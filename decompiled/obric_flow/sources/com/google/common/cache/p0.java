package com.google.common.cache;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class p0 implements Map.Entry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f8736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f8737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ q0 f8738c;

    public p0(q0 r5, Object r10, Object r11) {
        this.f8738c = r5;
        this.f8736a = r10;
        this.f8737b = r11;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object r5) {
        if ((r5 instanceof Map.Entry) == false) goto L10;
        Map.Entry r10 = (Map.Entry) r5;
        Object r11 = r10.getKey();
        if (this.f8736a.equals(r11) == true) goto L7;
        return false;
    L7:
        if (this.f8737b.equals(r10.getValue()) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f8736a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f8737b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        int r5 = this.f8736a.hashCode();
        return this.f8737b.hashCode() ^ r5;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object r5) {
        Object r10 = this.f8738c.put(this.f8736a, r5);
        this.f8737b = r5;
        return r10;
    }

    public final String toString() {
        String r5 = String.valueOf(this.f8736a);
        String r10 = String.valueOf(this.f8737b);
        int r11 = r5.length() + 1;
        return androidx.room.jarjarred.org.antlr.runtime.a.m(r10.length() + r11, r5, "=", r10);
    }
}
