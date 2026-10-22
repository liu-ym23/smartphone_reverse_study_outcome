package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f0 {
    public final String a;
    public final String b;
    public final long c;

    public f0() {
        this(null, 7);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof f0) == false) goto L12;
        f0 r6 = (f0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r6.c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L9;
        r1 = r4.hashCode();
    L9:
        int r5 = (r3 + r1) * 31;
        long r6 = this.c;
        return r5 + ((int) (r6 ^ (r6 >>> 32)));
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "StickerDialogPageStatus(tabKey=" + this.a + ", secondaryTabKey=" + this.b + ", stickerID=" + this.c + ")";
    }

    public /* synthetic */ f0(String r5, int r6) {
        String r1 = "";
        if ((r6 & 1) == 0) goto L6;
        r5 = "";
    L6:
        if ((r6 & 2) != 0) goto L9;
        r1 = null;
    L9:
        this(r5, r1, 0);
    }

    public f0(String r2, String r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "tabKey");
        Intrinsics.checkNotNullParameter(r3, "secondaryTabKey");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
