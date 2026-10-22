package com.bytedance.dataplatform;

import android.content.Context;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f2263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private h f2264b;
    private Set<String> c;
    private Set<String> d;
    private Set<String> e;
    private Set<String> f;
    private String g;
    private String h;
    private Map<String, String> i;
    private Map<String, Map<String, String>> j;
    private List<String> k;

    public f(Context r4, h r5, Set<String> r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        h r8 = (h) ZeusTransformUtils.wrapperContextForParams(r5, h.class, "com.obric.memorydata.plugin");
        Set<String> r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin");
        this.d = new ConcurrentSkipListSet();
        this.j = new ConcurrentHashMap();
        this.k = new CopyOnWriteArrayList();
        this.f2263a = ZeusTransformUtils.wrapperContext(r7, "com.obric.memorydata.plugin");
        this.f2264b = r8;
        this.f = r9;
        this.g = a.b(r7, "SP_EXPERIMENT_CACHE", "ab_test_current_uid");
        this.c = a.c(r7, "SP_EXPERIMENT_CACHE", "SP_EXPERIMENT_EXPOSURE_CACHE");
        this.e = a.c(r7, "SP_EXPERIMENT_CACHE", "SP_EXPERIMENT_EXPOSURE_CACHE_" + this.g);
        this.i = a.b(r7, "SP_EXPERIMENT_EXPOSURE_CACHE");
        Iterator<String> r10 = a.c(r7, "SP_EXPERIMENT_CACHE", "SP_CLIENT_EXPOSURE_CACHE").iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin");
        Map<String, String> r0 = a.b(r7, "SP_CLIENT_EXPOSURE_CACHE$$$" + r11);
        this.j.put(r11, r0);
        this.d.addAll(r0.values());
        goto L4
    L6:
        a();
        l.a(new AnonymousClass1(this), 5000);
    }

    private String a(Set<String>... r9) {
        StringBuilder r8 = new StringBuilder();
        int r0 = r9.length;
        boolean r2 = true;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L15;
        Set<String> r4 = r9[r3];
        if (r4 == null) goto L13;
        Iterator<String> r5 = r4.iterator();
    L8:
        if (r5.hasNext() == false) goto L13;
        if (r2 == false) goto L11;
        r2 = false;
    L12:
        r8.append((String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin"));
        goto L8
    L11:
        r8.append(',');
    L13:
        r3 = r3 + 1;
        goto L3
    L15:
        return r8.toString();
    }

    static /* synthetic */ List a(f r0) {
        return r0.k;
    }

    private void a() {
        if (this.c.isEmpty() == true) goto L5;
    L11:
        String r0 = a(new Set[]{this.c, this.e, this.d, this.f});
    L13:
        if (TextUtils.equals(r0, this.h) == true) goto L18;
        this.h = r0;
        h r3 = this.f2264b;
        if (r3 == null) goto L19;
        r3.expose(r0);
        return;
    L19:
        return;
    L18:
        return;
    L5:
        if (this.e.isEmpty() == false) goto L11;
        if (this.d.isEmpty() == false) goto L11;
        if (this.f.isEmpty() == false) goto L11;
        r0 = null;
        goto L13
    }

    static /* synthetic */ void a(f r2, String r3, List r4) {
        r2.a(r3, (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"));
    }

    private void a(String r8, List<String> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(this.j.get(r8), Map.class, "com.obric.memorydata.plugin");
        Iterator r2 = r0.keySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");
        if (r10.contains(r3) == true) goto L4;
        this.d.remove(r0.get(r3));     // Catch: Throwable -> L10
        r0.remove(r3);     // Catch: Throwable -> L10
        a.d(this.f2263a, "SP_CLIENT_EXPOSURE_CACHE$$$" + r8, r3);     // Catch: Throwable -> L10
        goto L4
    }

    public void a(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
    L6:
        r4 = "";
    L8:
        if (TextUtils.equals(this.g, r4) == false) goto L10;
        return;
    L10:
        this.g = r4;
        this.e = a.c(this.f2263a, "SP_EXPERIMENT_CACHE", "SP_EXPERIMENT_EXPOSURE_CACHE_" + this.g);
        a.a(this.f2263a, "SP_EXPERIMENT_CACHE", "ab_test_current_uid", this.g);
        a();
        return;
    L5:
        if ("0".equals(r4) == false) goto L8;
        goto L6
    }

    <T> void a(String r6, com.bytedance.dataplatform.b.a<T> r7, String r8) {
        if (r7 != null) goto L4;
        return;
    L4:
        String r0 = r7.a();
        if (this.j.containsKey(r0) == true) goto L8;
        this.j.put(r0, new ConcurrentHashMap());
        a.a(this.f2263a, "SP_EXPERIMENT_CACHE", "SP_CLIENT_EXPOSURE_CACHE", this.j.keySet());
    L8:
        if (r7.b() == null) goto L10;
        a(r0, Arrays.asList(r7.b()));
    L11:
        Map r9 = (Map) ZeusTransformUtils.preCheckCast(this.j.get(r0), Map.class, "com.obric.memorydata.plugin");
        String r1 = (String) ZeusTransformUtils.preCheckCast(r9.get(r6), String.class, "com.obric.memorydata.plugin");
        if (TextUtils.equals(r1, r8) == false) goto L14;
    L20:
        com.bytedance.dataplatform.a.a.a(r8, this.h);
        return;
    L14:
        if (TextUtils.isEmpty(r1) == true) goto L17;
        this.d.remove(r1);
        r9.remove(r6);
    L17:
        if (TextUtils.isEmpty(r8) == true) goto L19;
        this.d.add(r8);
        r9.put(r6, r8);
    L19:
        a.a(this.f2263a, "SP_CLIENT_EXPOSURE_CACHE$$$" + r0, r6, r8);
        a();
        goto L20
    L10:
        this.k.add(r6);
        goto L11
    }

    void a(Map<String, String> r3, Map<String, Long> r4) {
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        this.i = r5;
        a.a(this.f2263a, "SP_EXPERIMENT_EXPOSURE_CACHE", r5);
        this.c.retainAll(this.i.values());
        a.a(this.f2263a, "SP_EXPERIMENT_CACHE", "SP_EXPERIMENT_EXPOSURE_CACHE", this.c);
        a();
    }
}
