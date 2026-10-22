package com.lynx.tasm.behavior;

import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.WritableArray;
import com.lynx.react.bridge.mapbuffer.ReadableCompactArrayBuffer;
import com.lynx.react.bridge.mapbuffer.ReadableMapBuffer;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.base.CalledByNative;
import com.lynx.tasm.base.TraceController;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.PropBundle;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.behavior.ui.UIShadowProxy;
import com.lynx.tasm.behavior.ui.list.UIList;
import com.lynx.tasm.behavior.ui.list.container.UIListContainer;
import com.lynx.tasm.behavior.ui.view.UIComponent;
import com.lynx.tasm.performance.PerformanceController;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes2.dex */
public final class PaintingContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n0 f10169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f10170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap f10171c;
    public final ConcurrentHashMap d;
    public final long e;

    public PaintingContext(n0 r5, int r10) {
        this.e = 0;
        this.f10169a = r5;
        this.f10170b = false;
        this.f10171c = new ConcurrentHashMap();
        this.d = new ConcurrentHashMap();
        r5.f10289c.getClass();
        this.e = nativeCreatePaintingContext(this, null, r10, r5.f10295m);
    }

    public static /* synthetic */ void a(PaintingContext r5, long r10, int r11, JavaOnlyArray r12) {
        r5.nativeInvokeCallback(r10, r11, r12);
    }

    @CalledByNative
    private void finishTasmOperation(long r5) {
        n0 r10 = this.f10169a;
        ArrayList r11 = r10.f10289c.f10154w;
        if (r11 == null) goto L8;
        Iterator r12 = r11.iterator();
    L6:
        if (r12.hasNext() == false) goto L8;
        ((u0) r12.next()).b();
    L8:
        UIBody r13 = r10.f10288b;
        UIBody.UIBodyView r14 = r13.f10385a;
        if (r14 != null) goto L11;
        return;
    L11:
        if (r14.HasPendingRequestLayout() == false) goto L16;
        LynxLog.b(2, "LynxUIOwner", "onTasmFinish do force RequestLayout after UpdateData in PreLoad Mode!");
        r13.f10385a.requestLayout();
        return;
    }

    @CalledByNative
    private void flushUIOperationBatch(ReadableCompactArrayBuffer r10) {
        if (r10 == null) goto L44;
        qm.e r5 = new qm.e(r10);
    L6:
        if (((qm.b) r5.f21531b).hasNext() == false) goto L73;
        int r11 = ((qm.c) r5.next()).b();
        int r12 = 0;
        switch(r11) {
            case 0: goto L43;
            case 1: goto L42;
            case 2: goto L41;
            case 3: goto L37;
            case 4: goto L29;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            default: goto L9;
        };
    L9:
        LynxLog.b(4, "lynx_PaintingContext", "flushUIOperationBatch with unknown UIOperationType: " + r11);
        return;
    L12:
        qm.c r13 = (qm.c) r5.next();
        qm.d r14 = r13.f21526b;
        finishTasmOperation(r14.f21527a.getLong(r13.f21525a + r14.f21529c));
        goto L6
    L13:
        int r15 = ((qm.c) r5.next()).b();
        int[] r16 = new int[r15];
        int r17 = 0;
    L14:
        if (r17 >= r15) goto L16;
        r16[r17] = ((qm.c) r5.next()).b();
        r17 = r17 + 1;
        goto L14
    L16:
        int r18 = ((qm.c) r5.next()).b();
        int[] r19 = new int[r18];
        int r20 = 0;
    L17:
        if (r20 >= r18) goto L19;
        r19[r20] = ((qm.c) r5.next()).b();
        r20 = r20 + 1;
        goto L17
    L19:
        int r110 = ((qm.c) r5.next()).b();
        float[] r21 = new float[r110];
        int r22 = 0;
    L20:
        if (r22 >= r110) goto L22;
        r21[r22] = (float) ((qm.c) r5.next()).a();
        r22 = r22 + 1;
        goto L20
    L22:
        int r111 = ((qm.c) r5.next()).b();
        float[] r23 = new float[r111];
        int r24 = 0;
    L23:
        if (r24 >= r111) goto L25;
        r23[r24] = (float) ((qm.c) r5.next()).a();
        r24 = r24 + 1;
        goto L23
    L25:
        int r112 = ((qm.c) r5.next()).b();
        int[] r25 = new int[r112];
    L26:
        if (r12 >= r112) goto L28;
        r25[r12] = ((qm.c) r5.next()).b();
        r12 = r12 + 1;
        goto L26
    L28:
        UpdateLayoutPatching(r16, r19, r21, r23, r25);
        goto L6
    L29:
        int r113 = ((qm.c) r5.next()).b();
        int[] r26 = new int[r113];
        int r27 = 0;
    L30:
        if (r27 >= r113) goto L32;
        r26[r27] = ((qm.c) r5.next()).b();
        r27 = r27 + 1;
    L32:
        if (r12 >= r113) goto L6;
        LynxBaseUI r28 = (LynxBaseUI) this.f10169a.g.get(Integer.valueOf(r26[r12]));
        if (r28 == null) goto L36;
        n0.D(r28);
    L36:
        r12 = r12 + 1;
        goto L32
    L37:
        int r114 = ((qm.c) r5.next()).b();
        int[] r29 = new int[r114];
    L38:
        if (r12 >= r114) goto L40;
        r29[r12] = ((qm.c) r5.next()).b();
        r12 = r12 + 1;
        goto L38
    L40:
        b(r29);
        goto L6
    L41:
        destroyNode(((qm.c) r5.next()).b(), ((qm.c) r5.next()).b());
        goto L6
    L42:
        removeNode(((qm.c) r5.next()).b(), ((qm.c) r5.next()).b());
        goto L6
    L43:
        insertNode(((qm.c) r5.next()).b(), ((qm.c) r5.next()).b(), ((qm.c) r5.next()).b());
        goto L6
    L11:
        int r115 = ((qm.c) r5.next()).b();
        qm.c r30 = (qm.c) r5.next();
        qm.d r31 = r30.f21526b;
        FinishLayoutOperation(r115, r31.f21527a.getLong(r30.f21525a + r31.f21529c), true);
        goto L6
    L73:
        return;
    }

    @CalledByNative
    private void markUIOperationQueueFlushForRecreateEngine(boolean r5) {
        n0 r10 = this.f10169a;
        if (r10 == null) goto L16;
        com.lynx.tasm.b0 r11 = r10.f10289c;
        if (r11 == null) goto L17;
        r11.L = r5;
        if (r5 == false) goto L11;
        return;
    L11:
        if (r11.l() == null) goto L15;
        r11.l().clearNodeIndexImageMap();
        r11.l().markNeedRemoveExistingViews();
        r11.l().removeExistingViews();
        return;
    L15:
        return;
    L17:
        return;
    }

    private native long nativeCreatePaintingContext(Object r5, Object r10, int r11, boolean r12);

    private native void nativeInvokeCallback(long r5, int r10, WritableArray r11);

    @CalledByNative
    private void setFrameAppBundle(int r5, TemplateBundle r10) {
        this.f10169a.k(r5, r10);
    }

    @CalledByNative
    public void FinishLayoutOperation(int r10, long r11, boolean r12) {
        n0 r13 = this.f10169a;
        com.lynx.tasm.u0 r14 = r13.f10289c.K;
        if (r14 == null) goto L5;
        boolean r15 = r14.C;
    L6:
        if (r15 == false) goto L24;
        Iterator r16 = r13.e.iterator();
    L10:
        if (r16.hasNext() == false) goto L24;
        LynxBaseUI r5 = (LynxBaseUI) r16.next();
        if (r5.flattenChildrenCount() <= 0) goto L10;
        if (r5.getNeedSortChildren() == false) goto L10;
        Iterator<LynxBaseUI> r17 = r5.getChildren().iterator();
    L17:
        if (r17.hasNext() == false) goto L90;
        n0.F(r17.next());
        goto L17
    L90:
        Collections.sort(r5.getChildren(), n0.f10286u);     // Catch: Exception -> L21
    L23:
        n0.A(r5);
        r5.setNeedSortChildren(false);
    L21:
        e = move-exception;
        LynxLog.b(2, "LynxUIOwner", "Something went wrong during sort children by translation Z " + e.getStackTrace());
    L24:
        com.lynx.tasm.behavior.ui.accessibility.d r18 = r13.f10288b.d;
        String r19 = null;
        if (r18 == null) goto L79;
        if (r18.f10411k == null) goto L55;
        if (r18.i() == false) goto L55;
        WeakReference r20 = r18.f10405a;
        if (r20 == null) goto L33;
        UIBody r21 = (UIBody) r20.get();
    L34:
        if (r21 == null) goto L55;
        if (r20 == null) goto L37;
        UIBody r22 = (UIBody) r20.get();
    L39:
        if (r22.getLynxContext() == null) goto L55;
        ym.p r23 = r18.f10411k;
        if (r20 == null) goto L43;
        UIBody r24 = (UIBody) r20.get();
    L44:
        LynxContext r25 = r24.getLynxContext();
        if (r25 != null) goto L47;
        r23.getClass();
        goto L55
    L47:
        if (((ArrayList) r23.f23312b).isEmpty() == true) goto L55;
        JavaOnlyArray r26 = new JavaOnlyArray();
        ArrayList r27 = (ArrayList) r23.f23312b;
        Iterator r28 = r27.iterator();
    L50:
        if (r28.hasNext() == false) goto L52;
        r26.add((JavaOnlyMap) r28.next());
        goto L50
    L52:
        JavaOnlyArray r29 = new JavaOnlyArray();
        r29.add(r26);
        r25.e("a11y-mutations", r29);
        r27.clear();
        goto L55
    L43:
        r24 = null;
        goto L44
    L37:
        r22 = null;
        goto L39
    L33:
        r21 = null;
    L55:
        if (r18.g() == false) goto L79;
        com.lynx.tasm.t r110 = r18.f10414n;
        if (((ArrayList) r110.e).isEmpty() == true) goto L67;
        ArrayList r30 = (ArrayList) r110.e;
        Iterator r31 = r30.iterator();
    L60:
        if (r31.hasNext() == false) goto L66;
        WeakReference r32 = (WeakReference) r31.next();
        if (r32 == null) goto L60;
        if (r32.get() == null) goto L60;
        r110.h((LynxBaseUI) r32.get());
        goto L60
    L66:
        r30.clear();
    L67:
        ArrayList r33 = (ArrayList) r110.d;
        if (r33.isEmpty() == true) goto L79;
        Iterator r34 = r33.iterator();
    L71:
        if (r34.hasNext() == false) goto L77;
        WeakReference r35 = (WeakReference) r34.next();
        if (r35 == null) goto L71;
        if (r35.get() == null) goto L71;
        r110.h((LynxBaseUI) r35.get());
        goto L71
    L77:
        r33.clear();
    L79:
        if (r11 == 0) goto L116;
        HashMap r36 = r13.g;
        LynxBaseUI r111 = (LynxBaseUI) r36.get(Integer.valueOf((int) (r11 >>> 32)));
        if (r111 != null) goto L84;
        return;
    L84:
        if (TraceController.g == false) goto L86;
        r19 = "UIOwner.layoutFinish." + r111.getTagName();
        TraceEvent.c(r19);
    L86:
        r111.onLayoutFinish(r11, (LynxBaseUI) r36.get(Integer.valueOf(r10)));
        if (TraceController.g == false) goto L115;
        TraceEvent.a(0, r19);
        return;
    L115:
        return;
    L116:
        return;
    L5:
        r15 = false;
        goto L6
    }

    @CalledByNative
    public void SetGestureDetectorState(int r5, int r10, int r11) {
        LynxBaseUI r12 = this.f10169a.v(r5);
        if (r12 != null) goto L6;
        LynxLog.b(4, "LynxUIOwner", "Attempted to set gesture detector state for a non-existing node");
        return;
    L6:
        r12.setGestureDetectorState(r10, r11);
    }

    @CalledByNative
    public void UpdateLayoutPatching(int[] r33, int[] r34, float[] r35, float[] r36, int[] r37) {
        int r5 = r33.length;
        int r10 = 0;
        int r11 = 0;
        int r12 = 0;
    L3:
        if (r10 >= r5) goto L12;
        int r13 = r10 * 19;
        float[] r14 = null;
        if (r34[r13 + 16] == 0) goto L7;
        int r15 = r11 * 4;
        r11 = r11 + 1;
        Rect r28 = new Rect((int) r35[r15], (int) r35[r15 + 1], (int) r35[r15 + 2], (int) r35[r15 + 3]);
    L9:
        if (r34[r13 + 17] == 0) goto L11;
        int r16 = r12 * 4;
        r14 = new float[]{r36[r16], r36[r16 + 1], r36[r16 + 2], r36[r16 + 3]};
        r12 = r12 + 1;
    L11:
        this.f10169a.j(r33[r10], r34[r13], r34[r13 + 1], r34[r13 + 2], r34[r13 + 3], r34[r13 + 4], r34[r13 + 5], r34[r13 + 6], r34[r13 + 7], r34[r13 + 8], r34[r13 + 9], r34[r13 + 10], r34[r13 + 11], r34[r13 + 12], r34[r13 + 13], r34[r13 + 14], r34[r13 + 15], r28, r14, r34[r13 + 18], r37[r10]);
        r10 = r10 + 1;
        goto L3
    L7:
        r28 = null;
        goto L9
    }

    public final void b(int[] r5) {
        int r10 = r5.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L11;
        int r12 = r5[r11];
        LynxBaseUI r13 = (LynxBaseUI) this.f10169a.g.get(Integer.valueOf(r12));
        if (r13 == null) goto L10;
        if ((r13 instanceof UIShadowProxy) == false) goto L9;
        r13 = ((UIShadowProxy) r13).f10388a;
    L9:
        r13.onNodeReady();
    L10:
        r11 = r11 + 1;
        goto L3
    }

    public final boolean c(int r5, String r10) {
        boolean r11 = false;
        n0 r12 = this.f10169a;
        if (r12 == null) goto L11;
        com.lynx.tasm.b0 r13 = r12.f10289c;
        if (r13 == null) goto L11;
        if (r13.L == false) goto L11;
        if (r13.l().containsViewForNodeIndex(r5) == false) goto L11;
        return false;
    L11:
        ConcurrentHashMap r14 = this.f10171c;
        if (r14.containsKey(r10) == false) goto L16;
        return ((Boolean) r14.get(r10)).booleanValue();
    L16:
        if (LynxEnv.inst().getCreateViewAsync() == false) goto L28;
        com.lynx.tasm.u0 r15 = r12.f10289c.K;
        if (r15 == null) goto L21;
        boolean r16 = r15.f10973k;
    L22:
        if (r16 == false) goto L28;
        if (r10.equals("page") == true) goto L28;
        r11 = r12.f10292j.a(r10).f10174c;
        goto L28
    L21:
        r16 = false;
    L28:
        r14.put(r10, Boolean.valueOf(r11));
        return r11;
    }

    @CalledByNative
    public void consumeGesture(int r5, int r10, ReadableMap r11) {
        LynxBaseUI r12 = this.f10169a.v(r5);
        if (r12 != null) goto L6;
        LynxLog.b(4, "LynxUIOwner", "Attempted to set gesture detector state for a non-existing node");
        return;
    L6:
        r12.consumeGesture(r10, r11);
    }

    @CalledByNative
    public Object createNode(final int r17, final String r18, PropBundle r19, ReadableMapBuffer r20, final boolean r21, final int r22) {
        if (c(r22, r18) == false) goto L26;
        y0 r5 = null;
        if (r19 == null) goto L7;
        ReadableMap r13 = r19.getProps();
    L8:
        if (r19 == null) goto L10;
        ReadableArray r14 = r19.getEventHandlers();
    L11:
        if (r19 == null) goto L13;
        ReadableArray r15 = r19.getGestures();
    L14:
        if (r13 == null) goto L16;
        r5 = new y0(r13, r20);
    L16:
        final y0 r10 = r5;
        final HashMap r11 = on.a.a(r14);
        final HashMap r12 = un.a.a(r15);
        final n0 r16 = this.f10169a;
        r16.getClass();
        Callable r23 = new g0(r16, r18, r17, r22, r21, r10, r11, r12);
        if (r16.f10295m == false) goto L22;
        FutureTask r24 = new FutureTask(r23);
        r16.f10299q.add(r24);
    L24:
        return new q0(this, r24, r17, r18, r13, r20, r14, r21, r22, r15);
    L22:
        r24 = new FutureTask(r23);
        LynxEnv.runJavaTaskOnConcurrentLoop(new jm.a(r24, 4), 0);
        goto L24
    L13:
        r15 = null;
        goto L14
    L10:
        r14 = null;
        goto L11
    L7:
        r13 = null;
        goto L8
    L26:
        return new r0(this, r17, r18, r19, r20, r21, r22);
    }

    @CalledByNative
    public Object createPaintingNodeAsync(int r19, String r20, PropBundle r21, ReadableMapBuffer r22, boolean r23, int r24) {
        if (r21 == null) goto L5;
        ReadableMap r10 = r21.getProps();
    L6:
        if (r21 == null) goto L8;
        ReadableArray r11 = r21.getEventHandlers();
    L9:
        if (r21 == null) goto L11;
        ReadableArray r13 = r21.getGestures();
    L12:
        n0 r14 = this.f10169a;
        r14.n(r19, r20, true);
        if (r10 == null) goto L15;
        y0 r12 = new y0(r10, r22);
    L16:
        y0 r15 = r12;
        com.lynx.tasm.behavior.ui.z r5 = new com.lynx.tasm.behavior.ui.z(r19, r24, r23, r20, on.a.a(r11), un.a.a(r13));
    L20:
        th = th;
    L31:
        String r16 = "createViewAsync failed, tagName:" + r20 + ", error:" + th;
        LynxLog.b(4, "LynxUIOwner", r16);
        Exception r17 = new Exception(r16);
        r17.setStackTrace(th.getStackTrace());
        com.lynx.tasm.utils.j.a().post(new l0(r14, r17, 0));
        m0 r18 = new m0(r14, r19, r20, r10, r22, r11, r23, r24, r13);
        r14.t(r20, r19, 3, false);
        return r18;
    L18:
        if (TraceController.g == false) goto L22;
        String r25 = "UIOwner.createAsyncViewRunnable." + r20;     // Catch: Throwable -> L20
        TraceEvent.c(r25);     // Catch: Throwable -> L20
    L23:
        LynxBaseUI[] r26 = {r14.c(r5)};     // Catch: Throwable -> L20
        UIShadowProxy r27 = r14.f(r26[0], r15);     // Catch: Throwable -> L20
        if (TraceController.g == false) goto L26;
        TraceEvent.a(0, r25);     // Catch: Throwable -> L20
    L26:
        r14.t(r20, r19, 2, true);     // Catch: Throwable -> L20
        return new k0(r14, r20, r26, r27, r15, r19, 0);
    L30:
        th = th;
        goto L31
    L22:
        r25 = null;
        goto L23
    L15:
        r12 = null;
        goto L16
    L11:
        r13 = null;
        goto L12
    L8:
        r11 = null;
        goto L9
    L5:
        r10 = null;
        goto L6
    }

    @CalledByNative
    public void createPaintingNodeSync(int r13, String r14, PropBundle r15, ReadableMapBuffer r16, boolean r17, int r18) {
        ReadableArray r5 = null;
        if (r15 == null) goto L5;
        ReadableMap r10 = r15.getProps();
    L6:
        if (r15 == null) goto L8;
        ReadableArray r11 = r15.getEventHandlers();
    L9:
        if (r15 == null) goto L11;
        r5 = r15.getGestures();
    L11:
        this.f10169a.l(r13, r14, r10, r16, r11, r17, r18, r5);
        this.f10169a.n(r13, r14, false);
        return;
    L8:
        r11 = null;
        goto L9
    L5:
        r10 = null;
        goto L6
    }

    @CalledByNative
    public void destroyNode(int r10, int r11) {
        n0 r12 = this.f10169a;
        r12.getClass();
        TraceEvent.c("UIOwner.destroy.item");
        HashMap r5 = r12.g;
        if (r5.size() <= 0) goto L22;
        LynxBaseUI r13 = (LynxBaseUI) r5.get(Integer.valueOf(r11));
        if (r13 != null) goto L8;
        TraceEvent.a(0, "UIOwner.destroy.item");
        return;
    L8:
        r12.e.remove(r13);
        n0.F(r13);
        r5.remove(Integer.valueOf(r11));
        r12.f10289c.c(r13);
        r13.destroy();
        r12.q(r13, 2);
        com.lynx.tasm.u0 r14 = r12.f10289c.K;
        if (r14 == null) goto L11;
        boolean r15 = r14.F;
    L12:
        if (r15 == true) goto L15;
        r12.p(r13);
    L15:
        if (r10 != (-1)) goto L17;
        LynxBaseUI r16 = r13.getParentBaseUI();
    L18:
        if (r16 != null) goto L21;
        TraceEvent.a(0, "UIOwner.destroy.item");
        return;
    L21:
        r16.removeChild(r13);
        goto L22
    L17:
        r16 = (LynxBaseUI) r5.get(Integer.valueOf(r10));
        goto L18
    L11:
        r15 = false;
    L22:
        TraceEvent.a(0, "UIOwner.destroy.item");
    }

    @CalledByNative
    public float[] getBoundingClientOrigin(int r5) {
        float[] r10 = {0.0f, 0.0f};
        LynxBaseUI r11 = this.f10169a.v(r5);
        if (r11 == null) goto L5;
        Rect r12 = r11.getBoundingClientRect();
        r10[0] = r12.left;
        r10[1] = r12.top;
    L5:
        return r10;
    }

    @CalledByNative
    public float[] getRectToLynxView(int r10) {
        float[] r5 = {0.0f, 0.0f, 0.0f, 0.0f};
        LynxBaseUI r11 = this.f10169a.v(r10);
        if (r11 == null) goto L5;
        Rect r12 = r11.getBoundingClientRect();
        r5[0] = r12.left;
        r5[1] = r12.top;
        r5[2] = r12.width();
        r5[3] = r12.height();
    L5:
        return r5;
    }

    @CalledByNative
    public float[] getRectToWindow(int r10) {
        float[] r5 = {0.0f, 0.0f, 0.0f, 0.0f};
        LynxBaseUI r11 = this.f10169a.v(r10);
        if (r11 == null) goto L5;
        Rect r12 = r11.getRectToWindow();
        r5[0] = r12.left;
        r5[1] = r12.top;
        r5[2] = r12.width();
        r5[3] = r12.height();
    L5:
        return r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [int] */
    @CalledByNative
    public int getTagInfo(String r10) {
        n0 r5 = this.f10169a;
        r5.getClass();
        c r11 = r5.f10292j;
        boolean r12 = false;
        ShadowNode r13 = r11.a(r10).d();
        if (r13 != null) goto L7;
        int r14 = 1;
    L13:
        if ((r14 & 2) > 0) goto L15;
        boolean r15 = c(-1, r10);
        ConcurrentHashMap r16 = this.d;
        if (r16.containsKey(r10) == false) goto L20;
        ?? r17 = ((Boolean) r16.get(r10)).booleanValue();
    L25:
        return ((r17 << 17) | ((r15 ? 1 : 0) << 16)) | (r14 & 65535);
    L20:
        if (r10.equals("page") == true) goto L23;
        r12 = r11.a(r10).d;
    L23:
        r16.put(r10, Boolean.valueOf(r12));
        r17 = r12;
        goto L25
    L15:
        return r14 & 65535;
    L7:
        if (r13.m() == false) goto L9;
        r14 = 6;
        goto L13
    L9:
        r14 = 4;
    L11:
        r14 = 0;
        goto L13
    }

    @CalledByNative
    public float[] getWindowSize(int r5) {
        WindowManager r10 = (WindowManager) this.f10169a.f10289c.a().getSystemService("window");
        if (r10 != null) goto L6;
        return null;
    L6:
        Display r11 = r10.getDefaultDisplay();
        DisplayMetrics r12 = new DisplayMetrics();
        r11.getRealMetrics(r12);
        return new float[]{r12.widthPixels, r12.heightPixels};
    }

    @CalledByNative
    public void insertListItemNode(int r5, int r10) {
        if (TraceController.g == false) goto L5;
        String r11 = "PaintingContext.insertListItemNode." + r5 + "_" + r10;
        TraceEvent.c(r11);
    L6:
        n0 r12 = this.f10169a;
        LynxBaseUI r13 = r12.v(r5);
        LynxBaseUI r14 = r12.v(r10);
        if ((r13 instanceof UIListContainer) == false) goto L12;
        if ((r14 instanceof UIComponent) == false) goto L12;
        ((UIListContainer) r13).n(r14);
    L12:
        if (TraceController.g == false) goto L15;
        TraceEvent.a(0, r11);
        return;
    L15:
        return;
    L5:
        r11 = null;
        goto L6
    }

    @CalledByNative
    public void insertNode(int r5, int r10, int r11) {
        this.f10169a.i(r5, r10, r11);
    }

    @CalledByNative
    public void invoke(int r10, String r11, ReadableMap r12, long r13, int r15) {
        com.lynx.tasm.utils.j.f(new t0(this, r13, r15, r10, r11, r12));
    }

    @CalledByNative
    public void listCellAppear(int r5, String r10) {
        LynxBaseUI r11 = (LynxBaseUI) this.f10169a.g.get(Integer.valueOf(r5));
        if (r11 != null) goto L5;
        return;
    L5:
        if ((r11.getParentBaseUI() instanceof UIListContainer) == false) goto L9;
        r11.onListCellAppear(r10, r11.getParentBaseUI());
        return;
    }

    @CalledByNative
    public void listCellDisappear(int r5, boolean r10, String r11) {
        LynxBaseUI r12 = (LynxBaseUI) this.f10169a.g.get(Integer.valueOf(r5));
        if (r12 != null) goto L5;
        return;
    L5:
        if ((r12.getParentBaseUI() instanceof UIListContainer) == false) goto L9;
        r12.onListCellDisAppear(r11, r12.getParentBaseUI(), r10);
        return;
    }

    @CalledByNative
    public void rebuildViewTree() {
        boolean r5 = TraceController.g;
        n0 r10 = this.f10169a;
        if (r5 == false) goto L5;
        r10.getClass();
        String r11 = "UIOwner.rebuildViewTree";
        TraceEvent.c("UIOwner.rebuildViewTree");
    L6:
        r10.f10288b.i();
        if (TraceController.g == false) goto L10;
        TraceEvent.a(0, r11);
        return;
    L10:
        return;
    L5:
        r11 = null;
        goto L6
    }

    @CalledByNative
    public void removeListItemNode(int r5, int r10) {
        if (TraceController.g == false) goto L5;
        String r11 = "PaintingContext.removeListItemNode." + r5 + "_" + r10;
        TraceEvent.c(r11);
    L6:
        n0 r12 = this.f10169a;
        LynxBaseUI r13 = r12.v(r5);
        LynxBaseUI r14 = r12.v(r10);
        if ((r13 instanceof UIListContainer) == false) goto L12;
        if ((r14 instanceof UIComponent) == false) goto L12;
        ((UIListContainer) r13).removeView(r14);
    L12:
        if (TraceController.g == false) goto L15;
        TraceEvent.a(0, r11);
        return;
    L15:
        return;
    L5:
        r11 = null;
        goto L6
    }

    @CalledByNative
    public void removeNode(int r5, int r10) {
        this.f10169a.z(r5, r10);
    }

    @CalledByNative
    public void requestLayout() {
        com.lynx.tasm.utils.j.f(new a6.a(this, 28));
    }

    @CalledByNative
    public void reuseListNode(int r5, String r10) {
        LynxBaseUI r11 = (LynxBaseUI) this.f10169a.g.get(Integer.valueOf(r5));
        if (r11 != null) goto L5;
        return;
    L5:
        if ((r11.getParentBaseUI() instanceof UIList) == false) goto L7;
    L8:
        r11.onListCellPrepareForReuse(r10, r11.getParentBaseUI());
        return;
    L7:
        if ((r11.getParentBaseUI() instanceof UIListContainer) == true) goto L8;
    }

    @CalledByNative
    public float[] scrollBy(int r16, float r17, float r18) {
        if (com.lynx.tasm.utils.j.j() == false) goto L10;
        LynxBaseUI r5 = this.f10169a.v(r16);
        if (r5 == null) goto L9;
        return r5.scrollBy(r17, r18);
    L9:
        return new float[]{0.0f, 0.0f, r17, r18};
    L10:
        com.lynx.tasm.utils.j.a().post(new p0(this, r16, 0, r17, r18));
        return new float[]{0.0f, 0.0f, r17, r18};
    }

    @CalledByNative
    public void scrollIntoView(int r5) {
        LynxBaseUI r10 = this.f10169a.v(r5);
        if (r10 != null) goto L5;
        return;
    L5:
        r10.scrollIntoView(false, "center", "center", null);
    }

    @CalledByNative
    public void setKeyframes(PropBundle r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.getProps() == null) goto L17;
        n0 r10 = this.f10169a;
        com.lynx.tasm.b0 r11 = r10.f10289c;
        String r12 = r5.getProps().getString("removeKeyframe");
        JavaOnlyMap r13 = r11.e;
        if (r13 == null) goto L9;
        r13.remove(r12);
    L9:
        com.lynx.tasm.b0 r14 = r10.f10289c;
        ReadableMap r15 = r5.getProps().getMap("keyframes");
        if (r14.e != null) goto L12;
        r14.e = new JavaOnlyMap();
    L12:
        if (r15 == null) goto L16;
        JavaOnlyMap r16 = r14.e;
        r16.getClass();
        r16.putAll(r15.asHashMap());
        return;
    L16:
        return;
    }

    @CalledByNative
    public void setNeedMarkPaintEndTiming(String r5) {
        n0 r10 = this.f10169a;
        if (r10 == null) goto L19;
        com.lynx.tasm.b0 r11 = r10.f10289c;
        if (r11 == null) goto L20;
        WeakReference r12 = r11.f10143k;
        if (r12 != null) goto L11;
        PerformanceController r13 = null;
    L12:
        if (r13 != null) goto L15;
        return;
    L15:
        if (com.lynx.tasm.utils.j.j() == true) goto L17;
        return;
    L17:
        r13.e.add(r5);
        return;
    L11:
        r13 = (PerformanceController) r12.get();
        goto L12
    L20:
        return;
    }

    @CalledByNative
    public void updateContentSizeAndOffset(int r5, float r10, float r11, float r12) {
        LynxBaseUI r13 = this.f10169a.v(r5);
        if ((r13 instanceof UIListContainer) == false) goto L6;
        ((UIListContainer) r13).k(r10, r11, r12);
        return;
    }

    @CalledByNative
    public void updateEventInfo(boolean r5) {
        this.f10169a.f10301t = r5;
    }

    @CalledByNative
    public void updateExtraData(int r5, Object r10) {
        this.f10169a.k(r5, r10);
    }

    @CalledByNative
    public void updateFlattenStatus(int r5, boolean r10) {
        this.f10169a.o(r5, r10);
    }

    @CalledByNative
    public void updateLayout(int r24, float r25, float r26, float r27, float r28, float r29, float r30, float r31, float r32, float r33, float r34, float r35, float r36, float r37, float r38, float r39, float r40, float[] r41, float[] r42, float r43, int r44) {
        int r5 = (int) r25;
        int r10 = (int) r26;
        int r11 = (int) r27;
        int r12 = (int) r28;
        int r13 = (int) r29;
        int r14 = (int) r30;
        int r15 = (int) r31;
        int r16 = (int) r32;
        int r17 = (int) r33;
        int r18 = (int) r34;
        int r19 = (int) r35;
        int r110 = (int) r36;
        int r111 = (int) r37;
        int r112 = (int) r38;
        int r20 = (int) r39;
        int r21 = (int) r40;
        if (r41 == null) goto L6;
        Rect r22 = new Rect((int) r41[0], (int) r41[1], (int) r41[2], (int) r41[3]);
    L5:
        Rect r23 = r22;
        this.f10169a.j(r24, r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r20, r21, r23, r42, r43, r44);
        return;
    L6:
        r22 = null;
        goto L5
    }

    @CalledByNative
    public void updateNodeReadyPatching(int[] r5, int[] r10) {
        b(r5);
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        int r13 = r10[r12];
        LynxBaseUI r14 = (LynxBaseUI) this.f10169a.g.get(Integer.valueOf(r13));
        if (r14 == null) goto L7;
        n0.D(r14);
    L7:
        r12 = r12 + 1;
        goto L3
    }

    @CalledByNative
    public void updateNodeReloadPatching(int[] r5) {
        int r10 = r5.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L11;
        int r12 = r5[r11];
        LynxBaseUI r13 = (LynxBaseUI) this.f10169a.g.get(Integer.valueOf(r12));
        if (r13 == null) goto L10;
        if ((r13 instanceof UIShadowProxy) == false) goto L9;
        r13 = ((UIShadowProxy) r13).f10388a;
    L9:
        r13.onNodeReload();
    L10:
        r11 = r11 + 1;
        goto L3
    }

    @CalledByNative
    public void updateProps(int r10, boolean r11, PropBundle r12, ReadableMapBuffer r13) {
        String r5 = null;
        if (r12 == null) goto L5;
        ReadableMap r14 = r12.getProps();
    L6:
        if (r12 == null) goto L8;
        ReadableArray r15 = r12.getEventHandlers();
    L9:
        HashMap r16 = on.a.a(r15);
        if (r12 == null) goto L12;
        ReadableArray r17 = r12.getGestures();
    L13:
        HashMap r18 = un.a.a(r17);
        if (r14 == null) goto L16;
        y0 r19 = new y0(r14, r13);
    L17:
        n0 r20 = this.f10169a;
        r20.getClass();
        if (com.lynx.tasm.utils.j.j() == false) goto L82;
        HashMap r110 = r20.g;
        LynxBaseUI r21 = (LynxBaseUI) r110.get(Integer.valueOf(r10));
        if (r21 == null) goto L84;
        r20.m(r10, r21.getTagName(), r19);
        if (TraceController.g == false) goto L25;
        r5 = "UIOwner.updateProps." + r21.getTagName();
        TraceEvent.c(r5);
    L25:
        if (r16 == null) goto L27;
        r21.setEvents(r16);
    L27:
        if (r18 == null) goto L29;
        r21.setGestureDetectors(r18);
    L29:
        int r22 = 0;
        if (r11 == false) goto L32;
    L34:
        if (r19 != null) goto L36;
    L74:
        r21.updateProperties(r19);
        if (r21.getParentBaseUI() == null) goto L78;
        r20.h(r21.getSign(), r21.getParentBaseUI().getSign());
    L78:
        if (TraceController.g == false) goto L83;
        TraceEvent.a(0, r5);
        return;
    L83:
        return;
    L36:
        if (r19.d() == true) goto L74;
        ReadableMap r23 = r19.f10815a;
        boolean r24 = r23.hasKey("transition");
        ReadableMapBuffer r25 = r19.f10816b;
        if (r24 == true) goto L43;
        if (r25 == null) goto L47;
        if (r25.e(109) != (-1)) goto L43;
    L47:
        if (r23.hasKey("animation") == true) goto L52;
        if (r25 == null) goto L56;
        if (r25.e(64) != (-1)) goto L52;
    L56:
        if (n0.u(r19) == false) goto L74;
        if (r23.getArray("box-shadow") != null) goto L64;
        if (r19.c("outline-style", -1) == (-1)) goto L74;
    L64:
        if ((r21 instanceof UIShadowProxy) == true) goto L74;
        if ((r21.getParent() instanceof UIShadowProxy) == true) goto L74;
        LynxBaseUI r26 = r21.getParentBaseUI();
        if (r26 == null) goto L71;
        r22 = r26.getIndex(r21);
        r20.z(r26.getSign(), r21.getSign());
    L71:
        r20.f10289c.c(r21);
        UIShadowProxy r27 = new UIShadowProxy(r20.f10289c, r21);
        r110.put(Integer.valueOf(r21.getSign()), r27);
        if (r26 == null) goto L74;
        r20.i(r26.getSign(), r27.getSign(), r22);
    L52:
        if ((r21 instanceof UIShadowProxy) == false) goto L54;
        ((UIShadowProxy) r21).f10388a.setAnimation(r23.getArray("animation"));
        goto L56
    L54:
        r21.setAnimation(r23.getArray("animation"));
    L43:
        if ((r21 instanceof UIShadowProxy) == false) goto L45;
        ((UIShadowProxy) r21).f10388a.initTransitionAnimator(r23);
        goto L47
    L45:
        r21.initTransitionAnimator(r23);
        goto L47
    L32:
        if (r21.isFlatten() == false) goto L34;
        r20.o(r10, false);
        r21 = (LynxBaseUI) r110.get(Integer.valueOf(r10));
        goto L34
    L84:
        return;
    L82:
        throw new AssertionError("Expected to run on UI thread!");
    L16:
        r19 = null;
        goto L17
    L12:
        r17 = null;
        goto L13
    L8:
        r15 = null;
        goto L9
    L5:
        r14 = null;
        goto L6
    }

    @CalledByNative
    public void updateScrollInfo(int r5, boolean r10, float r11, boolean r12) {
        LynxBaseUI r13 = this.f10169a.v(r5);
        if ((r13 instanceof UIListContainer) == false) goto L6;
        ((UIListContainer) r13).l(r11, r12);
        return;
    }

    @CalledByNative
    public void validate(int r5) {
        LynxBaseUI r10 = this.f10169a.v(r5);
        if (r10 != null) goto L6;
        LynxLog.b(4, "LynxUIOwner", "try to validate a not-existing node");
        return;
    L6:
        r10.renderIfNeeded();
    }
}
