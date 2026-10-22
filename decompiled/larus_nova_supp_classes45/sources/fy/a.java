package fy;

import com.bytedance.android.livesdkapi.depend.model.live.linker.BattleConfigSetting;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerInviteContent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final BattleConfigSetting e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final String i;
    public final int j;
    public final String k;
    public final LinkerInviteContent l;

    public a() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L30;
        a r4 = (a) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (this.f == r4.f) goto L18;
        return false;
    L18:
        if (this.g == r4.g) goto L20;
        return false;
    L20:
        if (this.h == r4.h) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r4.i) == true) goto L24;
        return false;
    L24:
        if (this.j == r4.j) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.k, r4.k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.l, r4.l) == true) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        int r0 = ((((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31;
        BattleConfigSetting r1 = this.e;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        boolean r5 = this.f;
        ?? r6 = 1;
        ?? r7 = r5;
        if (r5 == false) goto L9;
        r7 = 1;
    L9:
        int r8 = (r4 + r7) * 31;
        boolean r9 = this.g;
        ?? r11 = r9;
        if (r9 == false) goto L12;
        r11 = 1;
    L12:
        int r12 = (r8 + r11) * 31;
        boolean r13 = this.h;
        if (r13 == true) goto L16;
        r6 = r13;
    L16:
        int r14 = (r12 + r6) * 31;
        String r15 = this.i;
        if (r15 == null) goto L19;
        int r16 = r15.hashCode();
    L20:
        int r17 = (((r14 + r16) * 31) + this.j) * 31;
        String r18 = this.k;
        if (r18 == null) goto L23;
        int r19 = r18.hashCode();
    L24:
        int r21 = (r17 + r19) * 31;
        LinkerInviteContent r22 = this.l;
        if (r22 == null) goto L28;
        r2 = r22.hashCode();
    L28:
        return r21 + r2;
    L23:
        r19 = 0;
        goto L24
    L19:
        r16 = 0;
        goto L20
    L5:
        r3 = 0;
        goto L6
    }

    public final String toString() {
        return "AnchorReplyParams(matchType=" + this.a + ", inviteType=" + this.b + ", inviteSource=" + this.c + ", multiPkMode=" + this.d + ", battleConfigSetting=" + this.e + ", isFromNpkInvite=" + this.f + ", isMultiReply=" + this.g + ", isMatchAutoReply=" + this.h + ", reqSrc=" + this.i + ", pkSwitchMode=" + this.j + ", inviteUserId=" + this.k + ", inviteContent=" + this.l + ")";
    }

    public /* synthetic */ a(int r14) {
        this(0, 0, 0, 0, null, false, false, false, "", 0, "0", null);
    }

    public a(int r2, int r3, int r4, int r5, BattleConfigSetting r6, boolean r7, boolean r8, boolean r9, String r11, int r12, String r13, LinkerInviteContent r14) {
        Intrinsics.checkNotNullParameter(r11, "reqSrc");
        Intrinsics.checkNotNullParameter(r13, "inviteUserId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
    }
}
