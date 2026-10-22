package com.obric.oui.chip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.ai.event.MessageIndication;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.layout.OUIFrameLayout;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated(message = "use com.obric.oui.chip.v2.OChip instead")
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0001-B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eJE\u0010\u0015\u001a\u00020\f26\u0010\u000b\u001a2\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\f0\u000f¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001c\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\"\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010%\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b#\u0010\u0019\u001a\u0004\b$\u0010\u001bR$\u0010,\u001a\u00020&2\u0006\u0010'\u001a\u00020&8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006."}, d2 = {"Lcom/obric/oui/chip/OChip;", "Lcom/obric/oui/layout/OUIFrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/view/View$OnClickListener;", "l", "", "setOnCloseListener", "(Landroid/view/View$OnClickListener;)V", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "view", "", "checked", "setOnCheckedListener", "(Lkotlin/jvm/functions/Function2;)V", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "getChipIcon", "()Landroid/widget/ImageView;", "chipIcon", "Landroid/widget/TextView;", "j", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "textView", "k", "getCloseIcon", "closeIcon", "", "value", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", MessageIndication.CONTENT_TYPE_TEXT, "Style", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OChip extends OUIFrameLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f12322h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ImageView f12323i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextView f12324j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ImageView f12325k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f12326l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f12327m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Function2 f12328n;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/chip/OChip$Style;", "", "Default", "Rect", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum Style extends Enum<Style> {
        public static final Style Default = null;
        public static final Style Rect = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Style[] f12329a = null;

        static {
            Style r5 = new Style("Default", 0);
            Default = r5;
            Style r10 = new Style("Rect", 1);
            Rect = r10;
            f12329a = new Style[]{r5, r10};
        }

        public static Style valueOf(String r5) {
            return (Style) Enum.valueOf(Style.class, r5);
        }

        public static Style[] values() {
            return (Style[]) f12329a.clone();
        }
    }

    @JvmOverloads
    public OChip(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public final ImageView getChipIcon() {
        return this.f12323i;
    }

    public final ImageView getCloseIcon() {
        return this.f12325k;
    }

    public final CharSequence getText() {
        return this.f12324j.getText();
    }

    public final TextView getTextView() {
        return this.f12324j;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (this.f12326l == false) goto L6;
        boolean r5 = !this.f12327m;
        this.f12327m = r5;
        this.f12328n.mo2invoke(this, Boolean.valueOf(r5));
    L6:
        return super.performClick();
    }

    public final void setOnCheckedListener(Function2<? super OChip, ? super Boolean, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "l");
        this.f12328n = r5;
    }

    public final void setOnCloseListener(View.OnClickListener r5) {
        this.f12325k.setOnClickListener(r5);
    }

    public final void setText(CharSequence r5) {
        Intrinsics.checkNotNullParameter(r5, "value");
        this.f12324j.setText(r5);
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
    public OChip(final Context r13, AttributeSet r14, int r15) {
        Intrinsics.checkNotNullParameter(r13, "context");
        super(r13, r14, r15, 8);
        View r16 = View.inflate(r13, R$layout.o_chip, this);
        this.f12322h = r16;
        ImageView r5 = (ImageView) r16.findViewById(R$id.chip_icon);
        this.f12323i = r5;
        TextView r10 = (TextView) r16.findViewById(R$id.chip_text);
        this.f12324j = r10;
        ImageView r17 = (ImageView) r16.findViewById(R$id.close_icon);
        this.f12325k = r17;
        this.f12328n = new OChip$onCheckedListener$1(this, r13);
        TypedArray r18 = r13.obtainStyledAttributes(r14, R$styleable.OChip);
        getChipIcon().setImageDrawable(r18.getDrawable(R$styleable.OChip_oui_chip_icon));
        getTextView().setText(r18.getText(R$styleable.OChip_oui_text));
        getCloseIcon().setImageDrawable(r18.getDrawable(R$styleable.OChip_oui_close_icon));
        int r19 = r18.getColor(R$styleable.OChip_oui_chip_icon_tint_color, -1);
        int r11 = r18.getColor(R$styleable.OChip_oui_close_icon_tint_color, -1);
        int r12 = r18.getColor(R$styleable.OChip_oui_text_color, -1);
        this.f12326l = r18.getBoolean(R$styleable.OChip_oui_enable_checked, false);
        Style r20 = Style.values()[r18.getInt(R$styleable.OChip_oui_chip_style, 0)];
        r18.recycle();
        if (r5.getDrawable() == null) goto L5;
        boolean r110 = true;
    L7:
        if (r110 == false) goto L13;
        ViewGroup.LayoutParams r111 = r10.getLayoutParams();
        if (r111 == null) goto L12;
        ViewGroup.MarginLayoutParams r112 = (ViewGroup.MarginLayoutParams) r111;
        r112.setMarginStart(com.lynx.tasm.utils.a.B(4, this));
        r10.setLayoutParams(r112);
        r5.setVisibility(0);
    L17:
        if (r17.getDrawable() == null) goto L23;
        ViewGroup.LayoutParams r113 = r10.getLayoutParams();
        if (r113 == null) goto L22;
        ViewGroup.MarginLayoutParams r114 = (ViewGroup.MarginLayoutParams) r113;
        r114.setMarginEnd(com.lynx.tasm.utils.a.B(6, this));
        r10.setLayoutParams(r114);
        r17.setVisibility(0);
    L26:
        if (r19 == (-1)) goto L31;
        Drawable r115 = r5.getDrawable();
        if (r115 == null) goto L31;
        r115.setTint(r19);
    L31:
        if (r11 == (-1)) goto L36;
        Drawable r116 = r17.getDrawable();
        if (r116 == null) goto L36;
        r116.setTint(r11);
    L36:
        if (r12 == (-1)) goto L38;
        r10.setTextColor(r12);
    L38:
        int r117 = a.f12330a[r20.ordinal()];
        if (r117 != 1) goto L41;
        int r118 = com.lynx.tasm.utils.a.B(99, this);
    L46:
        setRadius(r118);
        return;
    L41:
        if (r117 != 2) goto L44;
        r118 = com.lynx.tasm.utils.a.B(8, this);
        goto L46
    L44:
        throw new NoWhenBranchMatchedException();
    L22:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L23:
        ViewGroup.LayoutParams r119 = r10.getLayoutParams();
        if (r119 == null) goto L49;
        ViewGroup.MarginLayoutParams r120 = (ViewGroup.MarginLayoutParams) r119;
        r120.setMarginEnd(com.lynx.tasm.utils.a.B(6, this));
        r10.setLayoutParams(r120);
        r17.setVisibility(8);
        goto L26
    L49:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L13:
        ViewGroup.LayoutParams r121 = r10.getLayoutParams();
        if (r121 == null) goto L51;
        ViewGroup.MarginLayoutParams r122 = (ViewGroup.MarginLayoutParams) r121;
        r122.setMarginStart(com.lynx.tasm.utils.a.B(6, this));
        r10.setLayoutParams(r122);
        r5.setVisibility(8);
        goto L17
    L51:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L5:
        r110 = false;
        goto L7
    }
}
