package com.obric.assistant.component;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import com.bytedance.keva.Keva;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.banner.IObricBannerService;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.interaction.api.service.IInteractionStateService;
import com.obric.assistant.interaction.api.window.IWindowContextKt;
import com.obric.assistant.interaction.api.window.animation.IWindowAnimationListener;
import com.obric.assistant.interaction.api.window.animation.WindowAnimationType;
import com.obric.assistant.interaction.base.interact.IObserveToken;
import com.obric.assistant.interaction.base.model.AssistantActivityExpandState;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.update.api.v2.IObricUpdateService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u00025:\u0018\u0000 k2\u00020\u00012\u00020\u0002:\u0001kB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020=H\u0002J\b\u0010?\u001a\u00020=H\u0002J\b\u0010@\u001a\u00020=H\u0016J\b\u0010A\u001a\u00020=H\u0002J\b\u0010B\u001a\u00020=H\u0002J\b\u0010C\u001a\u00020=H\u0002J\b\u0010G\u001a\u00020=H\u0002J\u0010\u0010H\u001a\u00020=2\u0006\u0010I\u001a\u00020JH\u0002J\b\u0010K\u001a\u00020=H\u0002J\b\u0010L\u001a\u00020=H\u0002J\b\u0010M\u001a\u00020=H\u0002J$\u0010N\u001a\u00020=2\u0006\u0010O\u001a\u00020P2\u0012\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020S0RH\u0002J(\u0010T\u001a\u00020=2\u0006\u0010U\u001a\u00020/2\n\b\u0002\u0010V\u001a\u0004\u0018\u00010/2\n\b\u0002\u0010W\u001a\u0004\u0018\u00010XH\u0002J\b\u0010Y\u001a\u00020=H\u0016J\u0010\u0010Z\u001a\u00020=2\u0006\u0010[\u001a\u00020\\H\u0002J\u0018\u0010]\u001a\u00020=2\u0006\u0010[\u001a\u00020\\2\u0006\u0010^\u001a\u00020,H\u0002J&\u0010_\u001a\u00020=2\u000e\u0010`\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010a2\f\u0010b\u001a\b\u0012\u0004\u0012\u00020=0aH\u0002J\b\u0010c\u001a\u00020dH\u0002J\b\u0010e\u001a\u00020,H\u0002J\u0012\u0010f\u001a\u00020,2\b\u0010g\u001a\u0004\u0018\u00010hH\u0002J\b\u0010i\u001a\u00020,H\u0002J\f\u0010j\u001a\u00020/*\u00020JH\u0002R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010&\u001a\u0004\u0018\u00010'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\n\u001a\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020,8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b+\u0010-R\u000e\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0004\n\u0002\u00106R\u000e\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u00020:X\u0082\u0004¢\u0006\u0004\n\u0002\u0010;R\u000e\u0010D\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010FX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006l"}, d2 = {"Lcom/obric/assistant/component/ObricUpdateComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/obric/assistant/interaction/base/interact/IObserveToken;", "<init>", "()V", "chatFragmentAbility", "Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "getChatFragmentAbility", "()Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "chatFragmentAbility$delegate", "Lkotlin/Lazy;", "pageStateAbility", "Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "getPageStateAbility", "()Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "pageStateAbility$delegate", "collectAbility", "Lcom/larus/bmhome/chat/component/collection/IChatCollectMessageAbility;", "getCollectAbility", "()Lcom/larus/bmhome/chat/component/collection/IChatCollectMessageAbility;", "collectAbility$delegate", "caseAbility", "Lcom/larus/bmhome/chat/component/showcase/IChatCaseMessageAbility;", "getCaseAbility", "()Lcom/larus/bmhome/chat/component/showcase/IChatCaseMessageAbility;", "caseAbility$delegate", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "obricUpdateComponentRepo", "Lcom/bytedance/keva/Keva;", "globalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "checkBannerJob", "Lkotlinx/coroutines/Job;", "fullOrHalfScreenCheckJob", "binding", "Lcom/larus/bmhome/ability/IChatCoreBinding;", "getBinding", "()Lcom/larus/bmhome/ability/IChatCoreBinding;", "binding$delegate", "isScreenLocked", "", "()Z", "bannerHostId", "", "isWindowBannerAnimationRunning", "sideBarFragment", "Lcom/larus/bmhome/ISideBarFragment;", "isSideBarBlockingBanner", "sideBarLayoutListener", "com/obric/assistant/component/ObricUpdateComponent$sideBarLayoutListener$1", "Lcom/obric/assistant/component/ObricUpdateComponent$sideBarLayoutListener$1;", "obricUpdateListener", "Lcom/obric/update/api/v2/ObricUpdateListener;", "windowAnimationListener", "com/obric/assistant/component/ObricUpdateComponent$windowAnimationListener$1", "Lcom/obric/assistant/component/ObricUpdateComponent$windowAnimationListener$1;", "afterViewBind", "", "checkUpdate", "initListener", "onResume", "checkActivityExpandState", "onEnterExpandFullScreen", "onEnterExpandHalfWindow", "hasShowInstallTipDialog", "installDialog", "Lcom/obric/oui/dialog/v2/alert/OAlertDialog;", "showInstallTip", "addLayoutListener", "container", "Landroid/view/View;", "handleBannerLogic", "checkUpdateBannerNeedShow", "blockBannerForSideBar", "realShowUpdateBanner", "type", "", "data", "", "", "reportBannerPipeline", WindowEvent.Params.RESULT, WindowEvent.Params.REASON, "extra", "Lorg/json/JSONObject;", "onDestroy", "checkForceUpdateRom", "activity", "Landroidx/fragment/app/FragmentActivity;", "finishProcess", "jumpToOta", "showForceUpdateRomDialog", "onConfirmCallback", "Lkotlin/Function0;", "onCancelCallback", "getPageState", "Lcom/obric/assistant/data/ObricFloatChatPageState;", "isMainBot", "isCreateSubCvs", "currentArgument", "Landroid/os/Bundle;", "isMainBotPage", "toAnchorLog", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricUpdateComponent extends BaseContentWidget implements IObserveToken {
    public static final /* synthetic */ int F = 0;
    public final e A;
    public final c B;
    public final k C;
    public volatile boolean D;
    public com.obric.oui.dialog.v2.alert.c E;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Keva r;
    public o4 s;
    public Job t;
    public Job u;
    public final Lazy v;
    public final String w;
    public boolean x;
    public com.larus.bmhome.a0 y;
    public boolean z;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AssistantActivityExpandState.values().length];
            r0[AssistantActivityExpandState.FULL_SCREEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[AssistantActivityExpandState.HALF_WINDOW.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class c implements coa.a {
        public final /* synthetic */ ObricUpdateComponent a;

        public final void onProgress(int r1) {
        }

        public c(ObricUpdateComponent r1) {
            this.a = r1;
        }

        public final void onStateUpdate(int r11) {
            FLogger r0 = FLogger.a;
            r0.i("ObricUpdateComponent", "obricUpdateListener state=" + r11);
            if (r11 == (-1)) goto L18;
            IInteractionStateService r1 = IAssistantInteractionServiceKt.getInteractionStateService();
            if (r1 == null) goto L7;
            AssistantActivityExpandState r2 = r1.getInteractionActivityExpandState();
        L8:
            r0.i("ObricUpdateComponent", "obricUpdateListener expandState=" + r2);
            AssistantActivityExpandState r4 = AssistantActivityExpandState.FULL_SCREEN;
            if (r2 != r4) goto L11;
        L12:
            r0.i("ObricUpdateComponent", "obricUpdateListener -> handleBannerLogic");
            ObricUpdateComponent r3 = this.a;
            JSONObject r5 = new JSONObject();
            r5.put("expand_state", String.valueOf(r2));
            r5.put("update_state", r11);
            Unit r6 = Unit.INSTANCE;
            int r7 = ObricUpdateComponent.F;
            r3.getClass();
            ObricUpdateComponent.D3("start", "on_state_update", r5);
            this.a.z3();
        L13:
            if (r2 == r4) goto L15;
            return;
        L15:
            if (r11 != 4) goto L20;
            ObricUpdateComponent r12 = this.a;
            int r8 = ObricUpdateComponent.F;
            r12.getClass();
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r12), null, null, new ObricUpdateComponent$showInstallTip$1(r12, null), 3, null);
            return;
        L20:
            return;
        L11:
            if (r2 != AssistantActivityExpandState.HALF_WINDOW) goto L13;
        L7:
            r2 = null;
            goto L8
        }
    }

    public static final class d implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public d(t4 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    public static final class e implements com.larus.bmhome.c0 {
        public final /* synthetic */ ObricUpdateComponent a;

        public e(ObricUpdateComponent r1) {
            this.a = r1;
        }

        public final void G(boolean r4) {
            FLogger.a.i("ObricUpdateComponent", "onSideBarOpen, hostId=" + this.a.w + ", isClick=" + r4);
            ObricUpdateComponent.Y2(this.a);
        }

        public final void H0(int r4) {
            FLogger.a.i("ObricUpdateComponent", "onSideBarStateChanged, hostId=" + this.a.w + ", newState=" + r4);
            if (r4 == 0) goto L5;
            ObricUpdateComponent.Y2(this.a);
            return;
        L5:
            ObricUpdateComponent r5 = this.a;
            if (r5.z == false) goto L17;
            com.larus.bmhome.a0 r6 = r5.y;
            if (r6 == null) goto L12;
            boolean r1 = true;
            if (r6.Ga() != true) goto L12;
        L13:
            if (r1 == true) goto L18;
            ObricUpdateComponent r7 = this.a;
            r7.z = false;
            r7.z3();
            return;
        L18:
            return;
        L12:
            r1 = false;
            goto L13
        }

        public final void n0(boolean r4) {
            FLogger.a.i("ObricUpdateComponent", "onSideBarClose, hostId=" + this.a.w + ", isClick=" + r4);
            ObricUpdateComponent r5 = this.a;
            r5.z = false;
            r5.z3();
        }
    }

    public static final class f implements Function0<va8.m> {
        public final /* synthetic */ AttachReceiver a;

        public f(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.m.class));
        }
    }

    public static final class g implements Function0<laa.d> {
        public final /* synthetic */ AttachReceiver a;

        public g(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(laa.d.class));
        }
    }

    public static final class h implements Function0<com.larus.bmhome.chat.component.collection.o> {
        public final /* synthetic */ AttachReceiver a;

        public h(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.collection.o.class));
        }
    }

    public static final class i implements Function0<com.larus.bmhome.chat.component.showcase.x> {
        public final /* synthetic */ AttachReceiver a;

        public i(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.showcase.x.class));
        }
    }

    public static final class j implements Function0<de8.c> {
        public final /* synthetic */ AttachReceiver a;

        public j(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).g(Reflection.getOrCreateKotlinClass(de8.c.class));
        }
    }

    public static final class k implements IWindowAnimationListener {
        public final /* synthetic */ ObricUpdateComponent a;

        public k(ObricUpdateComponent r1) {
            this.a = r1;
        }

        @Override // com.obric.assistant.interaction.api.window.animation.IWindowAnimationListener
        public final void onWindowAnimationStart(boolean r4, WindowAnimationType r5) {
            Intrinsics.checkNotNullParameter(r5, "type");
            if (IWindowContextKt.isWindowContext(this.a.getContext()) == true) goto L5;
            return;
        L5:
            FLogger.a.i("ObricUpdateComponent", "onWindowAnimationStart, hostId=" + this.a.w + ", isShow=" + r4 + ", type=" + r5);
            this.a.x = true;
            IObricBannerService r6 = (IObricBannerService) ServiceManager.get().getService(IObricBannerService.class);
            if (r6 == null) goto L9;
            r6.d(this.a.w);
            return;
        }

        @Override // com.obric.assistant.interaction.api.window.animation.IWindowAnimationListener
        public final void onWindowAnimationEnd(boolean r5, WindowAnimationType r6, boolean r7) {
            Intrinsics.checkNotNullParameter(r6, "type");
            boolean r0 = IWindowContextKt.isWindowContext(this.a.getContext());
            if (r0 == false) goto L5;
        L7:
            FLogger.a.i("ObricUpdateComponent", "onWindowAnimationEnd, hostId=" + this.a.w + ", isShow=" + r5 + ", type=" + r6 + ", isSuccess=" + r7);
            ObricUpdateComponent r8 = this.a;
            r8.x = false;
            if (r0 == false) goto L13;
            if (r5 == false) goto L14;
            if (r7 == false) goto L15;
            r8.z3();
            return;
        L15:
            return;
        L14:
            return;
        L13:
            return;
        L5:
            if (this.a.x == true) goto L7;
        }
    }

    static {
    }

    public final void onResume() {
        Job r1 = this.u;     // Catch: Exception -> L14
        if (r1 != null) goto L6;
    L8:
        boolean r2 = false;
    L9:
        if (r2 == false) goto L16;
        Job r3 = this.u;     // Catch: Exception -> L14
        if (r3 == null) goto L16;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);     // Catch: Exception -> L14
    L16:
        this.u = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ObricUpdateComponent$checkActivityExpandState$1(this, null), 3, null);
        return;
    L6:
        if (r1.isActive() != true) goto L8;
        r2 = true;
    L14:
        e = move-exception;
        FLogger.a.e("ObricUpdateComponent", "Error checkActivityExpandState: " + e);
        goto L16
    }

    public final void z3() {
        Job r1 = this.t;     // Catch: Exception -> L13
        boolean r2 = false;
        if (r1 != null) goto L6;
    L8:
        if (r2 == false) goto L15;
        Job r3 = this.t;     // Catch: Exception -> L13
        if (r3 == null) goto L15;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);     // Catch: Exception -> L13
    L15:
        this.t = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ObricUpdateComponent$handleBannerLogic$1(this, null), 3, null);
        return;
    L6:
        if (r1.isActive() != true) goto L8;
        r2 = true;
    L13:
        e = move-exception;
        FLogger.a.e("ObricUpdateComponent", "Error checkActivityExpandState: " + e);
        goto L15
    }

    public final void B3() {
        FLogger.a.i("ObricUpdateComponent", "onEnterExpandFullScreen, hostId=" + this.w);
        D3("start", "enter_full_screen", null);
        z3();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ObricUpdateComponent$showInstallTip$1(this, null), 3, null);
    }

    public final void C3() {
        FLogger.a.i("ObricUpdateComponent", "onEnterExpandHalfWindow, hostId=" + this.w);
        D3("start", "enter_half_window", null);
        z3();
    }

    public final void P2() {
        FLogger.a.i("ObricUpdateComponent", "afterViewBind, hostId=" + this.w);
        IObricUpdateService r0 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r0 == null) goto L5;
        r0.f(this.B);
    L5:
        Intrinsics.checkNotNullParameter(this, "<this>");
        com.larus.bmhome.a0 r1 = com.larus.bmhome.b0.a(com.larus.ui.arch.component.internal.attach.a.b(this, this));
        if (r1 == null) goto L9;
        this.y = r1;
        this.z = r1.Ga();
        r1.If(this.A);
    L9:
        if (IWindowContextKt.isWindowContext(getContext()) == false) goto L13;
        IAssistantChatWindow r2 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r2 == null) goto L13;
        r2.addWindowAnimationListener(this.C);
    L13:
        va8.l r3 = (va8.l) this.v.getValue();
        if (r3 == null) goto L21;
        FrameLayout r4 = r3.getTitleContainer();
        if (r4 == null) goto L21;
        if (this.s != null) goto L21;
        ViewTreeObserver r5 = r4.getViewTreeObserver();
        o4 r6 = new o4(this, r4);
        this.s = r6;
        r5.addOnGlobalLayoutListener(r6);
    L21:
        IAssistantInteractionServiceKt.getInteractionStateService().observeInteractionActivityExpandState(this, new k4(this));
        IObricUpdateService r7 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r7 == null) goto L24;
        r7.d(true, "obric_update_component");
    L24:
        FragmentActivity r8 = getContext();
        if ((r8 instanceof FragmentActivity) == false) goto L27;
        FragmentActivity r9 = r8;
    L28:
        if (r9 != null) goto L30;
        return;
    L30:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ObricUpdateComponent$checkForceUpdateRom$1(this, r9, null), 3, null);
        return;
    L27:
        r9 = null;
        goto L28
    }

    public final ObricFloatChatPageState getPageState() {
        laa.d r0 = (laa.d) this.n.getValue();
        if (r0 == null) goto L6;
        ObricFloatChatPageState r1 = r0.getPageState();
        if (r1 == null) goto L6;
        return r1;
    L6:
        ObricFloatChatPageData.Companion.getClass();
        return ObricFloatChatPageData.access$getUNKNOWN$cp();
    }

    public final void onDestroy() {
        FLogger.a.i("ObricUpdateComponent", "onDestroy, hostId=" + this.w);
        IObricUpdateService r0 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r0 == null) goto L5;
        r0.i(this.B);
    L5:
        com.larus.bmhome.a0 r1 = this.y;
        if (r1 == null) goto L8;
        r1.OB(this.A);
    L8:
        this.y = null;
        this.z = false;
        IAssistantChatWindow r2 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r2 == null) goto L11;
        r2.removeWindowAnimationListener(this.C);
    L11:
        IAssistantInteractionServiceKt.getInteractionStateService().unObserveInteractionActivityExpandState(this);
        IObricBannerService r3 = (IObricBannerService) ServiceManager.get().getService(IObricBannerService.class);
        if (r3 == null) goto L49;
        r3.d(this.w);
    L49:
        Job r4 = this.u;     // Catch: Exception -> L21
        if (r4 == null) goto L17;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);     // Catch: Exception -> L21
    L17:
        Job r5 = this.t;     // Catch: Exception -> L21
        if (r5 == null) goto L23;
        Job.DefaultImpls.cancel$default(r5, null, 1, null);     // Catch: Exception -> L21
    L23:
        this.u = null;
        this.t = null;
        this.s = null;
        if (Build.VERSION.SDK_INT < 30) goto L44;
        com.obric.oui.dialog.v2.alert.c r6 = this.E;
        if (r6 == null) goto L44;
        Handler r7 = DialogLancet.resolveDialogHandler(r6);
        if (r7 != null) goto L30;
    L32:
        DialogLancet.beforeDialogDismiss(r6);
        r6.dismiss();     // Catch: Throwable -> L35 Exception -> L37
    L41:
        DialogLancet.afterDialogDismiss(r6);
        goto L44
    L35:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r6);
        throw th;
    L37:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L35
        Throwable r8 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L35
        if (r8 == null) goto L41;
        com.bytedance.crash.d.d(r8, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L35
        goto L41
    L30:
        if (Looper.myLooper() == r7.getLooper()) goto L32;
        r7.post(DialogLancet.createDismissRunnable(r6));
    L44:
        this.E = null;
        return;
    L21:
        e = move-exception;
        FLogger.a.e("ObricUpdateComponent", "Error cancel job in onDestroy: " + e);
        goto L23
    }

    public ObricUpdateComponent() {
        this.m = LazyKt.lazy(new f(this));
        this.n = LazyKt.lazy(new g(this));
        this.o = LazyKt.lazy(new h(this));
        this.p = LazyKt.lazy(new i(this));
        this.q = LazyKt.lazy(new j(this));
        this.r = Keva.getRepo("repo_obric_update_component", 0);
        this.v = LazyKt.lazy(new j4(this));
        this.w = "ObricUpdateComponent_" + System.identityHashCode(this);
        this.A = new e(this);
        this.B = new c(this);
        this.C = new k(this);
    }

    public static String E3(View r3) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r3.getClass().getSimpleName());
        r0.append('@');
        r0.append(Integer.toHexString(System.identityHashCode(r3)));
        r0.append("[shown=");
        r0.append(r3.isShown());
        r0.append(",attached=");
        r0.append(r3.isAttachedToWindow());
        r0.append(",bounds=");
        r0.append(r3.getLeft());
        r0.append(',');
        r0.append(r3.getTop());
        r0.append('-');
        r0.append(r3.getRight());
        r0.append(',');
        r0.append(r3.getBottom());
        r0.append(",root=");
        View r1 = r3.getRootView();
        Integer r2 = null;
        if (r1 == null) goto L5;
        Integer r4 = Integer.valueOf(r1.getWidth());
    L6:
        r0.append(r4);
        r0.append('x');
        View r5 = r3.getRootView();
        if (r5 == null) goto L9;
        r2 = Integer.valueOf(r5.getHeight());
    L9:
        r0.append(r2);
        r0.append(']');
        return r0.toString();
    L5:
        r4 = null;
        goto L6
    }

    public static final void Y2(ObricUpdateComponent r3) {
        r3.z = true;
        Job r1 = r3.t;
        if (r1 == null) goto L5;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L5:
        IObricBannerService r0 = (IObricBannerService) ServiceManager.get().getService(IObricBannerService.class);
        if (r0 == null) goto L9;
        r0.d(r3.w);
        return;
    }

    public static final void h3(ObricUpdateComponent r9) {
        r9.getClass();
        FLogger.a.i("ObricUpdateComponent", "checkUpdateBannerNeedShow, hostId=" + r9.w);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r9), Dispatchers.getMain(), null, new ObricUpdateComponent$checkUpdateBannerNeedShow$1(r9, null), 2, null);
    }

    public static void D3(String r2, String r3, JSONObject r4) {
        IObricUpdateService r0 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r0 == null) goto L6;
        r0.a(r2, r3, r4);
        return;
    }

    public static final void m3(ObricUpdateComponent r6, FragmentActivity r7, boolean r8) {
        r6.getClass();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r6), null, null, new ObricUpdateComponent$finishProcess$1(r8, r7, null), 3, null);
    }

    public static final void p3(ObricUpdateComponent r8, p4 r9, q4 r10) {
        r8.getClass();
        CommonDialog.a r0 = new CommonDialog.a();
        AppHost.Companion r1 = AppHost.a;
        r0.i(r1.getApplication().getString(2131912114));
        r0.g(r1.getApplication().getString(2131912113));
        r0.k = 8388611;
        com.larus.common_ui.dialog.f0 r2 = new com.larus.common_ui.dialog.f0(null, Integer.valueOf(r1.getApplication().getResources().getColor(2131105539)), null, 5);
        Intrinsics.checkNotNullParameter(r2, "commonDialogTextStyleConfig");
        r0.D = r2;
        com.larus.common_ui.dialog.f0 r3 = new com.larus.common_ui.dialog.f0(null, Integer.valueOf(r1.getApplication().getResources().getColor(2131101300)), null, 5);
        Intrinsics.checkNotNullParameter(r3, "commonDialogTextStyleConfig");
        r0.E = r3;
        CommonDialog.a.f(r0, new u4(r9), r1.getApplication().getString(2131912112), false, 12);
        CommonDialog.a.e(r0, new v4(r10), r1.getApplication().getString(2131912111), 4);
        Function0 r11 = new n4();
        Intrinsics.checkNotNullParameter(r11, "callback");
        r0.B = r11;
        r0.z = false;
        CommonDialog r12 = r0.a();
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L16
        FragmentActivity r14 = r8.getContext();     // Catch: Throwable -> L16
        if ((r14 instanceof FragmentActivity) == false) goto L6;
        FragmentActivity r15 = r14;     // Catch: Throwable -> L16
    L7:
        if (r15 == null) goto L27;
        FragmentManager r16 = r15.getSupportFragmentManager();     // Catch: Throwable -> L16
        LandscapeRestrictionOperation r17 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Throwable -> L16
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r12, null, r17);     // Catch: Throwable -> L16
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r16, r12, r17) == false) goto L25;
    L14:
        Object r18 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        Throwable r19 = Result.exceptionOrNull-impl(r18);
        if (r19 == null) goto L28;
        FLogger.a.e("ObricUpdateComponent", "showForceUpdateRomDialog, error: " + r19.getMessage(), r19);
        return;
    L28:
        return;
    L25:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L22 Throwable -> L16
    L13:
        r12.show(r16, null);     // Catch: Throwable -> L16
        goto L14
    L27:
        return;
    L6:
        r15 = null;
    L16:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    }
}
