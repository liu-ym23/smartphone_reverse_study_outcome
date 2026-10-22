package com.larus.bmhome.actionbar.model;

import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.g2;
import nuc.i2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Serializable
public final class l0 implements k1 {
    public static final b Companion = null;
    public final h a;
    public final h b;
    public final h c;
    public final Integer d;
    public final Boolean e;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<l0> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final juc.d<?>[] childSerializers() {
            h.a r1 = h.a.a;
            return new juc.d[]{kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(nuc.w0.a), kuc.a.d(nuc.i.a)};
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.ActionBarTranslatorBoxTemplate", r0, 5);
            r1.j("source_selector", true);
            r1.j("target_selector", true);
            r1.j("voice_selector", true);
            r1.j("default_selection_index", true);
            r1.j("can_be_empty", true);
            b = r1;
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r22) {
            Intrinsics.checkNotNullParameter(r22, "decoder");
            g2 r1 = b;
            muc.c r0 = r22.beginStructure(r1);
            h r8 = null;
            if (r0.decodeSequentially() == false) goto L5;
            h.a r2 = h.a.a;
            h r5 = (h) r0.decodeNullableSerializableElement(r1, 0, r2, null);
            h r6 = (h) r0.decodeNullableSerializableElement(r1, 1, r2, null);
            h r3 = (h) r0.decodeNullableSerializableElement(r1, 2, r2, null);
            h r18 = r3;
            Integer r19 = (Integer) r0.decodeNullableSerializableElement(r1, 3, nuc.w0.a, null);
            Boolean r20 = (Boolean) r0.decodeNullableSerializableElement(r1, 4, nuc.i.a, null);
            h r16 = r5;
            h r17 = r6;
            int r15 = 31;
        L23:
            r0.endStructure(r1);
            return new l0(r15, r16, r17, r18, r19, r20);
        L5:
            h r9 = null;
            h r10 = null;
            Integer r11 = null;
            Boolean r12 = null;
            int r4 = 0;
            boolean r13 = true;
        L6:
            if (r13 == false) goto L22;
            int r14 = r0.decodeElementIndex(r1);
            if (r14 != (-1)) goto L9;
            r13 = false;
            goto L6
        L9:
            if (r14 != 0) goto L10;
            r8 = (h) r0.decodeNullableSerializableElement(r1, 0, h.a.a, r8);
            r4 = r4 | 1;
            goto L6
        L10:
            if (r14 != 1) goto L11;
            r9 = (h) r0.decodeNullableSerializableElement(r1, 1, h.a.a, r9);
            r4 = r4 | 2;
            goto L6
        L11:
            if (r14 != 2) goto L12;
            r10 = (h) r0.decodeNullableSerializableElement(r1, 2, h.a.a, r10);
            r4 = r4 | 4;
            goto L6
        L12:
            if (r14 != 3) goto L13;
            r11 = (Integer) r0.decodeNullableSerializableElement(r1, 3, nuc.w0.a, r11);
            r4 = r4 | 8;
            goto L6
        L13:
            if (r14 != 4) goto L16;
            r12 = (Boolean) r0.decodeNullableSerializableElement(r1, 4, nuc.i.a, r12);
            r4 = r4 | 16;
            goto L6
        L16:
            throw new UnknownFieldException(r14);
        L22:
            r15 = r4;
            r16 = r8;
            r17 = r9;
            r18 = r10;
            r19 = r11;
            r20 = r12;
            goto L23
        }

