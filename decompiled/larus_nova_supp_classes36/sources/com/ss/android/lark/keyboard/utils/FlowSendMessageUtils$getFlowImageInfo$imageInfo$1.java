package com.ss.android.lark.keyboard.utils;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.uploader.utils.ImageInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\t\u0018\u00010\u0001¢\u0006\u0002\b\u0002*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/image/uploader/utils/ImageInfo;", "Lkotlin/jvm/internal/EnhancedNullability;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.utils.FlowSendMessageUtils$getFlowImageInfo$imageInfo$1", f = "FlowSendMessageUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FlowSendMessageUtils$getFlowImageInfo$imageInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ImageInfo>, Object> {
    final /* synthetic */ String $filePath;
    int label;

    public FlowSendMessageUtils$getFlowImageInfo$imageInfo$1(String r1, Continuation<? super FlowSendMessageUtils$getFlowImageInfo$imageInfo$1> r2) {
        this.$filePath = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new FlowSendMessageUtils$getFlowImageInfo$imageInfo$1(this.$filePath, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super ImageInfo> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        return com.ss.android.lark.image.uploader.utils.b.d(this.$filePath, true, false);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
