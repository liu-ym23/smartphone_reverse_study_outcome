package com.lynx.tasm.behavior;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.PixelCopy;
import android.view.Surface;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.lynx.config.LynxLiteConfigs;
import com.lynx.devtoolwrapper.ScreenshotMode;
import com.lynx.tasm.LynxBooleanOption;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.ThreadStrategyForRendering;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.behavior.render.NativePaintingContext;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import com.obric.assistant.AutoEndConversationTime;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxUIRenderer implements ILynxUIRenderer {
    public static final Object p = null;
    public static PthreadHandlerThreadV2 q;
    public WeakReference<LynxContext> a;
    public LynxUIOwner b;
    public b1 c;
    public v0 d;
    public l e;
    public long f;
    public String g;
    public LynxBooleanOption h;
    public boolean i;
    public String j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;

    private static native long nativeCreateUIDelegate(long r0, long r2);

    private static native void nativeDestroyUIDelegate(long r0);

    static {
        p = new Object();
        q = null;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class b() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("android.view.ViewRootImpl");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.view.ViewRootImpl");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.view.ViewRootImpl");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("android.view.ViewRootImpl");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.view.ViewRootImpl");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.view.ViewRootImpl");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.view.ViewRootImpl");
    }

    public static synchronized void n() {
        monitor-enter(LynxUIRenderer.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (q != null) goto L7;
        PthreadHandlerThreadV2 r1 = new PthreadHandlerThreadV2("PixelCopier");     // Catch: Throwable -> L9
        q = r1;     // Catch: Throwable -> L9
        ThreadMethodProxy.start(r1);     // Catch: Throwable -> L9
    L7:
        monitor-exit(LynxUIRenderer.class);
    }

    public final void a() {
        LynxUIOwner r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.c != null) goto L33;
        b1 r1 = new b1(r0);
        this.c = r1;
        boolean r2 = this.b.getHasTouchPseudo();
        boolean r3 = true;
        if (r1.w == true) goto L11;
        if (r2 == true) goto L11;
        boolean r4 = false;
    L12:
        r1.w = r4;
        if (this.i == false) goto L34;
        this.i = false;
        if (this.b.getContext() == null) goto L35;
        LynxContext r5 = this.b.getContext();
        r5.setTouchEventDispatcher(this.c);
        String r6 = this.j;
        if (r6 != null) goto L19;
    L21:
        b1 r7 = this.c;
        boolean r8 = this.l;
        if (r7.w == true) goto L26;
        if (r8 == true) goto L26;
        r3 = false;
    L26:
        r7.w = r3;
        r7.z = this.k;
        r7.x = this.n;
        if (this.m == true) goto L29;
        return;
    L29:
        if (LynxLiteConfigs.enableNewGesture() == false) goto L37;
        b1 r9 = this.c;
        r9.k = this.b.getGestureArenaManager();
        return;
    L37:
        return;
    L19:
        if (r6.equals("50px") == true) goto L21;
        b1 r10 = this.c;
        r10.o = com.lynx.tasm.utils.n.e(r6, 0.0f, r5.getScreenMetrics());
        goto L21
    L35:
        return;
    L34:
        return;
    L11:
        r4 = true;
        goto L12
    }

    public final Bitmap f() {
        LynxView r0 = this.a.get().getLynxView();
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.getWidth() > 0) goto L7;
        return null;
    L7:
        if (r0.getHeight() <= 0) goto L14;
        Bitmap r1 = Bitmap.createBitmap(r0.getWidth(), r0.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas r2 = new Canvas(r1);
        r2.drawColor(h(r0));
        d(r0, r2);
        return r1;
    L14:
        return null;
    }

    public final UIBody g() {
        LynxUIOwner r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRootUI();
    }

    public final long j() {
        if (this.f != 0) goto L18;
        l r0 = this.e;
        if (r0 == null) goto L7;
        long r1 = r0.a();
    L8:
        v0 r4 = this.d;
        if (r4 == null) goto L11;
        long r5 = r4.c;
    L13:
        if (r1 == 0) goto L18;
        if (r5 == 0) goto L18;
        this.f = nativeCreateUIDelegate(r1, r5);
        goto L18
    L11:
        r5 = 0;
        goto L13
    L7:
        r1 = 0;
    L18:
        return this.f;
    }

    public final void l() {
        v0 r0 = this.d;
        if (r0 == null) goto L5;
        r0.b();
        this.d = null;
    L5:
        l r1 = this.e;
        if (r1 == null) goto L8;
        r1.destroy();
        this.e = null;
    L8:
        LynxUIOwner r2 = this.b;
        if (r2 == null) goto L11;
        r2.setPaintingContext(null);
    L11:
        long r3 = this.f;
        if (r3 == 0) goto L15;
        nativeDestroyUIDelegate(r3);
        this.f = 0;
        return;
    }

    public LynxUIRenderer() {
        this.f = 0;
        this.g = ScreenshotMode.SCREEN_SHOT_MODE_FULL_SCREEN;
        this.j = "50px";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int h(View r2) {
        ViewParent r3 = r2.getParent();     // Catch: Throwable -> L11
    L4:
        if ((r3 instanceof View) == false) goto L21;
        ViewParent r0 = r3.getParent();     // Catch: Throwable -> L11
        Drawable r4 = ((View) r3).getBackground();     // Catch: Throwable -> L11
        if ((r4 instanceof ColorDrawable) == false) goto L10;
        int r5 = ((ColorDrawable) r4).getColor();     // Catch: Throwable -> L11
        if (r5 == 0) goto L10;
        return r5;
    L10:
        r3 = r0;
        goto L4
    L21:
        return -1;
    L11:
        th = move-exception;
        th.printStackTrace();
        return -1;
    }

    public final void d(View r12, Canvas r13) {
    L36:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (LynxEnv.inst().isPixelCopyEnabled() == false) goto L34;
        int r0 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L36
        if (r0 < 26) goto L34;
        int[] r1 = new int[2];     // Catch: Throwable -> L36
        if (r0 < 29) goto L9;
        r12.getLocationInSurface(r1);     // Catch: Throwable -> L36
    L10:
        Field r2 = b().getDeclaredField("mSurface");     // Catch: Throwable -> L36
        if (r12.getRootView().getParent() != null) goto L14;
        r12.draw(r13);     // Catch: Throwable -> L36
        return;
    L14:
        Surface r3 = (Surface) r2.get(r12.getRootView().getParent());     // Catch: Throwable -> L36
        DisplayMetrics r4 = DisplayMetricsHolder.getRealScreenDisplayMetrics(r12.getContext());     // Catch: Throwable -> L36
        int r5 = r4.widthPixels;     // Catch: Throwable -> L36
        int r6 = r4.heightPixels;     // Catch: Throwable -> L36
        int r7 = Math.max(0, r1[0]);     // Catch: Throwable -> L36
        int r8 = Math.max(0, r1[1]);     // Catch: Throwable -> L36
        Rect r9 = new Rect(r7, r8, Math.min(r1[0] + r12.getWidth(), r5), Math.min(r1[1] + r12.getHeight(), r6));     // Catch: Throwable -> L36
        int r14 = Math.max(0, r9.width());     // Catch: Throwable -> L36
        int r10 = Math.max(0, r9.height());     // Catch: Throwable -> L36
        if (r14 <= 0) goto L32;
        if (r10 <= 0) goto L32;
        Bitmap r15 = Bitmap.createBitmap(r14, r10, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L36
        n();     // Catch: Throwable -> L36
        Object r11 = p;     // Catch: Throwable -> L36
        monitor-enter(r11);     // Catch: Throwable -> L36
        PixelCopy.request(r3, r9, r15, new k0(), new Handler(q.getLooper()));     // Catch: Throwable -> L29
        r11.wait(AutoEndConversationTime.AFTER_10_SECONDS);     // Catch: InterruptedException -> L24 Throwable -> L29
    L26:
        monitor-exit(r11);     // Catch: Throwable -> L29
        r13.drawBitmap(r15, r7 - r1[0], r8 - r1[1], null);     // Catch: Throwable -> L36
        r15.recycle();     // Catch: Throwable -> L36
        return;
    L24:
        e = move-exception;
        LLog.e("DevTool Screenshot", e.toString());     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        throw th;     // Catch: Throwable -> L36
    L32:
        r13.drawColor(0);     // Catch: Throwable -> L36
        return;
    L9:
        r12.getLocationInWindow(r1);     // Catch: Throwable -> L36
    L34:
        r12.draw(r13);     // Catch: Throwable -> L36
    }

    public final float[] i(int r12, float[] r13) {
        float[] r0 = new float[32];
        l r1 = this.e;
        if (r1 != null) goto L6;
        LLog.e("LynxUIRenderer", "getTransformValue failed since mPaintingContext is null.");
        return r0;
    L6:
        int r2 = r1.b(r12);
        int r3 = this.e.h(r12);
        int r4 = 0;
    L8:
        if (r4 >= 4) goto L20;
        if (r4 != 0) goto L13;
        float r5 = (r13[BoxModelOffset.PAD_LEFT.ordinal()] + r13[BoxModelOffset.BORDER_LEFT.ordinal()]) + r13[BoxModelOffset.LAYOUT_LEFT.ordinal()];
        float r6 = ((r2 - r13[BoxModelOffset.PAD_RIGHT.ordinal()]) - r13[BoxModelOffset.BORDER_RIGHT.ordinal()]) - r13[BoxModelOffset.LAYOUT_RIGHT.ordinal()];
        float r7 = (r13[BoxModelOffset.PAD_TOP.ordinal()] + r13[BoxModelOffset.BORDER_TOP.ordinal()]) + r13[BoxModelOffset.LAYOUT_TOP.ordinal()];
        float r8 = (r3 - r13[BoxModelOffset.PAD_BOTTOM.ordinal()]) - r13[BoxModelOffset.BORDER_BOTTOM.ordinal()];
        float r9 = r13[BoxModelOffset.LAYOUT_BOTTOM.ordinal()];
    L11:
        float r10 = r8 - r9;
        PointF r11 = this.e.g(r12, new PointF(r5, r7));
        PointF r14 = this.e.g(r12, new PointF(r6, r7));
        PointF r15 = this.e.g(r12, new PointF(r5, r10));
        PointF r16 = this.e.g(r12, new PointF(r6, r10));
        int r17 = r4 * 8;
        r0[r17] = r11.x;
        r0[r17 + 1] = r11.y;
        r0[r17 + 2] = r14.x;
        r0[r17 + 3] = r14.y;
        r0[r17 + 4] = r16.x;
        r0[r17 + 5] = r16.y;
        r0[r17 + 6] = r15.x;
        r0[r17 + 7] = r15.y;
        r4 = r4 + 1;
        goto L8
    L13:
        if (r4 != 1) goto L16;
        r5 = r13[BoxModelOffset.BORDER_LEFT.ordinal()] + r13[BoxModelOffset.LAYOUT_LEFT.ordinal()];
        r6 = (r2 - r13[BoxModelOffset.BORDER_RIGHT.ordinal()]) - r13[BoxModelOffset.LAYOUT_RIGHT.ordinal()];
        r7 = r13[BoxModelOffset.BORDER_TOP.ordinal()] + r13[BoxModelOffset.LAYOUT_TOP.ordinal()];
        r8 = r3 - r13[BoxModelOffset.BORDER_BOTTOM.ordinal()];
        r9 = r13[BoxModelOffset.LAYOUT_BOTTOM.ordinal()];
        goto L11
    L16:
        if (r4 != 2) goto L18;
        r5 = r13[BoxModelOffset.LAYOUT_LEFT.ordinal()];
        r6 = r2 - r13[BoxModelOffset.LAYOUT_RIGHT.ordinal()];
        r7 = r13[BoxModelOffset.LAYOUT_TOP.ordinal()];
        r8 = r3;
        r9 = r13[BoxModelOffset.LAYOUT_BOTTOM.ordinal()];
        goto L11
    L18:
        r5 = (-r13[BoxModelOffset.MARGIN_LEFT.ordinal()]) + r13[BoxModelOffset.LAYOUT_LEFT.ordinal()];
        r6 = (r2 + r13[BoxModelOffset.MARGIN_RIGHT.ordinal()]) - r13[BoxModelOffset.LAYOUT_RIGHT.ordinal()];
        r7 = (-r13[BoxModelOffset.MARGIN_TOP.ordinal()]) + r13[BoxModelOffset.LAYOUT_TOP.ordinal()];
        r8 = r3 + r13[BoxModelOffset.MARGIN_BOTTOM.ordinal()];
        r9 = r13[BoxModelOffset.LAYOUT_BOTTOM.ordinal()];
        goto L11
    L20:
        return r0;
    }

    public final void c(UIBody.UIBodyView r2, LynxContext r3, Context r4) {
        if (r3 == null) goto L12;
        this.a = new WeakReference(r3);
        r3.setLynxUIOwner(this.b);
        r3.setUIBody(this.b.getRootUI());
        r3.setBaseContext(r4);
        r3.setUIBodyView(r2);
        b1 r0 = this.c;
        if (r0 == null) goto L12;
        k r1 = r0.b;
        if (r1 == null) goto L11;
        if (r4 != null) goto L9;
        int r5 = ViewConfiguration.getTouchSlop();
    L10:
        r1.a = r5 * r5;
        goto L11
    L9:
        r5 = ViewConfiguration.get(r4).getScaledTouchSlop();
    L11:
        r3.setTouchEventDispatcher(this.c);
    L12:
        LynxUIOwner r6 = this.b;
        if (r6 == null) goto L16;
        r6.attachLynxContext(r3);
        this.b.attachUIBodyView(r2);
        return;
    }

    public final int e(float r6, float r7, int r8, String r9) {
        LynxUIOwner r0 = this.b;
        if (r0 == null) goto L19;
        if (r8 != 0) goto L6;
        LynxBaseUI r10 = r0.getRootUI();
    L9:
        if (r10 == null) goto L19;
        float[] r2 = {r6, r7};
        if (r9 != null) goto L13;
    L15:
        EventTarget r11 = r10.hitTest(r2[0], r2[1], true);
        if (r11 == null) goto L19;
        return r11.getSign();
    L13:
        if (r9.equals(ScreenshotMode.SCREEN_SHOT_MODE_FULL_SCREEN) == false) goto L15;
        r2 = new float[]{r6, r7};
        float[] r12 = r10.getLocationOnScreen(new float[2]);
        r2[0] = r2[0] - r12[0];
        r2[1] = r2[1] - r12[1];
        goto L15
    L6:
        r10 = r0.getNode(r8);
        if (r10 == null) goto L9;
        r10 = ((LynxUI) r10).getTransitionUI();
    L19:
        return 0;
    }

    public final void k(LynxContext r3, ThreadStrategyForRendering r4, c r5, y6a.f r6) {
        if (this.b != null) goto L6;
        return;
    L6:
        if (this.e == null) goto L8;
    L12:
        this.b.setPaintingContext(this.e);
        if (this.d != null) goto L15;
        this.d = new v0(r3, r5, r6);
    L15:
        r3.setShadowNodeOwner(this.d);
        return;
    L8:
        if (r3.isFragmentLayerRenderOn() == false) goto L10;
        l r7 = new NativePaintingContext(this.b.getRootUI().getBodyView(), r3, r5);
    L11:
        this.e = r7;
        goto L12
    L10:
        r7 = new PaintingContext(this.b, r4.id());
        goto L11
    }

    public final void m(LynxContext r2, c r3, UIBody.UIBodyView r4, LynxBooleanOption r5) {
        if (this.o == true) goto L5;
        this.b = new LynxUIOwner(r2, r3, r4);
    L7:
        if (r4 != null) goto L9;
        this.b.setContextFree(true);
    L9:
        r2.setLynxUIOwner(this.b);
        r2.setUIBody(this.b.getRootUI());
        r2.setUIBodyView(r4);
        this.a = new WeakReference(r2);
        this.h = r5;
        this.o = true;
        return;
    L5:
        this.b.attachLynxContext(r2);
        this.b.attachUIBodyView(r4);
        goto L7
    }
}
