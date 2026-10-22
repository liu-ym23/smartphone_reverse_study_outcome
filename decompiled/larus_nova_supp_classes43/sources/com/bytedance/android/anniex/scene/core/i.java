package com.bytedance.android.anniex.scene.core;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i {
    public final h a;
    public final com.bytedance.android.anniex.scene.data.b b;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof i) == true) goto L8;
        return false;
    L8:
        i r11 = (i) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "SceneInfoCollection(sceneFingerprint=" + this.a + ", queryInfo=" + this.b + ')';
    }

    public i(h r10, com.bytedance.android.anniex.scene.data.b r11) {
        Intrinsics.checkNotNullParameter(r10, "sceneFingerprint");
        Intrinsics.checkNotNullParameter(r11, "queryInfo");
        this.a = r10;
        this.b = r11;
    }
}
