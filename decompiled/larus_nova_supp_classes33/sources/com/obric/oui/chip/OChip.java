package com.obric.oui.chip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.obric.oui.layout.OUIFrameLayout;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import pla.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Deprecated(message = "use com.obric.oui.chip.v2.OChip instead")
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001+B'\b\u0007\u0012\u0006\u0010$\u001a\u00020#\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\b\b\u0002\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J>\u0010\f\u001a\u00020\u000426\u0010\u0003\u001a2\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00040\u0006R\u0017\u0010\u0012\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001b\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u0011R$\u0010\"\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006,"}, d2 = {"Lcom/obric/oui/chip/OChip;", "Lcom/obric/oui/layout/OUIFrameLayout;", "Landroid/view/View$OnClickListener;", "l", "", "setOnCloseListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "view", "", "checked", "setOnCheckedListener", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "getChipIcon", "()Landroid/widget/ImageView;", "chipIcon", "Landroid/widget/TextView;", "j", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "textView", "k", "getCloseIcon", "closeIcon", "", "value", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "text", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Style", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OChip extends OUIFrameLayout {
    public final View h;
    public final ImageView i;
    public final TextView j;
    public final ImageView k;
    public final boolean l;
    public boolean m;
    public Function2<? super OChip, ? super Boolean, Unit> n;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/chip/OChip$Style;", "", "Default", "Rect", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
    public static final enum Style extends Enum<Style> {
        public static final Style Default = null;
        public static final Style Rect = null;
        public static final /* synthetic */ Style[] a = null;

        public static Style valueOf(String r1) {
            return (Style) r27.a.a(Style.class, r1);
        }

        public static Style[] values() {
            return (Style[]) a.clone();
        }

        static {
            Style r0 = new Style("Default", 0);
            Default = r0;
            Style r1 = new Style("Rect", 1);
            Rect = r1;
            a = new Style[]{r0, r1};
        }

        public Style(String r1, int r2) {
            super(r1, r2);
        }
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Style.values().length];
            r0[Style.Default.ordinal()] = 1;
            r0[Style.Rect.ordinal()] = 2;
            a = r0;
        }
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
        return this.j.getText();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean performClick() {
        if (this.l == false) goto L6;
        boolean r0 = !this.m;
        this.m = r0;
        this.n.invoke(this, Boolean.valueOf(r0));
    L6:
        return super/*android.widget.FrameLayout*/.performClick();
    }

    public final ImageView getChipIcon() {
        return this.i;
    }

    public final ImageView getCloseIcon() {
        return this.k;
    }

    public final TextView getTextView() {
        return this.j;
    }

    public final void setOnCheckedListener(Function2<? super OChip, ? super Boolean, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "l");
        this.n = r2;
    }

    public final void setOnCloseListener(View.OnClickListener r2) {
        this.k.setOnClickListener(r2);
    }

    public final void setText(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.j.setText(r2);
    }

    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OChip(final Context r13, AttributeSet r14, int r15) {
        Intrinsics.checkNotNullParameter(r13, "context");
        super(r13, r14, r15, 8);
        View r16 = FrameLayout.inflate(r13, 2131563758, this);
        this.h = r16;
        ImageView r1 = (ImageView) r16.findViewById(2131365670);
        this.i = r1;
        TextView r2 = (TextView) r16.findViewById(2131365671);
        this.j = r2;
        ImageView r17 = (ImageView) r16.findViewById(2131366997);
        this.k = r17;
        this.n = new OChip$onCheckedListener$1(this, r13);
        TypedArray r18 = r13.obtainStyledAttributes(r14, new int[]{2130973031, 2130973080, 2130973081, 2130973082, 2130973083, 2130973084, 2130973085, 2130973086, 2130973087, 2130973088, 2130973091, 2130973092, 2130973131, 2130973324, 2130973328, 2130973329, 2130973365, 2130973366, 2130973392, 2130973394, 2130973396, 2130973400});
        getChipIcon().setImageDrawable(r18.getDrawable(6));
        getTextView().setText(r18.getText(13));
        getCloseIcon().setImageDrawable(r18.getDrawable(10));
        int r19 = r18.getColor(7, -1);
        int r5 = r18.getColor(11, -1);
        int r6 = r18.getColor(14, -1);
        this.l = r18.getBoolean(12, false);
        Style r7 = Style.values()[r18.getInt(8, 0)];
        r18.recycle();
        if (r1.getDrawable() == null) goto L5;
        boolean r110 = true;
    L7:
        if (r110 == false) goto L13;
        ViewGroup.LayoutParams r111 = r2.getLayoutParams();
        if (r111 == null) goto L12;
        ViewGroup.MarginLayoutParams r112 = (ViewGroup.MarginLayoutParams) r111;
        r112.setMarginStart(d.n(this, 4));
        r2.setLayoutParams(r112);
        r1.setVisibility(0);
    L17:
        if (r17.getDrawable() == null) goto L19;
        boolean r113 = true;
    L20:
        if (r113 == false) goto L26;
        ViewGroup.LayoutParams r114 = r2.getLayoutParams();
        if (r114 == null) goto L25;
        ViewGroup.MarginLayoutParams r115 = (ViewGroup.MarginLayoutParams) r114;
        r115.setMarginEnd(d.n(this, 6));
        r2.setLayoutParams(r115);
        r17.setVisibility(0);
    L29:
        if (r19 == (-1)) goto L34;
        Drawable r116 = r1.getDrawable();
        if (r116 == null) goto L34;
        r116.setTint(r19);
    L34:
        if (r5 == (-1)) goto L39;
        Drawable r117 = r17.getDrawable();
        if (r117 == null) goto L39;
        r117.setTint(r5);
    L39:
        if (r6 == (-1)) goto L41;
        r2.setTextColor(r6);
    L41:
        int r118 = a.a[r7.ordinal()];
        if (r118 != 1) goto L44;
        int r119 = d.n(this, 99);
    L49:
        setRadius(r119);
        return;
    L44:
        if (r118 != 2) goto L47;
        r119 = d.n(this, 8);
        goto L49
    L47:
        throw new NoWhenBranchMatchedException();
    L25:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L26:
        ViewGroup.LayoutParams r120 = r2.getLayoutParams();
        if (r120 == null) goto L52;
        ViewGroup.MarginLayoutParams r121 = (ViewGroup.MarginLayoutParams) r120;
        r121.setMarginEnd(d.n(this, 6));
        r2.setLayoutParams(r121);
        r17.setVisibility(8);
        goto L29
    L52:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L19:
        r113 = false;
        goto L20
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L13:
        ViewGroup.LayoutParams r122 = r2.getLayoutParams();
        if (r122 == null) goto L54;
        ViewGroup.MarginLayoutParams r123 = (ViewGroup.MarginLayoutParams) r122;
        r123.setMarginStart(d.n(this, 6));
        r2.setLayoutParams(r123);
        r1.setVisibility(8);
        goto L17
    L54:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L5:
        r110 = false;
        goto L7
    }

    public /* synthetic */ OChip(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super/*android.widget.FrameLayout*/.onLayout(r1, r2, r3, r4, r5);
    }
}
