package com.ss.android.lark.inline.ai.ui.operates;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import com.larksuite.component.universe_design.button.UDButton;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.inline.ai.logic.b;
import com.ss.android.lark.inline.ai.ui.f0;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000  2\u00020\u0001:\u0001 B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u0007J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000bJ(\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007H\u0016J\u0018\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0015J\b\u0010\u001c\u001a\u00020\u0012H\u0002J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001fH\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/ss/android/lark/inline/ai/ui/operates/OperateButton;", "Lcom/larksuite/component/universe_design/button/UDButton;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "type", "", "savedWidth", "savedHeight", "colorfulShader", "Landroid/graphics/Shader;", "bgColor", "setPrimaryTypeBgColor", "", "setType", "setPadding", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "updateColorfulShader", "onDraw", "canvas", "Landroid/graphics/Canvas;", "Companion", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class OperateButton extends UDButton {
    public String a;
    public int b;
    public int c;
    public Shader d;
    public int e;

    public static final class a {
    }

    static {
    }

    public OperateButton(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public OperateButton(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a() {
        this.d = new LinearGradient(0.0f, 0.0f, (getMeasuredWidth() - getPaddingStart()) - getPaddingEnd(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), ContextCompat.getColor(getContext(), 2131100164), ContextCompat.getColor(getContext(), 2131100165), Shader.TileMode.CLAMP);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r4) {
        Intrinsics.checkNotNullParameter(r4, "canvas");
        TextPaint r0 = getPaint();
        if (r0 != null) goto L5;
    L11:
        super/*android.widget.Button*/.onDraw(r4);
        return;
    L5:
        if (Intrinsics.areEqual(this.a, "primary") == true) goto L7;
    L9:
        Shader r1 = null;
    L10:
        r0.setShader(r1);
        goto L11
    L7:
        if (isEnabled() == false) goto L9;
        r1 = this.d;
        goto L10
    }

    public final void setPrimaryTypeBgColor(int r1) {
        this.e = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setType(String r21) {
        Intrinsics.checkNotNullParameter(r21, "type");
        Log.i("OperateButton", "setType, type = " + r21);
        this.a = r21;
        if (Intrinsics.areEqual(r21, "primary") == false) goto L5;
        StateListDrawable r1 = new StateListDrawable();
        int[] r8 = {R.attr.state_pressed};
        Drawable r9 = AppCompatResources.getDrawable(getContext(), 2131231225);
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        GradientDrawable r10 = (GradientDrawable) r9;
        r10.setCornerRadius(f0.a(6));
        Unit r12 = Unit.INSTANCE;
        GradientDrawable r11 = new GradientDrawable();
        r11.setColor(ContextCompat.getColor(getContext(), this.e));
        r11.setCornerRadius(f0.a(5));
        Drawable r13 = AppCompatResources.getDrawable(getContext(), 2131231237);
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        GradientDrawable r14 = (GradientDrawable) r13;
        r14.setCornerRadius(f0.a(5));
        LayerDrawable r15 = new LayerDrawable(new GradientDrawable[]{r10, r11, r14});
        r15.setLayerInset(1, f0.a(1), f0.a(1), f0.a(1), f0.a(1));
        r15.setLayerInset(2, f0.a(1), f0.a(1), f0.a(1), f0.a(1));
        r1.addState(r8, r15);
        GradientDrawable r2 = new GradientDrawable();
        r2.setColor(AppCompatResources.getColorStateList(getContext(), this.e));
        r2.setCornerRadius(f0.a(6));
        r2.setStroke(f0.a(1), ContextCompat.getColor(getContext(), 2131103352));
        r1.addState(new int[]{-16842910}, r2);
        Drawable r4 = AppCompatResources.getDrawable(getContext(), 2131231225);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        GradientDrawable r5 = (GradientDrawable) r4;
        r5.setCornerRadius(f0.a(6));
        GradientDrawable r6 = new GradientDrawable();
        r6.setColor(ContextCompat.getColor(getContext(), this.e));
        r6.setCornerRadius(f0.a(5));
        LayerDrawable r7 = new LayerDrawable(new GradientDrawable[]{r5, r6});
        r7.setLayerInset(1, f0.a(1), f0.a(1), f0.a(1), f0.a(1));
        r1.addState(new int[0], r7);
        setBackground(r1);
        return;
    L5:
        StateListDrawable r3 = new StateListDrawable();
        int[] r16 = {R.attr.state_pressed};
        GradientDrawable r17 = new GradientDrawable();
        r17.setColor(AppCompatResources.getColorStateList(getContext(), 2131101953));
        r17.setCornerRadius(f0.a(6));
        r17.setStroke(f0.a(1), ContextCompat.getColor(getContext(), 2131103352));
        Unit r18 = Unit.INSTANCE;
        r3.addState(r16, r17);
        GradientDrawable r19 = new GradientDrawable();
        r19.setColor(AppCompatResources.getColorStateList(getContext(), 2131109044));
        r19.setCornerRadius(f0.a(6));
        r19.setStroke(f0.a(1), ContextCompat.getColor(getContext(), 2131103352));
        r3.addState(new int[]{-16842910}, r19);
        GradientDrawable r20 = new GradientDrawable();
        r20.setColor(AppCompatResources.getColorStateList(getContext(), 2131109044));
        r20.setCornerRadius(f0.a(6));
        r20.setStroke(f0.a(1), ContextCompat.getColor(getContext(), 2131103352));
        r3.addState(new int[0], r20);
        setBackground(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r1, int r2) {
        super/*android.widget.Button*/.onMeasure(r1, r2);
        if (this.b == getMeasuredWidth()) goto L5;
    L6:
        this.b = getMeasuredWidth();
        this.c = getMeasuredHeight();
        a();
        return;
    L5:
        if (this.c != getMeasuredHeight()) goto L6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OperateButton(Context r6, AttributeSet r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r8);
        this.a = "primary";
        com.ss.android.lark.storage.a r9 = b.a;
        this.e = 2131100557;
        setTextColor(new ColorStateList(new int[][]{new int[]{-16842910}, new int[0]}, new int[]{ContextCompat.getColor(r6, 2131106613), ContextCompat.getColor(r6, 2131106622)}));
        setType(this.a);
    }

    public /* synthetic */ OperateButton(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setPadding(int r1, int r2, int r3, int r4) {
        super/*android.widget.Button*/.setPadding(r1, r2, r3, r4);
        if (getMeasuredWidth() > 0) goto L5;
        return;
    L5:
        if (getMeasuredHeight() <= 0) goto L9;
        a();
        return;
    }
}
