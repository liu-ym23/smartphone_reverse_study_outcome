package com.ss.android.lark.flow.chat.mediapreview;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.Target;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.mediapreview.FlowLargeImageLoadController", f = "FlowLargeImageLoadController.kt", i = {0, 0, 2}, l = {169, 175, 178}, m = "downloadOrigin", n = {"photoItem", "listener", "listener"}, s = {"L$0", "L$1", "L$0"})
public final class FlowLargeImageLoadController$downloadOrigin$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowLargeImageLoadController this$0;

    public FlowLargeImageLoadController$downloadOrigin$1(FlowLargeImageLoadController r1, Continuation<? super FlowLargeImageLoadController$downloadOrigin$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Target.SIZE_ORIGINAL;
        return this.this$0.c(null, null, this);
    }
}
