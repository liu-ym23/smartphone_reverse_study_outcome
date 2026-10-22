package com.obric.assistant.component;

import android.os.Build;
import android.os.Bundle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.api.IAuthModelService;
import com.larus.common.apphost.AppHost;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.banner.IObricBannerService;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0001=B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020$H\u0016J\b\u0010&\u001a\u00020$H\u0016J\b\u0010'\u001a\u00020$H\u0016J\u0010\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020$H\u0002J\b\u0010/\u001a\u00020$H\u0002J\u0012\u00100\u001a\u00020*2\b\u0010,\u001a\u0004\u0018\u00010-H\u0002J\u0012\u00101\u001a\u00020*2\b\u0010,\u001a\u0004\u0018\u00010-H\u0002J\b\u00102\u001a\u00020*H\u0002J\u000e\u00103\u001a\u00020**\u0004\u0018\u00010-H\u0002J\b\u00104\u001a\u00020*H\u0002J\u0010\u00105\u001a\u00020$2\u0006\u00106\u001a\u000207H\u0002J\b\u00108\u001a\u00020$H\u0002J\b\u00109\u001a\u00020$H\u0002J\u0010\u0010:\u001a\u00020$2\u0006\u0010;\u001a\u00020<H\u0002R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/obric/assistant/component/ObricSetDefaultAssistantBannerComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/obric/assistant/callback/IChatStyleChangedCallback;", "<init>", "()V", "chatFragmentAbility", "Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "getChatFragmentAbility", "()Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "chatFragmentAbility$delegate", "Lkotlin/Lazy;", "pageStateAbility", "Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "getPageStateAbility", "()Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "pageStateAbility$delegate", "collectAbility", "Lcom/larus/bmhome/chat/component/collection/IChatCollectMessageAbility;", "getCollectAbility", "()Lcom/larus/bmhome/chat/component/collection/IChatCollectMessageAbility;", "collectAbility$delegate", "caseAbility", "Lcom/larus/bmhome/chat/component/showcase/IChatCaseMessageAbility;", "getCaseAbility", "()Lcom/larus/bmhome/chat/component/showcase/IChatCaseMessageAbility;", "caseAbility$delegate", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "keva", "Lcom/bytedance/keva/Keva;", "showBannerJob", "Lkotlinx/coroutines/Job;", "onCreate", "", "onResume", "onStop", "onDestroy", "onChatStyleChanged", "isChatWindow", "", "onPageStateChanged", "pageState", "Lcom/obric/assistant/data/ObricFloatChatPageState;", "scheduleBannerIfNeeded", "showBannerIfNeeded", "canStartTiming", "canShowBanner", "baseConditionMatched", "isMainBotVisiblePage", "isMainBot", "showCloseConfirmDialog", "activity", "Landroidx/fragment/app/FragmentActivity;", "stopTiming", "trackObricBannerShow", "trackObricBannerClick", "actionType", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricSetDefaultAssistantBannerComponent extends BaseContentWidget implements hca.b {
    public static final CoroutineScope t = null;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Keva r;
    public Job s;

    public static final class a {
    }

    public static final class b implements Function0<va8.m> {
        public final /* synthetic */ AttachReceiver a;

        public b(AttachReceiver r1) {
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

    public static final class c implements Function0<laa.d> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
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

    public static final class d implements Function0<com.larus.bmhome.chat.component.collection.o> {
        public final /* synthetic */ AttachReceiver a;

        public d(AttachReceiver r1) {
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

    public static final class e implements Function0<com.larus.bmhome.chat.component.showcase.x> {
        public final /* synthetic */ AttachReceiver a;

        public e(AttachReceiver r1) {
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

    public static final class f implements Function0<de8.c> {
        public final /* synthetic */ AttachReceiver a;

        public f(AttachReceiver r1) {
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

    static {
        t = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    public final laa.d m3() {
        return (laa.d) this.n.getValue();
    }

    public final void onDestroy() {
        Job r0 = this.s;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.s = null;
        laa.d r1 = m3();
        if (r1 == null) goto L8;
        r1.AN(this);
    L8:
        IObricBannerService r2 = (IObricBannerService) ServiceManager.get().getService(IObricBannerService.class);
        if (r2 == null) goto L12;
        r2.c();
        return;
    }

    public final void onStop() {
        Job r0 = this.s;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.s = null;
    }

    public ObricSetDefaultAssistantBannerComponent() {
        this.m = LazyKt.lazy(new b(this));
        this.n = LazyKt.lazy(new c(this));
        this.o = LazyKt.lazy(new d(this));
        this.p = LazyKt.lazy(new e(this));
        this.q = LazyKt.lazy(new f(this));
        this.r = xg9.b.a();
    }

    public final void onCreate() {
        super/*com.larus.ui.arch.component.external.delegate.BaseComponentWidget*/.onCreate();
        com.obric.assistant.common.utils.m.a.getClass();
        if (com.obric.assistant.common.utils.m.a() == false) goto L8;
        laa.d r0 = m3();
        if (r0 == null) goto L9;
        r0.HU(this);
        return;
    L9:
        return;
    }

    public final void p3() {
        laa.d r0 = m3();
        if (r0 == null) goto L5;
        ObricFloatChatPageState r1 = r0.getPageState();
    L6:
        boolean r2 = true;
        if (h3(r1) == true) goto L15;
        Job r3 = this.s;
        if (r3 == null) goto L11;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);
    L11:
        this.s = null;
        IObricBannerService r4 = (IObricBannerService) ServiceManager.get().getService(IObricBannerService.class);
        if (r4 == null) goto L25;
        r4.c();
        return;
    L25:
        return;
    L15:
        Job r5 = this.s;
        if (r5 != null) goto L18;
    L20:
        r2 = false;
    L21:
        if (r2 == false) goto L23;
        return;
    L23:
        this.s = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ObricSetDefaultAssistantBannerComponent$scheduleBannerIfNeeded$1(this, null), 3, null);
        return;
    L18:
        if (r5.isActive() != true) goto L20;
    L5:
        r1 = null;
        goto L6
    }

    public final void onResume() {
        p3();
    }

    public final boolean Y2(ObricFloatChatPageState r4) {
        if (h3(r4) == true) goto L5;
        return false;
    L5:
        if (r4 == null) goto L9;
        ObricFloatChatPageData.Companion.getClass();
        if ((r4 instanceof vda.c) != true) goto L9;
        boolean r5 = true;
    L10:
        if (r5 == false) goto L12;
        return false;
    L12:
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == true) goto L17;
        return true;
    L17:
        return false;
    L9:
        r5 = false;
        goto L10
    }

    public final boolean h3(ObricFloatChatPageState r9) {
        if (Build.VERSION.SDK_INT < 30) goto L99;
        com.obric.assistant.common.utils.m.a.getClass();
        if (com.obric.assistant.common.utils.m.a() == false) goto L99;
        if (this.r.getBoolean("set_default_assistant_banner_closed", false) == true) goto L99;
        long r0 = this.r.getLong("set_default_assistant_banner_suppress_until_time", 0);
        AppHost.Companion r4 = AppHost.a;
        if (r0 > r4.getAppClock().currentTimeMillis()) goto L99;
        if (com.obric.assistant.utils.j.c(r4.getApplication()) == true) goto L99;
        laa.d r1 = m3();
        if (r1 != null) goto L20;
    L22:
        boolean r2 = false;
    L23:
        if (r2 == false) goto L99;
        com.larus.bmhome.chat.component.collection.o r3 = (com.larus.bmhome.chat.component.collection.o) this.o.getValue();
        if (r3 != null) goto L28;
    L30:
        boolean r5 = false;
    L31:
        Object r6 = null;
        if (r5 == true) goto L91;
        com.larus.bmhome.chat.component.showcase.x r7 = (com.larus.bmhome.chat.component.showcase.x) this.p.getValue();
        if (r7 != null) goto L36;
    L38:
        boolean r8 = false;
    L39:
        if (r8 == true) goto L91;
        de8.c r10 = (de8.c) this.q.getValue();
        if (r10 == null) goto L48;
        Bundle r11 = r10.b;
        if (r11 == null) goto L48;
        if (r11.getBoolean("is_create_sub_conversation") != true) goto L48;
        boolean r12 = true;
    L49:
        if (r12 == false) goto L51;
        FLogger.a.i("ObricSetDefaultAssistantBannerComponent", "not main bot, create sub conversation");
        goto L99
    L51:
        de8.c r13 = (de8.c) this.q.getValue();
        if (r13 == null) goto L56;
        Bundle r14 = r13.b;
        if (r14 == null) goto L56;
        String r15 = r14.getString("argConversationId");
    L57:
        if (r15 != null) goto L59;
    L62:
        boolean r16 = true;
    L63:
        if (r16 == false) goto L66;
        r15 = null;
    L66:
        if (r15 != null) goto L73;
        de8.c r17 = (de8.c) this.q.getValue();
        if (r17 == null) goto L72;
        Bundle r18 = r17.a;
        if (r18 == null) goto L72;
        r15 = r18.getString("argConversationId");
    L72:
        r15 = null;
    L73:
        IAuthModelService r19 = (IAuthModelService) ServiceManager.get().getService(IAuthModelService.class);
        if (r19 == null) goto L78;
        LiveData r20 = r19.y();
        if (r20 == null) goto L78;
        wc9.e r21 = (wc9.e) r20.getValue();
    L79:
        if (r15 != null) goto L81;
    L84:
        boolean r22 = true;
    L85:
        if (r22 == true) goto L90;
        if (r21 == null) goto L89;
        r6 = r21.a;
    L89:
        if (Intrinsics.areEqual(r15, r6) == false) goto L99;
    L90:
        boolean r23 = true;
    L100:
        if (r23 == false) goto L113;
        ObricFloatChatPageData.Companion.getClass();
        if ((r9 instanceof vda.d) == false) goto L104;
    L109:
        boolean r24 = true;
    L110:
        if (r24 == false) goto L114;
        return true;
    L114:
        return false;
    L104:
        if ((r9 instanceof vda.e) == true) goto L109;
        if ((r9 instanceof vda.f) == true) goto L109;
        r24 = false;
        goto L110
    L113:
        return false;
    L81:
        if (r15.length() == 0) goto L84;
        r22 = false;
    L78:
        r21 = null;
        goto L79
    L59:
        if (r15.length() == 0) goto L62;
        r16 = false;
    L56:
        r15 = null;
    L48:
        r12 = false;
        goto L49
    L36:
        if (r7.e6() != true) goto L38;
        r8 = true;
    L91:
        FLogger r25 = FLogger.a;
        StringBuilder r26 = new StringBuilder("not main bot, collectMode=");
        com.larus.bmhome.chat.component.collection.o r27 = (com.larus.bmhome.chat.component.collection.o) this.o.getValue();
        if (r27 == null) goto L94;
        Boolean r28 = Boolean.valueOf(r27.i0());
    L95:
        r26.append(r28);
        r26.append(", showCaseMode=");
        com.larus.bmhome.chat.component.showcase.x r29 = (com.larus.bmhome.chat.component.showcase.x) this.p.getValue();
        if (r29 == null) goto L98;
        r6 = Boolean.valueOf(r29.e6());
    L98:
        r26.append(r6);
        r25.i("ObricSetDefaultAssistantBannerComponent", r26.toString());
        goto L99
    L94:
        r28 = null;
        goto L95
    L28:
        if (r3.i0() != true) goto L30;
        r5 = true;
        goto L31
    L20:
        if (r1.Da() != true) goto L22;
        r2 = true;
    L99:
        r23 = false;
        goto L100
    }

    public final void r2(boolean r1) {
        p3();
    }

    public final void x1(ObricFloatChatPageState r2) {
        Intrinsics.checkNotNullParameter(r2, "pageState");
        p3();
    }
}
