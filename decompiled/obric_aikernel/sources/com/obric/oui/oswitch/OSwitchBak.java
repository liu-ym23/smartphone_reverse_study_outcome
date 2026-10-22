package com.obric.oui.oswitch;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import com.obric.oui.common.util.h;
import com.obric.oui.common.util.k;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import u8.c;
import u8.l;
import v9.b;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\b\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/oswitch/OSwitchBak;", "Lcom/obric/oui/oswitch/SwitchCompat;", "", "checked", "", "setChecked", "setCheckedWithoutFeedback", "enabled", "setEnabled", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OSwitchBak extends SwitchCompat {

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private boolean f6909d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private boolean f6910e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private boolean f6911f0;

    @JvmOverloads
    public OSwitchBak(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public OSwitchBak(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public OSwitchBak(Context r19, AttributeSet r20, int r21) {
        super(r19, r20, r21);
        this.f6909d0 = true;
        if (r19 == null) goto L7;
        Resources.Theme r10 = r19.getTheme();
        if (r10 == null) goto L7;
        TypedArray r11 = r10.obtainStyledAttributes(r20, l.OSwitch, 0, 0);
    L8:
        if (r11 != null) goto L42;
        boolean r12 = false;
    L13:
        this.f6910e0 = r12;     // Catch: Throwable -> L10
        if (r11 == null) goto L16;
        boolean r13 = r11.getBoolean(l.OSwitch_oui_isAlwaysDark, false);     // Catch: Throwable -> L10
    L17:
        this.f6911f0 = r13;     // Catch: Throwable -> L10
        if (r11 == null) goto L20;
        r11.recycle();
        Unit r14 = Unit.INSTANCE;
    L20:
        Unit r15 = Unit.INSTANCE;
        setLayerType(1, null);
        ShapeDrawable r16 = new ShapeDrawable(new b(r19));
        float r17 = 21;
        Resources r18 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r18, "Resources.getSystem()");
        r16.setIntrinsicHeight(MathKt.roundToInt(TypedValue.applyDimension(1, r17, r18.getDisplayMetrics())));
        Resources r22 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r22, "Resources.getSystem()");
        r16.setIntrinsicWidth(MathKt.roundToInt(TypedValue.applyDimension(1, r17, r22.getDisplayMetrics())));
        setThumbDrawable(r16);
        ShapeDrawable r23 = new ShapeDrawable();
        Resources r24 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r24, "Resources.getSystem()");
        r23.setIntrinsicHeight(MathKt.roundToInt(TypedValue.applyDimension(1, 24, r24.getDisplayMetrics())));
        Resources r25 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r25, "Resources.getSystem()");
        r23.setIntrinsicWidth(MathKt.roundToInt(TypedValue.applyDimension(1, 36, r25.getDisplayMetrics())));
        float r110 = (float) 12.5d;
        Resources r111 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r111, "Resources.getSystem()");
        Resources r112 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r112, "Resources.getSystem()");
        Resources r113 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r113, "Resources.getSystem()");
        Resources r114 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r114, "Resources.getSystem()");
        Resources r115 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r115, "Resources.getSystem()");
        Resources r116 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r116, "Resources.getSystem()");
        Resources r117 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r117, "Resources.getSystem()");
        Resources r118 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r118, "Resources.getSystem()");
        r23.setShape(new RoundRectShape(new float[]{TypedValue.applyDimension(1, r110, r111.getDisplayMetrics()), TypedValue.applyDimension(1, r110, r112.getDisplayMetrics()), TypedValue.applyDimension(1, r110, r113.getDisplayMetrics()), TypedValue.applyDimension(1, r110, r114.getDisplayMetrics()), TypedValue.applyDimension(1, r110, r115.getDisplayMetrics()), TypedValue.applyDimension(1, r110, r116.getDisplayMetrics()), TypedValue.applyDimension(1, r110, r117.getDisplayMetrics()), TypedValue.applyDimension(1, r110, r118.getDisplayMetrics())}, new RectF(), new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}));
        if (this.f6910e0 == false) goto L24;
        int r26 = c.LineReverse;
    L27:
        int r27 = Build.VERSION.SDK_INT;
        Intrinsics.checkNotNull(r19);
        int r28 = ContextCompat.getColor(r19, r26);
        if (r27 < 21) goto L30;
        DrawableCompat.setTint(r23, r28);
    L31:
        ShapeDrawable r29 = new ShapeDrawable();
        Resources r119 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r119, "Resources.getSystem()");
        r29.setIntrinsicHeight(MathKt.roundToInt(TypedValue.applyDimension(1, 25, r119.getDisplayMetrics())));
        Resources r120 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r120, "Resources.getSystem()");
        r29.setIntrinsicWidth(MathKt.roundToInt(TypedValue.applyDimension(1, 43, r120.getDisplayMetrics())));
        Resources r30 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r30, "Resources.getSystem()");
        Resources r31 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r31, "Resources.getSystem()");
        Resources r32 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r32, "Resources.getSystem()");
        Resources r33 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r33, "Resources.getSystem()");
        Resources r34 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r34, "Resources.getSystem()");
        Resources r35 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r35, "Resources.getSystem()");
        Resources r36 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r36, "Resources.getSystem()");
        Resources r37 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r37, "Resources.getSystem()");
        r29.setShape(new RoundRectShape(new float[]{TypedValue.applyDimension(1, r110, r30.getDisplayMetrics()), TypedValue.applyDimension(1, r110, r31.getDisplayMetrics()), TypedValue.applyDimension(1, r110, r32.getDisplayMetrics()), TypedValue.applyDimension(1, r110, r33.getDisplayMetrics()), TypedValue.applyDimension(1, r110, r34.getDisplayMetrics()), TypedValue.applyDimension(1, r110, r35.getDisplayMetrics()), TypedValue.applyDimension(1, r110, r36.getDisplayMetrics()), TypedValue.applyDimension(1, r110, r37.getDisplayMetrics())}, new RectF(), new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}));
        if (r27 < 21) goto L34;
        DrawableCompat.setTint(r29, ContextCompat.getColor(r19, c.blue_2761f2_100));
    L35:
        TransitionDrawable r38 = new TransitionDrawable(new ShapeDrawable[]{r23, r29});
        r38.setCrossFadeEnabled(true);
        setTrackDrawable(r38);
        Drawable r39 = getTrackDrawable();
        Objects.requireNonNull(r39, "null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
        ((TransitionDrawable) r39).resetTransition();
        float r40 = 2;
        Resources r41 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r41, "Resources.getSystem()");
        setThumbConstraintRight(MathKt.roundToInt(TypedValue.applyDimension(1, r40, r41.getDisplayMetrics())));
        Resources r42 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r42, "Resources.getSystem()");
        setThumbConstraintLeft(MathKt.roundToInt(TypedValue.applyDimension(1, r40, r42.getDisplayMetrics())));
        if (isChecked() == false) goto L44;
        Drawable r43 = getTrackDrawable();
        Objects.requireNonNull(r43, "null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
        ((TransitionDrawable) r43).startTransition(180);
        return;
    L44:
        return;
    L34:
        r29.setColorFilter(new h(ContextCompat.getColor(r19, c.blue_2761f2_100)));
        goto L35
    L30:
        r23.setColorFilter(new h(ColorUtils.compositeColors(r28, ContextCompat.getColor(r19, c.BGPrimary))));
        goto L31
    L24:
        if (this.f6911f0 == false) goto L26;
        r26 = c.ConstLineInverse;
        goto L27
    L26:
        r26 = c.LinePrimary2;
    L10:
        th = move-exception;
        if (r11 == null) goto L41;
        r11.recycle();
        Unit r44 = Unit.INSTANCE;
    L41:
        throw th;
    L16:
        r13 = false;
        goto L17
    L42:
        r12 = r11.getBoolean(l.OSwitch_oui_isAlwaysLight, false);     // Catch: Throwable -> L10
    L7:
        r11 = null;
        goto L8
    }

    public /* synthetic */ OSwitchBak(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    private final void n(boolean r10, boolean r11, boolean r12) {
        if (r10 == isChecked()) goto L13;
        if (r12 == false) goto L13;
        if ((getTrackDrawable() instanceof TransitionDrawable) == false) goto L13;
        Drawable r13 = getTrackDrawable();
        Objects.requireNonNull(r13, "null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
        TransitionDrawable r14 = (TransitionDrawable) r13;
        if (r10 == false) goto L10;
        r14.startTransition(180);
    L11:
        if (r11 == false) goto L13;
        performHapticFeedback(1, 2);
        goto L13
    L10:
        r14.reverseTransition(180);
    L13:
        super.setChecked(r10);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f6909d0 == false) goto L6;
        Resources r10 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r10, "Resources.getSystem()");
        k.a(this, MathKt.roundToInt(TypedValue.applyDimension(1, 45, r10.getDisplayMetrics())));
        return;
    }

    @Override // com.obric.oui.oswitch.SwitchCompat, android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r10) {
        n(r10, true, true);
    }

    public final void setCheckedWithoutFeedback(boolean r10) {
        n(r10, false, true);
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean r10) {
        super.setEnabled(r10);
        if (r10 == false) goto L5;
        float r11 = 1.0f;
    L6:
        setAlpha(r11);
        return;
    L5:
        r11 = 0.5f;
        goto L6
    }
}
