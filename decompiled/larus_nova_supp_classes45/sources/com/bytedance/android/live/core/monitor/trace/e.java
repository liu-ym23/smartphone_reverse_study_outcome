package com.bytedance.android.live.core.monitor.trace;

import com.bytedance.android.live.core.utils.statusbar.RomUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e {
    public static final /* synthetic */ int m = 0;
    public String a;
    public final String b;
    public final String c;
    public final String d;
    public String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final Integer j;
    public final String k;
    public final Map<String, Object> l;

    public static final class a {
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public Integer h;
        public String i;
        public Map<String, Object> j;
        public final String k;
        public final String l;

        public final e a() {
            return new e(this.k, this.l, this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
        }

        public a(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "eventType");
            Intrinsics.checkNotNullParameter(r3, "businessType");
            this.k = r2;
            this.l = r3;
        }

        public final void b(String r2, Object r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            if (this.j != null) goto L5;
            this.j = new LinkedHashMap();
            Unit r0 = Unit.INSTANCE;
        L5:
            Map<String, Object> r1 = this.j;
            if (r1 == null) goto L9;
            r1.put(r2, r3);
            return;
        }
    }

    public static final class b {
        @JvmStatic
        public static a a(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "eventType");
            Intrinsics.checkNotNullParameter(r2, "businessType");
            return new a(r1, r2);
        }
    }

    static {
    }

    public e() {
        this(null, null, null, null, null, null, null, null, null, null, null, 4095);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof e) == false) goto L30;
        e r4 = (e) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r4.h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r4.i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r4.j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.k, r4.k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.l, r4.l) == true) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r11 = this.d;
        if (r11 == null) goto L17;
        int r12 = r11.hashCode();
    L18:
        int r13 = (r9 + r12) * 31;
        String r14 = this.e;
        if (r14 == null) goto L21;
        int r15 = r14.hashCode();
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.f;
        if (r17 == null) goto L25;
        int r18 = r17.hashCode();
    L26:
        int r19 = (r16 + r18) * 31;
        String r21 = this.g;
        if (r21 == null) goto L29;
        int r22 = r21.hashCode();
    L30:
        int r23 = (r19 + r22) * 31;
        String r24 = this.h;
        if (r24 == null) goto L33;
        int r25 = r24.hashCode();
    L34:
        int r26 = (r23 + r25) * 31;
        String r27 = this.i;
        if (r27 == null) goto L37;
        int r28 = r27.hashCode();
    L38:
        int r29 = (r26 + r28) * 31;
        Integer r31 = this.j;
        if (r31 == null) goto L41;
        int r32 = r31.hashCode();
    L42:
        int r33 = (r29 + r32) * 31;
        String r34 = this.k;
        if (r34 == null) goto L45;
        int r35 = r34.hashCode();
    L46:
        int r36 = (r33 + r35) * 31;
        Map<String, Object> r37 = this.l;
        if (r37 == null) goto L50;
        r1 = r37.hashCode();
    L50:
        return r36 + r1;
    L45:
        r35 = 0;
        goto L46
    L41:
        r32 = 0;
        goto L42
    L37:
        r28 = 0;
        goto L38
    L33:
        r25 = 0;
        goto L34
    L29:
        r22 = 0;
        goto L30
    L25:
        r18 = 0;
        goto L26
    L21:
        r15 = 0;
        goto L22
    L17:
        r12 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "TraceMeta(eventType=" + this.a + ", businessType=" + this.b + ", traceId=" + this.c + ", logId=" + this.d + ", productId=" + this.e + ", step=" + this.f + ", roomId=" + this.g + ", anchorId=" + this.h + ", userId=" + this.i + ", statusCode=" + this.j + ", statusMsg=" + this.k + ", index=" + this.l + ")";
    }

    public /* synthetic */ e(String r17, String r18, String r19, String r21, String r22, String r23, String r24, String r25, Integer r26, String r27, Map r28, int r29) {
        if ((r29 & 1) == 0) goto L5;
        String r4 = "";
    L7:
        if ((r29 & 2) == 0) goto L9;
        String r5 = "";
    L11:
        if ((r29 & 4) == 0) goto L13;
        String r6 = null;
    L15:
        if ((r29 & 16) == 0) goto L17;
        String r8 = null;
    L19:
        if ((r29 & 32) == 0) goto L21;
        String r9 = null;
    L23:
        if ((r29 & 64) == 0) goto L25;
        String r11 = null;
    L27:
        if ((r29 & 128) == 0) goto L29;
        String r12 = null;
    L31:
        if ((r29 & 256) == 0) goto L33;
        String r13 = null;
    L35:
        if ((r29 & 512) == 0) goto L37;
        Integer r14 = null;
    L39:
        if ((r29 & RomUtils.SZ) == 0) goto L41;
        String r15 = null;
    L43:
        if ((r29 & 2048) == 0) goto L45;
        Map r16 = null;
    L46:
        this(r4, r5, r6, null, r8, r9, r11, r12, r13, r14, r15, r16);
        return;
    L45:
        r16 = r28;
        goto L46
    L41:
        r15 = r27;
        goto L43
    L37:
        r14 = r26;
        goto L39
    L33:
        r13 = r25;
        goto L35
    L29:
        r12 = r24;
        goto L31
    L25:
        r11 = r23;
        goto L27
    L21:
        r9 = r22;
        goto L23
    L17:
        r8 = r21;
        goto L19
    L13:
        r6 = r19;
        goto L15
    L9:
        r5 = r18;
        goto L11
    L5:
        r4 = r17;
        goto L7
    }

    public e(String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r11, Integer r12, String r13, Map<String, Object> r14) {
        Intrinsics.checkNotNullParameter(r2, "eventType");
        Intrinsics.checkNotNullParameter(r3, "businessType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
    }
}
