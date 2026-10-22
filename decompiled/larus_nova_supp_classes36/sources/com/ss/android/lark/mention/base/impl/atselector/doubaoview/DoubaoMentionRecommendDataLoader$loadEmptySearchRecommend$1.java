package com.ss.android.lark.mention.base.impl.atselector.doubaoview;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.Target;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.mention.base.impl.atselector.doubaoview.DoubaoMentionRecommendDataLoader", f = "DoubaoMentionRecommendDataLoader.kt", i = {0}, l = {37}, m = "loadEmptySearchRecommend-IoAF18A", n = {"$this$loadEmptySearchRecommend_IoAF18A_u24lambda_u241"}, s = {"L$0"})
public final class DoubaoMentionRecommendDataLoader$loadEmptySearchRecommend$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoubaoMentionRecommendDataLoader this$0;

    public DoubaoMentionRecommendDataLoader$loadEmptySearchRecommend$1(DoubaoMentionRecommendDataLoader r1, Continuation<? super DoubaoMentionRecommendDataLoader$loadEmptySearchRecommend$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Target.SIZE_ORIGINAL;
        Object r3 = this.this$0.a(this);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Result.box-impl(r3);
    }
}
