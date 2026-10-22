package com.google.common.base;

import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class Functions$FunctionForMapNoDefault<K, V> implements q, Serializable {
    private static final long serialVersionUID = 0;
    final Map<K, V> map;

    public Functions$FunctionForMapNoDefault(Map<K, V> r5) {
        r5.getClass();
        this.map = r5;
    }

    @Override // java.util.function.Function
    public V apply(K r5) {
        V r10 = this.map.get(r5);
        if (r10 == null) goto L5;
    L8:
        boolean r11 = true;
    L9:
        b0.h("Key '%s' not present in map", r11, r5);
        return r10;
    L5:
        if (this.map.containsKey(r5) == true) goto L8;
        r11 = false;
        goto L9
    }

    @Override // com.google.common.base.q
    public boolean equals(Object r5) {
        if ((r5 instanceof Functions$FunctionForMapNoDefault) == true) goto L5;
        return false;
    L5:
        return this.map.equals(((Functions$FunctionForMapNoDefault) r5).map);
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    public String toString() {
        String r5 = String.valueOf(this.map);
        return androidx.room.jarjarred.org.antlr.runtime.a.m(r5.length() + 18, "Functions.forMap(", r5, ")");
    }
}
