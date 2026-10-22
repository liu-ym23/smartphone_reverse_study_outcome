package com.bytedance.ai.widget.contianer;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.widget.contianer.AppletWidgetContainer", f = "AppletWidgetContainer.kt", i = {}, l = {528}, m = "bindDataByType", n = {}, s = {})
public final class AppletWidgetContainer$bindDataByType$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppletWidgetContainer this$0;

    public AppletWidgetContainer$bindDataByType$1(AppletWidgetContainer r1, Continuation<? super AppletWidgetContainer$bindDataByType$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        AppletWidgetContainer r11 = this.this$0;
        int r0 = AppletWidgetContainer.O;
        return r11.z(null, null, this);
    }
}
