package com.larus.bmhome.actionbar.model;

import com.larus.bmhome.chat.model.ChatDraftItem;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.g2;
import nuc.i2;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Serializable
public final class x1 {
    public static final b Companion = null;
    public final String a;
    public final String b;
    public final String c;
    public final g1 d;
    public final g1 e;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<x1> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final juc.d<?>[] childSerializers() {
            v2 r1 = v2.a;
            g1.a r2 = g1.a.a;
            return new juc.d[]{kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r2), kuc.a.d(r2)};
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.SendMsgMenuConf", r0, 5);
            r1.j("name", true);
            r1.j(ChatDraftItem.TYPE_TEXT, true);
            r1.j("sub_action_bar_key", true);
            r1.j("icon", true);
            r1.j("dark_mode_icon", true);
            b = r1;
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r22) {
            Intrinsics.checkNotNullParameter(r22, "decoder");
            g2 r1 = b;
            muc.c r0 = r22.beginStructure(r1);
            String r8 = null;
            if (r0.decodeSequentially() == false) goto L5;
            v2 r2 = v2.a;
            String r5 = (String) r0.decodeNullableSerializableElement(r1, 0, r2, null);
            String r6 = (String) r0.decodeNullableSerializableElement(r1, 1, r2, null);
            String r3 = (String) r0.decodeNullableSerializableElement(r1, 2, r2, null);
            g1.a r4 = g1.a.a;
            g1 r7 = (g1) r0.decodeNullableSerializableElement(r1, 3, r4, null);
            String r18 = r3;
            g1 r20 = (g1) r0.decodeNullableSerializableElement(r1, 4, r4, null);
            String r16 = r5;
            String r17 = r6;
            g1 r19 = r7;
            int r15 = 31;
        L23:
            r0.endStructure(r1);
            return new x1(r15, r16, r17, r18, r19, r20);
        L5:
            String r9 = null;
            String r10 = null;
            g1 r11 = null;
            g1 r12 = null;
            int r13 = 0;
            boolean r14 = true;
        L6:
            if (r14 == false) goto L22;
            int r110 = r0.decodeElementIndex(r1);
            if (r110 != (-1)) goto L9;
            r14 = false;
            goto L6
        L9:
            if (r110 != 0) goto L10;
            r8 = (String) r0.decodeNullableSerializableElement(r1, 0, v2.a, r8);
            r13 = r13 | 1;
            goto L6
        L10:
            if (r110 != 1) goto L11;
            r9 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, r9);
            r13 = r13 | 2;
            goto L6
        L11:
            if (r110 != 2) goto L12;
            r10 = (String) r0.decodeNullableSerializableElement(r1, 2, v2.a, r10);
            r13 = r13 | 4;
            goto L6
        L12:
            if (r110 != 3) goto L13;
            r11 = (g1) r0.decodeNullableSerializableElement(r1, 3, g1.a.a, r11);
            r13 = r13 | 8;
            goto L6
        L13:
            if (r110 != 4) goto L16;
            r12 = (g1) r0.decodeNullableSerializableElement(r1, 4, g1.a.a, r12);
            r13 = r13 | 16;
            goto L6
        L16:
            throw new UnknownFieldException(r110);
        L22:
            r15 = r13;
            r16 = r8;
            r17 = r9;
            r18 = r10;
            r19 = r11;
            r20 = r12;
            goto L23
        }

        public final void serialize(muc.f r13, Object r14) {
            x1 r15 = (x1) r14;
            Intrinsics.checkNotNullParameter(r13, "encoder");
            Intrinsics.checkNotNullParameter(r15, "value");
            g2 r0 = b;
            muc.d r16 = r13.beginStructure(r0);
            b r1 = x1.Companion;
            boolean r2 = false;
            if (r16.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r16.encodeNullableSerializableElement(r0, 0, v2.a, r15.a);
        L12:
            if (r16.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r16.encodeNullableSerializableElement(r0, 1, v2.a, r15.b);
        L21:
            if (r16.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            boolean r5 = true;
        L27:
            if (r5 == false) goto L30;
            r16.encodeNullableSerializableElement(r0, 2, v2.a, r15.c);
        L30:
            if (r16.shouldEncodeElementDefault(r0, 3) == false) goto L33;
        L34:
            boolean r6 = true;
        L36:
            if (r6 == false) goto L39;
            r16.encodeNullableSerializableElement(r0, 3, g1.a.a, r15.d);
        L39:
            if (r16.shouldEncodeElementDefault(r0, 4) == false) goto L42;
        L43:
            r2 = true;
        L44:
            if (r2 == false) goto L46;
            r16.encodeNullableSerializableElement(r0, 4, g1.a.a, r15.e);
        L46:
            r16.endStructure(r0);
            return;
        L42:
            if (Intrinsics.areEqual(r15.e, new g1("", "", null, null, 28)) == true) goto L44;
        L33:
            if (Intrinsics.areEqual(r15.d, new g1("", "", null, null, 28)) == false) goto L34;
            r6 = false;
            goto L36
        L24:
            if (Intrinsics.areEqual(r15.c, "") == false) goto L25;
            r5 = false;
            goto L27
        L15:
            if (Intrinsics.areEqual(r15.b, "") == false) goto L16;
            r4 = false;
            goto L18
        L6:
            if (Intrinsics.areEqual(r15.a, "") == false) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<x1> serializer() {
            return a.a;
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof x1) == true) goto L8;
        return false;
    L8:
        x1 r6 = (x1) r5;
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
        String r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        g1 r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        g1 r13 = this.e;
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
        return "SendMsgMenuConf(name=" + this.a + ", text=" + this.b + ", key=" + this.c + ", icon=" + this.d + ", darkModeIcon=" + this.e + ')';
    }

    static {
        Companion = new b();
    }

    public x1() {
        g1 r6 = new g1("", "", null, null, 28);
        g1 r0 = new g1("", "", null, null, 28);
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = r6;
        this.e = r0;
    }

    public x1(int r7, String r8, String r9, String r10, g1 r11, g1 r12) {
        if ((r7 & 0) == 0) goto L5;
        nuc.b2.b(r7, 0, a.b);
        throw null;
    L5:
        if ((r7 & 1) != 0) goto L7;
        this.a = "";
    L9:
        if ((r7 & 2) != 0) goto L11;
        this.b = "";
    L13:
        if ((r7 & 4) != 0) goto L15;
        this.c = "";
    L17:
        if ((r7 & 8) != 0) goto L19;
        this.d = new g1("", "", null, null, 28);
    L21:
        if ((r7 & 16) != 0) goto L23;
        this.e = new g1("", "", null, null, 28);
        return;
    L23:
        this.e = r12;
        return;
    L19:
        this.d = r11;
        goto L21
    L15:
        this.c = r10;
        goto L17
    L11:
        this.b = r9;
        goto L13
    L7:
        this.a = r8;
        goto L9
    }
}
