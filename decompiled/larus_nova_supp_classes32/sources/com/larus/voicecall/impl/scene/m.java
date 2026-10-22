package com.larus.voicecall.impl.scene;

import com.larus.im.bean.bot.SceneModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class m {
    public final SceneModel a;
    public int b;
    public final Integer c;
    public final boolean d;
    public final boolean e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof m) == true) goto L8;
        return false;
    L8:
        m r6 = (m) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b) * 31;
        Integer r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (r0 + r2) * 31;
        int r4 = 1231;
        if (this.d == false) goto L9;
        int r5 = 1231;
    L10:
        int r6 = (r3 + r5) * 31;
        if (this.e == true) goto L15;
        r4 = 1237;
    L15:
        return r6 + r4;
    L9:
        r5 = 1237;
        goto L10
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "SceneDisplayItem(model=" + this.a + ", status=" + this.b + ", clickTraceId=" + this.c + ", disableExit=" + this.d + ", disableChange=" + this.e + ')';
    }

    public static m a(m r7, int r8, Integer r9, int r10) {
        if ((r10 & 1) == 0) goto L5;
        SceneModel r0 = r7.a;
    L6:
        SceneModel r2 = r0;
        if ((r10 & 2) == 0) goto L9;
        r8 = r7.b;
    L9:
        int r3 = r8;
        if ((r10 & 4) == 0) goto L12;
        r9 = r7.c;
    L12:
        Integer r4 = r9;
        if ((r10 & 8) == 0) goto L15;
        boolean r5 = r7.d;
    L17:
        if ((r10 & 16) == 0) goto L19;
        boolean r6 = r7.e;
    L20:
        r7.getClass();
        Intrinsics.checkNotNullParameter(r2, "model");
        return new m(r2, r3, r4, r5, r6);
    L19:
        r6 = false;
        goto L20
    L15:
        r5 = false;
        goto L17
    L5:
        r0 = null;
        goto L6
    }

    public m(SceneModel r2, int r3, Integer r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "model");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
