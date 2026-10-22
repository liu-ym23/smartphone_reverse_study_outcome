package com.lynx.tasm;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.lynx.devtoolwrapper.DevToolOverlayDelegate;
import com.lynx.devtoolwrapper.IDevToolDelegate;
import com.lynx.devtoolwrapper.ScreenshotBitmapHandler;
import com.lynx.devtoolwrapper.ScreenshotMode;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.ILynxUIRenderer;
import com.lynx.tasm.behavior.LynxUIOwner;
import com.lynx.tasm.behavior.LynxUIRenderer;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.utils.UIThreadUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class r implements IDevToolDelegate {
    public final WeakReference<LynxTemplateRender> a;

    public class a implements Runnable {
        public final /* synthetic */ ReadableMap a;
        public final /* synthetic */ r b;

        /* JADX INFO: renamed from: com.lynx.tasm.r$a$a, reason: collision with other inner class name */
        public class RunnableC0063a implements Runnable {
            public final /* synthetic */ a a;

            @Override // java.lang.Runnable
            public final void run() {
                LynxTemplateRender r0 = this.a.b.a.get();     // Catch: Throwable -> L7
                if (r0 == null) goto L10;
                r0.dispatchMessageEvent(this.a.a);     // Catch: Throwable -> L7
                return;
            L10:
                return;
            L7:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L14;
                throw th;
            }

            public RunnableC0063a(a r1) {
                this.a = r1;
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            UIThreadUtils.runOnUiThreadImmediately(new RunnableC0063a(this));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(r r1, ReadableMap r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public final ILynxUIRenderer a() {
        LynxTemplateRender r0 = this.a.get();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.lynxUIRenderer();
    }

    @Override // com.lynx.devtoolwrapper.IDevToolDelegate
    public final String getActualScreenshotMode() {
        ILynxUIRenderer r0 = a();
        if (r0 != null) goto L5;
        return ScreenshotMode.SCREEN_SHOT_MODE_FULL_SCREEN;
    L5:
        return ((LynxUIRenderer) r0).g;
    }

    @Override // com.lynx.devtoolwrapper.IDevToolDelegate
    public final Bitmap getBitmapOfView() {
        ILynxUIRenderer r0 = a();
        if (r0 != null) goto L5;
        return null;
    L5:
        return ((LynxUIRenderer) r0).f();
    }

    public r(LynxTemplateRender r2) {
        this.a = null;
        this.a = new WeakReference(r2);
    }

    @Override // com.lynx.devtoolwrapper.IDevToolDelegate
    public final void onDispatchMessageEvent(ReadableMap r2) {
        UIThreadUtils.runOnUiThreadImmediately(new a(this, r2));
    }

    @Override // com.lynx.devtoolwrapper.IDevToolDelegate
    public final void scrollIntoViewFromUI(int r4) {
        ILynxUIRenderer r0 = a();
        if (r0 == null) goto L13;
        LynxUIRenderer r1 = (LynxUIRenderer) r0;
        LynxUIOwner r2 = r1.b;
        if (r2 != null) goto L7;
        return;
    L7:
        if (r2.getRootSign() == (-1)) goto L16;
        LynxBaseUI r5 = r1.b.getNode(r4);
        if (r5 == null) goto L15;
        r5.scrollIntoView(false, "center", "center", null);
        return;
    L15:
        return;
    L16:
        return;
    }

    @Override // com.lynx.devtoolwrapper.IDevToolDelegate
    public final float[] getTransformValue(int r2, float[] r3) {
        ILynxUIRenderer r0 = a();
        if (r0 == null) goto L7;
        return ((LynxUIRenderer) r0).i(r2, r3);
    L7:
        return new float[0];
    }

    @Override // com.lynx.devtoolwrapper.IDevToolDelegate
    public final void takeScreenshot(ScreenshotBitmapHandler r18, String r19) {
        ILynxUIRenderer r1 = a();
        if (r1 == null) goto L51;
        LynxUIRenderer r2 = (LynxUIRenderer) r1;
        r2.g = r19;
        if (r19 != null) goto L7;
    L9:
        LynxView r0 = r2.a.get().getLynxView();
        if (r0 != null) goto L12;
    L43:
        Bitmap r3 = null;
    L44:
        r18.sendBitmap(r3);
        return;
    L12:
        if (r0.getWidth() <= 0) goto L43;
        if (r0.getHeight() <= 0) goto L43;
        if (r0.getContext() == null) goto L21;
        WindowManager r4 = (WindowManager) r0.getContext().getSystemService("window");
        if (r4 == null) goto L21;
        Display r5 = r4.getDefaultDisplay();
        DisplayMetrics r6 = new DisplayMetrics();
        r5.getRealMetrics(r6);
        Bitmap r7 = Bitmap.createBitmap(r6.widthPixels, r6.heightPixels, Bitmap.Config.ARGB_8888);
    L24:
        if (r7 != null) goto L26;
        LLog.i("LynxUIRenderer", "getBitmapOfScreen: get null from createScreenBitmap");
        goto L43
    L26:
        View r8 = r0.getRootView();
        if (r8 != null) goto L29;
        LLog.e("LynxUIRenderer", "getBitmapOfScreen: lynxDecoderView is null");
        goto L43
    L29:
        Canvas r9 = new Canvas(r7);
        r9.drawColor(LynxUIRenderer.h(r8));
        ArrayList<Dialog> r10 = DevToolOverlayDelegate.getInstance().getGlobalOverlayView();
        ArrayList r11 = new ArrayList();
        if (r10 == null) goto L39;
        int r12 = r10.size() - 1;
    L32:
        if (r12 < 0) goto L39;
        View r13 = ((Dialog) ListProtector.get(r10, r12)).getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L38;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r14 = ThreadMethodProxy.currentThread();
        if (r14 == com.larus.home.impl.utils.c.a) goto L38;
        com.larus.home.impl.utils.c.a(r14, "getDecorView");
    L38:
        r11.add(r13);
        r12 = r12 - 1;
    L39:
        Bitmap r15 = Bitmap.createBitmap(r8.getWidth(), r8.getHeight(), Bitmap.Config.ARGB_8888);
        r2.d(r8, new Canvas(r15));
        int r16 = 2;
        int[] r17 = new int[2];
        r8.getLocationOnScreen(r17);
        int r110 = r17[0];
        r9.drawBitmap(r15, null, new Rect(r110, r17[1], r8.getWidth() + r110, r17[1] + r8.getHeight()), null);
        r15.recycle();
        int r20 = r11.size();
        int r21 = 0;
    L40:
        if (r21 >= r20) goto L42;
        View r22 = (View) ListProtector.get(r11, r21);
        Bitmap r111 = Bitmap.createBitmap(r22.getWidth(), r22.getHeight(), Bitmap.Config.ARGB_8888);
        r2.d(r22, new Canvas(r111));
        int[] r112 = new int[r16];
        r22.getLocationOnScreen(r112);
        int r113 = r112[0];
        r9.drawBitmap(r111, null, new Rect(r113, r112[1], r22.getWidth() + r113, r112[1] + r22.getHeight()), null);
        r111.recycle();
        r21 = r21 + 1;
        r16 = 2;
        goto L40
    L42:
        r3 = r7;
    L21:
        r7 = null;
        goto L24
    L7:
        if (r19.equals(ScreenshotMode.SCREEN_SHOT_MODE_LYNX_VIEW) == false) goto L9;
        r3 = r2.f();
        goto L44
    }

    @Override // com.lynx.devtoolwrapper.IDevToolDelegate
    public final int getNodeForLocation(float r8, float r9, String r10) {
        ILynxUIRenderer r0 = a();
        if (r0 == null) goto L27;
        LynxUIRenderer r1 = (LynxUIRenderer) r0;
        if (r10 != null) goto L8;
        return 0;
    L8:
        if (r10.equals(ScreenshotMode.SCREEN_SHOT_MODE_FULL_SCREEN) == false) goto L20;
        ArrayList<Integer> r2 = DevToolOverlayDelegate.getInstance().getAllVisibleOverlaySign();
        if (r2 == null) goto L19;
        int r3 = r2.size();
        int r4 = 0;
    L12:
        if (r4 >= r3) goto L19;
        int r5 = r1.e(r8, r9, ((Integer) ListProtector.get(r2, r4)).intValue(), r10);
        if (r5 == 0) goto L18;
        if (r5 == ((Integer) ListProtector.get(r2, r4)).intValue()) goto L18;
        return r5;
    L18:
        r4 = r4 + 1;
    L19:
        int r11 = r1.e(r8, r9, 0, r10);
    L22:
        return r11;
    L20:
        r11 = r1.e(r8, r9, 0, r10);
        goto L22
    L27:
        return 0;
    }
}
