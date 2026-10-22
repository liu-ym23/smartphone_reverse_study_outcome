package com.obric.assistant.session;

import android.os.Bundle;
import bga.j;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL;
import com.obric.assistant.common.utils.i;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.interaction.api.service.IInteractionStateService;
import com.obric.assistant.session.bean.ErrorCode;
import com.obric.assistant.session.model.IAssistActivateOperation;
import com.obric.assistant.session.model.ISessionMaintaining;
import com.obric.assistant.session.singleton.u;
import com.obric.assistant.utils.o;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.session.AiIslandVoiceInteractionSession$doOnShow$job$1", f = "AiIslandVoiceInteractionSession.kt", i = {0, 0, 1, 1}, l = {596, 223}, m = "invokeSuspend", n = {"waitLockTrace", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "errorCode"}, s = {"L$0", "L$1", "L$0", "L$3"})
public final class AiIslandVoiceInteractionSession$doOnShow$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bundle $args;
    final /* synthetic */ int $showFlags;
    final /* synthetic */ i.a $waitLaunchTrace;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ AiIslandVoiceInteractionSession this$0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ErrorCode.values().length];
            r0[ErrorCode.CONTINUE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[ErrorCode.END_ON_SHOW.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[ErrorCode.QUIT_SESSION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[ErrorCode.LAUNCH_ASSISTANT_DIRECTLY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[ErrorCode.NA.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[ErrorCode.ONLY_END.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            a = r0;
        }
    }

    public AiIslandVoiceInteractionSession$doOnShow$job$1(i.a r1, AiIslandVoiceInteractionSession r2, Bundle r3, int r4, Continuation<? super AiIslandVoiceInteractionSession$doOnShow$job$1> r5) {
        this.$waitLaunchTrace = r1;
        this.this$0 = r2;
        this.$args = r3;
        this.$showFlags = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        AiIslandVoiceInteractionSession$doOnShow$job$1 r6 = new AiIslandVoiceInteractionSession$doOnShow$job$1(this.$waitLaunchTrace, this.this$0, this.$args, this.$showFlags, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.obric.assistant.session.model.ISessionMaintaining] */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r11v2, types: [com.obric.assistant.session.model.ISessionMaintaining] */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r13v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r14v0, types: [android.os.Bundle] */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v3, types: [android.os.Bundle, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.obric.assistant.session.model.ISessionMaintaining] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v13, types: [com.obric.assistant.session.bean.ErrorCode] */
    /* JADX WARN: Type inference failed for: r2v14, types: [com.obric.assistant.session.bean.ErrorCode] */
    /* JADX WARN: Type inference failed for: r2v16, types: [com.obric.assistant.session.model.ISessionMaintaining] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v24, types: [com.obric.assistant.session.bean.ErrorCode] */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v7, types: [com.obric.assistant.session.model.ISessionMaintaining] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v12, types: [com.obric.assistant.session.AiIslandVoiceInteractionSession] */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [com.obric.assistant.session.AiIslandVoiceInteractionSession] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8, types: [com.obric.assistant.session.AiIslandVoiceInteractionSession] */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r7v0, types: [int] */
    /* JADX WARN: Type inference failed for: r7v1, types: [com.obric.assistant.session.AiIslandVoiceInteractionSession] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13, types: [android.os.Bundle] */
    /* JADX WARN: Type inference failed for: r7v14, types: [android.os.Bundle] */
    /* JADX WARN: Type inference failed for: r7v15, types: [android.os.Bundle] */
    /* JADX WARN: Type inference failed for: r7v16, types: [android.os.Bundle] */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v22, types: [android.os.Bundle] */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v29 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v30 */
    /* JADX WARN: Type inference failed for: r7v31 */
    /* JADX WARN: Type inference failed for: r7v32 */
    /* JADX WARN: Type inference failed for: r7v9, types: [android.service.voice.VoiceInteractionSession, com.obric.assistant.session.AiIslandVoiceInteractionSession, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [com.obric.assistant.session.bean.ErrorCode] */
    /* JADX WARN: Type inference failed for: r8v10, types: [com.obric.assistant.session.bean.ErrorCode, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v27 */
    /* JADX WARN: Type inference failed for: r8v30 */
    /* JADX WARN: Type inference failed for: r8v31 */
    /* JADX WARN: Type inference failed for: r8v7, types: [com.obric.assistant.session.model.ISessionMaintaining] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v15, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v26 */
    /* JADX WARN: Type inference failed for: r9v27 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    public final Object invokeSuspend(Object r18) {
        ?? r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r7 = this.label;
        ?? r9 = 2;
        ?? r10 = 2;
        if (r7 == 0) goto L16;
        if (r7 == 1) goto L15;
        if (r7 != 2) goto L14;
        ?? r2 = (ErrorCode) this.L$3;
        r6 = (AiIslandVoiceInteractionSession) this.L$2;
        r7 = (Bundle) this.L$1;
        r10 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r18);     // Catch: Throwable -> L9 Exception -> L11
        ?? r8 = r2;
        Object r3 = r18;
        r6 = r6;
        r7 = r7;
        r10 = r10;
    L126:
        ErrorCode r4 = (ErrorCode) r3;     // Catch: Throwable -> L46 Exception -> L48
        ErrorCode r5 = r4;
        ?? r11 = r6;
        ?? r12 = r7;
        ?? r13 = r10;
        if (r4 != null) goto L53;
        ?? r14 = r6;
        ?? r15 = r7;
        ?? r16 = r10;
    L51:
        r5 = ErrorCode.NA;     // Catch: Throwable -> L9 Exception -> L11
        r11 = r14;
        r12 = r15;
        r13 = r16;
    L53:
        switch(a.a[r5.ordinal()]) {
            case 1: goto L62;
            case 2: goto L62;
            case 3: goto L55;
            case 4: goto L55;
            case 5: goto L55;
            case 6: goto L55;
            default: goto L85;
        };     // Catch: Throwable -> L9 Exception -> L11
    L55:
        FLogger.a.i("AiIslandVoiceInteractionSession", "doOnShow: code = " + r5 + ", return");     // Catch: Throwable -> L9 Exception -> L11
        ISessionMaintaining r0 = j.b();     // Catch: Throwable -> L60
        ?? r1 = r0;
        ?? r17 = r5;
        ?? r19 = r11;
        ?? r20 = r12;
        ?? r21 = r13;
        ?? r22 = r5;
        ?? r23 = r11;
        ?? r24 = r12;
        ?? r25 = r13;
        if (r0 == null) goto L102;
    L58:
        r1.r(r17, r20);     // Catch: Throwable -> L60
        r22 = r17;
        r23 = r19;
        r24 = r20;
        r25 = r21;
    L102:
        AiIslandVoiceInteractionSession.f(r23, r24, r22);     // Catch: Throwable -> L60
        ?? r26 = r25;
    L103:
        ?? r110 = r26;
    L104:
        Unit r27 = Unit.INSTANCE;     // Catch: Throwable -> L117
        r110.unlock(null);
        return Unit.INSTANCE;
    L117:
        th = th;
    L118:
        r110.unlock(null);
        throw th;
    L62:
        u.b();     // Catch: Throwable -> L9 Exception -> L11
        IAssistActivateOperation r28 = bga.d.a();     // Catch: Throwable -> L9 Exception -> L11
        if (r28 == null) goto L65;
        r28.i();     // Catch: Throwable -> L9 Exception -> L11
    L65:
        IInteractionStateService r29 = IAssistantInteractionServiceKt.getInteractionStateService();     // Catch: Throwable -> L9 Exception -> L11
        IAssistActivateOperation r30 = bga.d.a();     // Catch: Throwable -> L9 Exception -> L11
        if (r30 != null) goto L68;
    L70:
        boolean r31 = false;
    L71:
        r29.clearCustomBarActions(r31);     // Catch: Throwable -> L9 Exception -> L11
        IAgentVoiceInteractionIDL r32 = com.obric.aiagent.assistant.idl.u.a(Reflection.getOrCreateKotlinClass(IAgentVoiceInteractionIDL.class));     // Catch: Throwable -> L9 Exception -> L11
        if (r32 == null) goto L74;
        r32.onShow(r12);     // Catch: Throwable -> L9 Exception -> L11
    L74:
        FLogger r33 = FLogger.a;     // Catch: Throwable -> L9 Exception -> L11
        r33.i("AiIslandVoiceInteractionSession", "launchAssistantNow ------------> start !");     // Catch: Throwable -> L9 Exception -> L11
        ISessionMaintaining r34 = j.b();     // Catch: Throwable -> L9 Exception -> L11
        if (r34 == null) goto L77;
        r34.l();     // Catch: Throwable -> L9 Exception -> L11
        Boolean r35 = Boxing.boxBoolean(true);     // Catch: Throwable -> L9 Exception -> L11
    L78:
        r33.i("AiIslandVoiceInteractionSession", "launchAssistantNow end ! " + r35);     // Catch: Throwable -> L9 Exception -> L11
        ErrorCode r36 = ErrorCode.END_ON_SHOW;     // Catch: Throwable -> L9 Exception -> L11
        ?? r37 = j.b();     // Catch: Throwable -> L60
        if (r37 == 0) goto L82;
        r37.r(r36, r12);     // Catch: Throwable -> L60
    L82:
        AiIslandVoiceInteractionSession.f(r11, r12, r36);     // Catch: Throwable -> L60
        r26 = r13;
        goto L103
    L77:
        r35 = null;
        goto L78
    L68:
        if (r30.o() != true) goto L70;
        r31 = true;
        goto L71
    L85:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L9 Exception -> L11
    L48:
        e = e;
        r2 = r8;
    L90:
        FLogger.a.w("AiIslandVoiceInteractionSession", "doOnShowFailed: " + e.getMessage(), e);     // Catch: Throwable -> L9
        o r38 = o.a;     // Catch: Throwable -> L9
        String r39 = "doOnShow failed: " + e.getMessage();     // Catch: Throwable -> L9
        r38.getClass();     // Catch: Throwable -> L9
        String r40 = "VOICE";
        if (r7 == 0) goto L96;
        String r41 = r7.getString("sessionName", "VOICE");     // Catch: Throwable -> L9
        if (r41 == null) goto L96;
        r40 = r41;
    L96:
        if (r39 != null) goto L98;
        r39 = "";
    L98:
        o.b("do_show_failed", r39, r40);     // Catch: Throwable -> L9
        ISessionMaintaining r42 = j.b();     // Catch: Throwable -> L60
        r22 = r2;
        r23 = r6;
        r24 = r7;
        r25 = r10;
        if (r42 == null) goto L102;
        r1 = r42;
        r17 = r2;
        r19 = r6;
        r20 = r7;
        r21 = r10;
    L46:
        th = th;
    L108:
        ?? r111 = r7;
        r110 = r10;
        ?? r43 = r6;
    L122:
        ?? r44 = j.b();     // Catch: Throwable -> L114
        if (r44 == 0) goto L112;
        r44.r(r8, r111);     // Catch: Throwable -> L114
    L112:
        AiIslandVoiceInteractionSession.f(r43, r111, r8);     // Catch: Throwable -> L114
        throw th;     // Catch: Throwable -> L114
    L114:
        th = th;
        r9 = r110;
    L116:
        r110 = r9;
    L11:
        e = e;
        goto L90
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        int r45 = this.I$0;
        AiIslandVoiceInteractionSession r112 = (AiIslandVoiceInteractionSession) this.L$3;
        Bundle r113 = (Bundle) this.L$2;
        kotlinx.coroutines.sync.a r114 = (kotlinx.coroutines.sync.a) this.L$1;
        final i.a r46 = (i.a) this.L$0;
        ResultKt.throwOnFailure(r18);
        int r115 = r45;
        r43 = r112;
        r110 = r114;
        r111 = r113;
    L25:
        if (r46 != null) goto L124;
    L27:
        ?? r47 = j.b();     // Catch: Throwable -> L117
        if (r47 == 0) goto L30;
        boolean r48 = r47.e(r111);     // Catch: Throwable -> L117
    L31:
        if (r48 == true) goto L33;
        FLogger.a.i("AiIslandVoiceInteractionSession", "doOnShow: is not valid, return");     // Catch: Throwable -> L117
        AiIslandVoiceInteractionSession.f(r43, r111, ErrorCode.NA);     // Catch: Throwable -> L117
        r110 = r110;
        goto L104
    L33:
        r8 = ErrorCode.NA;     // Catch: Throwable -> L117
        AiIslandVoiceInteractionSession.g(r43, r111, r115);     // Catch: Throwable -> L86 Exception -> L88
        ?? r116 = j.b();     // Catch: Throwable -> L86 Exception -> L88
        if (r116 == 0) goto L37;
        r116.p(r43.getContext(), r111);     // Catch: Throwable -> L86 Exception -> L88
    L37:
        FLogger.a.i("AiIslandVoiceInteractionSession", "onShow showFlags: " + r115 + ", from source is " + j.a());     // Catch: Throwable -> L86 Exception -> L88
        ?? r49 = j.b();     // Catch: Throwable -> L86 Exception -> L88
        if (r49 == 0) goto L50;
        this.L$0 = r110;     // Catch: Throwable -> L86 Exception -> L88
        this.L$1 = r111;     // Catch: Throwable -> L86 Exception -> L88
        this.L$2 = r43;     // Catch: Throwable -> L86 Exception -> L88
        this.L$3 = r8;     // Catch: Throwable -> L86 Exception -> L88
        this.label = 2;     // Catch: Throwable -> L86 Exception -> L88
        r3 = r49.d(r111, this);     // Catch: Throwable -> L86 Exception -> L88
        if (r3 != r6) goto L42;
        return r6;
    L42:
        r6 = r43;
        r10 = r110;
        r7 = r111;
        r8 = r8;
        goto L126
    L50:
        r14 = r43;
        r16 = r110;
        r15 = r111;
    L88:
        e = e;
        r6 = r43;
        r2 = r8;
        r10 = r110;
        r7 = r111;
    L86:
        th = th;
        goto L122
    L30:
        r48 = false;
        goto L31
    L124:
        r46.a();     // Catch: Throwable -> L117
        goto L27
    L16:
        ResultKt.throwOnFailure(r18);
        CoroutineScope r50 = (CoroutineScope) this.L$0;
        i.a r51 = this.$waitLaunchTrace;
        if (r51 == null) goto L19;
        r51.a();
    L19:
        r46 = i.a("ObricAiSession.onShow.waitLock");
        if (r46 == null) goto L22;
        JobKt.getJob(r50.getCoroutineContext()).invokeOnCompletion(new d(r46));
    L22:
        AiIslandVoiceInteractionSession r52 = this.this$0;
        MutexImpl r117 = r52.d;
        Bundle r118 = this.$args;
        r115 = this.$showFlags;
        this.L$0 = r46;
        this.L$1 = r117;
        this.L$2 = r118;
        this.L$3 = r52;
        this.I$0 = r115;
        this.label = 1;
        Object r119 = r117.a(null, this);
        r43 = r52;
        r110 = r117;
        r111 = r118;
        if (r119 != r6) goto L25;
        return r6;
    L9:
        th = th;
        r8 = "onShow showFlags: ";
    L60:
        th = th;
        goto L116
    }
}
