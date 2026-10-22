package com.obric.aikernel.res.update;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f5173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f5174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.google.gson.k f5175d;

    public e(String r10, String r11, String r12, com.google.gson.k r13) {
        Intrinsics.checkNotNullParameter(r13, "data");
        this.f5172a = r10;
        this.f5173b = r11;
        this.f5174c = r12;
        this.f5175d = r13;
    }

    public final com.google.gson.k a() {
        return this.f5175d;
    }

    public final String b() {
        return this.f5174c;
    }

    public final String c() {
        return this.f5173b;
    }

    public final String d() {
        return this.f5172a;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof e) == true) goto L8;
        return false;
    L8:
        e r11 = (e) r10;
        if (Intrinsics.areEqual(this.f5172a, r11.f5172a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f5173b, r11.f5173b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f5174c, r11.f5174c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f5175d, r11.f5175d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r10 = this.f5172a;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        String r14 = this.f5173b;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        String r17 = this.f5174c;
        if (r17 == null) goto L15;
        r11 = r17.hashCode();
    L15:
        return ((r16 + r11) * 31) + this.f5175d.hashCode();
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public String toString() {
        return "MetadataResponseEnvelope(status=" + this.f5172a + ", message=" + this.f5173b + ", extra=" + this.f5174c + ", data=" + this.f5175d + ')';
    }
}
