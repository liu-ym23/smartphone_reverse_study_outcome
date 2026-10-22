package m5a;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.utils.logger.FLogger;
import com.lynx.canvas.camera.CameraSize;
import com.lynx.clay.embedding.android.FlutterView;
import com.lynx.clay.embedding.engine.FlutterOverlaySurface;
import com.lynx.clay.embedding.engine.plugins.externalview.ExternalViewPlugin;
import com.lynx.clay.embedding.engine.plugins.overlay.OverlayPlatformPluginAndroid;
import com.lynx.xelement.overlay.LynxUIOverlay;
import com.mammon.speechaudiosdk.jni.enums.SpeechNativePropertyId;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class q extends FrameLayout {
    public int[] A;
    public boolean a;
    public boolean b;
    public boolean c;
    public String d;
    public String e;
    public final g f;
    public ViewTreeObserver g;
    public a h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public OverlayPlatformPluginAndroid n;
    public d o;
    public FlutterOverlaySurface p;
    public View q;
    public boolean r;
    public int s;
    public int t;
    public final FlutterView u;
    public int[] v;
    public final int w;
    public final String x;
    public final ExternalViewPlugin y;
    public int[] z;

    public class a implements ViewTreeObserver.OnDrawListener {
        public final /* synthetic */ q a;

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public final void onDraw() {
            q.c(this.a);
        }

        public a(q r1) {
            this.a = r1;
        }
    }

    private Matrix getTouchEventTransformMatrix() {
        int[] r0 = {0, 0};
        int[] r1 = getFlutterViewLocation();
        getLocationOnScreen(r0);
        int r3 = r0[0] - r1[0];
        int r2 = r0[1] - r1[1];
        if (r3 != 0) goto L7;
        if (r2 != 0) goto L7;
        return null;
    L7:
        Matrix r4 = new Matrix();
        r4.postTranslate(r3, r2);
        return r4;
    }

    private int[] getFlutterViewLocation() {
        FlutterView r0 = this.u;
        if (r0 != null) goto L7;
        return new int[]{0, 0};
    L7:
        if (this.v != null) goto L9;
        this.v = new int[2];
    L9:
        r0.getLocationOnScreen(this.v);
        return this.v;
    }

    private View getOverlayContentView() {
        View r0 = this.q;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return this.o;
    }

    public final void d() {
        boolean r0 = !this.j;
        d r1 = this.o;
        if (r1 == null) goto L5;
        r1.setFocusable(r0);
        this.o.setFocusableInTouchMode(r0);
    L5:
        View r2 = this.q;
        if (r2 == null) goto L9;
        r2.setFocusable(r0);
        this.q.setFocusableInTouchMode(r0);
        return;
    }

    public final void e() {
        this.f.d();
        boolean r0 = this.b;
        Window r1 = this.f.getWindow();
        if (r1 == null) goto L19;
        int r2 = Build.VERSION.SDK_INT;
        if (r0 == false) goto L8;
        r1.addFlags(65792);
        r1.addFlags(Integer.MIN_VALUE);
        r1.setStatusBarColor(0);
    L10:
        if (r2 >= 23) goto L12;
    L14:
        int r3 = a(r1).getSystemUiVisibility() | CameraSize.highHeight;
    L15:
        if (r0 == false) goto L17;
        a(r1).setSystemUiVisibility(r3);
        goto L19
    L17:
        a(r1).setSystemUiVisibility(0);
        goto L19
    L12:
        if (this.d.equals(LynxUIOverlay.PROP_STATUS_BAR_TRANSLUCENT_STYLE_LITE) == false) goto L14;
        r3 = a(r1).getSystemUiVisibility() | 9472;
        goto L15
    L8:
        r1.clearFlags(256);
        r1.clearFlags(65536);
        r1.clearFlags(Integer.MIN_VALUE);
    L19:
        if (Build.VERSION.SDK_INT < 28) goto L28;
        Window r4 = this.f.getWindow();
        if (r4 == null) goto L28;
        WindowManager.LayoutParams r5 = r4.getAttributes();
        if (this.c == false) goto L28;
        r5.layoutInDisplayCutoutMode = 1;
        r4.setAttributes(r5);
    L28:
        if (this.k == false) goto L36;
        Window r6 = this.f.getWindow();
        if (r6 != null) goto L32;
        return;
    L32:
        if (a(r6) == null) goto L38;
        int r7 = a(r6).getSystemUiVisibility() | 5894;
        a(r6).setSystemUiVisibility(r7);
        return;
    L38:
        return;
    }

    public final void f() {
        ExternalViewPlugin r0 = this.y;
        if (r0 != null) goto L5;
        return;
    L5:
        d r1 = r0.b;
        if (r1 == null) goto L17;
        d r2 = this.o;
        if (r2 == r1) goto L19;
        if (r2 == null) goto L13;
        if (r2 == r1) goto L13;
        j();
    L13:
        r1.setExternalViewPlugin(this.y);
        this.y.b = r1;
        this.o = r1;
        r1.setLifecycleListener(new p(this));
        this.o.setClickable(true);
        this.o.setSurfaceTextureReadyListener(new k(this));
        this.o.setSurfaceTextureUpdatedListener(new l(this));
        d();
        addView(r1, new ViewGroup.LayoutParams(-1, -1));
        if (this.f.isShowing() == false) goto L18;
        m();
        return;
    L18:
        return;
    L19:
        return;
    }

    public final void g() {
        if (this.i == false) goto L5;
        return;
    L5:
        this.i = true;
        h r1 = h.e;
        String r2 = this.e;
        if (r2 == null) goto L14;
        int r4 = 0;
    L9:
        if (r4 >= ((ArrayList) r1.c).size()) goto L15;
        if (((h.a) ListProtector.get(r1.c, r4)).a.equals(r2) == true) goto L12;
        r4 = r4 + 1;
        goto L9
    L12:
        ListProtector.remove(r1.c, r4);
        r1.c();
        r1.b();
    L15:
        h();
        j();
        if (this.m == false) goto L18;
        i(true);
        return;
    L18:
        i(false);
        return;
    L14:
        r1.getClass();
        goto L15
    }

    public final void h() {
        ViewTreeObserver r0 = this.g;
        if (r0 != null) goto L5;
    L12:
        this.g = null;
        this.h = null;
        return;
    L5:
        if (this.h == null) goto L12;
        if (r0.isAlive() == false) goto L10;
        this.g.removeOnDrawListener(this.h);
    L10:
        this.g = null;
        this.h = null;
    }

    public final void j() {
        if (this.o != null) goto L5;
        return;
    L5:
        h();
        this.o.setSurfaceTextureReadyListener(null);
        this.o.setSurfaceTextureUpdatedListener(null);
        ViewParent r0 = this.o.getParent();
        if ((r0 instanceof ViewGroup) == false) goto L8;
        ((ViewGroup) r0).removeView(this.o);
    L8:
        this.o = null;
    }

    public final void o() {
        FlutterOverlaySurface r0 = this.p;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.r == false) goto L10;
        n(r0, this.s, this.t);
        return;
    }

    public final void l() {
        k(this);
        Window r0 = this.f.getWindow();
        if (r0 == null) goto L7;
        View r1 = a(r0);
        k(r1);
        if (r1 == null) goto L7;
        k(r1.findViewById(R.id.content));
    L7:
        ViewParent r2 = getParent();
    L9:
        if ((r2 instanceof ViewGroup) == false) goto L11;
        k((View) r2);
        r2 = r2.getParent();
        goto L9
    }

    public final void m() {
        View r0 = getOverlayContentView();
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.h != null) goto L23;
        ViewTreeObserver r1 = r0.getViewTreeObserver();
        if (r1 != null) goto L10;
    L17:
        this.g = null;
        this.h = null;
        return;
    L10:
        if (r1.isAlive() == false) goto L17;
        this.g = r1;
        a r2 = new a(this);
        this.h = r2;
        r1.addOnDrawListener(r2);     // Catch: IllegalStateException -> L15
        return;
    L15:
        this.g = null;
        this.h = null;
        return;
    }

    public int getViewId() {
        return this.w;
    }

    public String getViewTag() {
        return this.x;
    }

    public static View a(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static void b(g r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static void c(q r8) {
        if (r8.n == null) goto L20;
        int[] r1 = {0, 0};
        r8.getLocationOnScreen(r1);
        int[] r2 = r8.getFlutterViewLocation();
        int[] r3 = r8.z;
        if (r3 != null) goto L8;
    L18:
        r8.z = r1;
        r8.A = new int[]{r2[0], r2[1]};
        OverlayPlatformPluginAndroid.nativeUpdateRootPosOffset(r8.n.e, r1[0] - r2[0], r1[1] - r2[1]);
        return;
    L8:
        if (r1[0] != r3[0]) goto L18;
        if (r1[1] != r3[1]) goto L18;
        int[] r4 = r8.A;
        if (r4 == null) goto L18;
        if (r2[0] != r4[0]) goto L18;
        if (r2[1] != r4[1]) goto L18;
        return;
    }

    public static void k(View r1) {
        if ((r1 instanceof ViewGroup) == false) goto L6;
        ViewGroup r2 = (ViewGroup) r1;
        r2.setClipChildren(false);
        r2.setClipToPadding(false);
        return;
    }

    private void setDialogType(int r2) {
        if (this.f.getWindow() == null) goto L6;
        this.f.getWindow().setType(r2);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r5) {
        FlutterView r0 = this.u;
        if (r0 == null) goto L30;
        if (r0.getAndroidTouchProcessor() == null) goto L30;
        int r1 = r5.getActionMasked();
        if (r1 != 0) goto L10;
        this.l = false;
    L10:
        Matrix r2 = getTouchEventTransformMatrix();
        if (r2 != null) goto L13;
        boolean r6 = this.u.getAndroidTouchProcessor().d(r5, com.lynx.clay.embedding.android.b.f);
    L15:
        if (r1 != 0) goto L18;
        if (r6 == false) goto L18;
        this.l = true;
    L18:
        if (r6 == false) goto L20;
    L23:
        boolean r7 = true;
    L24:
        if (r1 != 1) goto L26;
    L27:
        this.l = false;
    L28:
        return r7;
    L26:
        if (r1 != 3) goto L28;
    L20:
        if (this.l == true) goto L23;
        r7 = false;
        goto L24
    L13:
        r6 = this.u.getAndroidTouchProcessor().d(r5, r2);
    L30:
        return super.dispatchTouchEvent(r5);
    }

    public final void i(boolean r4) {
        if (this.q == null) goto L8;
        h();
        ViewParent r0 = this.q.getParent();
        if ((r0 instanceof ViewGroup) == false) goto L7;
        ((ViewGroup) r0).removeView(this.q);
    L7:
        this.q = null;
    L8:
        if (r4 == false) goto L11;
        this.p = null;
        this.r = false;
        return;
    }

    public void setAndroidSetSoftInputMode(String r3) {
        Window r0 = this.f.getWindow();
        if (r0 != null) goto L6;
        return;
    L6:
        if ("unspecified".equals(r3) == false) goto L9;
        int r4 = 0;
    L17:
        r0.setSoftInputMode(r4);
        return;
    L9:
        if ("nothing".equals(r3) == false) goto L12;
        r4 = 48;
        goto L17
    L12:
        if ("pan".equals(r3) == false) goto L15;
        r4 = 32;
        goto L17
    L15:
        if ("resize".equals(r3) == false) goto L19;
        r4 = 16;
        goto L17
    }

    public void setCutOutMode(boolean r1) {
        this.c = r1;
        e();
    }

    public void setFullScreen(boolean r1) {
        if (r1 == false) goto L5;
        this.k = true;
        e();
        return;
    }

    public void setIgnoreFocus(boolean r4) {
        this.j = r4;
        d();
        Window r0 = this.f.getWindow();
        if (r4 == false) goto L8;
        this.f.b = false;
        if (r0 != null) goto L7;
        return;
    L7:
        r0.clearFlags(131072);
        r0.setFlags(8, 8);
        return;
    L8:
        if (r0 != null) goto L10;
        return;
    L10:
        r0.clearFlags(8);
    }

    public void setLevel(int r5) {
        int r0 = 2;
        if (r5 == 1) goto L13;
        if (r5 != 2) goto L6;
        r0 = SpeechNativePropertyId.SPEECH_PROPERTY_VOICE_ASSISTANT_SET_WAKEUP_PARAM;
        goto L13
    L6:
        if (r5 != 3) goto L8;
        r0 = 1002;
        goto L13
    L8:
        if (r5 == 4) goto L10;
        r5 = 1;
        goto L13
    L10:
        r0 = 1000;
    L13:
        setDialogType(r0);
        this.f.c = r5;
        h r6 = h.e;
        String r1 = this.e;
        if (r1 != null) goto L16;
        r6.getClass();
        return;
    L16:
        int r2 = 0;
    L18:
        if (r2 >= ((ArrayList) r6.c).size()) goto L27;
        h.a r3 = (h.a) ListProtector.get(r6.c, r2);
        if (r3.a.equals(r1) == true) goto L21;
        r2 = r2 + 1;
        goto L18
    L21:
        ListProtector.remove(r6.c, r2);
        r6.a(r3);
        r6.c();
        r6.b();
        return;
    }

    public void setNativeEventPass(boolean r3) {
        Window r0 = this.f.getWindow();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r3 == false) goto L8;
        r0.addFlags(16);
        return;
    L8:
        r0.clearFlags(16);
    }

    public void setOverlayPlatformPluginAndroid(OverlayPlatformPluginAndroid r1) {
        this.n = r1;
    }

    public void setStatusBarTranslucent(boolean r1) {
        this.b = r1;
        e();
    }

    public void setStatusBarTranslucentStyle(String r1) {
        if (r1 != null) goto L5;
        r1 = LynxUIOverlay.PROP_STATUS_BAR_TRANSLUCENT_STYLE_DARK;
    L5:
        this.d = r1;
        e();
    }

    public void setVisible(boolean r7) {
        if (this.a != r7) goto L5;
        return;
    L5:
        this.a = r7;
        if (r7 == false) goto L41;
        f();
        Activity r8 = t5a.b.getActivity(getContext());
        this.z = null;
        if (r8 != null) goto L10;
        return;
    L10:
        if (r8.isFinishing() == true) goto L58;
        h r0 = h.e;
        String r1 = this.e;
        byte r2 = 0;
        if (r1 == null) goto L19;
        Iterator r3 = ((ArrayList) r0.c).iterator();
    L15:
        if (r3.hasNext() == false) goto L20;
        if (((h.a) r3.next()).a.equals(r1) == false) goto L15;
        boolean r4 = true;
    L21:
        if (r4 == true) goto L59;
        h r5 = h.e;     // Catch: RuntimeException -> L39
        g r6 = this.f;     // Catch: RuntimeException -> L39
        r5.getClass();     // Catch: RuntimeException -> L39
        StringBuilder r9 = new StringBuilder("default_overlay_id_");     // Catch: RuntimeException -> L39
        int r10 = r5.d;     // Catch: RuntimeException -> L39
        r5.d = r10 + 1;     // Catch: RuntimeException -> L39
        r9.append(r10);     // Catch: RuntimeException -> L39
        String r11 = r9.toString();     // Catch: RuntimeException -> L39
        r5.a(new h.a(r11, r6));     // Catch: RuntimeException -> L39
        r5.c();     // Catch: RuntimeException -> L39
        this.e = r11;     // Catch: RuntimeException -> L39
        this.i = false;     // Catch: RuntimeException -> L39
        this.f.setOnDismissListener(new i(this));     // Catch: RuntimeException -> L39
        this.f.getClass();     // Catch: RuntimeException -> L39
        if (r8.isFinishing() == false) goto L26;
        r2 = -1;
    L28:
        if (r2 < 0) goto L36;
        g r12 = this.f;     // Catch: RuntimeException -> L39
        if (DialogLancet.shouldBlockDialogShow(r12) == false) goto L52;
        DialogLancet.handleBlockedDialogShow(r12);     // Catch: RuntimeException -> L39
    L35:
        e();     // Catch: RuntimeException -> L39
        h.e.c();     // Catch: RuntimeException -> L39
        l();     // Catch: RuntimeException -> L39
        o();     // Catch: RuntimeException -> L39
    L37:
        m();     // Catch: RuntimeException -> L39
        return;
    L52:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L47
    L34:
        DialogLancet.beforeDialogShow(r12);     // Catch: RuntimeException -> L39
        r12.show();     // Catch: RuntimeException -> L39
        DialogLancet.afterDialogShow(r12);     // Catch: RuntimeException -> L39
        goto L35
    L36:
        g();     // Catch: RuntimeException -> L39
        goto L37
    L26:
        if (r8.isDestroyed() == false) goto L28;
        r2 = -2;
    L39:
        g();
        return;
    L59:
        return;
    L20:
        r4 = false;
        goto L21
    L19:
        r0.getClass();
        goto L20
    L58:
        return;
    L41:
        if (this.f.isShowing() == true) goto L50;
        g();
        return;
    L50:
        b(this.f);     // Catch: RuntimeException -> L44
        return;
    L44:
        g();
    }

    public final int p(int r3, boolean r4) {
        if (r3 <= 0) goto L4;
        return r3;
    L4:
        if (r4 == false) goto L6;
        int r0 = getWidth();
    L7:
        Window r1 = this.f.getWindow();
        if (r1 != null) goto L10;
        View r2 = null;
    L11:
        if (r0 > 0) goto L16;
        if (r2 == null) goto L16;
        if (r4 == false) goto L15;
        r0 = r2.getWidth();
        goto L16
    L15:
        r0 = r2.getHeight();
    L16:
        if (r0 > 0) goto L23;
        View r5 = getRootView();
        if (r5 != null) goto L20;
        r0 = 0;
        goto L23
    L20:
        if (r4 == false) goto L22;
        r0 = r5.getWidth();
        goto L23
    L22:
        r0 = r5.getHeight();
    L23:
        if (r0 > 0) goto L29;
        Resources r6 = getResources();
        DisplayMetrics r7 = WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics());
        if (r4 == false) goto L27;
        int r8 = r7.widthPixels;
    L28:
        r0 = r8;
        goto L29
    L27:
        r8 = r7.heightPixels;
    L29:
        if (r0 > 0) goto L31;
        return r3;
    L31:
        return r0;
    L10:
        r2 = a(r1);
        goto L11
    L6:
        r0 = getHeight();
        goto L7
    }

    public final void n(FlutterOverlaySurface r7, int r8, int r9) {
        boolean r0 = true;
        int r1 = p(r8, true);
        int r3 = p(r9, false);
        View r4 = null;
        if (r7 != null) goto L5;
        View r5 = null;
    L6:
        if (r5 != null) goto L9;
    L20:
        if (r4 == null) goto L46;
        if (r1 <= 0) goto L47;
        if (r3 <= 0) goto L48;
        this.r = true;
        this.s = r8;
        this.t = r9;
        l();
        ViewGroup.LayoutParams r10 = r4.getLayoutParams();
        boolean r11 = r10 instanceof FrameLayout.LayoutParams;
        if (r11 == false) goto L27;
        FrameLayout.LayoutParams r12 = (FrameLayout.LayoutParams) r10;
    L28:
        if (r11 == true) goto L30;
    L39:
        if (r0 == false) goto L41;
        r12.width = r1;
        r12.height = r3;
        r12.leftMargin = 0;
        r12.topMargin = 0;
        r4.setLayoutParams(r12);
    L41:
        r4.setTranslationX(0.0f);
        r4.setTranslationY(0.0f);
        r4.setVisibility(0);
        r4.bringToFront();
        r4.requestLayout();
        r4.invalidate();
        if (this.j == true) goto L44;
        this.f.b(r4);
    L44:
        m();
        return;
    L30:
        if (r12.width != r1) goto L39;
        if (r12.height != r3) goto L39;
        if (r12.leftMargin != 0) goto L39;
        if (r12.topMargin != 0) goto L39;
        r0 = false;
        goto L39
    L27:
        r12 = new FrameLayout.LayoutParams(r1, r3);
        goto L28
    L48:
        return;
    L47:
        return;
    L46:
        return;
    L9:
        if (this.p == r7) goto L11;
    L12:
        i(true);
        this.p = r7;
        this.q = r5;
    L13:
        ViewParent r13 = r5.getParent();
        if (r13 != this) goto L16;
    L19:
        r4 = r5;
        goto L20
    L16:
        if ((r13 instanceof ViewGroup) == false) goto L18;
        ((ViewGroup) r13).removeView(r5);
    L18:
        addView(r5, new FrameLayout.LayoutParams(-1, -1));
        goto L19
    L11:
        if (this.q == r5) goto L13;
    L5:
        r5 = r7.a();
        goto L6
    }

    public q(Context r3, int r4, String r5, FlutterView r6, ExternalViewPlugin r7) {
        super(r3);
        this.a = false;
        this.b = true;
        this.c = false;
        this.d = LynxUIOverlay.PROP_STATUS_BAR_TRANSLUCENT_STYLE_DARK;
        this.i = true;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        this.r = false;
        this.s = 0;
        this.t = 0;
        this.v = null;
        this.z = null;
        this.A = null;
        this.x = r5;
        this.w = r4;
        this.u = r6;
        this.y = r7;
        Activity r8 = t5a.b.getActivity(getContext());
        if (r8 == null) goto L12;
        g r9 = new g(r8, this, r6);
        this.f = r9;
        r9.getWindow().clearFlags(2);
        r9.getWindow().setDimAmount(0.0f);
        h r10 = h.e;
        Context r11 = getContext();
        WeakReference<Context> r12 = r10.a;
        if (r12 != null) goto L7;
    L8:
        r10.a = new WeakReference(r11.getApplicationContext());
    L9:
        r9.setContentView(this, new ViewGroup.LayoutParams(-1, -1));
        l();
        r9.setOnKeyListener(new j(this));
        e();
        f();
        return;
    L7:
        if (r12.get() != null) goto L9;
    L12:
        throw new RuntimeException("Failed to create OverlayViewNG, which needs an activity context!");
    }
}
