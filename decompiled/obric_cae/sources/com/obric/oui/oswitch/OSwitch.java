package com.obric.oui.oswitch;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.content.a;
import com.obric.cae.R;
import com.qualcomm.qti.qesdk.QesdkUtils;
import he.i;
import j0.h0;
import j0.w;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import mc.b;
import xd.j;

/* JADX INFO: loaded from: classes2.dex */
public final class OSwitch extends b {
    public final int Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final int f6366a0;

    public OSwitch(Context r8, AttributeSet r10) {
        this(r8, r10, 4);
    }

    private final Drawable getCheckedDrawable() {
        int r8 = this.f6366a0;
        Context r10 = getContext();
        if (r8 != 0) goto L5;
        Object r11 = a.f1674a;
        Drawable r12 = a.b.b(r10, R.drawable.o_switch_track_checked);
        i.c(r12);
        Drawable r13 = r12.mutate();
        String r14 = "ContextCompat.getDrawabl…                .mutate()";
    L6:
        i.e(r13, r14);
        return r13;
    L5:
        Object r15 = a.f1674a;
        Drawable r16 = a.b.b(r10, r8);
        i.c(r16);
        r13 = r16.mutate();
        r14 = "ContextCompat.getDrawabl… trackChecked)!!.mutate()";
        goto L6
    }

    private final boolean getTargetCheckedState() {
        if (getThumbPosition() <= 0.5f) goto L5;
        return true;
    L5:
        return false;
    }

