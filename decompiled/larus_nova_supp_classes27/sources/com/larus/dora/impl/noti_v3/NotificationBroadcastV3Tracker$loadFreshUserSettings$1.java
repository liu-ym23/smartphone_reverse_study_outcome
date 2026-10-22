package com.larus.dora.impl.noti_v3;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.noti_v3.NotificationBroadcastV3Tracker", f = "NotificationBroadcastV3Tracker.kt", i = {}, l = {129}, m = "loadFreshUserSettings", n = {}, s = {})
public final class NotificationBroadcastV3Tracker$loadFreshUserSettings$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NotificationBroadcastV3Tracker this$0;

    public NotificationBroadcastV3Tracker$loadFreshUserSettings$1(NotificationBroadcastV3Tracker r1, Continuation<? super NotificationBroadcastV3Tracker$loadFreshUserSettings$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        NotificationBroadcastV3Tracker r3 = this.this$0;
        NotificationBroadcastV3Tracker r0 = NotificationBroadcastV3Tracker.a;
        return r3.c(this);
    }
}
