package com.bytedance.ai.applet.app.foundation.performance;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class o {
    public final long a;
    public final long b;
    public final Long c;
    public final Long d;
    public final Long e;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof o) == true) goto L8;
        return false;
    L8:
        o r11 = (o) r10;
        if (this.a == r11.a) goto L12;
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
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r10 = this.b;
        int r11 = (r1 + ((int) (r10 ^ (r10 >>> 32)))) * 31;
        Long r12 = this.c;
        int r13 = 0;
        if (r12 != null) goto L5;
        int r14 = 0;
    L6:
        int r15 = (r11 + r14) * 31;
        Long r16 = this.d;
        if (r16 != null) goto L9;
        int r17 = 0;
    L10:
        int r18 = (r15 + r17) * 31;
        Long r19 = this.e;
        if (r19 == null) goto L15;
        r13 = r19.hashCode();
    L15:
        return r18 + r13;
    L9:
        r17 = r16.hashCode();
        goto L10
    L5:
        r14 = r12.hashCode();
        goto L6
    }

    public final String toString() {
        return "FirstRenderTiming(startTime=" + this.a + ", endTime=" + this.b + ", viewLayerReadyTime=" + this.c + ", viewLayerRenderStartTime=" + this.d + ", viewLayerRenderEndTime=" + this.e + ')';
    }

    public final boolean a(long r10) {
        long r0 = this.a;
        if (r0 >= r10) goto L5;
        return false;
    L5:
        if (this.b < r0) goto L38;
        List r11 = CollectionsKt.listOfNotNull(new Long[]{this.c, this.d, this.e});
        if ((r11 instanceof Collection) == true) goto L10;
    L12:
        Iterator r12 = r11.iterator();
    L14:
        if (r12.hasNext() == false) goto L11;
        long r13 = ((Number) r12.next()).longValue();
        long r14 = this.a;
        if (r13 <= this.b) goto L18;
    L20:
        boolean r15 = false;
    L22:
        if ((!r15) == false) goto L14;
        boolean r16 = true;
    L24:
        if (r16 == false) goto L26;
        return false;
    L26:
        Long r17 = this.d;
        Long r18 = this.e;
        if (r17 == null) goto L31;
        if (r18 == null) goto L31;
        if (r18.longValue() >= r17.longValue()) goto L31;
        return false;
    L31:
        return true;
    L18:
        if (r14 > r13) goto L20;
        r15 = true;
    L11:
        r16 = false;
        goto L24
    L10:
        if (r11.isEmpty() == false) goto L12;
    L38:
        return false;
    }

    public o(long r1, long r10, Long r11, Long r12, Long r13) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
    }
}
