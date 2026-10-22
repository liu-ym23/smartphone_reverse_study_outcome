package com.obric.eventkit;

import com.obric.eventkit.logger.Logger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
public final class EventsTaskSdk$c1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;

    public EventsTaskSdk$c1(String r1, String r2) {
        this.a = r1;
        this.b = r2;
        super(0);
    }

    public Object invoke() {
        Logger.INSTANCE.i("EventsTaskSdk", "scheduleShortcutTask");
        EventsTaskSdk.access$getApi(EventsTaskSdk.INSTANCE).scheduleShortcutTask(this.a, this.b);
        return Unit.INSTANCE;
    }
}
