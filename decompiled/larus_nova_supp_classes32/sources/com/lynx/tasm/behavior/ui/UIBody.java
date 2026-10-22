package com.lynx.tasm.behavior.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import androidx.core.util.Consumer;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxBooleanOption;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.ILynxUIRenderer;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxUIRenderer;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.behavior.render.NativePaintingContext;
import com.lynx.tasm.behavior.render.PlatformRendererContext;
import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.performance.longtasktiming.LynxLongTaskMonitor;
import com.lynx.tasm.service.ILynxTextService;
import com.lynx.tasm.t1;
import com.lynx.tasm.utils.SizeValue;
import com.miui.easygo.constant.EasyGoDbTable;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class UIBody extends UIGroup<UIBodyView> {
    private static final String TAG = "UIBody";
    private com.lynx.tasm.behavior.ui.accessibility.d mA11yWrapper;
    private com.lynx.tasm.base.h<Void> mAttachTask;
    private UIBodyView mBodyView;
    private HashMap<String, EventTarget> mChildrenLynxPageUI;
    private ArrayList<LynxUI> mCreateViewUI;
    private com.lynx.tasm.base.h<Void> mDetachTask;
    private Consumer<Exception> mExceptionHandler;
    private EventTarget mParentLynxPageUI;

    public static class UIBodyView extends FrameLayout implements IDrawChildHook.IDrawChildHookBinding, x6a.e {
        protected com.lynx.tasm.behavior.ui.accessibility.d mA11yWrapper;
        private int mCacheHeight;
        private int mCacheWidth;
        private IDrawChildHook mDrawChildHook;
        private boolean mHasMeaningfulLayout;
        private boolean mHasMeaningfulPaint;
        private boolean mHasPendingRequestLayout;
        private ConcurrentHashMap<Integer, d7a.f> mImageMap;
        private int mInstanceId;
        private boolean mInterceptRequestLayout;
        private int mIntrinsicHeight;
        private int mIntrinsicWidth;
        private boolean mIsChildLynxPageUI;
        boolean mIsMeaningfulPaintingAreaInvalidate;
        private LynxContext mLynxContext;
        protected ILynxUIRenderer mLynxUIRender;
        private long mMeaningfulPaintTiming;
        private boolean mNeedRemoveExistingViews;
        private x6a.i mRenderer;
        private WeakReference<c8a.c> mTimingCollector;
        private ConcurrentHashMap<Integer, View> mViewMap;

        public interface a {
        }

        public /* bridge */ /* synthetic */ void applyRendererClipBounds(boolean r1, Rect r2) {
            x6a.d.a(this, r1, r2);
        }

        public /* bridge */ /* synthetic */ void applyRendererOpacity(float r1) {
            x6a.d.b(this, r1);
        }

        public /* bridge */ /* synthetic */ void applyRendererTransform(float[] r1) {
            x6a.d.c(this, r1);
        }

        public void clearMeaningfulFlag() {
            this.mHasMeaningfulLayout = false;
            this.mHasMeaningfulPaint = false;
            this.mMeaningfulPaintTiming = 0;
        }

        public /* bridge */ /* synthetic */ PointF convertPointInRendererHostToScreen(PointF r1) {
            return x6a.d.d(this, r1);
        }

        public LynxViewBuilder getLynxViewBuilder() {
            return null;
        }

        public /* bridge */ /* synthetic */ int getRendererHostHeight() {
            return x6a.d.e(this);
        }

        public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
            return x6a.d.f(this);
        }

        public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
            return x6a.d.g(this);
        }

        public /* bridge */ /* synthetic */ int getRendererHostWidth() {
            return x6a.d.h(this);
        }

        @Override // x6a.e
        public View getView() {
            return this;
        }

        public /* bridge */ /* synthetic */ void invalidateForRenderer() {
            x6a.d.i(this);
        }

        public void invalidateMeaningfulPaintingArea() {
            this.mIsMeaningfulPaintingAreaInvalidate = true;
        }

        public /* bridge */ /* synthetic */ boolean invokeUIMethod(String r1, ReadableMap r2, Callback r3) {
            return false;
        }

        public boolean isAccessibilityDisabled() {
            return false;
        }

        public void markNeedRemoveExistingViews() {
            this.mNeedRemoveExistingViews = true;
        }

        public void notifyMeaningfulLayout() {
            this.mHasMeaningfulLayout = true;
        }

        public /* bridge */ /* synthetic */ void requestLayoutForRenderer() {
            x6a.d.j(this);
        }

        public void runOnTasmThread(Runnable r1) {
        }

        public void sendGlobalEvent(String r1, JavaOnlyArray r2) {
        }

        public void setAttachLynxPageUICallback(a r1) {
        }

        public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r1) {
            x6a.d.k(this, r1);
        }

        public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r1) {
            x6a.d.l(this, r1);
        }

        private boolean shouldDrawWithDisplayList() {
            if (this.mRenderer == null) goto L5;
            return true;
        L5:
            return false;
        }

        public void clearNodeIndexImageMap() {
            this.mImageMap.clear();
        }

        public LynxBooleanOption getLongTaskMonitorEnabled() {
            LynxBooleanOption r0 = LynxBooleanOption.UNSET;
            Context r1 = getContext();
            if ((r1 instanceof LynxContext) == true) goto L5;
            return r0;
        L5:
            return ((LynxContext) r1).getLongTaskMonitorEnabled();
        }

        public List<e> getMeaningfulPaintingAreas() {
            if ((this.mDrawChildHook instanceof m) == true) goto L6;
            return null;
        L6:
            ArrayList<e> r0 = new ArrayList();
            ((m) this.mDrawChildHook).c(0, 0, r0);
            return r0;
        }

        public void onLayoutWhenDetach() {
            IDrawChildHook r0 = this.mDrawChildHook;
            if ((r0 instanceof m) == false) goto L6;
            ((m) r0).d();
            return;
        }

        public void removeExistingViews() {
            if (this.mNeedRemoveExistingViews == true) goto L5;
            return;
        L5:
            Iterator<Map.Entry<Integer, View>> r0 = this.mViewMap.entrySet().iterator();
        L7:
            if (r0.hasNext() == false) goto L11;
            View r1 = r0.next().getValue();
            if ((r1.getParent() instanceof ViewGroup) == false) goto L7;
            ((ViewGroup) r1.getParent()).removeView(r1);
            goto L7
        L11:
            this.mViewMap.clear();
            this.mNeedRemoveExistingViews = false;
        }

        @Override // android.view.View, android.view.ViewParent
        public void requestLayout() {
            if (this.mInterceptRequestLayout == false) goto L6;
            this.mHasPendingRequestLayout = true;
            return;
        L6:
            this.mHasPendingRequestLayout = false;
            super.requestLayout();
        }

        private void TraceUITreeLayout() {
            if (TraceEvent.isTracingStarted() == false) goto L11;
            ILynxUIRenderer r0 = this.mLynxUIRender;
            if (r0 == null) goto L13;
            UIBody r1 = ((LynxUIRenderer) r0).g();
            if ((r1 instanceof UIBody) == false) goto L12;
            TraceEvent.beginSection(0, "DumpUITreeLayout");
            JSONObject r2 = getUITreeRecursively(r1);
            HashMap r4 = new HashMap();
            r4.put("detail", r2.toString());
            r4.put("instance_id", String.valueOf(this.mInstanceId));
            TraceEvent.endSection(0, "DumpUITreeLayout", r4);
            return;
        L12:
            return;
        L13:
            return;
        }

        public boolean HasPendingRequestLayout() {
            return this.mHasPendingRequestLayout;
        }

        public int getIntrinsicHeight() {
            return this.mIntrinsicHeight;
        }

        public int getIntrinsicWidth() {
            return this.mIntrinsicWidth;
        }

        public ILynxUIRenderer getLynxUIRendererInternal() {
            return this.mLynxUIRender;
        }

        public long getMeaningfulPaintTiming() {
            return this.mMeaningfulPaintTiming;
        }

        @Override // x6a.e
        public x6a.i getRenderer() {
            return this.mRenderer;
        }

        public boolean isChildLynxPageUI() {
            return this.mIsChildLynxPageUI;
        }

        public boolean isMeaningfulPaintingAreaInvalidate() {
            return this.mIsMeaningfulPaintingAreaInvalidate;
        }

        public UIBodyView(Context r2) {
            super(r2);
            this.mViewMap = new ConcurrentHashMap();
            this.mImageMap = new ConcurrentHashMap();
            this.mLynxContext = null;
            this.mTimingCollector = new WeakReference(null);
            this.mInstanceId = -1;
            this.mNeedRemoveExistingViews = false;
            this.mIsMeaningfulPaintingAreaInvalidate = false;
        }

        private JSONObject getUITreeRecursively(LynxBaseUI r7) {
            JSONObject r0 = new JSONObject();
            r0.put(EasyGoDbTable.Server.NAME, r7.getClass().getName());     // Catch: Exception -> L9
            r0.put("tagName", r7.getTagName());     // Catch: Exception -> L9
            r0.put("id", r7.getSign());     // Catch: Exception -> L9
            r0.put("nodeIndex", r7.getNodeIndex());     // Catch: Exception -> L9
            r0.put("frame", new JSONArray(Arrays.asList(new Integer[]{Integer.valueOf(r7.getLeft()), Integer.valueOf(r7.getTop()), Integer.valueOf(r7.getWidth()), Integer.valueOf(r7.getHeight())})));     // Catch: Exception -> L9
            ArrayList r1 = new ArrayList();     // Catch: Exception -> L9
            Iterator<LynxBaseUI> r8 = r7.getChildren().iterator();     // Catch: Exception -> L9
        L5:
            if (r8.hasNext() == false) goto L7;
            r1.add(getUITreeRecursively(r8.next()));     // Catch: Exception -> L9
            goto L5
        L7:
            r0.put("children", new JSONArray(r1));     // Catch: Exception -> L9
        L11:
            return r0;
        L9:
            e = move-exception;
            LLog.e(UIBody.TAG, "getUITreeRecursively error: " + e.getMessage());
            goto L11
        }

        public void bindDrawChildHook(IDrawChildHook r1) {
            this.mDrawChildHook = r1;
        }

        public boolean containsViewForNodeIndex(int r2) {
            return this.mViewMap.containsKey(Integer.valueOf(r2));
        }

        @Override // android.view.ViewGroup, android.view.View
        public void dispatchDraw(Canvas r5) {
            if (shouldDrawWithDisplayList() == false) goto L8;
            super.dispatchDraw(r5);
            this.mRenderer.a(r5);
            c8a.c r6 = this.mTimingCollector.get();
            if (r6 == null) goto L30;
            r6.b();
            return;
        L30:
            return;
        L8:
            this.mIsMeaningfulPaintingAreaInvalidate = false;
            c8a.c r0 = this.mTimingCollector.get();
            if (r0 == null) goto L11;
            r0.a("drawStart");
        L11:
            boolean r1 = LynxLongTaskMonitor.b("LynxTemplateRender.Draw", this.mInstanceId, getLongTaskMonitorEnabled());
            IDrawChildHook r2 = this.mDrawChildHook;
            if (r2 == null) goto L14;
            r2.beforeDispatchDraw(r5);
        L14:
            super.dispatchDraw(r5);
            IDrawChildHook r3 = this.mDrawChildHook;
            if (r3 == null) goto L18;
            r3.afterDispatchDraw(r5);
        L18:
            if (this.mHasMeaningfulLayout == true) goto L20;
        L22:
            if (r0 != null) goto L24;
        L27:
            if (r1 == false) goto L31;
            LynxLongTaskMonitor.a();
            return;
        L31:
            return;
        L24:
            if (r0.c().isEmpty() == true) goto L26;
            TraceUITreeLayout();
        L26:
            r0.a("drawEnd");
            r0.b();
            goto L27
        L20:
            if (this.mHasMeaningfulPaint == true) goto L22;
            TraceEvent.instant(1, "FirstMeaningfulPaint");
            this.mMeaningfulPaintTiming = System.currentTimeMillis();
            this.mHasMeaningfulPaint = true;
            goto L22
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchHoverEvent(MotionEvent r5) {
            if (isAccessibilityDisabled() == true) goto L5;
            com.lynx.tasm.behavior.ui.accessibility.d r0 = this.mA11yWrapper;
            if (r0 == null) goto L31;
            if (r0.f() == true) goto L11;
            com.lynx.tasm.behavior.ui.accessibility.d r1 = this.mA11yWrapper;
            boolean r2 = false;
            if (r1.b == false) goto L15;
        L19:
            boolean r3 = false;
        L20:
            if (r3 == false) goto L24;
            if (r1.l.h(r5) == false) goto L24;
        L27:
            r2 = true;
        L28:
            if (r2 == false) goto L31;
            return true;
        L24:
            if (r1.e() == false) goto L28;
            if (r1.m.dispatchHoverEvent(r5) == false) goto L28;
        L15:
            if (r1.c == true) goto L19;
            if (r1.l == null) goto L19;
            r3 = true;
            goto L20
        L11:
            return super.dispatchHoverEvent(r5);
        L31:
            return onHoverEvent(r5);
        L5:
            return super.dispatchHoverEvent(r5);
        }

        public d7a.f obtainImageAccordingToNodeIndex(int r3) {
            d7a.f r0 = this.mImageMap.get(Integer.valueOf(r3));
            this.mImageMap.remove(Integer.valueOf(r3));
            return r0;
        }

        public View obtainViewAccordingToNodeIndex(int r3) {
            View r0 = this.mViewMap.get(Integer.valueOf(r3));
            this.mViewMap.remove(Integer.valueOf(r3));
            return r0;
        }

        @Override // android.view.View
        public void onDraw(Canvas r2) {
            super.onDraw(r2);
            if (shouldDrawWithDisplayList() == false) goto L6;
            this.mRenderer.g(r2);
            return;
        }

        public d7a.f peekImageAccordingToNodeIndex(int r2) {
            return this.mImageMap.get(Integer.valueOf(r2));
        }

        @Override // android.view.ViewGroup
        public void setChildrenDrawingOrderEnabled(boolean r1) {
            super.setChildrenDrawingOrderEnabled(r1);
        }

        public void setInstanceId(int r1) {
            this.mInstanceId = r1;
        }

        public void setIsChildLynxPageUI(boolean r1) {
            this.mIsChildLynxPageUI = r1;
        }

        public void setLynxAccessibilityWrapper(com.lynx.tasm.behavior.ui.accessibility.d r1) {
            this.mA11yWrapper = r1;
        }

        public void setLynxUIRendererInternal(ILynxUIRenderer r1) {
            this.mLynxUIRender = r1;
        }

        @Override // x6a.e
        public void setRenderer(x6a.i r1) {
            this.mRenderer = r1;
        }

        public void setShouldInterceptRequestLayout(boolean r1) {
            this.mInterceptRequestLayout = r1;
        }

        public void setTimingCollector(c8a.c r2) {
            this.mTimingCollector = new WeakReference(r2);
        }

        public UIBodyView(Context r1, AttributeSet r2) {
            super(r1, r2);
            this.mViewMap = new ConcurrentHashMap();
            this.mImageMap = new ConcurrentHashMap();
            this.mLynxContext = null;
            this.mTimingCollector = new WeakReference(null);
            this.mInstanceId = -1;
            this.mNeedRemoveExistingViews = false;
            this.mIsMeaningfulPaintingAreaInvalidate = false;
        }

        public static /* synthetic */ LynxContext access$002(UIBodyView r0, LynxContext r1) {
            r0.mLynxContext = r1;
            return r1;
        }

        public void cacheLayoutInfo(int r1, int r2) {
            this.mCacheWidth = r1;
            this.mCacheHeight = r2;
        }

        @Override // x6a.e
        public x6a.i createRenderer(PlatformRendererContext r2, int r3) {
            return new x6a.i(r2, r3);
        }

        @Override // android.view.ViewGroup
        public int getChildDrawingOrder(int r2, int r3) {
            IDrawChildHook r0 = this.mDrawChildHook;
            if (r0 == null) goto L7;
            return r0.getChildDrawingOrder(r2, r3);
        L7:
            return super.getChildDrawingOrder(r2, r3);
        }

        public void innerSetMeasuredDimension(int r5, int r6) {
            if (TraceEvent.isTracingStarted() == false) goto L5;
            HashMap r0 = new HashMap();
            r0.put("width", String.valueOf(r5));
            r0.put("height", String.valueOf(r6));
            TraceEvent.instant(0, "UIBody.innerSetMeasuredDimension", r0);
        L5:
            setMeasuredDimension(r5, r6);
        }

        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int r2, int r3) {
            if (shouldDrawWithDisplayList() == false) goto L5;
            getRenderer().i();
            return;
        L5:
            super.onMeasure(r2, r3);
        }

        public void onMeasureWhenDetach(int r3, int r4) {
            performMeasure(r3, this.mCacheWidth, r4, this.mCacheHeight);
            IDrawChildHook r5 = this.mDrawChildHook;
            if ((r5 instanceof m) == false) goto L6;
            ((m) r5).e();
            return;
        }

        public void registerImageAccordingToNodeIndex(int r2, d7a.f r3) {
            this.mImageMap.put(Integer.valueOf(r2), r3);
        }

        public void registerViewAccordingToNodeIndex(int r2, View r3) {
            this.mViewMap.put(Integer.valueOf(r2), r3);
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public boolean requestSendAccessibilityEvent(View r3, AccessibilityEvent r4) {
            if (isAccessibilityDisabled() == true) goto L5;
            com.lynx.tasm.behavior.ui.accessibility.d r0 = this.mA11yWrapper;
            if (r0 == null) goto L14;
            if (r0.f() == true) goto L14;
            if (r4.getEventType() != 2048) goto L14;
            r4.setSource(this);
        L14:
            return super.requestSendAccessibilityEvent(r3, r4);
        L5:
            return super.requestSendAccessibilityEvent(r3, r4);
        }

        public void setIntrinsicContentSize(int r1, int r2) {
            this.mIntrinsicWidth = r1;
            this.mIntrinsicHeight = r2;
        }

        @Override // android.view.ViewGroup
        public boolean drawChild(Canvas r3, View r4, long r5) {
            if (shouldDrawWithDisplayList() == false) goto L6;
            this.mRenderer.b(r3, r4);
            boolean r6 = super.drawChild(r3, r4, r5);
            this.mRenderer.getClass();
            r3.restore();
            return r6;
        L6:
            IDrawChildHook r0 = this.mDrawChildHook;
            if (r0 == null) goto L9;
            Rect r1 = r0.beforeDrawChild(r3, r4, r5);
        L10:
            if (r1 == null) goto L12;
            r3.save();
            r3.clipRect(r1);
            boolean r2 = super.drawChild(r3, r4, r5);
            r3.restore();
        L13:
            IDrawChildHook r7 = this.mDrawChildHook;
            if (r7 == null) goto L16;
            r7.afterDrawChild(r3, r4, r5);
        L16:
            return r2;
        L12:
            r2 = super.drawChild(r3, r4, r5);
            goto L13
        L9:
            r1 = null;
            goto L10
        }

        public void performMeasure(int r1, int r2, int r3, int r4) {
            int r5 = View.MeasureSpec.getMode(r1);
            if (r5 == Integer.MIN_VALUE) goto L7;
            if (r5 == 0) goto L7;
            int r6 = View.MeasureSpec.getSize(r1);
        L8:
            int r7 = View.MeasureSpec.getMode(r3);
            if (r7 == Integer.MIN_VALUE) goto L13;
            if (r7 == 0) goto L13;
            int r8 = View.MeasureSpec.getSize(r3);
        L14:
            innerSetMeasuredDimension(r6, r8);
            return;
        L13:
            r8 = this.mCacheHeight;
        L7:
            r6 = this.mCacheWidth;
            goto L8
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
            super.onLayout(r1, r2, r3, r4, r5);
            if (shouldDrawWithDisplayList() == false) goto L6;
            this.mRenderer.h();
            return;
        }
    }

    public class a implements Consumer<Exception> {
        public final /* synthetic */ UIBody a;

        public a(UIBody r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Exception r3 = (Exception) r2;
            if (this.a.getLynxContext() == null) goto L6;
            this.a.getLynxContext().handleException(r3);
            return;
        }
    }

    public class b implements Callable<Void> {
        public final /* synthetic */ UIBodyView a;
        public final /* synthetic */ LynxContext b;
        public final /* synthetic */ UIBody c;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public Void call2() throws Exception {
            if (this.c.mContext.isEnginePoolEnabled() == true) goto L5;
        L10:
            UIBody.access$102(this.c, this.a);
            this.c.initialize();
            if (this.c.mContext.isEnginePoolEnabled() == true) goto L14;
            return null;
        L14:
            if (UIBody.access$100(this.c) != null) goto L17;
            LLog.e(UIBody.TAG, "attachUIBodyView failed since mBodyView is null.");
            return null;
        L17:
            UIBody r0 = this.c;
            r0.mContext = this.b;
            UIBodyView.access$002(UIBody.access$100(r0), this.b);
            UIBody r1 = this.c;
            r1.mContext.setUIBodyView(UIBody.access$100(r1));
            TraceEvent.beginSection("UIBody.attachUIBodyView");
            UIBody r2 = this.c;
            r2.mContext.setUIBodyView(UIBody.access$100(r2));
            UIBody.access$202(this.c, new ArrayList());
            this.c.attachToView(this.b);
            UIBody.access$100(this.c).markNeedRemoveExistingViews();
            TraceEvent.endSection("UIBody.attachUIBodyView");
            return null;
        L5:
            if (UIBody.access$100(this.c) != this.a) goto L8;
            return null;
        L8:
            if (UIBody.access$100(this.c) == null) goto L10;
            this.c.detachUIBodyView();
            goto L10
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Void call() throws Exception {
            return call2();
        }

        public b(UIBody r1, UIBodyView r2, LynxContext r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public class c implements Callable<Void> {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ UIBody b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public Void call2() throws Exception {
            TraceEvent.beginSection("UIBody.detachUIBodyView");
            this.b.markDetachWithViewRecursively(true);
            if (this.a == false) goto L5;
            this.b.performMeasureChildrenUI();
            this.b.performLayoutChildrenUI();
        L5:
            this.b.processViewInfo();
            UIBody r0 = this.b;
            r0.detachWithViewInfo(r0.mViewInfo);
            this.b.markDetachWithViewRecursively(false);
            TraceEvent.endSection("UIBody.detachUIBodyView");
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L8:
            if (UIBody.access$300(this.b) == null) goto L10;
            UIBody.access$300(this.b).run();     // Catch: Throwable -> L13
        L10:
            monitor-exit(this);     // Catch: Throwable -> L13
            return null;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Void call() throws Exception {
            return call2();
        }

        public c(UIBody r1, boolean r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void createViewAsync() {
    }

    public synchronized void detachUIBodyView() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.mContext.isEnginePoolEnabled() == true) goto L9;
        LLog.w(TAG, "UIBody.detachUIBodyView should not be called when isEnginePoolEnabled == false.");     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L9:
        if (this.mBodyView != null) goto L12;
        monitor-exit(this);
        return;
    L12:
        boolean r0 = ((UIBodyView) this.mView).isLayoutRequested();     // Catch: Throwable -> L15
        this.mBodyView.cacheLayoutInfo(getWidth(), getHeight());     // Catch: Throwable -> L15
        com.lynx.tasm.base.h<Void> r1 = new com.lynx.tasm.base.h(new c(this, r0), this.mExceptionHandler);     // Catch: Throwable -> L15
        this.mDetachTask = r1;     // Catch: Throwable -> L15
        LynxThreadPool.g(r1);     // Catch: Throwable -> L15
        monitor-exit(this);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public void ensureCreateView() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void registerViewAccordingToNodeIndex() {
    }

    public synchronized void tryRunDetachAndAttachTask() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.mContext.isEnginePoolEnabled() == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        com.lynx.tasm.base.h<Void> r0 = this.mDetachTask;     // Catch: Throwable -> L15
        if (r0 == null) goto L10;
        r0.run();     // Catch: Throwable -> L15
        this.mDetachTask.a();     // Catch: Throwable -> L15
    L10:
        com.lynx.tasm.base.h<Void> r1 = this.mAttachTask;     // Catch: Throwable -> L15
        if (r1 == null) goto L13;
        r1.run();     // Catch: Throwable -> L15
        this.mAttachTask.a();     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void updateNewSticky(float[] r1) {
    }

    public boolean enableNewAccessibility() {
        com.lynx.tasm.behavior.ui.accessibility.d r0 = this.mA11yWrapper;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.e() == false) goto L7;
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onAttach() {
        if (this.mContext.isEnginePoolEnabled() == false) goto L5;
        tryRunDetachAndAttachTask();
    L5:
        super.onAttach();
    }

    public void rebuildViewTree() {
        if (this.mContext.isEnginePoolEnabled() == true) goto L5;
        return;
    L5:
        TraceEvent.beginSection("UIBody.rebuildViewTree");
        monitor-enter(this);
        com.lynx.tasm.base.h<Void> r0 = this.mDetachTask;     // Catch: Throwable -> L27
        if (r0 == null) goto L10;
        r0.run();     // Catch: Throwable -> L27
        this.mDetachTask.a();     // Catch: Throwable -> L27
        this.mDetachTask = null;     // Catch: Throwable -> L27
    L10:
        com.lynx.tasm.base.h<Void> r1 = this.mAttachTask;     // Catch: Throwable -> L27
        if (r1 == null) goto L13;
        r1.run();     // Catch: Throwable -> L27
        this.mAttachTask.a();     // Catch: Throwable -> L27
        this.mAttachTask = null;     // Catch: Throwable -> L27
    L13:
        monitor-exit(this);     // Catch: Throwable -> L27
        UIBodyView r2 = this.mBodyView;
        if (r2 == null) goto L17;
        r2.removeExistingViews();
    L17:
        ArrayList<LynxUI> r3 = this.mCreateViewUI;
        if (r3 != null) goto L21;
        TraceEvent.endSection("UIBody.rebuildViewTree");
        return;
    L21:
        Iterator<LynxUI> r4 = r3.iterator();
    L23:
        if (r4.hasNext() == false) goto L25;
        r4.next().ensureCreateView();
        goto L23
    L25:
        this.mCreateViewUI.clear();
        TraceEvent.endSection("UIBody.rebuildViewTree");
        return;
    L27:
        th = move-exception;
        throw th;
    }

    public List<e> getMeaningfulPaintingAreas() {
        tryRunDetachAndAttachTask();
        if (getLynxContext() == null) goto L87;
        if (getLynxContext().isFragmentLayerRenderOn() == false) goto L87;
        UIBodyView r1 = this.mBodyView;
        if (r1 == null) goto L87;
        ILynxUIRenderer r2 = r1.getLynxUIRendererInternal();
        if ((r2 instanceof LynxUIRenderer) == false) goto L87;
        com.lynx.tasm.behavior.l r3 = ((LynxUIRenderer) r2).e;
        if ((r3 instanceof NativePaintingContext) == false) goto L98;
        NativePaintingContext r4 = (NativePaintingContext) r3;
        if (r4.c == true) goto L85;
        long r5 = r4.a;
        if (r5 == 0) goto L85;
        int[] r6 = r4.nativeGetMeaningfulPaintingAreaRecords(r5);
        PlatformRendererContext r7 = r4.b;
        LynxContext r8 = r4.e;
        if (r6 == null) goto L100;
        if (r6.length == 0) goto L100;
        ArrayList r9 = new ArrayList(r6.length / 6);
        int r10 = 0;
    L24:
        int r11 = r10 + 6;
        if (r11 > r6.length) goto L99;
        int r12 = r6[r10 + 0];
        int r13 = r6[r10 + 1];
        int r14 = r6[r10 + 2];
        int r15 = r6[r10 + 3];
        int r16 = r6[r10 + 4];
        int r17 = r6[r10 + 5];
        if (r16 <= 0) goto L78;
        if (r17 <= 0) goto L78;
        if (r13 != 5) goto L39;
        d7a.f r18 = r7.e(r12);
        if (r18 != null) goto L35;
    L37:
        ILynxUIMeaningfulContent$MeaningfulContentStatus r19 = ILynxUIMeaningfulContent$MeaningfulContentStatus.PENDING;
    L57:
        if (r19 == ILynxUIMeaningfulContent$MeaningfulContentStatus.IRRELEVANT) goto L78;
        if (r13 != 5) goto L65;
        d7a.f r20 = r7.e(r12);
        if (r20 == null) goto L65;
        r20.e().booleanValue();
    L65:
        e r21 = new e(r14, r15, r16, r17);
        x6a.e r22 = r7.b.get(Integer.valueOf(r12));
        if (r22 != null) goto L68;
    L71:
        x6a.e r23 = r7.b.get(Integer.valueOf(r12));
        if (r23 != null) goto L74;
    L77:
        r7.f(r12, true);
        r7.f(r12, false);
        r21.e = r19;
        r21.f = -1;
    L79:
        if (r21 == null) goto L81;
        r9.add(r21);
    L81:
        r10 = r11;
        goto L24
    L74:
        if (r23.getView() == null) goto L77;
        r23.getView().getAlpha();
        goto L77
    L68:
        if (r22.getView() == null) goto L71;
        r22.getView().getVisibility();
        goto L71
    L35:
        if (r18.e().booleanValue() == false) goto L37;
        r19 = ILynxUIMeaningfulContent$MeaningfulContentStatus.PRESENTED;
        goto L57
    L39:
        if (r13 != 4) goto L55;
        if (r8 != null) goto L42;
    L46:
        com.lynx.tasm.behavior.shadow.text.d r24 = r7.j;
        if (r24 != null) goto L49;
    L51:
        boolean r25 = false;
    L52:
        if (r25 == false) goto L54;
        r19 = ILynxUIMeaningfulContent$MeaningfulContentStatus.PRESENTED;
        goto L57
    L54:
        r19 = ILynxUIMeaningfulContent$MeaningfulContentStatus.PENDING;
        goto L57
    L49:
        if (r24.b.get(r12) == null) goto L51;
    L50:
        r25 = true;
        goto L52
    L42:
        if (r8.isTextServiceModeOn() == false) goto L46;
        if (((ILynxTextService.a) r7.i.get(Integer.valueOf(r12))) == null) goto L51;
    L55:
        r19 = ILynxUIMeaningfulContent$MeaningfulContentStatus.IRRELEVANT;
    L78:
        r21 = null;
        goto L79
    L99:
        return r9;
    L100:
        return new ArrayList();
    L85:
        return new ArrayList();
    L98:
        return new ArrayList();
    L87:
        int r26 = getWidth();
        int r27 = getHeight();
        if (r26 == 0) goto L94;
        if (r27 == 0) goto L94;
        ArrayList<e> r28 = new ArrayList();
        convertToMeaningfulPaintingAreaRecursive(0, 0, r26, r27, r28);
        return r28;
    L94:
        return new ArrayList();
    }

    public void initAccessibility() {
        UIBodyView r0 = getBodyView();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isAccessibilityDisabled() == false) goto L8;
        return;
    L8:
        if (this.mA11yWrapper != null) goto L10;
        this.mA11yWrapper = new com.lynx.tasm.behavior.ui.accessibility.d(this);
    L10:
        this.mAccessibilityElementStatus = 1;
        r0.setLynxAccessibilityWrapper(this.mA11yWrapper);
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void initialize() {
        super.initialize();
        initAccessibility();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onLayoutUpdated() {
        super.onLayoutUpdated();
        UIBodyView r0 = this.mBodyView;
        if (r0 == null) goto L6;
        r0.notifyMeaningfulLayout();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public void removeAll() {
        super.removeAll();
        UIBodyView r0 = this.mBodyView;
        if (r0 == null) goto L6;
        r0.clearMeaningfulFlag();
        return;
    }

    public UIBodyView getBodyView() {
        return this.mBodyView;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public HashMap<String, EventTarget> getChildrenLynxPageUI() {
        return this.mChildrenLynxPageUI;
    }

    public com.lynx.tasm.behavior.ui.accessibility.d getLynxAccessibilityWrapper() {
        return this.mA11yWrapper;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public EventTarget getParentLynxPageUI() {
        return this.mParentLynxPageUI;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public View getRealParentView() {
        return this.mBodyView;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_lynx_tasm_behavior_ui_UIBody_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public static /* synthetic */ UIBodyView access$100(UIBody r0) {
        return r0.mBodyView;
    }

    public static /* synthetic */ com.lynx.tasm.base.h access$300(UIBody r0) {
        return r0.mAttachTask;
    }

    public void appendUIWithCreateViewAsync(LynxUI r2) {
        ArrayList<LynxUI> r0 = this.mCreateViewUI;
        if (r0 != null) goto L6;
        LLog.w(TAG, "UIBody.appendUIWithCreateViewAsync failed since mCreateViewUI is null.");
        return;
    L6:
        r0.add(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public /* bridge */ /* synthetic */ View createView(Context r1) {
        return createView(r1);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void detachWithViewInfo(m r2) {
        m r0 = this.mViewInfo;
        if (r0 == null) goto L5;
        r2 = r0;
    L5:
        super.detachWithViewInfo(r2);
        this.mBodyView = null;
    }

    public void onPageConfigDecoded(t1 r7) {
        if (this.mA11yWrapper == null) goto L47;
        com.lynx.tasm.behavior.ui.accessibility.d r0 = this.mA11yWrapper;
        r0.getClass();
        if (r7 == null) goto L54;
        boolean r1 = r7.u;
        r0.c = r1;
        boolean r2 = true;
        if (r1 == false) goto L10;
    L14:
        boolean r3 = false;
    L15:
        r0.b = r3;
        boolean r4 = r7.q;
        r0.d = r4;
        boolean r5 = r7.r;
        r0.e = r5;
        r0.f = r7.t;
        if (r0.o == false) goto L18;
        r0.d();
        return;
    L18:
        if (r3 == false) goto L20;
    L24:
        r2 = false;
    L25:
        if (r2 == false) goto L27;
        com.lynx.tasm.behavior.ui.c r8 = r0.l;
        r8.h = r4;
        r8.i = r5;
        return;
    L27:
        UIBody r9 = r0.h();
        if (r9 != null) goto L30;
        return;
    L30:
        if (r9.getBodyView() != null) goto L32;
        return;
    L32:
        if (r0.i != null) goto L35;
        return;
    L35:
        if (r0.j != null) goto L38;
        r0.j = new com.lynx.tasm.behavior.ui.accessibility.b(r0.i, r0);
    L38:
        if (r0.k != null) goto L41;
        r0.k = new com.lynx.tasm.behavior.ui.accessibility.a();
    L41:
        if (r0.c == false) goto L44;
        r0.j(r9, r9.getBodyView());
        return;
    L44:
        if (r0.b == false) goto L53;
        r0.i(r9);
        return;
    L53:
        return;
    L20:
        if (r0.c == true) goto L24;
        if (r0.l == null) goto L24;
    L10:
        if (r7.s == false) goto L12;
    L13:
        r3 = true;
        goto L15
    L12:
        if (LynxEnv.inst().isPlatformObservabilityEnabled() == false) goto L14;
    L54:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public void setChildrenLynxPageUI(HashMap<String, EventTarget> r1) {
        this.mChildrenLynxPageUI = r1;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public void setParentLynxPageUI(EventTarget r1) {
        this.mParentLynxPageUI = r1;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public UIBodyView createView(Context r1) {
        return this.mBodyView;
    }

    public UIBody(LynxContext r2, UIBodyView r3) {
        super(r2);
        this.mDetachTask = null;
        this.mAttachTask = null;
        this.mExceptionHandler = null;
        this.mBodyView = r3;
        if (r3 == null) goto L8;
        if (r2 == null) goto L8;
        if (r2.isFragmentLayerRenderOn() == false) goto L8;
        UIBodyView.access$002(this.mBodyView, r2);
        this.mBodyView.setClipChildren(false);
    L8:
        initialize();
        this.mExceptionHandler = new a(this);
    }

    public static /* synthetic */ UIBodyView access$102(UIBody r0, UIBodyView r1) {
        r0.mBodyView = r1;
        return r1;
    }

    public static /* synthetic */ ArrayList access$202(UIBody r0, ArrayList r1) {
        r0.mCreateViewUI = r1;
        return r1;
    }

    public synchronized void attachUIBodyView(UIBodyView r3, LynxContext r4) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.mContext.isEnginePoolEnabled() == false) goto L6;
    L9:
        com.lynx.tasm.base.h<Void> r0 = new com.lynx.tasm.base.h(new b(this, r3, r4), this.mExceptionHandler);     // Catch: Throwable -> L14
        this.mAttachTask = r0;     // Catch: Throwable -> L14
        if (this.mDetachTask != null) goto L12;
        r0.run();     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
        return;
    L6:
        if (this.mBodyView != r3) goto L9;
        monitor-exit(this);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public /* bridge */ /* synthetic */ View createView(Context r1, Object r2) {
        return createView(r1, r2);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public boolean eventThrough(float r10, float r11) {
        boolean r0 = super.eventThrough(r10, r11);
        if (r0 == true) goto L6;
        r0 = r0 | this.mContext.enableEventThrough();
    L6:
        if (this.mEventThroughActiveRegions != null) goto L8;
        return r0;
    L8:
        float r1 = INVOKEVIRTUAL_com_lynx_tasm_behavior_ui_UIBody_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(this.mContext.getResources()).density;
        float r12 = r10 * r1;
        float r13 = r11 * r1;
        int r2 = 0;
        boolean r3 = false;
    L10:
        if (r2 >= this.mEventThroughActiveRegions.size()) goto L28;
        ArrayList r4 = (ArrayList) ListProtector.get(this.mEventThroughActiveRegions, r2);
        if (r4 == null) goto L27;
        if (r4.size() != 4) goto L27;
        float r5 = ((SizeValue) ListProtector.get(r4, 0)).a(getWidth());
        float r6 = ((SizeValue) ListProtector.get(r4, 1)).a(getHeight());
        float r7 = ((SizeValue) ListProtector.get(r4, 2)).a(getWidth()) + r5;
        float r8 = ((SizeValue) ListProtector.get(r4, 3)).a(getHeight()) + r6;
        if (r12 >= r5) goto L18;
    L24:
        r3 = false;
    L25:
        if (r3 == false) goto L27;
        LLog.i(TAG, "hit the event through active regions!");
        goto L28
    L18:
        if (r12 >= r7) goto L24;
        if (r13 < r6) goto L24;
        if (r13 >= r8) goto L24;
        r3 = true;
    L27:
        r2 = r2 + 1;
    L28:
        if (r3 == true) goto L40;
        if (r0 == true) goto L32;
        return true;
    L32:
        return false;
    L40:
        return r0;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public /* bridge */ /* synthetic */ View getOrCreateView(Context r1, Object r2) {
        return getOrCreateView(r1, r2);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public UIBodyView createView(Context r1, Object r2) {
        return this.mBodyView;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public UIBodyView getOrCreateView(Context r1, Object r2) {
        return this.mBodyView;
    }
}
