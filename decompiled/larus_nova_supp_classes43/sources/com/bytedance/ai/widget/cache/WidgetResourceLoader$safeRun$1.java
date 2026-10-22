package com.bytedance.ai.widget.cache;

import com.bytedance.ai.model.objects.Widget;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.widget.cache.WidgetResourceLoader", f = "WidgetResourceLoader.kt", i = {0}, l = {81}, m = "safeRun", n = {"$this$safeRun"}, s = {"L$0"})
public final class WidgetResourceLoader$safeRun$1<T> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WidgetResourceLoader this$0;

    public WidgetResourceLoader$safeRun$1(WidgetResourceLoader r1, Continuation<? super WidgetResourceLoader$safeRun$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        WidgetResourceLoader r11 = this.this$0;
        ConcurrentHashMap<String, CompletableDeferred<Widget>> r0 = WidgetResourceLoader.e;
        return r11.o(null, null, this);
    }
}
