package com.bytedance.pia.core;

import java.util.HashMap;
import java.util.Map;
import oh.a;
import oh.b;
import oh.d;
import oh.e;
import oh.f;
import oh.g;
import oh.h;
import oh.i;
import oh.j;
import oh.k;

/* JADX INFO: loaded from: classes2.dex */
public class ServiceProvider {
    private final Map<Class<?>, Object> services;

    public ServiceProvider() {
        this.services = new HashMap();
        put(k.class, a.f20572c);
        put(e.class, d.f20576a);
        put(f.class, f.f20578a);
        int r5 = j.f20581a;
        put(eh.a.class, i.f20580a);
        put(h.class, h.f20579a);
        put(b.class, a.f20570a);
        put(g.class, a.f20571b);
    }

    private <T> void put(Class<T> r5, T r10) {
        this.services.put(r5, r10);
    }

    public <T> T get(Class<T> r5) {
        return (T) this.services.get(r5);
    L4:
        return null;
    }
}
