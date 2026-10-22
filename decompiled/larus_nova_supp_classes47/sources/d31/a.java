package d31;

import com.bytedance.android.live.revlink.impl.model.BizType;
import com.bytedance.android.live.saas.middleware.fresco.DefaultConfig;
import d11.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final /* synthetic */ int m = 0;
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final String e;
    public final int f;
    public final int g;
    public final String h;
    public final String i;
    public final Long j;
    public final String k;
    public final BizType l;

    /* JADX INFO: renamed from: d31.a$a, reason: collision with other inner class name */
    public static final class C0230a {
        public static a a(d11.c r14) {
            Intrinsics.checkNotNullParameter(r14, "params");
            return new a(0, 0, 0, r14.a, r14.g, r14.f, 0, null, null, null, null, 4039);
        }

        public static a b(d11.d r14) {
            Intrinsics.checkNotNullParameter(r14, "params");
            int r2 = r14.e;
            int r3 = r14.d;
            int r4 = r14.n;
            int r5 = r14.a;
            String r9 = String.valueOf(r14.s);
            int r15 = r14.i;
            BizType r1 = BizType.PK;
            if (r15 == r1.ordinal()) goto L10;
            r1 = BizType.OpenGame;
            if (r15 == r1.ordinal()) goto L10;
            r1 = BizType.AnchorLink;
            if (r15 == r1.ordinal()) goto L10;
            BizType r12 = BizType.None;
        L13:
            return new a(r2, r3, r4, r5, null, 0, 0, r9, null, null, r12, 1904);
        L10:
            r12 = r1;
            goto L13
        }

        public static a c(g r14) {
            Intrinsics.checkNotNullParameter(r14, "params");
            d11.a r1 = r14.j;
            return new a(r1.a, r1.b, r1.c, r14.a, r1.h, r14.e, 0, null, null, null, null, 4032);
        }
    }

    static {
    }

    public a() {
        this(0, 0, 0, 0, null, 0, 0, null, null, null, null, 4095);
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
        if (Intrinsics.areEqual(this.l, r4.l) == true) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    public final int hashCode() {
        int r0 = ((((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31;
        String r1 = this.e;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (((((r0 + r3) * 31) + this.f) * 31) + this.g) * 31;
        String r5 = this.h;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.i;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r10 = (r7 + r9) * 31;
        Long r12 = this.j;
        if (r12 == null) goto L17;
        int r13 = r12.hashCode();
    L18:
        int r14 = (r10 + r13) * 31;
        String r15 = this.k;
        if (r15 == null) goto L21;
        int r16 = r15.hashCode();
    L22:
        int r17 = (r14 + r16) * 31;
        BizType r18 = this.l;
        if (r18 == null) goto L26;
        r2 = r18.hashCode();
    L26:
        return r17 + r2;
    L21:
        r16 = 0;
        goto L22
    L17:
        r13 = 0;
        goto L18
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final String toString() {
        return "ApiCallParams(matchType=" + this.a + ", inviteType=" + this.b + ", inviteSource=" + this.c + ", reqScene=" + this.d + ", reqSource=" + this.e + ", type=" + this.f + ", mode=" + this.g + ", source=" + this.h + ", status=" + this.i + ", channelId=" + this.j + ", queryStr=" + this.k + ", bizType=" + this.l + ")";
    }

    public final int getType() {
        return this.f;
    }

    public a(int r15, int r16, int r17, int r18, String r19, int r20, int r22, String r23, Long r24, String r25, BizType r26, int r27) {
        int r3 = 0;
        if ((r27 & 1) == 0) goto L5;
        int r2 = 0;
    L7:
        if ((r27 & 2) == 0) goto L9;
        int r4 = 0;
    L11:
        if ((r27 & 4) == 0) goto L13;
        int r5 = 0;
    L15:
        if ((r27 & 8) == 0) goto L17;
        int r6 = 0;
    L18:
        String r8 = "";
        if ((r27 & 16) == 0) goto L21;
        String r7 = "";
    L23:
        if ((r27 & 32) == 0) goto L25;
        int r9 = 0;
    L27:
        if ((r27 & 64) != 0) goto L31;
        r3 = r22;
    L31:
        if ((r27 & 128) == 0) goto L33;
        String r10 = "";
    L34:
        Long r12 = null;
        if ((r27 & DefaultConfig.MAX_CACHE_ENTRIES) == 0) goto L37;
        String r13 = "";
    L39:
        if ((r27 & 512) != 0) goto L43;
        r12 = r24;
    L43:
        if ((r27 & 1024) != 0) goto L47;
        r8 = r25;
    L47:
        if ((r27 & 2048) == 0) goto L49;
        BizType r1 = BizType.None;
    L50:
        Intrinsics.checkNotNullParameter(r7, "reqSource");
        Intrinsics.checkNotNullParameter(r10, "source");
        Intrinsics.checkNotNullParameter(r13, "status");
        Intrinsics.checkNotNullParameter(r8, "queryStr");
        Intrinsics.checkNotNullParameter(r1, "bizType");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r9;
        this.g = r3;
        this.h = r10;
        this.i = r13;
        this.j = r12;
        this.k = r8;
        this.l = r1;
        return;
    L49:
        r1 = r26;
        goto L50
    L37:
        r13 = null;
        goto L39
    L33:
        r10 = r23;
        goto L34
    L25:
        r9 = r20;
        goto L27
    L21:
        r7 = r19;
        goto L23
    L17:
        r6 = r18;
        goto L18
    L13:
        r5 = r17;
        goto L15
    L9:
        r4 = r16;
        goto L11
    L5:
        r2 = r15;
        goto L7
    }
}
