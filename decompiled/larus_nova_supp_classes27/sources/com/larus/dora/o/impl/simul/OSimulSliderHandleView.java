package com.larus.dora.o.impl.simul;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010!\u001a\u00020\fH\u0016J\u0010\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R(\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR(\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/larus/dora/o/impl/simul/OSimulSliderHandleView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "touchSlop", "isDragging", "", "downRawY", "", "onDragStart", "Lkotlin/Function0;", "", "getOnDragStart", "()Lkotlin/jvm/functions/Function0;", "setOnDragStart", "(Lkotlin/jvm/functions/Function0;)V", "onDrag", "Lkotlin/Function1;", "getOnDrag", "()Lkotlin/jvm/functions/Function1;", "setOnDrag", "(Lkotlin/jvm/functions/Function1;)V", "onDragEnd", "getOnDragEnd", "setOnDragEnd", "barView", "Landroid/view/View;", "performClick", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "dp", "value", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OSimulSliderHandleView extends FrameLayout {
    public final int a;
    public boolean b;
    public float c;
    public Function0<Unit> d;
    public Function1<? super Float, Unit> e;
    public Function1<? super Float, Unit> f;
    public final View g;

    public OSimulSliderHandleView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public OSimulSliderHandleView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // android.view.View
    public final boolean performClick() {
        super.performClick();
        return true;
    }

    public final Function1<Float, Unit> getOnDrag() {
        return this.e;
    }

    public final Function1<Float, Unit> getOnDragEnd() {
        return this.f;
    }

    public final Function0<Unit> getOnDragStart() {
        return this.d;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        int r0 = r5.getActionMasked();
        if (r0 == 0) goto L38;
        if (r0 != 1) goto L6;
        ViewParent r1 = getParent();
        if (r1 == null) goto L31;
        r1.requestDisallowInterceptTouchEvent(false);
    L31:
        if (this.b == false) goto L35;
        Function1<? super Float, Unit> r2 = this.f;
        if (r2 == null) goto L36;
        r2.invoke(Float.valueOf(r5.getRawY() - this.c));
    L36:
        this.g.setPressed(false);
        this.b = false;
        return true;
    L35:
        super.performClick();
        goto L36
    L6:
        if (r0 != 2) goto L8;
        float r6 = r5.getRawY() - this.c;
        if (this.b == true) goto L22;
        if (Math.abs(r6) <= this.a) goto L22;
        this.b = true;
    L22:
        if (this.b == false) goto L26;
        Function1<? super Float, Unit> r3 = this.e;
        if (r3 == null) goto L26;
        r3.invoke(Float.valueOf(r6));
    L26:
        return true;
    L8:
        if (r0 != 3) goto L10;
        ViewParent r7 = getParent();
        if (r7 == null) goto L14;
        r7.requestDisallowInterceptTouchEvent(false);
    L14:
        this.g.setPressed(false);
        this.b = false;
        return true;
    L10:
        return super.onTouchEvent(r5);
    L38:
        this.c = r5.getRawY();
        this.g.setPressed(true);
        this.b = false;
        ViewParent r8 = getParent();
        if (r8 == null) goto L41;
        r8.requestDisallowInterceptTouchEvent(true);
    L41:
        Function0<Unit> r9 = this.d;
        if (r9 == null) goto L44;
        r9.invoke();
    L44:
        return true;
    }

    public final void setOnDrag(Function1<? super Float, Unit> r1) {
        this.e = r1;
    }

    public final void setOnDragEnd(Function1<? super Float, Unit> r1) {
        this.f = r1;
    }

    public final void setOnDragStart(Function0<Unit> r1) {
        this.d = r1;
    }

    public OSimulSliderHandleView(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        this.a = ViewConfiguration.get(r4).getScaledTouchSlop();
        View r7 = new View(r4);
        r7.setBackgroundResource(2131233941);
        this.g = r7;
        setClickable(true);
        setFocusable(true);
        Resources r8 = getResources();
        int r9 = (int) ((WindowDisplayMetricsOverride.apply(r8, r8.getDisplayMetrics()).density * 36) + 0.5f);
        Resources r1 = getResources();
        addView(r7, new FrameLayout.LayoutParams(r9, (int) ((WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()).density * 8) + 0.5f), 17));
    }

    public /* synthetic */ OSimulSliderHandleView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
