package com.obric.eventkit.eventstaskmanager;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a%\u0010\u0004\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0001¢\u0006\u0004\b\u0004\u0010\u0005\"@\u0010\n\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00000\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\t0\u00070\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/AppEvent;", "T", "", "eventType", "newInstanceByEventType", "(Ljava/lang/String;)Lcom/obric/eventkit/eventstaskmanager/AppEvent;", "", "Lkotlin/Triple;", "Ljava/lang/Class;", "Lkotlin/Function0;", "EVENTS", "Ljava/util/List;", "a", "()Ljava/util/List;", "eventstaskkit_release"}, k = 2, mv = {1, 7, 1})
public final class EventTypeKt {
    private static final List<Triple<String, Class<? extends AppEvent>, Function0<AppEvent>>> EVENTS = null;

    static {
        EVENTS = CollectionsKt.listOf(new Triple[]{new Triple("NOTIFICATION_EVENT", NotificationEvent.class, EVENTS.1.INSTANCE), new Triple("ACTIVE_AGENT_EVENT", ActiveAgentEvent.class, EVENTS.2.INSTANCE)});
    }

    public static final List<Triple<String, Class<? extends AppEvent>, Function0<AppEvent>>> a() {
        return EVENTS;
    }

    public static final String b(AppEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Iterator<T> r0 = EVENTS.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(r4.getClass(), ((Triple) r1).getSecond()) == false) goto L4;
    L9:
        Triple r2 = (Triple) r1;
        if (r2 == null) goto L13;
        String r5 = (String) r2.getFirst();
        if (r5 == null) goto L13;
        return r5;
    L13:
        return "UNKNOWN";
    L8:
        r1 = null;
        goto L9
    }

    public static final <T extends AppEvent> T newInstanceByEventType(String r4) {
        Iterator<T> r0 = EVENTS.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((Triple) r1).getFirst(), r4) == false) goto L4;
    L9:
        Triple r2 = (Triple) r1;
        if (r2 == null) goto L14;
        Function0 r5 = (Function0) r2.getThird();
        if (r5 == null) goto L14;
        AppEvent r6 = (AppEvent) r5.invoke();
    L16:
        if ((r6 instanceof AppEvent) == true) goto L18;
        return null;
    L18:
        return (T) r6;
    L14:
        r6 = null;
        goto L16
    L8:
        r1 = null;
        goto L9
    }
}
