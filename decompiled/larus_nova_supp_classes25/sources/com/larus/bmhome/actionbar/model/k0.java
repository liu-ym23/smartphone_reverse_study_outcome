package com.larus.bmhome.actionbar.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.g2;
import nuc.i2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Serializable
public final class k0 implements k1 {
    public static final b Companion = null;
    public static final Lazy<juc.d<Object>>[] f = null;
    public final Integer a;
    public final y1 b;
    public final List<y1> c;
    public Integer d;
    public final Boolean e;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<k0> {
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
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.ActionBarTextSelectorTemplate", r0, 5);
            r1.j("col_nums", true);
            r1.j("default_option", true);
            r1.j("option_list", true);
            r1.j("default_selection_index", true);
            r1.j("choose_required", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r0 = k0.f;
            nuc.w0 r2 = nuc.w0.a;
            return new juc.d[]{kuc.a.d(r2), kuc.a.d(y1.a.a), kuc.a.d((juc.d) r0[2].getValue()), kuc.a.d(r2), kuc.a.d(nuc.i.a)};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r24) {
            Intrinsics.checkNotNullParameter(r24, "decoder");
            g2 r1 = b;
            muc.c r0 = r24.beginStructure(r1);
            Lazy<juc.d<Object>>[] r2 = k0.f;
            Integer r9 = null;
            if (r0.decodeSequentially() == false) goto L5;
            nuc.w0 r3 = nuc.w0.a;
            Integer r7 = (Integer) r0.decodeNullableSerializableElement(r1, 0, r3, null);
            y1 r6 = (y1) r0.decodeNullableSerializableElement(r1, 1, y1.a.a, null);
            List r4 = (List) r0.decodeNullableSerializableElement(r1, 2, (juc.c) r2[2].getValue(), null);
            List r20 = r4;
            Integer r21 = (Integer) r0.decodeNullableSerializableElement(r1, 3, r3, null);
            Boolean r22 = (Boolean) r0.decodeNullableSerializableElement(r1, 4, nuc.i.a, null);
            y1 r19 = r6;
            Integer r18 = r7;
            int r17 = 31;
        L25:
            r0.endStructure(r1);
            return new k0(r17, r18, r19, r20, r21, r22);
        L5:
            y1 r10 = null;
            List r11 = null;
            Integer r12 = null;
            Boolean r13 = null;
            int r5 = 0;
            boolean r14 = true;
        L6:
            if (r14 == false) goto L24;
            int r15 = r0.decodeElementIndex(r1);
            if (r15 != (-1)) goto L9;
            r14 = false;
            goto L6
        L9:
            if (r15 == 0) goto L21;
            if (r15 == 1) goto L19;
            if (r15 == 2) goto L18;
            if (r15 == 3) goto L17;
            if (r15 != 4) goto L16;
            r13 = (Boolean) r0.decodeNullableSerializableElement(r1, 4, nuc.i.a, r13);
            r5 = r5 | 16;
            goto L6
        L16:
            throw new UnknownFieldException(r15);
        L17:
            r12 = (Integer) r0.decodeNullableSerializableElement(r1, 3, nuc.w0.a, r12);
            r5 = r5 | 8;
            goto L6
        L18:
            r11 = (List) r0.decodeNullableSerializableElement(r1, 2, (juc.c) r2[2].getValue(), r11);
            r5 = r5 | 4;
            goto L6
        L19:
            r10 = (y1) r0.decodeNullableSerializableElement(r1, 1, y1.a.a, r10);
            r5 = r5 | 2;
            goto L6
        L21:
            r5 = r5 | 1;
            r9 = (Integer) r0.decodeNullableSerializableElement(r1, 0, nuc.w0.a, r9);
            goto L6
        L24:
            r17 = r5;
            r18 = r9;
            r19 = r10;
            r20 = r11;
            r21 = r12;
            r22 = r13;
            goto L25
        }

        public final void serialize(muc.f r8, Object r9) {
            k0 r10 = (k0) r9;
            Intrinsics.checkNotNullParameter(r8, "encoder");
            Intrinsics.checkNotNullParameter(r10, "value");
            g2 r0 = b;
            muc.d r11 = r8.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = k0.f;
            boolean r2 = false;
            if (r11.shouldEncodeElementDefault(r0, 0) == true) goto L10;
            Integer r3 = r10.a;
            if (r3 == null) goto L10;
            if (r3.intValue() != 1) goto L10;
            boolean r4 = false;
        L12:
            if (r4 == false) goto L15;
            r11.encodeNullableSerializableElement(r0, 0, nuc.w0.a, r10.a);
        L15:
            if (r11.shouldEncodeElementDefault(r0, 1) == false) goto L18;
        L19:
            boolean r5 = true;
        L21:
            if (r5 == false) goto L24;
            r11.encodeNullableSerializableElement(r0, 1, y1.a.a, r10.b);
        L24:
            if (r11.shouldEncodeElementDefault(r0, 2) == false) goto L27;
        L28:
            boolean r6 = true;
        L30:
            if (r6 == false) goto L33;
            r11.encodeNullableSerializableElement(r0, 2, (juc.n) r1[2].getValue(), r10.c);
        L33:
            if (r11.shouldEncodeElementDefault(r0, 3) == true) goto L40;
            Integer r7 = r10.d;
            if (r7 == null) goto L40;
            if (r7.intValue() != (-1)) goto L40;
            boolean r12 = false;
        L42:
            if (r12 == false) goto L45;
            r11.encodeNullableSerializableElement(r0, 3, nuc.w0.a, r10.d);
        L45:
            if (r11.shouldEncodeElementDefault(r0, 4) == false) goto L48;
        L49:
            r2 = true;
        L50:
            if (r2 == false) goto L52;
            r11.encodeNullableSerializableElement(r0, 4, nuc.i.a, r10.e);
        L52:
            r11.endStructure(r0);
            return;
        L48:
            if (Intrinsics.areEqual(r10.e, Boolean.FALSE) == true) goto L50;
        L40:
            r12 = true;
            goto L42
        L27:
            if (Intrinsics.areEqual(r10.c, new ArrayList()) == false) goto L28;
            r6 = false;
            goto L30
        L18:
            if (r10.b != null) goto L19;
            r5 = false;
        L10:
            r4 = true;
            goto L12
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<k0> serializer() {
            return a.a;
        }
    }

    public k0() {
        this(1, null, new ArrayList(), -1, Boolean.FALSE);
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final List<String> b(List<String> r1) {
        return null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof k0) == true) goto L8;
        return false;
    L8:
        k0 r6 = (k0) r5;
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
        Integer r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        y1 r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        List<y1> r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Boolean r13 = this.e;
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
        return "ActionBarTextSelectorTemplate(colNums=" + this.a + ", defaultOption=" + this.b + ", options=" + this.c + ", defaultSelectionIndex=" + this.d + ", chooseRequired=" + this.e + ')';
    }

