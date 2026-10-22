package wp8;

import com.larus.bmhome.music.applet.MusicAppletPage;
import java.util.Map;
import juc.n;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.c;
import muc.e;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Serializable
public final class b {
    public static final C0139b Companion = null;
    public static final Lazy<juc.d<Object>>[] g = null;
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final Map<Integer, Integer> e;
    public final String f;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<b> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.bmhome.instruction.core.api.ActionBarConfRequestBody", r0, 6);
            r1.j("language_code", false);
            r1.j("bot_id", false);
            r1.j(MusicAppletPage.KEY_CONVERSATION_ID, false);
            r1.j("page_scene", true);
            r1.j("instruction_code_version", true);
            r1.j("through_token", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r0 = b.g;
            v2 r2 = v2.a;
            return new juc.d[]{r2, r2, r2, kuc.a.d(r2), kuc.a.d((juc.d) r0[4].getValue()), kuc.a.d(r2)};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r20) {
            Intrinsics.checkNotNullParameter(r20, "decoder");
            g2 r1 = b;
            c r0 = r20.beginStructure(r1);
            Lazy<juc.d<Object>>[] r2 = b.g;
            String r10 = null;
            if (r0.decodeSequentially() == false) goto L5;
            String r3 = r0.decodeStringElement(r1, 0);
            String r6 = r0.decodeStringElement(r1, 1);
            String r5 = r0.decodeStringElement(r1, 2);
            v2 r7 = v2.a;
            String r9 = (String) r0.decodeNullableSerializableElement(r1, 3, r7, null);
            Map r14 = (Map) r0.decodeNullableSerializableElement(r1, 4, (juc.c) r2[4].getValue(), null);
            r10 = r3;
            String r15 = (String) r0.decodeNullableSerializableElement(r1, 5, r7, null);
            String r12 = r5;
            String r11 = r6;
            String r13 = r9;
            int r16 = 63;
        L20:
            r0.endStructure(r1);
            return new b(r16, r10, r11, r12, r13, r14, r15);
        L5:
            Map r17 = null;
            String r18 = null;
            String r19 = null;
            String r110 = null;
            String r111 = null;
            int r4 = 0;
            boolean r112 = true;
        L6:
            if (r112 == false) goto L19;
            int r8 = r0.decodeElementIndex(r1);
            switch(r8) {
                case -1: goto L18;
                case 0: goto L17;
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r8);
        L17:
            r10 = r0.decodeStringElement(r1, 0);
            r4 = r4 | 1;
            goto L6
        L18:
            r112 = false;
            goto L6
        L11:
            r4 = r4 | 32;
            r19 = (String) r0.decodeNullableSerializableElement(r1, 5, v2.a, r19);
            goto L6
        L12:
            r4 = r4 | 16;
            r17 = (Map) r0.decodeNullableSerializableElement(r1, 4, (juc.c) r2[4].getValue(), r17);
            goto L6
        L13:
            r4 = r4 | 8;
            r111 = (String) r0.decodeNullableSerializableElement(r1, 3, v2.a, r111);
            goto L6
        L14:
            r4 = r4 | 4;
            r110 = r0.decodeStringElement(r1, 2);
            goto L6
        L15:
            r4 = r4 | 2;
            r18 = r0.decodeStringElement(r1, 1);
            goto L6
        L19:
            r16 = r4;
            String r113 = r110;
            r14 = r17;
            r11 = r18;
            r12 = r113;
            String r114 = r111;
            r15 = r19;
            r13 = r114;
            goto L20
        }

        public final void serialize(muc.f r8, Object r9) {
            b r10 = (b) r9;
            Intrinsics.checkNotNullParameter(r8, "encoder");
            Intrinsics.checkNotNullParameter(r10, "value");
            g2 r0 = b;
            muc.d r11 = r8.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = b.g;
            boolean r3 = false;
            r11.encodeStringElement(r0, 0, r10.a);
            r11.encodeStringElement(r0, 1, r10.b);
            r11.encodeStringElement(r0, 2, r10.c);
            if (r11.shouldEncodeElementDefault(r0, 3) == false) goto L6;
        L7:
            boolean r5 = true;
        L9:
            if (r5 == false) goto L12;
            r11.encodeNullableSerializableElement(r0, 3, v2.a, r10.d);
        L12:
            if (r11.shouldEncodeElementDefault(r0, 4) == false) goto L15;
        L16:
            boolean r6 = true;
        L18:
            if (r6 == false) goto L21;
            r11.encodeNullableSerializableElement(r0, 4, (n) r1[4].getValue(), r10.e);
        L21:
            if (r11.shouldEncodeElementDefault(r0, 5) == false) goto L24;
        L25:
            r3 = true;
        L26:
            if (r3 == false) goto L28;
            r11.encodeNullableSerializableElement(r0, 5, v2.a, r10.f);
        L28:
            r11.endStructure(r0);
            return;
        L24:
            if (r10.f == null) goto L26;
        L15:
            if (r10.e != null) goto L16;
            r6 = false;
            goto L18
        L6:
            if (r10.d != null) goto L7;
            r5 = false;
            goto L9
        }
    }

    /* JADX INFO: renamed from: wp8.b$b, reason: collision with other inner class name */
    public static final class C0139b {
        public C0139b() {
        }

        public final juc.d<b> serializer() {
            return a.a;
        }
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
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        String r1 = this.d;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Map<Integer, Integer> r5 = this.e;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.f;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "ActionBarConfRequestBody(languageCode=" + this.a + ", botId=" + this.b + ", conversationId=" + this.c + ", pageScene=" + this.d + ", instructionCodeVersion=" + this.e + ", throughToken=" + this.f + ')';
    }

    static {
        Companion = new C0139b();
        g = new Lazy[]{null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new wp8.a()), null};
    }

    public b(int r4, String r5, String r6, String r7, String r8, Map r9, String r10) {
        if (7 != (r4 & 7)) goto L17;
        this.a = r5;
        this.b = r6;
        this.c = r7;
        if ((r4 & 8) != 0) goto L7;
        this.d = null;
    L9:
        if ((r4 & 16) != 0) goto L11;
        this.e = null;
    L13:
        if ((r4 & 32) != 0) goto L15;
        this.f = null;
        return;
    L15:
        this.f = r10;
        return;
    L11:
        this.e = r9;
        goto L13
    L7:
        this.d = r8;
        goto L9
    L17:
        b2.b(r4, 7, a.b);
        throw null;
    }
}
