package com.obric.oui.tips;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ivy.ivykit.plugin.impl.render.g;
import com.lynx.tasm.utils.d;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\r\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u000f\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\u000f\u0010\u000eR#\u0010\u0016\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R#\u0010\u001b\u001a\n \u0011*\u0004\u0018\u00010\u00170\u00178FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u001aR#\u0010\u001e\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u0015R(\u0010%\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u001f8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R(\u0010(\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u001f8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R(\u0010/\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010)8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00105\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u0010<\u001a\u0002062\u0006\u00107\u001a\u0002068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b8\u00109\"\u0004\b:\u0010;¨\u0006="}, d2 = {"Lcom/obric/oui/tips/OTips;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lkotlin/Function0;", "", "clickAction", "setRightIconOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setLeftIconOnClickListener", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "g", "Lkotlin/Lazy;", "getLeftIcon", "()Landroid/widget/ImageView;", "leftIcon", "Landroid/widget/TextView;", "h", "getTipsTv", "()Landroid/widget/TextView;", "tipsTv", "i", "getRightIcon", "rightIcon", "Landroid/graphics/drawable/Drawable;", "ic", "getLeftIc", "()Landroid/graphics/drawable/Drawable;", "setLeftIc", "(Landroid/graphics/drawable/Drawable;)V", "leftIc", "getRightIc", "setRightIc", "rightIc", "", "txt", "getTipsText", "()Ljava/lang/String;", "setTipsText", "(Ljava/lang/String;)V", "tipsText", "num", "getTipsLine", "()I", "setTipsLine", "(I)V", "tipsLine", "", "value", "getTextRolling", "()Z", "setTextRolling", "(Z)V", "textRolling", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OTips extends ConstraintLayout {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f14763j = 0;
    public final Lazy g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f14764h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f14765i;

    @JvmOverloads
    public OTips(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    private final Drawable getLeftIc() {
        return getLeftIcon().getDrawable();
    }

    private final Drawable getRightIc() {
        return getRightIcon().getDrawable();
    }

    private final void setLeftIc(Drawable r5) {
        getLeftIcon().setImageDrawable(r5);
        d.t(getLeftIcon());
        invalidate();
    }

    private final void setRightIc(Drawable r5) {
        getRightIcon().setImageDrawable(r5);
        d.t(getRightIcon());
        invalidate();
    }

    public final ImageView getLeftIcon() {
        return (ImageView) this.g.getValue();
    }

    public final ImageView getRightIcon() {
        return (ImageView) this.f14765i.getValue();
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
        CharSequence r5 = getTipsTv().getText();
        if (r5 != null) goto L6;
        return null;
    L6:
        return r5.toString();
    }

    public final TextView getTipsTv() {
        return (TextView) this.f14764h.getValue();
    }

    public final void setLeftIconOnClickListener(Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "clickAction");
        ImageView r10 = getLeftIcon();
        if (r10 == null) goto L7;
        r10.setOnClickListener(new g(2, r5));
        return;
    }

    public final void setRightIconOnClickListener(Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "clickAction");
        ImageView r10 = getRightIcon();
        if (r10 == null) goto L7;
        r10.setOnClickListener(new g(1, r5));
        return;
    }

    public final void setTextRolling(boolean r5) {
        getTipsTv().setSelected(r5);
        if (r5 == false) goto L5;
        getTipsTv().setMovementMethod(null);
        String r10 = getTipsText();
        getTipsTv().setText(null);
        getTipsTv().setText(r10);
        setTipsLine(1);
        getTipsTv().setMarqueeRepeatLimit(-1);
        getTipsTv().setEllipsize(TextUtils.TruncateAt.MARQUEE);
    L6:
        invalidate();
        return;
    L5:
        getTipsTv().setEllipsize(TextUtils.TruncateAt.END);
        goto L6
    }

    public final void setTipsLine(int r5) {
        getTipsTv().setMaxLines(r5);
        TextView r10 = getTipsTv();
        boolean r11 = true;
        if (r5 == 1) goto L6;
        r11 = false;
    L6:
        r10.setSingleLine(r11);
        invalidate();
    }

    public final void setTipsText(String r5) {
        getTipsTv().setText(r5);
        invalidate();
    }

    @JvmOverloads
    public OTips(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OTips(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public OTips(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        this.g = LazyKt.lazy(new OTips$leftIcon$2(this));
        this.f14764h = LazyKt.lazy(new OTips$tipsTv$2(this));
        this.f14765i = LazyKt.lazy(new OTips$rightIcon$2(this));
        LayoutInflater.from(r5).inflate(R$layout.o_tips, this);
        if (r10 == null) goto L44;
        TypedArray r12 = r5.obtainStyledAttributes(r10, R$styleable.OTips);
        Drawable r13 = r12.getDrawable(R$styleable.OTips_oui_leftIcon);
        if (r13 == null) goto L8;
        setLeftIc(r13);
    L8:
        Drawable r14 = r12.getDrawable(R$styleable.OTips_oui_RightIcon);
        if (r14 == null) goto L12;
        setRightIc(r14);
    L12:
        ColorStateList r15 = r12.getColorStateList(R$styleable.OTips_oui_leftIcon_tint);
        if (r15 == null) goto L22;
        ImageView r16 = getLeftIcon();
        if (r16 == null) goto L22;
        Drawable r17 = r16.getDrawable();
        if (r17 == null) goto L22;
        r17.setTintList(r15);
    L22:
        ColorStateList r18 = r12.getColorStateList(R$styleable.OTips_oui_rightIcon_tint);
        if (r18 == null) goto L32;
        ImageView r19 = getRightIcon();
        if (r19 == null) goto L32;
        Drawable r20 = r19.getDrawable();
        if (r20 == null) goto L32;
        r20.setTintList(r18);
    L32:
        Integer r21 = Integer.valueOf(r12.getColor(R$styleable.OTips_oui_tipsTextColor, -1));
        if (r21.intValue() != (-1)) goto L36;
        r21 = null;
    L36:
        if (r21 == null) goto L42;
        int r22 = r21.intValue();
        TextView r23 = getTipsTv();
        if (r23 == null) goto L42;
        r23.setTextColor(r22);
    L42:
        setTipsText(r12.getString(R$styleable.OTips_oui_tipsText));
        setTipsLine(r12.getInteger(R$styleable.OTips_oui_tipsLine, 1));
        setTextRolling(r12.getBoolean(R$styleable.OTips_oui_textRolling, false));
        r12.getString(R$styleable.OTips_oui_spanText);
        r12.recycle();
        return;
    }
}
