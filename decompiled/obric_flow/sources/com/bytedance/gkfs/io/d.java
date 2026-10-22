package com.bytedance.gkfs.io;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f4859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f4860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.gkfs.storage.e f4861c;

    public d(f r5, com.bytedance.gkfs.storage.e r10) {
        this.f4860b = r5;
        this.f4861c = r10;
        this.f4859a = r5.f4865a;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof d) == false) goto L10;
        d r10 = (d) r5;
        f r11 = r10.f4860b;
        if (Intrinsics.areEqual(this.f4860b, r11) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f4861c, r10.f4861c) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r5 = 0;
        f r10 = this.f4860b;
        if (r10 == null) goto L5;
        int r11 = r10.hashCode();
    L6:
        int r12 = r11 * 31;
        com.bytedance.gkfs.storage.e r13 = this.f4861c;
        if (r13 == null) goto L10;
        r5 = r13.hashCode();
    L10:
        return r12 + r5;
    L5:
        r11 = 0;
        goto L6
    }

    public final String toString() {
        return "GkFSChunk(meta=" + this.f4860b + ", storageInfo=" + this.f4861c + ")";
    }
}
