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
public final class l implements k1 {
    public static final b Companion = null;
    public static final Lazy<juc.d<Object>>[] d = null;
    public List<w> a;
    public final Integer b;
    public final Boolean c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<l> {
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
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.ActionBarImageSelectorTemplate", r0, 3);
            r1.j("option_list", true);
            r1.j("default_selection_index", true);
            r1.j("choose_required", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{kuc.a.d((juc.d) l.d[0].getValue()), kuc.a.d(nuc.w0.a), kuc.a.d(nuc.i.a)};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r13) {
            Intrinsics.checkNotNullParameter(r13, "decoder");
            g2 r0 = b;
            muc.c r14 = r13.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = l.d;
            List r6 = null;
            if (r14.decodeSequentially() == false) goto L5;
            List r2 = (List) r14.decodeNullableSerializableElement(r0, 0, (juc.c) r1[0].getValue(), null);
            Integer r3 = (Integer) r14.decodeNullableSerializableElement(r0, 1, nuc.w0.a, null);
            Boolean r4 = (Boolean) r14.decodeNullableSerializableElement(r0, 2, nuc.i.a, null);
            int r5 = 7;
        L19:
            r14.endStructure(r0);
            return new l(r5, r2, r3, r4);
        L5:
            Integer r7 = null;
            Boolean r8 = null;
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
            r6 = (List) r14.decodeNullableSerializableElement(r0, 0, (juc.c) r1[0].getValue(), r6);
            r9 = r9 | 1;
            goto L6
        L10:
            if (r11 != 1) goto L11;
            r7 = (Integer) r14.decodeNullableSerializableElement(r0, 1, nuc.w0.a, r7);
            r9 = r9 | 2;
            goto L6
        L11:
            if (r11 != 2) goto L14;
            r8 = (Boolean) r14.decodeNullableSerializableElement(r0, 2, nuc.i.a, r8);
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

        public final void serialize(muc.f r7, Object r8) {
            l r9 = (l) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = l.d;
            boolean r2 = false;
            if (r10.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r10.encodeNullableSerializableElement(r0, 0, (juc.n) r1[0].getValue(), r9.a);
        L12:
            if (r10.shouldEncodeElementDefault(r0, 1) == true) goto L19;
            Integer r4 = r9.b;
            if (r4 == null) goto L19;
            if (r4.intValue() != (-1)) goto L19;
            boolean r5 = false;
        L21:
            if (r5 == false) goto L24;
            r10.encodeNullableSerializableElement(r0, 1, nuc.w0.a, r9.b);
        L24:
            if (r10.shouldEncodeElementDefault(r0, 2) == false) goto L27;
        L28:
            r2 = true;
        L29:
            if (r2 == false) goto L31;
            r10.encodeNullableSerializableElement(r0, 2, nuc.i.a, r9.c);
        L31:
            r10.endStructure(r0);
            return;
        L27:
            if (Intrinsics.areEqual(r9.c, Boolean.FALSE) == true) goto L29;
        L19:
            r5 = true;
            goto L21
        L6:
            if (Intrinsics.areEqual(r9.a, new ArrayList()) == false) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<l> serializer() {
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
        if ((r5 instanceof l) == true) goto L8;
        return false;
    L8:
        l r6 = (l) r5;
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
        return "ActionBarImageSelectorTemplate(imageList=" + this.a + ", defaultSelectionIndex=" + this.b + ", chooseRequired=" + this.c + ')';
    }

    static {
        Companion = new b();
        d = new Lazy[]{LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new wa8.q()), null, null};
    }

    public l() {
        this(new ArrayList(), -1, Boolean.FALSE);
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
        if (r12 == null) goto L11;
        List<w> r13 = r12;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator<T> r14 = r13.iterator();
    L6:
        if (r14.hasNext() == false) goto L8;
        r0.add(((w) r14.next()).d);
        goto L6
    L8:
        if (r10 != null) goto L14;
        r10 = wa8.h.a();
    L14:
        return CollectionsKt.joinToString$default(r0, r10, null, null, 0, null, null, 62, null);
    L11:
        return null;
    }

    public l(List<w> r1, Integer r2, Boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public l(int r2, List r3, Integer r4, Boolean r5) {
        if ((r2 & 0) == 0) goto L5;
        nuc.b2.b(r2, 0, a.b);
        throw null;
    L5:
        if ((r2 & 1) != 0) goto L7;
        r3 = new ArrayList();
    L7:
        this.a = r3;
        if ((r2 & 2) != 0) goto L10;
        this.b = -1;
    L12:
        if ((r2 & 4) != 0) goto L14;
        this.c = Boolean.FALSE;
        return;
    L14:
        this.c = r5;
        return;
    L10:
        this.b = r4;
        goto L12
    }
}
