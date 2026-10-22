package com.obric.assistant.ipc;

import com.larus.account.base.api.ILoginService;
import com.larus.account.base.api.UserAction;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.audio.ObricEnrollInteropDelegate;
import com.obric.audio.enroll.VoiceEnrollServiceDelegate;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.ipc.IpcMessenger$handleAccountBecomeActive$1", f = "IpcMessenger.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class IpcMessenger$handleAccountBecomeActive$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ UserAction $action;
    final /* synthetic */ String $uid;
    private /* synthetic */ Object L$0;
    int label;

    public IpcMessenger$handleAccountBecomeActive$1(String r1, UserAction r2, Continuation<? super IpcMessenger$handleAccountBecomeActive$1> r3) {
        this.$uid = r1;
        this.$action = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        IpcMessenger$handleAccountBecomeActive$1 r0 = new IpcMessenger$handleAccountBecomeActive$1(this.$uid, this.$action, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r10v80 */
    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L96;
        ResultKt.throwOnFailure(r10);
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        UserAction r12 = this.$action;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        VoiceEnrollServiceDelegate.c.i("account_active_" + r12);     // Catch: Throwable -> L7
        Object r13 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L97;
        FLogger.a.e(SvaSdkIPCService.TAG, "releaseVoiceEnrollState failed: " + r14.getMessage());
    L97:
        ObricEnrollInteropDelegate.b.p();     // Catch: Throwable -> L14
        Object r15 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L19;
        FLogger.a.e(SvaSdkIPCService.TAG, "migrateLegacyPhoneWakeupSettings failed: " + r16.getMessage());
    L19:
        boolean r2 = true;
        if ((!StringsKt.isBlank(this.$uid)) == true) goto L103;
        ?? r17 = 0;
    L35:
        if ((!StringsKt.isBlank(this.$uid)) == true) goto L109;
        boolean r3 = false;
    L49:
        IpcMessenger r4 = IpcMessenger.a;
        String r5 = this.$uid;
        r4.getClass();
        IpcMessenger.i(9, 1, r17, r5);
        ObricEnrollInteropDelegate r6 = ObricEnrollInteropDelegate.b;     // Catch: Throwable -> L56
        if (r17 == 0) goto L53;
        boolean r7 = true;
    L54:
        r6.f(r7);     // Catch: Throwable -> L56
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L56
    L58:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L101;
        FLogger.a.e(SvaSdkIPCService.TAG, "sync setVoiceWakeupEnabled(" + r17 + ") failed: " + r9.getMessage());
    L101:
        ObricEnrollInteropDelegate r18 = ObricEnrollInteropDelegate.b;     // Catch: Throwable -> L67
        if (r3 == false) goto L64;
        boolean r19 = true;
    L65:
        r18.j(r19);     // Catch: Throwable -> L67
        Object r110 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L67
    L69:
        Throwable r111 = Result.exceptionOrNull-impl(r110);
        if (r111 == null) goto L73;
        FLogger.a.e(SvaSdkIPCService.TAG, "sync setBreathWakeupEnabled(" + r3 + ") failed: " + r111.getMessage());
    L73:
        if (this.$action == UserAction.USER_LOGIN) goto L107;
    L93:
        IpcMessenger.k(IpcMessenger.a, 6, 0, null, 14);
        return Unit.INSTANCE;
    L107:
        Object r112 = Result.constructor-impl(Boxing.boxBoolean(ILoginService.a.getAccountInfo().g));     // Catch: Throwable -> L76
    L78:
        Boolean r20 = Boxing.boxBoolean(false);
        if (Result.isFailure-impl(r112) == false) goto L81;
        r112 = r20;
    L81:
        boolean r113 = ((Boolean) r112).booleanValue();
        VoiceEnrollServiceDelegate r21 = VoiceEnrollServiceDelegate.c;     // Catch: Throwable -> L88
        if (r113 == true) goto L86;
        r2 = false;
    L86:
        Object r114 = Result.constructor-impl(Boxing.boxInt(r21.l(r2)));     // Catch: Throwable -> L88
    L90:
        Throwable r115 = Result.exceptionOrNull-impl(r114);
        if (r115 == null) goto L93;
        FLogger.a.e(SvaSdkIPCService.TAG, "migrateLegacyPhoneEnrollIfNeeded failed: " + r115.getMessage());
    L88:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r114 = Result.constructor-impl(ResultKt.createFailure(th));
    L76:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r112 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L78
    L64:
        r19 = false;
    L67:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r110 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L69
    L53:
        r7 = false;
    L56:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L58
    L109:
        Object r26 = Result.constructor-impl(Boxing.boxBoolean(ObricEnrollInteropDelegate.b.y(this.$uid)));     // Catch: Throwable -> L39
    L41:
        Throwable r27 = Result.exceptionOrNull-impl(r26);
        if (r27 == null) goto L44;
        FLogger.a.e(SvaSdkIPCService.TAG, "isBreathWakeupEnabled(uid) failed: " + r27.getMessage());
    L44:
        Boolean r28 = Boxing.boxBoolean(false);
        if (Result.isFailure-impl(r26) == false) goto L47;
        r26 = r28;
    L47:
        r3 = ((Boolean) r26).booleanValue();
    L39:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        r26 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L41
    L103:
        Object r116 = Result.constructor-impl(Boxing.boxBoolean(ObricEnrollInteropDelegate.b.u(this.$uid)));     // Catch: Throwable -> L24
    L26:
        Throwable r30 = Result.exceptionOrNull-impl(r116);
        if (r30 == null) goto L29;
        FLogger.a.e(SvaSdkIPCService.TAG, "isVoiceWakeupEnabled(uid) failed: " + r30.getMessage());
    L29:
        Boolean r31 = Boxing.boxBoolean(false);
        if (Result.isFailure-impl(r116) == false) goto L32;
        r116 = r31;
    L32:
        r17 = ((Boolean) r116).booleanValue();
    L24:
        th = move-exception;
        Result.Companion r32 = Result.Companion;
        r116 = Result.constructor-impl(ResultKt.createFailure(th));
    L14:
        th = move-exception;
        Result.Companion r33 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    L96:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
