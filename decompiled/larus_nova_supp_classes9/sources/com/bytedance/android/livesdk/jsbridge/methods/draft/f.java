package com.bytedance.android.livesdk.jsbridge.methods.draft;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdk.jsbridge.methods.d1;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f implements b {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final long g;
    public final long h;
    public final String i;
    public final String j;
    public final int k;
    public final String l;
    public final String m;
    public final int n;
    public final Room o;
    public final User p;
    public final d1.c q;
    public final String r;
    public final d1.d s;

    public final int hashCode() {
        String r0 = this.a;
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
        String r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = getType();
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r13 = (r9 + r11) * 31;
        String r14 = this.e;
        if (r14 == null) goto L21;
        int r15 = r14.hashCode();
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.f;
        if (r17 == null) goto L25;
        int r18 = r17.hashCode();
    L26:
        int r19 = (r16 + r18) * 31;
        long r20 = this.g;
        int r21 = (r19 + ((int) (r20 ^ (r20 >>> 32)))) * 31;
        long r23 = this.h;
        int r24 = (r21 + ((int) (r23 ^ (r23 >>> 32)))) * 31;
        String r25 = this.i;
        if (r25 == null) goto L29;
        int r26 = r25.hashCode();
    L30:
        int r27 = (r24 + r26) * 31;
        String r28 = this.j;
        if (r28 == null) goto L33;
        int r29 = r28.hashCode();
    L34:
        int r30 = (((r27 + r29) * 31) + this.k) * 31;
        String r31 = this.l;
        if (r31 == null) goto L37;
        int r33 = r31.hashCode();
    L38:
        int r34 = (r30 + r33) * 31;
        String r35 = this.m;
        if (r35 == null) goto L41;
        int r36 = r35.hashCode();
    L42:
        int r37 = (((r34 + r36) * 31) + this.n) * 31;
        Room r38 = this.o;
        if (r38 == null) goto L45;
        int r39 = r38.hashCode();
    L46:
        int r40 = (r37 + r39) * 31;
        User r41 = this.p;
        if (r41 == null) goto L49;
        int r43 = r41.hashCode();
    L50:
        int r44 = (r40 + r43) * 31;
        d1.c r45 = this.q;
        if (r45 == null) goto L53;
        int r46 = r45.hashCode();
    L54:
        int r47 = (r44 + r46) * 31;
        String r48 = this.r;
        if (r48 == null) goto L57;
        int r49 = r48.hashCode();
    L58:
        int r50 = (r47 + r49) * 31;
        d1.d r51 = this.s;
        if (r51 == null) goto L62;
        r1 = r51.hashCode();
    L62:
        return r50 + r1;
    L57:
        r49 = 0;
        goto L58
    L53:
        r46 = 0;
        goto L54
    L49:
        r43 = 0;
        goto L50
    L45:
        r39 = 0;
        goto L46
    L41:
        r36 = 0;
        goto L42
    L37:
        r33 = 0;
        goto L38
    L33:
        r29 = 0;
        goto L34
    L29:
        r26 = 0;
        goto L30
    L25:
        r18 = 0;
        goto L26
    L21:
        r15 = 0;
        goto L22
    L17:
        r11 = 0;
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
        return "RealDraft(videoPath=" + this.a + ", videoId=" + this.b + ", title=" + this.c + ", type=" + getType() + ", roomId=" + this.e + ", roomTime=" + this.f + ", startTime=" + this.g + ", endTime=" + this.h + ", shootWay=" + this.i + ", fragmentId=" + this.j + ", anchorBusinessType=" + this.k + ", anchorContent=" + this.l + ", anchorTitle=" + this.m + ", anchorSource=" + this.n + ", room=" + this.o + ", anchor=" + this.p + ", shoppingExtras=" + this.q + ", promotionId=" + this.r + ", trackExtras=" + this.s + ")";
    }

    @Override // com.bytedance.android.livesdk.jsbridge.methods.draft.b
    public final String a() {
        return this.a;
    }

    @Override // com.bytedance.android.livesdk.jsbridge.methods.draft.b
    public final d1.d b() {
        return this.s;
    }

    @Override // com.bytedance.android.livesdk.jsbridge.methods.draft.b
    public final d1.c c() {
        return this.q;
    }

    @Override // com.bytedance.android.livesdk.jsbridge.methods.draft.b
    public final User getAnchor() {
        return this.p;
    }

    @Override // com.bytedance.android.livesdk.jsbridge.methods.draft.b
    public final long getEndTime() {
        return this.h;
    }

    @Override // com.bytedance.android.livesdk.jsbridge.methods.draft.b
    public final String getPromotionId() {
        return this.r;
    }

    @Override // com.bytedance.android.livesdk.jsbridge.methods.draft.b
    public final Room getRoom() {
        return this.o;
    }

    @Override // com.bytedance.android.livesdk.jsbridge.methods.draft.b
    public final String getRoomId() {
        return this.e;
    }

    @Override // com.bytedance.android.livesdk.jsbridge.methods.draft.b
    public final long getStartTime() {
        return this.g;
    }

    @Override // com.bytedance.android.livesdk.jsbridge.methods.draft.b
    public final String getTitle() {
        return this.c;
    }

    @Override // com.bytedance.android.livesdk.jsbridge.methods.draft.b
    public String getType() {
        return this.d;
    }

    @Override // com.bytedance.android.livesdk.jsbridge.methods.draft.b
    public final String getVideoId() {
        return this.b;
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof f) == false) goto L44;
        f r7 = (f) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(getType(), r7.getType()) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r7.f) == true) goto L18;
        return false;
    L18:
        if (this.g == r7.g) goto L20;
        return false;
    L20:
        if (this.h == r7.h) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r7.i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r7.j) == true) goto L26;
        return false;
    L26:
        if (this.k == r7.k) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.l, r7.l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.m, r7.m) == true) goto L32;
        return false;
    L32:
        if (this.n == r7.n) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.o, r7.o) == true) goto L36;
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
        if (Intrinsics.areEqual(this.s, r7.s) == true) goto L67;
        return false;
    L67:
        return true;
    L44:
        return false;
    }

    public f(String r15, String r16, String r17, String r18, String r19, String r20, long r21, long r23, String r25, String r26, int r27, String r28, String r29, int r30, Room r31, User r33, d1.c r34, String r35, d1.d r36) {
        Intrinsics.checkNotNullParameter(r16, "videoId");
        Intrinsics.checkNotNullParameter(r17, "title");
        Intrinsics.checkNotNullParameter(r18, "type");
        Intrinsics.checkNotNullParameter(r19, "roomId");
        Intrinsics.checkNotNullParameter(r20, "roomTime");
        Intrinsics.checkNotNullParameter(r25, "shootWay");
        Intrinsics.checkNotNullParameter(r26, "fragmentId");
        Intrinsics.checkNotNullParameter(r28, "anchorContent");
        Intrinsics.checkNotNullParameter(r29, "anchorTitle");
        Intrinsics.checkNotNullParameter(r34, "shoppingExtras");
        Intrinsics.checkNotNullParameter(r35, "promotionId");
        Intrinsics.checkNotNullParameter(r36, "trackExtras");
        this.a = r15;
        this.b = r16;
        this.c = r17;
        this.d = r18;
        this.e = r19;
        this.f = r20;
        this.g = r21;
        this.h = r23;
        this.i = r25;
        this.j = r26;
        this.k = r27;
        this.l = r28;
        this.m = r29;
        this.n = r30;
        this.o = r31;
        this.p = r33;
        this.q = r34;
        this.r = r35;
        this.s = r36;
    }
}
