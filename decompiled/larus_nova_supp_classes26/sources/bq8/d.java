package bq8;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Serializable
public final class d {
    public static final b Companion = null;
    public final e a;
    public final e b;
    public final e c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<d> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final juc.d<?>[] childSerializers() {
            e.a r1 = e.a.a;
            return new juc.d[]{kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1)};
        }

        public final f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.bmhome.instruction.core.model.music.TemplateOptionConf", r0, 3);
            r1.j("mood", true);
            r1.j("gender", true);
            r1.j("genre", true);
            b = r1;
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r12) {
            Intrinsics.checkNotNullParameter(r12, "decoder");
            g2 r0 = b;
            muc.c r13 = r12.beginStructure(r0);
            e r5 = null;
            if (r13.decodeSequentially() == false) goto L5;
            e.a r1 = e.a.a;
            e r3 = (e) r13.decodeNullableSerializableElement(r0, 0, r1, null);
            e r4 = (e) r13.decodeNullableSerializableElement(r0, 1, r1, null);
            e r2 = (e) r13.decodeNullableSerializableElement(r0, 2, r1, null);
            int r6 = 7;
        L19:
            r13.endStructure(r0);
            return new d(r6, r3, r4, r2);
        L5:
            e r7 = null;
            e r8 = null;
            int r9 = 0;
            boolean r10 = true;
        L6:
            if (r10 == false) goto L18;
            int r11 = r13.decodeElementIndex(r0);
            if (r11 != (-1)) goto L9;
            r10 = false;
            goto L6
        L9:
            if (r11 != 0) goto L10;
            r5 = (e) r13.decodeNullableSerializableElement(r0, 0, e.a.a, r5);
            r9 = r9 | 1;
            goto L6
        L10:
            if (r11 != 1) goto L11;
            r7 = (e) r13.decodeNullableSerializableElement(r0, 1, e.a.a, r7);
            r9 = r9 | 2;
            goto L6
        L11:
            if (r11 != 2) goto L14;
            r8 = (e) r13.decodeNullableSerializableElement(r0, 2, e.a.a, r8);
            r9 = r9 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r11);
        L18:
            r6 = r9;
            r3 = r5;
            r4 = r7;
            r2 = r8;
            goto L19
        }

        public final void serialize(muc.f r7, Object r8) {
            d r9 = (d) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            b r1 = d.Companion;
            boolean r2 = false;
            if (r10.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r10.encodeNullableSerializableElement(r0, 0, e.a.a, r9.a);
        L12:
            if (r10.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r10.encodeNullableSerializableElement(r0, 1, e.a.a, r9.b);
        L21:
            if (r10.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            r2 = true;
        L26:
            if (r2 == false) goto L28;
            r10.encodeNullableSerializableElement(r0, 2, e.a.a, r9.c);
        L28:
            r10.endStructure(r0);
            return;
        L24:
            if (Intrinsics.areEqual(r9.c, new e()) == true) goto L26;
        L15:
            if (Intrinsics.areEqual(r9.b, new e()) == false) goto L16;
            r4 = false;
            goto L18
        L6:
            if (Intrinsics.areEqual(r9.a, new e()) == false) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<d> serializer() {
            return a.a;
        }
    }

    static {
        Companion = new b();
    }

    public d() {
        this.a = new e();
        this.b = new e();
        this.c = new e();
    }

    public d(int r2, e r3, e r4, e r5) {
        if ((r2 & 0) == 0) goto L5;
        b2.b(r2, 0, a.b);
        throw null;
    L5:
        if ((r2 & 1) != 0) goto L7;
        r3 = new e();
    L7:
        this.a = r3;
        if ((r2 & 2) != 0) goto L10;
        this.b = new e();
    L12:
        if ((r2 & 4) != 0) goto L14;
        this.c = new e();
        return;
    L14:
        this.c = r5;
        return;
    L10:
        this.b = r4;
        goto L12
    }
}
