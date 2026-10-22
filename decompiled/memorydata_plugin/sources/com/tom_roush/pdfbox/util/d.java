package com.tom_roush.pdfbox.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class d<K, V> implements Map<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object[] f16300a;

    private class a implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f16301a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f16302b;

        a(d r1, int r2) {
            this.f16301a = r1;
            this.f16302b = r2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, a.class) == true) goto L5;
            return false;
        L5:
            a r5 = (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.memorydata.plugin");
            if (getKey().equals(r5.getKey()) == true) goto L8;
            return false;
        L8:
            if (getValue().equals(r5.getValue()) == false) goto L12;
            return true;
        L12:
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return (K) d.a(this.f16301a)[this.f16302b];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return (V) d.a(this.f16301a)[this.f16302b + 1];
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return getKey().hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V r3) {
            Objects.requireNonNull(r3, "Key or value must not be null.");
            V r0 = (V) getValue();
            d.a(this.f16301a)[this.f16302b + 1] = r3;
            return r0;
        }
    }

    public d() {
    }

    private int a(Object r5) {
        if (isEmpty() == true) goto L13;
        if (r5 == null) goto L13;
        int r0 = 0;
    L7:
        Object[] r2 = this.f16300a;
        if (r0 >= r2.length) goto L13;
        if (r5.equals(r2[r0]) == true) goto L11;
        r0 = r0 + 2;
        goto L7
    L11:
        return r0;
    L13:
        return -1;
    }

    static /* synthetic */ Object[] a(d r0) {
        return r0.f16300a;
    }

    private int b(Object r5) {
        if (isEmpty() == true) goto L13;
        if (r5 == null) goto L13;
        int r0 = 1;
    L7:
        Object[] r2 = this.f16300a;
        if (r0 >= r2.length) goto L13;
        if (r5.equals(r2[r0]) == true) goto L11;
        r0 = r0 + 2;
        goto L7
    L11:
        return r0;
    L13:
        return -1;
    }

    @Override // java.util.Map
    public void clear() {
        this.f16300a = null;
    }

    @Override // java.util.Map
    public boolean containsKey(Object r1) {
        if (a(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Map
    public boolean containsValue(Object r1) {
        if (b(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (isEmpty() == true) goto L5;
        LinkedHashSet r0 = new LinkedHashSet();
        int r1 = 0;
    L8:
        if (r1 >= this.f16300a.length) goto L11;
        r0.add(new a(this, r1));
        r1 = r1 + 2;
        goto L8
    L11:
        return Collections.unmodifiableSet(r0);
    L5:
        return Collections.emptySet();
    }

    @Override // java.util.Map
    public V get(Object r1) {
        int r2 = a(r1);
        if (r2 >= 0) goto L6;
        return null;
    L6:
        return (V) this.f16300a[r2 + 1];
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        Object[] r0 = this.f16300a;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.length == 0) goto L8;
        return false;
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        if (isEmpty() == true) goto L5;
        LinkedHashSet r0 = new LinkedHashSet();
        int r1 = 0;
    L7:
        Object[] r2 = this.f16300a;
        if (r1 >= r2.length) goto L11;
        r0.add(r2[r1]);
        r1 = r1 + 2;
        goto L7
    L11:
        return Collections.unmodifiableSet(r0);
    L5:
        return Collections.emptySet();
    }

    @Override // java.util.Map
    public V put(K r7, V r8) {
        if (r7 == null) goto L15;
        if (r8 == null) goto L15;
        if (this.f16300a != null) goto L8;
        this.f16300a = new Object[]{r7, r8};
        return null;
    L8:
        int r0 = a(r7);
        if (r0 >= 0) goto L12;
        Object[] r1 = this.f16300a;
        int r4 = r1.length;
        Object[] r5 = new Object[r4 + 2];
        System.arraycopy(r1, 0, r5, 0, r4);
        r5[r4] = r7;
        r5[r4 + 1] = r8;
        this.f16300a = r5;
        return null;
    L12:
        Object[] r6 = this.f16300a;
        int r2 = r0 + 1;
        V r9 = (V) r6[r2];
        r6[r2] = r8;
        return r9;
    L15:
        throw new NullPointerException("Key or value must not be null.");
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends K, ? extends V> r10) {
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin");
        Object[] r0 = this.f16300a;
        int r3 = 0;
        if (r0 != null) goto L5;
    L23:
        this.f16300a = new Object[r11.size() << 1];
        Iterator<Map.Entry<K, V>> r12 = r11.entrySet().iterator();
    L25:
        if (r12.hasNext() == false) goto L45;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r1.getKey() == null) goto L32;
        if (r1.getValue() == null) goto L32;
        int r5 = r3 + 1;
        this.f16300a[r3] = r1.getKey();
        this.f16300a[r5] = r1.getValue();
        r3 = r5 + 1;
    L32:
        throw new NullPointerException("Key or value must not be null.");
    L45:
        return;
    L5:
        if (r0.length == 0) goto L23;
        int r2 = r0.length;
        int r4 = (r11.size() << 1) + r2;
        Object[] r6 = new Object[r4];
        System.arraycopy(this.f16300a, 0, r6, 0, r2);
        Iterator<Map.Entry<K, V>> r13 = r11.entrySet().iterator();
    L9:
        if (r13.hasNext() == false) goto L20;
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r7.getKey() == null) goto L19;
        if (r7.getValue() == null) goto L19;
        int r8 = a(r7.getKey());
        if (r8 >= 0) goto L16;
        int r9 = r2 + 1;
        r6[r2] = r7.getKey();
        r2 = r9 + 1;
        r6[r9] = r7.getValue();
        goto L9
    L16:
        r6[r8 + 1] = r7.getValue();
    L19:
        throw new NullPointerException("Key or value must not be null.");
    L20:
        if (r2 >= r4) goto L22;
        Object[] r14 = new Object[r2];
        System.arraycopy(r6, 0, r14, 0, r2);
        r6 = r14;
    L22:
        this.f16300a = r6;
    }

    @Override // java.util.Map
    public V remove(Object r7) {
        int r8 = a(r7);
        if (r8 >= 0) goto L5;
        return null;
    L5:
        Object[] r1 = this.f16300a;
        V r2 = (V) r1[r8 + 1];
        int r3 = r1.length;
        if (r3 != 2) goto L8;
        this.f16300a = null;
    L9:
        return r2;
    L8:
        Object[] r0 = new Object[r3 - 2];
        System.arraycopy(r1, 0, r0, 0, r8);
        System.arraycopy(this.f16300a, r8 + 2, r0, r8, (r3 - r8) - 2);
        this.f16300a = r0;
        goto L9
    }

    @Override // java.util.Map
    public int size() {
        Object[] r0 = this.f16300a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.length >> 1;
    }

    @Override // java.util.Map
    public Collection<V> values() {
        if (isEmpty() == true) goto L5;
        int r2 = 1;
        ArrayList r0 = new ArrayList(this.f16300a.length >> 1);
    L7:
        Object[] r1 = this.f16300a;
        if (r2 >= r1.length) goto L11;
        r0.add(r1[r2]);
        r2 = r2 + 2;
        goto L7
    L11:
        return Collections.unmodifiableList(r0);
    L5:
        return Collections.emptySet();
    }
}
