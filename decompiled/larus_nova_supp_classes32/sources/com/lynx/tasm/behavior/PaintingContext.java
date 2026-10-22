package com.lynx.tasm.behavior;

import android.graphics.PointF;
import android.graphics.Rect;
import android.os.SystemClock;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.WritableArray;
import com.lynx.react.bridge.mapbuffer.ReadableCompactArrayBuffer;
import com.lynx.react.bridge.mapbuffer.ReadableMapBuffer;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.shadow.TextLayout;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.PropBundle;
import com.lynx.tasm.behavior.ui.list.container.UIListContainer;
import com.lynx.tasm.behavior.ui.text.FlattenUIText;
import com.lynx.tasm.behavior.ui.text.UIText;
import com.lynx.tasm.behavior.ui.view.UIComponent;
import com.lynx.tasm.behavior.utils.LynxUIMethodsExecutor;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.performance.PerformanceController;
import com.lynx.tasm.recording.LynxFrameRecorder;
import com.lynx.tasm.service.ILynxTextService;
import com.lynx.tasm.utils.UIThreadUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class PaintingContext implements l {
    public final LynxUIOwner a;
    public final TextLayout b;
    public boolean c;
    public final ConcurrentHashMap<String, Boolean> d;
    public final ConcurrentHashMap<String, Boolean> e;
    public final long f;
    public long g;
    public final ConcurrentHashMap<Integer, ILynxTextService.a> h;

    public class a implements Runnable {
        public final /* synthetic */ Future a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ ReadableMap d;
        public final /* synthetic */ ReadableMapBuffer e;
        public final /* synthetic */ ReadableArray f;
        public final /* synthetic */ boolean g;
        public final /* synthetic */ int h;
        public final /* synthetic */ ReadableArray i;
        public final /* synthetic */ PaintingContext j;

        public final void a() {
            PaintingContext r0 = this.j;
            Future r1 = this.a;
            int r11 = this.b;
            String r12 = this.c;
            ReadableMap r5 = this.d;
            ReadableMapBuffer r6 = this.e;
            ReadableArray r7 = this.f;
            boolean r8 = this.g;
            int r9 = this.h;
            ReadableArray r10 = this.i;
            r0.getClass();
            Runnable r4 = null;
            if (r1.isDone() == true) goto L16;
            int r2 = !r1.cancel(true) ? 1 : 0;
            LLog.i("lynx_PaintingContext", "createViewAsync not done, will create on ui thread, tagName:" + r12);
        L11:
            if (r4 == null) goto L13;
            r4.run();
            r0.a.reportCreateAsyncSuccessEvent(r11, r12, true, r2);
        L14:
            this.j.a.reportCreateViewConfig(this.b, this.c, true);
            return;
        L13:
            r0.a.createView(r11, r12, r5, r6, r7, r8, r9, r10);
            r0.a.reportCreateAsyncSuccessEvent(r11, r12, false, r2);
            goto L14
        L16:
            r4 = (Runnable) r1.get();     // Catch: ExecutionException -> L7 Throwable -> L9
            r2 = 2;
        L9:
            e = move-exception;
            String r3 = "createViewAsync failed, tagName:" + r12 + ", error:" + e;
            LLog.e("lynx_PaintingContext", r3);
            r0.a.getContext().handleException(new Exception(r3));
            r2 = 3;
            goto L11
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

        public a(PaintingContext r1, Future r2, int r3, String r4, ReadableMap r5, ReadableMapBuffer r6, ReadableArray r7, boolean r8, int r9, ReadableArray r10) {
            this.j = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ String b;
        public final /* synthetic */ PropBundle c;
        public final /* synthetic */ ReadableMapBuffer d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ int f;
        public final /* synthetic */ PaintingContext g;

        @Override // java.lang.Runnable
        public final void run() {
            this.g.createPaintingNodeSync(this.a, this.b, this.c, this.d, this.e, this.f);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(PaintingContext r1, int r2, String r3, PropBundle r4, ReadableMapBuffer r5, boolean r6, int r7) {
            this.g = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ long a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;
        public final /* synthetic */ ReadableMap e;
        public final /* synthetic */ PaintingContext f;

        public final void b() {
            LynxBaseUI r0 = this.f.a.getNode(this.c);
            if (r0 == null) goto L5;
            LynxUIMethodsExecutor.b(r0, this.d, this.e, new o0(this));
            return;
        L5:
            a(new Object[]{6, String.format("Worklet: node %d does not have a LynxUI", new Object[]{Integer.valueOf(this.c)})});
        }

        @Override // java.lang.Runnable
        public final void run() {
            b();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public final void a(final Object... r9) {
            PaintingContext r0 = this.f;
            if (r0.c == false) goto L5;
            return;
        L5:
            if (r0.a.getContext() == null) goto L10;
            LynxContext r1 = this.f.a.getContext();
            final long r3 = this.a;
            final int r5 = this.b;
            r1.runOnTasmThread(new p0(this, r3, r5, r9));
            return;
        }

        public c(PaintingContext r1, long r2, int r4, int r5, String r6, ReadableMap r7) {
            this.f = r1;
            this.a = r2;
            this.b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r7;
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ PaintingContext a;

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (this.a.a.getRootUI() == null) goto L9;
            this.a.a.getRootUI().requestLayout();     // Catch: Throwable -> L6
            return;
        }

        public d(PaintingContext r1) {
            this.a = r1;
        }
    }

    private native long nativeCreatePaintingContext(Object r1, Object r2, long r3, int r5, boolean r6);

    private native void nativeInvokeCallback(long r1, int r3, WritableArray r4);

    @Override // com.lynx.tasm.behavior.l
    public final boolean c(MotionEvent r1, int r2) {
        return false;
    }

    @Override // com.lynx.tasm.behavior.l
    public final void d(long r1) {
    }

    @Override // com.lynx.tasm.behavior.l
    public final void destroy() {
        this.c = true;
        Iterator<ILynxTextService.a> r0 = this.h.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        ILynxTextService.a r1 = r0.next();
        if (r1 == null) goto L4;
        r1.destroy();
        goto L4
    L8:
        this.h.clear();
        this.g = 0;
    }

    @Override // com.lynx.tasm.behavior.l
    public final void e() {
    }

    @Override // com.lynx.tasm.behavior.l
    public final void f() {
    }

    @Override // com.lynx.tasm.behavior.l
    public final void i() {
    }

    public final int k() {
        LynxUIOwner r0 = this.a;
        if (r0 == null) goto L5;
        LynxContext r1 = r0.getContext();
    L6:
        if (r1 != null) goto L10;
        return -1;
    L10:
        return r1.getInstanceId();
    L5:
        r1 = null;
        goto L6
    }

    public final boolean n() {
        return LynxFrameRecorder.k.k(k());
    }

    public void rebuildViewTree() {
        this.a.rebuildViewTree();
    }

    public void requestLayout() {
        UIThreadUtils.runOnUiThreadImmediately(new d(this));
    }

    public void resumeExposure() {
        LynxContext r0 = this.a.getContext();
        if (r0 == null) goto L6;
        r0.resumeExposure();
        return;
    }

    @Override // com.lynx.tasm.behavior.l
    public final long a() {
        return this.f;
    }

    private void finishTasmOperation(long r2) {
        this.a.onTasmFinish(r2);
    }

    private void flushUIOperationBatch(ReadableCompactArrayBuffer r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        Iterator<com.lynx.react.bridge.mapbuffer.a.InterfaceC0048a> r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L40;
        int r0 = r11.next().a();
        int r1 = 0;
        switch(r0) {
            case 0: goto L39;
            case 1: goto L38;
            case 2: goto L37;
            case 3: goto L33;
            case 4: goto L29;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            default: goto L9;
        };
    L9:
        LLog.e("lynx_PaintingContext", "flushUIOperationBatch with unknown UIOperationType: " + r0);
        return;
    L12:
        finishTasmOperation(r11.next().c());
        goto L6
    L13:
        int r2 = r11.next().a();
        int[] r3 = new int[r2];
        int r4 = 0;
    L14:
        if (r4 >= r2) goto L16;
        r3[r4] = r11.next().a();
        r4 = r4 + 1;
        goto L14
    L16:
        int r5 = r11.next().a();
        int[] r6 = new int[r5];
        int r7 = 0;
    L17:
        if (r7 >= r5) goto L19;
        r6[r7] = r11.next().a();
        r7 = r7 + 1;
        goto L17
    L19:
        int r8 = r11.next().a();
        float[] r9 = new float[r8];
        int r12 = 0;
    L20:
        if (r12 >= r8) goto L22;
        r9[r12] = (float) r11.next().b();
        r12 = r12 + 1;
        goto L20
    L22:
        int r13 = r11.next().a();
        float[] r14 = new float[r13];
        int r15 = 0;
    L23:
        if (r15 >= r13) goto L25;
        r14[r15] = (float) r11.next().b();
        r15 = r15 + 1;
        goto L23
    L25:
        int r16 = r11.next().a();
        int[] r17 = new int[r16];
    L26:
        if (r1 >= r16) goto L28;
        r17[r1] = r11.next().a();
        r1 = r1 + 1;
        goto L26
    L28:
        UpdateLayoutPatching(r3, r6, r9, r14, r17);
        goto L6
    L29:
        int r18 = r11.next().a();
        int[] r19 = new int[r18];
    L30:
        if (r1 >= r18) goto L32;
        r19[r1] = r11.next().a();
        r1 = r1 + 1;
        goto L30
    L32:
        w(r19);
        goto L6
    L33:
        int r20 = r11.next().a();
        int[] r21 = new int[r20];
    L34:
        if (r1 >= r20) goto L36;
        r21[r1] = r11.next().a();
        r1 = r1 + 1;
        goto L34
    L36:
        v(r21);
        goto L6
    L37:
        destroyNode(r11.next().a(), r11.next().a());
        goto L6
    L38:
        removeNode(r11.next().a(), r11.next().a());
        goto L6
    L39:
        insertNode(r11.next().a(), r11.next().a(), r11.next().a());
        goto L6
    L11:
        FinishLayoutOperation(r11.next().a(), r11.next().c(), true);
        goto L6
    }

    private float[] getRectToScreen(int r2) {
        return s(r2, true);
    }

    private void markUIOperationQueueFlushForRecreateEngine(boolean r2) {
        LynxUIOwner r0 = this.a;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.getContext() != null) goto L8;
        return;
    L8:
        this.a.getContext().markFallbackProcess(r2);
    }

    public static String u(ILynxTextService.a r3) {
        if (r3 != null) goto L13;
        return null;
    L13:
        int r1 = r3.a();     // Catch: RuntimeException -> L10
        if (r1 >= 0) goto L8;
        return null;
    L8:
        return r3.b(0, r1);
    L10:
        e = move-exception;
        LLog.e("lynx_PaintingContext", "record text page failed: " + e);
        return null;
    }

    @Override // com.lynx.tasm.behavior.l
    public final int b(int r2) {
        LynxBaseUI r3 = this.a.getNode(r2);
        if (r3 != null) goto L7;
        LLog.e("lynx_PaintingContext", "getTargetWidth failed since can not find target ui.");
        return 0;
    L7:
        return r3.getWidth();
    }

    public void destroyTextBundle(int r2) {
        ILynxTextService.a r3 = this.h.remove(Integer.valueOf(r2));
        if (r3 == null) goto L6;
        r3.destroy();
        return;
    }

    public float[] getBoundingClientOrigin(int r4) {
        float[] r0 = {0.0f, 0.0f};
        LynxBaseUI r5 = this.a.getNode(r4);
        if (r5 == null) goto L5;
        Rect r6 = r5.getBoundingClientRect();
        r0[0] = r6.left;
        r0[1] = r6.top;
    L5:
        return r0;
    }

    public float[] getRectToLynxView(int r2) {
        return s(r2, false);
    }

    public float[] getRectToWindow(int r4) {
        float[] r0 = {0.0f, 0.0f, 0.0f, 0.0f};
        LynxBaseUI r5 = this.a.getNode(r4);
        if (r5 == null) goto L5;
        Rect r6 = r5.getRectToWindow();
        r0[0] = r6.left;
        r0[1] = r6.top;
        r0[2] = r6.width();
        r0[3] = r6.height();
    L5:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v2, types: [int] */
    public int getTagInfo(String r7) {
        int r0 = this.a.getTagInfo(r7);
        if ((r0 & 2) <= 0) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == true) goto L9;
        boolean r2 = o(r7, -1);
        if (this.e.containsKey(r7) == false) goto L13;
        ?? r8 = this.e.get(r7).booleanValue();
    L15:
        return ((r8 << 17) | ((r2 ? 1 : 0) << 16)) | (r0 & 65535);
    L13:
        boolean r3 = this.a.behaviorNeedProcessDirection(r7);
        this.e.put(r7, Boolean.valueOf(r3));
        r8 = r3;
        goto L15
    L9:
        return r0 & 65535;
    L5:
        r1 = false;
        goto L7
    }

    public float[] getWindowSize(int r4) {
        float[] r5 = new float[2];
        WindowManager r0 = (WindowManager) this.a.getContext().getContext().getSystemService("window");
        if (r0 != null) goto L6;
        return null;
    L6:
        Display r1 = r0.getDefaultDisplay();
        DisplayMetrics r2 = new DisplayMetrics();
        r1.getRealMetrics(r2);
        r5[0] = r2.widthPixels;
        r5[1] = r2.heightPixels;
        return r5;
    }

    @Override // com.lynx.tasm.behavior.l
    public final int h(int r2) {
        LynxBaseUI r3 = this.a.getNode(r2);
        if (r3 != null) goto L7;
        LLog.e("lynx_PaintingContext", "getTargetHeight failed since can not find target ui.");
        return 0;
    L7:
        return r3.getHeight();
    }

    public final float[] l(int r4) {
        float[] r0 = {0.0f, 0.0f, 0.0f, 0.0f};
        LynxBaseUI r5 = this.a.getNode(r4);
        if (r5 == null) goto L5;
        Rect r6 = r5.getBoundingClientRect();
        r0[0] = r6.left;
        r0[1] = r6.top;
        r0[2] = r6.width();
        r0[3] = r6.height();
    L5:
        return r0;
    }

    public final float[] m(int r9) {
        float[] r0 = {0.0f, 0.0f, 0.0f, 0.0f};
        LynxBaseUI r10 = this.a.getNode(r9);
        if (r10 == null) goto L5;
        float[] r2 = {0.0f, 0.0f};
        r10.getLocationOnScreen(r2);
        float r4 = r2[0];
        float r6 = r2[1];
        r2[0] = r10.getWidth();
        r2[1] = r10.getHeight();
        r10.getLocationOnScreen(r2);
        r0[0] = r4;
        r0[1] = r6;
        r0[2] = r2[0] - r4;
        r0[3] = r2[1] - r6;
    L5:
        return r0;
    }

    public void scrollIntoView(int r4) {
        LynxBaseUI r5 = this.a.getNode(r4);
        if (r5 != null) goto L5;
        return;
    L5:
        r5.scrollIntoView(false, "center", "center", null);
    }

    public void setKeyframes(PropBundle r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.getProps() == null) goto L9;
        this.a.getContext().removeAnimationKeyframe(r4.getProps().getString("removeKeyframe"));
        this.a.getContext().setKeyframes(r4.getProps().getMap("keyframes"));
        return;
    }

    public void setNeedMarkPaintEndTiming(String r3) {
        LynxUIOwner r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        LynxContext r1 = r0.getContext();
        if (r1 != null) goto L8;
        return;
    L8:
        PerformanceController r2 = r1.getPerfController();
        if (r2 != null) goto L12;
        return;
    L12:
        if (r2.e == false) goto L14;
        return;
    L14:
        if (UIThreadUtils.isOnUiThread() == false) goto L19;
        r2.g.add(r3);
        return;
    }

    public void stopExposure(ReadableMap r2) {
        LynxContext r0 = this.a.getContext();
        if (r0 == null) goto L6;
        r0.stopExposure(r2.asHashMap());
        return;
    }

    public void updateEventInfo(boolean r2) {
        this.a.setHasTouchPseudo(r2);
    }

    public void updateNodeReloadPatching(int[] r5) {
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        int r2 = r5[r1];
        this.a.onNodeReload(r2);
        r1 = r1 + 1;
        goto L3
    }

    public final void v(int[] r6) {
        int r0 = r6.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        int r2 = r6[r1];
        ILynxTextService.a r3 = this.h.get(Integer.valueOf(r2));
        if (r3 == null) goto L7;
        this.a.updateViewExtraData(r2, r3);
    L7:
        this.a.onNodeReady(r2);
        r1 = r1 + 1;
        goto L3
    }

    public void validate(int r2) {
        this.a.validate(r2);
    }

    public final void w(int[] r6) {
        int r0 = r6.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        int r2 = r6[r1];
        ILynxTextService.a r3 = this.h.remove(Integer.valueOf(r2));
        if (r3 == null) goto L7;
        r3.destroy();
    L7:
        this.a.onNodeRemoved(r2);
        r1 = r1 + 1;
        goto L3
    }

    public PaintingContext(LynxUIOwner r10, int r11) {
        this.f = 0;
        this.g = 0;
        this.h = new ConcurrentHashMap();
        this.a = r10;
        this.c = false;
        this.d = new ConcurrentHashMap();
        this.e = new ConcurrentHashMap();
        if (r10.getContext().isLayoutInElementModeOn() == false) goto L9;
        this.b = new TextLayout(r10);
        if (r10.getContext().isTextServiceModeOn() == false) goto L9;
        if (r10.getContext().getTextService() == null) goto L9;
        this.g = r10.getContext().getTextService().createTextLayoutAPI(r10.getContext());
    L9:
        this.f = nativeCreatePaintingContext(this, this.b, this.g, r11, r10.isContextFree());
    }

    private void setFrameAppBundle(int r2, TemplateBundle r3) {
        this.a.setFrameAppBundle(r2, r3);
    }

    public void destroyNode(int r3, int r4) {
        q(105, r3, r4, null);
        this.a.destroy(r3, r4);
    }

    @Override // com.lynx.tasm.behavior.l
    public final PointF g(int r4, PointF r5) {
        LynxBaseUI r6 = this.a.getNode(r4);
        if (r6 != null) goto L6;
        LLog.e("lynx_PaintingContext", "convertPointInViewToScreen failed since can not find target ui.");
        return r5;
    L6:
        float[] r7 = r6.getLocationOnScreen(new float[]{r5.x, r5.y});
        return new PointF(r7[0], r7[1]);
    }

    public void insertListItemNode(int r3, int r4) {
        if (TraceEvent.isTracingStarted() == false) goto L5;
        String r0 = "PaintingContext.insertListItemNode." + r3 + "_" + r4;
        TraceEvent.beginSection(r0);
    L6:
        LynxBaseUI r5 = this.a.getNode(r3);
        LynxBaseUI r6 = this.a.getNode(r4);
        if ((r5 instanceof UIListContainer) == false) goto L12;
        if ((r6 instanceof UIComponent) == false) goto L12;
        ((UIListContainer) r5).W(r6);
    L12:
        if (TraceEvent.isTracingStarted() == false) goto L15;
        TraceEvent.endSection(r0);
        return;
    L15:
        return;
    L5:
        r0 = null;
        goto L6
    }

    public void listCellAppear(int r2, String r3) {
        this.a.listCellAppear(r2, r3);
    }

    public final boolean o(String r3, int r4) {
        LynxUIOwner r0 = this.a;
        boolean r1 = false;
        if (r0 == null) goto L12;
        if (r0.getContext() == null) goto L12;
        if (this.a.getContext().isFallbackProcess() == false) goto L12;
        if (this.a.getContext().getUIBodyView().containsViewForNodeIndex(r4) == false) goto L12;
        return false;
    L12:
        if (this.d.containsKey(r3) == false) goto L16;
        return this.d.get(r3).booleanValue();
    L16:
        if (LynxEnv.inst().getCreateViewAsync() == true) goto L19;
    L22:
        this.d.put(r3, Boolean.valueOf(r1));
        return r1;
    L19:
        if (this.a.getEnableCreateViewAsync() == false) goto L22;
        r1 = this.a.behaviorSupportCreateAsync(r3);
        goto L22
    }

    public final void r(int r9, Object r10) {
        if (n() == true) goto L5;
        return;
    L5:
        String r1 = null;
        if ((r10 instanceof z6a.w) == false) goto L19;
        z6a.w r11 = (z6a.w) r10;
        if (r11 == null) goto L21;
        CharSequence r0 = r11.g;
        if (r0 != null) goto L16;
        Layout r12 = r11.c;
        if (r12 == null) goto L15;
        r0 = r12.getText();
        goto L16
    L15:
        r0 = null;
    L16:
        if (r0 == null) goto L21;
        r1 = r0.toString();
    L21:
        if (r1 != null) goto L23;
        return;
    L23:
        LynxFrameRecorder r2 = LynxFrameRecorder.k;
        int r3 = k();
        r2.getClass();
        r2.p(r3, 109, new LynxFrameRecorder.q(r9, "text", r1), SystemClock.uptimeMillis());
        return;
    L19:
        if ((r10 instanceof ILynxTextService.a) == false) goto L21;
        r1 = u((ILynxTextService.a) r10);
        goto L21
    }

    public void removeListItemNode(int r3, int r4) {
        if (TraceEvent.isTracingStarted() == false) goto L5;
        String r0 = "PaintingContext.removeListItemNode." + r3 + "_" + r4;
        TraceEvent.beginSection(r0);
    L6:
        LynxBaseUI r5 = this.a.getNode(r3);
        LynxBaseUI r6 = this.a.getNode(r4);
        if ((r5 instanceof UIListContainer) == false) goto L12;
        if ((r6 instanceof UIComponent) == false) goto L12;
        ((UIListContainer) r5).removeView(r6);
    L12:
        if (TraceEvent.isTracingStarted() == false) goto L15;
        TraceEvent.endSection(r0);
        return;
    L15:
        return;
    L5:
        r0 = null;
        goto L6
    }

    public void removeNode(int r3, int r4) {
        q(104, r3, r4, null);
        this.a.remove(r3, r4);
    }

    public void reuseListNode(int r2, String r3) {
        this.a.reuseListNode(r2, r3);
    }

    public final float[] s(final int r11, final boolean r12) {
        if (UIThreadUtils.isOnUiThread() == false) goto L8;
        if (r12 == false) goto L7;
        return m(r11);
    L7:
        return l(r11);
    L8:
        float[] r0 = {0.0f, 0.0f, 0.0f, 0.0f};
        if (r12 == false) goto L12;
        r0 = {x0052: FILL_ARRAY_DATA  (LINE:33554514), data: [0, 0, -1082130432, -1082130432} // fill-array;
    L12:
        final AtomicReference r7 = new AtomicReference(r0);
        final CountDownLatch r8 = new CountDownLatch(1);
        UIThreadUtils.postAtFrontOfQueueOnUiThread(new n0(this, r7, r12, r11, r8));
        if (r8.await(1000, TimeUnit.MILLISECONDS) == true) goto L17;
        return r0;
    L17:
        return (float[]) r7.get();
    L18:
        ThreadMethodProxy.currentThread().interrupt();
        return r0;
    }

    public void updateExtraData(int r2, Object r3) {
        r(r2, r3);
        this.a.updateViewExtraData(r2, r3);
    }

    public void updateFlattenStatus(int r2, boolean r3) {
        this.a.updateFlatten(r2, r3);
    }

    public void updateNodeReadyPatching(int[] r1, int[] r2) {
        v(r1);
        w(r2);
    }

    public void updateTextBundle(int r2, long r3) {
        if (this.c == false) goto L5;
        return;
    L5:
        if (this.a.getContext() != null) goto L7;
        return;
    L7:
        if (this.a.getContext().getTextService() == null) goto L19;
        ILynxTextService.a r4 = this.a.getContext().getTextService().createPage(r3);
        if (r4 != null) goto L12;
        return;
    L12:
        r(r2, r4);
        ILynxTextService.a r5 = this.h.put(Integer.valueOf(r2), r4);
        if (r5 == null) goto L15;
        r5.destroy();
    L15:
        this.a.updateViewExtraData(r2, r4);
        return;
    }

    public void FinishLayoutOperation(int r1, long r2, boolean r4) {
        this.a.onLayoutFinish(r1, r2);
    }

    public void SetGestureDetectorState(int r2, int r3, int r4) {
        this.a.setGestureDetectorState(r2, r3, r4);
    }

    public void consumeGesture(int r2, int r3, ReadableMap r4) {
        this.a.consumeGesture(r2, r3, r4);
    }

    public void insertNode(int r3, int r4, int r5) {
        q(103, r3, r4, Integer.valueOf(r5));
        this.a.insert(r3, r4, r5);
    }

    public void listCellDisappear(int r2, boolean r3, String r4) {
        this.a.listCellDisappear(r2, Boolean.valueOf(r3), r4);
    }

    public float[] scrollBy(final int r8, final float r9, final float r10) {
        if (UIThreadUtils.isOnUiThread() == false) goto L10;
        LynxBaseUI r11 = this.a.getNode(r8);
        if (r11 == null) goto L9;
        return r11.scrollBy(r9, r10);
    L9:
        return new float[]{0.0f, 0.0f, r9, r10};
    L10:
        UIThreadUtils.runOnUiThread(new m0(this, r8, r9, r10));
        return new float[]{0.0f, 0.0f, r9, r10};
    }

    public static /* synthetic */ void j(PaintingContext r0, long r1, int r3, JavaOnlyArray r4) {
        r0.nativeInvokeCallback(r1, r3, r4);
    }

    public final void p(int r8, String r9, PropBundle r10, ReadableMapBuffer r11) {
        if (n() == true) goto L5;
        return;
    L5:
        LynxFrameRecorder r1 = LynxFrameRecorder.k;
        int r2 = k();
        r1.getClass();
        long r5 = SystemClock.uptimeMillis();
        r1.p(r2, 102, new LynxFrameRecorder.b(r8, r9, LynxFrameRecorder.t(r10), LynxFrameRecorder.w(r11)), r5);
    }

    public final void q(int r8, int r9, int r10, Integer r11) {
        if (n() == true) goto L5;
        return;
    L5:
        LynxFrameRecorder r1 = LynxFrameRecorder.k;
        int r2 = k();
        r1.getClass();
        long r5 = SystemClock.uptimeMillis();
        r1.p(r2, r8, new LynxFrameRecorder.h(r9, r10, r11), r5);
    }

    public void updateContentSizeAndOffset(int r2, float r3, float r4, float r5) {
        LynxBaseUI r6 = this.a.getNode(r2);
        if ((r6 instanceof UIListContainer) == false) goto L6;
        ((UIListContainer) r6).b0(r3, r4, r5);
        return;
    }

    public void updateProps(int r10, boolean r11, PropBundle r12, ReadableMapBuffer r13) {
        if (n() == false) goto L6;
        LynxFrameRecorder r1 = LynxFrameRecorder.k;
        int r2 = k();
        r1.getClass();
        r1.p(r2, 106, new LynxFrameRecorder.t(r10, Boolean.valueOf(r11), LynxFrameRecorder.t(r12), LynxFrameRecorder.w(r13)), SystemClock.uptimeMillis());
    L6:
        x0 r0 = null;
        if (r12 == null) goto L9;
        ReadableMap r3 = r12.getProps();
    L10:
        if (r12 == null) goto L12;
        ReadableArray r4 = r12.getEventHandlers();
    L13:
        Map<String, EventsListener> r7 = EventsListener.convertEventListeners(r4);
        if (r12 == null) goto L16;
        ReadableArray r14 = r12.getGestures();
    L17:
        Map<Integer, s7a.a> r8 = s7a.a.a(r14);
        LynxUIOwner r5 = this.a;
        if (r3 == null) goto L20;
        r0 = new x0(r3, r13);
    L20:
        r5.updateProperties(r10, r11, r0, r7, r8);
        return;
    L16:
        r14 = null;
        goto L17
    L12:
        r4 = null;
        goto L13
    L9:
        r3 = null;
        goto L10
    }

    public void updateScrollInfo(int r1, boolean r2, float r3, boolean r4) {
        LynxBaseUI r5 = this.a.getNode(r1);
        if ((r5 instanceof UIListContainer) == false) goto L6;
        ((UIListContainer) r5).c0(r3, r4);
        return;
    }

    public void UpdateLayoutPatching(int[] r33, int[] r34, float[] r35, float[] r36, int[] r37) {
        int r1 = r33.length;
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
    L3:
        if (r3 >= r1) goto L17;
        int r6 = r3 * 20;
        float[] r8 = null;
        if (r34[r6 + 16] == 0) goto L7;
        int r9 = r4 * 4;
        r4 = r4 + 1;
        Rect r27 = new Rect((int) r35[r9], (int) r35[r9 + 1], (int) r35[r9 + 2], (int) r35[r9 + 3]);
    L9:
        if (r34[r6 + 17] == 0) goto L12;
        r8 = new float[10];
        System.arraycopy(r36, r5 * 10, r8, 0, 10);
        r5 = r5 + 1;
    L12:
        float[] r28 = r8;
        int r10 = r33[r3];
        int r11 = r34[r6 + 0];
        int r12 = r34[r6 + 1];
        int r13 = r34[r6 + 2];
        int r14 = r34[r6 + 3];
        int r7 = r34[r6 + 4];
        int r16 = r34[r6 + 5];
        int r17 = r34[r6 + 6];
        int r18 = r34[r6 + 7];
        int r19 = r34[r6 + 8];
        int r20 = r34[r6 + 9];
        int r21 = r34[r6 + 10];
        int r22 = r34[r6 + 11];
        int r23 = r34[r6 + 12];
        int r24 = r34[r6 + 13];
        int r25 = r34[r6 + 14];
        int r26 = r34[r6 + 15];
        float r15 = r34[r6 + 18];
        int r30 = r37[r3];
        if (r34[r6 + 19] == 0) goto L15;
        boolean r31 = true;
    L16:
        t(r10, r11, r12, r13, r14, r7, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r15, r30, r31);
        r3 = r3 + 1;
        goto L3
    L15:
        r31 = false;
        goto L16
    L7:
        r27 = null;
        goto L9
    }

    public void invoke(int r16, String r17, ReadableMap r18, long r19, int r21) {
        if (n() == false) goto L6;
        LynxFrameRecorder r1 = LynxFrameRecorder.k;
        int r2 = k();
        r1.getClass();
        long r5 = SystemClock.uptimeMillis();
        r1.p(r2, 108, new LynxFrameRecorder.f(r16, r17, LynxFrameRecorder.v(r18)), r5);
    L6:
        UIThreadUtils.runOnUiThreadImmediately(new c(this, r19, r21, r16, r17, r18));
    }

    public Object createNode(int r17, String r18, PropBundle r19, ReadableMapBuffer r20, boolean r21, int r22) {
        if (o(r18, r22) == false) goto L21;
        x0 r0 = null;
        if (r19 == null) goto L7;
        ReadableMap r10 = r19.getProps();
    L8:
        if (r19 == null) goto L10;
        ReadableArray r12 = r19.getEventHandlers();
    L11:
        if (r19 == null) goto L13;
        ReadableArray r13 = r19.getGestures();
    L14:
        p(r17, r18, r19, r20);
        if (r10 == null) goto L19;
        r0 = new x0(r10, r20);
    L19:
        return new a(this, this.a.createViewAsync(r17, r18, r0, EventsListener.convertEventListeners(r12), r21, r22, s7a.a.a(r13)), r17, r18, r10, r20, r12, r21, r22, r13);
    L13:
        r13 = null;
        goto L14
    L10:
        r12 = null;
        goto L11
    L7:
        r10 = null;
        goto L8
    L21:
        return new b(this, r17, r18, r19, r20, r21, r22);
    }

    public Object createPaintingNodeAsync(int r12, String r13, PropBundle r14, ReadableMapBuffer r15, boolean r16, int r17) {
        p(r12, r13, r14, r15);
        ReadableArray r0 = null;
        if (r14 == null) goto L5;
        ReadableMap r5 = r14.getProps();
    L6:
        if (r14 == null) goto L8;
        ReadableArray r7 = r14.getEventHandlers();
    L9:
        if (r14 == null) goto L12;
        r0 = r14.getGestures();
    L12:
        return this.a.createViewAsyncRunnable(r12, r13, r5, r15, r7, r16, r17, r0);
    L8:
        r7 = null;
        goto L9
    L5:
        r5 = null;
        goto L6
    }

    public void createPaintingNodeSync(int r13, String r14, PropBundle r15, ReadableMapBuffer r16, boolean r17, int r18) {
        p(r13, r14, r15, r16);
        ReadableArray r1 = null;
        if (r15 == null) goto L5;
        ReadableMap r6 = r15.getProps();
    L6:
        if (r15 == null) goto L8;
        ReadableArray r8 = r15.getEventHandlers();
    L9:
        if (r15 == null) goto L11;
        r1 = r15.getGestures();
    L11:
        this.a.createView(r13, r14, r6, r16, r8, r17, r18, r1);
        this.a.reportCreateViewConfig(r13, r14, false);
        return;
    L8:
        r8 = null;
        goto L9
    L5:
        r6 = null;
        goto L6
    }

    private void recordInitialTreeForReplay(int[] r38, String[] r39, Object[] r40, Object[] r41, int[] r42, int[] r43, float[] r44, boolean[] r45, boolean[] r46) {
        Object[] r3 = r40;
        Object[] r4 = r41;
        if (n() == true) goto L5;
        return;
    L5:
        if (r38 != null) goto L7;
    L36:
        String[] r13 = null;
    L37:
        final LynxFrameRecorder r10 = LynxFrameRecorder.k;
        final int r12 = k();
        Integer r14 = r10.b.get(Integer.valueOf(r12));
        if (r14 == null) goto L104;
        if (r38 == null) goto L67;
        if (r39 == null) goto L67;
        if (r3 == null) goto L67;
        if (r4 == null) goto L67;
        if (r42 == null) goto L67;
        if (r43 == null) goto L67;
        if (r44 == null) goto L67;
        if (r45 == null) goto L67;
        if (r46 == null) goto L67;
        int r15 = r38.length;
        if (r39.length != r15) goto L67;
        if (r3.length != r15) goto L67;
        if (r4.length != r15) goto L67;
        if (r42.length != r15) goto L67;
        if (r43.length != r15) goto L67;
        if (r45.length != r15) goto L67;
        if (r46.length != r15) goto L67;
        if (r44.length < (r15 * 25)) goto L67;
        boolean r11 = true;
    L68:
        if (r11 == true) goto L70;
        final int r1 = r14.intValue();
        r10.a.execute(new com.lynx.tasm.recording.i(r10, r12, r1));
        return;
    L70:
        int r16 = r38.length;
        final long r17 = SystemClock.uptimeMillis();
        ArrayList r18 = new ArrayList(r16);
        int r0 = 0;
    L71:
        if (r0 >= r16) goto L95;
        Integer r19 = r14;
        Object r110 = r3[r0];
        if ((r110 instanceof PropBundle) == false) goto L75;
        PropBundle r111 = (PropBundle) r110;
    L76:
        Object r5 = r4[r0];
        if ((r5 instanceof ReadableMapBuffer) == false) goto L79;
        ReadableMapBuffer r6 = (ReadableMapBuffer) r5;
    L80:
        Map<String, Object> r22 = LynxFrameRecorder.t(r111);
        Map<String, Object> r23 = LynxFrameRecorder.w(r6);
        int r7 = r0 * 25;
        if (r13 != null) goto L83;
    L85:
        String r36 = null;
    L86:
        int r20 = r38[r0];
        String r21 = r39[r0];
        int r24 = r42[r0];
        int r25 = r43[r0];
        float r26 = r44[r7 + 0];
        float r27 = r44[r7 + 1];
        float r28 = r44[r7 + 2];
        float r29 = r44[r7 + 3];
        float[] r30 = LynxFrameRecorder.c(r44, r7 + 4);
        float[] r31 = LynxFrameRecorder.c(r44, r7 + 8);
        float[] r32 = LynxFrameRecorder.c(r44, r7 + 12);
        if (r45[r0] == false) goto L89;
        float[] r33 = LynxFrameRecorder.c(r44, r7 + 16);
    L91:
        if (r46[r0] == false) goto L93;
        float[] r34 = LynxFrameRecorder.c(r44, r7 + 20);
    L94:
        r18.add(new LynxFrameRecorder.e(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r44[r7 + 24], r36));
        r0 = r0 + 1;
        r3 = r40;
        r4 = r41;
        r14 = r19;
        goto L71
    L93:
        r34 = null;
        goto L94
    L89:
        r33 = null;
        goto L91
    L83:
        if (r13.length != r16) goto L85;
        r36 = r13[r0];
        goto L86
    L79:
        r6 = null;
        goto L80
    L75:
        r111 = null;
        goto L76
    L95:
        final Integer r112 = r14;
        final List r2 = Collections.unmodifiableList(r18);
        r10.a.execute(new com.lynx.tasm.recording.b(r10, r12, r112, r2, r17));
        return;
    L67:
        r11 = false;
        goto L68
    L104:
        return;
    L7:
        if (r38.length == 0) goto L36;
        int r113 = 0;
        r13 = null;
    L11:
        if (r113 >= r38.length) goto L37;
        int r114 = r38[r113];
        String r115 = u(this.h.get(Integer.valueOf(r114)));
        if (r115 != null) goto L30;
        LynxUIOwner r116 = this.a;
        if (r116 == null) goto L18;
        LynxBaseUI r117 = r116.getNode(r114);
    L20:
        if ((r117 instanceof UIText) == false) goto L25;
        CharSequence r118 = ((UIText) r117).getOriginText();
        if (r118 == null) goto L29;
        r115 = r118.toString();
    L29:
        r115 = null;
        goto L30
    L25:
        if ((r117 instanceof FlattenUIText) == false) goto L29;
        CharSequence r119 = ((FlattenUIText) r117).getOriginText();
        if (r119 == null) goto L29;
        r115 = r119.toString();
        goto L30
    L18:
        r117 = null;
    L30:
        if (r115 == null) goto L35;
        if (r13 != null) goto L34;
        r13 = new String[r38.length];
    L34:
        r13[r113] = r115;
    L35:
        r113 = r113 + 1;
        goto L11
    }

    public final void t(int r26, int r27, int r28, int r29, int r30, int r31, int r32, int r33, int r34, int r35, int r36, int r37, int r38, int r39, int r40, int r41, int r42, Rect r43, float[] r44, float r45, int r46, boolean r47) {
        float r5 = r27;
        float r6 = r28;
        float r7 = r29;
        float r8 = r30;
        float r3 = r31;
        float r4 = r32;
        float r9 = r33;
        float r0 = r34;
        float r1 = r35;
        float r10 = r36;
        float r11 = r37;
        float r12 = r38;
        float r13 = r39;
        float r14 = r40;
        float r15 = r41;
        float r16 = r42;
        if (n() == false) goto L10;
        LynxFrameRecorder r19 = LynxFrameRecorder.k;
        int r20 = k();
        float[] r17 = {r3, r4, r9, r0};
        float[] r2 = {r1, r10, r11, r12};
        float[] r18 = {r13, r14, r15, r16};
        if (r43 == null) goto L8;
        float[] r21 = {r43.left, r43.top, r43.right, r43.bottom};
    L9:
        r19.getClass();
        r19.p(r20, 107, new LynxFrameRecorder.s(r26, r5, r6, r7, r8, LynxFrameRecorder.b(r17), LynxFrameRecorder.b(r2), LynxFrameRecorder.b(r18), LynxFrameRecorder.b(r21), LynxFrameRecorder.b(r44), r45), SystemClock.uptimeMillis());
        goto L10
    L8:
        r21 = null;
    L10:
        this.a.updateLayout(r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47);
    }

    public void updateLayout(int r24, float r25, float r26, float r27, float r28, float r29, float r30, float r31, float r32, float r33, float r34, float r35, float r36, float r37, float r38, float r39, float r40, float[] r41, float[] r42, float r43, int r44, boolean r45) {
        int r2 = (int) r25;
        int r3 = (int) r26;
        int r4 = (int) r27;
        int r5 = (int) r28;
        int r6 = (int) r29;
        int r7 = (int) r30;
        int r8 = (int) r31;
        int r9 = (int) r32;
        int r10 = (int) r33;
        int r11 = (int) r34;
        int r12 = (int) r35;
        int r13 = (int) r36;
        int r14 = (int) r37;
        int r15 = (int) r38;
        int r1 = (int) r39;
        int r0 = (int) r40;
        if (r41 == null) goto L5;
        Rect r16 = new Rect((int) r41[0], (int) r41[1], (int) r41[2], (int) r41[3]);
    L6:
        t(r24, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r1, r0, r16, r42, r43, r44, r45);
        return;
    L5:
        r16 = null;
        goto L6
    }
}
