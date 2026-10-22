package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceModule;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c;
import com.ss.android.lark.log.Log;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 52\u00020\u0001:\u00015B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&J\u000e\u0010'\u001a\u00020$2\u0006\u0010%\u001a\u00020&J\u001a\u0010(\u001a\u00020$2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010%\u001a\u00020&J\u0010\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020-H\u0014J\u0010\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u000200H\u0002J\u0019\u00101\u001a\u00020$2\n\b\u0003\u00102\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0002\u00103J\u0010\u00104\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/widget/AudioRotatableButton;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mImageView", "Landroidx/appcompat/widget/AppCompatImageView;", "getMImageView", "()Landroidx/appcompat/widget/AppCompatImageView;", "mImageView$delegate", "Lkotlin/Lazy;", "mTextView", "Landroidx/appcompat/widget/AppCompatTextView;", "getMTextView", "()Landroidx/appcompat/widget/AppCompatTextView;", "mTextView$delegate", "defaultIconRes", "", "defaultIconColorRes", "defaultTextColorRes", "defaultTextRes", "disableIconColor", "disableTextColor", "iconZhRes", "iconOtherRes", "iconColorRes", "textRes", "textColorRes", "circleBkgNormalColor", "circleBkgDisableColor", "paint", "Landroid/graphics/Paint;", "setEnable", "", "enable", "", "stopRotation", "startRotation", "milliseconds", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "parseTypedArray", "arr", "Landroid/content/res/TypedArray;", "setImageDrawable", "resId", "(Ljava/lang/Integer;)V", "updateSubView", "Companion", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class AudioRotatableButton extends ConstraintLayout {
    public final Lazy a;
    public final Lazy b;
    public final int c;
    public final int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public final Paint l;

    public static final class a {
    }

    static {
    }

    private final AppCompatImageView getMImageView() {
        return (AppCompatImageView) this.a.getValue();
    }

    private final AppCompatTextView getMTextView() {
        return (AppCompatTextView) this.b.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setImageDrawable(Integer r5) {
        if (r5 == null) goto L5;
        int r6 = r5.intValue();
    L8:
        AppCompatImageView r0 = getMImageView();
        r0.setScaleType(ImageView.ScaleType.FIT_CENTER);
        int r1 = c.a;
        Drawable r7 = c.d(this, r6);
        if (isEnabled() == false) goto L11;
        PorterDuffColorFilter r2 = new PorterDuffColorFilter(c.c(this, this.g), PorterDuff.Mode.SRC_IN);
    L12:
        r7.setColorFilter(r2);
        r0.setImageDrawable(r7);
        return;
    L11:
        r2 = new PorterDuffColorFilter(c.c(this, this.c), PorterDuff.Mode.SRC_IN);
        goto L12
    L5:
        if (KeyboardVoiceModule.a().isZh() == false) goto L7;
        r6 = this.e;
        goto L8
    L7:
        r6 = this.f;
        goto L8
    }

    public final void R5(boolean r2) {
        if (getMImageView().getAnimation() == null) goto L6;
        getMImageView().clearAnimation();
        setImageDrawable(null);
        setEnable(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        if (this.k != (-1)) goto L5;
    L11:
        super/*android.view.ViewGroup*/.onDraw(r5);
        return;
    L5:
        if (this.j == (-1)) goto L11;
        Paint r0 = this.l;
        if (isEnabled() == false) goto L9;
        int r1 = this.j;
    L10:
        r0.setColor(r1);
        r5.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, this.l);
        goto L11
    L9:
        r1 = this.k;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setEnable(boolean r3) {
        if (r3 == true) goto L4;
    L6:
        boolean r4 = false;
    L7:
        setEnabled(r4);
        int r0 = c.a;
        if (r4 == false) goto L10;
        int r1 = this.g;
    L11:
        int r2 = c.c(this, r1);
        if (r4 == false) goto L14;
        int r5 = this.i;
    L15:
        int r6 = c.c(this, r5);
        getMImageView().setColorFilter(r2);
        getMTextView().setTextColor(r6);
        return;
    L14:
        r5 = this.d;
        goto L15
    L10:
        r1 = this.c;
        goto L11
    L4:
        if (getMImageView().getAnimation() != null) goto L6;
        r4 = true;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AudioRotatableButton(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9);
        this.a = LazyKt.lazy(new AudioRotatableButton$mImageView$2(this));
        this.b = LazyKt.lazy(new AudioRotatableButton$mTextView$2(this));
        this.c = 2131102416;
        this.d = 2131106610;
        this.e = 2131256063;
        this.f = 2131256063;
        this.g = 2131102418;
        this.h = -1;
        this.i = 2131106607;
        this.j = -1;
        this.k = -1;
        Paint r4 = new Paint(5);
        r4.setStyle(Paint.Style.FILL);
        this.l = r4;
        LayoutInflater.from(r8).inflate(2131563407, this);
        setWillNotDraw(false);
        TypedArray r10 = r8.obtainStyledAttributes(r9, new int[]{2130969090, 2130969091, 2130969092, 2130969093, 2130969094, 2130969214, 2130969215});
        int r0 = r10.getResourceId(2, 2131256063);
        this.e = r0;
        this.f = r10.getResourceId(1, r0);
        this.g = r10.getResourceId(0, 2131102418);
        this.h = r10.getResourceId(3, -1);
        this.i = r10.getResourceId(4, 2131106607);
        this.j = r10.getColor(6, -1);
        this.k = r10.getColor(5, -1);
        r10.recycle();
        setImageDrawable(null);
        StringBuilder r11 = new StringBuilder("[debug info]: mTextView.textSize: ");
        r11.append(getMTextView().getTextSize());
        r11.append(", context.resources.displayMetrics.density：");
        Resources r1 = r8.getResources();
        r11.append(WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()).density);
        r11.append(", context.resources.configuration.fontScale: ");
        r11.append(r8.getResources().getConfiguration().fontScale);
        Log.i("AudioRotatableButton", r11.toString());
        if (this.h == (-1)) goto L5;
        AppCompatTextView r12 = getMTextView();
        int r13 = c.a;
        r12.setText(c.f(this, this.h));
    L6:
        setEnable(true);
        return;
    L5:
        getMTextView().setVisibility(8);
        goto L6
    }
}
