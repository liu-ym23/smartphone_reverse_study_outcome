package com.larksuite.component.ui.layout;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\b\u0010\n\u001a\u00020\u0005H&J\b\u0010\u000b\u001a\u00020\u0007H&J\n\u0010\f\u001a\u0004\u0018\u00010\tH&J%\u0010\r\u001a\u0002H\u000e\"\b\b\u0000\u0010\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0011H&¢\u0006\u0002\u0010\u0012J \u0010\u0013\u001a\u00020\u0003\"\b\b\u0000\u0010\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0011H&J'\u0010\u0014\u001a\u0004\u0018\u0001H\u000e\"\b\b\u0000\u0010\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0011H&¢\u0006\u0002\u0010\u0012J\b\u0010\u0015\u001a\u00020\u0016H&¨\u0006\u0017"}, d2 = {"Lcom/larksuite/component/ui/layout/ILKUILayout;", "Lcom/larksuite/component/ui/layout/ILKUIDelegate;", "onConstructor", "", "layout", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "getLayout", "getLKUIContext", "getAttrs", "registerPlus", "T", "Lcom/larksuite/component/ui/layout/plus/BaseLKUIPlus;", "plusClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/larksuite/component/ui/layout/plus/BaseLKUIPlus;", "unRegisterPlus", "getPlus", "hasPlus", "", "suite-ui_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public interface ILKUILayout {
    AttributeSet getAttrs();

    Context getLKUIContext();

    ViewGroup getLayout();

    <T extends com.larksuite.component.ui.layout.plus.a> T getPlus(Class<T> r1);

    boolean hasPlus();

    void onConstructor(ViewGroup r1, Context r2, AttributeSet r3);

    /* synthetic */ void onDelegateAttachedToWindow();

    /* synthetic */ void onDelegateComputeScroll();

    /* synthetic */ void onDelegateConfigurationChanged(Configuration r1);

    /* synthetic */ void onDelegateDetachedFromWindow();

    /* synthetic */ void onDelegateDispatchDrawEnd(Canvas r1);

    /* synthetic */ void onDelegateDispatchDrawStart(Canvas r1);

    /* synthetic */ Boolean onDelegateDispatchTouchEvent(MotionEvent r1);

    /* synthetic */ Boolean onDelegateDragEvent(DragEvent r1);

    /* synthetic */ void onDelegateDrawEnd(Canvas r1);

    /* synthetic */ void onDelegateDrawStart(Canvas r1);

    /* synthetic */ void onDelegateFinishInflate();

    /* synthetic */ void onDelegateFocusChanged(boolean r1, int r2, Rect r3);

    /* synthetic */ Boolean onDelegateInterceptHoverEvent(MotionEvent r1);

    /* synthetic */ Boolean onDelegateInterceptTouchEvent(MotionEvent r1);

    /* synthetic */ void onDelegateLayoutEnd(c r1);

    /* synthetic */ void onDelegateLayoutStart(c r1);

    /* synthetic */ void onDelegateMeasureEnd(d r1);

    /* synthetic */ void onDelegateMeasureStart(d r1);

    /* synthetic */ void onDelegateSetPaddingEnd(Rect r1);

    /* synthetic */ void onDelegateSetPaddingStart(Rect r1);

    /* synthetic */ void onDelegateSizeChanged(int r1, int r2, int r3, int r4);

    /* synthetic */ Boolean onDelegateTouchEvent(MotionEvent r1);

    <T extends com.larksuite.component.ui.layout.plus.a> T registerPlus(Class<T> r1);

    <T extends com.larksuite.component.ui.layout.plus.a> void unRegisterPlus(Class<T> r1);
}
