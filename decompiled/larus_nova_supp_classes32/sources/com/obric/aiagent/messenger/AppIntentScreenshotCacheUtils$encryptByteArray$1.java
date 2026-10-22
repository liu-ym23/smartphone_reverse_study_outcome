package com.obric.aiagent.messenger;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.AppIntentScreenshotCacheUtils", f = "AppIntentScreenshotCacheUtils.kt", i = {}, l = {289}, m = "encryptByteArray", n = {}, s = {})
public final class AppIntentScreenshotCacheUtils$encryptByteArray$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppIntentScreenshotCacheUtils this$0;

    public AppIntentScreenshotCacheUtils$encryptByteArray$1(AppIntentScreenshotCacheUtils r1, Continuation<? super AppIntentScreenshotCacheUtils$encryptByteArray$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        AppIntentScreenshotCacheUtils r3 = this.this$0;
        AppIntentScreenshotCacheUtils r0 = AppIntentScreenshotCacheUtils.a;
        return r3.b(null, null, this);
    }
}
