package com.ss.android.ugc.aweme.framework.services;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes6.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Set<String> f15753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Set<String> f15754b;
    private Map<String, Object> c;
    private Map<String, Set<Object>> d;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final i f15755a = null;

        static {
            f15755a = new i();
        }

        static /* synthetic */ i a() {
            return f15755a;
        }
    }

    public i() {
        this.c = new ConcurrentHashMap();
        this.f15753a = Collections.synchronizedSet(new HashSet());
        this.d = new ConcurrentHashMap();
        this.f15754b = Collections.synchronizedSet(new HashSet());
    }

    public static i a() {
        return a.a();
    }

    private <T> T b(Class<T> r1) {
        this.f15753a.add(r1.getName());
        return null;
    }

    public <T> T a(Class<T> r4) {
        String r0 = r4.getName();
        T r1 = (T) this.c.get(r0);
        if (r1 == null) goto L5;
        return r1;
    L5:
        if (this.f15753a.contains(r0) == false) goto L7;
        return r1;
    L7:
        return (T) b(r4);
    }
}
