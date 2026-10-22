package com.bytedance.android.accessibilityLib_Core.config.remote.dsl;

import java.util.Arrays;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g {
    public final String a;
    public final h b;
    public final boolean c;
    public final boolean d;
    public final SelectMode e;
    public final boolean f;
    public final LabelMode g;
    public final ConfigType h;
    public final String i;
    public final h[] j;
    public final d k;
    public final h l;
    public final h m;
    public final List<b> n;
    public final boolean o;
    public final String p;
    public final ClassType q;

    public final int hashCode() {
        int r0 = this.b.hashCode() * 31;
        int r10 = 1231;
        if (this.c == false) goto L5;
        int r1 = 1231;
    L6:
        int r11 = (r0 + r1) * 31;
        SelectMode r12 = this.e;
        int r13 = 0;
        if (r12 == null) goto L9;
        int r14 = r12.hashCode();
    L10:
        int r15 = (r11 + r14) * 31;
        if (this.d == false) goto L13;
        int r16 = 1231;
    L14:
        int r17 = (r15 + r16) * 31;
        if (this.f == false) goto L17;
        int r18 = 1231;
    L18:
        int r19 = (r17 + r18) * 31;
        ConfigType r20 = this.h;
        if (r20 == null) goto L21;
        int r21 = r20.hashCode();
    L22:
        int r22 = (r19 + r21) * 31;
        String r23 = this.i;
        if (r23 == null) goto L25;
        int r24 = r23.hashCode();
    L26:
        int r25 = (r22 + r24) * 31;
        h[] r26 = this.j;
        if (r26 == null) goto L29;
        int r27 = Arrays.hashCode(r26);
    L30:
        int r28 = (r25 + r27) * 31;
        d r29 = this.k;
        if (r29 == null) goto L33;
        int r30 = r29.hashCode();
    L34:
        int r31 = (r28 + r30) * 31;
        h r32 = this.l;
        if (r32 == null) goto L37;
        int r33 = r32.hashCode();
    L38:
        int r34 = (r31 + r33) * 31;
        h r35 = this.m;
        if (r35 == null) goto L41;
        int r36 = r35.hashCode();
    L42:
        int r37 = (r34 + r36) * 31;
        List<b> r38 = this.n;
        if (r38 == null) goto L45;
        r13 = r38.hashCode();
    L45:
        int r39 = (r37 + r13) * 31;
        if (this.o == true) goto L50;
        r10 = 1237;
    L50:
        return ((((r39 + r10) * 31) + this.p.hashCode()) * 31) + this.q.hashCode();
    L41:
        r36 = 0;
        goto L42
    L37:
        r33 = 0;
        goto L38
    L33:
        r30 = 0;
        goto L34
    L29:
        r27 = 0;
        goto L30
    L25:
        r24 = 0;
        goto L26
    L21:
        r21 = 0;
        goto L22
    L17:
        r18 = 1237;
        goto L18
    L13:
        r16 = 1237;
        goto L14
    L9:
        r14 = 0;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("ViewConfigDsl(viewIdentifyDsl=");
        r0.append(this.b);
        r0.append(", needFocus=");
        r0.append(this.c);
        r0.append(", overWrite=");
        r0.append(this.d);
        r0.append(", select=");
        SelectMode r1 = this.e;
        String r10 = null;
        if (r1 == null) goto L5;
        String r11 = r1.name();
    L6:
        r0.append(r11);
        r0.append(", disableClick=");
        r0.append(this.f);
        r0.append(",labelMode=");
        r0.append(this.g);
        r0.append(",\nconfigType=");
        r0.append(this.h);
        r0.append(",panelTitle=");
        r0.append(this.i);
        r0.append(",hideExcludeFocus=");
        h[] r12 = this.j;
        if (r12 == null) goto L9;
        r10 = Arrays.toString(r12);
    L9:
        r0.append(r10);
        r0.append(", label=");
        r0.append(this.k);
        r0.append(",before=");
        r0.append(this.l);
        r0.append(",after=");
        r0.append(this.m);
        r0.append(", \nverify=");
        r0.append(this.o);
        r0.append(",appMode=");
        r0.append(this.p);
        r0.append(",classType=");
        r0.append(this.q.getValue());
        r0.append(")");
        return r0.toString();
    L5:
        r11 = null;
        goto L6
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 == null) goto L8;
        Class<?> r11 = r10.getClass();
    L10:
        if ((!Intrinsics.areEqual(g.class, r11)) == false) goto L12;
        return false;
    L12:
        if (r10 == null) goto L68;
        g r12 = (g) r10;
        if ((!Intrinsics.areEqual(this.b, r12.b)) == false) goto L17;
        return false;
    L17:
        if (this.c == r12.c) goto L20;
        return false;
    L20:
        if (this.d == r12.d) goto L23;
        return false;
    L23:
        if (this.f == r12.f) goto L26;
        return false;
    L26:
        if (this.e == r12.e) goto L29;
        return false;
    L29:
        if (this.h == r12.h) goto L32;
        return false;
    L32:
        if ((!Intrinsics.areEqual(this.i, r12.i)) == false) goto L34;
        return false;
    L34:
        h[] r1 = this.j;
        if (r1 == null) goto L43;
        h[] r13 = r12.j;
        if (r13 != null) goto L40;
        return false;
    L40:
        if (Arrays.equals(r1, r13) == true) goto L46;
        return false;
    L46:
        if ((!Intrinsics.areEqual(this.k, r12.k)) == false) goto L49;
        return false;
    L49:
        if ((!Intrinsics.areEqual(this.l, r12.l)) == false) goto L52;
        return false;
    L52:
        if ((!Intrinsics.areEqual(this.m, r12.m)) == false) goto L55;
        return false;
    L55:
        if ((!Intrinsics.areEqual(this.n, r12.n)) == false) goto L58;
        return false;
    L58:
        if (this.o == r12.o) goto L61;
        return false;
    L61:
        if ((!Intrinsics.areEqual(this.p, r12.p)) == false) goto L64;
        return false;
    L64:
        if (this.q == r12.q) goto L66;
        return false;
    L66:
        return true;
    L43:
        if (r12.j == null) goto L46;
        return false;
    L68:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.accessibilityLib_Core.config.remote.dsl.ViewConfigDsl");
    L8:
        r11 = null;
        goto L10
    }

    public g(String r10, h r11, boolean r12, boolean r13, SelectMode r14, boolean r15, LabelMode r16, ConfigType r17, String r18, h[] r19, d r110, h r111, h r112, List<b> r113, boolean r114, String r115, ClassType r116) {
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.g = r16;
        this.h = r17;
        this.i = r18;
        this.j = r19;
        this.k = r110;
        this.l = r111;
        this.m = r112;
        this.n = r113;
        this.o = r114;
        this.p = r115;
        this.q = r116;
    }
}
