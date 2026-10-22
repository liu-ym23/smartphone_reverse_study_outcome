package com.ss.android.lark.flow.chat.mediapreview;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.Target;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.mediapreview.FlowLargeImageView", f = "FlowLargeImageView.kt", i = {0}, l = {372}, m = "loadLargeImageFlow", n = {"info"}, s = {"L$0"})
public final class FlowLargeImageView$loadLargeImageFlow$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowLargeImageView this$0;

    public FlowLargeImageView$loadLargeImageFlow$1(FlowLargeImageView r1, Continuation<? super FlowLargeImageView$loadLargeImageFlow$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Target.SIZE_ORIGINAL;
        FlowLargeImageView r3 = this.this$0;
        int r0 = FlowLargeImageView.o;
        return r3.y(null, this);
    }
}
