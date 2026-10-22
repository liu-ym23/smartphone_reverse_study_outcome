package com.bytedance.gkfs.cdc;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.gkfs.io.c f4819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final cb.a f4821c;

    public a(com.bytedance.gkfs.io.c r5, int r10, cb.a r11) {
        this.f4819a = r5;
        this.f4820b = r10;
        this.f4821c = r11;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r10 = (a) r5;
        com.bytedance.gkfs.io.c r11 = r10.f4819a;
        if (Intrinsics.areEqual(this.f4819a, r11) == true) goto L12;
        return false;
    L12:
        if (this.f4820b == r10.f4820b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f4819a.f4858a.hashCode() * 31) + this.f4820b;
    }

    public final String toString() {
        return "GkFSCDCChunkInfo(id=" + this.f4819a + ", from=" + this.f4820b + ", bytes=" + this.f4821c + ")";
    }
}
