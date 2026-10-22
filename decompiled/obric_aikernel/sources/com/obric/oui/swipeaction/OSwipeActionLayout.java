package com.obric.oui.swipeaction;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.bytedance.crash.entity.EventBody;
import java.util.Objects;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated(message = "使用 OSwipeLayout")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u00029:B'\b\u0007\u0012\u0006\u00103\u001a\u000202\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000104\u0012\b\b\u0002\u00106\u001a\u00020\u000e¢\u0006\u0004\b7\u00108R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00028B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u0016\u0010\r\u001a\u00020\u00028B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u0016\u0010\u0011\u001a\u00020\u000e8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00028B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0006R\"\u0010\u001d\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0016R\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u0016\u0010#\u001a\u00020\u000e8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0010R\u0016\u0010%\u001a\u00020\u00028B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u0006R$\u0010-\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\u00028B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u0006R\u0016\u00101\u001a\u00020\u000e8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u0010¨\u0006;"}, d2 = {"Lcom/obric/oui/swipeaction/OSwipeActionLayout;", "Landroid/widget/FrameLayout;", "", "g", "Z", "getSwipeEnabled", "()Z", "setSwipeEnabled", "(Z)V", "swipeEnabled", "getRightViewOpened", "rightViewOpened", "getLeftOpenFinished", "leftOpenFinished", "", "getRViewWidth", "()I", "rViewWidth", EventBody.KEY_VALUE, "t", "I", "setRightViewPadding", "(I)V", "rightViewPadding", "getRightViewEmpty", "rightViewEmpty", "c", "getDirection", "setDirection", "direction", "h", "getContinuousSwipe", "setContinuousSwipe", "continuousSwipe", "getPreviousPosition", "previousPosition", "getRightOpenFinished", "rightOpenFinished", "Lcom/obric/oui/swipeaction/OSwipeActionLayout$b;", "K", "Lcom/obric/oui/swipeaction/OSwipeActionLayout$b;", "getActionsListener", "()Lcom/obric/oui/swipeaction/OSwipeActionLayout$b;", "setActionsListener", "(Lcom/obric/oui/swipeaction/OSwipeActionLayout$b;)V", "actionsListener", "getLeftViewOpened", "leftViewOpened", "getLViewWidth", "lViewWidth", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OSwipeActionLayout extends FrameLayout {
    private int A;
    private boolean B;
    private boolean C;
    private View D;
    private View E;
    private View F;
    private int G;
    private View H;
    private View I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private int f7458J;
    private b K;
    private final GestureDetector.OnGestureListener L;
    private final ViewDragHelper.Callback M;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f7459c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f7460g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f7461h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final double f7462i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f7463j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f7464k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f7465l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f7466m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f7467n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final int f7468o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final int f7469p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final int f7470q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final int f7471r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f7472s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f7473t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f7474u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f7475v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f7476w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private ViewDragHelper f7477x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private GestureDetectorCompat f7478y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f7479z;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    public interface b {
        void a();

        void b(int r10, boolean r11);

        void onClose();
    }

    public static final class c extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OSwipeActionLayout f7480a;

        c(OSwipeActionLayout r10) {
            this.f7480a = r10;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent r10, MotionEvent r11, float r12, float r13) {
            Intrinsics.checkNotNullParameter(r10, "e1");
            Intrinsics.checkNotNullParameter(r11, "e2");
            ViewParent r14 = this.f7480a.getParent();
            if (r14 == null) goto L7;
            r14.requestDisallowInterceptTouchEvent(true);
            return false;
        L7:
            return false;
        }
    }

    static final class d implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OSwipeActionLayout f7481c;

        d(OSwipeActionLayout r10) {
            this.f7481c = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int r10 = this.f7481c.getDirection();
            if (r10 != 1) goto L5;
            View r11 = OSwipeActionLayout.q(this.f7481c);
            Intrinsics.checkNotNull(r11);
            float r12 = OSwipeActionLayout.j(this.f7481c);
        L12:
            r11.setX(r12);
            return;
        L5:
            if (r10 != 2) goto L7;
        L10:
            r11 = OSwipeActionLayout.l(this.f7481c);
            Intrinsics.checkNotNull(r11);
            View r13 = OSwipeActionLayout.l(this.f7481c);
            Intrinsics.checkNotNull(r13);
            r12 = -r13.getWidth();
            goto L12
        L7:
            if (r10 != 3) goto L14;
            View r14 = OSwipeActionLayout.q(this.f7481c);
            Intrinsics.checkNotNull(r14);
            r14.setX(OSwipeActionLayout.j(this.f7481c));
            goto L10
        }
    }

    static {
        new a(null);
    }

    @JvmOverloads
    public OSwipeActionLayout(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public OSwipeActionLayout(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public OSwipeActionLayout(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.f7459c = 1;
        this.f7475v = true;
        TypedArray r13 = getContext().obtainStyledAttributes(r11, l.OSwipeActionLayout);
        Intrinsics.checkNotNullExpressionValue(r13, "getContext().obtainStyle…eable.OSwipeActionLayout)");
        this.f7459c = 1;
        this.f7460g = r13.getBoolean(l.OSwipeActionLayout_oui_sal_swipeEnabled, true);
        this.f7461h = r13.getBoolean(l.OSwipeActionLayout_oui_sal_continuousSwipe, true);
        this.f7462i = r13.getInt(l.OSwipeActionLayout_oui_sal_autoMovingSensitivity, 1000);
        this.f7463j = r13.getBoolean(l.OSwipeActionLayout_oui_sal_dragAfterOpened, false);
        this.f7464k = r13.getBoolean(l.OSwipeActionLayout_oui_sal_freeDrag, true);
        this.f7465l = r13.getResourceId(l.OSwipeActionLayout_oui_sal_rightItem, 0);
        this.f7466m = r13.getResourceId(l.OSwipeActionLayout_oui_sal_rightItem_bg, 0);
        this.f7467n = (int) r13.getDimension(l.OSwipeActionLayout_oui_sal_rightItem_first_expand_width, 0.0f);
        this.G = (int) r13.getDimension(l.OSwipeActionLayout_oui_sal_rightItem_full_open_pending, 0.0f);
        this.f7468o = r13.getResourceId(l.OSwipeActionLayout_oui_sal_leftItem, 0);
        this.f7469p = r13.getResourceId(l.OSwipeActionLayout_oui_sal_leftItem_bg, 0);
        this.f7470q = (int) r13.getDimension(l.OSwipeActionLayout_oui_sal_leftItem_first_expand_width, 0.0f);
        this.f7458J = (int) r13.getDimension(l.OSwipeActionLayout_oui_sal_leftItem_full_open_pending, 0.0f);
        this.f7471r = r13.getResourceId(l.OSwipeActionLayout_oui_sal_draggedItem, 0);
        setRightViewPadding((int) r13.getDimension(l.OSwipeActionLayout_oui_sal_rightViewPadding, 0.0f));
        this.f7474u = (int) r13.getDimension(l.OSwipeActionLayout_oui_sal_leftViewPadding, 0.0f);
        P();
        r13.recycle();
        this.L = new c(this);
        this.M = new OSwipeActionLayout$dragHelperCallback$1(this);
    }

    public /* synthetic */ OSwipeActionLayout(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    private final int A(float r10) {
        if (K(r10) == false) goto L7;
        return getLViewWidth();
    L7:
        if (L(r10) == false) goto L11;
        return -getRViewWidth();
    L11:
        if (J(r10) == false) goto L14;
        return 0;
    L14:
        return -1;
    }

    private final int B(float r10) {
        if (this.f7461h == true) goto L5;
    L18:
        double r11 = r10;
        double r12 = this.f7462i;
        boolean r13 = true;
        if (r11 <= r12) goto L22;
    L20:
        r13 = false;
    L32:
        if (r13 == true) goto L34;
        return 0;
    L34:
        return -getRViewWidth();
    L22:
        if (r11 < (-r12)) goto L32;
        int r14 = this.f7479z;
        if (r14 < 0) goto L27;
    L29:
        int r15 = this.f7479z;
        if (r15 >= 0) goto L20;
        Math.abs(r15);
        int r16 = getRViewWidth() / 2;
        goto L20
    L27:
        if (Math.abs(r14) <= (getRViewWidth() / 2)) goto L29;
    L5:
        if (getRightViewEmpty() == false) goto L15;
        int r17 = this.f7479z;
        if (r17 >= 0) goto L11;
        if (Math.abs(r17) <= (this.A / 2)) goto L11;
    L13:
        return (-this.A) + this.G;
    L11:
        if (r10 < (-this.f7462i)) goto L13;
        return 0;
    L15:
        if (F(r10) == false) goto L18;
        return (-this.A) + this.G;
    }

    private final int C(float r10) {
        if (this.f7461h == true) goto L5;
    L18:
        double r11 = r10;
        double r12 = this.f7462i;
        boolean r13 = true;
        if (r11 <= r12) goto L22;
    L32:
        if (r13 == true) goto L34;
        return 0;
    L34:
        return getLViewWidth();
    L22:
        if (r11 >= (-r12)) goto L24;
    L23:
        r13 = false;
        goto L32
    L24:
        int r14 = this.f7479z;
        if (r14 > 0) goto L27;
    L29:
        int r15 = this.f7479z;
        if (r15 <= 0) goto L23;
        Math.abs(r15);
        int r16 = getLViewWidth() / 2;
        goto L23
    L27:
        if (Math.abs(r14) <= (getLViewWidth() / 2)) goto L29;
    L5:
        if (getRightViewEmpty() == false) goto L15;
        int r17 = this.f7479z;
        if (r17 <= 0) goto L11;
        if (Math.abs(r17) <= (this.A / 2)) goto L11;
    L13:
        return this.A - this.f7458J;
    L11:
        if (r10 > this.f7462i) goto L13;
        return 0;
    L15:
        if (G(r10) == false) goto L18;
        return this.A - this.f7458J;
    }

    private final View D(MotionEvent r10, ViewGroup r11) {
        Intrinsics.checkNotNull(r11);
        if (r11.onInterceptTouchEvent(r10) == false) goto L5;
        return r11;
    L5:
        int r12 = r11.getChildCount();
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L12;
        View r14 = r11.getChildAt(r13);
        Intrinsics.checkNotNullExpressionValue(r14, "rootView.getChildAt(i)");
        if (N(r14) == true) goto L10;
        r13 = r13 + 1;
        goto L6
    L10:
        Objects.requireNonNull(r14, "null cannot be cast to non-null type android.view.ViewGroup");
        return D(r10, (ViewGroup) r14);
    L12:
        return null;
    }

    private final boolean E() {
        if (this.f7479z != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean F(float r10) {
        if (r10 < (-this.f7462i)) goto L5;
    L6:
        int r11 = this.f7479z;
        if (r11 < 0) goto L9;
    L11:
        return false;
    L9:
        if (Math.abs(r11) <= (this.A / 2)) goto L11;
    L10:
        return true;
    L5:
        if (Math.abs(this.f7479z) > getRViewWidth()) goto L10;
        goto L6
    }

    private final boolean G(float r10) {
        if (r10 > this.f7462i) goto L5;
    L6:
        int r11 = this.f7479z;
        if (r11 > 0) goto L9;
    L11:
        return false;
    L9:
        if (Math.abs(r11) <= (this.A / 2)) goto L11;
    L10:
        return true;
    L5:
        if (Math.abs(this.f7479z) > getLViewWidth()) goto L10;
        goto L6
    }

    private final boolean H(int r10) {
        int r11 = this.f7476w;
        if (r11 != 1) goto L5;
    L6:
        if (r10 == 0) goto L10;
    L8:
        return false;
    L10:
        return true;
    L5:
        if (r11 != 2) goto L8;
        goto L6
    }

    private final boolean I() {
        int r10 = this.f7476w;
        if (r10 != 1) goto L5;
        return true;
    L5:
        if (r10 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    private final boolean J(float r10) {
        int r11 = this.f7479z;
        if (r11 >= 0) goto L5;
    L6:
        if (r11 <= 0) goto L8;
    L9:
        if (r11 >= 0) goto L11;
    L12:
        int r12 = this.f7479z;
        if (r12 <= 0) goto L15;
    L17:
        return false;
    L15:
        if (Math.abs(r12) >= (getRViewWidth() / 2)) goto L17;
    L16:
        return true;
    L11:
        if (Math.abs(r11) < (getLViewWidth() / 2)) goto L16;
    L8:
        if (r10 > this.f7462i) goto L16;
    L5:
        if (r10 < (-this.f7462i)) goto L16;
        goto L6
    }

    private final boolean K(float r10) {
        if (r10 >= 0) goto L5;
        return false;
    L5:
        int r11 = this.f7479z;
        if (r11 > 0) goto L8;
    L9:
        if (r11 > 0) goto L11;
        return false;
    L11:
        if (Math.abs(r11) <= (getLViewWidth() / 2)) goto L15;
    L12:
        return true;
    L15:
        return false;
    L8:
        if (r10 > this.f7462i) goto L12;
        goto L9
    }

    private final boolean L(float r10) {
        if (r10 <= 0) goto L5;
        return false;
    L5:
        int r11 = this.f7479z;
        if (r11 < 0) goto L8;
    L9:
        if (r11 < 0) goto L11;
        return false;
    L11:
        if (Math.abs(r11) <= (getRViewWidth() / 2)) goto L15;
    L12:
        return true;
    L15:
        return false;
    L8:
        if (r10 < (-this.f7462i)) goto L12;
        goto L9
    }

    private final boolean M(MotionEvent r10) {
        int[] r11 = new int[2];
        View r12 = this.D;
        Intrinsics.checkNotNull(r12);
        r12.getLocationOnScreen(r11);
        int r13 = r11[1];
        View r14 = this.D;
        Intrinsics.checkNotNull(r14);
        int r15 = r13 + r14.getMeasuredHeight();
        int r16 = r11[1];
        int r17 = (int) r10.getRawY();
        if ((r16 + 1) > r17) goto L7;
        if (r15 <= r17) goto L7;
        return true;
    L7:
        return false;
    }

    private final boolean N(View r10) {
        return r10 instanceof ViewGroup;
    }

    private final boolean O(View r10, Point r11) {
        if (r11.y >= r10.getTop()) goto L5;
    L11:
        return false;
    L5:
        if (r11.y >= r10.getBottom()) goto L11;
        if (r11.x < r10.getLeft()) goto L11;
        if (r11.y >= r10.getRight()) goto L11;
        return true;
    }

    private final void P() {
        if (this.f7461h == false) goto L8;
        if (this.f7459c == 3) goto L8;
        this.f7463j = true;
    L8:
        if (this.f7459c != 3) goto L11;
        setRightViewPadding(0);
        this.f7474u = 0;
        return;
    }

    private final void Q() {
        post(new d(this));
    }

    private final void R() {
        if (E() == false) goto L15;
        this.B = false;
        this.C = false;
        b r10 = this.K;
        if (r10 == null) goto L7;
        r10.onClose();
    L7:
        View r11 = this.E;
        if (r11 == null) goto L10;
        r11.layout(0, r11.getTop(), r11.getWidth(), r11.getBottom());
    L10:
        View r12 = this.H;
        if (r12 == null) goto L13;
        r12.layout(0, r12.getTop(), r12.getWidth(), r12.getBottom());
    L13:
        this.f7472s = 0;
        return;
    L15:
        if (getLeftOpenFinished() == false) goto L17;
    L26:
        this.B = true;
        this.C = false;
        b r13 = this.K;
        if (r13 == null) goto L34;
        r13.b(2, getLeftOpenFinished());
        return;
    L34:
        return;
    L17:
        if (getLeftViewOpened() == true) goto L26;
        if (getRightOpenFinished() == false) goto L22;
    L23:
        this.B = false;
        this.C = true;
        b r14 = this.K;
        if (r14 == null) goto L32;
        r14.b(1, getRightOpenFinished());
        return;
    L32:
        return;
    L22:
        if (getRightViewOpened() == true) goto L23;
    }

    public static final /* synthetic */ int a(OSwipeActionLayout r10, int r11, int r12) {
        return r10.x(r11, r12);
    }

    public static final /* synthetic */ int b(OSwipeActionLayout r10, int r11) {
        return r10.y(r11);
    }

    public static final /* synthetic */ int c(OSwipeActionLayout r10, int r11) {
        return r10.z(r11);
    }

    public static final /* synthetic */ int d(OSwipeActionLayout r10) {
        return r10.f7476w;
    }

    public static final /* synthetic */ ViewDragHelper e(OSwipeActionLayout r10) {
        return r10.f7477x;
    }

    public static final /* synthetic */ View f(OSwipeActionLayout r10) {
        return r10.D;
    }

    public static final /* synthetic */ int g(OSwipeActionLayout r10, float r11) {
        return r10.A(r11);
    }

    private final int getLViewWidth() {
        return this.f7470q;
    }

    private final boolean getLeftOpenFinished() {
        if (this.f7479z != (this.A - this.f7458J)) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean getLeftViewOpened() {
        if (this.H != null) goto L5;
    L7:
        return false;
    L5:
        if (this.f7479z != getLViewWidth()) goto L7;
        return true;
    }

    private final int getPreviousPosition() {
        if (this.B == false) goto L6;
        return getLViewWidth();
    L6:
        if (this.C == true) goto L11;
        return 0;
    L11:
        return -getRViewWidth();
    }

    private final int getRViewWidth() {
        return this.f7467n;
    }

    private final boolean getRightOpenFinished() {
        if (this.f7479z != ((-this.A) + this.G)) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean getRightViewEmpty() {
        if (this.E != null) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean getRightViewOpened() {
        if (this.E != null) goto L5;
    L7:
        return false;
    L5:
        if (this.f7479z != (-getRViewWidth())) goto L7;
        return true;
    }

    public static final /* synthetic */ int h(OSwipeActionLayout r10, float r11) {
        return r10.B(r11);
    }

    public static final /* synthetic */ int i(OSwipeActionLayout r10, float r11) {
        return r10.C(r11);
    }

    public static final /* synthetic */ int j(OSwipeActionLayout r10) {
        return r10.A;
    }

    public static final /* synthetic */ boolean k(OSwipeActionLayout r10) {
        return r10.B;
    }

    public static final /* synthetic */ View l(OSwipeActionLayout r10) {
        return r10.H;
    }

    public static final /* synthetic */ View m(OSwipeActionLayout r10) {
        return r10.I;
    }

    public static final /* synthetic */ int n(OSwipeActionLayout r10) {
        return r10.getPreviousPosition();
    }

    public static final /* synthetic */ int o(OSwipeActionLayout r10) {
        return r10.f7472s;
    }

    public static final /* synthetic */ boolean p(OSwipeActionLayout r10) {
        return r10.C;
    }

    public static final /* synthetic */ View q(OSwipeActionLayout r10) {
        return r10.E;
    }

    public static final /* synthetic */ View r(OSwipeActionLayout r10) {
        return r10.F;
    }

    public static final /* synthetic */ boolean s(OSwipeActionLayout r10, int r11) {
        return r10.H(r11);
    }

    private final void setRightViewPadding(int r10) {
        this.f7473t = r10;
        P();
    }

    public static final /* synthetic */ void t(OSwipeActionLayout r10, int r11) {
        r10.f7476w = r11;
    }

    public static final /* synthetic */ void u(OSwipeActionLayout r10, int r11) {
        r10.f7479z = r11;
    }

    public static final /* synthetic */ void v(OSwipeActionLayout r10, int r11) {
        r10.f7472s = r11;
    }

    public static final /* synthetic */ void w(OSwipeActionLayout r10) {
        r10.R();
    }

    private final int x(int r10, int r11) {
        boolean r12 = this.f7464k;
        if (r12 == false) goto L5;
    L9:
        if (r12 == false) goto L11;
    L15:
        boolean r13 = this.f7463j;
        if (r13 == true) goto L20;
        if (r10 <= 0) goto L20;
        return RangesKt.coerceAtMost(r10, getLViewWidth());
    L20:
        if (r13 == true) goto L24;
        if (r10 >= 0) goto L24;
        return RangesKt.coerceAtLeast(r10, -getRViewWidth());
    L24:
        if (r10 >= 0) goto L27;
        return RangesKt.coerceAtLeast(r10, this.f7474u - this.A);
    L27:
        return RangesKt.coerceAtMost(r10, this.A - this.f7473t);
    L11:
        if (this.C == false) goto L15;
        if (r11 <= 0) goto L15;
        return RangesKt.coerceAtMost(r10, 0);
    L5:
        if (this.B == false) goto L9;
        if (r11 >= 0) goto L9;
        return RangesKt.coerceAtLeast(r10, 0);
    }

    private final int y(int r10) {
        if (this.f7461h == false) goto L17;
        if (getRightViewEmpty() == false) goto L17;
        if (this.f7464k == false) goto L11;
        int r11 = this.A;
        if (r10 <= r11) goto L15;
        return 0;
    L15:
        return RangesKt.coerceAtLeast(r10, -r11);
    L11:
        if (r10 > 0) goto L41;
        r11 = this.A;
        goto L15
    L41:
        return 0;
    L17:
        if (this.f7463j == false) goto L30;
        if (this.f7464k == false) goto L25;
        int r12 = this.A;
        if (r10 <= r12) goto L24;
        return 0;
    L24:
        return RangesKt.coerceAtLeast(r10, this.f7474u - r12);
    L25:
        if (r10 <= 0) goto L28;
        return 0;
    L28:
        return RangesKt.coerceAtLeast(r10, this.f7474u - this.A);
    L30:
        if (this.f7464k == true) goto L32;
        if (r10 <= 0) goto L39;
        return 0;
    L39:
        return RangesKt.coerceAtLeast(r10, -getRViewWidth());
    L32:
        if (r10 <= this.A) goto L35;
        return 0;
    L35:
        return RangesKt.coerceAtLeast(r10, -getRViewWidth());
    }

    private final int z(int r10) {
        if (this.f7461h == false) goto L17;
        if (getRightViewEmpty() == false) goto L17;
        if (this.f7464k == false) goto L11;
        int r11 = this.A;
        if (r10 >= (-r11)) goto L15;
        return -r11;
    L15:
        return RangesKt.coerceAtMost(r10, r11);
    L11:
        if (r10 < 0) goto L41;
        r11 = this.A;
        goto L15
    L41:
        return 0;
    L17:
        if (this.f7463j == false) goto L30;
        if (this.f7464k == false) goto L25;
        int r12 = this.A;
        if (r10 >= (-r12)) goto L24;
        return -r12;
    L24:
        return RangesKt.coerceAtMost(r10, r12 - this.f7473t);
    L25:
        if (r10 >= 0) goto L28;
        return 0;
    L28:
        return RangesKt.coerceAtMost(r10, this.A - this.f7473t);
    L30:
        if (this.f7464k == false) goto L36;
        int r13 = this.A;
        if (r10 >= (-r13)) goto L35;
        return -r13;
    L35:
        return RangesKt.coerceAtMost(r10, getLViewWidth());
    L36:
        if (r10 >= 0) goto L39;
        return 0;
    L39:
        return RangesKt.coerceAtMost(r10, getLViewWidth());
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewDragHelper r10 = this.f7477x;
        Intrinsics.checkNotNull(r10);
        if (r10.continueSettling(true) == false) goto L6;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    }

    public final b getActionsListener() {
        return this.K;
    }

    public final boolean getContinuousSwipe() {
        return this.f7461h;
    }

    public final int getDirection() {
        return this.f7459c;
    }

    public final boolean getSwipeEnabled() {
        return this.f7460g;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        int r10 = this.f7471r;
        if (r10 == 0) goto L5;
        this.D = findViewById(r10);
    L5:
        int r11 = this.f7468o;
        if (r11 == 0) goto L8;
        this.H = findViewById(r11);
    L8:
        int r12 = this.f7465l;
        if (r12 == 0) goto L11;
        this.E = findViewById(r12);
    L11:
        int r13 = this.f7466m;
        if (r13 == 0) goto L14;
        this.F = findViewById(r13);
    L14:
        int r14 = this.f7469p;
        if (r14 == 0) goto L18;
        this.I = findViewById(r14);
    L18:
        if (this.D == null) goto L61;
        int r15 = this.f7459c;
        if (r15 != 1) goto L27;
        if (this.E != null) goto L27;
        throw new RuntimeException("'oui_sal_rightItem' must be specified");
    L27:
        if (r15 == 2) goto L29;
    L33:
        if (r15 == 1) goto L35;
    L41:
        if (r15 != 2) goto L50;
        if (this.f7461h == true) goto L50;
        if (this.H != null) goto L50;
        throw new RuntimeException("Must be specified 'oui_sal_leftItem'  or flag oui_sal_continuousSwipe = true");
    L50:
        if (r15 == 3) goto L52;
    L58:
        this.f7477x = ViewDragHelper.create(this, 1.0f, this.M);
        this.f7478y = new GestureDetectorCompat(getContext(), this.L);
        Q();
        super.onFinishInflate();
        return;
    L52:
        if (this.E == null) goto L57;
        if (this.H != null) goto L58;
    L57:
        throw new RuntimeException("'oui_sal_leftItem' and 'oui_sal_rightItem' must be specified");
    L35:
        if (this.f7461h == true) goto L41;
        if (this.E != null) goto L41;
        throw new RuntimeException("Must be specified 'oui_sal_rightItem' or flag oui_sal_continuousSwipe = true");
    L29:
        if (this.H != null) goto L33;
        throw new RuntimeException("'oui_sal_leftItem' must be specified");
    L61:
        throw new RuntimeException("'oui_sal_draggedItem' must be specified");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_EVENT);
        if (this.f7475v == false) goto L12;
        if (N(this.D) == false) goto L12;
        View r11 = D(r10, (ViewGroup) this.D);
        Point r12 = new Point((int) r10.getX(), (int) r10.getY());
        if (r11 == null) goto L12;
        if (O(r11, r12) == false) goto L12;
        return false;
    L12:
        if (M(r10) == false) goto L17;
        ViewDragHelper r13 = this.f7477x;
        Intrinsics.checkNotNull(r13);
        if (r13.shouldInterceptTouchEvent(r10) == false) goto L18;
        return true;
    L18:
        return false;
    L17:
        return false;
    }

    @Override // android.view.View
    protected void onSizeChanged(int r10, int r11, int r12, int r13) {
        this.A = r10;
        super.onSizeChanged(r10, r11, r12, r13);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_EVENT);
        if (M(r10) == false) goto L5;
    L8:
        GestureDetectorCompat r11 = this.f7478y;
        Intrinsics.checkNotNull(r11);
        r11.onTouchEvent(r10);
        ViewDragHelper r12 = this.f7477x;
        Intrinsics.checkNotNull(r12);
        r12.processTouchEvent(r10);
        return true;
    L5:
        if (I() == true) goto L8;
        return super.onTouchEvent(r10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean r10) {
        super.requestDisallowInterceptTouchEvent(r10);
        this.f7475v = r10;
    }

    public final void setActionsListener(b r10) {
        this.K = r10;
    }

    public final void setContinuousSwipe(boolean r10) {
        this.f7461h = r10;
    }

    public final void setDirection(int r10) {
        this.f7459c = r10;
    }

    public final void setSwipeEnabled(boolean r10) {
        this.f7460g = r10;
    }
}
