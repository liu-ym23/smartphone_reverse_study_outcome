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
public final class y0 {
    public static final b Companion = null;
    public static final Lazy<juc.d<Object>>[] f = null;
    public final ArrayList<z0> a;
    public final String b;
    public final Boolean c;
    public final Boolean d;
    public final String e;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<y0> {
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
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.CustomActionBarConfResultOld", r0, 5);
            r1.j("item_list", true);
            r1.j("recommend_request_id", true);
            r1.j("disable_client_reorder", true);
            r1.j("action_bar_always_on_top", true);
            r1.j("red_dot_text", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            v2 r0 = v2.a;
            nuc.i r2 = nuc.i.a;
            return new juc.d[]{kuc.a.d((juc.d) y0.f[0].getValue()), kuc.a.d(r0), kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(r0)};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r23) {
            Intrinsics.checkNotNullParameter(r23, "decoder");
            g2 r1 = b;
            muc.c r0 = r23.beginStructure(r1);
            Lazy<juc.d<Object>>[] r2 = y0.f;
            ArrayList r9 = null;
            if (r0.decodeSequentially() == false) goto L5;
            ArrayList r3 = (ArrayList) r0.decodeNullableSerializableElement(r1, 0, (juc.c) r2[0].getValue(), null);
            v2 r4 = v2.a;
            String r6 = (String) r0.decodeNullableSerializableElement(r1, 1, r4, null);
            nuc.i r7 = nuc.i.a;
            Boolean r5 = (Boolean) r0.decodeNullableSerializableElement(r1, 2, r7, null);
            Boolean r8 = (Boolean) r0.decodeNullableSerializableElement(r1, 3, r7, null);
            ArrayList r17 = r3;
            String r21 = (String) r0.decodeNullableSerializableElement(r1, 4, r4, null);
            Boolean r19 = r5;
            String r18 = r6;
            Boolean r20 = r8;
            int r16 = 31;
        L24:
            r0.endStructure(r1);
            return new y0(r16, r17, r18, r19, r20, r21);
        L5:
            String r10 = null;
            Boolean r11 = null;
            Boolean r12 = null;
            String r13 = null;
            int r14 = 0;
            boolean r15 = true;
        L6:
            if (r15 == false) goto L23;
            int r110 = r0.decodeElementIndex(r1);
            if (r110 != (-1)) goto L9;
            r15 = false;
            goto L6
        L9:
            if (r110 != 0) goto L10;
            r9 = (ArrayList) r0.decodeNullableSerializableElement(r1, 0, (juc.c) r2[0].getValue(), r9);
            r14 = r14 | 1;
            goto L6
        L10:
            if (r110 == 1) goto L19;
            if (r110 == 2) goto L18;
            if (r110 == 3) goto L17;
            if (r110 != 4) goto L16;
            r14 = r14 | 16;
            r13 = (String) r0.decodeNullableSerializableElement(r1, 4, v2.a, r13);
            goto L6
        L16:
            throw new UnknownFieldException(r110);
        L17:
            r14 = r14 | 8;
            r12 = (Boolean) r0.decodeNullableSerializableElement(r1, 3, nuc.i.a, r12);
            goto L6
        L18:
            r14 = r14 | 4;
            r11 = (Boolean) r0.decodeNullableSerializableElement(r1, 2, nuc.i.a, r11);
            goto L6
        L19:
            r14 = r14 | 2;
            r10 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, r10);
            goto L6
        L23:
            r16 = r14;
            r17 = r9;
            r18 = r10;
            r19 = r11;
            r20 = r12;
            r21 = r13;
            goto L24
        }

        public final void serialize(muc.f r7, Object r8) {
            y0 r9 = (y0) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = y0.f;
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
            r2 = true;
        L44:
            if (r2 == false) goto L46;
            r10.encodeNullableSerializableElement(r0, 4, v2.a, r9.e);
        L46:
            r10.endStructure(r0);
            return;
        L42:
            if (r9.e == null) goto L44;
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

        public final juc.d<y0> serializer() {
            return a.a;
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof y0) == true) goto L8;
        return false;
    L8:
        y0 r6 = (y0) r5;
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
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
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
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
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
        return "CustomActionBarConfResultOld(actionBarItemList=" + this.a + ", recommendRequestId=" + this.b + ", disableClientReorder=" + this.c + ", actionBarAlwaysOnTop=" + this.d + ", redDotText=" + this.e + ')';
    }

    static {
        Companion = new b();
        f = new Lazy[]{LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new wa8.j1()), null, null, null, null};
    }

    public y0() {
        ArrayList<z0> r0 = new ArrayList();
        Boolean r1 = Boolean.TRUE;
        this.a = r0;
        this.b = "";
        this.c = r1;
        this.d = null;
        this.e = null;
    }

    public final x0 a() {
        return new x0(this.a, this.b, this.c, this.d, this.e, 96);
    }

    public y0(int r3, ArrayList r4, String r5, Boolean r6, Boolean r7, String r8) {
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
        return;
    L22:
        this.e = r8;
        return;
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
