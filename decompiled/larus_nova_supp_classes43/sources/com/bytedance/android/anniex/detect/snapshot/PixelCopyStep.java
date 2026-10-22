package com.bytedance.android.anniex.detect.snapshot;

import com.bytedance.android.anniex.detect.j;
import com.bytedance.android.anniex.detect.k;
import com.bytedance.android.anniex.detect.m;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class PixelCopyStep implements m {
    public final long a;
    public final float b;

    public PixelCopyStep(long r1, float r10) {
        this.a = r1;
        this.b = r10;
    }

    @Override // com.bytedance.android.anniex.detect.m
    public final Object a(j r12, Continuation<? super k> r13) {
        if ((r13 instanceof PixelCopyStep$execute$1) == false) goto L7;
        PixelCopyStep$execute$1 r0 = (PixelCopyStep$execute$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = r0.label;
        if (r11 == 0) goto L18;
        if (r11 != 1) goto L17;
        StringBuilder r15 = (StringBuilder) r0.L$1;
        PixelCopyStep r16 = (PixelCopyStep) r0.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Exception -> L14 TimeoutCancellationException -> L30
    L22:
        return r14;
    L14:
        Exception e = e;
    L25:
        HybridLogger r17 = HybridLogger.a;
        HybridLogger.i("AnnieXBlankDetect", "PixelCopy exception:" + e.getMessage() + ", captureLog: " + r15, null, 12);
        return new k(false, "PixelCopy exception:" + e.getMessage() + ", captureLog: " + r15);
    L28:
        String r18 = "PixelCopy timeout after " + r16.a + "ms, captureLog: " + r15;
        HybridLogger.i("AnnieXBlankDetect", r18, null, 12);
        return new k(false, r18);
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r14);
        HybridLogger.f("AnnieXBlankDetect", "开始截图", null, 12);
        StringBuilder r19 = new StringBuilder();
        long r20 = this.a;     // Catch: Exception -> L23 TimeoutCancellationException -> L27
        PixelCopyStep$execute$2 r21 = new PixelCopyStep$execute$2(r12, this, r19, null);     // Catch: Exception -> L23 TimeoutCancellationException -> L27
        r0.L$0 = this;     // Catch: Exception -> L23 TimeoutCancellationException -> L27
        r0.L$1 = r19;     // Catch: Exception -> L23 TimeoutCancellationException -> L27
        r0.label = 1;     // Catch: Exception -> L23 TimeoutCancellationException -> L27
        r14 = TimeoutKt.b(r20, r21, r0);     // Catch: Exception -> L23 TimeoutCancellationException -> L27
        if (r14 != r10) goto L22;
        return r10;
    L27:
        r16 = this;
        r15 = r19;
    L23:
        e = move-exception;
        e = e;
        r15 = r19;
    L7:
        r0 = new PixelCopyStep$execute$1(this, r13);
        goto L8
    }
}
