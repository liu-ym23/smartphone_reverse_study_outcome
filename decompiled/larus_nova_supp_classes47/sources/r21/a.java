package r21;

import com.bytedance.android.livesdk.link.model.IBattleRivalTag;
import com.bytedance.android.livesdk.link.model.t5;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public final k a;
    public final String b;
    public final Integer c;
    public final List<IBattleRivalTag> d;
    public final Integer e;
    public final Integer f;
    public final Long g;
    public final Boolean h;
    public final List<t5> i;
    public final Boolean j;
    public final Boolean k;
    public final Boolean l;
    public final Map<String, Long> m;
    public final String n;
    public final Boolean o;
    public final Boolean p;
    public final Boolean q;
    public final Runnable r;
    public final String s;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L44;
        a r4 = (a) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r4.h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r4.i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r4.j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.k, r4.k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.l, r4.l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.m, r4.m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.n, r4.n) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.o, r4.o) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.p, r4.p) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.q, r4.q) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.r, r4.r) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.s, r4.s) == true) goto L67;
        return false;
    L67:
        return true;
    L44:
        return false;
    }

    public final int hashCode() {
        k r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        List<IBattleRivalTag> r10 = this.d;
        if (r10 == null) goto L17;
        int r12 = r10.hashCode();
    L18:
        int r13 = (r9 + r12) * 31;
        Integer r14 = this.e;
        if (r14 == null) goto L21;
        int r15 = r14.hashCode();
    L22:
        int r16 = (r13 + r15) * 31;
        Integer r17 = this.f;
        if (r17 == null) goto L25;
        int r18 = r17.hashCode();
    L26:
        int r19 = (r16 + r18) * 31;
        Long r20 = this.g;
        if (r20 == null) goto L29;
        int r22 = r20.hashCode();
    L30:
        int r23 = (r19 + r22) * 31;
        Boolean r24 = this.h;
        if (r24 == null) goto L33;
        int r25 = r24.hashCode();
    L34:
        int r26 = (r23 + r25) * 31;
        List<t5> r27 = this.i;
        if (r27 == null) goto L37;
        int r28 = r27.hashCode();
    L38:
        int r29 = (r26 + r28) * 31;
        Boolean r30 = this.j;
        if (r30 == null) goto L41;
        int r32 = r30.hashCode();
    L42:
        int r33 = (r29 + r32) * 31;
        Boolean r34 = this.k;
        if (r34 == null) goto L45;
        int r35 = r34.hashCode();
    L46:
        int r36 = (r33 + r35) * 31;
        Boolean r37 = this.l;
        if (r37 == null) goto L49;
        int r38 = r37.hashCode();
    L50:
        int r39 = (r36 + r38) * 31;
        Map<String, Long> r40 = this.m;
        if (r40 == null) goto L53;
        int r42 = r40.hashCode();
    L54:
        int r43 = (r39 + r42) * 31;
        String r44 = this.n;
        if (r44 == null) goto L57;
        int r45 = r44.hashCode();
    L58:
        int r46 = (r43 + r45) * 31;
        Boolean r47 = this.o;
        if (r47 == null) goto L61;
        int r48 = r47.hashCode();
    L62:
        int r49 = (r46 + r48) * 31;
        Boolean r50 = this.p;
        if (r50 == null) goto L65;
        int r52 = r50.hashCode();
    L66:
        int r53 = (r49 + r52) * 31;
        Boolean r54 = this.q;
        if (r54 == null) goto L69;
        int r55 = r54.hashCode();
    L70:
        int r56 = (r53 + r55) * 31;
        Runnable r57 = this.r;
        if (r57 == null) goto L73;
        int r58 = r57.hashCode();
    L74:
        int r59 = (r56 + r58) * 31;
        String r60 = this.s;
        if (r60 == null) goto L78;
        r1 = r60.hashCode();
    L78:
        return r59 + r1;
    L73:
        r58 = 0;
        goto L74
    L69:
        r55 = 0;
        goto L70
    L65:
        r52 = 0;
        goto L66
    L61:
        r48 = 0;
        goto L62
    L57:
        r45 = 0;
        goto L58
    L53:
        r42 = 0;
        goto L54
    L49:
        r38 = 0;
        goto L50
    L45:
        r35 = 0;
        goto L46
    L41:
        r32 = 0;
        goto L42
    L37:
        r28 = 0;
        goto L38
    L33:
        r25 = 0;
        goto L34
    L29:
        r22 = 0;
        goto L30
    L25:
        r18 = 0;
        goto L26
    L21:
        r15 = 0;
        goto L22
    L17:
        r12 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "AnchorLinkUserUiState(avatarThumb=" + this.a + ", nickName=" + this.b + ", gender=" + this.c + ", battleRivalTags=" + this.d + ", inviteType=" + this.e + ", userCount=" + this.f + ", followCount=" + this.g + ", pannelOpt=" + this.h + ", linkedUserInfos=" + this.i + ", roomInVoteMode=" + this.j + ", roomInBreakThrough=" + this.k + ", roomInPkMode=" + this.l + ", linkMap=" + this.m + ", linkText=" + this.n + ", inApplicantList=" + this.o + ", inInviteeList=" + this.p + ", fromBanner=" + this.q + ", inviteOrApplyHandler=" + this.r + ", roomStatusDesc=" + this.s + ")";
    }

    public a(k r3, String r4, Integer r5, List<? extends IBattleRivalTag> r6, Integer r7, Integer r8, Long r9, Boolean r10, List<? extends t5> r12, Boolean r13, Boolean r14, Boolean r15, Map<String, Long> r16, String r17, Boolean r18, Boolean r19, Boolean r110, Runnable r20, String r22) {
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r12;
        this.j = r13;
        this.k = r14;
        this.l = r15;
        this.m = r16;
        this.n = r17;
        this.o = r18;
        this.p = r19;
        this.q = r110;
        this.r = r20;
        this.s = r22;
    }
}