    static {
        Companion = new b();
        f = new Lazy[]{null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new wa8.p0()), null, null};
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final String a() {
        List<y1> r0 = this.c;
        if (r0 == null) goto L9;
        List<y1> r1 = r0;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r3 = r1.iterator();
    L6:
        if (r3.hasNext() == false) goto L12;
        r2.add(((y1) r3.next()).b);
        goto L6
    L12:
        return CollectionsKt.joinToString$default(r2, ";", null, null, 0, null, null, 62, null);
    L9:
        return null;
    }

    public static k0 d(k0 r6, List r7) {
        return new k0(r6.a, r6.b, r7, r6.d, r6.e);
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final String c(String r10, List<String> r11) {
        List<y1> r12 = this.c;
        if (r12 == null) goto L9;
        List<y1> r13 = r12;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator<T> r14 = r13.iterator();
    L6:
        if (r14.hasNext() == false) goto L12;
        r0.add(((y1) r14.next()).c);
        goto L6
    L12:
        return CollectionsKt.joinToString$default(r0, wa8.h.a(), null, null, 0, null, null, 62, null);
    L9:
        return null;
    }

    public k0(Integer r1, y1 r2, List<y1> r3, Integer r4, Boolean r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public k0(int r3, Integer r4, y1 r5, List r6, Integer r7, Boolean r8) {
        if ((r3 & 0) == 0) goto L5;
        nuc.b2.b(r3, 0, a.b);
        throw null;
    L5:
        if ((r3 & 1) != 0) goto L7;
        r4 = 1;
    L7:
        this.a = r4;
        if ((r3 & 2) != 0) goto L10;
        this.b = null;
    L12:
        if ((r3 & 4) != 0) goto L14;
        this.c = new ArrayList();
    L16:
        if ((r3 & 8) != 0) goto L18;
        this.d = -1;
    L20:
        if ((r3 & 16) != 0) goto L22;
        this.e = Boolean.FALSE;
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
