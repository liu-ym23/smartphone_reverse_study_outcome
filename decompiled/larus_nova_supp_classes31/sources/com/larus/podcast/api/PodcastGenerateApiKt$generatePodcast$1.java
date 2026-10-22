package com.larus.podcast.api;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.podcast.api.PodcastGenerateApiKt", f = "PodcastGenerateApi.kt", i = {}, l = {23}, m = "generatePodcast", n = {}, s = {})
public final class PodcastGenerateApiKt$generatePodcast$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    public PodcastGenerateApiKt$generatePodcast$1(Continuation<? super PodcastGenerateApiKt$generatePodcast$1> r1) {
        super(r1);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return PodcastGenerateApiKt.a(null, false, null, null, this);
    }
}
