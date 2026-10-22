package com.tom_roush.pdfbox.pdmodel.common;

import com.tom_roush.pdfbox.a.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class b<K, V> implements Map<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.tom_roush.pdfbox.a.d f16181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<K, V> f16182b;

    public b(Map<K, V> r3, com.tom_roush.pdfbox.a.d r4) {
        this.f16182b = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        this.f16181a = r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static b<String, Object> a(com.tom_roush.pdfbox.a.d r6) {
        if (r6 == null) goto L28;
        HashMap r0 = new HashMap();
        Iterator<com.tom_roush.pdfbox.a.i> r1 = r6.c().iterator();
    L5:
        if (r1.hasNext() == false) goto L38;
        com.tom_roush.pdfbox.a.i r2 = (com.tom_roush.pdfbox.a.i) ZeusTransformUtils.preCheckCast(r1.next(), com.tom_roush.pdfbox.a.i.class, "com.obric.memorydata.plugin");
        com.tom_roush.pdfbox.a.b r3 = r6.a(r2);
        if (ZeusTransformUtils.instanceOf(r3, o.class) == false) goto L10;
        Object r4 = ((o) ZeusTransformUtils.preCheckCast(r3, o.class, "com.obric.memorydata.plugin")).a();
    L24:
        r0.put(r2.a(), r4);
        goto L5
    L10:
        if (ZeusTransformUtils.instanceOf(r3, com.tom_roush.pdfbox.a.h.class) == false) goto L13;
        r4 = Integer.valueOf(((com.tom_roush.pdfbox.a.h) ZeusTransformUtils.preCheckCast(r3, com.tom_roush.pdfbox.a.h.class, "com.obric.memorydata.plugin")).c());
        goto L24
    L13:
        if (ZeusTransformUtils.instanceOf(r3, com.tom_roush.pdfbox.a.i.class) == false) goto L16;
        r4 = ((com.tom_roush.pdfbox.a.i) ZeusTransformUtils.preCheckCast(r3, com.tom_roush.pdfbox.a.i.class, "com.obric.memorydata.plugin")).a();
        goto L24
    L16:
        if (ZeusTransformUtils.instanceOf(r3, com.tom_roush.pdfbox.a.f.class) == false) goto L19;
        r4 = Float.valueOf(((com.tom_roush.pdfbox.a.f) ZeusTransformUtils.preCheckCast(r3, com.tom_roush.pdfbox.a.f.class, "com.obric.memorydata.plugin")).a());
        goto L24
    L19:
        if (ZeusTransformUtils.instanceOf(r3, com.tom_roush.pdfbox.a.c.class) == false) goto L26;
        if (((com.tom_roush.pdfbox.a.c) ZeusTransformUtils.preCheckCast(r3, com.tom_roush.pdfbox.a.c.class, "com.obric.memorydata.plugin")).a() == false) goto L23;
        r4 = Boolean.TRUE;
        goto L24
    L23:
        r4 = Boolean.FALSE;
        goto L24
    L26:
        throw new IOException("Error:unknown type of object to convert:" + r3);
    L38:
        return new b(r0, r6);
    L28:
        return null;
    }

    @Override // java.util.Map
    public void clear() {
        this.f16181a.b();
        this.f16182b.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object r1) {
        return this.f16182b.containsKey(r1);
    }

    @Override // java.util.Map
    public boolean containsValue(Object r1) {
        return this.f16182b.containsValue(r1);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return Collections.unmodifiableSet(this.f16182b.entrySet());
    }

    @Override // java.util.Map
    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, b.class) == true) goto L7;
        return false;
    L7:
        return ((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.memorydata.plugin")).f16181a.equals(this.f16181a);
    }

    @Override // java.util.Map
    public V get(Object r1) {
        return this.f16182b.get(r1);
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.f16181a.hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return this.f16182b.keySet();
    }

    @Override // java.util.Map
    public V put(K r5, V r6) {
        c r0 = (c) ZeusTransformUtils.preCheckCast(r6, c.class, "com.obric.memorydata.plugin");
        this.f16181a.a(com.tom_roush.pdfbox.a.i.a((String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin")), r0.e());
        return this.f16182b.put(r5, r6);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> r2) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override // java.util.Map
    public V remove(Object r4) {
        this.f16181a.k(com.tom_roush.pdfbox.a.i.a((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin")));
        return this.f16182b.remove(r4);
    }

    @Override // java.util.Map
    public int size() {
        return this.f16181a.a();
    }

    public String toString() {
        return this.f16182b.toString();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return this.f16182b.values();
    }
}
