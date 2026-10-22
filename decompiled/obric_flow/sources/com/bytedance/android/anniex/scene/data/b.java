package com.bytedance.android.anniex.scene.data;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f3426b;

    public b(int r5, LinkedHashMap r10) {
        Intrinsics.checkNotNullParameter(r10, "transitions");
        this.f3425a = r5;
        this.f3426b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r10 = (b) r5;
        int r11 = r10.f3425a;
        if (this.f3425a == r11) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f3426b, r10.f3426b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = Integer.hashCode(this.f3425a) * 31;
        return this.f3426b.hashCode() + r5;
    }

    public final String toString() {
        return "SceneQueryInfo(currentCount=" + this.f3425a + ", transitions=" + this.f3426b + ')';
    }
}
