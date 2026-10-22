package org.ehcache.core.b;

import java.util.EnumSet;
import org.ehcache.event.EventFiring;
import org.ehcache.event.EventOrdering;
import org.ehcache.event.EventType;

/* JADX INFO: loaded from: classes7.dex */
public interface c<R> extends org.ehcache.spi.service.d<d, R> {
    EventFiring a();

    EventOrdering c();

    EnumSet<EventType> d();
}
