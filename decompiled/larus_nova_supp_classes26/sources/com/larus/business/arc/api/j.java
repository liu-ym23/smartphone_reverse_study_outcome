package com.larus.business.arc.api;

import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import java.util.List;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Serializable
public final class j {
    public static final b Companion = null;
    public static final Lazy<juc.d<Object>>[] d = null;
    public final ArcBizStatus a;
    public final ArcFrameworkFailure b;
    public final String c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<j> {
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
            g2 r1 = new g2("com.larus.business.arc.api.ArcCallOutcome", r0, 3);
            r1.j("bizStatus", false);
            r1.j("failureCode", true);
            r1.j("bizCode", true);
            b = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r0 = j.d;
            return new juc.d[]{r0[0].getValue(), r0[1].getValue(), v2.a};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r13) {
            Intrinsics.checkNotNullParameter(r13, "decoder");
            g2 r0 = b;
            muc.c r14 = r13.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = j.d;
            ArcBizStatus r6 = null;
            if (r14.decodeSequentially() == false) goto L5;
            ArcBizStatus r2 = (ArcBizStatus) r14.decodeSerializableElement(r0, 0, (juc.c) r1[0].getValue(), null);
            ArcFrameworkFailure r3 = (ArcFrameworkFailure) r14.decodeSerializableElement(r0, 1, (juc.c) r1[1].getValue(), null);
            String r4 = r14.decodeStringElement(r0, 2);
            int r5 = 7;
        L19:
            r14.endStructure(r0);
            return new j(r5, r2, r3, r4);
        L5:
            ArcFrameworkFailure r7 = null;
            String r8 = null;
            int r9 = 0;
            boolean r10 = true;
        L6:
            if (r10 == false) goto L18;
            int r11 = r14.decodeElementIndex(r0);
            if (r11 != (-1)) goto L9;
            r10 = false;
            goto L6
        L9:
            if (r11 != 0) goto L10;
            r6 = (ArcBizStatus) r14.decodeSerializableElement(r0, 0, (juc.c) r1[0].getValue(), r6);
            r9 = r9 | 1;
            goto L6
        L10:
            if (r11 != 1) goto L11;
            r7 = (ArcFrameworkFailure) r14.decodeSerializableElement(r0, 1, (juc.c) r1[1].getValue(), r7);
            r9 = r9 | 2;
            goto L6
        L11:
            if (r11 != 2) goto L14;
            r8 = r14.decodeStringElement(r0, 2);
            r9 = r9 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r11);
        L18:
            r5 = r9;
            r2 = r6;
            r3 = r7;
            r4 = r8;
            goto L19
        }

        public final void serialize(muc.f r7, Object r8) {
            j r9 = (j) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = j.d;
            boolean r2 = false;
            r10.encodeSerializableElement(r0, 0, (juc.n) r1[0].getValue(), r9.a);
            if (r10.shouldEncodeElementDefault(r0, 1) == false) goto L6;
        L7:
            boolean r4 = true;
        L9:
            if (r4 == false) goto L12;
            r10.encodeSerializableElement(r0, 1, (juc.n) r1[1].getValue(), r9.b);
        L12:
            if (r10.shouldEncodeElementDefault(r0, 2) == false) goto L15;
        L16:
            r2 = true;
        L17:
            if (r2 == false) goto L19;
            r10.encodeStringElement(r0, 2, r9.c);
        L19:
            r10.endStructure(r0);
            return;
        L15:
            if (Intrinsics.areEqual(r9.c, TriggerSendLoading.NO_LOADING) == true) goto L17;
        L6:
            if (r9.b != ArcFrameworkFailure.NONE) goto L7;
            r4 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<j> serializer() {
            return a.a;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ArcStage.values().length];
            r0[ArcStage.PREPARE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ArcStage.EXECUTE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ArcStage.FINALIZE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof j) == true) goto L8;
        return false;
    L8:
        j r6 = (j) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "ArcCallOutcome(bizStatus=" + this.a + ", failureCode=" + this.b + ", bizCode=" + this.c + ')';
    }

    static {
        Companion = new b();
        LazyThreadSafetyMode r1 = LazyThreadSafetyMode.PUBLICATION;
        d = new Lazy[]{LazyKt.lazy(r1, new h()), LazyKt.lazy(r1, new i()), null};
    }

    public final j b() {
        ArcStage r1 = this.b.getStage();
        if (r1 != null) goto L5;
        int r2 = -1;
    L6:
        String r4 = TriggerSendLoading.NO_LOADING;
        if (r2 == (-1)) goto L16;
        if (r2 == 1) goto L265;
        if (r2 == 2) goto L264;
        if (r2 == 3) goto L16;
        throw new NoWhenBranchMatchedException();
    L264:
        return a(this, ArcBizStatus.UNKNOWN, TriggerSendLoading.NO_LOADING, 2);
    L265:
        return a(this, ArcBizStatus.NOT_STARTED, TriggerSendLoading.NO_LOADING, 2);
    L16:
        List<String> r3 = p.a;
        String r5 = this.c;
        ArcBizStatus r6 = this.a;
        Intrinsics.checkNotNullParameter(r6, "status");
        if (r6 != ArcBizStatus.FAILED) goto L246;
        if (r5 != null) goto L22;
        r5 = "";
    L22:
        if (r5.length() > 256) goto L243;
        String r7 = StringsKt.trim(r5).toString();
        if (r7.length() != 0) goto L27;
        boolean r8 = true;
    L28:
        if (r8 == true) goto L246;
        if (Intrinsics.areEqual(r7, TriggerSendLoading.NO_LOADING) == true) goto L246;
        if (r7.length() > 64) goto L240;
        int r9 = 0;
    L36:
        if (r9 >= r7.length()) goto L67;
        char r10 = r7.charAt(r9);
        if ('a' > r10) goto L41;
        if (r10 >= '{') goto L41;
        boolean r16 = true;
    L42:
        if (r16 == true) goto L55;
        if ('A' > r10) goto L46;
        if (r10 >= '[') goto L46;
        boolean r17 = true;
    L47:
        if (r17 == true) goto L55;
        if ('0' > r10) goto L51;
        if (r10 >= ':') goto L51;
        boolean r18 = true;
    L52:
        if (r18 == true) goto L55;
        boolean r19 = false;
    L56:
        if (r19 == true) goto L63;
        if (r10 == '_') goto L63;
        if (r10 == '.') goto L63;
        if (r10 == ':') goto L63;
        if (r10 == '-') goto L63;
        boolean r11 = false;
    L64:
        if (r11 == false) goto L65;
        r9 = r9 + 1;
        goto L36
    L65:
        boolean r12 = false;
    L68:
        if (r12 == false) goto L240;
        if (p.h.matches(r7) == false) goto L73;
    L141:
        boolean r13 = true;
    L146:
        if (r13 == false) goto L148;
    L237:
        boolean r14 = true;
    L238:
        if (r14 == true) goto L240;
        boolean r15 = true;
    L241:
        if (r15 == false) goto L243;
    L244:
        r4 = r7;
        goto L246
    L148:
        if (p.b.matches(r7) == true) goto L237;
        if (p.c.matches(r7) == true) goto L237;
        if (p.d.matches(r7) == true) goto L237;
        if (p.e.matches(r7) == true) goto L237;
        if (p.i.containsMatchIn(r7) == true) goto L237;
        if (p.j.containsMatchIn(r7) == true) goto L237;
        if (p.k.contains(r7.toLowerCase(Locale.ROOT)) == true) goto L237;
        if (StringsKt.contains$default(r7, '@', false, 2, null) == true) goto L237;
        if (StringsKt.contains$default(r7, '/', false, 2, null) == true) goto L237;
        if (StringsKt.contains$default(r7, '\\', false, 2, null) == true) goto L237;
        int r20 = 0;
    L169:
        if (r20 >= r7.length()) goto L185;
        char r21 = r7.charAt(r20);
        if (r21 != '{') goto L173;
    L181:
        boolean r22 = true;
    L182:
        if (r22 == true) goto L183;
        r20 = r20 + 1;
        goto L169
    L183:
        boolean r23 = true;
    L186:
        if (r23 == true) goto L237;
        int r24 = 0;
        int r25 = 0;
    L189:
        if (r24 >= r7.length()) goto L198;
        if (r7.charAt(r24) != ':') goto L193;
        boolean r26 = true;
    L194:
        if (r26 == false) goto L196;
        r25 = r25 + 1;
    L196:
        r24 = r24 + 1;
        goto L189
    L193:
        r26 = false;
        goto L194
    L198:
        if (r25 < 2) goto L233;
        int r27 = 0;
    L201:
        if (r27 >= r7.length()) goto L230;
        char r28 = r7.charAt(r27);
        if ('a' <= r28) goto L205;
    L207:
        boolean r29 = false;
    L208:
        if (r29 == true) goto L226;
        if ('A' <= r28) goto L211;
    L213:
        boolean r30 = false;
    L214:
        if (r30 == true) goto L226;
        if ('0' > r28) goto L218;
        if (r28 >= ':') goto L218;
        boolean r31 = true;
    L219:
        if (r31 == true) goto L226;
        if (r28 == ':') goto L226;
        if (r28 == '.') goto L226;
        boolean r32 = false;
    L227:
        if (r32 == false) goto L228;
        r27 = r27 + 1;
        goto L201
    L228:
        boolean r33 = false;
    L231:
        if (r33 == false) goto L233;
        boolean r34 = true;
    L234:
        if (r34 == true) goto L237;
        r14 = false;
    L218:
        r31 = false;
        goto L219
    L211:
        if (r28 >= 'G') goto L213;
        r30 = true;
    L226:
        r32 = true;
        goto L227
    L205:
        if (r28 >= 'g') goto L207;
        r29 = true;
        goto L208
    L230:
        r33 = true;
    L233:
        r34 = false;
        goto L234
    L173:
        if (r21 == '}') goto L181;
        if (r21 == '[') goto L181;
        if (r21 == ']') goto L181;
        if (r21 == '\"') goto L181;
        r22 = false;
        goto L182
    L185:
        r23 = false;
        goto L186
    L73:
        if (r7.length() < 24) goto L78;
        if (p.f.matches(r7) == true) goto L141;
    L78:
        if (r7.length() < 24) goto L143;
        if (p.g.matches(r7) == false) goto L139;
        int r35 = 0;
    L84:
        if (r35 >= r7.length()) goto L93;
        char r36 = r7.charAt(r35);
        if ('a' > r36) goto L89;
        if (r36 >= '{') goto L89;
        boolean r37 = true;
    L90:
        if (r37 == true) goto L91;
        r35 = r35 + 1;
        goto L84
    L91:
        int r38 = 1;
    L94:
        int r39 = 0;
    L96:
        if (r39 >= r7.length()) goto L105;
        char r110 = r7.charAt(r39);
        if ('A' > r110) goto L101;
        if (r110 >= '[') goto L101;
        boolean r111 = true;
    L102:
        if (r111 == true) goto L103;
        r39 = r39 + 1;
        goto L96
    L103:
        boolean r40 = true;
    L106:
        if (r40 == false) goto L108;
        r38 = r38 + 1;
    L108:
        int r41 = 0;
    L110:
        if (r41 >= r7.length()) goto L119;
        char r112 = r7.charAt(r41);
        if ('0' > r112) goto L115;
        if (r112 >= ':') goto L115;
        boolean r113 = true;
    L116:
        if (r113 == true) goto L117;
        r41 = r41 + 1;
        goto L110
    L117:
        boolean r42 = true;
    L120:
        if (r42 == false) goto L122;
        r38 = r38 + 1;
    L122:
        int r43 = 0;
    L124:
        if (r43 >= r7.length()) goto L134;
        char r114 = r7.charAt(r43);
        if (r114 == '_') goto L130;
        if (r114 == '-') goto L130;
        boolean r115 = false;
    L131:
        if (r115 == true) goto L132;
        r43 = r43 + 1;
        goto L124
    L132:
        boolean r44 = true;
    L135:
        if (r44 == false) goto L137;
        r38 = r38 + 1;
    L137:
        if (r38 < 3) goto L139;
        boolean r45 = true;
    L140:
        if (r45 == false) goto L143;
    L130:
        r115 = true;
        goto L131
    L134:
        r44 = false;
    L115:
        r113 = false;
        goto L116
    L119:
        r42 = false;
    L101:
        r111 = false;
        goto L102
    L105:
        r40 = false;
    L89:
        r37 = false;
        goto L90
    L93:
        r38 = 0;
    L139:
        r45 = false;
    L143:
        if (r7.length() >= 32) goto L145;
        r13 = false;
        goto L146
    L145:
        r13 = p.g.matches(r7);
    L63:
        r11 = true;
    L51:
        r18 = false;
    L46:
        r17 = false;
    L55:
        r19 = true;
    L41:
        r16 = false;
        goto L42
    L67:
        r12 = true;
    L240:
        r15 = false;
        goto L241
    L27:
        r8 = false;
    L243:
        r7 = "UNCLASSIFIED";
    L246:
        return a(this, null, r4, 3);
    L5:
        r2 = c.a[r1.ordinal()];
        goto L6
    }

    public j(ArcBizStatus r2, ArcFrameworkFailure r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "bizStatus");
        Intrinsics.checkNotNullParameter(r3, "failureCode");
        Intrinsics.checkNotNullParameter(r4, "bizCode");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public j(int r3, ArcBizStatus r4, ArcFrameworkFailure r5, String r6) {
        if (1 != (r3 & 1)) goto L13;
        this.a = r4;
        if ((r3 & 2) != 0) goto L7;
        this.b = ArcFrameworkFailure.NONE;
    L9:
        if ((r3 & 4) != 0) goto L11;
        this.c = TriggerSendLoading.NO_LOADING;
        return;
    L11:
        this.c = r6;
        return;
    L7:
        this.b = r5;
        goto L9
    L13:
        b2.b(r3, 1, a.b);
        throw null;
    }

    public static j a(j r1, ArcBizStatus r2, String r3, int r4) {
        if ((r4 & 1) == 0) goto L6;
        r2 = r1.a;
    L6:
        if ((r4 & 2) == 0) goto L8;
        ArcFrameworkFailure r0 = r1.b;
    L10:
        if ((r4 & 4) == 0) goto L12;
        r3 = r1.c;
    L12:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "bizStatus");
        Intrinsics.checkNotNullParameter(r0, "failureCode");
        Intrinsics.checkNotNullParameter(r3, "bizCode");
        return new j(r2, r0, r3);
    L8:
        r0 = null;
        goto L10
    }
}
