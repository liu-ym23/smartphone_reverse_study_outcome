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
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.util.h;
import com.obric.oui.layout.OUIFrameLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated(message = "use com.obric.oui.chip.v2.OChip instead")
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u00017B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ0\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0007H\u0014J\u0018\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0007H\u0014J\b\u0010/\u001a\u00020\nH\u0016J>\u00100\u001a\u00020\u001726\u00101\u001a2\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00170\u0013J\u0010\u00102\u001a\u00020\u00172\b\u00101\u001a\u0004\u0018\u000103J\u0010\u00104\u001a\u00020\u00172\u0006\u00105\u001a\u00020\nH\u0002J\u0010\u00106\u001a\u00020\u00172\u0006\u00105\u001a\u00020\nH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\u0012\u001a2\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00170\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n \u001a*\u0004\u0018\u00010\u00190\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u00068"}, d2 = {"Lcom/obric/oui/chip/OChip;", "Lcom/obric/oui/layout/OUIFrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "checked", "", "chipIcon", "Landroid/widget/ImageView;", "getChipIcon", "()Landroid/widget/ImageView;", "closeIcon", "getCloseIcon", "enableChecked", "onCheckedListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "view", "", "parent", "Landroid/view/View;", "kotlin.jvm.PlatformType", EventBody.KEY_VALUE, "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "performClick", "setOnCheckedListener", "l", "setOnCloseListener", "Landroid/view/View$OnClickListener;", "updateChipIcon", "enable", "updateCloseIcon", "Style", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OChip extends OUIFrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f13452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ImageView f13453b;
    private final TextView c;
    private final ImageView d;
    private final boolean e;
    private boolean f;
    private Function2<? super OChip, ? super Boolean, Unit> g;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/chip/OChip$Style;", "", "(Ljava/lang/String;I)V", "Default", "Rect", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum Style extends Enum<Style> {
        private static final /* synthetic */ Style[] $VALUES = null;
        public static final Style Default = null;
        public static final Style Rect = null;

        private static final /* synthetic */ Style[] $values() {
            return new Style[]{Default, Rect};
        }

        static {
            Default = new Style("Default", 0);
            Rect = new Style("Rect", 1);
            $VALUES = $values();
        }

        private Style(String r1, int r2) {
            super(r1, r2);
        }

        public static Style valueOf(String r2) {
            return (Style) ZeusTransformUtils.preCheckCast(Enum.valueOf(Style.class, r2), Style.class, "com.obric.memorydata.plugin");
        }

        public static Style[] values() {
            return (Style[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Style[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13454a = null;

        static {
            int[] r0 = new int[Style.values().length];
            r0[Style.Default.ordinal()] = 1;
            r0[Style.Rect.ordinal()] = 2;
            f13454a = r0;
        }
    }

    public OChip(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OChip(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OChip(Context r12, AttributeSet r13, int r14) {
        final Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r16 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r13, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r15, "context");
        super(r15, r16, r14, null, 8, null);
        View r17 = FrameLayout.inflate(r15, ZeusTransformUtils.mapRes(R.layout.o_chip, "layout", "o_chip"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"));
        this.f13452a = r17;
        View r0 = r17.findViewById(ZeusTransformUtils.mapRes(R.id.chip_icon, OaidModel.KEY_ID, "chip_icon"));
        Intrinsics.checkNotNullExpressionValue(r0, "parent.findViewById(R.id.chip_icon)");
        ImageView r1 = (ImageView) ZeusTransformUtils.preCheckCast(r0, ImageView.class, "com.obric.memorydata.plugin");
        this.f13453b = r1;
        View r3 = r17.findViewById(ZeusTransformUtils.mapRes(R.id.chip_text, OaidModel.KEY_ID, "chip_text"));
        Intrinsics.checkNotNullExpressionValue(r3, "parent.findViewById(R.id.chip_text)");
        TextView r4 = (TextView) ZeusTransformUtils.preCheckCast(r3, TextView.class, "com.obric.memorydata.plugin");
        this.c = r4;
        View r18 = r17.findViewById(ZeusTransformUtils.mapRes(R.id.close_icon, OaidModel.KEY_ID, "close_icon"));
        Intrinsics.checkNotNullExpressionValue(r18, "parent.findViewById(R.id.close_icon)");
        ImageView r19 = (ImageView) ZeusTransformUtils.preCheckCast(r18, ImageView.class, "com.obric.memorydata.plugin");
        this.d = r19;
        this.g = (Function2) ZeusTransformUtils.preCheckCast(new OChip$onCheckedListener$1(this, r15), Function2.class, "com.obric.memorydata.plugin");
        TypedArray r110 = r15.obtainStyledAttributes(r16, R.styleable.OChip);
        getChipIcon().setImageDrawable(r110.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_chip_icon, "styleable", "OChip_oui_chip_icon")));
        getTextView().setText(r110.getText(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_text, "styleable", "OChip_oui_text")));
        getCloseIcon().setImageDrawable(r110.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_close_icon, "styleable", "OChip_oui_close_icon")));
        int r111 = r110.getColor(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_chip_icon_tint_color, "styleable", "OChip_oui_chip_icon_tint_color"), -1);
        int r5 = r110.getColor(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_close_icon_tint_color, "styleable", "OChip_oui_close_icon_tint_color"), -1);
        int r6 = r110.getColor(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_text_color, "styleable", "OChip_oui_text_color"), -1);
        boolean r8 = false;
        this.e = r110.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_enable_checked, "styleable", "OChip_oui_enable_checked"), false);
        Style r7 = Style.values()[r110.getInt(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_chip_style, "styleable", "OChip_oui_chip_style"), 0)];
        r110.recycle();
        if (r1.getDrawable() == null) goto L5;
        boolean r112 = true;
    L6:
        a(r112);
        if (r19.getDrawable() == null) goto L9;
        r8 = true;
    L9:
        b(r8);
        if (r111 == (-1)) goto L15;
        Drawable r113 = r1.getDrawable();
        if (r113 == null) goto L15;
        r113.setTint(r111);
    L15:
        if (r5 == (-1)) goto L20;
        Drawable r114 = r19.getDrawable();
        if (r114 == null) goto L20;
        r114.setTint(r5);
    L20:
        if (r6 == (-1)) goto L22;
        r4.setTextColor(r6);
    L22:
        int r115 = a.f13454a[r7.ordinal()];
        if (r115 != 1) goto L25;
        View r116 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
        int r117 = 99;
    L30:
        setRadius(h.a(r116, r117));
        return;
    L25:
        if (r115 != 2) goto L28;
        r116 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
        r117 = 8;
        goto L30
    L28:
        throw new NoWhenBranchMatchedException();
    L5:
        r112 = false;
        goto L6
    }

    public /* synthetic */ OChip(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
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

    private final void a(boolean r5) {
        if (r5 == false) goto L5;
        View r6 = (View) ZeusTransformUtils.preCheckCast(this.c, View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r2 = r6.getLayoutParams();
        Objects.requireNonNull(r2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.LayoutParams r0 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin"), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin")).setMarginStart(h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 4));
        r6.setLayoutParams(r0);
        ImageView r4 = this.f13453b;
        int r7 = 0;
    L6:
        r4.setVisibility(r7);
        return;
    L5:
        View r8 = (View) ZeusTransformUtils.preCheckCast(this.c, View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r3 = r8.getLayoutParams();
        Objects.requireNonNull(r3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.LayoutParams r1 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin"), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin")).setMarginStart(h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 6));
        r8.setLayoutParams(r1);
        r4 = this.f13453b;
        r7 = 8;
        goto L6
    }

    public static final /* synthetic */ boolean a(OChip r0) {
        return r0.f;
    }

    private final void b(boolean r6) {
        if (r6 == false) goto L5;
        View r7 = (View) ZeusTransformUtils.preCheckCast(this.c, View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r3 = r7.getLayoutParams();
        Objects.requireNonNull(r3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.LayoutParams r1 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin"), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin")).setMarginEnd(h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 6));
        r7.setLayoutParams(r1);
        ImageView r5 = this.d;
        int r8 = 0;
    L6:
        r5.setVisibility(r8);
        return;
    L5:
        View r9 = (View) ZeusTransformUtils.preCheckCast(this.c, View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r4 = r9.getLayoutParams();
        Objects.requireNonNull(r4, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.LayoutParams r2 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r4, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin"), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin")).setMarginEnd(h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 6));
        r9.setLayoutParams(r2);
        r5 = this.d;
        r8 = 8;
        goto L6
    }

    public final ImageView getChipIcon() {
        return this.f13453b;
    }

    public final ImageView getCloseIcon() {
        return this.d;
    }

    public final CharSequence getText() {
        CharSequence r1 = this.c.getText();
        Intrinsics.checkNotNullExpressionValue(r1, "textView.text");
        return r1;
    }

    public final TextView getTextView() {
        return this.c;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.e == false) goto L6;
        boolean r0 = !this.f;
        this.f = r0;
        this.g.invoke(this, Boolean.valueOf(r0));
    L6:
        return super.performClick();
    }

    public final void setOnCheckedListener(Function2<? super OChip, ? super Boolean, Unit> r3) {
        Function2<? super OChip, ? super Boolean, Unit> r4 = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "l");
        this.g = r4;
    }

    public final void setOnCloseListener(View.OnClickListener r3) {
        View.OnClickListener r4 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.memorydata.plugin");
        this.d.setOnClickListener(r4);
    }

    public final void setText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, EventBody.KEY_VALUE);
        this.c.setText(r4);
    }
}
