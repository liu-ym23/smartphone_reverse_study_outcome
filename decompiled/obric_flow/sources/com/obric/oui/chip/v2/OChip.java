package com.obric.oui.chip.v2;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import ar.a;
import com.bytedance.ai.event.MessageIndication;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.common.style.i;
import com.obric.oui.common.style.m;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.layout.OUILinearLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\r\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\rJ\u0015\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\rJ\u0015\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\rJ\u0015\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\rJ\u0015\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\rJ\u0015\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\rJ\u0017\u0010\u001c\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001c\u0010\u001dJE\u0010$\u001a\u00020\u000b26\u0010\u001b\u001a2\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\"¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u000b0\u001e¢\u0006\u0004\b$\u0010%J\u0015\u0010'\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\"¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u0006H\u0016¢\u0006\u0004\b*\u0010\rJ\u0017\u0010,\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u0006H\u0016¢\u0006\u0004\b,\u0010\rR\u0017\u00102\u001a\u00020-8\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0017\u00108\u001a\u0002038\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0017\u0010>\u001a\u0002098\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0017\u0010@\u001a\u0002038\u0006¢\u0006\f\n\u0004\b\u001b\u00105\u001a\u0004\b?\u00107R\u0017\u0010C\u001a\u0002038\u0006¢\u0006\f\n\u0004\bA\u00105\u001a\u0004\bB\u00107R*\u0010#\u001a\u00020\"2\u0006\u0010D\u001a\u00020\"8F@FX\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\b#\u0010G\"\u0004\bH\u0010(R$\u0010N\u001a\u00020I2\u0006\u0010D\u001a\u00020I8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010M¨\u0006O"}, d2 = {"Lcom/obric/oui/chip/v2/OChip;", "Lcom/obric/oui/layout/OUIFrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "widgetBgColor", "", "setWidgetBgColor", "(I)V", "textColor", "setChipTextColor", "chipIconTintColor", "setChipIconTintColor", "closeIconTintColor", "setCloseIconTintColor", "arrowIconTintColor", "setArrowIconTintColor", "widgetBgColorDisabled", "setWidgetBgColorDisabled", "textColorDisabled", "setChipTextColorDisabled", "Landroid/view/View$OnClickListener;", "l", "setOnCloseListener", "(Landroid/view/View$OnClickListener;)V", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "view", "", "isOn", "setOnCheckedListener", "(Lkotlin/jvm/functions/Function2;)V", "isToggleable", "setToggleable", "(Z)V", "minWidth", "setMinimumWidth", "minHeight", "setMinimumHeight", "Lcom/obric/oui/layout/OUILinearLayout;", "i", "Lcom/obric/oui/layout/OUILinearLayout;", "getChipContainer", "()Lcom/obric/oui/layout/OUILinearLayout;", "chipContainer", "Landroid/widget/ImageView;", "j", "Landroid/widget/ImageView;", "getChipIcon", "()Landroid/widget/ImageView;", "chipIcon", "Landroid/widget/TextView;", "k", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "textView", "getCloseIcon", "closeIcon", "m", "getArrowIcon", "arrowIcon", "value", "y", "Z", "()Z", "setOn", "", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", MessageIndication.CONTENT_TYPE_TEXT, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OChip extends OUIFrameLayout {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ int f12331z = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f12332h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final OUILinearLayout f12333i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ImageView f12334j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final TextView f12335k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ImageView f12336l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ImageView f12337m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f12338n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f12339o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f12340p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f12341q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f12342r;
    public int s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f12343t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f12344u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Function2 f12345v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View.OnClickListener f12346w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final List f12347x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f12348y;

    @JvmOverloads
    public OChip(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public final ImageView getArrowIcon() {
        return this.f12337m;
    }

    public final OUILinearLayout getChipContainer() {
        return this.f12333i;
    }

    public final ImageView getChipIcon() {
        return this.f12334j;
    }

    public final ImageView getCloseIcon() {
        return this.f12336l;
    }

    public final CharSequence getText() {
        return this.f12335k.getText();
    }

    public final TextView getTextView() {
        return this.f12335k;
    }

    public final void n(boolean r5) {
        TextView r10 = this.f12335k;
        ImageView r11 = this.f12334j;
        OUILinearLayout r12 = this.f12333i;
        if (r5 == false) goto L28;
        int r13 = this.s;
        if (r13 == 0) goto L8;
        r12.setBackgroundColor(r13);
    L8:
        if (this.f12338n == 0) goto L14;
        Drawable r14 = r11.getDrawable();
        if (r14 == null) goto L14;
        r14.setTint(this.f12338n);
    L14:
        if (this.f12339o == 0) goto L20;
        Drawable r15 = this.f12336l.getDrawable();
        if (r15 == null) goto L20;
        r15.setTint(this.f12339o);
    L20:
        if (this.f12340p == 0) goto L25;
        Drawable r16 = this.f12337m.getDrawable();
        if (r16 == null) goto L25;
        r16.setTint(this.f12340p);
    L25:
        int r17 = this.f12341q;
        if (r17 == 0) goto L39;
        r10.setTextColor(r17);
        return;
    L39:
        return;
    L28:
        int r18 = this.f12343t;
        if (r18 == 0) goto L32;
        r12.setBackgroundColor(r18);
    L32:
        if (this.f12342r == 0) goto L41;
        Drawable r19 = r11.getDrawable();
        if (r19 == null) goto L37;
        r19.setTint(this.f12342r);
    L37:
        r10.setTextColor(this.f12342r);
        return;
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (this.f12344u == false) goto L6;
        setOn(!this.f12348y);
    L6:
        return super.performClick();
    }

    public final void setArrowIconTintColor(int r5) {
        if (r5 == 0) goto L10;
        this.f12340p = r5;
        if (this.f12348y == false) goto L11;
        Drawable r10 = this.f12337m.getDrawable();
        if (r10 == null) goto L12;
        r10.setTint(r5);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void setChipIconTintColor(int r5) {
        if (r5 == 0) goto L10;
        this.f12338n = r5;
        if (this.f12348y == false) goto L11;
        Drawable r10 = this.f12334j.getDrawable();
        if (r10 == null) goto L12;
        r10.setTint(r5);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void setChipTextColor(int r5) {
        if (r5 == 0) goto L7;
        this.f12341q = r5;
        if (this.f12348y == false) goto L8;
        this.f12335k.setTextColor(r5);
        return;
    L8:
        return;
    }

    public final void setChipTextColorDisabled(int r5) {
        if (r5 == 0) goto L11;
        this.f12342r = r5;
        if (this.f12348y == true) goto L12;
        Drawable r10 = this.f12334j.getDrawable();
        if (r10 == null) goto L9;
        r10.setTint(r5);
    L9:
        this.f12335k.setTextColor(r5);
        return;
    L12:
        return;
    }

    public final void setCloseIconTintColor(int r5) {
        if (r5 == 0) goto L10;
        this.f12339o = r5;
        if (this.f12348y == false) goto L11;
        Drawable r10 = this.f12336l.getDrawable();
        if (r10 == null) goto L12;
        r10.setTint(r5);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // android.view.View
    public void setMinimumHeight(int r5) {
        super.setMinimumHeight(r5);
        this.f12333i.setMinimumHeight(r5);
    }

    @Override // android.view.View
    public void setMinimumWidth(int r5) {
        super.setMinimumWidth(r5);
        this.f12333i.setMinimumWidth(r5);
    }

    public final void setOn(boolean r5) {
        if (this.f12348y == r5) goto L9;
        this.f12348y = r5;
        n(r5);
        Function2 r10 = this.f12345v;
        if (r10 == null) goto L10;
        r10.mo2invoke(this, Boolean.valueOf(this.f12348y));
        return;
    L10:
        return;
    }

    public final void setOnCheckedListener(Function2<? super OChip, ? super Boolean, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "l");
        this.f12345v = r5;
    }

    public final void setOnCloseListener(View.OnClickListener r5) {
        this.f12346w = r5;
    }

    public final void setText(CharSequence r5) {
        Intrinsics.checkNotNullParameter(r5, "value");
        this.f12335k.setText(r5);
    }

    public final void setToggleable(boolean r5) {
        this.f12344u = r5;
    }

    public final void setWidgetBgColor(int r5) {
        if (r5 == 0) goto L7;
        this.s = r5;
        if (this.f12348y == false) goto L8;
        this.f12333i.setBackgroundColor(r5);
        return;
    L8:
        return;
    }

    public final void setWidgetBgColorDisabled(int r5) {
        if (r5 == 0) goto L7;
        this.f12343t = r5;
        if (this.f12348y == true) goto L8;
        this.f12333i.setBackgroundColor(r5);
        return;
    L8:
        return;
    }

    @JvmOverloads
    public OChip(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OChip(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public OChip(Context r19, AttributeSet r20, int r21) {
        Intrinsics.checkNotNullParameter(r19, "context");
        super(r19, r20, r21, 8);
        View r5 = View.inflate(r19, R$layout.o_chip_v2, this);
        this.f12332h = r5;
        OUILinearLayout r10 = (OUILinearLayout) r5.findViewById(R$id.chip_container);
        this.f12333i = r10;
        ImageView r11 = (ImageView) r5.findViewById(R$id.chip_icon);
        this.f12334j = r11;
        TextView r12 = (TextView) r5.findViewById(R$id.chip_text);
        this.f12335k = r12;
        ImageView r13 = (ImageView) r5.findViewById(R$id.close_icon);
        this.f12336l = r13;
        ImageView r14 = (ImageView) r5.findViewById(R$id.arrow_icon);
        this.f12337m = r14;
        this.f12348y = true;
        TypedArray r15 = r19.obtainStyledAttributes(r20, R$styleable.OChip);
        getChipIcon().setImageDrawable(r15.getDrawable(R$styleable.OChip_oui_chip_icon));
        getTextView().setText(r15.getText(R$styleable.OChip_oui_text));
        getCloseIcon().setImageDrawable(r15.getDrawable(R$styleable.OChip_oui_close_icon));
        getArrowIcon().setImageDrawable(r15.getDrawable(R$styleable.OChip_oui_chipArrowIcon));
        this.f12338n = r15.getColor(R$styleable.OChip_oui_chip_icon_tint_color, 0);
        this.f12339o = r15.getColor(R$styleable.OChip_oui_close_icon_tint_color, 0);
        this.f12340p = r15.getColor(R$styleable.OChip_oui_arrow_icon_tint_color, 0);
        this.f12341q = r15.getColor(R$styleable.OChip_oui_text_color, 0);
        this.f12342r = r15.getColor(R$styleable.OChip_oui_text_color_disabled, 0);
        this.s = r15.getColor(R$styleable.OChip_oui_widgetBgColor, 0);
        this.f12343t = r15.getColor(R$styleable.OChip_oui_widgetBgColorDisabled, 0);
        this.f12344u = r15.getBoolean(R$styleable.OChip_oui_chip_toggleable, false);
        int r16 = r15.getDimensionPixelSize(R$styleable.OChip_oui_widgetPaddingL, 0);
        int r17 = r15.getDimensionPixelSize(R$styleable.OChip_oui_widgetPaddingR, 0);
        int r18 = r15.getDimensionPixelSize(R$styleable.OChip_oui_chipIconSpaceL, 0);
        int r110 = r15.getDimensionPixelSize(R$styleable.OChip_oui_chipIconSpaceR, 0);
        int r22 = r15.getDimensionPixelSize(R$styleable.OChip_oui_chipArrowSpaceL, 0);
        r15.getDimensionPixelSize(R$styleable.OChip_oui_chipArrowSpaceR, 0);
        getChipContainer().setPadding(r16, getChipContainer().getPaddingTop(), r17, getChipContainer().getPaddingBottom());
        int r23 = 0;
        int r24 = r15.getColor(R$styleable.OChip_oui_widgetPressColor, 0);
        if (r24 == 0) goto L5;
        getChipContainer().setOverridePressColor(r24);
        getChipContainer().i("OChip");
    L5:
        int r25 = r15.getResourceId(R$styleable.OChip_oui_widgetShadowNormal, 0);
        if (r25 == 0) goto L8;
        boolean r111 = true;
    L9:
        if (r25 == 0) goto L11;
        ArrayList r26 = i.o(r25, r19);
        List r27 = CollectionsKt.listOf(new m[]{(m) r26.get(0), (m) r26.get(1)});
        this.f12347x = r27;
        Intrinsics.checkNotNull(r27);
        m r28 = (m) CollectionsKt.getOrNull(r27, 0);
        List r112 = this.f12347x;
        Intrinsics.checkNotNull(r112);
        r23 = 0;
        l(r28, (m) CollectionsKt.getOrNull(r112, 1), false);
    L11:
        r15.recycle();
        TypedArray r29 = r19.obtainStyledAttributes(r20, new int[]{R.attr.minWidth, R.attr.minHeight});
        int r30 = r29.getDimensionPixelSize(r23, r23);
        int r113 = r29.getDimensionPixelSize(1, r23);
        if (r30 <= 0) goto L14;
        getChipContainer().setMinimumWidth(r30);
    L14:
        if (r113 <= 0) goto L16;
        getChipContainer().setMinimumHeight(r113);
    L16:
        r29.recycle();
        setChangeAlphaWhenPress(false);
        if (r11.getDrawable() == null) goto L19;
        boolean r31 = true;
    L21:
        if (r31 == false) goto L27;
        ViewGroup.LayoutParams r32 = r12.getLayoutParams();
        if (r32 == null) goto L26;
        ViewGroup.MarginLayoutParams r33 = (ViewGroup.MarginLayoutParams) r32;
        r33.setMarginStart(r18);
        r12.setLayoutParams(r33);
        int r34 = 0;
        r11.setVisibility(0);
    L31:
        if (r13.getDrawable() == null) goto L37;
        ViewGroup.LayoutParams r35 = r13.getLayoutParams();
        if (r35 == null) goto L36;
        ViewGroup.MarginLayoutParams r36 = (ViewGroup.MarginLayoutParams) r35;
        r36.setMarginStart(r110);
        r13.setLayoutParams(r36);
        r13.setVisibility(r34);
        r13.setOnClickListener(new a(this, 0));
        int r37 = 0;
    L41:
        if (r14.getDrawable() == null) goto L48;
        ViewGroup.LayoutParams r38 = r14.getLayoutParams();
        if (r38 == null) goto L47;
        ViewGroup.MarginLayoutParams r39 = (ViewGroup.MarginLayoutParams) r38;
        r39.setMarginStart(r22);
        r14.setLayoutParams(r39);
        r14.setVisibility(r37);
    L51:
        n(true);
        int r40 = com.lynx.tasm.utils.a.B(99, this);
        if (r111 == false) goto L55;
        ps.a.a("OChip", "initShadows, have shadow");
        setShadowCornerRadius(r40);
        r10.setRadius(r40);
    L56:
        setClipChildren(false);
        return;
    L55:
        setRadius(r40);
        goto L56
    L47:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L48:
        ViewGroup.LayoutParams r41 = r14.getLayoutParams();
        if (r41 == null) goto L59;
        ViewGroup.MarginLayoutParams r42 = (ViewGroup.MarginLayoutParams) r41;
        r42.setMarginStart(r37);
        r14.setLayoutParams(r42);
        r14.setVisibility(8);
        goto L51
    L59:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L36:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L37:
        ViewGroup.LayoutParams r43 = r13.getLayoutParams();
        if (r43 == null) goto L61;
        ViewGroup.MarginLayoutParams r44 = (ViewGroup.MarginLayoutParams) r43;
        r37 = 0;
        r44.setMarginStart(0);
        r13.setLayoutParams(r44);
        r13.setVisibility(8);
        goto L41
    L61:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L26:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L27:
        r34 = 0;
        ViewGroup.LayoutParams r45 = r12.getLayoutParams();
        if (r45 == null) goto L63;
        ViewGroup.MarginLayoutParams r46 = (ViewGroup.MarginLayoutParams) r45;
        r46.setMarginStart(0);
        r12.setLayoutParams(r46);
        r11.setVisibility(8);
        goto L31
    L63:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L19:
        r31 = false;
        goto L21
    L8:
        r111 = false;
        goto L9
    }
}
