package com.obric.miniapp.alarm;

import com.obric.capabilitykit.entity.ResultCode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.alarm.AlarmManager", f = "AlarmManager.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 3}, l = {218, 266, 274, 297, ResultCode.ERROR_EMPTY_ENTITY, 307}, m = "doCreateOrUpdateAlarm", n = {"id", "title", "content", "triggerTime", "extraInfo", "now", "intervalMinutes", "repeatCount", "oldAlarm", "oldAlarm"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0", "I$0", "L$0", "L$0"})
final class AlarmManager$doCreateOrUpdateAlarm$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AlarmManager this$0;

    public AlarmManager$doCreateOrUpdateAlarm$1(AlarmManager r1, Continuation<? super AlarmManager$doCreateOrUpdateAlarm$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r11) {
        this.result = r11;
        this.label |= Integer.MIN_VALUE;
        return AlarmManager.a(this.this$0, null, null, null, null, null, 0, 0, this);
    }
}
