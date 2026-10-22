package vi8;

import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.e;
import nuc.b2;
import nuc.g1;
import nuc.g2;
import nuc.i;
import nuc.i2;
import nuc.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Serializable
public final class a {
    public static final b Companion = null;
    public final long a;
    public final boolean b;
    public final boolean c;

    /* JADX INFO: renamed from: vi8.a$a, reason: collision with other inner class name */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class C0089a implements m0<a> {
        public static final C0089a a = null;
        public static final g2 b = null;

        public C0089a() {
        }

        public final d<?>[] childSerializers() {
            i r1 = i.a;
            return new d[]{g1.a, r1, r1};
        }

        public final f getDescriptor() {
            return b;
        }

        static {
            C0089a r0 = new C0089a();
            a = r0;
            g2 r1 = new g2("com.larus.bmhome.chat.servicebot.ServiceBotConfig", r0, 3);
            r1.j("timestamp_interval", true);
            r1.j("enable_service_bot", true);
            r1.j("enable_service_bot_on_oversea", true);
            b = r1;
        }

        public final d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r18) {
            Intrinsics.checkNotNullParameter(r18, "decoder");
            g2 r1 = b;
            muc.c r0 = r18.beginStructure(r1);
            if (r0.decodeSequentially() == false) goto L5;
            long r5 = r0.decodeLongElement(r1, 0);
            boolean r15 = r0.decodeBooleanElement(r1, 1);
            boolean r16 = r0.decodeBooleanElement(r1, 2);
            long r13 = r5;
            int r12 = 7;
        L19:
            r0.endStructure(r1);
            return new a(r12, r13, r15, r16);
        L5:
            long r8 = 0;
            boolean r2 = false;
            boolean r6 = false;
            int r7 = 0;
            boolean r10 = true;
        L6:
            if (r10 == false) goto L18;
            int r11 = r0.decodeElementIndex(r1);
            if (r11 != (-1)) goto L9;
            r10 = false;
            goto L6
        L9:
            if (r11 != 0) goto L10;
            r8 = r0.decodeLongElement(r1, 0);
            r7 = r7 | 1;
            goto L6
        L10:
            if (r11 != 1) goto L11;
            r2 = r0.decodeBooleanElement(r1, 1);
            r7 = r7 | 2;
            goto L6
        L11:
            if (r11 != 2) goto L14;
            r6 = r0.decodeBooleanElement(r1, 2);
            r7 = r7 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r11);
        L18:
            r15 = r2;
            r16 = r6;
            r12 = r7;
            r13 = r8;
            goto L19
        }

        public final void serialize(muc.f r9, Object r10) {
            a r11 = (a) r10;
            Intrinsics.checkNotNullParameter(r9, "encoder");
            Intrinsics.checkNotNullParameter(r11, "value");
            g2 r0 = b;
            muc.d r12 = r9.beginStructure(r0);
            b r1 = a.Companion;
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
            r12.encodeBooleanElement(r0, 1, r11.b);
        L21:
            if (r12.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            r2 = true;
        L26:
            if (r2 == false) goto L28;
            r12.encodeBooleanElement(r0, 2, r11.c);
        L28:
            r12.endStructure(r0);
            return;
        L24:
            if (r11.c == false) goto L26;
        L15:
            if (r11.b == true) goto L16;
            r4 = false;
            goto L18
        L6:
            if (r11.a != 3600) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final d<a> serializer() {
            return C0089a.a;
        }
    }

    public a() {
        this(0);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r9 = (a) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        int r2 = 1231;
        if (this.b == false) goto L5;
        int r3 = 1231;
    L6:
        int r4 = (r1 + r3) * 31;
        if (this.c == true) goto L11;
        r2 = 1237;
    L11:
        return r4 + r2;
    L5:
        r3 = 1237;
        goto L6
    }

    public final String toString() {
        return "ServiceBotConfig(timestampInterval=" + this.a + ", enableServiceBot=" + this.b + ", enableServiceBotOnOversea=" + this.c + ')';
    }

    static {
        Companion = new b();
    }

    public a(int r3) {
        this.a = 3600;
        this.b = false;
        this.c = false;
    }

    public a(int r3, long r4, boolean r6, boolean r7) {
        if ((r3 & 0) == 0) goto L5;
        b2.b(r3, 0, C0089a.b);
        throw null;
    L5:
        if ((r3 & 1) != 0) goto L7;
        r4 = 3600;
    L7:
        this.a = r4;
        if ((r3 & 2) != 0) goto L10;
        this.b = false;
    L12:
        if ((r3 & 4) != 0) goto L14;
        this.c = false;
        return;
    L14:
        this.c = r7;
        return;
    L10:
        this.b = r6;
        goto L12
    }
}
