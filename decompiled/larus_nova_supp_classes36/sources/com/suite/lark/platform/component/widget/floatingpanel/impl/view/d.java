package com.suite.lark.platform.component.widget.floatingpanel.impl.view;

import android.content.Context;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.ss.android.lark.log.Log;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d extends ViewGroup implements MessageQueue.IdleHandler {
    public String a;
    public Function0<? extends View> b;

    public static final class a {
    }

    static {
    }

    public final boolean b() {
        if (getChildCount() != 0) goto L11;
        Function0<? extends View> r0 = this.b;
        if (r0 == null) goto L8;
        a((View) r0.invoke());
        return true;
    L8:
        Log.w("FloatingCardWrapperView", "lazyCard is not set");
        return false;
    L11:
        return false;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public final boolean queueIdle() {
        b();
        return false;
    }

    public final String getCardId() {
        return this.a;
    }

    public d(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, null, 0);
        setId(View.generateViewId());
    }

    private final void setLazyCard(Function0<? extends View> r2) {
        if (this.b == null) goto L5;
        return;
    L5:
        this.b = r2;
    }

    public final void a(View r4) {
        Intrinsics.checkNotNullParameter(r4, "cardView");
        if (r4.getParent() == null) goto L14;
        if (Intrinsics.areEqual(r4.getParent(), this) == false) goto L7;
        return;
    L7:
        ViewParent r0 = r4.getParent();
        if ((r0 instanceof ViewGroup) == false) goto L10;
        ViewGroup r1 = (ViewGroup) r0;
    L11:
        if (r1 == null) goto L14;
        r1.removeView(r4);
        goto L14
    L10:
        r1 = null;
    L14:
        if (r4.getLayoutParams() != null) goto L16;
        r4.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    L16:
        addView(r4);
    }

    public final void setCardId(String r1) {
        this.a = r1;
    }

    public final void c(Function0<? extends View> r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "lazyCard");
        setLazyCard(r2);
        if (r3 == false) goto L6;
        Looper.myQueue().addIdleHandler(this);
        return;
    }

    @Override // android.view.View
    public final void onMeasure(int r4, int r5) {
        int r0 = View.MeasureSpec.getSize(r4);
        if (getChildCount() != 0) goto L6;
        setMeasuredDimension(r0, 0);
        return;
    L6:
        View r1 = getChildAt(0);
        measureChild(r1, r4, r5);
        setMeasuredDimension(r0, r1.getMeasuredHeight());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        if (getChildCount() != 0) goto L5;
        return;
    L5:
        View r6 = getChildAt(0);
        r6.layout(0, getHeight() - r6.getMeasuredHeight(), r6.getMeasuredWidth(), getHeight());
    }
}
