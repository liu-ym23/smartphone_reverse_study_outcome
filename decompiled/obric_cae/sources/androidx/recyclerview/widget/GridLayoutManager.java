package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import j0.h0;
import java.util.Arrays;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    public boolean E;
    public int F;
    public int[] G;
    public View[] H;
    public final SparseIntArray I;
    public final SparseIntArray J;
    public final a K;
    public final Rect L;

    public static final class a extends c {
    }

    public static class b extends RecyclerView.p {
        public static final int INVALID_SPAN_ID = -1;
        int mSpanIndex;
        int mSpanSize;

        public b(int r8, int r10) {
            super(r8, r10);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public int getSpanIndex() {
            return this.mSpanIndex;
        }

        public int getSpanSize() {
            return this.mSpanSize;
        }

        public b(Context r8, AttributeSet r10) {
            super(r8, r10);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public b(ViewGroup.LayoutParams r8) {
            super(r8);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public b(ViewGroup.MarginLayoutParams r8) {
            super(r8);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public b(RecyclerView.p r8) {
            super(r8);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }
    }

    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SparseIntArray f2233a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SparseIntArray f2234b;

        public c() {
            this.f2233a = new SparseIntArray();
            this.f2234b = new SparseIntArray();
        }

        public static int a(int r8, int r10) {
            int r11 = 0;
            int r12 = 0;
            int r13 = 0;
        L4:
            if (r11 >= r8) goto L12;
            r12 = r12 + 1;
            if (r12 != r10) goto L8;
            r13 = r13 + 1;
            r12 = 0;
        L10:
            r11 = r11 + 1;
            goto L4
        L8:
            if (r12 <= r10) goto L10;
            r13 = r13 + 1;
            r12 = 1;
            goto L10
        L12:
            if ((r12 + 1) > r10) goto L14;
            return r13;
        L14:
            return r13 + 1;
        }

        public final void b() {
            this.f2233a.clear();
        }
    }

    public GridLayoutManager(int r8) {
        super(1);
        this.E = false;
        this.F = -1;
        this.I = new SparseIntArray();
        this.J = new SparseIntArray();
        this.K = new a();
        this.L = new Rect();
        k1(r8);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void A0(RecyclerView.z r8, LinearLayoutManager.c r10, RecyclerView.o.c r11) {
        int r12 = this.F;
        int r13 = 0;
    L4:
        if (r13 >= this.F) goto L14;
        int r14 = r10.f2261d;
        if (r14 >= 0) goto L8;
    L10:
        boolean r15 = false;
    L11:
        if (r15 == false) goto L18;
        if (r12 <= 0) goto L19;
        ((m.b) r11).a(r10.f2261d, Math.max(0, r10.f2264g));
        this.K.getClass();
        r12 = r12 - 1;
        r10.f2261d += r10.f2262e;
        r13 = r13 + 1;
        goto L4
    L19:
        return;
    L18:
        return;
    L8:
        if (r14 >= r8.b()) goto L10;
        r15 = true;
        goto L11
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final int I(RecyclerView.v r8, RecyclerView.z r10) {
        if (this.f2235p != 0) goto L7;
        return this.F;
    L7:
        if (r10.b() >= 1) goto L11;
        return 0;
    L11:
        return g1(r10.b() - 1, r8, r10) + 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final View N0(RecyclerView.v r8, RecyclerView.z r10, int r11, int r12, int r13) {
        F0();
        int r14 = this.f2237r.k();
        int r15 = this.f2237r.g();
        if (r12 <= r11) goto L5;
        int r16 = 1;
    L6:
        View r17 = null;
        View r18 = null;
    L7:
        if (r11 == r12) goto L27;
        View r19 = v(r11);
        int r20 = RecyclerView.o.G(r19);
        if (r20 < 0) goto L26;
        if (r20 >= r13) goto L26;
        if (h1(r20, r8, r10) != 0) goto L26;
        if (((RecyclerView.p) r19.getLayoutParams()).isItemRemoved() == false) goto L19;
        if (r18 != null) goto L26;
        r18 = r19;
        goto L26
    L19:
        if (this.f2237r.e(r19) < r15) goto L21;
    L24:
        if (r17 != null) goto L26;
        r17 = r19;
        goto L26
    L21:
        if (this.f2237r.b(r19) < r14) goto L24;
        return r19;
    L26:
        r11 = r11 + r16;
        goto L7
    L27:
        if (r17 == null) goto L30;
        return r17;
    L30:
        return r18;
    L5:
        r16 = -1;
        goto L6
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public final View R(View r23, int r24, RecyclerView.v r25, RecyclerView.z r26) {
        RecyclerView.v r8 = r25;
        RecyclerView.z r10 = r26;
        RecyclerView r11 = this.f2314b;
        View r12 = null;
        if (r11 != null) goto L5;
    L4:
        View r13 = null;
    L11:
        if (r13 != null) goto L13;
        return null;
    L13:
        b r14 = (b) r13.getLayoutParams();
        int r15 = r14.mSpanIndex;
        int r16 = r14.mSpanSize + r15;
        if (super.R(r23, r24, r25, r26) != null) goto L17;
        return null;
    L17:
        if (E0(r24) != 1) goto L19;
        boolean r17 = true;
    L21:
        if (r17 == this.f2240u) goto L23;
        boolean r18 = true;
    L25:
        if (r18 == false) goto L27;
        int r19 = w() - 1;
        int r110 = -1;
        int r111 = -1;
    L29:
        if (this.f2235p == 1) goto L31;
    L33:
        boolean r112 = false;
    L34:
        int r113 = g1(r19, r8, r10);
        int r20 = -1;
        int r114 = -1;
        int r115 = r111;
        int r21 = 0;
        int r116 = 0;
        int r117 = r19;
        View r22 = null;
    L35:
        if (r117 == r110) goto L93;
        int r118 = r110;
        int r119 = g1(r117, r8, r10);
        View r27 = v(r117);
        if (r27 == r13) goto L93;
        if (r27.hasFocusable() == false) goto L45;
        if (r119 == r113) goto L45;
        if (r12 != null) goto L93;
        View r120 = r13;
        View r28 = r22;
        int r121 = r21;
    L91:
        r21 = r121;
        r22 = r28;
    L92:
        r117 = r117 + r115;
        r8 = r25;
        r10 = r26;
        r110 = r118;
        r13 = r120;
    L45:
        b r122 = (b) r27.getLayoutParams();
        int r29 = r122.mSpanIndex;
        r120 = r13;
        int r30 = r122.mSpanSize + r29;
        if (r27.hasFocusable() == false) goto L51;
        if (r29 != r15) goto L51;
        if (r30 != r16) goto L51;
        return r27;
    L51:
        if (r27.hasFocusable() == false) goto L54;
        if (r12 != null) goto L54;
    L56:
        r28 = r22;
    L66:
        r121 = r21;
        boolean r31 = true;
    L86:
        if (r31 == false) goto L91;
        if (r27.hasFocusable() == false) goto L90;
        int r32 = r122.mSpanIndex;
        r21 = Math.min(r30, r16) - Math.max(r29, r15);
        r114 = r32;
        r22 = r28;
        r12 = r27;
        goto L92
    L90:
        int r33 = r122.mSpanIndex;
        r116 = Math.min(r30, r16) - Math.max(r29, r15);
        r20 = r33;
        r21 = r121;
        r22 = r27;
    L54:
        if (r27.hasFocusable() == true) goto L57;
        if (r22 == null) goto L56;
    L57:
        r28 = r22;
        int r34 = Math.min(r30, r16) - Math.max(r29, r15);
        if (r27.hasFocusable() == false) goto L67;
        if (r34 > r21) goto L66;
        if (r34 != r21) goto L84;
        if (r29 <= r114) goto L64;
        boolean r35 = true;
    L65:
        if (r112 != r35) goto L84;
    L64:
        r35 = false;
    L84:
        r121 = r21;
    L85:
        r31 = false;
        goto L86
    L67:
        if (r12 != null) goto L84;
        r121 = r21;
        if (this.f2315c.b(r27) == true) goto L71;
    L73:
        boolean r36 = false;
    L75:
        if ((!r36) == false) goto L85;
        if (r34 > r116) goto L83;
        if (r34 != r116) goto L85;
        if (r29 <= r20) goto L81;
        boolean r37 = true;
    L82:
        if (r112 != r37) goto L85;
    L81:
        r37 = false;
    L83:
        r31 = true;
        goto L86
    L71:
        if (this.f2316d.b(r27) == false) goto L73;
        r36 = true;
    L93:
        View r210 = r22;
        if (r12 == null) goto L97;
        return r12;
    L97:
        return r210;
    L31:
        if (S0() == false) goto L33;
        r112 = true;
        goto L34
    L27:
        r110 = w();
        r111 = 1;
        r19 = 0;
        goto L29
    L23:
        r18 = false;
        goto L25
    L19:
        r17 = false;
        goto L21
    L5:
        r13 = r11.findContainingItemView(r23);
        if (r13 == null) goto L4;
        if (this.f2313a.j(r13) == false) goto L11;
        goto L11
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void T0(RecyclerView.v r19, RecyclerView.z r20, LinearLayoutManager.c r21, LinearLayoutManager.b r22) {
        int r8 = this.f2237r.j();
        int r10 = 1;
        if (r8 == 1073741824) goto L5;
        boolean r11 = true;
    L7:
        if (w() <= 0) goto L9;
        int r12 = this.G[this.F];
    L10:
        if (r11 == false) goto L13;
        l1();
    L13:
        if (r21.f2262e != 1) goto L15;
        boolean r13 = true;
    L16:
        int r14 = this.F;
        if (r13 == true) goto L19;
        r14 = h1(r21.f2261d, r19, r20) + i1(r21.f2261d, r19, r20);
    L19:
        int r15 = 0;
    L21:
        if (r15 >= this.F) goto L41;
        int r16 = r21.f2261d;
        if (r16 >= 0) goto L25;
    L27:
        boolean r17 = false;
    L28:
        if (r17 == false) goto L41;
        if (r14 <= 0) goto L41;
        int r18 = r21.f2261d;
        int r110 = i1(r18, r19, r20);
        if (r110 > this.F) goto L40;
        r14 = r14 - r110;
        if (r14 < 0) goto L41;
        View r111 = r21.b(r19);
        if (r111 == null) goto L41;
        this.H[r15] = r111;
        r15 = r15 + 1;
        goto L21
    L40:
        throw new IllegalArgumentException(android.aimedia.a.h(defpackage.a.g("Item at position ", r18, " requires ", r110, " spans but GridLayoutManager has only "), this.F, " spans."));
    L25:
        if (r16 >= r20.b()) goto L27;
        r17 = true;
    L41:
        if (r15 != 0) goto L44;
        r22.f2255b = true;
        return;
    L44:
        if (r13 == false) goto L46;
        int r112 = 0;
        int r113 = r15;
    L47:
        int r114 = 0;
    L48:
        if (r112 == r113) goto L50;
        View r115 = this.H[r112];
        b r116 = (b) r115.getLayoutParams();
        int r117 = i1(RecyclerView.o.G(r115), r19, r20);
        r116.mSpanSize = r117;
        r116.mSpanIndex = r114;
        r114 = r114 + r117;
        r112 = r112 + r10;
        goto L48
    L50:
        float r23 = 0.0f;
        int r24 = 0;
        int r25 = 0;
    L51:
        if (r24 >= r15) goto L68;
        View r118 = this.H[r24];
        if (r21.f2268k != null) goto L57;
        if (r13 == false) goto L56;
        boolean r119 = false;
        b(r118, -1, false);
    L61:
        d(r118, this.L);
        j1(r118, r8, r119);
        int r120 = this.f2237r.c(r118);
        if (r120 <= r25) goto L64;
        r25 = r120;
    L64:
        float r121 = (this.f2237r.d(r118) * 1.0f) / ((b) r118.getLayoutParams()).mSpanSize;
        if (r121 <= r23) goto L67;
        r23 = r121;
    L67:
        r24 = r24 + 1;
        goto L51
    L56:
        r119 = false;
        b(r118, 0, false);
        goto L61
    L57:
        r119 = false;
        if (r13 == false) goto L60;
        b(r118, -1, true);
        goto L61
    L60:
        b(r118, 0, true);
        goto L61
    L68:
        if (r11 == false) goto L75;
        e1(Math.max(Math.round(r23 * this.F), r12));
        int r26 = 0;
        r25 = 0;
    L70:
        if (r26 >= r15) goto L75;
        View r27 = this.H[r26];
        j1(r27, 1073741824, true);
        int r28 = this.f2237r.c(r27);
        if (r28 <= r25) goto L74;
        r25 = r28;
    L74:
        r26 = r26 + 1;
    L75:
        int r29 = 0;
    L76:
        if (r29 >= r15) goto L87;
        View r30 = this.H[r29];
        if (this.f2237r.c(r30) == r25) goto L86;
        b r31 = (b) r30.getLayoutParams();
        Rect r32 = r31.mDecorInsets;
        int r33 = ((r32.top + r32.bottom) + ((ViewGroup.MarginLayoutParams) r31).topMargin) + ((ViewGroup.MarginLayoutParams) r31).bottomMargin;
        int r34 = ((r32.left + r32.right) + ((ViewGroup.MarginLayoutParams) r31).leftMargin) + ((ViewGroup.MarginLayoutParams) r31).rightMargin;
        int r35 = f1(r31.mSpanIndex, r31.mSpanSize);
        if (this.f2235p != 1) goto L82;
        int r36 = RecyclerView.o.x(r35, 1073741824, r34, false, ((ViewGroup.MarginLayoutParams) r31).width);
        int r37 = View.MeasureSpec.makeMeasureSpec(r25 - r33, 1073741824);
    L84:
        if (v0(r30, r36, r37, (RecyclerView.p) r30.getLayoutParams()) == false) goto L86;
        r30.measure(r36, r37);
        goto L86
    L82:
        int r38 = View.MeasureSpec.makeMeasureSpec(r25 - r34, 1073741824);
        r37 = RecyclerView.o.x(r35, 1073741824, r33, false, ((ViewGroup.MarginLayoutParams) r31).height);
        r36 = r38;
    L86:
        r29 = r29 + 1;
        goto L76
    L87:
        int r39 = 0;
        r22.f2254a = r25;
        if (this.f2235p != 1) goto L95;
        if (r21.f2263f != (-1)) goto L92;
        int r40 = r21.f2259b;
        int r41 = r40 - r25;
    L93:
        int r42 = 0;
        int r43 = r41;
        int r44 = r40;
        int r45 = 0;
    L99:
        if (r39 >= r15) goto L113;
        View r46 = this.H[r39];
        b r47 = (b) r46.getLayoutParams();
        if (this.f2235p == 1) goto L103;
        int r48 = F() + this.G[r47.mSpanIndex];
        r43 = r48;
        r44 = this.f2237r.d(r46) + r48;
    L107:
        RecyclerView.o.M(r46, r42, r43, r45, r44);
        if (r47.isItemRemoved() == false) goto L110;
    L111:
        r22.f2256c = true;
    L112:
        r22.f2257d = r46.hasFocusable() | r22.f2257d;
        r39 = r39 + 1;
        goto L99
    L110:
        if (r47.isItemChanged() == false) goto L112;
    L103:
        if (S0() == false) goto L105;
        r45 = D() + this.G[this.F - r47.mSpanIndex];
        r42 = r45 - this.f2237r.d(r46);
        goto L107
    L105:
        int r49 = D() + this.G[r47.mSpanIndex];
        r42 = r49;
        r45 = this.f2237r.d(r46) + r49;
        goto L107
    L113:
        Arrays.fill(this.H, null);
        return;
    L92:
        r41 = r21.f2259b;
        r40 = r25 + r41;
        goto L93
    L95:
        if (r21.f2263f != (-1)) goto L97;
        r45 = r21.f2259b;
        int r50 = r45 - r25;
    L98:
        r43 = 0;
        r42 = r50;
        r44 = 0;
        goto L99
    L97:
        r50 = r21.f2259b;
        r45 = r25 + r50;
        goto L98
    L46:
        r112 = r15 - 1;
        r10 = -1;
        r113 = -1;
        goto L47
    L15:
        r13 = false;
        goto L16
    L9:
        r12 = 0;
        goto L10
    L5:
        r11 = false;
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void U(RecyclerView.v r8, RecyclerView.z r10, View r11, k0.f r12) {
        ViewGroup.LayoutParams r13 = r11.getLayoutParams();
        if ((r13 instanceof b) == true) goto L6;
        T(r11, r12);
        return;
    L6:
        b r14 = (b) r13;
        int r15 = g1(r14.getViewLayoutPosition(), r8, r10);
        int r16 = 1;
        if (this.f2235p != 0) goto L9;
        r15 = r14.getSpanIndex();
        int r17 = r15;
        int r18 = 1;
        r16 = r14.getSpanSize();
    L10:
        r12.h(k0.f.c.a(r15, r16, r17, r18, false));
        return;
    L9:
        r17 = r14.getSpanIndex();
        r18 = r14.getSpanSize();
        goto L10
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void U0(RecyclerView.v r8, RecyclerView.z r10, LinearLayoutManager.a r11, int r12) {
        l1();
        if (r10.b() > 0) goto L5;
    L22:
        View[] r13 = this.H;
        if (r13 != null) goto L25;
    L26:
        this.H = new View[this.F];
        return;
    L25:
        if (r13.length != this.F) goto L26;
        return;
    L5:
        if (r10.f2370g == true) goto L22;
        if (r12 != 1) goto L9;
        boolean r14 = true;
    L10:
        int r15 = h1(r11.f2250b, r8, r10);
        if (r14 == false) goto L16;
    L12:
        if (r15 <= 0) goto L22;
        int r16 = r11.f2250b;
        if (r16 <= 0) goto L22;
        int r17 = r16 - 1;
        r11.f2250b = r17;
        r15 = h1(r17, r8, r10);
        goto L12
    L16:
        int r18 = r10.b() - 1;
        int r19 = r11.f2250b;
    L17:
        if (r19 >= r18) goto L21;
        int r20 = r19 + 1;
        int r21 = h1(r20, r8, r10);
        if (r21 <= r15) goto L21;
        r19 = r20;
        r15 = r21;
    L21:
        r11.f2250b = r19;
        goto L22
    L9:
        r14 = false;
        goto L10
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void V(int r8, int r10) {
        a r11 = this.K;
        r11.b();
        r11.f2234b.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void W() {
        a r8 = this.K;
        r8.b();
        r8.f2234b.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void X(int r8, int r10) {
        a r11 = this.K;
        r11.b();
        r11.f2234b.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void Y(int r8, int r10) {
        a r11 = this.K;
        r11.b();
        r11.f2234b.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void Z(int r8, int r10) {
        a r11 = this.K;
        r11.b();
        r11.f2234b.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public final void a0(RecyclerView.v r8, RecyclerView.z r10) {
        boolean r11 = r10.f2370g;
        SparseIntArray r12 = this.J;
        SparseIntArray r13 = this.I;
        if (r11 == false) goto L7;
        int r14 = w();
        int r15 = 0;
    L5:
        if (r15 >= r14) goto L7;
        b r16 = (b) v(r15).getLayoutParams();
        int r17 = r16.getViewLayoutPosition();
        r13.put(r17, r16.getSpanSize());
        r12.put(r17, r16.getSpanIndex());
        r15 = r15 + 1;
    L7:
        super.a0(r8, r10);
        r13.clear();
        r12.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void a1(boolean r8) {
        if (r8 == true) goto L6;
        super.a1(false);
        return;
    L6:
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public final void b0(RecyclerView.z r8) {
        super.b0(r8);
        this.E = false;
    }

    public final void e1(int r8) {
        int[] r10 = this.G;
        int r11 = this.F;
        int r12 = 1;
        if (r10 != null) goto L5;
    L8:
        r10 = new int[r11 + 1];
    L9:
        int r13 = 0;
        r10[0] = 0;
        int r14 = r8 / r11;
        int r15 = r8 % r11;
        int r16 = 0;
    L10:
        if (r12 > r11) goto L18;
        r13 = r13 + r15;
        if (r13 > 0) goto L14;
    L16:
        int r17 = r14;
    L17:
        r16 = r16 + r17;
        r10[r12] = r16;
        r12 = r12 + 1;
        goto L10
    L14:
        if ((r11 - r13) >= r15) goto L16;
        r17 = r14 + 1;
        r13 = r13 - r11;
        goto L17
    L18:
        this.G = r10;
        return;
    L5:
        if (r10.length != (r11 + 1)) goto L8;
        if (r10[r10.length - 1] == r8) goto L9;
        goto L8
    }

    public final int f1(int r8, int r10) {
        if (this.f2235p == 1) goto L5;
    L8:
        int[] r11 = this.G;
        return r11[r10 + r8] - r11[r8];
    L5:
        if (S0() == false) goto L8;
        int[] r12 = this.G;
        int r13 = this.F;
        return r12[r13 - r8] - r12[(r13 - r8) - r10];
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final boolean g(RecyclerView.p r8) {
        return r8 instanceof b;
    }

    public final int g1(int r8, RecyclerView.v r10, RecyclerView.z r11) {
        boolean r12 = r11.f2370g;
        a r13 = this.K;
        if (r12 == true) goto L6;
        int r14 = this.F;
        r13.getClass();
        return c.a(r8, r14);
    L6:
        int r15 = r10.b(r8);
        if (r15 != (-1)) goto L10;
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + r8);
        return 0;
    L10:
        int r16 = this.F;
        r13.getClass();
        return c.a(r15, r16);
    }

    public final int h1(int r8, RecyclerView.v r10, RecyclerView.z r11) {
        boolean r12 = r11.f2370g;
        a r13 = this.K;
        if (r12 == true) goto L6;
        int r14 = this.F;
        r13.getClass();
        return r8 % r14;
    L6:
        int r15 = this.J.get(r8, -1);
        if (r15 == (-1)) goto L9;
        return r15;
    L9:
        int r16 = r10.b(r8);
        if (r16 != (-1)) goto L13;
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + r8);
        return 0;
    L13:
        int r17 = this.F;
        r13.getClass();
        return r16 % r17;
    }

    public final int i1(int r8, RecyclerView.v r10, RecyclerView.z r11) {
        boolean r12 = r11.f2370g;
        a r13 = this.K;
        if (r12 == true) goto L6;
        r13.getClass();
        return 1;
    L6:
        int r14 = this.I.get(r8, -1);
        if (r14 == (-1)) goto L10;
        return r14;
    L10:
        if (r10.b(r8) != (-1)) goto L13;
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + r8);
        return 1;
    L13:
        r13.getClass();
        return 1;
    }

    public final void j1(View r10, int r11, boolean r12) {
        b r8 = (b) r10.getLayoutParams();
        Rect r13 = r8.mDecorInsets;
        int r14 = ((r13.top + r13.bottom) + ((ViewGroup.MarginLayoutParams) r8).topMargin) + ((ViewGroup.MarginLayoutParams) r8).bottomMargin;
        int r15 = ((r13.left + r13.right) + ((ViewGroup.MarginLayoutParams) r8).leftMargin) + ((ViewGroup.MarginLayoutParams) r8).rightMargin;
        int r16 = f1(r8.mSpanIndex, r8.mSpanSize);
        if (this.f2235p != 1) goto L5;
        int r17 = RecyclerView.o.x(r16, r11, r15, false, ((ViewGroup.MarginLayoutParams) r8).width);
        int r18 = RecyclerView.o.x(this.f2237r.l(), this.f2325m, r14, true, ((ViewGroup.MarginLayoutParams) r8).height);
    L6:
        RecyclerView.p r19 = (RecyclerView.p) r10.getLayoutParams();
        if (r12 == false) goto L9;
        boolean r20 = v0(r10, r17, r18, r19);
    L10:
        if (r20 == false) goto L13;
        r10.measure(r17, r18);
        return;
    L13:
        return;
    L9:
        r20 = t0(r10, r17, r18, r19);
        goto L10
    L5:
        int r110 = RecyclerView.o.x(r16, r11, r14, false, ((ViewGroup.MarginLayoutParams) r8).height);
        int r21 = RecyclerView.o.x(this.f2237r.l(), this.f2324l, r15, true, ((ViewGroup.MarginLayoutParams) r8).width);
        r18 = r110;
        r17 = r21;
        goto L6
    }

    public final void k1(int r8) {
        if (r8 != this.F) goto L5;
        return;
    L5:
        this.E = true;
        if (r8 < 1) goto L10;
        this.F = r8;
        this.K.b();
        k0();
        return;
    L10:
        throw new IllegalArgumentException(defpackage.a.d("Span count should be at least 1. Provided ", r8));
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public final int l(RecyclerView.z r8) {
        return C0(r8);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public final int l0(int r8, RecyclerView.v r10, RecyclerView.z r11) {
        l1();
        View[] r12 = this.H;
        if (r12 != null) goto L5;
    L6:
        this.H = new View[this.F];
    L8:
        return super.l0(r8, r10, r11);
    L5:
        if (r12.length == this.F) goto L8;
        goto L6
    }

    public final void l1() {
        if (this.f2235p != 1) goto L5;
        int r8 = this.f2326n - E();
        int r10 = D();
    L6:
        e1(r8 - r10);
        return;
    L5:
        r8 = this.f2327o - C();
        r10 = F();
        goto L6
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public final int m(RecyclerView.z r8) {
        return D0(r8);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public final int n0(int r8, RecyclerView.v r10, RecyclerView.z r11) {
        l1();
        View[] r12 = this.H;
        if (r12 != null) goto L5;
    L6:
        this.H = new View[this.F];
    L8:
        return super.n0(r8, r10, r11);
    L5:
        if (r12.length == this.F) goto L8;
        goto L6
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public final int o(RecyclerView.z r8) {
        return C0(r8);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public final int p(RecyclerView.z r8) {
        return D0(r8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void q0(int r8, int r10, Rect r11) {
        if (this.G != null) goto L5;
        super.q0(r8, r10, r11);
    L5:
        int r12 = D();
        int r13 = E() + r12;
        int r14 = F();
        int r15 = C() + r14;
        if (this.f2235p != 1) goto L8;
        int r16 = r11.height() + r15;
        RecyclerView r17 = this.f2314b;
        WeakHashMap<View, h0> r18 = j0.w.f8437a;
        int r19 = RecyclerView.o.h(r10, r16, j0.w.d.d(r17));
        int[] r20 = this.G;
        int r21 = RecyclerView.o.h(r8, r20[r20.length - 1] + r13, j0.w.d.e(this.f2314b));
    L9:
        RecyclerView.access$300(this.f2314b, r21, r19);
        return;
    L8:
        int r22 = r11.width() + r13;
        RecyclerView r23 = this.f2314b;
        WeakHashMap<View, h0> r24 = j0.w.f8437a;
        r21 = RecyclerView.o.h(r8, r22, j0.w.d.e(r23));
        int[] r25 = this.G;
        r19 = RecyclerView.o.h(r10, r25[r25.length - 1] + r15, j0.w.d.d(this.f2314b));
        goto L9
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public final RecyclerView.p s() {
        if (this.f2235p != 0) goto L7;
        return new b(-2, -1);
    L7:
        return new b(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final RecyclerView.p t(Context r8, AttributeSet r10) {
        return new b(r8, r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final RecyclerView.p u(ViewGroup.LayoutParams r8) {
        if ((r8 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        return new b((ViewGroup.MarginLayoutParams) r8);
    L7:
        return new b(r8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final int y(RecyclerView.v r8, RecyclerView.z r10) {
        if (this.f2235p != 1) goto L7;
        return this.F;
    L7:
        if (r10.b() >= 1) goto L11;
        return 0;
    L11:
        return g1(r10.b() - 1, r8, r10) + 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public final boolean y0() {
        if (this.f2245z == null) goto L5;
    L7:
        return false;
    L5:
        if (this.E == true) goto L7;
        return true;
    }

    public GridLayoutManager(Context r8, AttributeSet r10, int r11, int r12) {
        super(r8, r10, r11, r12);
        this.E = false;
        this.F = -1;
        this.I = new SparseIntArray();
        this.J = new SparseIntArray();
        this.K = new a();
        this.L = new Rect();
        k1(RecyclerView.o.H(r8, r10, r11, r12).f2331b);
    }
}
