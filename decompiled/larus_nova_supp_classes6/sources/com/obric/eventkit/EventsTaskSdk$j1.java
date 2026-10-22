package com.obric.eventkit;

import com.obric.eventkit.eventstaskmanager.ConditionTaskAction;
import com.obric.eventkit.eventstaskmanager.TaskKnowledge;
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
public final class EventsTaskSdk$j1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Continuation<Unit> a;
    public final /* synthetic */ String b;
    public final /* synthetic */ List<ConditionTaskAction> c;
    public final /* synthetic */ TaskKnowledge d;
    public final /* synthetic */ int e;
    public final /* synthetic */ String f;

    public EventsTaskSdk$j1(Continuation<? super Unit> r1, String r2, List<ConditionTaskAction> r3, TaskKnowledge r4, int r5, String r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        super(0);
    }

    public Object invoke() {
        Logger.INSTANCE.i("EventsTaskSdk", "tryScheduleConditionTask");
        Continuation<Unit> r0 = this.a;
        EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).tryScheduleConditionTask(this.b, this.c, this.d, this.e, this.f);
        Unit r1 = Unit.INSTANCE;
        r0.resumeWith(Result.constructor-impl(r1));
        return r1;
    }
}
