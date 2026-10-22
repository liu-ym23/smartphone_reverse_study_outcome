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
import kotlin.text.StringsKt;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.g2;
import nuc.i2;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Serializable
public final class a0 implements k1 {
    public static final b Companion = null;
    public static final Lazy<juc.d<Object>>[] g = null;
    public final String a;
    public final String b;
    public final List<f0> c;
    public final String d;
    public final l1 e;
    public final List<z> f;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<a0> {
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
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.ActionBarMultiFeatureSelector", r0, 6);
            r1.j("id", true);
            r1.j("title", true);
            r1.j("selectors", true);
            r1.j("display_text", true);
            r1.j("media_info", true);
            r1.j("model_input_rule", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r0 = a0.g;
            v2 r2 = v2.a;
            return new juc.d[]{kuc.a.d(r2), kuc.a.d(r2), kuc.a.d((juc.d) r0[2].getValue()), kuc.a.d(r2), kuc.a.d(l1.a.a), kuc.a.d((juc.d) r0[5].getValue())};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r19) {
            Intrinsics.checkNotNullParameter(r19, "decoder");
            g2 r1 = b;
            muc.c r0 = r19.beginStructure(r1);
            Lazy<juc.d<Object>>[] r2 = a0.g;
            int r4 = 2;
            List r10 = null;
            if (r0.decodeSequentially() == false) goto L5;
            v2 r3 = v2.a;
            String r8 = (String) r0.decodeNullableSerializableElement(r1, 0, r3, null);
            String r7 = (String) r0.decodeNullableSerializableElement(r1, 1, r3, null);
            List r5 = (List) r0.decodeNullableSerializableElement(r1, 2, (juc.c) r2[2].getValue(), null);
            String r6 = (String) r0.decodeNullableSerializableElement(r1, 3, r3, null);
            l1 r9 = (l1) r0.decodeNullableSerializableElement(r1, 4, l1.a.a, null);
            List r16 = (List) r0.decodeNullableSerializableElement(r1, 5, (juc.c) r2[5].getValue(), null);
            String r14 = r6;
            List r13 = r5;
            l1 r15 = r9;
            String r12 = r7;
            String r11 = r8;
            int r17 = 63;
        L21:
            r0.endStructure(r1);
            return new a0(r17, r11, r12, r13, r14, r15, r16);
        L5:
            r11 = null;
            String r18 = null;
            r13 = null;
            String r110 = null;
            r15 = null;
            int r20 = 0;
            boolean r111 = true;
        L6:
            if (r111 == false) goto L20;
            int r21 = r0.decodeElementIndex(r1);
            switch(r21) {
                case -1: goto L19;
                case 0: goto L17;
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r21);
        L19:
            r4 = 2;
            r111 = false;
            goto L6
        L11:
            r10 = (List) r0.decodeNullableSerializableElement(r1, 5, (juc.c) r2[5].getValue(), r10);
            r20 = r20 | 32;
        L18:
            r4 = 2;
            goto L6
        L12:
            r15 = (l1) r0.decodeNullableSerializableElement(r1, 4, l1.a.a, r15);
            r20 = r20 | 16;
            goto L18
        L13:
            r18 = (String) r0.decodeNullableSerializableElement(r1, 3, v2.a, r18);
            r20 = r20 | 8;
            goto L18
        L14:
            r13 = (List) r0.decodeNullableSerializableElement(r1, r4, (juc.c) r2[r4].getValue(), r13);
            r20 = r20 | 4;
            goto L18
        L15:
            r110 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, r110);
            r20 = r20 | 2;
            goto L18
        L17:
            r20 = r20 | 1;
            r11 = (String) r0.decodeNullableSerializableElement(r1, 0, v2.a, r11);
            goto L18
        L20:
            r16 = r10;
            r17 = r20;
            String r112 = r110;
            r14 = r18;
            r12 = r112;
            goto L21
        }