    private final float getThumbPosition() {
        Field r8 = b.class.getDeclaredField("G");     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        i.e(r8, "v");     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        r8.setAccessible(true);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        Object r10 = r8.get(this);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        if (r10 == null) goto L6;
        return ((Float) r10).floatValue();
    L6:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
    L7:
        e = move-exception;
        e.printStackTrace();
    L11:
        return 0.0f;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    private final int getTouchMode() {
        Field r8 = b.class.getDeclaredField("A");     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        i.e(r8, "v");     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        r8.setAccessible(true);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        Object r10 = r8.get(this);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        if (r10 == null) goto L6;
        return ((Integer) r10).intValue();
    L6:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
    L7:
        e = move-exception;
        e.printStackTrace();
    L11:
        return 0;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    private final Drawable getUncheckedDrawable() {
        int r8 = this.Z;
        Context r10 = getContext();
        if (r8 != 0) goto L5;
        Object r11 = a.f1674a;
        Drawable r12 = a.b.b(r10, R.drawable.o_switch_track_unchecked);
        i.c(r12);
        Drawable r13 = r12.mutate();
        String r14 = "ContextCompat.getDrawabl…                .mutate()";
    L6:
        i.e(r13, r14);
        return r13;
    L5:
        Object r15 = a.f1674a;
        Drawable r16 = a.b.b(r10, r8);
        i.c(r16);
        r13 = r16.mutate();
        r14 = "ContextCompat.getDrawabl…rackUnchecked)!!.mutate()";
        goto L6
    }

    public final void c(boolean r8) {
        Drawable r10 = getTrackDrawable();
        if ((r10 instanceof TransitionDrawable) == false) goto L12;
        TransitionDrawable r11 = (TransitionDrawable) r10;
        if (r8 == true) goto L18;
        r11.resetTransition();
        return;
    L18:
        Method r12 = TransitionDrawable.class.getDeclaredMethod("showSecondLayer", new Class[0]);     // Catch: Exception -> L8
        i.e(r12, "showSecondLayerMethod");     // Catch: Exception -> L8
        r12.setAccessible(true);     // Catch: Exception -> L8
        r12.invoke(r11, new Object[0]);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        zc.b.c("OSwitch", "reflectShowSecondLayer, error", e);
        j r13 = j.f13877a;
        return;
    L12:
        if ((r10 instanceof mc.a) == false) goto L22;
        mc.a r14 = (mc.a) r10;
        if (r8 == false) goto L16;
        r14.f9329f = 255;
        r14.f9324a = 0;
        r14.invalidateSelf();
        return;
    L16:
        r14.f9329f = 0;
        r14.f9324a = 0;
        r14.invalidateSelf();
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        measure(0, 0);     // Catch: Exception -> L22
        int r8 = getMeasuredWidth();     // Catch: Exception -> L22
        int r10 = getMeasuredHeight();     // Catch: Exception -> L22
        if (r8 <= 0) goto L27;
        if (r10 <= 0) goto L28;
        float r11 = 20;
        Resources r12 = Resources.getSystem();     // Catch: Exception -> L22
        i.e(r12, "Resources.getSystem()");     // Catch: Exception -> L22
        int r13 = r8 + l6.a.I0(TypedValue.applyDimension(1, r11, r12.getDisplayMetrics()));     // Catch: Exception -> L22
        Resources r14 = Resources.getSystem();     // Catch: Exception -> L22
        i.e(r14, "Resources.getSystem()");     // Catch: Exception -> L22
        int r15 = r10 + l6.a.I0(TypedValue.applyDimension(1, r11, r14.getDisplayMetrics()));     // Catch: Exception -> L22
        ViewParent r16 = getParent();     // Catch: Exception -> L22
        if (r16 != null) goto L11;
    L13:
        r16 = null;
    L14:
        ViewGroup r17 = (ViewGroup) r16;     // Catch: Exception -> L22
        if (r17 == null) goto L20;
        r17.measure(0, 0);     // Catch: Exception -> L22
        int r18 = r17.getMeasuredWidth();     // Catch: Exception -> L22
        if (r15 > r17.getMeasuredHeight()) goto L19;
        if (r13 <= r18) goto L20;
    L19:
        bc.a.a(r17, r13, r15, false);     // Catch: Exception -> L22
    L20:
        bc.a.a(this, r13, r15, false);     // Catch: Exception -> L22
        return;
    L11:
        if ((r16 instanceof ViewGroup) == false) goto L13;
    L28:
        return;
    L27:
        return;
    L22:
        e = move-exception;
        zc.b.c("OSwitch", "increaseTouchArea, error", e);
    }

    @Override // mc.b, android.widget.TextView, android.view.View
    public final void onLayout(boolean r8, int r10, int r11, int r12, int r13) {
        super.onLayout(r8, r10, r11, r12, r13);
    }

    @Override // mc.b, android.widget.TextView, android.view.View
    public final void onMeasure(int r8, int r10) {
        super.onMeasure(r8, r10);
    }

    @Override // mc.b, android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent r8) {
        i.f(r8, "ev");
        if (r8.getAction() == 3) goto L7;
        if (r8.getAction() == 1) goto L7;
    L30:
        return super.onTouchEvent(r8);
    L7:
        if (getTouchMode() != 2) goto L30;
        Field r10 = b.class.getDeclaredField("A");     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L13
        i.e(r10, "v");     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L13
        r10.setAccessible(true);     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L13
        r10.set(this, 0);     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L13
    L16:
        if (r8.getAction() == 1) goto L18;
    L20:
        boolean r11 = false;
    L21:
        boolean r12 = isChecked();
        if (r11 == false) goto L24;
        boolean r13 = getTargetCheckedState();
    L25:
        if (r13 == r12) goto L27;
        playSoundEffect(0);
    L27:
        setChecked(r13);
        MotionEvent r14 = MotionEvent.obtain(r8);
        i.e(r14, "cancel");
        r14.setAction(3);
        super.onTouchEvent(r14);
        r14.recycle();
        super.onTouchEvent(r8);
        return true;
    L24:
        r13 = r12;
        goto L25
    L18:
        if (isEnabled() == false) goto L20;
        r11 = true;
    L11:
        e = move-exception;
        e.printStackTrace();
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }

    @Override // mc.b, android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r10) {
        boolean r8 = isChecked();
        super.setChecked(r10);
        boolean r11 = isChecked();
        int r12 = 255;
        if (isEnabled() == false) goto L11;
        Drawable r13 = getTrackDrawable();
        if (r13 == null) goto L7;
        r13.setAlpha(255);
    L7:
        Drawable r14 = getThumbDrawable();
        if (r14 == null) goto L25;
    L23:
        r14.setAlpha(255);
    L25:
        if (getWindowToken() == null) goto L55;
        WeakHashMap<View, h0> r15 = w.f8437a;
        if (w.g.c(this) == false) goto L55;
        if (r8 == r11) goto L58;
        Drawable r16 = getTrackDrawable();
        if ((r16 instanceof TransitionDrawable) == false) goto L36;
        TransitionDrawable r17 = (TransitionDrawable) r16;
        if (r11 == false) goto L34;
        r17.startTransition(260);
        return;
    L34:
        r17.reverseTransition(100);
        return;
    L36:
        if ((r16 instanceof mc.a) == false) goto L61;
        mc.a r18 = (mc.a) r16;
        if (r11 == false) goto L40;
        r18.f9327d = 0;
        r18.f9328e = 255;
        r18.f9329f = 0;
        r18.f9326c = 260;
        r18.f9330g = false;
        r18.f9324a = 1;
        r18.invalidateSelf();
        return;
    L40:
        r18.getClass();
        long r19 = SystemClock.uptimeMillis();
        if (r18.f9324a != 2) goto L53;
        long r20 = r19 - r18.f9325b;
        int r110 = r18.f9326c;
        if (r20 > r110) goto L53;
        boolean r21 = !r18.f9330g;
        r18.f9330g = r21;
        r18.f9327d = r18.f9329f;
        if (r21 == false) goto L48;
        r12 = 0;
    L48:
        r18.f9328e = r12;
        if (r21 == false) goto L51;
        int r111 = (int) r20;
    L52:
        r18.f9326c = r111;
    L54:
        r18.f9324a = 1;
        r18.invalidateSelf();
        return;
    L51:
        r111 = r110 - ((int) r20);
    L53:
        r18.f9327d = 255;
        r18.f9328e = 0;
        r18.f9329f = 255;
        r18.f9326c = 100;
        r18.f9330g = true;
        goto L54
    L61:
        return;
    L58:
        return;
    L55:
        if (r8 == r11) goto L64;
        c(r11);
        return;
    L64:
        return;
    L11:
        if (isChecked() == false) goto L18;
        Drawable r22 = getTrackDrawable();
        if (r22 == null) goto L15;
        r22.setAlpha(76);
    L15:
        Drawable r23 = getThumbDrawable();
        if (r23 == null) goto L25;
        r23.setAlpha(QesdkUtils.LIMITS.INT_8_UPPER);
        goto L25
    L18:
        Drawable r24 = getTrackDrawable();
        if (r24 == null) goto L21;
        r24.setAlpha(76);
    L21:
        r14 = getThumbDrawable();
        if (r14 == null) goto L25;
        goto L23
    }

