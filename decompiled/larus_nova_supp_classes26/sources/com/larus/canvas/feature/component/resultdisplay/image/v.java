package com.larus.canvas.feature.component.resultdisplay.image;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class v {
    public final CanvasSaveActionPlacement a;
    public final boolean b;
    public final boolean c;

    public v() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof v) == true) goto L8;
        return false;
    L8:
        v r6 = (v) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        int r2 = 1231;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.c == true) goto L11;
        r2 = 1237;
    L11:
        return r3 + r2;
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "ImageSaveActionUiState(placement=" + this.a + ", visible=" + this.b + ", allowResaveAfterSuccess=" + this.c + ')';
    }

    public /* synthetic */ v(int r2) {
        this(CanvasSaveActionPlacement.TITLE_RIGHT, false, false);
    }

    public final boolean a(y r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        if (b(r2) == false) goto L13;
        w r3 = r2.j;
        if (r3.b == false) goto L13;
        if (r3.c == true) goto L13;
        if (this.c == false) goto L11;
    L12:
        return true;
    L11:
        if (r3.d == false) goto L12;
    L13:
        return false;
    }

    public final boolean b(y r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        if (this.b == true) goto L5;
    L11:
        return false;
    L5:
        if (this.a != CanvasSaveActionPlacement.IMAGE_OVERLAY_BOTTOM_START) goto L11;
        if (r3.i == false) goto L11;
        if (r3.j.a == false) goto L11;
        return true;
    }

    public v(CanvasSaveActionPlacement r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "placement");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
