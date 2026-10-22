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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Serializable
public final class v {
    public static final b Companion = null;
    public static final Lazy<juc.d<Object>>[] e = null;
    public final Integer a;
    public final l1 b;
    public List<MediaAttachment> c;
    public final Integer d;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<v> {
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
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.ActionBarInstructionMultiMediaTemplateItem", r0, 4);
            r1.j("max_num", true);
            r1.j("media_info", true);
            r1.j("media_attachment_list", true);
            r1.j("media_type", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r0 = v.e;
            nuc.w0 r2 = nuc.w0.a;
            return new juc.d[]{kuc.a.d(r2), kuc.a.d(l1.a.a), kuc.a.d((juc.d) r0[2].getValue()), kuc.a.d(r2)};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r20) {
            Intrinsics.checkNotNullParameter(r20, "decoder");
            g2 r1 = b;
            muc.c r0 = r20.beginStructure(r1);
            Lazy<juc.d<Object>>[] r2 = v.e;
            Integer r8 = null;
            if (r0.decodeSequentially() == false) goto L5;
            nuc.w0 r3 = nuc.w0.a;
            Integer r5 = (Integer) r0.decodeNullableSerializableElement(r1, 0, r3, null);
            l1 r6 = (l1) r0.decodeNullableSerializableElement(r1, 1, l1.a.a, null);
            List r17 = (List) r0.decodeNullableSerializableElement(r1, 2, (juc.c) r2[2].getValue(), null);
            Integer r18 = (Integer) r0.decodeNullableSerializableElement(r1, 3, r3, null);
            Integer r15 = r5;
            l1 r16 = r6;
            int r14 = 15;
        L21:
            r0.endStructure(r1);
            return new v(r14, r15, r16, r17, r18);
        L5:
            l1 r9 = null;
            List r10 = null;
            Integer r11 = null;
            int r4 = 0;
            boolean r12 = true;
        L6:
            if (r12 == false) goto L20;
            int r13 = r0.decodeElementIndex(r1);
            if (r13 != (-1)) goto L9;
            r12 = false;
            goto L6
        L9:
            if (r13 != 0) goto L10;
            r8 = (Integer) r0.decodeNullableSerializableElement(r1, 0, nuc.w0.a, r8);
            r4 = r4 | 1;
            goto L6
        L10:
            if (r13 != 1) goto L11;
            r9 = (l1) r0.decodeNullableSerializableElement(r1, 1, l1.a.a, r9);
            r4 = r4 | 2;
            goto L6
        L11:
            if (r13 != 2) goto L12;
            r10 = (List) r0.decodeNullableSerializableElement(r1, 2, (juc.c) r2[2].getValue(), r10);
            r4 = r4 | 4;
            goto L6
        L12:
            if (r13 != 3) goto L15;
            r11 = (Integer) r0.decodeNullableSerializableElement(r1, 3, nuc.w0.a, r11);
            r4 = r4 | 8;
            goto L6
        L15:
            throw new UnknownFieldException(r13);
        L20:
            r14 = r4;
            r15 = r8;
            r16 = r9;
            r17 = r10;
            r18 = r11;
            goto L21
        }

        public final void serialize(muc.f r8, Object r9) {
            v r10 = (v) r9;
            Intrinsics.checkNotNullParameter(r8, "encoder");
            Intrinsics.checkNotNullParameter(r10, "value");
            g2 r0 = b;
            muc.d r11 = r8.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = v.e;
            boolean r2 = false;
            if (r11.shouldEncodeElementDefault(r0, 0) == true) goto L10;
            Integer r3 = r10.a;
            if (r3 == null) goto L10;
            if (r3.intValue() != 0) goto L10;
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
            r11.encodeNullableSerializableElement(r0, 1, l1.a.a, r10.b);
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
            if (r7.intValue() != 1) goto L40;
        L41:
            if (r2 == false) goto L43;
            r11.encodeNullableSerializableElement(r0, 3, nuc.w0.a, r10.d);
        L43:
            r11.endStructure(r0);
            return;
        L40:
            r2 = true;
            goto L41
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

        public final juc.d<v> serializer() {
            return a.a;
        }
    }

    public v() {
        this(null, null, 15);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof v) == true) goto L8;
        return false;
    L8:
        v r6 = (v) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        Integer r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        l1 r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        List<MediaAttachment> r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.d;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
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
        return "ActionBarInstructionMultiMediaTemplateItem(maxNum=" + this.a + ", placeholder=" + this.b + ", attachmentList=" + this.c + ", mediaType=" + this.d + ')';
    }

    static {
        Companion = new b();
        e = new Lazy[]{null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new wa8.x()), null};
    }

    public v(Integer r3, l1 r4, int r5) {
        if ((r5 & 1) == 0) goto L5;
        r3 = 0;
    L5:
        Integer r1 = null;
        if ((r5 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        ArrayList r0 = new ArrayList();
    L13:
        if ((r5 & 8) == 0) goto L15;
        r1 = 1;
    L15:
        this.a = r3;
        this.b = r4;
        this.c = r0;
        this.d = r1;
        return;
    L11:
        r0 = null;
        goto L13
    }

    public v(int r4, Integer r5, l1 r6, List r7, Integer r8) {
        if ((r4 & 0) == 0) goto L5;
        nuc.b2.b(r4, 0, a.b);
        throw null;
    L5:
        if ((r4 & 1) != 0) goto L7;
        r5 = 0;
    L7:
        this.a = r5;
        if ((r4 & 2) != 0) goto L10;
        this.b = null;
    L12:
        if ((r4 & 4) != 0) goto L14;
        this.c = new ArrayList();
    L16:
        if ((r4 & 8) != 0) goto L18;
        this.d = 1;
        return;
    L18:
        this.d = r8;
        return;
    L14:
        this.c = r7;
        goto L16
    L10:
        this.b = r6;
        goto L12
    }
}
