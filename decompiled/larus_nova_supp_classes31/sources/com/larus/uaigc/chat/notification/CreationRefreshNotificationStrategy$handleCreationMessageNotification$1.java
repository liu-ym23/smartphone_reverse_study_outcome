package com.larus.uaigc.chat.notification;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.notification.CreationRefreshNotificationStrategy", f = "CreationRefreshNotificationStrategy.kt", i = {0}, l = {146, 153}, m = "handleCreationMessageNotification", n = {"message"}, s = {"L$0"})
final class CreationRefreshNotificationStrategy$handleCreationMessageNotification$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationRefreshNotificationStrategy this$0;

    public CreationRefreshNotificationStrategy$handleCreationMessageNotification$1(CreationRefreshNotificationStrategy r1, Continuation<? super CreationRefreshNotificationStrategy$handleCreationMessageNotification$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return CreationRefreshNotificationStrategy.a(this.this$0, null, this);
    }
}
