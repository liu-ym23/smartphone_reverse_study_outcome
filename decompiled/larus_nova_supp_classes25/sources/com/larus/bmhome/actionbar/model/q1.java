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
public final class q1 {
    public static final b Companion = null;
    public static final Lazy<juc.d<Object>>[] d = null;
    public final String a;
    public final String b;
    public final List<s1> c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<q1> {
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
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.MsgPromptConf", r0, 3);
            r1.j("placeholder", true);
            r1.j("no_limit_prompt_format", true);
            r1.j("prompt_list", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r0 = q1.d;
            v2 r2 = v2.a;
            return new juc.d[]{kuc.a.d(r2), kuc.a.d(r2), kuc.a.d((juc.d) r0[2].getValue())};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r13) {
            Intrinsics.checkNotNullParameter(r13, "decoder");
            g2 r0 = b;
            muc.c r14 = r13.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = q1.d;
            String r6 = null;
            if (r14.decodeSequentially() == false) goto L5;
            v2 r2 = v2.a;
            String r4 = (String) r14.decodeNullableSerializableElement(r0, 0, r2, null);
            String r3 = (String) r14.decodeNullableSerializableElement(r0, 1, r2, null);
            List r5 = (List) r14.decodeNullableSerializableElement(r0, 2, (juc.c) r1[2].getValue(), null);
            int r7 = 7;
        L19:
            r14.endStructure(r0);
            return new q1(r7, r4, r3, r5);
        L5:
            String r8 = null;
            List r9 = null;
            int r10 = 0;
            boolean r11 = true;
        L6:
            if (r11 == false) goto L18;
            int r12 = r14.decodeElementIndex(r0);
            if (r12 != (-1)) goto L9;
            r11 = false;
            goto L6
        L9:
            if (r12 != 0) goto L10;
            r6 = (String) r14.decodeNullableSerializableElement(r0, 0, v2.a, r6);
            r10 = r10 | 1;
            goto L6
        L10:
            if (r12 != 1) goto L11;
            r8 = (String) r14.decodeNullableSerializableElement(r0, 1, v2.a, r8);
            r10 = r10 | 2;
            goto L6
        L11:
            if (r12 != 2) goto L14;
            r9 = (List) r14.decodeNullableSerializableElement(r0, 2, (juc.c) r1[2].getValue(), r9);
            r10 = r10 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r12);
        L18:
            r7 = r10;
            r4 = r6;
            r3 = r8;
            r5 = r9;
            goto L19
        }

        public final void serialize(muc.f r8, Object r9) {
            q1 r10 = (q1) r9;
            Intrinsics.checkNotNullParameter(r8, "encoder");
            Intrinsics.checkNotNullParameter(r10, "value");
            g2 r0 = b;
            muc.d r11 = r8.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = q1.d;
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
            if (Intrinsics.areEqual(r10.b, "") == false) goto L16;
            r4 = false;
            goto L18
        L6:
            if (Intrinsics.areEqual(r10.a, "") == false) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<q1> serializer() {
            return a.a;
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof q1) == true) goto L8;
        return false;
    L8:
        q1 r6 = (q1) r5;
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
        String r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        List<s1> r7 = this.c;
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
        return "MsgPromptConf(placeHolder=" + this.a + ", noLimitPrompt=" + this.b + ", promptList=" + this.c + ')';
    }

    static {
        Companion = new b();
        d = new Lazy[]{null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new wa8.q1())};
    }

    public q1() {
        ArrayList r0 = new ArrayList();
        this.a = "";
        this.b = "";
        this.c = r0;
    }

    public q1(int r3, String r4, String r5, List r6) {
        if ((r3 & 0) == 0) goto L5;
        nuc.b2.b(r3, 0, a.b);
        throw null;
    L5:
        if ((r3 & 1) != 0) goto L7;
        this.a = "";
    L9:
        if ((r3 & 2) != 0) goto L11;
        this.b = "";
    L13:
        if ((r3 & 4) != 0) goto L15;
        this.c = new ArrayList();
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
