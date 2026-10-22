package com.ss.android.ugc.aweme.framework.services;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes6.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Map<String, String> f15745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Set<String> f15746b;
    final Set<String> c;
    private Map<String, g> d;
    private Map<String, Object> e;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final d f15747a = null;

        static {
            f15747a = new d();
        }

        static /* synthetic */ d a() {
            return f15747a;
        }
    }

    public d() {
        this.d = new ConcurrentHashMap();
        this.e = new ConcurrentHashMap();
        this.f15745a = new ConcurrentHashMap();
        this.f15746b = Collections.synchronizedSet(new HashSet());
        this.c = Collections.synchronizedSet(new HashSet());
    }

    public static d a() {
        return a.a();
    }

    private <T> T c(Class<T> r1) {
        this.c.add(r1.getName());
        return null;
    }

    public <T> T a(Class<T> r5) {
        String r0 = r5.getName();
        g r1 = (g) ZeusTransformUtils.preCheckCast(this.d.get(r0), g.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
        T r2 = (T) this.e.get(r0);
        if (r2 == null) goto L9;
    L12:
        return r2;
    L9:
        if (this.c.contains(r0) == true) goto L12;
        return (T) c(r5);
    L5:
        return (T) r1.get();
    }

    public boolean b(Class r3) {
        String r4 = (String) ZeusTransformUtils.preCheckCast(this.f15745a.get(r3.getName()), String.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return false;
    L5:
        return this.f15746b.contains(r4);
    }
}
