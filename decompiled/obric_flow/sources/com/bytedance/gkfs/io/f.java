package com.bytedance.gkfs.io;

import ai.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f4865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f4866b;

    public f(c r5, long r10) {
        this.f4865a = r5;
        this.f4866b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof f) == false) goto L10;
        f r10 = (f) r5;
        c r11 = r10.f4865a;
        if (Intrinsics.areEqual(this.f4865a, r11) == true) goto L8;
        return false;
    L8:
        if (this.f4866b == r10.f4866b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        c r5 = this.f4865a;
        if (r5 == null) goto L5;
        int r10 = r5.f4858a.hashCode();
    L6:
        long r11 = this.f4866b;
        return (r10 * 31) + ((int) (r11 ^ (r11 >>> 32)));
    L5:
        r10 = 0;
        goto L6
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("GkFSChunkMeta(id=");
        r5.append(this.f4865a);
        r5.append(", offset=");
        return j0.o(r5, this.f4866b, ")");
    }
}