        public final void serialize(muc.f r8, Object r9) {
            a0 r10 = (a0) r9;
            Intrinsics.checkNotNullParameter(r8, "encoder");
            Intrinsics.checkNotNullParameter(r10, "value");
            g2 r0 = b;
            muc.d r11 = r8.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = a0.g;
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
            r11.encodeNullableSerializableElement(r0, 1, v2.a, r10.b);
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
            boolean r6 = true;
        L36:
            if (r6 == false) goto L39;
            r11.encodeNullableSerializableElement(r0, 3, v2.a, r10.d);
        L39:
            if (r11.shouldEncodeElementDefault(r0, 4) == false) goto L42;
        L43:
            boolean r7 = true;
        L45:
            if (r7 == false) goto L48;
            r11.encodeNullableSerializableElement(r0, 4, l1.a.a, r10.e);
        L48:
            if (r11.shouldEncodeElementDefault(r0, 5) == false) goto L51;
        L52:
            r2 = true;
        L53:
            if (r2 == false) goto L55;
            r11.encodeNullableSerializableElement(r0, 5, (juc.n) r1[5].getValue(), r10.f);
        L55:
            r11.endStructure(r0);
            return;
        L51:
            if (r10.f == null) goto L53;
        L42:
            if (r10.e != null) goto L43;
            r7 = false;
            goto L45
        L33:
            if (r10.d != null) goto L34;
            r6 = false;
            goto L36
        L24:
            if (Intrinsics.areEqual(r10.c, new ArrayList()) == false) goto L25;
            r5 = false;
            goto L27
        L15:
            if (Intrinsics.areEqual(r10.b, "") == false) goto L16;
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

        public final juc.d<a0> serializer() {
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
        if ((r5 instanceof a0) == true) goto L8;
        return false;
    L8:
        a0 r6 = (a0) r5;
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
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        List<f0> r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        l1 r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        List<z> r16 = this.f;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
    L21:
        r14 = r13.hashCode();
        goto L22
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
        return "ActionBarMultiFeatureSelector(id=" + this.a + ", title=" + this.b + ", selectors=" + this.c + ", displayText=" + this.d + ", mediaInfo=" + this.e + ", modelInputRules=" + this.f + ')';
    }

    static {
        Companion = new b();
        LazyThreadSafetyMode r1 = LazyThreadSafetyMode.PUBLICATION;
        g = new Lazy[]{null, null, LazyKt.lazy(r1, new wa8.f0()), null, null, LazyKt.lazy(r1, new wa8.g0())};
    }

    public a0() {
        ArrayList r0 = new ArrayList();
        this.a = null;
        this.b = "";
        this.c = r0;
        this.d = null;
        this.e = null;
        this.f = null;
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final String a() {
        List<f0> r0 = this.c;
        if (r0 == null) goto L21;
        ArrayList r2 = new ArrayList();
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        String r3 = ((f0) r1.next()).a();
        if (r3 == null) goto L6;
        r2.add(r3);
        goto L6
    L10:
        String r4 = CollectionsKt.joinToString$default(r2, wa8.h.a(), null, null, 0, null, null, 62, null);
        if (r4 != null) goto L13;
        return null;
    L13:
        if ((!StringsKt.isBlank(r4)) == true) goto L15;
        return null;
    L15:
        return r4;
    L21:
        return null;
    }

    @Override // com.larus.bmhome.actionbar.model.k1
    public final String c(String r12, List<String> r13) {
        List<f0> r0 = this.c;
        if (r0 == null) goto L23;
        ArrayList r2 = new ArrayList();
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        String r3 = ((f0) r1.next()).c(r12, r13);
        if (r3 == null) goto L6;
        r2.add(r3);
        goto L6
    L10:
        if (r12 != null) goto L12;
        r12 = wa8.h.a();
    L12:
        String r14 = CollectionsKt.joinToString$default(r2, r12, null, null, 0, null, null, 62, null);
        if (r14 != null) goto L15;
        return null;
    L15:
        if ((!StringsKt.isBlank(r14)) == true) goto L17;
        return null;
    L17:
        return r14;
    L23:
        return null;
    }

    public a0(int r3, String r4, String r5, List r6, String r7, l1 r8, List r9) {
        if ((r3 & 0) == 0) goto L5;
        nuc.b2.b(r3, 0, a.b);
        throw null;
    L5:
        if ((r3 & 1) != 0) goto L7;
        this.a = null;
    L9:
        if ((r3 & 2) != 0) goto L11;
        this.b = "";
    L13:
        if ((r3 & 4) != 0) goto L15;
        this.c = new ArrayList();
    L17:
        if ((r3 & 8) != 0) goto L19;
        this.d = null;
    L21:
        if ((r3 & 16) != 0) goto L23;
        this.e = null;
    L25:
        if ((r3 & 32) != 0) goto L27;
        this.f = null;
        return;
    L27:
        this.f = r9;
        return;
    L23:
        this.e = r8;
        goto L25
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
