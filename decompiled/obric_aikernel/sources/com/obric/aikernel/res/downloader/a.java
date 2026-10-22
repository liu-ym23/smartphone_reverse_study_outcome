package com.obric.aikernel.res.downloader;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f4959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f4960b;

    public a(int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "message");
        this.f4959a = r10;
        this.f4960b = r11;
    }

    public final boolean a() {
        if (this.f4959a == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final String b() {
        return this.f4960b;
    }

    public final int c() {
        return this.f4959a;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L8;
        return false;
    L8:
        a r11 = (a) r10;
        if (this.f4959a == r11.f4959a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f4960b, r11.f4960b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Integer.hashCode(this.f4959a) * 31) + this.f4960b.hashCode();
    }

    public String toString() {
        return "DownloadConstraintGate(state=" + this.f4959a + ", message=" + this.f4960b + ')';
    }
}
