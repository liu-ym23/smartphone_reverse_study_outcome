package com.obric.oui.common.style;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.obric.common.oea.foundation.animation.token.Token;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import kotlin.Unit;

/* JADX INFO: loaded from: classes5.dex */
public class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<View> f13479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f13480b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private Boolean h;
    private Boolean i;
    private Boolean j;
    private Boolean k;
    private float l;
    private int m;
    private int n;
    private float o;
    private Context p;
    private AttributeSet q;
    private int r;
    private int s;
    private Drawable t;
    private Drawable u;
    private ObjectAnimator v;
    private ObjectAnimator w;
    private long x;
    private long y;
    private int z;

    public c(Context r6, AttributeSet r7, int r8, int r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.memorydata.plugin");
        this.f13480b = true;
        this.c = false;
        this.d = true;
        this.e = true;
        this.f = false;
        this.g = false;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = 1.0f;
        this.m = 0;
        this.n = -1;
        this.o = 0.3f;
        this.x = 1;
        this.y = Token.Duration.OUI_ANIMATION_DURATION_SHORT_4.getDuration();
        this.z = 0;
        this.p = ZeusTransformUtils.wrapperContext(r10, "com.obric.memorydata.plugin");
        this.q = r11;
        this.r = r8;
        this.s = r9;
    }

    private static /* synthetic */ Unit a(boolean r2, View r3) {
        if (ZeusTransformUtils.instanceOf(r3, a.class) == false) goto L7;
        ((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin")).setKeepPressAlpha(r2);
        return null;
    L7:
        return null;
    }

    private void a() {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.f13479a.get(), View.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.f13480b == false) goto L16;
        if (r0.isPressed() == false) goto L10;
    L13:
        Drawable r3 = this.t;
    L14:
        r0.setForeground(r3);
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r0, b.class) == false) goto L16;
        if (((b) ZeusTransformUtils.preCheckCast(r0, b.class, "com.obric.memorydata.plugin")).isFakePressed() == true) goto L13;
    L16:
        if (this.f13480b == false) goto L23;
        if (ZeusTransformUtils.instanceOf(r0, b.class) == false) goto L23;
        if (((b) ZeusTransformUtils.preCheckCast(r0, b.class, "com.obric.memorydata.plugin")).decideIsNeedUpdatePressedForegroundBySelf() == true) goto L13;
    L23:
        if (this.f == true) goto L25;
    L27:
        r3 = null;
        goto L14
    L25:
        if (r0.isSelected() == false) goto L27;
        r3 = this.u;
        goto L14
    }

    private /* synthetic */ void a(ValueAnimator r2) {
        a(r2, "release anim");
    }

    private void a(ValueAnimator r5, String r6) {
        View r4 = (View) ZeusTransformUtils.preCheckCast(this.f13479a.get(), View.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, b.class) == true) goto L5;
        return;
    L5:
        b r7 = (b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.memorydata.plugin");
        Object r8 = r5.getAnimatedValue("alpha");
        if (r7.shouldUpdateDividerColorOnPress() == false) goto L16;
        if (ZeusTransformUtils.instanceOf(r8, Integer.class) == false) goto L16;
        int r0 = ((Integer) ZeusTransformUtils.preCheckCast(r8, Integer.class, "com.obric.memorydata.plugin")).intValue();
        if (r0 >= 0) goto L12;
    L14:
        com.obric.oui.c.a.b.e("OUIAlphaHelper", "pressColorAnimSideEffect, invalid alpha: " + r0 + ", scene: " + r6);
        goto L16
    L12:
        if (r0 > 255) goto L14;
        r7.updateDividerColorStrength((255 - r0) / 255.0f);
    L16:
        if (ZeusTransformUtils.instanceOf(r8, Integer.class) == false) goto L19;
        r7.onPressAlphaChange(((Integer) ZeusTransformUtils.preCheckCast(r8, Integer.class, "com.obric.memorydata.plugin")).intValue());
        return;
    }

    static /* synthetic */ void a(c r0) {
        r0.a();
    }

    private void b() {
        this.v.cancel();
        this.w.cancel();
        this.t.setAlpha(0);
        View r2 = (View) ZeusTransformUtils.preCheckCast(this.f13479a.get(), View.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L6;
        r2.setForeground(null);
        return;
    }

    private /* synthetic */ void b(ValueAnimator r2) {
        a(r2, "press anim");
    }

    private void b(View r6) {
        if (this.z <= 0) goto L5;
        GradientDrawable r0 = new GradientDrawable();
        this.t = r0;
        ((GradientDrawable) ZeusTransformUtils.preCheckCast(r0, GradientDrawable.class, "com.obric.memorydata.plugin")).setCornerRadius(this.z);
        ((GradientDrawable) ZeusTransformUtils.preCheckCast(this.t, GradientDrawable.class, "com.obric.memorydata.plugin")).setColor(this.m);
        GradientDrawable r1 = new GradientDrawable();
        this.u = r1;
        ((GradientDrawable) ZeusTransformUtils.preCheckCast(r1, GradientDrawable.class, "com.obric.memorydata.plugin")).setCornerRadius(this.z);
        ((GradientDrawable) ZeusTransformUtils.preCheckCast(this.u, GradientDrawable.class, "com.obric.memorydata.plugin")).setColor(this.m);
    L6:
        boolean r2 = true;
        if (this.h != null) goto L14;
        if (this.m <= 0) goto L11;
        boolean r3 = true;
    L12:
        this.f13480b = r3;
        goto L14
    L11:
        r3 = false;
    L14:
        if (this.i == null) goto L16;
    L20:
        a(r6, r6.isEnabled());
        if (Build.VERSION.SDK_INT < 23) goto L24;
        ObjectAnimator r7 = ObjectAnimator.ofInt(this.t, "alpha", new int[]{255, 255});
        this.v = r7;
        r7.setDuration(this.x);
        this.v.setInterpolator(null);
        this.v.addUpdateListener(new $$Lambda$c$c2Pp0npYKIHnyFCTefQejO8Y5Nc(this));
        ObjectAnimator r8 = ObjectAnimator.ofInt(this.t, "alpha", new int[]{255, 0});
        this.w = r8;
        r8.setDuration(this.y);
        this.w.setInterpolator(null);
        this.w.addListener(new AnonymousClass1(this));
        this.w.addUpdateListener(new $$Lambda$c$q7aehvJCpIn_q9RkNpgi4KYRGM(this));
        return;
    L24:
        return;
    L16:
        if (this.o > 0.0f) goto L19;
        r2 = false;
    L19:
        this.d = r2;
        goto L20
    L5:
        this.t = new ColorDrawable(this.m);
        this.u = new ColorDrawable(this.m);
        goto L6
    }

    private void c(View r14) {
        int r0 = d(r14);
        int r5 = 0;
        int[] r2 = {ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r14.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_accent_bg, TypedValues.Custom.S_COLOR, "oui_accent_bg")), ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r14.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_functional_red_6, TypedValues.Custom.S_COLOR, "oui_functional_red_6"))};
        this.m = r0;
        TypedArray r3 = this.p.obtainStyledAttributes(this.q, R.styleable.OUIAlpha, this.r, this.s);
        if (this.q == null) goto L5;
    L8:
        int r7 = r3.getIndexCount();
        int r8 = 0;
    L9:
        if (r8 >= r7) goto L18;
        int r9 = r3.getIndex(r8);
        if (r9 != ZeusTransformUtils.mapRes(R.styleable.OUIAlpha_OUI_alpha_pressed, "styleable", "OUIAlpha_OUI_alpha_pressed")) goto L14;
        this.m = r3.getColor(r9, r0);
    L16:
        r8 = r8 + 1;
        goto L9
    L14:
        if (r9 != ZeusTransformUtils.mapRes(R.styleable.OUIAlpha_OUI_alpha_disabled, "styleable", "OUIAlpha_OUI_alpha_disabled")) goto L16;
        this.o = r3.getFloat(r9, -1.0f);
    L18:
        if (this.m != r0) goto L26;
        Drawable r1 = r14.getBackground();
        if (ZeusTransformUtils.instanceOf(r1, ColorDrawable.class) == false) goto L26;
    L21:
        if (r5 >= 2) goto L26;
        if (((ColorDrawable) ZeusTransformUtils.preCheckCast(r1, ColorDrawable.class, "com.obric.memorydata.plugin")).getColor() != r2[r5]) goto L25;
        this.m = ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r14.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_pressed_on_color, TypedValues.Custom.S_COLOR, "oui_pressed_on_color"));
    L25:
        r5 = r5 + 1;
    L26:
        b(r14);
        return;
    L5:
        if (this.r != 0) goto L8;
        if (this.s == 0) goto L18;
        goto L8
    }

    private int d(View r3) {
        int r2 = this.n;
        if (r2 == (-1)) goto L5;
        return r2;
    L5:
        return ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_fill_element_2, TypedValues.Custom.S_COLOR, "oui_fill_element_2"));
    }

    private static /* synthetic */ Unit e(View r2) {
        if (ZeusTransformUtils.instanceOf(r2, a.class) == false) goto L7;
        ((a) ZeusTransformUtils.preCheckCast(r2, a.class, "com.obric.memorydata.plugin")).resetAlphaAnim();
        return null;
    L7:
        return null;
    }

    /* JADX INFO: renamed from: lambda$bOFXdpxIby8SVEBEPdi-lNmUj3s, reason: not valid java name */
    public static /* synthetic */ Unit m1275lambda$bOFXdpxIby8SVEBEPdilNmUj3s(View r0) {
        return e(r0);
    }

    public static /* synthetic */ void lambda$c2Pp0npYKIHnyFCTefQejO8Y5Nc(c r0, ValueAnimator r1) {
        r0.b(r1);
    }

    /* JADX INFO: renamed from: lambda$q7aehvJCpIn_q9RkNpgi4KY-RGM, reason: not valid java name */
    public static /* synthetic */ void m1276lambda$q7aehvJCpIn_q9RkNpgi4KYRGM(c r0, ValueAnimator r1) {
        r0.a(r1);
    }

    public static /* synthetic */ Unit lambda$vqcADeSs87GANxc1Xu6LCJIUEHQ(boolean r0, View r1) {
        return a(r0, r1);
    }

    public void a(int r3) {
        if (this.z == r3) goto L10;
        this.z = r3;
        View r4 = (View) ZeusTransformUtils.preCheckCast(this.f13479a.get(), View.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L8;
        com.obric.oui.c.a.b.e("OUIAlphaHelper", "setRadius: owner is null");
        return;
    L8:
        b(r4);
        return;
    }

    public void a(View r2) {
        this.f13479a = new WeakReference(r2);
        c(r2);
    }

    public void a(View r4, boolean r5) {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.f13479a.get(), View.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.d == false) goto L10;
        if (r5 == true) goto L10;
        float r1 = this.o;
    L11:
        if (r4 == r0) goto L16;
        if (r0.isEnabled() == r5) goto L16;
        r0.setEnabled(r5);
    L16:
        if (this.e == true) goto L18;
        return;
    L18:
        r0.setAlpha(r1);
        return;
    L10:
        r1 = this.l;
        goto L11
    }

    public void a(boolean r3, boolean r4) {
        this.h = Boolean.valueOf(r3);
        this.f13480b = r3;
        View r5 = (View) ZeusTransformUtils.preCheckCast(this.f13479a.get(), View.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L7;
        if (r4 == false) goto L8;
        onPressedChanged(r5, r5.isPressed());
        return;
    L8:
        return;
    }

    @Override // com.obric.oui.common.style.a
    public void disablePressReleaseAnim(boolean r2) {
        this.k = Boolean.valueOf(r2);
        this.g = r2;
    }

    @Override // com.obric.oui.common.style.a
    public void handleTouchEvent(MotionEvent r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        int r3 = r2.getAction();
        if (r3 == 1) goto L10;
        if (r3 == 3) goto L10;
        return;
    L10:
        if (this.g == false) goto L13;
        b();
        return;
    }

    @Override // com.obric.oui.common.style.a
    public void onPressedChanged(View r3, boolean r4) {
        View r5 = (View) ZeusTransformUtils.preCheckCast(this.f13479a.get(), View.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        this.v.cancel();
        this.w.cancel();
        if (r5.isEnabled() == true) goto L9;
        return;
    L9:
        if (this.f13480b == true) goto L11;
        return;
    L11:
        if (this.c == true) goto L20;
        if (r4 == false) goto L16;
        a();
        ObjectAnimator r2 = this.v;
    L14:
        r2.start();
        return;
    L16:
        if (this.g == false) goto L18;
        b();
        return;
    L18:
        r2 = this.w;
        goto L14
    }

    @Override // com.obric.oui.common.style.a
    public void onSelectedChanged(View r1, boolean r2) {
        if (this.f == false) goto L6;
        a();
        return;
    }

    @Override // com.obric.oui.common.style.a
    public void refreshColors(String r3) {
        View r4 = (View) ZeusTransformUtils.preCheckCast(this.f13479a.get(), View.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L6;
        com.obric.oui.c.a.b.e("OUIAlphaHelper", "refreshColors: owner is null");
        return;
    L6:
        c(r4);
    }

    @Override // com.obric.oui.common.style.a
    public void resetAlphaAnim() {
        this.c = false;
        if (this.f13480b == false) goto L5;
        b();
    L5:
        com.obric.oui.c.h.a((View) ZeusTransformUtils.preCheckCast(this.f13479a.get(), View.class, "com.obric.memorydata.plugin"), $$Lambda$c$bOFXdpxIby8SVEBEPdilNmUj3s.INSTANCE);
    }

    @Override // com.obric.oui.common.style.a
    public void setChangeAlphaWhenDisable(boolean r3) {
        this.i = Boolean.valueOf(r3);
        this.d = r3;
        View r4 = (View) ZeusTransformUtils.preCheckCast(this.f13479a.get(), View.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L6;
        a(r4, r4.isEnabled());
        return;
    }

    @Override // com.obric.oui.common.style.a
    public void setChangeAlphaWhenEnabledChanged(boolean r1) {
        this.e = r1;
    }

    @Override // com.obric.oui.common.style.a
    public void setChangeAlphaWhenPress(boolean r2) {
        a(r2, false);
    }

    @Override // com.obric.oui.common.style.a
    public void setChangeAlphaWhenSelected(boolean r2) {
        this.j = Boolean.valueOf(r2);
        this.f = r2;
    }

    @Override // com.obric.oui.common.style.a
    public void setKeepPressAlpha(final boolean r4) {
        com.obric.oui.c.a.b.a("OUIAlphaHelper", "setKeepPressAlpha, " + r4 + ", target: " + this.f13479a.get());
        if (this.c == r4) goto L7;
        this.c = r4;
        if (r4 == true) goto L7;
        onPressedChanged((View) ZeusTransformUtils.preCheckCast(this.f13479a.get(), View.class, "com.obric.memorydata.plugin"), false);
    L7:
        com.obric.oui.c.h.a((View) ZeusTransformUtils.preCheckCast(this.f13479a.get(), View.class, "com.obric.memorydata.plugin"), new $$Lambda$c$vqcADeSs87GANxc1Xu6LCJIUEHQ(r4));
    }

    @Override // com.obric.oui.common.style.a
    public void setOverridePressColor(int r2) {
        if (this.n == r2) goto L6;
        this.n = r2;
        return;
    }
}
