package com.larus.business.floatchat.impl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/business/floatchat/impl/TouchDelegateFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "activeTouchDelegate", "Landroid/view/TouchDelegate;", "onInterceptTouchEvent", "", "event", "Landroid/view/MotionEvent;", "onTouchEvent", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TouchDelegateFrameLayout extends FrameLayout {
    public TouchDelegate a;

    public TouchDelegateFrameLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public TouchDelegateFrameLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        if (r4.getActionMasked() != 0) goto L13;
        TouchDelegate r0 = null;
        this.a = null;
        TouchDelegate r1 = getTouchDelegate();
        if (r1 == null) goto L13;
        if (r1.onTouchEvent(r4) == false) goto L9;
        r0 = r1;
    L9:
        if (r0 == null) goto L13;
        this.a = r0;
        return true;
    L13:
        return super.onInterceptTouchEvent(r4);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        TouchDelegate r0 = this.a;
        if (r0 != null) goto L7;
        return super.onTouchEvent(r3);
    L7:
        if (r3.getActionMasked() == 0) goto L10;
        r0.onTouchEvent(r3);
    L10:
        if (r3.getActionMasked() != 1) goto L12;
    L13:
        this.a = null;
    L14:
        return true;
    L12:
        if (r3.getActionMasked() != 3) goto L14;
        goto L13
    }

    public TouchDelegateFrameLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ TouchDelegateFrameLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
