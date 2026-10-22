package com.bytedance.applog.sampling;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1873b;
    private JSONArray c;
    private JSONArray d;
    private final List<a> e;

    public c() {
        this.e = new ArrayList();
    }

    public int a() {
        return this.f1872a;
    }

    public void a(int r1) {
        this.f1872a = r1;
    }

    public void a(int r3, int r4, Set<String> r5, Map<String, List<Set<String>>> r6, Map<String, List<Map<String, Object>>> r7) {
        Set r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        if (r4 != 1) goto L5;
        a r11 = new g(r3, r8, r9, r10);
    L18:
        a r12 = r11;
    L19:
        if (r12 == null) goto L22;
        this.e.add(r12);
        return;
    L22:
        return;
    L5:
        if (r4 != 2) goto L7;
        r11 = new e(r3, r8, r9, r10);
        goto L18
    L7:
        if (r4 != 3) goto L9;
        r11 = new f(r3, r8, r9, r10);
        goto L18
    L9:
        if (r4 != 4) goto L11;
        r11 = new h(r3, r8, r9, r10);
        goto L18
    L11:
        if (r4 == 6) goto L13;
        r12 = null;
        goto L19
    L13:
        r11 = new i(r3, r8, r9, r10);
        goto L18
    }

    public void a(JSONArray r1) {
        this.d = r1;
    }

    public boolean a(b r4, String r5, String r6) {
        b r7 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.memorydata.plugin");
        Iterator<a> r3 = this.e.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r3.next(), a.class, "com.obric.memorydata.plugin");
        if (r0.a(r5, r6) == false) goto L4;
        return r0.a(r7);
    L9:
        return false;
    }

    public boolean a(b r5, String r6, JSONObject r7) {
        b r8 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.memorydata.plugin");
        Iterator<a> r4 = this.e.iterator();
    L4:
        if (r4.hasNext() == false) goto L12;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r4.next(), a.class, "com.obric.memorydata.plugin");
        if (r0.a(r6, r7) == false) goto L4;
        if (ZeusTransformUtils.instanceOf(r0, g.class) == false) goto L11;
        return false;
    L11:
        return r0.a(r8);
    L12:
        return false;
    }

    public int b() {
        return this.f1873b;
    }

    public void b(int r1) {
        this.f1873b = r1;
    }

    public void b(JSONArray r1) {
        this.c = r1;
    }

    public JSONArray c() {
        return this.d;
    }

    public JSONArray d() {
        return this.c;
    }

    public boolean e() {
        return !this.e.isEmpty();
    }
}
