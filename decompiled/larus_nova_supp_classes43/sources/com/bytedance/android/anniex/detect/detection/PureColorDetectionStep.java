package com.bytedance.android.anniex.detect.detection;

import com.bytedance.android.anniex.detect.FailureStage;
import com.bytedance.android.anniex.detect.c;
import com.bytedance.android.anniex.detect.f;
import com.bytedance.android.anniex.detect.h;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class PureColorDetectionStep implements h {
    public final long a;
    public final float b;

    public PureColorDetectionStep(long r1, float r10) {
        this.a = r1;
        this.b = r10;
    }

    @Override // com.bytedance.android.anniex.detect.h
    public final Object a(f r13, Continuation<? super c> r14) {
        if ((r14 instanceof PureColorDetectionStep$execute$1) == false) goto L7;
        PureColorDetectionStep$execute$1 r0 = (PureColorDetectionStep$execute$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = r0.label;
        if (r11 == 0) goto L14;
        if (r11 != 1) goto L13;
        long r12 = r0.J$0;
        Ref.ObjectRef r16 = (Ref.ObjectRef) r0.L$2;
        Ref.ObjectRef r17 = (Ref.ObjectRef) r0.L$1;
        f r18 = (f) r0.L$0;
        ResultKt.throwOnFailure(r15);
        Ref.ObjectRef r19 = r16;
        r13 = r18;
        Object r20 = r15;
    L18:
        Object r21 = (c) r20;
        if (r21 != null) goto L21;
        r21 = new c.a(1002, "PureColorDetection timeout", FailureStage.PureColorDetection);
        r13.b.f = true;
    L21:
        r19.element = r21;
        long r22 = System.currentTimeMillis() - r12;
        HybridLogger r110 = HybridLogger.a;
        HybridLogger.f("AnnieXBlankDetect", "纯色检测结束，检测耗时为 ：" + r22, null, 12);
        r13.b.g = Boxing.boxLong(r22);
        return r17.element;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        HybridLogger.f("AnnieXBlankDetect", "开启纯色检测", null, 12);
        r19 = new Ref.ObjectRef();
        long r23 = System.currentTimeMillis();
        long r24 = this.a;
        PureColorDetectionStep$execute$duration$1$1 r25 = new PureColorDetectionStep$execute$duration$1$1(r13, this, null);
        r0.L$0 = r13;
        r0.L$1 = r19;
        r0.L$2 = r19;
        r0.J$0 = r23;
        r0.label = 1;
        r20 = TimeoutKt.c(r24, r25, r0);
        if (r20 != r10) goto L17;
        return r10;
    L17:
        r12 = r23;
        r17 = r19;
    L7:
        r0 = new PureColorDetectionStep$execute$1(this, r14);
        goto L8
    }
}
