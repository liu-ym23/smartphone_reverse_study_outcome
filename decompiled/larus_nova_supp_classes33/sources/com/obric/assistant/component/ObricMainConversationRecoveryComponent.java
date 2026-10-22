package com.obric.assistant.component;

import android.os.Bundle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import com.larus.bmhome.chat.api.IAuthModelService;
import com.larus.platform.service.AccountService;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 -2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\b\u0010!\u001a\u00020\u001fH\u0016J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$H\u0002J\u0016\u0010%\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$H\u0082@¢\u0006\u0002\u0010&J\u0010\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020$H\u0002J\u0010\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u0005H\u0002J\u0018\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020$2\u0006\u0010#\u001a\u00020$H\u0002R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/obric/assistant/component/ObricMainConversationRecoveryComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "<init>", "()V", "conversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "conversationAbility$delegate", "Lkotlin/Lazy;", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "observedAuthModelService", "Lcom/larus/bmhome/chat/api/IAuthModelService;", "recoveryJob", "Lkotlinx/coroutines/Job;", "launchRetryRequested", "", "mainConversationRetryRequested", "hasReboundPageConversation", "hasCheckedOnResume", "mainConversationObserver", "Landroidx/lifecycle/Observer;", "Lcom/larus/im/bean/conversation/Conversation;", "launchInfoObserver", "Lcom/larus/bmhome/auth/LaunchResult;", "Lcom/larus/bmhome/auth/CoreLaunchInfo;", "onCreate", "", "onDestroy", "onResume", "scheduleRecovery", WindowEvent.Params.REASON, "", "recoverOnForeground", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isRemoteConversationId", "conversationId", "isSubConversationPage", "ability", "rebindPageConversation", "remoteConversationId", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricMainConversationRecoveryComponent extends ComponentFeature {
    public static final /* synthetic */ int r = 0;
    public final Lazy h;
    public final Lazy i;
    public IAuthModelService j;
    public Job k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public final w2 p;
    public final x2 q;

    public static final class a {
    }

    public static final class b implements Function0<com.larus.bmhome.chat.component.cvs.y> {
        public final /* synthetic */ AttachReceiver a;

        public b(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.cvs.y.class));
        }
    }

    public static final class c implements Function0<de8.c> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
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
    }

    public final void onCreate() {
        IAuthModelService r0 = (IAuthModelService) ServiceManager.get().getService(IAuthModelService.class);
        if (r0 != null) goto L6;
        FLogger.a.w("ObricMainCvsRecovery", "register observer failed: auth service is missing");
        return;
    L6:
        this.j = r0;
        r0.y().observe(this, this.p);
        r0.a().observe(this, this.q);
        FLogger.a.i("ObricMainCvsRecovery", "main conversation and launch observers registered");
    }

    public final void onDestroy() {
        IAuthModelService r0 = this.j;
        if (r0 == null) goto L7;
        LiveData r1 = r0.y();
        if (r1 == null) goto L7;
        r1.removeObserver(this.p);
    L7:
        IAuthModelService r2 = this.j;
        if (r2 == null) goto L12;
        LiveData r3 = r2.a();
        if (r3 == null) goto L12;
        r3.removeObserver(this.q);
    L12:
        this.j = null;
        Job r4 = this.k;
        if (r4 == null) goto L15;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);
    L15:
        this.k = null;
        FLogger.a.i("ObricMainCvsRecovery", "main conversation and launch observers removed");
    }

    public final void onResume() {
        if (this.o == false) goto L6;
        FLogger.a.i("ObricMainCvsRecovery", "skip repeated onResume recovery");
        return;
    L6:
        N2("resume");
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.obric.assistant.component.w2] */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.obric.assistant.component.x2] */
    public ObricMainConversationRecoveryComponent() {
        this.h = LazyKt.lazy(new b(this));
        this.i = LazyKt.lazy(new c(this));
        this.p = new w2(this);
        this.q = new x2(this);
    }

    public final boolean F2(com.larus.bmhome.chat.component.cvs.y r8) {
        de8.c r0 = (de8.c) this.i.getValue();
        String r1 = null;
        if (r0 == null) goto L5;
        Bundle r2 = r0.b;
    L6:
        String r3 = r8.Y1();
        wc9.e r9 = r8.h();
        if (r2 == null) goto L9;
        Integer r4 = Integer.valueOf(r2.getInt("argBotConversationType", 0));
    L11:
        if (r2 != null) goto L13;
    L15:
        boolean r5 = false;
    L16:
        if (r5 == false) goto L18;
    L31:
        return true;
    L18:
        if (r4 != null) goto L21;
    L22:
        if (r9 == null) goto L25;
        r1 = r9.a;
    L25:
        if (Intrinsics.areEqual(r1, r3) == false) goto L33;
        Integer r10 = r9.v;
        if (r10 != null) goto L30;
        return false;
    L30:
        if (r10.intValue() == 3) goto L31;
        return false;
    L33:
        return false;
    L21:
        if (r4.intValue() == 3) goto L31;
    L13:
        if (r2.getBoolean("is_create_sub_conversation") != true) goto L15;
        r5 = true;
        goto L16
    L9:
        r4 = null;
        goto L11
    L5:
        r2 = null;
        goto L6
    }

    public final void N2(String r9) {
        Job r0 = this.k;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L10;
        FLogger.a.i("ObricMainCvsRecovery", "recovery already scheduled, reason=" + r9);
        return;
    L10:
        this.k = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ObricMainConversationRecoveryComponent$scheduleRecovery$1(this, r9, null), 3, null);
        return;
    L5:
        if (r0.isActive() != true) goto L7;
        r1 = true;
        goto L7
    }

    public final void L2(String r18, String r19) {
        if (this.n == false) goto L6;
        FLogger.a.i("ObricMainCvsRecovery", "page conversation already rebound, reason=".concat(r19));
        return;
    L6:
        com.larus.bmhome.chat.component.cvs.y r3 = (com.larus.bmhome.chat.component.cvs.y) this.h.getValue();
        if (r3 != null) goto L9;
        return;
    L9:
        IAuthModelService r5 = (IAuthModelService) ServiceManager.get().getService(IAuthModelService.class);
        if (r5 != null) goto L12;
        return;
    L12:
        com.larus.bmhome.auth.h0 r6 = r5.v();
        if (r6 == null) goto L41;
        String r7 = r6.b();
        if (r7 == null) goto L42;
        boolean r8 = false;
        if ((!StringsKt.isBlank(r7)) == true) goto L19;
    L21:
        boolean r9 = false;
    L22:
        if (r9 == true) goto L25;
        r7 = null;
    L25:
        if (r7 == null) goto L43;
        String r10 = r3.Y1();
        String r11 = com.larus.im.j.b(r10);
        boolean r12 = F2(r3);
        if (AccountService.a.isLogin().booleanValue() == false) goto L36;
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (com.larus.ui.arch.component.internal.attach.a.b(this, this).isResumed() == false) goto L36;
        if (com.larus.im.j.f(r10) == false) goto L36;
        if (Intrinsics.areEqual(r11, r7) == false) goto L36;
        if (r12 == true) goto L36;
        r8 = true;
    L36:
        FLogger r13 = FLogger.a;
        StringBuilder r14 = new StringBuilder("rebind check, reason=");
        r14.append(r19);
        r14.append(", localCvsId=");
        r14.append(r10);
        r14.append(", remoteCvsId=");
        r14.append(r18);
        r14.append(", mainBotId=");
        r14.append(r7);
        r14.append(", localBotId=");
        r14.append(r11);
        r14.append(", isSubConversation=");
        r14.append(r12);
        r14.append(", resumed=");
        Intrinsics.checkNotNullParameter(this, "<this>");
        r14.append(com.larus.ui.arch.component.internal.attach.a.b(this, this).isResumed());
        r14.append(", shouldRebind=");
        r14.append(r8);
        r13.i("ObricMainCvsRecovery", r14.toString());
        if (r8 == true) goto L39;
        return;
    L39:
        this.n = true;
        r3.updateConversationId(r18, r7);
        r13.i("ObricMainCvsRecovery", "rebind success, reason=" + r19 + ", localCvsId=" + r10 + ", remoteCvsId=" + r18 + ", mainBotId=" + r7);
        return;
    L43:
        return;
    L19:
        if (Intrinsics.areEqual(r7, "0") == true) goto L21;
        r9 = true;
        goto L22
    L42:
        return;
    }
}
