package com.larus.bmhome.actionbar.model;

import java.util.ArrayList;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.g2;
import nuc.i2;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Serializable
public final class x0 {
    public static final b Companion = null;
    public static final Lazy<juc.d<Object>>[] h = null;
    public final ArrayList<z0> a;
    public final String b;
    public final Boolean c;
    public final Boolean d;
    public final String e;
    public final String f;
    public final Boolean g;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<x0> {
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
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.CustomActionBarConfResult", r0, 7);
            r1.j("entry_list", true);
            r1.j("recommend_request_id", true);
            r1.j("disable_client_reorder", true);
            r1.j("action_bar_always_on_top", true);
            r1.j("red_dot_text", true);
            r1.j("through_token", true);
            r1.j("need_offline_actionbar", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            v2 r0 = v2.a;
            nuc.i r2 = nuc.i.a;
            return new juc.d[]{kuc.a.d((juc.d) x0.h[0].getValue()), kuc.a.d(r0), kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(r0), kuc.a.d(r0), kuc.a.d(r2)};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r19) {
            Intrinsics.checkNotNullParameter(r19, "decoder");
            g2 r1 = b;
            muc.c r0 = r19.beginStructure(r1);
            Lazy<juc.d<Object>>[] r2 = x0.h;
            int r4 = 4;
            ArrayList r11 = null;
            if (r0.decodeSequentially() == false) goto L5;
            ArrayList r3 = (ArrayList) r0.decodeNullableSerializableElement(r1, 0, (juc.c) r2[0].getValue(), null);
            v2 r5 = v2.a;
            String r7 = (String) r0.decodeNullableSerializableElement(r1, 1, r5, null);
            nuc.i r8 = nuc.i.a;
            Boolean r6 = (Boolean) r0.decodeNullableSerializableElement(r1, 2, r8, null);
            Boolean r10 = (Boolean) r0.decodeNullableSerializableElement(r1, 3, r8, null);
            String r9 = (String) r0.decodeNullableSerializableElement(r1, 4, r5, null);
            String r12 = (String) r0.decodeNullableSerializableElement(r1, 5, r5, null);
            Boolean r13 = (Boolean) r0.decodeNullableSerializableElement(r1, 6, r8, null);
            int r14 = 127;
            ArrayList r15 = r3;
            String r16 = r12;
            String r17 = r9;
            Boolean r18 = r13;
            Boolean r110 = r6;
            Boolean r111 = r10;
            String r112 = r7;
        L23:
            r0.endStructure(r1);
            return new x0(r14, r15, r112, r110, r111, r17, r16, r18);
        L5:
            Boolean r20 = null;
            Boolean r21 = null;
            String r113 = null;
            r17 = null;
            r16 = null;
            Boolean r114 = null;
            int r22 = 0;
            boolean r115 = true;
        L6:
            if (r115 == false) goto L22;
            int r23 = r0.decodeElementIndex(r1);
            switch(r23) {
                case -1: goto L21;
                case 0: goto L19;
                case 1: goto L17;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r23);
        L21:
            r115 = false;
            goto L6
        L11:
            r21 = (Boolean) r0.decodeNullableSerializableElement(r1, 6, nuc.i.a, r21);
            r22 = r22 | 64;
        L20:
            r4 = 4;
            goto L6
        L12:
            r16 = (String) r0.decodeNullableSerializableElement(r1, 5, v2.a, r16);
            r22 = r22 | 32;
            goto L20
        L13:
            r17 = (String) r0.decodeNullableSerializableElement(r1, r4, v2.a, r17);
            r22 = r22 | 16;
            goto L20
        L14:
            r114 = (Boolean) r0.decodeNullableSerializableElement(r1, 3, nuc.i.a, r114);
            r22 = r22 | 8;
            goto L20
        L15:
            r20 = (Boolean) r0.decodeNullableSerializableElement(r1, 2, nuc.i.a, r20);
            r22 = r22 | 4;
            goto L20
        L17:
            r113 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, r113);
            r22 = r22 | 2;
            goto L20
        L19:
            r22 = r22 | 1;
            r11 = (ArrayList) r0.decodeNullableSerializableElement(r1, 0, (juc.c) r2[0].getValue(), r11);
            goto L20
        L22:
            r15 = r11;
            r112 = r113;
            r111 = r114;
            r110 = r20;
            r18 = r21;
            r14 = r22;
            goto L23
        }

