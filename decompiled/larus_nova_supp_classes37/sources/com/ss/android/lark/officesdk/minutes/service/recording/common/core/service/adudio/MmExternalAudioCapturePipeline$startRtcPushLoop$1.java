package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio;

import android.os.SystemClock;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmExternalAudioCapturePipeline$startRtcPushLoop$1", f = "MmExternalAudioCapturePipeline.kt", i = {0, 0, 1, 1}, l = {423, 440}, m = "invokeSuspend", n = {"$this$launch", "nextPushTimeMs", "$this$launch", "nextPushTimeMs"}, s = {"L$0", "J$0", "L$0", "J$0"})
final class MmExternalAudioCapturePipeline$startRtcPushLoop$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    long J$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmExternalAudioCapturePipeline this$0;

    public MmExternalAudioCapturePipeline$startRtcPushLoop$1(MmExternalAudioCapturePipeline r1, Continuation<? super MmExternalAudioCapturePipeline$startRtcPushLoop$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MmExternalAudioCapturePipeline$startRtcPushLoop$1 r0 = new MmExternalAudioCapturePipeline$startRtcPushLoop$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 == 2) goto L9;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        long r4 = this.J$0;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r14);
    L13:
        if (CoroutineScopeKt.isActive(r2) == false) goto L47;
        if (this.this$0.i == true) goto L16;
        nub.a r6 = this.this$0.l;
        byte[] r7 = null;
        if (r6 == null) goto L40;
        MmExternalAudioCapturePipeline r8 = this.this$0;
        if (r8.c() > 0) goto L24;
        lvb.a.b("MmExternalAudioCapturePipeline", "Invalid rtcFrameBytes=" + r8.c());
        goto L40
    L24:
        Object r9 = r8.m;
        monitor-enter(r9);
        if (r8.r.length >= r8.c()) goto L30;
        monitor-exit(r9);
        goto L40
    L30:
        r7 = ArraysKt.copyOfRange(r8.r, 0, r8.c());     // Catch: Throwable -> L37
        if (r8.r.length <= r8.c()) goto L33;
        byte[] r10 = ArraysKt.copyOfRange(r8.r, r8.c(), r8.r.length);     // Catch: Throwable -> L37
    L34:
        r8.r = r10;     // Catch: Throwable -> L37
        monitor-exit(r9);
        goto L40
    L33:
        r10 = new byte[0];     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        throw th;
    L40:
        if (r6 == null) goto L43;
        if (r7 == null) goto L43;
        r6.i(r7, this.this$0.d(), this.this$0.e(), this.this$0.b());
    L43:
        r4 = r4 + ((long) 10);
        long r11 = RangesKt.coerceAtLeast(r4 - SystemClock.elapsedRealtime(), 0);
        this.L$0 = r2;
        this.J$0 = r4;
        this.label = 2;
        if (DelayKt.delay(r11, this) != r0) goto L13;
        return r0;
    L16:
        r4 = SystemClock.elapsedRealtime();
        this.L$0 = r2;
        this.J$0 = r4;
        this.label = 1;
        if (DelayKt.delay(10, this) != r0) goto L13;
        return r0;
    L47:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r14);
        CoroutineScope r15 = (CoroutineScope) this.L$0;
        r4 = SystemClock.elapsedRealtime();
        r2 = r15;
        goto L13
    }
}
