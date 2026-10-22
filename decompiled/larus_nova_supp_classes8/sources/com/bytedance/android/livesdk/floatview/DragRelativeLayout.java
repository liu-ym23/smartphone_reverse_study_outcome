package com.bytedance.android.livesdk.floatview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.customview.widget.ViewDragHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\bB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/floatview/DragRelativeLayout;", "Landroid/widget/RelativeLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DragRelativeLayout extends RelativeLayout {
    public ViewDragHelper a;
    public View b;
    public boolean c;
    public boolean d;
    public ViewDragHelper.Callback e;

    public static final class a {
    }

    static {
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.b = getChildAt(0);
    }

    public final boolean a(MotionEvent r8) {
        Intrinsics.checkNotNullParameter(r8, "event");
        View r0 = this.b;
        if (r0 == null) goto L5;
        int r1 = r0.getLeft();
    L6:
        View r2 = this.b;
        if (r2 == null) goto L9;
        int r3 = r2.getTop();
    L10:
        View r4 = this.b;
        if (r4 == null) goto L13;
        int r5 = r4.getRight();
    L14:
        View r6 = this.b;
        if (r6 == null) goto L17;
        int r7 = r6.getBottom();
    L19:
        if (r8.getX() >= r1) goto L21;
    L27:
        boolean r9 = false;
    L28:
        if (r9 == true) goto L30;
        return false;
    L30:
        if (this.d == false) goto L34;
        return true;
    L34:
        return false;
    L21:
        if (r8.getX() > r5) goto L27;
        if (r8.getY() < r3) goto L27;
        if (r8.getY() > r7) goto L27;
        r9 = true;
        goto L28
    L17:
        r7 = 0;
        goto L19
    L13:
        r5 = 0;
        goto L14
    L9:
        r3 = 0;
        goto L10
    L5:
        r1 = 0;
        goto L6
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        boolean r0 = a(r2);
        this.c = r0;
        if (r0 == false) goto L9;
        ViewDragHelper r1 = this.a;
        if (r1 != null) goto L10;
        return false;
    L10:
        return r1.shouldInterceptTouchEvent(r2);
    L9:
        return super.onInterceptTouchEvent(r2);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (this.c == false) goto L12;
        ViewDragHelper r0 = this.a;     // Catch: IllegalArgumentException -> L8
        if (r0 == null) goto L10;
        r0.processTouchEvent(r2);     // Catch: IllegalArgumentException -> L8
    L10:
        return true;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    L12:
        return super.onTouchEvent(r2);
    }

    public DragRelativeLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3);
        this.a = ViewDragHelper.create(this, 1.0f, new DragRelativeLayout$initDragHelper$1(this));
    }
}
