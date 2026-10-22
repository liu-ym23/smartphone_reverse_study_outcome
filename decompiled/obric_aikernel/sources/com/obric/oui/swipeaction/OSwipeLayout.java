package com.obric.oui.swipeaction;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.obric.oui.layout.OUIFrameLayout;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
public class OSwipeLayout extends OUIFrameLayout {
    private static final DragEdge O = null;
    private boolean A;
    private float B;
    private float C;
    private ViewDragHelper.Callback D;
    private int E;
    private List<e> F;
    private boolean G;
    private float H;
    private float I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f7482J;
    View.OnClickListener K;
    View.OnLongClickListener L;
    private Rect M;
    private GestureDetector N;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f7483l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private DragEdge f7484m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ViewDragHelper f7485n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f7486o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private LinkedHashMap<DragEdge, View> f7487p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ShowMode f7488q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float[] f7489r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private List<i> f7490s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private List<g> f7491t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Map<View, ArrayList<f>> f7492u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Map<View, Boolean> f7493v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Map<View, Rect> f7494w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private d f7495x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f7496y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean[] f7497z;

    public static final enum DragEdge extends Enum<DragEdge> {
        private static final /* synthetic */ DragEdge[] $VALUES = null;
        public static final DragEdge Bottom = null;
        public static final DragEdge Left = null;
        public static final DragEdge Right = null;
        public static final DragEdge Top = null;

        static {
            DragEdge r10 = new DragEdge("Left", 0);
            Left = r10;
            DragEdge r11 = new DragEdge("Top", 1);
            Top = r11;
            DragEdge r12 = new DragEdge("Right", 2);
            Right = r12;
            DragEdge r13 = new DragEdge("Bottom", 3);
            Bottom = r13;
            $VALUES = new DragEdge[]{r10, r11, r12, r13};
        }

        private DragEdge(String r10, int r11) {
            super(r10, r11);
        }

        public static DragEdge valueOf(String r10) {
            return (DragEdge) Enum.valueOf(DragEdge.class, r10);
        }

        public static DragEdge[] values() {
            return (DragEdge[]) $VALUES.clone();
        }
    }

    public static final enum ShowMode extends Enum<ShowMode> {
        private static final /* synthetic */ ShowMode[] $VALUES = null;
        public static final ShowMode LayDown = null;
        public static final ShowMode PullOut = null;

        static {
            ShowMode r10 = new ShowMode("LayDown", 0);
            LayDown = r10;
            ShowMode r11 = new ShowMode("PullOut", 1);
            PullOut = r11;
            $VALUES = new ShowMode[]{r10, r11};
        }

        private ShowMode(String r10, int r11) {
            super(r10, r11);
        }

        public static ShowMode valueOf(String r10) {
            return (ShowMode) Enum.valueOf(ShowMode.class, r10);
        }

        public static ShowMode[] values() {
            return (ShowMode[]) $VALUES.clone();
        }
    }

    public static final enum Status extends Enum<Status> {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final Status Close = null;
        public static final Status Middle = null;
        public static final Status Open = null;

        static {
            Status r10 = new Status("Middle", 0);
            Middle = r10;
            Status r11 = new Status("Open", 1);
            Open = r11;
            Status r12 = new Status("Close", 2);
            Close = r12;
            $VALUES = new Status[]{r10, r11, r12};
        }

        private Status(String r10, int r11) {
            super(r10, r11);
        }

        public static Status valueOf(String r10) {
            return (Status) Enum.valueOf(Status.class, r10);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }
    }

    class a implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OSwipeLayout f7498c;

