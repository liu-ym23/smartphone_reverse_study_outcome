package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u000e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 J\b\u0010!\u001a\u00020\u001dH\u0002J\b\u0010\"\u001a\u00020\u001dH\u0002J\u0010\u0010#\u001a\u00020\u001d2\b\b\u0002\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020'J\u000e\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020'J\u000e\u0010*\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020'J\b\u0010+\u001a\u00020'H\u0016J\u0019\u0010,\u001a\u00020\u001d2\n\b\u0003\u0010-\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010.R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u0019\u0010\u001a¨\u0006/"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/widget/CircleIconWithTitle;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "iconDrawableResId", "", "textTitleResId", "iconTintColor", "iconDisableTintColor", "iconSize", "iconBackground", "backgroundTintColor", "backgroundDisableTintColor", "icon", "Landroidx/appcompat/widget/AppCompatImageView;", "getIcon", "()Landroidx/appcompat/widget/AppCompatImageView;", "icon$delegate", "Lkotlin/Lazy;", "title", "Landroidx/appcompat/widget/AppCompatTextView;", "getTitle", "()Landroidx/appcompat/widget/AppCompatTextView;", "title$delegate", "initStyleAttributes", "", "setText", "text", "", "initData", "adjustLayoutIfNeed", "startRotation", "milliseconds", "", "isRotating", "", "stopRotation", "enable", "setIsEnabled", "performClick", "setImageDrawable", "drawableRes", "(Ljava/lang/Integer;)V", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class CircleIconWithTitle extends ConstraintLayout {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public final Lazy i;
    public final Lazy j;

    private final AppCompatImageView getIcon() {
        return (AppCompatImageView) this.i.getValue();
    }

    private final AppCompatTextView getTitle() {
        return (AppCompatTextView) this.j.getValue();
    }

    public final boolean R5() {
        if (getIcon().getAnimation() == null) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean performClick() {
        return super/*android.view.ViewGroup*/.performClick();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void S5(CircleIconWithTitle r2) {
        if (r2.getIcon().getAnimation() != null) goto L7;
        r2.setEnabled(false);
        r2.setImageDrawable(2131255040);
        Animation r0 = AnimationUtils.loadAnimation(r2.getContext(), 2130772806);
        r2.getIcon().startAnimation(r0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setImageDrawable(Integer r7) {
        if (r7 == null) goto L4;
        int r0 = r7.intValue();
    L5:
        boolean r1 = isEnabled();
        AppCompatImageView r2 = getIcon();
        r2.setScaleType(ImageView.ScaleType.CENTER);
        Drawable r3 = UIUtils.getDrawable(r2.getContext(), r0);
        r2.setScaleType(ImageView.ScaleType.FIT_CENTER);
        if (r7 != null) goto L10;
        if (r1 == false) goto L9;
        int r4 = this.c;
    L11:
        r3.setColorFilter(new PorterDuffColorFilter(r4, PorterDuff.Mode.SRC_IN));
        r2.setImageDrawable(r3);
        if (r7 != null) goto L16;
        if (r1 == false) goto L15;
        int r8 = this.g;
    L17:
        Drawable r5 = getBackground();
        if (r5 == null) goto L21;
        r5.setColorFilter(new PorterDuffColorFilter(r8, PorterDuff.Mode.SRC_IN));
        return;
    L21:
        return;
    L15:
        r8 = this.h;
        goto L17
    L16:
        r8 = this.g;
        goto L17
    L9:
        r4 = this.d;
        goto L11
    L10:
        r4 = this.c;
        goto L11
    L4:
        r0 = this.a;
        goto L5
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void T5(boolean r2) {
        if (getIcon().getAnimation() == null) goto L5;
        getIcon().clearAnimation();
    L5:
        setEnabled(r2);
        setImageDrawable(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setIsEnabled(boolean r2) {
        if (r2 == isEnabled()) goto L9;
        setEnabled(r2);
        if (getIcon().getAnimation() == null) goto L7;
        setImageDrawable(2131255040);
        return;
    L7:
        setImageDrawable(null);
        return;
    }

    public final void setText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        getTitle().setText(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CircleIconWithTitle(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9);
        this.a = -1;
        this.b = -1;
        this.c = UIUtils.getColor(r8, 2131106531);
        this.d = UIUtils.getColor(r8, 2131106524);
        this.e = -1;
        this.f = -1;
        this.g = UIUtils.getColor(r8, 2131106522);
        this.h = UIUtils.getColor(r8, 2131106522);
        this.i = LazyKt.lazy(new CircleIconWithTitle$icon$2(this));
        this.j = LazyKt.lazy(new CircleIconWithTitle$title$2(this));
        boolean r3 = true;
        LayoutInflater.from(r8).inflate(2131568212, this, true);
        if (r9 == null) goto L6;
        TypedArray r10 = r8.obtainStyledAttributes(r9, new int[]{2130968902, 2130968907, 2130970282, 2130970283, 2130970285, 2130970298, 2130970355, 2130974540});
        this.a = r10.getResourceId(4, -1);
        this.f = r10.getResourceId(2, -1);
        this.b = r10.getResourceId(7, -1);
        this.c = r10.getColor(5, this.c);
        this.d = r10.getColor(3, this.d);
        this.g = r10.getColor(1, this.g);
        this.h = r10.getColor(0, this.h);
        this.e = r10.getDimensionPixelSize(6, -1);
        r10.recycle();
    L6:
        if (this.b == (-1)) goto L8;
        getTitle().setText(getContext().getString(this.b));
    L9:
        ConstraintSet r11 = new ConstraintSet();
        r11.clone(this);
        if (getTitle().getVisibility() == 0) goto L14;
        r3 = false;
    L14:
        if (r3 == false) goto L16;
        r11.connect(2131374718, 4, 2131388772, 3);
    L17:
        r11.applyTo(this);
        if (this.a == (-1)) goto L21;
        setImageDrawable(null);
    L21:
        if (this.f == (-1)) goto L24;
        getIcon().setBackgroundResource(this.f);
    L24:
        if (this.e == (-1)) goto L27;
        ViewGroup.LayoutParams r12 = getIcon().getLayoutParams();
        int r13 = this.e;
        r12.width = r13;
        r12.height = r13;
        return;
    L27:
        return;
    L16:
        r11.connect(2131374718, 4, 0, 4);
        goto L17
    L8:
        getTitle().setVisibility(8);
        goto L9
    }
}
