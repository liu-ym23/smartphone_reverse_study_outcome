package com.bytedance.android.anniex.detect.detection;

import android.graphics.Bitmap;
import com.bytedance.android.anniex.detect.c;
import com.bytedance.android.anniex.detect.f;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/bytedance/android/anniex/detect/c;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.anniex.detect.detection.PureColorDetectionStep$execute$duration$1$1", f = "PureColorDetectionStep.kt", i = {}, l = {35}, m = "invokeSuspend", n = {}, s = {})
public final class PureColorDetectionStep$execute$duration$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super c>, Object> {
    final /* synthetic */ f $context;
    int label;
    final /* synthetic */ PureColorDetectionStep this$0;

    /* JADX INFO: renamed from: com.bytedance.android.anniex.detect.detection.PureColorDetectionStep$execute$duration$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/bytedance/android/anniex/detect/c;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.anniex.detect.detection.PureColorDetectionStep$execute$duration$1$1$1", f = "PureColorDetectionStep.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super c>, Object> {
        final /* synthetic */ f $context;
        int label;
        final /* synthetic */ PureColorDetectionStep this$0;

        public AnonymousClass1(f r1, PureColorDetectionStep r10, Continuation<? super AnonymousClass1> r11) {
            this.$context = r1;
            this.this$0 = r10;
            super(2, r11);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.$context, this.this$0, r11);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
            return invoke((CoroutineScope) r1, (Continuation) r10);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super c> r10) {
            return create(r1, r10).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r14) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L30;
            ResultKt.throwOnFailure(r14);
            Bitmap r15 = this.$context.a;
            Intrinsics.checkNotNullParameter(r15, "bitmap");
            int r0 = 0;
            int r1 = r15.getPixel(0, 0);
            IntProgression r10 = RangesKt.step(RangesKt.until(0, r15.getHeight()), 10);
            int r11 = r10.getFirst();
            int r12 = r10.getLast();
            int r13 = r10.getStep();
            if (r13 <= 0) goto L7;
            if (r11 > r12) goto L7;
        L9:
            int r16 = 0;
            int r17 = 0;
        L10:
            IntProgression r18 = RangesKt.step(RangesKt.until(0, r15.getWidth()), 10);
            int r19 = r18.getFirst();
            int r110 = r18.getLast();
            int r20 = r18.getStep();
            if (r20 <= 0) goto L13;
            if (r19 > r110) goto L13;
        L15:
            r16 = r16 + 1;
            if (r15.getPixel(r19, r11) != r1) goto L18;
            r17 = r17 + 1;
        L18:
            if (r19 == r110) goto L20;
            r19 = r19 + r20;
        L20:
            if (r11 == r12) goto L22;
            r11 = r11 + r13;
            goto L10
        L22:
            r0 = r17;
        L24:
            float r111 = r0 / r16;
            HybridLogger r21 = HybridLogger.a;
            HybridLogger.f("AnnieXBlankDetect", "纯色检测概率为：" + r111, null, 12);
            if (r111 <= this.this$0.b) goto L28;
            HybridLogger.i("AnnieXBlankDetect", "纯色白屏检测异常，probability：" + r111, null, 12);
            c.b r22 = new c.b(r111);
            this.$context.b.e = true;
            return r22;
        L28:
            return new c.C0092c();
        L13:
            if (r20 >= 0) goto L20;
            if (r110 > r19) goto L20;
        L7:
            if (r13 >= 0) goto L23;
            if (r12 <= r11) goto L9;
        L23:
            r16 = 0;
            goto L24
        L30:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public PureColorDetectionStep$execute$duration$1$1(f r1, PureColorDetectionStep r10, Continuation<? super PureColorDetectionStep$execute$duration$1$1> r11) {
        this.$context = r1;
        this.this$0 = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new PureColorDetectionStep$execute$duration$1$1(this.$context, this.this$0, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super c> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        CoroutineDispatcher r11 = Dispatchers.getDefault();
        AnonymousClass1 r12 = new AnonymousClass1(this.$context, this.this$0, null);
        this.label = 1;
        r10 = BuildersKt.withContext(r11, r12, this);
        if (r10 != r0) goto L11;
        return r0;
    }
}
