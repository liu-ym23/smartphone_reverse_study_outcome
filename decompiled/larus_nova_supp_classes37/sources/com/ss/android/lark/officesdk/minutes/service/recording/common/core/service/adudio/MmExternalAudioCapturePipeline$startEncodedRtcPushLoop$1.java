package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio;

import android.os.SystemClock;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmExternalAudioCapturePipeline$startEncodedRtcPushLoop$1", f = "MmExternalAudioCapturePipeline.kt", i = {0, 1, 2}, l = {465, 471, 476}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "$this$launch"}, s = {"L$0", "L$0", "L$0"})
final class MmExternalAudioCapturePipeline$startEncodedRtcPushLoop$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmExternalAudioCapturePipeline this$0;

    public MmExternalAudioCapturePipeline$startEncodedRtcPushLoop$1(MmExternalAudioCapturePipeline r1, Continuation<? super MmExternalAudioCapturePipeline$startEncodedRtcPushLoop$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MmExternalAudioCapturePipeline$startEncodedRtcPushLoop$1 r0 = new MmExternalAudioCapturePipeline$startEncodedRtcPushLoop$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L11;
        if (r2 == 1) goto L10;
        if (r2 == 2) goto L10;
        if (r2 == 3) goto L10;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        CoroutineScope r3 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r18);
    L13:
        if (CoroutineScopeKt.isActive(r3) == false) goto L49;
        if (this.this$0.i == true) goto L16;
        MmExternalAudioCapturePipeline r6 = this.this$0;
        Object r9 = r6.m;
        monitor-enter(r9);
        sub.a r10 = r6.s.pollFirst();     // Catch: Throwable -> L45
        if (r10 != null) goto L26;
        monitor-exit(r9);
        r10 = null;
    L31:
        if (r10 == null) goto L32;
        MmExternalAudioCapturePipeline r7 = this.this$0;
        nub.a r8 = r7.l;
        if (r8 == null) goto L38;
        r8.h(r10);
    L38:
        long r11 = SystemClock.elapsedRealtime();
        if ((r11 - r7.v) >= 3000) goto L43;
        r7.d.invoke(r10);
        long r12 = RangesKt.coerceAtLeast(0, 1);
        this.L$0 = r3;
        this.label = 3;
        if (DelayKt.delay(r12, this) != r0) goto L13;
        return r0;
    L43:
        r7.v = r11;
        throw null;
    L32:
        this.L$0 = r3;
        this.label = 2;
        if (DelayKt.delay(10, this) != r0) goto L13;
        return r0;
    L26:
        int r13 = r6.t - RangesKt.coerceAtLeast(0, 1);     // Catch: Throwable -> L45
        r6.t = r13;     // Catch: Throwable -> L45
        if (r13 >= 0) goto L29;
        r6.t = 0;     // Catch: Throwable -> L45
    L29:
        r6.s.isEmpty();     // Catch: Throwable -> L45
        monitor-exit(r9);
    L45:
        th = move-exception;
        throw th;
    L16:
        this.L$0 = r3;
        this.label = 1;
        if (DelayKt.delay(10, this) != r0) goto L13;
        return r0;
    L49:
        return Unit.INSTANCE;
    L11:
        ResultKt.throwOnFailure(r18);
        r3 = (CoroutineScope) this.L$0;
        lvb.a.e("MmExternalAudioCapturePipeline", "[encoded audio][pacer] start");
        goto L13
    }
}
