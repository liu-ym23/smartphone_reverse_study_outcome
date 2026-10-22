package com.bytedance.android.anniex.scene.core;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f3394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.anniex.scene.data.b f3395b;

    public g(f r5, com.bytedance.android.anniex.scene.data.b r10) {
        Intrinsics.checkNotNullParameter(r5, "sceneFingerprint");
        Intrinsics.checkNotNullParameter(r10, "queryInfo");
        this.f3394a = r5;
        this.f3395b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r10 = (g) r5;
        f r11 = r10.f3394a;
        if (Intrinsics.areEqual(this.f3394a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f3395b, r10.f3395b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f3394a.hashCode() * 31;
        return this.f3395b.hashCode() + r5;
    }

    public final String toString() {
        return "SceneInfoCollection(sceneFingerprint=" + this.f3394a + ", queryInfo=" + this.f3395b + ')';
    }
}
