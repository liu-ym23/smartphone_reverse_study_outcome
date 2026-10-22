package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cB\u001b\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001b\u0010\u001fR\u001f\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/LiveGiftViewPager;", "Landroidx/viewpager/widget/ViewPager;", "Landroid/view/ViewConfiguration;", "kotlin.jvm.PlatformType", "g", "Landroid/view/ViewConfiguration;", "getConfiguration", "()Landroid/view/ViewConfiguration;", "configuration", BuildConfig.FLAVOR, "h", "I", "getTouchSlop", "()I", "setTouchSlop", "(I)V", "touchSlop", BuildConfig.FLAVOR, "i", "D", "getScrollAngle", "()D", "setScrollAngle", "(D)V", "scrollAngle", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveGiftViewPager extends ViewPager {
    public float a;
    public float b;
    public float c;
    public float d;
    public final int e;
    public int f;
    public final ViewConfiguration g;
    public int h;
    public double i;

    public final ViewConfiguration getConfiguration() {
        return this.g;
    }

    public final double getScrollAngle() {
        return this.i;
    }

    public final int getTouchSlop() {
        return this.h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LiveGiftViewPager(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.e = -1;
        this.f = -1;
        ViewConfiguration r4 = ViewConfiguration.get(getContext());
        this.g = r4;
        this.h = r4.getScaledPagingTouchSlop();
        this.i = -1.0d;
        this.i = ((Number) nz1.a.Z.getValue(null, nz1.a.a[50])).doubleValue();
    }

    public final boolean onInterceptTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "ev");
        int r0 = r10.getAction() & 255;
        if (r0 != 3) goto L5;
    L28:
        return false;
    L5:
        if (r0 == 1) goto L28;
        if (r0 != 0) goto L9;
        this.a = r10.getX();
        this.b = r10.getX();
        this.c = r10.getY();
        this.d = r10.getY();
        this.f = r10.getPointerId(0);
        return super.onInterceptTouchEvent(r10);
    L9:
        if (r0 != 2) goto L11;
        int r1 = this.f;
        if (r1 != this.e) goto L15;
        return false;
    L15:
        int r2 = r10.findPointerIndex(r1);
        float r3 = r10.getX(r2) - this.a;
        float r4 = Math.abs(r3);
        float r5 = r10.getY(r2);
        float r6 = Math.abs(r5 - this.d);
        if (r4 > this.h) goto L18;
    L25:
        return false;
    L18:
        if ((((double) r4) * Math.tan(Math.toRadians(this.i))) <= r6) goto L25;
        if (r3 <= 0) goto L22;
        float r7 = this.b + this.h;
    L23:
        this.a = r7;
        this.c = r5;
        return super.onInterceptTouchEvent(r10);
    L22:
        r7 = this.b - this.h;
        goto L23
    L11:
        return super.onInterceptTouchEvent(r10);
    }

    public final boolean onTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "ev");
        int r0 = r10.getAction() & 255;
        if (r0 != 0) goto L5;
        this.a = r10.getX();
        this.b = r10.getX();
        this.c = r10.getY();
        this.d = r10.getY();
        this.f = r10.getPointerId(0);
        return super.onTouchEvent(r10);
    L5:
        if (r0 != 2) goto L7;
        int r1 = r10.findPointerIndex(this.f);
        if (r1 != (-1)) goto L11;
        return false;
    L11:
        float r2 = r10.getX(r1);
        float r3 = Math.abs(r2 - this.a);
        float r4 = r10.getY(r1);
        float r5 = Math.abs(r4 - this.c);
        if (r3 <= this.h) goto L22;
        if ((((double) r3) * Math.tan(Math.toRadians(this.i))) <= r5) goto L22;
        float r6 = this.b;
        if ((r2 - r6) <= 0) goto L18;
        float r7 = r6 + this.h;
    L19:
        this.a = r7;
        this.c = r4;
        return super.onTouchEvent(r10);
    L18:
        r7 = r6 - this.h;
    L22:
        return super.onTouchEvent(r10);
    L7:
        return super.onTouchEvent(r10);
    }

    public final void setScrollAngle(double r1) {
        this.i = r1;
    }

    public final void setTouchSlop(int r1) {
        this.h = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LiveGiftViewPager(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.e = -1;
        this.f = -1;
        ViewConfiguration r4 = ViewConfiguration.get(getContext());
        this.g = r4;
        this.h = r4.getScaledPagingTouchSlop();
        this.i = -1.0d;
        this.i = ((Number) nz1.a.Z.getValue(null, nz1.a.a[50])).doubleValue();
    }
}
