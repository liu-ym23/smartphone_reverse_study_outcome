package pea;

import android.content.Intent;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class h {
    public final int a;
    public final int b;
    public final String c;
    public Intent d;
    public final boolean e;
    public final String f;
    public final int g;
    public final String h;
    public final Integer i;
    public final String j;
    public String k;
    public final String l;
    public final String m;
    public Integer n;
    public String o;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof h) == true) goto L8;
        return false;
    L8:
        h r6 = (h) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
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
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r6.n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r6.o) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a * 31) + this.b) * 31;
        String r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Intent r5 = this.d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        if (this.e == false) goto L13;
        int r8 = 1231;
    L14:
        int r9 = (r7 + r8) * 31;
        String r10 = this.f;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (((r9 + r11) * 31) + this.g) * 31;
        String r13 = this.h;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.i;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.j;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.k;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.l;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.m;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        Integer r31 = this.n;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.o;
        if (r34 == null) goto L51;
        r2 = r34.hashCode();
    L51:
        return r33 + r2;
    L45:
        r32 = r31.hashCode();
        goto L46
    L41:
        r29 = r28.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
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
        r8 = 1237;
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "ExpandedImageTextActionInfo(type=" + this.a + ", actionParamType=" + this.b + ", action=" + this.c + ", intent=" + this.d + ", clickWithCollapse=" + this.e + ", actionIcon=" + this.f + ", actionIconResId=" + this.g + ", actionIconDark=" + this.h + ", actionIconDarkResId=" + this.i + ", actionBgColor=" + this.j + ", actionTitle=" + this.k + ", actionTitleColor=" + this.l + ", actionTitleColorDark=" + this.m + ", actionIntentType=" + this.n + ", actionIntent=" + this.o + ')';
    }

    public final JSONObject a() {
        JSONObject r0 = new JSONObject();
        r0.put("type", this.a);
        r0.put("clickWithCollapse", this.e);
        if (this.b != 0) goto L5;
        r0.put("action", this.c);
    L29:
        return r0;
    L5:
        r0.put("actionIcon", this.f);
        r0.put("actionIconDark", this.h);
        String r1 = this.j;
        if (r1 == null) goto L8;
        r0.put("actionBgColor", r1);
    L8:
        String r2 = this.k;
        if (r2 == null) goto L11;
        r0.put("actionTitle", r2);
    L11:
        String r3 = this.l;
        if (r3 == null) goto L14;
        r0.put("actionTitleColor", r3);
    L14:
        String r4 = this.m;
        if (r4 == null) goto L17;
        r0.put("actionTitleColorDark", r4);
    L17:
        Intent r5 = this.d;
        if (r5 == null) goto L22;
        String r6 = r5.toUri(1);
        if (r6 == null) goto L22;
    L23:
        this.o = r6;
        if (r6 == null) goto L26;
        r0.put("actionIntent", r6);
    L26:
        Integer r7 = this.n;
        if (r7 == null) goto L29;
        r7.intValue();
        r0.put("actionIntentType", this.n);
    L22:
        r6 = null;
        goto L23
    }

    public final int getType() {
        return this.a;
    }

    public h(String r5, boolean r6, String r7, int r8, String r9, Integer r10, int r11) {
        if ((r11 & 2) == 0) goto L5;
        int r0 = 0;
    L7:
        if ((r11 & 4) == 0) goto L10;
        r5 = null;
    L10:
        if ((r11 & 16) == 0) goto L13;
        r6 = false;
    L13:
        if ((r11 & 32) == 0) goto L16;
        r7 = null;
    L16:
        if ((r11 & 128) == 0) goto L19;
        r9 = null;
    L19:
        if ((r11 & 256) == 0) goto L22;
        r10 = null;
    L22:
        if ((r11 & 8192) == 0) goto L24;
        Integer r12 = 2;
    L25:
        this.a = 0;
        this.b = r0;
        this.c = r5;
        this.d = null;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = r12;
        this.o = null;
        return;
    L24:
        r12 = null;
        goto L25
    L5:
        r0 = 1;
        goto L7
    }
}
