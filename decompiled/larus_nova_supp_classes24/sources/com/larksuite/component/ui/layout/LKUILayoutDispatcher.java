package com.larksuite.component.ui.layout;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.larksuite.component.ui.layout.plus.BaseInnerPlus;
import com.larksuite.component.ui.layout.plus.InnerPlusType;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\tH\u0016J%\u0010\u0019\u001a\u0002H\u001a\"\b\b\u0000\u0010\u001a*\u00020\f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u001cH\u0016¢\u0006\u0002\u0010\u001dJ \u0010\u001e\u001a\u00020\u000f\"\b\b\u0000\u0010\u001a*\u00020\f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u001cH\u0016J'\u0010\u001f\u001a\u0004\u0018\u0001H\u001a\"\b\b\u0000\u0010\u001a*\u00020\f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u001cH\u0016¢\u0006\u0002\u0010\u001dJ\b\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010*\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010.\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010/\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020,H\u0016J\u0017\u00100\u001a\u0004\u0018\u00010!2\u0006\u00101\u001a\u000202H\u0016¢\u0006\u0002\u00103J\u0017\u00104\u001a\u0004\u0018\u00010!2\u0006\u00101\u001a\u000202H\u0016¢\u0006\u0002\u00103J\u0017\u00105\u001a\u0004\u0018\u00010!2\u0006\u00106\u001a\u000202H\u0016¢\u0006\u0002\u00103J\u0017\u00107\u001a\u0004\u0018\u00010!2\u0006\u00106\u001a\u000202H\u0016¢\u0006\u0002\u00103J\u0017\u00108\u001a\u0004\u0018\u00010!2\u0006\u00106\u001a\u000209H\u0016¢\u0006\u0002\u0010:J\b\u0010;\u001a\u00020\u000fH\u0016J\b\u0010<\u001a\u00020\u000fH\u0016J\b\u0010=\u001a\u00020\u000fH\u0016J\"\u0010>\u001a\u00020\u000f2\u0006\u0010?\u001a\u00020!2\u0006\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J\u0010\u0010D\u001a\u00020\u000f2\u0006\u0010E\u001a\u00020FH\u0016J(\u0010G\u001a\u00020\u000f2\u0006\u0010H\u001a\u00020A2\u0006\u0010I\u001a\u00020A2\u0006\u0010J\u001a\u00020A2\u0006\u0010K\u001a\u00020AH\u0016J\u0010\u0010L\u001a\u00020\u000f2\u0006\u0010M\u001a\u00020CH\u0016J\u0010\u0010N\u001a\u00020\u000f2\u0006\u0010M\u001a\u00020CH\u0016J\b\u0010O\u001a\u00020\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006P"}, d2 = {"Lcom/larksuite/component/ui/layout/LKUILayoutDispatcher;", "Lcom/larksuite/component/ui/layout/ILKUILayout;", "<init>", "()V", "mLayout", "Landroid/view/ViewGroup;", "mContext", "Landroid/content/Context;", "mAttrs", "Landroid/util/AttributeSet;", "mPlusList", "Ljava/util/ArrayList;", "Lcom/larksuite/component/ui/layout/plus/BaseLKUIPlus;", "Lkotlin/collections/ArrayList;", "onConstructor", "", "layout", "context", "attrs", "parseInnerPluses", "array", "Landroid/content/res/TypedArray;", "getLayout", "getLKUIContext", "getAttrs", "registerPlus", "T", "plusClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/larksuite/component/ui/layout/plus/BaseLKUIPlus;", "unRegisterPlus", "getPlus", "hasPlus", "", "onDelegateMeasureStart", "onMeasureData", "Lcom/larksuite/component/ui/layout/OnMeasureData;", "onDelegateMeasureEnd", "onDelegateLayoutStart", "onLayoutData", "Lcom/larksuite/component/ui/layout/OnLayoutData;", "onDelegateLayoutEnd", "onDelegateDrawStart", "canvas", "Landroid/graphics/Canvas;", "onDelegateDrawEnd", "onDelegateDispatchDrawStart", "onDelegateDispatchDrawEnd", "onDelegateDispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "(Landroid/view/MotionEvent;)Ljava/lang/Boolean;", "onDelegateInterceptTouchEvent", "onDelegateTouchEvent", "event", "onDelegateInterceptHoverEvent", "onDelegateDragEvent", "Landroid/view/DragEvent;", "(Landroid/view/DragEvent;)Ljava/lang/Boolean;", "onDelegateAttachedToWindow", "onDelegateDetachedFromWindow", "onDelegateFinishInflate", "onDelegateFocusChanged", "gainFocus", "direction", "", "previouslyFocusedRect", "Landroid/graphics/Rect;", "onDelegateConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDelegateSizeChanged", "w", "h", "oldw", "oldh", "onDelegateSetPaddingStart", "paddingData", "onDelegateSetPaddingEnd", "onDelegateComputeScroll", "suite-ui_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class LKUILayoutDispatcher implements ILKUILayout {
    private AttributeSet mAttrs;
    private Context mContext;
    private ViewGroup mLayout;
    private final ArrayList<com.larksuite.component.ui.layout.plus.a> mPlusList;

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public Context getLKUIContext() {
        Context r0 = this.mContext;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mContext");
        return null;
    L6:
        return r0;
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public ViewGroup getLayout() {
        ViewGroup r0 = this.mLayout;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mLayout");
        return null;
    L6:
        return r0;
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public boolean hasPlus() {
        if (this.mPlusList.size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateAttachedToWindow() {
        Iterator<com.larksuite.component.ui.layout.plus.a> r0 = this.mPlusList.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onDelegateAttachedToWindow();
        goto L4
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateComputeScroll() {
        Iterator<com.larksuite.component.ui.layout.plus.a> r0 = this.mPlusList.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onDelegateComputeScroll();
        goto L4
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateDetachedFromWindow() {
        Iterator<com.larksuite.component.ui.layout.plus.a> r0 = this.mPlusList.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onDelegateDetachedFromWindow();
        goto L4
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateFinishInflate() {
        Iterator<com.larksuite.component.ui.layout.plus.a> r0 = this.mPlusList.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onDelegateFinishInflate();
        goto L4
    }

    public LKUILayoutDispatcher() {
        this.mPlusList = new ArrayList();
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public AttributeSet getAttrs() {
        return this.mAttrs;
    }

    private final void parseInnerPluses(TypedArray r9) {
        int r1 = 0;
        int r10 = r9.getInt(0, InnerPlusType.UNKNOWN.getValue());
        ArrayList<com.larksuite.component.ui.layout.plus.a> r0 = this.mPlusList;
        int r2 = com.larksuite.component.ui.layout.plus.b.a;
        Intrinsics.checkNotNullParameter(this, "layout");
        ArrayList r3 = new ArrayList();
        InnerPlusType[] r4 = InnerPlusType.values();
        int r5 = r4.length;
    L3:
        if (r1 >= r5) goto L10;
        InnerPlusType r6 = r4[r1];
        int r7 = r6.getValue();
        if ((r10 & r7) != r7) goto L9;
        BaseInnerPlus r8 = r6.createPlus(this);
        if (r8 == null) goto L9;
        r3.add(r8);
    L9:
        r1 = r1 + 1;
        goto L3
    L10:
        r0.addAll(r3);
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public <T extends com.larksuite.component.ui.layout.plus.a> T getPlus(Class<T> r4) {
        Intrinsics.checkNotNullParameter(r4, "plusClass");
        Iterator<com.larksuite.component.ui.layout.plus.a> r0 = this.mPlusList.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        T r1 = (T) r0.next();
        if (Intrinsics.areEqual(r1.getClass(), r4) == false) goto L4;
        return r1;
    L8:
        return null;
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateConfigurationChanged(Configuration r3) {
        Intrinsics.checkNotNullParameter(r3, "newConfig");
        Iterator<com.larksuite.component.ui.layout.plus.a> r0 = this.mPlusList.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onDelegateConfigurationChanged(r3);
        goto L4
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateDispatchDrawEnd(Canvas r3) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        Iterator<com.larksuite.component.ui.layout.plus.a> r0 = this.mPlusList.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onDelegateDispatchDrawEnd(r3);
        goto L4
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateDispatchDrawStart(Canvas r3) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        Iterator<com.larksuite.component.ui.layout.plus.a> r0 = this.mPlusList.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onDelegateDispatchDrawStart(r3);
        goto L4
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public Boolean onDelegateDispatchTouchEvent(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "ev");
        Iterator<com.larksuite.component.ui.layout.plus.a> r0 = this.mPlusList.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Boolean r1 = r0.next().onDelegateDispatchTouchEvent(r3);
        if (r1 == null) goto L4;
        return r1;
    L8:
        return null;
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public Boolean onDelegateDragEvent(DragEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        Iterator<com.larksuite.component.ui.layout.plus.a> r0 = this.mPlusList.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Boolean r1 = r0.next().onDelegateDragEvent(r3);
        if (r1 == null) goto L4;
        return r1;
    L8:
        return null;
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateDrawEnd(Canvas r3) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        Iterator<com.larksuite.component.ui.layout.plus.a> r0 = this.mPlusList.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onDelegateDrawEnd(r3);
        goto L4
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateDrawStart(Canvas r3) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        Iterator<com.larksuite.component.ui.layout.plus.a> r0 = this.mPlusList.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onDelegateDrawStart(r3);
        goto L4
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public Boolean onDelegateInterceptHoverEvent(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        Iterator<com.larksuite.component.ui.layout.plus.a> r0 = this.mPlusList.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Boolean r1 = r0.next().onDelegateInterceptHoverEvent(r3);
        if (r1 == null) goto L4;
        return r1;
    L8:
        return null;
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public Boolean onDelegateInterceptTouchEvent(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "ev");
        Iterator<com.larksuite.component.ui.layout.plus.a> r0 = this.mPlusList.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Boolean r1 = r0.next().onDelegateInterceptTouchEvent(r3);
        if (r1 == null) goto L4;
        return r1;
    L8:
        return null;
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateLayoutEnd(c r3) {
        Intrinsics.checkNotNullParameter(r3, "onLayoutData");
        Iterator<com.larksuite.component.ui.layout.plus.a> r0 = this.mPlusList.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onDelegateLayoutEnd(r3);
        goto L4
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateLayoutStart(c r3) {
        Intrinsics.checkNotNullParameter(r3, "onLayoutData");
        Iterator<com.larksuite.component.ui.layout.plus.a> r0 = this.mPlusList.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onDelegateLayoutStart(r3);
        goto L4
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateMeasureEnd(d r3) {
        Intrinsics.checkNotNullParameter(r3, "onMeasureData");
        Iterator<com.larksuite.component.ui.layout.plus.a> r0 = this.mPlusList.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onDelegateMeasureEnd(r3);
        goto L4
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateMeasureStart(d r3) {
        Intrinsics.checkNotNullParameter(r3, "onMeasureData");
        Iterator<com.larksuite.component.ui.layout.plus.a> r0 = this.mPlusList.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onDelegateMeasureStart(r3);
        goto L4
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateSetPaddingEnd(Rect r3) {
        Intrinsics.checkNotNullParameter(r3, "paddingData");
        Iterator<com.larksuite.component.ui.layout.plus.a> r0 = this.mPlusList.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onDelegateSetPaddingEnd(r3);
        goto L4
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateSetPaddingStart(Rect r3) {
        Intrinsics.checkNotNullParameter(r3, "paddingData");
        Iterator<com.larksuite.component.ui.layout.plus.a> r0 = this.mPlusList.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onDelegateSetPaddingStart(r3);
        goto L4
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public Boolean onDelegateTouchEvent(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        Iterator<com.larksuite.component.ui.layout.plus.a> r0 = this.mPlusList.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Boolean r1 = r0.next().onDelegateTouchEvent(r3);
        if (r1 == null) goto L4;
        return r1;
    L8:
        return null;
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public <T extends com.larksuite.component.ui.layout.plus.a> T registerPlus(Class<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "plusClass");
        T r0 = (T) getPlus(r5);
        if (r0 != null) goto L5;
        r0 = r5.getDeclaredConstructor(new Class[]{ILKUILayout.class}).newInstance(new Object[]{this});
        this.mPlusList.add(r0);
    L5:
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public <T extends com.larksuite.component.ui.layout.plus.a> void unRegisterPlus(Class<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "plusClass");
        Iterator<com.larksuite.component.ui.layout.plus.a> r0 = this.mPlusList.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        if (Intrinsics.areEqual(r0.next().getClass(), r3) == false) goto L4;
        r0.remove();
        goto L4
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onConstructor(ViewGroup r3, Context r4, AttributeSet r5) {
        Intrinsics.checkNotNullParameter(r3, "layout");
        Intrinsics.checkNotNullParameter(r4, "context");
        this.mLayout = r3;
        this.mContext = r4;
        this.mAttrs = r5;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mContext");
        r4 = null;
    L5:
        TypedArray r6 = r4.obtainStyledAttributes(r5, new int[]{2130973509}, 0, 0);
        parseInnerPluses(r6);
        r6.recycle();
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateFocusChanged(boolean r3, int r4, Rect r5) {
        Iterator<com.larksuite.component.ui.layout.plus.a> r0 = this.mPlusList.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onDelegateFocusChanged(r3, r4, r5);
        goto L4
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateSizeChanged(int r3, int r4, int r5, int r6) {
        Iterator<com.larksuite.component.ui.layout.plus.a> r0 = this.mPlusList.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onDelegateSizeChanged(r3, r4, r5, r6);
        goto L4
    }
}
