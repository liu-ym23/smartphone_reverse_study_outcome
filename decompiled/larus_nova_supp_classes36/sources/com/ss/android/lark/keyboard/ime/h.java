package com.ss.android.lark.keyboard.ime;

import android.content.Context;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h extends FrameLayout {
    public final ImeWrapper a;
    public boolean b;
    public int c;
    public final b d;

    public static final class a {
    }

    public static final class b implements MessageQueue.IdleHandler {
        public final /* synthetic */ h a;

        public b(h r1) {
            this.a = r1;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            h r0 = this.a;
            r0.b = false;
            r0.measure(View.MeasureSpec.makeMeasureSpec(r0.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(r0.getMeasuredHeight(), 1073741824));
            r0.layout(r0.getLeft(), r0.getTop(), r0.getRight(), r0.getBottom());
            return false;
        }
    }

    static {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Looper.myQueue().removeIdleHandler(this.d);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        super.requestLayout();
        if (isAttachedToWindow() == true) goto L5;
        return;
    L5:
        if (this.a.T() == true) goto L7;
        return;
    L7:
        if (this.b == true) goto L12;
        Log.i("ImePanelContainer", "ImePanelContainer: requestLayout called, but keyboard is in animation. Measure and layout by self");
        this.b = true;
        Looper.myQueue().addIdleHandler(this.d);
        return;
    }

    public final void setExpectHeight(int r2) {
        if (r2 > 0) goto L4;
        return;
    L4:
        if (r2 == this.c) goto L12;
        this.c = r2;
        ViewGroup.LayoutParams r0 = getLayoutParams();
        if (r0 == null) goto L9;
        r0.height = r2;
    L9:
        requestLayout();
        return;
    }

    public h(Context r2, ImeWrapper r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "imeWrapper");
        super(r2);
        this.a = r3;
        this.c = -1;
        this.d = new b(this);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r2, int r3) {
        int r0 = this.c;
        if (r0 <= 0) goto L5;
        r3 = View.MeasureSpec.makeMeasureSpec(r0, 1073741824);
    L5:
        super.onMeasure(r2, r3);
    }
}
