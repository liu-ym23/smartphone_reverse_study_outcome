package com.obric.oui.tips;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.util.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0014\u0010:\u001a\u00020;2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020;0=J\u001a\u0010>\u001a\u00020;2\u0006\u0010?\u001a\u00020\u00072\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0018J\u0014\u0010A\u001a\u00020;2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020;0=J\u001a\u0010B\u001a\u00020;2\u0006\u0010?\u001a\u00020\u00072\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0018R(\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR#\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0019\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR#\u0010\u001c\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0016\u001a\u0004\b\u001d\u0010\u0014R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020#8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010*\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R(\u00100\u001a\u0004\u0018\u00010!2\b\u0010/\u001a\u0004\u0018\u00010!8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b1\u00102\"\u0004\b3\u00104R#\u00105\u001a\n \u0012*\u0004\u0018\u000106068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\u0016\u001a\u0004\b7\u00108¨\u0006C"}, d2 = {"Lcom/obric/oui/tips/OTips;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ic", "Landroid/graphics/drawable/Drawable;", "leftIc", "getLeftIc", "()Landroid/graphics/drawable/Drawable;", "setLeftIc", "(Landroid/graphics/drawable/Drawable;)V", "leftIcon", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getLeftIcon", "()Landroid/widget/ImageView;", "leftIcon$delegate", "Lkotlin/Lazy;", "leftIconTint", "Landroid/content/res/ColorStateList;", "rightIc", "getRightIc", "setRightIc", "rightIcon", "getRightIcon", "rightIcon$delegate", "rightIconTint", "spanText", "", EventBody.KEY_VALUE, "", "textRolling", "getTextRolling", "()Z", "setTextRolling", "(Z)V", "num", "tipsLine", "getTipsLine", "()I", "setTipsLine", "(I)V", "txt", "tipsText", "getTipsText", "()Ljava/lang/String;", "setTipsText", "(Ljava/lang/String;)V", "tipsTv", "Landroid/widget/TextView;", "getTipsTv", "()Landroid/widget/TextView;", "tipsTv$delegate", "setLeftIconOnClickListener", "", "clickAction", "Lkotlin/Function0;", "setLeftIconRes", "res", "tintList", "setRightIconOnClickListener", "setRightIconRes", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OTips extends ConstraintLayout {
    private final Lazy leftIcon$delegate;
    private ColorStateList leftIconTint;
    private final Lazy rightIcon$delegate;
    private ColorStateList rightIconTint;
    private String spanText;
    private final Lazy tipsTv$delegate;

    public OTips(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OTips(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OTips(Context r6, AttributeSet r7, int r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10, r8);
        this.leftIcon$delegate = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new OTips$leftIcon$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.tipsTv$delegate = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new OTips$tipsTv$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.rightIcon$delegate = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new OTips$rightIcon$2(this), Function0.class, "com.obric.memorydata.plugin"));
        ZeusTransformUtils.inflate(LayoutInflater.from(r9), ZeusTransformUtils.mapRes(R.layout.o_tips, "layout", "o_tips"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        if (r10 == null) goto L47;
        TypedArray r11 = r9.obtainStyledAttributes(r10, R.styleable.OTips);
        Intrinsics.checkNotNullExpressionValue(r11, "context.obtainStyledAttr…attrs, R.styleable.OTips)");
        Drawable r12 = r11.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OTips_oui_leftIcon, "styleable", "OTips_oui_leftIcon"));
        if (r12 == null) goto L8;
        setLeftIc(r12);
    L8:
        Drawable r13 = r11.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OTips_oui_RightIcon, "styleable", "OTips_oui_RightIcon"));
        if (r13 == null) goto L12;
        setRightIc(r13);
    L12:
        ColorStateList r14 = r11.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.OTips_oui_leftIcon_tint, "styleable", "OTips_oui_leftIcon_tint"));
        if (r14 == null) goto L22;
        this.leftIconTint = r14;
        ImageView r0 = getLeftIcon();
        if (r0 == null) goto L22;
        Drawable r1 = r0.getDrawable();
        if (r1 == null) goto L22;
        r1.setTintList(r14);
    L22:
        ColorStateList r15 = r11.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.OTips_oui_rightIcon_tint, "styleable", "OTips_oui_rightIcon_tint"));
        if (r15 == null) goto L32;
        this.rightIconTint = r15;
        ImageView r2 = getRightIcon();
        if (r2 == null) goto L32;
        Drawable r3 = r2.getDrawable();
        if (r3 == null) goto L32;
        r3.setTintList(r15);
    L32:
        Integer r16 = Integer.valueOf(r11.getColor(ZeusTransformUtils.mapRes(R.styleable.OTips_oui_tipsTextColor, "styleable", "OTips_oui_tipsTextColor"), -1));
        if (((Number) ZeusTransformUtils.preCheckCast(r16, Number.class, "com.obric.memorydata.plugin")).intValue() == (-1)) goto L35;
        boolean r4 = true;
    L36:
        if (r4 == true) goto L39;
        r16 = null;
    L39:
        if (r16 == null) goto L45;
        int r17 = ((Number) ZeusTransformUtils.preCheckCast(r16, Number.class, "com.obric.memorydata.plugin")).intValue();
        TextView r5 = getTipsTv();
        if (r5 == null) goto L45;
        r5.setTextColor(r17);
    L45:
        setTipsText(r11.getString(ZeusTransformUtils.mapRes(R.styleable.OTips_oui_tipsText, "styleable", "OTips_oui_tipsText")));
        setTipsLine(r11.getInteger(ZeusTransformUtils.mapRes(R.styleable.OTips_oui_tipsLine, "styleable", "OTips_oui_tipsLine"), 1));
        setTextRolling(r11.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OTips_oui_textRolling, "styleable", "OTips_oui_textRolling"), false));
        this.spanText = r11.getString(ZeusTransformUtils.mapRes(R.styleable.OTips_oui_spanText, "styleable", "OTips_oui_spanText"));
        r11.recycle();
        return;
    L35:
        r4 = false;
        goto L36
    }

    public /* synthetic */ OTips(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    private final Drawable getLeftIc() {
        return getLeftIcon().getDrawable();
    }

    private final Drawable getRightIc() {
        return getRightIcon().getDrawable();
    }

    public static /* synthetic */ void lambda$V134awnnd7xZxcmCKPAFAQ5Up4Y(Function0 r0, View r1) {
        m1381setLeftIconOnClickListener$lambda3(r0, r1);
    }

    public static /* synthetic */ void lambda$ZamPUp5DVk9OnEUuucYd9oZvnwo(Function0 r0, View r1) {
        m1382setRightIconOnClickListener$lambda2(r0, r1);
    }

    private final void setLeftIc(Drawable r3) {
        getLeftIcon().setImageDrawable(r3);
        ImageView r4 = getLeftIcon();
        Intrinsics.checkNotNullExpressionValue(r4, "leftIcon");
        o.a((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin"));
        invalidate();
    }

    /* JADX INFO: renamed from: setLeftIconOnClickListener$lambda-3, reason: not valid java name */
    private static final void m1381setLeftIconOnClickListener$lambda3(Function0 r1, View r2) {
        Function0 r3 = (Function0) ZeusTransformUtils.wrapperContextForParams(r1, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "$clickAction");
        r3.invoke();
    }

    public static /* synthetic */ void setLeftIconRes$default(OTips r0, int r1, ColorStateList r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.setLeftIconRes(r1, r2);
    }

    private final void setRightIc(Drawable r3) {
        getRightIcon().setImageDrawable(r3);
        ImageView r4 = getRightIcon();
        Intrinsics.checkNotNullExpressionValue(r4, "rightIcon");
        o.a((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin"));
        invalidate();
    }

    /* JADX INFO: renamed from: setRightIconOnClickListener$lambda-2, reason: not valid java name */
    private static final void m1382setRightIconOnClickListener$lambda2(Function0 r1, View r2) {
        Function0 r3 = (Function0) ZeusTransformUtils.wrapperContextForParams(r1, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "$clickAction");
        r3.invoke();
    }

    public static /* synthetic */ void setRightIconRes$default(OTips r0, int r1, ColorStateList r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.setRightIconRes(r1, r2);
    }

    public final ImageView getLeftIcon() {
        return (ImageView) ZeusTransformUtils.preCheckCast(this.leftIcon$delegate.getValue(), ImageView.class, "com.obric.memorydata.plugin");
    }

    public final ImageView getRightIcon() {
        return (ImageView) ZeusTransformUtils.preCheckCast(this.rightIcon$delegate.getValue(), ImageView.class, "com.obric.memorydata.plugin");
    }

    public final boolean getTextRolling() {
        if (getTipsTv().isSelected() == true) goto L5;
    L7:
        return false;
    L5:
        if (getTipsLine() != 1) goto L7;
        return true;
    }

    public final int getTipsLine() {
        return getTipsTv().getMaxLines();
    }

    public final String getTipsText() {
        CharSequence r0 = getTipsTv().getText();
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.toString();
    }

    public final TextView getTipsTv() {
        return (TextView) ZeusTransformUtils.preCheckCast(this.tipsTv$delegate.getValue(), TextView.class, "com.obric.memorydata.plugin");
    }

    public final void setLeftIconOnClickListener(Function0<Unit> r3) {
        final Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "clickAction");
        ImageView r2 = getLeftIcon();
        if (r2 == null) goto L7;
        r2.setOnClickListener(new $$Lambda$OTips$V134awnnd7xZxcmCKPAFAQ5Up4Y(r4));
        return;
    }

    public final void setLeftIconRes(int r2, ColorStateList r3) {
        ImageView r0 = getLeftIcon();
        if (r0 == null) goto L19;
        r0.setImageResource(r2);
        if (r3 == null) goto L12;
        Drawable r1 = r0.getDrawable();
        if (r1 == null) goto L17;
        r1.setTintList(r3);
    L17:
        o.a((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin"));
        r0.invalidate();
        return;
    L12:
        if (this.leftIconTint == null) goto L17;
        Drawable r4 = r0.getDrawable();
        if (r4 == null) goto L17;
        r4.setTintList(this.leftIconTint);
        goto L17
    }

    public final void setRightIconOnClickListener(Function0<Unit> r3) {
        final Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "clickAction");
        ImageView r2 = getRightIcon();
        if (r2 == null) goto L7;
        r2.setOnClickListener(new $$Lambda$OTips$ZamPUp5DVk9OnEUuucYd9oZvnwo(r4));
        return;
    }

    public final void setRightIconRes(int r2, ColorStateList r3) {
        ImageView r0 = getRightIcon();
        if (r0 == null) goto L19;
        r0.setImageResource(r2);
        if (r3 == null) goto L12;
        Drawable r1 = r0.getDrawable();
        if (r1 == null) goto L17;
        r1.setTintList(r3);
    L17:
        o.a((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin"));
        r0.invalidate();
        return;
    L12:
        if (this.rightIconTint == null) goto L17;
        Drawable r4 = r0.getDrawable();
        if (r4 == null) goto L17;
        r4.setTintList(this.rightIconTint);
        goto L17
    }

    public final void setTextRolling(boolean r4) {
        getTipsTv().setSelected(r4);
        if (r4 == false) goto L5;
        getTipsTv().setMovementMethod(null);
        String r5 = getTipsText();
        getTipsTv().setText(null);
        getTipsTv().setText((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"));
        setTipsLine(1);
        getTipsTv().setMarqueeRepeatLimit(-1);
        TextView r6 = getTipsTv();
        TextUtils.TruncateAt r0 = TextUtils.TruncateAt.MARQUEE;
    L6:
        r6.setEllipsize(r0);
        invalidate();
        return;
    L5:
        r6 = getTipsTv();
        r0 = TextUtils.TruncateAt.END;
        goto L6
    }

    public final void setTipsLine(int r3) {
        getTipsTv().setMaxLines(r3);
        TextView r0 = getTipsTv();
        boolean r1 = true;
        if (r3 == 1) goto L6;
        r1 = false;
    L6:
        r0.setSingleLine(r1);
        invalidate();
    }

    public final void setTipsText(String r4) {
        getTipsTv().setText((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"));
        invalidate();
    }
}
