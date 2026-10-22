package com.obric.audio.enroll;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.audio.ObricEnrollInteropDelegate;
import com.obric.assistant.utils.j;
import com.obric.audio.enroll.sami.SamiEnrollEngine;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.enroll.VoiceEnrollServiceImpl$clearVoicePrintForUidInternal$1", f = "VoiceEnrollServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class VoiceEnrollServiceImpl$clearVoicePrintForUidInternal$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Boolean, Unit> $callback;
    final /* synthetic */ boolean $clearLegacyDefaultVoicePrint;
    final /* synthetic */ String $uid;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ VoiceEnrollServiceImpl this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public VoiceEnrollServiceImpl$clearVoicePrintForUidInternal$1(VoiceEnrollServiceImpl r1, String r2, Function1<? super Boolean, Unit> r3, boolean r4, Continuation<? super VoiceEnrollServiceImpl$clearVoicePrintForUidInternal$1> r5) {
        this.this$0 = r1;
        this.$uid = r2;
        this.$callback = r3;
        this.$clearLegacyDefaultVoicePrint = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        VoiceEnrollServiceImpl$clearVoicePrintForUidInternal$1 r6 = new VoiceEnrollServiceImpl$clearVoicePrintForUidInternal$1(this.this$0, this.$uid, this.$callback, this.$clearLegacyDefaultVoicePrint, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L67;
        ResultKt.throwOnFailure(r13);
        CoroutineScope r14 = (CoroutineScope) this.L$0;
        VoiceEnrollServiceImpl r15 = this.this$0;
        VoiceEnrollServiceImpl.b r5 = VoiceEnrollServiceImpl.k;
        r15.getClass();
        VoiceEnrollServiceImpl.C();
        FLogger.a.i("VoiceEnrollServiceImpl", "clearVoicePrintForUid uid=" + j.d(this.$uid));
        Ref.IntRef r16 = new Ref.IntRef();
        Object r6 = this.this$0.c;
        boolean r7 = this.$clearLegacyDefaultVoicePrint;
        String r8 = this.$uid;
        monitor-enter(r6);
        if (r7 == true) goto L71;
    L8:
        VoiceEnrollServiceImpl.A(r8, "clear default voice print");     // Catch: Throwable -> L63
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L11
        SamiEnrollEngine.a.getClass();     // Catch: Throwable -> L11
        Object r10 = Result.constructor-impl(Boxing.boxInt(SamiEnrollEngine.l(r8)));     // Catch: Throwable -> L11
    L13:
        Throwable r11 = Result.exceptionOrNull-impl(r10);     // Catch: Throwable -> L63
        if (r11 == null) goto L16;
        FLogger.a.e("VoiceEnrollServiceImpl", "clearVoicePrintForUid local delete failed uid=" + j.d(r8) + ": " + r11.getMessage());     // Catch: Throwable -> L63
    L16:
        Integer r12 = Boxing.boxInt(Integer.MIN_VALUE);     // Catch: Throwable -> L63
        if (Result.isFailure-impl(r10) == false) goto L19;
        r10 = r12;
    L19:
        r16.element = ((Number) r10).intValue();     // Catch: Throwable -> L63
        FLogger.a.i("VoiceEnrollServiceImpl", "clearVoicePrintForUid local ret=" + r16.element + " uid=" + j.d(r8));     // Catch: Throwable -> L63
        pia.d.k(r8);     // Catch: Throwable -> L63
        Intrinsics.checkNotNullParameter(r8, "uid");     // Catch: Throwable -> L63
        if (StringsKt.isBlank(r8) == true) goto L23;
        pia.d.i().erase("default_voice_print_mic0_recorded_".concat(r8));     // Catch: Throwable -> L63
    L23:
        pia.d.m(r8);     // Catch: Throwable -> L63
        VoiceEnrollServiceImpl.D(r8, "delete", "clear_voice_print_for_uid intent");     // Catch: Throwable -> L63
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L63
        monitor-exit(r6);
        String r18 = this.$uid;
        VoiceEnrollServiceImpl r3 = this.this$0;
        int r19 = 0;
        ObricEnrollInteropDelegate r20 = ObricEnrollInteropDelegate.b;     // Catch: Throwable -> L28
        r20.n(r18, false);     // Catch: Throwable -> L28
        r20.z(r18);     // Catch: Throwable -> L28
        VoiceEnrollServiceImpl.v(r3, r18);     // Catch: Throwable -> L28
        Object r110 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L28
    L30:
        Throwable r111 = Result.exceptionOrNull-impl(r110);
        if (r111 == null) goto L33;
        FLogger.a.e("VoiceEnrollServiceImpl", "clearVoicePrintForUid update per-uid settings failed: " + r111.getMessage());
    L33:
        Function1<Boolean, Unit> r112 = this.$callback;
        if (r112 == null) goto L36;
        r112.invoke(Boxing.boxBoolean(true));
    L36:
        VoiceEnrollServiceImpl r113 = this.this$0;
        Object r4 = r113.c;
        String r21 = this.$uid;
        monitor-enter(r4);
        String r22 = pia.d.d(r21);     // Catch: Throwable -> L60
        if (Intrinsics.areEqual(r22, "delete") == true) goto L73;
        FLogger.a.i("VoiceEnrollServiceImpl", "clearVoicePrintForUid online phase skip: desired=" + r22 + " uid=" + j.d(r21));     // Catch: Throwable -> L60
    L55:
        monitor-exit(r4);
        if (r19 == 0) goto L59;
        this.this$0.E(this.$uid, "clear_voice_print_for_uid_retry");
    L59:
        return Unit.INSTANCE;
    L73:
        SamiEnrollEngine.a.getClass();     // Catch: Throwable -> L44
        Object r2 = Result.constructor-impl(Boxing.boxInt(SamiEnrollEngine.m(r21)));     // Catch: Throwable -> L44
    L46:
        Throwable r23 = Result.exceptionOrNull-impl(r2);     // Catch: Throwable -> L60
        if (r23 == null) goto L49;
        FLogger.a.e("VoiceEnrollServiceImpl", "clearVoicePrintForUid online delete failed uid=" + j.d(r21) + ": " + r23.getMessage());     // Catch: Throwable -> L60
    L49:
        Integer r1 = Boxing.boxInt(Integer.MIN_VALUE);     // Catch: Throwable -> L60
        if (Result.isFailure-impl(r2) == false) goto L52;
        r2 = r1;
    L52:
        r19 = ((Number) r2).intValue();     // Catch: Throwable -> L60
        FLogger.a.i("VoiceEnrollServiceImpl", "clearVoicePrintForUid online ret=" + r19 + " uid=" + j.d(r21));     // Catch: Throwable -> L60
        if (r19 != 0) goto L55;
        VoiceEnrollServiceImpl.w(r113, r21, "delete", "clear_voice_print_for_uid online_success");     // Catch: Throwable -> L60
        goto L55
    L44:
        th = move-exception;
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L60
        r2 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L60
    L60:
        th = move-exception;
        throw th;
    L28:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r110 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L30
    L11:
        th = move-exception;
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L63
        r10 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L63
    L63:
        th = move-exception;
        throw th;
    L71:
        VoiceEnrollServiceImpl.k.getClass();     // Catch: Throwable -> L63
        VoiceEnrollServiceImpl.b.b("clear default voice print");     // Catch: Throwable -> L63
        goto L8
    L67:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
