package com.larus.avlink.activeSummary;

import com.larus.avlink.model.ProactiveSummaryScene;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g1;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Serializable
public final class f {
    public static final b Companion = null;
    public static final Lazy<juc.d<Object>>[] n = null;
    public final String a;
    public final Integer b;
    public final String c;
    public final com.larus.avlink.activeSummary.b d;
    public final Integer e;
    public final Boolean f;
    public final List<u> g;
    public final String h;
    public final String i;
    public final Map<String, String> j;
    public final String k;
    public final String l;
    public final Long m;

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
            g2 r1 = new g2("com.larus.avlink.activeSummary.ProactiveSummaryInfoResponse", r0, 13);
            r1.j("summary_id", true);
            r1.j("scene", true);
            r1.j("sub_scene", true);
            r1.j("occupy_avoid_conf", true);
            r1.j("proactive_methods", true);
            r1.j("skip_wakeup_hardware", true);
            r1.j("original_system_notification_list", true);
            r1.j("system_notify_version", true);
            r1.j("priority_broadcast_switch", true);
            r1.j("extra", true);
            r1.j("system_notification_id", true);
            r1.j("notification_id", true);
            r1.j("notification_timestamp", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r0 = f.n;
            v2 r2 = v2.a;
            w0 r3 = w0.a;
            return new juc.d[]{kuc.a.d(r2), kuc.a.d(r3), kuc.a.d(r2), kuc.a.d(com.larus.avlink.activeSummary.b.a.a), kuc.a.d(r3), kuc.a.d(nuc.i.a), kuc.a.d((juc.d) r0[6].getValue()), kuc.a.d(r2), kuc.a.d(r2), kuc.a.d((juc.d) r0[9].getValue()), kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(g1.a)};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r31) {
            Intrinsics.checkNotNullParameter(r31, "decoder");
            g2 r1 = b;
            muc.c r0 = r31.beginStructure(r1);
            Lazy<juc.d<Object>>[] r2 = f.n;
            int r14 = 8;
            String r5 = null;
            if (r0.decodeSequentially() == false) goto L5;
            v2 r3 = v2.a;
            String r15 = (String) r0.decodeNullableSerializableElement(r1, 0, r3, null);
            w0 r6 = w0.a;
            Integer r4 = (Integer) r0.decodeNullableSerializableElement(r1, 1, r6, null);
            String r12 = (String) r0.decodeNullableSerializableElement(r1, 2, r3, null);
            com.larus.avlink.activeSummary.b r7 = (com.larus.avlink.activeSummary.b) r0.decodeNullableSerializableElement(r1, 3, com.larus.avlink.activeSummary.b.a.a, null);
            Integer r8 = (Integer) r0.decodeNullableSerializableElement(r1, 4, r6, null);
            Boolean r9 = (Boolean) r0.decodeNullableSerializableElement(r1, 5, nuc.i.a, null);
            List r10 = (List) r0.decodeNullableSerializableElement(r1, 6, (juc.c) r2[6].getValue(), null);
            String r11 = (String) r0.decodeNullableSerializableElement(r1, 7, r3, null);
            String r13 = (String) r0.decodeNullableSerializableElement(r1, 8, r3, null);
            Map r16 = (Map) r0.decodeNullableSerializableElement(r1, 9, (juc.c) r2[9].getValue(), null);
            String r17 = (String) r0.decodeNullableSerializableElement(r1, 10, r3, null);
            Map r23 = r16;
            String r25 = (String) r0.decodeNullableSerializableElement(r1, 11, r3, null);
            Integer r19 = r4;
            Long r26 = (Long) r0.decodeNullableSerializableElement(r1, 12, g1.a, null);
            Integer r110 = r8;
            com.larus.avlink.activeSummary.b r111 = r7;
            List r20 = r10;
            Boolean r112 = r9;
            String r21 = r11;
            String r22 = r13;
            String r24 = r17;
            String r113 = r15;
            int r114 = 8191;
            String r115 = r12;
        L36:
            r0.endStructure(r1);
            return new f(r114, r113, r19, r115, r111, r110, r112, r20, r21, r22, r23, r24, r25, r26);
        L5:
            int r116 = 12;
            String r27 = null;
            String r29 = null;
            String r30 = null;
            com.larus.avlink.activeSummary.b r32 = null;
            Map r33 = null;
            String r117 = null;
            Long r118 = null;
            String r119 = null;
            Integer r210 = null;
            Integer r211 = null;
            List r212 = null;
            Boolean r213 = null;
            int r34 = 0;
            boolean r214 = true;
        L6:
            if (r214 == false) goto L35;
            int r120 = r0.decodeElementIndex(r1);
            switch(r120) {
                case -1: goto L32;
                case 0: goto L31;
                case 1: goto L29;
                case 2: goto L27;
                case 3: goto L26;
                case 4: goto L25;
                case 5: goto L24;
                case 6: goto L23;
                case 7: goto L19;
                case 8: goto L18;
                case 9: goto L15;
                case 10: goto L14;
                case 11: goto L13;
                case 12: goto L11;
                default: goto L10;
            };
        L11:
            r118 = (Long) r0.decodeNullableSerializableElement(r1, r116, g1.a, r118);
            r34 = r34 | 4096;
        L16:
            r2 = r2;
            r29 = r29;
            r211 = r211;
            List r121 = r212;
            Boolean r122 = r213;
        L28:
            Integer r123 = r211;
            r29 = r29;
        L30:
            r212 = r121;
            r213 = r122;
            r211 = r123;
        L34:
            r2 = r2;
            r14 = 8;
            r116 = 12;
            goto L6
        L13:
            r5 = (String) r0.decodeNullableSerializableElement(r1, 11, v2.a, r5);
            r34 = r34 | 2048;
            goto L16
        L14:
            r29 = (String) r0.decodeNullableSerializableElement(r1, 10, v2.a, r29);
            r34 = r34 | 1024;
            goto L16
        L15:
            r33 = (Map) r0.decodeNullableSerializableElement(r1, 9, (juc.c) r2[9].getValue(), r33);
            r34 = r34 | 512;
            goto L16
        L18:
            r117 = (String) r0.decodeNullableSerializableElement(r1, r14, v2.a, r117);
            r34 = r34 | 256;
        L20:
            r121 = r212;
        L21:
            r122 = r213;
            goto L28
        L19:
            r119 = (String) r0.decodeNullableSerializableElement(r1, 7, v2.a, r119);
            r34 = r34 | 128;
            goto L20
        L23:
            r212 = (List) r0.decodeNullableSerializableElement(r1, 6, (juc.c) r2[6].getValue(), r212);
            r34 = r34 | 64;
            goto L20
        L24:
            r121 = r212;
            r213 = (Boolean) r0.decodeNullableSerializableElement(r1, 5, nuc.i.a, r213);
            r34 = r34 | 32;
            goto L21
        L25:
            r2 = r2;
            r121 = r212;
            r122 = r213;
            r29 = r29;
            r34 = r34 | 16;
            r211 = (Integer) r0.decodeNullableSerializableElement(r1, 4, w0.a, r211);
            goto L28
        L26:
            r2 = r2;
            r29 = r29;
            r211 = r211;
            r121 = r212;
            r122 = r213;
            r32 = (com.larus.avlink.activeSummary.b) r0.decodeNullableSerializableElement(r1, 3, com.larus.avlink.activeSummary.b.a.a, r32);
            r34 = r34 | 8;
            goto L28
        L27:
            r2 = r2;
            r29 = r29;
            r211 = r211;
            r121 = r212;
            r122 = r213;
            r27 = (String) r0.decodeNullableSerializableElement(r1, 2, v2.a, r27);
            r34 = r34 | 4;
            goto L28
        L29:
            r2 = r2;
            r121 = r212;
            r122 = r213;
            r123 = r211;
            r34 = r34 | 2;
            r210 = (Integer) r0.decodeNullableSerializableElement(r1, 1, w0.a, r210);
            r29 = r29;
            goto L30
        L31:
            r30 = (String) r0.decodeNullableSerializableElement(r1, 0, v2.a, r30);
            r34 = r34 | 1;
        L33:
            r210 = r210;
            r212 = r212;
            r213 = r213;
            r211 = r211;
            r29 = r29;
            goto L34
        L32:
            r214 = false;
            goto L33
        L10:
            throw new UnknownFieldException(r120);
        L35:
            String r215 = r29;
            Integer r35 = r210;
            List r124 = r212;
            r115 = r27;
            r25 = r5;
            r111 = r32;
            r22 = r117;
            r26 = r118;
            r21 = r119;
            r20 = r124;
            r110 = r211;
            r24 = r215;
            r113 = r30;
            r114 = r34;
            r23 = r33;
            r112 = r213;
            r19 = r35;
            goto L36
        }

