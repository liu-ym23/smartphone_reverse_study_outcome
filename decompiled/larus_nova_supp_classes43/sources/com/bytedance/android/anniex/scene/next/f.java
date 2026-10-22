package com.bytedance.android.anniex.scene.next;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f implements a {
    public final String a;
    public final boolean b;
    public final Double c;
    public final Double d;
    public final Map<String, Object> e;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof f) == true) goto L8;
        return false;
    L8:
        f r11 = (f) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r11.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r10 = (r0 + r1) * 31;
        Double r11 = this.c;
        int r12 = 0;
        if (r11 != null) goto L9;
        int r13 = 0;
    L10:
        int r14 = (r10 + r13) * 31;
        Double r15 = this.d;
        if (r15 != null) goto L13;
        int r16 = 0;
    L14:
        int r17 = (r14 + r16) * 31;
        Map<String, Object> r18 = this.e;
        if (r18 == null) goto L19;
        r12 = r18.hashCode();
    L19:
        return r17 + r12;
    L13:
        r16 = r15.hashCode();
        goto L14
    L9:
        r13 = r11.hashCode();
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "SceneRepeatInput(currentSceneId=" + this.a + ", isFirstShow=" + this.b + ", avgDuration=" + this.c + ", repeatRate=" + this.d + ", extraParams=" + this.e + ')';
    }

    public f(String r10, boolean r11, Double r12, Double r13, Map<String, ? extends Object> r14) {
        Intrinsics.checkNotNullParameter(r10, "currentSceneId");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
    }
}
