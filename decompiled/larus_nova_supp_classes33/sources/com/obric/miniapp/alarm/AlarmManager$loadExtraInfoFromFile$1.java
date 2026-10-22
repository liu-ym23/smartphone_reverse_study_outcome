package com.obric.miniapp.alarm;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.alarm.AlarmManager", f = "AlarmManager.kt", i = {0}, l = {161}, m = "loadExtraInfoFromFile", n = {"file"}, s = {"L$0"})
final class AlarmManager$loadExtraInfoFromFile$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AlarmManager this$0;

    public AlarmManager$loadExtraInfoFromFile$1(AlarmManager r1, Continuation<? super AlarmManager$loadExtraInfoFromFile$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return AlarmManager.c(this.this$0, null, this);
    }
}
