package com.obric.eventkit.eventstaskmanager;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/obric/eventkit/eventstaskmanager/NotificationEvent;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class EventTypeKt$EVENTS$1 extends Lambda implements Function0<NotificationEvent> {
    public static final EventTypeKt$EVENTS$1 INSTANCE = null;

    static {
        INSTANCE = new EventTypeKt$EVENTS$1();
    }

    public EventTypeKt$EVENTS$1() {
        super(0);
    }

    public final NotificationEvent invoke() {
        return new NotificationEvent(null, null, null, 7, null);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m47invoke() {
        return invoke();
    }
}
