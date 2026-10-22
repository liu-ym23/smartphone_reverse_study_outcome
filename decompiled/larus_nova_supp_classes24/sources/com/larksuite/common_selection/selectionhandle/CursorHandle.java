package com.larksuite.common_selection.selectionhandle;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.larksuite.common_selection.SelectionContainer;
import com.larksuite.common_selection.o;
import com.larksuite.common_selection.t;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ly7.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nJ\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nH\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J \u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0018\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020!H\u0016J\b\u0010%\u001a\u00020!H\u0016J\u0010\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020(H\u0014J\u0010\u0010)\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/larksuite/common_selection/selectionhandle/CursorHandle;", "Landroidx/appcompat/widget/AppCompatImageView;", "Lcom/larksuite/common_selection/selectionhandle/ISelectionHandle;", "context", "Landroid/content/Context;", "handleType", "Lcom/larksuite/common_selection/selectionhandle/SelectionHandleType;", "<init>", "(Landroid/content/Context;Lcom/larksuite/common_selection/selectionhandle/SelectionHandleType;)V", "handleColor", "", "containerLocation", "", "isGhost", "", "setHandleColor", "", "color", "dpToPx", "dp", "getView", "Landroid/view/View;", "updateSize", "point", "Lcom/larksuite/common_selection/SelectionPoint;", "strategyRegistry", "Lcom/larksuite/common_selection/SelectionStrategyRegistry;", "position", "container", "Landroid/widget/FrameLayout;", "screenPoint", "Landroid/graphics/Point;", "angle", "", "getLogicalTouchPoint", "rawX", "rawY", "getOffsetForMagnifier", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setIsGhost", "common-selection_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CursorHandle extends AppCompatImageView implements c {
    public final SelectionHandleType a;
    public boolean b;

    @Override // ly7.c
    public final void e(o r2, t r3) {
        Intrinsics.checkNotNullParameter(r2, "point");
        Intrinsics.checkNotNullParameter(r3, "strategyRegistry");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ly7.c
    public View getView() {
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ly7.c
    public float getOffsetForMagnifier() {
        return getHeight() * 0.4f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int j(int r3) {
        Resources r0 = getResources();
        return (int) (r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        if (this.b == false) goto L5;
        return;
    L5:
        super/*android.widget.ImageView*/.onDraw(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setHandleColor(int r3) {
        Drawable r0 = getDrawable();
        if (r0 == null) goto L7;
        Drawable r1 = r0.mutate();
        if (r1 == null) goto L7;
        r1.setTint(r3);
    L7:
        setImageDrawable(r0);
    }

    public void setIsGhost(boolean r1) {
        this.b = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CursorHandle(Context r3, SelectionHandleType r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "handleType");
        super(r3);
        this.a = r4;
        if (r4 != SelectionHandleType.START) goto L5;
        int r5 = 2131248387;
    L6:
        Drawable r6 = ContextCompat.getDrawable(r3, r5);
        if (r6 == null) goto L11;
        Drawable r7 = r6.mutate();
        if (r7 == null) goto L11;
        r7.setTint(-16776961);
    L11:
        setImageDrawable(r6);
        setPadding(j(5), j(5), 0, j(10));
        setLayerType(2, null);
        setHasTransientState(true);
        return;
    L5:
        r5 = 2131248391;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ly7.c
    public final Point h(float r5, float r6) {
        float r7 = r6 - (getHeight() * 0.75f);
        float r0 = getWidth() * 0.2f;
        if (this.a != SelectionHandleType.START) goto L5;
        float r8 = (r5 + (getWidth() / 2.0f)) - r0;
    L7:
        return new Point((int) r8, (int) r7);
    L5:
        r8 = (r5 - (getWidth() / 2.0f)) + r0;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ly7.c
    public final void k(SelectionContainer r6, Point r7, float r8) {
        Intrinsics.checkNotNullParameter(r6, "container");
        Intrinsics.checkNotNullParameter(r7, "screenPoint");
        int r9 = r7.x;
        int r10 = r7.y;
        if (getMeasuredWidth() != 0) goto L5;
        measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    L5:
        setRotation(r8);
        int r0 = getMeasuredWidth();
        double r1 = Math.toRadians(r8);
        float r11 = r0 * 0.2f;
        if (this.a != SelectionHandleType.START) goto L8;
        setPivotX(r0 - getPaddingRight());
        setPivotY(getPaddingTop());
        float r12 = r9 - getPivotX();
        float r13 = r10 - getPivotY();
        float r2 = ((float) Math.cos(r1)) * r11;
        float r14 = r11 * ((float) Math.sin(r1));
        setX(r12 + r2);
        setY(r13 + r14);
        return;
    L8:
        setPivotX(getPaddingLeft());
        setPivotY(getPaddingTop());
        float r15 = r9 - getPivotX();
        float r16 = r10 - getPivotY();
        float r17 = -r11;
        float r3 = ((float) Math.cos(r1)) * r17;
        float r19 = r17 * ((float) Math.sin(r1));
        setX(r15 + r3);
        setY(r16 + r19);
    }
}
