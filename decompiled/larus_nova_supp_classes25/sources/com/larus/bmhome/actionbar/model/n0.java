package com.larus.bmhome.actionbar.model;

import com.larus.bmhome.chat.model.ChatDraftItem;
import java.util.ArrayList;
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
public final class n0 {
    public static final b Companion = null;
    public static final Lazy<juc.d<Object>>[] c = null;
    public final String a;
    public final ArrayList<x1> b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<n0> {
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
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.ActionBarUserSendMsgConf", r0, 2);
            r1.j(ChatDraftItem.TYPE_TEXT, true);
            r1.j("sub_menu_conf", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{kuc.a.d(v2.a), kuc.a.d((juc.d) n0.c[1].getValue())};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r11) {
            Intrinsics.checkNotNullParameter(r11, "decoder");
            g2 r0 = b;
            muc.c r12 = r11.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = n0.c;
            ArrayList r5 = null;
            if (r12.decodeSequentially() == false) goto L5;
            String r2 = (String) r12.decodeNullableSerializableElement(r0, 0, v2.a, null);
            ArrayList r3 = (ArrayList) r12.decodeNullableSerializableElement(r0, 1, (juc.c) r1[1].getValue(), null);
            int r4 = 3;
        L17:
            r12.endStructure(r0);
            return new n0(r4, r2, r3);
        L5:
            String r6 = null;
            int r7 = 0;
            boolean r8 = true;
        L6:
            if (r8 == false) goto L16;
            int r9 = r12.decodeElementIndex(r0);
            if (r9 != (-1)) goto L9;
            r8 = false;
            goto L6
        L9:
            if (r9 != 0) goto L10;
            r6 = (String) r12.decodeNullableSerializableElement(r0, 0, v2.a, r6);
            r7 = r7 | 1;
            goto L6
        L10:
            if (r9 != 1) goto L13;
            r5 = (ArrayList) r12.decodeNullableSerializableElement(r0, 1, (juc.c) r1[1].getValue(), r5);
            r7 = r7 | 2;
            goto L6
        L13:
            throw new UnknownFieldException(r9);
        L16:
            r4 = r7;
            r3 = r5;
            r2 = r6;
            goto L17
        }

        public final void serialize(muc.f r7, Object r8) {
            n0 r9 = (n0) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = n0.c;
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
            r2 = true;
        L17:
            if (r2 == false) goto L19;
            r10.encodeNullableSerializableElement(r0, 1, (juc.n) r1[1].getValue(), r9.b);
        L19:
            r10.endStructure(r0);
            return;
        L15:
            if (r9.b == null) goto L17;
        L6:
            if (Intrinsics.areEqual(r9.a, "") == false) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<n0> serializer() {
            return a.a;
        }
    }

    public n0() {
        this(null, 3);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof n0) == true) goto L8;
        return false;
    L8:
        n0 r6 = (n0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        ArrayList<x1> r4 = this.b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ActionBarUserSendMsgConf(text=" + this.a + ", menuList=" + this.b + ')';
    }

    static {
        Companion = new b();
        c = new Lazy[]{null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new wa8.q0())};
    }

    public n0(String r1, int r2) {
        if ((r2 & 1) == 0) goto L5;
        r1 = "";
    L5:
        this.a = r1;
        this.b = null;
    }

    public n0(int r3, String r4, ArrayList r5) {
        if ((r3 & 0) == 0) goto L5;
        nuc.b2.b(r3, 0, a.b);
        throw null;
    L5:
        if ((r3 & 1) != 0) goto L7;
        r4 = "";
    L7:
        this.a = r4;
        if ((r3 & 2) != 0) goto L10;
        this.b = null;
        return;
    L10:
        this.b = r5;
    }
}
