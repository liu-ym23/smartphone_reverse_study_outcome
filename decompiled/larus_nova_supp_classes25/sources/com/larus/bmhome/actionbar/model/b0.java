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
public final class b0 implements k1 {
    public static final b Companion = null;
    public static final Lazy<juc.d<Object>>[] c = null;
    public List<c0> a;
    public final Integer b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<b0> {
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
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.ActionBarMultiSelectorInstructionTemplate", r0, 2);
            r1.j("selector_list", true);
            r1.j("row_nums", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{kuc.a.d((juc.d) b0.c[0].getValue()), kuc.a.d(nuc.w0.a)};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r11) {
            Intrinsics.checkNotNullParameter(r11, "decoder");
            g2 r0 = b;
            muc.c r12 = r11.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = b0.c;
            List r5 = null;
            if (r12.decodeSequentially() == false) goto L5;
            List r2 = (List) r12.decodeNullableSerializableElement(r0, 0, (juc.c) r1[0].getValue(), null);
            Integer r3 = (Integer) r12.decodeNullableSerializableElement(r0, 1, nuc.w0.a, null);
            int r4 = 3;
        L17:
            r12.endStructure(r0);
            return new b0(r4, r2, r3);
        L5:
            Integer r6 = null;
            int r7 = 0;
            boolean r8 = true;
        L6:
            if (r8 == false) goto L16;
            int r9 = r12.decodeElementIndex(r0);
            if (r9 != (-1)) goto L9;
            r8 = false;
            goto L6
        L9:
            if (r9 != 0) goto L10;
            r5 = (List) r12.decodeNullableSerializableElement(r0, 0, (juc.c) r1[0].getValue(), r5);
            r7 = r7 | 1;
            goto L6
        L10:
            if (r9 != 1) goto L13;
            r6 = (Integer) r12.decodeNullableSerializableElement(r0, 1, nuc.w0.a, r6);
            r7 = r7 | 2;
            goto L6
        L13:
            throw new UnknownFieldException(r9);
        L16:
            r4 = r7;
            r2 = r5;
            r3 = r6;
            goto L17
        }

        public final void serialize(muc.f r7, Object r8) {
            b0 r9 = (b0) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = b0.c;
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
            r2 = true;
        L17:
            if (r2 == false) goto L19;
            r10.encodeNullableSerializableElement(r0, 1, nuc.w0.a, r9.b);
        L19:
            r10.endStructure(r0);
            return;
        L15:
            if (r9.b == null) goto L17;
        L6:
            if (Intrinsics.areEqual(r9.a, new ArrayList()) == false) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<b0> serializer() {
            return a.a;
        }
    }

    public b0() {
        this(0);
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final List<String> b(List<String> r1) {
        return null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b0) == true) goto L8;
        return false;
    L8:
        b0 r6 = (b0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        List<c0> r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ActionBarMultiSelectorInstructionTemplate(selectorList=" + this.a + ", rowNums=" + this.b + ')';
    }

    static {
        Companion = new b();
        c = new Lazy[]{LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new wa8.h0()), null};
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final String a() {
        List<c0> r0 = this.a;
        if (r0 == null) goto L22;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L17;
        Object r3 = r2.next();
        String r4 = ((c0) r3).a();
        if (r4 != null) goto L10;
    L13:
        boolean r5 = true;
    L15:
        if ((!r5) == false) goto L6;
        r1.add(r3);
        goto L6
    L10:
        if (r4.length() == 0) goto L13;
        r5 = false;
        goto L15
    L17:
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r7 = r1.iterator();
    L19:
        if (r7.hasNext() == false) goto L30;
        r6.add(((c0) r7.next()).a());
        goto L19
    L30:
        return CollectionsKt.joinToString$default(r6, wa8.h.a(), null, null, 0, null, null, 62, null);
    L22:
        return null;
    }

    public final List<c0> d() {
        return this.a;
    }

    public /* synthetic */ b0(int r2) {
        this(new ArrayList(), null);
    }

    public b0(List<c0> r1, Integer r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final String c(String r13, List<String> r14) {
        List<c0> r15 = this.a;
        if (r15 == null) goto L29;
        ArrayList r0 = new ArrayList();
        Iterator<T> r16 = r15.iterator();
    L6:
        if (r16.hasNext() == false) goto L17;
        Object r1 = r16.next();
        String r2 = k1.a.a((c0) r1, null, 3);
        if (r2 != null) goto L10;
    L13:
        boolean r3 = true;
    L15:
        if ((!r3) == false) goto L6;
        r0.add(r1);
        goto L6
    L10:
        if (r2.length() == 0) goto L13;
        r3 = false;
        goto L15
    L17:
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r17 = r0.iterator();
    L19:
        if (r17.hasNext() == false) goto L22;
        r4.add(k1.a.a((c0) r17.next(), null, 3));
        goto L19
    L22:
        return CollectionsKt.joinToString$default(r4, wa8.h.a(), null, null, 0, null, null, 62, null);
    L29:
        return null;
    }

    public b0(int r3, List r4, Integer r5) {
        if ((r3 & 0) == 0) goto L5;
        nuc.b2.b(r3, 0, a.b);
        throw null;
    L5:
        if ((r3 & 1) != 0) goto L7;
        r4 = new ArrayList();
    L7:
        this.a = r4;
        if ((r3 & 2) != 0) goto L10;
        this.b = null;
        return;
    L10:
        this.b = r5;
    }
}
