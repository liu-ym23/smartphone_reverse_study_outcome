package com.ss.android.lark.compose.chat_member_list;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d {
    public final String a;
    public final List<com.ss.android.lark.compose.chatterselector.a> b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final String f;
    public final boolean g;
    public final int h;
    public final boolean i;
    public final boolean j;

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
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
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
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        int r2 = 1231;
        if (this.c == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.d == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        if (this.e == false) goto L13;
        int r6 = 1231;
    L14:
        int r7 = (r5 + r6) * 31;
        String r8 = this.f;
        if (r8 != null) goto L17;
        int r9 = 0;
    L18:
        int r10 = (r7 + r9) * 31;
        if (this.g == false) goto L21;
        int r11 = 1231;
    L22:
        int r12 = (((r10 + r11) * 31) + this.h) * 31;
        if (this.i == false) goto L25;
        int r13 = 1231;
    L26:
        int r14 = (r12 + r13) * 31;
        if (this.j == true) goto L31;
        r2 = 1237;
    L31:
        return r14 + r2;
    L25:
        r13 = 1237;
        goto L26
    L21:
        r11 = 1237;
        goto L22
    L17:
        r9 = r8.hashCode();
        goto L18
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
        return "ChatMembersUiState(query=" + this.a + ", members=" + this.b + ", loading=" + this.c + ", loadingMore=" + this.d + ", hasMore=" + this.e + ", cursor=" + this.f + ", isCurrentUserAdmin=" + this.g + ", userCount=" + this.h + ", isUserCountVisible=" + this.i + ", allCanAddMember=" + this.j + ')';
    }

    public /* synthetic */ d(int r12) {
        this(BuildConfig.FLAVOR, CollectionsKt.emptyList(), false, false, false, null, false, 0, true, false);
    }

    public d(String r2, List<com.ss.android.lark.compose.chatterselector.a> r3, boolean r4, boolean r5, boolean r6, String r7, boolean r8, int r9, boolean r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r2, "query");
        Intrinsics.checkNotNullParameter(r3, "members");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
    }

    public static d a(d r11, String r12, List r13, boolean r14, boolean r15, boolean r16, String r17, boolean r18, int r19, boolean r20, boolean r21, int r22) {
        if ((r22 & 1) == 0) goto L5;
        String r2 = r11.a;
    L7:
        if ((r22 & 2) == 0) goto L9;
        List r3 = r11.b;
    L11:
        if ((r22 & 4) == 0) goto L13;
        boolean r4 = r11.c;
    L15:
        if ((r22 & 8) == 0) goto L17;
        boolean r5 = r11.d;
    L19:
        if ((r22 & 16) == 0) goto L21;
        boolean r6 = r11.e;
    L23:
        if ((r22 & 32) == 0) goto L25;
        String r7 = r11.f;
    L27:
        if ((r22 & 64) == 0) goto L29;
        boolean r8 = r11.g;
    L31:
        if ((r22 & 128) == 0) goto L33;
        int r9 = r11.h;
    L35:
        if ((r22 & 256) == 0) goto L37;
        boolean r10 = r11.i;
    L39:
        if ((r22 & 512) == 0) goto L41;
        boolean r1 = r11.j;
    L42:
        r11.getClass();
        Intrinsics.checkNotNullParameter(r2, "query");
        Intrinsics.checkNotNullParameter(r3, "members");
        return new d(r2, r3, r4, r5, r6, r7, r8, r9, r10, r1);
    L41:
        r1 = r21;
        goto L42
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r2 = r12;
        goto L7
    }
}
