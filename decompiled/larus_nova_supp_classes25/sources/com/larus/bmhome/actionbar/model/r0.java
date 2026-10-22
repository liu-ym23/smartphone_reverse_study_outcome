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
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Serializable
public final class r0 {
    public static final b Companion = null;
    public static final Lazy<juc.d<Object>>[] d = null;
    public final String a;
    public final Map<String, String> b;
    public final Map<String, o1> c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<r0> {
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
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.ActiveSwitchMemoryV2", r0, 3);
            r1.j("default_select_mode_id", true);
            r1.j("default_select_mode_id_by_scene", true);
            r1.j("default_select_model_by_mode_id", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r0 = r0.d;
            return new juc.d[]{kuc.a.d(v2.a), kuc.a.d((juc.d) r0[1].getValue()), kuc.a.d((juc.d) r0[2].getValue())};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r13) {
            Intrinsics.checkNotNullParameter(r13, "decoder");
            g2 r0 = b;
            muc.c r14 = r13.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = r0.d;
            String r6 = null;
            if (r14.decodeSequentially() == false) goto L5;
            String r2 = (String) r14.decodeNullableSerializableElement(r0, 0, v2.a, null);
            Map r4 = (Map) r14.decodeNullableSerializableElement(r0, 1, (juc.c) r1[1].getValue(), null);
            Map r3 = (Map) r14.decodeNullableSerializableElement(r0, 2, (juc.c) r1[2].getValue(), null);
            int r5 = 7;
        L19:
            r14.endStructure(r0);
            return new r0(r5, r2, r4, r3);
        L5:
            Map r7 = null;
            Map r8 = null;
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
            r6 = (String) r14.decodeNullableSerializableElement(r0, 0, v2.a, r6);
            r9 = r9 | 1;
            goto L6
        L10:
            if (r11 != 1) goto L11;
            r7 = (Map) r14.decodeNullableSerializableElement(r0, 1, (juc.c) r1[1].getValue(), r7);
            r9 = r9 | 2;
            goto L6
        L11:
            if (r11 != 2) goto L14;
            r8 = (Map) r14.decodeNullableSerializableElement(r0, 2, (juc.c) r1[2].getValue(), r8);
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

        public final void serialize(muc.f r7, Object r8) {
            r0 r9 = (r0) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = r0.d;
            boolean r2 = false;
            if (r10.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r10.encodeNullableSerializableElement(r0, 0, v2.a, r9.a);
        L12:
            if (r10.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r10.encodeNullableSerializableElement(r0, 1, (juc.n) r1[1].getValue(), r9.b);
        L21:
            if (r10.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            r2 = true;
        L26:
            if (r2 == false) goto L28;
            r10.encodeNullableSerializableElement(r0, 2, (juc.n) r1[2].getValue(), r9.c);
        L28:
            r10.endStructure(r0);
            return;
        L24:
            if (r9.c == null) goto L26;
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

        public final juc.d<r0> serializer() {
            return a.a;
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof r0) == true) goto L8;
        return false;
    L8:
        r0 r6 = (r0) r5;
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
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Map<String, String> r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Map<String, o1> r7 = this.c;
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
        return "ActiveSwitchMemoryV2(defaultSelectModeId=" + this.a + ", defaultSelectModeIdByScene=" + this.b + ", defaultSelectModelByModeId=" + this.c + ')';
    }

    static {
        Companion = new b();
        LazyThreadSafetyMode r1 = LazyThreadSafetyMode.PUBLICATION;
        d = new Lazy[]{null, LazyKt.lazy(r1, new wa8.u0()), LazyKt.lazy(r1, new wa8.v0())};
    }

    public r0() {
        this.a = null;
        this.b = null;
        this.c = null;
    }

    public r0(int r3, String r4, Map r5, Map r6) {
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
        return;
    L15:
        this.c = r6;
        return;
    L11:
        this.b = r5;
        goto L13
    L7:
        this.a = r4;
        goto L9
    }
}
