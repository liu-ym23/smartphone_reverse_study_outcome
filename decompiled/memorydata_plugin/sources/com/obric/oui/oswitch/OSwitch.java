package com.obric.oui.oswitch;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.security.obric.guard.ObricSecurityGuardStub;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.content.ContextCompat;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.obric.memorydata.plugin.R;
import com.obric.oui.c.c;
import com.obric.oui.common.util.h;
import com.obric.oui.common.util.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 B2\u00020\u0001:\u0001BB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\nH\u0002J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\nH\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0002J\u001c\u0010\u001e\u001a\u00020\u00182\b\b\u0002\u0010\u001f\u001a\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u0007H\u0002J\u001a\u0010!\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\nH\u0002J\u0018\u0010\"\u001a\u00020#2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\nH\u0002J\b\u0010$\u001a\u00020\u0018H\u0014J0\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H\u0014J\u0018\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0007H\u0016J\u0010\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u000200H\u0016J\u000e\u00101\u001a\u00020\u00182\u0006\u00102\u001a\u00020\nJ\u0010\u00103\u001a\u00020\u00182\u0006\u00104\u001a\u00020\nH\u0016J\u0018\u00105\u001a\u00020\u00182\u0006\u00104\u001a\u00020\n2\u0006\u00106\u001a\u00020\nH\u0002J\u0010\u00107\u001a\u00020\u00182\u0006\u00104\u001a\u00020\nH\u0016J\u0010\u00108\u001a\u00020\u00182\u0006\u00104\u001a\u00020\nH\u0007J\u0010\u00109\u001a\u00020\u00182\u0006\u0010:\u001a\u00020\nH\u0016J\b\u0010;\u001a\u00020\u0018H\u0002J\u0010\u0010<\u001a\u00020\u00182\u0006\u0010/\u001a\u000200H\u0002J\b\u0010=\u001a\u00020\u0018H\u0002J\u0014\u0010>\u001a\n @*\u0004\u0018\u00010?0?*\u00020AH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/obric/oui/oswitch/OSwitch;", "Lcom/obric/oui/oswitch/SwitchCompat;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "changeAlphaWhenDisable", "", "targetCheckedState", "getTargetCheckedState", "()Z", "thumbPosition", "", "getThumbPosition", "()F", "touchMode", "getTouchMode", "()I", "trackChecked", "trackUnchecked", "changeTrackDrawableStateWithoutAnim", "", "isChecked", "doTrackDrawableTransitionAnim", "getCheckedDrawable", "Landroid/graphics/drawable/Drawable;", "getUncheckedDrawable", "increaseTouchArea", "xAmount", "yAmount", "makeAndroidTransitionDrawable", "makeCustomTransitionDrawable", "Lcom/obric/oui/oswitch/CustomTransitionDrawable;", "onAttachedToWindow", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onTouchEvent", "ev", "Landroid/view/MotionEvent;", "setChangeAlphaWhenDisable", "change", "setChecked", "checked", "setCheckedInner", "withAnim", "setCheckedNoAnim", "setCheckedWithoutFeedback", "setEnabled", "enabled", "setIdleTouchMode", "stopDrag", "updateAlphaState", "reflectShowSecondLayer", "", "kotlin.jvm.PlatformType", "Landroid/graphics/drawable/TransitionDrawable;", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSwitch extends SwitchCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14242a = null;
    private int c;
    private int d;
    private boolean e;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/oswitch/OSwitch$Companion;", "", "()V", "TAG", "", "USE_CUSTOM_TRANSITION_DRAWABLE", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f14242a = new a(null);
    }

    public OSwitch(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OSwitch(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OSwitch(Context r6, AttributeSet r7, int r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10, r8);
        this.e = true;
        int[] r2 = R.styleable.OSwitch;
        Intrinsics.checkNotNullExpressionValue(r2, "OSwitch");
        TypedArray r11 = r9.obtainStyledAttributes(r10, r2, r8, 0);
        Intrinsics.checkNotNullExpressionValue(r11, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        this.c = r11.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OSwitch_oui_trackUnchecked, "styleable", "OSwitch_oui_trackUnchecked"), 0);
        this.d = r11.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OSwitch_oui_trackChecked, "styleable", "OSwitch_oui_trackChecked"), 0);
        this.e = r11.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OSwitch_oui_disabledAlpha, "styleable", "OSwitch_oui_disabledAlpha"), true);
        r11.recycle();
        if (getThumbDrawable() != null) goto L6;
        setThumbDrawable(ContextCompat.getDrawable(r9, ZeusTransformUtils.mapRes(R.drawable.o_switch_thumb, "drawable", "o_switch_thumb")));
    L6:
        if (getTrackDrawable() != null) goto L8;
        setTrackDrawable((Drawable) ZeusTransformUtils.preCheckCast(a(r9, isChecked()), Drawable.class, "com.obric.memorydata.plugin"));
    L8:
        setEnabled(isEnabled());
    }

    public /* synthetic */ OSwitch(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = ZeusTransformUtils.mapRes(R.attr.OUISwitchStyle, "attr", "OUISwitchStyle");
    L8:
        this(r7, r8, r4);
    }

    private final com.obric.oui.oswitch.a a(Context r3, boolean r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        com.obric.oui.oswitch.a r0 = new com.obric.oui.oswitch.a(getUncheckedDrawable(), getCheckedDrawable());
        if (r4 == false) goto L5;
        r0.a(0);
    L6:
        return r0;
    L5:
        r0.a();
        goto L6
    }

    private final Object a(TransitionDrawable r4) {
        Method r3 = TransitionDrawable.class.getDeclaredMethod("showSecondLayer", new Class[0]);     // Catch: Exception -> L4
        r3.setAccessible(true);     // Catch: Exception -> L4
        return r3.invoke(r4, new Object[0]);
    L4:
        e = move-exception;
        com.obric.oui.c.a.b.a("OSwitch", "reflectShowSecondLayer, error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    private final void a(int r11, int r12) {
        measure(0, 0);     // Catch: Exception -> L21
        int r2 = getMeasuredWidth();     // Catch: Exception -> L21
        int r3 = getMeasuredHeight();     // Catch: Exception -> L21
        if (r2 <= 0) goto L20;
        if (r3 <= 0) goto L26;
        int r13 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r11) + r2;     // Catch: Exception -> L21
        int r14 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r12) + r3;     // Catch: Exception -> L21
        c r4 = c.f13403a;     // Catch: Exception -> L21
        ViewParent r5 = getParent();     // Catch: Exception -> L21
        if (r5 != null) goto L11;
    L9:
        r5 = null;
    L12:
        ViewGroup r6 = (ViewGroup) ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L21
        if (r6 == null) goto L18;
        r6.measure(0, 0);     // Catch: Exception -> L21
        int r1 = r6.getMeasuredWidth();     // Catch: Exception -> L21
        if (r14 > r6.getMeasuredHeight()) goto L17;
        if (r13 <= r1) goto L18;
    L17:
        o.a((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin"), r13, r14, false, 4, null);     // Catch: Exception -> L21
    L18:
        o.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r13, r14, false, 4, null);     // Catch: Exception -> L21
        return;
    L11:
        if (ZeusTransformUtils.instanceOf(r5, ViewGroup.class) == false) goto L9;
    L26:
        return;
    L20:
        return;
    L21:
        e = move-exception;
        com.obric.oui.c.a.b.a("OSwitch", "increaseTouchArea, error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final void a(MotionEvent r4) {
        c();
        boolean r2 = true;
        if (r4.getAction() == 1) goto L5;
    L7:
        r2 = false;
    L8:
        boolean r0 = isChecked();
        if (r2 == false) goto L11;
        boolean r3 = getTargetCheckedState();
    L12:
        if (r3 == r0) goto L14;
        playSoundEffect(0);
    L14:
        setChecked(r3);
        MotionEvent r5 = MotionEvent.obtain(r4);
        r5.setAction(3);
        Intrinsics.checkNotNullExpressionValue(r5, ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL);
        super.onTouchEvent(r5);
        r5.recycle();
        return;
    L11:
        r3 = r0;
        goto L12
    L5:
        if (isEnabled() == false) goto L7;
        goto L7
    }

    static /* synthetic */ void a(OSwitch r1, int r2, int r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = 20;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = 20;
    L8:
        r1.a(r2, r3);
    }

    private final void a(boolean r4, boolean r5) {
        if (r4 == isChecked()) goto L11;
        if (r5 == false) goto L11;
        if (ZeusTransformUtils.instanceOf(getTrackDrawable(), TransitionDrawable.class) == false) goto L11;
        Drawable r2 = getTrackDrawable();
        Objects.requireNonNull(r2, "null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
        TransitionDrawable r0 = (TransitionDrawable) ZeusTransformUtils.preCheckCast(r2, TransitionDrawable.class, "com.obric.memorydata.plugin");
        if (r4 == false) goto L10;
        r0.startTransition(SubsamplingScaleImageView.ORIENTATION_180);
        goto L11
    L10:
        r0.reverseTransition(SubsamplingScaleImageView.ORIENTATION_180);
    L11:
        super.setChecked(r4);
    }

    private final void b() {
        if (this.e == true) goto L5;
        Drawable r0 = getTrackDrawable();
        if (r0 == null) goto L34;
        r0.setAlpha(255);
    L34:
        Drawable r3 = getThumbDrawable();
        if (r3 == null) goto L43;
    L37:
        r3.setAlpha(255);
        return;
    L43:
        return;
    L5:
        if (isEnabled() == false) goto L14;
        Drawable r1 = getTrackDrawable();
        if (r1 == null) goto L10;
        r1.setAlpha(255);
    L10:
        r3 = getThumbDrawable();
        if (r3 != null) goto L37;
        return;
    L14:
        if (isChecked() == false) goto L23;
        Drawable r2 = getTrackDrawable();
        if (r2 == null) goto L19;
        r2.setAlpha(76);
    L19:
        Drawable r4 = getThumbDrawable();
        if (r4 == null) goto L41;
        r4.setAlpha(127);
        return;
    L41:
        return;
    L23:
        Drawable r5 = getTrackDrawable();
        if (r5 == null) goto L27;
        r5.setAlpha(76);
    L27:
        r3 = getThumbDrawable();
        if (r3 != null) goto L37;
    }

    private final void b(boolean r5) {
        Drawable r4 = getTrackDrawable();
        if (ZeusTransformUtils.instanceOf(r4, TransitionDrawable.class) == false) goto L8;
        if (r5 == false) goto L6;
        ((TransitionDrawable) ZeusTransformUtils.preCheckCast(r4, TransitionDrawable.class, "com.obric.memorydata.plugin")).startTransition(260);
        return;
    L6:
        ((TransitionDrawable) ZeusTransformUtils.preCheckCast(r4, TransitionDrawable.class, "com.obric.memorydata.plugin")).reverseTransition(100);
        return;
    L8:
        if (ZeusTransformUtils.instanceOf(r4, com.obric.oui.oswitch.a.class) == false) goto L15;
        if (r5 == false) goto L11;
        ((com.obric.oui.oswitch.a) ZeusTransformUtils.preCheckCast(r4, com.obric.oui.oswitch.a.class, "com.obric.memorydata.plugin")).a(260);
        return;
    L11:
        ((com.obric.oui.oswitch.a) ZeusTransformUtils.preCheckCast(r4, com.obric.oui.oswitch.a.class, "com.obric.memorydata.plugin")).b(100);
        return;
    }

    private final void c() {
        Field r0 = SwitchCompat.class.getDeclaredField("s");     // Catch: IllegalAccessException -> L4 NoSuchFieldException -> L6
        r0.setAccessible(true);     // Catch: IllegalAccessException -> L4 NoSuchFieldException -> L6
        r0.set(this, 0);     // Catch: IllegalAccessException -> L4 NoSuchFieldException -> L6
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

    private final void c(boolean r4) {
        Drawable r0 = getTrackDrawable();
        if (ZeusTransformUtils.instanceOf(r0, TransitionDrawable.class) == false) goto L8;
        if (r4 == false) goto L6;
        a((TransitionDrawable) ZeusTransformUtils.preCheckCast(r0, TransitionDrawable.class, "com.obric.memorydata.plugin"));
        return;
    L6:
        ((TransitionDrawable) ZeusTransformUtils.preCheckCast(r0, TransitionDrawable.class, "com.obric.memorydata.plugin")).resetTransition();
        return;
    L8:
        if (ZeusTransformUtils.instanceOf(r0, com.obric.oui.oswitch.a.class) == false) goto L16;
        com.obric.oui.oswitch.a r3 = (com.obric.oui.oswitch.a) ZeusTransformUtils.preCheckCast(r0, com.obric.oui.oswitch.a.class, "com.obric.memorydata.plugin");
        if (r4 == false) goto L12;
        r3.b();
        return;
    L12:
        r3.a();
        return;
    }

    private final Drawable getCheckedDrawable() {
        if (this.d != 0) goto L5;
        Drawable r3 = ContextCompat.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.drawable.o_switch_track_checked, "drawable", "o_switch_track_checked"));
        Intrinsics.checkNotNull(r3);
        Drawable r4 = r3.mutate();
        String r0 = "{\n            ContextCom…      .mutate()\n        }";
    L6:
        Intrinsics.checkNotNullExpressionValue(r4, r0);
        return r4;
    L5:
        Drawable r5 = ContextCompat.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this.d);
        Intrinsics.checkNotNull(r5);
        r4 = r5.mutate();
        r0 = "{\n            ContextCom…ked)!!.mutate()\n        }";
        goto L6
    }

    private final boolean getTargetCheckedState() {
        if (getThumbPosition() <= 0.5f) goto L5;
        return true;
    L5:
        return false;
    }

    private final float getThumbPosition() {
        Field r0 = SwitchCompat.class.getDeclaredField("y");     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        r0.setAccessible(true);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        Object r2 = r0.get(this);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        if (r2 == null) goto L6;
        return ((Float) ZeusTransformUtils.preCheckCast(r2, Float.class, "com.obric.memorydata.plugin")).floatValue();
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
        Field r0 = SwitchCompat.class.getDeclaredField("s");     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        r0.setAccessible(true);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        Object r2 = r0.get(this);     // Catch: IllegalAccessException -> L7 NoSuchFieldException -> L9
        if (r2 == null) goto L6;
        return ((Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.memorydata.plugin")).intValue();
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
        if (this.c != 0) goto L5;
        Drawable r3 = ContextCompat.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.drawable.o_switch_track_unchecked, "drawable", "o_switch_track_unchecked"));
        Intrinsics.checkNotNull(r3);
        Drawable r4 = r3.mutate();
        String r0 = "{\n            ContextCom…      .mutate()\n        }";
    L6:
        Intrinsics.checkNotNullExpressionValue(r4, r0);
        return r4;
    L5:
        Drawable r5 = ContextCompat.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this.c);
        Intrinsics.checkNotNull(r5);
        r4 = r5.mutate();
        r0 = "{\n            ContextCom…ked)!!.mutate()\n        }";
        goto L6
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a(this, 0, 0, 3, null);
    }

    @Override // com.obric.oui.oswitch.SwitchCompat, android.widget.TextView, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // com.obric.oui.oswitch.SwitchCompat, android.widget.TextView, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // com.obric.oui.oswitch.SwitchCompat, android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "ev");
        if (r4.getAction() == 3) goto L7;
        if (r4.getAction() == 1) goto L7;
    L11:
        return super.onTouchEvent(r4);
    L7:
        if (getTouchMode() != 2) goto L11;
        a(r4);
        super.onTouchEvent(r4);
        return true;
    }

    public final void setChangeAlphaWhenDisable(boolean r2) {
        if (this.e == r2) goto L6;
        this.e = r2;
        b();
        return;
    }

    @Override // com.obric.oui.oswitch.SwitchCompat, android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r3) {
        boolean r0 = isChecked();
        super.setChecked(r3);
        boolean r4 = isChecked();
        b();
        if (getWindowToken() != null) goto L5;
    L8:
        c(r4);
        return;
    L5:
        if (a() == false) goto L8;
        if (r0 == r4) goto L10;
        b(r4);
        return;
    }

    @Override // com.obric.oui.oswitch.SwitchCompat
    public void setCheckedNoAnim(boolean r1) {
        super.setCheckedNoAnim(r1);
        c(r1);
    }

    @Deprecated(message = "use setHapticFeedbackEnabled instead")
    public final void setCheckedWithoutFeedback(boolean r2) {
        a(r2, true);
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean r1) {
        super.setEnabled(r1);
        b();
    }
}
