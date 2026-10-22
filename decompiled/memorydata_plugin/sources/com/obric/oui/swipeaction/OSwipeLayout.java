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
import com.obric.memorydata.plugin.R;
import com.obric.oui.layout.OUIFrameLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class OSwipeLayout extends OUIFrameLayout {
    private static final DragEdge g = null;
    private boolean A;
    private d B;
    private boolean C;
    private ViewDragHelper.Callback D;
    private int E;
    private List<b> F;
    private boolean G;
    private boolean H;
    private float I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private float f14506J;
    private Rect K;
    private GestureDetector L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected float f14507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected float f14508b;
    protected int c;
    public boolean d;
    View.OnClickListener e;
    View.OnLongClickListener f;
    private int h;
    private DragEdge i;
    private ViewDragHelper j;
    private float k;
    private int l;
    private LinkedHashMap<DragEdge, View> m;
    private ShowMode n;
    private float[] o;
    private List<g> p;
    private List<e> q;
    private Map<View, ArrayList<c>> r;
    private Map<View, Boolean> s;
    private Map<View, Rect> t;
    private a u;
    private boolean v;
    private boolean[] w;
    private boolean x;
    private float y;
    private float z;

    /* JADX INFO: renamed from: com.obric.oui.swipeaction.OSwipeLayout$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f14511a = null;

        static {
            int[] r0 = new int[DragEdge.values().length];
            f14511a = r0;
            r0[DragEdge.Top.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f14511a[DragEdge.Bottom.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f14511a[DragEdge.Left.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f14511a[DragEdge.Right.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static final enum DragEdge extends Enum<DragEdge> {
        private static final /* synthetic */ DragEdge[] $VALUES = null;
        public static final DragEdge Bottom = null;
        public static final DragEdge Left = null;
        public static final DragEdge Right = null;
        public static final DragEdge Top = null;

        static {
            DragEdge r0 = new DragEdge("Left", 0);
            Left = r0;
            DragEdge r1 = new DragEdge("Top", 1);
            Top = r1;
            DragEdge r3 = new DragEdge("Right", 2);
            Right = r3;
            DragEdge r5 = new DragEdge("Bottom", 3);
            Bottom = r5;
            $VALUES = new DragEdge[]{r0, r1, r3, r5};
        }

        private DragEdge(String r1, int r2) {
            super(r1, r2);
        }

        public static DragEdge valueOf(String r2) {
            return (DragEdge) ZeusTransformUtils.preCheckCast(Enum.valueOf(DragEdge.class, r2), DragEdge.class, "com.obric.memorydata.plugin");
        }

        public static DragEdge[] values() {
            return (DragEdge[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DragEdge[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum ShowMode extends Enum<ShowMode> {
        private static final /* synthetic */ ShowMode[] $VALUES = null;
        public static final ShowMode LayDown = null;
        public static final ShowMode PullOut = null;

        static {
            ShowMode r0 = new ShowMode("LayDown", 0);
            LayDown = r0;
            ShowMode r1 = new ShowMode("PullOut", 1);
            PullOut = r1;
            $VALUES = new ShowMode[]{r0, r1};
        }

        private ShowMode(String r1, int r2) {
            super(r1, r2);
        }

        public static ShowMode valueOf(String r2) {
            return (ShowMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(ShowMode.class, r2), ShowMode.class, "com.obric.memorydata.plugin");
        }

        public static ShowMode[] values() {
            return (ShowMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ShowMode[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum Status extends Enum<Status> {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final Status Close = null;
        public static final Status Middle = null;
        public static final Status Open = null;

        static {
            Status r0 = new Status(com.tom_roush.pdfbox.pdmodel.a.d.d.H, 0);
            Middle = r0;
            Status r1 = new Status("Open", 1);
            Open = r1;
            Status r3 = new Status("Close", 2);
            Close = r3;
            $VALUES = new Status[]{r0, r1, r3};
        }

        private Status(String r1, int r2) {
            super(r1, r2);
        }

        public static Status valueOf(String r2) {
            return (Status) ZeusTransformUtils.preCheckCast(Enum.valueOf(Status.class, r2), Status.class, "com.obric.memorydata.plugin");
        }

        public static Status[] values() {
            return (Status[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Status[].class, "com.obric.memorydata.plugin");
        }
    }

    public interface a {
        void a(OSwipeLayout r1, boolean r2);
    }

    public interface b {
        void a(OSwipeLayout r1);
    }

    public interface c {
        void a(View r1, DragEdge r2, float r3, int r4);
    }

    public interface d {
        void a();

        void a(boolean r1);
    }

    public interface e {
        boolean a(MotionEvent r1);
    }

    class f extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OSwipeLayout f14512a;

        f(OSwipeLayout r1) {
            this.f14512a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent r6) {
            if (OSwipeLayout.m(this.f14512a) == null) goto L21;
            View r0 = this.f14512a.getCurrentBottomView();
            View r2 = this.f14512a.getSurfaceView();
            if (r0 != null) goto L7;
        L15:
            r0 = r2;
        L16:
            a r7 = OSwipeLayout.m(this.f14512a);
            OSwipeLayout r5 = this.f14512a;
            if (r0 != r2) goto L19;
            boolean r1 = true;
        L20:
            r7.a(r5, r1);
            goto L21
        L19:
            r1 = false;
            goto L20
        L7:
            if (r6.getX() <= r0.getLeft()) goto L15;
            if (r6.getX() >= r0.getRight()) goto L15;
            if (r6.getY() <= r0.getTop()) goto L15;
            if (r6.getY() >= r0.getBottom()) goto L15;
        L21:
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent r2) {
            if (OSwipeLayout.l(this.f14512a) == false) goto L8;
            if (OSwipeLayout.a(this.f14512a, r2) == false) goto L8;
            this.f14512a.o();
        L8:
            return super.onSingleTapUp(r2);
        }
    }

    public interface g {
        void a(OSwipeLayout r1);

        void a(OSwipeLayout r1, float r2, float r3);

        void a(OSwipeLayout r1, int r2, int r3);

        void b(OSwipeLayout r1);

        void c(OSwipeLayout r1);

        void d(OSwipeLayout r1);
    }

    static {
        g = DragEdge.Right;
    }

    public OSwipeLayout(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public OSwipeLayout(Context r3, AttributeSet r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), 0);
    }

    public OSwipeLayout(Context r9, AttributeSet r10, int r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r13 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r12, r13, r11);
        this.i = g;
        this.l = 0;
        this.m = new LinkedHashMap();
        this.o = new float[4];
        this.p = new ArrayList();
        this.q = new ArrayList();
        this.r = new HashMap();
        this.s = new HashMap();
        this.t = new HashMap();
        this.v = true;
        this.w = new boolean[]{true, true, true, true};
        this.x = false;
        this.y = 0.75f;
        this.z = 0.25f;
        this.A = false;
        this.f14507a = 1.5f;
        this.f14508b = 2.0f;
        this.c = -1;
        this.C = false;
        this.D = new AnonymousClass1(this);
        this.E = 0;
        this.I = -1.0f;
        this.f14506J = -1.0f;
        this.d = false;
        this.L = new GestureDetector((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), new f(this));
        this.j = ViewDragHelper.create(this, this.D);
        this.h = ViewConfiguration.get(r12).getScaledTouchSlop();
        TypedArray r14 = r12.obtainStyledAttributes(r13, R.styleable.OSwipeLayout);
        int r15 = r14.getInt(ZeusTransformUtils.mapRes(R.styleable.OSwipeLayout_oui_drag_edge, "styleable", "OSwipeLayout_oui_drag_edge"), 2);
        this.o[DragEdge.Left.ordinal()] = r14.getDimension(ZeusTransformUtils.mapRes(R.styleable.OSwipeLayout_oui_leftEdgeSwipeOffset, "styleable", "OSwipeLayout_oui_leftEdgeSwipeOffset"), 0.0f);
        this.o[DragEdge.Right.ordinal()] = r14.getDimension(ZeusTransformUtils.mapRes(R.styleable.OSwipeLayout_oui_rightEdgeSwipeOffset, "styleable", "OSwipeLayout_oui_rightEdgeSwipeOffset"), 0.0f);
        this.o[DragEdge.Top.ordinal()] = r14.getDimension(ZeusTransformUtils.mapRes(R.styleable.OSwipeLayout_oui_topEdgeSwipeOffset, "styleable", "OSwipeLayout_oui_topEdgeSwipeOffset"), 0.0f);
        this.o[DragEdge.Bottom.ordinal()] = r14.getDimension(ZeusTransformUtils.mapRes(R.styleable.OSwipeLayout_oui_bottomEdgeSwipeOffset, "styleable", "OSwipeLayout_oui_bottomEdgeSwipeOffset"), 0.0f);
        setClickToClose(r14.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OSwipeLayout_oui_clickToClose, "styleable", "OSwipeLayout_oui_clickToClose"), this.x));
        if ((r15 & 1) != 1) goto L6;
        this.m.put(DragEdge.Left, null);
    L6:
        if ((r15 & 4) != 4) goto L9;
        this.m.put(DragEdge.Top, null);
    L9:
        if ((r15 & 2) != 2) goto L12;
        this.m.put(DragEdge.Right, null);
    L12:
        if ((r15 & 8) != 8) goto L14;
        this.m.put(DragEdge.Bottom, null);
    L14:
        int r16 = r14.getInt(ZeusTransformUtils.mapRes(R.styleable.OSwipeLayout_oui_show_mode, "styleable", "OSwipeLayout_oui_show_mode"), ShowMode.PullOut.ordinal());
        this.n = ShowMode.values()[r16];
        r14.recycle();
    }

    static /* synthetic */ float a(OSwipeLayout r1, float r2) {
        float r0 = r1.k + r2;
        r1.k = r0;
        return r0;
    }

    private int a(float r3) {
        return (int) ((r3 * ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getDisplayMetrics().density) + 0.5f);
    }

    private int a(ViewGroup r6, View r7) {
        int r0 = r6.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L13;
        View r2 = r6.getChildAt(r1);
        if (r2 == r7) goto L6;
        if (ZeusTransformUtils.instanceOf(r2, ViewGroup.class) == false) goto L12;
        if (b((ViewGroup) ZeusTransformUtils.preCheckCast(r2, ViewGroup.class, "com.obric.memorydata.plugin"), r7) == false) goto L12;
        return r1;
    L12:
        r1 = r1 + 1;
        goto L3
    L6:
        return r1;
    L13:
        return -1;
    }

    private Rect a(DragEdge r4) {
        int r0 = getPaddingLeft();
        int r1 = getPaddingTop();
        if (r4 != DragEdge.Right) goto L6;
        r0 = getMeasuredWidth() - this.l;
    L9:
        if (r4 != DragEdge.Left) goto L11;
    L14:
        int r5 = this.l + r0;
        int r3 = getMeasuredHeight();
    L16:
        return new Rect(r0, r1, r5, r3 + r1);
    L11:
        if (r4 == DragEdge.Right) goto L14;
        r5 = getMeasuredWidth() + r0;
        r3 = this.l;
        goto L16
    L6:
        if (r4 != DragEdge.Bottom) goto L9;
        r1 = getMeasuredHeight() - this.l;
        goto L9
    }

    private Rect a(ShowMode r7, Rect r8) {
        View r0 = getCurrentBottomView();
        int r1 = r8.left;
        int r2 = r8.top;
        int r3 = r8.right;
        int r4 = r8.bottom;
        if (r7 != ShowMode.PullOut) goto L29;
        if (this.i != DragEdge.Left) goto L8;
        r1 = r8.left - this.l;
    L14:
        int r5 = 0;
        if (this.i != DragEdge.Left) goto L17;
    L23:
        int r6 = r8.bottom;
        if (r0 == null) goto L27;
        r5 = r0.getMeasuredWidth();
    L27:
        r3 = r1 + r5;
        r4 = r6;
    L41:
        return new Rect(r1, r2, r3, r4);
    L17:
        if (this.i == DragEdge.Right) goto L23;
        if (r0 == null) goto L22;
        r5 = r0.getMeasuredHeight();
    L22:
        r4 = r5 + r2;
        r3 = r8.right;
        goto L41
    L8:
        if (this.i != DragEdge.Right) goto L11;
        r1 = r8.right;
        goto L14
    L11:
        if (this.i != DragEdge.Top) goto L13;
        r2 = r8.top - this.l;
        goto L14
    L13:
        r2 = r8.bottom;
        goto L14
    L29:
        if (r7 != ShowMode.LayDown) goto L41;
        if (this.i != DragEdge.Left) goto L34;
        r3 = r1 + this.l;
        goto L41
    L34:
        if (this.i != DragEdge.Right) goto L36;
        r1 = r3 - this.l;
        goto L41
    L36:
        DragEdge r9 = this.i;
        DragEdge r10 = DragEdge.Top;
        int r11 = this.l;
        if (r9 != r10) goto L39;
        r4 = r2 + r11;
        goto L41
    L39:
        r2 = r4 - r11;
        goto L41
    }

    static /* synthetic */ Rect a(OSwipeLayout r0, DragEdge r1) {
        return r0.a(r1);
    }

    static /* synthetic */ DragEdge a(OSwipeLayout r0) {
        return r0.i;
    }

    private void a(MotionEvent r10) {
        if (this.H == false) goto L8;
        if (this.G == true) goto L8;
        return;
    L8:
        if (getOpenStatus() != Status.Middle) goto L11;
        this.H = true;
        return;
    L11:
        Status r0 = getOpenStatus();
        float r1 = r10.getRawX() - this.I;
        float r11 = r10.getRawY() - this.f14506J;
        float r3 = (float) Math.toDegrees(Math.atan(Math.abs(r11 / r1)));
        if (getOpenStatus() == Status.Close) goto L14;
    L38:
        boolean r7 = false;
        if (this.i == DragEdge.Right) goto L41;
    L67:
        boolean r4 = false;
    L69:
        if (this.i != DragEdge.Left) goto L91;
        if (r0 != Status.Open) goto L75;
        if (r1 >= (-this.h)) goto L75;
    L78:
        boolean r2 = true;
    L80:
        if (r2 == false) goto L82;
    L85:
        boolean r5 = true;
    L87:
        if (r3 > 30.0f) goto L89;
        if (r5 == true) goto L91;
    L89:
        r4 = true;
        goto L91
    L82:
        if (r0 == Status.Middle) goto L85;
        r5 = false;
    L75:
        if (r0 == Status.Close) goto L77;
    L79:
        r2 = false;
        goto L80
    L77:
        if (r1 <= this.h) goto L79;
    L91:
        if (this.i != DragEdge.Top) goto L113;
        if (r0 != Status.Open) goto L97;
        if (r11 >= (-this.h)) goto L97;
    L100:
        boolean r6 = true;
    L102:
        if (r6 == false) goto L104;
    L107:
        boolean r8 = true;
    L109:
        if (r3 < 60.0f) goto L111;
        if (r8 == true) goto L113;
    L111:
        r4 = true;
        goto L113
    L104:
        if (r0 == Status.Middle) goto L107;
        r8 = false;
    L97:
        if (r0 == Status.Close) goto L99;
    L101:
        r6 = false;
        goto L102
    L99:
        if (r11 <= this.h) goto L101;
    L113:
        if (this.i == DragEdge.Bottom) goto L115;
    L132:
        this.H = !r4;
        return;
    L115:
        if (r0 != Status.Open) goto L119;
        if (r11 <= this.h) goto L119;
    L122:
        boolean r12 = true;
    L124:
        if (r12 == false) goto L126;
    L127:
        r7 = true;
    L129:
        if (r3 < 60.0f) goto L131;
        if (r7 == true) goto L132;
    L131:
        r4 = true;
        goto L132
    L126:
        if (r0 != Status.Middle) goto L129;
    L119:
        if (r0 == Status.Close) goto L121;
    L123:
        r12 = false;
        goto L124
    L121:
        if (r11 >= (-this.h)) goto L123;
    L41:
        if (r0 != Status.Open) goto L45;
        if (r1 <= this.h) goto L45;
    L48:
        boolean r9 = true;
    L51:
        if (this.A == true) goto L53;
    L57:
        if (r9 == false) goto L59;
    L62:
        boolean r13 = true;
    L64:
        if (r3 > 30.0f) goto L66;
        if (r13 == true) goto L67;
    L66:
        r4 = true;
        goto L69
    L59:
        if (r0 == Status.Middle) goto L62;
        r13 = false;
        goto L64
    L53:
        if (r0 != Status.Open) goto L57;
        if (r1 >= (-this.h)) goto L57;
        r9 = true;
    L45:
        if (r0 == Status.Close) goto L47;
    L49:
        r9 = false;
        goto L51
    L47:
        if (r1 >= (-this.h)) goto L49;
    L14:
        if (r3 >= 45.0f) goto L27;
        if (r1 <= 0.0f) goto L21;
        if (g() == false) goto L21;
        DragEdge r14 = DragEdge.Left;
    L36:
        setCurrentDragEdge(r14);
    L21:
        if (r1 < 0.0f) goto L23;
        return;
    L23:
        if (h() == false) goto L134;
        r14 = DragEdge.Right;
        goto L36
    L134:
        return;
    L27:
        if (r11 <= 0.0f) goto L32;
        if (i() == false) goto L32;
        r14 = DragEdge.Top;
    L32:
        if (r11 < 0.0f) goto L34;
        return;
    L34:
        if (j() == false) goto L135;
        r14 = DragEdge.Bottom;
        goto L36
    }

    static /* synthetic */ boolean a(OSwipeLayout r0, MotionEvent r1) {
        return r0.b(r1);
    }

    static /* synthetic */ boolean a(OSwipeLayout r0, boolean r1) {
        r0.C = r1;
        return r1;
    }

    static /* synthetic */ float b(OSwipeLayout r0, float r1) {
        r0.k = r1;
        return r1;
    }

    static /* synthetic */ int b(OSwipeLayout r0) {
        return r0.l;
    }

    private Rect b(boolean r4) {
        int r0 = getPaddingLeft();
        int r1 = getPaddingTop();
        if (r4 == false) goto L15;
        if (this.i != DragEdge.Left) goto L8;
        int r5 = getPaddingLeft();
        r0 = this.l + r5;
        goto L15
    L8:
        if (this.i != DragEdge.Right) goto L11;
        r0 = getPaddingLeft() - this.l;
        goto L15
    L11:
        if (this.i != DragEdge.Top) goto L13;
        int r6 = getPaddingTop();
        r1 = this.l + r6;
        goto L15
    L13:
        r1 = getPaddingTop() - this.l;
    L15:
        return new Rect(r0, r1, getMeasuredWidth() + r0, getMeasuredHeight() + r1);
    }

    private boolean b(MotionEvent r3) {
        View r0 = getSurfaceView();
        if (r0 != null) goto L7;
        return false;
    L7:
        if (this.K != null) goto L9;
        this.K = new Rect();
    L9:
        r0.getHitRect(this.K);
        return this.K.contains((int) r3.getX(), (int) r3.getY());
    }

    private boolean b(ViewGroup r8, View r9) {
        int r0 = r8.getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L13;
        View r3 = r8.getChildAt(r2);
        if (r3 == r9) goto L6;
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.class) == false) goto L12;
        if (b((ViewGroup) ZeusTransformUtils.preCheckCast(r3, ViewGroup.class, "com.obric.memorydata.plugin"), r9) == false) goto L12;
        return true;
    L12:
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L13:
        return false;
    }

    private boolean c(MotionEvent r4) {
        View r3 = getSurfaceView();
        if (r3 != null) goto L5;
        return false;
    L5:
        int r1 = (int) r4.getX();
        int r5 = (int) r4.getY();
        if (r1 >= r3.getLeft()) goto L8;
        return false;
    L8:
        if (r1 <= r3.getRight()) goto L10;
        return false;
    L10:
        if (r5 >= r3.getTop()) goto L12;
        return false;
    L12:
        if (r5 > r3.getBottom()) goto L18;
        return true;
    L18:
        return false;
    }

    static /* synthetic */ boolean c(OSwipeLayout r0) {
        return r0.A;
    }

    static /* synthetic */ ViewDragHelper d(OSwipeLayout r0) {
        return r0.j;
    }

    static /* synthetic */ float e(OSwipeLayout r0) {
        return r0.k;
    }

    static /* synthetic */ ShowMode f(OSwipeLayout r0) {
        return r0.n;
    }

    static /* synthetic */ d g(OSwipeLayout r0) {
        return r0.B;
    }

    private AdapterView getAdapterView() {
        ViewParent r0 = getParent();
        if (l() == false) goto L9;
    L4:
        if (r0 == null) goto L9;
        if (ZeusTransformUtils.instanceOf(r0, AdapterView.class) == true) goto L9;
        r0 = r0.getParent();
    L9:
        if (ZeusTransformUtils.instanceOf(r0, AdapterView.class) == true) goto L11;
        return null;
    L11:
        return (AdapterView) ZeusTransformUtils.preCheckCast(r0, AdapterView.class, "com.obric.memorydata.plugin");
    }

    private float getCurrentOffset() {
        DragEdge r0 = this.i;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return this.o[r0.ordinal()];
    }

    static /* synthetic */ List h(OSwipeLayout r0) {
        return r0.p;
    }

    static /* synthetic */ void i(OSwipeLayout r0) {
        r0.p();
    }

    static /* synthetic */ void j(OSwipeLayout r0) {
        r0.s();
    }

    static /* synthetic */ boolean k(OSwipeLayout r0) {
        return r0.t();
    }

    static /* synthetic */ boolean l(OSwipeLayout r0) {
        return r0.x;
    }

    static /* synthetic */ a m(OSwipeLayout r0) {
        return r0.u;
    }

    private void p() {
        View r0 = getCurrentBottomView();
        View r1 = getSurfaceView();
        if (getOpenStatus() != Status.Close) goto L6;
        this.t.remove(r0);
        this.t.remove(r1);
        return;
    L6:
        int r4 = 0;
        View[] r3 = {r1, r0};
    L7:
        if (r4 >= 2) goto L12;
        View r2 = r3[r4];
        Rect r5 = (Rect) ZeusTransformUtils.preCheckCast(this.t.get(r2), Rect.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L11;
        r5 = new Rect();
        this.t.put(r2, r5);
    L11:
        r5.left = r2.getLeft();
        r5.top = r2.getTop();
        r5.right = r2.getRight();
        r5.bottom = r2.getBottom();
        r4 = r4 + 1;
        goto L7
    }

    private void q() {
        Status r0 = getOpenStatus();
        List<View> r1 = getBottomViews();
        if (r0 != Status.Close) goto L12;
        Iterator<View> r3 = r1.iterator();
    L6:
        if (r3.hasNext() == false) goto L27;
        View r2 = (View) ZeusTransformUtils.preCheckCast(r3.next(), View.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L6;
        if (r2.getVisibility() == 4) goto L6;
        r2.setVisibility(4);
        goto L6
    L27:
        return;
    L12:
        View r4 = getCurrentBottomView();
        if (r4 != null) goto L15;
        return;
    L15:
        if (r4.getVisibility() == 0) goto L26;
        r4.setVisibility(0);
        return;
    }

    private boolean r() {
        if (getAdapterView() == null) goto L5;
        return true;
    L5:
        return false;
    }

    private void s() {
        if (getOpenStatus() == Status.Close) goto L5;
        return;
    L5:
        AdapterView r0 = getAdapterView();
        if (r0 == null) goto L15;
        int r1 = r0.getPositionForView(this);
        if (r1 == (-1)) goto L10;
    L12:
        if (r1 == (-1)) goto L16;
        r0.performItemClick(r0.getChildAt(r1 - r0.getFirstVisiblePosition()), r1, r0.getAdapter().getItemId(r1));
        return;
    L16:
        return;
    L10:
        if (l() == false) goto L12;
        r1 = a(r0, this);
        goto L12
    }

    private void setCurrentDragEdge(DragEdge r1) {
        this.i = r1;
        u();
    }

    private boolean t() {
        if (getOpenStatus() == Status.Close) goto L5;
        return false;
    L5:
        AdapterView r0 = getAdapterView();
        if (r0 == null) goto L26;
        AdapterView<?> r1 = (AdapterView) ZeusTransformUtils.preCheckCast(r0, AdapterView.class, "com.obric.memorydata.plugin");
        int r2 = r1.getPositionForView(this);
        if (r2 == (-1)) goto L10;
    L12:
        int r7 = r2;
        if (r7 != (-1)) goto L15;
        return false;
    L15:
        long r8 = r1.getItemIdAtPosition(r7);
        Method r3 = AbsListView.class.getDeclaredMethod("performLongPress", new Class[]{View.class, Integer.TYPE, Long.TYPE});     // Catch: Exception -> L18
        r3.setAccessible(true);     // Catch: Exception -> L18
        return ((Boolean) ZeusTransformUtils.preCheckCast(r3.invoke(r1, new Object[]{this, Integer.valueOf(r7), Long.valueOf(r8)}), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L18:
        e = move-exception;
        e.printStackTrace();
        if (r1.getOnItemLongClickListener() == null) goto L22;
        boolean r13 = r1.getOnItemLongClickListener().onItemLongClick(r1, this, r7, r8);
    L23:
        if (r13 == false) goto L29;
        r1.performHapticFeedback(0);
        return r13;
    L29:
        return r13;
    L22:
        r13 = false;
        goto L23
    L10:
        if (l() == false) goto L12;
        r2 = a(r1, this);
        goto L12
    L26:
        return false;
    }

    private void u() {
        View r0 = getCurrentBottomView();
        if (r0 == null) goto L13;
        if (this.i != DragEdge.Left) goto L7;
    L10:
        int r1 = r0.getMeasuredWidth();
    L11:
        this.l = r1 - a(getCurrentOffset());
        goto L13
    L7:
        if (this.i == DragEdge.Right) goto L10;
        r1 = r0.getMeasuredHeight();
    L13:
        if (this.n != ShowMode.PullOut) goto L16;
        d();
    L18:
        q();
        return;
    L16:
        if (this.n != ShowMode.LayDown) goto L18;
        e();
        goto L18
    }

    public Rect a(View r5) {
        Rect r0 = new Rect(r5.getLeft(), r5.getTop(), 0, 0);
        View r1 = r5;
    L4:
        if (r1.getParent() == null) goto L11;
        if (r1 == getRootView()) goto L11;
        r1 = (View) ZeusTransformUtils.preCheckCast(r1.getParent(), View.class, "com.obric.memorydata.plugin");
        if (r1 == this) goto L11;
        r0.left += r1.getLeft();
        r0.top += r1.getTop();
    L11:
        r0.right = r0.left + r5.getMeasuredWidth();
        r0.bottom = r0.top + r5.getMeasuredHeight();
        return r0;
    }

    public void a() {
        Iterator<g> r0 = this.p.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        g r1 = (g) ZeusTransformUtils.preCheckCast(r0.next(), g.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, com.obric.oui.swipeaction.a.class) == false) goto L4;
        this.p.remove(r1);
        goto L4
    L8:
        this.B = null;
    }

    public void a(float r5, float r6, boolean r7) {
        float r0 = this.j.getMinVelocity();
        View r1 = getSurfaceView();
        DragEdge r2 = this.i;
        if (r2 == null) goto L58;
        if (r1 != null) goto L7;
        return;
    L7:
        if (this.A == true) goto L9;
    L11:
        if (r7 == false) goto L13;
        float r8 = this.z;
    L15:
        if (r2 != DragEdge.Left) goto L26;
        if (r5 <= r0) goto L20;
    L18:
        n();
        return;
    L20:
        if (r5 >= (-r0)) goto L23;
    L29:
        o();
        return;
    L23:
        if (((getSurfaceView().getLeft() * 1.0f) / this.l) <= r8) goto L29;
    L26:
        if (r2 != DragEdge.Right) goto L37;
        if (r5 > r0) goto L29;
        if (r5 < (-r0)) goto L18;
        if ((((-getSurfaceView().getLeft()) * 1.0f) / this.l) <= r8) goto L29;
    L37:
        if (r2 != DragEdge.Top) goto L48;
        if (r6 > r0) goto L18;
        if (r6 < (-r0)) goto L29;
        if (((getSurfaceView().getTop() * 1.0f) / this.l) <= r8) goto L29;
    L48:
        if (r2 == DragEdge.Bottom) goto L50;
        return;
    L50:
        if (r6 > r0) goto L29;
        if (r6 < (-r0)) goto L18;
        if ((((-getSurfaceView().getTop()) * 1.0f) / this.l) <= r8) goto L29;
    L13:
        r8 = this.y;
        goto L15
    L9:
        if (this.C == false) goto L11;
        return;
    }

    public void a(int r4, int r5, int r6, int r7) {
        DragEdge r0 = getDragEdge();
        boolean r2 = false;
        if (r0 != DragEdge.Left) goto L7;
        if (r6 < 0) goto L19;
    L18:
        r2 = true;
    L19:
        a(r4, r5, r2);
        return;
    L7:
        if (r0 != DragEdge.Right) goto L11;
        if (r6 <= 0) goto L18;
    L11:
        if (r0 != DragEdge.Top) goto L15;
        if (r7 >= 0) goto L18;
    L15:
        if (r0 != DragEdge.Bottom) goto L18;
        if (r7 <= 0) goto L18;
        goto L18
    }

    public void a(int r7, int r8, boolean r9) {
        q();
        Status r0 = getOpenStatus();
        if (this.p.isEmpty() == true) goto L37;
        this.E++;
        Iterator<g> r1 = this.p.iterator();
    L6:
        if (r1.hasNext() == false) goto L14;
        g r3 = (g) ZeusTransformUtils.preCheckCast(r1.next(), g.class, "com.obric.memorydata.plugin");
        if (this.E != 1) goto L12;
        if (r9 == false) goto L11;
        r3.a(this);
        goto L12
    L11:
        r3.c(this);
    L12:
        r3.a(this, r7 - getPaddingLeft(), r8 - getPaddingTop());
        goto L6
    L14:
        if (r0 != Status.Close) goto L21;
        Iterator<g> r10 = this.p.iterator();
    L17:
        if (r10.hasNext() == false) goto L19;
        ((g) ZeusTransformUtils.preCheckCast(r10.next(), g.class, "com.obric.memorydata.plugin")).d(this);
        goto L17
    L19:
        this.E = 0;
    L21:
        if (r0 != Status.Open) goto L38;
        View r11 = getCurrentBottomView();
        if (r11 == null) goto L25;
        r11.setEnabled(true);
    L25:
        Iterator<g> r12 = this.p.iterator();
    L27:
        if (r12.hasNext() == false) goto L29;
        ((g) ZeusTransformUtils.preCheckCast(r12.next(), g.class, "com.obric.memorydata.plugin")).b(this);
        goto L27
    L29:
        this.E = 0;
        return;
    L38:
        return;
    }

    public void a(g r3) {
        g r4 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin");
        this.p.add(r4);
    }

    public void a(boolean r2) {
        b(r2, true);
    }

    public void a(boolean r9, boolean r10) {
        View r0 = getSurfaceView();
        View r1 = getCurrentBottomView();
        if (r0 != null) goto L5;
        return;
    L5:
        ViewDragHelper r2 = this.j;
        if (r2 == null) goto L8;
        r2.abort();
    L8:
        Rect r3 = b(true);
        if (r9 == false) goto L11;
        this.j.smoothSlideViewTo(r0, r3.left, r3.top);
    L31:
        invalidate();
        return;
    L11:
        int r11 = r3.left - r0.getLeft();
        int r4 = r3.top - r0.getTop();
        r0.layout(r3.left, r3.top, r3.right, r3.bottom);
        Rect r5 = (Rect) ZeusTransformUtils.preCheckCast(this.t.get(r0), Rect.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L14;
        r5 = new Rect();
        this.t.put(r0, r5);
    L14:
        r5.set(r3);
        if (getShowMode() != ShowMode.PullOut) goto L20;
        Rect r6 = a(ShowMode.PullOut, r3);
        if (r1 != null) goto L27;
    L28:
        if (r10 == false) goto L30;
        b(r3.left, r3.top, r3.right, r3.bottom);
        a(r3.left, r3.top, r11, r4);
        goto L31
    L30:
        q();
    L27:
        r1.layout(r6.left, r6.top, r6.right, r6.bottom);
        goto L28
    L20:
        if (getShowMode() != ShowMode.LayDown) goto L28;
        r6 = a(ShowMode.LayDown, r3);
        if (r1 == null) goto L28;
        Rect r7 = (Rect) ZeusTransformUtils.preCheckCast(this.t.get(r1), Rect.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L26;
        r7 = new Rect();
        this.t.put(r1, r7);
    L26:
        r7.set(r6);
        goto L27
    }

    public boolean a(View r7, Rect r8, DragEdge r9, int r10, int r11, int r12, int r13) {
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.s.get(r7), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L5;
        return false;
    L5:
        int r14 = r8.left;
        int r1 = r8.right;
        int r2 = r8.top;
        int r15 = r8.bottom;
        if (getShowMode() != ShowMode.LayDown) goto L21;
        if (r9 != DragEdge.Right) goto L11;
        if (r12 > r14) goto L11;
    L41:
        return true;
    L11:
        if (r9 != DragEdge.Left) goto L14;
        if (r10 >= r1) goto L41;
    L14:
        if (r9 != DragEdge.Top) goto L17;
        if (r11 >= r15) goto L41;
    L17:
        if (r9 != DragEdge.Bottom) goto L39;
        if (r13 <= r2) goto L41;
        return false;
    L39:
        return false;
    L21:
        if (getShowMode() == ShowMode.PullOut) goto L23;
        return false;
    L23:
        if (r9 != DragEdge.Right) goto L27;
        if (r1 <= getWidth()) goto L41;
    L27:
        if (r9 != DragEdge.Left) goto L31;
        if (r14 >= getPaddingLeft()) goto L41;
    L31:
        if (r9 != DragEdge.Top) goto L35;
        if (r2 >= getPaddingTop()) goto L41;
    L35:
        if (r9 == DragEdge.Bottom) goto L37;
        return false;
    L37:
        if (r15 <= getHeight()) goto L41;
        return false;
    }

    @Override // android.view.ViewGroup
    public void addView(View r5, int r6, ViewGroup.LayoutParams r7) {
        if (r5 != null) goto L5;
        return;
    L5:
        int r1 = 0;
        r1 = ((Integer) ZeusTransformUtils.preCheckCast(r7.getClass().getField("gravity").get(r7), Integer.class, "com.obric.memorydata.plugin")).intValue();     // Catch: Exception -> L8
    L10:
        if (r1 <= 0) goto L23;
        int r0 = GravityCompat.getAbsoluteGravity(r1, ViewCompat.getLayoutDirection(this));
        if ((r0 & 3) != 3) goto L15;
        this.m.put(DragEdge.Left, r5);
    L15:
        if ((r0 & 5) != 5) goto L18;
        this.m.put(DragEdge.Right, r5);
    L18:
        if ((r0 & 48) != 48) goto L21;
        this.m.put(DragEdge.Top, r5);
    L21:
        if ((r0 & 80) != 80) goto L30;
        this.m.put(DragEdge.Bottom, r5);
    L30:
        if (r5.getParent() != this) goto L32;
        return;
    L32:
        super.addView(r5, r6, r7);
        return;
    L23:
        Iterator<Map.Entry<DragEdge, View>> r2 = this.m.entrySet().iterator();
    L25:
        if (r2.hasNext() == false) goto L30;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r3.getValue() != null) goto L25;
        this.m.put((DragEdge) ZeusTransformUtils.preCheckCast(r3.getKey(), DragEdge.class, "com.obric.memorydata.plugin"), r5);
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    public void b() {
        this.p.clear();
    }

    public void b(int r17, int r18, int r19, int r20) {
        if (this.r.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<Map.Entry<View, ArrayList<c>>> r9 = this.r.entrySet().iterator();
    L7:
        if (r9.hasNext() == false) goto L58;
        Map.Entry r11 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        View r12 = (View) ZeusTransformUtils.preCheckCast(r11.getKey(), View.class, "com.obric.memorydata.plugin");
        Rect r13 = a(r12);
        if (b(r12, r13, this.i, r17, r18, r19, r20) == false) goto L46;
        int r1 = 0;
        this.s.put(r12, false);
        float r0 = 0.0f;
        if (getShowMode() != ShowMode.LayDown) goto L23;
        int r2 = AnonymousClass4.f14511a[this.i.ordinal()];
        if (r2 == 1) goto L21;
        if (r2 == 2) goto L20;
        if (r2 == 3) goto L19;
        if (r2 != 4) goto L39;
        r1 = r13.right - r19;
    L33:
        float r3 = r1;
        int r4 = r12.getWidth();
    L38:
        r0 = r3 / r4;
    L39:
        Iterator r5 = ((ArrayList) ZeusTransformUtils.preCheckCast(r11.getValue(), ArrayList.class, "com.obric.memorydata.plugin")).iterator();
    L41:
        if (r5.hasNext() == false) goto L46;
        ((c) ZeusTransformUtils.preCheckCast(r5.next(), c.class, "com.obric.memorydata.plugin")).a(r12, this.i, Math.abs(r0), r1);
        if (Math.abs(r0) != 1.0f) goto L41;
        this.s.put(r12, true);
        goto L41
    L19:
        r1 = r13.left - r17;
        goto L33
    L20:
        r1 = r13.bottom - r20;
    L37:
        r3 = r1;
        r4 = r12.getHeight();
        goto L38
    L21:
        r1 = r13.top - r18;
        goto L37
    L23:
        if (getShowMode() != ShowMode.PullOut) goto L39;
        int r6 = AnonymousClass4.f14511a[this.i.ordinal()];
        if (r6 == 1) goto L35;
        if (r6 == 2) goto L34;
        if (r6 == 3) goto L31;
        if (r6 != 4) goto L39;
        int r7 = r13.left;
        int r8 = getWidth();
    L32:
        r1 = r7 - r8;
        goto L33
    L31:
        r7 = r13.right;
        r8 = getPaddingLeft();
        goto L32
    L34:
        int r10 = r13.top;
        int r14 = getHeight();
    L36:
        r1 = r10 - r14;
        goto L37
    L35:
        r10 = r13.bottom;
        r14 = getPaddingTop();
    L46:
        if (a(r12, r13, this.i, r17, r18, r19, r20) == false) goto L7;
        this.s.put(r12, true);
        Iterator r15 = ((ArrayList) ZeusTransformUtils.preCheckCast(r11.getValue(), ArrayList.class, "com.obric.memorydata.plugin")).iterator();
    L49:
        if (r15.hasNext() == false) goto L7;
        c r16 = (c) ZeusTransformUtils.preCheckCast(r15.next(), c.class, "com.obric.memorydata.plugin");
        if (this.i != DragEdge.Left) goto L53;
    L56:
        DragEdge r21 = this.i;
        int r22 = r12.getWidth();
    L57:
        r16.a(r12, r21, 1.0f, r22);
        goto L49
    L53:
        if (this.i == DragEdge.Right) goto L56;
        r21 = this.i;
        r22 = r12.getHeight();
        goto L57
    }

    public void b(boolean r8, boolean r9) {
        View r0 = getSurfaceView();
        if (r0 != null) goto L5;
        return;
    L5:
        ViewDragHelper r1 = this.j;
        if (r1 == null) goto L8;
        r1.abort();
    L8:
        if (r8 == false) goto L10;
        this.j.smoothSlideViewTo(getSurfaceView(), getPaddingLeft(), getPaddingTop());
    L17:
        invalidate();
        return;
    L10:
        Rect r10 = b(false);
        this.t.remove(r0);
        if (((Rect) ZeusTransformUtils.preCheckCast(this.t.get(getCurrentBottomView()), Rect.class, "com.obric.memorydata.plugin")) == null) goto L13;
        this.t.remove(getCurrentBottomView());
    L13:
        int r2 = r10.left - r0.getLeft();
        int r3 = r10.top - r0.getTop();
        r0.layout(r10.left, r10.top, r10.right, r10.bottom);
        if (r9 == false) goto L16;
        b(r10.left, r10.top, r10.right, r10.bottom);
        a(r10.left, r10.top, r2, r3);
        goto L17
    L16:
        q();
        goto L17
    }

    public boolean b(View r9, Rect r10, DragEdge r11, int r12, int r13, int r14, int r15) {
        int r16 = r10.left;
        int r0 = r10.right;
        int r1 = r10.top;
        int r17 = r10.bottom;
        if (getShowMode() != ShowMode.LayDown) goto L23;
        int r8 = AnonymousClass4.f14511a[r11.ordinal()];
        if (r8 == 1) goto L19;
        if (r8 == 2) goto L16;
        if (r8 == 3) goto L13;
        if (r8 != 4) goto L68;
        if (r14 <= r16) goto L50;
        if (r14 > r0) goto L52;
        return true;
    L52:
        return false;
    L50:
        return false;
    L68:
        return false;
    L13:
        if (r12 >= r0) goto L53;
        if (r12 < r16) goto L54;
        return true;
    L54:
        return false;
    L53:
        return false;
    L16:
        if (r15 <= r1) goto L55;
        if (r15 > r17) goto L56;
        return true;
    L56:
        return false;
    L55:
        return false;
    L19:
        if (r13 < r1) goto L57;
        if (r13 >= r17) goto L58;
        return true;
    L58:
        return false;
    L57:
        return false;
    L23:
        if (getShowMode() != ShowMode.PullOut) goto L59;
        int r18 = AnonymousClass4.f14511a[r11.ordinal()];
        if (r18 == 1) goto L46;
        if (r18 == 2) goto L41;
        if (r18 == 3) goto L36;
        if (r18 == 4) goto L31;
        return false;
    L31:
        if (r16 <= getWidth()) goto L33;
        return false;
    L33:
        if (r0 <= getWidth()) goto L61;
        return true;
    L61:
        return false;
    L36:
        if (r0 >= getPaddingLeft()) goto L38;
        return false;
    L38:
        if (r16 >= getPaddingLeft()) goto L63;
        return true;
    L63:
        return false;
    L41:
        if (r1 < getHeight()) goto L43;
        return false;
    L43:
        if (r1 < getPaddingTop()) goto L65;
        return true;
    L65:
        return false;
    L46:
        if (r1 < getPaddingTop()) goto L48;
        return false;
    L48:
        if (r17 < getPaddingTop()) goto L67;
        return true;
    L67:
        return false;
    L59:
        return false;
    }

    public void c() {
        this.m.clear();
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.j.continueSettling(true) == false) goto L6;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    }

    void d() {
        View r0 = getSurfaceView();
        Rect r1 = (Rect) ZeusTransformUtils.preCheckCast(this.t.get(r0), Rect.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L5;
    L9:
        if (r0 == null) goto L11;
        r0.layout(r1.left, r1.top, r1.right, r1.bottom);
        bringChildToFront(r0);
    L11:
        View r2 = getCurrentBottomView();
        Rect r3 = (Rect) ZeusTransformUtils.preCheckCast(this.t.get(r2), Rect.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L14;
        r3 = a(ShowMode.PullOut, r1);
    L14:
        if (r2 == null) goto L17;
        r2.layout(r3.left, r3.top, r3.right, r3.bottom);
        return;
    L17:
        return;
    L5:
        if (getOpenStatus() == Status.Close) goto L7;
        boolean r4 = true;
    L8:
        r1 = b(r4);
        goto L9
    L7:
        r4 = false;
        goto L8
    }

    void e() {
        View r0 = getSurfaceView();
        Rect r1 = (Rect) ZeusTransformUtils.preCheckCast(this.t.get(r0), Rect.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
        r1 = b(false);
    L5:
        if (r0 == null) goto L7;
        r0.layout(r1.left, r1.top, r1.right, r1.bottom);
        bringChildToFront(r0);
    L7:
        View r2 = getCurrentBottomView();
        Rect r3 = (Rect) ZeusTransformUtils.preCheckCast(this.t.get(r2), Rect.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L10;
        r3 = a(ShowMode.LayDown, r1);
    L10:
        if (r2 == null) goto L13;
        r2.layout(r3.left, r3.top, r3.right, r3.bottom);
        return;
    }

    public boolean f() {
        return this.v;
    }

    public boolean g() {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.m.get(DragEdge.Left), View.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L11:
        return false;
    L5:
        if (r0.getParent() != this) goto L11;
        if (r0 == getSurfaceView()) goto L11;
        if (this.w[DragEdge.Left.ordinal()] == false) goto L11;
        return true;
    }

    public List<View> getBottomViews() {
        ArrayList r0 = new ArrayList();
        DragEdge[] r1 = DragEdge.values();
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        DragEdge r4 = r1[r3];
        r0.add((View) ZeusTransformUtils.preCheckCast(this.m.get(r4), View.class, "com.obric.memorydata.plugin"));
        r3 = r3 + 1;
        goto L3
    L5:
        return r0;
    }

    public View getCurrentBottomView() {
        List<View> r0 = getBottomViews();
        if (this.i.ordinal() < r0.size()) goto L5;
        return null;
    L5:
        return (View) ZeusTransformUtils.preCheckCast(r0.get(this.i.ordinal()), View.class, "com.obric.memorydata.plugin");
    }

    public int getDragDistance() {
        return this.l;
    }

    public DragEdge getDragEdge() {
        return this.i;
    }

    public Map<DragEdge, View> getDragEdgeMap() {
        return this.m;
    }

    @Deprecated
    public List<DragEdge> getDragEdges() {
        return new ArrayList(this.m.keySet());
    }

    public boolean getIsBeingDragged() {
        return this.H;
    }

    public Status getOpenStatus() {
        View r0 = getSurfaceView();
        if (r0 == null) goto L5;
        int r1 = r0.getLeft();
        int r2 = r0.getTop();
        if (r1 != getPaddingLeft()) goto L13;
        if (r2 != getPaddingTop()) goto L13;
        return Status.Close;
    L13:
        if (r1 == (getPaddingLeft() - this.l)) goto L24;
        if (r1 == (getPaddingLeft() + this.l)) goto L24;
        if (r2 == (getPaddingTop() - this.l)) goto L24;
        if (r2 == (getPaddingTop() + this.l)) goto L24;
        return Status.Middle;
    L24:
        return Status.Open;
    L5:
        return Status.Close;
    }

    public ShowMode getShowMode() {
        return this.n;
    }

    public View getSurfaceView() {
        if (getChildCount() != 0) goto L7;
        return null;
    L7:
        return getChildAt(getChildCount() - 1);
    }

    public float getWillOpenPercentAfterClose() {
        return this.z;
    }

    public float getWillOpenPercentAfterOpen() {
        return this.y;
    }

    public boolean h() {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.m.get(DragEdge.Right), View.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L11:
        return false;
    L5:
        if (r0.getParent() != this) goto L11;
        if (r0 == getSurfaceView()) goto L11;
        if (this.w[DragEdge.Right.ordinal()] == false) goto L11;
        return true;
    }

    public boolean i() {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.m.get(DragEdge.Top), View.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L11:
        return false;
    L5:
        if (r0.getParent() != this) goto L11;
        if (r0 == getSurfaceView()) goto L11;
        if (this.w[DragEdge.Top.ordinal()] == false) goto L11;
        return true;
    }

    public boolean j() {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.m.get(DragEdge.Bottom), View.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L11:
        return false;
    L5:
        if (r0.getParent() != this) goto L11;
        if (r0 == getSurfaceView()) goto L11;
        if (this.w[DragEdge.Bottom.ordinal()] == false) goto L11;
        return true;
    }

    public boolean l() {
        return this.d;
    }

    public boolean m() {
        return this.C;
    }

    public void n() {
        a(true, true);
    }

    public void o() {
        b(true, true);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (r() == true) goto L5;
        return;
    L5:
        if (this.e != null) goto L8;
        setOnClickListener(new AnonymousClass2(this));
    L8:
        if (this.f != null) goto L12;
        setOnLongClickListener(new AnonymousClass3(this));
        return;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewDragHelper r0 = this.j;
        if (r0 == null) goto L6;
        r0.abort();
    L6:
        if (getOpenStatus() == Status.Close) goto L9;
        a(false);
        return;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r7) {
        if (f() == true) goto L6;
        return false;
    L6:
        if (this.x == true) goto L8;
    L12:
        Iterator<e> r0 = this.q.iterator();
    L14:
        if (r0.hasNext() == false) goto L20;
        e r3 = (e) ZeusTransformUtils.preCheckCast(r0.next(), e.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L14;
        if (r3.a(r7) == false) goto L14;
        return false;
    L20:
        int r1 = r7.getAction();
        if (r1 == 0) goto L41;
        if (r1 != 1) goto L24;
    L39:
        this.G = false;
        this.H = false;
    L40:
        this.j.processTouchEvent(r7);
    L50:
        return this.H;
    L24:
        if (r1 != 2) goto L26;
        boolean r2 = this.H;
        a(r7);
        if (this.H == true) goto L31;
    L35:
        if (r2 == true) goto L50;
        if (this.H == false) goto L50;
        return false;
    L31:
        if (this.G == true) goto L35;
        ViewParent r8 = getParent();
        if (r8 == null) goto L35;
        r8.requestDisallowInterceptTouchEvent(true);
        goto L35
    L26:
        if (r1 == 3) goto L39;
    L41:
        this.j.processTouchEvent(r7);
        this.G = false;
        this.H = false;
        this.I = r7.getRawX();
        this.f14506J = r7.getRawY();
        if (getOpenStatus() != Status.Middle) goto L45;
        this.H = true;
    L45:
        if (this.A == false) goto L50;
        if (c(r7) == true) goto L50;
        this.G = true;
        goto L50
    L8:
        if (getOpenStatus() != Status.Open) goto L12;
        if (b(r7) == false) goto L12;
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        u();
        if (this.F == null) goto L8;
        int r6 = 0;
    L6:
        if (r6 >= this.F.size()) goto L10;
        ((b) ZeusTransformUtils.preCheckCast(this.F.get(r6), b.class, "com.obric.memorydata.plugin")).a(this);
        r6 = r6 + 1;
        goto L6
    L10:
        return;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r5) {
        if (f() == false) goto L5;
        int r0 = r5.getActionMasked();
        this.L.onTouchEvent(r5);
        if (r0 == 0) goto L21;
        if (r0 != 1) goto L10;
    L19:
        this.H = false;
    L20:
        this.j.processTouchEvent(r5);
    L23:
        if (super.onTouchEvent(r5) == true) goto L28;
        if (this.H == true) goto L28;
        if (r0 == 0) goto L28;
        return false;
    L28:
        return true;
    L10:
        if (r0 != 2) goto L12;
        a(r5);
        if (this.H == false) goto L23;
        if (this.G == true) goto L23;
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L20
    L12:
        if (r0 == 3) goto L19;
    L21:
        this.j.processTouchEvent(r5);
        this.I = r5.getRawX();
        this.f14506J = r5.getRawY();
        goto L23
    L5:
        return super.onTouchEvent(r5);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View r5) {
        Iterator r0 = new HashMap(this.m).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r1.getValue() != r5) goto L4;
        this.m.remove(r1.getKey());
        goto L4
    }

    public void setBottomSwipeEnabled(boolean r2) {
        this.w[DragEdge.Bottom.ordinal()] = r2;
    }

    public void setClickToClose(boolean r1) {
        this.x = r1;
    }

    public void setDragDistance(int r1) {
        if (r1 >= 0) goto L4;
        r1 = 0;
    L4:
        this.l = a(r1);
        requestLayout();
    }

    @Deprecated
    public void setDragEdge(DragEdge r4) {
        c();
        if (getChildCount() < 2) goto L5;
        this.m.put(r4, getChildAt(getChildCount() - 2));
    L5:
        setCurrentDragEdge(r4);
    }

    @Deprecated
    public void setDragEdges(List<DragEdge> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        c();
        int r0 = Math.min(r9.size(), getChildCount() - 1);
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L6;
        this.m.put((DragEdge) ZeusTransformUtils.preCheckCast(r9.get(r3), DragEdge.class, "com.obric.memorydata.plugin"), getChildAt(r3));
        r3 = r3 + 1;
        goto L3
    L6:
        if (r9.size() != 0) goto L8;
    L11:
        DragEdge r10 = g;
    L12:
        setCurrentDragEdge(r10);
        return;
    L8:
        if (r9.contains(g) == true) goto L11;
        r10 = (DragEdge) ZeusTransformUtils.preCheckCast(r9.get(0), DragEdge.class, "com.obric.memorydata.plugin");
        goto L12
    }

    @Deprecated
    public void setDragEdges(DragEdge... r1) {
        c();
        setDragEdges(Arrays.asList(r1));
    }

    public void setLeftSwipeEnabled(boolean r2) {
        this.w[DragEdge.Left.ordinal()] = r2;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r3) {
        View.OnClickListener r4 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.memorydata.plugin");
        super.setOnClickListener(r4);
        this.e = r4;
    }

    public void setOnDoubleClickListener(a r3) {
        this.u = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener r3) {
        View.OnLongClickListener r4 = (View.OnLongClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnLongClickListener.class, "com.obric.memorydata.plugin");
        super.setOnLongClickListener(r4);
        this.f = r4;
    }

    public void setOverrideDragDistance(int r1) {
        this.c = r1;
    }

    public void setQuickDeleteEnabled(boolean r1) {
        this.A = r1;
    }

    public void setQuickDeleteListener(d r3) {
        this.B = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
    }

    public void setQuickDeleteMax(float r1) {
        this.f14508b = r1;
    }

    public void setQuickDeleteThreshold(float r1) {
        this.f14507a = r1;
    }

    public void setRightSwipeEnabled(boolean r2) {
        this.w[DragEdge.Right.ordinal()] = r2;
    }

    public void setShowMode(ShowMode r1) {
        this.n = r1;
        requestLayout();
    }

    public void setSwipeEnabled(boolean r1) {
        this.v = r1;
    }

    public void setTopSwipeEnabled(boolean r2) {
        this.w[DragEdge.Top.ordinal()] = r2;
    }

    public void setWillOpenPercentAfterClose(float r1) {
        this.z = r1;
    }

    public void setWillOpenPercentAfterOpen(float r1) {
        this.y = r1;
    }
}
