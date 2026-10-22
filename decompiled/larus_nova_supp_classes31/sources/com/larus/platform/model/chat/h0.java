package com.larus.platform.model.chat;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class h0 {
    public final l a;
    public final m b;
    public final k0 c;

    public h0() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof h0) == true) goto L8;
        return false;
    L8:
        h0 r6 = (h0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "NewPreviewTotalConfig(sendImageConfig=" + this.a + ", creationImageConfig=" + this.b + ", previewPageConfig=" + this.c + ')';
    }

    public /* synthetic */ h0(int r4) {
        this(new l(0), new m(false, 0), new k0(true));
    }

    public h0(l r2, m r3, k0 r4) {
        Intrinsics.checkNotNullParameter(r2, "sendImageConfig");
        Intrinsics.checkNotNullParameter(r3, "creationImageConfig");
        Intrinsics.checkNotNullParameter(r4, "previewPageConfig");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
