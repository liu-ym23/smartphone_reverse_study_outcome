package com.obric.oui.common.style;

import android.R;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.util.StateSet;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Keep;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 F2\u00020\u0001:\u0001GB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\nJG\u0010\u0012\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0012\u0010\u0016JO\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u001aJ\r\u0010\u001b\u001a\u00020\b¢\u0006\u0004\b\u001b\u0010\u0003J\u000f\u0010\u001c\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001eH\u0014¢\u0006\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010$\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010#R\u0016\u0010%\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010#R\u0016\u0010&\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010#R\u0016\u0010'\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010#R\u0016\u0010(\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010#R\u0016\u0010)\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010#R\u0016\u0010*\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010#R\u0016\u0010+\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010#R\u0016\u0010,\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010#R\u0016\u0010-\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010#R\u0016\u0010.\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010#R\u0016\u0010/\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010#R\u0016\u00100\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010#R\u0016\u00101\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010#R\u0016\u00102\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010#R\u0016\u00103\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u0010#R\u0018\u00105\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00106R\"\u00109\u001a\u0002088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010@\u001a\u00020?8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010E¨\u0006H"}, d2 = {"Lcom/obric/oui/common/style/OStateGradientDrawable;", "Landroid/graphics/drawable/GradientDrawable;", "<init>", "()V", "", "toColor", "", "animate", "", "updateSolidColor", "(IZ)V", "updateStrokeColor", "normal", "pressed", "selected", "checked", "hover", "disabled", "setSolidColors", "(IIIIII)V", "Landroid/content/res/ColorStateList;", "colorStateList", "(Landroid/content/res/ColorStateList;)V", "width", "setStrokeConfigs", "(IIIIIII)V", "(ILandroid/content/res/ColorStateList;)V", "endAnimation", "isStateful", "()Z", "", "stateSet", "onStateChange", "([I)Z", "normalSolidColor", "I", "pressedSolidColor", "selectedSolidColor", "checkedSolidColor", "hoverSolidColor", "disabledSolidColor", "normalStrokeColor", "pressedStrokeColor", "selectedStrokeColor", "checkedStrokeColor", "hoverStrokeColor", "disabledStrokeColor", "strokeWidth", "targetSolidColor", "targetStrokeColor", "animatedSolidColor", "animatedStrokeColor", "Landroid/animation/ValueAnimator;", "colorAnimator", "Landroid/animation/ValueAnimator;", "strokeAnimator", "", "animDuration", "J", "getAnimDuration", "()J", "setAnimDuration", "(J)V", "Landroid/view/animation/LinearInterpolator;", "animInterpolator", "Landroid/view/animation/LinearInterpolator;", "getAnimInterpolator", "()Landroid/view/animation/LinearInterpolator;", "setAnimInterpolator", "(Landroid/view/animation/LinearInterpolator;)V", "Companion", "com/obric/oui/common/style/d", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OStateGradientDrawable extends GradientDrawable {
    public static final d Companion = null;
    private static final int[] STATE_CHECKED = null;
    private static final int[] STATE_DISABLED = null;
    private static final int[] STATE_HOVERED = null;
    private static final int[] STATE_NORMAL = null;
    private static final int[] STATE_PRESSED = null;
    private static final int[] STATE_SELECTED = null;
    private long animDuration;
    private LinearInterpolator animInterpolator;
    private int animatedSolidColor;
    private int animatedStrokeColor;
    private int checkedSolidColor;
    private int checkedStrokeColor;
    private ValueAnimator colorAnimator;
    private int disabledSolidColor;
    private int disabledStrokeColor;
    private int hoverSolidColor;
    private int hoverStrokeColor;
    private int normalSolidColor;
    private int normalStrokeColor;
    private int pressedSolidColor;
    private int pressedStrokeColor;
    private int selectedSolidColor;
    private int selectedStrokeColor;
    private ValueAnimator strokeAnimator;
    private int strokeWidth;
    private int targetSolidColor;
    private int targetStrokeColor;

    static {
        Companion = new d();
        STATE_PRESSED = new int[]{R.attr.state_pressed, R.attr.state_enabled};
        STATE_SELECTED = new int[]{R.attr.state_selected, R.attr.state_enabled};
        STATE_CHECKED = new int[]{R.attr.state_checked, R.attr.state_enabled};
        STATE_HOVERED = new int[]{R.attr.state_hovered, R.attr.state_enabled};
        STATE_DISABLED = new int[]{-16842910};
        STATE_NORMAL = new int[]{R.attr.state_enabled};
    }

    public OStateGradientDrawable() {
        this.animDuration = Token$Duration.OUI_ANIMATION_DURATION_SHORT_2.getDuration();
        this.animInterpolator = new LinearInterpolator();
    }

    public static /* synthetic */ void a(OStateGradientDrawable r5, ValueAnimator r10) {
        m105updateSolidColor$lambda1$lambda0(r5, r10);
    }

    public static /* synthetic */ void b(OStateGradientDrawable r5, ValueAnimator r10) {
        m106updateStrokeColor$lambda3$lambda2(r5, r10);
    }

    public static /* synthetic */ void setSolidColors$default(OStateGradientDrawable r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, Object r18) {
        if ((r17 & 2) == 0) goto L5;
        int r5 = r11;
    L7:
        if ((r17 & 4) == 0) goto L9;
        int r19 = r11;
    L11:
        if ((r17 & 8) == 0) goto L13;
        int r20 = r11;
    L15:
        if ((r17 & 16) == 0) goto L17;
        int r21 = r11;
    L19:
        if ((r17 & 32) == 0) goto L21;
        int r22 = r11;
    L22:
        r10.setSolidColors(r11, r5, r19, r20, r21, r22);
        return;
    L21:
        r22 = r16;
        goto L22
    L17:
        r21 = r15;
        goto L19
    L13:
        r20 = r14;
        goto L15
    L9:
        r19 = r13;
        goto L11
    L5:
        r5 = r12;
        goto L7
    }

    public static /* synthetic */ void setStrokeConfigs$default(OStateGradientDrawable r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, Object r19) {
        if ((r18 & 4) == 0) goto L5;
        int r5 = r12;
    L7:
        if ((r18 & 8) == 0) goto L9;
        int r20 = r12;
    L11:
        if ((r18 & 16) == 0) goto L13;
        int r21 = r12;
    L15:
        if ((r18 & 32) == 0) goto L17;
        int r22 = r12;
    L19:
        if ((r18 & 64) == 0) goto L21;
        int r23 = r12;
    L22:
        r10.setStrokeConfigs(r11, r12, r5, r20, r21, r22, r23);
        return;
    L21:
        r23 = r17;
        goto L22
    L17:
        r22 = r16;
        goto L19
    L13:
        r21 = r15;
        goto L15
    L9:
        r20 = r14;
        goto L11
    L5:
        r5 = r13;
        goto L7
    }

    private final void updateSolidColor(int r5, boolean r10) {
        ValueAnimator r11 = this.colorAnimator;
        if (r11 == null) goto L6;
        r11.cancel();
    L6:
        if (r10 == false) goto L8;
        int r12 = this.animatedSolidColor;
        ValueAnimator r13 = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(r12), Integer.valueOf(r5)});
        r13.setDuration(getAnimDuration());
        r13.setInterpolator(getAnimInterpolator());
        r13.addUpdateListener(new c(this, 0));
        r13.start();
        this.colorAnimator = r13;
        return;
    L8:
        this.colorAnimator = null;
        this.animatedSolidColor = r5;
        setColor(r5);
    }

    /* JADX INFO: renamed from: updateSolidColor$lambda-1$lambda-0, reason: not valid java name */
    private static final void m105updateSolidColor$lambda1$lambda0(OStateGradientDrawable r5, ValueAnimator r10) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        Intrinsics.checkNotNullParameter(r10, "animator");
        Object r11 = r10.getAnimatedValue();
        if (r11 == null) goto L7;
        int r12 = ((Integer) r11).intValue();
        r5.animatedSolidColor = r12;
        r5.setColor(r12);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    private final void updateStrokeColor(int r5, boolean r10) {
        ValueAnimator r11 = this.strokeAnimator;
        if (r11 == null) goto L6;
        r11.cancel();
    L6:
        if (r10 == false) goto L8;
        int r12 = this.animatedStrokeColor;
        ValueAnimator r13 = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(r12), Integer.valueOf(r5)});
        r13.setDuration(getAnimDuration());
        r13.setInterpolator(getAnimInterpolator());
        r13.addUpdateListener(new c(this, 1));
        r13.start();
        this.strokeAnimator = r13;
        return;
    L8:
        this.strokeAnimator = null;
        this.animatedStrokeColor = r5;
        setStroke(this.strokeWidth, r5);
    }

    /* JADX INFO: renamed from: updateStrokeColor$lambda-3$lambda-2, reason: not valid java name */
    private static final void m106updateStrokeColor$lambda3$lambda2(OStateGradientDrawable r5, ValueAnimator r10) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        Intrinsics.checkNotNullParameter(r10, "animator");
        Object r11 = r10.getAnimatedValue();
        if (r11 == null) goto L7;
        int r12 = ((Integer) r11).intValue();
        r5.animatedStrokeColor = r12;
        r5.setStroke(r5.strokeWidth, r12);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    public final void endAnimation() {
        ValueAnimator r5 = this.colorAnimator;
        if (r5 == null) goto L6;
        r5.end();
    L6:
        this.colorAnimator = null;
        ValueAnimator r10 = this.strokeAnimator;
        if (r10 == null) goto L10;
        r10.end();
    L10:
        this.strokeAnimator = null;
    }

    public final long getAnimDuration() {
        return this.animDuration;
    }

    public final LinearInterpolator getAnimInterpolator() {
        return this.animInterpolator;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] r11) {
        Intrinsics.checkNotNullParameter(r11, "stateSet");
        if (StateSet.stateSetMatches(new int[]{R.attr.state_enabled}, r11) == true) goto L6;
        int r5 = this.disabledSolidColor;
    L18:
        int r10 = this.targetSolidColor;
        if (r5 == r10) goto L26;
        int r12 = this.normalSolidColor;
        if (r5 != r12) goto L24;
        if (r10 == r12) goto L24;
        boolean r13 = true;
    L25:
        updateSolidColor(r5, r13);
        this.targetSolidColor = r5;
        boolean r14 = true;
    L28:
        if (StateSet.stateSetMatches(new int[]{R.attr.state_enabled}, r11) == true) goto L31;
        int r15 = this.disabledStrokeColor;
    L43:
        int r16 = this.targetStrokeColor;
        if (r15 == r16) goto L51;
        int r17 = this.normalStrokeColor;
        if (r15 != r17) goto L49;
        if (r16 == r17) goto L49;
        boolean r18 = true;
    L50:
        updateStrokeColor(r15, r18);
        this.targetStrokeColor = r15;
        r14 = true;
    L49:
        r18 = false;
    L51:
        if (r14 == false) goto L53;
        return true;
    L53:
        if (super.onStateChange(r11) == false) goto L56;
        return true;
    L56:
        return false;
    L31:
        if (StateSet.stateSetMatches(new int[]{R.attr.state_pressed}, r11) == false) goto L34;
        r15 = this.pressedStrokeColor;
        goto L43
    L34:
        if (StateSet.stateSetMatches(new int[]{R.attr.state_selected}, r11) == false) goto L37;
        r15 = this.selectedStrokeColor;
        goto L43
    L37:
        if (StateSet.stateSetMatches(new int[]{R.attr.state_checked}, r11) == false) goto L40;
        r15 = this.checkedStrokeColor;
        goto L43
    L40:
        if (StateSet.stateSetMatches(new int[]{R.attr.state_hovered}, r11) == false) goto L42;
        r15 = this.hoverStrokeColor;
        goto L43
    L42:
        r15 = this.normalStrokeColor;
    L24:
        r13 = false;
        goto L25
    L26:
        r14 = false;
        goto L28
    L6:
        if (StateSet.stateSetMatches(new int[]{R.attr.state_pressed}, r11) == false) goto L9;
        r5 = this.pressedSolidColor;
        goto L18
    L9:
        if (StateSet.stateSetMatches(new int[]{R.attr.state_selected}, r11) == false) goto L12;
        r5 = this.selectedSolidColor;
        goto L18
    L12:
        if (StateSet.stateSetMatches(new int[]{R.attr.state_checked}, r11) == false) goto L15;
        r5 = this.checkedSolidColor;
        goto L18
    L15:
        if (StateSet.stateSetMatches(new int[]{R.attr.state_hovered}, r11) == false) goto L17;
        r5 = this.hoverSolidColor;
        goto L18
    L17:
        r5 = this.normalSolidColor;
        goto L18
    }

    public final void setAnimDuration(long r5) {
        this.animDuration = r5;
    }

    public final void setAnimInterpolator(LinearInterpolator r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.animInterpolator = r5;
    }

    public final void setSolidColors(int r5, int r10, int r11, int r12, int r13, int r14) {
        this.normalSolidColor = r5;
        this.pressedSolidColor = r10;
        this.selectedSolidColor = r11;
        this.checkedSolidColor = r12;
        this.hoverSolidColor = r13;
        this.disabledSolidColor = r14;
        this.targetSolidColor = r5;
        this.animatedSolidColor = r5;
        ValueAnimator r15 = this.colorAnimator;
        if (r15 == null) goto L6;
        r15.cancel();
    L6:
        setColor(r5);
    }

    public final void setStrokeConfigs(int r5, int r10, int r11, int r12, int r13, int r14, int r15) {
        this.strokeWidth = r5;
        this.normalStrokeColor = r10;
        this.pressedStrokeColor = r11;
        this.selectedStrokeColor = r12;
        this.checkedStrokeColor = r13;
        this.hoverStrokeColor = r14;
        this.disabledStrokeColor = r15;
        this.targetStrokeColor = r10;
        this.animatedStrokeColor = r10;
        ValueAnimator r16 = this.strokeAnimator;
        if (r16 == null) goto L6;
        r16.cancel();
    L6:
        setStroke(r5, r10);
    }

    public final void setSolidColors(ColorStateList r10) {
        Intrinsics.checkNotNullParameter(r10, "colorStateList");
        int r5 = r10.getColorForState(STATE_NORMAL, r10.getDefaultColor());
        int r11 = r10.getColorForState(STATE_PRESSED, r5);
        setSolidColors(r5, r11, r10.getColorForState(STATE_SELECTED, r5), r10.getColorForState(STATE_CHECKED, r5), r10.getColorForState(STATE_HOVERED, r11), r10.getColorForState(STATE_DISABLED, r5));
    }

    public final void setStrokeConfigs(int r11, ColorStateList r12) {
        Intrinsics.checkNotNullParameter(r12, "colorStateList");
        int r5 = r12.getColorForState(STATE_NORMAL, r12.getDefaultColor());
        setStrokeConfigs(r11, r5, r12.getColorForState(STATE_PRESSED, r5), r12.getColorForState(STATE_SELECTED, r5), r12.getColorForState(STATE_CHECKED, r5), r12.getColorForState(STATE_HOVERED, r5), r12.getColorForState(STATE_DISABLED, r5));
    }
}
