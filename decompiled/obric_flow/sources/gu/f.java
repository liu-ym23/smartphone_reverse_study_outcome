package gu;

import ai.j0;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.os.Trace;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.Advanceable;
import android.widget.FrameLayout;
import android.widget.RemoteViews;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.clockwidgets.R$id;
import com.obric.clockwidgets.ui.CircleClockView;
import com.obric.clockwidgets.ui.SquareClockView;
import com.obric.clockwidgets.ui.WidgetViewBinder$Type;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import obric.flow.appwidget.FlowAppWidgetProviderInfo;
import obric.flow.appwidget.R$drawable;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends b implements j, View.OnLongClickListener {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final SparseBooleanArray f17234u = null;
    public final hu.a g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f17235h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f17236i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f17237j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public e f17238k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f17239l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f17240m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public RecyclerView f17241n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ViewGroup f17242o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f17243p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f17244q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public com.obric.clockwidgets.ui.g f17245r;
    public com.obric.clockwidgets.ui.d s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View f17246t;

    static {
        f17234u = new SparseBooleanArray();
    }

    public f(Context r5) {
        super(r5);
        this.f17239l = false;
        this.f17240m = null;
        this.f17245r = null;
        this.s = null;
        this.f17246t = null;
        this.g = new hu.a(this, this);
        setBackgroundResource(R$drawable.widget_internal_focus_bg);
        setOnLightBackground(true);
    }

    public static void a(f r5) {
        Advanceable r10 = r5.getAdvanceable();
        if (r10 == null) goto L5;
        r10.advance();
    L5:
        r5.e();
    }

    public static boolean c(ViewGroup r5) {
        if ((r5 instanceof AdapterView) == false) goto L5;
        return true;
    L5:
        int r10 = 0;
    L7:
        if (r10 >= r5.getChildCount()) goto L14;
        View r11 = r5.getChildAt(r10);
        if ((r11 instanceof ViewGroup) == false) goto L13;
        if (c((ViewGroup) r11) == false) goto L13;
        return true;
    L13:
        r10 = r10 + 1;
        goto L7
    L14:
        return false;
    }

    private Advanceable getAdvanceable() {
        AppWidgetProviderInfo r5 = getAppWidgetInfo();
        if (r5 == null) goto L13;
        int r10 = r5.autoAdvanceViewId;
        if (r10 != (-1)) goto L7;
        return null;
    L7:
        if (this.f17236i == false) goto L16;
        KeyEvent.Callback r11 = findViewById(r10);
        if ((r11 instanceof Advanceable) == true) goto L12;
        return null;
    L12:
        return (Advanceable) r11;
    L16:
        return null;
    L13:
        return null;
    }

    public final void b() {
        Advanceable r5 = getAdvanceable();
        boolean r10 = false;
        if (r5 == null) goto L5;
        r5.fyiWillBeAdvancedByHostKThx();
        boolean r11 = true;
    L6:
        SparseBooleanArray r12 = f17234u;
        if (r12.indexOfKey(getAppWidgetId()) < 0) goto L9;
        r10 = true;
    L9:
        if (r11 == r10) goto L15;
        if (r11 == false) goto L12;
        r12.put(getAppWidgetId(), true);
    L13:
        d();
        return;
    L12:
        r12.delete(getAppWidgetId());
        goto L13
    L15:
        return;
    L5:
        r11 = false;
        goto L6
    }

    @Override // android.view.View
    public final void cancelLongPress() {
        super.cancelLongPress();
        this.g.a();
    }

    public final void d() {
        Handler r5 = getHandler();
        if (getWindowVisibility() != 0) goto L8;
        if (r5 == null) goto L8;
        if (f17234u.indexOfKey(getAppWidgetId()) < 0) goto L8;
        boolean r10 = true;
    L10:
        if (r10 == this.f17237j) goto L16;
        this.f17237j = r10;
        if (this.f17238k != null) goto L14;
        this.f17238k = new e(this, 0);
    L14:
        r5.removeCallbacks(this.f17238k);
        e();
        return;
    L16:
        return;
    L8:
        r10 = false;
        goto L10
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r5) {
        if (r5.getAction() != 2) goto L15;
        float r10 = r5.getRawX() - this.f17243p;
        float r11 = r5.getRawY() - this.f17244q;
        if (Math.abs(r11) <= 20.0f) goto L7;
    L8:
        this.g.a();
        if (Math.abs(r10) <= Math.abs(r11)) goto L15;
        if (this.f17235h == false) goto L15;
        this.f17241n.requestDisallowInterceptTouchEvent(false);
        return false;
    L7:
        if (Math.abs(r10) > 20.0f) goto L8;
    L15:
        return super.dispatchTouchEvent(r5);
    }

    public final void e() {
        if (this.f17237j == true) goto L5;
        return;
    L5:
        long r5 = SystemClock.uptimeMillis();
        long r10 = (20000 - (r5 % 20000)) + r5;
        long r11 = (((long) f17234u.indexOfKey(getAppWidgetId())) * 250) + r10;
        Handler r12 = getHandler();
        if (r12 == null) goto L9;
        r12.postAtTime(this.f17238k, r11);
        return;
    }

    public final void f(View r10) {
        if (r10 != null) goto L5;
    L13:
        StringBuilder r5 = new StringBuilder("update widget size fail, view is null: ");
        if (r10 != null) goto L16;
        boolean r11 = true;
    L17:
        r5.append(r11);
        String r12 = r5.toString();
        Intrinsics.checkNotNullParameter("FlowAppWidgetHostView", "tag");
        Intrinsics.checkNotNullParameter(r12, "msg");
        org.koin.core.a r13 = su.a.f22013b;
        if (r13 == null) goto L22;
        ((ju.b) r13.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("FlowAppWidgetHostView", r12);
        return;
    L22:
        throw new IllegalStateException("KoinApplication has not been started");
    L16:
        r11 = false;
        goto L17
    L5:
        if (r10.getLayoutParams() == null) goto L13;
        int r14 = getMeasuredWidth();
        int r15 = r10.getLayoutParams().width;
        int r16 = r10.getLayoutParams().height;
        if (r15 <= 0) goto L10;
        int r17 = (int) (((r14 * 1.0f) * r16) / r15);
    L11:
        StringBuilder r18 = j0.v("prepareView: widthTarget = ", r14, r17, ", heightTarget = ", ", measuredWidth = ");
        r18.append(r14);
        Log.i("FlowAppWidgetHostView", r18.toString());
        r10.getLayoutParams().height = r17;
        r10.getLayoutParams().width = r14;
        return;
    L10:
        r17 = (int) (((r14 * 1.0f) * getAppWidgetInfo().minHeight) / getAppWidgetInfo().minWidth);
        goto L11
    }

    @Override // android.appwidget.AppWidgetHostView
    public AppWidgetProviderInfo getAppWidgetInfo() {
        AppWidgetProviderInfo r5 = super.getAppWidgetInfo();
        if (r5 != null) goto L5;
    L9:
        return r5;
    L5:
        if ((r5 instanceof FlowAppWidgetProviderInfo) == true) goto L9;
        throw new IllegalStateException("Launcher widget must have LauncherAppWidgetProviderInfo");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        boolean r5 = true;
        this.f17236i = true;
        b();
        if (this.f17242o != null) goto L6;
        return;
    L6:
        if (((CircleClockView) findViewById(R$id.circle_clock_1)) == null) goto L9;
        com.obric.clockwidgets.ui.g r10 = new com.obric.clockwidgets.ui.g(getContext(), getAppWidgetId(), this, WidgetViewBinder$Type.CircleLarge);
        this.f17245r = r10;
        r10.a();
    L9:
        if (((SquareClockView) findViewById(R$id.square_clock_analog)) == null) goto L12;
        com.obric.clockwidgets.ui.g r11 = new com.obric.clockwidgets.ui.g(getContext(), getAppWidgetId(), this, WidgetViewBinder$Type.SquareLarge);
        this.f17245r = r11;
        r11.a();
    L12:
        if (findViewById(R$id.widget_real_content) == null) goto L21;
        Context r12 = getContext();
        getAppWidgetId();
        com.obric.clockwidgets.ui.d r13 = new com.obric.clockwidgets.ui.d(r12, this);
        this.s = r13;
        ConcurrentHashMap r14 = com.obric.clockwidgets.c.f11255a;
        Intrinsics.checkNotNullParameter(r13, "listener");
        com.obric.clockwidgets.c.f11256b.add(new WeakReference(r13));
        Intrinsics.checkNotNullParameter(r12, "context");
        r12.getPackageManager().getApplicationInfo("com.obric.clock", 0);     // Catch: Exception -> L16
    L17:
        r13.a(r5);
        return;
    L16:
        Log.e("WidgetInstallHelper", "isClockInstalled: ");
        r5 = false;
        goto L17
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f17236i = false;
        b();
        com.obric.clockwidgets.ui.g r5 = this.f17245r;
        if (r5 == null) goto L5;
        com.obric.clockwidgets.c.d(r5.f11309b, r5);
    L5:
        com.obric.clockwidgets.ui.d r10 = this.s;
        if (r10 == null) goto L9;
        r10.getClass();
        com.obric.clockwidgets.c.c(r10);
        return;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r5) {
        super.onInitializeAccessibilityNodeInfo(r5);
        r5.setClassName(f.class.getName());
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r10) {
        if (r10.getAction() != 0) goto L12;
        this.f17243p = (int) r10.getRawX();
        this.f17244q = (int) r10.getRawY();
        RecyclerView r5 = this.f17241n;
        if (r5 == null) goto L12;
        if (this.f17235h == false) goto L9;
        r5.requestDisallowInterceptTouchEvent(true);
    L9:
        ViewParent r11 = this.f17241n;
        if ((r11 instanceof g) == false) goto L12;
        ((g) r11).setTouchCompleteListener(this);
    L12:
        hu.a r12 = this.g;
        r12.b(r10);
        if (r10.getAction() != 1) goto L32;
        if (r12.d == true) goto L32;
        if (getAppWidgetInfo() == null) goto L32;
        if (getAppWidgetInfo().provider == null) goto L32;
        obric.flow.thermal.a r13 = kn.e.f();
        String r14 = getAppWidgetInfo().provider.getPackageName();
        if (r14 == null) goto L28;
        if (r13.f20541c < 5) goto L32;
        if (r13.g.contains(r14) == true) goto L32;
    L29:
        kn.e.f().b(getContext());
        return true;
    L28:
        if (r13.f20541c >= 5) goto L29;
    L32:
        return r12.d;
    }

    @Override // gu.b, android.appwidget.AppWidgetHostView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
        this.f17235h = c(this);
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r5) {
        if (this.f17235h == false) goto L7;
        RecyclerView r10 = this.f17241n;
        if (r10 == null) goto L7;
        r10.requestDisallowInterceptTouchEvent(false);
    L7:
        r5.performLongClick();
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r5, int r10) {
        super.onMeasure(r5, View.MeasureSpec.makeMeasureSpec((int) (((View.MeasureSpec.getSize(r5) * getAppWidgetInfo().minHeight) * 1.0f) / getAppWidgetInfo().minWidth), BasicMeasure.EXACTLY));
    }

    @Override // android.view.View
    public final void onSizeChanged(int r5, int r10, int r11, int r12) {
        if (r11 != r5) goto L4;
    L6:
        super.onSizeChanged(r5, r10, r11, r12);
        return;
    L4:
        if (this.f17246t == null) goto L6;
        StringBuilder r13 = j0.v("onSizeChanged: w = ", r5, r10, ", h = ", ", oldw = ");
        r13.append(r11);
        r13.append(", oldh = ");
        r13.append(r12);
        Log.i("FlowAppWidgetHostView", r13.toString());
        f(this.f17246t);
        this.f17246t.post(new e(this, 1));
        goto L6
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r5) {
        this.g.b(r5);
        return true;
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r5) {
        super.onWindowVisibilityChanged(r5);
        d();
    }

    @Override // android.appwidget.AppWidgetHostView
    public final void prepareView(View r5) {
        this.f17246t = r5;
        if (getMeasuredWidth() > 0) goto L5;
        post(new a2.b(23, this, r5));
    L6:
        super.prepareView(r5);
        return;
    L5:
        f(r5);
        goto L6
    }

    @Override // android.appwidget.AppWidgetHostView
    public final void setAppWidget(int r5, AppWidgetProviderInfo r10) {
        super.setAppWidget(r5, r10);
        setPadding(0, 0, 0, 0);
        if (this.f17239l == true) goto L5;
        this.f17239l = true;
        Trace.beginAsyncSection("appwidget load-widget " + r10.provider, r5);
        Log.i("FlowAppWidgetHostView", "App widget created with id: " + r5);
    L5:
        ComponentName r11 = getAppWidgetInfo().provider;
        Map r12 = i.f17250a;
        Intrinsics.checkNotNullParameter(r11, "componentName");
        c r13 = (c) i.f17250a.get(r11);
        if (r13 == null) goto L10;
        removeAllViews();
        Context r14 = getContext();
        Intrinsics.checkNotNullParameter(r14, "context");
        Intrinsics.checkNotNullParameter(r13, "layout");
        View r15 = LayoutInflater.from(r14).inflate(r13.f17227a, null, false);
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type android.view.ViewGroup");
        this.f17242o = (ViewGroup) r15;
        this.f17240m = getContext().getText(r13.f17228b.intValue()).toString();
        FrameLayout.LayoutParams r16 = new FrameLayout.LayoutParams(-1, -1);
        r16.gravity = 17;
        addView(this.f17242o, r16);
        return;
    }

    @Override // android.appwidget.AppWidgetHostView
    @RequiresApi(api = 31)
    public void setColorResources(@Nullable SparseIntArray r5) {
        if (r5 != null) goto L4;
        resetColorResources();
        return;
    L4:
        super.setColorResources(r5);
    }

    public void setListener(a r5) {
    }

    @Override // android.appwidget.AppWidgetHostView
    public final void updateAppWidget(RemoteViews r5) {
        if (this.f17242o == null) goto L7;
        Log.i("FlowAppWidgetHostView", "updateAppWidget customView return");
        return;
    L7:
        if (this.f17239l == false) goto L11;
        if (r5 == null) goto L11;
        Log.i("FlowAppWidgetHostView", "App widget with id: " + getAppWidgetId() + " loaded");
        StringBuilder r10 = new StringBuilder("appwidget load-widget ");
        r10.append(getAppWidgetInfo().provider);
        Trace.endAsyncSection(r10.toString(), getAppWidgetId());
        this.f17239l = false;
    L11:
        if (SystemClock.uptimeMillis() >= 0) goto L13;
        return;
    L13:
        super.updateAppWidget(r5);
        hu.b.f17473b.f17474a.postDelayed(new e(this, 2), 1000);
        b();
    }
}
