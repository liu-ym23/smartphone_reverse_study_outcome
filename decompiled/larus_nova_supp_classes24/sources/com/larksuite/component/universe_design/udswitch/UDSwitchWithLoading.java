package com.larksuite.component.universe_design.udswitch;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010*\u0002 #\b\u0017\u0018\u0000 I2\u00020\u0001:\u0002HIB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ*\u0010%\u001a\u00020&2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\u000e\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u0010J\b\u0010)\u001a\u0004\u0018\u00010\u0010J\u000e\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020,J\u000e\u0010-\u001a\u00020&2\u0006\u0010.\u001a\u00020\nJ\u000e\u0010/\u001a\u00020&2\u0006\u0010.\u001a\u00020\nJ(\u00100\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\n2\u0006\u00104\u001a\u00020\nH\u0002J\u0018\u00105\u001a\u00020&2\u0006\u00106\u001a\u00020\n2\u0006\u00107\u001a\u00020\nH\u0014J\u0010\u00108\u001a\u00020&2\u0006\u00109\u001a\u00020:H\u0016J\u0010\u0010;\u001a\u00020&2\u0006\u0010<\u001a\u00020:H\u0014J\b\u0010=\u001a\u000202H\u0002J\u0010\u0010>\u001a\u00020&2\u0006\u00101\u001a\u000202H\u0002J\b\u0010?\u001a\u00020\u0016H\u0016J\b\u0010@\u001a\u00020&H\u0002J\b\u0010A\u001a\u00020&H\u0002J\u0010\u0010B\u001a\u00020&2\u0006\u0010C\u001a\u00020\u0016H\u0002J\u000e\u0010D\u001a\u00020&2\u0006\u0010E\u001a\u00020\u0016J\u000e\u0010F\u001a\u00020&2\u0006\u0010G\u001a\u00020\u001eR\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010!R\u0010\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0004\n\u0002\u0010$¨\u0006J"}, d2 = {"Lcom/larksuite/component/universe_design/udswitch/UDSwitchWithLoading;", "Lcom/larksuite/component/universe_design/udswitch/UDSwitch;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mLoadingWidth", "mLoadingDrawable", "Landroidx/swiperefreshlayout/widget/CircularProgressDrawable;", "mLoadingCheckedColor", "mLoadingUnCheckedColor", "mLoadingTintMode", "Landroid/graphics/PorterDuff$Mode;", "mHasLoadingTint", "", "mHasLoadingTintMode", "mLoadingRadius", "mLoadingStrokeWidth", "mTempRect", "Landroid/graphics/Rect;", "mLoadingState", "mLoadingStatusChangeListener", "Lcom/larksuite/component/universe_design/udswitch/UDSwitchWithLoading$OnLoadingStatusChangeListener;", "mLoadingAnimatorCallback", "com/larksuite/component/universe_design/udswitch/UDSwitchWithLoading$mLoadingAnimatorCallback$1", "Lcom/larksuite/component/universe_design/udswitch/UDSwitchWithLoading$mLoadingAnimatorCallback$1;", "drawablesAttachListener", "com/larksuite/component/universe_design/udswitch/UDSwitchWithLoading$drawablesAttachListener$1", "Lcom/larksuite/component/universe_design/udswitch/UDSwitchWithLoading$drawablesAttachListener$1;", "initView", "", "setLoadingDrawable", "loading", "getLoadingDrawable", "setLoadingTintList", "tint", "Landroid/content/res/ColorStateList;", "setLoadingRadius", "pixels", "setLoadingStrokeWidth", "generateProgressDrawable", "progressColors", "", "progressRadiusPx", "progressStrokePx", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "draw", "c", "Landroid/graphics/Canvas;", "onDraw", "canvas", "getStateColor", "changeColor", "performClick", "stopLoading", "startLoading", "setLoadingState", "isLoading", "submitLoadingStatus", "checked", "setOnLoadingStatusChangeListener", "listener", "OnLoadingStatusChangeListener", "Companion", "universe-ui-switch_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public class UDSwitchWithLoading extends UDSwitch {
    public static final int[] J = null;
    public static final int[] K = null;
    public CircularProgressDrawable B;
    public int C;
    public int D;
    public int E;
    public int F;
    public final Rect G;
    public boolean H;
    public b I;

    public static final class a {
    }

    public interface b {
        void a();
    }

    public static final class c implements View.OnAttachStateChangeListener {
        public final /* synthetic */ UDSwitchWithLoading a;

        public c(UDSwitchWithLoading r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            UDSwitchWithLoading r3 = this.a;
            if (r3.H == false) goto L6;
            r3.c();
            return;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            UDSwitchWithLoading r3 = this.a;
            int[] r0 = UDSwitchWithLoading.J;
            CircularProgressDrawable r4 = r3.B;
            if (r4 == null) goto L6;
            r4.stop();
            return;
        }
    }

    public static final class d implements Drawable.Callback {
        public final /* synthetic */ UDSwitchWithLoading a;

        @Override // android.graphics.drawable.Drawable.Callback
        public final void scheduleDrawable(Drawable r1, Runnable r2, long r3) {
            Intrinsics.checkNotNullParameter(r1, "who");
            Intrinsics.checkNotNullParameter(r2, "what");
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void unscheduleDrawable(Drawable r2, Runnable r3) {
            Intrinsics.checkNotNullParameter(r2, "who");
            Intrinsics.checkNotNullParameter(r3, "what");
        }

        public d(UDSwitchWithLoading r1) {
            this.a = r1;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void invalidateDrawable(Drawable r2) {
            Intrinsics.checkNotNullParameter(r2, "who");
            this.a.invalidate();
        }
    }

    private final int[] getStateColor() {
        int[] r0 = new int[1];
        if (isChecked() == false) goto L5;
        int r1 = this.C;
    L6:
        r0[0] = r1;
        return r0;
    L5:
        r1 = this.D;
        goto L6
    }

    @Override // android.widget.CompoundButton, android.view.View
    public final boolean performClick() {
        setLoadingState(true);
        return true;
    }

    static {
        J = new int[]{-16842910, R.attr.state_checked};
        K = new int[]{-16842910};
    }

    public final void c() {
        CircularProgressDrawable r0 = this.B;
        if (r0 == null) goto L15;
        int[] r1 = getStateColor();
        if (r1.length != 0) goto L7;
        boolean r2 = true;
    L9:
        if ((!r2) == false) goto L13;
        CircularProgressDrawable r3 = this.B;
        if (r3 == null) goto L13;
        r3.setColorSchemeColors(Arrays.copyOf(r1, r1.length));
    L13:
        r0.start();
        return;
    L7:
        r2 = false;
        goto L9
    }

    public final CircularProgressDrawable getLoadingDrawable() {
        return this.B;
    }

    public UDSwitchWithLoading(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    private final void setLoadingState(boolean r2) {
        if (this.H == r2) goto L14;
        this.H = r2;
        if (r2 == false) goto L10;
        b r3 = this.I;
        if (r3 == null) goto L9;
        isChecked();
        r3.a();
    L9:
        setEnabled(false);
        c();
        return;
    L10:
        setEnabled(true);
        CircularProgressDrawable r4 = this.B;
        if (r4 == null) goto L16;
        r4.stop();
        return;
    L16:
        return;
    }

    public final void d(boolean r2) {
        if (this.H == false) goto L6;
        setLoadingState(false);
        setChecked(r2);
        invalidate();
        return;
    }

    @Override // com.larksuite.component.universe_design.udswitch.UDSwitch, android.view.View
    public final void draw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "c");
        super.draw(r5);
        Rect r6 = this.G;
        if (this.H == false) goto L10;
        CircularProgressDrawable r0 = this.B;
        if (r0 == null) goto L11;
        r0.getPadding(r6);
        int r1 = ((int) (r0.getCenterRadius() + r0.getStrokeWidth())) * 2;
        int r2 = getThumbInitialLeft() + ((getMThumbWidth() - r1) / 2);
        int r3 = r2 - r6.left;
        int r4 = (r2 + r1) + r6.right;
        r0.setBounds(r3, getMSwitchTop(), r4, getMSwitchBottom());
        Drawable r7 = getBackground();
        if (r7 == null) goto L12;
        DrawableCompat.setHotspotBounds(r7, r3, getMSwitchTop(), r4, getMSwitchBottom());
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.larksuite.component.universe_design.udswitch.UDSwitch, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas r3) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        super.onDraw(r3);
        if (this.H == false) goto L9;
        CircularProgressDrawable r0 = this.B;
        int r1 = r3.save();
        if (r0 == null) goto L7;
        r0.draw(r3);
    L7:
        r3.restoreToCount(r1);
        return;
    }

    public final void setLoadingDrawable(CircularProgressDrawable r2) {
        Intrinsics.checkNotNullParameter(r2, "loading");
        this.B = r2;
        invalidate();
    }

    public final void setLoadingRadius(int r3) {
        CircularProgressDrawable r0 = this.B;
        if (r0 == null) goto L6;
        r0.setCenterRadius(r3 - r0.getStrokeWidth());
        int r4 = ((int) r0.getCenterRadius()) * 2;
        r0.setBounds(0, 0, r4, r4);
        return;
    }

    public final void setLoadingStrokeWidth(int r2) {
        CircularProgressDrawable r0 = this.B;
        if (r0 == null) goto L6;
        r0.setStrokeWidth(r2);
        return;
    }

    public final void setLoadingTintList(ColorStateList r4) {
        Intrinsics.checkNotNullParameter(r4, "tint");
        boolean r1 = false;
        this.C = r4.getColorForState(J, 0);
        this.D = r4.getColorForState(K, 0);
        int[] r5 = getStateColor();
        if (r5.length != 0) goto L6;
        r1 = true;
    L6:
        if ((!r1) == false) goto L11;
        CircularProgressDrawable r0 = this.B;
        if (r0 == null) goto L12;
        r0.setColorSchemeColors(Arrays.copyOf(r5, r5.length));
        return;
    L12:
        return;
    }

    public final void setOnLoadingStatusChangeListener(b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.I = r2;
    }

    public UDSwitchWithLoading(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    @Override // com.larksuite.component.universe_design.udswitch.UDSwitch, android.widget.TextView, android.view.View
    public final void onMeasure(int r3, int r4) {
        Rect r0 = this.G;
        if (this.H == false) goto L7;
        CircularProgressDrawable r1 = this.B;
        if (r1 == null) goto L7;
        Intrinsics.checkNotNull(r1);
        r1.getPadding(r0);
        CircularProgressDrawable r2 = this.B;
        Intrinsics.checkNotNull(r2);
        r2.getIntrinsicWidth();
        int r5 = r0.left;
        CircularProgressDrawable r6 = this.B;
        Intrinsics.checkNotNull(r6);
        r6.getIntrinsicHeight();
    L7:
        super.onMeasure(r3, r4);
    }

    public UDSwitchWithLoading(Context r9, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10, r11, 0);
        this.G = new Rect();
        d r1 = new d(this);
        c r2 = new c(this);
        TypedArray r12 = r9.obtainStyledAttributes(r10, new int[]{2130974947, 2130974948, 2130974949, 2130974950}, r11, 2131953905);
        ColorStateList r13 = r12.getColorStateList(3);
        if (r13 == null) goto L5;
        int r3 = r13.getColorForState(J, 0);
    L6:
        this.C = r3;
        if (r13 == null) goto L9;
        int r14 = r13.getColorForState(K, 0);
    L10:
        this.D = r14;
        this.E = r12.getDimensionPixelSize(1, (int) h18.d.a(r9, 5.43f));
        this.F = r12.getDimensionPixelSize(2, (int) h18.d.a(r9, 1.43f));
        CircularProgressDrawable r15 = r12.getDrawable(0);
        if ((r15 instanceof CircularProgressDrawable) == false) goto L13;
        this.B = r15;
    L21:
        CircularProgressDrawable r16 = this.B;
        if (r16 == null) goto L24;
        r16.setCallback(r1);
    L24:
        r12.recycle();
        addOnAttachStateChangeListener(r2);
        return;
    L13:
        int[] r17 = getStateColor();
        int r5 = this.E;
        int r6 = this.F;
        CircularProgressDrawable r7 = new CircularProgressDrawable(r9);
        r7.setStyle(1);
        if (r17.length != 0) goto L16;
        boolean r19 = true;
    L18:
        if ((!r19) == false) goto L20;
        r7.setColorSchemeColors(Arrays.copyOf(r17, r17.length));
    L20:
        r7.setStrokeCap(Paint.Cap.ROUND);
        float r110 = r6;
        r7.setCenterRadius(r5 - r110);
        r7.setStrokeWidth(r110);
        int r20 = ((int) r7.getCenterRadius()) * 2;
        r7.setBounds(0, 0, r20, r20);
        this.B = r7;
        goto L21
    L16:
        r19 = false;
        goto L18
    L9:
        r14 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }
}
