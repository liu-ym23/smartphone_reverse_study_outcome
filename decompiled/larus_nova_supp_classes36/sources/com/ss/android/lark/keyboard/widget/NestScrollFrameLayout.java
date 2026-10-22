package com.ss.android.lark.keyboard.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\u000bJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\rJ\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/keyboard/widget/NestScrollFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "targetView", "Landroid/view/ViewGroup;", "getTargetView", "()Landroid/view/ViewGroup;", "setTargetView", "(Landroid/view/ViewGroup;)V", "startX", "startY", "attach", "", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "keyboard-base_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class NestScrollFrameLayout extends FrameLayout {
    public ViewGroup a;
    public int b;
    public int c;

    public final ViewGroup getTargetView() {
        return this.a;
    }

    public NestScrollFrameLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r5) {
        if (r5 == null) goto L23;
        int r0 = r5.getAction();
        if (r0 == 0) goto L19;
        if (r0 != 1) goto L7;
    L16:
        ViewGroup r1 = this.a;
        if (r1 == null) goto L23;
        r1.requestDisallowInterceptTouchEvent(false);
        goto L23
    L7:
        if (r0 != 2) goto L9;
        int r2 = (int) r5.getX();
        int r3 = (int) r5.getY();
        if (Math.abs(r2 - this.b) <= Math.abs(r3 - this.c)) goto L23;
        ViewGroup r4 = this.a;
        if (r4 == null) goto L23;
        r4.requestDisallowInterceptTouchEvent(true);
        goto L23
    L9:
        if (r0 == 3) goto L16;
    L19:
        this.b = (int) r5.getX();
        this.c = (int) r5.getY();
        ViewGroup r6 = this.a;
        if (r6 == null) goto L23;
        r6.requestDisallowInterceptTouchEvent(true);
    L23:
        return super.dispatchTouchEvent(r5);
    }

    public final void setTargetView(ViewGroup r1) {
        this.a = r1;
    }

    public NestScrollFrameLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, -1);
    }

    public NestScrollFrameLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = -1;
        this.c = -1;
    }
}
