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
public final class d0 implements k1 {
    public static final b Companion = null;
    public static final Lazy<juc.d<Object>>[] f = null;
    public List<w> a;
    public Integer b;
    public final Boolean c;
    public final List<w> d;
    public final bq8.a e;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<d0> {
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
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.ActionBarMusicTemplateInstructionTemplate", r0, 5);
            r1.j("option_list", true);
            r1.j("default_selection_index", true);
            r1.j("choose_required", true);
            r1.j("other_option_list", true);
            r1.j("selected_template", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r0 = d0.f;
            return new juc.d[]{kuc.a.d((juc.d) r0[0].getValue()), kuc.a.d(nuc.w0.a), kuc.a.d(nuc.i.a), kuc.a.d((juc.d) r0[3].getValue()), kuc.a.d(bq8.b.a)};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r23) {
            Intrinsics.checkNotNullParameter(r23, "decoder");
            g2 r1 = b;
            muc.c r0 = r23.beginStructure(r1);
            Lazy<juc.d<Object>>[] r2 = d0.f;
            List r9 = null;
            if (r0.decodeSequentially() == false) goto L5;
            List r3 = (List) r0.decodeNullableSerializableElement(r1, 0, (juc.c) r2[0].getValue(), null);
            Integer r6 = (Integer) r0.decodeNullableSerializableElement(r1, 1, nuc.w0.a, null);
            Boolean r4 = (Boolean) r0.decodeNullableSerializableElement(r1, 2, nuc.i.a, null);
            List r20 = (List) r0.decodeNullableSerializableElement(r1, 3, (juc.c) r2[3].getValue(), null);
            List r17 = r3;
            Boolean r19 = r4;
            bq8.a r21 = (bq8.a) r0.decodeNullableSerializableElement(r1, 4, bq8.b.a, null);
            Integer r18 = r6;
            int r16 = 31;
        L24:
            r0.endStructure(r1);
            return new d0(r16, r17, r18, r19, r20, r21);
        L5:
            Integer r10 = null;
            Boolean r11 = null;
            List r12 = null;
            bq8.a r13 = null;
            int r5 = 0;
            boolean r14 = true;
        L6:
            if (r14 == false) goto L23;
            int r15 = r0.decodeElementIndex(r1);
            if (r15 != (-1)) goto L9;
            r14 = false;
            goto L6
        L9:
            if (r15 != 0) goto L10;
            r9 = (List) r0.decodeNullableSerializableElement(r1, 0, (juc.c) r2[0].getValue(), r9);
            r5 = r5 | 1;
            goto L6
        L10:
            if (r15 == 1) goto L19;
            if (r15 == 2) goto L18;
            if (r15 == 3) goto L17;
            if (r15 != 4) goto L16;
            r5 = r5 | 16;
            r13 = (bq8.a) r0.decodeNullableSerializableElement(r1, 4, bq8.b.a, r13);
            goto L6
        L16:
            throw new UnknownFieldException(r15);
        L17:
            r5 = r5 | 8;
            r12 = (List) r0.decodeNullableSerializableElement(r1, 3, (juc.c) r2[3].getValue(), r12);
            goto L6
        L18:
            r5 = r5 | 4;
            r11 = (Boolean) r0.decodeNullableSerializableElement(r1, 2, nuc.i.a, r11);
            goto L6
        L19:
            r5 = r5 | 2;
            r10 = (Integer) r0.decodeNullableSerializableElement(r1, 1, nuc.w0.a, r10);
            goto L6
        L23:
            r16 = r5;
            r17 = r9;
            r18 = r10;
            r19 = r11;
            r20 = r12;
            r21 = r13;
            goto L24
        }

        public final void serialize(muc.f r8, Object r9) {
            d0 r10 = (d0) r9;
            Intrinsics.checkNotNullParameter(r8, "encoder");
            Intrinsics.checkNotNullParameter(r10, "value");
            g2 r0 = b;
            muc.d r11 = r8.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = d0.f;
            boolean r2 = false;
            if (r11.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r11.encodeNullableSerializableElement(r0, 0, (juc.n) r1[0].getValue(), r10.a);
        L12:
            if (r11.shouldEncodeElementDefault(r0, 1) == true) goto L19;
            Integer r4 = r10.b;
            if (r4 == null) goto L19;
            if (r4.intValue() != (-1)) goto L19;
            boolean r5 = false;
        L21:
            if (r5 == false) goto L24;
            r11.encodeNullableSerializableElement(r0, 1, nuc.w0.a, r10.b);
        L24:
            if (r11.shouldEncodeElementDefault(r0, 2) == false) goto L27;
        L28:
            boolean r6 = true;
        L30:
            if (r6 == false) goto L33;
            r11.encodeNullableSerializableElement(r0, 2, nuc.i.a, r10.c);
        L33:
            if (r11.shouldEncodeElementDefault(r0, 3) == false) goto L36;
        L37:
            boolean r7 = true;
        L39:
            if (r7 == false) goto L42;
            r11.encodeNullableSerializableElement(r0, 3, (juc.n) r1[3].getValue(), r10.d);
        L42:
            if (r11.shouldEncodeElementDefault(r0, 4) == false) goto L45;
        L46:
            r2 = true;
        L47:
            if (r2 == false) goto L49;
            r11.encodeNullableSerializableElement(r0, 4, bq8.b.a, r10.e);
        L49:
            r11.endStructure(r0);
            return;
        L45:
            if (r10.e == null) goto L47;
        L36:
            if (Intrinsics.areEqual(r10.d, new ArrayList()) == false) goto L37;
            r7 = false;
            goto L39
        L27:
            if (Intrinsics.areEqual(r10.c, Boolean.FALSE) == false) goto L28;
            r6 = false;
        L19:
            r5 = true;
            goto L21
        L6:
            if (Intrinsics.areEqual(r10.a, new ArrayList()) == false) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<d0> serializer() {
            return a.a;
        }
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final List<String> b(List<String> r1) {
        return null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d0) == true) goto L8;
        return false;
    L8:
        d0 r6 = (d0) r5;
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
        List<w> r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        List<w> r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        bq8.a r13 = this.e;
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
        return "ActionBarMusicTemplateInstructionTemplate(imageList=" + this.a + ", defaultSelectionIndex=" + this.b + ", chooseRequired=" + this.c + ", otherOptionList=" + this.d + ", selectorMusicTemplateItem=" + this.e + ')';
    }

    static {
        Companion = new b();
        LazyThreadSafetyMode r1 = LazyThreadSafetyMode.PUBLICATION;
        f = new Lazy[]{LazyKt.lazy(r1, new wa8.i0()), null, null, LazyKt.lazy(r1, new wa8.j0()), null};
    }

    public d0() {
        this(new ArrayList(), -1, Boolean.FALSE, new ArrayList(), null);
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final String a() {
        List<w> r0 = this.a;
        if (r0 == null) goto L9;
        List<w> r1 = r0;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r3 = r1.iterator();
    L6:
        if (r3.hasNext() == false) goto L12;
        r2.add(((w) r3.next()).b);
        goto L6
    L12:
        return CollectionsKt.joinToString$default(r2, ";", null, null, 0, null, null, 62, null);
    L9:
        return null;
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final String c(String r10, List<String> r11) {
        List<w> r12 = this.a;
        if (r12 == null) goto L9;
        List<w> r13 = r12;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator<T> r14 = r13.iterator();
    L6:
        if (r14.hasNext() == false) goto L12;
        r0.add(((w) r14.next()).d);
        goto L6
    L12:
        return CollectionsKt.joinToString$default(r0, wa8.h.a(), null, null, 0, null, null, 62, null);
    L9:
        return null;
    }

    public static d0 d(d0 r6, List r7, bq8.a r8, int r9) {
        if ((r9 & 1) == 0) goto L5;
        r7 = r6.a;
    L5:
        List r1 = r7;
        if ((r9 & 2) == 0) goto L8;
        Integer r2 = r6.b;
    L10:
        if ((r9 & 4) == 0) goto L12;
        Boolean r3 = r6.c;
    L14:
        if ((r9 & 8) == 0) goto L16;
        List<w> r4 = r6.d;
    L18:
        if ((r9 & 16) == 0) goto L21;
        r8 = r6.e;
    L21:
        return new d0(r1, r2, r3, r4, r8);
    L16:
        r4 = null;
        goto L18
    L12:
        r3 = null;
        goto L14
    L8:
        r2 = null;
        goto L10
    }

    public d0(List<w> r1, Integer r2, Boolean r3, List<w> r4, bq8.a r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public d0(int r3, List r4, Integer r5, Boolean r6, List r7, bq8.a r8) {
        if ((r3 & 0) == 0) goto L5;
        nuc.b2.b(r3, 0, a.b);
        throw null;
    L5:
        if ((r3 & 1) != 0) goto L7;
        r4 = new ArrayList();
    L7:
        this.a = r4;
        if ((r3 & 2) != 0) goto L10;
        this.b = -1;
    L12:
        if ((r3 & 4) != 0) goto L14;
        this.c = Boolean.FALSE;
    L16:
        if ((r3 & 8) != 0) goto L18;
        this.d = new ArrayList();
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
