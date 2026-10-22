package org.ehcache.config;

import java.util.Set;
import org.ehcache.event.EventFiring;
import org.ehcache.event.EventOrdering;
import org.ehcache.event.EventType;

/* JADX INFO: loaded from: classes7.dex */
public interface c<K, V> extends b<K, V> {
    void a(org.ehcache.event.a<? super K, ? super V> r1, EventOrdering r2, EventFiring r3, Set<EventType> r4);
}
