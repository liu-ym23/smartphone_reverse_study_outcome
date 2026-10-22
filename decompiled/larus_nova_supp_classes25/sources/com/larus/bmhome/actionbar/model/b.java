package com.larus.bmhome.actionbar.model;

import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.g2;
import nuc.i2;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Serializable
public final class b implements k1 {
    public static final C0030b Companion = null;
    public static final Lazy<juc.d<Object>>[] d = null;
    public final Map<String, a0> a;
    public final Integer b;
    public String c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<b> {
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
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.ActionBarCollaboratedMultiFeatureSelectorTemplate", r0, 3);
            r1.j("configs", true);
            r1.j("collaborated_dropdown_box_id", true);
            r1.j("active_config_key", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{kuc.a.d((juc.d) b.d[0].getValue()), kuc.a.d(wa8.r1.a), kuc.a.d(v2.a)};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r13) {
            Intrinsics.checkNotNullParameter(r13, "decoder");
            g2 r0 = b;
            muc.c r14 = r13.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = b.d;
            Map r6 = null;
            if (r14.decodeSequentially() == false) goto L5;
            Map r2 = (Map) r14.decodeNullableSerializableElement(r0, 0, (juc.c) r1[0].getValue(), null);
            Integer r3 = (Integer) r14.decodeNullableSerializableElement(r0, 1, wa8.r1.a, null);
            String r4 = (String) r14.decodeNullableSerializableElement(r0, 2, v2.a, null);
            int r5 = 7;
        L19:
            r14.endStructure(r0);
            return new b(r5, r2, r3, r4);
        L5:
            Integer r7 = null;
            String r8 = null;
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
            r6 = (Map) r14.decodeNullableSerializableElement(r0, 0, (juc.c) r1[0].getValue(), r6);
            r9 = r9 | 1;
            goto L6
        L10:
            if (r11 != 1) goto L11;
            r7 = (Integer) r14.decodeNullableSerializableElement(r0, 1, wa8.r1.a, r7);
            r9 = r9 | 2;
            goto L6
        L11:
            if (r11 != 2) goto L14;
            r8 = (String) r14.decodeNullableSerializableElement(r0, 2, v2.a, r8);
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
            b r9 = (b) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = b.d;
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
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r10.encodeNullableSerializableElement(r0, 1, wa8.r1.a, r9.b);
        L21:
            if (r10.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            r2 = true;
        L26:
            if (r2 == false) goto L28;
            r10.encodeNullableSerializableElement(r0, 2, v2.a, r9.c);
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
            if (Intrinsics.areEqual(r9.a, MapsKt.emptyMap()) == false) goto L7;
            r3 = false;
            goto L9
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.actionbar.model.b$b, reason: collision with other inner class name */
    public static final class C0030b {
        public C0030b() {
        }

        public final juc.d<b> serializer() {
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
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
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
        Map<String, a0> r0 = this.a;
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
        String r7 = this.c;
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
        return "ActionBarCollaboratedMultiFeatureSelectorTemplate(configs=" + this.a + ", collaboratedDropdownBoxId=" + this.b + ", activeConfigKey=" + this.c + ')';
    }

    static {
        Companion = new C0030b();
        d = new Lazy[]{LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new wa8.e()), null, null};
    }

    public final a0 d() {
        Map<String, a0> r0 = this.a;
        if (r0 != null) goto L5;
        r0 = MapsKt.emptyMap();
    L5:
        String r1 = this.c;
        if (r1 == null) goto L10;
        a0 r2 = r0.get(r1);
        if (r2 == null) goto L10;
        return r2;
    L10:
        return (a0) CollectionsKt.firstOrNull(r0.values());
    }

    public b() {
        this.a = MapsKt.emptyMap();
        this.b = null;
        this.c = null;
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final String a() {
        a0 r0 = d();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final String c(String r2, List<String> r3) {
        a0 r0 = d();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c(r2, r3);
    }

    public b(int r3, Map r4, Integer r5, String r6) {
        if ((r3 & 0) == 0) goto L5;
        nuc.b2.b(r3, 0, a.b);
        throw null;
    L5:
        if ((r3 & 1) != 0) goto L7;
        r4 = MapsKt.emptyMap();
    L7:
        this.a = r4;
        if ((r3 & 2) != 0) goto L10;
        this.b = null;
    L12:
        if ((r3 & 4) != 0) goto L14;
        this.c = null;
        return;
    L14:
        this.c = r6;
        return;
    L10:
        this.b = r5;
        goto L12
    }
}
