package v5a;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import com.lynx.clay.embedding.engine.plugins.platformview.PlatformViewPlugin;
import com.lynx.clay.embedding.engine.sharedimage.SurfaceTexturePlatformWrapper;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import n5a.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b extends FrameLayout {
    public int a;
    public int b;
    public int c;
    public int d;
    public SurfaceTexture e;
    public Surface f;
    public c g;
    public final AtomicLong h;
    public final AtomicInteger i;
    public boolean j;
    public boolean k;
    public boolean l;
    public d m;
    public e n;
    public boolean o;
    public int p;
    public final a q;
    public final C0116b r;

    public class a implements ComponentCallbacks2 {
        public final /* synthetic */ b a;

        @Override // android.content.ComponentCallbacks
        public final void onConfigurationChanged(Configuration r1) {
        }

        @Override // android.content.ComponentCallbacks
        public final void onLowMemory() {
        }

        public a(b r1) {
            this.a = r1;
        }

        @Override // android.content.ComponentCallbacks2
        public final void onTrimMemory(int r2) {
            if (r2 == 80) goto L5;
            return;
        L5:
            if (Build.VERSION.SDK_INT < 29) goto L9;
            this.a.j = true;
            return;
        }
    }

    /* JADX INFO: renamed from: v5a.b$b, reason: collision with other inner class name */
    public class C0116b implements SurfaceTexturePlatformWrapper.a {
        public final /* synthetic */ b a;

        @Override // com.lynx.clay.embedding.engine.sharedimage.SurfaceTexturePlatformWrapper.a
        public final void a() {
            if (Build.VERSION.SDK_INT == 29) goto L5;
            return;
        L5:
            if (this.a.h.decrementAndGet() >= 0) goto L7;
            this.a.h.set(0);
        L7:
            this.a.i.set(0);
        }

        public C0116b(b r1) {
            this.a = r1;
        }
    }

    public class c implements ViewTreeObserver.OnGlobalFocusChangeListener {
        public final /* synthetic */ View.OnFocusChangeListener a;
        public final /* synthetic */ b b;

        public c(b r1, View.OnFocusChangeListener r2) {
            this.b = r1;
            this.a = r2;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
        public final void onGlobalFocusChanged(View r2, View r3) {
            View.OnFocusChangeListener r4 = this.a;
            b r5 = this.b;
            r4.onFocusChange(r5, com.lynx.clay.util.d.b(r5, new com.lynx.clay.util.b()));
        }
    }

    public interface d {
    }

    public interface e {
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r1) {
        return false;
    }

    public final void a() {
        if (this.o == false) goto L11;
        int r0 = this.p;
        if (r0 <= 0) goto L13;
        int r1 = r0 - 1;
        this.p = r1;
        if (r1 <= 0) goto L12;
        postInvalidateOnAnimation();
        return;
    L12:
        return;
    L13:
        return;
    }

    public int getBufferHeight() {
        return this.d;
    }

    public int getBufferWidth() {
        return this.c;
    }

    public SurfaceTexture getTexture() {
        return this.e;
    }

    public b(Context r4) {
        super(r4);
        this.h = new AtomicLong(0);
        this.i = new AtomicInteger(0);
        this.j = false;
        this.k = false;
        this.l = true;
        this.o = false;
        this.p = 0;
        a r0 = new a(this);
        this.q = r0;
        this.r = new C0116b(this);
        setWillNotDraw(false);
        r4.registerComponentCallbacks(r0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r8) {
        if (this.k == true) goto L5;
        return false;
    L5:
        int r0 = r8.getActionMasked();
        if (r0 != 0) goto L15;
        e r3 = this.n;
        if (r3 != null) goto L10;
    L13:
        boolean r4 = true;
    L14:
        this.l = r4;
        goto L15
    L10:
        if (PlatformViewPlugin.a(((n) r3).a, r8, Math.round(this.a + r8.getX(r8.getActionIndex())), Math.round(this.b + r8.getY(r8.getActionIndex()))) == true) goto L13;
        r4 = false;
    L15:
        boolean r5 = this.l;
        if (r0 != 1) goto L18;
    L19:
        this.l = true;
    L20:
        if (r5 == true) goto L22;
        return false;
    L22:
        boolean r1 = super.dispatchTouchEvent(r8);
        d r2 = this.m;
        if (r2 == null) goto L25;
        PlatformViewPlugin.access$000(((PlatformViewPlugin.a) r2).a, r8, r1);
    L25:
        return r1;
    L18:
        if (r0 != 3) goto L20;
        goto L19
    }

    @Override // android.view.View
    public final void draw(Canvas r8) {
        Surface r0 = this.f;
        if (r0 != null) goto L7;
        super.draw(r8);
        c5a.c.d(6, "PlatformViewWrapper", "Platform view cannot be composed without a surface.");
        return;
    L7:
        if (r0.isValid() == true) goto L10;
        c5a.c.d(6, "PlatformViewWrapper", "Invalid surface. The platform view cannot be displayed.");
        return;
    L10:
        SurfaceTexture r9 = this.e;
        if (r9 != null) goto L13;
    L42:
        c5a.c.d(6, "PlatformViewWrapper", "Invalid texture. The platform view cannot be displayed.");
        return;
    L13:
        if (r9.isReleased() == true) goto L42;
        int r10 = Build.VERSION.SDK_INT;
        if (r10 == 29) goto L18;
    L24:
        boolean r2 = true;
    L25:
        if (r2 == true) goto L28;
        postInvalidateOnAnimation();
        return;
    L28:
        if (this.j == false) goto L33;
        Surface r3 = this.f;
        if (r3 == null) goto L32;
        r3.release();
    L32:
        this.f = new Surface(this.e);
        this.j = false;
    L33:
        Canvas r4 = this.f.lockHardwareCanvas();
        r4.drawColor(0, PorterDuff.Mode.CLEAR);     // Catch: Throwable -> L39
        super.draw(r4);     // Catch: Throwable -> L39
        if (r10 != 29) goto L37;
        this.h.incrementAndGet();     // Catch: Throwable -> L39
    L37:
        this.f.unlockCanvasAndPost(r4);
        a();
        return;
    L39:
        th = move-exception;
        this.f.unlockCanvasAndPost(r4);
        a();
        throw th;
    L18:
        if (this.h.get() > 0) goto L21;
        this.i.set(0);
        goto L24
    L21:
        if (this.i.incrementAndGet() < 3) goto L23;
        this.h.set(0);
        this.i.set(0);
        goto L24
    L23:
        r2 = false;
        goto L25
    }

    public void setLayoutParams(FrameLayout.LayoutParams r2) {
        setLayoutParams(r2);
        this.a = r2.leftMargin;
        this.b = r2.topMargin;
    }

    public void setOnDescendantFocusChangeListener(View.OnFocusChangeListener r4) {
        ViewTreeObserver r0 = getViewTreeObserver();
        if (r0.isAlive() == false) goto L7;
        c r1 = this.g;
        if (r1 == null) goto L7;
        this.g = null;
        r0.removeOnGlobalFocusChangeListener(r1);
    L7:
        ViewTreeObserver r2 = getViewTreeObserver();
        if (r2.isAlive() == true) goto L10;
        return;
    L10:
        if (this.g != null) goto L14;
        c r3 = new c(this, r4);
        this.g = r3;
        r2.addOnGlobalFocusChangeListener(r3);
        return;
    }

    public void setPendingFramesCountForTesting(long r2) {
        this.h.set(r2);
        this.i.set(0);
    }

    public void setPostDrawRedrawEnabled(boolean r1) {
        this.o = r1;
        if (r1 == true) goto L6;
        this.p = 0;
        return;
    }

    public void setSystemTouchDispatchEnabled(boolean r1) {
        this.k = r1;
        if (r1 == true) goto L6;
        this.l = true;
        return;
    }

    public void setTexture(SurfaceTexture r5) {
        if (Build.VERSION.SDK_INT >= 23) goto L6;
        c5a.c.d(6, "PlatformViewWrapper", "Platform views cannot be displayed below API level 23. You can prevent this issue by setting `minSdkVersion: 23` in build.gradle.");
        return;
    L6:
        this.e = r5;
        C0116b r1 = this.r;
        WeakHashMap<SurfaceTexture, SurfaceTexturePlatformWrapper.a> r2 = SurfaceTexturePlatformWrapper.c;
        monitor-enter(r2);
        r2.put(r5, r1);     // Catch: Throwable -> L25
        monitor-exit(r2);     // Catch: Throwable -> L25
        int r3 = this.c;
        if (r3 <= 0) goto L15;
        int r4 = this.d;
        if (r4 <= 0) goto L15;
        this.e.setDefaultBufferSize(r3, r4);
    L15:
        Surface r6 = this.f;
        if (r6 == null) goto L18;
        r6.release();
    L18:
        Surface r7 = new Surface(r5);
        this.f = r7;
        Canvas r8 = r7.lockHardwareCanvas();
        r8.drawColor(0, PorterDuff.Mode.CLEAR);     // Catch: Throwable -> L22
        this.f.unlockCanvasAndPost(r8);
        a();
        return;
    L22:
        th = move-exception;
        this.f.unlockCanvasAndPost(r8);
        a();
        throw th;
    L25:
        th = move-exception;
        throw th;
    }

    public void setTouchDispatchResultListener(d r1) {
        this.m = r1;
    }

    public void setTouchDispatchTargetChecker(e r1) {
        this.n = r1;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ViewParent invalidateChildInParent(int[] r1, Rect r2) {
        invalidate();
        return super.invalidateChildInParent(r1, r2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onDescendantInvalidated(View r1, View r2) {
        super.onDescendantInvalidated(r1, r2);
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestSendAccessibilityEvent(View r4, AccessibilityEvent r5) {
        View r1 = getChildAt(0);
        if (r1 == null) goto L8;
        if (r1.getImportantForAccessibility() != 4) goto L8;
        return false;
    L8:
        return super.requestSendAccessibilityEvent(r4, r5);
    }
}
