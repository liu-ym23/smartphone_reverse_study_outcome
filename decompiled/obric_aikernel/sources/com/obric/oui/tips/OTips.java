package com.obric.oui.tips;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.crash.entity.EventBody;
import com.obric.oui.common.util.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import u8.h;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010@\u001a\u00020?\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010A\u0012\b\b\u0002\u0010C\u001a\u00020\u0002¢\u0006\u0004\bD\u0010EJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0014\u0010\u000b\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\tJ\u0014\u0010\f\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\tR$\u0010\u0012\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00138F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R%\u0010 \u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001a8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR(\u0010'\u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010!8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R%\u0010,\u001a\n \u001b*\u0004\u0018\u00010(0(8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u001d\u001a\u0004\b*\u0010+R\u0018\u0010-\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u0010/\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010.R\u0018\u00101\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R(\u00105\u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010!8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b3\u0010$\"\u0004\b4\u0010&R(\u0010;\u001a\u0004\u0018\u0001002\b\u00106\u001a\u0004\u0018\u0001008F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R%\u0010>\u001a\n \u001b*\u0004\u0018\u00010(0(8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\u001d\u001a\u0004\b=\u0010+¨\u0006F"}, d2 = {"Lcom/obric/oui/tips/OTips;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "res", "Landroid/content/res/ColorStateList;", "tintList", "", "setRightIconRes", "setLeftIconRes", "Lkotlin/Function0;", "clickAction", "setRightIconOnClickListener", "setLeftIconOnClickListener", "num", "getTipsLine", "()I", "setTipsLine", "(I)V", "tipsLine", "", EventBody.KEY_VALUE, "getTextRolling", "()Z", "setTextRolling", "(Z)V", "textRolling", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "tipsTv$delegate", "Lkotlin/Lazy;", "getTipsTv", "()Landroid/widget/TextView;", "tipsTv", "Landroid/graphics/drawable/Drawable;", "ic", "getRightIc", "()Landroid/graphics/drawable/Drawable;", "setRightIc", "(Landroid/graphics/drawable/Drawable;)V", "rightIc", "Landroid/widget/ImageView;", "leftIcon$delegate", "getLeftIcon", "()Landroid/widget/ImageView;", "leftIcon", "leftIconTint", "Landroid/content/res/ColorStateList;", "rightIconTint", "", "spanText", "Ljava/lang/String;", "getLeftIc", "setLeftIc", "leftIc", "txt", "getTipsText", "()Ljava/lang/String;", "setTipsText", "(Ljava/lang/String;)V", "tipsText", "rightIcon$delegate", "getRightIcon", "rightIcon", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OTips extends ConstraintLayout {
    private final Lazy leftIcon$delegate;
    private ColorStateList leftIconTint;
    private final Lazy rightIcon$delegate;
    private ColorStateList rightIconTint;
    private String spanText;
    private final Lazy tipsTv$delegate;

    static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function0 f7639c;

        a(Function0 r10) {
            this.f7639c = r10;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            this.f7639c.invoke();
        }
    }

    static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function0 f7640c;

        b(Function0 r10) {
            this.f7640c = r10;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            this.f7640c.invoke();
        }
    }

    @JvmOverloads
    public OTips(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public OTips(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public OTips(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.leftIcon$delegate = LazyKt.lazy(new OTips$leftIcon$2(this));
        this.tipsTv$delegate = LazyKt.lazy(new OTips$tipsTv$2(this));
        this.rightIcon$delegate = LazyKt.lazy(new OTips$rightIcon$2(this));
        LayoutInflater.from(r10).inflate(h.o_tips, this);
        if (r11 == null) goto L37;
        TypedArray r13 = r10.obtainStyledAttributes(r11, l.OTips);
        Intrinsics.checkNotNullExpressionValue(r13, "context.obtainStyledAttr…attrs, R.styleable.OTips)");
        Drawable r14 = r13.getDrawable(l.OTips_oui_leftIcon);
        if (r14 == null) goto L7;
        setLeftIc(r14);
    L7:
        Drawable r15 = r13.getDrawable(l.OTips_oui_RightIcon);
        if (r15 == null) goto L10;
        setRightIc(r15);
    L10:
        ColorStateList r16 = r13.getColorStateList(l.OTips_oui_leftIcon_tint);
        if (r16 == null) goto L17;
        this.leftIconTint = r16;
        ImageView r17 = getLeftIcon();
        if (r17 == null) goto L17;
        Drawable r18 = r17.getDrawable();
        if (r18 == null) goto L17;
        r18.setTintList(r16);
    L17:
        ColorStateList r19 = r13.getColorStateList(l.OTips_oui_rightIcon_tint);
        if (r19 == null) goto L24;
        this.rightIconTint = r19;
        ImageView r20 = getRightIcon();
        if (r20 == null) goto L24;
        Drawable r21 = r20.getDrawable();
        if (r21 == null) goto L24;
        r21.setTintList(r19);
    L24:
        Integer r22 = Integer.valueOf(r13.getColor(l.OTips_oui_tipsTextColor, -1));
        if (r22.intValue() == (-1)) goto L27;
        boolean r23 = true;
    L28:
        if (r23 == true) goto L31;
        r22 = null;
    L31:
        if (r22 == null) goto L35;
        int r24 = r22.intValue();
        TextView r25 = getTipsTv();
        if (r25 == null) goto L35;
        r25.setTextColor(r24);
    L35:
        setTipsText(r13.getString(l.OTips_oui_tipsText));
        setTipsLine(r13.getInteger(l.OTips_oui_tipsLine, 1));
        setTextRolling(r13.getBoolean(l.OTips_oui_textRolling, false));
        this.spanText = r13.getString(l.OTips_oui_spanText);
        r13.recycle();
        return;
    L27:
        r23 = false;
        goto L28
    }

    public /* synthetic */ OTips(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    private final Drawable getLeftIc() {
        ImageView r10 = getLeftIcon();
        Intrinsics.checkNotNullExpressionValue(r10, "leftIcon");
        return r10.getDrawable();
    }

    private final Drawable getRightIc() {
        ImageView r10 = getRightIcon();
        Intrinsics.checkNotNullExpressionValue(r10, "rightIcon");
        return r10.getDrawable();
    }

    private final void setLeftIc(Drawable r10) {
        getLeftIcon().setImageDrawable(r10);
        ImageView r11 = getLeftIcon();
        Intrinsics.checkNotNullExpressionValue(r11, "leftIcon");
        k.h(r11);
        invalidate();
    }

    public static /* synthetic */ void setLeftIconRes$default(OTips r10, int r11, ColorStateList r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = null;
    L5:
        r10.setLeftIconRes(r11, r12);
    }

    private final void setRightIc(Drawable r10) {
        getRightIcon().setImageDrawable(r10);
        ImageView r11 = getRightIcon();
        Intrinsics.checkNotNullExpressionValue(r11, "rightIcon");
        k.h(r11);
        invalidate();
    }

    public static /* synthetic */ void setRightIconRes$default(OTips r10, int r11, ColorStateList r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = null;
    L5:
        r10.setRightIconRes(r11, r12);
    }

    public final ImageView getLeftIcon() {
        return (ImageView) this.leftIcon$delegate.getValue();
    }

    public final ImageView getRightIcon() {
        return (ImageView) this.rightIcon$delegate.getValue();
    }

    public final boolean getTextRolling() {
        TextView r10 = getTipsTv();
        Intrinsics.checkNotNullExpressionValue(r10, "tipsTv");
        if (r10.isSelected() == true) goto L5;
    L7:
        return false;
    L5:
        if (getTipsLine() != 1) goto L7;
        return true;
    }

    public final int getTipsLine() {
        TextView r10 = getTipsTv();
        Intrinsics.checkNotNullExpressionValue(r10, "tipsTv");
        return r10.getMaxLines();
    }

    public final String getTipsText() {
        TextView r10 = getTipsTv();
        Intrinsics.checkNotNullExpressionValue(r10, "tipsTv");
        CharSequence r11 = r10.getText();
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.toString();
    }

    public final TextView getTipsTv() {
        return (TextView) this.tipsTv$delegate.getValue();
    }

    public final void setLeftIconOnClickListener(Function0<Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "clickAction");
        ImageView r11 = getLeftIcon();
        if (r11 == null) goto L6;
        r11.setOnClickListener(new a(r10));
        return;
    }

    public final void setLeftIconRes(int r10, ColorStateList r11) {
        ImageView r12 = getLeftIcon();
        if (r12 == null) goto L16;
        r12.setImageResource(r10);
        if (r11 == null) goto L10;
        Drawable r13 = r12.getDrawable();
        if (r13 == null) goto L14;
        r13.setTintList(r11);
    L14:
        k.h(r12);
        r12.invalidate();
        return;
    L10:
        if (this.leftIconTint == null) goto L14;
        Drawable r14 = r12.getDrawable();
        if (r14 == null) goto L14;
        r14.setTintList(this.leftIconTint);
        goto L14
    }

    public final void setRightIconOnClickListener(Function0<Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "clickAction");
        ImageView r11 = getRightIcon();
        if (r11 == null) goto L6;
        r11.setOnClickListener(new b(r10));
        return;
    }

    public final void setRightIconRes(int r10, ColorStateList r11) {
        ImageView r12 = getRightIcon();
        if (r12 == null) goto L16;
        r12.setImageResource(r10);
        if (r11 == null) goto L10;
        Drawable r13 = r12.getDrawable();
        if (r13 == null) goto L14;
        r13.setTintList(r11);
    L14:
        k.h(r12);
        r12.invalidate();
        return;
    L10:
        if (this.rightIconTint == null) goto L14;
        Drawable r14 = r12.getDrawable();
        if (r14 == null) goto L14;
        r14.setTintList(this.rightIconTint);
        goto L14
    }

    public final void setTextRolling(boolean r10) {
        TextView r11 = getTipsTv();
        Intrinsics.checkNotNullExpressionValue(r11, "tipsTv");
        r11.setSelected(r10);
        if (r10 == false) goto L5;
        TextView r12 = getTipsTv();
        Intrinsics.checkNotNullExpressionValue(r12, "tipsTv");
        r12.setMovementMethod(null);
        String r13 = getTipsText();
        TextView r14 = getTipsTv();
        Intrinsics.checkNotNullExpressionValue(r14, "tipsTv");
        r14.setText(null);
        TextView r15 = getTipsTv();
        Intrinsics.checkNotNullExpressionValue(r15, "tipsTv");
        r15.setText(r13);
        setTipsLine(1);
        TextView r16 = getTipsTv();
        Intrinsics.checkNotNullExpressionValue(r16, "tipsTv");
        r16.setMarqueeRepeatLimit(-1);
        TextView r17 = getTipsTv();
        Intrinsics.checkNotNullExpressionValue(r17, "tipsTv");
        TextUtils.TruncateAt r18 = TextUtils.TruncateAt.MARQUEE;
    L6:
        r17.setEllipsize(r18);
        invalidate();
        return;
    L5:
        r17 = getTipsTv();
        Intrinsics.checkNotNullExpressionValue(r17, "tipsTv");
        r18 = TextUtils.TruncateAt.END;
        goto L6
    }

    public final void setTipsLine(int r10) {
        TextView r11 = getTipsTv();
        Intrinsics.checkNotNullExpressionValue(r11, "tipsTv");
        r11.setMaxLines(r10);
        TextView r12 = getTipsTv();
        Intrinsics.checkNotNullExpressionValue(r12, "tipsTv");
        boolean r13 = true;
        if (r10 == 1) goto L6;
        r13 = false;
    L6:
        r12.setSingleLine(r13);
        invalidate();
    }

    public final void setTipsText(String r10) {
        TextView r11 = getTipsTv();
        Intrinsics.checkNotNullExpressionValue(r11, "tipsTv");
        r11.setText(r10);
        invalidate();
    }
}
