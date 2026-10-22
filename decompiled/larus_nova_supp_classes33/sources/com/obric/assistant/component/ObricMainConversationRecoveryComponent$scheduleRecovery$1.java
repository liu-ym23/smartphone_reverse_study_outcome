package com.obric.assistant.component;

import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.IAuthModelService;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.component.ObricMainConversationRecoveryComponent$scheduleRecovery$1", f = "ObricMainConversationRecoveryComponent.kt", i = {}, l = {122, 127}, m = "invokeSuspend", n = {}, s = {})
public final class ObricMainConversationRecoveryComponent$scheduleRecovery$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $reason;
    int label;
    final /* synthetic */ ObricMainConversationRecoveryComponent this$0;

    public ObricMainConversationRecoveryComponent$scheduleRecovery$1(ObricMainConversationRecoveryComponent r1, String r2, Continuation<? super ObricMainConversationRecoveryComponent$scheduleRecovery$1> r3) {
        this.this$0 = r1;
        this.$reason = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ObricMainConversationRecoveryComponent$scheduleRecovery$1(this.this$0, this.$reason, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r87) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        ResultKt.throwOnFailure(r87);
    L107:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r87);
    L14:
        if (s1a.a.c(this.this$0).isResumed() == false) goto L107;
        if (Intrinsics.areEqual(this.$reason, "resume") == false) goto L18;
        this.this$0.o = true;
    L18:
        ObricMainConversationRecoveryComponent r3 = this.this$0;
        String r6 = this.$reason;
        this.label = 2;
        int r4 = ObricMainConversationRecoveryComponent.r;
        com.larus.bmhome.chat.component.cvs.y r5 = (com.larus.bmhome.chat.component.cvs.y) r3.h.getValue();
        if (r5 != null) goto L21;
        Object r7 = Unit.INSTANCE;
    L104:
        if (r7 != r1) goto L107;
        return r1;
    L21:
        IAuthModelService r8 = (IAuthModelService) ServiceManager.get().getService(IAuthModelService.class);
        if (r8 != null) goto L24;
        r7 = Unit.INSTANCE;
        goto L104
    L24:
        com.larus.bmhome.auth.c1 r9 = (com.larus.bmhome.auth.c1) r8.a().getValue();
        com.larus.bmhome.auth.h0 r10 = r8.v();
        if (r10 == null) goto L36;
        String r13 = r10.b();
        if (r13 == null) goto L36;
        if ((!StringsKt.isBlank(r13)) == true) goto L31;
    L33:
        boolean r14 = false;
    L34:
        if (r14 == false) goto L36;
    L37:
        String r15 = r5.Y1();
        String r16 = com.larus.im.j.b(r15);
        if (r13 != null) goto L40;
    L44:
        boolean r17 = false;
    L45:
        boolean r11 = r3.F2(r5);
        AccountService r18 = AccountService.a;
        if (r18.isLogin().booleanValue() == false) goto L50;
        if (r17 == false) goto L50;
        if (r11 == true) goto L50;
        boolean r12 = true;
    L51:
        wc9.e r19 = (wc9.e) r8.y().getValue();
        if (r19 == null) goto L65;
        String r110 = r19.a;
        if (r110 == null) goto L65;
        if ((!StringsKt.isBlank(r110)) == true) goto L58;
    L62:
        boolean r111 = false;
    L63:
        if (r111 == false) goto L65;
    L66:
        FLogger r112 = FLogger.a;
        StringBuilder r20 = new StringBuilder("recovery check, reason=");
        r20.append(r6);
        r20.append(", localCvsId=");
        r20.append(r15);
        r20.append(", remoteCvsId=");
        r20.append(r110);
        r20.append(", mainBotId=");
        r20.append(r13);
        r20.append(", localBotId=");
        r20.append(r16);
        r20.append(", isSubConversation=");
        r20.append(r11);
        r20.append(", launchStatus=");
        if (r9 == null) goto L69;
        Integer r21 = Boxing.boxInt(r9.b);
    L70:
        r20.append(r21);
        r20.append(", shouldRecover=");
        r20.append(r12);
        r20.append(", launchRetryRequested=");
        r20.append(r3.l);
        r20.append(", mainConversationRetryRequested=");
        r20.append(r3.m);
        r20.append(", hasReboundPageConversation=");
        r20.append(r3.n);
        r112.i("ObricMainCvsRecovery", r20.toString());
        if (r18.isLogin().booleanValue() == true) goto L73;
    L88:
        if (r12 == true) goto L91;
        Unit r22 = Unit.INSTANCE;
    L90:
        r7 = r22;
    L99:
        r1 = r1;
        goto L104
    L91:
        if (r110 != null) goto L93;
        LaunchInfo r23 = new LaunchInfo(null, null, null, null, null, null, null, r13, null, null, 0, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, false, false, false, null, null, null, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, 0, 0, null, null, null, null, null, null, -129, -1, 1048575);
        if (r3.m == false) goto L100;
        r112.i("ObricMainCvsRecovery", "main conversation retry already requested");
        r22 = Unit.INSTANCE;
        goto L90
    L100:
        r3.m = true;
        r112.i("ObricMainCvsRecovery", "remote main conversation is missing, retry conversation in foreground");
        r7 = r8.G(r23, this);
        if (r7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L99;
        r7 = Unit.INSTANCE;
        goto L99
    L93:
        if (r3.n == false) goto L95;
        r112.i("ObricMainCvsRecovery", "skip repeated resume rebind");
        r22 = Unit.INSTANCE;
        goto L90
    L95:
        r3.L2(r110, "resume");
        r22 = Unit.INSTANCE;
        goto L90
    L73:
        if (com.larus.im.j.f(r15) == false) goto L88;
        if (r11 == true) goto L88;
        if (r10 == null) goto L77;
        if (r13 != null) goto L88;
    L77:
        if (r9 != null) goto L79;
    L81:
        boolean r113 = false;
    L82:
        if (r113 == false) goto L85;
        r112.i("ObricMainCvsRecovery", "launch request is running, wait for observer");
        r22 = Unit.INSTANCE;
        goto L90
    L85:
        if (r3.l == false) goto L87;
        r112.i("ObricMainCvsRecovery", "launch retry already requested in current page");
        r22 = Unit.INSTANCE;
        goto L90
    L87:
        r3.l = true;
        r112.i("ObricMainCvsRecovery", "launch info is missing, retry core launch in foreground");
        IAuthModelService.a.a(r8, "ObricMainCvsRecovery", true, 4);
        r22 = Unit.INSTANCE;
        goto L90
    L79:
        if (r9.b != 1) goto L81;
        r113 = true;
        goto L82
    L69:
        r21 = null;
        goto L70
    L58:
        if (Intrinsics.areEqual(r110, "0") == true) goto L62;
        if (com.larus.im.j.f(r110) == true) goto L62;
        r111 = true;
    L65:
        r110 = null;
    L50:
        r12 = false;
        goto L51
    L40:
        if (com.larus.im.j.f(r15) == false) goto L44;
        if (Intrinsics.areEqual(r16, r13) == false) goto L44;
        r17 = true;
        goto L45
    L31:
        if (Intrinsics.areEqual(r13, "0") == true) goto L33;
        r14 = true;
    L36:
        r13 = null;
        goto L37
    L10:
        ResultKt.throwOnFailure(r87);
        this.label = 1;
        if (DelayKt.delay(500, this) != r1) goto L14;
        return r1;
    }
}
