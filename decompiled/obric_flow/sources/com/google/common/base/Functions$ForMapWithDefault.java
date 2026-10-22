package com.google.common.base;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class Functions$ForMapWithDefault<K, V> implements q, Serializable {
    private static final long serialVersionUID = 0;
    final V defaultValue;
    final Map<K, ? extends V> map;

    public Functions$ForMapWithDefault(Map<K, ? extends V> r5, V r10) {
        r5.getClass();
        this.map = r5;
        this.defaultValue = r10;
    }

    @Override // java.util.function.Function
    public V apply(K r5) {
        V r10 = this.map.get(r5);
        if (r10 == null) goto L5;
        return r10;
    L5:
        if (this.map.containsKey(r5) == false) goto L8;
        return r10;
    L8:
        return this.defaultValue;
    }

    @Override // com.google.common.base.q
    public boolean equals(Object r5) {
        if ((r5 instanceof Functions$ForMapWithDefault) == false) goto L10;
        Functions$ForMapWithDefault r10 = (Functions$ForMapWithDefault) r5;
        if (this.map.equals(r10.map) == true) goto L7;
        return false;
    L7:
        if (b0.w(this.defaultValue, r10.defaultValue) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.map, this.defaultValue});
    }

    public String toString() {
        String r5 = String.valueOf(this.map);
        String r10 = String.valueOf(this.defaultValue);
        int r11 = r5.length() + 33;
        StringBuilder r12 = new StringBuilder(r10.length() + r11);
        r12.append("Functions.forMap(");
        r12.append(r5);
        r12.append(", defaultValue=");
        r12.append(r10);
        r12.append(")");
        return r12.toString();
    }
}
