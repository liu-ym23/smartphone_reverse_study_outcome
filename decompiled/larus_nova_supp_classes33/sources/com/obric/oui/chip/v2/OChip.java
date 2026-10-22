package com.obric.oui.chip.v2;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.obric.oui.common.style.l;
import com.obric.oui.common.style.q;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.layout.OUILinearLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import pla.d;
import wma.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001LB'\b\u0007\u0012\u0006\u0010F\u001a\u00020E\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010G\u0012\b\b\u0002\u0010I\u001a\u00020\u0002¢\u0006\u0004\bJ\u0010KJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0002J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J>\u0010\u001b\u001a\u00020\u000426\u0010\u0013\u001a2\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00040\u0015J\u000e\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0019J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0002H\u0016J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0002H\u0016R\u0017\u0010'\u001a\u00020\"8\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010-\u001a\u00020(8\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0017\u00103\u001a\u00020.8\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0017\u00105\u001a\u00020(8\u0006¢\u0006\f\n\u0004\b\u0013\u0010*\u001a\u0004\b4\u0010,R\u0017\u00108\u001a\u00020(8\u0006¢\u0006\f\n\u0004\b6\u0010*\u001a\u0004\b7\u0010,R*\u0010\u001a\u001a\u00020\u00192\u0006\u00109\u001a\u00020\u00198F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b\u001a\u0010<\"\u0004\b=\u0010>R$\u0010D\u001a\u00020?2\u0006\u00109\u001a\u00020?8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b@\u0010A\"\u0004\bB\u0010C¨\u0006M"}, d2 = {"Lcom/obric/oui/chip/v2/OChip;", "Lcom/obric/oui/layout/OUIFrameLayout;", "", "widgetBgColor", "", "setWidgetBgColor", "textColor", "setChipTextColor", "chipIconTintColor", "setChipIconTintColor", "closeIconTintColor", "setCloseIconTintColor", "arrowIconTintColor", "setArrowIconTintColor", "widgetBgColorDisabled", "setWidgetBgColorDisabled", "textColorDisabled", "setChipTextColorDisabled", "Landroid/view/View$OnClickListener;", "l", "setOnCloseListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "view", "", "isOn", "setOnCheckedListener", "isToggleable", "setToggleable", "minWidth", "setMinimumWidth", "minHeight", "setMinimumHeight", "Lcom/obric/oui/layout/OUILinearLayout;", "i", "Lcom/obric/oui/layout/OUILinearLayout;", "getChipContainer", "()Lcom/obric/oui/layout/OUILinearLayout;", "chipContainer", "Landroid/widget/ImageView;", "j", "Landroid/widget/ImageView;", "getChipIcon", "()Landroid/widget/ImageView;", "chipIcon", "Landroid/widget/TextView;", "k", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "textView", "getCloseIcon", "closeIcon", "m", "getArrowIcon", "arrowIcon", "value", "y", "Z", "()Z", "setOn", "(Z)V", "", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "text", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OChip extends OUIFrameLayout {
    public static final /* synthetic */ int z = 0;
    public final View h;
    public final OUILinearLayout i;
    public final ImageView j;
    public final TextView k;
    public final ImageView l;
    public final ImageView m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public boolean u;
    public Function2<? super OChip, ? super Boolean, Unit> v;
    public View.OnClickListener w;
    public List<q> x;
    public boolean y;

    public static final class a {
    }

    static {
    }

    public OChip(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public OChip(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final CharSequence getText() {
        return this.k.getText();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean performClick() {
        if (this.u == false) goto L6;
        setOn(!this.y);
    L6:
        return super/*android.widget.FrameLayout*/.performClick();
    }

    public final ImageView getArrowIcon() {
        return this.m;
    }

    public final OUILinearLayout getChipContainer() {
        return this.i;
    }

    public final ImageView getChipIcon() {
        return this.j;
    }

    public final ImageView getCloseIcon() {
        return this.l;
    }

    public final TextView getTextView() {
        return this.k;
    }

    public final void d(boolean r2) {
        if (r2 == false) goto L27;
        int r3 = this.s;
        if (r3 == 0) goto L7;
        this.i.setBackgroundColor(r3);
    L7:
        if (this.n == 0) goto L13;
        Drawable r4 = this.j.getDrawable();
        if (r4 == null) goto L13;
        r4.setTint(this.n);
    L13:
        if (this.o == 0) goto L19;
        Drawable r5 = this.l.getDrawable();
        if (r5 == null) goto L19;
        r5.setTint(this.o);
    L19:
        if (this.p == 0) goto L24;
        Drawable r6 = this.m.getDrawable();
        if (r6 == null) goto L24;
        r6.setTint(this.p);
    L24:
        int r7 = this.q;
        if (r7 == 0) goto L38;
        this.k.setTextColor(r7);
        return;
    L38:
        return;
    L27:
        int r8 = this.t;
        if (r8 == 0) goto L31;
        this.i.setBackgroundColor(r8);
    L31:
        if (this.r == 0) goto L40;
        Drawable r9 = this.j.getDrawable();
        if (r9 == null) goto L36;
        r9.setTint(this.r);
    L36:
        this.k.setTextColor(this.r);
        return;
    }

    public final void setArrowIconTintColor(int r2) {
        if (r2 == 0) goto L10;
        this.p = r2;
        if (this.y == false) goto L11;
        Drawable r0 = this.m.getDrawable();
        if (r0 == null) goto L12;
        r0.setTint(r2);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void setChipIconTintColor(int r2) {
        if (r2 == 0) goto L10;
        this.n = r2;
        if (this.y == false) goto L11;
        Drawable r0 = this.j.getDrawable();
        if (r0 == null) goto L12;
        r0.setTint(r2);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void setChipTextColor(int r2) {
        if (r2 == 0) goto L7;
        this.q = r2;
        if (this.y == false) goto L8;
        this.k.setTextColor(r2);
        return;
    L8:
        return;
    }

    public final void setChipTextColorDisabled(int r2) {
        if (r2 == 0) goto L11;
        this.r = r2;
        if (this.y == true) goto L12;
        Drawable r0 = this.j.getDrawable();
        if (r0 == null) goto L9;
        r0.setTint(r2);
    L9:
        this.k.setTextColor(r2);
        return;
    L12:
        return;
    }

    public final void setCloseIconTintColor(int r2) {
        if (r2 == 0) goto L10;
        this.o = r2;
        if (this.y == false) goto L11;
        Drawable r0 = this.l.getDrawable();
        if (r0 == null) goto L12;
        r0.setTint(r2);
        return;
    L12:
        return;
    L11:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setMinimumHeight(int r2) {
        super/*android.widget.FrameLayout*/.setMinimumHeight(r2);
        this.i.setMinimumHeight(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setMinimumWidth(int r2) {
        super/*android.widget.FrameLayout*/.setMinimumWidth(r2);
        this.i.setMinimumWidth(r2);
    }

    public final void setOn(boolean r2) {
        if (this.y == r2) goto L9;
        this.y = r2;
        d(r2);
        Function2<? super OChip, ? super Boolean, Unit> r3 = this.v;
        if (r3 == null) goto L10;
        r3.invoke(this, Boolean.valueOf(this.y));
        return;
    L10:
        return;
    }

    public final void setOnCheckedListener(Function2<? super OChip, ? super Boolean, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "l");
        this.v = r2;
    }

    public final void setOnCloseListener(View.OnClickListener r1) {
        this.w = r1;
    }

    public final void setText(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.k.setText(r2);
    }

    public final void setToggleable(boolean r1) {
        this.u = r1;
    }

    public final void setWidgetBgColor(int r2) {
        if (r2 == 0) goto L7;
        this.s = r2;
        if (this.y == false) goto L8;
        this.i.setBackgroundColor(r2);
        return;
    L8:
        return;
    }

    public final void setWidgetBgColorDisabled(int r2) {
        if (r2 == 0) goto L7;
        this.t = r2;
        if (this.y == true) goto L8;
        this.i.setBackgroundColor(r2);
        return;
    L8:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OChip(Context r19, AttributeSet r20, int r21) {
        Intrinsics.checkNotNullParameter(r19, "context");
        super(r19, r20, r21, 8);
        View r4 = FrameLayout.inflate(r19, 2131563759, this);
        this.h = r4;
        OUILinearLayout r5 = r4.findViewById(2131365669);
        this.i = r5;
        ImageView r6 = (ImageView) r4.findViewById(2131365670);
        this.j = r6;
        TextView r7 = (TextView) r4.findViewById(2131365671);
        this.k = r7;
        ImageView r8 = (ImageView) r4.findViewById(2131366997);
        this.l = r8;
        ImageView r9 = (ImageView) r4.findViewById(2131363240);
        this.m = r9;
        this.y = true;
        TypedArray r10 = r19.obtainStyledAttributes(r20, new int[]{2130973031, 2130973080, 2130973081, 2130973082, 2130973083, 2130973084, 2130973085, 2130973086, 2130973087, 2130973088, 2130973091, 2130973092, 2130973131, 2130973324, 2130973328, 2130973329, 2130973365, 2130973366, 2130973392, 2130973394, 2130973396, 2130973400});
        getChipIcon().setImageDrawable(r10.getDrawable(6));
        getTextView().setText(r10.getText(13));
        getCloseIcon().setImageDrawable(r10.getDrawable(10));
        getArrowIcon().setImageDrawable(r10.getDrawable(1));
        this.n = r10.getColor(7, 0);
        this.o = r10.getColor(11, 0);
        this.p = r10.getColor(0, 0);
        this.q = r10.getColor(14, 0);
        this.r = r10.getColor(15, 0);
        this.s = r10.getColor(16, 0);
        this.t = r10.getColor(17, 0);
        this.u = r10.getBoolean(9, false);
        int r11 = r10.getDimensionPixelSize(18, 0);
        int r13 = r10.getDimensionPixelSize(19, 0);
        int r14 = r10.getDimensionPixelSize(4, 0);
        int r15 = r10.getDimensionPixelSize(5, 0);
        int r12 = r10.getDimensionPixelSize(2, 0);
        r10.getDimensionPixelSize(3, 0);
        getChipContainer().setPadding(r11, getChipContainer().getPaddingTop(), r13, getChipContainer().getPaddingBottom());
        int r3 = r10.getColor(20, 0);
        if (r3 == 0) goto L5;
        getChipContainer().setOverridePressColor(r3);
        getChipContainer().m1("OChip");
    L5:
        List<q> r16 = l.b(r19, r10, 21);
        if (r16 == null) goto L8;
        this.x = r16;
        Intrinsics.checkNotNull(r16);
        q r17 = (q) CollectionsKt.getOrNull(r16, 0);
        List<q> r18 = this.x;
        Intrinsics.checkNotNull(r18);
        int r110 = 0;
        c(r17, (q) CollectionsKt.getOrNull(r18, 1), false);
    L9:
        if (r16 == null) goto L11;
        boolean r22 = true;
    L12:
        r10.recycle();
        TypedArray r1 = r19.obtainStyledAttributes(r20, new int[]{R.attr.minWidth, R.attr.minHeight});
        int r2 = r1.getDimensionPixelSize(r110, r110);
        int r111 = r1.getDimensionPixelSize(1, r110);
        if (r2 <= 0) goto L15;
        getChipContainer().setMinimumWidth(r2);
    L15:
        if (r111 <= 0) goto L17;
        getChipContainer().setMinimumHeight(r111);
    L17:
        r1.recycle();
        setChangeAlphaWhenPress(false);
        if (r6.getDrawable() == null) goto L20;
        boolean r23 = true;
    L22:
        if (r23 == false) goto L28;
        ViewGroup.LayoutParams r24 = r7.getLayoutParams();
        if (r24 == null) goto L27;
        ViewGroup.MarginLayoutParams r25 = (ViewGroup.MarginLayoutParams) r24;
        r25.setMarginStart(r14);
        r7.setLayoutParams(r25);
        r6.setVisibility(0);
    L32:
        if (r8.getDrawable() == null) goto L34;
        boolean r26 = true;
    L35:
        if (r26 == false) goto L41;
        ViewGroup.LayoutParams r27 = r8.getLayoutParams();
        if (r27 == null) goto L40;
        ViewGroup.MarginLayoutParams r28 = (ViewGroup.MarginLayoutParams) r27;
        r28.setMarginStart(r15);
        r8.setLayoutParams(r28);
        r8.setVisibility(0);
        r8.setOnClickListener(new nla.a(this));
    L45:
        if (r9.getDrawable() == null) goto L47;
        boolean r29 = true;
    L48:
        if (r29 == false) goto L54;
        ViewGroup.LayoutParams r30 = r9.getLayoutParams();
        if (r30 == null) goto L53;
        ViewGroup.MarginLayoutParams r31 = (ViewGroup.MarginLayoutParams) r30;
        r31.setMarginStart(r12);
        r9.setLayoutParams(r31);
        r9.setVisibility(0);
    L57:
        d(true);
        int r32 = d.n(this, 99);
        if (r22 == false) goto L60;
        b.a("OChip", "initShadows, have shadow");
        setShadowCornerRadius(r32);
        r5.setRadius(r32);
    L61:
        setClipChildren(false);
        return;
    L60:
        setRadius(r32);
        goto L61
    L53:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L54:
        ViewGroup.LayoutParams r33 = r9.getLayoutParams();
        if (r33 == null) goto L64;
        ViewGroup.MarginLayoutParams r34 = (ViewGroup.MarginLayoutParams) r33;
        r34.setMarginStart(0);
        r9.setLayoutParams(r34);
        r9.setVisibility(8);
        goto L57
    L64:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L47:
        r29 = false;
        goto L48
    L40:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L41:
        ViewGroup.LayoutParams r35 = r8.getLayoutParams();
        if (r35 == null) goto L66;
        ViewGroup.MarginLayoutParams r36 = (ViewGroup.MarginLayoutParams) r35;
        r36.setMarginStart(0);
        r8.setLayoutParams(r36);
        r8.setVisibility(8);
        goto L45
    L66:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L34:
        r26 = false;
        goto L35
    L27:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L28:
        ViewGroup.LayoutParams r112 = r7.getLayoutParams();
        if (r112 == null) goto L68;
        ViewGroup.MarginLayoutParams r113 = (ViewGroup.MarginLayoutParams) r112;
        r113.setMarginStart(0);
        r7.setLayoutParams(r113);
        r6.setVisibility(8);
        goto L32
    L68:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L20:
        r23 = false;
        goto L22
    L11:
        r22 = false;
        goto L12
    L8:
        r110 = 0;
        goto L9
    }

    public /* synthetic */ OChip(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
