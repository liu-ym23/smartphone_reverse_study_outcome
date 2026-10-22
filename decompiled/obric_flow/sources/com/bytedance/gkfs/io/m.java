package com.bytedance.gkfs.io;

import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f4892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f4893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.gkfs.cdc.c f4894c;
    public final l d;

    public m(j r5, File r10, com.bytedance.gkfs.cdc.c r11, l r12) {
        this.f4892a = r5;
        this.f4893b = r10;
        this.f4894c = r11;
        this.d = r12;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof m) == false) goto L14;
        m r10 = (m) r5;
        j r11 = r10.f4892a;
        if (Intrinsics.areEqual(this.f4892a, r11) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f4893b, r10.f4893b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f4894c, r10.f4894c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        int r5 = 0;
        j r10 = this.f4892a;
        if (r10 == null) goto L5;
        int r11 = r10.hashCode();
    L6:
        int r12 = r11 * 31;
        File r13 = this.f4893b;
        if (r13 == null) goto L9;
        int r14 = r13.hashCode();
    L10:
        int r15 = (r12 + r14) * 31;
        com.bytedance.gkfs.cdc.c r16 = this.f4894c;
        if (r16 == null) goto L13;
        int r17 = r16.hashCode();
    L14:
        int r18 = (r15 + r17) * 31;
        l r19 = this.d;
        if (r19 == null) goto L18;
        r5 = r19.hashCode();
    L18:
        return r18 + r5;
    L13:
        r17 = 0;
        goto L14
    L9:
        r14 = 0;
        goto L10
    L5:
        r11 = 0;
        goto L6
    }

    public final String toString() {
        return "GkFSOutputInfo(meta=" + this.f4892a + ", originFile=" + this.f4893b + ", cdcStatistics=" + this.f4894c + ", storeStatistics=" + this.d + ")";
    }
}
