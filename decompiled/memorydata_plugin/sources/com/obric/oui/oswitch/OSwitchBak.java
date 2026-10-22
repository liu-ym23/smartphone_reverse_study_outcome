package com.obric.oui.oswitch;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.util.h;
import com.obric.oui.common.util.k;
import com.obric.oui.common.util.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B'\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u00020\u000eH\u0014J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\nH\u0016J \u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\nH\u0002J\u000e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\nJ\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\nH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/oui/oswitch/OSwitchBak;", "Lcom/obric/oui/oswitch/SwitchCompat;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adaptForCSR", "", "isAlwaysDark", "isAlwaysLight", "disableAdaptForCSR", "", "onAttachedToWindow", "setChecked", "checked", "setCheckedInner", "withHapticFeedback", "withAnim", "setCheckedWithoutFeedback", "setEnabled", "enabled", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSwitchBak extends SwitchCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f14243a;
    private boolean c;
    private boolean d;

    public OSwitchBak(Context r7) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin"), null, 0, 6, null);
    }

    public OSwitchBak(Context r9, AttributeSet r10) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin"), 0, 4, null);
    }

    public OSwitchBak(Context r20, AttributeSet r21, int r22) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r20, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r3 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r21, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r1, r3, r22);
        this.f14243a = true;
        if (r1 != null) goto L5;
    L4:
        TypedArray r4 = null;
    L10:
        if (r4 != null) goto L46;
        boolean r8 = false;
    L13:
        this.c = r8;     // Catch: Throwable -> L41
        if (r4 != null) goto L16;
        boolean r7 = false;
    L17:
        this.d = r7;     // Catch: Throwable -> L41
        if (r4 == null) goto L21;
        r4.recycle();
    L21:
        setLayerType(1, null);
        ShapeDrawable r5 = new ShapeDrawable((Shape) ZeusTransformUtils.preCheckCast(new b(r1), Shape.class, "com.obric.memorydata.plugin"));
        r5.setIntrinsicHeight(h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 21));
        r5.setIntrinsicWidth(h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 21));
        setThumbDrawable((Drawable) ZeusTransformUtils.preCheckCast(r5, Drawable.class, "com.obric.memorydata.plugin"));
        ShapeDrawable r6 = new ShapeDrawable();
        r6.setIntrinsicHeight(h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 24));
        r6.setIntrinsicWidth(h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 36));
        r6.setShape((Shape) ZeusTransformUtils.preCheckCast(new RoundRectShape(new float[]{h.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12.5d), h.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12.5d), h.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12.5d), h.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12.5d), h.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12.5d), h.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12.5d), h.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12.5d), h.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12.5d)}, new RectF(), new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}), Shape.class, "com.obric.memorydata.plugin"));
        if (this.c == false) goto L26;
        int r9 = R.color.LineReverse;
        String r10 = "LineReverse";
    L24:
        int r11 = ZeusTransformUtils.mapRes(r9, TypedValues.Custom.S_COLOR, r10);
        if (Build.VERSION.SDK_INT < 21) goto L32;
        Drawable r12 = (Drawable) ZeusTransformUtils.preCheckCast(r6, Drawable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r1);
        DrawableCompat.setTint(r12, ContextCompat.getColor(r1, r11));
    L33:
        ShapeDrawable r13 = new ShapeDrawable();
        r13.setIntrinsicHeight(h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 25));
        r13.setIntrinsicWidth(h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 43));
        r13.setShape((Shape) ZeusTransformUtils.preCheckCast(new RoundRectShape(new float[]{h.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12.5d), h.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12.5d), h.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12.5d), h.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12.5d), h.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12.5d), h.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12.5d), h.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12.5d), h.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12.5d)}, new RectF(), new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}), Shape.class, "com.obric.memorydata.plugin"));
        if (Build.VERSION.SDK_INT < 21) goto L36;
        DrawableCompat.setTint((Drawable) ZeusTransformUtils.preCheckCast(r13, Drawable.class, "com.obric.memorydata.plugin"), ContextCompat.getColor(r1, ZeusTransformUtils.mapRes(R.color.blue_2761f2_100, TypedValues.Custom.S_COLOR, "blue_2761f2_100")));
    L37:
        TransitionDrawable r2 = new TransitionDrawable((Drawable[]) ZeusTransformUtils.preCheckCast(new ShapeDrawable[]{r6, r13}, Drawable[].class, "com.obric.memorydata.plugin"));
        r2.setCrossFadeEnabled(true);
        setTrackDrawable((Drawable) ZeusTransformUtils.preCheckCast(r2, Drawable.class, "com.obric.memorydata.plugin"));
        Drawable r14 = getTrackDrawable();
        Objects.requireNonNull(r14, "null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
        ((TransitionDrawable) ZeusTransformUtils.preCheckCast(r14, TransitionDrawable.class, "com.obric.memorydata.plugin")).resetTransition();
        setThumbConstraintRight(h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 2));
        setThumbConstraintLeft(h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 2));
        if (isChecked() == false) goto L48;
        Drawable r0 = getTrackDrawable();
        Objects.requireNonNull(r0, "null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
        ((TransitionDrawable) ZeusTransformUtils.preCheckCast(r0, TransitionDrawable.class, "com.obric.memorydata.plugin")).startTransition(SubsamplingScaleImageView.ORIENTATION_180);
        return;
    L48:
        return;
    L36:
        r13.setColorFilter((ColorFilter) ZeusTransformUtils.preCheckCast(new k(ContextCompat.getColor(r1, ZeusTransformUtils.mapRes(R.color.blue_2761f2_100, TypedValues.Custom.S_COLOR, "blue_2761f2_100"))), ColorFilter.class, "com.obric.memorydata.plugin"));
        goto L37
    L32:
        Intrinsics.checkNotNull(r1);
        r6.setColorFilter((ColorFilter) ZeusTransformUtils.preCheckCast(new k(ColorUtils.compositeColors(ContextCompat.getColor(r1, r11), ContextCompat.getColor(r1, ZeusTransformUtils.mapRes(R.color.BGPrimary, TypedValues.Custom.S_COLOR, "BGPrimary")))), ColorFilter.class, "com.obric.memorydata.plugin"));
        goto L33
    L26:
        if (this.d == false) goto L28;
        r9 = R.color.ConstLineInverse;
        r10 = "ConstLineInverse";
        goto L24
    L28:
        r9 = R.color.LinePrimary2;
        r10 = "LinePrimary2";
    L41:
        th = move-exception;
        if (r4 == null) goto L45;
        r4.recycle();
    L45:
        throw th;
    L16:
        r7 = r4.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OSwitch_oui_isAlwaysDark, "styleable", "OSwitch_oui_isAlwaysDark"), false);     // Catch: Throwable -> L41
        goto L17
    L46:
        r8 = r4.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OSwitch_oui_isAlwaysLight, "styleable", "OSwitch_oui_isAlwaysLight"), false);     // Catch: Throwable -> L41
        goto L13
    L5:
        Resources.Theme r15 = r1.getTheme();
        if (r15 == null) goto L4;
        r4 = r15.obtainStyledAttributes(r3, R.styleable.OSwitch, 0, 0);
        goto L10
    }

    public /* synthetic */ OSwitchBak(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    private final void a(boolean r4, boolean r5, boolean r6) {
        if (r4 == isChecked()) goto L13;
        if (r6 == false) goto L13;
        if (ZeusTransformUtils.instanceOf(getTrackDrawable(), TransitionDrawable.class) == false) goto L13;
        Drawable r2 = getTrackDrawable();
        Objects.requireNonNull(r2, "null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
        TransitionDrawable r0 = (TransitionDrawable) ZeusTransformUtils.preCheckCast(r2, TransitionDrawable.class, "com.obric.memorydata.plugin");
        if (r4 == false) goto L10;
        r0.startTransition(SubsamplingScaleImageView.ORIENTATION_180);
    L11:
        if (r5 == false) goto L13;
        performHapticFeedback(1, 2);
        goto L13
    L10:
        r0.reverseTransition(SubsamplingScaleImageView.ORIENTATION_180);
    L13:
        super.setChecked(r4);
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f14243a == false) goto L6;
        o.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 45));
        return;
    }

    @Override // com.obric.oui.oswitch.SwitchCompat, android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r2) {
        a(r2, true, true);
    }

    public final void setCheckedWithoutFeedback(boolean r3) {
        a(r3, false, true);
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean r1) {
        super.setEnabled(r1);
        if (r1 == false) goto L5;
        float r2 = 1.0f;
    L6:
        setAlpha(r2);
        return;
    L5:
        r2 = 0.5f;
        goto L6
    }
}
