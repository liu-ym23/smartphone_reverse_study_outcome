package com.bytedance.android.anniex.detect;

import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/bytedance/android/anniex/detect/g;", "", "e", "", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.anniex.detect.AnnieXBlankDetector$asFlow$2", f = "AnnieXBlankDetector.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
final class AnnieXBlankDetector$asFlow$2 extends SuspendLambda implements Function3<FlowCollector<? super g>, Throwable, Continuation<? super Unit>, Object> {
    final /* synthetic */ g $detectionStatus;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public AnnieXBlankDetector$asFlow$2(g r1, Continuation<? super AnnieXBlankDetector$asFlow$2> r10) {
        this.$detectionStatus = r1;
        super(3, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10, Object r11) {
        return invoke((FlowCollector) r1, (Throwable) r10, (Continuation) r11);
    }

    public final Object invoke(FlowCollector<? super g> r10, Throwable r11, Continuation<? super Unit> r12) {
        AnnieXBlankDetector$asFlow$2 r0 = new AnnieXBlankDetector$asFlow$2(this.$detectionStatus, r12);
        r0.L$0 = r10;
        r0.L$1 = r11;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        FlowCollector r11 = (FlowCollector) this.L$0;
        Throwable r12 = (Throwable) this.L$1;
        HybridLogger r13 = HybridLogger.a;
        HybridLogger.i("AnnieXBlankDetect", "检测异常: " + r12.getMessage(), null, 12);
        g r14 = this.$detectionStatus;
        r14.a = false;
        StringBuilder r15 = r14.m;
        r15.append("Detection EXCEPTION: " + r12.getMessage());
        r15.append('\n');
        this.L$0 = null;
        this.label = 1;
        if (r11.emit(r14, this) != r0) goto L12;
        return r0;
    }
}
