package com.ss.android.lark.officesdk.minutes.ui.foundation.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.ColorUtils;
import com.larksuite.framework.utils.UIUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0017H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u0012\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u0018\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u0017H\u0002J\u0010\u0010\"\u001a\u00020\u00132\b\b\u0002\u0010#\u001a\u00020\u0015J\u0006\u0010$\u001a\u00020\u001bJ\u0006\u0010%\u001a\u00020\u0013J\u0006\u0010&\u001a\u00020\u0013J\u000e\u0010'\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u0010(\u001a\u00020\u001bH\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/MmSummaryLoadingTextView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "textView", "Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/LineHeightTextView;", "sweepView", "Landroid/view/View;", "sweepAnimation", "Landroid/view/animation/TranslateAnimation;", "autoLoopRunnable", "Ljava/lang/Runnable;", "isAnimating", "", "loopInterval", "", "sweepWidthPx", "", "px2sp", "pxValue", "initSweepBackground", "", "updateTextAndInitAnimation", "text", "", "initAnimation", "textWidth", "sweepWidth", "startAutoLoop", "interval", "playOneShot", "stop", "isInAnimation", "setText", "onDetachedFromWindow", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmSummaryLoadingTextView extends ConstraintLayout {
    public static final /* synthetic */ int h = 0;
    public final LineHeightTextView a;
    public final View b;
    public TranslateAnimation c;
    public e d;
    public boolean e;
    public long f;
    public final float g;

    public MmSummaryLoadingTextView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MmSummaryLoadingTextView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean R5() {
        if (this.e == true) goto L5;
        return false;
    L5:
        int r0 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "stop", null, null, 12);
        this.e = false;
        e r1 = this.d;
        if (r1 == null) goto L8;
        removeCallbacks(r1);
    L8:
        this.d = null;
        this.b.clearAnimation();
        this.b.setVisibility(4);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        R5();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void S5(String r6) {
        this.a.setText(r6);
        if (r6 != null) goto L5;
    L8:
        boolean r7 = true;
    L9:
        if (r7 == true) goto L18;
        this.a.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        float r8 = this.a.getMeasuredWidth();
        float r1 = this.g;
        if (r1 > 0.0f) goto L15;
        r1 = UIUtils.dp2px(getContext(), 40.0f);
    L15:
        if (r8 <= 0.0f) goto L19;
        this.b.setTranslationX(-r1);
        TranslateAnimation r3 = new TranslateAnimation(0.0f, r8 + r1, 0.0f, 0.0f);
        r3.setDuration(500);
        r3.setFillAfter(false);
        r3.setAnimationListener(new d(this));
        this.c = r3;
        return;
    L19:
        return;
    L18:
        return;
    L5:
        if (r6.length() == 0) goto L8;
        r7 = false;
        goto L9
    }

    public final void setText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        S5(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v4, types: [android.widget.TextView, com.ss.android.lark.officesdk.minutes.ui.foundation.widget.LineHeightTextView] */
    public MmSummaryLoadingTextView(Context r11, AttributeSet r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        super(r11, r12, r13);
        this.f = 4000;
        View.inflate(r11, 2131564111, this);
        ?? r14 = (LineHeightTextView) findViewById(2131378986);
        this.a = r14;
        View r0 = findViewById(2131387806);
        this.b = r0;
        if (r12 == null) goto L14;
        TypedArray r15 = r11.obtainStyledAttributes(r12, new int[]{2130972594, 2130972595, 2130972596, 2130972597, 2130974345});
        String r5 = r15.getString(0);
        float r7 = r15.getDimension(3, -1.0f);
        if (r7 <= 0.0f) goto L7;
        Resources r16 = r11.getResources();
        r14.setTextSize(r7 / WindowDisplayMetricsOverride.apply(r16, r16.getDisplayMetrics()).scaledDensity);
    L7:
        r14.setTextColor(r15.getColor(1, FakePickerAvatarCreator.BLACK));
        float r17 = r15.getDimension(2, -1.0f);
        if (r17 <= 0.0f) goto L10;
        r14.setUXLineHeight(r17);
    L10:
        float r18 = r15.getDimension(4, -1.0f);
        if (r18 <= 0.0f) goto L13;
        this.g = r18;
        ViewGroup.LayoutParams r19 = r0.getLayoutParams();
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r110 = (ConstraintLayout.LayoutParams) r19;
        ((ViewGroup.MarginLayoutParams) r110).width = (int) r18;
        r0.setLayoutParams(r110);
    L13:
        r15.recycle();
        S5(r5);
    L14:
        GradientDrawable r111 = new GradientDrawable();
        r111.setGradientType(0);
        r111.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        int r112 = UIUtils.getColor(getContext(), 2131100548);
        int r113 = ColorUtils.setAlphaComponent(r112, 0);
        r111.setColors(new int[]{r113, ColorUtils.setAlphaComponent(r112, 153), r113});
        r0.setBackground(r111);
    }

    public /* synthetic */ MmSummaryLoadingTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
