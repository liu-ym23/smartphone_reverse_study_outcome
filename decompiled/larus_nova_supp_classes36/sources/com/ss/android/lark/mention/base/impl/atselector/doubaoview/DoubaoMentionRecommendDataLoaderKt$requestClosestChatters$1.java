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
@DebugMetadata(c = "com.ss.android.lark.mention.base.impl.atselector.doubaoview.DoubaoMentionRecommendDataLoaderKt", f = "DoubaoMentionRecommendDataLoader.kt", i = {}, l = {165}, m = "requestClosestChatters", n = {}, s = {})
final class DoubaoMentionRecommendDataLoaderKt$requestClosestChatters$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    public DoubaoMentionRecommendDataLoaderKt$requestClosestChatters$1(Continuation<? super DoubaoMentionRecommendDataLoaderKt$requestClosestChatters$1> r1) {
        super(r1);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Target.SIZE_ORIGINAL;
        Object r3 = g.a(this);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Result.box-impl(r3);
    }
}
