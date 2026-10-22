package com.bytedance.ai.widget.cache;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.widget.cache.WidgetResourceLoader", f = "WidgetResourceLoader.kt", i = {0}, l = {241}, m = "awaitRunApplet$suspendImpl", n = {"widgetContainerData"}, s = {"L$0"})
final class WidgetResourceLoader$awaitRunApplet$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WidgetResourceLoader this$0;

    public WidgetResourceLoader$awaitRunApplet$1(WidgetResourceLoader r1, Continuation<? super WidgetResourceLoader$awaitRunApplet$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return WidgetResourceLoader.i(this.this$0, null, this);
    }
}
