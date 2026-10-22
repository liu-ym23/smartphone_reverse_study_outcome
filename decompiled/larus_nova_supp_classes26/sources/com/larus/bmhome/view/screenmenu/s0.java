package com.larus.bmhome.view.screenmenu;

import com.larus.bmhome.share.panel.ShareType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class s0 implements ot8.a {
    public final int a;
    public final String b;
    public final boolean c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof s0) == true) goto L8;
        return false;
    L8:
        s0 r6 = (s0) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a * 31) + this.b.hashCode()) * 31;
        if (this.c == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "MenuTimeStamp(id=" + this.a + ", text=" + this.b + ", removeAroundDivider=" + this.c + ')';
    }

    @Override // ot8.a
    public final boolean a() {
        return this.c;
    }

    @Override // ot8.a
    public final int getId() {
        return this.a;
    }

    public s0(String r2) {
        Intrinsics.checkNotNullParameter(r2, ShareType.TEXT);
        this.a = 2131392528;
        this.b = r2;
        this.c = true;
    }
}
