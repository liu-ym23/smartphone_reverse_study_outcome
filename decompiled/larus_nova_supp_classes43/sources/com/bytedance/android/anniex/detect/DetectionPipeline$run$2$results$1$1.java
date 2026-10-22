package com.bytedance.android.anniex.detect;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Pair;", "Lcom/bytedance/android/anniex/detect/h;", "Lcom/bytedance/android/anniex/detect/c;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.anniex.detect.DetectionPipeline$run$2$results$1$1", f = "DetectorConfig.kt", i = {}, l = {172}, m = "invokeSuspend", n = {}, s = {})
public final class DetectionPipeline$run$2$results$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends h, ? extends c>>, Object> {
    final /* synthetic */ f $context;
    final /* synthetic */ h $step;
    Object L$0;
    int label;

    public DetectionPipeline$run$2$results$1$1(h r1, f r10, Continuation<? super DetectionPipeline$run$2$results$1$1> r11) {
        this.$step = r1;
        this.$context = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new DetectionPipeline$run$2$results$1$1(this.$step, this.$context, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Pair<? extends h, ? extends c>> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        h r11 = (h) this.L$0;
        ResultKt.throwOnFailure(r10);
    L13:
        return TuplesKt.to(r11, r10);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        h r12 = this.$step;
        f r13 = this.$context;
        this.L$0 = r12;
        this.label = 1;
        Object r14 = r12.a(r13, this);
        if (r14 != r0) goto L11;
        return r0;
    L11:
        r11 = r12;
        r10 = r14;
        goto L13
    }
}
