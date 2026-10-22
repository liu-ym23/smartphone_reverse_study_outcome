package com.bytedance.android.accessibilityLib_Core.config.remote.dsl;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public final EventType a;
    public final d b;
    public final Map<String, d> c;
    public String d;

    public b() {
        throw null;
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof b) == false) goto L14;
        b r11 = (b) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        EventType r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        d r12 = this.b;
        if (r12 == null) goto L9;
        int r13 = r12.hashCode();
    L10:
        int r14 = (r11 + r13) * 31;
        Map<String, d> r15 = this.c;
        if (r15 == null) goto L13;
        int r16 = r15.hashCode();
    L14:
        int r17 = (r14 + r16) * 31;
        String r18 = this.d;
        if (r18 == null) goto L18;
        r1 = r18.hashCode();
    L18:
        return r17 + r1;
    L13:
        r16 = 0;
        goto L14
    L9:
        r13 = 0;
        goto L10
    L5:
        r10 = 0;
        goto L6
    }

    public final String toString() {
        return "EventConfigDsl(type='" + this.a + "', label=" + this.b + ", map=" + this.c + ", extra=" + this.d + ')';
    }

    public final EventType getType() {
        return this.a;
    }

    public b(EventType r1, d r10, Map r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = null;
    }
}
