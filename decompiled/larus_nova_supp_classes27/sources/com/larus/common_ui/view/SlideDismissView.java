package com.larus.common_ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/larus/common_ui/view/SlideDismissView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "touchSlop", "dismissOffset", "", "startX", "startY", "dismissCallback", "Lkotlin/Function0;", "", "getDismissCallback", "()Lkotlin/jvm/functions/Function0;", "setDismissCallback", "(Lkotlin/jvm/functions/Function0;)V", "onInterceptTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SlideDismissView extends LinearLayout {
    public final int a;
    public final float b;
    public float c;
    public float d;
    public Function0<Unit> e;

    public SlideDismissView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SlideDismissView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final Function0<Unit> getDismissCallback() {
        return this.e;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r7) {
        Intrinsics.checkNotNullParameter(r7, "ev");
        int r0 = r7.getActionMasked();
        if (r0 != 0) goto L5;
        this.c = r7.getX();
        this.d = r7.getY();
        getParent().requestDisallowInterceptTouchEvent(true);
    L24:
        return super.onInterceptTouchEvent(r7);
    L5:
        if (r0 != 1) goto L7;
    L21:
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L24
    L7:
        if (r0 != 2) goto L9;
        float r1 = r7.getX() - this.c;
        float r3 = r7.getY() - this.d;
        if (Math.abs(r3) > this.a) goto L14;
    L16:
        boolean r2 = false;
    L17:
        if (r2 == false) goto L20;
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    L20:
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L24
    L14:
        if (Math.abs(r3) <= Math.abs(r1)) goto L16;
        r2 = true;
        goto L17
    L9:
        if (r0 == 3) goto L21;
        goto L21
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r7) {
        Intrinsics.checkNotNullParameter(r7, "ev");
        if (r7.getActionMasked() != 2) goto L21;
        float r0 = r7.getX() - this.c;
        float r1 = r7.getY() - this.d;
        if (Math.abs(r1) > this.a) goto L7;
    L13:
        boolean r2 = false;
    L14:
        if (r2 == false) goto L19;
        Function0<Unit> r8 = this.e;
        if (r8 == null) goto L18;
        r8.invoke();
    L18:
        return true;
    L19:
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L21
    L7:
        if (Math.abs(r1) <= this.b) goto L13;
        if (Math.abs(r1) <= Math.abs(r0)) goto L13;
        if (r1 <= 0.0f) goto L13;
        r2 = true;
    L21:
        return super.onTouchEvent(r7);
    }

    public final void setDismissCallback(Function0<Unit> r1) {
        this.e = r1;
    }

    public SlideDismissView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = ViewConfiguration.get(r2).getScaledTouchSlop();
        this.b = 150.0f;
    }

    public /* synthetic */ SlideDismissView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
