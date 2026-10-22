package com.ss.android.lark.flow.chat.message.image;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.Target;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.message.image.FlowImageLoaderUtils", f = "FlowImageLoaderUtils.kt", i = {0, 0, 0, 0}, l = {372, 379}, m = "downloadImageFile", n = {"context", "type", "photoItem", "isOnlyCache"}, s = {"L$0", "L$1", "L$2", "Z$0"})
final class FlowImageLoaderUtils$downloadImageFile$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ f this$0;

    public FlowImageLoaderUtils$downloadImageFile$1(f r1, Continuation<? super FlowImageLoaderUtils$downloadImageFile$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Target.SIZE_ORIGINAL;
        return f.a(this.this$0, null, null, null, false, this);
    }
}
