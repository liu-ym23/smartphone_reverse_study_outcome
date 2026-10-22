package com.larus.canvas.feature.component.logic;

import com.larus.image.loader.ImageLoaderKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.GenImagePlannerComponent$prefetchNoWatermarkBitmaps$1", f = "GenImagePlannerComponent.kt", i = {}, l = {1144}, m = "invokeSuspend", n = {}, s = {})
public final class GenImagePlannerComponent$prefetchNoWatermarkBitmaps$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String> $urls;
    Object L$0;
    int label;

    public GenImagePlannerComponent$prefetchNoWatermarkBitmaps$1(List<String> r1, Continuation<? super GenImagePlannerComponent$prefetchNoWatermarkBitmaps$1> r2) {
        this.$urls = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new GenImagePlannerComponent$prefetchNoWatermarkBitmaps$1(this.$urls, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Iterator r2 = (Iterator) this.L$0;
        ResultKt.throwOnFailure(r10);
    L10:
        if (r2.hasNext() == false) goto L15;
        String r3 = (String) r2.next();
        this.L$0 = r2;
        this.label = 1;
        if (ImageLoaderKt.C(r3, "canvas_pager_no_watermark_image_prefetch", null, null, this, 60) != r0) goto L10;
        return r0;
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        r2 = this.$urls.iterator();
        goto L10
    }
}
