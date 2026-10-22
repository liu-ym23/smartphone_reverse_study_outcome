package com.obric.aiagent.messenger;

import com.mammon.speechaudiosdk.session.type.SpeechEvent;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.AppIntentScreenshotCacheUtils", f = "AppIntentScreenshotCacheUtils.kt", i = {0, 0, 1}, l = {177, 192, SpeechEvent.SERVER_DOWNLINK_EVENT_ASR_INFO}, m = "tryGetEncryptData", n = {"messageIdKey", "questionIdKey", "cacheKey"}, s = {"L$0", "L$1", "L$0"})
public final class AppIntentScreenshotCacheUtils$tryGetEncryptData$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppIntentScreenshotCacheUtils this$0;

    public AppIntentScreenshotCacheUtils$tryGetEncryptData$1(AppIntentScreenshotCacheUtils r1, Continuation<? super AppIntentScreenshotCacheUtils$tryGetEncryptData$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.i(null, null, this);
    }
}
