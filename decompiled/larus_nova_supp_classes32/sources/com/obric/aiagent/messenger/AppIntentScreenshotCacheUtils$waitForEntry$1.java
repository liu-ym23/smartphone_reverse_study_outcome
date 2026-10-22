package com.obric.aiagent.messenger;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.AppIntentScreenshotCacheUtils", f = "AppIntentScreenshotCacheUtils.kt", i = {0, 0, 0}, l = {245}, m = "waitForEntry", n = {"messageIdKey", "questionIdKey", "deadline"}, s = {"L$0", "L$1", "J$0"})
public final class AppIntentScreenshotCacheUtils$waitForEntry$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppIntentScreenshotCacheUtils this$0;

    public AppIntentScreenshotCacheUtils$waitForEntry$1(AppIntentScreenshotCacheUtils r1, Continuation<? super AppIntentScreenshotCacheUtils$waitForEntry$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        AppIntentScreenshotCacheUtils r3 = this.this$0;
        AppIntentScreenshotCacheUtils r0 = AppIntentScreenshotCacheUtils.a;
        return r3.j(null, null, this);
    }
}
