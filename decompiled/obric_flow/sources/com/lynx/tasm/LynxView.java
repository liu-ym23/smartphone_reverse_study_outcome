package com.lynx.tasm;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.AnyThread;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.tasm.base.TraceController;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxUIRenderer;
import com.lynx.tasm.behavior.a1;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.lynx.tasm.core.JSProxy;
import com.lynx.tasm.core.LynxEngineProxy;
import com.lynx.tasm.core.VSyncMonitor;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.featurecount.LynxFeatureCounter;
import com.lynx.tasm.performance.PerformanceController;
import com.lynx.tasm.utils.CallStackUtil;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class LynxView extends UIBody.UIBodyView {
    private static final String TAG = "LynxView";
    private static final String VIEW_TAG = "lynxview";
    private static final Looper sMainLooper = null;
    private boolean isInPrePainting;
    private boolean mCanDispatchTouchEvent;
    private int mCurrentHeightMeasureSpec;
    private int mCurrentWidthMeasureSpec;
    private boolean mDisableDrawChildHook;
    protected boolean mDispatchTouchEventToDev;
    private volatile boolean mHasReportedAccessFromNonUiThread;
    private boolean mIsAccessibilityDisabled;
    private boolean mIsPrePaintingStage;
    private com.lynx.tasm.behavior.o mKeyboardEvent;
    protected LynxTemplateRender mLynxTemplateRender;
    private WeakReference<Object> mLynxViewGroupRef;
    private int mLynxViewId;
    private boolean mOnLoadFired;
    private String mUrl;

    static {
        sMainLooper = Looper.getMainLooper();
    }

    public LynxView(Context r5) {
        super(r5);
        this.mDispatchTouchEventToDev = true;
        this.mIsAccessibilityDisabled = false;
        this.mDisableDrawChildHook = false;
        this.mLynxViewId = 0;
        this.mOnLoadFired = false;
        this.mIsPrePaintingStage = false;
        this.mHasReportedAccessFromNonUiThread = false;
        this.mCurrentWidthMeasureSpec = -1;
        this.mCurrentHeightMeasureSpec = -1;
        this.isInPrePainting = false;
    }

    public static /* synthetic */ void access$000(LynxView r5, Map r10) {
        r5.putPendingPipelineIdsToMap(r10);
    }

    public static l0 builder() {
        return new l0();
    }

    private void checkAccessFromNonUiThread(String r5) {
        if (getLynxContext() != null) goto L5;
        return;
    L5:
        if (LynxEnv.inst().enableCheckAccessFromNonUIThread() == true) goto L7;
        return;
    L7:
        if (this.mHasReportedAccessFromNonUiThread == false) goto L10;
        return;
    L10:
        if (sMainLooper != Looper.myLooper()) goto L12;
        return;
    L12:
        if (TextUtils.isEmpty(this.mUrl) == true) goto L24;
        this.mHasReportedAccessFromNonUiThread = true;
        HashMap r10 = new HashMap();
        r10.put("url", this.mUrl);
        if (getThreadStrategyForRendering() == null) goto L17;
        int r11 = getThreadStrategyForRendering().f10067a;
    L18:
        r10.put(LynxEventReporter.PROP_NAME_THREAD_MODE, Integer.valueOf(r11));
        r10.put(LynxEventReporter.PROP_NAME_LYNX_SDK_VERSION, LynxEnv.inst().getLynxVersion());
        r10.put("method", r5);
        LynxEventReporter.onEvent("lynxsdk_access_lynxview_from_non_ui_thread", r10, -1);
        return;
    L17:
        r11 = -1;
        goto L18
    }

    private void initLynxTemplateRender(Context r5, l0 r10) {
        LynxTemplateRender r11 = this.mLynxTemplateRender;
        if (r11 == null) goto L6;
        r11.q(this);
        return;
    L6:
        this.mLynxUIRender.getClass();
        this.mIsAccessibilityDisabled = false;
        this.mLynxTemplateRender = new LynxTemplateRender(r5, this, r10);
    }

    private void initLynxViewWithRuntime(Context r5, l0 r10) {
        r10.getClass();
        LynxLog.b(3, TAG, "init LynxView with runtime, null");
        throw null;
    }

    private void initialize(Context r5, l0 r10) {
        setFocusableInTouchMode(true);
        if (LynxEnv.inst().enableFreshRateOpt() == true) goto L6;
        VSyncMonitor.f10831a = new WeakReference((WindowManager) r5.getSystemService("window"));
        VSyncMonitor.d = false;
    L6:
        if (VSyncMonitor.f10833c != null) goto L9;
        com.lynx.tasm.utils.j.f(new com.bytedance.android.anniex.worker.a(25));
    L9:
        initLynxTemplateRender(r5, r10);
        this.mKeyboardEvent = new com.lynx.tasm.behavior.o(getLynxContext());
        this.mLynxUIRender.getClass();
        this.mDisableDrawChildHook = false;
    }

    private void onTraceEventBegin(String r5, Callable<HashMap<String, String>> r10) {
        if (TraceController.g == false) goto L19;
        HashMap r11 = new HashMap();
        if (getLynxContext() == null) goto L8;
        String r12 = String.valueOf(getLynxContext().A);
    L9:
        r11.put("instance_id", r12);
        r11.put("lynx_view", toString());
        if (r10 != null) goto L17;
    L15:
        TraceEvent.b(0, r5, r11);
        return;
    L17:
        r11.putAll(r10.call());     // Catch: Exception -> L13
    L13:
        e = move-exception;
        r11.put("exception", e.toString());
        goto L15
    L8:
        r12 = "null";
        goto L9
    }

    private void onTraceEventEnd(String r5) {
        if (TraceController.g == true) goto L5;
        return;
    L5:
        TraceEvent.a(0, r5);
    }

    private void putPendingPipelineIdsToMap(Map<String, String> r5) {
        LynxTemplateRender r10 = this.mLynxTemplateRender;
        if (r10 == null) goto L18;
        PerformanceController r11 = r10.Q;
        if (r11 == null) goto L19;
        JavaOnlyArray r12 = r11.e;
        StringBuilder r13 = new StringBuilder();
        Iterator<Object> r14 = r12.iterator();
    L8:
        if (r14.hasNext() == false) goto L13;
        Object r15 = r14.next();
        if (r13.length() <= 0) goto L12;
        r13.append(",");
    L12:
        r13.append(String.valueOf(r15));
        goto L8
    L13:
        r5.put("pipeline_ids", r13.toString());
        return;
    L19:
        return;
    }

    private void showMessageOnConsole(String r5, int r10) {
        getBaseInspectorOwner();
    }

    private void triggerEmbeddedModeLifecycle(String r5, boolean r10) {
    }

    public void addLynxViewClient(o0 r5) {
        LynxTemplateRender r10 = this.mLynxTemplateRender;
        if (r10 == null) goto L12;
        if (r5 == null) goto L13;
        p0 r11 = r10.f10033m;
        if (r11.f10927a.contains(r5) == true) goto L11;
        r11.f10927a.add(r5);
        return;
    L11:
        return;
    L13:
        return;
    }

    public void addLynxViewClientV2(r0 r5) {
        LynxTemplateRender r10 = this.mLynxTemplateRender;
        if (r10 == null) goto L12;
        q0 r11 = r10.f10034n;
        if (r5 != null) goto L7;
        r11.getClass();
        return;
    L7:
        if (r11.f10938a.contains(r5) == true) goto L13;
        r11.f10938a.add(r5);
        return;
    L13:
        return;
    }

    public void addRuntimeLifecycleListener(@NonNull com.lynx.jsbridge.s r5) {
        LynxTemplateRender r10 = this.mLynxTemplateRender;
        if (r10 == null) goto L12;
        if (r5 == null) goto L10;
        JSProxy r11 = r10.X;
        if (r11 == null) goto L10;
        r11.e(r5);
        return;
    L10:
        LynxLog.b(3, "LynxTemplateRender", "add a null lifecycle listener or js proxy is null.");
        return;
    }

    public void attachEngineToUIThread() {
        LynxTemplateRender r5 = this.mLynxTemplateRender;
        if (r5 == null) goto L6;
        r5.c();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, com.lynx.tasm.behavior.ui.a
    public void bindDrawChildHook(com.lynx.tasm.behavior.ui.b r5) {
        if (this.mDisableDrawChildHook == false) goto L5;
        return;
    L5:
        super.bindDrawChildHook(r5);
    }

    public void destroy() {
        com.lynx.tasm.behavior.ui.utils.p.j(this, new StringBuilder("lynxview destroy "), 2);
        triggerEmbeddedModeLifecycle("onDestroy", true);
        TraceEvent.c("DestroyLynxView");
        WeakReference<Object> r5 = this.mLynxViewGroupRef;
        if (r5 != null) goto L5;
    L9:
        com.lynx.tasm.behavior.o r10 = this.mKeyboardEvent;
        if (r10 == null) goto L31;
        if (r10.d == false) goto L31;
        monitor-enter(r10);
    L23:
        th = move-exception;
        throw th;
    L15:
        if (r10.d == true) goto L19;
        monitor-exit(r10);
    L47:
        goto L31
    L19:
        if (com.lynx.tasm.utils.j.j() == true) goto L25;
        com.lynx.tasm.behavior.l r11 = new com.lynx.tasm.behavior.l(r10, 2);     // Catch: Throwable -> L23
        com.lynx.tasm.utils.j.a().post(r11);     // Catch: Throwable -> L23
        monitor-exit(r10);
        goto L47
    L25:
        r10.e();     // Catch: Throwable -> L23
        monitor-exit(r10);
    L31:
        if (this.mLynxTemplateRender == null) goto L33;
        xm.i r12 = xm.f.f23173a;
        xm.i.a(r12.f, this);
        xm.i.a(r12.f23176c, this);
        xm.i.a(r12.f23175b, this);
        xm.i.a(r12.e, this);
        xm.i.a(r12.d, this);
        this.mLynxTemplateRender.w0();
        this.mLynxTemplateRender.S();
        this.mLynxTemplateRender = null;
    L33:
        com.lynx.tasm.behavior.ui.accessibility.d r13 = this.mA11yWrapper;
        if (r13 == null) goto L45;
        com.google.common.reflect.w r14 = r13.f10410j;
        if (r14 == null) goto L45;
        AccessibilityManager r15 = (AccessibilityManager) r14.f9377c;
        if (r15 == null) goto L45;
        com.lynx.tasm.behavior.ui.accessibility.a r16 = (com.lynx.tasm.behavior.ui.accessibility.a) r14.f9376b;
        if (r16 == null) goto L42;
        r15.removeAccessibilityStateChangeListener(r16);
    L42:
        com.lynx.tasm.behavior.ui.accessibility.b r17 = (com.lynx.tasm.behavior.ui.accessibility.b) r14.d;
        if (r17 == null) goto L45;
        r15.removeTouchExplorationStateChangeListener(r17);
    L45:
        TraceEvent.a(0, "DestroyLynxView");
        return;
    L5:
        if (r5.get() == null) goto L9;
        throw new ClassCastException();
    }

    public void detachEngineFromUIThread() {
        LynxTemplateRender r5 = this.mLynxTemplateRender;
        if (r5 == null) goto L6;
        r5.l0();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r5) {
        onTraceEventBegin("LynxView.onDraw", new k0(this));
        super.dispatchDraw(r5);
        LynxTemplateRender r10 = this.mLynxTemplateRender;
        if (r10 == null) goto L20;
        b0 r11 = r10.e;
        if (r11 == null) goto L20;
        com.lynx.tasm.behavior.ui.y r12 = r11.f10155x;
        if (r12 == null) goto L9;
        com.lynx.tasm.utils.j.f(new com.lynx.tasm.behavior.x(r12, 2));
    L9:
        u0 r13 = r11.K;
        if (r13 == null) goto L12;
        boolean r14 = r13.E;
    L13:
        if (r14 == false) goto L20;
        WeakReference r15 = r11.f10148p;
        if (r15 == null) goto L20;
        com.lynx.tasm.behavior.w r16 = (com.lynx.tasm.behavior.w) r15.get();
        if (r16 == null) goto L20;
        com.lynx.tasm.utils.j.f(new com.lynx.tasm.behavior.x(r16, 2));
        goto L20
    L12:
        r14 = false;
    L20:
        if (this.mOnLoadFired == false) goto L22;
    L24:
        onTraceEventEnd("LynxView.onDraw");
        return;
    L22:
        if (this.mIsPrePaintingStage == true) goto L24;
        this.mOnLoadFired = true;
        triggerEmbeddedModeLifecycle("onLoad", true);
        goto L24
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent r5) {
        if (lynxUIRenderer() == null) goto L6;
        lynxUIRenderer().getClass();
    L6:
        return super.dispatchKeyEvent(r5);
    }

    @Override // android.view.ViewGroup, android.view.View
    @Keep
    public boolean dispatchTouchEvent(MotionEvent r13) {
        int r5 = r13.getAction();     // Catch: Throwable -> L13
        if (r5 == 0) goto L8;
        if (r5 == 1) goto L8;
        if (r5 == 3) goto L8;
    L10:
        if (this.mLynxTemplateRender == null) goto L12;
        lynxUIRenderer();     // Catch: Throwable -> L13
        if (isChildLynxPageUI() == false) goto L20;
        return super.dispatchTouchEvent(r13);
    L20:
        if (r5 != 0) goto L26;
        if (LynxEnv.inst().isHighlightTouchEnabled() == false) goto L24;
        showMessageOnConsole("LynxView: dispatch touch for lynx " + hashCode() + ", touch: " + r5 + " x: " + r13.getX() + " y: " + r13.getY(), 0);     // Catch: Throwable -> L13
    L24:
        this.mCanDispatchTouchEvent = true;     // Catch: Throwable -> L13
    L26:
        if (this.mCanDispatchTouchEvent == false) goto L57;
        float r10 = r13.getX();     // Catch: Throwable -> L13
        float r11 = r13.getY();     // Catch: Throwable -> L13
        LynxTemplateRender r12 = this.mLynxTemplateRender;     // Catch: Throwable -> L13
        r12.getClass();     // Catch: Throwable -> L13
        com.lynx.tasm.behavior.i r14 = r12.O;     // Catch: Throwable -> L13
        if (r14 == null) goto L35;
        LynxUIRenderer r15 = (LynxUIRenderer) r14;     // Catch: Throwable -> L13
        r15.b();     // Catch: Throwable -> L13
        a1 r16 = r15.f10162c;     // Catch: Throwable -> L13
        if (r16 == null) goto L32;
        boolean r17 = r16.p(r13, null);     // Catch: Throwable -> L13
    L33:
        if (r17 == false) goto L35;
        boolean r18 = true;
    L36:
        r13.setLocation(r10, r11);     // Catch: Throwable -> L13
        if (r18 == false) goto L58;
        com.lynx.tasm.behavior.i r19 = this.mLynxTemplateRender.O;     // Catch: Throwable -> L13
        if (r19 == null) goto L52;
        a1 r20 = ((LynxUIRenderer) r19).f10162c;     // Catch: Throwable -> L13
        if (r20 == null) goto L52;
        wm.a r21 = r20.f10179c;     // Catch: Throwable -> L13
        if (r21 == null) goto L52;
    L45:
        if (r21 == null) goto L52;
        if (r21.parent() == r21) goto L52;
        if (r21.blockNativeEvent(r13) == true) goto L50;
        r21 = r21.parent();     // Catch: Throwable -> L13
        goto L45
    L50:
        boolean r22 = true;
    L53:
        if (r22 == false) goto L58;
        if (getParent() == null) goto L58;
        getParent().requestDisallowInterceptTouchEvent(true);     // Catch: Throwable -> L13
    L52:
        r22 = false;
    L58:
        if (r5 == 1) goto L61;
        if (r5 == 3) goto L61;
    L64:
        if (r18 == true) goto L66;
    L76:
        return false;
    L66:
        if (this.mDispatchTouchEventToDev == false) goto L69;
        this.mLynxTemplateRender.getClass();     // Catch: Throwable -> L13
    L69:
        if (this.mLynxTemplateRender.N(r13) == false) goto L72;
        return true;
    L72:
        return super.dispatchTouchEvent(r13);
    L61:
        if (LynxEnv.inst().isHighlightTouchEnabled() == false) goto L63;
        showMessageOnConsole("LynxView: dispatch touch for lynx " + hashCode() + ", touch: " + r5 + " x: " + r13.getX() + " y: " + r13.getY(), 0);     // Catch: Throwable -> L13
    L63:
        this.mCanDispatchTouchEvent = false;     // Catch: Throwable -> L13
        goto L64
    L32:
        r17 = false;
    L35:
        r18 = false;
        goto L36
    L57:
        r18 = false;
        goto L58
    L12:
        return super.dispatchTouchEvent(r13);
    L8:
        LynxLog.b(2, LynxMonitorService.DEFAULT_PID, "LynxView dispatchTouchEvent, this: " + hashCode() + ", touch: " + r13.getActionMasked() + " x: " + r13.getX() + " y: " + r13.getY());     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        if (this.mLynxTemplateRender == null) goto L76;
        LynxError r23 = new LynxError(109900, androidx.room.jarjarred.org.antlr.runtime.a.x(th, new StringBuilder("An exception occurred during dispatchTouchEvent(): ")), "This error is caught by native, please ask Lynx for help", "error");
        String r110 = CallStackUtil.a(th);
        r23.g = null;
        r23.f9999n = r110;
        this.mLynxTemplateRender.onErrorOccurred(r23);
        goto L76
    }

    public boolean enableAirStrictMode() {
        LynxTemplateRender r5 = this.mLynxTemplateRender;
        if (r5 != null) goto L5;
        return false;
    L5:
        return r5.W;
    }

    public boolean enableJSRuntime() {
        LynxTemplateRender r5 = this.mLynxTemplateRender;
        if (r5 != null) goto L5;
        return true;
    L5:
        return r5.V;
    }

    @Nullable
    public LynxBaseUI findUIByIdSelector(String r5) {
        LynxTemplateRender r10 = this.mLynxTemplateRender;
        if (r10 != null) goto L5;
        return null;
    L5:
        com.lynx.tasm.behavior.i r11 = r10.O;
        if (r11 == null) goto L11;
        com.lynx.tasm.behavior.n0 r12 = ((LynxUIRenderer) r11).f10161b;
        if (r12 == null) goto L11;
        return r12.E(r5);
    L11:
        return null;
    }

    @Nullable
    public LynxBaseUI findUIByIndex(int r5) {
        LynxTemplateRender r10 = this.mLynxTemplateRender;
        if (r10 == null) goto L10;
        com.lynx.tasm.behavior.i r11 = r10.O;
        if (r11 == null) goto L10;
        com.lynx.tasm.behavior.n0 r12 = ((LynxUIRenderer) r11).f10161b;
        if (r12 == null) goto L10;
        return (LynxBaseUI) r12.g.get(Integer.valueOf(r5));
    L10:
        return null;
    }

    @Nullable
    public LynxBaseUI findUIByName(String r5) {
        LynxTemplateRender r10 = this.mLynxTemplateRender;
        if (r10 != null) goto L5;
        return null;
    L5:
        com.lynx.tasm.behavior.i r11 = r10.O;
        if (r11 == null) goto L17;
        com.lynx.tasm.behavior.n0 r12 = ((LynxUIRenderer) r11).f10161b;
        if (r12 == null) goto L17;
        Iterator r13 = r12.g.values().iterator();
    L11:
        if (r13.hasNext() == false) goto L17;
        LynxBaseUI r14 = (LynxBaseUI) r13.next();
        if (r14 == null) goto L11;
        if (r5.equals(r14.getName()) == false) goto L11;
        return r14;
    L17:
        return null;
    }

    @Nullable
    public View findViewByIdSelector(String r5) {
        LynxTemplateRender r10 = this.mLynxTemplateRender;
        if (r10 != null) goto L5;
        return null;
    L5:
        com.lynx.tasm.behavior.i r11 = r10.O;
        if (r11 == null) goto L10;
        com.lynx.tasm.behavior.n0 r12 = ((LynxUIRenderer) r11).f10161b;
        if (r12 == null) goto L10;
        LynxBaseUI r13 = r12.E(r5);
    L12:
        if ((r13 instanceof LynxUI) == true) goto L14;
        return null;
    L14:
        return ((LynxUI) r13).getView();
    L10:
        r13 = null;
        goto L12
    }

    @Nullable
    public View findViewByName(String r5) {
        LynxTemplateRender r10 = this.mLynxTemplateRender;
        if (r10 != null) goto L5;
        return null;
    L5:
        com.lynx.tasm.behavior.i r11 = r10.O;
        if (r11 == null) goto L17;
        com.lynx.tasm.behavior.n0 r12 = ((LynxUIRenderer) r11).f10161b;
        if (r12 == null) goto L17;
        Iterator r13 = r12.g.values().iterator();
    L11:
        if (r13.hasNext() == false) goto L17;
        LynxBaseUI r14 = (LynxBaseUI) r13.next();
        if (r14 == null) goto L11;
        if (r5.equals(r14.getName()) == false) goto L11;
    L19:
        if ((r14 instanceof LynxUI) == true) goto L21;
        return null;
    L21:
        return ((LynxUI) r14).getView();
    L17:
        r14 = null;
        goto L19
    }

    @Nullable
    @Deprecated
    public y forceGetPerf() {
        return null;
    }

    public HashMap<String, Object> getAllTimingInfo() {
        LynxTemplateRender r5 = this.mLynxTemplateRender;
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.p0();
    }

    public mm.b getBaseInspectorOwner() {
        return null;
    }

    @Deprecated
    public void getCurrentData(s r5) {
        checkAccessFromNonUiThread("getCurrentData");
        LynxTemplateRender r10 = this.mLynxTemplateRender;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.m(r5);
    }

    public int getCurrentHeightMeasureSpec() {
        return this.mCurrentHeightMeasureSpec;
    }

    public int getCurrentWidthMeasureSpec() {
        return this.mCurrentWidthMeasureSpec;
    }

    @Deprecated
    public long getFirstMeasureTime() {
        LynxTemplateRender r5 = this.mLynxTemplateRender;
        if (r5 != null) goto L7;
        return -1;
    L7:
        return r5.f10045z;
    }

    public com.lynx.jsbridge.b getJSModule(String r5) {
        LynxTemplateRender r10 = this.mLynxTemplateRender;
        if (r10 != null) goto L5;
        return null;
    L5:
        b0 r11 = r10.e;
        if (r11 == null) goto L14;
        WeakReference r12 = r11.f10142j;
        if (r12 != null) goto L10;
        return null;
    L10:
        JSProxy r13 = (JSProxy) r12.get();
        if (r13 != null) goto L13;
        return null;
    L13:
        return new com.lynx.jsbridge.b(r5, r13);
    L14:
        return null;
    }

    public com.lynx.tasm.behavior.o getKeyboardEvent() {
        return this.mKeyboardEvent;
    }

    public l getLynxConfigInfo() {
        return new l();
    }

    public LynxContext getLynxContext() {
        LynxTemplateRender r5 = this.mLynxTemplateRender;
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.e;
    }

    public UIGroup<UIBody.UIBodyView> getLynxUIRoot() {
        LynxTemplateRender r5 = this.mLynxTemplateRender;
        if (r5 != null) goto L5;
        return null;
    L5:
        com.lynx.tasm.behavior.i r10 = r5.O;
        if (r10 == null) goto L11;
        com.lynx.tasm.behavior.n0 r11 = ((LynxUIRenderer) r10).f10161b;
        if (r11 == null) goto L11;
        return r11.f10288b;
    L11:
        return null;
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView
    public l0 getLynxViewBuilder() {
        LynxTemplateRender r5 = this.mLynxTemplateRender;
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.u0();
    }

    public int getLynxViewId() {
        return this.mLynxViewId;
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView
    public List<com.lynx.tasm.behavior.ui.p> getMeaningfulPaintingAreas() {
        if (getLynxContext() != null) goto L5;
        return null;
    L5:
        getLynxContext().getClass();
        return null;
    }

    @Nullable
    public Map<String, Object> getPageDataByKey(String[] r5) {
        checkAccessFromNonUiThread("getPageDataByKey");
        if (r5 != null) goto L5;
    L12:
        LynxLog.b(2, TAG, "getPageDataByKey called with empty keys.");
        return null;
    L5:
        if (r5.length == 0) goto L12;
        LynxTemplateRender r10 = this.mLynxTemplateRender;
        if (r10 != null) goto L11;
        return null;
    L11:
        return r10.b(r5);
    }

    @Deprecated
    public String getPageVersion() {
        LynxTemplateRender r5 = this.mLynxTemplateRender;
        if (r5 != null) goto L5;
        return "";
    L5:
        b0 r10 = r5.e;
        if (r10 != null) goto L8;
        return "";
    L8:
        u0 r11 = r10.K;
        if (r11 != null) goto L13;
        LynxLog.b(4, "LynxContext", "PageConfig is null.GetPageVersion get default error;");
        return "error";
    L13:
        return r11.d;
    }

    @AnyThread
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public String getRenderPhase() {
        LynxTemplateRender r5 = this.mLynxTemplateRender;
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.R;
    }

    public void getSessionStorageItem(String r5, PlatformCallBack r10) {
        checkAccessFromNonUiThread("getSessionStorageItem");
        LynxTemplateRender r11 = this.mLynxTemplateRender;
        if (r11 == null) goto L6;
        r11.A(r5, r10);
        return;
    }

    @Override // android.view.View
    public Object getTag() {
        return VIEW_TAG;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public TemplateData getTemplateData() {
        LynxTemplateRender r5 = this.mLynxTemplateRender;
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.f10029j0.p();
    }

    @Nullable
    public String getTemplateUrl() {
        LynxTemplateRender r5 = this.mLynxTemplateRender;
        if (r5 != null) goto L6;
        return null;
    L6:
        String r10 = r5.g;
        if (r10 != null) goto L10;
        return "";
    L10:
        return r10;
    }

    @Deprecated
    public mo.a getTheme() {
        LynxContext r5 = getLynxContext();
        if (r5 == null) goto L5;
        LynxFeatureCounter.a(77, r5.A);
    L5:
        LynxTemplateRender r10 = this.mLynxTemplateRender;
        if (r10 != null) goto L10;
        return null;
    L10:
        return r10.f10043x;
    }

    public ThreadStrategyForRendering getThreadStrategyForRendering() {
        LynxTemplateRender r5 = this.mLynxTemplateRender;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.f10032l;
    }

    public void initWithLynxViewBuilder(l0 r5) {
        r5.f10912t.getClass();
        LynxUIRenderer r10 = new LynxUIRenderer();
        ThreadStrategyForRendering r11 = r5.f10910q;
        if (r11 == null) goto L5;
        r5.f10910q = r11;
    L5:
        this.mLynxUIRender = r10;
        LynxLog.b(2, TAG, "new lynxview detail " + this);
        com.lynx.tasm.behavior.i r12 = this.mLynxUIRender;
        getContext();
        u r13 = r5.f10900c.f10894c;
        r12.getClass();
        initialize(getContext(), r5);
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isAccessibilityDisabled() {
        return this.mIsAccessibilityDisabled;
    }

    @AnyThread
    public void loadTemplate(@NonNull x r10) {
        if (r10 == null) goto L44;
        LynxLoadMode r5 = LynxLoadMode.f10004b;
        LynxLoadMode r11 = r10.f;
        if (r11 != r5) goto L7;
    L8:
        this.mIsPrePaintingStage = true;
    L10:
        if (isLayoutRequested() == false) goto L39;
        if (r5 != r11) goto L39;
        this.isInPrePainting = true;
        if (getChildCount() <= 0) goto L15;
        removeAllViewsInLayout();
    L15:
        ViewGroup.LayoutParams r12 = getLayoutParams();
        if (r12 == null) goto L20;
        int r13 = r12.width;
        if (r13 < 0) goto L20;
    L21:
        int r14 = View.MeasureSpec.makeMeasureSpec(r13, BasicMeasure.EXACTLY);
        if (r12 == null) goto L26;
        int r15 = r12.height;
        if (r15 < 0) goto L26;
    L27:
        measure(r14, View.MeasureSpec.makeMeasureSpec(r15, BasicMeasure.EXACTLY));
        if (r12 == null) goto L32;
        int r16 = r12.width;
        if (r16 < 0) goto L32;
    L33:
        if (r12 == null) goto L37;
        int r17 = r12.height;
        if (r17 < 0) goto L37;
    L38:
        layout(0, 0, r16, r17);
        this.isInPrePainting = false;
    L37:
        r17 = 0;
    L32:
        r16 = 0;
    L26:
        r15 = 0;
    L20:
        r13 = 0;
    L39:
        com.lynx.tasm.behavior.ui.utils.p.j(this, new StringBuilder("loadTemplate with LynxLoadMeta in "), 2);
        LynxTemplateRender r18 = this.mLynxTemplateRender;
        if (r18 != null) goto L42;
        return;
    L42:
        r18.V(r10);
        return;
    L7:
        if (r11 != LynxLoadMode.f10005c) goto L10;
    }

    public com.lynx.tasm.behavior.i lynxUIRenderer() {
        LynxTemplateRender r5 = this.mLynxTemplateRender;
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.v0();
    }

    @Override // android.view.ViewGroup, android.view.View
    @Keep
    public void onAttachedToWindow() {
        onTraceEventBegin("LynxView.onAttachedToWindow", null);
        super.onAttachedToWindow();
        LynxLog.b(2, LynxMonitorService.DEFAULT_PID, "onAttachedToWindow:" + hashCode());
        LynxTemplateRender r5 = this.mLynxTemplateRender;
        if (r5 == null) goto L18;
        String r10 = "lynxview onAttachedToWindow " + r5;
        LynxLog.b(2, "LynxTemplateRender", r10);
        r5.f0(r10);
        r5.k0(false);
        com.lynx.tasm.behavior.i r11 = r5.O;
        if (r11 == null) goto L12;
        com.lynx.tasm.behavior.n0 r12 = ((LynxUIRenderer) r11).f10161b;
        if (r12 == null) goto L12;
        UIBody r13 = r12.f10288b;
        if (r13 == null) goto L12;
        r13.onAttach();
    L12:
        b0 r14 = r5.e;
        if (r14 == null) goto L17;
        com.lynx.tasm.behavior.ui.y r15 = r14.f10155x;
        if (r15 == null) goto L17;
        r15.g();
    L17:
        LynxTemplateRender.j0(r10);
    L18:
        onTraceEventEnd("LynxView.onAttachedToWindow");
    }

    @Override // android.view.ViewGroup, android.view.View
    @Keep
    public void onDetachedFromWindow() {
        onTraceEventBegin("LynxView.onDetachedFromWindow", null);
        LynxLog.b(2, LynxMonitorService.DEFAULT_PID, "onDetachedFromWindow:" + hashCode());
        LynxTemplateRender r5 = this.mLynxTemplateRender;
        if (r5 == null) goto L5;
        r5.w0();
    L5:
        super.onDetachedFromWindow();
        onTraceEventEnd("LynxView.onDetachedFromWindow");
    }

    public void onEnterBackground() {
        checkAccessFromNonUiThread("onEnterBackground");
        com.lynx.tasm.behavior.ui.utils.p.j(this, new StringBuilder("onEnterBackground"), 2);
        LynxTemplateRender r5 = this.mLynxTemplateRender;
        if (r5 == null) goto L5;
        r5.g0(true);
    L5:
        lynxUIRenderer();
    }

    public void onEnterForeground() {
        checkAccessFromNonUiThread("onEnterForeground");
        com.lynx.tasm.behavior.ui.utils.p.j(this, new StringBuilder("onEnterForeground "), 2);
        LynxTemplateRender r5 = this.mLynxTemplateRender;
        if (r5 == null) goto L5;
        r5.k0(true);
    L5:
        lynxUIRenderer();
    }

    @Override // android.view.ViewGroup
    @Keep
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        LynxLog.b(2, LynxMonitorService.DEFAULT_PID, "LynxView onInterceptTouchEvent, this: " + hashCode());     // Catch: Throwable -> L7
        if (isChildLynxPageUI() == false) goto L10;
        return super.onInterceptTouchEvent(r10);
    L10:
        return super.onInterceptTouchEvent(r10);
    L7:
        th = move-exception;
        if (this.mLynxTemplateRender == null) goto L17;
        LynxError r5 = new LynxError(109900, androidx.room.jarjarred.org.antlr.runtime.a.x(th, new StringBuilder("An exception occurred during onInterceptTouchEvent(): ")), "This error is caught by native, please ask Lynx for help", "error");
        String r11 = CallStackUtil.a(th);
        r5.g = null;
        r5.f9999n = r11;
        this.mLynxTemplateRender.onErrorOccurred(r5);
        return false;
    L17:
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    @Keep
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        onTraceEventBegin("LynxView.onLayout", new i0(this, r10, r11, r12, r13, r14));
        LynxTemplateRender r15 = this.mLynxTemplateRender;
        if (r15 != null) goto L5;
    L30:
        onTraceEventEnd("LynxView.onLayout");
        return;
    L5:
        if (this.isInPrePainting == true) goto L30;
        PerformanceController r16 = r15.Q;
        if (r16 == null) goto L11;
        r16.d("layoutStart");
    L11:
        if (lynxUIRenderer() == null) goto L13;
        this.mLynxTemplateRender.x0();
    L14:
        if (r10 == true) goto L16;
    L25:
        PerformanceController r17 = this.mLynxTemplateRender.Q;
        if (r17 == null) goto L28;
        r17.d("layoutEnd");
    L28:
        onTraceEventEnd("LynxView.onLayout");
        return;
    L16:
        if (getLynxContext() == null) goto L25;
        u0 r18 = getLynxContext().K;
        if (r18 == null) goto L20;
        boolean r19 = r18.f10984w;
    L21:
        if (r19 == false) goto L25;
        com.lynx.tasm.behavior.o r20 = this.mKeyboardEvent;
        if (r20.d == false) goto L25;
        r20.a();
        goto L25
    L20:
        r19 = false;
        goto L21
    L13:
        onLayoutWhenDetach();
        goto L14
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r5, int r10) {
        onTraceEventBegin("LynxView.onMeasure", new h0(this, r5, r10));
        this.mCurrentWidthMeasureSpec = r5;
        this.mCurrentHeightMeasureSpec = r10;
        LynxLog.b(1, LynxMonitorService.DEFAULT_PID, "onMeasure:" + hashCode() + ", width" + View.MeasureSpec.toString(r5) + ", height" + View.MeasureSpec.toString(r10));
        LynxTemplateRender r11 = this.mLynxTemplateRender;
        if (r11 != null) goto L5;
    L19:
        super.onMeasure(r5, r10);
        onTraceEventEnd("LynxView.onMeasure");
        return;
    L5:
        if (this.isInPrePainting == true) goto L19;
        PerformanceController r12 = r11.Q;
        if (r12 == null) goto L11;
        r12.d("measureStart");
    L11:
        if (lynxUIRenderer() == null) goto L13;
        this.mLynxTemplateRender.getClass();
        this.mLynxTemplateRender.g(r5, r10);
    L14:
        PerformanceController r13 = this.mLynxTemplateRender.Q;
        if (r13 == null) goto L17;
        r13.d("measureEnd");
    L17:
        onTraceEventEnd("LynxView.onMeasure");
        return;
    L13:
        onMeasureWhenDetach(r5, r10);
        goto L14
    }

    @Override // android.view.View
    @Keep
    public boolean onTouchEvent(MotionEvent r10) {
        LynxLog.b(2, LynxMonitorService.DEFAULT_PID, "LynxView onTouchEvent, this: " + hashCode());     // Catch: Throwable -> L7
        if (isChildLynxPageUI() == true) goto L6;
        LynxTemplateRender r5 = this.mLynxTemplateRender;     // Catch: Throwable -> L7
        if (r5 == null) goto L39;
        com.lynx.tasm.behavior.i r11 = r5.O;     // Catch: Throwable -> L7
        if (r11 == null) goto L27;
        a1 r12 = ((LynxUIRenderer) r11).f10162c;     // Catch: Throwable -> L7
        if (r12 == null) goto L27;
        wm.a r13 = r12.f10179c;     // Catch: Throwable -> L7
        if (r13 == null) goto L27;
    L18:
        if (r13 == null) goto L27;
        if (r13.parent() == r13) goto L27;
        if (r13.blockNativeEvent(r10) == true) goto L24;
        r13 = r13.parent();     // Catch: Throwable -> L7
        goto L18
    L24:
        if (getParent() == null) goto L27;
        return true;
    L27:
        super.onTouchEvent(r10);     // Catch: Throwable -> L7
        return true;
    L39:
        return true;
    L6:
        return super.onTouchEvent(r10);
    L7:
        th = move-exception;
        if (this.mLynxTemplateRender == null) goto L41;
        LynxError r14 = new LynxError(109900, androidx.room.jarjarred.org.antlr.runtime.a.x(th, new StringBuilder("An exception occurred during onTouchEvent(): ")), "This error is caught by native, please ask Lynx for help", "error");
        String r15 = CallStackUtil.a(th);
        r14.g = null;
        r14.f9999n = r15;
        this.mLynxTemplateRender.onErrorOccurred(r14);
        return false;
    L41:
        return false;
    }

    public void pauseRootLayoutAnimation() {
        LynxTemplateRender r5 = this.mLynxTemplateRender;
        if (r5 == null) goto L13;
        com.lynx.tasm.behavior.i r10 = r5.O;
        if (r10 == null) goto L11;
        com.lynx.tasm.behavior.n0 r11 = ((LynxUIRenderer) r10).f10161b;
        if (r11 == null) goto L12;
        r11.f10294l = false;
        return;
    L12:
        return;
    L11:
        return;
    }

    @Deprecated
    public void preloadDynamicComponents(@NonNull String[] r5) {
        checkAccessFromNonUiThread("preloadDynamicComponents");
        com.lynx.tasm.behavior.ui.utils.e.i(new StringBuilder("preload lazy bundles: "), TextUtils.join(", ", r5), 2, TAG);
        LynxTemplateRender r10 = this.mLynxTemplateRender;
        if (r10 == null) goto L10;
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.length == 0) goto L12;
        r10.Y(r5);
        return;
    L12:
        return;
    }

    @Deprecated
    public void processLayout(@NonNull String r5, TemplateData r10) {
        com.lynx.tasm.behavior.ui.utils.p.j(this, com.lynx.tasm.utils.e.b("processLayout ", r5, "with templateData in "), 2);
        LynxTemplateRender r11 = this.mLynxTemplateRender;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.n0(false);
        r11.X(r5, new ug.d(r11, r5, r10));
    }

    @Deprecated
    public void processLayoutWithSSRUrl(@NonNull String r5, TemplateData r10) {
        com.lynx.tasm.behavior.ui.utils.p.j(this, new StringBuilder("processLayoutWithSSRUrl in "), 2);
        LynxTemplateRender r11 = this.mLynxTemplateRender;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.n0(false);
        r11.z(r5, new a0(r11, r5, r10));
    }

    @Deprecated
    public void processLayoutWithTemplateBundle(@NonNull TemplateBundle r5, TemplateData r10, String r11) {
        com.lynx.tasm.behavior.ui.utils.p.j(this, new StringBuilder("processLayoutWithTemplateBundle in "), 2);
        LynxTemplateRender r12 = this.mLynxTemplateRender;
        if (r12 != null) goto L5;
        return;
    L5:
        r12.n0(false);
        r12.r(r5, r10, r11);
    }

    @UiThread
    public void processRender() {
        checkAccessFromNonUiThread("processRender");
        if (this.mLynxTemplateRender != null) goto L5;
        return;
    L5:
        com.lynx.tasm.behavior.ui.utils.p.j(this, new StringBuilder("LynxView call processRender in "), 2);
        this.mLynxTemplateRender.A0();
    }

    public void putParamsForReportingEvents(Map<String, Object> r5) {
        if (r5 == null) goto L11;
        LynxTemplateRender r10 = this.mLynxTemplateRender;
        if (r10 == null) goto L12;
        r10.f0("LynxTemplateRender.putExtraParamsForReportEvents");
        b0 r11 = r10.e;
        if (r11 == null) goto L9;
        LynxEventReporter.putExtraParams(r5, r11.A);
    L9:
        LynxTemplateRender.j0("LynxTemplateRender.putExtraParamsForReportEvents");
        return;
    L12:
        return;
    }

    @Deprecated
    public boolean registerDynamicComponent(@NonNull String r5, @NonNull TemplateBundle r10) {
        LynxLog.b(2, TAG, "register lazy bundle with TemplateBundle: " + r5);
        LynxTemplateRender r11 = this.mLynxTemplateRender;
        if (r11 != null) goto L7;
        return false;
    L7:
        return r11.O(r5, r10);
    }

    public void reloadAndInit() {
        lynxUIRenderer();
        removeAllViews();
    }

    public void reloadTemplate(TemplateData r5) {
        reloadTemplate(r5, null);
    }

    public void removeLynxViewClient(o0 r5) {
        LynxTemplateRender r10 = this.mLynxTemplateRender;
        if (r10 == null) goto L12;
        if (r5 != null) goto L7;
        return;
    L7:
        p0 r11 = r10.f10033m;
        if (r11 == null) goto L11;
        r11.f10927a.remove(r5);
        return;
    L11:
        return;
    }

    public void removeLynxViewClientV2(r0 r5) {
        LynxTemplateRender r10 = this.mLynxTemplateRender;
        if (r10 == null) goto L6;
        r10.f10034n.f10938a.remove(r5);
        return;
    }

    public void renderSSR(@NonNull byte[] r5, @NonNull String r10, Map<String, Object> r11) {
        LynxLog.b(1, TAG, "renderSSR " + r10);
        LynxTemplateRender r12 = this.mLynxTemplateRender;
        if (r12 != null) goto L5;
        return;
    L5:
        TemplateData r13 = TemplateData.c(r11);
        r13.e = true;
        r12.J(r5, r13, r10);
    }

    public void renderSSRUrl(@NonNull String r5, TemplateData r10) {
        LynxLog.b(1, TAG, "renderSSRUrl " + r5);
        this.mUrl = r5;
        LynxTemplateRender r11 = this.mLynxTemplateRender;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.z(r5, new a0(r11, r5, r10));
    }

    public void renderTemplate(byte[] r5, Map<String, Object> r10) {
        com.lynx.tasm.behavior.ui.utils.p.j(this, new StringBuilder("renderTemplate with init data in "), 2);
        LynxTemplateRender r11 = this.mLynxTemplateRender;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.L(r5, r10);
    }

    public void renderTemplateBundle(@NonNull TemplateBundle r5, TemplateData r10, String r11) {
        com.lynx.tasm.behavior.ui.utils.p.j(this, new StringBuilder("renderTemplateBundle with templateData in "), 2);
        LynxTemplateRender r12 = this.mLynxTemplateRender;
        if (r12 != null) goto L5;
        return;
    L5:
        r12.r(r5, r10, r11);
    }

    public void renderTemplateUrl(@NonNull String r5, TemplateData r10) {
        com.lynx.tasm.behavior.ui.utils.p.j(this, com.lynx.tasm.utils.e.b("renderTemplateUrl ", r5, "with templateData in"), 2);
        this.mUrl = r5;
        LynxTemplateRender r11 = this.mLynxTemplateRender;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.X(r5, new ug.d(r11, r5, r10));
    }

    public void renderTemplateWithBaseUrl(byte[] r5, TemplateData r10, String r11) {
        com.lynx.tasm.behavior.ui.utils.p.j(this, com.lynx.tasm.utils.e.b("renderTemplateWithBaseUrl ", r11, "with templateData in "), 2);
        this.mUrl = r11;
        LynxTemplateRender r12 = this.mLynxTemplateRender;
        if (r12 != null) goto L5;
        return;
    L5:
        r12.q0(r11);
        r12.I(r5, r10);
        LynxLog.b(2, "LynxTemplateRender", r12.R("renderTemplate"));
    }

    public void resetData(TemplateData r5) {
        checkAccessFromNonUiThread("resetData");
        LynxLog.b(2, TAG, "resetData with json in " + r5.toString());
        LynxTemplateRender r10 = this.mLynxTemplateRender;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.e0(r5);
        if (this.mIsPrePaintingStage == false) goto L9;
        this.mIsPrePaintingStage = false;
        return;
    L9:
        triggerEmbeddedModeLifecycle("onDataChanged", true);
    }

    public void resumeRootLayoutAnimation() {
        LynxTemplateRender r5 = this.mLynxTemplateRender;
        if (r5 == null) goto L13;
        com.lynx.tasm.behavior.i r10 = r5.O;
        if (r10 == null) goto L11;
        com.lynx.tasm.behavior.n0 r11 = ((LynxUIRenderer) r10).f10161b;
        if (r11 == null) goto L12;
        r11.f10294l = true;
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView
    public void runOnTasmThread(Runnable r5) {
        checkAccessFromNonUiThread("runOnTasmThread");
        LynxTemplateRender r10 = this.mLynxTemplateRender;
        if (r10 != null) goto L5;
        return;
    L5:
        LynxEngineProxy r11 = r10.Z;
        if (r11 != null) goto L9;
        LynxLog.b(2, "LynxTemplateRender", "runOnTasmThread failed, engine proxy is null.");
        return;
    L9:
        com.lynx.tasm.utils.j.f(new com.lynx.tasm.ui.image.v(20, r11, r5));
    }

    public void sendGlobalEvent(String r5, JavaOnlyArray r10) {
        if (LynxEnv.inst().isHighlightTouchEnabled() == false) goto L5;
        StringBuilder r11 = com.lynx.tasm.utils.e.b("LynxView: send global event ", r5, " for lynx ");
        r11.append(hashCode());
        showMessageOnConsole(r11.toString(), 0);
    L5:
        com.lynx.tasm.behavior.ui.utils.p.j(this, com.lynx.tasm.utils.e.b("LynxView sendGlobalEvent ", r5, " with this: "), 2);
        if (this.mLynxTemplateRender != null) goto L10;
        com.lynx.tasm.behavior.ui.utils.p.j(this, new StringBuilder("LynxVew sendGlobalEvent failed since mLynxTemplateRender is null with this: "), 4);
        return;
    L10:
        if (enableAirStrictMode() == false) goto L13;
        triggerEventBus(r5, r10);
        return;
    L13:
        this.mLynxTemplateRender.y(r5, r10);
    }

    public void sendGlobalEventToLepus(String r5, List<Object> r10) {
        if (LynxEnv.inst().isHighlightTouchEnabled() == false) goto L5;
        StringBuilder r11 = com.lynx.tasm.utils.e.b("LynxView: send global event ", r5, " to lepus for lynx ");
        r11.append(hashCode());
        showMessageOnConsole(r11.toString(), 0);
    L5:
        checkAccessFromNonUiThread("sendGlobalEventToLepus");
        LynxTemplateRender r12 = this.mLynxTemplateRender;
        if (r12 != null) goto L8;
        return;
    L8:
        r12.C(r5, r10);
    }

    public void setAsyncImageInterceptor(com.lynx.tasm.behavior.k r5) {
        LynxTemplateRender r10 = this.mLynxTemplateRender;
        if (r10 == null) goto L10;
        b0 r11 = r10.e;
        if (r11 == null) goto L9;
        r11.d = r5;
        return;
    L9:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView
    public void setAttachLynxPageUICallback(com.lynx.tasm.behavior.ui.u r5) {
        LynxTemplateRender r10 = this.mLynxTemplateRender;
        if (r10 == null) goto L10;
        b0 r11 = r10.e;
        if (r11 != null) goto L7;
        return;
    L7:
        if (((com.lynx.tasm.behavior.n0) r11.f10147o.get()) == null) goto L12;
        ((com.lynx.tasm.behavior.n0) r10.e.f10147o.get()).s = r5;
        return;
    L12:
        return;
    }

    public void setEnableUIFlush(boolean r5) {
        checkAccessFromNonUiThread("setEnableUIFlush");
        LynxTemplateRender r10 = this.mLynxTemplateRender;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.n0(r5);
    }

    public void setEnableUserBytecode(boolean r5, String r10) {
        LynxTemplateRender r11 = this.mLynxTemplateRender;
        if (r11 == null) goto L6;
        r11.D(r10, r5);
        return;
    }

    public void setEnableUserCodeCache(boolean r5, String r10) {
        setEnableUserBytecode(r5, r10);
    }

    public void setExtraTiming(w0 r5) {
        if (r5 == null) goto L8;
        LynxTemplateRender r10 = this.mLynxTemplateRender;
        if (r10 == null) goto L9;
        r10.f0("LynxTemplateRender.setExtraTiming");
        PerformanceController r11 = r10.Q;
        r11.getClass();
        LynxEventReporter.runOnReportThread(new a2.b(7, r11, r5));
        LynxTemplateRender.j0("LynxTemplateRender.setExtraTiming");
        return;
    L9:
        return;
    }

    public void setFluencyTracerEnabled(LynxBooleanOption r5) {
        LynxTemplateRender r10 = this.mLynxTemplateRender;
        if (r10 == null) goto L14;
        b0 r11 = r10.e;
        if (r11 != null) goto L7;
        return;
    L7:
        if (r11.C != null) goto L9;
        r11.C = new qn.a(r11);
    L9:
        qn.a r12 = r11.C;
        if (r12.f == r5) goto L16;
        r12.f = r5;
        r12.a();
        return;
    L16:
        return;
    }

    @Deprecated
    public void setGlobalProps(Map<String, Object> r5) {
        checkAccessFromNonUiThread("setGlobalProps");
        LynxTemplateRender r10 = this.mLynxTemplateRender;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.m0(TemplateData.c(r5));
    }

    public void setImageInterceptor(com.lynx.tasm.behavior.k r5) {
        LynxTemplateRender r10 = this.mLynxTemplateRender;
        if (r10 == null) goto L10;
        b0 r11 = r10.e;
        if (r11 == null) goto L9;
        r11.f10139c = r5;
        return;
    L9:
        return;
    }

    public void setLongTaskMonitorEnabled(LynxBooleanOption r5) {
        this.mLynxTemplateRender.l(r5);
        LynxContext r10 = getLynxContext();
        if (r10 == null) goto L6;
        r10.f10156y = r5;
        return;
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener r5) {
        if (r5 != null) goto L4;
        boolean r10 = true;
    L5:
        setFocusableInTouchMode(r10);
        super.setOnClickListener(r5);
        return;
    L4:
        r10 = false;
        goto L5
    }

    public void setSessionStorageItem(String r5, TemplateData r10) {
        checkAccessFromNonUiThread("setSessionStorageItem");
        if (r10 == null) goto L8;
        LynxTemplateRender r11 = this.mLynxTemplateRender;
        if (r11 == null) goto L9;
        r11.B(r5, r10);
        return;
    L9:
        return;
    }

    @Deprecated
    public void setTheme(mo.a r5) {
        LynxContext r10 = getLynxContext();
        if (r10 == null) goto L5;
        LynxFeatureCounter.a(76, r10.A);
    L5:
        checkAccessFromNonUiThread("setTheme");
        LynxTemplateRender r11 = this.mLynxTemplateRender;
        if (r11 == null) goto L22;
        if (r5 == null) goto L23;
        mo.a r12 = r11.f10043x;
        if (r12 != null) goto L13;
        r11.f10043x = r5;
    L15:
        if (r11.f10039t == true) goto L17;
        return;
    L17:
        if (r11.f10024f0 == 0) goto L24;
        r11.G(r5);
        return;
    L24:
        return;
    L13:
        r12.f20155a = r5.f20155a;
        goto L15
    L23:
        return;
    }

    @Override // android.view.View
    public void setVisibility(int r5) {
        super.setVisibility(r5);
        LynxLog.b(2, LynxMonitorService.DEFAULT_PID, "setVisibility:" + hashCode() + " " + r5);
    }

    public void ssrHydrate(@NonNull byte[] r5, @NonNull String r10, Map<String, Object> r11) {
        StringBuilder r12 = new StringBuilder("ssrHydrate ");
        r12.append(r10);
        if (r11 != null) goto L5;
        String r13 = "";
    L6:
        com.lynx.tasm.behavior.ui.utils.e.i(r12, r13, 1, TAG);
        LynxTemplateRender r14 = this.mLynxTemplateRender;
        if (r14 != null) goto L9;
        return;
    L9:
        i r15 = r14.f10027i;
        if (r15 != null) goto L12;
    L14:
        TemplateData r16 = TemplateData.c(r11);
        r16.e = true;
        r14.q0(r10);
        r14.I(r5, r16);
        LynxLog.b(2, "LynxTemplateRender", r14.R("renderTemplate"));
        return;
    L12:
        if (((LynxSSRHelper$SSRHydrateStatus) r15.f10879a) != LynxSSRHelper$SSRHydrateStatus.f10007b) goto L14;
        r15.f10879a = LynxSSRHelper$SSRHydrateStatus.f10008c;
        goto L14
    L5:
        r13 = " with data in " + r11.toString();
        goto L6
    }

    public void ssrHydrateUrl(@NonNull String r5, Map<String, Object> r10) {
        if (r10 == null) goto L5;
        StringBuilder r11 = com.lynx.tasm.utils.e.b("ssrHydrateUrl  ", r5, " with data in ");
        r11.append(r10.toString());
        LynxLog.b(1, TAG, r11.toString());
    L6:
        LynxTemplateRender r12 = this.mLynxTemplateRender;
        if (r12 != null) goto L9;
        return;
    L9:
        i r13 = r12.f10027i;
        if (r13 != null) goto L12;
    L14:
        r12.X(r5, new ug.d(r12, r5, r10));
        return;
    L12:
        if (((LynxSSRHelper$SSRHydrateStatus) r13.f10879a) != LynxSSRHelper$SSRHydrateStatus.f10007b) goto L14;
        r13.f10879a = LynxSSRHelper$SSRHydrateStatus.f10008c;
        goto L14
    L5:
        LynxLog.b(1, TAG, "ssrHydrateUrl  " + r5);
        goto L6
    }

    public void startLynxRuntime() {
        checkAccessFromNonUiThread("startLynxRuntime");
        LynxTemplateRender r5 = this.mLynxTemplateRender;
        if (r5 != null) goto L5;
        return;
    L5:
        r5.C0();
    }

    public double subscribeSessionStorage(String r5, PlatformCallBack r10) {
        checkAccessFromNonUiThread("subscribeSessionStorage");
        LynxTemplateRender r11 = this.mLynxTemplateRender;
        if (r11 != null) goto L5;
        return -1.0d;
    L5:
        return r11.P(r5, r10);
    }

    @UiThread
    public void syncFlush() {
        LynxTemplateRender r5 = this.mLynxTemplateRender;
        if (r5 == null) goto L6;
        r5.D0();
        return;
    }

    public void triggerEventBus(String r5, List<Object> r10) {
        checkAccessFromNonUiThread("triggerEventBus");
        LynxTemplateRender r11 = this.mLynxTemplateRender;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.W(r5, r10);
    }

    public void unsubscribeSessionStorage(String r5, double r10) {
        checkAccessFromNonUiThread("removeGlobalSharedDataListener");
        LynxTemplateRender r11 = this.mLynxTemplateRender;
        if (r11 == null) goto L6;
        r11.x(r5, r10);
        return;
    }

    public void updateData(String r5) {
        updateData(r5, null);
    }

    @Deprecated
    public void updateFontScacle(float r5) {
        checkAccessFromNonUiThread("updateFontScale");
        LynxTemplateRender r10 = this.mLynxTemplateRender;
        if (r10 == null) goto L7;
        b0 r11 = r10.e;
        if (r11 == null) goto L7;
        int r12 = r11.A;
    L8:
        LynxFeatureCounter.a(71, r12);
        LynxTemplateRender r13 = this.mLynxTemplateRender;
        if (r13 != null) goto L11;
        return;
    L11:
        r13.d(r5);
        return;
    L7:
        r12 = -1;
        goto L8
    }

    public void updateFontScale(float r5) {
        checkAccessFromNonUiThread("updateFontScale");
        LynxTemplateRender r10 = this.mLynxTemplateRender;
        if (r10 == null) goto L7;
        b0 r11 = r10.e;
        if (r11 == null) goto L7;
        int r12 = r11.A;
    L8:
        LynxFeatureCounter.a(71, r12);
        LynxTemplateRender r13 = this.mLynxTemplateRender;
        if (r13 != null) goto L11;
        return;
    L11:
        r13.d(r5);
        return;
    L7:
        r12 = -1;
        goto L8
    }

    public void updateGlobalProps(@NonNull Map<String, Object> r5) {
        updateGlobalProps(TemplateData.c(r5));
    }

    @AnyThread
    public void updateMetaData(g0 r5) {
        checkAccessFromNonUiThread("updateMetaData");
        LynxTemplateRender r10 = this.mLynxTemplateRender;
        if (r10 == null) goto L11;
        if (r5 == null) goto L12;
        r10.p(r5);
        if (this.mIsPrePaintingStage == false) goto L9;
        this.mIsPrePaintingStage = false;
        return;
    L9:
        triggerEmbeddedModeLifecycle("onDataChanged", true);
        return;
    L12:
        return;
    }

    public void updateScreenMetrics(int r5, int r10) {
        checkAccessFromNonUiThread("updateScreenMetrics");
        if (this.mLynxTemplateRender != null) goto L6;
        return;
    L6:
        monitor-enter(DisplayMetricsHolder.class);
        DisplayMetricsHolder.f = true;     // Catch: Throwable -> L11
        DisplayMetrics r11 = DisplayMetricsHolder.f11154a;     // Catch: Throwable -> L11
        if (r11 == null) goto L13;
        r11.widthPixels = r5;     // Catch: Throwable -> L11
        r11.heightPixels = r10;     // Catch: Throwable -> L11
    L13:
        DisplayMetrics r12 = DisplayMetricsHolder.f11155b;     // Catch: Throwable -> L11
        if (r12 == null) goto L16;
        r12.widthPixels = r5;     // Catch: Throwable -> L11
        r12.heightPixels = r10;     // Catch: Throwable -> L11
    L16:
        monitor-exit(DisplayMetricsHolder.class);     // Catch: Throwable -> L11
        this.mLynxTemplateRender.i0(r5, r10);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public void updateViewport(int r5, int r10, boolean r11) {
        onTraceEventBegin("LynxView.updateViewport", new j0(r5, r10, r11));
        this.mCurrentWidthMeasureSpec = r5;
        this.mCurrentHeightMeasureSpec = r10;
        checkAccessFromNonUiThread("updateViewport");
        LynxTemplateRender r12 = this.mLynxTemplateRender;
        if (r12 != null) goto L5;
        return;
    L5:
        r12.h(r5, r10, r11);
        onTraceEventEnd("LynxView.updateViewport");
    }

    @Keep
    @Deprecated
    public static l0 builder(Context r5) {
        return new l0();
    }

    public void reloadTemplate(TemplateData r5, TemplateData r10) {
        checkAccessFromNonUiThread("reloadTemplate");
        LynxLog.b(2, TAG, "reloadTemplate with data: " + String.valueOf(r5) + ", with globalProps:" + String.valueOf(r10));
        LynxTemplateRender r11 = this.mLynxTemplateRender;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.u(r5, r10);
    }

    public void updateData(String r5, String r10) {
        checkAccessFromNonUiThread("updateData");
        com.lynx.tasm.behavior.ui.utils.p.j(this, new StringBuilder("updateData with json in "), 2);
        LynxTemplateRender r11 = this.mLynxTemplateRender;
        if (r11 != null) goto L5;
        return;
    L5:
        TemplateData r12 = TemplateData.b(r5);
        r12.f10056c = r10;
        r12.e = true;
        r11.v(r12, false);
        if (this.mIsPrePaintingStage == false) goto L9;
        this.mIsPrePaintingStage = false;
        return;
    L9:
        triggerEmbeddedModeLifecycle("onDataChanged", true);
    }

    public void updateGlobalProps(@NonNull TemplateData r5) {
        checkAccessFromNonUiThread("updateGlobalProps");
        LynxTemplateRender r10 = this.mLynxTemplateRender;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.m0(r5);
    }

    @Deprecated
    public void setGlobalProps(TemplateData r5) {
        checkAccessFromNonUiThread("setGlobalProps");
        LynxTemplateRender r10 = this.mLynxTemplateRender;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.m0(r5);
    }

    public void renderTemplate(byte[] r5, TemplateData r10) {
        com.lynx.tasm.behavior.ui.utils.p.j(this, new StringBuilder("renderTemplate with templateData in "), 2);
        LynxTemplateRender r11 = this.mLynxTemplateRender;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.I(r5, r10);
    }

    public void renderSSRUrl(@NonNull String r5, Map<String, Object> r10) {
        LynxLog.b(1, TAG, "renderSSRUrl " + r5);
        this.mUrl = r5;
        LynxTemplateRender r11 = this.mLynxTemplateRender;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.z(r5, new a0(r11, r5, TemplateData.c(r10)));
    }

    public void renderTemplateUrl(@NonNull String r5, String r10) {
        com.lynx.tasm.behavior.ui.utils.p.j(this, com.lynx.tasm.utils.e.b("renderTemplateUrl ", r5, "with jsonData in"), 2);
        this.mUrl = r5;
        LynxTemplateRender r11 = this.mLynxTemplateRender;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.X(r5, new ug.d(r11, r5, r10));
    }

    public void renderSSR(@NonNull byte[] r5, @NonNull String r10, TemplateData r11) {
        LynxLog.b(1, TAG, "renderSSR " + r10);
        LynxTemplateRender r12 = this.mLynxTemplateRender;
        if (r12 != null) goto L5;
        return;
    L5:
        r12.J(r5, r11, r10);
    }

    @Deprecated
    public void setExtraTiming(Map<String, Long> r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (this.mLynxTemplateRender == null) goto L24;
        w0 r10 = new w0();
        r10.f11188a = 0;
        r10.f11189b = 0;
        r10.f11190c = 0;
        r10.d = 0;
        r10.e = 0;
        if (r5.containsKey("open_time") == false) goto L10;
        r10.f11188a = r5.get("open_time").longValue();
    L10:
        if (r5.containsKey("container_init_start") == false) goto L13;
        r10.f11189b = r5.get("container_init_start").longValue();
    L13:
        if (r5.containsKey("container_init_end") == false) goto L16;
        r10.f11190c = r5.get("container_init_end").longValue();
    L16:
        if (r5.containsKey("prepare_template_start") == false) goto L19;
        r10.d = r5.get("prepare_template_start").longValue();
    L19:
        if (r5.containsKey("prepare_template_end") == false) goto L21;
        r10.e = r5.get("prepare_template_end").longValue();
    L21:
        LynxTemplateRender r11 = this.mLynxTemplateRender;
        r11.f0("LynxTemplateRender.setExtraTiming");
        PerformanceController r12 = r11.Q;
        r12.getClass();
        LynxEventReporter.runOnReportThread(new a2.b(7, r12, r10));
        LynxTemplateRender.j0("LynxTemplateRender.setExtraTiming");
        return;
    }

    public void updateViewport(int r5, int r10) {
        checkAccessFromNonUiThread("updateViewport");
        updateViewport(r5, r10, true);
    }

    public void renderTemplateWithBaseUrl(byte[] r5, Map<String, Object> r10, String r11) {
        com.lynx.tasm.behavior.ui.utils.p.j(this, com.lynx.tasm.utils.e.b("renderTemplateWithBaseUrl ", r11, "with map in "), 2);
        this.mUrl = r11;
        LynxTemplateRender r12 = this.mLynxTemplateRender;
        if (r12 != null) goto L5;
        return;
    L5:
        TemplateData r13 = TemplateData.c(r10);
        r13.e = true;
        r12.q0(r11);
        r12.I(r5, r13);
        LynxLog.b(2, "LynxTemplateRender", r12.R("renderTemplate"));
    }

    public void renderTemplateUrl(@NonNull String r5, Map<String, Object> r10) {
        com.lynx.tasm.behavior.ui.utils.p.j(this, com.lynx.tasm.utils.e.b("renderTemplateUrl ", r5, "with Map in"), 2);
        this.mUrl = r5;
        LynxTemplateRender r11 = this.mLynxTemplateRender;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.X(r5, new ug.d(r11, r5, r10));
    }

    public LynxView(Context r5, AttributeSet r10) {
        super(r5, r10);
        this.mDispatchTouchEventToDev = true;
        this.mIsAccessibilityDisabled = false;
        this.mDisableDrawChildHook = false;
        this.mLynxViewId = 0;
        this.mOnLoadFired = false;
        this.mIsPrePaintingStage = false;
        this.mHasReportedAccessFromNonUiThread = false;
        this.mCurrentWidthMeasureSpec = -1;
        this.mCurrentHeightMeasureSpec = -1;
        this.isInPrePainting = false;
    }

    @Deprecated
    public void setTheme(ByteBuffer r5) {
        LynxContext r10 = getLynxContext();
        if (r10 == null) goto L5;
        LynxFeatureCounter.a(76, r10.A);
    L5:
        checkAccessFromNonUiThread("setTheme");
        LynxTemplateRender r11 = this.mLynxTemplateRender;
        if (r11 == null) goto L11;
        if (r5 == null) goto L12;
        r11.F(r5);
        return;
    L12:
        return;
    }

    public void ssrHydrateUrl(@NonNull String r5, TemplateData r10) {
        StringBuilder r11 = com.lynx.tasm.utils.e.b("ssrHydrateUrl  ", r5, " with data in ");
        r11.append(r10.toString());
        LynxLog.b(1, TAG, r11.toString());
        LynxTemplateRender r12 = this.mLynxTemplateRender;
        if (r12 != null) goto L5;
        return;
    L5:
        i r13 = r12.f10027i;
        if (r13 != null) goto L8;
    L10:
        r12.X(r5, new ug.d(r12, r5, r10));
        return;
    L8:
        if (((LynxSSRHelper$SSRHydrateStatus) r13.f10879a) != LynxSSRHelper$SSRHydrateStatus.f10007b) goto L10;
        r13.f10879a = LynxSSRHelper$SSRHydrateStatus.f10008c;
        goto L10
    }

    public void updateData(TemplateData r5) {
        checkAccessFromNonUiThread("updateData");
        LynxLog.b(2, TAG, "updateData with data in " + r5.toString());
        LynxTemplateRender r10 = this.mLynxTemplateRender;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.v(r5, false);
        if (this.mIsPrePaintingStage == false) goto L9;
        this.mIsPrePaintingStage = false;
        return;
    L9:
        triggerEmbeddedModeLifecycle("onDataChanged", true);
    }

    public void ssrHydrate(@NonNull byte[] r5, @NonNull String r10, TemplateData r11) {
        StringBuilder r12 = new StringBuilder("ssrHydrate ");
        r12.append(r10);
        if (r11 != null) goto L5;
        String r13 = "";
    L6:
        com.lynx.tasm.behavior.ui.utils.e.i(r12, r13, 1, TAG);
        LynxTemplateRender r14 = this.mLynxTemplateRender;
        if (r14 != null) goto L9;
        return;
    L9:
        i r15 = r14.f10027i;
        if (r15 != null) goto L12;
    L14:
        r14.q0(r10);
        r14.I(r5, r11);
        LynxLog.b(2, "LynxTemplateRender", r14.R("renderTemplate"));
        return;
    L12:
        if (((LynxSSRHelper$SSRHydrateStatus) r15.f10879a) != LynxSSRHelper$SSRHydrateStatus.f10007b) goto L14;
        r15.f10879a = LynxSSRHelper$SSRHydrateStatus.f10008c;
        goto L14
    L5:
        r13 = " with data in " + r11.toString();
        goto L6
    }

    public void renderTemplateWithBaseUrl(byte[] r5, String r10, String r11) {
        com.lynx.tasm.behavior.ui.utils.p.j(this, com.lynx.tasm.utils.e.b("renderTemplateWithBaseUrl ", r11, "with string data in"), 2);
        this.mUrl = r11;
        LynxTemplateRender r12 = this.mLynxTemplateRender;
        if (r12 != null) goto L5;
        return;
    L5:
        TemplateData r13 = TemplateData.b(r10);
        r13.e = true;
        r12.q0(r11);
        r12.I(r5, r13);
        LynxLog.b(2, "LynxTemplateRender", r12.R("renderTemplate"));
    }

    @Keep
    public void updateData(Map<String, Object> r5) {
        updateData(r5, null);
    }

    public void updateData(Map<String, Object> r5, String r10) {
        checkAccessFromNonUiThread("updateData");
        com.lynx.tasm.behavior.ui.utils.p.j(this, new StringBuilder("updateData with map in "), 2);
        LynxTemplateRender r11 = this.mLynxTemplateRender;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.updateData(r5, r10);
    }

    @Keep
    public LynxView(Context r5, l0 r10) {
        super(r5);
        this.mDispatchTouchEventToDev = true;
        this.mIsAccessibilityDisabled = false;
        this.mDisableDrawChildHook = false;
        this.mLynxViewId = 0;
        this.mOnLoadFired = false;
        this.mIsPrePaintingStage = false;
        this.mHasReportedAccessFromNonUiThread = false;
        this.mCurrentWidthMeasureSpec = -1;
        this.mCurrentHeightMeasureSpec = -1;
        this.isInPrePainting = false;
        initWithLynxViewBuilder(r10);
    }

    public LynxView(Context r5, @NonNull f r10) {
        super(r5);
        this.mDispatchTouchEventToDev = true;
        this.mIsAccessibilityDisabled = false;
        this.mDisableDrawChildHook = false;
        this.mLynxViewId = 0;
        this.mOnLoadFired = false;
        this.mIsPrePaintingStage = false;
        this.mHasReportedAccessFromNonUiThread = false;
        this.mCurrentWidthMeasureSpec = -1;
        this.mCurrentHeightMeasureSpec = -1;
        this.isInPrePainting = false;
        this.mLynxTemplateRender = (LynxTemplateRender) r10;
        initialize(r5, null);
    }
}
