package com.bytedance.android.livesdk.interactivity.api;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011B\u001b\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0010\u0010\u0014B#\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0015\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0016J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\n¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/DragContainer;", "Landroid/widget/FrameLayout;", BuildConfig.FLAVOR, "Ld42/d;", "dragParentView", BuildConfig.FLAVOR, "setDragParentView", BuildConfig.FLAVOR, "enable", "setEnableDrag", BuildConfig.FLAVOR, "getMaxWidth", "maxWidth", "setMaxWidth", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DragContainer extends FrameLayout {
    public int a;
    public d42.d b;
    public float c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public final int l;
    public boolean m;
    public boolean n;

    public final int getMaxWidth() {
        return this.a;
    }

    public DragContainer(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.m = true;
        this.l = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        if (this.m == false) goto L5;
        int r0 = r5.getAction();
        if (r0 != 0) goto L9;
        this.c = getTranslationX();
        this.d = getTranslationY();
        this.e = r5.getRawX();
        float r1 = r5.getRawY();
        this.f = r1;
        this.g = this.e;
        this.h = r1;
    L45:
        return super.dispatchTouchEvent(r5);
    L9:
        if (r0 == 1) goto L38;
        if (r0 != 2) goto L13;
        this.k = Math.abs(r5.getRawX() - this.g);
        float r2 = Math.abs(r5.getRawY() - this.h);
        float r3 = this.k;
        float r4 = this.l;
        if (r3 <= r4) goto L24;
    L25:
        requestDisallowInterceptTouchEvent(true);
        this.n = true;
        this.i = r5.getRawX() - this.e;
        this.j = r5.getRawY() - this.f;
        d42.d r6 = this.b;
        if (r6 != null) goto L28;
    L35:
        if (this.n == false) goto L45;
        return true;
    L28:
        if (r6.e(getX() + this.i, getWidth()) == false) goto L31;
        this.e = r5.getRawX();
        setX(getX() + this.i);
    L31:
        if (r6.i(getY() + this.j, getHeight()) == false) goto L33;
        this.f = r5.getRawY();
        setY(getY() + this.j);
    L33:
        r6.g(this);
        goto L35
    L24:
        if (r2 <= r4) goto L35;
    L13:
        if (r0 != 3) goto L45;
        if (this.n == false) goto L45;
        requestDisallowInterceptTouchEvent(false);
        this.n = false;
        d42.d r7 = this.b;
        if (r7 == null) goto L20;
        r7.c(this);
    L20:
        return true;
    L38:
        if (this.n == false) goto L45;
        requestDisallowInterceptTouchEvent(false);
        this.n = false;
        d42.d r8 = this.b;
        if (r8 == null) goto L42;
        r8.f(this);
    L42:
        return true;
    L5:
        return super.dispatchTouchEvent(r5);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r1) {
        return this.m;
    }

    public void setDragParentView(d42.d r1) {
        this.b = r1;
    }

    public void setEnableDrag(boolean r1) {
        this.m = r1;
    }

    public final void setMaxWidth(int r1) {
        this.a = r1;
    }

    public DragContainer(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, 0);
        this.m = true;
        this.l = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r3, int r4) {
        int r0 = View.MeasureSpec.getMode(r3);
        int r5 = View.MeasureSpec.getSize(r3);
        int r1 = this.a;
        if (r1 <= 0) goto L5;
        r5 = Math.min(r5, r1);
    L5:
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r5, r0), r4);
    }

    public DragContainer(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.m = true;
        this.l = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }
}
