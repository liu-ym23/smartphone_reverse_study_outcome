package com.bytedance.ai.applet.app.foundation;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.app.foundation.AppletAppResourceLoader", f = "AppletAppResourceLoader.kt", i = {0}, l = {69}, m = "preloadHomePageTemplateBundle", n = {"homePage"}, s = {"L$0"})
final class AppletAppResourceLoader$preloadHomePageTemplateBundle$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppletAppResourceLoader this$0;

    public AppletAppResourceLoader$preloadHomePageTemplateBundle$1(AppletAppResourceLoader r1, Continuation<? super AppletAppResourceLoader$preloadHomePageTemplateBundle$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return AppletAppResourceLoader.b(this.this$0, this);
    }
}