        public final void serialize(muc.f r7, Object r8) {
            x0 r9 = (x0) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = x0.h;
            boolean r2 = false;
            if (r10.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r10.encodeNullableSerializableElement(r0, 0, (juc.n) r1[0].getValue(), r9.a);
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
            r10.encodeNullableSerializableElement(r0, 2, nuc.i.a, r9.c);
        L30:
            if (r10.shouldEncodeElementDefault(r0, 3) == false) goto L33;
        L34:
            boolean r6 = true;
        L36:
            if (r6 == false) goto L39;
            r10.encodeNullableSerializableElement(r0, 3, nuc.i.a, r9.d);
        L39:
            if (r10.shouldEncodeElementDefault(r0, 4) == false) goto L42;
        L43:
            boolean r11 = true;
        L45:
            if (r11 == false) goto L48;
            r10.encodeNullableSerializableElement(r0, 4, v2.a, r9.e);
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
            r2 = true;
        L62:
            if (r2 == false) goto L64;
            r10.encodeNullableSerializableElement(r0, 6, nuc.i.a, r9.g);
        L64:
            r10.endStructure(r0);
            return;
        L60:
            if (r9.g == null) goto L62;
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
            if (Intrinsics.areEqual(r9.c, Boolean.TRUE) == false) goto L25;
            r5 = false;
            goto L27
        L15:
            if (Intrinsics.areEqual(r9.b, "") == false) goto L16;
            r4 = false;
            goto L18
        L6:
            if (Intrinsics.areEqual(r9.a, new ArrayList()) == false) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<x0> serializer() {
            return a.a;
        }
    }

    public x0() {
        this(null, null, null, null, null, 127);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof x0) == true) goto L8;
        return false;
    L8:
        x0 r6 = (x0) r5;
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
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        ArrayList<z0> r0 = this.a;
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
        String r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Boolean r19 = this.g;
        if (r19 == null) goto L31;
        r1 = r19.hashCode();
    L31:
        return r18 + r1;
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
        return "CustomActionBarConfResult(actionBarItemList=" + this.a + ", recommendRequestId=" + this.b + ", disableClientReorder=" + this.c + ", actionBarAlwaysOnTop=" + this.d + ", redDotText=" + this.e + ", throughToken=" + this.f + ", needOfflineActionbar=" + this.g + ')';
    }

    static {
        Companion = new b();
        h = new Lazy[]{LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new wa8.i1()), null, null, null, null, null, null};
    }

    public x0(ArrayList r3, String r4, Boolean r5, Boolean r6, String r7, int r8) {
        if ((r8 & 1) == 0) goto L6;
        r3 = new ArrayList();
    L6:
        if ((r8 & 2) == 0) goto L9;
        r4 = "";
    L9:
        if ((r8 & 4) == 0) goto L12;
        r5 = Boolean.TRUE;
    L12:
        if ((r8 & 8) == 0) goto L15;
        r6 = null;
    L15:
        if ((r8 & 16) == 0) goto L17;
        r7 = null;
    L17:
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = null;
        this.g = null;
    }

    public x0(int r3, ArrayList r4, String r5, Boolean r6, Boolean r7, String r8, String r9, Boolean r10) {
        if ((r3 & 0) == 0) goto L5;
        nuc.b2.b(r3, 0, a.b);
        throw null;
    L5:
        if ((r3 & 1) != 0) goto L7;
        r4 = new ArrayList();
    L7:
        this.a = r4;
        if ((r3 & 2) != 0) goto L10;
        this.b = "";
    L12:
        if ((r3 & 4) != 0) goto L14;
        this.c = Boolean.TRUE;
    L16:
        if ((r3 & 8) != 0) goto L18;
        this.d = null;
    L20:
        if ((r3 & 16) != 0) goto L22;
        this.e = null;
    L24:
        if ((r3 & 32) != 0) goto L26;
        this.f = null;
    L28:
        if ((r3 & 64) != 0) goto L30;
        this.g = null;
        return;
    L30:
        this.g = r10;
        return;
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
}
