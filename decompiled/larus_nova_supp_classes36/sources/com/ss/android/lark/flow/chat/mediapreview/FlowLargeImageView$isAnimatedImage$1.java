package com.ss.android.lark.flow.chat.mediapreview;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.Target;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.mediapreview.FlowLargeImageView", f = "FlowLargeImageView.kt", i = {}, l = {580}, m = "isAnimatedImage", n = {}, s = {})
public final class FlowLargeImageView$isAnimatedImage$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowLargeImageView this$0;

    public FlowLargeImageView$isAnimatedImage$1(FlowLargeImageView r1, Continuation<? super FlowLargeImageView$isAnimatedImage$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Target.SIZE_ORIGINAL;
        return this.this$0.g(this);
    }
}
