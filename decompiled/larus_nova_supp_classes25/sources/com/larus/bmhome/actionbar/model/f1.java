package com.larus.bmhome.actionbar.model;

import java.util.ArrayList;
import java.util.List;
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
public final class f1 {
    public static final b Companion = null;
    public static final Lazy<juc.d<Object>>[] d = null;
    public final String a;
    public final List<Long> b;
    public final Long c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<f1> {
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
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.FilterConf", r0, 3);
            r1.j("match_ui_id", true);
            r1.j("option_list", true);
            r1.j("default_option_id", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{kuc.a.d(v2.a), kuc.a.d((juc.d) f1.d[1].getValue()), kuc.a.d(nuc.g1.a)};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r13) {
            Intrinsics.checkNotNullParameter(r13, "decoder");
            g2 r0 = b;
            muc.c r14 = r13.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = f1.d;
            String r6 = null;
            if (r14.decodeSequentially() == false) goto L5;
            String r2 = (String) r14.decodeNullableSerializableElement(r0, 0, v2.a, null);
            List r3 = (List) r14.decodeNullableSerializableElement(r0, 1, (juc.c) r1[1].getValue(), null);
            Long r4 = (Long) r14.decodeNullableSerializableElement(r0, 2, nuc.g1.a, null);
            int r5 = 7;
        L19:
            r14.endStructure(r0);
            return new f1(r5, r2, r3, r4);
        L5:
            List r7 = null;
            Long r8 = null;
            int r9 = 0;
            boolean r10 = true;
        L6:
            if (r10 == false) goto L18;
            int r11 = r14.decodeElementIndex(r0);
            if (r11 != (-1)) goto L9;
            r10 = false;
            goto L6
        L9:
            if (r11 != 0) goto L10;
            r6 = (String) r14.decodeNullableSerializableElement(r0, 0, v2.a, r6);
            r9 = r9 | 1;
            goto L6
        L10:
            if (r11 != 1) goto L11;
            r7 = (List) r14.decodeNullableSerializableElement(r0, 1, (juc.c) r1[1].getValue(), r7);
            r9 = r9 | 2;
            goto L6
        L11:
            if (r11 != 2) goto L14;
            r8 = (Long) r14.decodeNullableSerializableElement(r0, 2, nuc.g1.a, r8);
            r9 = r9 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r11);
        L18:
            r5 = r9;
            r2 = r6;
            r3 = r7;
            r4 = r8;
            goto L19
        }

        public final void serialize(muc.f r10, Object r11) {
            f1 r12 = (f1) r11;
            Intrinsics.checkNotNullParameter(r10, "encoder");
            Intrinsics.checkNotNullParameter(r12, "value");
            g2 r0 = b;
            muc.d r13 = r10.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = f1.d;
            boolean r2 = false;
            if (r13.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r13.encodeNullableSerializableElement(r0, 0, v2.a, r12.a);
        L12:
            if (r13.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r13.encodeNullableSerializableElement(r0, 1, (juc.n) r1[1].getValue(), r12.b);
        L21:
            if (r13.shouldEncodeElementDefault(r0, 2) == true) goto L28;
            Long r5 = r12.c;
            if (r5 == null) goto L28;
            if (r5.longValue() != (-1)) goto L28;
        L29:
            if (r2 == false) goto L31;
            r13.encodeNullableSerializableElement(r0, 2, nuc.g1.a, r12.c);
        L31:
            r13.endStructure(r0);
            return;
        L28:
            r2 = true;
            goto L29
        L15:
            if (Intrinsics.areEqual(r12.b, new ArrayList()) == false) goto L16;
            r4 = false;
            goto L18
        L6:
            if (Intrinsics.areEqual(r12.a, "") == false) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<f1> serializer() {
            return a.a;
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f1) == true) goto L8;
        return false;
    L8:
        f1 r6 = (f1) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<Long> r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.c;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "FilterConf(matchUiId=" + this.a + ", optionList=" + this.b + ", defaultOptionId=" + this.c + ')';
    }

    static {
        Companion = new b();
        d = new Lazy[]{null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new wa8.m1()), null};
    }

    public f1() {
        ArrayList r0 = new ArrayList();
        this.a = "";
        this.b = r0;
        this.c = -1L;
    }

    public f1(int r2, String r3, List r4, Long r5) {
        if ((r2 & 0) == 0) goto L5;
        nuc.b2.b(r2, 0, a.b);
        throw null;
    L5:
        if ((r2 & 1) != 0) goto L7;
        r3 = "";
    L7:
        this.a = r3;
        if ((r2 & 2) != 0) goto L10;
        this.b = new ArrayList();
    L12:
        if ((r2 & 4) != 0) goto L14;
        this.c = -1L;
        return;
    L14:
        this.c = r5;
        return;
    L10:
        this.b = r4;
        goto L12
    }
}
