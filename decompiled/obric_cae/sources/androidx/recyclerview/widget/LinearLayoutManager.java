package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.o implements RecyclerView.y.b {
    public final a A;
    public final b B;
    public final int C;
    public final int[] D;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f2235p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public c f2236q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public s f2237r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f2238s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f2239t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f2240u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f2241v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f2242w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f2243x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f2244y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public SavedState f2245z;

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2246a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2247b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f2248m;

        public static class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel r8) {
                return new SavedState(r8);
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int r8) {
                return new SavedState[r8];
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState() {
        }

        public SavedState(Parcel r8) {
            this.f2246a = r8.readInt();
            this.f2247b = r8.readInt();
            boolean r10 = true;
            if (r8.readInt() == 1) goto L6;
            r10 = false;
        L6:
            this.f2248m = r10;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r8, int r10) {
            r8.writeInt(this.f2246a);
            r8.writeInt(this.f2247b);
            r8.writeInt(this.f2248m ? 1 : 0);
        }

        public SavedState(SavedState r8) {
            this.f2246a = r8.f2246a;
            this.f2247b = r8.f2247b;
            this.f2248m = r8.f2248m;
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public s f2249a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2250b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2251c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f2252d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f2253e;

        public a() {
            c();
        }

        public final void a(View r8, int r10) {
            if (this.f2252d == false) goto L5;
            int r11 = this.f2249a.b(r8);
            this.f2251c = this.f2249a.m() + r11;
        L6:
            this.f2250b = r10;
            return;
        L5:
            this.f2251c = this.f2249a.e(r8);
            goto L6
        }

        public final void b(View r8, int r10) {
            int r11 = this.f2249a.m();
            if (r11 < 0) goto L6;
            a(r8, r10);
            return;
        L6:
            this.f2250b = r10;
            if (this.f2252d == false) goto L13;
            int r12 = (this.f2249a.g() - r11) - this.f2249a.b(r8);
            this.f2251c = this.f2249a.g() - r12;
            if (r12 <= 0) goto L20;
            int r13 = this.f2249a.c(r8);
            int r14 = this.f2251c - r13;
            int r15 = this.f2249a.k();
            int r16 = r14 - (Math.min(this.f2249a.e(r8) - r15, 0) + r15);
            if (r16 >= 0) goto L21;
            int r17 = this.f2251c;
            int r18 = Math.min(r12, -r16) + r17;
        L18:
            this.f2251c = r18;
            return;
        L21:
            return;
        L20:
            return;
        L13:
            int r19 = this.f2249a.e(r8);
            int r20 = r19 - this.f2249a.k();
            this.f2251c = r19;
            if (r20 <= 0) goto L22;
            int r21 = this.f2249a.c(r8) + r19;
            int r22 = (this.f2249a.g() - r11) - this.f2249a.b(r8);
            int r23 = (this.f2249a.g() - Math.min(0, r22)) - r21;
            if (r23 >= 0) goto L23;
            r18 = this.f2251c - Math.min(r20, -r23);
            goto L18
        L23:
            return;
        }

        public final void c() {
            this.f2250b = -1;
            this.f2251c = Integer.MIN_VALUE;
            this.f2252d = false;
            this.f2253e = false;
        }

        public final String toString() {
            return "AnchorInfo{mPosition=" + this.f2250b + ", mCoordinate=" + this.f2251c + ", mLayoutFromEnd=" + this.f2252d + ", mValid=" + this.f2253e + '}';
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2254a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f2255b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f2256c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f2257d;
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f2258a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2259b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2260c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f2261d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f2262e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f2263f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f2264g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f2265h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f2266i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f2267j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public List<RecyclerView.c0> f2268k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f2269l;

        public c() {
            this.f2258a = true;
            this.f2265h = 0;
            this.f2266i = 0;
            this.f2268k = null;
        }

        public final void a(View r8) {
            int r10 = this.f2268k.size();
            View r11 = null;
            int r12 = Integer.MAX_VALUE;
            int r13 = 0;
        L3:
            if (r13 >= r10) goto L18;
            View r14 = this.f2268k.get(r13).f2281a;
            RecyclerView.p r15 = (RecyclerView.p) r14.getLayoutParams();
            if (r14 == r8) goto L17;
            if (r15.isItemRemoved() == true) goto L17;
            int r16 = (r15.getViewLayoutPosition() - this.f2261d) * this.f2262e;
            if (r16 < 0) goto L17;
            if (r16 >= r12) goto L17;
            r11 = r14;
            if (r16 == 0) goto L18;
            r12 = r16;
        L17:
            r13 = r13 + 1;
        L18:
            if (r11 != null) goto L20;
            int r17 = -1;
        L21:
            this.f2261d = r17;
            return;
        L20:
            r17 = ((RecyclerView.p) r11.getLayoutParams()).getViewLayoutPosition();
            goto L21
        }

        public final View b(RecyclerView.v r8) {
            List<RecyclerView.c0> r10 = this.f2268k;
            if (r10 == null) goto L15;
            int r11 = r10.size();
            int r12 = 0;
        L5:
            if (r12 >= r11) goto L13;
            View r13 = this.f2268k.get(r12).f2281a;
            RecyclerView.p r14 = (RecyclerView.p) r13.getLayoutParams();
            if (r14.isItemRemoved() == true) goto L12;
            if (this.f2261d != r14.getViewLayoutPosition()) goto L12;
            a(r13);
            return r13;
        L12:
            r12 = r12 + 1;
            goto L5
        L13:
            return null;
        L15:
            View r15 = r8.d(this.f2261d);
            this.f2261d += this.f2262e;
            return r15;
        }
    }

    public LinearLayoutManager(int r8) {
        this.f2235p = 1;
        this.f2239t = false;
        this.f2240u = false;
        this.f2241v = false;
        this.f2242w = true;
        this.f2243x = -1;
        this.f2244y = Integer.MIN_VALUE;
        this.f2245z = null;
        this.A = new a();
        this.B = new b();
        this.C = 2;
        this.D = new int[2];
        Z0(r8);
        c(null);
        if (this.f2239t == false) goto L7;
        this.f2239t = false;
        k0();
        return;
    }

    public void A0(RecyclerView.z r8, c r10, RecyclerView.o.c r11) {
        int r12 = r10.f2261d;
        if (r12 >= 0) goto L5;
        return;
    L5:
        if (r12 >= r8.b()) goto L9;
        m.b r13 = (m.b) r11;
        r13.a(r12, Math.max(0, r10.f2264g));
        return;
    }

    public final int B0(RecyclerView.z r8) {
        if (w() != 0) goto L6;
        return 0;
    L6:
        F0();
        s r10 = this.f2237r;
        boolean r11 = !this.f2242w;
        return w.a(r8, r10, I0(r11), H0(r11), this, this.f2242w);
    }

    public final int C0(RecyclerView.z r8) {
        if (w() != 0) goto L6;
        return 0;
    L6:
        F0();
        s r10 = this.f2237r;
        boolean r11 = !this.f2242w;
        return w.b(r8, r10, I0(r11), H0(r11), this, this.f2242w, this.f2240u);
    }

    public final int D0(RecyclerView.z r8) {
        if (w() != 0) goto L6;
        return 0;
    L6:
        F0();
        s r10 = this.f2237r;
        boolean r11 = !this.f2242w;
        return w.c(r8, r10, I0(r11), H0(r11), this, this.f2242w);
    }

    public final int E0(int r8) {
        if (r8 == 1) goto L43;
        if (r8 == 2) goto L36;
        if (r8 == 17) goto L31;
        if (r8 == 33) goto L26;
        if (r8 == 66) goto L21;
        if (r8 == 130) goto L16;
        return Integer.MIN_VALUE;
    L16:
        if (this.f2235p != 1) goto L19;
        return 1;
    L19:
        return Integer.MIN_VALUE;
    L21:
        if (this.f2235p != 0) goto L24;
        return 1;
    L24:
        return Integer.MIN_VALUE;
    L26:
        if (this.f2235p != 1) goto L29;
        return -1;
    L29:
        return Integer.MIN_VALUE;
    L31:
        if (this.f2235p != 0) goto L34;
        return -1;
    L34:
        return Integer.MIN_VALUE;
    L36:
        if (this.f2235p != 1) goto L39;
        return 1;
    L39:
        if (S0() == false) goto L41;
        return -1;
    L41:
        return 1;
    L43:
        if (this.f2235p != 1) goto L46;
        return -1;
    L46:
        if (S0() == false) goto L48;
        return 1;
    L48:
        return -1;
    }

    public final void F0() {
        if (this.f2236q != null) goto L6;
        this.f2236q = new c();
        return;
    }

    public final int G0(RecyclerView.v r8, c r10, RecyclerView.z r11, boolean r12) {
        int r13 = r10.f2260c;
        int r14 = r10.f2264g;
        if (r14 == Integer.MIN_VALUE) goto L7;
        if (r13 >= 0) goto L6;
        r10.f2264g = r14 + r13;
    L6:
        V0(r8, r10);
    L7:
        int r15 = r10.f2260c + r10.f2265h;
    L9:
        if (r10.f2269l == true) goto L11;
        if (r15 > 0) goto L11;
    L38:
        return r13 - r10.f2260c;
    L11:
        int r16 = r10.f2261d;
        if (r16 >= 0) goto L14;
    L16:
        boolean r17 = false;
    L17:
        if (r17 == false) goto L38;
        b r18 = this.B;
        r18.f2254a = 0;
        r18.f2255b = false;
        r18.f2256c = false;
        r18.f2257d = false;
        T0(r8, r11, r10, r18);
        if (r18.f2255b == true) goto L38;
        int r19 = r10.f2259b;
        int r20 = r18.f2254a;
        r10.f2259b = (r10.f2263f * r20) + r19;
        if (r18.f2256c == true) goto L24;
    L27:
        r10.f2260c -= r20;
        r15 = r15 - r20;
    L28:
        int r21 = r10.f2264g;
        if (r21 == Integer.MIN_VALUE) goto L34;
        int r22 = r21 + r20;
        r10.f2264g = r22;
        int r23 = r10.f2260c;
        if (r23 >= 0) goto L33;
        r10.f2264g = r22 + r23;
    L33:
        V0(r8, r10);
    L34:
        if (r12 == false) goto L9;
        if (r18.f2257d == false) goto L9;
    L24:
        if (r10.f2268k != null) goto L27;
        if (r11.f2370g == true) goto L28;
    L14:
        if (r16 >= r11.b()) goto L16;
        r17 = true;
        goto L17
    }

    public final View H0(boolean r8) {
        if (this.f2240u == false) goto L5;
        int r10 = w();
        int r11 = 0;
    L7:
        return M0(r11, r10, r8);
    L5:
        r11 = w() - 1;
        r10 = -1;
        goto L7
    }

    public final View I0(boolean r8) {
        if (this.f2240u == false) goto L5;
        int r10 = -1;
        int r11 = w() - 1;
    L7:
        return M0(r11, r10, r8);
    L5:
        r10 = w();
        r11 = 0;
        goto L7
    }

    public final int J0() {
        View r8 = M0(0, w(), false);
        if (r8 != null) goto L6;
        return -1;
    L6:
        return RecyclerView.o.G(r8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final boolean K() {
        return true;
    }

    public final int K0() {
        View r8 = M0(w() - 1, -1, false);
        if (r8 != null) goto L6;
        return -1;
    L6:
        return RecyclerView.o.G(r8);
    }

    public final View L0(int r8, int r10) {
        F0();
        if (r10 <= r8) goto L5;
        byte r11 = 1;
    L8:
        if (r11 != 0) goto L12;
        return v(r8);
    L12:
        if (this.f2237r.e(v(r8)) >= this.f2237r.k()) goto L14;
        int r12 = 16644;
        int r13 = 16388;
    L16:
        if (this.f2235p != 0) goto L18;
        z r14 = this.f2315c;
    L20:
        return r14.a(r8, r10, r12, r13);
    L18:
        r14 = this.f2316d;
        goto L20
    L14:
        r12 = 4161;
        r13 = 4097;
        goto L16
    L5:
        if (r10 >= r8) goto L7;
        r11 = -1;
        goto L8
    L7:
        r11 = 0;
        goto L8
    }

    public final View M0(int r8, int r10, boolean r11) {
        F0();
        if (r11 == false) goto L5;
        int r12 = 24579;
    L7:
        if (this.f2235p != 0) goto L9;
        z r13 = this.f2315c;
    L11:
        return r13.a(r8, r10, r12, 320);
    L9:
        r13 = this.f2316d;
        goto L11
    L5:
        r12 = 320;
        goto L7
    }

    public View N0(RecyclerView.v r8, RecyclerView.z r10, int r11, int r12, int r13) {
        F0();
        int r14 = this.f2237r.k();
        int r15 = this.f2237r.g();
        if (r12 <= r11) goto L5;
        int r16 = 1;
    L6:
        View r17 = null;
        View r18 = null;
    L7:
        if (r11 == r12) goto L24;
        View r19 = v(r11);
        int r20 = RecyclerView.o.G(r19);
        if (r20 < 0) goto L23;
        if (r20 >= r13) goto L23;
        if (((RecyclerView.p) r19.getLayoutParams()).isItemRemoved() == false) goto L16;
        if (r18 != null) goto L23;
        r18 = r19;
        goto L23
    L16:
        if (this.f2237r.e(r19) < r15) goto L18;
    L21:
        if (r17 != null) goto L23;
        r17 = r19;
        goto L23
    L18:
        if (this.f2237r.b(r19) < r14) goto L21;
        return r19;
    L23:
        r11 = r11 + r16;
        goto L7
    L24:
        if (r17 == null) goto L27;
        return r17;
    L27:
        return r18;
    L5:
        r16 = -1;
        goto L6
    }

    public final int O0(int r8, RecyclerView.v r10, RecyclerView.z r11, boolean r12) {
        int r13 = this.f2237r.g() - r8;
        if (r13 <= 0) goto L11;
        int r14 = -Y0(-r13, r10, r11);
        int r15 = r8 + r14;
        if (r12 == false) goto L10;
        int r16 = this.f2237r.g() - r15;
        if (r16 <= 0) goto L10;
        this.f2237r.p(r16);
        return r16 + r14;
    L10:
        return r14;
    L11:
        return 0;
    }

    public final int P0(int r8, RecyclerView.v r10, RecyclerView.z r11, boolean r12) {
        int r13 = r8 - this.f2237r.k();
        if (r13 <= 0) goto L10;
        int r14 = -Y0(r13, r10, r11);
        int r15 = r8 + r14;
        if (r12 == false) goto L12;
        int r16 = r15 - this.f2237r.k();
        if (r16 <= 0) goto L13;
        this.f2237r.p(-r16);
        return r14 - r16;
    L13:
        return r14;
    L12:
        return r14;
    L10:
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void Q(RecyclerView r8) {
    }

    public final View Q0() {
        if (this.f2240u == false) goto L5;
        int r8 = 0;
    L7:
        return v(r8);
    L5:
        r8 = w() - 1;
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View R(View r8, int r10, RecyclerView.v r11, RecyclerView.z r12) {
        X0();
        if (w() != 0) goto L5;
        return null;
    L5:
        int r13 = E0(r10);
        if (r13 != Integer.MIN_VALUE) goto L8;
        return null;
    L8:
        F0();
        b1(r13, (int) (this.f2237r.l() * 0.33333334f), false, r12);
        c r14 = this.f2236q;
        r14.f2264g = Integer.MIN_VALUE;
        r14.f2258a = false;
        G0(r11, r14, r12, true);
        if (r13 != (-1)) goto L15;
        if (this.f2240u == false) goto L13;
        View r15 = L0(w() - 1, -1);
    L18:
        if (r13 != (-1)) goto L20;
        View r16 = R0();
    L22:
        if (r16.hasFocusable() == false) goto L26;
        if (r15 != null) goto L25;
        return null;
    L25:
        return r16;
    L26:
        return r15;
    L20:
        r16 = Q0();
        goto L22
    L13:
        r15 = L0(0, w());
        goto L18
    L15:
        if (this.f2240u == false) goto L17;
        r15 = L0(0, w());
        goto L18
    L17:
        r15 = L0(w() - 1, -1);
        goto L18
    }

    public final View R0() {
        if (this.f2240u == false) goto L5;
        int r8 = w() - 1;
    L7:
        return v(r8);
    L5:
        r8 = 0;
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void S(AccessibilityEvent r8) {
        super.S(r8);
        if (w() <= 0) goto L6;
        r8.setFromIndex(J0());
        r8.setToIndex(K0());
        return;
    }

    public final boolean S0() {
        if (B() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public void T0(RecyclerView.v r12, RecyclerView.z r13, c r14, b r15) {
        View r16 = r14.b(r12);
        if (r16 != null) goto L6;
        r15.f2255b = true;
        return;
    L6:
        RecyclerView.p r8 = (RecyclerView.p) r16.getLayoutParams();
        if (r14.f2268k != null) goto L15;
        boolean r10 = this.f2240u;
        if (r14.f2263f != (-1)) goto L11;
        boolean r11 = true;
    L12:
        if (r10 != r11) goto L14;
        b(r16, -1, false);
    L22:
        RecyclerView.p r17 = (RecyclerView.p) r16.getLayoutParams();
        Rect r18 = this.f2314b.getItemDecorInsetsForChild(r16);
        int r19 = (r18.left + r18.right) + 0;
        int r20 = (r18.top + r18.bottom) + 0;
        int r21 = RecyclerView.o.x(this.f2326n, this.f2324l, (((E() + D()) + ((ViewGroup.MarginLayoutParams) r17).leftMargin) + ((ViewGroup.MarginLayoutParams) r17).rightMargin) + r19, e(), ((ViewGroup.MarginLayoutParams) r17).width);
        int r22 = RecyclerView.o.x(this.f2327o, this.f2325m, (((C() + F()) + ((ViewGroup.MarginLayoutParams) r17).topMargin) + ((ViewGroup.MarginLayoutParams) r17).bottomMargin) + r20, f(), ((ViewGroup.MarginLayoutParams) r17).height);
        if (t0(r16, r21, r22, r17) == false) goto L25;
        r16.measure(r21, r22);
    L25:
        r15.f2254a = this.f2237r.c(r16);
        if (this.f2235p == 1) goto L28;
        int r23 = F();
        int r110 = this.f2237r.d(r16) + r23;
        int r24 = r14.f2263f;
        int r111 = r14.f2259b;
        if (r24 != (-1)) goto L38;
        int r25 = r110;
        int r112 = r111 - r15.f2254a;
        int r26 = r111;
        int r113 = r23;
    L39:
        RecyclerView.o.M(r16, r112, r113, r26, r25);
        if (r8.isItemRemoved() == false) goto L42;
    L43:
        r15.f2256c = true;
    L44:
        r15.f2257d = r16.hasFocusable();
        return;
    L42:
        if (r8.isItemChanged() == false) goto L44;
    L38:
        int r27 = r15.f2254a + r111;
        r25 = r110;
        r112 = r111;
        r113 = r23;
        r26 = r27;
        goto L39
    L28:
        if (S0() == false) goto L30;
        r26 = this.f2326n - E();
        r112 = r26 - this.f2237r.d(r16);
    L31:
        int r28 = r14.f2263f;
        r113 = r14.f2259b;
        if (r28 != (-1)) goto L34;
        r25 = r113;
        r113 = r113 - r15.f2254a;
        goto L39
    L34:
        r25 = r15.f2254a + r113;
        goto L39
    L30:
        int r29 = D();
        r26 = this.f2237r.d(r16) + r29;
        r112 = r29;
        goto L31
    L14:
        b(r16, 0, false);
        goto L22
    L11:
        r11 = false;
        goto L12
    L15:
        boolean r30 = this.f2240u;
        if (r14.f2263f != (-1)) goto L18;
        boolean r31 = true;
    L19:
        if (r30 != r31) goto L21;
        b(r16, -1, true);
        goto L22
    L21:
        b(r16, 0, true);
        goto L22
    L18:
        r31 = false;
        goto L19
    }

    public void U0(RecyclerView.v r8, RecyclerView.z r10, a r11, int r12) {
    }

    public final void V0(RecyclerView.v r8, c r10) {
        if (r10.f2258a == true) goto L5;
        return;
    L5:
        if (r10.f2269l == true) goto L71;
        int r11 = r10.f2264g;
        int r12 = r10.f2266i;
        if (r10.f2263f != (-1)) goto L32;
        int r13 = w();
        if (r11 < 0) goto L72;
        int r14 = (this.f2237r.f() - r11) + r12;
        if (this.f2240u == false) goto L23;
        int r15 = 0;
    L15:
        if (r15 >= r13) goto L74;
        View r16 = v(r15);
        if (this.f2237r.e(r16) < r14) goto L22;
        if (this.f2237r.o(r16) < r14) goto L22;
        r15 = r15 + 1;
    L22:
        W0(r8, 0, r15);
        return;
    L74:
        return;
    L23:
        int r17 = r13 - 1;
        int r18 = r17;
    L24:
        if (r18 < 0) goto L75;
        View r19 = v(r18);
        if (this.f2237r.e(r19) < r14) goto L31;
        if (this.f2237r.o(r19) < r14) goto L31;
        r18 = r18 - 1;
    L31:
        W0(r8, r17, r18);
        return;
    L75:
        return;
    L72:
        return;
    L32:
        if (r11 < 0) goto L73;
        int r20 = r11 - r12;
        int r21 = w();
        if (this.f2240u == false) goto L45;
        int r22 = r21 - 1;
        int r23 = r22;
    L37:
        if (r23 < 0) goto L76;
        View r24 = v(r23);
        if (this.f2237r.b(r24) > r20) goto L44;
        if (this.f2237r.n(r24) > r20) goto L44;
        r23 = r23 - 1;
    L44:
        W0(r8, r22, r23);
        return;
    L76:
        return;
    L45:
        int r25 = 0;
    L46:
        if (r25 >= r21) goto L77;
        View r26 = v(r25);
        if (this.f2237r.b(r26) > r20) goto L53;
        if (this.f2237r.n(r26) > r20) goto L53;
        r25 = r25 + 1;
    L53:
        W0(r8, 0, r25);
        return;
    L77:
        return;
    L73:
        return;
    }

    public final void W0(RecyclerView.v r8, int r10, int r11) {
        if (r10 != r11) goto L4;
        return;
    L4:
        if (r11 <= r10) goto L8;
    L5:
        r11 = r11 - 1;
        if (r11 < r10) goto L10;
        View r12 = v(r11);
        i0(r11);
        r8.h(r12);
        goto L5
    L10:
        return;
    L8:
        if (r10 <= r11) goto L13;
        View r13 = v(r10);
        i0(r10);
        r8.h(r13);
        r10 = r10 - 1;
        goto L8
    }

    public final void X0() {
        if (this.f2235p != 1) goto L5;
    L8:
        boolean r8 = this.f2239t;
    L9:
        this.f2240u = r8;
        return;
    L5:
        if (S0() == false) goto L8;
        r8 = !this.f2239t;
        goto L9
    }

    public final int Y0(int r8, RecyclerView.v r10, RecyclerView.z r11) {
        if (w() == 0) goto L17;
        if (r8 == 0) goto L17;
        F0();
        this.f2236q.f2258a = true;
        if (r8 <= 0) goto L9;
        int r12 = 1;
    L10:
        int r13 = Math.abs(r8);
        b1(r12, r13, true, r11);
        c r14 = this.f2236q;
        int r15 = G0(r10, r14, r11, false) + r14.f2264g;
        if (r15 >= 0) goto L13;
        return 0;
    L13:
        if (r13 <= r15) goto L15;
        r8 = r12 * r15;
    L15:
        this.f2237r.p(-r8);
        this.f2236q.f2267j = r8;
        return r8;
    L9:
        r12 = -1;
    L17:
        return 0;
    }

    public final void Z0(int r8) {
        if (r8 != 0) goto L4;
    L8:
        c(null);
        if (r8 == this.f2235p) goto L11;
    L12:
        s r10 = s.a(this, r8);
        this.f2237r = r10;
        this.A.f2249a = r10;
        this.f2235p = r8;
        k0();
        return;
    L11:
        if (this.f2237r == null) goto L12;
        return;
    L4:
        if (r8 == 1) goto L8;
        throw new IllegalArgumentException(defpackage.a.d("invalid orientation:", r8));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y.b
    public final PointF a(int r8) {
        if (w() != 0) goto L6;
        return null;
    L6:
        boolean r10 = false;
        int r11 = 1;
        if (r8 >= RecyclerView.o.G(v(0))) goto L10;
        r10 = true;
    L10:
        if (r10 == this.f2240u) goto L13;
        r11 = -1;
    L13:
        if (this.f2235p != 0) goto L17;
        return new PointF(r11, 0.0f);
    L17:
        return new PointF(0.0f, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v32 */
    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void a0(RecyclerView.v r18, RecyclerView.z r19) {
        if (this.f2245z != null) goto L7;
        if (this.f2243x != (-1)) goto L7;
    L10:
        SavedState r8 = this.f2245z;
        boolean r11 = false;
        if (r8 == null) goto L18;
        int r10 = r8.f2246a;
        if (r10 < 0) goto L15;
        boolean r12 = true;
    L16:
        if (r12 == false) goto L18;
        this.f2243x = r10;
        goto L18
    L15:
        r12 = false;
    L18:
        F0();
        this.f2236q.f2258a = false;
        X0();
        RecyclerView r13 = this.f2314b;
        if (r13 != null) goto L21;
    L20:
        View r14 = null;
    L26:
        a r15 = this.A;
        if (r15.f2253e == true) goto L29;
    L39:
        r15.c();
        r15.f2252d = this.f2240u ^ this.f2241v;
        if (r19.f2370g == true) goto L102;
        int r16 = this.f2243x;
        if (r16 == (-1)) goto L102;
        if (r16 >= 0) goto L46;
    L101:
        this.f2243x = -1;
        this.f2244y = Integer.MIN_VALUE;
        goto L102
    L46:
        if (r16 >= r19.b()) goto L101;
        int r17 = this.f2243x;
        r15.f2250b = r17;
        SavedState r20 = this.f2245z;
        if (r20 == null) goto L60;
        if (r20.f2246a < 0) goto L53;
        boolean r21 = true;
    L54:
        if (r21 == false) goto L60;
        boolean r22 = r20.f2248m;
        r15.f2252d = r22;
        if (r22 == false) goto L58;
        int r23 = this.f2237r.g();
        int r24 = this.f2245z.f2247b;
    L96:
        int r25 = r23 - r24;
    L99:
        r15.f2251c = r25;
    L100:
        boolean r26 = true;
    L103:
        if (r26 == false) goto L106;
    L171:
        r15.f2253e = true;
    L172:
        c r27 = this.f2236q;
        if (r27.f2267j < 0) goto L175;
        int r28 = 1;
    L176:
        r27.f2263f = r28;
        int[] r29 = this.D;
        r29[0] = 0;
        r29[1] = 0;
        z0(r19, r29);
        int r30 = this.f2237r.k() + Math.max(0, r29[0]);
        int r31 = this.f2237r.h() + Math.max(0, r29[1]);
        if (r19.f2370g == false) goto L193;
        int r32 = this.f2243x;
        if (r32 == (-1)) goto L193;
        if (this.f2244y == Integer.MIN_VALUE) goto L193;
        View r33 = r(r32);
        if (r33 == null) goto L193;
        if (this.f2240u == false) goto L187;
        int r34 = this.f2237r.g() - this.f2237r.b(r33);
        int r35 = this.f2244y;
    L188:
        int r36 = r34 - r35;
        if (r36 <= 0) goto L191;
        r30 = r30 + r36;
        goto L193
    L191:
        r31 = r31 - r36;
        goto L193
    L187:
        r35 = this.f2237r.e(r33) - this.f2237r.k();
        r34 = this.f2244y;
    L193:
        if (r15.f2252d == false) goto L198;
        if (this.f2240u == true) goto L200;
    L199:
        int r37 = -1;
    L201:
        U0(r18, r19, r15, r37);
        q(r18);
        c r38 = this.f2236q;
        if (this.f2237r.i() == 0) goto L204;
    L206:
        boolean r39 = false;
    L207:
        r38.f2269l = r39;
        this.f2236q.getClass();
        this.f2236q.f2266i = 0;
        if (r15.f2252d == false) goto L215;
        d1(r15.f2250b, r15.f2251c);
        c r40 = this.f2236q;
        r40.f2265h = r30;
        G0(r18, r40, r19, false);
        c r41 = this.f2236q;
        int r42 = r41.f2259b;
        int r43 = r41.f2261d;
        int r44 = r41.f2260c;
        if (r44 <= 0) goto L212;
        r31 = r31 + r44;
    L212:
        c1(r15.f2250b, r15.f2251c);
        c r45 = this.f2236q;
        r45.f2265h = r31;
        r45.f2261d += r45.f2262e;
        G0(r18, r45, r19, false);
        c r46 = this.f2236q;
        int r47 = r46.f2259b;
        int r48 = r46.f2260c;
        if (r48 <= 0) goto L222;
        d1(r43, r42);
        c r49 = this.f2236q;
        r49.f2265h = r48;
        G0(r18, r49, r19, false);
        r42 = this.f2236q.f2259b;
    L222:
        if (w() <= 0) goto L229;
        if ((this.f2240u ^ this.f2241v) == false) goto L226;
        int r50 = O0(r47, r18, r19, true);
        int r51 = r42 + r50;
        int r52 = r47 + r50;
        int r53 = P0(r51, r18, r19, false);
    L227:
        r42 = r51 + r53;
        r47 = r52 + r53;
        goto L229
    L226:
        int r54 = P0(r42, r18, r19, true);
        r51 = r42 + r54;
        r52 = r47 + r54;
        r53 = O0(r52, r18, r19, false);
    L229:
        if (r19.f2374k == false) goto L264;
        if (w() == 0) goto L264;
        if (r19.f2370g == true) goto L264;
        if (y0() == false) goto L264;
        List<RecyclerView.c0> r55 = r18.f2343d;
        int r56 = r55.size();
        int r57 = RecyclerView.o.G(v(0));
        int r58 = 0;
        int r110 = 0;
        int r111 = 0;
    L238:
        if (r58 >= r56) goto L255;
        RecyclerView.c0 r112 = r55.get(r58);
        if (r112.i() == true) goto L254;
        if (r112.c() >= r57) goto L245;
        boolean r113 = true;
    L247:
        if (r113 == this.f2240u) goto L249;
        byte r114 = -1;
    L250:
        int r115 = this.f2237r.c(r112.f2281a);
        if (r114 != (-1)) goto L253;
        r110 = r110 + r115;
        goto L254
    L253:
        r111 = r111 + r115;
        goto L254
    L249:
        r114 = 1;
        goto L250
    L245:
        r113 = r11;
    L254:
        r58 = r58 + 1;
        r11 = false;
        goto L238
    L255:
        this.f2236q.f2268k = r55;
        if (r110 <= 0) goto L258;
        d1(RecyclerView.o.G(R0()), r42);
        c r59 = this.f2236q;
        r59.f2265h = r110;
        ?? r60 = 0;
        r59.f2260c = 0;
        r59.a(null);
        G0(r18, this.f2236q, r19, false);
    L259:
        if (r111 <= 0) goto L261;
        c1(RecyclerView.o.G(Q0()), r47);
        c r61 = this.f2236q;
        r61.f2265h = r111;
        r61.f2260c = r60;
        List<RecyclerView.c0> r62 = null;
        r61.a(null);
        G0(r18, this.f2236q, r19, r60);
    L262:
        this.f2236q.f2268k = r62;
        goto L264
    L261:
        r62 = null;
        goto L262
    L258:
        r60 = 0;
    L264:
        if (r19.f2370g == true) goto L266;
        s r63 = this.f2237r;
        r63.f2555b = r63.l();
    L267:
        this.f2238s = this.f2241v;
        return;
    L266:
        r15.c();
        goto L267
    L215:
        c1(r15.f2250b, r15.f2251c);
        c r64 = this.f2236q;
        r64.f2265h = r31;
        G0(r18, r64, r19, false);
        c r65 = this.f2236q;
        r47 = r65.f2259b;
        int r66 = r65.f2261d;
        int r67 = r65.f2260c;
        if (r67 <= 0) goto L218;
        r30 = r30 + r67;
    L218:
        d1(r15.f2250b, r15.f2251c);
        c r68 = this.f2236q;
        r68.f2265h = r30;
        r68.f2261d += r68.f2262e;
        G0(r18, r68, r19, false);
        c r69 = this.f2236q;
        r42 = r69.f2259b;
        int r70 = r69.f2260c;
        if (r70 <= 0) goto L222;
        c1(r66, r47);
        c r71 = this.f2236q;
        r71.f2265h = r70;
        G0(r18, r71, r19, false);
        r47 = this.f2236q.f2259b;
        goto L222
    L204:
        if (this.f2237r.f() != 0) goto L206;
        r39 = true;
    L200:
        r37 = 1;
        goto L201
    L198:
        if (this.f2240u == false) goto L200;
    L175:
        r28 = -1;
        goto L176
    L106:
        if (w() == 0) goto L159;
        RecyclerView r72 = this.f2314b;
        if (r72 != null) goto L111;
    L110:
        View r73 = null;
    L116:
        if (r73 == null) goto L128;
        RecyclerView.p r74 = (RecyclerView.p) r73.getLayoutParams();
        if (r74.isItemRemoved() == false) goto L120;
    L124:
        boolean r75 = false;
    L125:
        if (r75 == false) goto L128;
        r15.b(r73, RecyclerView.o.G(r73));
    L158:
        boolean r76 = true;
    L160:
        if (r76 == true) goto L171;
        if (r15.f2252d == false) goto L165;
        int r77 = r15.f2249a.g();
    L166:
        r15.f2251c = r77;
        if (this.f2241v == false) goto L169;
        int r78 = r19.b() - 1;
    L170:
        r15.f2250b = r78;
        goto L171
    L169:
        r78 = 0;
        goto L170
    L165:
        r77 = r15.f2249a.k();
        goto L166
    L120:
        if (r74.getViewLayoutPosition() < 0) goto L124;
        if (r74.getViewLayoutPosition() >= r19.b()) goto L124;
        r75 = true;
    L128:
        if (this.f2238s != this.f2241v) goto L159;
        if (r15.f2252d == false) goto L137;
        if (this.f2240u == false) goto L135;
        View r79 = N0(r18, r19, 0, w(), r19.b());
    L140:
        if (r79 == null) goto L159;
        r15.a(r79, RecyclerView.o.G(r79));
        if (r19.f2370g == true) goto L158;
        if (y0() == false) goto L158;
        if (this.f2237r.e(r79) < this.f2237r.g()) goto L148;
    L151:
        boolean r80 = true;
    L152:
        if (r80 == false) goto L158;
        boolean r81 = r15.f2252d;
        s r82 = this.f2237r;
        if (r81 == false) goto L156;
        int r83 = r82.g();
    L157:
        r15.f2251c = r83;
        goto L158
    L156:
        r83 = r82.k();
        goto L157
    L148:
        if (this.f2237r.b(r79) < this.f2237r.k()) goto L151;
        r80 = false;
        goto L152
    L135:
        r79 = N0(r18, r19, w() - 1, -1, r19.b());
        goto L140
    L137:
        if (this.f2240u == false) goto L139;
        r79 = N0(r18, r19, w() - 1, -1, r19.b());
        goto L140
    L139:
        r79 = N0(r18, r19, 0, w(), r19.b());
        goto L140
    L111:
        r73 = r72.getFocusedChild();
        if (r73 == null) goto L110;
        if (this.f2313a.j(r73) == false) goto L116;
    L159:
        r76 = false;
        goto L160
    L58:
        int r84 = this.f2237r.k();
        int r85 = this.f2245z.f2247b;
    L98:
        r25 = r84 + r85;
        goto L99
    L53:
        r21 = false;
    L60:
        if (this.f2244y != Integer.MIN_VALUE) goto L93;
        View r86 = r(r17);
        if (r86 == null) goto L78;
        if (this.f2237r.c(r86) > this.f2237r.l()) goto L89;
        if ((this.f2237r.e(r86) - this.f2237r.k()) >= 0) goto L70;
        r15.f2251c = this.f2237r.k();
        r15.f2252d = false;
        goto L100
    L70:
        if ((this.f2237r.g() - this.f2237r.b(r86)) >= 0) goto L73;
        r15.f2251c = this.f2237r.g();
        r15.f2252d = true;
        goto L100
    L73:
        if (r15.f2252d == false) goto L75;
        int r87 = this.f2237r.m() + this.f2237r.b(r86);
    L76:
        r15.f2251c = r87;
        goto L100
    L75:
        r87 = this.f2237r.e(r86);
    L89:
        if (r15.f2252d == false) goto L91;
        int r88 = r15.f2249a.g();
    L92:
        r15.f2251c = r88;
        goto L100
    L91:
        r88 = r15.f2249a.k();
        goto L92
    L78:
        if (w() <= 0) goto L89;
        if (this.f2243x >= RecyclerView.o.G(v(0))) goto L82;
        boolean r89 = true;
    L84:
        if (r89 != this.f2240u) goto L86;
        boolean r90 = true;
    L87:
        r15.f2252d = r90;
        goto L89
    L86:
        r90 = false;
        goto L87
    L82:
        r89 = false;
        goto L84
    L93:
        boolean r91 = this.f2240u;
        r15.f2252d = r91;
        if (r91 == false) goto L97;
        r23 = this.f2237r.g();
        r24 = this.f2244y;
        goto L96
    L97:
        r84 = this.f2237r.k();
        r85 = this.f2244y;
    L102:
        r26 = false;
        goto L103
    L29:
        if (this.f2243x != (-1)) goto L39;
        if (this.f2245z != null) goto L39;
        if (r14 == null) goto L172;
        if (this.f2237r.e(r14) < this.f2237r.g()) goto L37;
    L38:
        r15.b(r14, RecyclerView.o.G(r14));
        goto L172
    L37:
        if (this.f2237r.b(r14) > this.f2237r.k()) goto L172;
    L21:
        r14 = r13.getFocusedChild();
        if (r14 == null) goto L20;
        if (this.f2313a.j(r14) == false) goto L26;
    L7:
        if (r19.b() != 0) goto L10;
        f0(r18);
    }

    public void a1(boolean r8) {
        c(null);
        if (this.f2241v != r8) goto L5;
        return;
    L5:
        this.f2241v = r8;
        k0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void b0(RecyclerView.z r8) {
        this.f2245z = null;
        this.f2243x = -1;
        this.f2244y = Integer.MIN_VALUE;
        this.A.c();
    }

    public final void b1(int r8, int r10, boolean r11, RecyclerView.z r12) {
        c r13 = this.f2236q;
        int r14 = 1;
        boolean r15 = false;
        if (this.f2237r.i() == 0) goto L5;
    L7:
        boolean r16 = false;
    L8:
        r13.f2269l = r16;
        this.f2236q.f2263f = r8;
        int[] r17 = this.D;
        r17[0] = 0;
        r17[1] = 0;
        z0(r12, r17);
        int r18 = Math.max(0, r17[0]);
        int r19 = Math.max(0, r17[1]);
        if (r8 != 1) goto L11;
        r15 = true;
    L11:
        c r20 = this.f2236q;
        if (r15 == false) goto L14;
        int r21 = r19;
    L15:
        r20.f2265h = r21;
        if (r15 == true) goto L19;
        r18 = r19;
    L19:
        r20.f2266i = r18;
        if (r15 == false) goto L25;
        r20.f2265h = this.f2237r.h() + r21;
        View r22 = Q0();
        c r23 = this.f2236q;
        if (this.f2240u == false) goto L24;
        r14 = -1;
    L24:
        r23.f2262e = r14;
        int r24 = RecyclerView.o.G(r22);
        c r25 = this.f2236q;
        r23.f2261d = r24 + r25.f2262e;
        r25.f2259b = this.f2237r.b(r22);
        int r26 = this.f2237r.b(r22) - this.f2237r.g();
    L30:
        c r27 = this.f2236q;
        r27.f2260c = r10;
        if (r11 == false) goto L33;
        r27.f2260c = r10 - r26;
    L33:
        r27.f2264g = r26;
        return;
    L25:
        View r28 = R0();
        c r29 = this.f2236q;
        r29.f2265h = this.f2237r.k() + r29.f2265h;
        c r30 = this.f2236q;
        if (this.f2240u == true) goto L29;
        r14 = -1;
    L29:
        r30.f2262e = r14;
        int r31 = RecyclerView.o.G(r28);
        c r32 = this.f2236q;
        r30.f2261d = r31 + r32.f2262e;
        r32.f2259b = this.f2237r.e(r28);
        r26 = (-this.f2237r.e(r28)) + this.f2237r.k();
        goto L30
    L14:
        r21 = r18;
        goto L15
    L5:
        if (this.f2237r.f() != 0) goto L7;
        r16 = true;
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void c(String r8) {
        if (this.f2245z != null) goto L6;
        super.c(r8);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void c0(Parcelable r8) {
        if ((r8 instanceof SavedState) == false) goto L6;
        this.f2245z = (SavedState) r8;
        k0();
        return;
    }

    public final void c1(int r8, int r10) {
        this.f2236q.f2260c = this.f2237r.g() - r10;
        c r11 = this.f2236q;
        if (this.f2240u == false) goto L5;
        int r12 = -1;
    L6:
        r11.f2262e = r12;
        r11.f2261d = r8;
        r11.f2263f = 1;
        r11.f2259b = r10;
        r11.f2264g = Integer.MIN_VALUE;
        return;
    L5:
        r12 = 1;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final Parcelable d0() {
        SavedState r8 = this.f2245z;
        if (r8 != null) goto L5;
        SavedState r10 = new SavedState();
        if (w() <= 0) goto L12;
        F0();
        boolean r11 = this.f2238s ^ this.f2240u;
        r10.f2248m = r11;
        if (r11 == false) goto L11;
        View r12 = Q0();
        r10.f2247b = this.f2237r.g() - this.f2237r.b(r12);
        r10.f2246a = RecyclerView.o.G(r12);
    L13:
        return r10;
    L11:
        View r13 = R0();
        r10.f2246a = RecyclerView.o.G(r13);
        r10.f2247b = this.f2237r.e(r13) - this.f2237r.k();
        goto L13
    L12:
        r10.f2246a = -1;
        goto L13
    L5:
        return new SavedState(r8);
    }

    public final void d1(int r8, int r10) {
        this.f2236q.f2260c = r10 - this.f2237r.k();
        c r11 = this.f2236q;
        r11.f2261d = r8;
        if (this.f2240u == false) goto L5;
        int r12 = 1;
    L6:
        r11.f2262e = r12;
        r11.f2263f = -1;
        r11.f2259b = r10;
        r11.f2264g = Integer.MIN_VALUE;
        return;
    L5:
        r12 = -1;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final boolean e() {
        if (this.f2235p != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final boolean f() {
        if (this.f2235p == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void i(int r8, int r10, RecyclerView.z r11, RecyclerView.o.c r12) {
        if (this.f2235p == 0) goto L7;
        r8 = r10;
    L7:
        if (w() == 0) goto L16;
        if (r8 == 0) goto L17;
        F0();
        if (r8 <= 0) goto L13;
        int r13 = 1;
    L14:
        b1(r13, Math.abs(r8), true, r11);
        A0(r11, this.f2236q, r12);
        return;
    L13:
        r13 = -1;
        goto L14
    L17:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void j(int r8, RecyclerView.o.c r10) {
        SavedState r11 = this.f2245z;
        int r12 = 1;
        if (r11 == null) goto L10;
        int r13 = r11.f2246a;
        if (r13 < 0) goto L7;
        boolean r14 = true;
    L8:
        if (r14 == false) goto L10;
        boolean r15 = r11.f2248m;
    L15:
        if (r15 == false) goto L17;
        r12 = -1;
    L17:
        int r16 = 0;
    L19:
        if (r16 >= this.C) goto L23;
        if (r13 < 0) goto L27;
        if (r13 >= r8) goto L28;
        ((m.b) r10).a(r13, 0);
        r13 = r13 + r12;
        r16 = r16 + 1;
        goto L19
    L28:
        return;
    L27:
        return;
    L23:
        return;
    L7:
        r14 = false;
    L10:
        X0();
        r15 = this.f2240u;
        r13 = this.f2243x;
        if (r13 != (-1)) goto L15;
        if (r15 == false) goto L14;
        r13 = r8 - 1;
        goto L15
    L14:
        r13 = 0;
        goto L15
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final int k(RecyclerView.z r8) {
        return B0(r8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int l(RecyclerView.z r8) {
        return C0(r8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int l0(int r8, RecyclerView.v r10, RecyclerView.z r11) {
        if (this.f2235p != 1) goto L7;
        return 0;
    L7:
        return Y0(r8, r10, r11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int m(RecyclerView.z r8) {
        return D0(r8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final void m0(int r8) {
        this.f2243x = r8;
        this.f2244y = Integer.MIN_VALUE;
        SavedState r10 = this.f2245z;
        if (r10 == null) goto L5;
        r10.f2246a = -1;
    L5:
        k0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final int n(RecyclerView.z r8) {
        return B0(r8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int n0(int r8, RecyclerView.v r10, RecyclerView.z r11) {
        if (this.f2235p != 0) goto L7;
        return 0;
    L7:
        return Y0(r8, r10, r11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int o(RecyclerView.z r8) {
        return C0(r8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int p(RecyclerView.z r8) {
        return D0(r8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final View r(int r8) {
        int r10 = w();
        if (r10 != 0) goto L6;
        return null;
    L6:
        int r11 = r8 - RecyclerView.o.G(v(0));
        if (r11 < 0) goto L13;
        if (r11 >= r10) goto L13;
        View r12 = v(r11);
        if (RecyclerView.o.G(r12) != r8) goto L13;
        return r12;
    L13:
        return super.r(r8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p s() {
        return new RecyclerView.p(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public final boolean u0() {
        if (this.f2325m != 1073741824) goto L5;
        return false;
    L5:
        if (this.f2324l == 1073741824) goto L24;
        int r8 = w();
        int r10 = 0;
    L8:
        if (r10 >= r8) goto L15;
        ViewGroup.LayoutParams r11 = v(r10).getLayoutParams();
        if (r11.width >= 0) goto L14;
        if (r11.height >= 0) goto L14;
        boolean r12 = true;
    L16:
        if (r12 == true) goto L18;
        return false;
    L18:
        return true;
    L14:
        r10 = r10 + 1;
        goto L8
    L15:
        r12 = false;
        goto L16
    L24:
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void w0(RecyclerView r8, int r10) {
        o r11 = new o(r8.getContext());
        r11.f2349a = r10;
        x0(r11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean y0() {
        if (this.f2245z == null) goto L5;
    L7:
        return false;
    L5:
        if (this.f2238s != this.f2241v) goto L7;
        return true;
    }

    public void z0(RecyclerView.z r8, int[] r10) {
        if (r8.f2364a == (-1)) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L8;
        int r12 = this.f2237r.l();
    L10:
        if (this.f2236q.f2263f != (-1)) goto L12;
        int r13 = 0;
    L13:
        r10[0] = r12;
        r10[1] = r13;
        return;
    L12:
        r13 = r12;
        r12 = 0;
        goto L13
    L8:
        r12 = 0;
        goto L10
    L5:
        r11 = false;
        goto L6
    }

    public LinearLayoutManager(Context r8, AttributeSet r10, int r11, int r12) {
        this.f2235p = 1;
        this.f2239t = false;
        this.f2240u = false;
        this.f2241v = false;
        this.f2242w = true;
        this.f2243x = -1;
        this.f2244y = Integer.MIN_VALUE;
        this.f2245z = null;
        this.A = new a();
        this.B = new b();
        this.C = 2;
        this.D = new int[2];
        RecyclerView.o.d r13 = RecyclerView.o.H(r8, r10, r11, r12);
        Z0(r13.f2330a);
        boolean r14 = r13.f2332c;
        c(null);
        if (r14 == this.f2239t) goto L6;
        this.f2239t = r14;
        k0();
    L6:
        a1(r13.f2333d);
    }
}
