package com.obric.oui.orecyclerview.widget;

import android.graphics.Rect;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentTransaction;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class s extends k0 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f13897m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public r f13898n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final v f13899o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f13900p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f13901q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f13902r;
    public final boolean s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f13903t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f13904u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public LinearLayoutManager$SavedState f13905v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final p f13906w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final q f13907x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f13908y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int[] f13909z;

    public s() {
        this.f13897m = 1;
        this.f13901q = false;
        this.f13902r = false;
        this.s = true;
        this.f13903t = -1;
        this.f13904u = Integer.MIN_VALUE;
        this.f13905v = null;
        p r5 = new p();
        r5.d();
        this.f13906w = r5;
        this.f13907x = new q();
        this.f13908y = 2;
        this.f13909z = new int[2];
        b(null);
        if (1 == this.f13897m) goto L5;
    L6:
        u r10 = new u(this);
        this.f13899o = r10;
        r5.f13876a = r10;
        this.f13897m = 1;
        Q();
    L7:
        b(null);
        return;
    L5:
        if (this.f13899o != null) goto L7;
        goto L6
    }

    @Override // com.obric.oui.orecyclerview.widget.k0
    public final boolean D() {
        return true;
    }

    @Override // com.obric.oui.orecyclerview.widget.k0
    public final View G(int r10, q0 r11, u0 r12) {
        q0();
        if (r() != 0) goto L6;
        return null;
    L6:
        if (r10 == 1) goto L37;
        if (r10 == 2) goto L31;
        if (r10 == 17) goto L28;
        if (r10 == 33) goto L25;
        if (r10 == 66) goto L22;
        if (r10 == 130) goto L19;
    L17:
        int r13 = Integer.MIN_VALUE;
    L42:
        if (r13 != Integer.MIN_VALUE) goto L44;
        return null;
    L44:
        e0();
        s0(r13, (int) (this.f13899o.j() * 0.33333334f), false, r12);
        r r5 = this.f13898n;
        r5.g = Integer.MIN_VALUE;
        r5.f13889a = false;
        f0(r11, r5, r12, true);
        if (r13 != (-1)) goto L51;
        if (this.f13901q == false) goto L49;
        View r14 = i0(r() - 1, -1);
    L54:
        if (r13 != (-1)) goto L56;
        View r15 = n0();
    L58:
        if (r15.hasFocusable() == false) goto L62;
        if (r14 != null) goto L61;
        return null;
    L61:
        return r15;
    L62:
        return r14;
    L56:
        r15 = m0();
        goto L58
    L49:
        r14 = i0(0, r());
        goto L54
    L51:
        if (this.f13901q == false) goto L53;
        r14 = i0(0, r());
        goto L54
    L53:
        r14 = i0(r() - 1, -1);
        goto L54
    L19:
        if (this.f13897m != 1) goto L17;
    L32:
        r13 = 1;
        goto L42
    L22:
        if (this.f13897m != 0) goto L17;
    L25:
        if (this.f13897m != 1) goto L17;
    L35:
        r13 = -1;
        goto L42
    L28:
        if (this.f13897m != 0) goto L17;
    L31:
        if (this.f13897m == 1) goto L32;
        if (ViewCompat.getLayoutDirection(this.f13839b) != 1) goto L32;
    L37:
        if (this.f13897m == 1) goto L35;
        if (ViewCompat.getLayoutDirection(this.f13839b) != 1) goto L35;
        goto L35
    }

    @Override // com.obric.oui.orecyclerview.widget.k0
    public final void H(AccessibilityEvent r5) {
        super.H(r5);
        if (r() <= 0) goto L14;
        View r10 = j0(0, r(), false);
        int r11 = -1;
        if (r10 != null) goto L7;
        int r12 = -1;
    L8:
        r5.setFromIndex(r12);
        View r13 = j0(r() - 1, -1, false);
        if (r13 == null) goto L12;
        r11 = k0.B(r13);
    L12:
        r5.setToIndex(r11);
        return;
    L7:
        r12 = k0.B(r10);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v23, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v24 */
    @Override // com.obric.oui.orecyclerview.widget.k0
    public final void I(q0 r20, u0 r21) {
        if (this.f13905v != null) goto L7;
        if (this.f13903t != (-1)) goto L7;
    L10:
        LinearLayoutManager$SavedState r5 = this.f13905v;
        if (r5 == null) goto L15;
        int r10 = r5.f13720a;
        if (r10 < 0) goto L15;
        this.f13903t = r10;
    L15:
        e0();
        this.f13898n.f13889a = false;
        q0();
        RecyclerView r11 = this.f13839b;
        if (r11 != null) goto L18;
    L17:
        View r12 = null;
    L23:
        p r13 = this.f13906w;
        if (r13.e == true) goto L26;
    L36:
        r13.d();
        r13.d = this.f13901q ^ this.f13902r;
        if (r21.f == true) goto L89;
        int r14 = this.f13903t;
        if (r14 == (-1)) goto L89;
        if (r14 >= 0) goto L43;
    L87:
        this.f13903t = -1;
        this.f13904u = Integer.MIN_VALUE;
        goto L89
    L43:
        if (r14 >= r21.b()) goto L87;
        int r15 = this.f13903t;
        r13.f13877b = r15;
        LinearLayoutManager$SavedState r16 = this.f13905v;
        if (r16 == null) goto L54;
        if (r16.f13720a < 0) goto L54;
        boolean r17 = r16.f13722c;
        r13.d = r17;
        if (r17 == false) goto L52;
        r13.f13878c = this.f13899o.f() - this.f13905v.f13721b;
    L174:
        r13.e = true;
    L175:
        r r18 = this.f13898n;
        if (r18.f13894j < 0) goto L178;
        int r19 = 1;
    L179:
        r18.f = r19;
        int[] r22 = this.f13909z;
        r22[0] = 0;
        r22[1] = 0;
        r21.getClass();
        int r23 = this.f13898n.f;
        r22[0] = 0;
        r22[1] = 0;
        int r24 = this.f13899o.i() + Math.max(0, 0);
        int r25 = this.f13899o.g() + Math.max(0, r22[1]);
        if (r21.f == false) goto L195;
        int r26 = this.f13903t;
        if (r26 == (-1)) goto L195;
        if (this.f13904u == Integer.MIN_VALUE) goto L195;
        View r27 = o(r26);
        if (r27 == null) goto L195;
        if (this.f13901q == false) goto L191;
        int r28 = this.f13899o.f() - this.f13899o.a(r27);
        int r29 = this.f13904u;
    L190:
        int r30 = r28 - r29;
        if (r30 <= 0) goto L194;
        r24 = r24 + r30;
        goto L195
    L194:
        r25 = r25 - r30;
        goto L195
    L191:
        r29 = this.f13899o.d(r27) - this.f13899o.i();
        r28 = this.f13904u;
    L195:
        n(r20);
        r r31 = this.f13898n;
        if (this.f13899o.h() == 0) goto L198;
    L200:
        boolean r32 = false;
    L201:
        r31.f13896l = r32;
        this.f13898n.getClass();
        this.f13898n.f13893i = 0;
        if (r13.d == false) goto L209;
        u0(r13.f13877b, r13.f13878c);
        r r33 = this.f13898n;
        r33.f13892h = r24;
        f0(r20, r33, r21, false);
        r r34 = this.f13898n;
        int r35 = r34.f13890b;
        int r36 = r34.d;
        int r37 = r34.f13891c;
        if (r37 <= 0) goto L206;
        r25 = r25 + r37;
    L206:
        t0(r13.f13877b, r13.f13878c);
        r r38 = this.f13898n;
        r38.f13892h = r25;
        r38.d += r38.e;
        f0(r20, r38, r21, false);
        r r39 = this.f13898n;
        int r40 = r39.f13890b;
        int r41 = r39.f13891c;
        if (r41 <= 0) goto L217;
        u0(r36, r35);
        r r42 = this.f13898n;
        r42.f13892h = r41;
        f0(r20, r42, r21, false);
        r35 = this.f13898n.f13890b;
    L217:
        if (r() <= 0) goto L224;
        if ((this.f13901q ^ this.f13902r) == false) goto L222;
        int r43 = k0(r40, r20, r21, true);
        int r44 = r35 + r43;
        int r45 = r40 + r43;
        int r46 = l0(r44, r20, r21, false);
    L221:
        r35 = r44 + r46;
        r40 = r45 + r46;
        goto L224
    L222:
        int r47 = l0(r35, r20, r21, true);
        r44 = r35 + r47;
        r45 = r40 + r47;
        r46 = k0(r45, r20, r21, false);
    L224:
        if (r21.f13916j == false) goto L255;
        if (r() == 0) goto L255;
        if (r21.f == true) goto L255;
        if (a0() == false) goto L255;
        List r48 = r20.d;
        int r49 = r48.size();
        int r50 = k0.B(q(0));
        int r110 = 0;
        int r111 = 0;
        int r112 = 0;
    L233:
        if (r110 >= r49) goto L246;
        x0 r113 = (x0) r48.get(r110);
        if (r113.isRemoved() == true) goto L245;
        if (r113.getLayoutPosition() >= r50) goto L240;
        boolean r114 = true;
    L242:
        if (r114 == this.f13901q) goto L244;
        r111 = this.f13899o.b(r113.itemView) + r111;
        goto L245
    L244:
        r112 = this.f13899o.b(r113.itemView) + r112;
        goto L245
    L240:
        r114 = false;
    L245:
        r110 = r110 + 1;
        goto L233
    L246:
        this.f13898n.f13895k = r48;
        if (r111 <= 0) goto L249;
        u0(k0.B(n0()), r35);
        r r51 = this.f13898n;
        r51.f13892h = r111;
        ?? r52 = 0;
        r51.f13891c = 0;
        r51.a(null);
        f0(r20, this.f13898n, r21, false);
    L250:
        if (r112 <= 0) goto L252;
        t0(k0.B(m0()), r40);
        r r53 = this.f13898n;
        r53.f13892h = r112;
        r53.f13891c = r52;
        List r54 = null;
        r53.a(null);
        f0(r20, this.f13898n, r21, r52);
    L253:
        this.f13898n.f13895k = r54;
        goto L255
    L252:
        r54 = null;
        goto L253
    L249:
        r52 = 0;
    L255:
        if (r21.f == true) goto L257;
        v r55 = this.f13899o;
        r55.f13921b = r55.j();
    L258:
        this.f13900p = this.f13902r;
        return;
    L257:
        r13.d();
        goto L258
    L209:
        t0(r13.f13877b, r13.f13878c);
        r r56 = this.f13898n;
        r56.f13892h = r25;
        f0(r20, r56, r21, false);
        r r57 = this.f13898n;
        r40 = r57.f13890b;
        int r58 = r57.d;
        int r59 = r57.f13891c;
        if (r59 <= 0) goto L212;
        r24 = r24 + r59;
    L212:
        u0(r13.f13877b, r13.f13878c);
        r r60 = this.f13898n;
        r60.f13892h = r24;
        r60.d += r60.e;
        f0(r20, r60, r21, false);
        r r61 = this.f13898n;
        int r62 = r61.f13890b;
        int r63 = r61.f13891c;
        if (r63 <= 0) goto L215;
        t0(r58, r40);
        r r64 = this.f13898n;
        r64.f13892h = r63;
        f0(r20, r64, r21, false);
        r40 = this.f13898n.f13890b;
    L215:
        r35 = r62;
        goto L217
    L198:
        if (this.f13899o.e() != 0) goto L200;
        r32 = true;
        goto L201
    L178:
        r19 = -1;
        goto L179
    L52:
        r13.f13878c = this.f13899o.i() + this.f13905v.f13721b;
    L54:
        if (this.f13904u != Integer.MIN_VALUE) goto L83;
        View r65 = o(r15);
        if (r65 == null) goto L72;
        if (this.f13899o.b(r65) <= this.f13899o.j()) goto L61;
        r13.a();
        goto L174
    L61:
        if ((this.f13899o.d(r65) - this.f13899o.i()) >= 0) goto L64;
        r13.f13878c = this.f13899o.i();
        r13.d = false;
        goto L174
    L64:
        if ((this.f13899o.f() - this.f13899o.a(r65)) >= 0) goto L67;
        r13.f13878c = this.f13899o.f();
        r13.d = true;
        goto L174
    L67:
        if (r13.d == false) goto L69;
        int r66 = this.f13899o.k() + this.f13899o.a(r65);
    L70:
        r13.f13878c = r66;
        goto L174
    L69:
        r66 = this.f13899o.d(r65);
        goto L70
    L72:
        if (r() > 0) goto L74;
    L82:
        r13.a();
        goto L174
    L74:
        if (this.f13903t >= k0.B(q(0))) goto L76;
        boolean r67 = true;
    L78:
        if (r67 != this.f13901q) goto L80;
        boolean r68 = true;
    L81:
        r13.d = r68;
        goto L82
    L80:
        r68 = false;
        goto L81
    L76:
        r67 = false;
        goto L78
    L83:
        boolean r69 = this.f13901q;
        r13.d = r69;
        if (r69 == false) goto L86;
        r13.f13878c = this.f13899o.f() - this.f13904u;
        goto L174
    L86:
        r13.f13878c = this.f13899o.i() + this.f13904u;
    L89:
        if (r() == 0) goto L169;
        RecyclerView r70 = this.f13839b;
        if (r70 != null) goto L94;
    L93:
        View r71 = null;
    L99:
        if (r71 == null) goto L107;
        RecyclerView.LayoutParams r72 = (RecyclerView.LayoutParams) r71.getLayoutParams();
        if (r72.f13768a.isRemoved() == true) goto L107;
        if (r72.f13768a.getLayoutPosition() < 0) goto L107;
        if (r72.f13768a.getLayoutPosition() >= r21.b()) goto L107;
        r13.c(r71, k0.B(r71));
    L107:
        boolean r73 = this.f13900p;
        boolean r74 = this.f13902r;
        if (r73 != r74) goto L169;
        boolean r75 = r13.d;
        e0();
        int r115 = r();
        if (r74 == false) goto L113;
        int r76 = r() - 1;
        r115 = -1;
        int r116 = -1;
    L114:
        int r117 = r21.b();
        int r118 = this.f13899o.i();
        int r119 = this.f13899o.f();
        View r120 = null;
        View r121 = null;
        View r122 = null;
    L115:
        if (r76 == r115) goto L143;
        View r77 = q(r76);
        int r123 = k0.B(r77);
        int r78 = this.f13899o.d(r77);
        int r79 = this.f13899o.a(r77);
        if (r123 < 0) goto L142;
        if (r123 >= r117) goto L142;
        if (((RecyclerView.LayoutParams) r77.getLayoutParams()).f13768a.isRemoved() == false) goto L123;
        if (r122 != null) goto L142;
        r122 = r77;
        goto L142
    L123:
        if (r79 > r118) goto L126;
        if (r78 >= r118) goto L126;
        boolean r124 = true;
    L127:
        if (r78 < r119) goto L130;
        if (r79 <= r119) goto L130;
        boolean r80 = true;
    L131:
        if (r124 == true) goto L133;
        if (r80 == true) goto L133;
    L149:
        if (r77 == null) goto L169;
        r13.b(r77, k0.B(r77));
        if (r21.f == true) goto L174;
        if (a0() == false) goto L174;
        int r81 = this.f13899o.d(r77);
        int r82 = this.f13899o.a(r77);
        int r83 = this.f13899o.i();
        int r84 = this.f13899o.f();
        if (r82 > r83) goto L158;
        if (r81 >= r83) goto L158;
        boolean r85 = true;
    L159:
        if (r81 < r84) goto L162;
        if (r82 <= r84) goto L162;
        boolean r86 = true;
    L163:
        if (r85 == true) goto L166;
        if (r86 == false) goto L174;
    L166:
        if (r13.d == false) goto L168;
        r83 = r84;
    L168:
        r13.f13878c = r83;
    L162:
        r86 = false;
    L158:
        r85 = false;
    L133:
        if (r75 == false) goto L138;
        if (r80 == true) goto L139;
        if (r120 != null) goto L142;
    L141:
        r120 = r77;
    L139:
        r121 = r77;
        goto L142
    L138:
        if (r124 == true) goto L139;
        if (r120 != null) goto L142;
    L130:
        r80 = false;
    L126:
        r124 = false;
    L142:
        r76 = r76 + r116;
        goto L115
    L143:
        if (r120 != null) goto L148;
        if (r121 == null) goto L147;
        r120 = r121;
        goto L148
    L147:
        r120 = r122;
    L148:
        r77 = r120;
        goto L149
    L113:
        r76 = 0;
        r116 = 1;
        goto L114
    L94:
        r71 = r70.getFocusedChild();
        if (r71 == null) goto L93;
        if (((ArrayList) this.f13838a.d).contains(r71) == false) goto L99;
    L169:
        r13.a();
        if (this.f13902r == false) goto L172;
        int r87 = r21.b() - 1;
    L173:
        r13.f13877b = r87;
        goto L174
    L172:
        r87 = 0;
        goto L173
    L26:
        if (this.f13903t != (-1)) goto L36;
        if (this.f13905v != null) goto L36;
        if (r12 == null) goto L175;
        if (this.f13899o.d(r12) < this.f13899o.f()) goto L34;
    L35:
        r13.c(r12, k0.B(r12));
        goto L175
    L34:
        if (this.f13899o.a(r12) > this.f13899o.i()) goto L175;
    L18:
        r12 = r11.getFocusedChild();
        if (r12 == null) goto L17;
        if (((ArrayList) this.f13838a.d).contains(r12) == false) goto L23;
    L7:
        if (r21.b() != 0) goto L10;
        M(r20);
    }

    @Override // com.obric.oui.orecyclerview.widget.k0
    public final void J() {
        this.f13905v = null;
        this.f13903t = -1;
        this.f13904u = Integer.MIN_VALUE;
        this.f13906w.d();
    }

    @Override // com.obric.oui.orecyclerview.widget.k0
    public final void K(Parcelable r5) {
        if ((r5 instanceof LinearLayoutManager$SavedState) == false) goto L9;
        LinearLayoutManager$SavedState r10 = (LinearLayoutManager$SavedState) r5;
        this.f13905v = r10;
        if (this.f13903t == (-1)) goto L7;
        r10.f13720a = -1;
    L7:
        Q();
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.k0
    public final Parcelable L() {
        LinearLayoutManager$SavedState r5 = this.f13905v;
        if (r5 == null) goto L6;
        LinearLayoutManager$SavedState r10 = new LinearLayoutManager$SavedState();
        r10.f13720a = r5.f13720a;
        r10.f13721b = r5.f13721b;
        r10.f13722c = r5.f13722c;
        return r10;
    L6:
        LinearLayoutManager$SavedState r11 = new LinearLayoutManager$SavedState();
        if (r() <= 0) goto L12;
        e0();
        boolean r12 = this.f13900p ^ this.f13901q;
        r11.f13722c = r12;
        if (r12 == false) goto L11;
        View r13 = m0();
        r11.f13721b = this.f13899o.f() - this.f13899o.a(r13);
        r11.f13720a = k0.B(r13);
    L13:
        return r11;
    L11:
        View r14 = n0();
        r11.f13720a = k0.B(r14);
        r11.f13721b = this.f13899o.d(r14) - this.f13899o.i();
        goto L13
    L12:
        r11.f13720a = -1;
        goto L13
    }

    @Override // com.obric.oui.orecyclerview.widget.k0
    public final int S(int r5, q0 r10, u0 r11) {
        if (this.f13897m != 1) goto L7;
        return 0;
    L7:
        return r0(r5, r10, r11);
    }

    @Override // com.obric.oui.orecyclerview.widget.k0
    public final void T(int r5) {
        this.f13903t = r5;
        this.f13904u = Integer.MIN_VALUE;
        LinearLayoutManager$SavedState r10 = this.f13905v;
        if (r10 == null) goto L5;
        r10.f13720a = -1;
    L5:
        Q();
    }

    @Override // com.obric.oui.orecyclerview.widget.k0
    public final int U(int r5, q0 r10, u0 r11) {
        if (this.f13897m != 0) goto L7;
        return 0;
    L7:
        return r0(r5, r10, r11);
    }

    @Override // com.obric.oui.orecyclerview.widget.k0
    public final boolean Z() {
        if (this.f13843j != 1073741824) goto L5;
        return false;
    L5:
        if (this.f13842i == 1073741824) goto L19;
        int r5 = r();
        int r10 = 0;
    L7:
        if (r10 >= r5) goto L21;
        ViewGroup.LayoutParams r11 = q(r10).getLayoutParams();
        if (r11.width >= 0) goto L13;
        if (r11.height >= 0) goto L13;
        return true;
    L13:
        r10 = r10 + 1;
        goto L7
    L21:
        return false;
    L19:
        return false;
    }

    @Override // com.obric.oui.orecyclerview.widget.k0
    public final boolean a0() {
        if (this.f13905v == null) goto L5;
    L7:
        return false;
    L5:
        if (this.f13900p != this.f13902r) goto L7;
        return true;
    }

    @Override // com.obric.oui.orecyclerview.widget.k0
    public final void b(String r5) {
        if (this.f13905v != null) goto L6;
        super.b(r5);
        return;
    }

    public final int b0(u0 r10) {
        if (r() != 0) goto L5;
        return 0;
    L5:
        e0();
        v r5 = this.f13899o;
        boolean r11 = this.s;
        boolean r12 = !r11;
        View r13 = h0(r12);
        View r14 = g0(r12);
        if (r() != 0) goto L8;
        return 0;
    L8:
        if (r10.b() == 0) goto L17;
        if (r13 == null) goto L18;
        if (r14 == null) goto L20;
        if (r11 == true) goto L15;
        return Math.abs(k0.B(r13) - k0.B(r14)) + 1;
    L15:
        return Math.min(r5.j(), r5.a(r14) - r5.d(r13));
    L20:
        return 0;
    L18:
        return 0;
    L17:
        return 0;
    }

    @Override // com.obric.oui.orecyclerview.widget.k0
    public final boolean c() {
        if (this.f13897m != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final int c0(u0 r10) {
        if (r() != 0) goto L5;
        return 0;
    L5:
        e0();
        v r5 = this.f13899o;
        boolean r11 = this.s;
        boolean r12 = !r11;
        View r13 = h0(r12);
        View r14 = g0(r12);
        boolean r15 = this.f13901q;
        if (r() != 0) goto L8;
        return 0;
    L8:
        if (r10.b() == 0) goto L22;
        if (r13 == null) goto L23;
        if (r14 == null) goto L24;
        int r16 = Math.min(k0.B(r13), k0.B(r14));
        int r17 = Math.max(k0.B(r13), k0.B(r14));
        if (r15 == false) goto L16;
        int r18 = Math.max(0, (r10.b() - r17) - 1);
    L15:
        int r19 = r18;
        if (r11 == true) goto L20;
        return r19;
    L20:
        return Math.round((r19 * (Math.abs(r5.a(r14) - r5.d(r13)) / (Math.abs(k0.B(r13) - k0.B(r14)) + 1))) + (r5.i() - r5.d(r13)));
    L16:
        r18 = Math.max(0, r16);
        goto L15
    L24:
        return 0;
    L23:
        return 0;
    L22:
        return 0;
    }

    @Override // com.obric.oui.orecyclerview.widget.k0
    public final boolean d() {
        if (this.f13897m == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final int d0(u0 r10) {
        if (r() != 0) goto L5;
        return 0;
    L5:
        e0();
        v r5 = this.f13899o;
        boolean r11 = this.s;
        boolean r12 = !r11;
        View r13 = h0(r12);
        View r14 = g0(r12);
        if (r() != 0) goto L8;
        return 0;
    L8:
        if (r10.b() == 0) goto L17;
        if (r13 == null) goto L18;
        if (r14 == null) goto L20;
        if (r11 == true) goto L15;
        return r10.b();
    L15:
        return (int) (((r5.a(r14) - r5.d(r13)) / (Math.abs(k0.B(r13) - k0.B(r14)) + 1)) * r10.b());
    L20:
        return 0;
    L18:
        return 0;
    L17:
        return 0;
    }

    public final void e0() {
        if (this.f13898n != null) goto L6;
        r r5 = new r();
        r5.f13889a = true;
        r5.f13892h = 0;
        r5.f13893i = 0;
        r5.f13895k = null;
        this.f13898n = r5;
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.k0
    public final void f(int r5, int r10, u0 r11, com.airbnb.lottie.parser.moshi.c r12) {
        if (this.f13897m == 0) goto L7;
        r5 = r10;
    L7:
        if (r() == 0) goto L20;
        if (r5 == 0) goto L23;
        e0();
        if (r5 <= 0) goto L13;
        int r13 = 1;
    L14:
        s0(r13, Math.abs(r5), true, r11);
        r r14 = this.f13898n;
        int r15 = r14.d;
        if (r15 >= 0) goto L17;
        return;
    L17:
        if (r15 >= r11.b()) goto L22;
        r12.e(r15, Math.max(0, r14.g));
        return;
    L22:
        return;
    L13:
        r13 = -1;
        goto L14
    L23:
        return;
    }

    public final int f0(q0 r18, r r19, u0 r20, boolean r21) {
        int r5 = r19.f13891c;
        int r10 = r19.g;
        if (r10 == Integer.MIN_VALUE) goto L7;
        if (r5 >= 0) goto L6;
        r19.g = r10 + r5;
    L6:
        o0(r18, r19);
    L7:
        int r11 = r19.f13891c + r19.f13892h;
    L9:
        if (r19.f13896l == true) goto L11;
        if (r11 > 0) goto L11;
    L92:
        return r5 - r19.f13891c;
    L11:
        int r12 = r19.d;
        if (r12 < 0) goto L92;
        if (r12 >= r20.b()) goto L92;
        q r13 = this.f13907x;
        r13.f13882a = 0;
        r13.f13883b = false;
        r13.f13884c = false;
        r13.d = false;
        List r14 = r19.f13895k;
        if (r14 == null) goto L28;
        int r15 = r14.size();
        int r16 = 0;
    L18:
        if (r16 >= r15) goto L26;
        View r17 = ((x0) r19.f13895k.get(r16)).itemView;
        RecyclerView.LayoutParams r110 = (RecyclerView.LayoutParams) r17.getLayoutParams();
        if (r110.f13768a.isRemoved() == true) goto L25;
        if (r19.d != r110.f13768a.getLayoutPosition()) goto L25;
        r19.a(r17);
    L30:
        if (r17 != null) goto L32;
        r13.f13883b = true;
    L69:
        if (r13.f13883b == true) goto L92;
        int r22 = r19.f13890b;
        int r23 = r13.f13882a;
        r19.f13890b = (r19.f * r23) + r22;
        if (r13.f13884c == false) goto L79;
        if (r19.f13895k != null) goto L79;
        if (r20.f == false) goto L79;
    L80:
        int r24 = r19.g;
        if (r24 == Integer.MIN_VALUE) goto L86;
        int r25 = r24 + r23;
        r19.g = r25;
        int r26 = r19.f13891c;
        if (r26 >= 0) goto L85;
        r19.g = r25 + r26;
    L85:
        o0(r18, r19);
    L86:
        if (r21 == false) goto L9;
        if (r13.d == false) goto L9;
    L79:
        r19.f13891c -= r23;
        r11 = r11 - r23;
        goto L80
    L32:
        RecyclerView.LayoutParams r27 = (RecyclerView.LayoutParams) r17.getLayoutParams();
        if (r19.f13895k != null) goto L41;
        boolean r111 = this.f13901q;
        if (r19.f != (-1)) goto L37;
        boolean r112 = true;
    L38:
        if (r111 != r112) goto L40;
        a(r17, -1, false);
    L48:
        F(r17);
        r13.f13882a = this.f13899o.b(r17);
        if (this.f13897m == 1) goto L51;
        int r113 = A();
        int r28 = this.f13899o.c(r17) + r113;
        if (r19.f != (-1)) goto L61;
        int r114 = r19.f13890b;
        int r115 = r28;
        int r29 = r114;
        int r116 = r114 - r13.f13882a;
    L62:
        RecyclerView.LayoutParams r117 = (RecyclerView.LayoutParams) r17.getLayoutParams();
        Rect r118 = r117.f13769b;
        r17.layout((r116 + r118.left) + ((ViewGroup.MarginLayoutParams) r117).leftMargin, (r113 + r118.top) + ((ViewGroup.MarginLayoutParams) r117).topMargin, (r29 - r118.right) - ((ViewGroup.MarginLayoutParams) r117).rightMargin, (r115 - r118.bottom) - ((ViewGroup.MarginLayoutParams) r117).bottomMargin);
        if (r27.f13768a.isRemoved() == false) goto L65;
    L66:
        r13.f13884c = true;
    L67:
        r13.d = r17.hasFocusable();
        goto L69
    L65:
        if (r27.f13768a.isUpdated() == false) goto L67;
    L61:
        r116 = r19.f13890b;
        r115 = r28;
        r29 = r13.f13882a + r116;
        goto L62
    L51:
        if (ViewCompat.getLayoutDirection(this.f13839b) != 1) goto L53;
        r29 = this.f13844k - z();
        r116 = r29 - this.f13899o.c(r17);
    L55:
        if (r19.f != (-1)) goto L57;
        r115 = r19.f13890b;
        r113 = r115 - r13.f13882a;
        goto L62
    L57:
        r113 = r19.f13890b;
        r115 = r13.f13882a + r113;
        goto L62
    L53:
        r116 = y();
        r29 = this.f13899o.c(r17) + r116;
        goto L55
    L40:
        a(r17, 0, false);
        goto L48
    L37:
        r112 = false;
        goto L38
    L41:
        boolean r119 = this.f13901q;
        if (r19.f != (-1)) goto L44;
        boolean r120 = true;
    L45:
        if (r119 != r120) goto L47;
        a(r17, -1, true);
        goto L48
    L47:
        a(r17, 0, true);
        goto L48
    L44:
        r120 = false;
    L25:
        r16 = r16 + 1;
        goto L18
    L26:
        r17 = null;
        goto L30
    L28:
        r17 = r18.j(r19.d, Long.MAX_VALUE).itemView;
        r19.d += r19.e;
        goto L30
    }

    @Override // com.obric.oui.orecyclerview.widget.k0
    public final void g(int r10, com.airbnb.lottie.parser.moshi.c r11) {
        LinearLayoutManager$SavedState r5 = this.f13905v;
        int r12 = -1;
        if (r5 == null) goto L7;
        int r13 = r5.f13720a;
        if (r13 < 0) goto L7;
        boolean r14 = r5.f13722c;
    L12:
        if (r14 == true) goto L15;
        r12 = 1;
    L15:
        int r15 = 0;
    L17:
        if (r15 >= this.f13908y) goto L21;
        if (r13 < 0) goto L25;
        if (r13 >= r10) goto L26;
        r11.e(r13, 0);
        r13 = r13 + r12;
        r15 = r15 + 1;
        goto L17
    L26:
        return;
    L25:
        return;
    L21:
        return;
    L7:
        q0();
        r14 = this.f13901q;
        r13 = this.f13903t;
        if (r13 != (-1)) goto L12;
        if (r14 == false) goto L11;
        r13 = r10 - 1;
        goto L12
    L11:
        r13 = 0;
        goto L12
    }

    public final View g0(boolean r5) {
        if (this.f13901q == false) goto L7;
        return j0(0, r(), r5);
    L7:
        return j0(r() - 1, -1, r5);
    }

    @Override // com.obric.oui.orecyclerview.widget.k0
    public final int h(u0 r5) {
        return b0(r5);
    }

    public final View h0(boolean r5) {
        if (this.f13901q == false) goto L7;
        return j0(r() - 1, -1, r5);
    L7:
        return j0(0, r(), r5);
    }

    @Override // com.obric.oui.orecyclerview.widget.k0
    public final int i(u0 r5) {
        return c0(r5);
    }

    public final View i0(int r5, int r10) {
        e0();
        if (r10 > r5) goto L7;
        if (r10 < r5) goto L7;
        return q(r5);
    L7:
        if (this.f13899o.d(q(r5)) >= this.f13899o.i()) goto L9;
        int r11 = 16644;
        int r12 = 16388;
    L11:
        if (this.f13897m != 0) goto L14;
        return this.f13840c.i(r5, r10, r11, r12);
    L14:
        return this.d.i(r5, r10, r11, r12);
    L9:
        r11 = 4161;
        r12 = FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
        goto L11
    }

    @Override // com.obric.oui.orecyclerview.widget.k0
    public final int j(u0 r5) {
        return d0(r5);
    }

    public final View j0(int r5, int r10, boolean r11) {
        e0();
        if (r11 == false) goto L5;
        int r12 = 24579;
    L7:
        if (this.f13897m != 0) goto L10;
        return this.f13840c.i(r5, r10, r12, 320);
    L10:
        return this.d.i(r5, r10, r12, 320);
    L5:
        r12 = 320;
        goto L7
    }

    @Override // com.obric.oui.orecyclerview.widget.k0
    public final int k(u0 r5) {
        return b0(r5);
    }

    public final int k0(int r5, q0 r10, u0 r11, boolean r12) {
        int r13 = this.f13899o.f() - r5;
        if (r13 <= 0) goto L11;
        int r14 = -r0(-r13, r10, r11);
        int r15 = r5 + r14;
        if (r12 == false) goto L10;
        int r16 = this.f13899o.f() - r15;
        if (r16 <= 0) goto L10;
        this.f13899o.n(r16);
        return r16 + r14;
    L10:
        return r14;
    L11:
        return 0;
    }

    @Override // com.obric.oui.orecyclerview.widget.k0
    public final int l(u0 r5) {
        return c0(r5);
    }

    public final int l0(int r5, q0 r10, u0 r11, boolean r12) {
        int r13 = r5 - this.f13899o.i();
        if (r13 <= 0) goto L10;
        int r14 = -r0(r13, r10, r11);
        int r15 = r5 + r14;
        if (r12 == false) goto L12;
        int r16 = r15 - this.f13899o.i();
        if (r16 <= 0) goto L13;
        this.f13899o.n(-r16);
        return r14 - r16;
    L13:
        return r14;
    L12:
        return r14;
    L10:
        return 0;
    }

    @Override // com.obric.oui.orecyclerview.widget.k0
    public final int m(u0 r5) {
        return d0(r5);
    }

    public final View m0() {
        if (this.f13901q == false) goto L5;
        int r5 = 0;
    L7:
        return q(r5);
    L5:
        r5 = r() - 1;
        goto L7
    }

    public final View n0() {
        if (this.f13901q == false) goto L5;
        int r5 = r() - 1;
    L7:
        return q(r5);
    L5:
        r5 = 0;
        goto L7
    }

    @Override // com.obric.oui.orecyclerview.widget.k0
    public final View o(int r5) {
        int r10 = r();
        if (r10 != 0) goto L6;
        return null;
    L6:
        int r11 = r5 - k0.B(q(0));
        if (r11 < 0) goto L13;
        if (r11 >= r10) goto L13;
        View r12 = q(r11);
        if (k0.B(r12) != r5) goto L13;
        return r12;
    L13:
        return super.o(r5);
    }

    public final void o0(q0 r10, r r11) {
        if (r11.f13889a == true) goto L5;
        return;
    L5:
        if (r11.f13896l == true) goto L71;
        int r5 = r11.g;
        int r12 = r11.f13893i;
        if (r11.f != (-1)) goto L32;
        int r13 = r();
        if (r5 < 0) goto L72;
        int r14 = (this.f13899o.e() - r5) + r12;
        if (this.f13901q == false) goto L23;
        int r15 = 0;
    L15:
        if (r15 >= r13) goto L74;
        View r16 = q(r15);
        if (this.f13899o.d(r16) < r14) goto L22;
        if (this.f13899o.m(r16) < r14) goto L22;
        r15 = r15 + 1;
    L22:
        p0(r10, 0, r15);
        return;
    L74:
        return;
    L23:
        int r17 = r13 - 1;
        int r18 = r17;
    L24:
        if (r18 < 0) goto L75;
        View r19 = q(r18);
        if (this.f13899o.d(r19) < r14) goto L31;
        if (this.f13899o.m(r19) < r14) goto L31;
        r18 = r18 - 1;
    L31:
        p0(r10, r17, r18);
        return;
    L75:
        return;
    L72:
        return;
    L32:
        if (r5 < 0) goto L73;
        int r20 = r5 - r12;
        int r21 = r();
        if (this.f13901q == false) goto L45;
        int r22 = r21 - 1;
        int r23 = r22;
    L37:
        if (r23 < 0) goto L76;
        View r24 = q(r23);
        if (this.f13899o.a(r24) > r20) goto L44;
        if (this.f13899o.l(r24) > r20) goto L44;
        r23 = r23 - 1;
    L44:
        p0(r10, r22, r23);
        return;
    L76:
        return;
    L45:
        int r25 = 0;
    L46:
        if (r25 >= r21) goto L77;
        View r26 = q(r25);
        if (this.f13899o.a(r26) > r20) goto L53;
        if (this.f13899o.l(r26) > r20) goto L53;
        r25 = r25 + 1;
    L53:
        p0(r10, 0, r25);
        return;
    L77:
        return;
    L73:
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.k0
    public final RecyclerView.LayoutParams p() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public final void p0(q0 r5, int r10, int r11) {
        if (r10 != r11) goto L4;
        return;
    L4:
        if (r11 <= r10) goto L8;
        int r12 = r11 - 1;
    L6:
        if (r12 < r10) goto L10;
        View r13 = q(r12);
        O(r12);
        r5.g(r13);
        r12 = r12 - 1;
        goto L6
    L10:
        return;
    L8:
        if (r10 <= r11) goto L13;
        View r14 = q(r10);
        O(r10);
        r5.g(r14);
        r10 = r10 - 1;
        goto L8
    }

    public final void q0() {
        if (this.f13897m != 1) goto L5;
    L7:
        this.f13901q = false;
        return;
    L5:
        if (ViewCompat.getLayoutDirection(this.f13839b) != 1) goto L7;
        this.f13901q = true;
    }

    public final int r0(int r10, q0 r11, u0 r12) {
        if (r() == 0) goto L17;
        if (r10 == 0) goto L17;
        e0();
        this.f13898n.f13889a = true;
        if (r10 <= 0) goto L9;
        int r5 = 1;
    L10:
        int r13 = Math.abs(r10);
        s0(r5, r13, true, r12);
        r r14 = this.f13898n;
        int r15 = f0(r11, r14, r12, false) + r14.g;
        if (r15 >= 0) goto L13;
        return 0;
    L13:
        if (r13 <= r15) goto L15;
        r10 = r5 * r15;
    L15:
        this.f13899o.n(-r10);
        this.f13898n.f13894j = r10;
        return r10;
    L9:
        r5 = -1;
    L17:
        return 0;
    }

    public final void s0(int r5, int r10, boolean r11, u0 r12) {
        r r13 = this.f13898n;
        boolean r14 = false;
        int r15 = 1;
        if (this.f13899o.h() == 0) goto L5;
    L7:
        boolean r16 = false;
    L8:
        r13.f13896l = r16;
        this.f13898n.f = r5;
        int[] r17 = this.f13909z;
        r17[0] = 0;
        r17[1] = 0;
        r12.getClass();
        int r18 = this.f13898n.f;
        r17[0] = 0;
        r17[1] = 0;
        int r19 = Math.max(0, 0);
        int r20 = Math.max(0, r17[1]);
        if (r5 != 1) goto L11;
        r14 = true;
    L11:
        r r21 = this.f13898n;
        if (r14 == false) goto L14;
        int r22 = r20;
    L15:
        r21.f13892h = r22;
        if (r14 == true) goto L19;
        r19 = r20;
    L19:
        r21.f13893i = r19;
        if (r14 == false) goto L25;
        r21.f13892h = this.f13899o.g() + r22;
        View r23 = m0();
        r r24 = this.f13898n;
        if (this.f13901q == false) goto L24;
        r15 = -1;
    L24:
        r24.e = r15;
        int r25 = k0.B(r23);
        r r26 = this.f13898n;
        r24.d = r25 + r26.e;
        r26.f13890b = this.f13899o.a(r23);
        int r27 = this.f13899o.a(r23) - this.f13899o.f();
    L30:
        r r28 = this.f13898n;
        r28.f13891c = r10;
        if (r11 == false) goto L33;
        r28.f13891c = r10 - r27;
    L33:
        r28.g = r27;
        return;
    L25:
        View r29 = n0();
        r r30 = this.f13898n;
        r30.f13892h = this.f13899o.i() + r30.f13892h;
        r r31 = this.f13898n;
        if (this.f13901q == true) goto L29;
        r15 = -1;
    L29:
        r31.e = r15;
        int r32 = k0.B(r29);
        r r33 = this.f13898n;
        r31.d = r32 + r33.e;
        r33.f13890b = this.f13899o.d(r29);
        r27 = (-this.f13899o.d(r29)) + this.f13899o.i();
        goto L30
    L14:
        r22 = r19;
        goto L15
    L5:
        if (this.f13899o.e() != 0) goto L7;
        r16 = true;
        goto L8
    }

    public final void t0(int r5, int r10) {
        this.f13898n.f13891c = this.f13899o.f() - r10;
        r r11 = this.f13898n;
        if (this.f13901q == false) goto L5;
        int r12 = -1;
    L6:
        r11.e = r12;
        r11.d = r5;
        r11.f = 1;
        r11.f13890b = r10;
        r11.g = Integer.MIN_VALUE;
        return;
    L5:
        r12 = 1;
        goto L6
    }

    public final void u0(int r5, int r10) {
        this.f13898n.f13891c = r10 - this.f13899o.i();
        r r11 = this.f13898n;
        r11.d = r5;
        if (this.f13901q == false) goto L5;
        int r12 = 1;
    L6:
        r11.e = r12;
        r11.f = -1;
        r11.f13890b = r10;
        r11.g = Integer.MIN_VALUE;
        return;
    L5:
        r12 = -1;
        goto L6
    }
}
