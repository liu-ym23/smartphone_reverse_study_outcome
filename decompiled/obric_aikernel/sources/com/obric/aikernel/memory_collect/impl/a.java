package com.obric.aikernel.memory_collect.impl;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f4496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f4497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f4498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f4499d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f4500e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f4501f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f4502g;

    public a(boolean r10, int r11, int r12, int r13, int r14, int r15, int r16) {
        this.f4496a = r10;
        this.f4497b = r11;
        this.f4498c = r12;
        this.f4499d = r13;
        this.f4500e = r14;
        this.f4501f = r15;
        this.f4502g = r16;
    }

    public final boolean a() {
        return this.f4496a;
    }

    public final int b() {
        return this.f4499d;
    }

    public final int c() {
        return this.f4502g;
    }

    public final int d() {
        return this.f4498c;
    }

    public final int e() {
        return this.f4500e;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L8;
        return false;
    L8:
        a r11 = (a) r10;
        if (this.f4496a == r11.f4496a) goto L12;
        return false;
    L12:
        if (this.f4497b == r11.f4497b) goto L15;
        return false;
    L15:
        if (this.f4498c == r11.f4498c) goto L18;
        return false;
    L18:
        if (this.f4499d == r11.f4499d) goto L21;
        return false;
    L21:
        if (this.f4500e == r11.f4500e) goto L24;
        return false;
    L24:
        if (this.f4501f == r11.f4501f) goto L27;
        return false;
    L27:
        if (this.f4502g == r11.f4502g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int f() {
        return this.f4497b;
    }

    public final int g() {
        return this.f4501f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    public int hashCode() {
        boolean r10 = this.f4496a;
        ?? r11 = r10;
        if (r10 == false) goto L6;
        r11 = 1;
    L6:
        return (((((((((((r11 * 31) + Integer.hashCode(this.f4497b)) * 31) + Integer.hashCode(this.f4498c)) * 31) + Integer.hashCode(this.f4499d)) * 31) + Integer.hashCode(this.f4500e)) * 31) + Integer.hashCode(this.f4501f)) * 31) + Integer.hashCode(this.f4502g);
    }

    public String toString() {
        return "MemoryPerfDataEvent(background=" + this.f4496a + ", totalPss=" + this.f4497b + ", nativePss=" + this.f4498c + ", dalvikPss=" + this.f4499d + ", otherPss=" + this.f4500e + ", totalSwappablePss=" + this.f4501f + ", dmaBufRss=" + this.f4502g + ')';
    }
}
