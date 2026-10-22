package com.larus.vesdk.impl.camera;

import com.larus.utils.logger.FLogger;
import com.ss.android.vesdk.VEGetFrameSettings;
import com.ss.android.vesdk.VERecorder;
import com.ss.android.vesdk.VESize;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
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
@DebugMetadata(c = "com.larus.vesdk.impl.camera.VeCameraImpl$getPreviewFrame$1", f = "VeCameraImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class VeCameraImpl$getPreviewFrame$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ pq9.e $callback;
    final /* synthetic */ VESize $resolution;
    int label;
    final /* synthetic */ VeCameraImpl this$0;

    public VeCameraImpl$getPreviewFrame$1(VeCameraImpl r1, VESize r2, pq9.e r3, Continuation<? super VeCameraImpl$getPreviewFrame$1> r4) {
        this.this$0 = r1;
        this.$resolution = r2;
        this.$callback = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new VeCameraImpl$getPreviewFrame$1(this.this$0, this.$resolution, this.$callback, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r5);
        VERecorder r6 = this.this$0.d;
        if (r6 == null) goto L11;
        VESize r0 = this.$resolution;
        final pq9.e r1 = this.$callback;
        int r7 = r6.getPreviewFrame(new VEGetFrameSettings.Builder().setEffectType(VEGetFrameSettings.VEGetFrameEffectType.FULL_EFFECT).setTargetResolution(r0).setGetBitmapFrameCallback(new y(r1)).build());
        if (r7 == 0) goto L9;
        r1.a(null);
    L9:
        FLogger.a.i("VeCameraImpl", "[getPreviewFrame] result:" + r7);
    L11:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
