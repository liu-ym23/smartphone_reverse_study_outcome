package com.obric.eventkit;

import com.obric.eventkit.eventstaskmanager.EventTaskExecutionDetailRecord;
import com.obric.eventkit.logger.Logger;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
public final class EventsTaskSdk$u extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Continuation<List<EventTaskExecutionDetailRecord>> a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;

    /* JADX WARN: Multi-variable type inference failed */
    public EventsTaskSdk$u(Continuation<? super List<EventTaskExecutionDetailRecord>> r1, String r2, int r3, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        super(0);
    }

    public Object invoke() {
        Logger.INSTANCE.i("EventsTaskSdk", "getEventTaskExecutionDetailRecordsByTaskId");
        this.a.resumeWith(Result.constructor-impl(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).getEventTaskExecutionDetailRecordsByTaskId(this.b, this.c, this.d)));
        return Unit.INSTANCE;
    }
}
