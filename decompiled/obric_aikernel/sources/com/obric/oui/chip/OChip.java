package com.obric.oui.chip;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.oui.layout.OUIFrameLayout;
import java.util.Objects;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import u8.f;
import u8.h;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated(message = "use com.obric.oui.chip.v2.OChip instead")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001+B'\b\u0007\u0012\u0006\u0010$\u001a\u00020#\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\b\b\u0002\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J>\u0010\f\u001a\u00020\u000426\u0010\u0003\u001a2\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00040\u0006R\u0019\u0010\u0012\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0015\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u0019\u0010\u001b\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR$\u0010\"\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006,"}, d2 = {"Lcom/obric/oui/chip/OChip;", "Lcom/obric/oui/layout/OUIFrameLayout;", "Landroid/view/View$OnClickListener;", "l", "", "setOnCloseListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "view", "", "checked", "setOnCheckedListener", "Landroid/widget/ImageView;", "m", "Landroid/widget/ImageView;", "getChipIcon", "()Landroid/widget/ImageView;", "chipIcon", "o", "getCloseIcon", "closeIcon", "Landroid/widget/TextView;", "n", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "textView", "", EventBody.KEY_VALUE, "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "text", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Style", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OChip extends OUIFrameLayout {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final View f6372l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final ImageView f6373m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final TextView f6374n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final ImageView f6375o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f6376p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f6377q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Function2<? super OChip, ? super Boolean, Unit> f6378r;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/chip/OChip$Style;", "", "<init>", "(Ljava/lang/String;I)V", "Default", "Rect", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Style extends Enum<Style> {
        private static final /* synthetic */ Style[] $VALUES = null;
        public static final Style Default = null;
        public static final Style Rect = null;

        static {
            Style r10 = new Style("Default", 0);
            Default = r10;
            Style r11 = new Style("Rect", 1);
            Rect = r11;
            $VALUES = new Style[]{r10, r11};
        }

        private Style(String r10, int r11) {
            super(r10, r11);
        }

        public static Style valueOf(String r10) {
            return (Style) Enum.valueOf(Style.class, r10);
        }

        public static Style[] values() {
            return (Style[]) $VALUES.clone();
        }
    }

    @JvmOverloads
    public OChip(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public OChip(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public OChip(final Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12, null, 8, null);
        View r13 = FrameLayout.inflate(r10, h.o_chip, this);
        this.f6372l = r13;
        View r14 = r13.findViewById(f.chip_icon);
        Intrinsics.checkNotNullExpressionValue(r14, "parent.findViewById(R.id.chip_icon)");
        ImageView r15 = (ImageView) r14;
        this.f6373m = r15;
        View r16 = r13.findViewById(f.chip_text);
        Intrinsics.checkNotNullExpressionValue(r16, "parent.findViewById(R.id.chip_text)");
        TextView r17 = (TextView) r16;
        this.f6374n = r17;
        View r18 = r13.findViewById(f.close_icon);
        Intrinsics.checkNotNullExpressionValue(r18, "parent.findViewById(R.id.close_icon)");
        ImageView r19 = (ImageView) r18;
        this.f6375o = r19;
        this.f6378r = new OChip$onCheckedListener$1(this, r10);
        TypedArray r20 = r10.obtainStyledAttributes(r11, l.OChip);
        r15.setImageDrawable(r20.getDrawable(l.OChip_oui_chip_icon));
        r17.setText(r20.getText(l.OChip_oui_text));
        r19.setImageDrawable(r20.getDrawable(l.OChip_oui_close_icon));
        int r110 = r20.getColor(l.OChip_oui_chip_icon_tint_color, -1);
        int r21 = r20.getColor(l.OChip_oui_close_icon_tint_color, -1);
        int r22 = r20.getColor(l.OChip_oui_text_color, -1);
        boolean r23 = false;
        this.f6376p = r20.getBoolean(l.OChip_oui_enable_checked, false);
        Style r24 = Style.values()[r20.getInt(l.OChip_oui_chip_style, 0)];
        r20.recycle();
        if (r15.getDrawable() == null) goto L5;
        boolean r25 = true;
    L6:
        d(r25);
        if (r19.getDrawable() == null) goto L9;
        r23 = true;
    L9:
        e(r23);
        if (r110 == (-1)) goto L14;
        Drawable r26 = r15.getDrawable();
        if (r26 == null) goto L14;
        r26.setTint(r110);
    L14:
        if (r21 == (-1)) goto L18;
        Drawable r27 = r19.getDrawable();
        if (r27 == null) goto L18;
        r27.setTint(r21);
    L18:
        if (r22 == (-1)) goto L20;
        r17.setTextColor(r22);
    L20:
        int r28 = a.f6379a[r24.ordinal()];
        if (r28 != 1) goto L23;
        int r29 = 99;
    L28:
        Resources r111 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r111, "Resources.getSystem()");
        setRadius(MathKt.roundToInt(TypedValue.applyDimension(1, r29, r111.getDisplayMetrics())));
        return;
    L23:
        if (r28 != 2) goto L26;
        r29 = 8;
        goto L28
    L26:
        throw new NoWhenBranchMatchedException();
    L5:
        r25 = false;
        goto L6
    }

    public /* synthetic */ OChip(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    public static final /* synthetic */ boolean c(OChip r10) {
        return r10.f6377q;
    }

    private final void d(boolean r10) {
        if (r10 == false) goto L5;
        TextView r11 = this.f6374n;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        Objects.requireNonNull(r12, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r12;
        Resources r14 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r14, "Resources.getSystem()");
        r13.setMarginStart(MathKt.roundToInt(TypedValue.applyDimension(1, 4, r14.getDisplayMetrics())));
        r11.setLayoutParams(r13);
        ImageView r15 = this.f6373m;
        int r16 = 0;
    L6:
        r15.setVisibility(r16);
        return;
    L5:
        TextView r17 = this.f6374n;
        ViewGroup.LayoutParams r18 = r17.getLayoutParams();
        Objects.requireNonNull(r18, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) r18;
        Resources r20 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r20, "Resources.getSystem()");
        r19.setMarginStart(MathKt.roundToInt(TypedValue.applyDimension(1, 6, r20.getDisplayMetrics())));
        r17.setLayoutParams(r19);
        r15 = this.f6373m;
        r16 = 8;
        goto L6
    }

    private final void e(boolean r10) {
        if (r10 == false) goto L5;
        TextView r11 = this.f6374n;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        Objects.requireNonNull(r12, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r12;
        Resources r14 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r14, "Resources.getSystem()");
        r13.setMarginEnd(MathKt.roundToInt(TypedValue.applyDimension(1, 6, r14.getDisplayMetrics())));
        r11.setLayoutParams(r13);
        ImageView r15 = this.f6375o;
        int r16 = 0;
    L6:
        r15.setVisibility(r16);
        return;
    L5:
        TextView r17 = this.f6374n;
        ViewGroup.LayoutParams r18 = r17.getLayoutParams();
        Objects.requireNonNull(r18, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) r18;
        Resources r20 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r20, "Resources.getSystem()");
        r19.setMarginEnd(MathKt.roundToInt(TypedValue.applyDimension(1, 6, r20.getDisplayMetrics())));
        r17.setLayoutParams(r19);
        r15 = this.f6375o;
        r16 = 8;
        goto L6
    }

    public final ImageView getChipIcon() {
        return this.f6373m;
    }

    public final ImageView getCloseIcon() {
        return this.f6375o;
    }

    public final CharSequence getText() {
        CharSequence r10 = this.f6374n.getText();
        Intrinsics.checkNotNullExpressionValue(r10, "textView.text");
        return r10;
    }

    public final TextView getTextView() {
        return this.f6374n;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.f6376p == false) goto L6;
        boolean r10 = !this.f6377q;
        this.f6377q = r10;
        this.f6378r.invoke(this, Boolean.valueOf(r10));
    L6:
        return super.performClick();
    }

    public final void setOnCheckedListener(Function2<? super OChip, ? super Boolean, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "l");
        this.f6378r = r10;
    }

    public final void setOnCloseListener(View.OnClickListener r10) {
        this.f6375o.setOnClickListener(r10);
    }

    public final void setText(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, EventBody.KEY_VALUE);
        this.f6374n.setText(r10);
    }
}
