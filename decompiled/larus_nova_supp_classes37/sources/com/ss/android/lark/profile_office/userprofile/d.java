package com.ss.android.lark.profile_office.userprofile;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final boolean g;

    public d() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
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
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.b == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.c == false) goto L13;
        int r5 = 1231;
    L14:
        int r6 = (r4 + r5) * 31;
        if (this.d == false) goto L17;
        int r7 = 1231;
    L18:
        int r8 = (r6 + r7) * 31;
        if (this.e == false) goto L21;
        int r9 = 1231;
    L22:
        int r10 = (r8 + r9) * 31;
        if (this.f == false) goto L25;
        int r11 = 1231;
    L26:
        int r12 = (r10 + r11) * 31;
        if (this.g == true) goto L31;
        r1 = 1237;
    L31:
        return r12 + r1;
    L25:
        r11 = 1237;
        goto L26
    L21:
        r9 = 1237;
        goto L22
    L17:
        r7 = 1237;
        goto L18
    L13:
        r5 = 1237;
        goto L14
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "OfficeProfileDialogState(showEditAliasDialog=" + this.a + ", isSavingAlias=" + this.b + ", showApplyFriendDialog=" + this.c + ", isSendingFriendRequest=" + this.d + ", showReportPopup=" + this.e + ", showDeleteFriendDialog=" + this.f + ", showBlockedDialog=" + this.g + ')';
    }

    public /* synthetic */ d(int r9) {
        this(false, false, false, false, false, false, false);
    }

    public d(boolean r1, boolean r2, boolean r3, boolean r4, boolean r5, boolean r6, boolean r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    public static d a(d r8, boolean r9, boolean r10, boolean r11, boolean r12, boolean r13, boolean r14, boolean r15, int r16) {
        if ((r16 & 1) == 0) goto L5;
        boolean r1 = r8.a;
    L7:
        if ((r16 & 2) == 0) goto L9;
        boolean r2 = r8.b;
    L11:
        if ((r16 & 4) == 0) goto L13;
        boolean r3 = r8.c;
    L15:
        if ((r16 & 8) == 0) goto L17;
        boolean r4 = r8.d;
    L19:
        if ((r16 & 16) == 0) goto L21;
        boolean r5 = r8.e;
    L23:
        if ((r16 & 32) == 0) goto L25;
        boolean r6 = r8.f;
    L27:
        if ((r16 & 64) == 0) goto L29;
        boolean r7 = r8.g;
    L30:
        r8.getClass();
        return new d(r1, r2, r3, r4, r5, r6, r7);
    L29:
        r7 = r15;
        goto L30
    L25:
        r6 = r14;
        goto L27
    L21:
        r5 = r13;
        goto L23
    L17:
        r4 = r12;
        goto L19
    L13:
        r3 = r11;
        goto L15
    L9:
        r2 = r10;
        goto L11
    L5:
        r1 = r9;
        goto L7
    }
}
