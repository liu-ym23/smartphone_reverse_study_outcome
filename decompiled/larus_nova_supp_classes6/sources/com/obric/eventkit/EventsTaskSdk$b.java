package com.obric.eventkit;

import com.obric.eventkit.eventstaskmanager.ConditionGroup;
import com.obric.eventkit.eventstaskmanager.ConditionTaskAction;
import com.obric.eventkit.eventstaskmanager.ConditionTaskResult;
import com.obric.eventkit.eventstaskmanager.PeriodicPolicy;
import com.obric.eventkit.eventstaskmanager.TriggerControlPolicy;
import com.obric.eventkit.logger.Logger;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
public final class EventsTaskSdk$b extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Continuation<ConditionTaskResult> a;
    public final /* synthetic */ List<ConditionTaskAction> b;
    public final /* synthetic */ String c;
    public final /* synthetic */ ConditionGroup d;
    public final /* synthetic */ PeriodicPolicy e;
    public final /* synthetic */ TriggerControlPolicy f;
    public final /* synthetic */ Map<String, String> g;

    /* JADX WARN: Multi-variable type inference failed */
    public EventsTaskSdk$b(Continuation<? super ConditionTaskResult> r1, List<ConditionTaskAction> r2, String r3, ConditionGroup r4, PeriodicPolicy r5, TriggerControlPolicy r6, Map<String, String> r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        super(0);
    }

    public Object invoke() {
        Logger.INSTANCE.i("EventsTaskSdk", "addConditionTask");
        this.a.resumeWith(Result.constructor-impl(EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).addConditionTask(this.b, this.c, this.d, this.e, this.f, this.g)));
        return Unit.INSTANCE;
    }
}
