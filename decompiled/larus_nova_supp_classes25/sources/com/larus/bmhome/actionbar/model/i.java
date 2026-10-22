package com.larus.bmhome.actionbar.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.g2;
import nuc.i2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Serializable
public final class i implements k1 {
    public static final b Companion = null;
    public static final Lazy<juc.d<Object>>[] b = null;
    public List<h> a;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<i> {
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
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.ActionBarDropdownBoxSelectorTemplate", r0, 1);
            r1.j("dropdown_box_list", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{kuc.a.d((juc.d) i.b[0].getValue())};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r9) {
            Intrinsics.checkNotNullParameter(r9, "decoder");
            g2 r0 = b;
            muc.c r10 = r9.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = i.b;
            int r3 = 1;
            List r5 = null;
            if (r10.decodeSequentially() == false) goto L5;
            List r2 = (List) r10.decodeNullableSerializableElement(r0, 0, (juc.c) r1[0].getValue(), null);
        L15:
            r10.endStructure(r0);
            return new i(r3, r2);
        L5:
            int r4 = 0;
        L6:
            if (r3 == 0) goto L14;
            int r6 = r10.decodeElementIndex(r0);
            if (r6 != (-1)) goto L9;
            r3 = 0;
            goto L6
        L9:
            if (r6 != 0) goto L12;
            r5 = (List) r10.decodeNullableSerializableElement(r0, 0, (juc.c) r1[0].getValue(), r5);
            r4 = r4 | 1;
            goto L6
        L12:
            throw new UnknownFieldException(r6);
        L14:
            r3 = r4;
            r2 = r5;
            goto L15
        }

        public final void serialize(muc.f r6, Object r7) {
            i r8 = (i) r7;
            Intrinsics.checkNotNullParameter(r6, "encoder");
            Intrinsics.checkNotNullParameter(r8, "value");
            g2 r0 = b;
            muc.d r9 = r6.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = i.b;
            if (r9.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L11;
            r9.encodeNullableSerializableElement(r0, 0, (juc.n) r1[0].getValue(), r8.a);
        L11:
            r9.endStructure(r0);
            return;
        L6:
            if (Intrinsics.areEqual(r8.a, new ArrayList()) == false) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<i> serializer() {
            return a.a;
        }
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof i) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((i) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        List<h> r0 = this.a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public final String toString() {
        return "ActionBarDropdownBoxSelectorTemplate(dropdownBoxList=" + this.a + ')';
    }

    static {
        Companion = new b();
        b = new Lazy[]{LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new wa8.l())};
    }

    public i() {
        this(new ArrayList());
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final String a() {
        ArrayList r0 = new ArrayList();
        List<h> r1 = this.a;
        if (r1 == null) goto L24;
        List<h> r2 = r1;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r4 = r2.iterator();
    L6:
        if (r4.hasNext() == false) goto L24;
        h r5 = (h) r4.next();
        ArrayList r6 = new ArrayList();
        String r7 = r5.c;
        if (r7 == null) goto L10;
        r6.add(r7);
    L10:
        List<w> r8 = r5.e;
        if (r8 == null) goto L20;
        List<w> r9 = r8;
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator<T> r11 = r9.iterator();
    L14:
        if (r11.hasNext() == false) goto L16;
        r10.add(((w) r11.next()).b);
        goto L14
    L16:
        String r12 = CollectionsKt.joinToString$default(r10, ",", null, null, 0, null, null, 62, null);
        if (r12 == null) goto L20;
        r6.add(r12);
    L20:
        if ((!r6.isEmpty()) == false) goto L22;
        r0.add(CollectionsKt.joinToString$default(r6, ";", null, null, 0, null, null, 62, null));
    L22:
        r3.add(Unit.INSTANCE);
    L24:
        return CollectionsKt.joinToString$default(r0, ";", null, null, 0, null, null, 62, null);
    }

    public i(List<h> r1) {
        this.a = r1;
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final List<String> b(List<String> r5) {
        ArrayList r0 = new ArrayList();
        List<h> r1 = this.a;
        if (r1 == null) goto L20;
        Iterator<T> r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L20;
        h r3 = (h) r2.next();
        List<String> r4 = r5;
        if (r4 != null) goto L10;
    L13:
        boolean r6 = true;
    L14:
        if (r6 == true) goto L6;
        if (r5.contains(String.valueOf(r3.a)) == false) goto L6;
        List<w> r7 = r3.e;
        if (r7 == null) goto L6;
        r0.addAll(r7);
        goto L6
    L10:
        if (r4.isEmpty() == true) goto L13;
        r6 = false;
    L20:
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r9 = r0.iterator();
    L22:
        if (r9.hasNext() == false) goto L27;
        String r10 = ((w) r9.next()).d;
        if (r10 != null) goto L26;
        r10 = "";
    L26:
        r8.add(r10);
        goto L22
    L27:
        return r8;
    }

    public i(int r2, List r3) {
        if ((r2 & 0) == 0) goto L5;
        nuc.b2.b(r2, 0, a.b);
        throw null;
    L5:
        if ((r2 & 1) != 0) goto L7;
        this.a = new ArrayList();
        return;
    L7:
        this.a = r3;
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final String c(String r13, List<String> r14) {
        ArrayList r0 = new ArrayList();
        List<h> r1 = this.a;
        if (r1 == null) goto L20;
        Iterator<T> r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L20;
        h r3 = (h) r2.next();
        List<String> r4 = r14;
        if (r4 != null) goto L10;
    L13:
        boolean r5 = true;
    L14:
        if (r5 == true) goto L17;
        if (CollectionsKt.contains(r14, r3.a) == true) goto L6;
    L17:
        List<w> r6 = r3.e;
        if (r6 == null) goto L6;
        r0.addAll(r6);
        goto L6
    L10:
        if (r4.isEmpty() == true) goto L13;
        r5 = false;
    L20:
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r15 = r0.iterator();
    L22:
        if (r15.hasNext() == false) goto L24;
        r7.add(((w) r15.next()).d);
        goto L22
    L24:
        if (r13 != null) goto L27;
        r13 = wa8.h.a();
    L27:
        return CollectionsKt.joinToString$default(r7, r13, null, null, 0, null, null, 62, null);
    }
}
