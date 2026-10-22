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
import com.obric.common.oui.R$styleable;
import com.obric.oui.layout.OUIFrameLayout;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class OSwipeLayout extends OUIFrameLayout {
    public static final DragEdge O = null;
    public h A;
    public float B;
    public float C;
    public int D;
    public boolean E;
    public int F;
    public boolean G;
    public boolean H;
    public float I;
    public float J;
    public View.OnClickListener K;
    public View.OnLongClickListener L;
    public Rect M;
    public final GestureDetector N;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f14591h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public DragEdge f14592i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ViewDragHelper f14593j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f14594k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f14595l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LinkedHashMap f14596m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ShowMode f14597n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final float[] f14598o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ArrayList f14599p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ArrayList f14600q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final HashMap f14601r;
    public final HashMap s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final HashMap f14602t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f14603u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean[] f14604v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f14605w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f14606x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f14607y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f14608z;

    public static final enum DragEdge extends Enum<DragEdge> {
        public static final DragEdge Bottom = null;
        public static final DragEdge Left = null;
        public static final DragEdge Right = null;
        public static final DragEdge Top = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DragEdge[] f14609a = null;

        static {
            DragEdge r5 = new DragEdge("Left", 0);
            Left = r5;
            DragEdge r10 = new DragEdge("Top", 1);
            Top = r10;
            DragEdge r11 = new DragEdge("Right", 2);
            Right = r11;
            DragEdge r12 = new DragEdge("Bottom", 3);
            Bottom = r12;
            f14609a = new DragEdge[]{r5, r10, r11, r12};
        }

        public static DragEdge valueOf(String r5) {
            return (DragEdge) Enum.valueOf(DragEdge.class, r5);
        }

        public static DragEdge[] values() {
            return (DragEdge[]) f14609a.clone();
        }
    }

    public static final enum ShowMode extends Enum<ShowMode> {
        public static final ShowMode LayDown = null;
        public static final ShowMode PullOut = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ShowMode[] f14610a = null;

        static {
            ShowMode r5 = new ShowMode("LayDown", 0);
            LayDown = r5;
            ShowMode r10 = new ShowMode("PullOut", 1);
            PullOut = r10;
            f14610a = new ShowMode[]{r5, r10};
        }

        public static ShowMode valueOf(String r5) {
            return (ShowMode) Enum.valueOf(ShowMode.class, r5);
        }

        public static ShowMode[] values() {
            return (ShowMode[]) f14610a.clone();
        }
    }

    public static final enum Status extends Enum<Status> {
        public static final Status Close = null;
        public static final Status Middle = null;
        public static final Status Open = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Status[] f14611a = null;

        static {
            Status r5 = new Status("Middle", 0);
            Middle = r5;
            Status r10 = new Status("Open", 1);
            Open = r10;
            Status r11 = new Status("Close", 2);
            Close = r11;
            f14611a = new Status[]{r5, r10, r11};
        }

        public static Status valueOf(String r5) {
            return (Status) Enum.valueOf(Status.class, r5);
        }

        public static Status[] values() {
            return (Status[]) f14611a.clone();
        }
    }

    static {
        O = DragEdge.Right;
    }

    public OSwipeLayout(Context r5) {
        this(r5, null);
    }

    private AdapterView getAdapterView() {
        ViewParent r5 = getParent();
        if ((r5 instanceof AdapterView) == true) goto L5;
        return null;
    L5:
        return (AdapterView) r5;
    }

    private float getCurrentOffset() {
        DragEdge r5 = this.f14592i;
        if (r5 != null) goto L7;
        return 0.0f;
    L7:
        return this.f14598o[r5.ordinal()];
    }

    public static void n(OSwipeLayout r5) {
        if (r5.getOpenStatus() != Status.Close) goto L13;
        AdapterView r10 = r5.getAdapterView();
        if (r10 == null) goto L11;
        int r11 = r10.getPositionForView(r5);
        if (r11 == (-1)) goto L12;
        r10.performItemClick(r10.getChildAt(r11 - r10.getFirstVisiblePosition()), r11, r10.getAdapter().getItemId(r11));
        return;
    L12:
        return;
    L11:
        return;
    }

    public static void o(OSwipeLayout r10) {
        if (r10.getOpenStatus() != Status.Close) goto L25;
        AdapterView<?> r5 = r10.getAdapterView();
        if (r5 == null) goto L23;
        int r11 = r5.getPositionForView(r10);
        if (r11 == (-1)) goto L26;
        long r12 = r5.getItemIdAtPosition(r11);
        Method r13 = AbsListView.class.getDeclaredMethod("performLongPress", new Class[]{View.class, Integer.TYPE, Long.TYPE});     // Catch: Exception -> L13
        r13.setAccessible(true);     // Catch: Exception -> L13
        ((Boolean) r13.invoke(r5, new Object[]{r10, Integer.valueOf(r11), Long.valueOf(r12)})).getClass();     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        if (r5.getOnItemLongClickListener() == null) goto L17;
        boolean r14 = r5.getOnItemLongClickListener().onItemLongClick(r5, r10, r11, r12);
    L18:
        if (r14 == false) goto L24;
        r5.performHapticFeedback(0);
        return;
    L24:
        return;
    L17:
        r14 = false;
        goto L18
    L26:
        return;
    L23:
        return;
    }

    private void setCurrentDragEdge(DragEdge r5) {
        this.f14592i = r5;
        z();
    }

    @Override // android.view.ViewGroup
    public final void addView(View r5, int r10, ViewGroup.LayoutParams r11) {
        if (r5 != null) goto L33;
        return;
    L33:
        int r12 = ((Integer) r11.getClass().getField("gravity").get(r11)).intValue();     // Catch: Exception -> L6
    L8:
        LinkedHashMap r13 = this.f14596m;
        if (r12 <= 0) goto L22;
        int r14 = GravityCompat.getAbsoluteGravity(r12, ViewCompat.getLayoutDirection(this));
        if ((r14 & 3) != 3) goto L14;
        r13.put(DragEdge.Left, r5);
    L14:
        if ((r14 & 5) != 5) goto L17;
        r13.put(DragEdge.Right, r5);
    L17:
        if ((r14 & 48) != 48) goto L20;
        r13.put(DragEdge.Top, r5);
    L20:
        if ((r14 & 80) != 80) goto L29;
        r13.put(DragEdge.Bottom, r5);
    L29:
        if (r5.getParent() != this) goto L31;
        return;
    L31:
        super.addView(r5, r10, r11);
        return;
    L22:
        Iterator r15 = r13.entrySet().iterator();
    L24:
        if (r15.hasNext() == false) goto L29;
        Map.Entry r16 = (Map.Entry) r15.next();
        if (r16.getValue() != null) goto L24;
        r13.put((DragEdge) r16.getKey(), r5);
    L6:
        e = move-exception;
        e.printStackTrace();
        r12 = 0;
        goto L8
    }

    @Override // android.view.View
    public final void computeScroll() {
        super.computeScroll();
        if (this.f14593j.continueSettling(true) == false) goto L6;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    }

    public List<View> getBottomViews() {
        ArrayList r5 = new ArrayList();
        DragEdge[] r10 = DragEdge.values();
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        DragEdge r13 = r10[r12];
        r5.add((View) this.f14596m.get(r13));
        r12 = r12 + 1;
        goto L3
    L5:
        return r5;
    }

    public View getCurrentBottomView() {
        List<View> r5 = getBottomViews();
        if (this.f14592i.ordinal() < r5.size()) goto L5;
        return null;
    L5:
        return r5.get(this.f14592i.ordinal());
    }

    public int getDragDistance() {
        return this.f14595l;
    }

    public DragEdge getDragEdge() {
        return this.f14592i;
    }

    public Map<DragEdge, View> getDragEdgeMap() {
        return this.f14596m;
    }

    @Deprecated
    public List<DragEdge> getDragEdges() {
        return new ArrayList(this.f14596m.keySet());
    }

    public boolean getIsBeingDragged() {
        return this.H;
    }

    public Status getOpenStatus() {
        View r5 = getSurfaceView();
        if (r5 == null) goto L5;
        int r10 = r5.getLeft();
        int r11 = r5.getTop();
        if (r10 != getPaddingLeft()) goto L13;
        if (r11 != getPaddingTop()) goto L13;
        return Status.Close;
    L13:
        if (r10 == (getPaddingLeft() - this.f14595l)) goto L24;
        if (r10 == (getPaddingLeft() + this.f14595l)) goto L24;
        if (r11 == (getPaddingTop() - this.f14595l)) goto L24;
        if (r11 == (getPaddingTop() + this.f14595l)) goto L24;
        return Status.Middle;
    L24:
        return Status.Open;
    L5:
        return Status.Close;
    }

    public ShowMode getShowMode() {
        return this.f14597n;
    }

    public View getSurfaceView() {
        if (getChildCount() != 0) goto L7;
        return null;
    L7:
        return getChildAt(getChildCount() - 1);
    }

    public float getWillOpenPercentAfterClose() {
        return this.f14607y;
    }

    public float getWillOpenPercentAfterOpen() {
        return this.f14606x;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getAdapterView() != null) goto L5;
        return;
    L5:
        if (this.K != null) goto L8;
        setOnClickListener(new com.bytedance.android.anniex.container.l(this, 3));
    L8:
        if (this.L != null) goto L12;
        setOnLongClickListener(new e(this));
        return;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewDragHelper r5 = this.f14593j;
        if (r5 == null) goto L6;
        r5.abort();
    L6:
        if (getOpenStatus() == Status.Close) goto L9;
        q(false);
        return;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r10) {
        if (this.f14603u == true) goto L6;
        return false;
    L6:
        if (this.f14605w == true) goto L8;
    L12:
        Iterator r5 = this.f14600q.iterator();
    L14:
        if (r5.hasNext() == false) goto L20;
        if (r5.next() == null) goto L14;
        throw new ClassCastException();
    L20:
        int r11 = r10.getAction();
        ViewDragHelper r12 = this.f14593j;
        if (r11 == 0) goto L40;
        if (r11 != 1) goto L24;
    L39:
        this.G = false;
        this.H = false;
        r12.processTouchEvent(r10);
    L59:
        return this.H;
    L24:
        if (r11 != 2) goto L26;
        boolean r13 = this.H;
        p(r10);
        if (this.H == true) goto L31;
    L35:
        if (r13 == true) goto L59;
        if (this.H == false) goto L59;
        return false;
    L31:
        if (this.G == true) goto L35;
        ViewParent r14 = getParent();
        if (r14 == null) goto L35;
        r14.requestDisallowInterceptTouchEvent(true);
        goto L35
    L26:
        if (r11 == 3) goto L39;
        r12.processTouchEvent(r10);
        goto L59
    L40:
        r12.processTouchEvent(r10);
        this.G = false;
        this.H = false;
        this.I = r10.getRawX();
        this.J = r10.getRawY();
        if (getOpenStatus() != Status.Middle) goto L44;
        this.H = true;
    L44:
        if (this.f14608z == false) goto L59;
        View r15 = getSurfaceView();
        if (r15 == null) goto L57;
        int r16 = (int) r10.getX();
        int r17 = (int) r10.getY();
        if (r16 < r15.getLeft()) goto L57;
        if (r16 > r15.getRight()) goto L57;
        if (r17 < r15.getTop()) goto L57;
        if (r17 <= r15.getBottom()) goto L59;
    L57:
        this.G = true;
        goto L59
    L8:
        if (getOpenStatus() != Status.Open) goto L12;
        if (w(r10) == false) goto L12;
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        z();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r10) {
        if (this.f14603u == false) goto L5;
        int r5 = r10.getActionMasked();
        this.N.onTouchEvent(r10);
        ViewDragHelper r11 = this.f14593j;
        if (r5 == 0) goto L20;
        if (r5 != 1) goto L10;
    L19:
        this.H = false;
        r11.processTouchEvent(r10);
    L22:
        if (super.onTouchEvent(r10) == true) goto L27;
        if (this.H == true) goto L27;
        if (r5 == 0) goto L27;
        return false;
    L27:
        return true;
    L10:
        if (r5 != 2) goto L12;
        p(r10);
        if (this.H == false) goto L22;
        if (this.G == true) goto L22;
        getParent().requestDisallowInterceptTouchEvent(true);
        r11.processTouchEvent(r10);
        goto L22
    L12:
        if (r5 == 3) goto L19;
        r11.processTouchEvent(r10);
        goto L22
    L20:
        r11.processTouchEvent(r10);
        this.I = r10.getRawX();
        this.J = r10.getRawY();
        goto L22
    L5:
        return super.onTouchEvent(r10);
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View r5) {
        LinkedHashMap r10 = this.f14596m;
        Iterator r11 = new HashMap(r10).entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Map.Entry r12 = (Map.Entry) r11.next();
        if (r12.getValue() != r5) goto L4;
        r10.remove(r12.getKey());
        goto L4
    }

    public final void p(MotionEvent r14) {
        if (this.H == true) goto L5;
    L7:
        Status r5 = getOpenStatus();
        Status r10 = Status.Middle;
        if (r5 != r10) goto L11;
        this.H = true;
        return;
    L11:
        Status r11 = getOpenStatus();
        float r12 = r14.getRawX() - this.I;
        float r15 = r14.getRawY() - this.J;
        float r13 = (float) Math.toDegrees(Math.atan(Math.abs(r15 / r12)));
        Status r16 = getOpenStatus();
        Status r17 = Status.Close;
        if (r16 != r17) goto L61;
        boolean[] r18 = this.f14604v;
        LinkedHashMap r19 = this.f14596m;
        if (r13 >= 45.0f) goto L39;
        if (r12 <= 0.0f) goto L27;
        DragEdge r20 = DragEdge.Left;
        View r110 = (View) r19.get(r20);
        if (r110 == null) goto L27;
        if (r110.getParent() != this) goto L27;
        if (r110 == getSurfaceView()) goto L27;
        if (r18[r20.ordinal()] == false) goto L27;
    L59:
        setCurrentDragEdge(r20);
    L27:
        if (r12 >= 0.0f) goto L37;
        r20 = DragEdge.Right;
        View r21 = (View) r19.get(r20);
        if (r21 != null) goto L31;
        return;
    L31:
        if (r21.getParent() == this) goto L33;
        return;
    L33:
        if (r21 != getSurfaceView()) goto L35;
        return;
    L35:
        if (r18[r20.ordinal()] == true) goto L59;
        return;
    L37:
        return;
    L39:
        if (r15 <= 0.0f) goto L50;
        r20 = DragEdge.Top;
        View r111 = (View) r19.get(r20);
        if (r111 == null) goto L50;
        if (r111.getParent() != this) goto L50;
        if (r111 == getSurfaceView()) goto L50;
        if (r18[r20.ordinal()] == true) goto L59;
    L50:
        if (r15 >= 0.0f) goto L60;
        r20 = DragEdge.Bottom;
        View r22 = (View) r19.get(r20);
        if (r22 != null) goto L54;
        return;
    L54:
        if (r22.getParent() == this) goto L56;
        return;
    L56:
        if (r22 != getSurfaceView()) goto L58;
        return;
    L58:
        if (r18[r20.ordinal()] == true) goto L59;
        return;
    L60:
        return;
    L61:
        DragEdge r23 = this.f14592i;
        DragEdge r24 = DragEdge.Right;
        int r25 = this.f14591h;
        boolean r112 = false;
        if (r23 != r24) goto L87;
        Status r26 = Status.Open;
        if (r11 == r26) goto L66;
    L67:
        if (r11 == r17) goto L69;
    L71:
        boolean r113 = false;
    L73:
        if (this.f14608z == false) goto L78;
        if (r11 != r26) goto L78;
        if (r12 >= (-r25)) goto L78;
        r113 = true;
    L78:
        if (r113 == true) goto L82;
        if (r11 == r10) goto L82;
        boolean r27 = false;
    L84:
        if (r13 > 30.0f) goto L86;
        if (r27 == true) goto L87;
    L86:
        boolean r28 = true;
    L89:
        if (r23 != DragEdge.Left) goto L109;
        if (r11 == Status.Open) goto L93;
    L94:
        if (r11 == r17) goto L96;
    L98:
        boolean r29 = false;
    L99:
        if (r29 == true) goto L103;
        if (r11 == r10) goto L103;
        boolean r30 = false;
    L105:
        if (r13 > 30.0f) goto L107;
        if (r30 == true) goto L109;
    L107:
        r28 = true;
    L103:
        r30 = true;
        goto L105
    L96:
        if (r12 <= r25) goto L98;
    L97:
        r29 = true;
        goto L99
    L93:
        if (r12 < (-r25)) goto L97;
    L109:
        if (r23 != DragEdge.Top) goto L129;
        if (r11 == Status.Open) goto L113;
    L114:
        if (r11 == r17) goto L116;
    L118:
        boolean r31 = false;
    L119:
        if (r31 == true) goto L123;
        if (r11 == r10) goto L123;
        boolean r32 = false;
    L125:
        if (r13 < 60.0f) goto L127;
        if (r32 == true) goto L129;
    L127:
        r28 = true;
    L123:
        r32 = true;
        goto L125
    L116:
        if (r15 <= r25) goto L118;
    L117:
        r31 = true;
        goto L119
    L113:
        if (r15 < (-r25)) goto L117;
    L129:
        if (r23 == DragEdge.Bottom) goto L131;
    L146:
        this.H = !r28;
        return;
    L131:
        if (r11 == Status.Open) goto L133;
    L134:
        if (r11 == r17) goto L136;
    L138:
        boolean r114 = false;
    L139:
        if (r114 == true) goto L141;
        if (r11 == r10) goto L141;
    L143:
        if (r13 < 60.0f) goto L145;
        if (r112 == true) goto L146;
    L145:
        r28 = true;
    L141:
        r112 = true;
        goto L143
    L136:
        if (r15 >= (-r25)) goto L138;
    L137:
        r114 = true;
        goto L139
    L133:
        if (r15 > r25) goto L137;
    L82:
        r27 = true;
        goto L84
    L69:
        if (r12 >= (-r25)) goto L71;
    L70:
        r113 = true;
        goto L73
    L66:
        if (r12 > r25) goto L70;
    L87:
        r28 = false;
        goto L89
    L5:
        if (this.G == true) goto L7;
    }

    public final void q(boolean r10) {
        View r5 = getSurfaceView();
        if (r5 != null) goto L5;
        return;
    L5:
        ViewDragHelper r11 = this.f14593j;
        if (r11 == null) goto L8;
        r11.abort();
    L8:
        if (r10 == false) goto L10;
        r11.smoothSlideViewTo(getSurfaceView(), getPaddingLeft(), getPaddingTop());
    L14:
        invalidate();
        return;
    L10:
        Rect r12 = s(false);
        HashMap r13 = this.f14602t;
        r13.remove(r5);
        if (((Rect) r13.get(getCurrentBottomView())) == null) goto L13;
        r13.remove(getCurrentBottomView());
    L13:
        int r14 = r12.left - r5.getLeft();
        int r15 = r12.top - r5.getTop();
        r5.layout(r12.left, r12.top, r12.right, r12.bottom);
        t(r12.left, r12.top, r12.right, r12.bottom);
        u(r12.left, r12.top, r14, r15);
        goto L14
    }

    public final Rect r(ShowMode r10, Rect r11) {
        View r5 = getCurrentBottomView();
        int r12 = r11.left;
        int r13 = r11.top;
        int r14 = r11.right;
        int r15 = r11.bottom;
        if (r10 != ShowMode.PullOut) goto L28;
        DragEdge r16 = this.f14592i;
        DragEdge r17 = DragEdge.Left;
        if (r16 != r17) goto L8;
        r12 = r12 - this.f14595l;
    L14:
        int r18 = 0;
        if (r16 != r17) goto L17;
    L23:
        if (r5 == null) goto L26;
        r18 = r5.getMeasuredWidth();
    L26:
        r14 = r12 + r18;
    L40:
        return new Rect(r12, r13, r14, r15);
    L17:
        if (r16 == DragEdge.Right) goto L23;
        if (r5 == null) goto L22;
        r18 = r5.getMeasuredHeight();
    L22:
        r15 = r13 + r18;
        r14 = r11.right;
        goto L40
    L8:
        if (r16 != DragEdge.Right) goto L11;
        r12 = r14;
        goto L14
    L11:
        if (r16 != DragEdge.Top) goto L13;
        r13 = r13 - this.f14595l;
        goto L14
    L13:
        r13 = r15;
        goto L14
    L28:
        if (r10 != ShowMode.LayDown) goto L40;
        DragEdge r19 = this.f14592i;
        if (r19 != DragEdge.Left) goto L33;
        r18 = this.f14595l;
        goto L26
    L33:
        if (r19 != DragEdge.Right) goto L36;
        r12 = r14 - this.f14595l;
        goto L40
    L36:
        if (r19 != DragEdge.Top) goto L38;
        r15 = r13 + this.f14595l;
        goto L40
    L38:
        r13 = r15 - this.f14595l;
        goto L40
    }

    public final Rect s(boolean r5) {
        int r10 = getPaddingLeft();
        int r11 = getPaddingTop();
        if (r5 == false) goto L15;
        DragEdge r12 = this.f14592i;
        if (r12 != DragEdge.Left) goto L8;
        int r13 = getPaddingLeft();
        r10 = this.f14595l + r13;
        goto L15
    L8:
        if (r12 != DragEdge.Right) goto L11;
        r10 = getPaddingLeft() - this.f14595l;
        goto L15
    L11:
        if (r12 != DragEdge.Top) goto L13;
        int r14 = getPaddingTop();
        r11 = this.f14595l + r14;
        goto L15
    L13:
        r11 = getPaddingTop() - this.f14595l;
    L15:
        return new Rect(r10, r11, getMeasuredWidth() + r10, getMeasuredHeight() + r11);
    }

    public void setBottomSwipeEnabled(boolean r5) {
        int r10 = DragEdge.Bottom.ordinal();
        this.f14604v[r10] = r5;
    }

    public void setClickToClose(boolean r5) {
        this.f14605w = r5;
    }

    public void setDragDistance(int r5) {
        if (r5 >= 0) goto L4;
        r5 = 0;
    L4:
        this.f14595l = v(r5);
        requestLayout();
    }

    @Deprecated
    public void setDragEdge(DragEdge r5) {
        this.f14596m.clear();
        if (getChildCount() < 2) goto L5;
        this.f14596m.put(r5, getChildAt(getChildCount() - 2));
    L5:
        setCurrentDragEdge(r5);
    }

    @Deprecated
    public void setDragEdges(List<DragEdge> r10) {
        this.f14596m.clear();
        int r5 = Math.min(r10.size(), getChildCount() - 1);
        int r11 = 0;
    L3:
        if (r11 >= r5) goto L5;
        this.f14596m.put(r10.get(r11), getChildAt(r11));
        r11 = r11 + 1;
        goto L3
    L5:
        int r12 = r10.size();
        DragEdge r13 = O;
        if (r12 != 0) goto L8;
    L11:
        setCurrentDragEdge(r13);
        return;
    L8:
        if (r10.contains(r13) == true) goto L11;
        setCurrentDragEdge(r10.get(0));
    }

    public void setLeftSwipeEnabled(boolean r5) {
        int r10 = DragEdge.Left.ordinal();
        this.f14604v[r10] = r5;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r5) {
        super.setOnClickListener(r5);
        this.K = r5;
    }

    public void setOnDoubleClickListener(g r5) {
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener r5) {
        super.setOnLongClickListener(r5);
        this.L = r5;
    }

    public void setOverrideDragDistance(int r5) {
        this.D = r5;
    }

    public void setQuickDeleteEnabled(boolean r5) {
        this.f14608z = r5;
    }

    public void setQuickDeleteListener(h r5) {
        this.A = r5;
    }

    public void setQuickDeleteMax(float r5) {
        this.C = r5;
    }

    public void setQuickDeleteThreshold(float r5) {
        this.B = r5;
    }

    public void setRightSwipeEnabled(boolean r5) {
        int r10 = DragEdge.Right.ordinal();
        this.f14604v[r10] = r5;
    }

    public void setShowMode(ShowMode r5) {
        this.f14597n = r5;
        requestLayout();
    }

    public void setSwipeEnabled(boolean r5) {
        this.f14603u = r5;
    }

    public void setTopSwipeEnabled(boolean r5) {
        int r10 = DragEdge.Top.ordinal();
        this.f14604v[r10] = r5;
    }

    public void setWillOpenPercentAfterClose(float r5) {
        this.f14607y = r5;
    }

    public void setWillOpenPercentAfterOpen(float r5) {
        this.f14606x = r5;
    }

    public final void t(int r20, int r21, int r22, int r23) {
        HashMap r5 = this.f14601r;
        if (r5.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator r10 = r5.entrySet().iterator();
    L7:
        if (r10.hasNext() == false) goto L161;
        Map.Entry r11 = (Map.Entry) r10.next();
        View r12 = (View) r11.getKey();
        Rect r13 = new Rect(r12.getLeft(), r12.getTop(), 0, 0);
        View r14 = r12;
    L10:
        if (r14.getParent() == null) goto L17;
        if (r14 == getRootView()) goto L17;
        r14 = (View) r14.getParent();
        if (r14 == this) goto L17;
        r13.left = r14.getLeft() + r13.left;
        r13.top = r14.getTop() + r13.top;
    L17:
        r13.right = r12.getMeasuredWidth() + r13.left;
        int r15 = r12.getMeasuredHeight() + r13.top;
        r13.bottom = r15;
        DragEdge r16 = this.f14592i;
        int r17 = r13.left;
        int r18 = r13.right;
        int r19 = r13.top;
        ShowMode r110 = getShowMode();
        ShowMode r111 = ShowMode.LayDown;
        Iterator r112 = r10;
        HashMap r24 = this.s;
        if (r110 != r111) goto L40;
        int r25 = f.f14620a[r16.ordinal()];
        if (r25 != 1) goto L22;
        if (r21 < r19) goto L109;
        if (r21 >= r15) goto L109;
    L69:
        r24.put(r12, Boolean.FALSE);
        float r26 = 0.0f;
        if (getShowMode() != r111) goto L85;
        int r27 = f.f14620a[this.f14592i.ordinal()];
        if (r27 != 1) goto L74;
        float r28 = r13.top - r21;
        int r29 = r12.getHeight();
    L96:
        r26 = r28 / r29;
    L100:
        Iterator r30 = ((ArrayList) r11.getValue()).iterator();
        if (r30.hasNext() == false) goto L109;
        if (r30.next() != null) goto L108;
        Math.abs(r26);
        throw null;
    L108:
        throw new ClassCastException();
    L74:
        if (r27 != 2) goto L76;
        r28 = r13.bottom - r23;
        r29 = r12.getHeight();
        goto L96
    L76:
        if (r27 != 3) goto L78;
        r28 = r13.left - r20;
        r29 = r12.getWidth();
        goto L96
    L78:
        if (r27 != 4) goto L100;
        r28 = r13.right - r22;
        r29 = r12.getWidth();
        goto L96
    L85:
        if (getShowMode() != ShowMode.PullOut) goto L100;
        int r31 = f.f14620a[this.f14592i.ordinal()];
        if (r31 != 1) goto L89;
        r28 = r13.bottom - getPaddingTop();
        r29 = r12.getHeight();
        goto L96
    L89:
        if (r31 != 2) goto L91;
        r28 = r13.top - getHeight();
        r29 = r12.getHeight();
        goto L96
    L91:
        if (r31 != 3) goto L93;
        r28 = r13.right - getPaddingLeft();
        r29 = r12.getWidth();
        goto L96
    L93:
        if (r31 != 4) goto L100;
        r28 = r13.left - getWidth();
        r29 = r12.getWidth();
    L109:
        DragEdge r32 = this.f14592i;
        if (((Boolean) r24.get(r12)).booleanValue() == true) goto L160;
        int r33 = r13.left;
        int r113 = r13.right;
        int r114 = r13.top;
        int r34 = r13.bottom;
        if (getShowMode() != r111) goto L128;
        if (r32 != DragEdge.Right) goto L118;
        if (r22 > r33) goto L118;
    L145:
        r24.put(r12, Boolean.TRUE);
        Iterator r35 = ((ArrayList) r11.getValue()).iterator();
        if (r35.hasNext() == false) goto L160;
        if (r35.next() != null) goto L159;
        DragEdge r36 = this.f14592i;
        if (r36 != DragEdge.Left) goto L152;
    L156:
        r12.getWidth();
        throw null;
    L152:
        if (r36 == DragEdge.Right) goto L156;
        r12.getHeight();
        throw null;
    L159:
        throw new ClassCastException();
    L118:
        if (r32 != DragEdge.Left) goto L121;
        if (r20 >= r113) goto L145;
    L121:
        if (r32 != DragEdge.Top) goto L124;
        if (r21 >= r34) goto L145;
    L124:
        if (r32 != DragEdge.Bottom) goto L160;
        if (r23 > r114) goto L160;
    L128:
        if (getShowMode() != ShowMode.PullOut) goto L160;
        if (r32 != DragEdge.Right) goto L134;
        if (r113 <= getWidth()) goto L145;
    L134:
        if (r32 != DragEdge.Left) goto L138;
        if (r33 >= getPaddingLeft()) goto L145;
    L138:
        if (r32 != DragEdge.Top) goto L142;
        if (r114 >= getPaddingTop()) goto L145;
    L142:
        if (r32 != DragEdge.Bottom) goto L160;
        if (r34 <= getHeight()) goto L145;
    L160:
        r10 = r112;
        goto L7
    L22:
        if (r25 != 2) goto L24;
        if (r23 <= r19) goto L109;
        if (r23 > r15) goto L109;
    L24:
        if (r25 == 3) goto L30;
        if (r25 != 4) goto L109;
        if (r22 <= r17) goto L109;
        if (r22 > r18) goto L109;
    L30:
        if (r20 >= r18) goto L109;
        if (r20 < r17) goto L109;
    L40:
        if (getShowMode() != ShowMode.PullOut) goto L109;
        int r37 = f.f14620a[r16.ordinal()];
        if (r37 == 1) goto L66;
        if (r37 == 2) goto L61;
        if (r37 == 3) goto L56;
        if (r37 != 4) goto L109;
        if (r17 > getWidth()) goto L109;
        if (r18 <= getWidth()) goto L109;
    L56:
        if (r18 < getPaddingLeft()) goto L109;
        if (r17 >= getPaddingLeft()) goto L109;
    L61:
        if (r19 >= getHeight()) goto L109;
        if (r19 < getPaddingTop()) goto L109;
    L66:
        if (r19 >= getPaddingTop()) goto L109;
        if (r15 < getPaddingTop()) goto L109;
    }

    public final void u(int r10, int r11, int r12, int r13) {
        DragEdge r14 = getDragEdge();
        if (r14 != DragEdge.Left) goto L7;
        if (r12 >= 0) goto L18;
    L5:
        boolean r15 = false;
    L19:
        y();
        Status r16 = getOpenStatus();
        ArrayList r17 = this.f14599p;
        if (r17.isEmpty() == true) goto L54;
        this.F++;
        Iterator r5 = r17.iterator();
    L23:
        if (r5.hasNext() == false) goto L31;
        i r18 = (i) r5.next();
        if (this.F != 1) goto L29;
        if (r15 == false) goto L28;
        r18.d();
        goto L29
    L28:
        r18.getClass();
    L29:
        int r19 = r10 - getPaddingLeft();
        getPaddingTop();
        r18.a(this, r19);
        goto L23
    L31:
        if (r16 != Status.Close) goto L38;
        Iterator r20 = r17.iterator();
    L34:
        if (r20.hasNext() == false) goto L36;
        ((i) r20.next()).onClose();
        goto L34
    L36:
        this.F = 0;
    L38:
        if (r16 != Status.Open) goto L55;
        View r21 = getCurrentBottomView();
        if (r21 == null) goto L42;
        r21.setEnabled(true);
    L42:
        Iterator r22 = r17.iterator();
    L44:
        if (r22.hasNext() == false) goto L46;
        ((i) r22.next()).c();
        goto L44
    L46:
        this.F = 0;
        return;
    L55:
        return;
    L54:
        return;
    L18:
        r15 = true;
        goto L19
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

    public final int v(float r5) {
        return (int) ((r5 * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final boolean w(MotionEvent r5) {
        View r10 = getSurfaceView();
        if (r10 != null) goto L7;
        return false;
    L7:
        if (this.M != null) goto L9;
        this.M = new Rect();
    L9:
        r10.getHitRect(this.M);
        return this.M.contains((int) r5.getX(), (int) r5.getY());
    }

    public final void x() {
        View r5 = getSurfaceView();
        getCurrentBottomView();
        if (r5 == null) goto L10;
        ViewDragHelper r10 = this.f14593j;
        if (r10 == null) goto L8;
        r10.abort();
    L8:
        Rect r11 = s(true);
        r10.smoothSlideViewTo(r5, r11.left, r11.top);
        invalidate();
        return;
    }

    public final void y() {
        Status r5 = getOpenStatus();
        List<View> r10 = getBottomViews();
        if (r5 != Status.Close) goto L12;
        Iterator<View> r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L27;
        View r12 = r11.next();
        if (r12 == null) goto L6;
        if (r12.getVisibility() == 4) goto L6;
        r12.setVisibility(4);
        goto L6
    L27:
        return;
    L12:
        View r13 = getCurrentBottomView();
        if (r13 != null) goto L15;
        return;
    L15:
        if (r13.getVisibility() == 0) goto L26;
        r13.setVisibility(0);
        return;
    }

    public final void z() {
        View r5 = getCurrentBottomView();
        if (r5 == null) goto L11;
        DragEdge r10 = this.f14592i;
        if (r10 != DragEdge.Left) goto L7;
    L10:
        this.f14595l = r5.getMeasuredWidth() - v(getCurrentOffset());
        goto L11
    L7:
        if (r10 == DragEdge.Right) goto L10;
        this.f14595l = r5.getMeasuredHeight() - v(getCurrentOffset());
    L11:
        ShowMode r11 = this.f14597n;
        ShowMode r12 = ShowMode.PullOut;
        HashMap r13 = this.f14602t;
        boolean r14 = false;
        if (r11 != r12) goto L26;
        View r15 = getSurfaceView();
        Rect r16 = (Rect) r13.get(r15);
        if (r16 == null) goto L16;
    L19:
        if (r15 == null) goto L21;
        r15.layout(r16.left, r16.top, r16.right, r16.bottom);
        bringChildToFront(r15);
    L21:
        View r17 = getCurrentBottomView();
        Rect r18 = (Rect) r13.get(r17);
        if (r18 != null) goto L24;
        r18 = r(r12, r16);
    L24:
        if (r17 == null) goto L38;
        r17.layout(r18.left, r18.top, r18.right, r18.bottom);
    L38:
        y();
        return;
    L16:
        if (getOpenStatus() == Status.Close) goto L18;
        r14 = true;
    L18:
        r16 = s(r14);
        goto L19
    L26:
        ShowMode r19 = ShowMode.LayDown;
        if (r11 != r19) goto L38;
        View r20 = getSurfaceView();
        Rect r21 = (Rect) r13.get(r20);
        if (r21 != null) goto L31;
        r21 = s(false);
    L31:
        if (r20 == null) goto L33;
        r20.layout(r21.left, r21.top, r21.right, r21.bottom);
        bringChildToFront(r20);
    L33:
        View r22 = getCurrentBottomView();
        Rect r23 = (Rect) r13.get(r22);
        if (r23 != null) goto L36;
        r23 = r(r19, r21);
    L36:
        if (r22 == null) goto L38;
        r22.layout(r23.left, r23.top, r23.right, r23.bottom);
        goto L38
    }

    public OSwipeLayout(Context r5, AttributeSet r10) {
        this(r5, r10, 0);
    }

    public OSwipeLayout(Context r12, AttributeSet r13, int r14) {
        super(r12, r13, r14);
        this.f14592i = O;
        this.f14595l = 0;
        LinkedHashMap r5 = new LinkedHashMap();
        this.f14596m = r5;
        float[] r10 = new float[4];
        this.f14598o = r10;
        this.f14599p = new ArrayList();
        this.f14600q = new ArrayList();
        this.f14601r = new HashMap();
        this.s = new HashMap();
        this.f14602t = new HashMap();
        this.f14603u = true;
        this.f14604v = new boolean[]{true, true, true, true};
        this.f14605w = false;
        this.f14606x = 0.75f;
        this.f14607y = 0.25f;
        this.f14608z = false;
        this.B = 1.5f;
        this.C = 2.0f;
        this.D = -1;
        this.E = false;
        d r11 = new d(this);
        this.F = 0;
        this.I = -1.0f;
        this.J = -1.0f;
        this.N = new GestureDetector(getContext(), new b(this, 1));
        this.f14593j = ViewDragHelper.create(this, r11);
        this.f14591h = ViewConfiguration.get(r12).getScaledTouchSlop();
        TypedArray r15 = r12.obtainStyledAttributes(r13, R$styleable.OSwipeLayout);
        int r16 = r15.getInt(R$styleable.OSwipeLayout_oui_drag_edge, 2);
        DragEdge r17 = DragEdge.Left;
        r10[r17.ordinal()] = r15.getDimension(R$styleable.OSwipeLayout_oui_leftEdgeSwipeOffset, 0.0f);
        DragEdge r18 = DragEdge.Right;
        r10[r18.ordinal()] = r15.getDimension(R$styleable.OSwipeLayout_oui_rightEdgeSwipeOffset, 0.0f);
        DragEdge r19 = DragEdge.Top;
        r10[r19.ordinal()] = r15.getDimension(R$styleable.OSwipeLayout_oui_topEdgeSwipeOffset, 0.0f);
        DragEdge r20 = DragEdge.Bottom;
        r10[r20.ordinal()] = r15.getDimension(R$styleable.OSwipeLayout_oui_bottomEdgeSwipeOffset, 0.0f);
        setClickToClose(r15.getBoolean(R$styleable.OSwipeLayout_oui_clickToClose, this.f14605w));
        if ((r16 & 1) != 1) goto L6;
        r5.put(r17, null);
    L6:
        if ((r16 & 4) != 4) goto L9;
        r5.put(r19, null);
    L9:
        if ((r16 & 2) != 2) goto L12;
        r5.put(r18, null);
    L12:
        if ((r16 & 8) != 8) goto L14;
        r5.put(r20, null);
    L14:
        int r110 = r15.getInt(R$styleable.OSwipeLayout_oui_show_mode, ShowMode.PullOut.ordinal());
        this.f14597n = ShowMode.values()[r110];
        r15.recycle();
    }

    @Deprecated
    public void setDragEdges(DragEdge... r5) {
        this.f14596m.clear();
        setDragEdges(Arrays.asList(r5));
    }
}
