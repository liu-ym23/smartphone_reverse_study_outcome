package com.bytedance.ai.applet.app.foundation;

import com.bytedance.android.ec.base.api.ai.AIStateLogRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.app.foundation.AppletAppResourceLoader", f = "AppletAppResourceLoader.kt", i = {0, 0, 0, 0, 1, 1}, l = {187, 153}, m = "loadAndCachePageTemplateBundle", n = {AIStateLogRequest.SOURCE_PAGE, "cacheKey", "resourceUrl", "$this$withLock_u24default$iv", "cacheKey", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1"})
public final class AppletAppResourceLoader$loadAndCachePageTemplateBundle$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppletAppResourceLoader this$0;

    public AppletAppResourceLoader$loadAndCachePageTemplateBundle$1(AppletAppResourceLoader r1, Continuation<? super AppletAppResourceLoader$loadAndCachePageTemplateBundle$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        AppletAppResourceLoader r11 = this.this$0;
        int r0 = AppletAppResourceLoader.f;
        return r11.c(null, null, null, this);
    }
}