        public final void serialize(muc.f r7, Object r8) {
            l0 r9 = (l0) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            b r1 = l0.Companion;
            boolean r2 = false;
            if (r10.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r10.encodeNullableSerializableElement(r0, 0, h.a.a, r9.a);
        L12:
            if (r10.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r10.encodeNullableSerializableElement(r0, 1, h.a.a, r9.b);
        L21:
            if (r10.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            boolean r5 = true;
        L27:
            if (r5 == false) goto L30;
            r10.encodeNullableSerializableElement(r0, 2, h.a.a, r9.c);
        L30:
            if (r10.shouldEncodeElementDefault(r0, 3) == true) goto L37;
            Integer r6 = r9.d;
            if (r6 == null) goto L37;
            if (r6.intValue() != (-1)) goto L37;
            boolean r11 = false;
        L39:
            if (r11 == false) goto L42;
            r10.encodeNullableSerializableElement(r0, 3, nuc.w0.a, r9.d);
        L42:
            if (r10.shouldEncodeElementDefault(r0, 4) == false) goto L45;
        L46:
            r2 = true;
        L47:
            if (r2 == false) goto L49;
            r10.encodeNullableSerializableElement(r0, 4, nuc.i.a, r9.e);
        L49:
            r10.endStructure(r0);
            return;
        L45:
            if (Intrinsics.areEqual(r9.e, Boolean.FALSE) == true) goto L47;
        L37:
            r11 = true;
            goto L39
        L24:
            if (r9.c != null) goto L25;
            r5 = false;
            goto L27
        L15:
            if (r9.b != null) goto L16;
            r4 = false;
            goto L18
        L6:
            if (r9.a != null) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<l0> serializer() {
            return a.a;
        }
    }

    public l0() {
        this(null, null, null, -1, Boolean.FALSE);
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final List<String> b(List<String> r1) {
        return null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof l0) == true) goto L8;
        return false;
    L8:
        l0 r6 = (l0) r5;
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
        h r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        h r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        h r7 = this.c;
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
        return "ActionBarTranslatorBoxTemplate(sourceSelector=" + this.a + ", targetSelector=" + this.b + ", voiceSelector=" + this.c + ", defaultSelectionIndex=" + this.d + ", canBeEmpty=" + this.e + ')';
    }

    static {
        Companion = new b();
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final String a() {
        ArrayList r0 = new ArrayList();
        h r1 = this.a;
        boolean r2 = true;
        if (r1 == null) goto L16;
        List<w> r3 = r1.e;
        if (r3 == null) goto L16;
        w r4 = (w) CollectionsKt.firstOrNull(r3);
        if (r4 == null) goto L16;
        String r5 = r4.b;
        if (r5 == null) goto L16;
        if (r5.length() <= 0) goto L13;
        boolean r6 = true;
    L14:
        if (r6 == false) goto L16;
        r0.add(r5);
        goto L16
    L13:
        r6 = false;
    L16:
        h r7 = this.b;
        if (r7 == null) goto L30;
        List<w> r8 = r7.e;
        if (r8 == null) goto L30;
        w r9 = (w) CollectionsKt.firstOrNull(r8);
        if (r9 == null) goto L30;
        String r10 = r9.b;
        if (r10 == null) goto L30;
        if (r10.length() <= 0) goto L27;
        boolean r11 = true;
    L28:
        if (r11 == false) goto L30;
        r0.add(r10);
        goto L30
    L27:
        r11 = false;
    L30:
        h r12 = this.c;
        if (r12 == null) goto L45;
        List<w> r13 = r12.e;
        if (r13 == null) goto L45;
        w r14 = (w) CollectionsKt.firstOrNull(r13);
        if (r14 == null) goto L45;
        String r15 = r14.b;
        if (r15 == null) goto L45;
        if (r15.length() > 0) goto L42;
        r2 = false;
    L42:
        if (r2 == false) goto L45;
        r0.add(r15);
    L45:
        return CollectionsKt.joinToString$default(r0, ";", null, null, 0, null, null, 62, null);
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final String c(String r2, List<String> r3) {
        h r4 = this.a;
        String r5 = null;
        if (r4 == null) goto L9;
        List<w> r6 = r4.e;
        if (r6 == null) goto L9;
        w r7 = (w) CollectionsKt.firstOrNull(r6);
        if (r7 == null) goto L9;
        String r8 = r7.d;
    L10:
        h r0 = this.b;
        if (r0 == null) goto L18;
        List<w> r1 = r0.e;
        if (r1 == null) goto L18;
        w r9 = (w) CollectionsKt.firstOrNull(r1);
        if (r9 == null) goto L18;
        r5 = r9.d;
    L18:
        return r8 + r5;
    L9:
        r8 = null;
        goto L10
    }

    public l0(h r1, h r2, h r3, Integer r4, Boolean r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public static l0 d(l0 r6, h r7, h r8, h r9, int r10) {
        if ((r10 & 1) == 0) goto L5;
        r7 = r6.a;
    L5:
        h r1 = r7;
        if ((r10 & 2) == 0) goto L8;
        r8 = r6.b;
    L8:
        h r2 = r8;
        if ((r10 & 4) == 0) goto L11;
        r9 = r6.c;
    L11:
        h r3 = r9;
        if ((r10 & 8) == 0) goto L14;
        Integer r4 = r6.d;
    L16:
        if ((r10 & 16) == 0) goto L18;
        Boolean r5 = r6.e;
    L19:
        r6.getClass();
        return new l0(r1, r2, r3, r4, r5);
    L18:
        r5 = null;
        goto L19
    L14:
        r4 = null;
        goto L16
    }

    public l0(int r3, h r4, h r5, h r6, Integer r7, Boolean r8) {
        if ((r3 & 0) == 0) goto L5;
        nuc.b2.b(r3, 0, a.b);
        throw null;
    L5:
        if ((r3 & 1) != 0) goto L7;
        this.a = null;
    L9:
        if ((r3 & 2) != 0) goto L11;
        this.b = null;
    L13:
        if ((r3 & 4) != 0) goto L15;
        this.c = null;
    L17:
        if ((r3 & 8) != 0) goto L19;
        this.d = -1;
    L21:
        if ((r3 & 16) != 0) goto L23;
        this.e = Boolean.FALSE;
        return;
    L23:
        this.e = r8;
        return;
    L19:
        this.d = r7;
        goto L21
    L15:
        this.c = r6;
        goto L17
    L11:
        this.b = r5;
        goto L13
    L7:
        this.a = r4;
        goto L9
    }
}
