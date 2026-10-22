package com.ss.android.lark.keyboard.utils;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.videosend.checker.VideoSendChecker;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/videosend/checker/VideoSendChecker$Result;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.utils.FlowSendMessageUtils$handleResourceBeforeUpload$result$1", f = "FlowSendMessageUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FlowSendMessageUtils$handleResourceBeforeUpload$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super VideoSendChecker.Result>, Object> {
    final /* synthetic */ String $localPath;
    int label;

    public FlowSendMessageUtils$handleResourceBeforeUpload$result$1(String r1, Continuation<? super FlowSendMessageUtils$handleResourceBeforeUpload$result$1> r2) {
        this.$localPath = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new FlowSendMessageUtils$handleResourceBeforeUpload$result$1(this.$localPath, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super VideoSendChecker.Result> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        return new VideoSendChecker(0).b(this.$localPath, false);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
