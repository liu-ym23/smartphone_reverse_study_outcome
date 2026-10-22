package com.bytedance.android.live.revlink.link.core.layoutstatus;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n {
    public final o51.e a;
    public final f b;
    public final Map<String, com.bytedance.android.live.revlink.link.infra.rtcbiz.d> c;
    public final List<Long> d;
    public final Map<String, Integer> e;
    public final Map<String, i> f;
    public final l g;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof n) == false) goto L22;
        n r4 = (n) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(null, null) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        o51.e r0 = this.a;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        int r2 = r1 * 31;
        f r3 = this.b;
        if (r3 == null) goto L9;
        int r4 = r3.hashCode();
    L10:
        int r5 = (r2 + r4) * 31;
        Map<String, com.bytedance.android.live.revlink.link.infra.rtcbiz.d> r6 = this.c;
        if (r6 == null) goto L13;
        int r7 = r6.hashCode();
    L14:
        int r8 = (r5 + r7) * 31;
        List<Long> r9 = this.d;
        if (r9 == null) goto L17;
        int r10 = r9.hashCode();
    L18:
        int r12 = (r8 + r10) * 31;
        Map<String, Integer> r13 = this.e;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        Map<String, i> r16 = this.f;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        l r19 = this.g;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L31:
        return ((r18 + r20) * 31) + 0;
    L29:
        r20 = 0;
        goto L31
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r10 = 0;
        goto L18
    L13:
        r7 = 0;
        goto L14
    L9:
        r4 = 0;
        goto L10
    L5:
        r1 = 0;
        goto L6
    }

    public final String toString() {
        return "RequestLayoutSnapShot(uiLayout=" + this.a + ", layoutConfig=" + this.b + ", validStream=" + this.c + ", forwardControl=" + this.d + ", anchorPosition=" + this.e + ", mainBackupStreamStatus=" + this.f + ", minFrames=" + this.g + ", renderLayerInfo=null)";
    }

    public n(o51.e r1, f r2, Map r3, List r4, Map r5, Map r6, l r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
