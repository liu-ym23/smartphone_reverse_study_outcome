package com.ss.android.lark.chat.cot.detail;

import com.ss.android.lark.chat.cot.CotBlockStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class k {
    public final String a;
    public final CotDetailBlockType b;
    public final String c;
    public final CharSequence d;
    public final CotBlockStatus e;
    public final boolean f;
    public final b g;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof k) == true) goto L8;
        return false;
    L8:
        k r6 = (k) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        String r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        CharSequence r5 = this.d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((r4 + r6) * 31) + this.e.hashCode()) * 31;
        if (this.f == false) goto L13;
        int r8 = 1231;
    L14:
        int r9 = (r7 + r8) * 31;
        b r10 = this.g;
        if (r10 == null) goto L19;
        r2 = r10.hashCode();
    L19:
        return r9 + r2;
    L13:
        r8 = 1237;
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "CotDetailItem(stableId=" + this.a + ", blockType=" + this.b + ", title=" + this.c + ", body=" + this.d + ", status=" + this.e + ", isStreaming=" + this.f + ", extra=" + this.g + ')';
    }

    public final t b() {
        b r0 = this.g;
        if ((r0 instanceof t) == false) goto L5;
        t r1 = (t) r0;
    L7:
        if (this.b != CotDetailBlockType.STATUS) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == true) goto L12;
        return null;
    L12:
        return r1;
    L9:
        r2 = false;
        goto L10
    L5:
        r1 = null;
        goto L7
    }

    public final u c() {
        b r0 = this.g;
        if ((r0 instanceof u) == false) goto L5;
        u r1 = (u) r0;
    L7:
        if (this.b != CotDetailBlockType.TOOLCALL) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == true) goto L12;
        return null;
    L12:
        return r1;
    L9:
        r2 = false;
        goto L10
    L5:
        r1 = null;
        goto L7
    }

    public static k a(k r8, b r9) {
        String r1 = r8.a;
        CotDetailBlockType r2 = r8.b;
        String r3 = r8.c;
        CharSequence r4 = r8.d;
        CotBlockStatus r5 = r8.e;
        boolean r6 = r8.f;
        Intrinsics.checkNotNullParameter(r1, "stableId");
        Intrinsics.checkNotNullParameter(r2, "blockType");
        Intrinsics.checkNotNullParameter(r5, "status");
        return new k(r1, r2, r3, r4, r5, r6, r9);
    }

    public k(String r2, CotDetailBlockType r3, String r4, CharSequence r5, CotBlockStatus r6, boolean r7, b r8) {
        Intrinsics.checkNotNullParameter(r2, "stableId");
        Intrinsics.checkNotNullParameter(r3, "blockType");
        Intrinsics.checkNotNullParameter(r6, "status");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
