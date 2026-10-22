package com.lynx.tasm;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.devtoolwrapper.LogBoxLogLevel;
import com.lynx.devtoolwrapper.LynxBaseInspectorController;
import com.lynx.devtoolwrapper.LynxBaseInspectorOwner;
import com.lynx.devtoolwrapper.LynxDevtool;
import com.lynx.jsbridge.LynxModuleFactory;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.ILynxUIRenderer;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxUIOwner;
import com.lynx.tasm.behavior.LynxUIRenderer;
import com.lynx.tasm.behavior.ui.IDrawChildHook;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.lynx.tasm.core.VSyncMonitor;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.featurecount.LynxFeatureCounter;
import com.lynx.tasm.utils.CallStackUtil;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import com.lynx.tasm.utils.UIThreadUtils;
import com.obric.aivoice.core.data.NameKeys;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxView extends UIBody.UIBodyView implements j8a.a {
    private static final String TAG = "LynxView";
    private static final String VIEW_TAG = "lynxview";
    private static final Looper sMainLooper = null;
    private boolean isInPrePainting;
    private boolean mCanDispatchTouchEvent;
    private boolean mConsumeSlideEvent;
    private int mCurrentHeightMeasureSpec;
    private int mCurrentWidthMeasureSpec;
    private boolean mDestroyed;
    private boolean mDisableDrawChildHook;
    protected boolean mDispatchTouchEventToDev;
    private volatile boolean mHasReportedAccessFromNonUiThread;
    private boolean mIsAccessibilityDisabled;
    private boolean mIsPrePaintingStage;
    private volatile com.lynx.tasm.behavior.n mKeyboardEvent;
    protected LynxTemplateRender mLynxTemplateRender;
    private WeakReference<com.lynx.tasm.group.c> mLynxViewGroupRef;
    private int mLynxViewId;
    private boolean mOnLoadFired;
    private String mUrl;

    public class a implements Callable<HashMap<String, String>> {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ LynxView c;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public HashMap<String, String> call2() throws Exception {
            HashMap<String, String> r0 = new HashMap();
            r0.put("widthMeasureSpec", String.valueOf(this.a));
            r0.put("heightMeasureSpec", String.valueOf(this.b));
            LynxView.access$000(this.c, r0);
            return r0;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ HashMap<String, String> call() throws Exception {
            return call2();
        }

        public a(LynxView r1, int r2, int r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public class b implements Callable<HashMap<String, String>> {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ LynxView f;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public HashMap<String, String> call2() throws Exception {
            HashMap<String, String> r0 = new HashMap();
            r0.put(LynxResourceModule.PARAMS_KEY, NameKeys.UnloadStrategy_No_Strategy + this.a + " " + this.b + " " + this.c + " " + this.d + " " + this.e);
            LynxView.access$000(this.f, r0);
            return r0;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ HashMap<String, String> call() throws Exception {
            return call2();
        }

        public b(LynxView r1, boolean r2, int r3, int r4, int r5, int r6) {
            this.f = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public class c implements Callable<HashMap<String, String>> {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public HashMap<String, String> call2() throws Exception {
            HashMap<String, String> r0 = new HashMap();
            r0.put("widthMeasureSpec", String.valueOf(this.a));
            r0.put("heightMeasureSpec", String.valueOf(this.b));
            r0.put("needLayout", String.valueOf(this.c));
            return r0;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ HashMap<String, String> call() throws Exception {
            return call2();
        }

        public c(int r1, int r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public class d implements Callable<HashMap<String, String>> {
        public final /* synthetic */ LynxView a;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public HashMap<String, String> call2() throws Exception {
            HashMap<String, String> r0 = new HashMap();
            LynxView.access$000(this.a, r0);
            return r0;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ HashMap<String, String> call() throws Exception {
            return call2();
        }

        public d(LynxView r1) {
            this.a = r1;
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ LynxView c;

        public final void a() {
            if (this.c.mLynxTemplateRender != null) goto L6;
            return;
        L6:
            if (TraceEvent.isTracingStarted() == false) goto L8;
            HashMap r0 = new HashMap();
            r0.put("lifecycle", this.a);
            TraceEvent.beginSection("TriggerEmbeddedModeLifecycle", r0);
        L8:
            JavaOnlyMap r1 = new JavaOnlyMap();
            r1.put("method", this.a);
            if (this.b == false) goto L13;
            LynxTemplateRender r2 = this.c.mLynxTemplateRender;
            if (r2 == null) goto L13;
            r1.put("args", r2.getTemplateData());
        L13:
            LynxTemplateRender r3 = this.c.mLynxTemplateRender;
            if (r3 == null) goto L17;
            r3.onLynxEvent(r1);
        L17:
            if (TraceEvent.isTracingStarted() == false) goto L20;
            TraceEvent.endSection("TriggerEmbeddedModeLifecycle");
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

        public e(LynxView r1, String r2, boolean r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public static /* synthetic */ void g(LynxView r1) {
        r1.lambda$getLynxElementRoot$0(null);
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, x6a.e
    public /* bridge */ /* synthetic */ void applyRendererClipBounds(boolean r1, Rect r2) {
        x6a.d.a(this, r1, r2);
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, x6a.e
    public /* bridge */ /* synthetic */ void applyRendererOpacity(float r1) {
        x6a.d.b(this, r1);
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, x6a.e
    public /* bridge */ /* synthetic */ void applyRendererTransform(float[] r1) {
        x6a.d.c(this, r1);
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, x6a.e
    public /* bridge */ /* synthetic */ PointF convertPointInRendererHostToScreen(PointF r1) {
        return x6a.d.d(this, r1);
    }

    public v0 forceGetPerf() {
        return null;
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return x6a.d.e(this);
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return x6a.d.f(this);
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return x6a.d.g(this);
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return x6a.d.h(this);
    }

    @Override // android.view.View
    public Object getTag() {
        return "lynxview";
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, x6a.e
    public /* bridge */ /* synthetic */ void invalidateForRenderer() {
        x6a.d.i(this);
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, x6a.e
    public /* bridge */ /* synthetic */ boolean invokeUIMethod(String r1, ReadableMap r2, Callback r3) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        onTraceEventBegin("LynxView.onAttachedToWindow", null);
        super.onAttachedToWindow();
        LLog.i("Lynx", "onAttachedToWindow:" + hashCode());
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 == null) goto L5;
        r0.onAttachedToWindow();
    L5:
        onTraceEventEnd("LynxView.onAttachedToWindow");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        onTraceEventBegin("LynxView.onDetachedFromWindow", null);
        LLog.i("Lynx", "onDetachedFromWindow:" + hashCode());
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 == null) goto L5;
        r0.onDetachedFromWindow();
    L5:
        super.onDetachedFromWindow();
        onTraceEventEnd("LynxView.onDetachedFromWindow");
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, x6a.e
    public /* bridge */ /* synthetic */ void requestLayoutForRenderer() {
        x6a.d.j(this);
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, x6a.e
    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r1) {
        x6a.d.k(this, r1);
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, x6a.e
    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r1) {
        x6a.d.l(this, r1);
    }

    public static LynxViewBuilder builder() {
        return new LynxViewBuilder();
    }

    public void attachEngineToUIThread() {
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 == null) goto L6;
        r0.attachEngineToUIThread();
        return;
    }

    public void destroy() {
        if (this.mDestroyed == false) goto L5;
        return;
    L5:
        this.mDestroyed = true;
        LLog.i(TAG, "lynxview destroy " + toString());
        triggerEmbeddedModeLifecycle("onDestroy", true);
        TraceEvent.beginSection("DestroyLynxView");
        WeakReference<com.lynx.tasm.group.c> r0 = this.mLynxViewGroupRef;
        if (r0 == null) goto L11;
        com.lynx.tasm.group.c r1 = r0.get();
        if (r1 == null) goto L11;
        r1.a();
    L11:
        if (this.mKeyboardEvent == null) goto L30;
        if (this.mKeyboardEvent.d == false) goto L30;
        com.lynx.tasm.behavior.n r2 = this.mKeyboardEvent;
        monitor-enter(r2);
    L26:
        th = move-exception;
        throw th;
    L17:
        if (r2.d == true) goto L21;
        monitor-exit(r2);
        goto L30
    L21:
        if (UIThreadUtils.isOnUiThread() == true) goto L23;
        UIThreadUtils.runOnUiThread(new com.lynx.tasm.behavior.o(r2));     // Catch: Throwable -> L26
    L24:
        monitor-exit(r2);
        goto L30
    L23:
        r2.f();     // Catch: Throwable -> L26
    L30:
        if (this.mLynxTemplateRender == null) goto L32;
        w6a.h r3 = w6a.h.a.a;
        w6a.h.a(r3.f, this);
        w6a.h.a(r3.c, this);
        w6a.h.a(r3.b, this);
        w6a.h.a(r3.e, this);
        w6a.h.a(r3.d, this);
        this.mLynxTemplateRender.onDetachedFromWindow();
        this.mLynxTemplateRender.destroy();
        this.mLynxTemplateRender = null;
    L32:
        com.lynx.tasm.behavior.ui.accessibility.d r4 = this.mA11yWrapper;
        if (r4 == null) goto L44;
        com.lynx.tasm.behavior.ui.accessibility.b r5 = r4.j;
        if (r5 == null) goto L44;
        AccessibilityManager r6 = r5.a;
        if (r6 == null) goto L44;
        com.lynx.tasm.behavior.ui.accessibility.b.a r7 = r5.b;
        if (r7 == null) goto L41;
        r6.removeAccessibilityStateChangeListener(r7);
    L41:
        com.lynx.tasm.behavior.ui.accessibility.b.AccessibilityManagerTouchExplorationStateChangeListenerC0052b r8 = r5.c;
        if (r8 == null) goto L44;
        r5.a.removeTouchExplorationStateChangeListener(r8);
    L44:
        TraceEvent.endSection("DestroyLynxView");
    }

    public void detachEngineFromUIThread() {
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 == null) goto L6;
        r0.detachEngineFromUIThread();
        return;
    }

    public boolean enableAirStrictMode() {
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.enableAirStrictMode();
    }

    public boolean enableJSRuntime() {
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 != null) goto L5;
        return true;
    L5:
        return r0.enableJSRuntime();
    }

    public HashMap<String, Object> getAllTimingInfo() {
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getAllTimingInfo();
    }

    public LynxBaseInspectorController getBaseInspectorController() {
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 == null) goto L8;
        LynxDevtool r1 = r0.getDevTool();
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.getBaseInspectorController();
    L8:
        return null;
    }

    public LynxBaseInspectorOwner getBaseInspectorOwner() {
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 == null) goto L8;
        LynxDevtool r1 = r0.getDevTool();
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.getBaseInspectorOwner();
    L8:
        return null;
    }

    public long getFirstMeasureTime() {
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.getFirstMeasureTime();
    }

    public com.lynx.tasm.behavior.n getKeyboardEvent() {
        com.lynx.tasm.behavior.n r0 = this.mKeyboardEvent;
        if (r0 == null) goto L5;
        return r0;
    L5:
        LynxContext r1 = getLynxContext();
        if (r1 != null) goto L9;
        return null;
    L9:
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L11:
        if (this.mKeyboardEvent != null) goto L13;
        this.mKeyboardEvent = new com.lynx.tasm.behavior.n(r1);     // Catch: Throwable -> L16
    L13:
        com.lynx.tasm.behavior.n r2 = this.mKeyboardEvent;     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        return r2;
    }

    public LynxConfigInfo getLynxConfigInfo() {
        return new LynxConfigInfo(new LynxConfigInfo.b(), null);
    }

    public LynxContext getLynxContext() {
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getLynxContext();
    }

    public UIGroup<UIBody.UIBodyView> getLynxUIRoot() {
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLynxRootUI();
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView
    public LynxViewBuilder getLynxViewBuilder() {
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLynxViewBuilder();
    }

    public String getPageVersion() {
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 != null) goto L6;
        return NameKeys.UnloadStrategy_No_Strategy;
    L6:
        return r0.getPageVersion();
    }

    public String getRenderPhase() {
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getRenderPhase();
    }

    public TemplateData getTemplateData() {
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getTemplateData();
    }

    public String getTemplateUrl() {
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getTemplateUrl();
    }

    public ThreadStrategyForRendering getThreadStrategyForRendering() {
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getThreadStrategyForRendering();
    }

    public ILynxUIRenderer lynxUIRenderer() {
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.lynxUIRenderer();
    }

    public void onEnterBackground() {
        checkAccessFromNonUiThread("onEnterBackground");
        LLog.i(TAG, "onEnterBackground" + toString());
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 == null) goto L5;
        r0.onEnterBackground();
    L5:
        lynxUIRenderer();
    }

    public void onEnterForeground() {
        checkAccessFromNonUiThread("onEnterForeground");
        LLog.i(TAG, "onEnterForeground " + toString());
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 == null) goto L5;
        r0.onEnterForeground();
    L5:
        lynxUIRenderer();
    }

    public void pauseRootLayoutAnimation() {
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.pauseRootLayoutAnimation();
    }

    public void processRender() {
        checkAccessFromNonUiThread("processRender");
        if (this.mLynxTemplateRender != null) goto L5;
        return;
    L5:
        LLog.i(TAG, "LynxView call processRender in " + toString());
        this.mLynxTemplateRender.processRender();
    }

    public void resumeRootLayoutAnimation() {
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.resumeRootLayoutAnimation();
    }

    public void syncFlush() {
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 == null) goto L6;
        r0.syncFlush();
        return;
    }

    static {
        sMainLooper = Looper.getMainLooper();
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView
    public List<com.lynx.tasm.behavior.ui.e> getMeaningfulPaintingAreas() {
        if (getLynxContext() != null) goto L6;
        return null;
    L6:
        if (getLynxContext().isEmbeddedModeOn() == true) goto L8;
        return null;
    L8:
        UIGroup<UIBody.UIBodyView> r0 = getLynxUIRoot();
        if ((r0 instanceof UIBody) == false) goto L13;
        return ((UIBody) r0).getMeaningfulPaintingAreas();
    L13:
        return super.getMeaningfulPaintingAreas();
    }

    public k8a.a getTheme() {
        LynxContext r0 = getLynxContext();
        if (r0 == null) goto L5;
        LynxFeatureCounter.a(87, r0.getInstanceId());
    L5:
        LynxTemplateRender r1 = this.mLynxTemplateRender;
        if (r1 != null) goto L10;
        return null;
    L10:
        return r1.getTheme();
    }

    public void reloadAndInit() {
        ILynxUIRenderer r0 = lynxUIRenderer();
        if (r0 == null) goto L7;
        UIThreadUtils.assertOnUiThread();
        LynxUIOwner r1 = ((LynxUIRenderer) r0).b;
        if (r1 == null) goto L7;
        r1.reset();
    L7:
        removeAllViews();
    }

    public void startLynxRuntime() {
        checkAccessFromNonUiThread("startLynxRuntime");
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.startLynxRuntime();
    }

    public int getCurrentHeightMeasureSpec() {
        return this.mCurrentHeightMeasureSpec;
    }

    public int getCurrentWidthMeasureSpec() {
        return this.mCurrentWidthMeasureSpec;
    }

    public int getLynxViewId() {
        return this.mLynxViewId;
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView
    public boolean isAccessibilityDisabled() {
        return this.mIsAccessibilityDisabled;
    }

    public LynxView(Context r2) {
        super(r2);
        this.mConsumeSlideEvent = false;
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
        this.mDestroyed = false;
    }

    public static LynxViewBuilder builder(Context r0) {
        return new LynxViewBuilder();
    }

    private void checkAccessFromNonUiThread(String r5) {
        LynxContext r0 = getLynxContext();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.enableEventReporter() == true) goto L8;
        return;
    L8:
        if (LynxEnv.inst().enableCheckAccessFromNonUIThread() == true) goto L10;
        return;
    L10:
        if (this.mHasReportedAccessFromNonUiThread == false) goto L13;
        return;
    L13:
        if (sMainLooper != Looper.myLooper()) goto L15;
        return;
    L15:
        if (TextUtils.isEmpty(this.mUrl) == true) goto L28;
        this.mHasReportedAccessFromNonUiThread = true;
        HashMap r1 = new HashMap();
        r1.put(LynxEventReporter.PROP_NAME_URL, this.mUrl);
        if (getThreadStrategyForRendering() == null) goto L20;
        int r2 = getThreadStrategyForRendering().id();
    L21:
        r1.put(LynxEventReporter.PROP_NAME_THREAD_MODE, Integer.valueOf(r2));
        r1.put(LynxEventReporter.PROP_NAME_LYNX_SDK_VERSION, LynxEnv.inst().getLynxVersion());
        r1.put("method", r5);
        LynxEventReporter.onEvent("lynxsdk_access_lynxview_from_non_ui_thread", r1, -1);
        return;
    L20:
        r2 = -1;
        goto L21
    }

    private /* synthetic */ void lambda$getLynxElementRoot$0(s r2) {
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 != null) goto L6;
        r2.a();
        return;
    L6:
        r0.getLynxElementRoot(r2);
    }

    private void onTraceEventEnd(String r2) {
        if (TraceEvent.isTracingStarted() == true) goto L5;
        return;
    L5:
        TraceEvent.endSection(r2);
    }

    private void putPendingPipelineIdsToMap(Map<String, String> r5) {
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getPerformanceController() == null) goto L19;
        JavaOnlyArray r1 = this.mLynxTemplateRender.getPerformanceController().g;
        StringBuilder r2 = new StringBuilder();
        Iterator<Object> r3 = r1.iterator();
    L8:
        if (r3.hasNext() == false) goto L13;
        Object r4 = r3.next();
        if (r2.length() <= 0) goto L12;
        r2.append(",");
    L12:
        r2.append(String.valueOf(r4));
        goto L8
    L13:
        r5.put("pipeline_ids", r2.toString());
        return;
    }

    public void addLynxViewClient(q1 r2) {
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.addLynxViewClient(r2);
    }

    public void addLynxViewClientV2(LynxViewClientV2 r2) {
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 == null) goto L6;
        r0.addLynxViewClientV2(r2);
        return;
    }

    public void addRuntimeLifecycleListener(com.lynx.jsbridge.g r2) {
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 == null) goto L6;
        r0.addRuntimeLifecycleListener(r2);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, com.lynx.tasm.behavior.ui.IDrawChildHook.IDrawChildHookBinding
    public void bindDrawChildHook(IDrawChildHook r2) {
        if (this.mDisableDrawChildHook == false) goto L5;
        return;
    L5:
        super.bindDrawChildHook(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r3) {
        onTraceEventBegin("LynxView.onDraw", new d(this));
        super.dispatchDraw(r3);
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 == null) goto L6;
        r0.onRootViewDraw(r3);
    L6:
        if (this.mOnLoadFired == false) goto L8;
    L10:
        onTraceEventEnd("LynxView.onDraw");
        return;
    L8:
        if (this.mIsPrePaintingStage == true) goto L10;
        this.mOnLoadFired = true;
        triggerEmbeddedModeLifecycle("onLoad", true);
        goto L10
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent r2) {
        if (lynxUIRenderer() == null) goto L6;
        lynxUIRenderer().getClass();
    L6:
        return super.dispatchKeyEvent(r2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r15) {
        int r4 = r15.getAction();     // Catch: Throwable -> L52
        if (r4 == 0) goto L8;
        if (r4 == 1) goto L8;
        if (r4 == 3) goto L8;
    L10:
        if (this.mLynxTemplateRender == null) goto L12;
        lynxUIRenderer();     // Catch: Throwable -> L52
        if (isChildLynxPageUI() == false) goto L18;
        return super.dispatchTouchEvent(r15);
    L18:
        if (r4 != 0) goto L24;
        if (LynxEnv.inst().isHighlightTouchEnabled() == false) goto L22;
        showMessageOnConsole("LynxView: dispatch touch for lynx " + hashCode() + ", touch: " + r4 + " x: " + r15.getX() + " y: " + r15.getY(), LogBoxLogLevel.Info.ordinal());     // Catch: Throwable -> L52
    L22:
        this.mCanDispatchTouchEvent = true;     // Catch: Throwable -> L52
        this.mConsumeSlideEvent = false;     // Catch: Throwable -> L52
    L24:
        if (this.mCanDispatchTouchEvent == false) goto L32;
        float r11 = r15.getX();     // Catch: Throwable -> L52
        float r12 = r15.getY();     // Catch: Throwable -> L52
        boolean r13 = this.mLynxTemplateRender.dispatchTouchEvent(r15);     // Catch: Throwable -> L52
        r15.setLocation(r11, r12);     // Catch: Throwable -> L52
        if (r13 == true) goto L28;
    L33:
        if (r4 == 1) goto L36;
        if (r4 == 3) goto L36;
    L39:
        if (r13 == true) goto L41;
    L56:
        return false;
    L41:
        if (this.mDispatchTouchEventToDev == false) goto L44;
        this.mLynxTemplateRender.onDispatchInputEvent(r15);     // Catch: Throwable -> L52
    L44:
        if (this.mConsumeSlideEvent == true) goto L47;
        this.mConsumeSlideEvent = this.mLynxTemplateRender.consumeSlideEvent(r15);     // Catch: Throwable -> L52
    L47:
        if (this.mConsumeSlideEvent == false) goto L51;
        LLog.i("Lynx", "LynxView dispatchTouchEvent consumeSlideEvent true for lynx " + hashCode());     // Catch: Throwable -> L52
        return true;
    L51:
        return super.dispatchTouchEvent(r15);
    L36:
        if (LynxEnv.inst().isHighlightTouchEnabled() == false) goto L38;
        showMessageOnConsole("LynxView: dispatch touch for lynx " + hashCode() + ", touch: " + r4 + " x: " + r15.getX() + " y: " + r15.getY(), LogBoxLogLevel.Info.ordinal());     // Catch: Throwable -> L52
    L38:
        this.mCanDispatchTouchEvent = false;     // Catch: Throwable -> L52
        goto L39
    L28:
        if (this.mLynxTemplateRender.blockNativeEvent(r15) == false) goto L33;
        if (getParent() == null) goto L33;
        LLog.i("Lynx", "LynxView dispatchTouchEvent blockNativeEvent true for lynx " + hashCode());     // Catch: Throwable -> L52
        getParent().requestDisallowInterceptTouchEvent(true);     // Catch: Throwable -> L52
        goto L33
    L32:
        r13 = false;
        goto L33
    L12:
        return super.dispatchTouchEvent(r15);
    L8:
        LLog.i("Lynx", "LynxView dispatchTouchEvent, this: " + hashCode() + ", touch: " + r15.getActionMasked() + " x: " + r15.getX() + " y: " + r15.getY());     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        if (this.mLynxTemplateRender == null) goto L56;
        LynxError r0 = new LynxError(109900, "An exception occurred during dispatchTouchEvent(): " + th.getMessage(), "This error is caught by native, please ask Lynx for help", "error");
        r0.setCallStack(CallStackUtil.a(th));
        this.mLynxTemplateRender.onErrorOccurred(r0);
        goto L56
    }

    public LynxBaseUI findUIByIdSelector(String r2) {
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.findUIByIdSelector(r2);
    }

    public LynxBaseUI findUIByIndex(int r2) {
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.findUIByIndex(r2);
    }

    public LynxBaseUI findUIByName(String r2) {
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.findUIByName(r2);
    }

    public View findViewByIdSelector(String r2) {
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.findViewByIdSelector(r2);
    }

    public View findViewByName(String r2) {
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.findViewByName(r2);
    }

    public void getCurrentData(d0 r2) {
        checkAccessFromNonUiThread("getCurrentData");
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.getCurrentData(r2);
    }

    public com.lynx.jsbridge.c getJSModule(String r2) {
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getJSModule(r2);
    }

    public void getLynxElementRoot(s<Object> r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        UIThreadUtils.runOnUiThread(new p1(this));
    }

    public Map<String, Object> getPageDataByKey(String[] r3) {
        checkAccessFromNonUiThread("getPageDataByKey");
        if (r3 != null) goto L5;
    L12:
        LLog.i(TAG, "getPageDataByKey called with empty keys.");
        return null;
    L5:
        if (r3.length == 0) goto L12;
        LynxTemplateRender r1 = this.mLynxTemplateRender;
        if (r1 != null) goto L11;
        return null;
    L11:
        return r1.getPageDataByKey(r3);
    }

    public void initWithLynxViewBuilder(LynxViewBuilder r3) {
        this.mLynxUIRender = r3.createLynxUIRenderer();
        if (r3.lynxBackgroundRuntime == null) goto L6;
        initLynxViewWithRuntime(getContext(), r3);
        return;
    L6:
        LLog.i(TAG, "new lynxview detail " + this);
        ILynxUIRenderer r0 = this.mLynxUIRender;
        getContext();
        LynxGroup r1 = r3.getLynxRuntimeOptions().c;
        r0.getClass();
        initialize(getContext(), r3);
        com.lynx.tasm.group.c r2 = r3.lynxViewGroup;
        if (r2 == null) goto L10;
        this.mLynxViewId = r2.e();
        r3.lynxViewGroup.b();
        this.mLynxViewGroupRef = new WeakReference(r3.lynxViewGroup);
        return;
    }

    public void loadTemplate(s0 r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        LynxLoadMode r0 = r6.g;
        LynxLoadMode r1 = LynxLoadMode.PRE_PAINTING;
        if (r0 != r1) goto L7;
    L8:
        this.mIsPrePaintingStage = true;
    L10:
        if (isLayoutRequested() == true) goto L12;
    L40:
        LLog.i(TAG, "loadTemplate with LynxLoadMeta in " + toString());
        if (this.mLynxTemplateRender != null) goto L43;
        return;
    L43:
        this.mLynxTemplateRender.loadTemplate(r6);
        return;
    L12:
        if (r1 != r6.g) goto L40;
        this.isInPrePainting = true;
        if (getChildCount() <= 0) goto L16;
        removeAllViewsInLayout();
    L16:
        ViewGroup.LayoutParams r2 = getLayoutParams();
        if (r2 == null) goto L21;
        int r3 = r2.width;
        if (r3 < 0) goto L21;
    L22:
        int r4 = View.MeasureSpec.makeMeasureSpec(r3, 1073741824);
        if (r2 == null) goto L27;
        int r5 = r2.height;
        if (r5 < 0) goto L27;
    L28:
        measure(r4, View.MeasureSpec.makeMeasureSpec(r5, 1073741824));
        if (r2 == null) goto L33;
        int r7 = r2.width;
        if (r7 < 0) goto L33;
    L34:
        if (r2 == null) goto L38;
        int r8 = r2.height;
        if (r8 < 0) goto L38;
    L39:
        layout(0, 0, r7, r8);
        this.isInPrePainting = false;
    L38:
        r8 = 0;
    L33:
        r7 = 0;
    L27:
        r5 = 0;
    L21:
        r3 = 0;
        goto L22
    L7:
        if (r0 != LynxLoadMode.PRE_PAINTING_DRAW) goto L10;
        goto L8
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r6) {
        LLog.i("Lynx", "LynxView onInterceptTouchEvent, this: " + hashCode());     // Catch: Throwable -> L19
        if (isChildLynxPageUI() == true) goto L6;
        LynxTemplateRender r0 = this.mLynxTemplateRender;     // Catch: Throwable -> L19
        if (r0 == null) goto L18;
        if (this.mCanDispatchTouchEvent == false) goto L18;
        if (r0.onInterceptTouchEvent(r6) == false) goto L18;
        ViewParent r7 = getParent();     // Catch: Throwable -> L19
        if (r7 == null) goto L16;
        r7.requestDisallowInterceptTouchEvent(true);     // Catch: Throwable -> L19
    L16:
        return true;
    L18:
        return super.onInterceptTouchEvent(r6);
    L6:
        return super.onInterceptTouchEvent(r6);
    L19:
        th = move-exception;
        if (this.mLynxTemplateRender == null) goto L26;
        LynxError r1 = new LynxError(109900, "An exception occurred during onInterceptTouchEvent(): " + th.getMessage(), "This error is caught by native, please ask Lynx for help", "error");
        r1.setCallStack(CallStackUtil.a(th));
        this.mLynxTemplateRender.onErrorOccurred(r1);
        return false;
    L26:
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r6) {
        LLog.i("Lynx", "LynxView onTouchEvent, this: " + hashCode());     // Catch: Throwable -> L19
        if (isChildLynxPageUI() == true) goto L6;
        LynxTemplateRender r0 = this.mLynxTemplateRender;     // Catch: Throwable -> L19
        if (r0 != null) goto L10;
        return true;
    L10:
        if (this.mCanDispatchTouchEvent == false) goto L13;
        r0.onTouchEvent(r6);     // Catch: Throwable -> L19
    L13:
        if (this.mLynxTemplateRender.blockNativeEvent(r6) == true) goto L15;
    L16:
        super.onTouchEvent(r6);     // Catch: Throwable -> L19
        return true;
    L15:
        if (getParent() == null) goto L16;
        return true;
    L6:
        return super.onTouchEvent(r6);
    L19:
        th = move-exception;
        if (this.mLynxTemplateRender == null) goto L28;
        LynxError r1 = new LynxError(109900, "An exception occurred during onTouchEvent(): " + th.getMessage(), "This error is caught by native, please ask Lynx for help", "error");
        r1.setCallStack(CallStackUtil.a(th));
        this.mLynxTemplateRender.onErrorOccurred(r1);
        return false;
    L28:
        return false;
    }

    public void preloadDynamicComponents(String[] r3) {
        checkAccessFromNonUiThread("preloadDynamicComponents");
        LLog.i(TAG, "preload lazy bundles: " + TextUtils.join(", ", r3));
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 == null) goto L10;
        if (r3 != null) goto L6;
        return;
    L6:
        if (r3.length == 0) goto L12;
        r0.preloadLazyBundles(r3);
        return;
    L12:
        return;
    }

    public void putParamsForReportingEvents(Map<String, Object> r2) {
        if (r2 == null) goto L8;
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 == null) goto L9;
        r0.putExtraParamsForReportingEvents(r2);
        return;
    L9:
        return;
    }

    public void reloadTemplate(TemplateData r2) {
        reloadTemplate(r2, null);
    }

    public void removeLynxViewClient(q1 r2) {
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.removeLynxViewClient(r2);
    }

    public void removeLynxViewClientV2(LynxViewClientV2 r2) {
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 == null) goto L6;
        r0.removeLynxViewClientV2(r2);
        return;
    }

    public void resetData(TemplateData r3) {
        checkAccessFromNonUiThread("resetData");
        LLog.i(TAG, "resetData with json in " + r3.toString());
        if (this.mLynxTemplateRender != null) goto L5;
        return;
    L5:
        this.mLynxTemplateRender.resetData(r3);
        if (this.mIsPrePaintingStage == false) goto L8;
        this.mIsPrePaintingStage = false;
        return;
    L8:
        triggerEmbeddedModeLifecycle("onDataChanged", true);
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView
    public void runOnTasmThread(Runnable r2) {
        checkAccessFromNonUiThread("runOnTasmThread");
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.runOnTasmThread(r2);
    }

    public void setAsyncImageInterceptor(com.lynx.tasm.behavior.m r2) {
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setAsyncImageInterceptor(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView
    public void setAttachLynxPageUICallback(UIBody.UIBodyView.a r2) {
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 == null) goto L6;
        r0.setAttachLynxPageUICallback(r2);
        return;
    }

    public void setEnableUIFlush(boolean r2) {
        checkAccessFromNonUiThread("setEnableUIFlush");
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setEnableUIFlush(r2);
    }

    public void setExtraTiming(Map<String, Long> r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (this.mLynxTemplateRender == null) goto L24;
        b2 r0 = new b2();
        if (r4.containsKey("open_time") == false) goto L10;
        r0.a = r4.get("open_time").longValue();
    L10:
        if (r4.containsKey("container_init_start") == false) goto L13;
        r0.b = r4.get("container_init_start").longValue();
    L13:
        if (r4.containsKey("container_init_end") == false) goto L16;
        r0.c = r4.get("container_init_end").longValue();
    L16:
        if (r4.containsKey("prepare_template_start") == false) goto L19;
        r0.d = r4.get("prepare_template_start").longValue();
    L19:
        if (r4.containsKey("prepare_template_end") == false) goto L21;
        r0.e = r4.get("prepare_template_end").longValue();
    L21:
        this.mLynxTemplateRender.setExtraTiming(r0);
        return;
    }

    public void setFluencyTracerEnabled(LynxBooleanOption r2) {
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 == null) goto L6;
        r0.setFluencyTracerEnabled(r2);
        return;
    }

    public void setGlobalProps(Map<String, Object> r2) {
        checkAccessFromNonUiThread("setGlobalProps");
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.updateGlobalProps(TemplateData.fromMap(r2));
    }

    public void setImageInterceptor(com.lynx.tasm.behavior.m r2) {
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setImageInterceptor(r2);
    }

    public void setLongTaskMonitorEnabled(LynxBooleanOption r2) {
        this.mLynxTemplateRender.setLongTaskMonitorEnabled(r2);
        LynxContext r0 = getLynxContext();
        if (r0 == null) goto L6;
        r0.setLongTaskMonitorEnabled(r2);
        return;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r2) {
        if (r2 != null) goto L4;
        boolean r0 = true;
    L5:
        setFocusableInTouchMode(r0);
        super.setOnClickListener(r2);
        return;
    L4:
        r0 = false;
        goto L5
    }

    public void setTheme(ByteBuffer r3) {
        LynxContext r0 = getLynxContext();
        if (r0 == null) goto L5;
        LynxFeatureCounter.a(86, r0.getInstanceId());
    L5:
        checkAccessFromNonUiThread("setTheme");
        LynxTemplateRender r1 = this.mLynxTemplateRender;
        if (r1 == null) goto L11;
        if (r3 == null) goto L12;
        r1.setTheme(r3);
        return;
    L12:
        return;
    }

    @Override // android.view.View
    public void setVisibility(int r3) {
        super.setVisibility(r3);
        LLog.i("Lynx", "setVisibility:" + hashCode() + " " + r3);
    }

    public void updateColorScheme(LynxColorScheme r2) {
        checkAccessFromNonUiThread("updateColorScheme");
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 == null) goto L8;
        if (r2 == null) goto L9;
        r0.updateColorScheme(r2);
        return;
    L9:
        return;
    }

    public void updateData(TemplateData r3) {
        checkAccessFromNonUiThread("updateData");
        LLog.i(TAG, "updateData with data in " + r3.toString());
        if (this.mLynxTemplateRender != null) goto L5;
        return;
    L5:
        this.mLynxTemplateRender.updateData(r3, false);
        if (this.mIsPrePaintingStage == false) goto L8;
        this.mIsPrePaintingStage = false;
        return;
    L8:
        triggerEmbeddedModeLifecycle("onDataChanged", true);
    }

    public void updateFontScacle(float r3) {
        checkAccessFromNonUiThread("updateFontScale");
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 != null) goto L5;
    L7:
        int r1 = -1;
    L8:
        LynxFeatureCounter.a(81, r1);
        LynxTemplateRender r2 = this.mLynxTemplateRender;
        if (r2 != null) goto L11;
        return;
    L11:
        r2.updateFontScale(r3);
        return;
    L5:
        if (r0.getLynxContext() == null) goto L7;
        r1 = this.mLynxTemplateRender.getLynxContext().getInstanceId();
        goto L8
    }

    public void updateFontScale(float r3) {
        checkAccessFromNonUiThread("updateFontScale");
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 != null) goto L5;
    L7:
        int r1 = -1;
    L8:
        LynxFeatureCounter.a(81, r1);
        LynxTemplateRender r2 = this.mLynxTemplateRender;
        if (r2 != null) goto L11;
        return;
    L11:
        r2.updateFontScale(r3);
        return;
    L5:
        if (r0.getLynxContext() == null) goto L7;
        r1 = this.mLynxTemplateRender.getLynxContext().getInstanceId();
        goto L8
    }

    public void updateGlobalProps(TemplateData r2) {
        checkAccessFromNonUiThread("updateGlobalProps");
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.updateGlobalProps(r2);
    }

    public void updateMetaData(o1 r2) {
        checkAccessFromNonUiThread("updateMetaData");
        if (this.mLynxTemplateRender == null) goto L10;
        if (r2 == null) goto L11;
        this.mLynxTemplateRender.updateMetaData(r2);
        if (this.mIsPrePaintingStage == false) goto L8;
        this.mIsPrePaintingStage = false;
        return;
    L8:
        triggerEmbeddedModeLifecycle("onDataChanged", true);
        return;
    L11:
        return;
    }

    public void setExtraTiming(b2 r2) {
        if (r2 == null) goto L8;
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 == null) goto L9;
        r0.setExtraTiming(r2);
        return;
    L9:
        return;
    }

    public void setGlobalProps(TemplateData r2) {
        checkAccessFromNonUiThread("setGlobalProps");
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.updateGlobalProps(r2);
    }

    public void setTheme(k8a.a r3) {
        LynxContext r0 = getLynxContext();
        if (r0 == null) goto L5;
        LynxFeatureCounter.a(86, r0.getInstanceId());
    L5:
        checkAccessFromNonUiThread("setTheme");
        LynxTemplateRender r1 = this.mLynxTemplateRender;
        if (r1 != null) goto L8;
        return;
    L8:
        r1.setTheme(r3);
    }

    public void updateData(String r2) {
        updateData(r2, null);
    }

    public void updateGlobalProps(Map<String, Object> r1) {
        updateGlobalProps(TemplateData.fromMap(r1));
    }

    public void updateData(Map<String, Object> r2) {
        updateData(r2, null);
    }

    public LynxView(Context r3, h r4) {
        super(r3);
        this.mConsumeSlideEvent = false;
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
        this.mDestroyed = false;
        this.mLynxTemplateRender = (LynxTemplateRender) r4;
        initialize(r3, null);
    }

    public static /* synthetic */ void access$000(LynxView r0, Map r1) {
        r0.putPendingPipelineIdsToMap(r1);
    }

    private void initLynxTemplateRender(Context r2, LynxViewBuilder r3) {
        if (this.mLynxTemplateRender == null) goto L6;
        this.mLynxTemplateRender.attachLynxView(this);
        return;
    L6:
        this.mLynxUIRender.getClass();
        this.mIsAccessibilityDisabled = false;
        this.mLynxTemplateRender = new LynxTemplateRender(r2, this, r3);
    }

    private void initLynxViewWithRuntime(Context r9, LynxViewBuilder r10) {
        LynxBackgroundRuntime r0 = r10.lynxBackgroundRuntime;
        LLog.w(TAG, "init LynxView with runtime, " + r0);
        Object r2 = r0.i;
        monitor-enter(r2);
    L29:
        th = move-exception;
        throw th;
    L5:
        if (r0.h == 0) goto L9;
        LLog.e("LynxBackgroundRuntime", "build LynxView using an invalid LynxBackgroundRuntime, state: " + r0.h + ", runtime: " + r0);     // Catch: Throwable -> L29
        monitor-exit(r2);     // Catch: Throwable -> L29
        boolean r1 = false;
    L12:
        if (r1 == false) goto L28;
        LynxModuleFactory r3 = r0.b;
        List<com.lynx.jsbridge.f> r4 = r10.getLynxRuntimeOptions().d;
        r3.getClass();
        if (r4 == null) goto L25;
        ArrayList r5 = (ArrayList) r4;
        if (r5.isEmpty() == true) goto L25;
        Iterator r6 = r5.iterator();
    L20:
        if (r6.hasNext() == false) goto L25;
        com.lynx.jsbridge.f r7 = (com.lynx.jsbridge.f) r6.next();
        String r8 = r7.b();
        if (r3.a.containsKey(r8) == false) goto L24;
        LLog.w("LynxModuleFactory", "Duplicated LynxModule For Name: " + r8 + ", will be ignored");
    L24:
        r3.a.putIfAbsent(r8, r7);
        LLog.v("LynxModuleFactory", "method addModuleParamWrapperIfAbsent , registered module with name: " + r8 + " class" + r7);
    L25:
        r10.getLynxRuntimeOptions().b(r0.a);
        initialize(r9, r10);
        return;
    L28:
        throw new RuntimeException("Build LynxView using an used LynxBackgroundRuntime: " + r0);
    L9:
        r0.h = 4;     // Catch: Throwable -> L29
        monitor-exit(r2);     // Catch: Throwable -> L29
        r1 = true;
        goto L12
    }

    private void initialize(Context r4, LynxViewBuilder r5) {
        setFocusableInTouchMode(true);
        if (LynxEnv.inst().enableFreshRateOpt() == true) goto L5;
        VSyncMonitor.a = new WeakReference((WindowManager) r4.getSystemService("window"));
        VSyncMonitor.d = false;
    L5:
        initLynxTemplateRender(r4, r5);
        this.mLynxUIRender.getClass();
        this.mDisableDrawChildHook = false;
    }

    private void onTraceEventBegin(String r4, Callable<HashMap<String, String>> r5) {
        if (TraceEvent.isTracingStarted() == true) goto L5;
        return;
    L5:
        HashMap r0 = new HashMap();
        if (getLynxContext() == null) goto L8;
        String r1 = String.valueOf(getLynxContext().getInstanceId());
    L9:
        r0.put("instance_id", r1);
        r0.put("lynx_view", toString());
        if (r5 != null) goto L17;
    L15:
        TraceEvent.beginSection(r4, r0);
        return;
    L17:
        r0.putAll(r5.call());     // Catch: Exception -> L13
    L13:
        e = move-exception;
        r0.put("exception", e.toString());
        goto L15
    L8:
        r1 = "null";
        goto L9
    }

    private void showMessageOnConsole(String r2, int r3) {
        LynxBaseInspectorController r0 = getBaseInspectorController();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.showMessageOnConsole(r2, r3);
    }

    private void triggerEmbeddedModeLifecycle(String r2, boolean r3) {
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 != null) goto L5;
        return;
    L5:
        LynxContext r1 = r0.getLynxContext();
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.isEmbeddedModeOn() == true) goto L10;
        return;
    L10:
        if (this.mLynxTemplateRender.hasLogicExecutor() == false) goto L16;
        UIThreadUtils.runOnUiThread(new e(this, r2, r3));
        return;
    }

    public void getSessionStorageItem(String r2, PlatformCallBack r3) {
        checkAccessFromNonUiThread("getSessionStorageItem");
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 == null) goto L6;
        r0.getSessionStorageItem(r2, r3);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r5, int r6) {
        boolean r1 = false;
        if (this.mDestroyed == false) goto L6;
        setMeasuredDimension(0, 0);
        return;
    L6:
        onTraceEventBegin("LynxView.onMeasure", new a(this, r5, r6));
        this.mCurrentWidthMeasureSpec = r5;
        this.mCurrentHeightMeasureSpec = r6;
        LLog.d("Lynx", "onMeasure:" + hashCode() + ", width" + View.MeasureSpec.toString(r5) + ", height" + View.MeasureSpec.toString(r6));
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 != null) goto L9;
    L29:
        super.onMeasure(r5, r6);
        onTraceEventEnd("LynxView.onMeasure");
        return;
    L9:
        if (this.isInPrePainting == true) goto L29;
        r0.markHostPlatformTiming("measureStart");
        if (lynxUIRenderer() != null) goto L14;
        onMeasureWhenDetach(r5, r6);
    L27:
        this.mLynxTemplateRender.markHostPlatformTiming("measureEnd");
        onTraceEventEnd("LynxView.onMeasure");
        return;
    L14:
        if (getLynxContext() == null) goto L19;
        if (getLynxContext().isFragmentLayerRenderOn() == false) goto L19;
        r1 = true;
    L19:
        if (this.mLynxTemplateRender.isEnableReuseEngine() == false) goto L23;
        UIGroup<UIBody.UIBodyView> r2 = getLynxUIRoot();
        if ((r2 instanceof UIBody) == false) goto L23;
        ((UIBody) r2).rebuildViewTree();
    L23:
        this.mLynxTemplateRender.onMeasure(r5, r6);
        if (r1 == false) goto L27;
        super.onMeasure(r5, r6);
        goto L27
    }

    public void processLayout(String r3, TemplateData r4) {
        LLog.i(TAG, "processLayout " + r3 + "with templateData in " + toString());
        if (this.mLynxTemplateRender != null) goto L5;
        return;
    L5:
        this.mLynxTemplateRender.processLayout(r3, r4);
    }

    public void processLayoutWithSSRUrl(String r3, TemplateData r4) {
        LLog.i(TAG, "processLayoutWithSSRUrl in " + toString());
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.processLayoutWithSSRUrl(r3, r4);
    }

    public boolean registerDynamicComponent(String r3, TemplateBundle r4) {
        LLog.i(TAG, "register lazy bundle with TemplateBundle: " + r3);
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.registerLazyBundle(r3, r4);
    }

    public void reloadTemplate(TemplateData r3, TemplateData r4) {
        checkAccessFromNonUiThread("reloadTemplate");
        LLog.i(TAG, "reloadTemplate with data: " + String.valueOf(r3) + ", with globalProps:" + String.valueOf(r4));
        if (this.mLynxTemplateRender != null) goto L5;
        return;
    L5:
        this.mLynxTemplateRender.reloadTemplate(r3, r4);
    }

    public void renderSSRUrl(String r3, TemplateData r4) {
        LLog.d(TAG, "renderSSRUrl " + r3);
        this.mUrl = r3;
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.renderSSRUrl(r3, r4);
    }

    public void renderTemplate(byte[] r3, TemplateData r4) {
        LLog.i(TAG, "renderTemplate with templateData in " + toString());
        if (this.mLynxTemplateRender != null) goto L5;
        return;
    L5:
        this.mLynxTemplateRender.renderTemplate(r3, r4);
    }

    public void renderTemplateUrl(String r3, TemplateData r4) {
        LLog.i(TAG, "renderTemplateUrl " + r3 + "with templateData in" + toString());
        this.mUrl = r3;
        if (this.mLynxTemplateRender != null) goto L5;
        return;
    L5:
        this.mLynxTemplateRender.renderTemplateUrl(r3, r4);
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView
    public void sendGlobalEvent(String r3, JavaOnlyArray r4) {
        if (LynxEnv.inst().isHighlightTouchEnabled() == false) goto L5;
        showMessageOnConsole("LynxView: send global event " + r3 + " for lynx " + hashCode(), LogBoxLogLevel.Info.ordinal());
    L5:
        LLog.i(TAG, "LynxView sendGlobalEvent " + r3 + " with this: " + toString());
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 != null) goto L10;
        LLog.e(TAG, "LynxVew sendGlobalEvent failed since mLynxTemplateRender is null with this: " + toString());
        return;
    L10:
        if (enableAirStrictMode() == false) goto L12;
    L15:
        triggerEventBus(r3, r4);
        return;
    L12:
        if (r0.shouldSendEventToMainThread() == true) goto L15;
        r0.sendGlobalEvent(r3, r4);
    }

    public void sendGlobalEventToLepus(String r3, List<Object> r4) {
        if (LynxEnv.inst().isHighlightTouchEnabled() == false) goto L5;
        showMessageOnConsole("LynxView: send global event " + r3 + " to lepus for lynx " + hashCode(), LogBoxLogLevel.Info.ordinal());
    L5:
        checkAccessFromNonUiThread("sendGlobalEventToLepus");
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 != null) goto L8;
        return;
    L8:
        r0.sendGlobalEventToLepus(r3, r4);
    }

    public void setEnableUserBytecode(boolean r2, String r3) {
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 == null) goto L6;
        r0.setEnableBytecode(r2, r3);
        return;
    }

    public void setEnableUserCodeCache(boolean r1, String r2) {
        setEnableUserBytecode(r1, r2);
    }

    public void setSessionStorageItem(String r2, TemplateData r3) {
        checkAccessFromNonUiThread("setSessionStorageItem");
        if (r3 == null) goto L8;
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 == null) goto L9;
        r0.setSessionStorageItem(r2, r3);
        return;
    L9:
        return;
    }

    public void ssrHydrateUrl(String r4, Map<String, Object> r5) {
        if (r5 == null) goto L5;
        LLog.d(TAG, "ssrHydrateUrl  " + r4 + " with data in " + r5.toString());
    L7:
        if (this.mLynxTemplateRender != null) goto L9;
        return;
    L9:
        this.mLynxTemplateRender.ssrHydrateUrl(r4, r5);
        return;
    L5:
        LLog.d(TAG, "ssrHydrateUrl  " + r4);
        goto L7
    }

    public double subscribeSessionStorage(String r2, PlatformCallBack r3) {
        checkAccessFromNonUiThread("subscribeSessionStorage");
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 != null) goto L5;
        return -1.0d;
    L5:
        return r0.subscribeSessionStorage(r2, r3);
    }

    public void triggerEventBus(String r2, List<Object> r3) {
        checkAccessFromNonUiThread("triggerEventBus");
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.triggerEventBus(r2, r3);
    }

    public void unsubscribeSessionStorage(String r2, double r3) {
        checkAccessFromNonUiThread("removeGlobalSharedDataListener");
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 == null) goto L6;
        r0.unsubscribeSessionStorage(r2, r3);
        return;
    }

    public void updateData(String r3, String r4) {
        checkAccessFromNonUiThread("updateData");
        LLog.i(TAG, "updateData with json in " + toString());
        if (this.mLynxTemplateRender != null) goto L5;
        return;
    L5:
        this.mLynxTemplateRender.updateData(r3, r4);
        if (this.mIsPrePaintingStage == false) goto L8;
        this.mIsPrePaintingStage = false;
        return;
    L8:
        triggerEmbeddedModeLifecycle("onDataChanged", true);
    }

    public void updateScreenMetrics(int r2, int r3) {
        checkAccessFromNonUiThread("updateScreenMetrics");
        if (this.mLynxTemplateRender != null) goto L5;
        return;
    L5:
        DisplayMetricsHolder.updateDisplayMetrics(r2, r3);
        this.mLynxTemplateRender.updateScreenMetrics(r2, r3);
    }

    public void updateViewport(int r2, int r3) {
        checkAccessFromNonUiThread("updateViewport");
        updateViewport(r2, r3, true);
    }

    public LynxView(Context r2, LynxViewBuilder r3) {
        super(r2);
        this.mConsumeSlideEvent = false;
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
        this.mDestroyed = false;
        initWithLynxViewBuilder(r3);
    }

    public void renderSSRUrl(String r3, Map<String, Object> r4) {
        LLog.d(TAG, "renderSSRUrl " + r3);
        this.mUrl = r3;
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.renderSSRUrl(r3, r4);
    }

    public void renderTemplate(byte[] r3, Map<String, Object> r4) {
        LLog.i(TAG, "renderTemplate with init data in " + toString());
        if (this.mLynxTemplateRender != null) goto L5;
        return;
    L5:
        this.mLynxTemplateRender.renderTemplate(r3, r4);
    }

    public void renderTemplateUrl(String r3, String r4) {
        LLog.i(TAG, "renderTemplateUrl " + r3 + "with jsonData in" + toString());
        this.mUrl = r3;
        if (this.mLynxTemplateRender != null) goto L5;
        return;
    L5:
        this.mLynxTemplateRender.renderTemplateUrl(r3, r4);
    }

    public void ssrHydrateUrl(String r3, TemplateData r4) {
        LLog.d(TAG, "ssrHydrateUrl  " + r3 + " with data in " + r4.toString());
        if (this.mLynxTemplateRender != null) goto L5;
        return;
    L5:
        this.mLynxTemplateRender.ssrHydrateUrl(r3, r4);
    }

    public void updateData(Map<String, Object> r3, String r4) {
        checkAccessFromNonUiThread("updateData");
        LLog.i(TAG, "updateData with map in " + toString());
        if (this.mLynxTemplateRender != null) goto L5;
        return;
    L5:
        this.mLynxTemplateRender.updateData(r3, r4);
    }

    public LynxView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mConsumeSlideEvent = false;
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
        this.mDestroyed = false;
    }

    public void renderTemplateUrl(String r3, Map<String, Object> r4) {
        LLog.i(TAG, "renderTemplateUrl " + r3 + "with Map in" + toString());
        this.mUrl = r3;
        if (this.mLynxTemplateRender != null) goto L5;
        return;
    L5:
        this.mLynxTemplateRender.renderTemplateUrl(r3, r4);
    }

    public void processLayoutWithTemplateBundle(TemplateBundle r3, TemplateData r4, String r5) {
        LLog.i(TAG, "processLayoutWithTemplateBundle in " + toString());
        if (this.mLynxTemplateRender != null) goto L5;
        return;
    L5:
        this.mLynxTemplateRender.processLayoutWithTemplateBundle(r3, r4, r5);
    }

    public void renderSSR(byte[] r3, String r4, TemplateData r5) {
        LLog.d(TAG, "renderSSR " + r4);
        if (this.mLynxTemplateRender != null) goto L5;
        return;
    L5:
        this.mLynxTemplateRender.renderSSR(r3, r4, r5);
    }

    public void renderTemplateBundle(TemplateBundle r3, TemplateData r4, String r5) {
        LLog.i(TAG, "renderTemplateBundle with templateData in " + toString());
        if (this.mLynxTemplateRender != null) goto L5;
        return;
    L5:
        this.mLynxTemplateRender.renderTemplateBundle(r3, r4, r5);
    }

    public void renderTemplateWithBaseUrl(byte[] r3, TemplateData r4, String r5) {
        LLog.i(TAG, "renderTemplateWithBaseUrl " + r5 + "with templateData in " + toString());
        this.mUrl = r5;
        if (this.mLynxTemplateRender != null) goto L5;
        return;
    L5:
        this.mLynxTemplateRender.renderTemplateWithBaseUrl(r3, r4, r5);
    }

    public void ssrHydrate(byte[] r4, String r5, TemplateData r6) {
        StringBuilder r0 = new StringBuilder("ssrHydrate ");
        r0.append(r5);
        if (r6 != null) goto L5;
        String r1 = NameKeys.UnloadStrategy_No_Strategy;
    L6:
        r0.append(r1);
        LLog.d(TAG, r0.toString());
        if (this.mLynxTemplateRender != null) goto L9;
        return;
    L9:
        this.mLynxTemplateRender.ssrHydrateWithBaseUrl(r4, r6, r5);
        return;
    L5:
        r1 = " with data in " + r6.toString();
        goto L6
    }

    public void updateViewport(int r3, int r4, boolean r5) {
        onTraceEventBegin("LynxView.updateViewport", new c(r3, r4, r5));
        this.mCurrentWidthMeasureSpec = r3;
        this.mCurrentHeightMeasureSpec = r4;
        checkAccessFromNonUiThread("updateViewport");
        LynxTemplateRender r0 = this.mLynxTemplateRender;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.updateViewport(r3, r4, r5);
        onTraceEventEnd("LynxView.updateViewport");
    }

    public void renderSSR(byte[] r3, String r4, Map<String, Object> r5) {
        LLog.d(TAG, "renderSSR " + r4);
        if (this.mLynxTemplateRender != null) goto L5;
        return;
    L5:
        this.mLynxTemplateRender.renderSSR(r3, r4, r5);
    }

    public void renderTemplateWithBaseUrl(byte[] r3, String r4, String r5) {
        LLog.i(TAG, "renderTemplateWithBaseUrl " + r5 + "with string data in" + toString());
        this.mUrl = r5;
        if (this.mLynxTemplateRender != null) goto L5;
        return;
    L5:
        this.mLynxTemplateRender.renderTemplateWithBaseUrl(r3, r4, r5);
    }

    public void ssrHydrate(byte[] r4, String r5, Map<String, Object> r6) {
        StringBuilder r0 = new StringBuilder("ssrHydrate ");
        r0.append(r5);
        if (r6 != null) goto L5;
        String r1 = NameKeys.UnloadStrategy_No_Strategy;
    L6:
        r0.append(r1);
        LLog.d(TAG, r0.toString());
        if (this.mLynxTemplateRender != null) goto L9;
        return;
    L9:
        this.mLynxTemplateRender.ssrHydrateWithBaseUrl(r4, r6, r5);
        return;
    L5:
        r1 = " with data in " + r6.toString();
        goto L6
    }

    public void renderTemplateWithBaseUrl(byte[] r3, Map<String, Object> r4, String r5) {
        LLog.i(TAG, "renderTemplateWithBaseUrl " + r5 + "with map in " + toString());
        this.mUrl = r5;
        if (this.mLynxTemplateRender != null) goto L5;
        return;
    L5:
        this.mLynxTemplateRender.renderTemplateWithBaseUrl(r3, r4, r5);
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r9, int r10, int r11, int r12, int r13) {
        onTraceEventBegin("LynxView.onLayout", new b(this, r9, r10, r11, r12, r13));
        LynxTemplateRender r1 = this.mLynxTemplateRender;
        if (r1 != null) goto L5;
    L28:
        onTraceEventEnd("LynxView.onLayout");
        return;
    L5:
        if (this.isInPrePainting == true) goto L28;
        r1.markHostPlatformTiming("layoutStart");
        if (lynxUIRenderer() != null) goto L10;
        onLayoutWhenDetach();
    L16:
        if (r9 == true) goto L18;
    L26:
        this.mLynxTemplateRender.markHostPlatformTiming("layoutEnd");
        onTraceEventEnd("LynxView.onLayout");
        return;
    L18:
        if (getLynxContext() == null) goto L26;
        if (getLynxContext().useRelativeKeyboardHeightApi() == false) goto L26;
        com.lynx.tasm.behavior.n r14 = this.mKeyboardEvent;
        if (r14 == null) goto L26;
        if (r14.d == false) goto L26;
        r14.b();
        goto L26
    L10:
        if (getLynxContext() != null) goto L12;
    L14:
        this.mLynxTemplateRender.onLayout(r9, r10, r11, r12, r13);
        goto L16
    L12:
        if (getLynxContext().isFragmentLayerRenderOn() == false) goto L14;
        super.onLayout(r9, r10, r11, r12, r13);
        goto L14
    }
}
