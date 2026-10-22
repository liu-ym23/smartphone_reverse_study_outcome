package com.bytedance.ai.resource;

import ai.j0;
import android.os.SystemClock;
import com.lynx.tasm.behavior.v0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f2764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2765c;
    public final String d;

    public x(String r5, String r10, int r11) {
        long r12 = SystemClock.elapsedRealtime();
        String r13 = Thread.currentThread().getName();
        if ((r11 & 8) == 0) goto L5;
        r10 = null;
    L5:
        Intrinsics.checkNotNullParameter(r5, "stage");
        Intrinsics.checkNotNullParameter(r13, "threadName");
        this.f2763a = r5;
        this.f2764b = r12;
        this.f2765c = r13;
        this.d = r10;
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof x) == true) goto L8;
        return false;
    L8:
        x r11 = (x) r10;
        String r5 = r11.f2763a;
        if (Intrinsics.areEqual(this.f2763a, r5) == true) goto L12;
        return false;
    L12:
        if (this.f2764b == r11.f2764b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f2765c, r11.f2765c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r5 = v0.a(this.f2763a.hashCode() * 31, this.f2764b);
        int r10 = kk.a.b(this.f2765c, r5, 31);
        String r11 = this.d;
        if (r11 != null) goto L5;
        int r12 = 0;
    L7:
        return r10 + r12;
    L5:
        r12 = r11.hashCode();
        goto L7
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("StageRecord(stage=");
        r5.append(this.f2763a);
        r5.append(", startedAtMs=");
        r5.append(this.f2764b);
        r5.append(", threadName=");
        r5.append(this.f2765c);
        r5.append(", detail=");
        return j0.p(r5, this.d, ')');
    }
}
