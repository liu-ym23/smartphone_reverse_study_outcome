package com.bytedance.android.anniex.scene.core;

import ai.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f3411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3412c;

    public k(long r5, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "url");
        this.f3410a = r10;
        this.f3411b = r5;
        this.f3412c = r11;
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof k) == false) goto L6;
        String r10 = ((k) r5).f3410a;
        return Intrinsics.areEqual(this.f3410a, r10);
    L6:
        return false;
    }

    public final int hashCode() {
        return this.f3410a.hashCode();
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("ViewAttachEvent(url=");
        r5.append(this.f3410a);
        r5.append(", timestamp=");
        r5.append(this.f3411b);
        r5.append(", sessionId=");
        return j0.p(r5, this.f3412c, ')');
    }
}
