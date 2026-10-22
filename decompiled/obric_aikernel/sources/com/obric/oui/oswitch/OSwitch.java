package com.obric.oui.oswitch;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.obric.oui.common.util.k;
import com.ttnet.org.chromium.base.BaseSwitches;
import da.c;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import u8.b;
import u8.e;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001fB'\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0007J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0016R\u0016\u0010\u0010\u001a\u00020\r8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00058B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006 "}, d2 = {"Lcom/obric/oui/oswitch/OSwitch;", "Lcom/obric/oui/oswitch/SwitchCompat;", "Landroid/graphics/drawable/Drawable;", "getUncheckedDrawable", "getCheckedDrawable", "", "enabled", "", "setEnabled", "checked", "setCheckedWithoutFeedback", "setChecked", "setCheckedNoAnim", "", "getThumbPosition", "()F", "thumbPosition", "getTargetCheckedState", "()Z", "targetCheckedState", "", "getTouchMode", "()I", "touchMode", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OSwitch extends SwitchCompat {

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private int f6907d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private int f6908e0;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
    }

    @JvmOverloads
    public OSwitch(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public OSwitch(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public OSwitch(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        int[] r13 = l.OSwitch;
        Intrinsics.checkNotNullExpressionValue(r13, "R.styleable.OSwitch");
        TypedArray r14 = r10.obtainStyledAttributes(r11, r13, r12, 0);
        this.f6907d0 = r14.getResourceId(l.OSwitch_oui_trackUnchecked, 0);
        this.f6908e0 = r14.getResourceId(l.OSwitch_oui_trackChecked, 0);
        r14.recycle();
        if (getThumbDrawable() != null) goto L6;
        setThumbDrawable(ContextCompat.getDrawable(r10, e.o_switch_thumb));
    L6:
        if (getTrackDrawable() != null) goto L8;
        setTrackDrawable(r(r10, isChecked()));
    L8:
        setEnabled(isEnabled());
    }

    public /* synthetic */ OSwitch(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = b.OUISwitchStyle;
    L8:
        this(r10, r11, r12);
    }

    private final Drawable getCheckedDrawable() {
        if (this.f6908e0 != 0) goto L5;
        Drawable r10 = ContextCompat.getDrawable(getContext(), e.o_switch_track_checked);
        Intrinsics.checkNotNull(r10);
        Drawable r11 = r10.mutate();
        String r12 = "ContextCompat.getDrawabl…                .mutate()";
    L6:
        Intrinsics.checkNotNullExpressionValue(r11, r12);
        return r11;
    L5:
        Drawable r13 = ContextCompat.getDrawable(getContext(), this.f6908e0);
        Intrinsics.checkNotNull(r13);
        r11 = r13.mutate();
        r12 = "ContextCompat.getDrawabl… trackChecked)!!.mutate()";
        goto L6
    }

    private final boolean getTargetCheckedState() {
        if (getThumbPosition() <= 0.5f) goto L5;
        return true;
    L5:
        return false;
    }

    private final float getThumbPosition() {
        Field r10 = SwitchCompat.class.getDeclaredField("C");     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        Intrinsics.checkNotNullExpressionValue(r10, BaseSwitches.V);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        r10.setAccessible(true);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        Object r11 = r10.get(this);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        if (r11 == null) goto L6;
        return ((Float) r11).floatValue();
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
        Field r10 = SwitchCompat.class.getDeclaredField("w");     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        Intrinsics.checkNotNullExpressionValue(r10, BaseSwitches.V);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        r10.setAccessible(true);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        Object r11 = r10.get(this);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        if (r11 == null) goto L6;
        return ((Integer) r11).intValue();
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
        if (this.f6907d0 != 0) goto L5;
        Drawable r10 = ContextCompat.getDrawable(getContext(), e.o_switch_track_unchecked);
        Intrinsics.checkNotNull(r10);
        Drawable r11 = r10.mutate();
        String r12 = "ContextCompat.getDrawabl…                .mutate()";
    L6:
        Intrinsics.checkNotNullExpressionValue(r11, r12);
        return r11;
    L5:
        Drawable r13 = ContextCompat.getDrawable(getContext(), this.f6907d0);
        Intrinsics.checkNotNull(r13);
        r11 = r13.mutate();
        r12 = "ContextCompat.getDrawabl…rackUnchecked)!!.mutate()";
        goto L6
    }

    private final void m(MotionEvent r10) {
        u();
        boolean r11 = true;
        if (r10.getAction() == 1) goto L5;
    L7:
        r11 = false;
    L8:
        boolean r12 = isChecked();
        if (r11 == false) goto L11;
        boolean r13 = getTargetCheckedState();
    L12:
        if (r13 == r12) goto L14;
        playSoundEffect(0);
    L14:
        setChecked(r13);
        MotionEvent r14 = MotionEvent.obtain(r10);
        Intrinsics.checkNotNullExpressionValue(r14, "cancel");
        r14.setAction(3);
        super.onTouchEvent(r14);
        r14.recycle();
        return;
    L11:
        r13 = r12;
        goto L12
    L5:
        if (isEnabled() == false) goto L7;
        goto L7
    }

    private final void n(boolean r10) {
        Drawable r11 = getTrackDrawable();
        if ((r11 instanceof TransitionDrawable) == false) goto L9;
        TransitionDrawable r12 = (TransitionDrawable) r11;
        if (r10 == false) goto L7;
        s(r12);
        return;
    L7:
        r12.resetTransition();
        return;
    L9:
        if ((r11 instanceof v9.a) == false) goto L17;
        v9.a r13 = (v9.a) r11;
        if (r10 == false) goto L13;
        r13.d();
        return;
    L13:
        r13.b();
        return;
    }

    private final void o(boolean r10) {
        Drawable r11 = getTrackDrawable();
        if ((r11 instanceof TransitionDrawable) == false) goto L9;
        TransitionDrawable r12 = (TransitionDrawable) r11;
        if (r10 == false) goto L7;
        r12.startTransition(260);
        return;
    L7:
        r12.reverseTransition(100);
        return;
    L9:
        if ((r11 instanceof v9.a) == false) goto L17;
        v9.a r13 = (v9.a) r11;
        if (r10 == false) goto L13;
        r13.e(260);
        return;
    L13:
        r13.c(100);
        return;
    }

    private final void p(int r13, int r14) {
        measure(0, 0);     // Catch: Exception -> L21
        int r10 = getMeasuredWidth();     // Catch: Exception -> L21
        int r11 = getMeasuredHeight();     // Catch: Exception -> L21
        if (r10 <= 0) goto L20;
        if (r11 <= 0) goto L26;
        Resources r12 = Resources.getSystem();     // Catch: Exception -> L21
        Intrinsics.checkNotNullExpressionValue(r12, "Resources.getSystem()");     // Catch: Exception -> L21
        int r15 = MathKt.roundToInt(TypedValue.applyDimension(1, r13, r12.getDisplayMetrics())) + r10;     // Catch: Exception -> L21
        Resources r16 = Resources.getSystem();     // Catch: Exception -> L21
        Intrinsics.checkNotNullExpressionValue(r16, "Resources.getSystem()");     // Catch: Exception -> L21
        int r17 = MathKt.roundToInt(TypedValue.applyDimension(1, r14, r16.getDisplayMetrics())) + r11;     // Catch: Exception -> L21
        c r18 = c.f8520a;     // Catch: Exception -> L21
        ViewParent r19 = getParent();     // Catch: Exception -> L21
        if (r19 != null) goto L11;
    L9:
        r19 = null;
    L12:
        ViewGroup r20 = (ViewGroup) r19;     // Catch: Exception -> L21
        if (r20 == null) goto L18;
        r20.measure(0, 0);     // Catch: Exception -> L21
        int r21 = r20.getMeasuredWidth();     // Catch: Exception -> L21
        if (r17 > r20.getMeasuredHeight()) goto L17;
        if (r15 <= r21) goto L18;
    L17:
        k.c(r20, r15, r17, false, 4, null);     // Catch: Exception -> L21
    L18:
        k.c(this, r15, r17, false, 4, null);     // Catch: Exception -> L21
        return;
    L11:
        if ((r19 instanceof ViewGroup) == false) goto L9;
    L26:
        return;
    L20:
        return;
    L21:
        e = move-exception;
        ea.b.c("OSwitch", "increaseTouchArea, error", e);
    }

    static /* synthetic */ void q(OSwitch r10, int r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = 20;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r12 = 20;
    L8:
        r10.p(r11, r12);
    }

    private final v9.a r(Context r10, boolean r11) {
        v9.a r12 = new v9.a(getUncheckedDrawable(), getCheckedDrawable());
        if (r11 == false) goto L5;
        r12.e(0);
    L6:
        return r12;
    L5:
        r12.b();
        goto L6
    }

    private final Object s(TransitionDrawable r10) {
        Method r11 = TransitionDrawable.class.getDeclaredMethod("showSecondLayer", new Class[0]);     // Catch: Exception -> L4
        Intrinsics.checkNotNullExpressionValue(r11, "showSecondLayerMethod");     // Catch: Exception -> L4
        r11.setAccessible(true);     // Catch: Exception -> L4
        return r11.invoke(r10, new Object[0]);
    L4:
        e = move-exception;
        ea.b.c("OSwitch", "reflectShowSecondLayer, error", e);
        return Unit.INSTANCE;
    }

    private final void t(boolean r10, boolean r11) {
        if (r10 == isChecked()) goto L11;
        if (r11 == false) goto L11;
        if ((getTrackDrawable() instanceof TransitionDrawable) == false) goto L11;
        Drawable r12 = getTrackDrawable();
        Objects.requireNonNull(r12, "null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
        TransitionDrawable r13 = (TransitionDrawable) r12;
        if (r10 == false) goto L10;
        r13.startTransition(180);
        goto L11
    L10:
        r13.reverseTransition(180);
    L11:
        super.setChecked(r10);
    }

    private final void u() {
        Field r10 = SwitchCompat.class.getDeclaredField("w");     // Catch: IllegalAccessException -> L4 NoSuchFieldException -> L6
        Intrinsics.checkNotNullExpressionValue(r10, BaseSwitches.V);     // Catch: IllegalAccessException -> L4 NoSuchFieldException -> L6
        r10.setAccessible(true);     // Catch: IllegalAccessException -> L4 NoSuchFieldException -> L6
        r10.set(this, 0);     // Catch: IllegalAccessException -> L4 NoSuchFieldException -> L6
    L12:
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        q(this, 0, 0, 3, null);
    }

    @Override // com.obric.oui.oswitch.SwitchCompat, android.widget.TextView, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // com.obric.oui.oswitch.SwitchCompat, android.widget.TextView, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
    }

    @Override // com.obric.oui.oswitch.SwitchCompat, android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "ev");
        if (r10.getAction() == 3) goto L7;
        if (r10.getAction() == 1) goto L7;
    L11:
        return super.onTouchEvent(r10);
    L7:
        if (getTouchMode() != 2) goto L11;
        m(r10);
        super.onTouchEvent(r10);
        return true;
    }

    @Override // com.obric.oui.oswitch.SwitchCompat, android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r10) {
        boolean r11 = isChecked();
        super.setChecked(r10);
        boolean r12 = isChecked();
        int r13 = 255;
        if (isEnabled() == false) goto L11;
        Drawable r14 = getTrackDrawable();
        if (r14 == null) goto L7;
        r14.setAlpha(255);
    L7:
        Drawable r15 = getThumbDrawable();
        if (r15 == null) goto L25;
    L9:
        r15.setAlpha(r13);
    L25:
        if (getWindowToken() != null) goto L27;
    L30:
        if (r11 == r12) goto L35;
        n(r12);
        return;
    L35:
        return;
    L27:
        if (ViewCompat.isLaidOut(this) == false) goto L30;
        if (r11 == r12) goto L33;
        o(r12);
        return;
    L33:
        return;
    L11:
        if (isChecked() == false) goto L18;
        Drawable r16 = getTrackDrawable();
        if (r16 == null) goto L15;
        r16.setAlpha(76);
    L15:
        r15 = getThumbDrawable();
        if (r15 == null) goto L25;
        r13 = 127;
        goto L9
    L18:
        Drawable r17 = getTrackDrawable();
        if (r17 == null) goto L21;
        r17.setAlpha(76);
    L21:
        r15 = getThumbDrawable();
        if (r15 == null) goto L25;
        goto L9
    }

    @Override // com.obric.oui.oswitch.SwitchCompat
    public void setCheckedNoAnim(boolean r10) {
        boolean r11 = isChecked();
        super.setCheckedNoAnim(r10);
        boolean r12 = isChecked();
        if (r11 == r12) goto L6;
        n(r12);
        return;
    }

    @Deprecated(message = "use setHapticFeedbackEnabled instead")
    public final void setCheckedWithoutFeedback(boolean r10) {
        t(r10, true);
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean r10) {
        super.setEnabled(r10);
        if (r10 == false) goto L11;
        Drawable r11 = getTrackDrawable();
        if (r11 == null) goto L7;
        r11.setAlpha(255);
    L7:
        Drawable r12 = getThumbDrawable();
        if (r12 == null) goto L24;
    L9:
        r12.setAlpha(255);
        return;
    L24:
        return;
    L11:
        if (isChecked() == false) goto L18;
        Drawable r13 = getTrackDrawable();
        if (r13 == null) goto L15;
        r13.setAlpha(76);
    L15:
        Drawable r14 = getThumbDrawable();
        if (r14 == null) goto L26;
        r14.setAlpha(127);
        return;
    L26:
        return;
    L18:
        Drawable r15 = getTrackDrawable();
        if (r15 == null) goto L21;
        r15.setAlpha(76);
    L21:
        r12 = getThumbDrawable();
        if (r12 != null) goto L9;
    }
}
