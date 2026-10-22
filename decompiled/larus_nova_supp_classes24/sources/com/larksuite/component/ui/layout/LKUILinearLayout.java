package com.larksuite.component.ui.layout;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u000bB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\fJ\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bH\u0014J0\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\bH\u0014J\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 H\u0014J\u0010\u0010!\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 H\u0014J\u0010\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020$H\u0016J\u0010\u0010(\u001a\u00020\u00192\u0006\u0010'\u001a\u00020$H\u0016J\u0010\u0010)\u001a\u00020\u00192\u0006\u0010'\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u0014H\u0014J\b\u0010,\u001a\u00020\u0014H\u0014J\b\u0010-\u001a\u00020\u0014H\u0014J\"\u0010.\u001a\u00020\u00142\u0006\u0010/\u001a\u00020\u00192\u0006\u00100\u001a\u00020\b2\b\u00101\u001a\u0004\u0018\u00010\u0012H\u0014J\u0010\u00102\u001a\u00020\u00142\u0006\u00103\u001a\u000204H\u0014J(\u00105\u001a\u00020\u00142\u0006\u00106\u001a\u00020\b2\u0006\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\bH\u0014J(\u0010:\u001a\u00020\u00142\u0006\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020\b2\u0006\u0010=\u001a\u00020\b2\u0006\u0010>\u001a\u00020\bH\u0016J\b\u0010?\u001a\u00020\u0014H\u0016J\u000b\u0010@\u001a\u0004\u0018\u00010\u0006H\u0096\u0001J\t\u0010A\u001a\u00020\u0004H\u0096\u0001J\t\u0010B\u001a\u00020CH\u0096\u0001J(\u0010D\u001a\u0004\u0018\u0001HE\"\b\b\u0000\u0010E*\u00020F2\f\u0010G\u001a\b\u0012\u0004\u0012\u0002HE0HH\u0096\u0001¢\u0006\u0002\u0010IJ\t\u0010J\u001a\u00020\u0019H\u0096\u0001J#\u0010K\u001a\u00020\u00142\u0006\u0010L\u001a\u00020C2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0096\u0001J\t\u0010M\u001a\u00020\u0014H\u0096\u0001J\t\u0010N\u001a\u00020\u0014H\u0096\u0001J\u0011\u0010O\u001a\u00020\u00142\u0006\u00103\u001a\u000204H\u0096\u0001J\t\u0010P\u001a\u00020\u0014H\u0096\u0001J\u0011\u0010Q\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 H\u0096\u0001J\u0011\u0010R\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 H\u0096\u0001J\u0018\u0010S\u001a\u0004\u0018\u00010\u00192\u0006\u0010#\u001a\u00020$H\u0096\u0001¢\u0006\u0002\u0010TJ\u0018\u0010U\u001a\u0004\u0018\u00010\u00192\u0006\u0010'\u001a\u00020*H\u0096\u0001¢\u0006\u0002\u0010VJ\u0011\u0010W\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 H\u0096\u0001J\u0011\u0010X\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 H\u0096\u0001J\t\u0010Y\u001a\u00020\u0014H\u0096\u0001J#\u0010Z\u001a\u00020\u00142\u0006\u0010/\u001a\u00020\u00192\u0006\u00100\u001a\u00020\b2\b\u00101\u001a\u0004\u0018\u00010\u0012H\u0096\u0001J\u0018\u0010[\u001a\u0004\u0018\u00010\u00192\u0006\u0010'\u001a\u00020$H\u0096\u0001¢\u0006\u0002\u0010TJ\u0018\u0010\\\u001a\u0004\u0018\u00010\u00192\u0006\u0010#\u001a\u00020$H\u0096\u0001¢\u0006\u0002\u0010TJ\u0011\u0010]\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0010H\u0096\u0001J\u0011\u0010^\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0010H\u0096\u0001J\u0011\u0010_\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0001J\u0011\u0010`\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0001J\u0011\u0010a\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0096\u0001J\u0011\u0010b\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0096\u0001J)\u0010c\u001a\u00020\u00142\u0006\u00106\u001a\u00020\b2\u0006\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\bH\u0096\u0001J\u0018\u0010d\u001a\u0004\u0018\u00010\u00192\u0006\u0010'\u001a\u00020$H\u0096\u0001¢\u0006\u0002\u0010TJ&\u0010e\u001a\u0002HE\"\b\b\u0000\u0010E*\u00020F2\f\u0010G\u001a\b\u0012\u0004\u0012\u0002HE0HH\u0096\u0001¢\u0006\u0002\u0010IJ!\u0010f\u001a\u00020\u0014\"\b\b\u0000\u0010E*\u00020F2\f\u0010G\u001a\b\u0012\u0004\u0012\u0002HE0HH\u0096\u0001R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006g"}, d2 = {"Lcom/larksuite/component/ui/layout/LKUILinearLayout;", "Landroid/widget/LinearLayout;", "Lcom/larksuite/component/ui/layout/ILKUILayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onMeasureData", "Lcom/larksuite/component/ui/layout/OnMeasureData;", "onLayoutData", "Lcom/larksuite/component/ui/layout/OnLayoutData;", "paddingData", "Landroid/graphics/Rect;", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onLayout", "changed", "", "l", "t", "r", "b", "onDraw", "canvas", "Landroid/graphics/Canvas;", "dispatchDraw", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "onInterceptTouchEvent", "onTouchEvent", "event", "onInterceptHoverEvent", "onDragEvent", "Landroid/view/DragEvent;", "onAttachedToWindow", "onDetachedFromWindow", "onFinishInflate", "onFocusChanged", "gainFocus", "direction", "previouslyFocusedRect", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onSizeChanged", "w", "h", "oldw", "oldh", "setPadding", "left", "top", "right", "bottom", "computeScroll", "getAttrs", "getLKUIContext", "getLayout", "Landroid/view/ViewGroup;", "getPlus", "T", "Lcom/larksuite/component/ui/layout/plus/BaseLKUIPlus;", "plusClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/larksuite/component/ui/layout/plus/BaseLKUIPlus;", "hasPlus", "onConstructor", "layout", "onDelegateAttachedToWindow", "onDelegateComputeScroll", "onDelegateConfigurationChanged", "onDelegateDetachedFromWindow", "onDelegateDispatchDrawEnd", "onDelegateDispatchDrawStart", "onDelegateDispatchTouchEvent", "(Landroid/view/MotionEvent;)Ljava/lang/Boolean;", "onDelegateDragEvent", "(Landroid/view/DragEvent;)Ljava/lang/Boolean;", "onDelegateDrawEnd", "onDelegateDrawStart", "onDelegateFinishInflate", "onDelegateFocusChanged", "onDelegateInterceptHoverEvent", "onDelegateInterceptTouchEvent", "onDelegateLayoutEnd", "onDelegateLayoutStart", "onDelegateMeasureEnd", "onDelegateMeasureStart", "onDelegateSetPaddingEnd", "onDelegateSetPaddingStart", "onDelegateSizeChanged", "onDelegateTouchEvent", "registerPlus", "unRegisterPlus", "suite-ui_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class LKUILinearLayout extends LinearLayout implements ILKUILayout {
    private final /* synthetic */ LKUILayoutDispatcher $$delegate_0;
    private final c onLayoutData;
    private final d onMeasureData;
    private final Rect paddingData;

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public AttributeSet getAttrs() {
        return this.$$delegate_0.getAttrs();
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public Context getLKUIContext() {
        return this.$$delegate_0.getLKUIContext();
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public ViewGroup getLayout() {
        return this.$$delegate_0.getLayout();
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public <T extends com.larksuite.component.ui.layout.plus.a> T getPlus(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "plusClass");
        return (T) this.$$delegate_0.getPlus(r2);
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public boolean hasPlus() {
        return this.$$delegate_0.hasPlus();
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onConstructor(ViewGroup r2, Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r2, "layout");
        Intrinsics.checkNotNullParameter(r3, "context");
        this.$$delegate_0.onConstructor(r2, r3, r4);
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateAttachedToWindow() {
        this.$$delegate_0.onDelegateAttachedToWindow();
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateComputeScroll() {
        this.$$delegate_0.onDelegateComputeScroll();
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        this.$$delegate_0.onDelegateConfigurationChanged(r2);
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateDetachedFromWindow() {
        this.$$delegate_0.onDelegateDetachedFromWindow();
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateDispatchDrawEnd(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        this.$$delegate_0.onDelegateDispatchDrawEnd(r2);
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateDispatchDrawStart(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        this.$$delegate_0.onDelegateDispatchDrawStart(r2);
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public Boolean onDelegateDispatchTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "ev");
        return this.$$delegate_0.onDelegateDispatchTouchEvent(r2);
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public Boolean onDelegateDragEvent(DragEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        return this.$$delegate_0.onDelegateDragEvent(r2);
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateDrawEnd(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        this.$$delegate_0.onDelegateDrawEnd(r2);
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateDrawStart(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        this.$$delegate_0.onDelegateDrawStart(r2);
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateFinishInflate() {
        this.$$delegate_0.onDelegateFinishInflate();
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateFocusChanged(boolean r2, int r3, Rect r4) {
        this.$$delegate_0.onDelegateFocusChanged(r2, r3, r4);
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public Boolean onDelegateInterceptHoverEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        return this.$$delegate_0.onDelegateInterceptHoverEvent(r2);
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public Boolean onDelegateInterceptTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "ev");
        return this.$$delegate_0.onDelegateInterceptTouchEvent(r2);
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateLayoutEnd(c r2) {
        Intrinsics.checkNotNullParameter(r2, "onLayoutData");
        this.$$delegate_0.onDelegateLayoutEnd(r2);
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateLayoutStart(c r2) {
        Intrinsics.checkNotNullParameter(r2, "onLayoutData");
        this.$$delegate_0.onDelegateLayoutStart(r2);
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateMeasureEnd(d r2) {
        Intrinsics.checkNotNullParameter(r2, "onMeasureData");
        this.$$delegate_0.onDelegateMeasureEnd(r2);
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateMeasureStart(d r2) {
        Intrinsics.checkNotNullParameter(r2, "onMeasureData");
        this.$$delegate_0.onDelegateMeasureStart(r2);
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateSetPaddingEnd(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "paddingData");
        this.$$delegate_0.onDelegateSetPaddingEnd(r2);
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateSetPaddingStart(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "paddingData");
        this.$$delegate_0.onDelegateSetPaddingStart(r2);
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateSizeChanged(int r2, int r3, int r4, int r5) {
        this.$$delegate_0.onDelegateSizeChanged(r2, r3, r4, r5);
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public Boolean onDelegateTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        return this.$$delegate_0.onDelegateTouchEvent(r2);
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public <T extends com.larksuite.component.ui.layout.plus.a> T registerPlus(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "plusClass");
        return (T) this.$$delegate_0.registerPlus(r2);
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public <T extends com.larksuite.component.ui.layout.plus.a> void unRegisterPlus(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "plusClass");
        this.$$delegate_0.unRegisterPlus(r2);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (hasPlus() == true) goto L6;
        super.computeScroll();
        return;
    L6:
        super.computeScroll();
        onDelegateComputeScroll();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        if (hasPlus() == true) goto L6;
        super.onAttachedToWindow();
        return;
    L6:
        super.onAttachedToWindow();
        onDelegateAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        if (hasPlus() == true) goto L6;
        super.onDetachedFromWindow();
        return;
    L6:
        super.onDetachedFromWindow();
        onDelegateDetachedFromWindow();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        if (hasPlus() == true) goto L6;
        super.onFinishInflate();
        return;
    L6:
        super.onFinishInflate();
        onDelegateFinishInflate();
    }

    public LKUILinearLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        if (hasPlus() == true) goto L6;
        super.dispatchDraw(r2);
        return;
    L6:
        onDelegateDispatchDrawStart(r2);
        super.dispatchDraw(r2);
        onDelegateDispatchDrawEnd(r2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "ev");
        if (hasPlus() == false) goto L5;
        Boolean r0 = onDelegateDispatchTouchEvent(r2);
        if (r0 == null) goto L10;
        return r0.booleanValue();
    L10:
        return super.dispatchTouchEvent(r2);
    L5:
        return super.dispatchTouchEvent(r2);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        if (hasPlus() == true) goto L6;
        super.onConfigurationChanged(r2);
        return;
    L6:
        super.onConfigurationChanged(r2);
        onDelegateConfigurationChanged(r2);
    }

    @Override // android.view.View
    public boolean onDragEvent(DragEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (hasPlus() == false) goto L5;
        Boolean r0 = onDelegateDragEvent(r2);
        if (r0 == null) goto L10;
        return r0.booleanValue();
    L10:
        return super.onDragEvent(r2);
    L5:
        return super.onDragEvent(r2);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        if (hasPlus() == true) goto L6;
        super.onDraw(r2);
        return;
    L6:
        onDelegateDrawStart(r2);
        super.onDraw(r2);
        onDelegateDrawEnd(r2);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptHoverEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (hasPlus() == false) goto L5;
        Boolean r0 = onDelegateInterceptHoverEvent(r2);
        if (r0 == null) goto L10;
        return r0.booleanValue();
    L10:
        return super.onInterceptHoverEvent(r2);
    L5:
        return super.onInterceptHoverEvent(r2);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "ev");
        if (hasPlus() == false) goto L5;
        Boolean r0 = onDelegateInterceptTouchEvent(r2);
        if (r0 == null) goto L10;
        return r0.booleanValue();
    L10:
        return super.onInterceptTouchEvent(r2);
    L5:
        return super.onInterceptTouchEvent(r2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (hasPlus() == false) goto L5;
        Boolean r0 = onDelegateTouchEvent(r2);
        if (r0 == null) goto L10;
        return r0.booleanValue();
    L10:
        return super.onTouchEvent(r2);
    L5:
        return super.onTouchEvent(r2);
    }

    public LKUILinearLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r2, int r3) {
        if (hasPlus() == true) goto L6;
        super.onMeasure(r2, r3);
        return;
    L6:
        d r0 = this.onMeasureData;
        r0.a = r2;
        r0.b = r3;
        onDelegateMeasureStart(r0);
        d r4 = this.onMeasureData;
        super.onMeasure(r4.a, r4.b);
        onDelegateMeasureEnd(this.onMeasureData);
    }

    public LKUILinearLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.$$delegate_0 = new LKUILayoutDispatcher();
        this.onMeasureData = new d();
        this.onLayoutData = new c();
        this.paddingData = new Rect(0, 0, 0, 0);
        onConstructor(this, r2, r3);
    }

    @Override // android.view.View
    public void onFocusChanged(boolean r2, int r3, Rect r4) {
        if (hasPlus() == true) goto L6;
        super.onFocusChanged(r2, r3, r4);
        return;
    L6:
        super.onFocusChanged(r2, r3, r4);
        onDelegateFocusChanged(r2, r3, r4);
    }

    @Override // android.view.View
    public void onSizeChanged(int r2, int r3, int r4, int r5) {
        if (hasPlus() == true) goto L6;
        super.onSizeChanged(r2, r3, r4, r5);
        return;
    L6:
        super.onSizeChanged(r2, r3, r4, r5);
        onDelegateSizeChanged(r2, r3, r4, r5);
    }

    @Override // android.view.View
    public void setPadding(int r2, int r3, int r4, int r5) {
        if (hasPlus() == true) goto L6;
        super.setPadding(r2, r3, r4, r5);
        return;
    L6:
        Rect r0 = this.paddingData;
        r0.left = r2;
        r0.top = r3;
        r0.right = r4;
        r0.bottom = r5;
        onDelegateSetPaddingStart(r0);
        Rect r6 = this.paddingData;
        super.setPadding(r6.left, r6.top, r6.right, r6.bottom);
        onDelegateSetPaddingEnd(this.paddingData);
    }

    public /* synthetic */ LKUILinearLayout(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r7, int r8, int r9, int r10, int r11) {
        if (hasPlus() == true) goto L6;
        super.onLayout(r7, r8, r9, r10, r11);
        return;
    L6:
        c r0 = this.onLayoutData;
        r0.a = r7;
        r0.b = r8;
        r0.c = r9;
        r0.d = r10;
        r0.e = r11;
        onDelegateLayoutStart(r0);
        c r12 = this.onLayoutData;
        super.onLayout(r12.a, r12.b, r12.c, r12.d, r12.e);
        onDelegateLayoutEnd(this.onLayoutData);
    }
}
