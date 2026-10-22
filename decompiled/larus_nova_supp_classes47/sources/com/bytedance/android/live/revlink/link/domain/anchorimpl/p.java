package com.bytedance.android.live.revlink.link.domain.anchorimpl;

import android.graphics.RectF;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p {
    public final String a;
    public final boolean b;
    public final RectF c;
    public final RectF d;
    public final int e;
    public final Function0<Unit> f;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof p) == false) goto L18;
        p r4 = (p) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (this.e == r4.e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        boolean r4 = this.b;
        ?? r5 = r4;
        if (r4 == false) goto L9;
        r5 = 1;
    L9:
        int r6 = (r3 + r5) * 31;
        RectF r7 = this.c;
        if (r7 == null) goto L12;
        int r8 = r7.hashCode();
    L13:
        int r9 = (r6 + r8) * 31;
        RectF r10 = this.d;
        if (r10 == null) goto L16;
        int r12 = r10.hashCode();
    L17:
        int r13 = (((r9 + r12) * 31) + this.e) * 31;
        Function0<Unit> r14 = this.f;
        if (r14 == null) goto L21;
        r1 = r14.hashCode();
    L21:
        return r13 + r1;
    L16:
        r12 = 0;
        goto L17
    L12:
        r8 = 0;
        goto L13
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "RenderState(zOrder=" + this.e + ", layerRectF={width=" + this.d.width() + ", height=" + this.d.height() + ",top=" + this.d.top + ", bottom=" + this.d.bottom + "}, screenRectF={width=" + this.c.width() + ", height=" + this.c.height() + ", top=" + this.c.top + ", bottom=" + this.c.bottom + ", visible=" + this.b + ", linkerID='" + this.a + "')";
    }

    public /* synthetic */ p(String r8, RectF r9, RectF r10) {
        this(r8, true, r9, r10, 0, null);
    }

    public p(String r2, boolean r3, RectF r4, RectF r5, int r6, Function0<Unit> r7) {
        Intrinsics.checkNotNullParameter(r2, "linkerID");
        Intrinsics.checkNotNullParameter(r4, "screenRectF");
        Intrinsics.checkNotNullParameter(r5, "layerRectF");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
