package com.bytedance.android.ec.core.sku;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.anniex.base.depend.DeviceDepend;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u001c\u0010\u0013\u001a\u00020\u00042\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0010¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/ec/core/sku/CommonMarqueeView;", "Landroid/widget/FrameLayout;", "", "delay", "", "setStartDelay", "", "interval", "setInterval", "scrollDuration", "setScrollDuration", "spacing", "setItemSpacing", "", DeviceDepend.FoldType.VERTICAL, "setOrientation", "Lkotlin/Function1;", "Landroid/view/View;", "listener", "setOnViewExposedListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonMarqueeView extends FrameLayout {
    public boolean a;
    public int b;
    public int c;
    public int d;
    public float e;
    public Function1<? super View, Unit> f;
    public boolean g;
    public int h;
    public final Handler i;
    public final a j;

    public static final class a implements Runnable {
        public final /* synthetic */ CommonMarqueeView a;

        @Override // java.lang.Runnable
        public final void run() {
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
            CommonMarqueeView.a(this.a);     // Catch: Throwable -> L4
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
        L6:
            CommonMarqueeView r1 = this.a;     // Catch: Throwable -> L8
            r1.i.postDelayed(this, r1.d);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L12;
            return;
        L12:
            throw th;
        L4:
            th = move-exception;
            Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L8
            Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L8
            goto L6
        }

        public a(CommonMarqueeView r1) {
            this.a = r1;
        }
    }

    public CommonMarqueeView(Context r10) {
        AttributeSet r11 = null;
        this(r10, r11, 6, 0);
    }

    public CommonMarqueeView(Context r10, AttributeSet r11) {
        this(r10, r11, 4, 0);
    }

    public final void d() {
        this.i.removeCallbacks(this.j);
        this.g = false;
    }

    public final void b() {
        Iterator r0 = com.bytedance.commerce.base.view.b.a(this).iterator();
        int r10 = 0;
    L4:
        if (r0.hasNext() == false) goto L16;
        Object r11 = r0.next();
        int r12 = r10 + 1;
        if (r10 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        View r13 = (View) r11;
        int r14 = this.h;
        if (r10 != r14) goto L11;
    L14:
        r13.setVisibility(0);
        r13.setTranslationY(0.0f);
    L15:
        r10 = r12;
        goto L4
    L11:
        if (r10 == (r14 % getChildCount())) goto L14;
        r13.setVisibility(8);
        goto L15
    }

    public final void c() {
        if (getChildCount() > 1) goto L5;
        return;
    L5:
        if (this.g == true) goto L9;
        this.g = true;
        b();
        this.i.postDelayed(this.j, (long) this.e);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d();
    }

    public static final void a(CommonMarqueeView r11) {
        if (r11.getChildCount() <= 1) goto L32;
        int r0 = (r11.h + 1) % r11.getChildCount();
        View r10 = r11.getChildAt(r11.h % r11.getChildCount());
        View r12 = r11.getChildAt(r0);
        if (r11.a == true) goto L7;
    L9:
        Iterator r13 = com.bytedance.commerce.base.view.b.a(r11).iterator();
        int r14 = 0;
    L11:
        if (r13.hasNext() == false) goto L23;
        Object r15 = r13.next();
        int r16 = r14 + 1;
        if (r14 >= 0) goto L15;
        CollectionsKt.throwIndexOverflow();
    L15:
        View r17 = (View) r15;
        int r18 = r11.h;
        if (r14 != r18) goto L18;
    L21:
        r17.setVisibility(0);
    L22:
        r14 = r16;
        goto L11
    L18:
        if (r14 == ((r18 + 1) % r11.getChildCount())) goto L21;
        r17.setVisibility(8);
        goto L22
    L23:
        int[] r19 = new int[2];
        r19[0] = 0;
        if (r11.a == false) goto L26;
        int r20 = r10.getHeight();
    L27:
        r19[1] = r20 + r11.b;
        ValueAnimator r1 = ValueAnimator.ofInt(r19);
        r1.addListener(new com.bytedance.android.ec.core.sku.a(r11, r0));
        r1.setDuration(r11.c);
        r1.addUpdateListener(new b(r11, r10, r12));
        r1.start();
        return;
    L26:
        r20 = r10.getWidth();
        goto L27
    L7:
        if (r10.getTop() == 0) goto L9;
        r10.setTranslationY(0.0f);
        goto L9
    }

    public final void setInterval(int r1) {
        this.d = r1;
    }

    public final void setItemSpacing(int r1) {
        this.b = r1;
    }

    public final void setOnViewExposedListener(Function1<? super View, Unit> r1) {
        this.f = r1;
    }

    public final void setOrientation(boolean r1) {
        this.a = r1;
    }

    public final void setScrollDuration(int r1) {
        this.c = r1;
    }

    public final void setStartDelay(float r1) {
        this.e = r1;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r10, int r11) {
        int r0 = getChildCount();
        int r1 = 0;
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r1 >= r0) goto L5;
        View r14 = getChildAt(r1);
        measureChild(r14, r10, r11);
        r12 = Math.max(r12, r14.getMeasuredWidth());
        r13 = Math.max(r13, r14.getMeasuredHeight());
        r1 = r1 + 1;
        goto L3
    L5:
        setMeasuredDimension(r12 + (getPaddingLeft() + getPaddingRight()), r13 + (getPaddingTop() + getPaddingBottom()));
    }

    public CommonMarqueeView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.a = true;
        this.b = 20;
        this.c = 400;
        this.d = 3000;
        this.e = 3000.0f;
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.i = new Handler(Looper.getMainLooper());
        this.j = new a(this);
    }

    public /* synthetic */ CommonMarqueeView(Context r1, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r1, r10, 0);
    }
}
