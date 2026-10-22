package com.larus.share.service;

import com.larus.bmhome.share.ShareScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e {
    public final ShareScene a;
    public final com.larus.bmhome.share.panel.b b;
    public final com.larus.bmhome.share.panel.h c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (this.a == r6.a) goto L12;
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
        return "SaasSharePanelContext(shareScene=" + this.a + ", shareContent=" + this.b + ", eventParam=" + this.c + ')';
    }

    public e(ShareScene r2, com.larus.bmhome.share.panel.b r3, com.larus.bmhome.share.panel.h r4) {
        Intrinsics.checkNotNullParameter(r2, "shareScene");
        Intrinsics.checkNotNullParameter(r3, "shareContent");
        Intrinsics.checkNotNullParameter(r4, "eventParam");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
