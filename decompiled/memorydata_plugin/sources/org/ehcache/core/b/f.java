package org.ehcache.core.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.EnumSet;
import java.util.Objects;
import org.ehcache.event.EventFiring;
import org.ehcache.event.EventOrdering;
import org.ehcache.event.EventType;

/* JADX INFO: loaded from: classes7.dex */
public final class f<K, V> implements org.ehcache.event.a<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final org.ehcache.event.a<? super K, ? super V> f18009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EventFiring f18010b;
    private final EventOrdering c;
    private final EnumSet<EventType> d;

    public f(org.ehcache.event.a<? super K, ? super V> r3, EventFiring r4, EventOrdering r5, EnumSet<EventType> r6) {
        org.ehcache.event.a<? super K, ? super V> r7 = (org.ehcache.event.a) ZeusTransformUtils.wrapperContextForParams(r3, org.ehcache.event.a.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r7, "listener cannot be null");
        Objects.requireNonNull(r4, "firing cannot be null");
        Objects.requireNonNull(r5, "ordering cannot be null");
        Objects.requireNonNull(r6, "forEvents cannot be null");
        if (r6.isEmpty() == true) goto L7;
        this.f18009a = r7;
        this.f18010b = r4;
        this.c = r5;
        this.d = r6;
        return;
    L7:
        throw new IllegalArgumentException("forEvents cannot be empty");
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, f.class) == true) goto L6;
        return false;
    L6:
        f r4 = (f) ZeusTransformUtils.preCheckCast(r3, f.class, "com.obric.memorydata.plugin");
        return this.f18009a.equals(r4.f18009a);
    }

    public int hashCode() {
        return this.f18009a.hashCode();
    }
}
