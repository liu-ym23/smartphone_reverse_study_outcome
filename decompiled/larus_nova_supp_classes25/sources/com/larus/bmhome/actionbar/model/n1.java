package com.larus.bmhome.actionbar.model;

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
public final class n1 {
    public static final b Companion = null;
    public static final Lazy<juc.d<Object>>[] e = null;
    public final String a;
    public final l1 b;
    public final List<z> c;
    public final List<g> d;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<n1> {
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
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.ModelInputRuleConfig", r0, 4);
            r1.j("display_text", true);
            r1.j("media_info", true);
            r1.j("model_input_rule", true);
            r1.j("display_text_confs", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r0 = n1.e;
            return new juc.d[]{kuc.a.d(v2.a), kuc.a.d(l1.a.a), kuc.a.d((juc.d) r0[2].getValue()), kuc.a.d((juc.d) r0[3].getValue())};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r20) {
            Intrinsics.checkNotNullParameter(r20, "decoder");
            g2 r1 = b;
            muc.c r0 = r20.beginStructure(r1);
            Lazy<juc.d<Object>>[] r2 = n1.e;
            String r8 = null;
            if (r0.decodeSequentially() == false) goto L5;
            String r3 = (String) r0.decodeNullableSerializableElement(r1, 0, v2.a, null);
            l1 r5 = (l1) r0.decodeNullableSerializableElement(r1, 1, l1.a.a, null);
            List r4 = (List) r0.decodeNullableSerializableElement(r1, 2, (juc.c) r2[2].getValue(), null);
            List r18 = (List) r0.decodeNullableSerializableElement(r1, 3, (juc.c) r2[3].getValue(), null);
            String r15 = r3;
            List r17 = r4;
            l1 r16 = r5;
            int r14 = 15;
        L21:
            r0.endStructure(r1);
            return new n1(r14, r15, r16, r17, r18);
        L5:
            l1 r9 = null;
            List r10 = null;
            List r11 = null;
            int r6 = 0;
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
            r6 = r6 | 1;
            goto L6
        L10:
            if (r13 != 1) goto L11;
            r9 = (l1) r0.decodeNullableSerializableElement(r1, 1, l1.a.a, r9);
            r6 = r6 | 2;
            goto L6
        L11:
            if (r13 != 2) goto L12;
            r10 = (List) r0.decodeNullableSerializableElement(r1, 2, (juc.c) r2[2].getValue(), r10);
            r6 = r6 | 4;
            goto L6
        L12:
            if (r13 != 3) goto L15;
            r11 = (List) r0.decodeNullableSerializableElement(r1, 3, (juc.c) r2[3].getValue(), r11);
            r6 = r6 | 8;
            goto L6
        L15:
            throw new UnknownFieldException(r13);
        L20:
            r14 = r6;
            r15 = r8;
            r16 = r9;
            r17 = r10;
            r18 = r11;
            goto L21
        }

        public final void serialize(muc.f r8, Object r9) {
            n1 r10 = (n1) r9;
            Intrinsics.checkNotNullParameter(r8, "encoder");
            Intrinsics.checkNotNullParameter(r10, "value");
            g2 r0 = b;
            muc.d r11 = r8.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = n1.e;
            boolean r2 = false;
            if (r11.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r11.encodeNullableSerializableElement(r0, 0, v2.a, r10.a);
        L12:
            if (r11.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r11.encodeNullableSerializableElement(r0, 1, l1.a.a, r10.b);
        L21:
            if (r11.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            boolean r5 = true;
        L27:
            if (r5 == false) goto L30;
            r11.encodeNullableSerializableElement(r0, 2, (juc.n) r1[2].getValue(), r10.c);
        L30:
            if (r11.shouldEncodeElementDefault(r0, 3) == false) goto L33;
        L34:
            r2 = true;
        L35:
            if (r2 == false) goto L37;
            r11.encodeNullableSerializableElement(r0, 3, (juc.n) r1[3].getValue(), r10.d);
        L37:
            r11.endStructure(r0);
            return;
        L33:
            if (r10.d == null) goto L35;
        L24:
            if (r10.c != null) goto L25;
            r5 = false;
            goto L27
        L15:
            if (r10.b != null) goto L16;
            r4 = false;
            goto L18
        L6:
            if (r10.a != null) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<n1> serializer() {
            return a.a;
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof n1) == true) goto L8;
        return false;
    L8:
        n1 r6 = (n1) r5;
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
        String r0 = this.a;
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
        List<z> r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        List<g> r10 = this.d;
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
        return "ModelInputRuleConfig(displayText=" + this.a + ", mediaInfo=" + this.b + ", modelInputRules=" + this.c + ", displayTextConfs=" + this.d + ')';
    }

    static {
        Companion = new b();
        LazyThreadSafetyMode r1 = LazyThreadSafetyMode.PUBLICATION;
        e = new Lazy[]{null, null, LazyKt.lazy(r1, new wa8.o1()), LazyKt.lazy(r1, new wa8.p1())};
    }

    public n1() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
    }

    public n1(int r3, String r4, l1 r5, List r6, List r7) {
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
        this.d = null;
        return;
    L19:
        this.d = r7;
        return;
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