    @Override // mc.b
    public void setCheckedNoAnim(boolean r8) {
        boolean r10 = isChecked();
        super.setCheckedNoAnim(r8);
        boolean r11 = isChecked();
        if (r10 == r11) goto L6;
        c(r11);
        return;
    }

    public final void setCheckedWithoutFeedback(boolean r8) {
        if (r8 != isChecked()) goto L5;
    L16:
        super.setChecked(r8);
        return;
    L5:
        if ((getTrackDrawable() instanceof TransitionDrawable) == false) goto L16;
        Drawable r10 = getTrackDrawable();
        if (r8 == false) goto L12;
        if (r10 == null) goto L11;
        ((TransitionDrawable) r10).startTransition(180);
        goto L16
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
    L12:
        if (r10 == null) goto L15;
        ((TransitionDrawable) r10).reverseTransition(180);
        goto L16
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean r8) {
        super.setEnabled(r8);
        if (r8 == false) goto L11;
        Drawable r10 = getTrackDrawable();
        if (r10 == null) goto L7;
        r10.setAlpha(255);
    L7:
        Drawable r11 = getThumbDrawable();
        if (r11 == null) goto L24;
    L9:
        r11.setAlpha(255);
        return;
    L24:
        return;
    L11:
        if (isChecked() == false) goto L18;
        Drawable r12 = getTrackDrawable();
        if (r12 == null) goto L15;
        r12.setAlpha(76);
    L15:
        Drawable r13 = getThumbDrawable();
        if (r13 == null) goto L26;
        r13.setAlpha(QesdkUtils.LIMITS.INT_8_UPPER);
        return;
    L26:
        return;
    L18:
        Drawable r14 = getTrackDrawable();
        if (r14 == null) goto L21;
        r14.setAlpha(76);
    L21:
        r11 = getThumbDrawable();
        if (r11 != null) goto L9;
    }

    public OSwitch(Context r8, AttributeSet r10, int r11) {
        if ((r11 & 2) == 0) goto L6;
        r10 = null;
    L6:
        if ((r11 & 4) == 0) goto L8;
        int r12 = R.attr.OUISwitchStyle;
    L9:
        i.f(r8, "context");
        super(r8, r10, r12);
        TypedArray r13 = r8.obtainStyledAttributes(r10, nb.a.f9507u, r12, 0);
        this.Z = r13.getResourceId(3, 0);
        this.f6366a0 = r13.getResourceId(2, 0);
        r13.recycle();
        if (getThumbDrawable() != null) goto L13;
        Object r14 = a.f1674a;
        setThumbDrawable(a.b.b(r8, R.drawable.o_switch_thumb));
    L13:
        if (getTrackDrawable() != null) goto L19;
        boolean r15 = isChecked();
        mc.a r16 = new mc.a(getUncheckedDrawable(), getCheckedDrawable());
        if (r15 == false) goto L17;
        r16.f9327d = 0;
        r16.f9328e = 255;
        r16.f9329f = 0;
        r16.f9326c = 0;
        r16.f9330g = false;
        r16.f9324a = 1;
        r16.invalidateSelf();
    L18:
        setTrackDrawable(r16);
        goto L19
    L17:
        r16.f9329f = 0;
        r16.f9324a = 0;
        r16.invalidateSelf();
    L19:
        setEnabled(isEnabled());
        return;
    L8:
        r12 = 0;
        goto L9
    }
}