        public final void serialize(muc.f r9, Object r10) {
            f r11 = (f) r10;
            Intrinsics.checkNotNullParameter(r9, "encoder");
            Intrinsics.checkNotNullParameter(r11, "value");
            g2 r0 = b;
            muc.d r12 = r9.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = f.n;
            boolean r2 = false;
            if (r12.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r12.encodeNullableSerializableElement(r0, 0, v2.a, r11.a);
        L12:
            if (r12.shouldEncodeElementDefault(r0, 1) == true) goto L19;
            Integer r4 = r11.b;
            if (r4 == null) goto L19;
            if (r4.intValue() != 0) goto L19;
            boolean r5 = false;
        L21:
            if (r5 == false) goto L24;
            r12.encodeNullableSerializableElement(r0, 1, w0.a, r11.b);
        L24:
            if (r12.shouldEncodeElementDefault(r0, 2) == false) goto L27;
        L28:
            boolean r6 = true;
        L30:
            if (r6 == false) goto L33;
            r12.encodeNullableSerializableElement(r0, 2, v2.a, r11.c);
        L33:
            if (r12.shouldEncodeElementDefault(r0, 3) == false) goto L36;
        L37:
            boolean r7 = true;
        L39:
            if (r7 == false) goto L42;
            r12.encodeNullableSerializableElement(r0, 3, com.larus.avlink.activeSummary.b.a.a, r11.d);
        L42:
            if (r12.shouldEncodeElementDefault(r0, 4) == false) goto L45;
        L46:
            boolean r8 = true;
        L48:
            if (r8 == false) goto L51;
            r12.encodeNullableSerializableElement(r0, 4, w0.a, r11.e);
        L51:
            if (r12.shouldEncodeElementDefault(r0, 5) == false) goto L54;
        L55:
            boolean r13 = true;
        L57:
            if (r13 == false) goto L60;
            r12.encodeNullableSerializableElement(r0, 5, nuc.i.a, r11.f);
        L60:
            if (r12.shouldEncodeElementDefault(r0, 6) == false) goto L63;
        L64:
            boolean r14 = true;
        L66:
            if (r14 == false) goto L69;
            r12.encodeNullableSerializableElement(r0, 6, (juc.n) r1[6].getValue(), r11.g);
        L69:
            if (r12.shouldEncodeElementDefault(r0, 7) == false) goto L72;
        L73:
            boolean r15 = true;
        L75:
            if (r15 == false) goto L78;
            r12.encodeNullableSerializableElement(r0, 7, v2.a, r11.h);
        L78:
            if (r12.shouldEncodeElementDefault(r0, 8) == false) goto L81;
        L82:
            boolean r16 = true;
        L84:
            if (r16 == false) goto L87;
            r12.encodeNullableSerializableElement(r0, 8, v2.a, r11.i);
        L87:
            if (r12.shouldEncodeElementDefault(r0, 9) == false) goto L90;
        L91:
            boolean r17 = true;
        L93:
            if (r17 == false) goto L96;
            r12.encodeNullableSerializableElement(r0, 9, (juc.n) r1[9].getValue(), r11.j);
        L96:
            if (r12.shouldEncodeElementDefault(r0, 10) == false) goto L99;
        L100:
            boolean r19 = true;
        L102:
            if (r19 == false) goto L105;
            r12.encodeNullableSerializableElement(r0, 10, v2.a, r11.k);
        L105:
            if (r12.shouldEncodeElementDefault(r0, 11) == false) goto L108;
        L109:
            boolean r20 = true;
        L111:
            if (r20 == false) goto L114;
            r12.encodeNullableSerializableElement(r0, 11, v2.a, r11.l);
        L114:
            if (r12.shouldEncodeElementDefault(r0, 12) == false) goto L117;
        L118:
            r2 = true;
        L119:
            if (r2 == false) goto L121;
            r12.encodeNullableSerializableElement(r0, 12, g1.a, r11.m);
        L121:
            r12.endStructure(r0);
            return;
        L117:
            if (r11.m == null) goto L119;
        L108:
            if (r11.l != null) goto L109;
            r20 = false;
            goto L111
        L99:
            if (r11.k != null) goto L100;
            r19 = false;
            goto L102
        L90:
            if (r11.j != null) goto L91;
            r17 = false;
            goto L93
        L81:
            if (r11.i != null) goto L82;
            r16 = false;
            goto L84
        L72:
            if (r11.h != null) goto L73;
            r15 = false;
            goto L75
        L63:
            if (r11.g != null) goto L64;
            r14 = false;
            goto L66
        L54:
            if (Intrinsics.areEqual(r11.f, Boolean.FALSE) == false) goto L55;
            r13 = false;
            goto L57
        L45:
            if (r11.e != null) goto L46;
            r8 = false;
            goto L48
        L36:
            if (Intrinsics.areEqual(r11.d, new com.larus.avlink.activeSummary.b(2)) == false) goto L37;
            r7 = false;
            goto L39
        L27:
            if (r11.c != null) goto L28;
            r6 = false;
        L19:
            r5 = true;
            goto L21
        L6:
            if (r11.a != null) goto L7;
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
        com.larus.avlink.activeSummary.b r1 = new com.larus.avlink.activeSummary.b(2);
        Boolean r2 = Boolean.FALSE;
        this.a = null;
        this.b = 0;
        this.c = null;
        this.d = r1;
        this.e = null;
        this.f = r2;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
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
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        com.larus.avlink.activeSummary.b r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Boolean r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r19 = (r15 + r17) * 31;
        List<u> r20 = this.g;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        String r23 = this.h;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (r22 + r24) * 31;
        String r26 = this.i;
        if (r26 != null) goto L37;
        int r27 = 0;
    L38:
        int r29 = (r25 + r27) * 31;
        Map<String, String> r30 = this.j;
        if (r30 != null) goto L41;
        int r31 = 0;
    L42:
        int r32 = (r29 + r31) * 31;
        String r33 = this.k;
        if (r33 != null) goto L45;
        int r34 = 0;
    L46:
        int r35 = (r32 + r34) * 31;
        String r36 = this.l;
        if (r36 != null) goto L49;
        int r37 = 0;
    L50:
        int r38 = (r35 + r37) * 31;
        Long r39 = this.m;
        if (r39 == null) goto L55;
        r1 = r39.hashCode();
    L55:
        return r38 + r1;
    L49:
        r37 = r36.hashCode();
        goto L50
    L45:
        r34 = r33.hashCode();
        goto L46
    L41:
        r31 = r30.hashCode();
        goto L42
    L37:
        r27 = r26.hashCode();
        goto L38
    L33:
        r24 = r23.hashCode();
        goto L34
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
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
        return "ProactiveSummaryInfoResponse(summaryId=" + this.a + ", scene=" + this.b + ", subScene=" + this.c + ", avoidConfig=" + this.d + ", proactiveMethods=" + this.e + ", skipWakeup=" + this.f + ", originalSystemNotificationList=" + this.g + ", systemNotifyVersion=" + this.h + ", priorityBroadcastSwitch=" + this.i + ", extra=" + this.j + ", systemNotificationId=" + this.k + ", notificationId=" + this.l + ", notificationTimestamp=" + this.m + ')';
    }

    static {
        Companion = new b();
        LazyThreadSafetyMode r1 = LazyThreadSafetyMode.PUBLICATION;
        n = new Lazy[]{null, null, null, null, null, null, LazyKt.lazy(r1, new d()), null, null, LazyKt.lazy(r1, new e()), null, null, null};
    }

    public final Long a() {
        List<u> r0 = this.g;
        if (r0 == null) goto L20;
        ArrayList r2 = new ArrayList();
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L14;
        u r3 = (u) r1.next();
        if (r3 == null) goto L10;
        Long r4 = r3.b;
    L11:
        if (r4 == null) goto L6;
        r2.add(r4);
        goto L6
    L10:
        r4 = null;
        goto L11
    L14:
        return (Long) CollectionsKt.minOrNull(r2);
    L20:
        return null;
    }

    public final String b() {
        Integer r0 = this.b;
        int r1 = ProactiveSummaryScene.SystemNotify.getValue();
        if (r0 != null) goto L6;
    L7:
        return null;
    L6:
        if (r0.intValue() != r1) goto L7;
        if (g() == false) goto L12;
        return "v3";
    L12:
        if (f() == false) goto L14;
        return "v2";
    L14:
        return "v1";
    }

    public final Long c() {
        String r0 = this.k;
        if (r0 != null) goto L6;
        r0 = this.l;
    L6:
        if (r0 == null) goto L27;
        List<u> r2 = this.g;
        if (r2 == null) goto L23;
        Iterator<T> r3 = r2.iterator();
    L11:
        if (r3.hasNext() == false) goto L19;
        Object r4 = r3.next();
        u r5 = (u) r4;
        if (r5 == null) goto L15;
        String r6 = r5.a;
    L17:
        if (Intrinsics.areEqual(r6, r0) == false) goto L11;
    L20:
        u r7 = (u) r4;
        if (r7 == null) goto L23;
        Long r1 = r7.b;
    L24:
        if (r1 == null) goto L27;
        return r1;
    L15:
        r6 = null;
        goto L17
    L19:
        r4 = null;
    L23:
        r1 = null;
    L27:
        List<u> r8 = this.g;
        if (r8 == null) goto L37;
        u r9 = (u) CollectionsKt.firstOrNull(r8);
        if (r9 != null) goto L32;
        return null;
    L32:
        return r9.b;
    L37:
        return null;
    }

    public final String d() {
        String r0 = this.k;
        if (r0 != null) goto L13;
        String r1 = this.l;
        if (r1 != null) goto L14;
        List<u> r2 = this.g;
        if (r2 == null) goto L11;
        u r3 = (u) CollectionsKt.firstOrNull(r2);
        if (r3 == null) goto L11;
        return r3.a;
    L11:
        return null;
    L14:
        return r1;
    L13:
        return r0;
    }

    public final boolean e() {
        Integer r0 = this.b;
        int r1 = ProactiveSummaryScene.DoraAutoGreet.getValue();
        if (r0 != null) goto L6;
    L8:
        return false;
    L6:
        if (r0.intValue() != r1) goto L8;
        return true;
    }

    public final boolean f() {
        Integer r0 = this.b;
        int r1 = ProactiveSummaryScene.SystemNotify.getValue();
        if (r0 != null) goto L6;
    L10:
        return false;
    L6:
        if (r0.intValue() != r1) goto L10;
        if (Intrinsics.areEqual(this.c, "system_notify_v2") == false) goto L10;
        return true;
    }

    public final boolean g() {
        Integer r0 = this.b;
        int r1 = ProactiveSummaryScene.SystemNotify.getValue();
        if (r0 != null) goto L6;
    L10:
        return false;
    L6:
        if (r0.intValue() != r1) goto L10;
        if (Intrinsics.areEqual(this.c, "system_notify_v3") == false) goto L10;
        return true;
    }

    public f(int r6, String r7, Integer r8, String r9, com.larus.avlink.activeSummary.b r10, Integer r11, Boolean r12, List r13, String r14, String r15, Map r16, String r17, String r19, Long r110) {
        if ((r6 & 0) == 0) goto L5;
        b2.b(r6, 0, a.b);
        throw null;
    L5:
        if ((r6 & 1) != 0) goto L7;
        this.a = null;
    L9:
        if ((r6 & 2) != 0) goto L11;
        Integer r2 = 0;
    L12:
        this.b = r2;
        if ((r6 & 4) != 0) goto L15;
        this.c = null;
    L17:
        if ((r6 & 8) != 0) goto L19;
        com.larus.avlink.activeSummary.b r3 = new com.larus.avlink.activeSummary.b(2);
    L20:
        this.d = r3;
        if ((r6 & 16) != 0) goto L23;
        this.e = null;
    L25:
        if ((r6 & 32) != 0) goto L27;
        Boolean r4 = Boolean.FALSE;
    L28:
        this.f = r4;
        if ((r6 & 64) != 0) goto L31;
        this.g = null;
    L33:
        if ((r6 & 128) != 0) goto L35;
        this.h = null;
    L37:
        if ((r6 & 256) != 0) goto L39;
        this.i = null;
    L41:
        if ((r6 & 512) != 0) goto L43;
        this.j = null;
    L45:
        if ((r6 & 1024) != 0) goto L47;
        this.k = null;
    L49:
        if ((r6 & 2048) != 0) goto L51;
        this.l = null;
    L53:
        if ((r6 & 4096) != 0) goto L55;
        this.m = null;
        return;
    L55:
        this.m = r110;
        return;
    L51:
        this.l = r19;
        goto L53
    L47:
        this.k = r17;
        goto L49
    L43:
        this.j = r16;
        goto L45
    L39:
        this.i = r15;
        goto L41
    L35:
        this.h = r14;
        goto L37
    L31:
        this.g = r13;
        goto L33
    L27:
        r4 = r12;
        goto L28
    L23:
        this.e = r11;
        goto L25
    L19:
        r3 = r10;
        goto L20
    L15:
        this.c = r9;
        goto L17
    L11:
        r2 = r8;
        goto L12
    L7:
        this.a = r7;
        goto L9
    }
}
