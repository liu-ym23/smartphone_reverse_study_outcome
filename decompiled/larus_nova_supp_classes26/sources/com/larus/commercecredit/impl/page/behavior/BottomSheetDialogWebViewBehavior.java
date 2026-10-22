package com.larus.commercecredit.impl.page.behavior;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001d*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u001dB\u001d\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0011\u001a\u00020\u0002H\u0002J%\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0002\u0010\u0018J%\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u001bH\u0016¢\u0006\u0002\u0010\u001cR\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/larus/commercecredit/impl/page/behavior/BottomSheetDialogWebViewBehavior;", "V", "Landroid/view/View;", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "webViewRef", "Ljava/lang/ref/WeakReference;", "Landroid/webkit/WebView;", "initialX", "", "initialY", "findWebView", "parent", "onLayoutChild", "", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "child", "layoutDirection", "", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;I)Z", "onInterceptTouchEvent", "event", "Landroid/view/MotionEvent;", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/MotionEvent;)Z", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BottomSheetDialogWebViewBehavior<V extends View> extends BottomSheetBehavior<V> {
    public static final /* synthetic */ int d = 0;
    public WeakReference<WebView> a;
    public float b;
    public float c;

    public static final class a {
    }

    static {
    }

    public BottomSheetDialogWebViewBehavior(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }

    public final boolean onInterceptTouchEvent(CoordinatorLayout r5, V r6, MotionEvent r7) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        Intrinsics.checkNotNullParameter(r6, "child");
        Intrinsics.checkNotNullParameter(r7, "event");
        WeakReference<WebView> r0 = this.a;
        if (r0 == null) goto L30;
        WebView r1 = r0.get();
        if (r1 == null) goto L30;
        int r2 = r7.getActionMasked();
        if (r2 != 0) goto L10;
        this.b = r7.getX();
        this.c = r7.getY();
    L28:
        return super.onInterceptTouchEvent(r5, r6, r7);
    L10:
        if (r2 != 1) goto L12;
    L25:
        this.b = 0.0f;
        this.c = 0.0f;
        goto L28
    L12:
        if (r2 == 2) goto L17;
        if (r2 == 3) goto L25;
    L17:
        if (Math.abs(r7.getX() - this.b) <= Math.abs(r7.getY() - this.c)) goto L19;
        return false;
    L19:
        Object r3 = r1.getTag(2131388155);
        if (r3 != null) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(r3, Boolean.TRUE) == true) goto L24;
        return false;
    L24:
        return super.onInterceptTouchEvent(r5, r6, r7);
    L30:
        return super.onInterceptTouchEvent(r5, r6, r7);
    }

    public final boolean onLayoutChild(CoordinatorLayout r4, V r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r5, "child");
        boolean r7 = super.onLayoutChild(r4, r5, r6);
        ArrayDeque r0 = new ArrayDeque();
        r0.add(r5);
    L4:
        if ((!r0.isEmpty()) == false) goto L14;
        View r8 = (View) r0.removeFirst();
        if ((r8 instanceof WebView) == true) goto L7;
        if ((r8 instanceof ViewGroup) == false) goto L4;
        ViewGroup r9 = (ViewGroup) r8;
        IntIterator r1 = RangesKt.until(0, r9.getChildCount()).iterator();
    L12:
        if (r1.hasNext() == false) goto L4;
        r0.add(r9.getChildAt(r1.nextInt()));
        goto L12
    L7:
        WebView r10 = (WebView) r8;
    L15:
        this.a = new WeakReference(r10);
        return r7;
    L14:
        r10 = null;
        goto L15
    }
}
