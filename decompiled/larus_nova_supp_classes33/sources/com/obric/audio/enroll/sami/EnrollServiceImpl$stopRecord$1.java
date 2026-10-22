package com.obric.audio.enroll.sami;

import com.larus.utils.logger.FLogger;
import com.mammon.audiosdk.SpeechFingerPrintEnrollService;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.enroll.sami.EnrollServiceImpl$stopRecord$1", f = "EnrollServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class EnrollServiceImpl$stopRecord$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $taskId;
    int label;

    public EnrollServiceImpl$stopRecord$1(String r1, Continuation<? super EnrollServiceImpl$stopRecord$1> r2) {
        this.$taskId = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new EnrollServiceImpl$stopRecord$1(this.$taskId, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L23;
        ResultKt.throwOnFailure(r7);
        SamiEnrollEngine r8 = SamiEnrollEngine.a;
        String r0 = this.$taskId;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r0, "taskId");
        FLogger r1 = FLogger.a;
        r1.i("SamiEnrollEngine", "stopRecord begin taskId=" + r0);
        if (StringsKt.isBlank(r0) == true) goto L18;
        if (SamiEnrollEngine.p.remove(r0) == true) goto L10;
        r1.i("SamiEnrollEngine", "stopRecord ignored: not started taskId=" + r0);
        goto L18
    L10:
        SamiEnrollEngine.q.remove(r0);
        SamiEnrollEngine.r.remove(r0);
        ReentrantLock r2 = SamiEnrollEngine.e;
        r2.lock();
        SpeechFingerPrintEnrollService r4 = SamiEnrollEngine.d;     // Catch: Throwable -> L19
        if (r4 == null) goto L14;
        int r5 = r4.stop(r0);     // Catch: Throwable -> L19
    L15:
        r1.i("SamiEnrollEngine", "stopRecord end taskId=" + r0 + " ret=" + r5);     // Catch: Throwable -> L19
        r2.unlock();
        goto L18
    L14:
        r5 = Integer.MIN_VALUE;
    L19:
        th = move-exception;
        SamiEnrollEngine.e.unlock();
        throw th;
    L18:
        return Unit.INSTANCE;
    L23:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
