package bq8;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import nuc.b2;
import nuc.g1;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Serializable
public final class e {
    public static final b Companion = null;
    public final long a;
    public final String b;
    public final int c;
    public final int d;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<e> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final juc.d<?>[] childSerializers() {
            w0 r1 = w0.a;
            return new juc.d[]{g1.a, kuc.a.d(v2.a), r1, r1};
        }

        public final f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.bmhome.instruction.core.model.music.TemplateOptionItemConf", r0, 4);
            r1.j("id", true);
            r1.j("show_name", true);
            r1.j("instruction_item_id", true);
            r1.j("dropdown_id", true);
            b = r1;
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r21) {
            Intrinsics.checkNotNullParameter(r21, "decoder");
            g2 r1 = b;
            muc.c r0 = r21.beginStructure(r1);
            if (r0.decodeSequentially() == false) goto L5;
            long r8 = r0.decodeLongElement(r1, 0);
            String r2 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, null);
            String r17 = r2;
            int r18 = r0.decodeIntElement(r1, 2);
            int r19 = r0.decodeIntElement(r1, 3);
            long r15 = r8;
            int r14 = 15;
        L21:
            r0.endStructure(r1);
            return new e(r14, r15, r17, r18, r19);
        L5:
            long r10 = 0;
            int r3 = 0;
            int r9 = 0;
            boolean r12 = true;
            String r11 = null;
            int r7 = 0;
        L6:
            if (r12 == false) goto L20;
            int r13 = r0.decodeElementIndex(r1);
            if (r13 != (-1)) goto L9;
            r12 = false;
            goto L6
        L9:
            if (r13 != 0) goto L10;
            r10 = r0.decodeLongElement(r1, 0);
            r9 = r9 | 1;
            goto L6
        L10:
            if (r13 != 1) goto L11;
            r11 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, r11);
            r9 = r9 | 2;
            goto L6
        L11:
            if (r13 != 2) goto L12;
            r3 = r0.decodeIntElement(r1, 2);
            r9 = r9 | 4;
            goto L6
        L12:
            if (r13 != 3) goto L15;
            r7 = r0.decodeIntElement(r1, 3);
            r9 = r9 | 8;
            goto L6
        L15:
            throw new UnknownFieldException(r13);
        L20:
            r18 = r3;
            r19 = r7;
            r14 = r9;
            r17 = r11;
            r15 = r10;
            goto L21
        }

        public final void serialize(muc.f r9, Object r10) {
            e r11 = (e) r10;
            Intrinsics.checkNotNullParameter(r9, "encoder");
            Intrinsics.checkNotNullParameter(r11, "value");
            g2 r0 = b;
            muc.d r12 = r9.beginStructure(r0);
            b r1 = e.Companion;
            boolean r2 = false;
            if (r12.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r12.encodeLongElement(r0, 0, r11.a);
        L12:
            if (r12.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r12.encodeNullableSerializableElement(r0, 1, v2.a, r11.b);
        L21:
            if (r12.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            boolean r5 = true;
        L27:
            if (r5 == false) goto L30;
            r12.encodeIntElement(r0, 2, r11.c);
        L30:
            if (r12.shouldEncodeElementDefault(r0, 3) == false) goto L33;
        L34:
            r2 = true;
        L35:
            if (r2 == false) goto L37;
            r12.encodeIntElement(r0, 3, r11.d);
        L37:
            r12.endStructure(r0);
            return;
        L33:
            if (r11.d == 0) goto L35;
        L24:
            if (r11.c != 0) goto L25;
            r5 = false;
            goto L27
        L15:
            if (Intrinsics.areEqual(r11.b, "") == false) goto L16;
            r4 = false;
            goto L18
        L6:
            if (r11.a != 0) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<e> serializer() {
            return a.a;
        }
    }

    static {
        Companion = new b();
    }

    public e() {
        this.b = "";
    }

    public e(int r3, long r4, String r6, int r7, int r8) {
        if ((r3 & 0) == 0) goto L5;
        b2.b(r3, 0, a.b);
        throw null;
    L5:
        if ((r3 & 1) != 0) goto L7;
        r4 = 0;
    L7:
        this.a = r4;
        if ((r3 & 2) != 0) goto L10;
        this.b = "";
    L12:
        if ((r3 & 4) != 0) goto L14;
        this.c = 0;
    L16:
        if ((r3 & 8) != 0) goto L18;
        this.d = 0;
        return;
    L18:
        this.d = r8;
        return;
    L14:
        this.c = r7;
        goto L16
    L10:
        this.b = r6;
        goto L12
    }
}
