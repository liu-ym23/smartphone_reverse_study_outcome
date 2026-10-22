package com.bytedance.lynx.service.reporter.performance;

import ai.j0;
import com.lynx.tasm.behavior.v0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f6848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f6849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6850c;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof d) == true) goto L8;
        return false;
    L8:
        d r11 = (d) r10;
        if (Intrinsics.areEqual(this.f6848a, r11.f6848a) == true) goto L12;
        return false;
    L12:
        if (this.f6849b == r11.f6849b) goto L15;
        return false;
    L15:
        if (this.f6850c == r11.f6850c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r5 = v0.a(this.f6848a.hashCode() * 31, this.f6849b);
        return Integer.hashCode(this.f6850c) + r5;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("LynxURLMemoryInfo(url=");
        r5.append(this.f6848a);
        r5.append(", totalBytes=");
        r5.append(this.f6849b);
        r5.append(", instanceCount=");
        return j0.n(r5, this.f6850c, ')');
    }
}
