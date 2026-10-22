package com.ss.android.lark.compose.groupinfo;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e {
    public final String a;
    public final String b;
    public final String c;
    public final boolean d;
    public final String e;
    public final long f;
    public final boolean g;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof e) == true) goto L8;
        return false;
    L8:
        e r9 = (e) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        int r2 = 1231;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (((r0 + r1) * 31) + this.e.hashCode()) * 31;
        long r4 = this.f;
        int r5 = (r3 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        if (this.g == true) goto L11;
        r2 = 1237;
    L11:
        return r5 + r2;
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "GroupInfoState(initialChatName=" + this.a + ", initialAvatarKey=" + this.b + ", chatName=" + this.c + ", canEdit=" + this.d + ", selectedImageUri=" + this.e + ", avatarRefreshKey=" + this.f + ", isUpdating=" + this.g + ')';
    }

    public e(String r2, String r3, String r4, boolean r5, String r6, long r7, boolean r9) {
        Intrinsics.checkNotNullParameter(r2, "initialChatName");
        Intrinsics.checkNotNullParameter(r3, "initialAvatarKey");
        Intrinsics.checkNotNullParameter(r4, "chatName");
        Intrinsics.checkNotNullParameter(r6, "selectedImageUri");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r9;
    }

    public static e a(e r11, String r12, String r13, String r14, long r15, boolean r17, int r18) {
        if ((r18 & 1) == 0) goto L5;
        String r3 = r11.a;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r1 = r11.b;
    L10:
        String r4 = r1;
        if ((r18 & 4) == 0) goto L13;
        String r5 = r11.c;
    L15:
        if ((r18 & 8) == 0) goto L17;
        boolean r6 = r11.d;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r7 = r11.e;
    L23:
        if ((r18 & 32) == 0) goto L25;
        long r8 = r11.f;
    L27:
        if ((r18 & 64) == 0) goto L29;
        boolean r10 = r11.g;
    L30:
        r11.getClass();
        Intrinsics.checkNotNullParameter(r3, "initialChatName");
        Intrinsics.checkNotNullParameter(r4, "initialAvatarKey");
        Intrinsics.checkNotNullParameter(r5, "chatName");
        Intrinsics.checkNotNullParameter(r7, "selectedImageUri");
        return new e(r3, r4, r5, r6, r7, r8, r10);
    L29:
        r10 = r17;
        goto L30
    L25:
        r8 = r15;
        goto L27
    L21:
        r7 = r14;
        goto L23
    L17:
        r6 = false;
        goto L19
    L13:
        r5 = r13;
        goto L15
    L9:
        r1 = null;
        goto L10
    L5:
        r3 = r12;
        goto L7
    }
}
