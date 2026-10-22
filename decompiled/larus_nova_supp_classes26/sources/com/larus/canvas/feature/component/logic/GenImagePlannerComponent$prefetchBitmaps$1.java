package com.larus.canvas.feature.component.logic;

import com.larus.im.bean.message.ImageData;
import com.larus.im.bean.message.ImageObj;
import com.larus.image.loader.ImageLoaderKt;
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
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.GenImagePlannerComponent$prefetchBitmaps$1", f = "GenImagePlannerComponent.kt", i = {}, l = {968, 969}, m = "invokeSuspend", n = {}, s = {})
final class GenImagePlannerComponent$prefetchBitmaps$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $previewUrl;
    final /* synthetic */ ky8.f $task;
    int label;

    public GenImagePlannerComponent$prefetchBitmaps$1(ky8.f r1, String r2, Continuation<? super GenImagePlannerComponent$prefetchBitmaps$1> r3) {
        this.$task = r1;
        this.$previewUrl = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new GenImagePlannerComponent$prefetchBitmaps$1(this.$task, this.$previewUrl, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r11);
    L23:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r11);
    L19:
        String r3 = this.$previewUrl;
        this.label = 2;
        if (ImageLoaderKt.C(r3, "canvas_pager_image_prefetch", null, null, this, 60) != r0) goto L23;
        return r0;
    L10:
        ResultKt.throwOnFailure(r11);
        ImageData r12 = this.$task.h();
        if (r12 == null) goto L15;
        ImageObj r13 = r12.imageThumb;
        if (r13 == null) goto L15;
        String r14 = r13.url;
    L16:
        this.label = 1;
        if (ImageLoaderKt.C(r14, "canvas_pager_image_thumb_prefetch", null, null, this, 60) != r0) goto L19;
        return r0;
    L15:
        r14 = null;
        goto L16
    }
}
