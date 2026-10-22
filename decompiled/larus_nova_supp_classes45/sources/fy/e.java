package fy;

import com.bytedance.android.live.core.utils.statusbar.RomUtils;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e {
    public final int a;
    public final long b;
    public final long c;
    public final int d;
    public final int e;
    public final String f;
    public final String g;
    public final Room h;
    public final String i;
    public final int j;
    public final String k;
    public final long l;
    public final int m;
    public final Integer n;
    public final int o;
    public final List<String> p;
    public final String q;
    public final String r;
    public final String s;
    public final int t;
    public final int u;
    public final long v;
    public final String w;

    public e() {
        throw null;
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof e) == false) goto L52;
        e r7 = (e) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (this.d == r7.d) goto L14;
        return false;
    L14:
        if (this.e == r7.e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r7.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r7.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r7.h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r7.i) == true) goto L24;
        return false;
    L24:
        if (this.j == r7.j) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.k, r7.k) == true) goto L28;
        return false;
    L28:
        if (this.l == r7.l) goto L30;
        return false;
    L30:
        if (this.m == r7.m) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.n, r7.n) == true) goto L34;
        return false;
    L34:
        if (this.o == r7.o) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.p, r7.p) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.q, r7.q) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.r, r7.r) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.s, r7.s) == true) goto L44;
        return false;
    L44:
        if (this.t == r7.t) goto L46;
        return false;
    L46:
        if (this.u == r7.u) goto L48;
        return false;
    L48:
        if (this.v == r7.v) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.w, r7.w) == true) goto L79;
        return false;
    L79:
        return true;
    L52:
        return false;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        long r1 = this.b;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.c;
        int r4 = (((((r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.d) * 31) + this.e) * 31;
        String r5 = this.f;
        int r6 = 0;
        if (r5 == null) goto L5;
        int r7 = r5.hashCode();
    L6:
        int r8 = (r4 + r7) * 31;
        String r9 = this.g;
        if (r9 == null) goto L9;
        int r11 = r9.hashCode();
    L10:
        int r12 = (r8 + r11) * 31;
        Room r13 = this.h;
        if (r13 == null) goto L13;
        int r14 = r13.hashCode();
    L14:
        int r15 = (r12 + r14) * 31;
        String r16 = this.i;
        if (r16 == null) goto L17;
        int r17 = r16.hashCode();
    L18:
        int r18 = (((r15 + r17) * 31) + this.j) * 31;
        String r19 = this.k;
        if (r19 == null) goto L21;
        int r21 = r19.hashCode();
    L22:
        long r22 = this.l;
        int r23 = (((((r18 + r21) * 31) + ((int) (r22 ^ (r22 >>> 32)))) * 31) + this.m) * 31;
        Integer r24 = this.n;
        if (r24 == null) goto L25;
        int r25 = r24.hashCode();
    L26:
        int r26 = (((r23 + r25) * 31) + this.o) * 31;
        List<String> r27 = this.p;
        if (r27 == null) goto L29;
        int r28 = r27.hashCode();
    L30:
        int r29 = (r26 + r28) * 31;
        String r31 = this.q;
        if (r31 == null) goto L33;
        int r32 = r31.hashCode();
    L34:
        int r33 = (r29 + r32) * 31;
        String r34 = this.r;
        if (r34 == null) goto L37;
        int r35 = r34.hashCode();
    L38:
        int r36 = (r33 + r35) * 31;
        String r37 = this.s;
        if (r37 == null) goto L41;
        int r38 = r37.hashCode();
    L42:
        int r39 = (((((r36 + r38) * 31) + this.t) * 31) + this.u) * 31;
        long r41 = this.v;
        int r42 = (r39 + ((int) (r41 ^ (r41 >>> 32)))) * 31;
        String r43 = this.w;
        if (r43 == null) goto L46;
        r6 = r43.hashCode();
    L46:
        return r42 + r6;
    L41:
        r38 = 0;
        goto L42
    L37:
        r35 = 0;
        goto L38
    L33:
        r32 = 0;
        goto L34
    L29:
        r28 = 0;
        goto L30
    L25:
        r25 = 0;
        goto L26
    L21:
        r21 = 0;
        goto L22
    L17:
        r17 = 0;
        goto L18
    L13:
        r14 = 0;
        goto L14
    L9:
        r11 = 0;
        goto L10
    L5:
        r7 = 0;
        goto L6
    }

    public final String toString() {
        return "InviteParams(scene=" + this.a + ", roomId=" + this.b + ", toRoomId=" + this.c + ", inviteType=" + this.d + ", matchType=" + this.e + ", toUserId=" + this.f + ", secToUserId=" + this.g + ", targetRoom=" + this.h + ", theme=" + this.i + ", duration=" + this.j + ", activityName=" + this.k + ", matchSubType=" + this.l + ", inviteSource=" + this.m + ", multiPkMode=" + this.n + ", inviteeScene=" + this.o + ", inviteeUserIds=" + this.p + ", battleConfigSettingStr=" + this.q + ", panelType=" + this.r + ", battleAttachedInfo=" + this.s + ", inviterRoomStatus=" + this.t + ", inviteIndex=" + this.u + ", stayDuration=" + this.v + ", clientAttachedInfo=" + this.w + ")";
    }

    public /* synthetic */ e(int r32, long r33, long r35, int r37, int r38, String r39, String r41, Room r42, String r43, String r44, int r45, List r46, String r47, String r48, int r49) {
        if ((r49 & 256) == 0) goto L5;
        String r14 = "";
    L7:
        if ((r49 & RomUtils.SZ) == 0) goto L9;
        String r16 = "";
    L11:
        if ((r49 & 4096) == 0) goto L13;
        int r19 = 0;
    L15:
        if ((32768 & r49) == 0) goto L17;
        List r22 = null;
    L19:
        if ((65536 & r49) == 0) goto L21;
        String r23 = "";
    L23:
        if ((131072 & r49) == 0) goto L25;
        String r24 = null;
    L27:
        if ((262144 & r49) == 0) goto L29;
        String r25 = "";
    L31:
        if ((r49 & 4194304) == 0) goto L33;
        String r31 = "";
    L34:
        this(r32, r33, r35, r37, r38, r39, r41, r42, r14, 0, r16, 0, r19, null, 0, r22, r23, r24, r25, 0, 0, 0, r31);
        return;
    L33:
        r31 = null;
        goto L34
    L29:
        r25 = r48;
        goto L31
    L25:
        r24 = r47;
        goto L27
    L21:
        r23 = null;
        goto L23
    L17:
        r22 = r46;
        goto L19
    L13:
        r19 = r45;
        goto L15
    L9:
        r16 = r44;
        goto L11
    L5:
        r14 = r43;
        goto L7
    }

    public e(int r9, long r11, long r12, int r14, int r15, String r16, String r17, Room r18, String r19, int r21, String r22, long r23, int r24, Integer r25, int r26, List<String> r27, String r28, String r29, String r31, int r32, int r33, long r34, String r35) {
        Intrinsics.checkNotNullParameter(r16, "toUserId");
        Intrinsics.checkNotNullParameter(r17, "secToUserId");
        Intrinsics.checkNotNullParameter(r18, "targetRoom");
        Intrinsics.checkNotNullParameter(r22, "activityName");
        Intrinsics.checkNotNullParameter(r35, "clientAttachedInfo");
        this.a = r9;
        this.b = r11;
        this.c = r12;
        this.d = r14;
        this.e = r15;
        this.f = r16;
        this.g = r17;
        this.h = r18;
        this.i = r19;
        this.j = r21;
        this.k = r22;
        this.l = r23;
        this.m = r24;
        this.n = r25;
        this.o = r26;
        this.p = r27;
        this.q = r28;
        this.r = r29;
        this.s = r31;
        this.t = r32;
        this.u = r33;
        this.v = r34;
        this.w = r35;
    }
}
