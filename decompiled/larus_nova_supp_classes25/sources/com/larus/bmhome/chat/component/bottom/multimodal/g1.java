package com.larus.bmhome.chat.component.bottom.multimodal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g1 {
    public final boolean a;
    public final MultimodalBizScene b;
    public final boolean c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g1) == true) goto L8;
        return false;
    L8:
        g1 r6 = (g1) r5;
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
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = ((r0 * 31) + this.b.hashCode()) * 31;
        if (this.c == true) goto L11;
        r1 = 1237;
    L11:
        return r2 + r1;
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "MultimodalProcessConfig(useAttachmentPanel=" + this.a + ", bizScene=" + this.b + ", notApplyNested=" + this.c + ')';
    }

    public g1(boolean r2, MultimodalBizScene r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "bizScene");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
