package com.larus.bmhome.actionbar.model;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.g2;
import nuc.i2;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Serializable
public final class h1 {
    public static final b Companion = null;
    public final String a;
    public String b;
    public final String c;
    public final g1 d;
    public final g1 e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<h1> {
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
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.InputBoxContent", r0, 10);
            r1.j("placeholder", true);
            r1.j("user_input_content", true);
            r1.j("reply_message_format", true);
            r1.j("icon", true);
            r1.j("dark_mode_icon", true);
            r1.j("title", true);
            r1.j("ai_replica_placeholder", true);
            r1.j("ai_replica_reply_message_format", true);
            r1.j("ai_style_placeholder", true);
            r1.j("ai_replica_generating_reply_message_format", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            v2 r1 = v2.a;
            g1.a r2 = g1.a.a;
            return new juc.d[]{kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1)};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r23) {
            Intrinsics.checkNotNullParameter(r23, "decoder");
            g2 r1 = b;
            muc.c r0 = r23.beginStructure(r1);
            int r3 = 8;
            int r6 = 6;
            int r7 = 7;
            String r13 = null;
            if (r0.decodeSequentially() == false) goto L5;
            v2 r2 = v2.a;
            String r11 = (String) r0.decodeNullableSerializableElement(r1, 0, r2, null);
            String r12 = (String) r0.decodeNullableSerializableElement(r1, 1, r2, null);
            String r9 = (String) r0.decodeNullableSerializableElement(r1, 2, r2, null);
            g1.a r14 = g1.a.a;
            g1 r4 = (g1) r0.decodeNullableSerializableElement(r1, 3, r14, null);
            g1 r10 = (g1) r0.decodeNullableSerializableElement(r1, 4, r14, null);
            String r5 = (String) r0.decodeNullableSerializableElement(r1, 5, r2, null);
            String r8 = (String) r0.decodeNullableSerializableElement(r1, 6, r2, null);
            String r15 = (String) r0.decodeNullableSerializableElement(r1, 7, r2, null);
            String r16 = (String) r0.decodeNullableSerializableElement(r1, 8, r2, null);
            String r17 = (String) r0.decodeNullableSerializableElement(r1, 9, r2, null);
            String r18 = r16;
            String r19 = r5;
            String r110 = r8;
            String r111 = r15;
            String r20 = r11;
            int r21 = 1023;
            g1 r112 = r4;
            String r113 = r9;
            String r22 = r12;
            g1 r114 = r10;
        L27:
            r0.endStructure(r1);
            return new h1(r21, r20, r22, r113, r112, r114, r19, r110, r111, r18, r17);
        L5:
            String r24 = null;
            String r25 = null;
            String r115 = null;
            String r116 = null;
            String r117 = null;
            g1 r118 = null;
            g1 r119 = null;
            String r120 = null;
            String r121 = null;
            int r26 = 0;
            boolean r27 = true;
        L6:
            if (r27 == false) goto L26;
            int r28 = r0.decodeElementIndex(r1);
            switch(r28) {
                case -1: goto L25;
                case 0: goto L23;
                case 1: goto L21;
                case 2: goto L19;
                case 3: goto L18;
                case 4: goto L17;
                case 5: goto L16;
                case 6: goto L14;
                case 7: goto L13;
                case 8: goto L12;
                case 9: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r28);
        L25:
            r3 = 8;
            r6 = 6;
            r7 = 7;
            r27 = false;
            goto L6
        L11:
            r24 = (String) r0.decodeNullableSerializableElement(r1, 9, v2.a, r24);
            r26 = r26 | 512;
        L20:
            String r29 = r120;
        L22:
            String r30 = r121;
        L24:
            r120 = r29;
            r121 = r30;
            r3 = 8;
            r6 = 6;
            r7 = 7;
            goto L6
        L12:
            r25 = (String) r0.decodeNullableSerializableElement(r1, r3, v2.a, r25);
            r26 = r26 | 256;
            goto L20
        L13:
            r115 = (String) r0.decodeNullableSerializableElement(r1, r7, v2.a, r115);
            r26 = r26 | 128;
            goto L20
        L14:
            r117 = (String) r0.decodeNullableSerializableElement(r1, r6, v2.a, r117);
            r26 = r26 | 64;
            goto L20
        L16:
            r116 = (String) r0.decodeNullableSerializableElement(r1, 5, v2.a, r116);
            r26 = r26 | 32;
            goto L20
        L17:
            r119 = (g1) r0.decodeNullableSerializableElement(r1, 4, g1.a.a, r119);
            r26 = r26 | 16;
            goto L20
        L18:
            r118 = (g1) r0.decodeNullableSerializableElement(r1, 3, g1.a.a, r118);
            r26 = r26 | 8;
            goto L20
        L19:
            r120 = (String) r0.decodeNullableSerializableElement(r1, 2, v2.a, r120);
            r26 = r26 | 4;
            goto L20
        L21:
            r29 = r120;
            r121 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, r121);
            r26 = r26 | 2;
            goto L22
        L23:
            r29 = r120;
            r30 = r121;
            r26 = r26 | 1;
            r13 = (String) r0.decodeNullableSerializableElement(r1, 0, v2.a, r13);
            goto L24
        L26:
            r21 = r26;
            r17 = r24;
            r18 = r25;
            r20 = r13;
            r22 = r121;
            r19 = r116;
            r112 = r118;
            r110 = r117;
            r114 = r119;
            r111 = r115;
            r113 = r120;
            goto L27
        }

        public final void serialize(muc.f r7, Object r8) {
            h1 r9 = (h1) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            b r1 = h1.Companion;
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
            r10.encodeNullableSerializableElement(r0, 2, v2.a, r9.c);
        L30:
            if (r10.shouldEncodeElementDefault(r0, 3) == false) goto L33;
        L34:
            boolean r6 = true;
        L36:
            if (r6 == false) goto L39;
            r10.encodeNullableSerializableElement(r0, 3, g1.a.a, r9.d);
        L39:
            if (r10.shouldEncodeElementDefault(r0, 4) == false) goto L42;
        L43:
            boolean r11 = true;
        L45:
            if (r11 == false) goto L48;
            r10.encodeNullableSerializableElement(r0, 4, g1.a.a, r9.e);
        L48:
            if (r10.shouldEncodeElementDefault(r0, 5) == false) goto L51;
        L52:
            boolean r12 = true;
        L54:
            if (r12 == false) goto L57;
            r10.encodeNullableSerializableElement(r0, 5, v2.a, r9.f);
        L57:
            if (r10.shouldEncodeElementDefault(r0, 6) == false) goto L60;
        L61:
            boolean r13 = true;
        L63:
            if (r13 == false) goto L66;
            r10.encodeNullableSerializableElement(r0, 6, v2.a, r9.g);
        L66:
            if (r10.shouldEncodeElementDefault(r0, 7) == false) goto L69;
        L70:
            boolean r14 = true;
        L72:
            if (r14 == false) goto L75;
            r10.encodeNullableSerializableElement(r0, 7, v2.a, r9.h);
        L75:
            if (r10.shouldEncodeElementDefault(r0, 8) == false) goto L78;
        L79:
            boolean r15 = true;
        L81:
            if (r15 == false) goto L84;
            r10.encodeNullableSerializableElement(r0, 8, v2.a, r9.i);
        L84:
            if (r10.shouldEncodeElementDefault(r0, 9) == false) goto L87;
        L88:
            r2 = true;
        L89:
            if (r2 == false) goto L91;
            r10.encodeNullableSerializableElement(r0, 9, v2.a, r9.j);
        L91:
            r10.endStructure(r0);
            return;
        L87:
            if (r9.j == null) goto L89;
        L78:
            if (r9.i != null) goto L79;
            r15 = false;
            goto L81
        L69:
            if (r9.h != null) goto L70;
            r14 = false;
            goto L72
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
            if (Intrinsics.areEqual(r9.c, "") == false) goto L25;
            r5 = false;
            goto L27
        L15:
            if (r9.b != null) goto L16;
            r4 = false;
            goto L18
        L6:
            if (r9.a != null) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<h1> serializer() {
            return a.a;
        }
    }

    public h1() {
        this(null, null, null, null, null, 1023);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof h1) == true) goto L8;
        return false;
    L8:
        h1 r6 = (h1) r5;
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
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L38;
        return false;
    L38:
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
        String r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        g1 r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        g1 r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.g;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.h;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.i;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.j;
        if (r28 == null) goto L43;
        r1 = r28.hashCode();
    L43:
        return r27 + r1;
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
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
        return "InputBoxContent(placeHolder=" + this.a + ", userInputContent=" + this.b + ", replayMessageFormat=" + this.c + ", icon=" + this.d + ", darkModeIcon=" + this.e + ", title=" + this.f + ", aiReplicaPlaceHolder=" + this.g + ", aiReplicaReplyMessageFormat=" + this.h + ", aiStylePlaceholder=" + this.i + ", aiReplicaGeneratingReplyMessageFormat=" + this.j + ')';
    }

    static {
        Companion = new b();
    }

    public static h1 a(h1 r15, String r16, String r17, int r18) {
        String r3 = null;
        if ((r18 & 1) == 0) goto L5;
        String r5 = r15.a;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r6 = r15.b;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r7 = r15.c;
    L15:
        if ((r18 & 8) == 0) goto L17;
        g1 r8 = r15.d;
    L19:
        if ((r18 & 16) == 0) goto L21;
        g1 r9 = r15.e;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r10 = r15.f;
    L27:
        if ((r18 & 64) == 0) goto L29;
        String r11 = r15.g;
    L31:
        if ((r18 & 128) == 0) goto L33;
        String r12 = r15.h;
    L35:
        if ((r18 & 256) == 0) goto L37;
        String r13 = r15.i;
    L39:
        if ((r18 & 512) == 0) goto L42;
        r3 = r15.j;
    L42:
        return new h1(r5, r6, r7, r8, r9, r10, r11, r12, r13, r3);
    L37:
        r13 = null;
        goto L39
    L33:
        r12 = null;
        goto L35
    L29:
        r11 = null;
        goto L31
    L25:
        r10 = null;
        goto L27
    L21:
        r9 = null;
        goto L23
    L17:
        r8 = null;
        goto L19
    L13:
        r7 = r17;
        goto L15
    L9:
        r6 = r16;
        goto L11
    L5:
        r5 = null;
        goto L7
    }

    public /* synthetic */ h1(String r15, String r16, String r17, String r18, String r19, int r20) {
        if ((r20 & 1) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r5 = null;
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r6 = "";
    L15:
        if ((r20 & 128) == 0) goto L17;
        String r11 = null;
    L19:
        if ((r20 & 512) == 0) goto L21;
        String r13 = null;
    L22:
        this(r4, r5, r6, null, null, null, null, r11, null, r13);
        return;
    L21:
        r13 = r19;
        goto L22
    L17:
        r11 = r18;
        goto L19
    L13:
        r6 = r17;
        goto L15
    L9:
        r5 = r16;
        goto L11
    L5:
        r4 = r15;
        goto L7
    }

    public h1(String r1, String r2, String r3, g1 r4, g1 r5, String r6, String r7, String r8, String r9, String r10) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
    }

    public h1(int r3, String r4, String r5, String r6, g1 r7, g1 r8, String r9, String r10, String r11, String r12, String r13) {
        if ((r3 & 0) == 0) goto L5;
        nuc.b2.b(r3, 0, a.b);
        throw null;
    L5:
        if ((r3 & 1) != 0) goto L7;
        this.a = null;
    L9:
        if ((r3 & 2) != 0) goto L11;
        this.b = null;
    L13:
        if ((r3 & 4) != 0) goto L15;
        this.c = "";
    L17:
        if ((r3 & 8) != 0) goto L19;
        this.d = null;
    L21:
        if ((r3 & 16) != 0) goto L23;
        this.e = null;
    L25:
        if ((r3 & 32) != 0) goto L27;
        this.f = null;
    L29:
        if ((r3 & 64) != 0) goto L31;
        this.g = null;
    L33:
        if ((r3 & 128) != 0) goto L35;
        this.h = null;
    L37:
        if ((r3 & 256) != 0) goto L39;
        this.i = null;
    L41:
        if ((r3 & 512) != 0) goto L43;
        this.j = null;
        return;
    L43:
        this.j = r13;
        return;
    L39:
        this.i = r12;
        goto L41
    L35:
        this.h = r11;
        goto L37
    L31:
        this.g = r10;
        goto L33
    L27:
        this.f = r9;
        goto L29
    L23:
        this.e = r8;
        goto L25
    L19:
        this.d = r7;
        goto L21
    L15:
        this.c = r6;
        goto L17
    L11:
        this.b = r5;
        goto L13
    L7:
        this.a = r4;
        goto L9
    }
}
