package com.larus.vesdk.impl.camera;

import com.larus.utils.logger.FLogger;
import com.ss.android.vesdk.VERecorder;
import com.tencent.open.log.TraceLevel;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.vesdk.impl.camera.VeCameraImpl$stopRecord$1", f = "VeCameraImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class VeCameraImpl$stopRecord$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ pq9.f $callback;
    int label;
    final /* synthetic */ VeCameraImpl this$0;

    public VeCameraImpl$stopRecord$1(VeCameraImpl r1, pq9.f r2, Continuation<? super VeCameraImpl$stopRecord$1> r3) {
        this.this$0 = r1;
        this.$callback = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new VeCameraImpl$stopRecord$1(this.this$0, this.$callback, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.larus.vesdk.impl.camera.g0] */
    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r7);
        VeCameraImpl r8 = this.this$0;
        VERecorder r0 = r8.d;
        if (r0 == null) goto L10;
        final pq9.f r1 = this.$callback;
        r0.enableAudioRecorder(false);
        final String r3 = r8.e;
        final Pair<Integer, Integer> r4 = r8.s.b();
        r8.e = null;
        final AtomicBoolean r9 = new AtomicBoolean(false);
        final ?? r2 = new g0(r9, r3, r1, r4);
        int r10 = r0.stopRecord(new h0(r2));
        FLogger r5 = FLogger.a;
        r5.i("VeCameraImpl", "[stopRecord] result:" + r10);
        if (r10 == 0) goto L10;
        r5.e("VeCameraImpl", "[stopRecord] failed to stop, result:" + r10);
        r2.invoke();
    L10:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
