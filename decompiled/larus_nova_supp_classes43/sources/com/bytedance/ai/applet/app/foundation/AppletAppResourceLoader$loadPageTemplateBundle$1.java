package com.bytedance.ai.applet.app.foundation;

import com.bytedance.android.ec.base.api.ai.AIStateLogRequest;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.app.foundation.AppletAppResourceLoader", f = "AppletAppResourceLoader.kt", i = {0, 0, 1}, l = {97, 119}, m = "loadPageTemplateBundle-gIAlu-s", n = {AIStateLogRequest.SOURCE_PAGE, "cacheKey", "resourceUrl"}, s = {"L$0", "L$1", "L$0"})
public final class AppletAppResourceLoader$loadPageTemplateBundle$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppletAppResourceLoader this$0;

    public AppletAppResourceLoader$loadPageTemplateBundle$1(AppletAppResourceLoader r1, Continuation<? super AppletAppResourceLoader$loadPageTemplateBundle$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        Object r11 = this.this$0.e(null, this);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r11;
    L6:
        return Result.box-impl(r11);
    }
}
