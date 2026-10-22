package com.larus.uaigc.chat.notification;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.notification.CreationRefreshNotificationStrategy", f = "CreationRefreshNotificationStrategy.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {283, 304}, m = "handleRefreshInner", n = {"state", "userQuery", "message", "tasks", "index$iv", "state", "userQuery", "message", "tasks", "index$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0"})
final class CreationRefreshNotificationStrategy$handleRefreshInner$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationRefreshNotificationStrategy this$0;

    public CreationRefreshNotificationStrategy$handleRefreshInner$1(CreationRefreshNotificationStrategy r1, Continuation<? super CreationRefreshNotificationStrategy$handleRefreshInner$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return CreationRefreshNotificationStrategy.b(this.this$0, null, null, this);
    }
}
