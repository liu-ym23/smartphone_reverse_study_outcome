package com.bytedance.ai.widget.cache;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.widget.cache.WidgetResourceLoader", f = "WidgetResourceLoader.kt", i = {0, 0, 0}, l = {117}, m = "loadTemplateBundleFromPackage$suspendImpl", n = {"$this", "packageName", "widgetId"}, s = {"L$0", "L$1", "L$2"})
public final class WidgetResourceLoader$loadTemplateBundleFromPackage$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WidgetResourceLoader this$0;

    public WidgetResourceLoader$loadTemplateBundleFromPackage$1(WidgetResourceLoader r1, Continuation<? super WidgetResourceLoader$loadTemplateBundleFromPackage$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return WidgetResourceLoader.m(this.this$0, this);
    }
}
