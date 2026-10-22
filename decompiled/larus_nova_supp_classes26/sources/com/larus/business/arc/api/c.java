package com.larus.business.arc.api;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Serializable
public final class c {
    public static final b Companion = null;
    public static final Lazy<juc.d<Object>>[] l = null;
    public final ArcPlatform a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final ArcRegion g;
    public final String h;
    public final String i;
    public final String j;
    public final ArcCallLifecycle k;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<c> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.business.arc.api.ArcActionContext", r0, 10);
            r1.j("platform", true);
            r1.j("packageName", true);
            r1.j("processName", true);
            r1.j("uid", true);
            r1.j("did", true);
            r1.j("channel", true);
            r1.j("region", true);
            r1.j("updateVersionCode", true);
            r1.j("requestId", true);
            r1.j("traceId", true);
            b = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r0 = c.l;
            v2 r2 = v2.a;
            return new juc.d[]{r0[0].getValue(), r2, r2, r2, r2, r2, r0[6].getValue(), r2, r2, r2};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r28) {
            Intrinsics.checkNotNullParameter(r28, "decoder");
            g2 r1 = b;
            muc.c r0 = r28.beginStructure(r1);
            Lazy<juc.d<Object>>[] r2 = c.l;
            int r4 = 2;
            int r5 = 4;
            ArcPlatform r14 = null;
            if (r0.decodeSequentially() == false) goto L5;
            ArcPlatform r3 = (ArcPlatform) r0.decodeSerializableElement(r1, 0, (juc.c) r2[0].getValue(), null);
            String r9 = r0.decodeStringElement(r1, 1);
            String r6 = r0.decodeStringElement(r1, 2);
            String r10 = r0.decodeStringElement(r1, 3);
            String r7 = r0.decodeStringElement(r1, 4);
            String r11 = r0.decodeStringElement(r1, 5);
            ArcRegion r8 = (ArcRegion) r0.decodeSerializableElement(r1, 6, (juc.c) r2[6].getValue(), null);
            String r12 = r0.decodeStringElement(r1, 7);
            int r13 = 1023;
            ArcRegion r19 = r8;
            ArcPlatform r15 = r3;
            String r16 = r6;
            String r17 = r7;
            String r21 = r0.decodeStringElement(r1, 8);
            String r20 = r12;
            String r22 = r0.decodeStringElement(r1, 9);
            String r18 = r9;
            String r110 = r10;
            String r111 = r11;
        L24:
            r0.endStructure(r1);
            return new c(r13, r15, r18, r16, r110, r17, r111, r19, r20, r21, r22);
        L5:
            ArcRegion r23 = null;
            String r112 = null;
            String r113 = null;
            String r114 = null;
            String r115 = null;
            String r116 = null;
            String r24 = null;
            String r25 = null;
            String r26 = null;
            int r27 = 0;
            boolean r29 = true;
        L6:
            if (r29 == false) goto L23;
            int r117 = r0.decodeElementIndex(r1);
            switch(r117) {
                case -1: goto L22;
                case 0: goto L21;
                case 1: goto L20;
                case 2: goto L18;
                case 3: goto L17;
                case 4: goto L16;
                case 5: goto L15;
                case 6: goto L14;
                case 7: goto L13;
                case 8: goto L12;
                case 9: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r117);
        L20:
            r116 = r0.decodeStringElement(r1, 1);
            r27 = r27 | 2;
            goto L6
        L21:
            r14 = (ArcPlatform) r0.decodeSerializableElement(r1, 0, (juc.c) r2[0].getValue(), r14);
            r27 = r27 | 1;
            r4 = 2;
            r5 = 4;
            goto L6
        L22:
            r4 = 2;
            r29 = false;
            goto L6
        L11:
            r27 = r27 | 512;
            r112 = r0.decodeStringElement(r1, 9);
            goto L6
        L12:
            r27 = r27 | 256;
            r24 = r0.decodeStringElement(r1, 8);
            goto L6
        L13:
            r27 = r27 | 128;
            r114 = r0.decodeStringElement(r1, 7);
            goto L6
        L14:
            r23 = (ArcRegion) r0.decodeSerializableElement(r1, 6, (juc.c) r2[6].getValue(), r23);
            r27 = r27 | 64;
            goto L6
        L15:
            r27 = r27 | 32;
            r26 = r0.decodeStringElement(r1, 5);
            goto L6
        L16:
            r27 = r27 | 16;
            r25 = r0.decodeStringElement(r1, r5);
            goto L6
        L17:
            r27 = r27 | 8;
            r115 = r0.decodeStringElement(r1, 3);
            goto L6
        L18:
            r27 = r27 | 4;
            r113 = r0.decodeStringElement(r1, r4);
            goto L6
        L23:
            r13 = r27;
            r15 = r14;
            r18 = r116;
            r19 = r23;
            String r210 = r26;
            r22 = r112;
            r16 = r113;
            r110 = r115;
            r111 = r210;
            String r211 = r24;
            r20 = r114;
            r17 = r25;
            r21 = r211;
            goto L24
        }

        public final void serialize(muc.f r9, Object r10) {
            c r11 = (c) r10;
            Intrinsics.checkNotNullParameter(r9, "encoder");
            Intrinsics.checkNotNullParameter(r11, "value");
            g2 r0 = b;
            muc.d r12 = r9.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = c.l;
            boolean r2 = false;
            if (r12.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r12.encodeSerializableElement(r0, 0, (juc.n) r1[0].getValue(), r11.a);
        L12:
            if (r12.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r12.encodeStringElement(r0, 1, r11.b);
        L21:
            if (r12.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            boolean r6 = true;
        L27:
            if (r6 == false) goto L30;
            r12.encodeStringElement(r0, 2, r11.c);
        L30:
            if (r12.shouldEncodeElementDefault(r0, 3) == false) goto L33;
        L34:
            boolean r7 = true;
        L36:
            if (r7 == false) goto L39;
            r12.encodeStringElement(r0, 3, r11.d);
        L39:
            if (r12.shouldEncodeElementDefault(r0, 4) == false) goto L42;
        L43:
            boolean r8 = true;
        L45:
            if (r8 == false) goto L48;
            r12.encodeStringElement(r0, 4, r11.e);
        L48:
            if (r12.shouldEncodeElementDefault(r0, 5) == false) goto L51;
        L52:
            boolean r13 = true;
        L54:
            if (r13 == false) goto L57;
            r12.encodeStringElement(r0, 5, r11.f);
        L57:
            if (r12.shouldEncodeElementDefault(r0, 6) == false) goto L60;
        L61:
            boolean r14 = true;
        L63:
            if (r14 == false) goto L66;
            r12.encodeSerializableElement(r0, 6, (juc.n) r1[6].getValue(), r11.g);
        L66:
            if (r12.shouldEncodeElementDefault(r0, 7) == false) goto L69;
        L70:
            boolean r5 = true;
        L72:
            if (r5 == false) goto L75;
            r12.encodeStringElement(r0, 7, r11.h);
        L75:
            if (r12.shouldEncodeElementDefault(r0, 8) == false) goto L78;
        L79:
            boolean r15 = true;
        L81:
            if (r15 == false) goto L84;
            r12.encodeStringElement(r0, 8, r11.i);
        L84:
            if (r12.shouldEncodeElementDefault(r0, 9) == false) goto L87;
        L88:
            r2 = true;
        L89:
            if (r2 == false) goto L91;
            r12.encodeStringElement(r0, 9, r11.j);
        L91:
            r12.endStructure(r0);
            return;
        L87:
            if (Intrinsics.areEqual(r11.j, "") == true) goto L89;
        L78:
            if (Intrinsics.areEqual(r11.i, "") == false) goto L79;
            r15 = false;
            goto L81
        L69:
            if (Intrinsics.areEqual(r11.h, "") == false) goto L70;
            r5 = false;
            goto L72
        L60:
            if (r11.g != ArcRegion.UNKNOWN) goto L61;
            r14 = false;
            goto L63
        L51:
            if (Intrinsics.areEqual(r11.f, "") == false) goto L52;
            r13 = false;
            goto L54
        L42:
            if (Intrinsics.areEqual(r11.e, "") == false) goto L43;
            r8 = false;
            goto L45
        L33:
            if (Intrinsics.areEqual(r11.d, "") == false) goto L34;
            r7 = false;
            goto L36
        L24:
            if (Intrinsics.areEqual(r11.c, "") == false) goto L25;
            r6 = false;
            goto L27
        L15:
            if (Intrinsics.areEqual(r11.b, "") == false) goto L16;
            r4 = false;
            goto L18
        L6:
            if (r11.a != ArcPlatform.UNKNOWN) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<c> serializer() {
            return a.a;
        }
    }

    public c() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31;
        ArcCallLifecycle r1 = this.k;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "ArcActionContext(platform=" + this.a + ", packageName=" + this.b + ", processName=" + this.c + ", uid=" + this.d + ", did=" + this.e + ", channel=" + this.f + ", region=" + this.g + ", updateVersionCode=" + this.h + ", requestId=" + this.i + ", traceId=" + this.j + ", callLifecycle=" + this.k + ')';
    }

    static {
        Companion = new b();
        LazyThreadSafetyMode r1 = LazyThreadSafetyMode.PUBLICATION;
        l = new Lazy[]{LazyKt.lazy(r1, new com.larus.business.arc.api.a()), null, null, null, null, null, LazyKt.lazy(r1, new com.larus.business.arc.api.b()), null, null, null};
    }

    public /* synthetic */ c(int r13) {
        this(ArcPlatform.UNKNOWN, "", "", "", "", "", ArcRegion.UNKNOWN, "", "", "", null);
    }

    public static c a(c r12, String r13, String r14, ArcCallLifecycle r15) {
        String r2 = r12.b;
        String r3 = r12.c;
        String r4 = r12.d;
        String r5 = r12.e;
        String r6 = r12.f;
        ArcRegion r7 = r12.g;
        String r8 = r12.h;
        Intrinsics.checkNotNullParameter(null, "platform");
        Intrinsics.checkNotNullParameter(r2, "packageName");
        Intrinsics.checkNotNullParameter(r3, "processName");
        Intrinsics.checkNotNullParameter(r4, "uid");
        Intrinsics.checkNotNullParameter(r5, "did");
        Intrinsics.checkNotNullParameter(r6, "channel");
        Intrinsics.checkNotNullParameter(r7, "region");
        Intrinsics.checkNotNullParameter(r8, "updateVersionCode");
        Intrinsics.checkNotNullParameter(r13, "requestId");
        Intrinsics.checkNotNullParameter(r14, "traceId");
        new c(null, r2, r3, r4, r5, r6, r7, r8, r13, r14, r15);
        throw null;
    }

    public c(int r3, ArcPlatform r4, String r5, String r6, String r7, String r8, String r9, ArcRegion r10, String r11, String r12, String r13) {
        if ((r3 & 0) == 0) goto L5;
        b2.b(r3, 0, a.b);
        throw null;
    L5:
        if ((r3 & 1) != 0) goto L7;
        r4 = ArcPlatform.UNKNOWN;
    L7:
        this.a = r4;
        if ((r3 & 2) != 0) goto L10;
        this.b = "";
    L12:
        if ((r3 & 4) != 0) goto L14;
        this.c = "";
    L16:
        if ((r3 & 8) != 0) goto L18;
        this.d = "";
    L20:
        if ((r3 & 16) != 0) goto L22;
        this.e = "";
    L24:
        if ((r3 & 32) != 0) goto L26;
        this.f = "";
    L28:
        if ((r3 & 64) != 0) goto L30;
        this.g = ArcRegion.UNKNOWN;
    L32:
        if ((r3 & 128) != 0) goto L34;
        this.h = "";
    L36:
        if ((r3 & 256) != 0) goto L38;
        this.i = "";
    L40:
        if ((r3 & 512) != 0) goto L42;
        this.j = "";
    L43:
        this.k = null;
        return;
    L42:
        this.j = r13;
        goto L43
    L38:
        this.i = r12;
        goto L40
    L34:
        this.h = r11;
        goto L36
    L30:
        this.g = r10;
        goto L32
    L26:
        this.f = r9;
        goto L28
    L22:
        this.e = r8;
        goto L24
    L18:
        this.d = r7;
        goto L20
    L14:
        this.c = r6;
        goto L16
    L10:
        this.b = r5;
        goto L12
    }

    public c(ArcPlatform r2, String r3, String r4, String r5, String r6, String r7, ArcRegion r8, String r9, String r10, String r11, ArcCallLifecycle r12) {
        Intrinsics.checkNotNullParameter(r2, "platform");
        Intrinsics.checkNotNullParameter(r3, "packageName");
        Intrinsics.checkNotNullParameter(r4, "processName");
        Intrinsics.checkNotNullParameter(r5, "uid");
        Intrinsics.checkNotNullParameter(r6, "did");
        Intrinsics.checkNotNullParameter(r7, "channel");
        Intrinsics.checkNotNullParameter(r8, "region");
        Intrinsics.checkNotNullParameter(r9, "updateVersionCode");
        Intrinsics.checkNotNullParameter(r10, "requestId");
        Intrinsics.checkNotNullParameter(r11, "traceId");
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
        this.k = r12;
    }
}
