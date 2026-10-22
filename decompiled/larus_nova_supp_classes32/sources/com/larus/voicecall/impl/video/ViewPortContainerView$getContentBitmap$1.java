package com.larus.voicecall.impl.video;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.video.ViewPortContainerView", f = "ViewPortSwitcher.kt", i = {}, l = {559}, m = "getContentBitmap", n = {}, s = {})
final class ViewPortContainerView$getContentBitmap$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ViewPortContainerView this$0;

    public ViewPortContainerView$getContentBitmap$1(ViewPortContainerView r1, Continuation<? super ViewPortContainerView$getContentBitmap$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return ViewPortContainerView.a(this.this$0, 0.0f, 0.0f, this);
    }
}
