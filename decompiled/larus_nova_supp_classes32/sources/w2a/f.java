package w2a;

import com.larus.im.bean.bot.MixVoice;
import com.lynx.tasm.event.LynxTouchEvent;
import java.util.List;
import juc.n;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.l0;
import nuc.m0;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Serializable
public final class f {
    public static final b Companion = null;
    public static final Lazy<juc.d<Object>>[] k = null;
    public final List<MixVoice> a;
    public final int b;
    public final int c;
    public final float d;
    public final float e;
    public final String f;
    public final String g;
    public final String h;
    public final Integer i;
    public final String j;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<f> {
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
            g2 r1 = new g2("com.larus.voice_setting.voice.mix.res.VoiceEditInfo", r0, 10);
            r1.j("mix_list", true);
            r1.j("pitch", true);
            r1.j("rate", true);
            r1.j("pitch_f64", true);
            r1.j("speech_rate_f64", true);
            r1.j("style_id", true);
            r1.j("preview_url", true);
            r1.j("added_voice_tab_name", true);
            r1.j("single_select_click_position", true);
            r1.j("enter_method", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            w0 r0 = w0.a;
            l0 r2 = l0.a;
            v2 r3 = v2.a;
            return new juc.d[]{kuc.a.d((juc.d) f.k[0].getValue()), r0, r0, r2, r2, kuc.a.d(r3), kuc.a.d(r3), kuc.a.d(r3), kuc.a.d(r0), kuc.a.d(r3)};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r25) {
            Intrinsics.checkNotNullParameter(r25, "decoder");
            g2 r1 = b;
            muc.c r0 = r25.beginStructure(r1);
            Lazy<juc.d<Object>>[] r2 = f.k;
            int r4 = 8;
            int r8 = 7;
            int r13 = 0;
            if (r0.decodeSequentially() == false) goto L5;
            List r3 = (List) r0.decodeNullableSerializableElement(r1, 0, (juc.c) r2[0].getValue(), null);
            int r5 = r0.decodeIntElement(r1, 1);
            int r10 = r0.decodeIntElement(r1, 2);
            float r6 = r0.decodeFloatElement(r1, 3);
            float r11 = r0.decodeFloatElement(r1, 4);
            v2 r12 = v2.a;
            String r7 = (String) r0.decodeNullableSerializableElement(r1, 5, r12, null);
            String r9 = (String) r0.decodeNullableSerializableElement(r1, 6, r12, null);
            String r14 = (String) r0.decodeNullableSerializableElement(r1, 7, r12, null);
            Integer r18 = (Integer) r0.decodeNullableSerializableElement(r1, 8, w0.a, null);
            float r15 = r6;
            String r16 = r7;
            String r17 = r9;
            String r19 = r14;
            String r110 = (String) r0.decodeNullableSerializableElement(r1, 9, r12, null);
            int r111 = r10;
            float r112 = r11;
            int r20 = 1023;
            List r113 = r3;
            int r114 = r5;
        L31:
            r0.endStructure(r1);
            return new f(r20, r113, r114, r111, r15, r112, r16, r17, r19, r18, r110);
        L5:
            String r21 = null;
            String r22 = null;
            Integer r115 = null;
            String r116 = null;
            String r117 = null;
            List r118 = null;
            int r23 = 0;
            float r119 = 0.0f;
            int r120 = 0;
            float r121 = 0.0f;
            boolean r24 = true;
        L6:
            if (r24 == false) goto L30;
            int r26 = r0.decodeElementIndex(r1);
            switch(r26) {
                case -1: goto L29;
                case 0: goto L27;
                case 1: goto L24;
                case 2: goto L22;
                case 3: goto L21;
                case 4: goto L19;
                case 5: goto L17;
                case 6: goto L16;
                case 7: goto L14;
                case 8: goto L12;
                case 9: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r26);
        L29:
            r4 = 8;
            r8 = 7;
            r24 = false;
            goto L6
        L11:
            r21 = (String) r0.decodeNullableSerializableElement(r1, 9, v2.a, r21);
            int r27 = r13 | 512;
        L13:
            r13 = r27;
        L28:
            r4 = 8;
            r8 = 7;
            goto L6
        L12:
            r115 = (Integer) r0.decodeNullableSerializableElement(r1, r4, w0.a, r115);
            r27 = r13 | 256;
            goto L13
        L14:
            r116 = (String) r0.decodeNullableSerializableElement(r1, r8, v2.a, r116);
            r13 = r13 | LynxTouchEvent.kPseudoStateFocusTransition;
        L25:
            r23 = r23;
            goto L28
        L16:
            r22 = (String) r0.decodeNullableSerializableElement(r1, 6, v2.a, r22);
            r13 = r13 | 64;
            goto L25
        L17:
            r117 = (String) r0.decodeNullableSerializableElement(r1, 5, v2.a, r117);
            r13 = r13 | 32;
            goto L25
        L19:
            r121 = r0.decodeFloatElement(r1, 4);
            r13 = r13 | 16;
            goto L25
        L21:
            r13 = r13 | 8;
            r119 = r0.decodeFloatElement(r1, 3);
            int r28 = r120;
        L23:
            r120 = r28;
            r23 = r23;
            goto L25
        L22:
            r28 = r0.decodeIntElement(r1, 2);
            r13 = r13 | 4;
            goto L23
        L24:
            r23 = r0.decodeIntElement(r1, 1);
            r13 = r13 | 2;
            goto L25
        L27:
            r118 = (List) r0.decodeNullableSerializableElement(r1, 0, (juc.c) r2[0].getValue(), r118);
            r13 = r13 | 1;
            goto L28
        L30:
            List r29 = r118;
            r110 = r21;
            r18 = r115;
            r19 = r116;
            r20 = r13;
            r15 = r119;
            r112 = r121;
            r114 = r23;
            r17 = r22;
            r113 = r29;
            int r210 = r120;
            r16 = r117;
            r111 = r210;
            goto L31
        }

        public final void serialize(muc.f r7, Object r8) {
            f r9 = (f) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = f.k;
            boolean r2 = false;
            if (r10.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r10.encodeNullableSerializableElement(r0, 0, (n) r1[0].getValue(), r9.a);
        L12:
            if (r10.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r10.encodeIntElement(r0, 1, r9.b);
        L21:
            if (r10.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            boolean r5 = true;
        L27:
            if (r5 == false) goto L30;
            r10.encodeIntElement(r0, 2, r9.c);
        L30:
            if (r10.shouldEncodeElementDefault(r0, 3) == false) goto L33;
        L34:
            boolean r6 = true;
        L36:
            if (r6 == false) goto L39;
            r10.encodeFloatElement(r0, 3, r9.d);
        L39:
            if (r10.shouldEncodeElementDefault(r0, 4) == false) goto L42;
        L43:
            boolean r11 = true;
        L45:
            if (r11 == false) goto L48;
            r10.encodeFloatElement(r0, 4, r9.e);
        L48:
            if (r10.shouldEncodeElementDefault(r0, 5) == false) goto L51;
        L52:
            boolean r12 = true;
        L54:
            if (r12 == false) goto L57;
            r10.encodeNullableSerializableElement(r0, 5, v2.a, r9.f);
        L57:
            if (r10.shouldEncodeElementDefault(r0, 6) == false) goto L60;
        L61:
            boolean r13 = true;
        L63:
            if (r13 == false) goto L66;
            r10.encodeNullableSerializableElement(r0, 6, v2.a, r9.g);
        L66:
            if (r10.shouldEncodeElementDefault(r0, 7) == false) goto L69;
        L70:
            boolean r14 = true;
        L72:
            if (r14 == false) goto L75;
            r10.encodeNullableSerializableElement(r0, 7, v2.a, r9.h);
        L75:
            if (r10.shouldEncodeElementDefault(r0, 8) == false) goto L78;
        L79:
            boolean r15 = true;
        L81:
            if (r15 == false) goto L84;
            r10.encodeNullableSerializableElement(r0, 8, w0.a, r9.i);
        L84:
            if (r10.shouldEncodeElementDefault(r0, 9) == false) goto L87;
        L88:
            r2 = true;
        L89:
            if (r2 == false) goto L91;
            r10.encodeNullableSerializableElement(r0, 9, v2.a, r9.j);
        L91:
            r10.endStructure(r0);
            return;
        L87:
            if (r9.j == null) goto L89;
        L78:
            if (r9.i != null) goto L79;
            r15 = false;
            goto L81
        L69:
            if (r9.h != null) goto L70;
            r14 = false;
            goto L72
        L60:
            if (r9.g != null) goto L61;
            r13 = false;
            goto L63
        L51:
            if (r9.f != null) goto L52;
            r12 = false;
            goto L54
        L42:
            if (Float.compare(r9.e, 10.0f) != 0) goto L43;
            r11 = false;
            goto L45
        L33:
            if (Float.compare(r9.d, 0.0f) != 0) goto L34;
            r6 = false;
            goto L36
        L24:
            if (r9.c != 10) goto L25;
            r5 = false;
            goto L27
        L15:
            if (r9.b != 0) goto L16;
            r4 = false;
            goto L18
        L6:
            if (r9.a != null) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<f> serializer() {
            return a.a;
        }
    }

    public f() {
        this(null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, 1023);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Float.compare(this.d, r6.d) == 0) goto L21;
        return false;
    L21:
        if (Float.compare(this.e, r6.e) == 0) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        List<MixVoice> r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((((((((r2 * 31) + this.b) * 31) + this.c) * 31) + Float.floatToIntBits(this.d)) * 31) + Float.floatToIntBits(this.e)) * 31;
        String r4 = this.f;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.g;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.h;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.i;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.j;
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
        return "VoiceEditInfo(list=" + this.a + ", pitch=" + this.b + ", speechRate=" + this.c + ", pitchF64=" + this.d + ", speechRateF64=" + this.e + ", styleId=" + this.f + ", previewUrl=" + this.g + ", lastAddedVoiceTabName=" + this.h + ", clickPosition=" + this.i + ", enterMethod=" + this.j + ')';
    }

    static {
        Companion = new b();
        k = new Lazy[]{LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new e()), null, null, null, null, null, null, null, null, null};
    }

    public f(int r4, List r5, int r6, int r7, float r8, float r9, String r10, String r11, String r12, Integer r13, String r14) {
        if ((r4 & 0) == 0) goto L5;
        b2.b(r4, 0, a.b);
        throw null;
    L5:
        if ((r4 & 1) != 0) goto L7;
        this.a = null;
    L9:
        if ((r4 & 2) != 0) goto L11;
        this.b = 0;
    L13:
        if ((r4 & 4) != 0) goto L15;
        this.c = 10;
    L17:
        if ((r4 & 8) != 0) goto L19;
        this.d = 0.0f;
    L21:
        if ((r4 & 16) != 0) goto L23;
        this.e = 10.0f;
    L25:
        if ((r4 & 32) != 0) goto L27;
        this.f = null;
    L29:
        if ((r4 & 64) != 0) goto L31;
        this.g = null;
    L33:
        if ((r4 & LynxTouchEvent.kPseudoStateFocusTransition) != 0) goto L35;
        this.h = null;
    L37:
        if ((r4 & 256) != 0) goto L39;
        this.i = null;
    L41:
        if ((r4 & 512) != 0) goto L43;
        this.j = null;
        return;
    L43:
        this.j = r14;
        return;
    L39:
        this.i = r13;
        goto L41
    L35:
        this.h = r12;
        goto L37
    L31:
        this.g = r11;
        goto L33
    L27:
        this.f = r10;
        goto L29
    L23:
        this.e = r9;
        goto L25
    L19:
        this.d = r8;
        goto L21
    L15:
        this.c = r7;
        goto L17
    L11:
        this.b = r6;
        goto L13
    L7:
        this.a = r5;
        goto L9
    }

    public f(List r3, int r4, int r5, float r6, float r7, String r8, String r9, String r10, Integer r11, String r12, int r13) {
        if ((r13 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r5 = 10;
    L12:
        if ((r13 & 8) == 0) goto L15;
        r6 = 0.0f;
    L15:
        if ((r13 & 16) == 0) goto L18;
        r7 = 10.0f;
    L18:
        if ((r13 & 32) == 0) goto L21;
        r8 = null;
    L21:
        if ((r13 & 64) == 0) goto L24;
        r9 = null;
    L24:
        if ((r13 & LynxTouchEvent.kPseudoStateFocusTransition) == 0) goto L27;
        r10 = null;
    L27:
        if ((r13 & 256) == 0) goto L30;
        r11 = null;
    L30:
        if ((r13 & 512) == 0) goto L32;
        r12 = null;
    L32:
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
    }
}
