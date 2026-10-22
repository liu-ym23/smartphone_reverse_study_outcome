package com.lynx.clay.embedding.android;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.DisplayCutout;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.widget.NestedScrollView;
import androidx.viewpager.widget.ViewPager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.clay.embedding.engine.FlutterEngine;
import com.lynx.clay.embedding.engine.FlutterJNI;
import com.lynx.clay.embedding.engine.accessibility.ClayAccessibilityBridge;
import com.lynx.clay.embedding.engine.plugins.ClayPluginContext;
import com.lynx.clay.embedding.engine.renderer.FlutterRenderer;
import com.lynx.clay.plugin.platform.PlatformViewsController;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class FlutterView extends FrameLayout implements NestedScrollingChild2 {
    public static final /* synthetic */ int O = 0;
    public AccessibilityManager A;
    public com.lynx.clay.embedding.android.g B;
    public NestedScrollingChildHelper C;
    public final FlutterRenderer.ViewportMetrics D;
    public final d E;
    public boolean F;
    public boolean G;
    public boolean H;
    public int I;
    public boolean J;
    public int K;
    public int L;
    public int M;
    public final e N;
    public FlutterSurfaceView a;
    public final FlutterTextureView b;
    public FlutterFunctorView c;
    public final FlutterDelegateView d;
    public FlutterImageView e;
    public SurfaceSnapshotController f;
    public s5a.c g;
    public final RenderMode h;
    public final Set<s5a.b> i;
    public boolean j;
    public final a k;
    public boolean l;
    public final b m;
    public final n5a.b n;
    public n5a.i o;
    public DisplayMetrics p;
    public g q;
    public FlutterEngine r;
    public final Set<f> s;
    public u5a.b t;
    public boolean u;
    public boolean v;
    public com.lynx.clay.embedding.android.a w;
    public com.lynx.clay.embedding.android.b x;
    public GestureMediator y;
    public ClayAccessibilityBridge z;

    public static final enum TransparencyMode extends Enum<TransparencyMode> {
        public static final /* synthetic */ TransparencyMode[] a = null;
        public static final TransparencyMode opaque = null;
        public static final TransparencyMode transparent = null;

        static {
            TransparencyMode r0 = new TransparencyMode("opaque", 0);
            opaque = r0;
            TransparencyMode r1 = new TransparencyMode("transparent", 1);
            transparent = r1;
            a = new TransparencyMode[]{r0, r1};
        }

        public static TransparencyMode[] values() {
            return (TransparencyMode[]) a.clone();
        }

        public static TransparencyMode valueOf(String r1) {
            return (TransparencyMode) r27.a.a(TransparencyMode.class, r1);
        }

        public TransparencyMode(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final enum ZeroSides extends Enum<ZeroSides> {
        public static final ZeroSides BOTH = null;
        public static final ZeroSides LEFT = null;
        public static final ZeroSides NONE = null;
        public static final ZeroSides RIGHT = null;
        public static final /* synthetic */ ZeroSides[] a = null;

        static {
            ZeroSides r0 = new ZeroSides("NONE", 0);
            NONE = r0;
            ZeroSides r1 = new ZeroSides("LEFT", 1);
            LEFT = r1;
            ZeroSides r3 = new ZeroSides("RIGHT", 2);
            RIGHT = r3;
            ZeroSides r5 = new ZeroSides("BOTH", 3);
            BOTH = r5;
            a = new ZeroSides[]{r0, r1, r3, r5};
        }

        public static ZeroSides[] values() {
            return (ZeroSides[]) a.clone();
        }

        public static ZeroSides valueOf(String r1) {
            return (ZeroSides) r27.a.a(ZeroSides.class, r1);
        }

        public ZeroSides(String r1, int r2) {
            super(r1, r2);
        }
    }

    public class a implements Runnable {
        public final /* synthetic */ FlutterView a;

        @Override // java.lang.Runnable
        public final void run() {
            FlutterView r0 = this.a;     // Catch: Throwable -> L8
            if (r0.a != null) goto L5;
            return;
        L5:
            if (r0.i() == false) goto L15;
            this.a.j();     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }

        public a(FlutterView r1) {
            this.a = r1;
        }
    }

    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ FlutterView a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            FlutterView r0 = this.a;
            int r1 = FlutterView.O;
            r0.l();
        }

        public b(FlutterView r1) {
            this.a = r1;
        }
    }

    public class c {
        public c() {
        }
    }

    public class d implements s5a.b {
        public final /* synthetic */ FlutterView a;

        @Override // s5a.b
        public final void a() {
            FlutterView r0 = this.a;
            r0.j = false;
            Iterator<s5a.b> r1 = r0.i.iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            r1.next().a();
            goto L4
        }

        @Override // s5a.b
        public final void b() {
            FlutterView r0 = this.a;
            r0.j = true;
            Iterator r1 = ((HashSet) r0.i).iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            ((s5a.b) r1.next()).b();
            goto L4
        }

        public d(FlutterView r1) {
            this.a = r1;
        }
    }

    public class e implements s5a.a {
        public final /* synthetic */ FlutterView a;

        public e(FlutterView r1) {
            this.a = r1;
        }

        @Override // s5a.a
        public final void a(int r10, int r11) {
            FlutterView r0 = this.a;
            int r1 = r0.M;
            if (r1 == r10) goto L5;
        L7:
            int r2 = r0.L;
            boolean r3 = r0.F;
            boolean r4 = r0.H;
            int r5 = r0.I;
            boolean r7 = true;
            if (r3 == true) goto L26;
            if (r4 == false) goto L14;
            if (r1 == (-1)) goto L13;
            if (r1 <= r5) goto L14;
        L13:
            int r6 = r5;
        L17:
            if (r4 == false) goto L21;
            if (r10 == (-1)) goto L24;
            if (r10 <= r5) goto L21;
        L24:
            if (r6 == r5) goto L26;
            boolean r8 = true;
        L27:
            if (r8 == true) goto L57;
            boolean r9 = r0.G;
            boolean r12 = r0.J;
            int r13 = r0.K;
            if (r9 == true) goto L47;
            if (r12 == false) goto L35;
            if (r2 == (-1)) goto L34;
            if (r2 <= r13) goto L35;
        L34:
            int r14 = r13;
        L38:
            if (r12 == false) goto L42;
            if (r11 == (-1)) goto L45;
            if (r11 <= r13) goto L42;
        L45:
            if (r14 == r13) goto L47;
            boolean r15 = true;
        L48:
            if (r15 == true) goto L57;
            if (r1 != r10) goto L51;
        L52:
            if (r2 != r11) goto L54;
        L56:
            r7 = false;
            goto L57
        L54:
            if (r0.getMeasuredHeight() == r11) goto L56;
        L51:
            if (r0.getMeasuredWidth() != r10) goto L57;
        L42:
            if (r11 != (-1)) goto L44;
            r13 = 0;
            goto L45
        L44:
            r13 = r11;
        L35:
            if (r2 != (-1)) goto L37;
            r14 = 0;
            goto L38
        L37:
            r14 = r2;
        L47:
            r15 = false;
        L57:
            FlutterView r16 = this.a;
            r16.M = r10;
            r16.L = r11;
            if (r7 == false) goto L61;
            r16.requestLayout();
            return;
        L61:
            return;
        L21:
            if (r10 != (-1)) goto L23;
            r5 = 0;
            goto L24
        L23:
            r5 = r10;
        L14:
            if (r1 != (-1)) goto L16;
            r6 = 0;
            goto L17
        L16:
            r6 = r1;
        L26:
            r8 = false;
            goto L27
        L5:
            if (r0.L != r11) goto L7;
        }
    }

    public interface f {
        void a();

        void b();
    }

    public interface g {
    }

    private AccessibilityManager getAccessibilityManager() {
        if (this.A != null) goto L14;
        Context r0 = getContext();
        if (r0 == null) goto L7;
        Context r2 = r0.getApplicationContext();
    L8:
        if (r2 == null) goto L10;
        r0 = r2;
    L10:
        if (r0 != null) goto L12;
        return null;
    L12:
        this.A = (AccessibilityManager) r0.getSystemService("accessibility");
        goto L14
    L7:
        r2 = null;
    L14:
        return this.A;
    }

    public final com.lynx.clay.embedding.android.a c() {
        if (this.w != null) goto L6;
        this.w = new com.lynx.clay.embedding.android.a(this, this.r.b, f());
    L6:
        return this.w;
    }

    public final com.lynx.clay.embedding.android.b d() {
        if (this.x != null) goto L6;
        this.x = new com.lynx.clay.embedding.android.b(this.r.b, false);
    L6:
        return this.x;
    }

    public final ClayAccessibilityBridge e() {
        if (this.z != null) goto L11;
        com.lynx.clay.embedding.engine.accessibility.a r1 = this.r.e;
        this.z = new ClayAccessibilityBridge();
        AccessibilityManager r0 = this.A;
        if (r0 == null) goto L9;
        com.lynx.clay.embedding.android.g r2 = this.B;
        if (r2 == null) goto L9;
        r0.removeAccessibilityStateChangeListener(r2);
    L9:
        this.B = null;
    L11:
        return this.z;
    }

    public final u5a.b f() {
        FlutterEngine r0 = this.r;
        if (r0 == null) goto L27;
        FlutterRenderer r1 = r0.b;
        if (r1 == null) goto L25;
        if (this.t != null) goto L9;
        this.t = new u5a.b(this, r1);
    L9:
        FlutterEngine r2 = this.r;
        if (r2 == null) goto L23;
        if (this.t == null) goto L23;
        if (this.u == false) goto L23;
        if (this.v == true) goto L23;
        if (r2.f == null) goto L23;
        this.v = true;
    L23:
        return this.t;
    L25:
        throw new IllegalStateException("Cannot initialize TextInputPlugin: flutterEngine renderer is null.");
    L27:
        throw new IllegalStateException("Cannot initialize TextInputPlugin: flutterEngine is null.");
    }

    public final void h() {
        ViewGroup.LayoutParams r0 = new FrameLayout.LayoutParams(-1, -1);
        FlutterSurfaceView r1 = this.a;
        if (r1 != null) goto L5;
        View r2 = this.b;
        if (r2 == null) goto L18;
        addView(r2, r0);
        String r3 = "TextureView";
    L26:
        if (c5a.a.a.booleanValue() == false) goto L32;
        TextView r4 = new TextView(getContext());
        r4.setTextColor(-65536);
        if (c5a.a.b.booleanValue() == false) goto L30;
        String r5 = " + Skity";
    L31:
        r4.setText(r3.concat(r5));
        addView(r4, new LinearLayout.LayoutParams(-2, -2));
        goto L32
    L30:
        r5 = " + Skia";
    L32:
        setFocusable(true);
        setFocusableInTouchMode(true);
        if (Build.VERSION.SDK_INT < 26) goto L35;
        setImportantForAutofill(4);
    L35:
        this.D.fontScale = getResources().getConfiguration().fontScale;
        FlutterRenderer.ViewportMetrics r6 = this.D;
        if ((getResources().getConfiguration().uiMode & 48) != 32) goto L38;
        boolean r7 = true;
    L39:
        r6.nightMode = r7;
        this.C = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        setWillNotDraw(false);
        return;
    L38:
        r7 = false;
        goto L39
    L18:
        View r8 = this.c;
        if (r8 == null) goto L21;
        addView(r8, r0);
        r3 = "FunctorView";
        goto L26
    L21:
        View r9 = this.d;
        if (r9 == null) goto L24;
        addView(r9, r0);
        r3 = "DelegateView";
        goto L26
    L24:
        addView(this.e, r0);
        r3 = "ImageView";
        goto L26
    L5:
        if ((!r1.a) == false) goto L11;
        SurfaceSnapshotController r10 = new SurfaceSnapshotController(this);
        this.f = r10;
        FlutterSurfaceView r11 = this.a;
        FlutterSurfaceView r12 = r10.b;
        if (r12 == null) goto L10;
        if (r12 == r11) goto L10;
        r12.setSurfaceSnapshotDelegate(null);
        r10.c();
    L10:
        r10.b = r11;
        r11.setSurfaceSnapshotDelegate(r10);
    L11:
        addView(this.a, r0);
        SurfaceSnapshotController r13 = this.f;
        if (r13 == null) goto L14;
        r13.d();
    L14:
        r3 = "SurfaceView";
        goto L26
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return this.C.hasNestedScrollingParent();
    }

    public final boolean i() {
        FlutterEngine r0 = this.r;
        if (r0 == null) goto L9;
        s5a.c r1 = this.g;
        if (r1 == null) goto L9;
        if (r0.b != r1.getAttachedRenderer()) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return this.C.isNestedScrollingEnabled();
    }

    public final void l() {
        SurfaceSnapshotController r0 = this.f;
        int r1 = 0;
        if (r0 == null) goto L17;
        boolean r2 = isShown();
        if (r0.h == r2) goto L31;
        r0.h = r2;
        if (r0.b == null) goto L32;
        if (r2 == true) goto L13;
        r0.m();
        return;
    L13:
        if (r0.j() == false) goto L15;
        r0.n();
        return;
    L15:
        r0.e();
        r0.b.setVisibility(0);
        return;
    L32:
        return;
    L31:
        return;
    L17:
        if (this.a == null) goto L29;
        boolean r3 = isShown();
        if (this.l == r3) goto L30;
        this.l = r3;
        FlutterSurfaceView r4 = this.a;
        if (r3 == true) goto L24;
        r1 = 4;
    L24:
        r4.setVisibility(r1);
        return;
    L30:
        return;
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        this.C.stopNestedScroll();
    }

    public final void b() {
        if (i() == true) goto L5;
        return;
    L5:
        removeCallbacks(this.k);
        SurfaceSnapshotController r0 = this.f;
        if (r0 == null) goto L8;
        r0.c();
    L8:
        Iterator r1 = ((HashSet) this.s).iterator();
    L10:
        if (r1.hasNext() == false) goto L13;
        ((f) r1.next()).a();
        goto L10
    L13:
        if (this.v == false) goto L15;
        this.r.f.getClass();
        this.v = false;
    L15:
        PlatformViewsController r2 = this.r.f;
        int r3 = 0;
    L17:
        if (r3 >= r2.g.size()) goto L19;
        e5a.a r4 = r2.g.valueAt(r3);
        r2.c.removeView(r4);
        r3 = r3 + 1;
        goto L17
    L19:
        r2.c = null;
        r2.h = false;
        this.u = false;
        FlutterEngine r5 = this.r;
        r5.f.b = null;
        com.lynx.clay.embedding.engine.a r6 = r5.d;
        Iterator r7 = ((HashMap) r6.a).keySet().iterator();
    L21:
        if (r7.hasNext() == false) goto L25;
        Class r8 = (Class) r7.next();
        f5a.a r9 = (f5a.a) ((HashMap) r6.a).get(r8);
        if (r9 == null) goto L21;
        r9.c();
        goto L21
    L25:
        ClayPluginContext r10 = this.r.c;
        if (r10.a == null) goto L28;
        boolean r11 = true;
    L29:
        if (r11 == true) goto L31;
        c5a.c.d(5, "ClayPluginContext", "already detached from flutter view");
    L32:
        AccessibilityManager r12 = this.A;
        if (r12 == null) goto L37;
        com.lynx.clay.embedding.android.g r13 = this.B;
        if (r13 == null) goto L37;
        r12.removeAccessibilityStateChangeListener(r13);
    L37:
        this.B = null;
        if (this.z == null) goto L40;
        this.z = null;
    L40:
        com.lynx.clay.embedding.android.a r14 = this.w;
        if (r14 == null) goto L43;
        r14.a.a.setEventResponseHandler(null);
        r14.a = null;
        com.lynx.clay.embedding.android.a.C0033a r15 = r14.d;
        r15.b = null;
        r15.c = null;
        r14.d = null;
        r14.b.b.a.setInputMethodHandler(null);
        r14.b = null;
        this.w = null;
        this.t = null;
    L46:
        FlutterRenderer r16 = this.r.b;
        this.j = false;
        d r17 = this.E;
        r16.a.removeIsDisplayingFlutterUiListener(r17);
        e r18 = this.N;
        r16.a.removeRootContentSizeListener(r18);
        this.M = -1;
        this.L = -1;
        this.F = false;
        this.G = false;
        this.H = false;
        this.J = false;
        this.I = 0;
        this.K = 0;
        r16.b(false);
        r16.a.setClaySemanticsEnabled(false);
        this.g.b();
        this.g = null;
        this.e = null;
        this.r = null;
        this.y = null;
        this.x = null;
        this.t = null;
        return;
    L43:
        u5a.b r19 = this.t;
        if (r19 == null) goto L46;
        r19.b.a.setInputMethodHandler(null);
        this.t = null;
        goto L46
    L31:
        r10.a = null;
        goto L32
    L28:
        r11 = false;
        goto L29
    }

    @Override // android.view.View
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        if (i() == true) goto L5;
        return null;
    L5:
        if (this.z != null) goto L14;
        AccessibilityManager r0 = getAccessibilityManager();
        if (r0 != null) goto L9;
    L11:
        boolean r1 = false;
    L12:
        if (r1 == true) goto L14;
        return null;
    L9:
        if (r0.isEnabled() == false) goto L11;
        r1 = true;
    L14:
        e().getClass();
        return null;
    }

    public com.lynx.clay.embedding.android.a getAndroidKeyProcessor() {
        if (i() == false) goto L6;
        return c();
    L6:
        return this.w;
    }

    public com.lynx.clay.embedding.android.b getAndroidTouchProcessor() {
        if (i() == false) goto L6;
        return d();
    L6:
        return this.x;
    }

    public final void j() {
        if (i() == true) goto L5;
        return;
    L5:
        DisplayMetrics r0 = this.p;
        if (r0 != null) goto L9;
        Resources r1 = getResources();
        r0 = WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    L9:
        FlutterRenderer.ViewportMetrics r2 = this.D;
        r2.screenWidth = r0.widthPixels;
        r2.screenHeight = r0.heightPixels;
        r2.devicePixelRatio = r0.density;
        r2.densityDpi = r0.densityDpi;
        FlutterRenderer r3 = this.r.b;
        r3.getClass();
        c5a.c.e();
        r3.a.setViewportMetrics(r2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this.m);
        l();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.m);
        l();
    }

    public FlutterEngine getAttachedFlutterEngine() {
        return this.r;
    }

    public n5a.i getExternalPlatformViewContext() {
        return this.o;
    }

    public n5a.i getInternalPlatformViewContext() {
        return this.n;
    }

    public g getKeyboardEventStartCallback() {
        return this.q;
    }

    public FlutterView(Context r3) {
        this(r3, null, new FlutterSurfaceView(r3));
    }

    public final void a(FlutterEngine r8) {
        if (i() == true) goto L5;
    L8:
        this.M = -1;
        this.L = -1;
        boolean r0 = false;
        this.F = false;
        this.G = false;
        this.H = false;
        this.J = false;
        this.I = 0;
        this.K = 0;
        this.r = r8;
        r8.h = this.h;
        FlutterRenderer r1 = r8.b;
        this.j = r1.d;
        this.g.a(r1);
        d r2 = this.E;
        r1.a.addIsDisplayingFlutterUiListener(r2);
        if (r1.d == false) goto L11;
        r2.b();
    L11:
        e r3 = this.N;
        r1.a.addRootContentSizeListener(r3);
        if (this.z != null) goto L24;
        AccessibilityManager r4 = getAccessibilityManager();
        if (r4 == null) goto L24;
        if (r4.isEnabled() == false) goto L21;
        e();
        goto L24
    L21:
        if (this.B != null) goto L24;
        com.lynx.clay.embedding.android.g r5 = new com.lynx.clay.embedding.android.g(this);
        this.B = r5;
        r4.addAccessibilityStateChangeListener(r5);
    L24:
        PlatformViewsController r6 = r8.f;
        FlutterRenderer r7 = this.r.b;
        r6.getClass();
        r6.a = new com.lynx.clay.embedding.android.b(r7, true);
        j();
        PlatformViewsController r9 = r8.f;
        Context r10 = getContext();
        if (r9.b != null) goto L63;
        r9.b = r10;
        PlatformViewsController r11 = r8.f;
        r11.c = this;
        int r12 = 0;
    L28:
        if (r12 >= r11.g.size()) goto L35;
        int r13 = r11.g.keyAt(r12);
        e5a.a r14 = r11.g.valueAt(r12);
        View r15 = r11.d.get(r13);
        if (r15 != null) goto L32;
    L33:
        r11.c.addView(r14);
    L34:
        r12 = r12 + 1;
        goto L28
    L32:
        if (r15.willNotDraw() == true) goto L34;
    L35:
        this.u = true;
        u5a.b r16 = f();
        if (hasFocus() == true) goto L38;
    L42:
        com.lynx.clay.embedding.engine.a r17 = r8.d;
        Iterator r18 = ((HashMap) r17.a).keySet().iterator();
    L44:
        if (r18.hasNext() == false) goto L48;
        Class r19 = (Class) r18.next();
        f5a.a r20 = (f5a.a) ((HashMap) r17.a).get(r19);
        if (r20 == null) goto L44;
        r20.b();
        goto L44
    L48:
        ClayPluginContext r21 = r8.c;
        if (r21.a == null) goto L51;
        r0 = true;
    L51:
        if (r0 == false) goto L53;
        c5a.c.d(5, "ClayPluginContext", "already attached to flutter view");
    L54:
        Iterator r22 = ((HashSet) this.s).iterator();
    L56:
        if (r22.hasNext() == false) goto L59;
        ((f) r22.next()).b();
        goto L56
    L59:
        if (this.j == false) goto L73;
        this.E.b();
        return;
    L73:
        return;
    L53:
        r21.a = this;
        goto L54
    L38:
        if (getWindowToken() == null) goto L42;
        r16.getClass();
        InputMethodManager r23 = u5a.b.h;
        if (r23 == null) goto L42;
        r23.restartInput(this);
        goto L42
    L63:
        throw new AssertionError("A PlatformViewsController can only be attached to a single output target.\nattach was called while the PlatformViewsController was already attached.");
    L5:
        if (r8 != this.r) goto L7;
        return;
    L7:
        b();
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent r4) {
        if (r4.getAction() != 0) goto L8;
        if (r4.getRepeatCount() != 0) goto L8;
        getKeyDispatcherState().startTracking(r4, this);
    L11:
        if (r4.getKeyCode() == 97) goto L35;
        if (r4.getKeyCode() == 96) goto L35;
        if (r4.getKeyCode() == 99) goto L35;
        if (r4.getKeyCode() == 100) goto L35;
        if (r4.getKeyCode() == 109) goto L35;
        if (r4.getKeyCode() == 108) goto L35;
        if (r4.getKeyCode() == 160) goto L35;
        if (i() == false) goto L30;
        if (c().a(r4) == false) goto L30;
        return true;
    L30:
        if (super.dispatchKeyEvent(r4) == true) goto L37;
        return false;
    L37:
        return true;
    L35:
        return super.dispatchKeyEvent(r4);
    L8:
        if (r4.getAction() != 1) goto L11;
        getKeyDispatcherState().handleUpEvent(r4);
        goto L11
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r1) {
        return super.dispatchTouchEvent(r1);
    }

    @Override // android.view.View
    public final boolean fitSystemWindows(Rect r1) {
        return super.fitSystemWindows(r1);
    }

    public final int g(WindowInsets r8) {
        if (r8.getSystemWindowInsetBottom() >= (((double) getRootView().getHeight()) * 0.18d)) goto L7;
        return 0;
    L7:
        return r8.getSystemWindowInsetBottom();
    }

    public final boolean hasNestedScrollingParent(int r2) {
        return this.C.hasNestedScrollingParent(r2);
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets r12) {
        WindowInsets r0 = super.onApplyWindowInsets(r12);
        int r1 = Build.VERSION.SDK_INT;
        if (r1 != 29) goto L5;
        Insets r2 = r12.getSystemGestureInsets();
        FlutterRenderer.ViewportMetrics r3 = this.D;
        r3.systemGestureInsetTop = r2.top;
        r3.systemGestureInsetRight = r2.right;
        r3.systemGestureInsetBottom = r2.bottom;
        r3.systemGestureInsetLeft = r2.left;
    L5:
        int r4 = 0;
        if ((getWindowSystemUiVisibility() & 4) != 0) goto L8;
        boolean r5 = true;
    L10:
        if ((getWindowSystemUiVisibility() & 2) != 0) goto L12;
        boolean r6 = true;
    L14:
        if (r1 < 30) goto L22;
        if (r6 == false) goto L17;
        r4 = 0 | WindowInsets.Type.navigationBars();
    L17:
        if (r5 == false) goto L19;
        r4 = r4 | WindowInsets.Type.statusBars();
    L19:
        Insets r7 = r12.getInsets(r4);
        FlutterRenderer.ViewportMetrics r8 = this.D;
        r8.viewPaddingTop = r7.top;
        r8.viewPaddingRight = r7.right;
        r8.viewPaddingBottom = r7.bottom;
        r8.viewPaddingLeft = r7.left;
        Insets r9 = r12.getInsets(WindowInsets.Type.ime());
        FlutterRenderer.ViewportMetrics r10 = this.D;
        r10.viewInsetTop = r9.top;
        r10.viewInsetRight = r9.right;
        r10.viewInsetBottom = r9.bottom;
        r10.viewInsetLeft = r9.left;
        Insets r11 = r12.getInsets(WindowInsets.Type.systemGestures());
        FlutterRenderer.ViewportMetrics r13 = this.D;
        r13.systemGestureInsetTop = r11.top;
        r13.systemGestureInsetRight = r11.right;
        r13.systemGestureInsetBottom = r11.bottom;
        r13.systemGestureInsetLeft = r11.left;
        DisplayCutout r14 = r12.getDisplayCutout();
        if (r14 == null) goto L64;
        Insets r15 = r14.getWaterfallInsets();
        FlutterRenderer.ViewportMetrics r16 = this.D;
        r16.viewPaddingTop = Math.max(Math.max(r16.viewPaddingTop, r15.top), r14.getSafeInsetTop());
        FlutterRenderer.ViewportMetrics r17 = this.D;
        r17.viewPaddingRight = Math.max(Math.max(r17.viewPaddingRight, r15.right), r14.getSafeInsetRight());
        FlutterRenderer.ViewportMetrics r18 = this.D;
        r18.viewPaddingBottom = Math.max(Math.max(r18.viewPaddingBottom, r15.bottom), r14.getSafeInsetBottom());
        FlutterRenderer.ViewportMetrics r19 = this.D;
        r19.viewPaddingLeft = Math.max(Math.max(r19.viewPaddingLeft, r15.left), r14.getSafeInsetLeft());
    L64:
        if (c5a.a.a.booleanValue() == false) goto L66;
        FlutterRenderer.ViewportMetrics r110 = this.D;
        int r20 = r110.viewPaddingTop;
        int r21 = r110.viewPaddingLeft;
        int r22 = r110.viewPaddingRight;
        int r23 = r110.viewInsetBottom;
        int r24 = r110.viewInsetLeft;
        int r25 = r110.viewInsetRight;
        int r26 = r110.systemGestureInsetLeft;
        int r27 = r110.systemGestureInsetTop;
        int r111 = r110.systemGestureInsetRight;
        c5a.c.e();
    L66:
        j();
        return r0;
    L22:
        ZeroSides r28 = ZeroSides.NONE;
        if (r6 == true) goto L38;
        Context r29 = getContext();
        int r30 = r29.getResources().getConfiguration().orientation;
        int r31 = ((WindowManager) r29.getSystemService("window")).getDefaultDisplay().getRotation();
        if (r30 != 2) goto L38;
        if (r31 != 1) goto L30;
        ZeroSides r32 = ZeroSides.RIGHT;
    L28:
        r28 = r32;
        goto L38
    L30:
        if (r31 == 3) goto L32;
        if (r31 == 0) goto L37;
        if (r31 != 2) goto L38;
    L37:
        r32 = ZeroSides.BOTH;
        goto L28
    L32:
        if (r1 < 23) goto L34;
        r32 = ZeroSides.LEFT;
        goto L28
    L34:
        r32 = ZeroSides.RIGHT;
    L38:
        FlutterRenderer.ViewportMetrics r33 = this.D;
        if (r5 == false) goto L41;
        int r34 = r12.getSystemWindowInsetTop();
    L42:
        r33.viewPaddingTop = r34;
        FlutterRenderer.ViewportMetrics r35 = this.D;
        if (r28 != ZeroSides.RIGHT) goto L45;
    L48:
        int r36 = 0;
    L49:
        r35.viewPaddingRight = r36;
        FlutterRenderer.ViewportMetrics r37 = this.D;
        if (r6 == true) goto L52;
    L54:
        int r38 = 0;
    L55:
        r37.viewPaddingBottom = r38;
        FlutterRenderer.ViewportMetrics r39 = this.D;
        if (r28 != ZeroSides.LEFT) goto L58;
    L61:
        int r40 = 0;
    L62:
        r39.viewPaddingLeft = r40;
        FlutterRenderer.ViewportMetrics r41 = this.D;
        r41.viewInsetTop = 0;
        r41.viewInsetRight = 0;
        r41.viewInsetBottom = g(r12);
        this.D.viewInsetLeft = 0;
        goto L64
    L58:
        if (r28 == ZeroSides.BOTH) goto L61;
        r40 = r12.getSystemWindowInsetLeft();
        goto L62
    L52:
        if (g(r12) != 0) goto L54;
        r38 = r12.getSystemWindowInsetBottom();
        goto L55
    L45:
        if (r28 == ZeroSides.BOTH) goto L48;
        r36 = r12.getSystemWindowInsetRight();
        goto L49
    L41:
        r34 = 0;
        goto L42
    L12:
        r6 = false;
        goto L14
    L8:
        r5 = false;
        goto L10
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r6) {
        super.onConfigurationChanged(r6);
        float r7 = getResources().getConfiguration().fontScale;
        boolean r2 = true;
        boolean r3 = false;
        if ((getResources().getConfiguration().uiMode & 48) != 32) goto L5;
        boolean r0 = true;
    L6:
        FlutterRenderer.ViewportMetrics r1 = this.D;
        if (r1.fontScale == r7) goto L10;
        r1.fontScale = r7;
        r3 = true;
    L10:
        if (r1.nightMode == r0) goto L12;
        r1.nightMode = r0;
    L13:
        if (r2 == false) goto L16;
        j();
        return;
    L16:
        return;
    L12:
        r2 = r3;
        goto L13
    L5:
        r0 = false;
        goto L6
    }

    @Override // android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo r8) {
        if (i() == false) goto L5;
        c();
        u5a.b r0 = f();
        if (r0.g == true) goto L9;
        r0.e = null;
        return null;
    L9:
        int r1 = r0.c;
        int r2 = 4;
        if (r1 == 1) goto L21;
        if (r1 == 2) goto L20;
        if (r1 == 3) goto L19;
        if (r1 != 4) goto L15;
        int r3 = 33;
    L22:
        r8.inputType = r3;
        r8.imeOptions = 33554432;
        int r6 = r0.d;
        if (r6 == 1) goto L33;
        if (r6 == 2) goto L32;
        if (r6 != 3) goto L27;
    L34:
        r8.imeOptions = 33554432 | r2;
        u5a.a r9 = new u5a.a(this, r0.b, r0.f);
        r0.e = r9;
        return r9;
    L27:
        if (r6 == 4) goto L31;
        if (r6 == 5) goto L30;
        r2 = 0;
        goto L34
    L30:
        r2 = 6;
        goto L34
    L31:
        r2 = 5;
        goto L34
    L32:
        r2 = 3;
        goto L34
    L33:
        r2 = 2;
        goto L34
    L15:
        if (r0.d != 0) goto L17;
        r3 = 131073;
        goto L22
    L17:
        r3 = 1;
        goto L22
    L19:
        r3 = 17;
        goto L22
    L20:
        r3 = 3;
        goto L22
    L21:
        r3 = 2;
        goto L22
    L5:
        return super.onCreateInputConnection(r8);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r4) {
        super.onDraw(r4);
        if (r4.isHardwareAccelerated() == true) goto L17;
        FlutterEngine r0 = this.r;
        if (r0 != null) goto L8;
        return;
    L8:
        if (this.h != RenderMode.sync) goto L10;
        return;
    L10:
        FlutterJNI r1 = r0.a;
        if (r1 == null) goto L13;
        Bitmap r2 = r1.getBitmap();
    L14:
        if (r2 == null) goto L18;
        r4.drawBitmap(r2, 0.0f, 0.0f, null);
        return;
    L18:
        return;
    L13:
        r2 = null;
        goto L14
    }

    @Override // android.view.View
    public final boolean onGenericMotionEvent(MotionEvent r12) {
        boolean r1 = false;
        if (i() == false) goto L22;
        com.lynx.clay.embedding.android.b r0 = d();
        r0.getClass();
        boolean r3 = r12.isFromSource(2);
        if (r12.getActionMasked() != 7) goto L7;
    L10:
        boolean r4 = true;
    L11:
        if (r3 == false) goto L19;
        if (r4 == false) goto L19;
        int r7 = com.lynx.clay.embedding.android.b.b(r12.getActionMasked());
        ByteBuffer r10 = ByteBuffer.allocateDirect((r12.getPointerCount() * 37) * 8);
        r10.order(ByteOrder.LITTLE_ENDIAN);
        r0.a(r12, r12.getActionIndex(), r7, 0, com.lynx.clay.embedding.android.b.f, r10);
        if ((r10.position() % 296) != 0) goto L18;
        FlutterRenderer r2 = r0.a;
        int r5 = r10.position();
        r2.a.dispatchPointerDataPacket(r10, r5);
        boolean r6 = true;
    L20:
        if (r6 == false) goto L22;
        r1 = true;
        goto L22
    L18:
        throw new AssertionError("Packet position is not on field boundary.");
    L19:
        r6 = false;
        goto L20
    L7:
        if (r12.getActionMasked() == 8) goto L10;
        r4 = false;
    L22:
        if (r1 == false) goto L25;
        return true;
    L25:
        return super.onGenericMotionEvent(r12);
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent r3) {
        if (i() == true) goto L7;
        return super.onHoverEvent(r3);
    L7:
        if (this.z != null) goto L17;
        AccessibilityManager r0 = getAccessibilityManager();
        if (r0 != null) goto L11;
    L13:
        boolean r1 = false;
    L14:
        if (r1 == true) goto L17;
        return super.onHoverEvent(r3);
    L11:
        if (r0.isEnabled() == false) goto L13;
        r1 = true;
    L17:
        e().getClass();
        return false;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r20) {
        if (i() == false) goto L5;
        requestUnbufferedDispatch(r20);
        if (this.y != null) goto L9;
        this.y = new GestureMediator(this, this.r, d());
    L9:
        GestureMediator r2 = this.y;
        r2.getClass();
        MotionEvent r3 = MotionEvent.obtain(r20);
        if (r20.getActionMasked() != 0) goto L12;
        r2.n = 0;
        r2.o = 0;
    L12:
        r3.setLocation(Math.round(r20.getX() + r2.n), Math.round(r20.getY() + r2.o));
        int r4 = r20.getAction();
        if (r4 != 0) goto L15;
        r2.l = (int) r20.getX();
        r2.m = (int) r20.getY();
        VelocityTracker r5 = r2.d;
        if (r5 != null) goto L93;
        r2.d = VelocityTracker.obtain();
    L94:
        r2.d.addMovement(r20);
        r2.h = 0;
        r2.i = 0;
        ViewParent r6 = r2.a.getParent();
    L95:
        if (r6 == null) goto L109;
        if ((r6 instanceof ScrollView) == false) goto L100;
        r2.h |= 3;
    L108:
        r6 = r6.getParent();
        goto L95
    L100:
        if ((r6 instanceof HorizontalScrollView) == false) goto L103;
        r2.h |= 12;
        goto L108
    L103:
        if ((r6 instanceof NestedScrollView) == false) goto L106;
        r2.h |= 3;
        r2.i |= 3;
        goto L108
    L106:
        if ((r6 instanceof ViewPager) == false) goto L108;
        r2.h |= 12;
        goto L108
    L109:
        FlutterEngine r7 = r2.b;
        int r10 = r2.h;
        FlutterJNI r8 = r7.a;
        if (r8 == null) goto L112;
        r8.setOuterScrollableDirection(r10);
    L112:
        boolean r9 = false;
    L113:
        VelocityTracker r11 = r2.d;
        if (r11 == null) goto L117;
        r11.addMovement(r3);
    L117:
        if (r20.getAction() != 2) goto L123;
        GestureMediator.GestureMediateState r12 = r2.p;
        if (r12 != GestureMediator.GestureMediateState.BLOCKING_MEDIATING) goto L121;
    L122:
        r9 = true;
        goto L123
    L121:
        if (r12 == GestureMediator.GestureMediateState.OUTER_WIN) goto L122;
    L123:
        if (r9 == true) goto L153;
        boolean r13 = r2.c.d(r20, com.lynx.clay.embedding.android.b.f);
        FlutterJNI r14 = r2.b.a;
        if (r14 == null) goto L127;
        int r15 = r14.getHitTestResponsiveResult();
    L128:
        r2.g = r15 & 15;
        int r16 = (r15 >> 4) & 15;
        if ((r15 & 512) == 0) goto L131;
        boolean r17 = true;
    L133:
        if ((r15 & 2048) == 0) goto L135;
        boolean r18 = true;
    L136:
        if (r16 == 0) goto L138;
        boolean r19 = true;
    L139:
        r2.q = r19;
        if (r17 == true) goto L145;
        if (r18 == true) goto L145;
        if (r19 == true) goto L145;
        boolean r21 = false;
    L146:
        r2.e = r21;
        if (r16 != 5) goto L150;
        r2.j = 12;
    L155:
        if (r20.getAction() != 1) goto L157;
    L188:
        r2.a(GestureMediator.GestureMediateState.IDLE);
    L189:
        return r13;
    L157:
        if (r20.getAction() == 3) goto L188;
        if (r2.e == false) goto L162;
    L187:
        r2.a(GestureMediator.GestureMediateState.INNER_WIN);
        goto L189
    L162:
        if (r2.q == true) goto L187;
        if (r20.getAction() != 0) goto L189;
        int r1 = r2.h;
        if (r1 == 0) goto L186;
        int r22 = r2.g;
        if (r22 == 0) goto L186;
        if ((r1 & 3) == 0) goto L180;
        if ((r1 & 12) == 0) goto L180;
        if ((r22 & 3) != 0) goto L177;
    L178:
        r2.a(GestureMediator.GestureMediateState.BLOCKING_MEDIATING);
        goto L189
    L177:
        if ((r22 & 12) == 0) goto L178;
    L180:
        if ((r22 & r1) != 0) goto L182;
        r2.a(GestureMediator.GestureMediateState.MEDIATING);
        goto L189
    L182:
        if ((r1 & (~r2.i)) == 0) goto L184;
        r2.a(GestureMediator.GestureMediateState.BLOCKING_MEDIATING);
        goto L189
    L184:
        r2.a(GestureMediator.GestureMediateState.INNER_WIN);
    L186:
        r2.a(GestureMediator.GestureMediateState.IDLE);
        goto L189
    L150:
        if (r16 != 6) goto L152;
        r2.j = 3;
        goto L155
    L152:
        r2.j = 0;
    L145:
        r21 = true;
        goto L146
    L138:
        r19 = false;
        goto L139
    L135:
        r18 = false;
        goto L136
    L131:
        r17 = false;
        goto L133
    L127:
        r15 = 0;
        goto L128
    L153:
        r13 = true;
        goto L155
    L93:
        r5.clear();
        goto L94
    L15:
        if (r4 == 1) goto L77;
        if (r4 == 2) goto L23;
        if (r4 != 3) goto L112;
        VelocityTracker r23 = r2.d;
        if (r23 == null) goto L22;
        r23.recycle();
        r2.d = null;
    L22:
        r2.k = 0;
        r2.a.stopNestedScroll(0);
        goto L112
    L23:
        int r24 = (int) r20.getX();
        int r110 = (int) r20.getY();
        int r111 = r2.l - r24;
        int r112 = r2.m - r110;
        GestureMediator.GestureMediateState r113 = r2.p;
        GestureMediator.GestureMediateState r114 = GestureMediator.GestureMediateState.BLOCKING_MEDIATING;
        if (r113 != r114) goto L51;
        if (Math.abs(r111) > r2.f) goto L30;
        if (Math.abs(r112) <= r2.f) goto L51;
    L30:
        if (Math.abs(r111) <= Math.abs(r112)) goto L32;
        int r115 = 12;
    L34:
        if ((r2.i & r115) != 0) goto L36;
        if (r115 != 12) goto L43;
        if (r111 <= 0) goto L42;
        int r116 = 8;
    L47:
        if ((r116 & r2.g) == 0) goto L49;
        r2.a(GestureMediator.GestureMediateState.INNER_WIN);
        goto L51
    L49:
        r2.a(GestureMediator.GestureMediateState.OUTER_WIN);
        goto L51
    L42:
        r116 = 4;
        goto L47
    L43:
        if (r112 <= 0) goto L45;
        r116 = 2;
        goto L47
    L45:
        r116 = 1;
        goto L47
    L36:
        if ((r115 & r2.g) == 0) goto L38;
        r2.a(GestureMediator.GestureMediateState.INNER_WIN);
        goto L51
    L38:
        r2.a(GestureMediator.GestureMediateState.OUTER_WIN);
        goto L51
    L32:
        r115 = 3;
    L51:
        if (r2.p == r114) goto L53;
        r2.l = r24;
        r2.m = r110;
    L53:
        int r25 = r2.j;
        if (r25 == 0) goto L72;
        if (r25 != 12) goto L59;
        if (r111 <= 0) goto L58;
        int r117 = 8;
    L62:
        int r26 = r2.k;
        if (r26 == 0) goto L67;
        if (r26 == r117) goto L72;
        r2.k = 0;
        goto L72
    L67:
        if ((r2.h & r117) == 0) goto L72;
        if ((r2.g & r117) != 0) goto L72;
        r2.k = r117;
        r2.a.startNestedScroll(2, 0);
        goto L72
    L58:
        r117 = 4;
        goto L62
    L59:
        if (r112 <= 0) goto L61;
        r117 = 2;
        goto L62
    L61:
        r117 = 1;
    L72:
        if (r2.k == 0) goto L112;
        int[] r27 = new int[2];
        if (r2.a.dispatchNestedScroll(0, 0, r111, r112, r27, 0) == false) goto L76;
        int r118 = r2.l;
        int r119 = r27[0];
        r2.l = r118 - r119;
        int r120 = r2.m;
        int r121 = r27[1];
        r2.m = r120 - r121;
        r3.offsetLocation(r119, r121);
        r2.n += r27[0];
        r2.o += r27[1];
    L76:
        r9 = true;
        goto L113
    L77:
        r2.d.computeCurrentVelocity(1000, 10000.0f);
        int r28 = (int) r2.d.getYVelocity();
        if (r28 >= 0) goto L80;
        int r122 = 2;
    L82:
        if (r122 == r2.k) goto L84;
    L86:
        VelocityTracker r29 = r2.d;
        if (r29 == null) goto L89;
        r29.recycle();
        r2.d = null;
    L89:
        r2.k = 0;
        r2.a.stopNestedScroll(0);
        goto L112
    L84:
        if (Math.abs(r28) <= 50) goto L86;
        r2.a.dispatchNestedFling(0.0f, -r28, false);
        goto L86
    L80:
        r122 = 1;
        goto L82
    L5:
        return super.onTouchEvent(r20);
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean r2) {
        super.onWindowFocusChanged(r2);
        SurfaceSnapshotController r0 = this.f;
        if (r0 == null) goto L16;
        if (r2 == true) goto L12;
        if (r0.j() == false) goto L8;
        return;
    L8:
        if (r0.g() == false) goto L10;
        r0.o(true);
        return;
    L10:
        r0.q();
        r0.o(false);
        return;
    L12:
        if (r0.j() == false) goto L14;
        r0.n();
        return;
    L14:
        r0.h();
        r0.q();
        return;
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r2) {
        super.onWindowVisibilityChanged(r2);
        SurfaceSnapshotController r0 = this.f;
        if (r0 == null) goto L8;
        if (r2 != 0) goto L6;
        r0.n();
        return;
    L6:
        r0.m();
        return;
    }

    public void setDefaultFocusRingEnabled(boolean r2) {
        FlutterEngine r0 = this.r;
        if (r0 == null) goto L6;
        r0.b.a.setDefaultFocusRingEnabled(r2);
        return;
    }

    public void setExternalDisplayMetrics(DisplayMetrics r1) {
        this.p = r1;
    }

    public void setExternalPlatformViewContext(n5a.i r1) {
        this.o = r1;
    }

    public void setInternalPlatformViewLynxContext(Context r3) {
        n5a.b r0 = this.n;
        if ((r0 instanceof n5a.b) == false) goto L6;
        r0.b = r3;
        return;
    }

    public void setKeyEventListener(com.lynx.clay.embedding.android.a.c r1) {
        com.lynx.clay.embedding.android.a r2 = this.w;
        if (r2 == null) goto L6;
        r2.d.getClass();
        return;
    }

    public void setKeyboardEventStartCallback(g r1) {
        this.q = r1;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean r2) {
        this.C.setNestedScrollingEnabled(r2);
    }

    public void setPerformanceOverlayEnabled(boolean r2) {
        FlutterEngine r0 = this.r;
        if (r0 == null) goto L6;
        r0.a.setPerformanceOverlayEnabled(r2);
        return;
    }

    public void setResourceUrlInterceptor(j r2) {
        this.r.a.setResourceUrlInterceptor(r2);
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int r2) {
        return this.C.startNestedScroll(r2);
    }

    public final void stopNestedScroll(int r2) {
        this.C.stopNestedScroll(r2);
    }

    public FlutterView(Context r4, FlutterDelegateView r5) {
        super(r4, null);
        this.i = new HashSet();
        this.k = new a(this);
        this.l = false;
        this.m = new b(this);
        this.n = new n5a.b(getContext());
        this.o = null;
        this.p = null;
        this.q = null;
        this.s = new HashSet();
        this.u = false;
        this.v = false;
        this.D = new FlutterRenderer.ViewportMetrics();
        new c();
        this.E = new d(this);
        this.L = -1;
        this.M = -1;
        this.N = new e(this);
        this.d = r5;
        this.g = r5;
        this.h = RenderMode.delegate;
        h();
    }

    public final void k(int r3, int r4) {
        Object r0 = com.lynx.clay.util.a.a;
        if (Looper.getMainLooper() != Looper.myLooper()) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L21;
        Object r2 = this.g;
        if ((r2 instanceof View) == true) goto L10;
        return;
    L10:
        ViewGroup.LayoutParams r5 = ((View) r2).getLayoutParams();
        if (r5 != null) goto L14;
        return;
    L14:
        if (r5.width == r3) goto L16;
    L18:
        r5.width = r3;
        r5.height = r4;
        return;
    L16:
        if (r5.height != r4) goto L18;
        return;
    L21:
        throw new RuntimeException("Methods marked with @UiThread must be executed on the main thread. Current thread: " + ThreadMethodProxy.currentThread().getName());
    L5:
        r1 = false;
        goto L6
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r13, int r14) {
        int r0 = View.MeasureSpec.getMode(r14);
        int r15 = View.MeasureSpec.getSize(r14);
        int r1 = View.MeasureSpec.getMode(r13);
        int r16 = View.MeasureSpec.getSize(r13);
        int r2 = this.L;
        boolean r3 = false;
        if (r2 == (-1)) goto L5;
        boolean r6 = true;
    L6:
        int r7 = this.M;
        if (r7 == (-1)) goto L9;
        boolean r5 = true;
    L10:
        if (r6 == true) goto L13;
        r2 = 0;
    L13:
        if (r5 == true) goto L17;
        r7 = 0;
    L17:
        if (r1 != 1073741824) goto L19;
        boolean r9 = true;
    L20:
        this.F = r9;
        if (r0 != 1073741824) goto L23;
        boolean r10 = true;
    L24:
        this.G = r10;
        if (r1 != Integer.MIN_VALUE) goto L27;
        boolean r4 = true;
    L28:
        this.H = r4;
        if (r4 == false) goto L33;
        if (r5 == false) goto L32;
        if (r7 <= r16) goto L33;
    L32:
        boolean r8 = true;
    L34:
        this.I = r16;
        if (r0 != Integer.MIN_VALUE) goto L37;
        boolean r11 = true;
    L38:
        this.J = r11;
        if (r11 == false) goto L43;
        if (r6 == false) goto L42;
        if (r2 <= r15) goto L43;
    L42:
        r3 = true;
    L43:
        this.K = r15;
        if (r10 == true) goto L48;
        if (r3 == true) goto L48;
        r15 = r2;
    L48:
        if (r9 == true) goto L52;
        if (r8 == true) goto L52;
        r16 = r7;
    L52:
        FlutterRenderer.ViewportMetrics r12 = this.D;
        r12.width = r16;
        r12.height = r15;
        if (r15 >= r2) goto L55;
        int r17 = r15 | 16777216;
    L56:
        if (r16 >= r7) goto L58;
        int r18 = 16777216 | r16;
    L59:
        k(r16, r15);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r18, 1073741824), View.MeasureSpec.makeMeasureSpec(r17, 1073741824));
        return;
    L58:
        r18 = r16;
        goto L59
    L55:
        r17 = r15;
        goto L56
    L37:
        r11 = false;
    L33:
        r8 = false;
        goto L34
    L27:
        r4 = false;
        goto L28
    L23:
        r10 = false;
        goto L24
    L19:
        r9 = false;
        goto L20
    L9:
        r5 = false;
        goto L10
    L5:
        r6 = false;
        goto L6
    }

    public final boolean startNestedScroll(int r2, int r3) {
        return this.C.startNestedScroll(r2, r3);
    }

    public FlutterView(Context r4, FlutterFunctorView r5) {
        super(r4, null);
        this.i = new HashSet();
        this.k = new a(this);
        this.l = false;
        this.m = new b(this);
        this.n = new n5a.b(getContext());
        this.o = null;
        this.p = null;
        this.q = null;
        this.s = new HashSet();
        this.u = false;
        this.v = false;
        this.D = new FlutterRenderer.ViewportMetrics();
        new c();
        this.E = new d(this);
        this.L = -1;
        this.M = -1;
        this.N = new e(this);
        this.c = r5;
        this.g = r5;
        this.h = RenderMode.sync;
        h();
    }

    public FlutterView(Context r4, FlutterTextureView r5) {
        super(r4, null);
        this.i = new HashSet();
        this.k = new a(this);
        this.l = false;
        this.m = new b(this);
        this.n = new n5a.b(getContext());
        this.o = null;
        this.p = null;
        this.q = null;
        this.s = new HashSet();
        this.u = false;
        this.v = false;
        this.D = new FlutterRenderer.ViewportMetrics();
        new c();
        this.E = new d(this);
        this.L = -1;
        this.M = -1;
        this.N = new e(this);
        this.b = r5;
        this.g = r5;
        this.h = RenderMode.texture;
        h();
    }

    public FlutterView(Context r2, AttributeSet r3) {
        this(r2, r3, new FlutterSurfaceView(r2));
    }

    public FlutterView(Context r2, AttributeSet r3, FlutterSurfaceView r4) {
        super(r2, r3);
        this.i = new HashSet();
        this.k = new a(this);
        this.l = false;
        this.m = new b(this);
        this.n = new n5a.b(getContext());
        this.o = null;
        this.p = null;
        this.q = null;
        this.s = new HashSet();
        this.u = false;
        this.v = false;
        this.D = new FlutterRenderer.ViewportMetrics();
        new c();
        this.E = new d(this);
        this.L = -1;
        this.M = -1;
        this.N = new e(this);
        this.a = r4;
        this.g = r4;
        this.h = RenderMode.surface;
        h();
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float r2, float r3, boolean r4) {
        return this.C.dispatchNestedFling(r2, r3, r4);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int r2, int r3, int[] r4, int[] r5) {
        return this.C.dispatchNestedPreScroll(r2, r3, r4, r5);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        FlutterRenderer.ViewportMetrics r5 = this.D;
        r5.width = r1;
        r5.height = r2;
        k(r1, r2);
        j();
    }

    public final boolean dispatchNestedPreScroll(int r7, int r8, int[] r9, int[] r10, int r11) {
        return this.C.dispatchNestedPreScroll(r7, r8, r9, r10, r11);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int r7, int r8, int r9, int r10, int[] r11) {
        return this.C.dispatchNestedScroll(r7, r8, r9, r10, r11);
    }

    public final boolean dispatchNestedScroll(int r8, int r9, int r10, int r11, int[] r12, int r13) {
        return this.C.dispatchNestedScroll(r8, r9, r10, r11, r12, r13);
    }
}
