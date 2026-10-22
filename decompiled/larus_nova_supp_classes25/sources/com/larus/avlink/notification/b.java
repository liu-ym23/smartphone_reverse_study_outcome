package com.larus.avlink.notification;

import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.c;
import muc.e;
import nuc.b2;
import nuc.g2;
import nuc.i;
import nuc.i2;
import nuc.m0;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Serializable
public final class b {
    public static final C0018b Companion = null;
    public final String a;
    public final String b;
    public final Boolean c;
    public final Boolean d;
    public final Boolean e;
    public final Boolean f;
    public final Boolean g;
    public final Boolean h;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<b> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.avlink.notification.UploadDoraStatusRequest", r0, 8);
            r1.j("user_id", true);
            r1.j("device_id", true);
            r1.j("connect_status", true);
            r1.j("a2dp", true);
            r1.j("hfp", true);
            r1.j("mic_occupy", true);
            r1.j("current_device_a2dp", true);
            r1.j("support_distinguish_a2dp", true);
            b = r1;
        }

        public final d<?>[] childSerializers() {
            v2 r1 = v2.a;
            i r2 = i.a;
            return new d[]{kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(r2)};
        }

        public final d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r20) {
            Intrinsics.checkNotNullParameter(r20, "decoder");
            g2 r1 = b;
            c r0 = r20.beginStructure(r1);
            int r3 = 4;
            String r11 = null;
            if (r0.decodeSequentially() == false) goto L5;
            v2 r2 = v2.a;
            String r7 = (String) r0.decodeNullableSerializableElement(r1, 0, r2, null);
            String r4 = (String) r0.decodeNullableSerializableElement(r1, 1, r2, null);
            i r8 = i.a;
            Boolean r6 = (Boolean) r0.decodeNullableSerializableElement(r1, 2, r8, null);
            Boolean r5 = (Boolean) r0.decodeNullableSerializableElement(r1, 3, r8, null);
            Boolean r9 = (Boolean) r0.decodeNullableSerializableElement(r1, 4, r8, null);
            Boolean r10 = (Boolean) r0.decodeNullableSerializableElement(r1, 5, r8, null);
            Boolean r12 = (Boolean) r0.decodeNullableSerializableElement(r1, 6, r8, null);
            Boolean r13 = (Boolean) r0.decodeNullableSerializableElement(r1, 7, r8, null);
            String r14 = r4;
            Boolean r15 = r9;
            Boolean r16 = r13;
            Boolean r17 = r12;
            Boolean r18 = r10;
            Boolean r19 = r5;
            Boolean r21 = r6;
            int r22 = 255;
        L24:
            r0.endStructure(r1);
            return new b(r22, r7, r14, r21, r19, r15, r18, r17, r16);
        L5:
            Boolean r23 = null;
            Boolean r24 = null;
            Boolean r25 = null;
            Boolean r110 = null;
            String r111 = null;
            Boolean r112 = null;
            Boolean r113 = null;
            int r26 = 0;
            boolean r114 = true;
        L6:
            if (r114 == false) goto L23;
            int r27 = r0.decodeElementIndex(r1);
            switch(r27) {
                case -1: goto L22;
                case 0: goto L20;
                case 1: goto L18;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                case 7: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r27);
        L22:
            r3 = 4;
            r114 = false;
            goto L6
        L11:
            r110 = (Boolean) r0.decodeNullableSerializableElement(r1, 7, i.a, r110);
            r26 = r26 | 128;
        L21:
            r3 = 4;
            goto L6
        L12:
            r24 = (Boolean) r0.decodeNullableSerializableElement(r1, 6, i.a, r24);
            r26 = r26 | 64;
            goto L21
        L13:
            r113 = (Boolean) r0.decodeNullableSerializableElement(r1, 5, i.a, r113);
            r26 = r26 | 32;
            goto L21
        L14:
            r25 = (Boolean) r0.decodeNullableSerializableElement(r1, r3, i.a, r25);
            r26 = r26 | 16;
            goto L21
        L15:
            r23 = (Boolean) r0.decodeNullableSerializableElement(r1, 3, i.a, r23);
            r26 = r26 | 8;
            goto L21
        L16:
            r112 = (Boolean) r0.decodeNullableSerializableElement(r1, 2, i.a, r112);
            r26 = r26 | 4;
            goto L21
        L18:
            r11 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, r11);
            r26 = r26 | 2;
            goto L21
        L20:
            r26 = r26 | 1;
            r111 = (String) r0.decodeNullableSerializableElement(r1, 0, v2.a, r111);
            goto L21
        L23:
            r19 = r23;
            r21 = r112;
            r22 = r26;
            r16 = r110;
            r18 = r113;
            String r115 = r111;
            r17 = r24;
            r7 = r115;
            String r116 = r11;
            r15 = r25;
            r14 = r116;
            goto L24
        }

        public final void serialize(muc.f r7, Object r8) {
            b r9 = (b) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            C0018b r1 = b.Companion;
            boolean r2 = false;
            if (r10.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r10.encodeNullableSerializableElement(r0, 0, v2.a, r9.a);
        L12:
            if (r10.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r10.encodeNullableSerializableElement(r0, 1, v2.a, r9.b);
        L21:
            if (r10.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            boolean r5 = true;
        L27:
            if (r5 == false) goto L30;
            r10.encodeNullableSerializableElement(r0, 2, i.a, r9.c);
        L30:
            if (r10.shouldEncodeElementDefault(r0, 3) == false) goto L33;
        L34:
            boolean r6 = true;
        L36:
            if (r6 == false) goto L39;
            r10.encodeNullableSerializableElement(r0, 3, i.a, r9.d);
        L39:
            if (r10.shouldEncodeElementDefault(r0, 4) == false) goto L42;
        L43:
            boolean r11 = true;
        L45:
            if (r11 == false) goto L48;
            r10.encodeNullableSerializableElement(r0, 4, i.a, r9.e);
        L48:
            if (r10.shouldEncodeElementDefault(r0, 5) == false) goto L51;
        L52:
            boolean r12 = true;
        L54:
            if (r12 == false) goto L57;
            r10.encodeNullableSerializableElement(r0, 5, i.a, r9.f);
        L57:
            if (r10.shouldEncodeElementDefault(r0, 6) == false) goto L60;
        L61:
            boolean r13 = true;
        L63:
            if (r13 == false) goto L66;
            r10.encodeNullableSerializableElement(r0, 6, i.a, r9.g);
        L66:
            if (r10.shouldEncodeElementDefault(r0, 7) == false) goto L69;
        L70:
            r2 = true;
        L71:
            if (r2 == false) goto L73;
            r10.encodeNullableSerializableElement(r0, 7, i.a, r9.h);
        L73:
            r10.endStructure(r0);
            return;
        L69:
            if (r9.h == null) goto L71;
        L60:
            if (r9.g != null) goto L61;
            r13 = false;
            goto L63
        L51:
            if (r9.f != null) goto L52;
            r12 = false;
            goto L54
        L42:
            if (r9.e != null) goto L43;
            r11 = false;
            goto L45
        L33:
            if (r9.d != null) goto L34;
            r6 = false;
            goto L36
        L24:
            if (r9.c != null) goto L25;
            r5 = false;
            goto L27
        L15:
            if (Intrinsics.areEqual(r9.b, "") == false) goto L16;
            r4 = false;
            goto L18
        L6:
            if (Intrinsics.areEqual(r9.a, "") == false) goto L7;
            r3 = false;
            goto L9
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.notification.b$b, reason: collision with other inner class name */
    public static final class C0018b {
        public C0018b() {
        }

        public final d<b> serializer() {
            return a.a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b() {
        Object[] r0 = 0 == true ? 1 : 0;
        Object[] r1 = 0 == true ? 1 : 0;
        this(null, r0, r1, 255);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
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
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Boolean r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Boolean r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Boolean r19 = this.g;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Boolean r22 = this.h;
        if (r22 == null) goto L35;
        r1 = r22.hashCode();
    L35:
        return r21 + r1;
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "UploadDoraStatusRequest(userId=" + this.a + ", deviceId=" + this.b + ", connectStatus=" + this.c + ", a2dp=" + this.d + ", hfp=" + this.e + ", micOccupy=" + this.f + ", currentDeviceA2dp=" + this.g + ", supportDistinguishA2dp=" + this.h + ')';
    }

    static {
        Companion = new C0018b();
    }

    public /* synthetic */ b(String r12, String r13, Boolean r14, int r15) {
        if ((r15 & 1) == 0) goto L5;
        String r3 = "";
    L7:
        if ((r15 & 2) == 0) goto L9;
        String r4 = "";
    L11:
        if ((r15 & 32) == 0) goto L13;
        r14 = null;
    L13:
        this(r3, r4, null, null, null, r14, null, null);
        return;
    L9:
        r4 = r13;
        goto L11
    L5:
        r3 = r12;
        goto L7
    }

    public b(String r1, String r2, Boolean r3, Boolean r4, Boolean r5, Boolean r6, Boolean r7, Boolean r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }

    public b(int r4, String r5, String r6, Boolean r7, Boolean r8, Boolean r9, Boolean r10, Boolean r11, Boolean r12) {
        if ((r4 & 0) == 0) goto L5;
        b2.b(r4, 0, a.b);
        throw null;
    L5:
        if ((r4 & 1) != 0) goto L7;
        this.a = "";
    L9:
        if ((r4 & 2) != 0) goto L11;
        this.b = "";
    L13:
        if ((r4 & 4) != 0) goto L15;
        this.c = null;
    L17:
        if ((r4 & 8) != 0) goto L19;
        this.d = null;
    L21:
        if ((r4 & 16) != 0) goto L23;
        this.e = null;
    L25:
        if ((r4 & 32) != 0) goto L27;
        this.f = null;
    L29:
        if ((r4 & 64) != 0) goto L31;
        this.g = null;
    L33:
        if ((r4 & 128) != 0) goto L35;
        this.h = null;
        return;
    L35:
        this.h = r12;
        return;
    L31:
        this.g = r11;
        goto L33
    L27:
        this.f = r10;
        goto L29
    L23:
        this.e = r9;
        goto L25
    L19:
        this.d = r8;
        goto L21
    L15:
        this.c = r7;
        goto L17
    L11:
        this.b = r6;
        goto L13
    L7:
        this.a = r5;
        goto L9
    }
}
