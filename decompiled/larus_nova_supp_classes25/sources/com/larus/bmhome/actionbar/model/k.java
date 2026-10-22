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
public final class k implements k1 {
    public static final b Companion = null;
    public static final Lazy<juc.d<Object>>[] d = null;
    public final q a;
    public final List<t> b;
    public final List<h> c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<k> {
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
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.ActionBarFeatureSelectorTemplate", r0, 3);
            r1.j("feature_selection_button", true);
            r1.j("feature_option_panel_list", true);
            r1.j("drop_down_box_list", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r0 = k.d;
            return new juc.d[]{kuc.a.d(q.a.a), kuc.a.d((juc.d) r0[1].getValue()), kuc.a.d((juc.d) r0[2].getValue())};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r13) {
            Intrinsics.checkNotNullParameter(r13, "decoder");
            g2 r0 = b;
            muc.c r14 = r13.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = k.d;
            q r6 = null;
            if (r14.decodeSequentially() == false) goto L5;
            q r2 = (q) r14.decodeNullableSerializableElement(r0, 0, q.a.a, null);
            List r4 = (List) r14.decodeNullableSerializableElement(r0, 1, (juc.c) r1[1].getValue(), null);
            List r3 = (List) r14.decodeNullableSerializableElement(r0, 2, (juc.c) r1[2].getValue(), null);
            int r5 = 7;
        L19:
            r14.endStructure(r0);
            return new k(r5, r2, r4, r3);
        L5:
            List r7 = null;
            List r8 = null;
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
            r6 = (q) r14.decodeNullableSerializableElement(r0, 0, q.a.a, r6);
            r9 = r9 | 1;
            goto L6
        L10:
            if (r11 != 1) goto L11;
            r7 = (List) r14.decodeNullableSerializableElement(r0, 1, (juc.c) r1[1].getValue(), r7);
            r9 = r9 | 2;
            goto L6
        L11:
            if (r11 != 2) goto L14;
            r8 = (List) r14.decodeNullableSerializableElement(r0, 2, (juc.c) r1[2].getValue(), r8);
            r9 = r9 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r11);
        L18:
            r5 = r9;
            r2 = r6;
            r4 = r7;
            r3 = r8;
            goto L19
        }

        public final void serialize(muc.f r8, Object r9) {
            k r10 = (k) r9;
            Intrinsics.checkNotNullParameter(r8, "encoder");
            Intrinsics.checkNotNullParameter(r10, "value");
            g2 r0 = b;
            muc.d r11 = r8.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = k.d;
            boolean r2 = false;
            if (r11.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r11.encodeNullableSerializableElement(r0, 0, q.a.a, r10.a);
        L12:
            if (r11.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r11.encodeNullableSerializableElement(r0, 1, (juc.n) r1[1].getValue(), r10.b);
        L21:
            if (r11.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            r2 = true;
        L26:
            if (r2 == false) goto L28;
            r11.encodeNullableSerializableElement(r0, 2, (juc.n) r1[2].getValue(), r10.c);
        L28:
            r11.endStructure(r0);
            return;
        L24:
            if (Intrinsics.areEqual(r10.c, new ArrayList()) == true) goto L26;
        L15:
            if (Intrinsics.areEqual(r10.b, new ArrayList()) == false) goto L16;
            r4 = false;
            goto L18
        L6:
            if (Intrinsics.areEqual(r10.a, new q(0)) == false) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<k> serializer() {
            return a.a;
        }
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final String a() {
        return null;
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final List<String> b(List<String> r1) {
        return null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof k) == true) goto L8;
        return false;
    L8:
        k r6 = (k) r5;
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
        q r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<t> r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        List<h> r7 = this.c;
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
        return "ActionBarFeatureSelectorTemplate(featureSelectionButton=" + this.a + ", featureOptionPanelList=" + this.b + ", dropdownBoxList=" + this.c + ')';
    }

    static {
        Companion = new b();
        LazyThreadSafetyMode r1 = LazyThreadSafetyMode.PUBLICATION;
        d = new Lazy[]{null, LazyKt.lazy(r1, new wa8.n()), LazyKt.lazy(r1, new wa8.o())};
    }

    public k() {
        this(new q(0), new ArrayList(), new ArrayList());
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final String c(String r12, List<String> r13) {
        ArrayList r14 = new ArrayList();
        List<h> r0 = this.c;
        if (r0 == null) goto L10;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        List<w> r2 = ((h) r1.next()).e;
        if (r2 == null) goto L6;
        r14.addAll(r2);
    L10:
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator r15 = r14.iterator();
    L12:
        if (r15.hasNext() == false) goto L14;
        r3.add(((w) r15.next()).d);
        goto L12
    L14:
        if (r12 != null) goto L17;
        r12 = wa8.h.a();
    L17:
        return CollectionsKt.joinToString$default(r3, r12, null, null, 0, null, null, 62, null);
    }

    public k(q r1, List<t> r2, List<h> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public k(int r3, q r4, List r5, List r6) {
        if ((r3 & 0) == 0) goto L5;
        nuc.b2.b(r3, 0, a.b);
        throw null;
    L5:
        if ((r3 & 1) != 0) goto L7;
        r4 = new q(0);
    L7:
        this.a = r4;
        if ((r3 & 2) != 0) goto L10;
        this.b = new ArrayList();
    L12:
        if ((r3 & 4) != 0) goto L14;
        this.c = new ArrayList();
        return;
    L14:
        this.c = r6;
        return;
    L10:
        this.b = r5;
        goto L12
    }

    public static k d(k r2, List r3, List r4, int r5) {
        if ((r5 & 1) == 0) goto L5;
        q r0 = r2.a;
    L7:
        if ((r5 & 2) == 0) goto L10;
        r3 = r2.b;
    L10:
        if ((r5 & 4) == 0) goto L13;
        r4 = r2.c;
    L13:
        return new k(r0, r3, r4);
    L5:
        r0 = null;
        goto L7
    }
}
