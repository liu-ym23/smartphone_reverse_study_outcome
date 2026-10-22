package com.bytedance.android.anniex.detect.detection;

import android.graphics.Bitmap;
import com.bytedance.android.anniex.detect.FailureStage;
import com.bytedance.android.anniex.detect.c;
import com.bytedance.android.anniex.detect.f;
import com.bytedance.android.anniex.detect.h;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import ga.e;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class PartialBlankDetectionStep implements h {
    public final long a;
    public final Function3<Bitmap, e, Continuation<? super Unit>, Object> b;

    /* JADX WARN: Multi-variable type inference failed */
    public PartialBlankDetectionStep(long r10, Function3<? super Bitmap, ? super e, ? super Continuation<? super Unit>, ? extends Object> r11) {
        Intrinsics.checkNotNullParameter(r11, "checker");
        this.a = r10;
        this.b = r11;
    }

    @Override // com.bytedance.android.anniex.detect.h
    public final Object a(f r18, Continuation<? super c> r19) {
        f r1 = r18;
        if ((r19 instanceof PartialBlankDetectionStep$execute$1) == false) goto L7;
        PartialBlankDetectionStep$execute$1 r10 = (PartialBlankDetectionStep$execute$1) r19;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r10.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r10.label;
        if (r14 == 0) goto L16;
        if (r14 == 1) goto L15;
        if (r14 != 2) goto L14;
        ResultKt.throwOnFailure(r12);
    L25:
        return r12;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r15 = r10.J$0;
        Deferred r16 = (CompletableDeferred) r10.L$1;
        f r17 = (f) r10.L$0;
        ResultKt.throwOnFailure(r12);
        Deferred r20 = r16;
        r1 = r17;
        Object r21 = r12;
    L20:
        if (((c) r21) != null) goto L22;
        c.a r22 = new c.a(1004, "PartialBlankDetection timeout", FailureStage.PartialBlankDetection);
        r1.b.j = true;
        Boxing.boxBoolean(r20.complete(r22));
    L22:
        long r110 = System.currentTimeMillis() - r15;
        r1.b.k = Boxing.boxLong(r110);
        HybridLogger r23 = HybridLogger.a;
        HybridLogger.f("AnnieXBlankDetect", "半白屏检测结束，检测耗时为 ：" + r110, null, 12);
        r10.L$0 = null;
        r10.L$1 = null;
        r10.label = 2;
        r12 = r20.await(r10);
        if (r12 != r13) goto L25;
        return r13;
    L16:
        ResultKt.throwOnFailure(r12);
        HybridLogger.f("AnnieXBlankDetect", "开启半白屏检测", null, 12);
        r20 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        r15 = System.currentTimeMillis();
        long r111 = this.a;
        PartialBlankDetectionStep$execute$duration$1$1 r24 = new PartialBlankDetectionStep$execute$duration$1$1(this, r1, r20, null);
        r10.L$0 = r1;
        r10.L$1 = r20;
        r10.J$0 = r15;
        r10.label = 1;
        r21 = TimeoutKt.c(r111, r24, r10);
        if (r21 != r13) goto L20;
        return r13;
    L7:
        r10 = new PartialBlankDetectionStep$execute$1(this, r19);
        goto L8
    }
}
