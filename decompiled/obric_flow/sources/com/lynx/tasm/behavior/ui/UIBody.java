package com.lynx.tasm.behavior.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import androidx.annotation.RestrictTo;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.LynxBooleanOption;
import com.lynx.tasm.base.TraceController;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.l0;
import com.lynx.tasm.performance.PerformanceController;
import com.lynx.tasm.performance.longtasktiming.LynxLongTaskMonitor;
import com.lynx.tasm.u0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class UIBody extends UIGroup<UIBodyView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public UIBodyView f10385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public wm.a f10386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HashMap f10387c;
    public com.lynx.tasm.behavior.ui.accessibility.d d;
    public final com.lynx.tasm.base.g e;
    public final s f;

    public static class UIBodyView extends FrameLayout implements a {
        protected com.lynx.tasm.behavior.ui.accessibility.d mA11yWrapper;
        private int mCacheHeight;
        private int mCacheWidth;
        private b mDrawChildHook;
        private boolean mHasMeaningfulLayout;
        private boolean mHasMeaningfulPaint;
        private boolean mHasPendingRequestLayout;
        private ConcurrentHashMap<Integer, dn.f> mImageMap;
        private int mInstanceId;
        private boolean mInterceptRequestLayout;
        private boolean mIsChildLynxPageUI;
        boolean mIsMeaningfulPaintingAreaInvalidate;

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        protected com.lynx.tasm.behavior.i mLynxUIRender;
        private long mMeaningfulPaintTiming;
        private boolean mNeedRemoveExistingViews;
        public int mSign;
        private WeakReference<eo.a> mTimingCollector;
        private ConcurrentHashMap<Integer, View> mViewMap;

        public UIBodyView(Context r5) {
            super(r5);
            this.mViewMap = new ConcurrentHashMap();
            this.mImageMap = new ConcurrentHashMap();
            this.mTimingCollector = new WeakReference(null);
            this.mInstanceId = -1;
            this.mNeedRemoveExistingViews = false;
            this.mIsMeaningfulPaintingAreaInvalidate = false;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public boolean HasPendingRequestLayout() {
            return this.mHasPendingRequestLayout;
        }

        public void bindDrawChildHook(b r5) {
            this.mDrawChildHook = r5;
        }

        public void cacheLayoutInfo(int r5, int r10) {
            this.mCacheWidth = r5;
            this.mCacheHeight = r10;
        }

        public void clearMeaningfulFlag() {
            this.mHasMeaningfulLayout = false;
            this.mHasMeaningfulPaint = false;
            this.mMeaningfulPaintTiming = 0;
        }

        public void clearNodeIndexImageMap() {
            this.mImageMap.clear();
        }

        public boolean containsViewForNodeIndex(int r5) {
            return this.mViewMap.containsKey(Integer.valueOf(r5));
        }

        @Override // android.view.ViewGroup, android.view.View
        public void dispatchDraw(Canvas r11) {
            this.mIsMeaningfulPaintingAreaInvalidate = false;
            eo.a r5 = this.mTimingCollector.get();
            if (r5 == null) goto L5;
            ((PerformanceController) r5).d("drawStart");
        L5:
            boolean r10 = LynxLongTaskMonitor.b("LynxTemplateRender.Draw", this.mInstanceId, getLongTaskMonitorEnabled());
            b r12 = this.mDrawChildHook;
            if (r12 == null) goto L8;
            r12.beforeDispatchDraw(r11);
        L8:
            super.dispatchDraw(r11);
            b r13 = this.mDrawChildHook;
            if (r13 == null) goto L12;
            r13.afterDispatchDraw(r11);
        L12:
            if (this.mHasMeaningfulLayout == true) goto L14;
        L16:
            if (r5 == null) goto L29;
            final PerformanceController r14 = (PerformanceController) r5;
            r14.d("drawEnd");
            if (com.lynx.tasm.utils.j.j() == false) goto L29;
            if (r14.e.isEmpty() == true) goto L29;
            final long r15 = PerformanceController.a();
            if (TraceController.g == false) goto L28;
            Iterator<Object> r16 = r14.e.iterator();
        L26:
            if (r16.hasNext() == false) goto L28;
            r14.f("Timing::Mark", r15, "paintEnd", (String) r16.next());
        L28:
            final JavaOnlyMap r17 = r14.d;
            r14.d = null;
            final JavaOnlyArray r18 = r14.e;
            r14.e = new JavaOnlyArray();
            LynxEventReporter.runOnReportThread(new ao.c(r14, r15, r17, r18));
        L29:
            if (r10 == false) goto L33;
            LynxLongTaskMonitor.a();
            return;
        L33:
            return;
        L14:
            if (this.mHasMeaningfulPaint == true) goto L16;
            TraceEvent.g(1, "FirstMeaningfulPaint");
            this.mMeaningfulPaintTiming = System.currentTimeMillis();
            this.mHasMeaningfulPaint = true;
            goto L16
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchHoverEvent(MotionEvent r5) {
            if (isAccessibilityDisabled() == true) goto L5;
            com.lynx.tasm.behavior.ui.accessibility.d r10 = this.mA11yWrapper;
            if (r10 == null) goto L27;
            if (r10.g() == true) goto L11;
            com.lynx.tasm.behavior.ui.accessibility.d r11 = this.mA11yWrapper;
            if (r11.f10406b == true) goto L21;
            if (r11.f10407c == true) goto L21;
            f r12 = r11.f10412l;
            if (r12 == null) goto L21;
            if (r12.g(r5) == false) goto L21;
            return true;
        L21:
            if (r11.f() == false) goto L27;
            if (r11.f10413m.c(r5) == false) goto L27;
            return true;
        L11:
            return super.dispatchHoverEvent(r5);
        L27:
            return onHoverEvent(r5);
        L5:
            return super.dispatchHoverEvent(r5);
        }

        @Override // android.view.ViewGroup
        public boolean drawChild(Canvas r5, View r10, long r11) {
            b r12 = this.mDrawChildHook;
            if (r12 == null) goto L5;
            Rect r13 = r12.beforeDrawChild(r5, r10, r11);
        L6:
            if (r13 == null) goto L8;
            r5.save();
            r5.clipRect(r13);
            boolean r14 = super.drawChild(r5, r10, r11);
            r5.restore();
        L9:
            b r15 = this.mDrawChildHook;
            if (r15 == null) goto L12;
            r15.afterDrawChild(r5, r10, r11);
        L12:
            return r14;
        L8:
            r14 = super.drawChild(r5, r10, r11);
            goto L9
        L5:
            r13 = null;
            goto L6
        }

        @Override // android.view.ViewGroup
        public int getChildDrawingOrder(int r5, int r10) {
            b r11 = this.mDrawChildHook;
            if (r11 == null) goto L7;
            return r11.getChildDrawingOrder(r5, r10);
        L7:
            return super.getChildDrawingOrder(r5, r10);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public LynxBooleanOption getLongTaskMonitorEnabled() {
            LynxBooleanOption r5 = LynxBooleanOption.f9962a;
            Context r10 = getContext();
            if ((r10 instanceof LynxContext) == true) goto L5;
            return r5;
        L5:
            return ((LynxContext) r10).f10156y;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public com.lynx.tasm.behavior.i getLynxUIRendererInternal() {
            return this.mLynxUIRender;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public l0 getLynxViewBuilder() {
            return null;
        }

        public long getMeaningfulPaintTiming() {
            return this.mMeaningfulPaintTiming;
        }

        public List<p> getMeaningfulPaintingAreas() {
            if ((this.mDrawChildHook instanceof g0) == true) goto L6;
            return null;
        L6:
            ArrayList r5 = new ArrayList();
            ((g0) this.mDrawChildHook).b(0, 0, r5);
            return r5;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public void innerSetMeasuredDimension(int r5, int r10) {
            if (TraceController.g == false) goto L5;
            HashMap r11 = new HashMap();
            r11.put("width", String.valueOf(r5));
            r11.put("height", String.valueOf(r10));
            TraceEvent.h(0, "UIBody.innerSetMeasuredDimension", r11);
        L5:
            setMeasuredDimension(r5, r10);
        }

        public void invalidateMeaningfulPaintingArea() {
            this.mIsMeaningfulPaintingAreaInvalidate = true;
        }

        public boolean isAccessibilityDisabled() {
            return false;
        }

        public boolean isChildLynxPageUI() {
            return this.mIsChildLynxPageUI;
        }

        public boolean isMeaningfulPaintingAreaInvalidate() {
            return this.mIsMeaningfulPaintingAreaInvalidate;
        }

        public void markNeedRemoveExistingViews() {
            this.mNeedRemoveExistingViews = true;
        }

        public void notifyMeaningfulLayout() {
            this.mHasMeaningfulLayout = true;
        }

        public dn.f obtainImageAccordingToNodeIndex(int r5) {
            dn.f r10 = this.mImageMap.get(Integer.valueOf(r5));
            this.mImageMap.remove(Integer.valueOf(r5));
            return r10;
        }

        public View obtainViewAccordingToNodeIndex(int r5) {
            View r10 = this.mViewMap.get(Integer.valueOf(r5));
            this.mViewMap.remove(Integer.valueOf(r5));
            return r10;
        }

        public void onLayoutWhenDetach() {
            b r5 = this.mDrawChildHook;
            if ((r5 instanceof g0) == false) goto L6;
            ((g0) r5).a();
            return;
        }

        public void onMeasureWhenDetach(int r5, int r10) {
            performMeasure(r5, this.mCacheWidth, r10, this.mCacheHeight);
            b r11 = this.mDrawChildHook;
            if ((r11 instanceof g0) == false) goto L6;
            ((g0) r11).e();
            return;
        }

        public void performMeasure(int r5, int r10, int r11, int r12) {
            int r13 = View.MeasureSpec.getMode(r5);
            if (r13 == Integer.MIN_VALUE) goto L7;
            if (r13 == 0) goto L7;
            int r14 = View.MeasureSpec.getSize(r5);
        L8:
            int r15 = View.MeasureSpec.getMode(r11);
            if (r15 == Integer.MIN_VALUE) goto L13;
            if (r15 == 0) goto L13;
            int r16 = View.MeasureSpec.getSize(r11);
        L14:
            innerSetMeasuredDimension(r14, r16);
            return;
        L13:
            r16 = this.mCacheHeight;
        L7:
            r14 = this.mCacheWidth;
            goto L8
        }

        public void registerImageAccordingToNodeIndex(int r5, dn.f r10) {
            this.mImageMap.put(Integer.valueOf(r5), r10);
        }

        public void registerViewAccordingToNodeIndex(int r5, View r10) {
            this.mViewMap.put(Integer.valueOf(r5), r10);
        }

        public void removeExistingViews() {
            if (this.mNeedRemoveExistingViews == true) goto L5;
            return;
        L5:
            Iterator<Map.Entry<Integer, View>> r5 = this.mViewMap.entrySet().iterator();
        L7:
            if (r5.hasNext() == false) goto L11;
            View r10 = r5.next().getValue();
            if ((r10.getParent() instanceof ViewGroup) == false) goto L7;
            ((ViewGroup) r10.getParent()).removeView(r10);
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

        @Override // android.view.ViewGroup, android.view.ViewParent
        public boolean requestSendAccessibilityEvent(View r5, AccessibilityEvent r10) {
            if (isAccessibilityDisabled() == true) goto L5;
            com.lynx.tasm.behavior.ui.accessibility.d r11 = this.mA11yWrapper;
            if (r11 == null) goto L14;
            if (r11.g() == true) goto L14;
            if (r10.getEventType() != 2048) goto L14;
            r10.setSource(this);
        L14:
            return super.requestSendAccessibilityEvent(r5, r10);
        L5:
            return super.requestSendAccessibilityEvent(r5, r10);
        }

        public abstract void runOnTasmThread(Runnable r5);

        public void setAttachLynxPageUICallback(u r5) {
        }

        @Override // android.view.ViewGroup
        public void setChildrenDrawingOrderEnabled(boolean r5) {
            super.setChildrenDrawingOrderEnabled(r5);
        }

        public void setInstanceId(int r5) {
            this.mInstanceId = r5;
        }

        public void setIsChildLynxPageUI(boolean r5) {
            this.mIsChildLynxPageUI = r5;
        }

        public void setLynxAccessibilityWrapper(com.lynx.tasm.behavior.ui.accessibility.d r5) {
            this.mA11yWrapper = r5;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public void setLynxUIRendererInternal(com.lynx.tasm.behavior.i r5) {
            this.mLynxUIRender = r5;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public void setShouldInterceptRequestLayout(boolean r5) {
            this.mInterceptRequestLayout = r5;
        }

        public void setTimingCollector(eo.a r5) {
            this.mTimingCollector = new WeakReference(r5);
        }

        public UIBodyView(Context r5, AttributeSet r10) {
            super(r5, r10);
            this.mViewMap = new ConcurrentHashMap();
            this.mImageMap = new ConcurrentHashMap();
            this.mTimingCollector = new WeakReference(null);
            this.mInstanceId = -1;
            this.mNeedRemoveExistingViews = false;
            this.mIsMeaningfulPaintingAreaInvalidate = false;
        }
    }

    public UIBody(com.lynx.tasm.b0 r5, UIBodyView r10) {
        super(r5, null);
        this.e = null;
        this.f = null;
        this.f10385a = r10;
        initialize();
        this.f = new s(this);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r5, Object r10) {
        return this.f10385a;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void createViewAsync() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void detachWithViewInfo(g0 r5) {
        g0 r10 = this.mViewInfo;
        if (r10 == null) goto L5;
        r5 = r10;
    L5:
        super.detachWithViewInfo(r5);
        this.f10385a = null;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final void ensureCreateView() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, wm.a
    public final boolean eventThrough(float r11, float r12) {
        boolean r5 = super.eventThrough(r11, r12);
        if (r5 == true) goto L10;
        u0 r10 = this.mContext.K;
        if (r10 == null) goto L7;
        boolean r13 = r10.f10968b;
    L8:
        r5 = r5 | r13;
        goto L10
    L7:
        r13 = false;
    L10:
        if (this.mEventThroughActiveRegions == null) goto L33;
        float r14 = this.mContext.getResources().getDisplayMetrics().density;
        float r15 = r11 * r14;
        float r16 = r12 * r14;
        int r17 = 0;
        boolean r18 = false;
    L14:
        if (r17 >= this.mEventThroughActiveRegions.size()) goto L32;
        ArrayList<com.lynx.tasm.utils.i> r19 = this.mEventThroughActiveRegions.get(r17);
        if (r19 == null) goto L31;
        if (r19.size() != 4) goto L31;
        float r20 = r19.get(0).a(getWidth());
        float r21 = r19.get(1).a(getHeight());
        float r22 = r19.get(2).a(getWidth()) + r20;
        float r23 = r19.get(3).a(getHeight()) + r21;
        if (r15 >= r20) goto L22;
    L28:
        r18 = false;
    L29:
        if (r18 == false) goto L31;
        LynxLog.b(2, "UIBody", "hit the event through active regions!");
        goto L32
    L22:
        if (r15 >= r22) goto L28;
        if (r16 < r21) goto L28;
        if (r16 >= r23) goto L28;
        r18 = true;
    L31:
        r17 = r17 + 1;
    L32:
        if (r18 == true) goto L33;
        if (r5 == true) goto L36;
        return true;
    L36:
        return false;
    L33:
        return r5;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, wm.a
    public final HashMap getChildrenLynxPageUI() {
        return this.f10387c;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View getOrCreateView(Context r5, Object r10) {
        return this.f10385a;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, wm.a
    public final wm.a getParentLynxPageUI() {
        return this.f10386b;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final View getRealParentView() {
        return this.f10385a;
    }

    public final void i() {
        this.mContext.getClass();
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void initialize() {
        super.initialize();
        UIBodyView r5 = this.f10385a;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.isAccessibilityDisabled() == false) goto L8;
        return;
    L8:
        if (this.d != null) goto L10;
        this.d = new com.lynx.tasm.behavior.ui.accessibility.d(this);
    L10:
        this.mAccessibilityElementStatus = 1;
        r5.setLynxAccessibilityWrapper(this.d);
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onAttach() {
        this.mContext.getClass();
        super.onAttach();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutUpdated() {
        super.onLayoutUpdated();
        UIBodyView r5 = this.f10385a;
        if (r5 == null) goto L6;
        r5.notifyMeaningfulLayout();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void registerViewAccordingToNodeIndex() {
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final void removeAll() {
        super.removeAll();
        UIBodyView r5 = this.f10385a;
        if (r5 == null) goto L6;
        r5.clearMeaningfulFlag();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setChildrenLynxPageUI(HashMap r5) {
        this.f10387c = r5;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setParentLynxPageUI(wm.a r5) {
        this.f10386b = r5;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r5) {
        return this.f10385a;
    }
}
