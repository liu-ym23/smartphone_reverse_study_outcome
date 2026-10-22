package com.bytedance.ai.lite.widget.cache;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.lite.widget.cache.LiteWidgetResourceLoader", f = "LiteWidgetResourceLoader.kt", i = {}, l = {76}, m = "loadTemplateBundleFromPackage", n = {}, s = {})
public final class LiteWidgetResourceLoader$loadTemplateBundleFromPackage$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LiteWidgetResourceLoader this$0;

    public LiteWidgetResourceLoader$loadTemplateBundleFromPackage$1(LiteWidgetResourceLoader r1, Continuation<? super LiteWidgetResourceLoader$loadTemplateBundleFromPackage$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.l(this);
    }
}
