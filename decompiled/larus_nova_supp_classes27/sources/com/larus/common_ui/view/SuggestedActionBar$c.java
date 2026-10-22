package com.larus.common_ui.view;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class SuggestedActionBar$c {
    public final String a;
    public final int b;
    public final String c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final Integer h;

    public SuggestedActionBar$c() {
        this(null, 0, null, false, false, 255);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SuggestedActionBar$c) == true) goto L8;
        return false;
    L8:
        SuggestedActionBar$c r6 = (SuggestedActionBar$c) r5;
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
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode()) * 31;
        int r2 = 1231;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.e == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        if (this.f == false) goto L13;
        int r6 = 1231;
    L14:
        int r7 = (r5 + r6) * 31;
        if (this.g == true) goto L18;
        r2 = 1237;
    L18:
        int r8 = (r7 + r2) * 31;
        Integer r9 = this.h;
        if (r9 != null) goto L21;
        int r10 = 0;
    L23:
        return r8 + r10;
    L21:
        r10 = r9.hashCode();
        goto L23
    L13:
        r6 = 1237;
        goto L14
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "SuggestedActionBarItem(key=" + this.a + ", row=" + this.b + ", displayName=" + this.c + ", highlight=" + this.d + ", loading=" + this.e + ", showIcon=" + this.f + ", selected=" + this.g + ", textColor=" + this.h + ')';
    }

    public SuggestedActionBar$c(String r4, int r5, String r6, boolean r7, boolean r8, int r9) {
        if ((r9 & 1) == 0) goto L6;
        r4 = "";
    L6:
        if ((r9 & 2) == 0) goto L9;
        r5 = 0;
    L9:
        if ((r9 & 4) == 0) goto L12;
        r6 = "";
    L12:
        if ((r9 & 8) == 0) goto L15;
        r7 = false;
    L15:
        if ((r9 & 16) == 0) goto L18;
        r8 = false;
    L18:
        if ((r9 & 32) == 0) goto L20;
        boolean r10 = true;
    L21:
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r6, "displayName");
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r10;
        this.g = false;
        this.h = null;
        return;
    L20:
        r10 = false;
        goto L21
    }
}
