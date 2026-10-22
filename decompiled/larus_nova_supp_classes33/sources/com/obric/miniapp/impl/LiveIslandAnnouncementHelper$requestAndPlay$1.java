package com.obric.miniapp.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.impl.LiveIslandAnnouncementHelper", f = "LiveIslandAnnouncementHelper.kt", i = {0}, l = {28}, m = "requestAndPlay", n = {"requestBody"}, s = {"L$0"})
public final class LiveIslandAnnouncementHelper$requestAndPlay$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LiveIslandAnnouncementHelper this$0;

    public LiveIslandAnnouncementHelper$requestAndPlay$1(LiveIslandAnnouncementHelper r1, Continuation<? super LiveIslandAnnouncementHelper$requestAndPlay$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
