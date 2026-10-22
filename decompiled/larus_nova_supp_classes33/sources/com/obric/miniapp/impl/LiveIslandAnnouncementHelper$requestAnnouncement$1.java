package com.obric.miniapp.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.impl.LiveIslandAnnouncementHelper", f = "LiveIslandAnnouncementHelper.kt", i = {}, l = {47}, m = "requestAnnouncement", n = {}, s = {})
public final class LiveIslandAnnouncementHelper$requestAnnouncement$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LiveIslandAnnouncementHelper this$0;

    public LiveIslandAnnouncementHelper$requestAnnouncement$1(LiveIslandAnnouncementHelper r1, Continuation<? super LiveIslandAnnouncementHelper$requestAnnouncement$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        LiveIslandAnnouncementHelper r3 = this.this$0;
        LiveIslandAnnouncementHelper r0 = LiveIslandAnnouncementHelper.a;
        return r3.b(null, this);
    }
}
