package com.obric.oui.oswitch;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.content.ContextCompat;
import com.lynx.tasm.utils.d;
import com.obric.common.oui.R$attr;
import com.obric.common.oui.R$drawable;
import com.obric.common.oui.R$styleable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import ps.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u0015\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0014\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0016\u0010\u0012J\u0017\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0017\u0010\u0012J\u0017\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0018\u0010\u0012R\u0014\u0010\u001b\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/obric/oui/oswitch/OSwitch;", "Lcom/obric/oui/oswitch/SwitchCompat;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/graphics/drawable/Drawable;", "getUncheckedDrawable", "()Landroid/graphics/drawable/Drawable;", "getCheckedDrawable", "", "change", "", "setChangeAlphaWhenDisable", "(Z)V", "enabled", "setEnabled", "checked", "setCheckedWithoutFeedback", "setChecked", "setCheckedNoAnim", "getTargetCheckedState", "()Z", "targetCheckedState", "", "getThumbPosition", "()F", "thumbPosition", "getTouchMode", "()I", "touchMode", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSwitch extends SwitchCompat {
    public final int Q;
    public final int R;
    public boolean S;

    @JvmOverloads
    public OSwitch(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    private final Drawable getCheckedDrawable() {
        int r5 = this.R;
        if (r5 != 0) goto L5;
        Drawable r10 = ContextCompat.getDrawable(getContext(), R$drawable.o_switch_track_checked);
        Intrinsics.checkNotNull(r10);
        return r10.mutate();
    L5:
        Drawable r11 = ContextCompat.getDrawable(getContext(), r5);
        Intrinsics.checkNotNull(r11);
        return r11.mutate();
    }

    private final boolean getTargetCheckedState() {
        if (getThumbPosition() <= 0.5f) goto L5;
        return true;
    L5:
        return false;
    }

    private final float getThumbPosition() {
        Field r5 = SwitchCompat.class.getDeclaredField("w");     // Catch: IllegalAccessException -> L5 NoSuchFieldException -> L7
        r5.setAccessible(true);     // Catch: IllegalAccessException -> L5 NoSuchFieldException -> L7
        Object r10 = r5.get(this);     // Catch: IllegalAccessException -> L5 NoSuchFieldException -> L7
        if (r10 == null) goto L10;
        return ((Float) r10).floatValue();
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");     // Catch: IllegalAccessException -> L5 NoSuchFieldException -> L7
    L5:
        e = move-exception;
        e.printStackTrace();
    L13:
        return 0.0f;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }

    private final int getTouchMode() {
        Field r5 = SwitchCompat.class.getDeclaredField("q");     // Catch: IllegalAccessException -> L5 NoSuchFieldException -> L7
        r5.setAccessible(true);     // Catch: IllegalAccessException -> L5 NoSuchFieldException -> L7
        Object r10 = r5.get(this);     // Catch: IllegalAccessException -> L5 NoSuchFieldException -> L7
        if (r10 == null) goto L10;
        return ((Integer) r10).intValue();
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");     // Catch: IllegalAccessException -> L5 NoSuchFieldException -> L7
    L5:
        e = move-exception;
        e.printStackTrace();
    L13:
        return 0;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }

    private final Drawable getUncheckedDrawable() {
        int r5 = this.Q;
        if (r5 != 0) goto L5;
        Drawable r10 = ContextCompat.getDrawable(getContext(), R$drawable.o_switch_track_unchecked);
        Intrinsics.checkNotNull(r10);
        return r10.mutate();
    L5:
        Drawable r11 = ContextCompat.getDrawable(getContext(), r5);
        Intrinsics.checkNotNull(r11);
        return r11.mutate();
    }

    public final void c(boolean r5) {
        Drawable r10 = getTrackDrawable();
        if ((r10 instanceof TransitionDrawable) == false) goto L12;
        if (r5 == false) goto L10;
        TransitionDrawable r11 = (TransitionDrawable) r10;
        Method r12 = TransitionDrawable.class.getDeclaredMethod("showSecondLayer", null);     // Catch: Exception -> L8
        r12.setAccessible(true);     // Catch: Exception -> L8
        r12.invoke(r11, null);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        a.b(e, "OSwitch", "reflectShowSecondLayer, error");
        Unit r13 = Unit.INSTANCE;
        return;
    L10:
        ((TransitionDrawable) r10).resetTransition();
        return;
    L12:
        if ((r10 instanceof xr.a) == true) goto L14;
        return;
    L14:
        if (r5 == false) goto L16;
        xr.a r14 = (xr.a) r10;
        r14.f23216h = 255;
        r14.f23215c = 0;
        r14.invalidateSelf();
        return;
    L16:
        xr.a r15 = (xr.a) r10;
        r15.f23216h = 0;
        r15.f23215c = 0;
        r15.invalidateSelf();
    }

    public final void d() {
        if (this.S == true) goto L5;
        Drawable r5 = getTrackDrawable();
        if (r5 == null) goto L36;
        r5.setAlpha(255);
    L36:
        Drawable r10 = getThumbDrawable();
        if (r10 == null) goto L47;
        r10.setAlpha(255);
        return;
    L47:
        return;
    L5:
        if (isEnabled() == false) goto L15;
        Drawable r11 = getTrackDrawable();
        if (r11 == null) goto L10;
        r11.setAlpha(255);
    L10:
        Drawable r12 = getThumbDrawable();
        if (r12 == null) goto L44;
        r12.setAlpha(255);
        return;
    L44:
        return;
    L15:
        if (isChecked() == false) goto L24;
        Drawable r13 = getTrackDrawable();
        if (r13 == null) goto L20;
        r13.setAlpha(76);
    L20:
        Drawable r14 = getThumbDrawable();
        if (r14 == null) goto L45;
        r14.setAlpha(127);
        return;
    L45:
        return;
    L24:
        Drawable r15 = getTrackDrawable();
        if (r15 == null) goto L28;
        r15.setAlpha(76);
    L28:
        Drawable r16 = getThumbDrawable();
        if (r16 == null) goto L46;
        r16.setAlpha(255);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        measure(0, 0);     // Catch: Exception -> L18
        int r5 = getMeasuredWidth();     // Catch: Exception -> L18
        int r10 = getMeasuredHeight();     // Catch: Exception -> L18
        if (r5 <= 0) goto L26;
        if (r10 <= 0) goto L27;
        int r11 = r5 + com.lynx.tasm.utils.a.B(20, this);     // Catch: Exception -> L18
        int r12 = r10 + com.lynx.tasm.utils.a.B(20, this);     // Catch: Exception -> L18
        ViewParent r13 = getParent();     // Catch: Exception -> L18
        if (r13 != null) goto L11;
    L9:
        r13 = null;
    L12:
        ViewGroup r14 = (ViewGroup) r13;     // Catch: Exception -> L18
        if (r14 == null) goto L20;
        r14.measure(0, 0);     // Catch: Exception -> L18
        int r15 = r14.getMeasuredWidth();     // Catch: Exception -> L18
        if (r12 > r14.getMeasuredHeight()) goto L17;
        if (r11 <= r15) goto L20;
    L17:
        d.o(r14, r11, r12, false);     // Catch: Exception -> L18
    L20:
        d.o(this, r11, r12, false);     // Catch: Exception -> L18
        return;
    L11:
        if ((r13 instanceof ViewGroup) == false) goto L9;
    L27:
        return;
    L26:
        return;
    L18:
        e = move-exception;
        a.b(e, "OSwitch", "increaseTouchArea, error");
    }

    @Override // com.obric.oui.oswitch.SwitchCompat, android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "ev");
        if (r10.getAction() == 3) goto L7;
        if (r10.getAction() == 1) goto L7;
    L32:
        return super.onTouchEvent(r10);
    L7:
        if (getTouchMode() != 2) goto L32;
        Field r5 = SwitchCompat.class.getDeclaredField("q");     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L13
        r5.setAccessible(true);     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L13
        r5.set(this, 0);     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L13
    L18:
        if (r10.getAction() == 1) goto L20;
    L22:
        boolean r11 = false;
    L23:
        boolean r12 = isChecked();
        if (r11 == false) goto L26;
        boolean r13 = getTargetCheckedState();
    L27:
        if (r13 == r12) goto L29;
        playSoundEffect(0);
    L29:
        setChecked(r13);
        MotionEvent r14 = MotionEvent.obtain(r10);
        r14.setAction(3);
        super.onTouchEvent(r14);
        r14.recycle();
        super.onTouchEvent(r10);
        return true;
    L26:
        r13 = r12;
        goto L27
    L20:
        if (isEnabled() == false) goto L22;
        r11 = true;
    L11:
        e = move-exception;
        e.printStackTrace();
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L18
    }

    public final void setChangeAlphaWhenDisable(boolean r5) {
        if (this.S == r5) goto L6;
        this.S = r5;
        d();
        return;
    }

    @Override // com.obric.oui.oswitch.SwitchCompat, android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r10) {
        boolean r5 = isChecked();
        super.setChecked(r10);
        boolean r11 = isChecked();
        d();
        if (getWindowToken() != null) goto L5;
    L33:
        c(r11);
        return;
    L5:
        if (getWidth() <= 0) goto L33;
        if (getHeight() <= 0) goto L33;
        if (r5 == r11) goto L35;
        Drawable r12 = getTrackDrawable();
        if ((r12 instanceof TransitionDrawable) == false) goto L15;
        if (r11 == false) goto L13;
        ((TransitionDrawable) r12).startTransition(260);
        return;
    L13:
        ((TransitionDrawable) r12).reverseTransition(100);
        return;
    L15:
        if ((r12 instanceof xr.a) == false) goto L38;
        int r13 = 255;
        if (r11 == false) goto L19;
        xr.a r14 = (xr.a) r12;
        r14.f = 0;
        r14.g = 255;
        r14.f23216h = 0;
        r14.e = 260;
        r14.f23217i = false;
        r14.f23215c = 1;
        r14.invalidateSelf();
        return;
    L19:
        xr.a r15 = (xr.a) r12;
        r15.getClass();
        long r16 = SystemClock.uptimeMillis();
        if (r15.f23215c != 2) goto L32;
        long r17 = r16 - r15.d;
        int r18 = r15.e;
        if (r17 > r18) goto L32;
        boolean r19 = r15.f23217i;
        r15.f23217i = !r19;
        r15.f = r15.f23216h;
        if (r19 == true) goto L27;
        r13 = 0;
    L27:
        r15.g = r13;
        if (r19 == true) goto L30;
        int r110 = (int) r17;
    L31:
        r15.e = r110;
        r15.f23215c = 1;
        r15.invalidateSelf();
        return;
    L30:
        r110 = r18 - ((int) r17);
    L32:
        r15.f = 255;
        r15.g = 0;
        r15.f23216h = 255;
        r15.e = 100;
        r15.f23217i = true;
        r15.f23215c = 1;
        r15.invalidateSelf();
        return;
    L38:
        return;
    }

    @Override // com.obric.oui.oswitch.SwitchCompat
    public void setCheckedNoAnim(boolean r5) {
        super.setCheckedNoAnim(r5);
        c(r5);
    }

    @Deprecated(message = "use setHapticFeedbackEnabled instead")
    public final void setCheckedWithoutFeedback(boolean r5) {
        if (r5 != isChecked()) goto L5;
    L18:
        super.setChecked(r5);
        return;
    L5:
        if ((getTrackDrawable() instanceof TransitionDrawable) == false) goto L18;
        if (r5 == false) goto L13;
        Drawable r10 = getTrackDrawable();
        if (r10 == null) goto L12;
        ((TransitionDrawable) r10).startTransition(180);
        goto L18
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
    L13:
        Drawable r11 = getTrackDrawable();
        if (r11 == null) goto L17;
        ((TransitionDrawable) r11).reverseTransition(180);
        goto L18
    L17:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean r5) {
        super.setEnabled(r5);
        d();
    }

    @JvmOverloads
    public OSwitch(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OSwitch(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, R$attr.OUISwitchStyle);
    }

    @JvmOverloads
    public OSwitch(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        this.S = true;
        TypedArray r12 = r5.obtainStyledAttributes(r10, R$styleable.OSwitch, r11, 0);
        this.Q = r12.getResourceId(R$styleable.OSwitch_oui_trackUnchecked, 0);
        this.R = r12.getResourceId(R$styleable.OSwitch_oui_trackChecked, 0);
        this.S = r12.getBoolean(R$styleable.OSwitch_oui_disabledAlpha, true);
        r12.recycle();
        if (getThumbDrawable() != null) goto L6;
        setThumbDrawable(ContextCompat.getDrawable(r5, R$drawable.o_switch_thumb));
    L6:
        if (getTrackDrawable() != null) goto L12;
        boolean r13 = isChecked();
        xr.a r14 = new xr.a(getUncheckedDrawable(), getCheckedDrawable());
        if (r13 == false) goto L10;
        r14.f = 0;
        r14.g = 255;
        r14.f23216h = 0;
        r14.e = 0;
        r14.f23217i = false;
        r14.f23215c = 1;
        r14.invalidateSelf();
    L11:
        setTrackDrawable(r14);
        goto L12
    L10:
        r14.f23216h = 0;
        r14.f23215c = 0;
        r14.invalidateSelf();
    L12:
        setEnabled(isEnabled());
    }
}
