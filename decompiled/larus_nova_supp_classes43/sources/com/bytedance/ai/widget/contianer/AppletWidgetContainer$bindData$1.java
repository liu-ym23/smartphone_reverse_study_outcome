package com.bytedance.ai.widget.contianer;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.widget.contianer.AppletWidgetContainer", f = "AppletWidgetContainer.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {323, 350, 396, 415}, m = "bindData", n = {"widgetContainerData", "pendingTracker", "resourceLoader", "widgetContainerData", "pendingTracker", "resourceLoader", "widgetInfo", "widgetContainerData", "pendingTracker", "resourceLoader", "widgetInfo"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
public final class AppletWidgetContainer$bindData$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppletWidgetContainer this$0;

    public AppletWidgetContainer$bindData$1(AppletWidgetContainer r1, Continuation<? super AppletWidgetContainer$bindData$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.y(null, null, this);
    }
}
