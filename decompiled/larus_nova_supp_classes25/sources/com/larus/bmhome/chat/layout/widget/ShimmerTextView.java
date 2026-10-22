package com.larus.bmhome.chat.layout.widget;

import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0019J\u0012\u0010\u001a\u001a\u00020\u00182\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0016J0\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0014J\b\u0010!\u001a\u00020\u0018H\u0014J\b\u0010\"\u001a\u00020\u0018H\u0014J\b\u0010#\u001a\u00020\u0018H\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/larus/bmhome/chat/layout/widget/ShimmerTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "linearGradient", "Landroid/graphics/LinearGradient;", "animator", "Landroid/animation/ValueAnimator;", "translateX", "", "shaderMatrix", "Landroid/graphics/Matrix;", "textColor", "textColorAlpha", "needStartAnimation", "", "useAlphaCenterColor", "setTextColorInfo", "", "(ILjava/lang/Integer;)V", "startShimmerAnimation", "onLayout", "changed", "left", "top", "right", "bottom", "onDetachedFromWindow", "onAttachedToWindow", "cancelAnimation", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public class ShimmerTextView extends AppCompatTextView {
    public static final /* synthetic */ int h = 0;
    public LinearGradient a;
    public ValueAnimator b;
    public final Matrix c;
    public int d;
    public int e;
    public boolean f;
    public boolean g;

    public ShimmerTextView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ShimmerTextView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x() {
        ValueAnimator r0 = this.b;
        if (r0 == null) goto L7;
        if (r0 == null) goto L6;
        r0.cancel();
    L6:
        this.b = null;
        getPaint().setShader(null);
        invalidate();
    L7:
        this.f = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.widget.TextView*/.onAttachedToWindow();
        if (this.f == false) goto L6;
        z(this.g);
        this.f = false;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.widget.TextView*/.onDetachedFromWindow();
        x();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void z(boolean r15) {
        this.g = r15;
        if (this.b == null) goto L6;
        return;
    L6:
        if (isAttachedToWindow() == true) goto L10;
        this.f = true;
        return;
    L10:
        if (r15 == false) goto L12;
        int r4 = this.d;
        int[] r16 = {r4, this.e, r4};
    L13:
        this.a = new LinearGradient(0.0f, 0.0f, getWidth(), 0.0f, r16, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
        getPaint().setShader(this.a);
        ValueAnimator r17 = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe("tx", new Keyframe[]{Keyframe.ofFloat(0.0f, -getWidth()), Keyframe.ofFloat(0.8f, getWidth()), Keyframe.ofFloat(1.0f, getWidth())})});
        r17.setDuration(1000);
        r17.setRepeatCount(-1);
        r17.setInterpolator(new LinearInterpolator());
        r17.addUpdateListener(new h1(this));
        r17.start();
        this.b = r17;
        return;
    L12:
        int r5 = this.e;
        r16 = new int[]{r5, this.d, r5};
        goto L13
    }

    public static void y(ShimmerTextView r1, int r2) {
        r1.d = r2;
        r1.e = ftc.a.a(r2, 68);
    }

    public ShimmerTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = new Matrix();
        int r5 = ContextCompat.getColor(r2, v19.c.b(2130972082, r2, 2131103146));
        this.d = r5;
        this.e = ftc.a.a(r5, 68);
    }

    public /* synthetic */ ShimmerTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if (r1 == true) goto L5;
        return;
    L5:
        if (this.b == null) goto L9;
        x();
        z(this.g);
        return;
    }
}
