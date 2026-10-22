package com.larus.bmhome.actionbar.model;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.g2;
import nuc.i2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Serializable
public final class i1 {
    public static final b Companion = null;
    public final boolean a;
    public final boolean b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<i1> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final juc.d<?>[] childSerializers() {
            nuc.i r1 = nuc.i.a;
            return new juc.d[]{r1, r1};
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.InputBoxSettings", r0, 2);
            r1.j("show_camera", true);
            r1.j("show_file_upload", true);
            b = r1;
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r10) {
            Intrinsics.checkNotNullParameter(r10, "decoder");
            g2 r0 = b;
            muc.c r11 = r10.beginStructure(r0);
            if (r11.decodeSequentially() == false) goto L5;
            boolean r1 = r11.decodeBooleanElement(r0, 0);
            boolean r2 = r11.decodeBooleanElement(r0, 1);
            int r3 = 3;
        L17:
            r11.endStructure(r0);
            return new i1(r3, r1, r2);
        L5:
            r1 = false;
            boolean r4 = false;
            int r5 = 0;
            boolean r6 = true;
        L6:
            if (r6 == false) goto L16;
            int r7 = r11.decodeElementIndex(r0);
            if (r7 != (-1)) goto L9;
            r6 = false;
            goto L6
        L9:
            if (r7 != 0) goto L10;
            r1 = r11.decodeBooleanElement(r0, 0);
            r5 = r5 | 1;
            goto L6
        L10:
            if (r7 != 1) goto L13;
            r4 = r11.decodeBooleanElement(r0, 1);
            r5 = r5 | 2;
            goto L6
        L13:
            throw new UnknownFieldException(r7);
        L16:
            r2 = r4;
            r3 = r5;
            goto L17
        }

        public final void serialize(muc.f r5, Object r6) {
            i1 r7 = (i1) r6;
            Intrinsics.checkNotNullParameter(r5, "encoder");
            Intrinsics.checkNotNullParameter(r7, "value");
            g2 r0 = b;
            muc.d r8 = r5.beginStructure(r0);
            b r1 = i1.Companion;
            boolean r2 = false;
            if (r8.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r8.encodeBooleanElement(r0, 0, r7.a);
        L12:
            if (r8.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            r2 = true;
        L17:
            if (r2 == false) goto L19;
            r8.encodeBooleanElement(r0, 1, r7.b);
        L19:
            r8.endStructure(r0);
            return;
        L15:
            if (r7.b == false) goto L17;
        L6:
            if (r7.a == true) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<i1> serializer() {
            return a.a;
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i1) == true) goto L8;
        return false;
    L8:
        i1 r6 = (i1) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.b == true) goto L11;
        r1 = 1237;
    L11:
        return r2 + r1;
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "InputBoxSettings(showCamera=" + this.a + ", showFileUpload=" + this.b + ')';
    }

    static {
        Companion = new b();
    }

    public i1() {
        this.a = false;
        this.b = false;
    }

    public i1(int r3, boolean r4, boolean r5) {
        if ((r3 & 0) == 0) goto L5;
        nuc.b2.b(r3, 0, a.b);
        throw null;
    L5:
        if ((r3 & 1) != 0) goto L7;
        this.a = false;
    L9:
        if ((r3 & 2) != 0) goto L11;
        this.b = false;
        return;
    L11:
        this.b = r5;
        return;
    L7:
        this.a = r4;
        goto L9
    }
}
