package com.larus.bmhome.actionbar.model;

import java.util.Map;
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
public final class s0 {
    public static final b Companion = null;
    public static final Lazy<juc.d<Object>>[] e = null;
    public final u0 a;
    public final a2 b;
    public final Map<String, q0> c;
    public final Boolean d;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<s0> {
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
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.ActiveSwitchMenuConfigV2", r0, 4);
            r1.j("mode_list", true);
            r1.j("model_list", true);
            r1.j("default_select_mode_map", true);
            r1.j("use_mode_model_list", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{kuc.a.d(u0.a.a), kuc.a.d(a2.a.a), kuc.a.d((juc.d) s0.e[2].getValue()), kuc.a.d(nuc.i.a)};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r20) {
            Intrinsics.checkNotNullParameter(r20, "decoder");
            g2 r1 = b;
            muc.c r0 = r20.beginStructure(r1);
            Lazy<juc.d<Object>>[] r2 = s0.e;
            u0 r8 = null;
            if (r0.decodeSequentially() == false) goto L5;
            u0 r3 = (u0) r0.decodeNullableSerializableElement(r1, 0, u0.a.a, null);
            a2 r5 = (a2) r0.decodeNullableSerializableElement(r1, 1, a2.a.a, null);
            Map r17 = (Map) r0.decodeNullableSerializableElement(r1, 2, (juc.c) r2[2].getValue(), null);
            u0 r15 = r3;
            Boolean r18 = (Boolean) r0.decodeNullableSerializableElement(r1, 3, nuc.i.a, null);
            a2 r16 = r5;
            int r14 = 15;
        L21:
            r0.endStructure(r1);
            return new s0(r14, r15, r16, r17, r18);
        L5:
            a2 r9 = null;
            Map r10 = null;
            Boolean r11 = null;
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
            r8 = (u0) r0.decodeNullableSerializableElement(r1, 0, u0.a.a, r8);
            r4 = r4 | 1;
            goto L6
        L10:
            if (r13 != 1) goto L11;
            r9 = (a2) r0.decodeNullableSerializableElement(r1, 1, a2.a.a, r9);
            r4 = r4 | 2;
            goto L6
        L11:
            if (r13 != 2) goto L12;
            r10 = (Map) r0.decodeNullableSerializableElement(r1, 2, (juc.c) r2[2].getValue(), r10);
            r4 = r4 | 4;
            goto L6
        L12:
            if (r13 != 3) goto L15;
            r11 = (Boolean) r0.decodeNullableSerializableElement(r1, 3, nuc.i.a, r11);
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

        public final void serialize(muc.f r7, Object r8) {
            s0 r9 = (s0) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = s0.e;
            boolean r2 = false;
            if (r10.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r10.encodeNullableSerializableElement(r0, 0, u0.a.a, r9.a);
        L12:
            if (r10.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r10.encodeNullableSerializableElement(r0, 1, a2.a.a, r9.b);
        L21:
            if (r10.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            boolean r5 = true;
        L27:
            if (r5 == false) goto L30;
            r10.encodeNullableSerializableElement(r0, 2, (juc.n) r1[2].getValue(), r9.c);
        L30:
            if (r10.shouldEncodeElementDefault(r0, 3) == false) goto L33;
        L34:
            r2 = true;
        L35:
            if (r2 == false) goto L37;
            r10.encodeNullableSerializableElement(r0, 3, nuc.i.a, r9.d);
        L37:
            r10.endStructure(r0);
            return;
        L33:
            if (r9.d == null) goto L35;
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

        public final juc.d<s0> serializer() {
            return a.a;
        }
    }

    public s0() {
        this(null, null, null, null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof s0) == true) goto L8;
        return false;
    L8:
        s0 r6 = (s0) r5;
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
        u0 r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        a2 r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Map<String, q0> r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.d;
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
        return "ActiveSwitchMenuConfigV2(modeList=" + this.a + ", modelList=" + this.b + ", defaultSelectModeMap=" + this.c + ", useModeModelList=" + this.d + ')';
    }

    static {
        Companion = new b();
        e = new Lazy[]{null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new wa8.w0()), null};
    }

    public s0(u0 r1, a2 r2, Map<String, q0> r3, Boolean r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public s0(int r3, u0 r4, a2 r5, Map r6, Boolean r7) {
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
