package com.larus.voicecall.impl.component.scene;

import android.app.Application;
import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import c4a.f;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.av_call.component.RealtimeComponent;
import com.larus.av_call.constant.ThemeType;
import com.larus.av_call.view.SceneModeButton;
import com.larus.av_call.view.VoiceCallTopLayout;
import com.larus.im.bean.bot.SceneModel;
import com.larus.im.bean.bot.SceneModelList;
import com.larus.platform.model.audio.RealtimeCallSceneModeConfig;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.z0;
import com.larus.voicecall.impl.RealtimeCallService;
import com.larus.voicecall.impl.plugins.n;
import com.larus.voicecall.impl.scene.RealtimeCallSceneBoard;
import com.larus.voicecall.impl.scene.k;
import com.larus.voicecall.impl.scene.m;
import com.larus.voicecall.impl.scene.o;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import i88.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import l3a.g;
import l3a.j;
import l3a.p;
import l3a.q;
import l3a.r;
import l3a.s;
import l3a.t;
import l3a.u;
import l3a.v;
import l3a.w;
import l3a.x;
import l3a.y;
import org.json.JSONObject;
import tx9.k3;
import w3a.h;
import w3a.i;
import w3a.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000Û\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b*\u0001E\u0018\u0000 u2\u00020\u00012\u00020\u0002:\u0001uB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010J\u001a\u00020KH\u0016J\b\u0010L\u001a\u00020KH\u0016J\b\u0010M\u001a\u00020KH\u0016J\u0010\u0010N\u001a\u00020K2\u0006\u0010O\u001a\u00020PH\u0016J\b\u0010Q\u001a\u00020KH\u0002J\u0010\u0010R\u001a\u00020K2\u0006\u0010S\u001a\u00020TH\u0016J\b\u0010U\u001a\u00020VH\u0002J\u0018\u0010W\u001a\u00020K2\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020[H\u0016J\b\u0010\\\u001a\u00020]H\u0016J\b\u0010^\u001a\u00020]H\u0016J\b\u0010_\u001a\u00020KH\u0016J\u0010\u0010`\u001a\u00020K2\u0006\u0010a\u001a\u00020bH\u0016J\b\u0010c\u001a\u00020KH\u0002J,\u0010d\u001a\u00020K2\f\u0010e\u001a\b\u0012\u0004\u0012\u00020K0f2\f\u0010g\u001a\b\u0012\u0004\u0012\u00020K0f2\u0006\u0010h\u001a\u00020]H\u0016J\n\u0010i\u001a\u0004\u0018\u00010jH\u0002J\u0012\u0010k\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010Y\u0018\u00010lH\u0016J\u000e\u0010m\u001a\b\u0012\u0004\u0012\u00020Y0nH\u0016J\b\u0010o\u001a\u00020]H\u0016J\b\u0010p\u001a\u00020KH\u0016J\b\u0010q\u001a\u00020KH\u0016J\u0012\u0010r\u001a\u00020K2\b\u0010s\u001a\u0004\u0018\u00010IH\u0016J\u0012\u0010t\u001a\u00020K2\b\u0010s\u001a\u0004\u0018\u00010IH\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u001f\u001a\u0004\u0018\u00010 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\n\u001a\u0004\b!\u0010\"R\u001d\u0010$\u001a\u0004\u0018\u00010%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\n\u001a\u0004\b&\u0010'R\u001d\u0010)\u001a\u0004\u0018\u00010*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\n\u001a\u0004\b+\u0010,R\u001d\u0010.\u001a\u0004\u0018\u00010/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\n\u001a\u0004\b0\u00101R\u001d\u00103\u001a\u0004\u0018\u0001048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u0010\n\u001a\u0004\b5\u00106R\u001d\u00108\u001a\u0004\u0018\u0001098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\n\u001a\u0004\b:\u0010;R\u001d\u0010=\u001a\u0004\u0018\u0001048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\n\u001a\u0004\b>\u00106R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020CX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u00020EX\u0082\u0004¢\u0006\u0004\n\u0002\u0010FR\u0014\u0010G\u001a\b\u0012\u0004\u0012\u00020I0HX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006v"}, d2 = {"Lcom/larus/voicecall/impl/component/scene/RealtimeSceneComponent;", "Lcom/larus/av_call/component/RealtimeComponent;", "Lcom/larus/voicecall/impl/component/scene/IRealtimeSceneAbility;", "<init>", "()V", "activity", "Landroidx/fragment/app/FragmentActivity;", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "activity$delegate", "Lkotlin/Lazy;", "argumentData", "Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "getArgumentData", "()Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "argumentData$delegate", "runtimeData", "Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "getRuntimeData", "()Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "runtimeData$delegate", "callService", "Lcom/larus/voicecall/impl/RealtimeCallService;", "getCallService", "()Lcom/larus/voicecall/impl/RealtimeCallService;", "callService$delegate", "viewStateManager", "Lcom/larus/voicecall/impl/realtime/RealtimeCallViewStateManager;", "getViewStateManager", "()Lcom/larus/voicecall/impl/realtime/RealtimeCallViewStateManager;", "viewStateManager$delegate", "topAbility", "Lcom/larus/voicecall/impl/component/top/IRealtimeTopAbility;", "getTopAbility", "()Lcom/larus/voicecall/impl/component/top/IRealtimeTopAbility;", "topAbility$delegate", "contentAbility", "Lcom/larus/voicecall/impl/component/content/IRealtimeContentAbility;", "getContentAbility", "()Lcom/larus/voicecall/impl/component/content/IRealtimeContentAbility;", "contentAbility$delegate", "bottomAbility", "Lcom/larus/voicecall/impl/component/bottom/IRealtimeBottomAbility;", "getBottomAbility", "()Lcom/larus/voicecall/impl/component/bottom/IRealtimeBottomAbility;", "bottomAbility$delegate", "traceAbility", "Lcom/larus/voicecall/impl/component/trace/IRealtimeTraceAbility;", "getTraceAbility", "()Lcom/larus/voicecall/impl/component/trace/IRealtimeTraceAbility;", "traceAbility$delegate", "sceneButtonCenter", "Lcom/larus/av_call/view/SceneModeButton;", "getSceneButtonCenter", "()Lcom/larus/av_call/view/SceneModeButton;", "sceneButtonCenter$delegate", "realtimeCallActionContainer", "Landroid/widget/LinearLayout;", "getRealtimeCallActionContainer", "()Landroid/widget/LinearLayout;", "realtimeCallActionContainer$delegate", "sceneButtonTop", "getSceneButtonTop", "sceneButtonTop$delegate", "sceneManager", "Lcom/larus/voicecall/impl/scene/IRealtimeCallSceneManager;", "closeSceneBoardTask", "Ljava/lang/Runnable;", "screenShareEventObserver", "com/larus/voicecall/impl/component/scene/RealtimeSceneComponent$screenShareEventObserver$1", "Lcom/larus/voicecall/impl/component/scene/RealtimeSceneComponent$screenShareEventObserver$1;", "sceneChangeListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/larus/voicecall/impl/component/scene/RealtimeSceneChangeListener;", "onAttach", NameKeys.UnloadStrategy_No_Strategy, "onVContextReady", "onCreate", "onViewCreated", "view", "Landroid/view/View;", "initTopSceneButton", "tryExitScene", "reason", NameKeys.UnloadStrategy_No_Strategy, "createRealtimeCallSceneManager", "Lcom/larus/voicecall/impl/scene/RealtimeCallSceneManager;", "switchScene", "item", "Lcom/larus/voicecall/impl/scene/SceneDisplayItem;", "traceId", NameKeys.UnloadStrategy_No_Strategy, "currentSceneNeedUplinkHangUp", NameKeys.UnloadStrategy_No_Strategy, "currentSceneSupportMoreBtn", "triggerUplinkHangUp", "onConnectionStateChanged", "state", "Lcom/larus/im/internal/audio/context/SessionState;", "tryShowRealtimeCallSceneBoardBySceneConfig", "showRealtimeCallSceneBoard", "onShow", "Lkotlin/Function0;", "onDismiss", "ignoreDisableState", "getSceneBoard", "Landroidx/fragment/app/DialogFragment;", "getCurrentScene", "Landroidx/lifecycle/LiveData;", "getSceneList", NameKeys.UnloadStrategy_No_Strategy, "isInSceneMode", "onFragmentViewDestroyed", "onDestroy", "registerSceneChangeListener", "listener", "unregisterSceneChangeListener", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeSceneComponent extends RealtimeComponent implements com.larus.voicecall.impl.component.scene.a {
    public static final /* synthetic */ int D = 0;
    public final s A;
    public final c B;
    public final CopyOnWriteArrayList<l3a.c> C;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public final Lazy x;
    public final Lazy y;
    public k z;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public b(Function1 r2) {
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

    public static final class c implements i {
        public final /* synthetic */ RealtimeSceneComponent a;

        public c(RealtimeSceneComponent r1) {
            this.a = r1;
        }

        @Override // w3a.i
        public final void a(h r4) {
            Intrinsics.checkNotNullParameter(r4, "event");
            if ((r4 instanceof l) == true) goto L5;
            return;
        L5:
            if (((l) r4).a == false) goto L31;
            FLogger.a.i("RealtimeSceneComponent", "dismiss scene board on enter screen share");
            RealtimeSceneComponent r5 = this.a;
            int r0 = RealtimeSceneComponent.D;
            r5.getClass();
            DialogFragment r6 = (DialogFragment) l0.a(null, new l3a.l(r5));
            if (r6 == null) goto L32;
            Dialog r7 = r6.getDialog();
            if (r7 == null) goto L33;
            Handler r1 = DialogLancet.resolveDialogHandler(r7);
            if (r1 != null) goto L13;
        L15:
            DialogLancet.beforeDialogDismiss(r7);
            r7.dismiss();     // Catch: Throwable -> L18 Exception -> L20
        L24:
            DialogLancet.afterDialogDismiss(r7);
            return;
        L18:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r7);
            throw th;
        L20:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L18
            Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L18
            if (r2 == null) goto L24;
            com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L18
            goto L24
        L13:
            if (Looper.myLooper() == r1.getLooper()) goto L15;
            r1.post(DialogLancet.createDismissRunnable(r7));
            return;
        L33:
            return;
        L32:
            return;
        }
    }

    public static final class d implements RealtimeCallSceneBoard.b {
        public final /* synthetic */ View a;
        public final /* synthetic */ RealtimeCallSceneBoard b;
        public final /* synthetic */ RealtimeSceneComponent c;
        public final /* synthetic */ Function0<Unit> d;
        public final /* synthetic */ Function0<Unit> e;

        @Override // com.larus.voicecall.impl.scene.RealtimeCallSceneBoard.b
        public final void a() {
            RealtimeCallUtil.a.getClass();
            if (RealtimeCallUtil.z == false) goto L14;
            View r0 = this.a;
            if (r0 == null) goto L11;
            Application r1 = f.a;
            ThemeType r2 = this.b.k;
            Intrinsics.checkNotNullParameter(r0, "<this>");
            Intrinsics.checkNotNullParameter(r2, "themeType");
            if (e.o(r2) == false) goto L9;
            int r3 = f.a(2131103293);
        L10:
            r0.setBackgroundColor(r3);
            goto L11
        L9:
            r3 = ColorProtector.parseColor("#1A000000");
        L11:
            View r4 = this.a;
            if (r4 == null) goto L17;
            com.larus.voicecall.impl.utils.c.c(r4, true, 200);
        L17:
            this.d.invoke();
            return;
        L14:
            LinearLayout r5 = (LinearLayout) this.c.x.getValue();
            if (r5 == null) goto L17;
            r5.setAlpha(0.3f);
            goto L17
        }

        @Override // com.larus.voicecall.impl.scene.RealtimeCallSceneBoard.b
        public final void onDialogDismiss() {
            RealtimeCallUtil.a.getClass();
            if (RealtimeCallUtil.z == false) goto L7;
            View r0 = this.a;
            if (r0 == null) goto L10;
            com.larus.voicecall.impl.utils.c.c(r0, false, 200);
        L10:
            this.e.invoke();
            return;
        L7:
            LinearLayout r1 = (LinearLayout) this.c.x.getValue();
            if (r1 == null) goto L10;
            r1.setAlpha(1.0f);
            goto L10
        }

        public d(View r1, RealtimeCallSceneBoard r2, RealtimeSceneComponent r3, Function0<Unit> r4, Function0<Unit> r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    static {
    }

    private final FragmentActivity getActivity() {
        return (FragmentActivity) this.n.getValue();
    }

    public final e3a.b B3() {
        return (e3a.b) this.p.getValue();
    }

    @Override // com.larus.voicecall.impl.component.scene.a
    public final void bQ() {
        RealtimeCallService r0 = (RealtimeCallService) this.q.getValue();
        RealtimeCallParam r1 = B3().a();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, LynxResourceModule.PARAMS_KEY);
        r0.q().R(r1);
    }

    @Override // com.larus.voicecall.impl.component.scene.a
    public final LiveData<m> getCurrentScene() {
        k r0 = this.z;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.f;
    }

    @Override // com.larus.voicecall.impl.component.scene.a
    public final List<m> getSceneList() {
        k r0 = this.z;
        if (r0 == null) goto L7;
        ArrayList<m> r1 = r0.e;
        if (r1 == null) goto L7;
        return r1;
    L7:
        return CollectionsKt.emptyList();
    }

    public final void onCreate() {
        if (((h88.b) B3()).h == false) goto L44;
        n r3 = ((RealtimeCallService) this.q.getValue()).q();
        SceneModelList r2 = z3().L0;
        if (r2 == null) goto L8;
        List r4 = r2.getList();
        if (r4 == null) goto L8;
    L9:
        Intrinsics.checkNotNullParameter(this, "<this>");
        k r1 = new k(r3, r4, LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(this, this)), z3(), B3());
        int r5 = ((h88.a) z3()).K;
        FLogger.a.i(r1.i, "[initScene] sceneId=" + r5 + ", fromDirectJump=true");
        RealtimeCallUtil r6 = RealtimeCallUtil.a;
        Iterator<o> r7 = r1.g.iterator();
    L10:
        m r9 = null;
        if (r7.hasNext() == false) goto L18;
        o r8 = r7.next();
        if (r8.a.getId() != r5) goto L15;
        boolean r10 = true;
    L16:
        if (r10 == false) goto L10;
    L19:
        r6.getClass();
        RealtimeCallUtil.l = r8;
        r1.n = true;
        Iterator<m> r11 = r1.e.iterator();
    L21:
        if (r11.hasNext() == false) goto L32;
        m r12 = r11.next();
        m r13 = r12;
        RealtimeCallUtil.a.getClass();
        o r14 = RealtimeCallUtil.l;
        if (r14 == null) goto L29;
        SceneModel r15 = r14.a;
        if (r15 == null) goto L29;
        if (r13.a.getId() != r15.getId()) goto L29;
        boolean r16 = true;
    L30:
        if (r16 == false) goto L21;
        r9 = r12;
    L29:
        r16 = false;
    L32:
        m r17 = r9;
        if (r17 == null) goto L43;
        String r18 = r17.a.getKey();
        RealtimeCallUtil.a.getClass();
        Long r19 = Long.valueOf(z0.c(RealtimeCallUtil.z));
        e3a.a r20 = r1.c;
        String r110 = ((h88.a) r20).f;
        String r111 = ((h88.a) r20).k;
        JSONObject r21 = new JSONObject();
        if (r1.d.a().p.q == false) goto L38;
    L41:
        String r22 = "1";
    L42:
        r21.put("is_continuous_speak", r22);
        Unit r23 = Unit.INSTANCE;
        k3.a(null, NameKeys.UnloadStrategy_No_Strategy, r18, r19, r110, r111, r21, 273);
        r1.f.postValue(r17);
        r1.j = false;
        goto L43
    L38:
        if (r1.d.a().a == true) goto L41;
        r22 = "0";
    L43:
        RealtimeCallService r24 = (RealtimeCallService) this.q.getValue();
        r24.getClass();
        Intrinsics.checkNotNullParameter(r1, "listener");
        r24.q().C0(r1);
        MutableLiveData<m> r25 = r1.f;
        Intrinsics.checkNotNullParameter(this, "<this>");
        r25.observe(com.larus.ui.arch.component.internal.attach.a.b(this, this), new b(new l3a.k(this)));
        this.z = r1;
        goto L44
    L15:
        r10 = false;
        goto L16
    L18:
        r8 = null;
    L8:
        r4 = CollectionsKt.emptyList();
    L44:
        w3a.k r26 = (w3a.k) this.r.getValue();
        if (r26 == null) goto L58;
        r26.c(this.B);
        return;
    }

    public final void onDestroy() {
        k r0 = this.z;
        if ((r0 instanceof com.larus.voicecall.impl.scene.a) == true) goto L7;
        r0 = null;
    L7:
        if (r0 == null) goto L9;
        RealtimeCallService r3 = (RealtimeCallService) this.q.getValue();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r0, "listener");
        r3.q().q0(r0);
    L9:
        k r1 = this.z;
        if (r1 == null) goto L12;
        r1.e.clear();
        r1.g.clear();
        r1.h.removeCallbacksAndMessages(null);
        RealtimeCallUtil.a.getClass();
        RealtimeCallUtil.l = null;
    L12:
        w3a.k r2 = (w3a.k) this.r.getValue();
        if (r2 == null) goto L16;
        c r4 = this.B;
        Intrinsics.checkNotNullParameter(r4, "listener");
        r2.e.remove(r4);
        return;
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, com.larus.voicecall.impl.component.scene.a.class);
    }

    public final e3a.a z3() {
        return (e3a.a) this.o.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v24, types: [l3a.s] */
    public RealtimeSceneComponent() {
        this.n = LazyKt.lazy(new l3a.d(this));
        this.o = LazyKt.lazy(new t(this));
        this.p = LazyKt.lazy(new u(this));
        this.q = LazyKt.lazy(new v(this));
        this.r = LazyKt.lazy(new w(this));
        this.s = LazyKt.lazy(new x(this));
        this.t = LazyKt.lazy(new y(this));
        this.u = LazyKt.lazy(new l3a.e(this));
        this.v = LazyKt.lazy(new l3a.f(this));
        this.w = LazyKt.lazy(new g(this));
        this.x = LazyKt.lazy(new l3a.o(this));
        this.y = LazyKt.lazy(new r(this));
        this.A = new s(this);
        this.B = new c(this);
        this.C = new CopyOnWriteArrayList();
    }

    public final void A0() {
        getActivity();
        z3();
        B3();
        RealtimeCallService r0 = (RealtimeCallService) this.q.getValue();
        com.larus.voicecall.impl.component.bottom.b r1 = (com.larus.voicecall.impl.component.bottom.b) this.u.getValue();
        n3a.a r2 = (n3a.a) this.v.getValue();
    }

    public final void A2() {
        p3(getActivity().getWindow()).removeCallbacks(this.A);
    }

    @Override // com.larus.voicecall.impl.component.scene.a
    public final boolean oY() {
        LiveData<m> r0 = getCurrentScene();
        if (r0 == null) goto L5;
        m r1 = (m) r0.getValue();
    L6:
        if (r1 == null) goto L8;
        return true;
    L8:
        return false;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.larus.voicecall.impl.component.scene.a
    public final boolean wm() {
        LiveData<m> r0 = getCurrentScene();
        if (r0 == null) goto L9;
        m r1 = (m) r0.getValue();
        if (r1 == null) goto L9;
        SceneModel r2 = r1.a;
        if (r2 == null) goto L9;
        String r3 = r2.getKey();
    L10:
        String r4 = u3a.f.a;
        return Intrinsics.areEqual(r3, "interpret_v2");
    L9:
        r3 = null;
        goto L10
    }

    public static Unit h3(RealtimeSceneComponent r5) {
        Double r0 = z2.a.realtimeCallSceneConfig().getAutoCloseDurationSecond();
        if (r0 == null) goto L9;
        long r1 = ((long) r0.doubleValue()) * ((long) 1000);
        if (r1 <= 0) goto L10;
        p3(r5.getActivity().getWindow()).postDelayed(r5.A, r1);
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    L9:
        return Unit.INSTANCE;
    }

    public static Unit m3(RealtimeSceneComponent r1) {
        p3(r1.getActivity().getWindow()).removeCallbacks(r1.A);
        return Unit.INSTANCE;
    }

    public static View p3(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    @Override // com.larus.voicecall.impl.component.scene.a
    public final void Fk(l3a.c r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.C.remove(r2);
    }

    public final void I6(jd9.c r12) {
        Intrinsics.checkNotNullParameter(r12, "state");
        Intrinsics.checkNotNullParameter(r12, "state");
        if ((r12 instanceof jd9.c.d) == false) goto L6;
        FLogger.a.w("RealtimeSceneComponent", "[onConnectionStateChanged] DISCONNECT, isAutoUplinkHangUp reset to false");
        B3().a().W = false;
        return;
    L6:
        if ((r12 instanceof jd9.c.a) == false) goto L48;
        FragmentActivity r13 = getActivity();
        Pair<Boolean, Boolean> r0 = com.larus.voicecall.impl.l.i;
        if (com.larus.voicecall.impl.l.a.b(r13) == true) goto L11;
        FLogger.a.i("RealtimeSceneComponent", "intercept by permission");
        return;
    L11:
        if (com.larus.bmhome.utils.i.g(((h88.a) z3()).f) == true) goto L14;
        FLogger.a.i("RealtimeSceneComponent", "intercept by bot type");
        return;
    L14:
        if (o0.d(((h88.a) z3()).E) == false) goto L16;
        FLogger.a.i("RealtimeSceneComponent", "intercept by spring");
        return;
    L16:
        DialogFragment r14 = (DialogFragment) l0.a(null, new l3a.l(this));
        if (r14 == null) goto L23;
        Dialog r15 = r14.getDialog();
        if (r15 == null) goto L23;
        if (r15.isShowing() != true) goto L23;
        boolean r16 = true;
    L24:
        if (r16 == false) goto L27;
        FLogger.a.i("RealtimeSceneComponent", "intercept by board already show");
        return;
    L27:
        if (((h88.a) z3()).m == false) goto L30;
        FLogger.a.i("RealtimeSceneComponent", "intercept by openVLMOnStart");
        return;
    L30:
        if (((h88.a) z3()).T == false) goto L32;
        FLogger.a.i("RealtimeSceneComponent", "intercept by simpleMode");
        return;
    L32:
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.l == null) goto L36;
        FLogger.a.i("RealtimeSceneComponent", "intercept by currentScene not null");
        return;
    L36:
        if (((h88.a) z3()).k0 == false) goto L38;
        FLogger.a.i("RealtimeSceneComponent", "intercept by useNewInteractionStyle");
        return;
    L38:
        String r17 = AccountService.a.getSecUserId();
        boolean r3 = c78.a.a;
        Intrinsics.checkNotNullParameter(r17, "uid");
        Keva r4 = c78.a.g;
        int r2 = r4.getInt("key_is_auto_show_scene_board_count_".concat(r17), 0);
        Long r6 = z2.a.realtimeCallSceneConfig().getAutoOpenCountTimes();
        if (r6 == null) goto L41;
        long r7 = r6.longValue();
    L43:
        if (r2 < r7) goto L45;
        FLogger.a.i("RealtimeSceneComponent", "intercept by count times, maxCount: " + r7 + ", curCount: " + r2);
        return;
    L45:
        Intrinsics.checkNotNullParameter(r17, "uid");
        r4.storeInt("key_is_auto_show_scene_board_count_".concat(r17), r2 + 1);
        x50(new p(this), new q(this), true);
        return;
    L41:
        r7 = 0;
    L23:
        r16 = false;
        goto L24
    }

    @Override // com.larus.voicecall.impl.component.scene.a
    public final void Ii(String r4) {
        Intrinsics.checkNotNullParameter(r4, "reason");
        if (oY() == true) goto L6;
        FLogger.a.w("RealtimeSceneComponent", "tryExitScene, not in scene mode, reason: " + r4);
        return;
    L6:
        k r0 = this.z;
        if (r0 == null) goto L10;
        r0.h(false, r4);
        return;
    }

    public final void onViewCreated(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        if (((h88.b) B3()).h == true) goto L5;
        return;
    L5:
        SceneModeButton r5 = (SceneModeButton) this.w.getValue();
        if (r5 == null) goto L8;
        e1.d(r5, new l3a.h(this));
    L8:
        RealtimeCallUtil.a.getClass();
        if (((RealtimeCallSceneModeConfig) RealtimeCallUtil.o.getValue()).getEnableSceneModeGuide() == false) goto L15;
        Keva r6 = c78.a.g;
        if (r6.getBoolean("key_first_enter_realtime_call", true) == false) goto L15;
        if (((h88.a) z3()).k0 == true) goto L15;
        r6.storeBoolean("key_first_enter_realtime_call", false);
        com.larus.voicecall.impl.component.scene.a.b.a(this, true, 3);
    L15:
        SceneModeButton r7 = (SceneModeButton) this.w.getValue();
        if (r7 == null) goto L18;
        r7.setExitListener(new l3a.i(this));
    L18:
        e1.d((SceneModeButton) this.y.getValue(), new l3a.m(this));
        SceneModeButton r8 = (SceneModeButton) this.y.getValue();
        if (r8 == null) goto L21;
        r8.setExitListener(new l3a.n(this));
    L21:
        k r9 = this.z;
        if (r9 == null) goto L27;
        MutableLiveData<m> r10 = r9.f;
        if (r10 == null) goto L28;
        Intrinsics.checkNotNullParameter(this, "<this>");
        r10.observe(com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner(), new b(new j(this)));
        return;
    L28:
        return;
    }

    @Override // com.larus.voicecall.impl.component.scene.a
    public final void yM(l3a.c r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (this.C.contains(r2) == true) goto L8;
        this.C.add(r2);
        return;
    }

    @Override // com.larus.voicecall.impl.component.scene.a
    public final void R3(m r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "item");
        k r0 = this.z;
        if (r0 == null) goto L6;
        r0.R3(r2, r3);
        return;
    }

    @Override // com.larus.voicecall.impl.component.scene.a
    public final void x50(Function0<Unit> r9, Function0<Unit> r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r9, "onShow");
        Intrinsics.checkNotNullParameter(r10, "onDismiss");
        if (r11 == true) goto L15;
        m3a.a r12 = (m3a.a) this.s.getValue();
        if (r12 == null) goto L11;
        VoiceCallTopLayout r13 = r12.Fv();
        if (r13 == null) goto L11;
        if (r13.g != true) goto L11;
        boolean r14 = true;
    L12:
        if (r14 == true) goto L15;
        FLogger.a.d("RealtimeSceneComponent", "click scene button top, disabled");
        t19.s r15 = t19.s.a;
        FragmentActivity r16 = getActivity();
        r15.getClass();
        t19.s.s(r16, 2131900533);
        return;
    L11:
        r14 = false;
    L15:
        int r17 = ((h88.b) B3()).k;
        if (r17 == (-1)) goto L34;
        if (r17 == 0) goto L34;
        if (r17 == 1) goto L34;
        if (r17 == 6) goto L34;
        RealtimeCallSceneBoard r18 = new RealtimeCallSceneBoard();
        g3a.a r0 = (g3a.a) this.t.getValue();
        if (r0 == null) goto L24;
        View r1 = r0.nj();
    L25:
        r18.i = this.z;
        r18.j = new d(r1, r18, this, r9, r10);
        ThemeType r19 = ((h88.b) B3()).i;
        Intrinsics.checkNotNullParameter(r19, "<set-?>");
        r18.k = r19;
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentManager r20 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getChildFragmentManager();
        LandscapeRestrictionOperation r110 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r18, "scene_board", r110);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r20, r18, r110) == false) goto L37;
    L30:
        n3a.a r21 = (n3a.a) this.v.getValue();
        if (r21 == null) goto L39;
        r21.Al();
        return;
    L39:
        return;
    L37:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L36
    L29:
        r18.show(r20, "scene_board");
        goto L30
    L24:
        r1 = null;
    L34:
        FLogger.a.d("RealtimeSceneComponent", "current state: " + r17 + " not support scene");
    }
}
