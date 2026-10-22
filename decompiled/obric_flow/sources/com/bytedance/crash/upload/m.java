package com.bytedance.crash.upload;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap f4140c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f4141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4142b;

    static {
        f4140c = new ConcurrentHashMap();
    }

    public m(Object r5, int r10) {
        this.f4141a = r5;
        this.f4142b = r10;
    }

    public static m a(Object r5, z8.f r10) {
        boolean r11 = r10 instanceof z8.e;
        int r12 = (r5.hashCode() * 31) + (r11 ? 1 : 0);
        ConcurrentHashMap r13 = f4140c;
        m r14 = (m) r13.get(Integer.valueOf(r12));
        if (r14 != null) goto L6;
        m r15 = new m(r5, r11 ? 1 : 0);
        r13.put(Integer.valueOf(r12), r15);
        return r15;
    L6:
        return r14;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof m) == true) goto L8;
        return false;
    L8:
        m r10 = (m) r5;
        int r11 = r10.f4142b;
        if (this.f4142b == r11) goto L12;
        return false;
    L12:
        return this.f4141a.equals(r10.f4141a);
    }

    public final int hashCode() {
        return (this.f4141a.hashCode() * 31) + this.f4142b;
    }
}
