package com.ss.android.lark.mention.base.impl.atselector.doubaoview;

import com.ss.android.lark.location_ui.statistics.LocationHitPoint$ResultType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j {
    public final b a;
    public final b b;
    public final String c;
    public final String d;
    public final long e;
    public final boolean f;
    public final boolean g;
    public final boolean h;

    public j() {
        boolean r0 = false;
        this(r0, r0, 255);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof j) == true) goto L8;
        return false;
    L8:
        j r9 = (j) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        long r1 = this.e;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        int r3 = 1231;
        if (this.f == false) goto L5;
        int r4 = 1231;
    L6:
        int r5 = (r2 + r4) * 31;
        if (this.g == false) goto L9;
        int r6 = 1231;
    L10:
        int r7 = (r5 + r6) * 31;
        if (this.h == true) goto L15;
        r3 = 1237;
    L15:
        return r7 + r3;
    L9:
        r6 = 1237;
        goto L10
    L5:
        r4 = 1237;
        goto L6
    }

    public final String toString() {
        return "DoubaoMentionUiState(recommend=" + this.a + ", search=" + this.b + ", searchKey=" + this.c + ", requestId=" + this.d + ", searchRefreshVersion=" + this.e + ", showDepartmentInSearch=" + this.f + ", isFromDoubaoBot=" + this.g + ", enableDoubaoMention=" + this.h + ')';
    }

    public /* synthetic */ j(boolean r13, boolean r14, int r15) {
        if ((r15 & 1) == 0) goto L5;
        b.c r3 = b.c.a;
    L7:
        if ((r15 & 2) == 0) goto L9;
        b.c r4 = b.c.a;
    L11:
        if ((r15 & 4) == 0) goto L13;
        String r5 = "";
    L15:
        if ((r15 & 8) == 0) goto L17;
        String r6 = "";
    L19:
        if ((r15 & 64) == 0) goto L21;
        boolean r10 = false;
    L23:
        if ((r15 & 128) == 0) goto L25;
        boolean r11 = true;
    L26:
        this(r3, r4, r5, r6, 0, false, r10, r11);
        return;
    L25:
        r11 = r14;
        goto L26
    L21:
        r10 = r13;
        goto L23
    L17:
        r6 = null;
        goto L19
    L13:
        r5 = null;
        goto L15
    L9:
        r4 = null;
        goto L11
    L5:
        r3 = null;
        goto L7
    }

    public j(b r2, b r3, String r4, String r5, long r6, boolean r8, boolean r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r2, "recommend");
        Intrinsics.checkNotNullParameter(r3, LocationHitPoint$ResultType.SEARCH);
        Intrinsics.checkNotNullParameter(r4, "searchKey");
        Intrinsics.checkNotNullParameter(r5, "requestId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r8;
        this.g = r9;
        this.h = r10;
    }

    public static j a(j r10, b r11, b r12, String r13, String r14, long r15, boolean r17, boolean r18, int r19) {
        if ((r19 & 1) == 0) goto L5;
        b r2 = r10.a;
    L7:
        if ((r19 & 2) == 0) goto L9;
        b r3 = r10.b;
    L11:
        if ((r19 & 4) == 0) goto L13;
        String r4 = r10.c;
    L15:
        if ((r19 & 8) == 0) goto L17;
        String r5 = r10.d;
    L19:
        if ((r19 & 16) == 0) goto L21;
        long r6 = r10.e;
    L23:
        if ((r19 & 32) == 0) goto L25;
        boolean r8 = r10.f;
    L27:
        if ((r19 & 64) == 0) goto L29;
        boolean r9 = r10.g;
    L31:
        if ((r19 & 128) == 0) goto L33;
        boolean r1 = r10.h;
    L34:
        r10.getClass();
        Intrinsics.checkNotNullParameter(r2, "recommend");
        Intrinsics.checkNotNullParameter(r3, LocationHitPoint$ResultType.SEARCH);
        Intrinsics.checkNotNullParameter(r4, "searchKey");
        Intrinsics.checkNotNullParameter(r5, "requestId");
        return new j(r2, r3, r4, r5, r6, r8, r9, r1);
    L33:
        r1 = r18;
        goto L34
    L29:
        r9 = false;
        goto L31
    L25:
        r8 = r17;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r2 = r11;
        goto L7
    }
}
