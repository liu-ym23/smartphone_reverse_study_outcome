package com.ss.android.lark.keyboard.utils;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.Target;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.utils.FlowSendMessageUtils", f = "FlowSendMessageUtils.kt", i = {0}, l = {154}, m = "getFlowImageInfo", n = {"filePath"}, s = {"L$0"})
public final class FlowSendMessageUtils$getFlowImageInfo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowSendMessageUtils this$0;

    public FlowSendMessageUtils$getFlowImageInfo$1(FlowSendMessageUtils r1, Continuation<? super FlowSendMessageUtils$getFlowImageInfo$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Target.SIZE_ORIGINAL;
        FlowSendMessageUtils r3 = this.this$0;
        FlowSendMessageUtils r0 = FlowSendMessageUtils.a;
        return r3.a(null, this);
    }
}
