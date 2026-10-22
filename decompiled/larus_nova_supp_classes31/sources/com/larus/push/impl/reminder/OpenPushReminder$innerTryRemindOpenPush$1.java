package com.larus.push.impl.reminder;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.push.impl.reminder.OpenPushReminder", f = "OpenPushReminder.kt", i = {0, 0}, l = {177}, m = "innerTryRemindOpenPush", n = {"data", "callback"}, s = {"L$0", "L$1"})
final class OpenPushReminder$innerTryRemindOpenPush$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OpenPushReminder this$0;

    public OpenPushReminder$innerTryRemindOpenPush$1(OpenPushReminder r1, Continuation<? super OpenPushReminder$innerTryRemindOpenPush$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return OpenPushReminder.a(this.this$0, null, null, this);
    }
}
