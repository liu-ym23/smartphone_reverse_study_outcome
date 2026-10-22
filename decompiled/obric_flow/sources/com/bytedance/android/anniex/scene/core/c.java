package com.bytedance.android.anniex.scene.core;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f3386b;

    public c(String r5, long r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        this.f3385a = r5;
        this.f3386b = r10;
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof c) == false) goto L6;
        String r10 = ((c) r5).f3385a;
        return Intrinsics.areEqual(this.f3385a, r10);
    L6:
        return false;
    }

    public final int hashCode() {
        return this.f3385a.hashCode();
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("PageAttachEvent(name=");
        r5.append(this.f3385a);
        r5.append(", timestamp=");
        return androidx.room.jarjarred.org.antlr.runtime.a.t(r5, this.f3386b, ')');
    }
}
