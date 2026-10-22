package com.ss.android.har.service;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f15242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f15243b;
    public String c;
    public Map<String, Float> d;
    public long e;

    public e(Map<String, Float> r5) {
        Map<String, Float> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        this.d = r6;
        String r7 = f.a(r6);
        this.f15243b = r7;
        this.c = f.a(r7);
        this.f15242a = f.b(this.f15243b);
        this.e = System.currentTimeMillis() / 1000;
    }

    public void a(Map<String, Float> r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L16;
        Map<String, Float> r5 = this.d;
        if (r5 == null) goto L22;
        Iterator<Map.Entry<String, Float>> r8 = r5.entrySet().iterator();
    L9:
        if (r8.hasNext() == false) goto L23;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L9;
        float r2 = ((Float) ZeusTransformUtils.preCheckCast(r0.getValue(), Float.class, "com.obric.memorydata.plugin")).floatValue();
        Float r3 = (Float) ZeusTransformUtils.preCheckCast(r7.get(r0.getKey()), Float.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L15;
        r2 = r2 + r3.floatValue();
    L15:
        r7.put(r0.getKey(), Float.valueOf(r2));
        goto L9
    L23:
        return;
    L22:
        return;
    }

    public String toString() {
        return "{" + this.f15242a + ", " + this.c + ", " + this.d + ", " + this.e + "}";
    }
}
