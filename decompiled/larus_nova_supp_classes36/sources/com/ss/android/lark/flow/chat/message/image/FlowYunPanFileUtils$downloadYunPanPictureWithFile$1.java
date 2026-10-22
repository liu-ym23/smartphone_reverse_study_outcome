package com.ss.android.lark.flow.chat.message.image;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.Target;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.message.image.FlowYunPanFileUtils", f = "FlowYunPanFileUtils.kt", i = {0, 0}, l = {121}, m = "downloadYunPanPictureWithFile", n = {"token", "startTime"}, s = {"L$0", "J$0"})
public final class FlowYunPanFileUtils$downloadYunPanPictureWithFile$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowYunPanFileUtils this$0;

    public FlowYunPanFileUtils$downloadYunPanPictureWithFile$1(FlowYunPanFileUtils r1, Continuation<? super FlowYunPanFileUtils$downloadYunPanPictureWithFile$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Target.SIZE_ORIGINAL;
        return this.this$0.e(null, null, false, this);
    }
}
