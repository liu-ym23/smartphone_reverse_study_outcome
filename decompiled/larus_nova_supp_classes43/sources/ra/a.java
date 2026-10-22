package ra;

import android.net.Uri;
import com.bytedance.forest.Forest;
import com.lynx.tasm.TemplateData;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public final String a;
    public final Uri b;
    public final String c;
    public final TemplateData d;
    public final Object e;
    public final ra.b f;
    public final String g;
    public final TemplateData h;
    public final b i;
    public final boolean j;
    public final boolean k;
    public final c l;
    public final String m;
    public final boolean n;
    public final C0191a o;
    public boolean p;
    public String q;
    public boolean r;
    public boolean s;
    public Forest t;

    /* JADX INFO: renamed from: ra.a$a, reason: collision with other inner class name */
    public static final class C0191a {
        public final boolean a;
        public final boolean b;
        public final boolean c;
        public final boolean d;
        public final boolean e;
        public final String f;
        public final boolean g;

        public C0191a() {
            this(false, null, 127);
        }

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof C0191a) == true) goto L8;
            return false;
        L8:
            C0191a r11 = (C0191a) r10;
            if (this.a == r11.a) goto L12;
            return false;
        L12:
            if (this.b == r11.b) goto L15;
            return false;
        L15:
            if (this.c == r11.c) goto L18;
            return false;
        L18:
            if (this.d == r11.d) goto L21;
            return false;
        L21:
            if (this.e == r11.e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r11.f) == true) goto L27;
            return false;
        L27:
            if (this.g == r11.g) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            int r1 = 1231;
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r10 = r0 * 31;
            if (this.b == false) goto L9;
            int r11 = 1231;
        L10:
            int r12 = (r10 + r11) * 31;
            if (this.c == false) goto L13;
            int r13 = 1231;
        L14:
            int r14 = (r12 + r13) * 31;
            if (this.d == false) goto L17;
            int r15 = 1231;
        L18:
            int r16 = (r14 + r15) * 31;
            if (this.e == false) goto L21;
            int r17 = 1231;
        L22:
            int r18 = (r16 + r17) * 31;
            String r19 = this.f;
            if (r19 != null) goto L25;
            int r20 = 0;
        L26:
            int r21 = (r18 + r20) * 31;
            if (this.g == true) goto L31;
            r1 = 1237;
        L31:
            return r21 + r1;
        L25:
            r20 = r19.hashCode();
            goto L26
        L21:
            r17 = 1237;
            goto L22
        L17:
            r15 = 1237;
            goto L18
        L13:
            r13 = 1237;
            goto L14
        L9:
            r11 = 1237;
            goto L10
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "CompactConfig(compactBridge=" + this.a + ", compactCanvas=" + this.b + ", compactMonitor=" + this.c + ", disableSignVerify=" + this.d + ", enableBridgeDelayInit=" + this.e + ", monitorID=" + this.f + ", trimGlobalProps=" + this.g + ')';
        }

        public C0191a(boolean r10, String r11, int r12) {
            boolean r1 = false;
            if ((r12 & 1) == 0) goto L5;
            boolean r0 = true;
        L7:
            if ((r12 & 2) == 0) goto L9;
            boolean r13 = true;
        L11:
            if ((r12 & 4) == 0) goto L13;
            boolean r14 = true;
        L15:
            if ((r12 & 8) == 0) goto L17;
            boolean r15 = true;
        L19:
            if ((r12 & 16) == 0) goto L22;
            r10 = false;
        L22:
            if ((r12 & 32) == 0) goto L25;
            r11 = null;
        L25:
            if ((r12 & 64) == 0) goto L27;
            r1 = true;
        L27:
            this.a = r0;
            this.b = r13;
            this.c = r14;
            this.d = r15;
            this.e = r10;
            this.f = r11;
            this.g = r1;
            return;
        L17:
            r15 = false;
            goto L19
        L13:
            r14 = false;
            goto L15
        L9:
            r13 = false;
            goto L11
        L5:
            r0 = false;
            goto L7
        }
    }

    public static final class b {
        public final byte[] a;

        public final String toString() {
            return "ComparableByteArray(templateJS=" + Arrays.toString(this.a) + ')';
        }

        public final int hashCode() {
            return Arrays.hashCode(this.a);
        }

        public b(byte[] r10) {
            Intrinsics.checkNotNullParameter(r10, "templateJS");
            this.a = r10;
        }

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if (r10 == null) goto L8;
            Class<?> r1 = r10.getClass();
        L10:
            if (Intrinsics.areEqual(b.class, r1) == true) goto L13;
            return false;
        L13:
            Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.bytedance.android.anniex.model.AnnieXLynxModel.ComparableByteArray");
            return Arrays.equals(this.a, ((b) r10).a);
        L8:
            r1 = null;
            goto L10
        }
    }

    public static final class c {
        public final b a;
        public final String b;
        public final TemplateData c;

        public c() {
            String r0 = null;
            this(r0, r0, 7);
        }

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof c) == true) goto L8;
            return false;
        L8:
            c r11 = (c) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            b r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r10 = 0;
        L6:
            int r11 = r10 * 31;
            String r12 = this.b;
            if (r12 != null) goto L9;
            int r13 = 0;
        L10:
            int r14 = (r11 + r13) * 31;
            TemplateData r15 = this.c;
            if (r15 == null) goto L15;
            r1 = r15.hashCode();
        L15:
            return r14 + r1;
        L9:
            r13 = r12.hashCode();
            goto L10
        L5:
            r10 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "SSRHydrateConfig(template=" + this.a + ", baseUrl=" + this.b + ", templateData=" + this.c + ')';
        }

        public /* synthetic */ c(String r10, TemplateData r11, int r12) {
            if ((r12 & 2) == 0) goto L6;
            r10 = null;
        L6:
            if ((r12 & 4) == 0) goto L8;
            r11 = null;
        L8:
            this(null, r10, r11);
        }

        public c(b r1, String r10, TemplateData r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
        }
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L8;
        return false;
    L8:
        a r11 = (a) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r11.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r11.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r11.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r11.i) == true) goto L36;
        return false;
    L36:
        if (this.j == r11.j) goto L39;
        return false;
    L39:
        if (this.k == r11.k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r11.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r11.m) == true) goto L48;
        return false;
    L48:
        if (this.n == r11.n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r11.o) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        TemplateData r1 = this.d;
        int r10 = 0;
        if (r1 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = (r0 + r11) * 31;
        Object r13 = this.e;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (((((r12 + r14) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
        TemplateData r16 = this.h;
        if (r16 != null) goto L13;
        int r17 = 0;
    L14:
        int r18 = (r15 + r17) * 31;
        b r19 = this.i;
        if (r19 != null) goto L17;
        int r20 = 0;
    L18:
        int r21 = (r18 + r20) * 31;
        int r22 = 1231;
        if (this.j == false) goto L21;
        int r23 = 1231;
    L22:
        int r24 = (r21 + r23) * 31;
        if (this.k == false) goto L25;
        int r25 = 1231;
    L26:
        int r26 = (r24 + r25) * 31;
        c r27 = this.l;
        if (r27 != null) goto L29;
        int r28 = 0;
    L30:
        int r29 = (((r26 + r28) * 31) + this.m.hashCode()) * 31;
        if (this.n == true) goto L34;
        r22 = 1237;
    L34:
        int r30 = (r29 + r22) * 31;
        C0191a r31 = this.o;
        if (r31 == null) goto L39;
        r10 = r31.hashCode();
    L39:
        return r30 + r10;
    L29:
        r28 = r27.hashCode();
        goto L30
    L25:
        r25 = 1237;
        goto L26
    L21:
        r23 = 1237;
        goto L22
    L17:
        r20 = r19.hashCode();
        goto L18
    L13:
        r17 = r16.hashCode();
        goto L14
    L9:
        r14 = r13.hashCode();
        goto L10
    L5:
        r11 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "AnnieXLynxModel(url=" + this.a + ", originalUri=" + this.b + ", bid=" + this.c + ", globalProps=" + this.d + ", extra=" + this.e + ", lynxViewBuilderParams=" + this.f + ", sessionId=" + this.g + ", templateData=" + this.h + ", template=" + this.i + ", isSSR=" + this.j + ", isCompactMode=" + this.k + ", ssrHydrateConfig=" + this.l + ", enterFrom=" + this.m + ", useXBridge3=" + this.n + ", compactConfig=" + this.o + ')';
    }

    public static a a(a r19, String r20, Uri r21, TemplateData r22, ra.b r23, String r24, TemplateData r25, b r26, boolean r27, c r28, int r29) {
        if ((r29 & 1) == 0) goto L5;
        String r10 = r19.a;
    L7:
        if ((r29 & 2) == 0) goto L9;
        Uri r11 = r19.b;
    L11:
        if ((r29 & 4) == 0) goto L13;
        String r12 = r19.c;
    L15:
        if ((r29 & 8) == 0) goto L17;
        TemplateData r13 = r19.d;
    L19:
        if ((r29 & 16) == 0) goto L21;
        Object r14 = r19.e;
    L23:
        if ((r29 & 32) == 0) goto L25;
        ra.b r15 = r19.f;
    L27:
        if ((r29 & 64) == 0) goto L29;
        String r16 = r19.g;
    L31:
        if ((r29 & 128) == 0) goto L33;
        TemplateData r17 = r19.h;
    L35:
        if ((r29 & 256) == 0) goto L37;
        b r18 = r19.i;
    L39:
        if ((r29 & 512) == 0) goto L41;
        boolean r110 = r19.j;
    L43:
        if ((r29 & 1024) == 0) goto L45;
        boolean r30 = r19.k;
    L47:
        if ((r29 & 2048) == 0) goto L49;
        c r111 = r19.l;
    L51:
        if ((r29 & 4096) == 0) goto L53;
        String r31 = r19.m;
    L55:
        if ((r29 & 8192) == 0) goto L57;
        boolean r112 = r19.n;
    L59:
        if ((r29 & 16384) == 0) goto L61;
        C0191a r113 = r19.o;
    L62:
        r19.getClass();
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "originalUri");
        Intrinsics.checkNotNullParameter(r12, "bid");
        Intrinsics.checkNotNullParameter(r15, "lynxViewBuilderParams");
        Intrinsics.checkNotNullParameter(r16, "sessionId");
        Intrinsics.checkNotNullParameter(r31, "enterFrom");
        boolean r114 = r30;
        return new a(r10, r11, r12, r13, r14, r15, r16, r17, r18, r110, r114, r111, r31, r112, r113);
    L61:
        r113 = null;
        goto L62
    L57:
        r112 = false;
        goto L59
    L53:
        r31 = null;
        goto L55
    L49:
        r111 = r28;
        goto L51
    L45:
        r30 = false;
        goto L47
    L41:
        r110 = r27;
        goto L43
    L37:
        r18 = r26;
        goto L39
    L33:
        r17 = r25;
        goto L35
    L29:
        r16 = r24;
        goto L31
    L25:
        r15 = r23;
        goto L27
    L21:
        r14 = null;
        goto L23
    L17:
        r13 = r22;
        goto L19
    L13:
        r12 = null;
        goto L15
    L9:
        r11 = r21;
        goto L11
    L5:
        r10 = r20;
        goto L7
    }

    public /* synthetic */ a(String r19, Uri r20, String r21, TemplateData r22, Object r23, ra.b r24, String r25, TemplateData r26, b r27, boolean r28, boolean r29, c r30, String r31, C0191a r32, int r33) {
        if ((r33 & 4) == 0) goto L5;
        String r10 = "default_bid";
    L7:
        if ((r33 & 8) == 0) goto L9;
        TemplateData r11 = null;
    L11:
        if ((r33 & 16) == 0) goto L13;
        Object r12 = null;
    L15:
        if ((r33 & 128) == 0) goto L17;
        TemplateData r13 = null;
    L19:
        if ((r33 & 256) == 0) goto L21;
        b r14 = null;
    L23:
        if ((r33 & 512) == 0) goto L25;
        boolean r15 = false;
    L27:
        if ((r33 & 1024) == 0) goto L29;
        boolean r16 = false;
    L31:
        if ((r33 & 2048) == 0) goto L33;
        c r17 = null;
    L35:
        if ((r33 & 4096) == 0) goto L37;
        String r18 = "annieXCard";
    L39:
        if ((r33 & 8192) == 0) goto L41;
        boolean r110 = true;
    L43:
        if ((r33 & 16384) == 0) goto L45;
        C0191a r111 = null;
    L46:
        this(r19, r20, r10, r11, r12, r24, r25, r13, r14, r15, r16, r17, r18, r110, r111);
        return;
    L45:
        r111 = r32;
        goto L46
    L41:
        r110 = false;
        goto L43
    L37:
        r18 = r31;
        goto L39
    L33:
        r17 = r30;
        goto L35
    L29:
        r16 = r29;
        goto L31
    L25:
        r15 = r28;
        goto L27
    L21:
        r14 = r27;
        goto L23
    L17:
        r13 = r26;
        goto L19
    L13:
        r12 = r23;
        goto L15
    L9:
        r11 = r22;
        goto L11
    L5:
        r10 = r21;
        goto L7
    }

    public a(String r10, Uri r11, String r12, TemplateData r13, Object r14, ra.b r15, String r16, TemplateData r17, b r18, boolean r19, boolean r110, c r20, String r21, boolean r22, C0191a r23) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "originalUri");
        Intrinsics.checkNotNullParameter(r12, "bid");
        Intrinsics.checkNotNullParameter(r15, "lynxViewBuilderParams");
        Intrinsics.checkNotNullParameter(r16, "sessionId");
        Intrinsics.checkNotNullParameter(r21, "enterFrom");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.g = r16;
        this.h = r17;
        this.i = r18;
        this.j = r19;
        this.k = r110;
        this.l = r20;
        this.m = r21;
        this.n = r22;
        this.o = r23;
        this.q = "";
    }
}
