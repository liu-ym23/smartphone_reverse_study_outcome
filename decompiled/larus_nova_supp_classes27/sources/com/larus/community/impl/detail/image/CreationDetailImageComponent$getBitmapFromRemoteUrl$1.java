package com.larus.community.impl.detail.image;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.detail.image.CreationDetailImageComponent", f = "CreationDetailImageComponent.kt", i = {}, l = {181}, m = "getBitmapFromRemoteUrl", n = {}, s = {})
final class CreationDetailImageComponent$getBitmapFromRemoteUrl$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationDetailImageComponent this$0;

    public CreationDetailImageComponent$getBitmapFromRemoteUrl$1(CreationDetailImageComponent r1, Continuation<? super CreationDetailImageComponent$getBitmapFromRemoteUrl$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return CreationDetailImageComponent.F2(this.this$0, null, this);
    }
}