        a(OSwipeLayout r10) {
            this.f7498c = r10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            OSwipeLayout.j(this.f7498c);
        }
    }

    class b implements View.OnLongClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OSwipeLayout f7499c;

        b(OSwipeLayout r10) {
            this.f7499c = r10;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View r10) {
            OSwipeLayout.k(this.f7499c);
            return true;
        }
    }

    static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7500a = null;

        static {
            int[] r10 = new int[DragEdge.values().length];
            f7500a = r10;
            r10[DragEdge.Top.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f7500a[DragEdge.Bottom.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f7500a[DragEdge.Left.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f7500a[DragEdge.Right.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public interface d {
        void a(OSwipeLayout r10, boolean r11);
    }

    public interface e {
        void a(OSwipeLayout r10);
    }

    public interface f {
        void a(View r10, DragEdge r11, float r12, int r13);
    }

    public interface g {
        boolean a(MotionEvent r10);
    }

    class h extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OSwipeLayout f7501a;

        h(OSwipeLayout r10) {
            this.f7501a = r10;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent r10) {
            if (OSwipeLayout.e(this.f7501a) == null) goto L21;
            View r11 = this.f7501a.getCurrentBottomView();
            View r12 = this.f7501a.getSurfaceView();
            if (r11 != null) goto L7;
        L15:
            r11 = r12;
        L16:
            d r13 = OSwipeLayout.e(this.f7501a);
            OSwipeLayout r14 = this.f7501a;
            if (r11 != r12) goto L19;
            boolean r15 = true;
        L20:
            r13.a(r14, r15);
            goto L21
        L19:
            r15 = false;
            goto L20
        L7:
            if (r10.getX() <= r11.getLeft()) goto L15;
            if (r10.getX() >= r11.getRight()) goto L15;
            if (r10.getY() <= r11.getTop()) goto L15;
            if (r10.getY() >= r11.getBottom()) goto L15;
        L21:
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent r10) {
            if (OSwipeLayout.l(this.f7501a) == false) goto L8;
            if (OSwipeLayout.m(this.f7501a, r10) == false) goto L8;
            this.f7501a.r();
        L8:
            return super.onSingleTapUp(r10);
        }
    }

    public interface i {
        void a(OSwipeLayout r10);

        void b(OSwipeLayout r10, int r11, int r12);

        void c(OSwipeLayout r10);

        void d(OSwipeLayout r10);

        void e(OSwipeLayout r10);

        void f(OSwipeLayout r10, float r11, float r12);
    }

    static {
        O = DragEdge.Right;
    }

    public OSwipeLayout(Context r10) {
        this(r10, null);
    }

    public OSwipeLayout(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    public OSwipeLayout(Context r11, AttributeSet r12, int r13) {
        super(r11, r12, r13);
        this.f7484m = O;
        this.f7486o = 0;
        this.f7487p = new LinkedHashMap();
        this.f7489r = new float[4];
        this.f7490s = new ArrayList();
        this.f7491t = new ArrayList();
        this.f7492u = new HashMap();
        this.f7493v = new HashMap();
        this.f7494w = new HashMap();
        this.f7496y = true;
        this.f7497z = new boolean[]{true, true, true, true};
        this.A = false;
        this.B = 0.75f;
        this.C = 0.25f;
        this.D = new AnonymousClass1(this);
        this.E = 0;
        this.H = -1.0f;
        this.I = -1.0f;
        this.f7482J = false;
        this.N = new GestureDetector(getContext(), new h(this));
        this.f7485n = ViewDragHelper.create(this, this.D);
        this.f7483l = ViewConfiguration.get(r11).getScaledTouchSlop();
        TypedArray r14 = r11.obtainStyledAttributes(r12, l.OSwipeLayout);
        int r15 = r14.getInt(l.OSwipeLayout_oui_drag_edge, 2);
        float[] r10 = this.f7489r;
        DragEdge r16 = DragEdge.Left;
        r10[r16.ordinal()] = r14.getDimension(l.OSwipeLayout_oui_leftEdgeSwipeOffset, 0.0f);
        float[] r17 = this.f7489r;
        DragEdge r18 = DragEdge.Right;
        r17[r18.ordinal()] = r14.getDimension(l.OSwipeLayout_oui_rightEdgeSwipeOffset, 0.0f);
        float[] r19 = this.f7489r;
        DragEdge r20 = DragEdge.Top;
        r19[r20.ordinal()] = r14.getDimension(l.OSwipeLayout_oui_topEdgeSwipeOffset, 0.0f);
        float[] r21 = this.f7489r;
        DragEdge r22 = DragEdge.Bottom;
        r21[r22.ordinal()] = r14.getDimension(l.OSwipeLayout_oui_bottomEdgeSwipeOffset, 0.0f);
        setClickToClose(r14.getBoolean(l.OSwipeLayout_oui_clickToClose, this.A));
        if ((r15 & 1) != 1) goto L6;
        this.f7487p.put(r16, null);
    L6:
        if ((r15 & 4) != 4) goto L9;
        this.f7487p.put(r20, null);
    L9:
        if ((r15 & 2) != 2) goto L12;
        this.f7487p.put(r18, null);
    L12:
        if ((r15 & 8) != 8) goto L14;
        this.f7487p.put(r22, null);
    L14:
        int r110 = r14.getInt(l.OSwipeLayout_oui_show_mode, ShowMode.PullOut.ordinal());
        this.f7488q = ShowMode.values()[r110];
        r14.recycle();
    }

    private int A(float r10) {
        return (int) ((r10 * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    private int C(ViewGroup r10, View r11) {
        int r12 = r10.getChildCount();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L13;
        View r14 = r10.getChildAt(r13);
        if (r14 == r11) goto L6;
        if ((r14 instanceof ViewGroup) == false) goto L12;
        if (w((ViewGroup) r14, r11) == false) goto L12;
        return r13;
    L12:
        r13 = r13 + 1;
        goto L3
    L6:
        return r13;
    L13:
        return -1;
    }

    private boolean E() {
        if (getAdapterView() == null) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean K(MotionEvent r10) {
        View r11 = getSurfaceView();
        if (r11 != null) goto L7;
        return false;
    L7:
        if (this.M != null) goto L9;
        this.M = new Rect();
    L9:
        r11.getHitRect(this.M);
        return this.M.contains((int) r10.getX(), (int) r10.getY());
    }

    private void R() {
        if (getOpenStatus() == Status.Close) goto L5;
        return;
    L5:
        AdapterView r10 = getAdapterView();
        if (r10 == null) goto L15;
        int r11 = r10.getPositionForView(this);
        if (r11 == (-1)) goto L10;
    L12:
        if (r11 == (-1)) goto L16;
        r10.performItemClick(r10.getChildAt(r11 - r10.getFirstVisiblePosition()), r11, r10.getAdapter().getItemId(r11));
        return;
    L16:
        return;
    L10:
        if (B() == false) goto L12;
        r11 = C(r10, this);
        goto L12
    }

    private boolean S() {
        if (getOpenStatus() == Status.Close) goto L5;
        return false;
    L5:
        AdapterView<?> r10 = getAdapterView();
        if (r10 == null) goto L26;
        int r11 = r10.getPositionForView(this);
        if (r11 == (-1)) goto L10;
    L12:
        int r12 = r11;
        if (r12 != (-1)) goto L15;
        return false;
    L15:
        long r13 = r10.getItemIdAtPosition(r12);
        Method r14 = AbsListView.class.getDeclaredMethod("performLongPress", new Class[]{View.class, Integer.TYPE, Long.TYPE});     // Catch: Exception -> L18
        r14.setAccessible(true);     // Catch: Exception -> L18
        return ((Boolean) r14.invoke(r10, new Object[]{this, Integer.valueOf(r12), Long.valueOf(r13)})).booleanValue();
    L18:
        e = move-exception;
        e.printStackTrace();
        if (r10.getOnItemLongClickListener() == null) goto L22;
        boolean r15 = r10.getOnItemLongClickListener().onItemLongClick(r10, this, r12, r13);
    L23:
        if (r15 == false) goto L29;
        r10.performHapticFeedback(0);
        return r15;
    L29:
        return r15;
    L22:
        r15 = false;
        goto L23
    L10:
        if (B() == false) goto L12;
        r11 = C(r10, this);
        goto L12
    L26:
        return false;
    }

    private void U() {
        Status r10 = getOpenStatus();
        List<View> r11 = getBottomViews();
        if (r10 != Status.Close) goto L12;
        Iterator<View> r12 = r11.iterator();
    L6:
        if (r12.hasNext() == false) goto L27;
        View r13 = r12.next();
        if (r13 == null) goto L6;
        if (r13.getVisibility() == 4) goto L6;
        r13.setVisibility(4);
        goto L6
    L27:
        return;
    L12:
        View r14 = getCurrentBottomView();
        if (r14 != null) goto L15;
        return;
    L15:
        if (r14.getVisibility() == 0) goto L26;
        r14.setVisibility(0);
        return;
    }

    private void V() {
        View r10 = getCurrentBottomView();
        if (r10 == null) goto L12;
        DragEdge r11 = this.f7484m;
        if (r11 != DragEdge.Left) goto L7;
    L10:
        int r12 = r10.getMeasuredWidth();
    L11:
        this.f7486o = r12 - A(getCurrentOffset());
        goto L12
    L7:
        if (r11 == DragEdge.Right) goto L10;
        r12 = r10.getMeasuredHeight();
    L12:
        ShowMode r13 = this.f7488q;
        if (r13 != ShowMode.PullOut) goto L16;
        O();
    L18:
        U();
        return;
    L16:
        if (r13 != ShowMode.LayDown) goto L18;
        N();
        goto L18
    }

    static /* synthetic */ DragEdge c(OSwipeLayout r10) {
        return r10.f7484m;
    }

    static /* synthetic */ int d(OSwipeLayout r10) {
        return r10.f7486o;
    }

    static /* synthetic */ d e(OSwipeLayout r10) {
        return r10.f7495x;
    }

    static /* synthetic */ ShowMode f(OSwipeLayout r10) {
        return r10.f7488q;
    }

    static /* synthetic */ List g(OSwipeLayout r10) {
        return r10.f7490s;
    }

    private AdapterView getAdapterView() {
        ViewParent r10 = getParent();
        if (B() == false) goto L9;
    L4:
        if (r10 == null) goto L9;
        if ((r10 instanceof AdapterView) == true) goto L9;
        r10 = r10.getParent();
    L9:
        if ((r10 instanceof AdapterView) == true) goto L11;
        return null;
    L11:
        return (AdapterView) r10;
    }

    private float getCurrentOffset() {
        DragEdge r10 = this.f7484m;
        if (r10 != null) goto L7;
        return 0.0f;
    L7:
        return this.f7489r[r10.ordinal()];
    }

    static /* synthetic */ Rect h(OSwipeLayout r10, DragEdge r11) {
        return r10.t(r11);
    }

    static /* synthetic */ void i(OSwipeLayout r10) {
        r10.o();
    }

    static /* synthetic */ void j(OSwipeLayout r10) {
        r10.R();
    }

    static /* synthetic */ boolean k(OSwipeLayout r10) {
        return r10.S();
    }

    static /* synthetic */ boolean l(OSwipeLayout r10) {
        return r10.A;
    }

    static /* synthetic */ boolean m(OSwipeLayout r10, MotionEvent r11) {
        return r10.K(r11);
    }

    private void o() {
        View r10 = getCurrentBottomView();
        if (getOpenStatus() != Status.Close) goto L6;
        this.f7494w.remove(r10);
        return;
    L6:
        int r11 = 0;
        View[] r12 = {getSurfaceView(), r10};
    L7:
        if (r11 >= 2) goto L12;
        View r13 = r12[r11];
        Rect r14 = this.f7494w.get(r13);
        if (r14 != null) goto L11;
        r14 = new Rect();
        this.f7494w.put(r13, r14);
    L11:
        r14.left = r13.getLeft();
        r14.top = r13.getTop();
        r14.right = r13.getRight();
        r14.bottom = r13.getBottom();
        r11 = r11 + 1;
        goto L7
    }

    private void p(MotionEvent r12) {
        if (this.G == false) goto L5;
        return;
    L5:
        Status r10 = getOpenStatus();
        Status r11 = Status.Middle;
        if (r10 != r11) goto L9;
        this.G = true;
        return;
    L9:
        Status r13 = getOpenStatus();
        float r14 = r12.getRawX() - this.H;
        float r15 = r12.getRawY() - this.I;
        float r16 = (float) Math.toDegrees(Math.atan(Math.abs(r15 / r14)));
        Status r17 = getOpenStatus();
        Status r18 = Status.Close;
        if (r17 == r18) goto L12;
    L36:
        DragEdge r19 = this.f7484m;
        boolean r20 = false;
        if (r19 == DragEdge.Right) goto L39;
    L56:
        boolean r21 = false;
    L58:
        if (r19 != DragEdge.Left) goto L78;
        if (r13 == Status.Open) goto L62;
    L63:
        if (r13 == r18) goto L65;
    L67:
        boolean r22 = false;
    L68:
        if (r22 == true) goto L72;
        if (r13 == r11) goto L72;
        boolean r23 = false;
    L74:
        if (r16 > 30.0f) goto L76;
        if (r23 == true) goto L78;
    L76:
        r21 = true;
    L72:
        r23 = true;
        goto L74
    L65:
        if (r14 <= this.f7483l) goto L67;
    L66:
        r22 = true;
        goto L68
    L62:
        if (r14 < (-this.f7483l)) goto L66;
    L78:
        if (r19 != DragEdge.Top) goto L98;
        if (r13 == Status.Open) goto L82;
    L83:
        if (r13 == r18) goto L85;
    L87:
        boolean r24 = false;
    L88:
        if (r24 == true) goto L92;
        if (r13 == r11) goto L92;
        boolean r25 = false;
    L94:
        if (r16 < 60.0f) goto L96;
        if (r25 == true) goto L98;
    L96:
        r21 = true;
    L92:
        r25 = true;
        goto L94
    L85:
        if (r15 <= this.f7483l) goto L87;
    L86:
        r24 = true;
        goto L88
    L82:
        if (r15 < (-this.f7483l)) goto L86;
    L98:
        if (r19 == DragEdge.Bottom) goto L100;
    L115:
        this.G = !r21;
        return;
    L100:
        if (r13 == Status.Open) goto L102;
    L103:
        if (r13 == r18) goto L105;
    L107:
        boolean r110 = false;
    L108:
        if (r110 == true) goto L110;
        if (r13 == r11) goto L110;
    L112:
        if (r16 < 60.0f) goto L114;
        if (r20 == true) goto L115;
    L114:
        r21 = true;
    L110:
        r20 = true;
        goto L112
    L105:
        if (r15 >= (-this.f7483l)) goto L107;
    L106:
        r110 = true;
        goto L108
    L102:
        if (r15 > this.f7483l) goto L106;
    L39:
        if (r13 == Status.Open) goto L41;
    L42:
        if (r13 == r18) goto L44;
    L46:
        boolean r26 = false;
    L47:
        if (r26 == true) goto L51;
        if (r13 == r11) goto L51;
        boolean r27 = false;
    L53:
        if (r16 > 30.0f) goto L55;
        if (r27 == true) goto L56;
    L55:
        r21 = true;
    L51:
        r27 = true;
        goto L53
    L44:
        if (r14 >= (-this.f7483l)) goto L46;
    L45:
        r26 = true;
        goto L47
    L41:
        if (r14 > this.f7483l) goto L45;
    L12:
        if (r16 >= 45.0f) goto L25;
        if (r14 <= 0.0f) goto L19;
        if (G() == false) goto L19;
        DragEdge r28 = DragEdge.Left;
    L34:
        setCurrentDragEdge(r28);
    L19:
        if (r14 < 0.0f) goto L21;
        return;
    L21:
        if (H() == false) goto L117;
        r28 = DragEdge.Right;
        goto L34
    L117:
        return;
    L25:
        if (r15 <= 0.0f) goto L30;
        if (J() == false) goto L30;
        r28 = DragEdge.Top;
    L30:
        if (r15 < 0.0f) goto L32;
        return;
    L32:
        if (F() == false) goto L118;
        r28 = DragEdge.Bottom;
        goto L34
    }

    private void setCurrentDragEdge(DragEdge r10) {
        this.f7484m = r10;
        V();
    }

    private Rect t(DragEdge r10) {
        int r11 = getPaddingLeft();
        int r12 = getPaddingTop();
        DragEdge r13 = DragEdge.Right;
        if (r10 != r13) goto L6;
        r11 = getMeasuredWidth() - this.f7486o;
    L9:
        if (r10 == DragEdge.Left) goto L13;
        if (r10 == r13) goto L13;
        int r14 = getMeasuredWidth() + r11;
        int r15 = this.f7486o;
    L15:
        return new Rect(r11, r12, r14, r15 + r12);
    L13:
        r14 = this.f7486o + r11;
        r15 = getMeasuredHeight();
        goto L15
    L6:
        if (r10 != DragEdge.Bottom) goto L9;
        r12 = getMeasuredHeight() - this.f7486o;
        goto L9
    }

    private Rect u(ShowMode r10, Rect r11) {
        View r12 = getCurrentBottomView();
        int r13 = r11.left;
        int r14 = r11.top;
        int r15 = r11.right;
        int r16 = r11.bottom;
        if (r10 != ShowMode.PullOut) goto L27;
        DragEdge r17 = this.f7484m;
        DragEdge r18 = DragEdge.Left;
        if (r17 != r18) goto L8;
        r13 = r13 - this.f7486o;
    L14:
        int r19 = 0;
        if (r17 != r18) goto L17;
    L23:
        if (r12 == null) goto L31;
        r19 = r12.getMeasuredWidth();
    L31:
        r15 = r13 + r19;
    L40:
        return new Rect(r13, r14, r15, r16);
    L17:
        if (r17 == DragEdge.Right) goto L23;
        if (r12 == null) goto L22;
        r19 = r12.getMeasuredHeight();
    L22:
        r16 = r14 + r19;
        r15 = r11.right;
        goto L40
    L8:
        if (r17 != DragEdge.Right) goto L11;
        r13 = r15;
        goto L14
    L11:
        if (r17 != DragEdge.Top) goto L13;
        r14 = r14 - this.f7486o;
        goto L14
    L13:
        r14 = r16;
        goto L14
    L27:
        if (r10 != ShowMode.LayDown) goto L40;
        DragEdge r20 = this.f7484m;
        if (r20 != DragEdge.Left) goto L33;
        r19 = this.f7486o;
        goto L31
    L33:
        if (r20 != DragEdge.Right) goto L35;
        r13 = r15 - this.f7486o;
        goto L40
    L35:
        DragEdge r21 = DragEdge.Top;
        int r22 = this.f7486o;
        if (r20 != r21) goto L38;
        r16 = r14 + r22;
        goto L40
    L38:
        r14 = r16 - r22;
        goto L40
    }

    private Rect v(boolean r10) {
        int r11 = getPaddingLeft();
        int r12 = getPaddingTop();
        if (r10 == false) goto L15;
        DragEdge r13 = this.f7484m;
        if (r13 != DragEdge.Left) goto L8;
        int r14 = getPaddingLeft();
        r11 = this.f7486o + r14;
        goto L15
    L8:
        if (r13 != DragEdge.Right) goto L11;
        r11 = getPaddingLeft() - this.f7486o;
        goto L15
    L11:
        if (r13 != DragEdge.Top) goto L13;
        int r15 = getPaddingTop();
        r12 = this.f7486o + r15;
        goto L15
    L13:
        r12 = getPaddingTop() - this.f7486o;
    L15:
        return new Rect(r11, r12, getMeasuredWidth() + r11, getMeasuredHeight() + r12);
    }

    private boolean w(ViewGroup r10, View r11) {
        int r12 = r10.getChildCount();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L13;
        View r14 = r10.getChildAt(r13);
        if (r14 == r11) goto L6;
        if ((r14 instanceof ViewGroup) == false) goto L12;
        if (w((ViewGroup) r14, r11) == false) goto L12;
        return true;
    L12:
        r13 = r13 + 1;
        goto L3
    L6:
        return true;
    L13:
        return false;
    }

    public boolean B() {
        return this.f7482J;
    }

    protected Rect D(View r10) {
        Rect r11 = new Rect(r10.getLeft(), r10.getTop(), 0, 0);
        View r12 = r10;
    L4:
        if (r12.getParent() == null) goto L11;
        if (r12 == getRootView()) goto L11;
        r12 = (View) r12.getParent();
        if (r12 == this) goto L11;
        r11.left += r12.getLeft();
        r11.top += r12.getTop();
    L11:
        r11.right = r11.left + r10.getMeasuredWidth();
        r11.bottom = r11.top + r10.getMeasuredHeight();
        return r11;
    }

    public boolean F() {
        LinkedHashMap<DragEdge, View> r10 = this.f7487p;
        DragEdge r11 = DragEdge.Bottom;
        View r12 = r10.get(r11);
        if (r12 != null) goto L5;
    L11:
        return false;
    L5:
        if (r12.getParent() != this) goto L11;
        if (r12 == getSurfaceView()) goto L11;
        if (this.f7497z[r11.ordinal()] == false) goto L11;
        return true;
    }

    public boolean G() {
        LinkedHashMap<DragEdge, View> r10 = this.f7487p;
        DragEdge r11 = DragEdge.Left;
        View r12 = r10.get(r11);
        if (r12 != null) goto L5;
    L11:
        return false;
    L5:
        if (r12.getParent() != this) goto L11;
        if (r12 == getSurfaceView()) goto L11;
        if (this.f7497z[r11.ordinal()] == false) goto L11;
        return true;
    }

    public boolean H() {
        LinkedHashMap<DragEdge, View> r10 = this.f7487p;
        DragEdge r11 = DragEdge.Right;
        View r12 = r10.get(r11);
        if (r12 != null) goto L5;
    L11:
        return false;
    L5:
        if (r12.getParent() != this) goto L11;
        if (r12 == getSurfaceView()) goto L11;
        if (this.f7497z[r11.ordinal()] == false) goto L11;
        return true;
    }

    public boolean I() {
        return this.f7496y;
    }

    public boolean J() {
        LinkedHashMap<DragEdge, View> r10 = this.f7487p;
        DragEdge r11 = DragEdge.Top;
        View r12 = r10.get(r11);
        if (r12 != null) goto L5;
    L11:
        return false;
    L5:
        if (r12.getParent() != this) goto L11;
        if (r12 == getSurfaceView()) goto L11;
        if (this.f7497z[r11.ordinal()] == false) goto L11;
        return true;
    }

    protected boolean L(View r10, Rect r11, DragEdge r12, int r13, int r14, int r15, int r16) {
        int r17 = r11.left;
        int r18 = r11.right;
        int r19 = r11.top;
        int r110 = r11.bottom;
        if (getShowMode() != ShowMode.LayDown) goto L23;
        int r20 = c.f7500a[r12.ordinal()];
        if (r20 == 1) goto L19;
        if (r20 == 2) goto L16;
        if (r20 == 3) goto L13;
        if (r20 != 4) goto L68;
        if (r15 <= r17) goto L50;
        if (r15 > r18) goto L52;
        return true;
    L52:
        return false;
    L50:
        return false;
    L68:
        return false;
    L13:
        if (r13 >= r18) goto L53;
        if (r13 < r17) goto L54;
        return true;
    L54:
        return false;
    L53:
        return false;
    L16:
        if (r16 <= r19) goto L55;
        if (r16 > r110) goto L56;
        return true;
    L56:
        return false;
    L55:
        return false;
    L19:
        if (r14 < r19) goto L57;
        if (r14 >= r110) goto L58;
        return true;
    L58:
        return false;
    L57:
        return false;
    L23:
        if (getShowMode() != ShowMode.PullOut) goto L59;
        int r111 = c.f7500a[r12.ordinal()];
        if (r111 == 1) goto L46;
        if (r111 == 2) goto L41;
        if (r111 == 3) goto L36;
        if (r111 == 4) goto L31;
        return false;
    L31:
        if (r17 <= getWidth()) goto L33;
        return false;
    L33:
        if (r18 <= getWidth()) goto L61;
        return true;
    L61:
        return false;
    L36:
        if (r18 >= getPaddingLeft()) goto L38;
        return false;
    L38:
        if (r17 >= getPaddingLeft()) goto L63;
        return true;
    L63:
        return false;
    L41:
        if (r19 < getHeight()) goto L43;
        return false;
    L43:
        if (r19 < getPaddingTop()) goto L65;
        return true;
    L65:
        return false;
    L46:
        if (r19 < getPaddingTop()) goto L48;
        return false;
    L48:
        if (r110 < getPaddingTop()) goto L67;
        return true;
    L67:
        return false;
    L59:
        return false;
    }

    protected boolean M(View r10, Rect r11, DragEdge r12, int r13, int r14, int r15, int r16) {
        if (this.f7493v.get(r10).booleanValue() == false) goto L5;
        return false;
    L5:
        int r17 = r11.left;
        int r18 = r11.right;
        int r19 = r11.top;
        int r20 = r11.bottom;
        if (getShowMode() != ShowMode.LayDown) goto L21;
        if (r12 != DragEdge.Right) goto L11;
        if (r15 > r17) goto L11;
    L41:
        return true;
    L11:
        if (r12 != DragEdge.Left) goto L14;
        if (r13 >= r18) goto L41;
    L14:
        if (r12 != DragEdge.Top) goto L17;
        if (r14 >= r20) goto L41;
    L17:
        if (r12 != DragEdge.Bottom) goto L39;
        if (r16 <= r19) goto L41;
        return false;
    L39:
        return false;
    L21:
        if (getShowMode() == ShowMode.PullOut) goto L23;
        return false;
    L23:
        if (r12 != DragEdge.Right) goto L27;
        if (r18 <= getWidth()) goto L41;
    L27:
        if (r12 != DragEdge.Left) goto L31;
        if (r17 >= getPaddingLeft()) goto L41;
    L31:
        if (r12 != DragEdge.Top) goto L35;
        if (r19 >= getPaddingTop()) goto L41;
    L35:
        if (r12 == DragEdge.Bottom) goto L37;
        return false;
    L37:
        if (r20 <= getHeight()) goto L41;
        return false;
    }

    void N() {
        View r10 = getSurfaceView();
        Rect r11 = this.f7494w.get(r10);
        if (r11 != null) goto L5;
        r11 = v(false);
    L5:
        if (r10 == null) goto L7;
        r10.layout(r11.left, r11.top, r11.right, r11.bottom);
        bringChildToFront(r10);
    L7:
        View r12 = getCurrentBottomView();
        Rect r13 = this.f7494w.get(r12);
        if (r13 != null) goto L10;
        r13 = u(ShowMode.LayDown, r11);
    L10:
        if (r12 == null) goto L13;
        r12.layout(r13.left, r13.top, r13.right, r13.bottom);
        return;
    }

    void O() {
        View r10 = getSurfaceView();
        if (getOpenStatus() == Status.Close) goto L5;
        boolean r11 = true;
    L6:
        Rect r12 = v(r11);
        if (r10 == null) goto L9;
        r10.layout(r12.left, r12.top, r12.right, r12.bottom);
        bringChildToFront(r10);
    L9:
        View r13 = getCurrentBottomView();
        Rect r14 = u(ShowMode.PullOut, r12);
        if (r13 == null) goto L13;
        r13.layout(r14.left, r14.top, r14.right, r14.bottom);
        return;
    L13:
        return;
    L5:
        r11 = false;
        goto L6
    }

    public void P() {
        Q(true, true);
    }

    public void Q(boolean r10, boolean r11) {
        View r12 = getSurfaceView();
        View r13 = getCurrentBottomView();
        if (r12 != null) goto L5;
        return;
    L5:
        Rect r14 = v(true);
        if (r10 == false) goto L8;
        this.f7485n.smoothSlideViewTo(r12, r14.left, r14.top);
    L16:
        invalidate();
        return;
    L8:
        int r15 = r14.left - r12.getLeft();
        int r16 = r14.top - r12.getTop();
        r12.layout(r14.left, r14.top, r14.right, r14.bottom);
        ShowMode r17 = getShowMode();
        ShowMode r18 = ShowMode.PullOut;
        if (r17 != r18) goto L13;
        Rect r19 = u(r18, r14);
        if (r13 == null) goto L13;
        r13.layout(r19.left, r19.top, r19.right, r19.bottom);
    L13:
        if (r11 == false) goto L15;
        x(r14.left, r14.top, r14.right, r14.bottom);
        y(r14.left, r14.top, r15, r16);
        goto L16
    L15:
        U();
        goto L16
    }

    protected void T(float r10, float r11, boolean r12) {
        float r13 = this.f7485n.getMinVelocity();
        View r14 = getSurfaceView();
        DragEdge r15 = this.f7484m;
        if (r15 == null) goto L53;
        if (r14 == null) goto L57;
        if (r12 == false) goto L8;
        float r16 = this.C;
    L10:
        if (r15 != DragEdge.Left) goto L21;
        if (r10 <= r13) goto L15;
    L13:
        P();
        return;
    L15:
        if (r10 >= (-r13)) goto L18;
    L24:
        r();
        return;
    L18:
        if (((getSurfaceView().getLeft() * 1.0f) / this.f7486o) <= r16) goto L24;
    L21:
        if (r15 != DragEdge.Right) goto L32;
        if (r10 > r13) goto L24;
        if (r10 < (-r13)) goto L13;
        if ((((-getSurfaceView().getLeft()) * 1.0f) / this.f7486o) <= r16) goto L24;
    L32:
        if (r15 != DragEdge.Top) goto L43;
        if (r11 > r13) goto L13;
        if (r11 < (-r13)) goto L24;
        if (((getSurfaceView().getTop() * 1.0f) / this.f7486o) <= r16) goto L24;
    L43:
        if (r15 == DragEdge.Bottom) goto L45;
        return;
    L45:
        if (r11 > r13) goto L24;
        if (r11 < (-r13)) goto L13;
        if ((((-getSurfaceView().getTop()) * 1.0f) / this.f7486o) <= r16) goto L24;
    L8:
        r16 = this.B;
        goto L10
    L57:
        return;
    }

    @Override // android.view.ViewGroup
    public void addView(View r10, int r11, ViewGroup.LayoutParams r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        int r13 = 0;
        r13 = ((Integer) r12.getClass().getField("gravity").get(r12)).intValue();     // Catch: Exception -> L7
    L9:
        if (r13 <= 0) goto L22;
        int r14 = GravityCompat.getAbsoluteGravity(r13, ViewCompat.getLayoutDirection(this));
        if ((r14 & 3) != 3) goto L14;
        this.f7487p.put(DragEdge.Left, r10);
    L14:
        if ((r14 & 5) != 5) goto L17;
        this.f7487p.put(DragEdge.Right, r10);
    L17:
        if ((r14 & 48) != 48) goto L20;
        this.f7487p.put(DragEdge.Top, r10);
    L20:
        if ((r14 & 80) != 80) goto L30;
        LinkedHashMap<DragEdge, View> r15 = this.f7487p;
        DragEdge r16 = DragEdge.Bottom;
    L28:
        r15.put(r16, r10);
    L30:
        if (r10.getParent() != this) goto L32;
        return;
    L32:
        super.addView(r10, r11, r12);
        return;
    L22:
        Iterator<Map.Entry<DragEdge, View>> r17 = this.f7487p.entrySet().iterator();
    L24:
        if (r17.hasNext() == false) goto L30;
        Map.Entry<DragEdge, View> r18 = r17.next();
        if (r18.getValue() != null) goto L24;
        r15 = this.f7487p;
        r16 = r18.getKey();
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.f7485n.continueSettling(true) == false) goto L6;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    }

    public List<View> getBottomViews() {
        ArrayList r10 = new ArrayList();
        DragEdge[] r11 = DragEdge.values();
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        DragEdge r14 = r11[r13];
        r10.add(this.f7487p.get(r14));
        r13 = r13 + 1;
        goto L3
    L5:
        return r10;
    }

    public View getCurrentBottomView() {
        List<View> r10 = getBottomViews();
        if (this.f7484m.ordinal() < r10.size()) goto L5;
        return null;
    L5:
        return r10.get(this.f7484m.ordinal());
    }

    public int getDragDistance() {
        return this.f7486o;
    }

    public DragEdge getDragEdge() {
        return this.f7484m;
    }

    public Map<DragEdge, View> getDragEdgeMap() {
        return this.f7487p;
    }

    @Deprecated
    public List<DragEdge> getDragEdges() {
        return new ArrayList(this.f7487p.keySet());
    }

    public Status getOpenStatus() {
        View r10 = getSurfaceView();
        if (r10 == null) goto L5;
        int r11 = r10.getLeft();
        int r12 = r10.getTop();
        if (r11 != getPaddingLeft()) goto L13;
        if (r12 != getPaddingTop()) goto L13;
        return Status.Close;
    L13:
        if (r11 == (getPaddingLeft() - this.f7486o)) goto L24;
        if (r11 == (getPaddingLeft() + this.f7486o)) goto L24;
        if (r12 == (getPaddingTop() - this.f7486o)) goto L24;
        if (r12 == (getPaddingTop() + this.f7486o)) goto L24;
        return Status.Middle;
    L24:
        return Status.Open;
    L5:
        return Status.Close;
    }

    public ShowMode getShowMode() {
        return this.f7488q;
    }

    public View getSurfaceView() {
        if (getChildCount() != 0) goto L7;
        return null;
    L7:
        return getChildAt(getChildCount() - 1);
    }

    public float getWillOpenPercentAfterClose() {
        return this.C;
    }

    public float getWillOpenPercentAfterOpen() {
        return this.B;
    }

    public void n(i r10) {
        this.f7490s.add(r10);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (E() == true) goto L5;
        return;
    L5:
        if (this.K != null) goto L8;
        setOnClickListener(new a(this));
    L8:
        if (this.L != null) goto L12;
        setOnLongClickListener(new b(this));
        return;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        if (I() == true) goto L6;
        return false;
    L6:
        if (this.A == true) goto L8;
    L12:
        Iterator<g> r11 = this.f7491t.iterator();
    L14:
        if (r11.hasNext() == false) goto L20;
        g r12 = r11.next();
        if (r12 == null) goto L14;
        if (r12.a(r10) == false) goto L14;
        return false;
    L20:
        int r13 = r10.getAction();
        if (r13 == 0) goto L39;
        if (r13 != 1) goto L24;
    L37:
        this.G = false;
    L38:
        this.f7485n.processTouchEvent(r10);
    L43:
        return this.G;
    L24:
        if (r13 != 2) goto L26;
        boolean r14 = this.G;
        p(r10);
        if (this.G == false) goto L33;
        ViewParent r15 = getParent();
        if (r15 == null) goto L33;
        r15.requestDisallowInterceptTouchEvent(true);
    L33:
        if (r14 == true) goto L43;
        if (this.G == false) goto L43;
        return false;
    L26:
        if (r13 == 3) goto L37;
    L39:
        this.f7485n.processTouchEvent(r10);
        this.G = false;
        this.H = r10.getRawX();
        this.I = r10.getRawY();
        if (getOpenStatus() != Status.Middle) goto L43;
        this.G = true;
        goto L43
    L8:
        if (getOpenStatus() != Status.Open) goto L12;
        if (K(r10) == false) goto L12;
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        V();
        if (this.F == null) goto L8;
        int r15 = 0;
    L6:
        if (r15 >= this.F.size()) goto L10;
        this.F.get(r15).a(this);
        r15 = r15 + 1;
        goto L6
    L10:
        return;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        if (I() == false) goto L5;
        int r11 = r10.getActionMasked();
        this.N.onTouchEvent(r10);
        if (r11 == 0) goto L16;
        if (r11 != 1) goto L10;
    L14:
        this.G = false;
    L15:
        this.f7485n.processTouchEvent(r10);
    L21:
        if (super.onTouchEvent(r10) == true) goto L26;
        if (this.G == true) goto L26;
        if (r11 == 0) goto L26;
        return false;
    L26:
        return true;
    L10:
        if (r11 != 2) goto L12;
    L17:
        p(r10);
        if (this.G == false) goto L21;
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L15
    L12:
        if (r11 == 3) goto L14;
    L16:
        this.f7485n.processTouchEvent(r10);
        this.H = r10.getRawX();
        this.I = r10.getRawY();
        goto L17
    L5:
        return super.onTouchEvent(r10);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View r10) {
        Iterator r11 = new HashMap(this.f7487p).entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Map.Entry r12 = (Map.Entry) r11.next();
        if (r12.getValue() != r10) goto L4;
        this.f7487p.remove(r12.getKey());
        goto L4
    }

    public void q() {
        this.f7487p.clear();
    }

    public void r() {
        s(true, true);
    }

    public void s(boolean r10, boolean r11) {
        View r12 = getSurfaceView();
        if (r12 != null) goto L5;
        return;
    L5:
        if (r10 == false) goto L7;
        this.f7485n.smoothSlideViewTo(getSurfaceView(), getPaddingLeft(), getPaddingTop());
    L11:
        invalidate();
        return;
    L7:
        Rect r13 = v(false);
        int r14 = r13.left - r12.getLeft();
        int r15 = r13.top - r12.getTop();
        r12.layout(r13.left, r13.top, r13.right, r13.bottom);
        if (r11 == false) goto L10;
        x(r13.left, r13.top, r13.right, r13.bottom);
        y(r13.left, r13.top, r14, r15);
        goto L11
    L10:
        U();
        goto L11
    }

    public void setBottomSwipeEnabled(boolean r10) {
        this.f7497z[DragEdge.Bottom.ordinal()] = r10;
    }

    public void setClickToClose(boolean r10) {
        this.A = r10;
    }

    public void setDragDistance(int r10) {
        if (r10 >= 0) goto L4;
        r10 = 0;
    L4:
        this.f7486o = A(r10);
        requestLayout();
    }

    @Deprecated
    public void setDragEdge(DragEdge r10) {
        q();
        if (getChildCount() < 2) goto L5;
        this.f7487p.put(r10, getChildAt(getChildCount() - 2));
    L5:
        setCurrentDragEdge(r10);
    }

    @Deprecated
    public void setDragEdges(List<DragEdge> r10) {
        q();
        int r11 = Math.min(r10.size(), getChildCount() - 1);
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L6;
        this.f7487p.put(r10.get(r12), getChildAt(r12));
        r12 = r12 + 1;
        goto L3
    L6:
        if (r10.size() != 0) goto L8;
    L11:
        DragEdge r13 = O;
    L12:
        setCurrentDragEdge(r13);
        return;
    L8:
        if (r10.contains(O) == true) goto L11;
        r13 = r10.get(0);
        goto L12
    }

    @Deprecated
    public void setDragEdges(DragEdge... r10) {
        q();
        setDragEdges(Arrays.asList(r10));
    }

    public void setLeftSwipeEnabled(boolean r10) {
        this.f7497z[DragEdge.Left.ordinal()] = r10;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r10) {
        super.setOnClickListener(r10);
        this.K = r10;
    }

    public void setOnDoubleClickListener(d r10) {
        this.f7495x = r10;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener r10) {
        super.setOnLongClickListener(r10);
        this.L = r10;
    }

    public void setRightSwipeEnabled(boolean r10) {
        this.f7497z[DragEdge.Right.ordinal()] = r10;
    }

    public void setShowMode(ShowMode r10) {
        this.f7488q = r10;
        requestLayout();
    }

    public void setSwipeEnabled(boolean r10) {
        this.f7496y = r10;
    }

    public void setTopSwipeEnabled(boolean r10) {
        this.f7497z[DragEdge.Top.ordinal()] = r10;
    }

    public void setWillOpenPercentAfterClose(float r10) {
        this.C = r10;
    }

    public void setWillOpenPercentAfterOpen(float r10) {
        this.B = r10;
    }

    protected void x(int r15, int r16, int r17, int r18) {
        if (this.f7492u.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<Map.Entry<View, ArrayList<f>>> r10 = this.f7492u.entrySet().iterator();
    L7:
        if (r10.hasNext() == false) goto L58;
        Map.Entry<View, ArrayList<f>> r11 = r10.next();
        View r12 = r11.getKey();
        Rect r13 = D(r12);
        if (L(r12, r13, this.f7484m, r15, r16, r17, r18) == false) goto L46;
        this.f7493v.put(r12, Boolean.FALSE);
        int r14 = 0;
        float r19 = 0.0f;
        if (getShowMode() != ShowMode.LayDown) goto L23;
        int r20 = c.f7500a[this.f7484m.ordinal()];
        if (r20 == 1) goto L21;
        if (r20 == 2) goto L20;
        if (r20 == 3) goto L19;
        if (r20 != 4) goto L39;
        r14 = r13.right - r17;
    L33:
        float r21 = r14;
        int r22 = r12.getWidth();
    L38:
        r19 = r21 / r22;
    L39:
        Iterator<f> r23 = r11.getValue().iterator();
    L41:
        if (r23.hasNext() == false) goto L46;
        r23.next().a(r12, this.f7484m, Math.abs(r19), r14);
        if (Math.abs(r19) != 1.0f) goto L41;
        this.f7493v.put(r12, Boolean.TRUE);
        goto L41
    L19:
        r14 = r13.left - r15;
        goto L33
    L20:
        r14 = r13.bottom - r18;
    L37:
        r21 = r14;
        r22 = r12.getHeight();
        goto L38
    L21:
        r14 = r13.top - r16;
        goto L37
    L23:
        if (getShowMode() != ShowMode.PullOut) goto L39;
        int r24 = c.f7500a[this.f7484m.ordinal()];
        if (r24 == 1) goto L35;
        if (r24 == 2) goto L34;
        if (r24 == 3) goto L31;
        if (r24 != 4) goto L39;
        int r25 = r13.left;
        int r26 = getWidth();
    L32:
        r14 = r25 - r26;
        goto L33
    L31:
        r25 = r13.right;
        r26 = getPaddingLeft();
        goto L32
    L34:
        int r27 = r13.top;
        int r28 = getHeight();
    L36:
        r14 = r27 - r28;
        goto L37
    L35:
        r27 = r13.bottom;
        r28 = getPaddingTop();
    L46:
        if (M(r12, r13, this.f7484m, r15, r16, r17, r18) == false) goto L7;
        this.f7493v.put(r12, Boolean.TRUE);
        Iterator<f> r29 = r11.getValue().iterator();
    L49:
        if (r29.hasNext() == false) goto L7;
        f r30 = r29.next();
        DragEdge r31 = this.f7484m;
        if (r31 != DragEdge.Left) goto L53;
    L56:
        int r32 = r12.getWidth();
    L57:
        r30.a(r12, r31, 1.0f, r32);
        goto L49
    L53:
        if (r31 == DragEdge.Right) goto L56;
        r32 = r12.getHeight();
        goto L57
    }

    protected void y(int r10, int r11, int r12, int r13) {
        DragEdge r14 = getDragEdge();
        boolean r15 = false;
        if (r14 != DragEdge.Left) goto L7;
        if (r12 < 0) goto L19;
    L18:
        r15 = true;
    L19:
        z(r10, r11, r15);
        return;
    L7:
        if (r14 != DragEdge.Right) goto L11;
        if (r12 <= 0) goto L18;
    L11:
        if (r14 != DragEdge.Top) goto L15;
        if (r13 >= 0) goto L18;
    L15:
        if (r14 != DragEdge.Bottom) goto L18;
        if (r13 <= 0) goto L18;
        goto L18
    }

    protected void z(int r10, int r11, boolean r12) {
        U();
        Status r13 = getOpenStatus();
        if (this.f7490s.isEmpty() == true) goto L37;
        this.E++;
        Iterator<i> r14 = this.f7490s.iterator();
    L6:
        if (r14.hasNext() == false) goto L14;
        i r15 = r14.next();
        if (this.E != 1) goto L12;
        if (r12 == false) goto L11;
        r15.e(this);
        goto L12
    L11:
        r15.a(this);
    L12:
        r15.b(this, r10 - getPaddingLeft(), r11 - getPaddingTop());
        goto L6
    L14:
        if (r13 != Status.Close) goto L21;
        Iterator<i> r16 = this.f7490s.iterator();
    L17:
        if (r16.hasNext() == false) goto L19;
        r16.next().c(this);
        goto L17
    L19:
        this.E = 0;
    L21:
        if (r13 != Status.Open) goto L38;
        View r17 = getCurrentBottomView();
        if (r17 == null) goto L25;
        r17.setEnabled(true);
    L25:
        Iterator<i> r18 = this.f7490s.iterator();
    L27:
        if (r18.hasNext() == false) goto L29;
        r18.next().d(this);
        goto L27
    L29:
        this.E = 0;
        return;
    L38:
        return;
    }
}
