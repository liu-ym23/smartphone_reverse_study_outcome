package com.ss.android.lark.flow.chat.message.image;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.Target;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.message.image.FlowYunPanFileUtils", f = "FlowYunPanFileUtils.kt", i = {0, 0}, l = {290}, m = "driveDownloadImageInner", n = {"token", "localPath"}, s = {"L$0", "L$1"})
final class FlowYunPanFileUtils$driveDownloadImageInner$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowYunPanFileUtils this$0;

    public FlowYunPanFileUtils$driveDownloadImageInner$1(FlowYunPanFileUtils r1, Continuation<? super FlowYunPanFileUtils$driveDownloadImageInner$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Target.SIZE_ORIGINAL;
        return FlowYunPanFileUtils.a(this.this$0, null, null, this);
    }
}
