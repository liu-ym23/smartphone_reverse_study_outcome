package com.bytedance.android.anniex.detect;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/bytedance/android/anniex/detect/c;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.anniex.detect.DetectionPipeline$run$2", f = "DetectorConfig.kt", i = {}, l = {172}, m = "invokeSuspend", n = {}, s = {})
public final class DetectionPipeline$run$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super c>, Object> {
    final /* synthetic */ f $context;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DetectionPipeline this$0;

    public DetectionPipeline$run$2(DetectionPipeline r1, f r10, Continuation<? super DetectionPipeline$run$2> r11) {
        this.this$0 = r1;
        this.$context = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        DetectionPipeline$run$2 r0 = new DetectionPipeline$run$2(this.this$0, this.$context, r11);
        r0.L$0 = r10;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super c> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        Object r10 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L15:
        DetectionPipeline r11 = this.this$0;
        Iterator r14 = ((List) r13).iterator();
    L17:
        if (r14.hasNext() == false) goto L21;
        Object r12 = r14.next();
        if (((Boolean) r11.c.invoke(((Pair) r12).getSecond())).booleanValue() == false) goto L17;
        r10 = r12;
    L21:
        Pair r15 = (Pair) r10;
        if (r15 == null) goto L26;
        c r16 = (c) r15.getSecond();
        if (r16 == null) goto L26;
        return r16;
    L26:
        return new c.C0092c();
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        CoroutineScope r17 = (CoroutineScope) this.L$0;
        List<h> r18 = this.this$0.a;
        f r19 = this.$context;
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));
        Iterator<T> r20 = r18.iterator();
    L10:
        if (r20.hasNext() == false) goto L12;
        r110.add(BuildersKt.async$default(r17, null, null, new DetectionPipeline$run$2$results$1$1((h) r20.next(), r19, null), 3, null));
        goto L10
    L12:
        this.label = 1;
        r13 = AwaitKt.a(r110, this);
        if (r13 != r0) goto L15;
        return r0;
    }
}
