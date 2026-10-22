package com.larus.canvas.feature.component.logic;

import com.larus.im.bean.message.ImageData;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.GenImagePlannerComponent$prepareNoWatermarkBlocksForDisplay$2", f = "GenImagePlannerComponent.kt", i = {}, l = {1097}, m = "invokeSuspend", n = {}, s = {})
final class GenImagePlannerComponent$prepareNoWatermarkBlocksForDisplay$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ List<ImageData> $images;
    int label;

    public GenImagePlannerComponent$prepareNoWatermarkBlocksForDisplay$2(List<ImageData> r1, Continuation<? super GenImagePlannerComponent$prepareNoWatermarkBlocksForDisplay$2> r2) {
        this.$images = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new GenImagePlannerComponent$prepareNoWatermarkBlocksForDisplay$2(this.$images, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        return r4;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        CreationNoWatermarkManager r5 = CreationNoWatermarkManager.a;
        List<ImageData> r2 = this.$images;
        this.label = 1;
        r4 = r5.q(r2, "canvas_success_display", this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
