package com.bytedance.ai.widget;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.widget.WidgetManager", f = "WidgetManager.kt", i = {0}, l = {406}, m = "createWidgetContainer", n = {"widgetContainer"}, s = {"L$0"})
public final class WidgetManager$createWidgetContainer$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WidgetManager this$0;

    public WidgetManager$createWidgetContainer$1(WidgetManager r1, Continuation<? super WidgetManager$createWidgetContainer$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        WidgetManager r11 = this.this$0;
        WidgetManager.a r0 = WidgetManager.h;
        return r11.j(null, this);
    }
}
