package com.obric.oui.oswitch;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.lynx.tasm.utils.a;
import com.lynx.tasm.utils.d;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$styleable;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import xr.b;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/obric/oui/oswitch/OSwitchBak;", "Lcom/obric/oui/oswitch/SwitchCompat;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "checked", "", "setChecked", "(Z)V", "setCheckedWithoutFeedback", "enabled", "setEnabled", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSwitchBak extends SwitchCompat {
    public final boolean Q;

    @JvmOverloads
    public OSwitchBak(Context r5) {
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public final void c(boolean r5, boolean r10) {
        if (r5 != isChecked()) goto L5;
    L20:
        super.setChecked(r5);
        return;
    L5:
        if ((getTrackDrawable() instanceof TransitionDrawable) == false) goto L20;
        if (r5 == false) goto L13;
        Drawable r11 = getTrackDrawable();
        if (r11 == null) goto L12;
        ((TransitionDrawable) r11).startTransition(180);
    L16:
        if (r10 == false) goto L20;
        performHapticFeedback(1, 2);
        goto L20
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
    L13:
        Drawable r12 = getTrackDrawable();
        if (r12 == null) goto L19;
        ((TransitionDrawable) r12).reverseTransition(180);
        goto L16
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.Q == false) goto L6;
        d.n(a.B(45, this), this);
        return;
    }

    @Override // com.obric.oui.oswitch.SwitchCompat, android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r5) {
        c(r5, true);
    }

    public final void setCheckedWithoutFeedback(boolean r5) {
        c(r5, false);
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean r5) {
        super.setEnabled(r5);
        if (r5 == false) goto L5;
        float r10 = 1.0f;
    L6:
        setAlpha(r10);
        return;
    L5:
        r10 = 0.5f;
        goto L6
    }

    @JvmOverloads
    public OSwitchBak(Context r5, AttributeSet r10) {
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OSwitchBak(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public OSwitchBak(Context r26, AttributeSet r27, int r28) {
        super(r26, r27, r28);
        this.Q = true;
        if (r26 != null) goto L5;
    L4:
        TypedArray r12 = null;
    L9:
        if (r12 != null) goto L41;
        boolean r13 = false;
    L12:
        if (r12 != null) goto L14;
        boolean r14 = false;
    L15:
        if (r12 == null) goto L18;
        r12.recycle();
    L18:
        setLayerType(1, null);
        b r15 = new b();
        r15.f23220a = r26;
        ShapeDrawable r10 = new ShapeDrawable(r15);
        r10.setIntrinsicHeight(a.B(21, this));
        r10.setIntrinsicWidth(a.B(21, this));
        setThumbDrawable(r10);
        ShapeDrawable r11 = new ShapeDrawable();
        r11.setIntrinsicHeight(a.B(24, this));
        r11.setIntrinsicWidth(a.B(36, this));
        r11.setShape(new RoundRectShape(new float[]{a.F(this, 12.5d), a.F(this, 12.5d), a.F(this, 12.5d), a.F(this, 12.5d), a.F(this, 12.5d), a.F(this, 12.5d), a.F(this, 12.5d), a.F(this, 12.5d)}, new RectF(), new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}));
        if (r13 == false) goto L21;
        int r5 = R$color.LineReverse;
    L24:
        Intrinsics.checkNotNull(r26);
        DrawableCompat.setTint(r11, ContextCompat.getColor(r26, r5));
        ShapeDrawable r16 = new ShapeDrawable();
        r16.setIntrinsicHeight(a.B(25, this));
        r16.setIntrinsicWidth(a.B(43, this));
        r16.setShape(new RoundRectShape(new float[]{a.F(this, 12.5d), a.F(this, 12.5d), a.F(this, 12.5d), a.F(this, 12.5d), a.F(this, 12.5d), a.F(this, 12.5d), a.F(this, 12.5d), a.F(this, 12.5d)}, new RectF(), new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}));
        DrawableCompat.setTint(r16, ContextCompat.getColor(r26, R$color.blue_2761f2_100));
        TransitionDrawable r17 = new TransitionDrawable(new ShapeDrawable[]{r11, r16});
        r17.setCrossFadeEnabled(true);
        setTrackDrawable(r17);
        Drawable r18 = getTrackDrawable();
        if (r18 == null) goto L35;
        ((TransitionDrawable) r18).resetTransition();
        setThumbConstraintRight(a.B(2, this));
        setThumbConstraintLeft(a.B(2, this));
        if (isChecked() == false) goto L33;
        Drawable r19 = getTrackDrawable();
        if (r19 == null) goto L32;
        ((TransitionDrawable) r19).startTransition(180);
        return;
    L32:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
    L33:
        return;
    L35:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
    L21:
        if (r14 == false) goto L23;
        r5 = R$color.ConstLineInverse;
        goto L24
    L23:
        r5 = R$color.LinePrimary2;
        goto L24
    L14:
        r14 = r12.getBoolean(R$styleable.OSwitch_oui_isAlwaysDark, false);     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        if (r12 == null) goto L40;
        r12.recycle();
    L40:
        throw th;
    L41:
        r13 = r12.getBoolean(R$styleable.OSwitch_oui_isAlwaysLight, false);     // Catch: Throwable -> L36
        goto L12
    L5:
        Resources.Theme r110 = r26.getTheme();
        if (r110 == null) goto L4;
        r12 = r110.obtainStyledAttributes(r27, R$styleable.OSwitch, 0, 0);
        goto L9
    }
}
