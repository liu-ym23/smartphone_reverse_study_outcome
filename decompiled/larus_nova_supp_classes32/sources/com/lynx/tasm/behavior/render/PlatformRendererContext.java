package com.lynx.tasm.behavior.render;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.mapbuffer.ReadableCompactArrayBuffer;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxUIOwner;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.TextLayout;
import com.lynx.tasm.behavior.shadow.text.d;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.PropBundle;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.behavior.ui.scroll.AndroidScrollView;
import com.lynx.tasm.behavior.utils.LynxUIMethodsExecutor;
import com.lynx.tasm.behavior.x0;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.service.ILynxTextService;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import u7a.m;
import x6a.e;
import x6a.f;
import x6a.g;
import x6a.i;
import y6a.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class PlatformRendererContext implements p {
    public final WeakReference<UIBody.UIBodyView> a;
    public final HashMap<Integer, e> b;
    public c c;
    public final LynxContext d;
    public final com.lynx.tasm.behavior.c e;
    public long f;
    public TextLayout g;
    public boolean h;
    public final ConcurrentHashMap<Integer, Object> i;
    public d j;

    public class a implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ReadableMap c;
        public final /* synthetic */ Callback d;
        public final /* synthetic */ PlatformRendererContext e;

        public final void a() {
            PlatformRendererContext r0 = this.e;
            if (r0.h == false) goto L5;
            return;
        L5:
            if (r0.f == 0) goto L24;
            e r1 = r0.b.get(Integer.valueOf(this.a));
            if (r1 != null) goto L10;
        L12:
            PlatformRendererContext r2 = this.e;
            int r3 = this.a;
            LynxContext r4 = r2.d;
            LynxBaseUI r5 = null;
            if (r4 == null) goto L15;
            LynxUIOwner r6 = r4.getLynxUIOwner();
        L16:
            if (r6 == null) goto L18;
            r5 = r6.getNode(r3);
        L18:
            if (r5 == null) goto L20;
            String r7 = this.b;
            ReadableMap r8 = this.c;
            final Callback r9 = this.d;
            LynxUIMethodsExecutor.b(r5, r7, r8, new g(r9));
            return;
        L20:
            this.d.invoke(new Object[]{6, "node does not have a LynxUI"});
            return;
        L15:
            r6 = null;
            goto L16
        L10:
            if (r1.invokeUIMethod(this.b, this.c, this.d) == false) goto L12;
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(PlatformRendererContext r1, int r2, String r3, ReadableMap r4, f r5) {
            this.e = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ PlatformRendererContext b;

        @Override // java.lang.Runnable
        public final void run() {
            ILynxTextService.a r0 = (ILynxTextService.a) this.b.i.remove(Integer.valueOf(this.a));     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.destroy();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public b(PlatformRendererContext r1, int r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public static final class c {
        public final int a;
        public final int b;
        public final LynxBaseUI c;
        public final e d;

        public final boolean a() {
            LynxBaseUI r0 = this.c;
            if (r0 != null) goto L5;
            e r1 = this.d;
            if (r1 == null) goto L9;
            View r2 = r1.getView();
        L10:
            if (r2 != null) goto L12;
        L14:
            return false;
        L12:
            if (r2.isFocusable() == false) goto L14;
            return true;
        L9:
            r2 = null;
            goto L10
        L5:
            return r0.isFocusable();
        }

        public final void b(boolean r2, boolean r3) {
            LynxBaseUI r0 = this.c;
            if (r0 == null) goto L6;
            r0.onFocusChanged(r2, r3);
            return;
        L6:
            e r4 = this.d;
            if (r4 == null) goto L9;
            View r5 = r4.getView();
        L10:
            if (r5 != null) goto L12;
            return;
        L12:
            if (r2 == false) goto L14;
            r5.requestFocus();
            return;
        L14:
            r5.clearFocus();
            return;
        L9:
            r5 = null;
            goto L10
        }

        public c(int r1, int r2, LynxBaseUI r3, e r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    private native void nativeInvokeUIMethodCallback(long r1, int r3, int r4, Object r5);

    public float[] getRootViewLocationOnScreen() {
        float[] r1 = {0.0f, 0.0f};
        WeakReference<UIBody.UIBodyView> r2 = this.a;
        if (r2 == null) goto L5;
        UIBody.UIBodyView r3 = r2.get();
    L6:
        if (r3 == null) goto L8;
        int[] r0 = new int[2];
        r3.getLocationOnScreen(r0);
        r1[0] = r0[0];
        r1[1] = r0[1];
    L8:
        return r1;
    L5:
        r3 = null;
        goto L6
    }

    public float[] getScreenSize() {
        float[] r0 = {0.0f, 0.0f};
        LynxContext r1 = this.d;
        if (r1 == null) goto L5;
        DisplayMetrics r2 = DisplayMetricsHolder.getRealScreenDisplayMetrics(r1);
        r0[0] = r2.widthPixels;
        r0[1] = r2.heightPixels;
    L5:
        return r0;
    }

    public native long nativeCreateEmbeddedViewContext(PlatformRendererContext r1);

    public native void nativeDestroy(long r1);

    public native void nativeGetDisplayListData(long r1, int r3, int[] r4, int[] r5, float[] r6);

    public native int[] nativeGetDisplayListLengths(long r1, int r3);

    private void finishTasmOperation(long r2) {
        LynxContext r0 = this.d;
        if (r0 == null) goto L5;
        LynxUIOwner r1 = r0.getLynxUIOwner();
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        r1.onTasmFinish(r2);
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // y6a.p
    public final float[] c(int r2) {
        d r0 = this.j;
        if (r0 == null) goto L7;
        return r0.a(r2);
    L7:
        return new float[0];
    }

    public void destroyImage(int r2) {
        UIBody.UIBodyView r0 = this.a.get();
        if (r0 == null) goto L6;
        r0.obtainImageAccordingToNodeIndex(r2);
        return;
    }

    public void destroyPlatformRenderer(int r5) {
        c r0 = this.c;
        boolean r2 = false;
        if (r0 != null) goto L5;
    L13:
        LynxUIOwner r1 = this.d.getLynxUIOwner();
        if (r1 != null) goto L16;
    L18:
        e r3 = this.b.get(Integer.valueOf(r5));
        if (r3 != null) goto L35;
    L33:
        this.b.remove(Integer.valueOf(r5));
        return;
    L35:
        View r4 = r3.getView();     // Catch: Throwable -> L30
        if (r2 == false) goto L26;
        if (r4 == null) goto L26;
        View r6 = (View) r4.getParent();     // Catch: Throwable -> L30
        if ((r6 instanceof ViewGroup) == false) goto L26;
        ((ViewGroup) r6).removeView(r4);     // Catch: Throwable -> L30
    L26:
        i r7 = r3.getRenderer();     // Catch: Throwable -> L30
        if (r7 == null) goto L33;
        r7.f();     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        this.b.remove(Integer.valueOf(r5));
        throw th;
    L16:
        if (r1.getNode(r5) == null) goto L18;
        LynxBaseUI r8 = r1.getNode(r5);
        boolean r9 = true ^ (r8.getParent() instanceof LynxBaseUI);
        r1.destroy(-1, r8.getSign());
        r2 = r9;
        goto L18
    L5:
        if (r0.a != r5) goto L7;
    L10:
        boolean r10 = true;
    L11:
        if (r10 == false) goto L13;
        this.c = null;
        goto L13
    L7:
        if (r0.b == r5) goto L10;
        r10 = false;
        goto L11
    }

    public void destroyTextBundle(int r2) {
        UIThreadUtils.runOnUiThread(new b(this, r2));
    }

    public final d7a.f e(int r2) {
        UIBody.UIBodyView r0 = this.a.get();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.peekImageAccordingToNodeIndex(r2);
    }

    public float[] getRendererHostScrollOffset(int r5) {
        float[] r0 = {0.0f, 0.0f};
        e r6 = this.b.get(Integer.valueOf(r5));
        if ((r6 instanceof AndroidScrollView) == false) goto L5;
        AndroidScrollView r7 = (AndroidScrollView) r6;
        r0[0] = r7.getRealScrollX();
        r0[1] = r7.getRealScrollY();
    L7:
        return r0;
    L5:
        if (r6 == null) goto L7;
        r0[0] = r6.getRendererHostScrollX();
        r0[1] = r6.getRendererHostScrollY();
        goto L7
    }

    public int getTagInfo(String r2) {
        ShadowNode r3 = this.e.c(r2).createShadowNode();
        if (r3 != null) goto L6;
        return 1;
    L6:
        if (r3.p() == false) goto L8;
        return 6;
    L8:
        return 4;
    L11:
        return 0;
    }

    public void invalidatePlatformRenderer(int r2) {
        e r3 = this.b.get(Integer.valueOf(r2));
        if (r3 == null) goto L6;
        r3.invalidateForRenderer();
        return;
    }

    public boolean isRendererHostScrollable(int r2) {
        e r3 = this.b.get(Integer.valueOf(r2));
        LynxBaseUI r0 = null;
        if (r3 == null) goto L5;
        i r4 = r3.getRenderer();
    L6:
        if (r4 == null) goto L8;
        r0 = r4.h;
    L8:
        if (r0 != null) goto L10;
    L12:
        return false;
    L10:
        if (r0.isScrollable() == false) goto L12;
        return true;
    L5:
        r4 = null;
        goto L6
    }

    public void onNodeReadyBatch(int[] r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        LynxContext r0 = this.d;
        if (r0 == null) goto L7;
        LynxUIOwner r1 = r0.getLynxUIOwner();
    L8:
        if (r1 != null) goto L10;
        return;
    L10:
        int r2 = r6.length;
        int r3 = 0;
    L11:
        if (r3 >= r2) goto L17;
        int r4 = r6[r3];
        if (r1.getNode(r4) == null) goto L16;
        r1.onNodeReady(r4);
    L16:
        r3 = r3 + 1;
        goto L11
    L17:
        return;
    L7:
        r1 = null;
        goto L8
    }

    @Override // y6a.p
    public final void b(int r2, ReadableCompactArrayBuffer r3) {
        if (this.j == null) goto L6;
        this.j.c(r2, r3);
        return;
    }

    public void createPlatformRenderer(int r3, int r4) {
        switch(r4) {
            case 1: goto L10;
            case 2: goto L4;
            case 3: goto L10;
            case 4: goto L10;
            case 5: goto L10;
            case 6: goto L10;
            case 7: goto L10;
            default: goto L14;
        };
    L4:
        LynxUIOwner r5 = this.d.getLynxUIOwner();
        if (r5 == null) goto L7;
        r5.setRootSign(r3);
        r5.setNode(r3, this.d.getUIBody());
    L7:
        UIBody.UIBodyView r6 = this.a.get();
        if (r6 == null) goto L12;
        r6.setWillNotDraw(false);
        r6.invalidate();
        i r0 = r6.createRenderer(this, r3);
        r0.h = this.d.getUIBody();
        r0.g = r6;
        r6.setRenderer(r0);
        this.b.put(Integer.valueOf(r3), r6);
        return;
    L12:
        return;
    L10:
        x6a.a r7 = new x6a.a(this.d);
        i r1 = new i(this, r3);
        r1.g = r7;
        r7.setRenderer(r1);
        this.b.put(Integer.valueOf(r3), r7);
        r7.invalidate();
        return;
    }

    public final float f(int r3, boolean r4) {
        e r5 = this.b.get(Integer.valueOf(r3));
        if (r5 != null) goto L5;
        return 1.0f;
    L5:
        if (r5.getView() == null) goto L26;
        View r6 = r5.getView();
        if (Build.VERSION.SDK_INT < 29) goto L19;
        Matrix r0 = r6.getAnimationMatrix();
        if (r0 == null) goto L19;
        if (r0.isIdentity() == true) goto L19;
        float[] r7 = new float[9];
        r0.getValues(r7);
        if (r4 == false) goto L18;
        double r8 = Math.hypot(r7[0], r7[3]);
    L17:
        return (float) r8;
    L18:
        r8 = Math.hypot(r7[1], r7[4]);
    L19:
        if (r4 == false) goto L22;
        return r6.getScaleX();
    L22:
        return r6.getScaleY();
    L26:
        return 1.0f;
    }

    public void updatePlatformExtraData(int r2, Object r3) {
        e r4 = this.b.get(Integer.valueOf(r2));
        if (r4 != null) goto L6;
        LLog.d("PlatformRendererContext", "host renderer not found for sign: " + r2);
        return;
    L6:
        r4.getRenderer();
    }

    public void updateTextBundle(int r2, long r3) {
        ILynxTextService.a r4 = this.d.getTextService().createPage(r3);
        if (r4 == null) goto L6;
        this.i.put(Integer.valueOf(r2), r4);
        return;
    }

    public PlatformRendererContext(UIBody.UIBodyView r4, LynxContext r5, com.lynx.tasm.behavior.c r6) {
        this.a = null;
        this.b = new HashMap();
        this.c = null;
        this.f = 0;
        this.h = false;
        this.i = new ConcurrentHashMap();
        this.j = null;
        if (r4 == null) goto L5;
        this.a = new WeakReference(r4);
    L5:
        this.d = r5;
        this.e = r6;
        this.f = nativeCreateEmbeddedViewContext(this);
        if (r5 != null) goto L8;
        return;
    L8:
        if (r5.isLayoutInElementModeOn() == false) goto L12;
        this.j = new d(r5);
        this.g = new TextLayout(this);
        return;
    }

    public void createPlatformExtendedRenderer(int r17, String r18, PropBundle r19) {
        com.lynx.tasm.behavior.c r1 = this.e;
        if (r1 == null) goto L10;
        com.lynx.tasm.behavior.a r2 = r1.c(r18);
        if (r2.supportFragmentLayerRenderer() == false) goto L11;
        e r3 = r2.createPlatformRendererHost(this.d);
        if (r3 == null) goto L11;
        i r4 = r3.createRenderer(this, r17);
        r4.g = r3;
        r3.setRenderer(r4);
        this.b.put(Integer.valueOf(r17), r3);
        r3.getView().invalidate();
        r4.j(r19);
        return;
    L11:
        LynxUIOwner r14 = this.d.getLynxUIOwner();
        if (r14 == null) goto L54;
        if (r19 == null) goto L15;
        ReadableMap r15 = r19.getProps();
    L16:
        if (r19 == null) goto L18;
        ReadableArray r6 = r19.getEventHandlers();
    L19:
        if (r19 == null) goto L21;
        ReadableArray r9 = r19.getGestures();
    L23:
        if (r15 != null) goto L25;
    L27:
        boolean r5 = false;
    L28:
        if (r5 == false) goto L33;
        if (r2 == null) goto L33;
        if (r2.supportUIFlatten() == false) goto L33;
        boolean r7 = true;
    L34:
        r14.createView(r17, r18, r15, null, r6, r7, r17, r9);
        LynxBaseUI r8 = r14.getNode(r17);
        if ((r8 instanceof LynxUI) == false) goto L42;
        if (r8.isOverlay() == false) goto L42;
        LynxUI r10 = ((LynxUI) r8).getTransitionUI();
        if (r10 == null) goto L42;
        r8 = r10;
    L42:
        if ((r8 instanceof e) == false) goto L45;
        e r11 = (e) r8;
    L50:
        if (r11 == null) goto L53;
        i r12 = r11.createRenderer(this, r17);
        r12.h = r8;
        r12.g = r11;
        r11.setRenderer(r12);
        this.b.put(Integer.valueOf(r17), r11);
        r11.setWillNotDrawForRenderer(false);
        r11.setClipChildrenForRenderer(false);
        r11.invalidateForRenderer();
        r12.j(r19);
        return;
    L53:
        r14.cleanupCreatedView(r17, r18, r15);
        goto L54
    L45:
        if ((r8 instanceof LynxUI) == false) goto L49;
        LynxUI r13 = (LynxUI) r8;
        if ((r13.getView() instanceof e) == false) goto L49;
        r11 = (e) r13.getView();
    L49:
        r11 = null;
    L33:
        r7 = false;
        goto L34
    L25:
        if (r15.getBoolean("__lynx_tends_to_flatten", false) == false) goto L27;
        r5 = true;
        goto L28
    L21:
        r9 = null;
        goto L23
    L18:
        r6 = null;
        goto L19
    L15:
        r15 = null;
    L54:
        x6a.a r16 = new x6a.a(this.d);
        i r20 = new i(this, r17);
        r20.g = r16;
        r16.setRenderer(r20);
        this.b.put(Integer.valueOf(r17), r16);
        r16.invalidate();
        return;
    L10:
        r2 = null;
        goto L11
    }

    public void finishLayoutOperation(int r1, long r2, boolean r4) {
        LynxContext r5 = this.d;
        if (r5 == null) goto L5;
        LynxUIOwner r6 = r5.getLynxUIOwner();
    L6:
        if (r6 != null) goto L8;
        return;
    L8:
        r6.onLayoutFinish(r1, r2);
        return;
    L5:
        r6 = null;
        goto L6
    }

    public void removePlatformRendererFromParent(int r6, int r7, boolean r8) {
        LynxUIOwner r0 = this.d.getLynxUIOwner();
        LynxBaseUI r1 = null;
        if (r0 == null) goto L5;
        LynxBaseUI r2 = r0.getNode(r6);
    L6:
        if (r0 == null) goto L8;
        r1 = r0.getNode(r7);
    L8:
        if (r8 == false) goto L13;
        if (r2 == null) goto L13;
        if (r1 == null) goto L13;
        r0.remove(r6, r7);
        return;
    L13:
        if (r8 == true) goto L18;
        if (r1 == null) goto L18;
        if (r1.isOverlay() == false) goto L18;
        return;
    L18:
        if (r8 == true) goto L36;
        boolean r9 = true;
        if (r2 != null) goto L22;
    L27:
        boolean r4 = false;
    L28:
        if (r4 == true) goto L30;
    L32:
        r9 = false;
    L33:
        if (r9 == false) goto L36;
        r0.remove(r6, r7);
        return;
    L30:
        if (r1.getParentBaseUI() != r2) goto L32;
    L22:
        if (r2.isFlatten() == false) goto L27;
        if (r1 == null) goto L27;
        if (r1.isOverlay() == true) goto L27;
        r4 = true;
    L36:
        e r10 = this.b.get(Integer.valueOf(r7));
        if (r10 == null) goto L44;
        View r11 = r10.getView();
        if (r11 != null) goto L41;
        return;
    L41:
        if ((r11.getParent() instanceof ViewGroup) == false) goto L46;
        ((ViewGroup) r11.getParent()).removeView(r11);
        return;
    L46:
        return;
    L44:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public void updatePlatformRendererAttributes(int r10, PropBundle r11, boolean r12) {
        e r0 = this.b.get(Integer.valueOf(r10));
        if (r0 != null) goto L6;
        LLog.d("PlatformRendererContext", "host renderer not found for sign: " + r10);
        return;
    L6:
        LynxContext r1 = this.d;
        x0 r2 = null;
        if (r1 == null) goto L9;
        LynxUIOwner r3 = r1.getLynxUIOwner();
    L10:
        if (r3 == null) goto L12;
        LynxBaseUI r4 = r3.getNode(r10);
    L13:
        if (r4 == null) goto L37;
        if (r11 == null) goto L16;
        ReadableMap r5 = r11.getProps();
    L17:
        if (r11 == null) goto L19;
        ReadableArray r6 = r11.getEventHandlers();
    L20:
        Map<String, EventsListener> r7 = EventsListener.convertEventListeners(r6);
        if (r11 == null) goto L23;
        ReadableArray r8 = r11.getGestures();
    L24:
        Map<Integer, s7a.a> r9 = s7a.a.a(r8);
        com.lynx.tasm.behavior.c r13 = this.e;
        if (r13 == null) goto L27;
        com.lynx.tasm.behavior.a r14 = r13.c(r4.getTagName());
    L28:
        if (r12 == false) goto L33;
        if (r14 == null) goto L33;
        if (r14.supportUIFlatten() == false) goto L33;
        boolean r15 = true;
    L34:
        if (r5 == null) goto L36;
        r2 = new x0(r5);
    L36:
        r3.updateProperties(r10, r15, r2, r7, r9);
    L33:
        r15 = false;
        goto L34
    L27:
        r14 = null;
        goto L28
    L23:
        r8 = null;
        goto L24
    L19:
        r6 = null;
        goto L20
    L16:
        r5 = null;
    L37:
        i r16 = r0.getRenderer();
        if (r16 == null) goto L41;
        r16.j(r11);
        return;
    L41:
        return;
    L12:
        r4 = null;
        goto L13
    L9:
        r3 = null;
        goto L10
    }

    public void updatePlatformRendererSubtreeProperties(int r7, ByteBuffer r8, int r9) {
        e r0 = this.b.get(Integer.valueOf(r7));
        if (r0 != null) goto L6;
        LLog.d("PlatformRendererContext", "host renderer not found for sign: " + r7);
        return;
    L6:
        i r10 = r0.getRenderer();
        if (r10 == null) goto L24;
        r8.order(ByteOrder.nativeOrder());
        e r11 = r10.g;
        if (r9 <= 0) goto L30;
        if (r11 == null) goto L31;
        int r1 = 0;
    L13:
        if (r1 >= r9) goto L32;
        r8.position(r1 * 68);
        int r2 = r8.getInt();
        if (r2 != 0) goto L21;
        float[] r3 = new float[16];
        int r4 = 0;
    L17:
        if (r4 >= 16) goto L19;
        r3[r4] = r8.getFloat();
        r4 = r4 + 1;
        goto L17
    L19:
        r11.applyRendererTransform(r3);
    L23:
        r1 = r1 + 1;
        goto L13
    L21:
        if (r2 != 1) goto L23;
        r11.applyRendererOpacity(r8.getFloat());
        goto L23
    L32:
        return;
    L31:
        return;
    L30:
        return;
    }

    public static /* synthetic */ void d(PlatformRendererContext r7, long r8, int r10, Object[] r11) {
        if (r7.h == false) goto L5;
        return;
    L5:
        if (r7.f != 0) goto L7;
        return;
    L7:
        if (r8 == 0) goto L25;
        if (r10 < 0) goto L28;
        if (r11 != null) goto L12;
    L21:
        r7.nativeInvokeUIMethodCallback(r8, r10, 0, new JavaOnlyArray());
        return;
    L12:
        if (r11.length == 0) goto L21;
        Object r3 = r11[0];
        if ((r3 instanceof Number) == false) goto L20;
        int r4 = ((Number) r3).intValue();
        Object[] r5 = new Object[r11.length - 1];
        if (r11.length <= 1) goto L19;
        System.arraycopy(r11, 1, r5, 0, r11.length - 1);
    L19:
        r7.nativeInvokeUIMethodCallback(r8, r10, r4, JavaOnlyArray.of(r5));
        return;
    L20:
        r7.nativeInvokeUIMethodCallback(r8, r10, 0, JavaOnlyArray.of(r11));
        return;
    L28:
        return;
    }

    public void insertPlatformRenderer(int r5, int r6, int r7, boolean r8) {
        LynxUIOwner r0 = this.d.getLynxUIOwner();
        LynxBaseUI r1 = null;
        if (r0 == null) goto L5;
        LynxBaseUI r2 = r0.getNode(r5);
    L6:
        if (r0 == null) goto L8;
        r1 = r0.getNode(r6);
    L8:
        if (r8 == false) goto L13;
        if (r2 == null) goto L13;
        if (r1 == null) goto L13;
        r0.insert(r5, r6, r7);
        return;
    L13:
        if (r8 == true) goto L18;
        if (r1 == null) goto L18;
        if (r1.isOverlay() == false) goto L18;
        return;
    L18:
        if (r8 == true) goto L32;
        if (r2 != null) goto L21;
    L26:
        boolean r9 = false;
    L27:
        if (r9 == false) goto L32;
        if (r1.getParentBaseUI() == r2) goto L49;
        r0.insert(r5, r6, r7);
        return;
    L49:
        return;
    L21:
        if (r2.isFlatten() == false) goto L26;
        if (r1 == null) goto L26;
        if (r1.isOverlay() == true) goto L26;
        r9 = true;
    L32:
        e r10 = this.b.get(Integer.valueOf(r5));
        e r11 = this.b.get(Integer.valueOf(r6));
        if (r10 == null) goto L50;
        if (r11 != null) goto L37;
        return;
    L37:
        if ((r10.getView() instanceof ViewGroup) == true) goto L39;
        return;
    L39:
        ViewGroup r12 = (ViewGroup) r10.getView();
        View r13 = r11.getView();
        if (r13 != null) goto L42;
        return;
    L42:
        int r14 = r12.getChildCount();
        if (r7 == (-1)) goto L47;
        if (r7 >= r14) goto L47;
        r12.addView(r13, r7);
        return;
    L47:
        r12.addView(r13);
        return;
    L50:
        return;
    L5:
        r2 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [x6a.f] */
    private void invokeUIMethod(int r7, String r8, ReadableMap r9, final long r10, final int r12) {
        UIThreadUtils.runOnUiThreadImmediately(new a(this, r7, r8, r9, new f(this, r10, r12)));
    }

    @Override // y6a.p
    public final float[] a(int r9, float r10, int r11, float r12, int r13, float[] r14) {
        if (this.j == null) goto L7;
        return this.j.e(r9, r10, r11, r12, r13, r14);
    L7:
        return new float[]{0.0f, 0.0f};
    }

    public void createImage(int r10, String r11, int r12, int r13, int r14, int r15, int r16, boolean r17) {
        d7a.f r8 = new d7a.f(this.d);
        r8.V0 = r10;
        r8.P0 = r15;
        r8.F = r17;
        if (r12 != 1) goto L5;
        m.b r1 = m.b.b;
    L13:
        if (Objects.equals(r1, r8.n) == true) goto L15;
        r8.n = r1;
        r8.a |= 16;
    L15:
        r8.v(r11);
        r8.l(r13, r14, 0, 0, 0, 0);
        UIBody.UIBodyView r2 = this.a.get();
        if (r2 == null) goto L18;
        r2.registerImageAccordingToNodeIndex(r16, r8);
    L18:
        r8.m();
        return;
    L5:
        if (r12 != 2) goto L7;
        r1 = m.b.d;
        goto L13
    L7:
        if (r12 == 3) goto L9;
        r1 = m.b.a;
        goto L13
    L9:
        r1 = m.b.c;
        goto L13
    }

    public void updatePlatformRendererFrame(int r25, boolean r26, int r27, int r28, int r29, int r30, int r31, int r32, int r33, int r34, int r35, int r36, int r37, int r38, int r39, int r40, int r41, int r42, int r43, int r44) {
        e r23 = this.b.get(Integer.valueOf(r25));
        if (r23 != null) goto L6;
        LLog.d("PlatformRendererContext", "host renderer not found for sign: " + r25);
        return;
    L6:
        i r3 = r23.getRenderer();
        int r7 = r27 + r31;
        int r8 = r28 + r32;
        r3.a.set(r7, r8, (r27 + r29) + r31, (r28 + r30) + r32);
        r3.b.set(r31, r32);
        e r1 = r3.g;
        if (r1 != null) goto L10;
    L21:
        LynxUIOwner r2 = this.d.getLynxUIOwner();
        if (r2 != null) goto L24;
    L26:
        r23.requestLayoutForRenderer();
        r23.getRenderer().e(3);
        return;
    L24:
        if (r2.getNode(r25) == null) goto L26;
        r2.updateLayout(r25, r7, r8, r29, r30, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, null, null, 0.0f, r25);
        goto L26
    L10:
        if (r26 == false) goto L12;
        r1.applyRendererClipBounds(true, new Rect(0, 0, r3.a.width(), r3.a.height()));
        goto L21
    L12:
        View r4 = r1.getView();
        LynxBaseUI r5 = r3.h;
        if (r5 != null) goto L15;
    L16:
        if (r4 != null) goto L18;
    L20:
        r3.g.applyRendererClipBounds(false, null);
        goto L21
    L18:
        if ((r4.getParent() instanceof ViewGroup) == false) goto L20;
        ViewGroup r6 = (ViewGroup) r4.getParent();
        r6.setClipChildren(false);
        r6.setClipToPadding(false);
        goto L20
    L15:
        if (r5.isFlatten() == true) goto L20;
        goto L16
    }
}
