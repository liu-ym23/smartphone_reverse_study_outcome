package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class i0 implements h.f {
    public AdapterView.OnItemSelectedListener A;
    public final g B;
    public final f C;
    public final e D;
    public final c E;
    public final Handler F;
    public final Rect G;
    public Rect H;
    public boolean I;
    public final p J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ListAdapter f1171b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public e0 f1172m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f1173n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f1174o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f1175p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f1176q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f1177r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f1178s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f1179t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f1180u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f1181v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f1182w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public d f1183x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public View f1184y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public AdapterView.OnItemClickListener f1185z;

    public static class a {
        public static int a(PopupWindow r8, View r10, int r11, boolean r12) {
            return r8.getMaxAvailableHeight(r10, r11, r12);
        }
    }

    public static class b {
        public static void a(PopupWindow r8, Rect r10) {
            r8.setEpicenterBounds(r10);
        }

        public static void b(PopupWindow r8, boolean r10) {
            r8.setIsClippedToScreen(r10);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i0 f1186a;

        public c(i0 r8) {
            this.f1186a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            e0 r8 = this.f1186a.f1172m;
            if (r8 == null) goto L6;
            r8.setListSelectionHidden(true);
            r8.requestLayout();
            return;
        }
    }

    public class d extends DataSetObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i0 f1187a;

        public d(i0 r8) {
            this.f1187a = r8;
        }

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            i0 r8 = this.f1187a;
            if (r8.isShowing() == false) goto L6;
            r8.show();
            return;
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            this.f1187a.dismiss();
        }
    }

    public class e implements AbsListView.OnScrollListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i0 f1188a;

        public e(i0 r8) {
            this.f1188a = r8;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public final void onScroll(AbsListView r8, int r10, int r11, int r12) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public final void onScrollStateChanged(AbsListView r8, int r10) {
            boolean r11 = true;
            if (r10 != 1) goto L13;
            i0 r12 = this.f1188a;
            if (r12.J.getInputMethodMode() == 2) goto L8;
            r11 = false;
        L8:
            if (r11 == false) goto L10;
            return;
        L10:
            if (r12.J.getContentView() == null) goto L15;
            Handler r13 = r12.F;
            g r14 = r12.B;
            r13.removeCallbacks(r14);
            r14.run();
            return;
        L15:
            return;
        }
    }

    public class f implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i0 f1189a;

        public f(i0 r8) {
            this.f1189a = r8;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r8, MotionEvent r10) {
            int r11 = r10.getAction();
            int r12 = (int) r10.getX();
            int r13 = (int) r10.getY();
            i0 r14 = this.f1189a;
            if (r11 != 0) goto L16;
            p r15 = r14.J;
            if (r15 == null) goto L16;
            if (r15.isShowing() == false) goto L16;
            if (r12 < 0) goto L16;
            p r16 = r14.J;
            if (r12 >= r16.getWidth()) goto L16;
            if (r13 < 0) goto L16;
            if (r13 >= r16.getHeight()) goto L16;
            r14.F.postDelayed(r14.B, 250);
            return false;
        L16:
            if (r11 != 1) goto L21;
            r14.F.removeCallbacks(r14.B);
            return false;
        L21:
            return false;
        }
    }

    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i0 f1190a;

        public g(i0 r8) {
            this.f1190a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            i0 r8 = this.f1190a;
            e0 r10 = r8.f1172m;
            if (r10 == null) goto L12;
            WeakHashMap<View, j0.h0> r11 = j0.w.f8437a;
            if (j0.w.g.b(r10) == true) goto L7;
            return;
        L7:
            if (r8.f1172m.getCount() > r8.f1172m.getChildCount()) goto L9;
            return;
        L9:
            if (r8.f1172m.getChildCount() > r8.f1182w) goto L15;
            r8.J.setInputMethodMode(2);
            r8.show();
            return;
        L15:
            return;
        }
    }

    public i0(Context r8, AttributeSet r10, int r11, int r12) {
        this.f1173n = -2;
        this.f1174o = -2;
        this.f1177r = 1002;
        this.f1181v = 0;
        this.f1182w = Integer.MAX_VALUE;
        this.B = new g(this);
        this.C = new f(this);
        this.D = new e(this);
        this.E = new c(this);
        this.G = new Rect();
        this.f1170a = r8;
        this.F = new Handler(r8.getMainLooper());
        TypedArray r13 = r8.obtainStyledAttributes(r10, c.a.f3229o, r11, r12);
        this.f1175p = r13.getDimensionPixelOffset(0, 0);
        int r14 = r13.getDimensionPixelOffset(1, 0);
        this.f1176q = r14;
        if (r14 == 0) goto L5;
        this.f1178s = true;
    L5:
        r13.recycle();
        p r15 = new p(r8, r10, r11, r12);
        this.J = r15;
        r15.setInputMethodMode(1);
    }

    public e0 d(Context r8, boolean r10) {
        return new e0(r8, r10);
    }

    @Override // h.f
    public final void dismiss() {
        p r8 = this.J;
        r8.dismiss();
        r8.setContentView(null);
        this.f1172m = null;
        this.F.removeCallbacks(this.B);
    }

    public final Object e() {
        if (isShowing() == true) goto L7;
        return null;
    L7:
        return this.f1172m.getSelectedItem();
    }

    public final long f() {
        if (isShowing() == true) goto L7;
        return Long.MIN_VALUE;
    L7:
        return this.f1172m.getSelectedItemId();
    }

    public final int g() {
        if (isShowing() == true) goto L7;
        return -1;
    L7:
        return this.f1172m.getSelectedItemPosition();
    }

    public final Drawable getBackground() {
        return this.J.getBackground();
    }

    public final int getHorizontalOffset() {
        return this.f1175p;
    }

    @Override // h.f
    public final e0 getListView() {
        return this.f1172m;
    }

    public final int getVerticalOffset() {
        if (this.f1178s == true) goto L7;
        return 0;
    L7:
        return this.f1176q;
    }

    public final View h() {
        if (isShowing() == true) goto L7;
        return null;
    L7:
        return this.f1172m.getSelectedView();
    }

    public final void i(int r8) {
        Drawable r10 = this.J.getBackground();
        if (r10 == null) goto L5;
        Rect r11 = this.G;
        r10.getPadding(r11);
        this.f1174o = (r11.left + r11.right) + r8;
        return;
    L5:
        this.f1174o = r8;
    }

    @Override // h.f
    public final boolean isShowing() {
        return this.J.isShowing();
    }

    public void setAdapter(ListAdapter r8) {
        d r10 = this.f1183x;
        if (r10 != null) goto L5;
        this.f1183x = new d(this);
    L8:
        this.f1171b = r8;
        if (r8 == null) goto L11;
        r8.registerDataSetObserver(this.f1183x);
    L11:
        e0 r11 = this.f1172m;
        if (r11 == null) goto L15;
        r11.setAdapter(this.f1171b);
        return;
    L15:
        return;
    L5:
        ListAdapter r12 = this.f1171b;
        if (r12 == null) goto L8;
        r12.unregisterDataSetObserver(r10);
        goto L8
    }

    public final void setBackgroundDrawable(Drawable r8) {
        this.J.setBackgroundDrawable(r8);
    }

    public final void setHorizontalOffset(int r8) {
        this.f1175p = r8;
    }

    public final void setVerticalOffset(int r8) {
        this.f1176q = r8;
        this.f1178s = true;
    }

    @Override // h.f
    public final void show() {
        e0 r8 = this.f1172m;
        p r10 = this.J;
        Context r11 = this.f1170a;
        if (r8 != null) goto L8;
        e0 r12 = d(r11, !this.I);
        this.f1172m = r12;
        r12.setAdapter(this.f1171b);
        this.f1172m.setOnItemClickListener(this.f1185z);
        this.f1172m.setFocusable(true);
        this.f1172m.setFocusableInTouchMode(true);
        this.f1172m.setOnItemSelectedListener(new h0(this));
        this.f1172m.setOnScrollListener(this.D);
        AdapterView.OnItemSelectedListener r13 = this.A;
        if (r13 == null) goto L7;
        this.f1172m.setOnItemSelectedListener(r13);
    L7:
        r10.setContentView(this.f1172m);
    L9:
        Drawable r14 = r10.getBackground();
        int r15 = 0;
        Rect r16 = this.G;
        if (r14 == null) goto L14;
        r14.getPadding(r16);
        int r17 = r16.top;
        int r18 = r16.bottom + r17;
        if (this.f1178s == true) goto L16;
        this.f1176q = -r17;
    L16:
        if (r10.getInputMethodMode() != 2) goto L18;
        boolean r19 = true;
    L19:
        int r20 = a.a(r10, this.f1184y, this.f1176q, r19);
        int r21 = this.f1173n;
        if (r21 != (-1)) goto L22;
        int r22 = r20 + r18;
    L35:
        if (r10.getInputMethodMode() != 2) goto L37;
        boolean r23 = true;
    L38:
        androidx.core.widget.j.d(r10, this.f1177r);
        if (r10.isShowing() == false) goto L70;
        View r24 = this.f1184y;
        WeakHashMap<View, j0.h0> r25 = j0.w.f8437a;
        if (j0.w.g.b(r24) == true) goto L43;
        return;
    L43:
        int r26 = this.f1174o;
        if (r26 != (-1)) goto L46;
        r26 = -1;
    L48:
        if (r21 != (-1)) goto L61;
        if (r23 == false) goto L51;
        r21 = r22;
    L52:
        int r27 = this.f1174o;
        if (r23 == false) goto L58;
        if (r27 != (-1)) goto L56;
        int r28 = -1;
    L57:
        r10.setWidth(r28);
        r10.setHeight(0);
    L63:
        r10.setOutsideTouchable(true);
        View r29 = this.f1184y;
        int r30 = this.f1175p;
        int r31 = this.f1176q;
        if (r26 >= 0) goto L66;
        r26 = -1;
    L66:
        if (r21 >= 0) goto L68;
        int r32 = -1;
    L69:
        r10.update(r29, r30, r31, r26, r32);
        return;
    L68:
        r32 = r21;
        goto L69
    L56:
        r28 = 0;
        goto L57
    L58:
        if (r27 != (-1)) goto L60;
        r15 = -1;
    L60:
        r10.setWidth(r15);
        r10.setHeight(-1);
        goto L63
    L51:
        r21 = -1;
        goto L52
    L61:
        if (r21 != (-2)) goto L63;
        r21 = r22;
        goto L63
    L46:
        if (r26 != (-2)) goto L48;
        r26 = this.f1184y.getWidth();
        goto L48
    L70:
        int r33 = this.f1174o;
        if (r33 != (-1)) goto L73;
        r33 = -1;
    L75:
        if (r21 != (-1)) goto L77;
        r21 = -1;
    L79:
        r10.setWidth(r33);
        r10.setHeight(r21);
        b.b(r10, true);
        r10.setOutsideTouchable(true);
        r10.setTouchInterceptor(this.C);
        if (this.f1180u == false) goto L82;
        androidx.core.widget.j.c(r10, this.f1179t);
    L82:
        b.a(r10, this.H);
        androidx.core.widget.i.a(r10, this.f1184y, this.f1175p, this.f1176q, this.f1181v);
        this.f1172m.setSelection(-1);
        if (this.I == true) goto L85;
    L86:
        e0 r34 = this.f1172m;
        if (r34 == null) goto L90;
        r34.setListSelectionHidden(true);
        r34.requestLayout();
    L90:
        if (this.I == true) goto L94;
        this.F.post(this.E);
        return;
    L94:
        return;
    L85:
        if (this.f1172m.isInTouchMode() == false) goto L90;
    L77:
        if (r21 != (-2)) goto L79;
        r21 = r22;
        goto L79
    L73:
        if (r33 != (-2)) goto L75;
        r33 = this.f1184y.getWidth();
        goto L75
    L37:
        r23 = false;
        goto L38
    L22:
        int r110 = this.f1174o;
        if (r110 != (-2)) goto L25;
        int r35 = View.MeasureSpec.makeMeasureSpec(r11.getResources().getDisplayMetrics().widthPixels - (r16.left + r16.right), Integer.MIN_VALUE);
    L29:
        int r36 = this.f1172m.a(r35, r20 + 0);
        if (r36 <= 0) goto L32;
        int r37 = ((this.f1172m.getPaddingBottom() + this.f1172m.getPaddingTop()) + r18) + 0;
    L33:
        r22 = r36 + r37;
        goto L35
    L32:
        r37 = 0;
        goto L33
    L25:
        if (r110 == (-1)) goto L27;
        r35 = View.MeasureSpec.makeMeasureSpec(r110, 1073741824);
        goto L29
    L27:
        r35 = View.MeasureSpec.makeMeasureSpec(r11.getResources().getDisplayMetrics().widthPixels - (r16.left + r16.right), 1073741824);
        goto L29
    L18:
        r19 = false;
        goto L19
    L14:
        r16.setEmpty();
        r18 = 0;
        goto L16
    L8:
        ViewGroup r38 = (ViewGroup) r10.getContentView();
        goto L9
    }
}
