package com.larus.dora.o.impl.health.calendar;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.o.impl.health.calendar.DoraOHealthCalendarRepo", f = "DoraOHealthCalendarRepo.kt", i = {0}, l = {42}, m = "fetchCalendar", n = {"month"}, s = {"L$0"})
public final class DoraOHealthCalendarRepo$fetchCalendar$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraOHealthCalendarRepo this$0;

    public DoraOHealthCalendarRepo$fetchCalendar$1(DoraOHealthCalendarRepo r1, Continuation<? super DoraOHealthCalendarRepo$fetchCalendar$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
