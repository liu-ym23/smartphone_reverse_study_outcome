package com.larus.vesdk.impl.camera;

import com.larus.utils.logger.FLogger;
import com.ss.android.vesdk.VERecorder;
import com.tencent.open.log.TraceLevel;
import java.util.UUID;
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
@DebugMetadata(c = "com.larus.vesdk.impl.camera.VeCameraImpl$startRecord$1", f = "VeCameraImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class VeCameraImpl$startRecord$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ pq9.g $callback;
    final /* synthetic */ boolean $enableAudio;
    final /* synthetic */ boolean $needEffect;
    int label;
    final /* synthetic */ VeCameraImpl this$0;

    public VeCameraImpl$startRecord$1(VeCameraImpl r1, boolean r2, boolean r3, pq9.g r4, Continuation<? super VeCameraImpl$startRecord$1> r5) {
        this.this$0 = r1;
        this.$enableAudio = r2;
        this.$needEffect = r3;
        this.$callback = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new VeCameraImpl$startRecord$1(this.this$0, this.$enableAudio, this.$needEffect, this.$callback, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r8);
        final VeCameraImpl r9 = this.this$0;
        VERecorder r0 = r9.d;
        if (r0 == null) goto L11;
        boolean r1 = this.$enableAudio;
        boolean r2 = this.$needEffect;
        final pq9.g r3 = this.$callback;
        r0.enableAudioRecorder(r1);
        c.a.getClass();
        StringBuilder r4 = new StringBuilder();
        pq9.k.a.getClass();
        r4.append(pq9.k.g);
        r4.append('/');
        r4.append(System.currentTimeMillis());
        r4.append('_');
        boolean r6 = false;
        r4.append(UUID.randomUUID().toString().substring(0, 8));
        r4.append(".mp4");
        String r5 = r4.toString();
        r9.e = r5;
        int r7 = r0.startRecord(r5, 1.0f);
        r9.E(new f0(r3, r9), false, r2);
        if (r7 != 0) goto L9;
        r6 = true;
    L9:
        r3.b(r6, r7);
        FLogger.a.i("VeCameraImpl", "[startRecord] result: " + r7 + ", path: " + r5);
    L11:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
