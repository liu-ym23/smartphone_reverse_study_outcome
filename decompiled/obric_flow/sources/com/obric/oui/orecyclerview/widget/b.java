package com.obric.oui.orecyclerview.widget;

import androidx.core.util.Pools;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Pools.SimplePool f13791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f13792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f13793c;
    public final y d;
    public final y e;
    public int f;

    public b(y r5) {
        this.f13791a = new Pools.SimplePool(30);
        this.f13792b = new ArrayList();
        this.f13793c = new ArrayList();
        this.f = 0;
        this.d = r5;
        this.e = new y(this);
    }

    public final boolean a(int r10) {
        ArrayList r5 = this.f13793c;
        int r11 = r5.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L17;
        a r13 = (a) r5.get(r12);
        int r14 = r13.f13785a;
        if (r14 == 8) goto L7;
        if (r14 != 1) goto L16;
        int r15 = r13.f13786b;
        int r16 = r13.d + r15;
    L11:
        if (r15 >= r16) goto L16;
        if (f(r15, r12 + 1) == r10) goto L14;
        r15 = r15 + 1;
        goto L11
    L14:
        return true;
    L16:
        r12 = r12 + 1;
        goto L3
    L7:
        if (f(r13.d, r12 + 1) != r10) goto L16;
        return true;
    L17:
        return false;
    }

    public final void b() {
        ArrayList r5 = this.f13793c;
        int r10 = r5.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        this.d.a((a) r5.get(r11));
        r11 = r11 + 1;
        goto L3
    L5:
        k(r5);
        this.f = 0;
    }

    public final void c() {
        b();
        ArrayList r5 = this.f13792b;
        int r10 = r5.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L18;
        a r12 = (a) r5.get(r11);
        int r13 = r12.f13785a;
        y r14 = this.d;
        if (r13 != 1) goto L7;
        r14.a(r12);
        r14.d(r12.f13786b, r12.d);
    L17:
        r11 = r11 + 1;
        goto L3
    L7:
        if (r13 != 2) goto L9;
        r14.a(r12);
        int r15 = r12.f13786b;
        int r16 = r12.d;
        RecyclerView r17 = (RecyclerView) r14.f13929a;
        r17.J(r15, r16, true);
        r17.f13733e0 = true;
        r17.f13729b0.f13912b += r16;
        goto L17
    L9:
        if (r13 != 4) goto L11;
        r14.a(r12);
        r14.c(r12.f13786b, r12.d, r12.f13787c);
        goto L17
    L11:
        if (r13 != 8) goto L17;
        r14.a(r12);
        r14.e(r12.f13786b, r12.d);
        goto L17
    L18:
        k(r5);
        this.f = 0;
    }

    public final void d(a r14) {
        int r5 = r14.f13785a;
        if (r5 == 1) goto L35;
        if (r5 == 8) goto L35;
        int r10 = l(r14.f13786b, r5);
        int r11 = r14.f13786b;
        int r12 = r14.f13785a;
        if (r12 == 2) goto L12;
        if (r12 != 4) goto L11;
        int r13 = 1;
    L13:
        int r15 = 1;
        int r16 = 1;
    L14:
        int r17 = r14.d;
        Pools.SimplePool r18 = this.f13791a;
        if (r15 >= r17) goto L30;
        int r19 = l((r13 * r15) + r14.f13786b, r14.f13785a);
        int r110 = r14.f13785a;
        if (r110 == 2) goto L23;
        if (r110 == 4) goto L21;
    L25:
        a r20 = h(r110, r10, r16, r14.f13787c);
        e(r20, r11);
        r20.f13787c = null;
        r18.release(r20);
        if (r14.f13785a != 4) goto L28;
        r11 = r11 + r16;
    L28:
        r16 = 1;
        r10 = r19;
    L29:
        r15 = r15 + 1;
        goto L14
    L21:
        if (r19 != (r10 + 1)) goto L25;
    L24:
        r16 = r16 + 1;
        goto L29
    L23:
        if (r19 != r10) goto L25;
    L30:
        Object r21 = r14.f13787c;
        r14.f13787c = null;
        r18.release(r14);
        if (r16 <= 0) goto L39;
        a r111 = h(r14.f13785a, r10, r16, r21);
        e(r111, r11);
        r111.f13787c = null;
        r18.release(r111);
        return;
    L39:
        return;
    L11:
        throw new IllegalArgumentException("op should be remove or update." + r14);
    L12:
        r13 = 0;
    L35:
        throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }

    public final void e(a r5, int r10) {
        y r11 = this.d;
        r11.a(r5);
        int r12 = r5.f13785a;
        if (r12 != 2) goto L5;
        int r13 = r5.d;
        RecyclerView r14 = (RecyclerView) r11.f13929a;
        r14.J(r10, r13, true);
        r14.f13733e0 = true;
        r14.f13729b0.f13912b += r13;
        return;
    L5:
        if (r12 != 4) goto L8;
        r11.c(r10, r5.d, r5.f13787c);
        return;
    L8:
        throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
    }

    public final int f(int r10, int r11) {
        ArrayList r5 = this.f13793c;
        int r12 = r5.size();
    L3:
        if (r11 >= r12) goto L27;
        a r13 = (a) r5.get(r11);
        int r14 = r13.f13785a;
        if (r14 != 8) goto L14;
        int r15 = r13.f13786b;
        if (r15 != r10) goto L9;
        r10 = r13.d;
    L26:
        r11 = r11 + 1;
        goto L3
    L9:
        if (r15 >= r10) goto L12;
        r10 = r10 - 1;
    L12:
        if (r13.d > r10) goto L26;
        r10 = r10 + 1;
        goto L26
    L14:
        int r16 = r13.f13786b;
        if (r16 > r10) goto L26;
        if (r14 != 2) goto L24;
        int r17 = r13.d;
        if (r10 < (r16 + r17)) goto L20;
        r10 = r10 - r17;
        goto L26
    L20:
        return -1;
    L24:
        if (r14 != 1) goto L26;
        r10 = r10 + r13.d;
        goto L26
    L27:
        return r10;
    }

    public final boolean g() {
        if (this.f13792b.size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final a h(int r5, int r10, int r11, Object r12) {
        a r13 = (a) this.f13791a.acquire();
        if (r13 != null) goto L5;
        a r14 = new a();
        r14.f13785a = r5;
        r14.f13786b = r10;
        r14.d = r11;
        r14.f13787c = r12;
        return r14;
    L5:
        r13.f13785a = r5;
        r13.f13786b = r10;
        r13.d = r11;
        r13.f13787c = r12;
        return r13;
    }

    public final void i(a r5) {
        this.f13793c.add(r5);
        int r10 = r5.f13785a;
        y r11 = this.d;
        if (r10 != 1) goto L5;
        r11.d(r5.f13786b, r5.d);
        return;
    L5:
        if (r10 != 2) goto L7;
        int r12 = r5.f13786b;
        int r13 = r5.d;
        RecyclerView r14 = (RecyclerView) r11.f13929a;
        r14.J(r12, r13, false);
        r14.f13733e0 = true;
        return;
    L7:
        if (r10 != 4) goto L9;
        r11.c(r5.f13786b, r5.d, r5.f13787c);
        return;
    L9:
        if (r10 != 8) goto L12;
        r11.e(r5.f13786b, r5.d);
        return;
    L12:
        throw new IllegalArgumentException("Unknown update op type for " + r5);
    }

    public final void j() {
        ArrayList r5 = this.f13792b;
        y r10 = this.e;
        r10.getClass();
    L3:
        int r11 = r5.size() - 1;
        boolean r12 = false;
    L4:
        byte r13 = -1;
        int r14 = 8;
        if (r11 < 0) goto L12;
        if (((a) r5.get(r11)).f13785a != 8) goto L10;
        if (r12 == false) goto L11;
    L14:
        if (r11 == (-1)) goto L121;
        int r15 = r11 + 1;
        a r16 = (a) r5.get(r11);
        a r17 = (a) r5.get(r15);
        int r18 = r17.f13785a;
        if (r18 != 1) goto L17;
        int r19 = r16.d;
        int r20 = r17.f13786b;
        if (r19 >= r20) goto L111;
        int r21 = -1;
    L112:
        int r22 = r16.f13786b;
        if (r22 >= r20) goto L115;
        r21 = r21 + 1;
    L115:
        if (r20 > r22) goto L117;
        r16.f13786b = r22 + r17.d;
    L117:
        int r23 = r17.f13786b;
        if (r23 > r19) goto L120;
        r16.d = r19 + r17.d;
    L120:
        r17.f13786b = r23 + r21;
        r5.set(r11, r17);
        r5.set(r15, r16);
        goto L3
    L111:
        r21 = 0;
        goto L112
    L17:
        b r24 = (b) r10.f13929a;
        if (r18 != 2) goto L19;
        int r25 = r16.f13786b;
        int r110 = r16.d;
        if (r25 >= r110) goto L53;
        if (r17.f13786b == r25) goto L48;
    L51:
        boolean r26 = false;
    L50:
        boolean r27 = false;
    L58:
        int r111 = r17.f13786b;
        if (r110 < r111) goto L60;
        int r112 = r17.d;
        if (r110 >= (r111 + r112)) goto L66;
        r17.d = r112 - 1;
        r16.f13785a = 2;
        r16.d = 1;
        if (r17.d != 0) goto L3;
        r5.remove(r15);
        r17.f13787c = null;
        r24.f13791a.release(r17);
    L66:
        int r28 = r16.f13786b;
        int r113 = r17.f13786b;
        if (r28 > r113) goto L69;
        r17.f13786b = r113 + 1;
    L72:
        a r29 = null;
    L73:
        if (r26 == true) goto L74;
        if (r27 == false) goto L89;
        if (r29 == null) goto L83;
        int r30 = r16.f13786b;
        if (r30 <= r29.f13786b) goto L80;
        r16.f13786b = r30 - r29.d;
    L80:
        int r31 = r16.d;
        if (r31 <= r29.f13786b) goto L83;
        r16.d = r31 - r29.d;
    L83:
        int r32 = r16.f13786b;
        if (r32 <= r17.f13786b) goto L86;
        r16.f13786b = r32 - r17.d;
    L86:
        int r33 = r16.d;
        if (r33 <= r17.f13786b) goto L102;
        r16.d = r33 - r17.d;
    L102:
        r5.set(r11, r17);
        if (r16.f13786b == r16.d) goto L105;
        r5.set(r15, r16);
    L106:
        if (r29 == null) goto L3;
        r5.add(r11, r29);
        goto L3
    L105:
        r5.remove(r15);
        goto L106
    L89:
        if (r29 == null) goto L96;
        int r34 = r16.f13786b;
        if (r34 < r29.f13786b) goto L93;
        r16.f13786b = r34 - r29.d;
    L93:
        int r35 = r16.d;
        if (r35 < r29.f13786b) goto L96;
        r16.d = r35 - r29.d;
    L96:
        int r36 = r16.f13786b;
        if (r36 < r17.f13786b) goto L99;
        r16.f13786b = r36 - r17.d;
    L99:
        int r37 = r16.d;
        if (r37 < r17.f13786b) goto L102;
        r16.d = r37 - r17.d;
        goto L102
    L74:
        r5.set(r11, r17);
        r5.remove(r15);
        r16.f13787c = null;
        r24.f13791a.release(r16);
        goto L3
    L69:
        int r114 = r113 + r17.d;
        if (r28 >= r114) goto L72;
        r29 = r24.h(2, r28 + 1, r114 - r28, null);
        r17.d = r16.f13786b - r17.f13786b;
        goto L73
    L60:
        r17.f13786b = r111 - 1;
        goto L66
    L48:
        if (r17.d != (r110 - r25)) goto L51;
        r26 = true;
        goto L50
    L53:
        if (r17.f13786b == (r110 + 1)) goto L55;
    L57:
        r27 = true;
        r26 = false;
        goto L58
    L55:
        if (r17.d != (r25 - r110)) goto L57;
        r26 = true;
        r27 = true;
        goto L58
    L19:
        if (r18 != 4) goto L3;
        int r38 = r16.d;
        int r39 = r17.f13786b;
        if (r38 >= r39) goto L24;
        r17.f13786b = r39 - 1;
    L27:
        a r40 = null;
    L28:
        int r41 = r16.f13786b;
        int r42 = r17.f13786b;
        if (r41 > r42) goto L31;
        r17.f13786b = r42 + 1;
    L34:
        a r43 = null;
    L35:
        r5.set(r15, r16);
        if (r17.d <= 0) goto L38;
        r5.set(r11, r17);
    L39:
        if (r40 == null) goto L41;
        r5.add(r11, r40);
    L41:
        if (r43 == null) goto L3;
        r5.add(r11, r43);
        goto L3
    L38:
        r5.remove(r11);
        r17.f13787c = null;
        r24.f13791a.release(r17);
        goto L39
    L31:
        int r44 = r42 + r17.d;
        if (r41 >= r44) goto L34;
        int r45 = r44 - r41;
        r43 = r24.h(4, r41 + 1, r45, r17.f13787c);
        r17.d -= r45;
        goto L35
    L24:
        int r115 = r17.d;
        if (r38 >= (r39 + r115)) goto L27;
        r17.d = r115 - 1;
        r40 = r24.h(4, r16.f13786b, 1, r17.f13787c);
        goto L28
    L121:
        int r46 = r5.size();
        int r47 = 0;
    L122:
        if (r47 >= r46) goto L178;
        a r116 = (a) r5.get(r47);
        int r117 = r116.f13785a;
        if (r117 == 1) goto L176;
        Pools.SimplePool r118 = this.f13791a;
        y r119 = this.d;
        if (r117 == 2) goto L151;
        if (r117 == 4) goto L131;
        if (r117 != r14) goto L177;
        i(r116);
    L177:
        r47 = r47 + 1;
        r13 = -1;
        r14 = 8;
        goto L122
    L131:
        int r120 = r116.f13786b;
        int r121 = r116.d + r120;
        byte r48 = r13;
        int r49 = r120;
        int r50 = 0;
    L132:
        if (r120 >= r121) goto L146;
        if (r119.b(r120) == null) goto L136;
    L141:
        if (r48 != 0) goto L143;
        d(h(4, r49, r50, r116.f13787c));
        r49 = r120;
        r50 = 0;
    L143:
        r48 = 1;
    L144:
        r50 = r50 + 1;
        r120 = r120 + 1;
        goto L132
    L136:
        if (a(r120) == true) goto L141;
        if (r48 != 1) goto L140;
        i(h(4, r49, r50, r116.f13787c));
        r49 = r120;
        r50 = 0;
    L140:
        r48 = 0;
        goto L144
    L146:
        if (r50 == r116.d) goto L148;
        Object r122 = r116.f13787c;
        r116.f13787c = null;
        r118.release(r116);
        r116 = h(4, r49, r50, r122);
    L148:
        if (r48 != 0) goto L150;
        d(r116);
        goto L177
    L150:
        i(r116);
        goto L177
    L151:
        int r51 = r116.f13786b;
        int r52 = r116.d + r51;
        int r53 = r51;
        int r123 = 0;
        byte r124 = -1;
    L152:
        if (r53 >= r52) goto L171;
        if (r119.b(r53) == null) goto L156;
    L162:
        if (r124 != 0) goto L164;
        d(h(2, r51, r123, null));
        boolean r125 = true;
    L165:
        byte r126 = 1;
    L166:
        if (r125 == false) goto L168;
        r53 = r53 - r123;
        r52 = r52 - r123;
        r123 = 1;
    L169:
        r53 = r53 + 1;
        r124 = r126;
        goto L152
    L168:
        r123 = r123 + 1;
        goto L169
    L164:
        r125 = false;
        goto L165
    L156:
        if (a(r53) == true) goto L162;
        if (r124 != 1) goto L160;
        i(h(2, r51, r123, null));
        r125 = true;
    L161:
        r126 = 0;
        goto L166
    L160:
        r125 = false;
        goto L161
    L171:
        if (r123 == r116.d) goto L173;
        r116.f13787c = null;
        r118.release(r116);
        r116 = h(2, r51, r123, null);
    L173:
        if (r124 != 0) goto L175;
        d(r116);
        goto L177
    L175:
        i(r116);
        goto L177
    L176:
        i(r116);
        goto L177
    L178:
        r5.clear();
        return;
    L11:
        r11 = r11 - 1;
        goto L4
    L10:
        r12 = true;
        goto L11
    L12:
        r11 = -1;
        goto L14
    }

    public final void k(ArrayList r5) {
        int r10 = r5.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        a r12 = (a) r5.get(r11);
        r12.f13787c = null;
        this.f13791a.release(r12);
        r11 = r11 + 1;
        goto L3
    L5:
        r5.clear();
    }

    public final int l(int r10, int r11) {
        ArrayList r5 = this.f13793c;
        int r12 = r5.size() - 1;
    L4:
        if (r12 < 0) goto L40;
        a r13 = (a) r5.get(r12);
        int r14 = r13.f13785a;
        if (r14 != 8) goto L29;
        int r15 = r13.f13786b;
        int r16 = r13.d;
        if (r15 >= r16) goto L10;
        int r17 = r15;
        int r18 = r16;
    L11:
        if (r10 < r17) goto L24;
        if (r10 > r18) goto L24;
        if (r17 != r15) goto L19;
        if (r11 != 1) goto L16;
        r13.d = r16 + 1;
    L18:
        r10 = r10 + 1;
    L39:
        r12 = r12 - 1;
        goto L4
    L16:
        if (r11 != 2) goto L18;
        r13.d = r16 - 1;
        goto L18
    L19:
        if (r11 != 1) goto L21;
        r13.f13786b = r15 + 1;
    L23:
        r10 = r10 - 1;
        goto L39
    L21:
        if (r11 != 2) goto L23;
        r13.f13786b = r15 - 1;
    L24:
        if (r10 >= r15) goto L39;
        if (r11 != 1) goto L27;
        r13.f13786b = r15 + 1;
        r13.d = r16 + 1;
        goto L39
    L27:
        if (r11 != 2) goto L39;
        r13.f13786b = r15 - 1;
        r13.d = r16 - 1;
        goto L39
    L10:
        r18 = r15;
        r17 = r16;
        goto L11
    L29:
        int r19 = r13.f13786b;
        if (r19 > r10) goto L35;
        if (r14 != 1) goto L33;
        r10 = r10 - r13.d;
        goto L39
    L33:
        if (r14 != 2) goto L39;
        r10 = r10 + r13.d;
        goto L39
    L35:
        if (r11 != 1) goto L37;
        r13.f13786b = r19 + 1;
        goto L39
    L37:
        if (r11 != 2) goto L39;
        r13.f13786b = r19 - 1;
        goto L39
    L40:
        int r110 = r5.size() - 1;
    L41:
        if (r110 < 0) goto L52;
        a r20 = (a) r5.get(r110);
        int r21 = r20.f13785a;
        Pools.SimplePool r22 = this.f13791a;
        if (r21 != 8) goto L49;
        int r23 = r20.d;
        if (r23 == r20.f13786b) goto L47;
        if (r23 < 0) goto L47;
    L51:
        r110 = r110 - 1;
    L47:
        r5.remove(r110);
        r20.f13787c = null;
        r22.release(r20);
        goto L51
    L49:
        if (r20.d > 0) goto L51;
        r5.remove(r110);
        r20.f13787c = null;
        r22.release(r20);
        goto L51
    L52:
        return r10;
    }
}
