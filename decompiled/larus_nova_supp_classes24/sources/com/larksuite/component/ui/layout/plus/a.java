package com.larksuite.component.ui.layout.plus;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.larksuite.component.ui.layout.ILKUILayout;
import com.larksuite.component.ui.layout.c;
import com.larksuite.component.ui.layout.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class a {
    private final /* synthetic */ com.larksuite.component.ui.layout.a $$delegate_0;
    private final ILKUILayout mLayout;

    public void onDelegateAttachedToWindow() {
        this.$$delegate_0.getClass();
    }

    public void onDelegateComputeScroll() {
        this.$$delegate_0.getClass();
    }

    public void onDelegateDetachedFromWindow() {
        this.$$delegate_0.getClass();
    }

    public void onDelegateFinishInflate() {
        this.$$delegate_0.getClass();
    }

    public void onDelegateFocusChanged(boolean r1, int r2, Rect r3) {
        this.$$delegate_0.getClass();
    }

    public void onDelegateSizeChanged(int r1, int r2, int r3, int r4) {
        this.$$delegate_0.getClass();
    }

    public final AttributeSet getAttrs() {
        return this.mLayout.getAttrs();
    }

    public final Context getContext() {
        return this.mLayout.getLKUIContext();
    }

    public final ViewGroup getLayout() {
        return this.mLayout.getLayout();
    }

    public a(ILKUILayout r2) {
        Intrinsics.checkNotNullParameter(r2, "layout");
        this.$$delegate_0 = new com.larksuite.component.ui.layout.a();
        this.mLayout = r2;
    }

    public void onDelegateConfigurationChanged(Configuration r3) {
        Intrinsics.checkNotNullParameter(r3, "newConfig");
        this.$$delegate_0.getClass();
        Intrinsics.checkNotNullParameter(r3, "newConfig");
    }

    public void onDelegateDispatchDrawEnd(Canvas r3) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        this.$$delegate_0.getClass();
        Intrinsics.checkNotNullParameter(r3, "canvas");
    }

    public void onDelegateDispatchDrawStart(Canvas r3) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        this.$$delegate_0.getClass();
        Intrinsics.checkNotNullParameter(r3, "canvas");
    }

    public Boolean onDelegateDispatchTouchEvent(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "ev");
        this.$$delegate_0.getClass();
        Intrinsics.checkNotNullParameter(r3, "ev");
        return null;
    }

    public Boolean onDelegateDragEvent(DragEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        this.$$delegate_0.getClass();
        Intrinsics.checkNotNullParameter(r3, "event");
        return null;
    }

    public void onDelegateDrawEnd(Canvas r3) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        this.$$delegate_0.getClass();
        Intrinsics.checkNotNullParameter(r3, "canvas");
    }

    public void onDelegateDrawStart(Canvas r3) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        this.$$delegate_0.getClass();
        Intrinsics.checkNotNullParameter(r3, "canvas");
    }

    public Boolean onDelegateInterceptHoverEvent(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        this.$$delegate_0.getClass();
        Intrinsics.checkNotNullParameter(r3, "event");
        return null;
    }

    public Boolean onDelegateInterceptTouchEvent(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "ev");
        this.$$delegate_0.getClass();
        Intrinsics.checkNotNullParameter(r3, "ev");
        return null;
    }

    public void onDelegateLayoutEnd(c r3) {
        Intrinsics.checkNotNullParameter(r3, "onLayoutData");
        this.$$delegate_0.getClass();
        Intrinsics.checkNotNullParameter(r3, "onLayoutData");
    }

    public void onDelegateLayoutStart(c r3) {
        Intrinsics.checkNotNullParameter(r3, "onLayoutData");
        this.$$delegate_0.getClass();
        Intrinsics.checkNotNullParameter(r3, "onLayoutData");
    }

    public void onDelegateMeasureEnd(d r3) {
        Intrinsics.checkNotNullParameter(r3, "onMeasureData");
        this.$$delegate_0.getClass();
        Intrinsics.checkNotNullParameter(r3, "onMeasureData");
    }

    public void onDelegateMeasureStart(d r3) {
        Intrinsics.checkNotNullParameter(r3, "onMeasureData");
        this.$$delegate_0.getClass();
        Intrinsics.checkNotNullParameter(r3, "onMeasureData");
    }

    public void onDelegateSetPaddingEnd(Rect r3) {
        Intrinsics.checkNotNullParameter(r3, "paddingData");
        this.$$delegate_0.getClass();
        Intrinsics.checkNotNullParameter(r3, "paddingData");
    }

    public void onDelegateSetPaddingStart(Rect r3) {
        Intrinsics.checkNotNullParameter(r3, "paddingData");
        this.$$delegate_0.getClass();
        Intrinsics.checkNotNullParameter(r3, "paddingData");
    }

    public Boolean onDelegateTouchEvent(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        this.$$delegate_0.getClass();
        Intrinsics.checkNotNullParameter(r3, "event");
        return null;
    }
}
