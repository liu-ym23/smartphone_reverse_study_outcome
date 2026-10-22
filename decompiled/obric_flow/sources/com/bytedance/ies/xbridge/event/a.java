package com.bytedance.ies.xbridge.event;

import ai.j0;
import com.lynx.tasm.behavior.v0;
import java.util.HashMap;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f6324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HashMap f6325c;

    public a(String r5, long r10) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        this.f6323a = r5;
        this.f6324b = r10;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object r5) {
        a r10 = (a) r5;
        Intrinsics.checkNotNullParameter(r10, "other");
        long r11 = r10.f6324b;
        long r12 = this.f6324b;
        if (r12 != r11) goto L5;
        return -1;
    L5:
        return ComparisonsKt.compareValues(Long.valueOf(r12), Long.valueOf(r10.f6324b));
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L8;
        return false;
    L8:
        a r11 = (a) r10;
        String r5 = r11.f6323a;
        if (Intrinsics.areEqual(this.f6323a, r5) == true) goto L12;
        return false;
    L12:
        if (this.f6324b == r11.f6324b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(null, null) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return v0.a(this.f6323a.hashCode() * 31, this.f6324b);
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("Event(eventName=");
        r5.append(this.f6323a);
        r5.append(", timestamp=");
        return j0.o(r5, this.f6324b, ", params=null)");
    }
}
