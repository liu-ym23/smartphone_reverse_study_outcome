package jq9;

import java.util.List;
import juc.n;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Serializable
public final class j {
    public static final b Companion = null;
    public static final Lazy<juc.d<Object>>[] j = null;
    public final Integer a;
    public final List<String> b;
    public final List<String> c;
    public final List<String> d;
    public final List<String> e;
    public final List<String> f;
    public final List<String> g;
    public final String h;
    public final String i;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<j> {
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
            g2 r1 = new g2("com.larus.platform.model.actionbar.ActionBarGradientStyle", r0, 9);
            r1.j("instruction_type", true);
            r1.j("text_light_color_list", true);
            r1.j("text_dark_color_list", true);
            r1.j("background_light_color_list", true);
            r1.j("background_dark_color_list", true);
            r1.j("border_dark_color_list", true);
            r1.j("border_light_color_list", true);
            r1.j("foreground_light_color", true);
            r1.j("foreground_dark_color", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r0 = j.j;
            v2 r1 = v2.a;
            return new juc.d[]{kuc.a.d(w0.a), kuc.a.d((juc.d) r0[1].getValue()), kuc.a.d((juc.d) r0[2].getValue()), kuc.a.d((juc.d) r0[3].getValue()), kuc.a.d((juc.d) r0[4].getValue()), kuc.a.d((juc.d) r0[5].getValue()), kuc.a.d((juc.d) r0[6].getValue()), kuc.a.d(r1), kuc.a.d(r1)};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r24) {
            Intrinsics.checkNotNullParameter(r24, "decoder");
            g2 r1 = b;
            muc.c r0 = r24.beginStructure(r1);
            Lazy<juc.d<Object>>[] r2 = j.j;
            int r5 = 5;
            int r6 = 6;
            int r7 = 7;
            List r13 = null;
            if (r0.decodeSequentially() == false) goto L5;
            Integer r3 = (Integer) r0.decodeNullableSerializableElement(r1, 0, w0.a, null);
            List r11 = (List) r0.decodeNullableSerializableElement(r1, 1, (juc.c) r2[1].getValue(), null);
            List r8 = (List) r0.decodeNullableSerializableElement(r1, 2, (juc.c) r2[2].getValue(), null);
            List r4 = (List) r0.decodeNullableSerializableElement(r1, 3, (juc.c) r2[3].getValue(), null);
            List r9 = (List) r0.decodeNullableSerializableElement(r1, 4, (juc.c) r2[4].getValue(), null);
            List r10 = (List) r0.decodeNullableSerializableElement(r1, 5, (juc.c) r2[5].getValue(), null);
            List r12 = (List) r0.decodeNullableSerializableElement(r1, 6, (juc.c) r2[6].getValue(), null);
            v2 r14 = v2.a;
            String r15 = (String) r0.decodeNullableSerializableElement(r1, 7, r14, null);
            List r18 = r12;
            Integer r16 = r3;
            List r17 = r4;
            List r19 = r10;
            String r20 = (String) r0.decodeNullableSerializableElement(r1, 8, r14, null);
            String r110 = r15;
            List r111 = r8;
            List r112 = r9;
            r13 = r11;
            int r113 = 511;
        L26:
            r0.endStructure(r1);
            return new j(r113, r16, r13, r111, r17, r112, r19, r18, r110, r20);
        L5:
            String r21 = null;
            String r22 = null;
            List r114 = null;
            List r115 = null;
            List r116 = null;
            List r117 = null;
            List r118 = null;
            Integer r23 = null;
            int r25 = 0;
            boolean r26 = true;
        L6:
            if (r26 == false) goto L25;
            int r27 = r0.decodeElementIndex(r1);
            switch(r27) {
                case -1: goto L24;
                case 0: goto L22;
                case 1: goto L21;
                case 2: goto L19;
                case 3: goto L18;
                case 4: goto L17;
                case 5: goto L16;
                case 6: goto L13;
                case 7: goto L12;
                case 8: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r27);
        L24:
            r5 = 5;
            r7 = 7;
            r26 = false;
            goto L6
        L11:
            r22 = (String) r0.decodeNullableSerializableElement(r1, 8, v2.a, r22);
            r25 = r25 | 256;
        L14:
            List r28 = r118;
        L23:
            r118 = r28;
            r5 = 5;
            r6 = 6;
            r7 = 7;
            goto L6
        L12:
            r21 = (String) r0.decodeNullableSerializableElement(r1, r7, v2.a, r21);
            r25 = r25 | 128;
            goto L14
        L13:
            r25 = r25 | 64;
            r114 = (List) r0.decodeNullableSerializableElement(r1, r6, (juc.c) r2[r6].getValue(), r114);
            goto L14
        L16:
            r117 = (List) r0.decodeNullableSerializableElement(r1, r5, (juc.c) r2[r5].getValue(), r117);
            r25 = r25 | 32;
        L20:
            r28 = r118;
            goto L23
        L17:
            r115 = (List) r0.decodeNullableSerializableElement(r1, 4, (juc.c) r2[4].getValue(), r115);
            r25 = r25 | 16;
            goto L20
        L18:
            r116 = (List) r0.decodeNullableSerializableElement(r1, 3, (juc.c) r2[3].getValue(), r116);
            r25 = r25 | 8;
            goto L20
        L19:
            r118 = (List) r0.decodeNullableSerializableElement(r1, 2, (juc.c) r2[2].getValue(), r118);
            r25 = r25 | 4;
            goto L20
        L21:
            r28 = r118;
            r25 = r25 | 2;
            r13 = (List) r0.decodeNullableSerializableElement(r1, 1, (juc.c) r2[1].getValue(), r13);
            goto L23
        L22:
            r28 = r118;
            r23 = (Integer) r0.decodeNullableSerializableElement(r1, 0, w0.a, r23);
            r25 = r25 | 1;
            goto L23
        L25:
            List r29 = r118;
            Integer r30 = r23;
            r110 = r21;
            r20 = r22;
            r18 = r114;
            r112 = r115;
            r19 = r117;
            r113 = r25;
            r16 = r30;
            r17 = r116;
            r111 = r29;
            goto L26
        }

        public final void serialize(muc.f r8, Object r9) {
            j r10 = (j) r9;
            Intrinsics.checkNotNullParameter(r8, "encoder");
            Intrinsics.checkNotNullParameter(r10, "value");
            g2 r0 = b;
            muc.d r11 = r8.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = j.j;
            boolean r2 = false;
            if (r11.shouldEncodeElementDefault(r0, 0) == true) goto L10;
            Integer r3 = r10.a;
            if (r3 == null) goto L10;
            if (r3.intValue() != (-1)) goto L10;
            boolean r4 = false;
        L12:
            if (r4 == false) goto L15;
            r11.encodeNullableSerializableElement(r0, 0, w0.a, r10.a);
        L15:
            if (r11.shouldEncodeElementDefault(r0, 1) == false) goto L18;
        L19:
            boolean r5 = true;
        L21:
            if (r5 == false) goto L24;
            r11.encodeNullableSerializableElement(r0, 1, (n) r1[1].getValue(), r10.b);
        L24:
            if (r11.shouldEncodeElementDefault(r0, 2) == false) goto L27;
        L28:
            boolean r6 = true;
        L30:
            if (r6 == false) goto L33;
            r11.encodeNullableSerializableElement(r0, 2, (n) r1[2].getValue(), r10.c);
        L33:
            if (r11.shouldEncodeElementDefault(r0, 3) == false) goto L36;
        L37:
            boolean r7 = true;
        L39:
            if (r7 == false) goto L42;
            r11.encodeNullableSerializableElement(r0, 3, (n) r1[3].getValue(), r10.d);
        L42:
            if (r11.shouldEncodeElementDefault(r0, 4) == false) goto L45;
        L46:
            boolean r12 = true;
        L48:
            if (r12 == false) goto L51;
            r11.encodeNullableSerializableElement(r0, 4, (n) r1[4].getValue(), r10.e);
        L51:
            if (r11.shouldEncodeElementDefault(r0, 5) == false) goto L54;
        L55:
            boolean r13 = true;
        L57:
            if (r13 == false) goto L60;
            r11.encodeNullableSerializableElement(r0, 5, (n) r1[5].getValue(), r10.f);
        L60:
            if (r11.shouldEncodeElementDefault(r0, 6) == false) goto L63;
        L64:
            boolean r14 = true;
        L66:
            if (r14 == false) goto L69;
            r11.encodeNullableSerializableElement(r0, 6, (n) r1[6].getValue(), r10.g);
        L69:
            if (r11.shouldEncodeElementDefault(r0, 7) == false) goto L72;
        L73:
            boolean r15 = true;
        L75:
            if (r15 == false) goto L78;
            r11.encodeNullableSerializableElement(r0, 7, v2.a, r10.h);
        L78:
            if (r11.shouldEncodeElementDefault(r0, 8) == false) goto L81;
        L82:
            r2 = true;
        L83:
            if (r2 == false) goto L85;
            r11.encodeNullableSerializableElement(r0, 8, v2.a, r10.i);
        L85:
            r11.endStructure(r0);
            return;
        L81:
            if (Intrinsics.areEqual(r10.i, "") == true) goto L83;
        L72:
            if (Intrinsics.areEqual(r10.h, "") == false) goto L73;
            r15 = false;
            goto L75
        L63:
            if (Intrinsics.areEqual(r10.g, CollectionsKt.emptyList()) == false) goto L64;
            r14 = false;
            goto L66
        L54:
            if (Intrinsics.areEqual(r10.f, CollectionsKt.emptyList()) == false) goto L55;
            r13 = false;
            goto L57
        L45:
            if (Intrinsics.areEqual(r10.e, CollectionsKt.emptyList()) == false) goto L46;
            r12 = false;
            goto L48
        L36:
            if (Intrinsics.areEqual(r10.d, CollectionsKt.emptyList()) == false) goto L37;
            r7 = false;
            goto L39
        L27:
            if (Intrinsics.areEqual(r10.c, CollectionsKt.emptyList()) == false) goto L28;
            r6 = false;
            goto L30
        L18:
            if (Intrinsics.areEqual(r10.b, CollectionsKt.emptyList()) == false) goto L19;
            r5 = false;
        L10:
            r4 = true;
            goto L12
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<j> serializer() {
            return a.a;
        }
    }

    public j() {
        this(-1, CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), "", "");
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof j) == true) goto L8;
        return false;
    L8:
        j r6 = (j) r5;
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
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        Integer r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<String> r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        List<String> r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        List<String> r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        List<String> r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        List<String> r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        List<String> r19 = this.g;
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
        if (r25 == null) goto L39;
        r1 = r25.hashCode();
    L39:
        return r24 + r1;
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
        return "ActionBarGradientStyle(instructionType=" + this.a + ", textLightColorList=" + this.b + ", textDarkColorList=" + this.c + ", backgroundLightColorList=" + this.d + ", backgroundDarkColorList=" + this.e + ", borderDarkColorList=" + this.f + ", borderLightColorList=" + this.g + ", foregroundLightColor=" + this.h + ", foregroundDarkColor=" + this.i + ')';
    }

    static {
        Companion = new b();
        LazyThreadSafetyMode r1 = LazyThreadSafetyMode.PUBLICATION;
        j = new Lazy[]{null, LazyKt.lazy(r1, new d()), LazyKt.lazy(r1, new e()), LazyKt.lazy(r1, new f()), LazyKt.lazy(r1, new g()), LazyKt.lazy(r1, new h()), LazyKt.lazy(r1, new i()), null, null};
    }

    public j(Integer r1, List<String> r2, List<String> r3, List<String> r4, List<String> r5, List<String> r6, List<String> r7, String r8, String r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
    }

    public j(int r2, Integer r3, List r4, List r5, List r6, List r7, List r8, List r9, String r10, String r11) {
        if ((r2 & 0) == 0) goto L5;
        b2.b(r2, 0, a.b);
        throw null;
    L5:
        if ((r2 & 1) != 0) goto L7;
        r3 = -1;
    L7:
        this.a = r3;
        if ((r2 & 2) != 0) goto L10;
        this.b = CollectionsKt.emptyList();
    L12:
        if ((r2 & 4) != 0) goto L14;
        this.c = CollectionsKt.emptyList();
    L16:
        if ((r2 & 8) != 0) goto L18;
        this.d = CollectionsKt.emptyList();
    L20:
        if ((r2 & 16) != 0) goto L22;
        this.e = CollectionsKt.emptyList();
    L24:
        if ((r2 & 32) != 0) goto L26;
        this.f = CollectionsKt.emptyList();
    L28:
        if ((r2 & 64) != 0) goto L30;
        this.g = CollectionsKt.emptyList();
    L32:
        if ((r2 & 128) != 0) goto L34;
        this.h = "";
    L36:
        if ((r2 & 256) != 0) goto L38;
        this.i = "";
        return;
    L38:
        this.i = r11;
        return;
    L34:
        this.h = r10;
        goto L36
    L30:
        this.g = r9;
        goto L32
    L26:
        this.f = r8;
        goto L28
    L22:
        this.e = r7;
        goto L24
    L18:
        this.d = r6;
        goto L20
    L14:
        this.c = r5;
        goto L16
    L10:
        this.b = r4;
        goto L12
    }
}
