package com.bytedance.iesgurd;

import java.io.FileInputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f6616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IESGurdResFrom f6617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f6618c;
    public final String d;
    public FileInputStream e;

    public d(e r5, IESGurdResFrom r10, long r11, String r12, int r13) {
        if ((r13 & 1) == 0) goto L6;
        r5 = null;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r10 = IESGurdResFrom.f6587a;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r11 = 0;
    L12:
        if ((r13 & 8) == 0) goto L14;
        r12 = null;
    L14:
        this.f6616a = r5;
        this.f6617b = r10;
        this.f6618c = r11;
        this.d = r12;
        this.e = null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof d) == false) goto L16;
        d r10 = (d) r5;
        e r11 = r10.f6616a;
        if (Intrinsics.areEqual(this.f6616a, r11) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f6617b, r10.f6617b) == true) goto L10;
        return false;
    L10:
        if (this.f6618c == r10.f6618c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        int r5 = 0;
        e r10 = this.f6616a;
        if (r10 == null) goto L5;
        int r11 = r10.hashCode();
    L6:
        int r12 = r11 * 31;
        IESGurdResFrom r13 = this.f6617b;
        if (r13 == null) goto L9;
        int r14 = r13.hashCode();
    L10:
        int r15 = (r12 + r14) * 31;
        long r16 = this.f6618c;
        int r17 = (r15 + ((int) (r16 ^ (r16 >>> 32)))) * 31;
        String r18 = this.d;
        if (r18 == null) goto L13;
        int r19 = r18.hashCode();
    L14:
        int r20 = (r17 + r19) * 31;
        FileInputStream r21 = this.e;
        if (r21 == null) goto L18;
        r5 = r21.hashCode();
    L18:
        return r20 + r5;
    L13:
        r19 = 0;
        goto L14
    L9:
        r14 = 0;
        goto L10
    L5:
        r11 = 0;
        goto L6
    }

    public final String toString() {
        return "IESGurdResData(error=" + this.f6616a + ", resFrom=" + this.f6617b + ", id=" + this.f6618c + ", path=" + this.d + ", data=" + this.e + ")";
    }
}
