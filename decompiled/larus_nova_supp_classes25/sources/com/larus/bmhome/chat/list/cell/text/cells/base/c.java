package com.larus.bmhome.chat.list.cell.text.cells.base;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c {
    public final CellComponentType a;
    public final int b;
    public final int c;
    public int d;
    public int e;
    public final HashMap<Object, Object> f;

    public c() {
        this(null, 0, 0, 63);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.a.hashCode() * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f.hashCode();
    }

    public final String toString() {
        return "CellComponentInfo(cellComponentType=" + this.a + ", indexInKind=" + this.b + ", countInKind=" + this.c + ", indexInAll=" + this.d + ", countInAll=" + this.e + ", ext=" + this.f + ')';
    }

    public c(CellComponentType r5, int r6, int r7, int r8) {
        if ((r8 & 1) == 0) goto L5;
        r5 = CellComponentType.UNKNOWN;
    L5:
        int r1 = -1;
        if ((r8 & 2) == 0) goto L9;
        r6 = -1;
    L9:
        if ((r8 & 4) == 0) goto L12;
        r7 = -1;
    L12:
        if ((r8 & 8) == 0) goto L14;
        int r0 = -1;
    L16:
        if ((r8 & 16) != 0) goto L20;
        r1 = 0;
    L20:
        if ((r8 & 32) == 0) goto L22;
        HashMap<Object, Object> r9 = new HashMap();
    L23:
        Intrinsics.checkNotNullParameter(r5, "cellComponentType");
        Intrinsics.checkNotNullParameter(r9, "ext");
        this.a = r5;
        this.b = r6;
        this.c = r7;
        this.d = r0;
        this.e = r1;
        this.f = r9;
        return;
    L22:
        r9 = null;
        goto L23
    L14:
        r0 = 0;
        goto L16
    }
}
