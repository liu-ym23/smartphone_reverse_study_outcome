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
public final class e implements k1 {
    public static final b Companion = null;
    public static final Lazy<juc.d<Object>>[] f = null;
    public final String a;
    public final List<w> b;
    public final List<f> c;
    public final Long d;
    public final f e;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<e> {
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
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.ActionBarDigitalAvatarTemplateInstructionTemplate", r0, 4);
            r1.j("sub_title", true);
            r1.j("other_option_list", true);
            r1.j("option_list", true);
            r1.j("avatar_id", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r0 = e.f;
            return new juc.d[]{kuc.a.d(v2.a), kuc.a.d((juc.d) r0[1].getValue()), kuc.a.d((juc.d) r0[2].getValue()), kuc.a.d(nuc.g1.a)};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r20) {
            Intrinsics.checkNotNullParameter(r20, "decoder");
            g2 r1 = b;
            muc.c r0 = r20.beginStructure(r1);
            Lazy<juc.d<Object>>[] r2 = e.f;
            String r8 = null;
            if (r0.decodeSequentially() == false) goto L5;
            String r3 = (String) r0.decodeNullableSerializableElement(r1, 0, v2.a, null);
            List r5 = (List) r0.decodeNullableSerializableElement(r1, 1, (juc.c) r2[1].getValue(), null);
            List r17 = (List) r0.decodeNullableSerializableElement(r1, 2, (juc.c) r2[2].getValue(), null);
            String r15 = r3;
            Long r18 = (Long) r0.decodeNullableSerializableElement(r1, 3, nuc.g1.a, null);
            List r16 = r5;
            int r14 = 15;
        L21:
            r0.endStructure(r1);
            return new e(r14, r15, r16, r17, r18);
        L5:
            List r9 = null;
            List r10 = null;
            Long r11 = null;
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
            r8 = (String) r0.decodeNullableSerializableElement(r1, 0, v2.a, r8);
            r4 = r4 | 1;
            goto L6
        L10:
            if (r13 != 1) goto L11;
            r9 = (List) r0.decodeNullableSerializableElement(r1, 1, (juc.c) r2[1].getValue(), r9);
            r4 = r4 | 2;
            goto L6
        L11:
            if (r13 != 2) goto L12;
            r10 = (List) r0.decodeNullableSerializableElement(r1, 2, (juc.c) r2[2].getValue(), r10);
            r4 = r4 | 4;
            goto L6
        L12:
            if (r13 != 3) goto L15;
            r11 = (Long) r0.decodeNullableSerializableElement(r1, 3, nuc.g1.a, r11);
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

        public final void serialize(muc.f r10, Object r11) {
            e r12 = (e) r11;
            Intrinsics.checkNotNullParameter(r10, "encoder");
            Intrinsics.checkNotNullParameter(r12, "value");
            g2 r0 = b;
            muc.d r13 = r10.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = e.f;
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
            if (r13.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            boolean r5 = true;
        L27:
            if (r5 == false) goto L30;
            r13.encodeNullableSerializableElement(r0, 2, (juc.n) r1[2].getValue(), r12.c);
        L30:
            if (r13.shouldEncodeElementDefault(r0, 3) == true) goto L37;
            Long r6 = r12.d;
            if (r6 == null) goto L37;
            if (r6.longValue() != (-1)) goto L37;
        L38:
            if (r2 == false) goto L40;
            r13.encodeNullableSerializableElement(r0, 3, nuc.g1.a, r12.d);
        L40:
            r13.endStructure(r0);
            return;
        L37:
            r2 = true;
            goto L38
        L24:
            if (Intrinsics.areEqual(r12.c, new ArrayList()) == false) goto L25;
            r5 = false;
            goto L27
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

        public final juc.d<e> serializer() {
            return a.a;
        }
    }

    public e() {
        this(null, 31);
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final String a() {
        return null;
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final List<String> b(List<String> r1) {
        return null;
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final String c(String r1, List<String> r2) {
        return null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
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
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<w> r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        List<f> r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Long r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        f r13 = this.e;
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
        return "ActionBarDigitalAvatarTemplateInstructionTemplate(title=" + this.a + ", otherOptionList=" + this.b + ", imageList=" + this.c + ", avatarId=" + this.d + ", selectorImageTemplateItem=" + this.e + ')';
    }

    static {
        Companion = new b();
        LazyThreadSafetyMode r1 = LazyThreadSafetyMode.PUBLICATION;
        f = new Lazy[]{null, LazyKt.lazy(r1, new wa8.i()), LazyKt.lazy(r1, new wa8.j()), null};
    }

    public /* synthetic */ e(List r9, int r10) {
        Long r1 = null;
        if ((r10 & 1) == 0) goto L5;
        String r3 = "";
    L7:
        if ((r10 & 2) == 0) goto L9;
        ArrayList r4 = new ArrayList();
    L11:
        if ((r10 & 4) == 0) goto L13;
        r9 = new ArrayList();
    L13:
        List r5 = r9;
        if ((r10 & 8) == 0) goto L16;
        r1 = -1L;
    L16:
        this(r3, r4, r5, r1, null);
        return;
    L9:
        r4 = null;
        goto L11
    L5:
        r3 = null;
        goto L7
    }

    public e(int r3, String r4, List r5, List r6, Long r7) {
        if ((r3 & 0) == 0) goto L5;
        nuc.b2.b(r3, 0, a.b);
        throw null;
    L5:
        if ((r3 & 1) != 0) goto L7;
        r4 = "";
    L7:
        this.a = r4;
        if ((r3 & 2) != 0) goto L10;
        this.b = new ArrayList();
    L12:
        if ((r3 & 4) != 0) goto L14;
        this.c = new ArrayList();
    L16:
        if ((r3 & 8) != 0) goto L18;
        this.d = -1L;
    L19:
        this.e = null;
        return;
    L18:
        this.d = r7;
        goto L19
    L14:
        this.c = r6;
        goto L16
    L10:
        this.b = r5;
        goto L12
    }

    public e(String r1, List<w> r2, List<f> r3, Long r4, f r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
