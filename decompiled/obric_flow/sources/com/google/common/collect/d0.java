package com.google.common.collect;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d0 implements Map.Entry {
    public d0() {
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object r5) {
        if ((r5 instanceof Map.Entry) == false) goto L10;
        Map.Entry r10 = (Map.Entry) r5;
        if (com.google.common.base.b0.w(getKey(), r10.getKey()) == true) goto L7;
        return false;
    L7:
        if (com.google.common.base.b0.w(getValue(), r10.getValue()) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        Object r5 = getKey();
        Object r10 = getValue();
        int r11 = 0;
        if (r5 != null) goto L5;
        int r12 = 0;
    L6:
        if (r10 == null) goto L10;
        r11 = r10.hashCode();
    L10:
        return r12 ^ r11;
    L5:
        r12 = r5.hashCode();
        goto L6
    }

    @Override // java.util.Map.Entry
    public Object setValue(Object r5) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        String r5 = String.valueOf(getKey());
        String r10 = String.valueOf(getValue());
        int r11 = r5.length() + 1;
        return androidx.room.jarjarred.org.antlr.runtime.a.m(r10.length() + r11, r5, "=", r10);
    }
}
