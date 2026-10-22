package ms9;

import android.graphics.Bitmap;
import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public final long a;
    public final boolean b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final int g;
    public final String h;
    public final Bitmap i;
    public final Bitmap j;
    public final int k;
    public final boolean l;
    public final boolean m;
    public final boolean n;
    public final String o;
    public final int p;
    public final Uri q;
    public final String r;
    public final String s;
    public final String t;
    public final JSONObject u;
    public final int v;
    public final String w;
    public final int x;
    public final boolean y;

    public a() {
        this(null, null, null, 33554431);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r9 = (a) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r9.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r9.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r9.j) == true) goto L39;
        return false;
    L39:
        if (this.k == r9.k) goto L42;
        return false;
    L42:
        if (this.l == r9.l) goto L45;
        return false;
    L45:
        if (this.m == r9.m) goto L48;
        return false;
    L48:
        if (this.n == r9.n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r9.o) == true) goto L54;
        return false;
    L54:
        if (this.p == r9.p) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.q, r9.q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.r, r9.r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.s, r9.s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.t, r9.t) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.u, r9.u) == true) goto L72;
        return false;
    L72:
        if (this.v == r9.v) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.w, r9.w) == true) goto L78;
        return false;
    L78:
        if (this.x == r9.x) goto L81;
        return false;
    L81:
        if (this.y == r9.y) goto L83;
        return false;
    L83:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        int r2 = 1231;
        if (this.b == false) goto L5;
        int r3 = 1231;
    L6:
        int r4 = (r1 + r3) * 31;
        String r5 = this.c;
        int r6 = 0;
        if (r5 != null) goto L9;
        int r7 = 0;
    L10:
        int r8 = (r4 + r7) * 31;
        String r9 = this.d;
        if (r9 != null) goto L13;
        int r10 = 0;
    L14:
        int r11 = (r8 + r10) * 31;
        String r12 = this.e;
        if (r12 != null) goto L17;
        int r13 = 0;
    L18:
        int r14 = (r11 + r13) * 31;
        String r15 = this.f;
        if (r15 != null) goto L21;
        int r16 = 0;
    L22:
        int r17 = (((r14 + r16) * 31) + this.g) * 31;
        String r18 = this.h;
        if (r18 != null) goto L25;
        int r19 = 0;
    L26:
        int r20 = (r17 + r19) * 31;
        Bitmap r21 = this.i;
        if (r21 != null) goto L29;
        int r22 = 0;
    L30:
        int r23 = (r20 + r22) * 31;
        Bitmap r24 = this.j;
        if (r24 != null) goto L33;
        int r25 = 0;
    L34:
        int r26 = (((r23 + r25) * 31) + this.k) * 31;
        if (this.l == false) goto L37;
        int r27 = 1231;
    L38:
        int r28 = (r26 + r27) * 31;
        if (this.m == false) goto L41;
        int r29 = 1231;
    L42:
        int r30 = (r28 + r29) * 31;
        if (this.n == false) goto L45;
        int r31 = 1231;
    L46:
        int r32 = (r30 + r31) * 31;
        String r33 = this.o;
        if (r33 != null) goto L49;
        int r34 = 0;
    L50:
        int r35 = (((r32 + r34) * 31) + this.p) * 31;
        Uri r36 = this.q;
        if (r36 != null) goto L53;
        int r37 = 0;
    L54:
        int r38 = (r35 + r37) * 31;
        String r39 = this.r;
        if (r39 != null) goto L57;
        int r40 = 0;
    L58:
        int r41 = (r38 + r40) * 31;
        String r42 = this.s;
        if (r42 != null) goto L61;
        int r43 = 0;
    L62:
        int r44 = (r41 + r43) * 31;
        String r45 = this.t;
        if (r45 != null) goto L65;
        int r46 = 0;
    L66:
        int r47 = (r44 + r46) * 31;
        JSONObject r48 = this.u;
        if (r48 != null) goto L69;
        int r49 = 0;
    L70:
        int r50 = (((r47 + r49) * 31) + this.v) * 31;
        String r51 = this.w;
        if (r51 == null) goto L74;
        r6 = r51.hashCode();
    L74:
        int r52 = (((r50 + r6) * 31) + this.x) * 31;
        if (this.y == true) goto L79;
        r2 = 1237;
    L79:
        return r52 + r2;
    L69:
        r49 = r48.hashCode();
        goto L70
    L65:
        r46 = r45.hashCode();
        goto L66
    L61:
        r43 = r42.hashCode();
        goto L62
    L57:
        r40 = r39.hashCode();
        goto L58
    L53:
        r37 = r36.hashCode();
        goto L54
    L49:
        r34 = r33.hashCode();
        goto L50
    L45:
        r31 = 1237;
        goto L46
    L41:
        r29 = 1237;
        goto L42
    L37:
        r27 = 1237;
        goto L38
    L33:
        r25 = r24.hashCode();
        goto L34
    L29:
        r22 = r21.hashCode();
        goto L30
    L25:
        r19 = r18.hashCode();
        goto L26
    L21:
        r16 = r15.hashCode();
        goto L22
    L17:
        r13 = r12.hashCode();
        goto L18
    L13:
        r10 = r9.hashCode();
        goto L14
    L9:
        r7 = r5.hashCode();
        goto L10
    L5:
        r3 = 1237;
        goto L6
    }

    public final String toString() {
        return "FlowNotificationBody(id=" + this.a + ", showWhen=" + this.b + ", title=" + this.c + ", content=" + this.d + ", groupId=" + this.e + ", channelId=" + this.f + ", redBadgeNum=" + this.g + ", imageUrl=" + this.h + ", imageBitmap=" + this.i + ", iconBitmap=" + this.j + ", imageType=" + this.k + ", useLED=" + this.l + ", useSound=" + this.m + ", useVibrator=" + this.n + ", androidGroup=" + this.o + ", groupFoldNum=" + this.p + ", sound=" + this.q + ", bdPushStr=" + this.r + ", appName=" + this.s + ", openUrl=" + this.t + ", eventExtra=" + this.u + ", channelImportance=" + this.v + ", notificationCategory=" + this.w + ", avatarDisplayMode=" + this.x + ", forceSameWithIos=" + this.y + ')';
    }

    public a(String r5, String r6, String r7, int r8) {
        if ((r8 & 4) == 0) goto L6;
        r5 = null;
    L6:
        if ((r8 & 8) == 0) goto L9;
        r6 = null;
    L9:
        if ((r8 & 128) == 0) goto L11;
        r7 = null;
    L11:
        this.a = 0;
        this.b = false;
        this.c = r5;
        this.d = r6;
        this.e = null;
        this.f = null;
        this.g = 0;
        this.h = r7;
        this.i = null;
        this.j = null;
        this.k = 0;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = null;
        this.p = 0;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = 0;
        this.w = null;
        this.x = 0;
        this.y = false;
    }
}
