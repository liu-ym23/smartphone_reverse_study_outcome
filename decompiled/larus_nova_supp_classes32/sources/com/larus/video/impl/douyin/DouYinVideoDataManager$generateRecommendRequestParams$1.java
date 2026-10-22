package com.larus.video.impl.douyin;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.video.impl.douyin.DouYinVideoDataManager", f = "DouYinVideoDataManager.kt", i = {}, l = {391}, m = "generateRecommendRequestParams", n = {}, s = {})
public final class DouYinVideoDataManager$generateRecommendRequestParams$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DouYinVideoDataManager this$0;

    public DouYinVideoDataManager$generateRecommendRequestParams$1(DouYinVideoDataManager r1, Continuation<? super DouYinVideoDataManager$generateRecommendRequestParams$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(this);
    }
}
