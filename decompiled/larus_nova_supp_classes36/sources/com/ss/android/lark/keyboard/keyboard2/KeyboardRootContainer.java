package com.ss.android.lark.keyboard.keyboard2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u000e\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fJ\u0018\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007H\u0014J\r\u0010\u0018\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u0019J\u0012\u0010\u001a\u001a\u00020\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/keyboard/keyboard2/KeyboardRootContainer;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "lastX", "", "lastY", "interceptClick", "", "touchSlop", "lastWidthMeasureSpec", "lastHeightMeasureSpec", "", "intercept", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "reMeasure", "reMeasure$keyboard_base_release", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "keyboard-base_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class KeyboardRootContainer extends FrameLayout {
    public float a;
    public float b;
    public boolean c;
    public final int d;
    public int e;
    public int f;

    public KeyboardRootContainer(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 0, 14);
    }

    public KeyboardRootContainer(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 12);
    }

    public KeyboardRootContainer(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, r4, 8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r8) {
        if (r8 == null) goto L4;
        Integer r0 = Integer.valueOf(r8.getActionMasked());
    L5:
        if (r0 != null) goto L8;
    L10:
        if (r0 != null) goto L13;
    L21:
        return super.dispatchTouchEvent(r8);
    L13:
        if (r0.intValue() != 1) goto L21;
        double r5 = 2;
        float r1 = ((float) Math.pow(r8.getRawX() - this.a, r5)) + ((float) Math.pow(r8.getRawY() - this.b, r5));
        if (this.c == false) goto L21;
        int r2 = this.d;
        if (r1 >= (r2 * r2)) goto L21;
        Log.i("keyboard", "KeyboardRootContainer: intercept click");
        this.a = 0.0f;
        this.b = 0.0f;
        MotionEvent r9 = MotionEvent.obtain(r8);
        r9.setAction(3);
        super.dispatchTouchEvent(r9);
        return true;
    L8:
        if (r0.intValue() != 0) goto L10;
        this.a = r8.getRawX();
        this.b = r8.getRawY();
        goto L21
    L4:
        r0 = null;
        goto L5
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        this.e = r1;
        this.f = r2;
    }

    public KeyboardRootContainer(Context r2, AttributeSet r3, int r4, int r5) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4, 0);
        this.d = ViewConfiguration.get(r2).getScaledTouchSlop() * 3;
    }
}
