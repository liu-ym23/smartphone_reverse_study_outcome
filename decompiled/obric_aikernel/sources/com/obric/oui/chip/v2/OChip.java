package com.obric.oui.chip.v2;

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
import com.bytedance.crash.NpthBus;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.layout.OUILinearLayout;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import o9.k;
import o9.p;
import u8.f;
import u8.h;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\"B'\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J>\u0010\f\u001a\u00020\u000426\u0010\u0003\u001a2\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00040\u0006R$\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006#"}, d2 = {"Lcom/obric/oui/chip/v2/OChip;", "Lcom/obric/oui/layout/OUIFrameLayout;", "Landroid/view/View$OnClickListener;", "l", "", "setOnCloseListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "view", "", "isOn", "setOnCheckedListener", "", EventBody.KEY_VALUE, "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "text", NpthBus.UUID_SUFIX_3_1_3, "Z", "h", "()Z", "setOn", "(Z)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OChip extends OUIFrameLayout {
    private int A;
    private int B;
    private int C;
    private int D;
    private boolean E;
    private List<p> F;
    private boolean G;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final View f6380l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final OUILinearLayout f6381m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final ImageView f6382n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final TextView f6383o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final ImageView f6384p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final int f6385q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final int f6386r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final int f6387s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final int f6388t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final int f6389u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final int f6390v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final boolean f6391w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Function2<? super OChip, ? super Boolean, Unit> f6392x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private View.OnClickListener f6393y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f6394z;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OChip f6395c;

        b(OChip r10) {
            this.f6395c = r10;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            if (this.f6395c.isEnabled() == false) goto L8;
            View.OnClickListener r11 = OChip.d(this.f6395c);
            if (r11 == null) goto L9;
            r11.onClick(OChip.c(this.f6395c));
            return;
        L9:
            return;
        }
    }

    static {
        new a(null);
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
    public OChip(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12, null, 8, null);
        View r13 = FrameLayout.inflate(r10, h.o_chip_v2, this);
        this.f6380l = r13;
        View r14 = r13.findViewById(f.chip_container);
        Intrinsics.checkNotNullExpressionValue(r14, "parent.findViewById(R.id.chip_container)");
        OUILinearLayout r15 = (OUILinearLayout) r14;
        this.f6381m = r15;
        View r16 = r13.findViewById(f.chip_icon);
        Intrinsics.checkNotNullExpressionValue(r16, "parent.findViewById(R.id.chip_icon)");
        ImageView r17 = (ImageView) r16;
        this.f6382n = r17;
        View r18 = r13.findViewById(f.chip_text);
        Intrinsics.checkNotNullExpressionValue(r18, "parent.findViewById(R.id.chip_text)");
        TextView r19 = (TextView) r18;
        this.f6383o = r19;
        View r110 = r13.findViewById(f.close_icon);
        Intrinsics.checkNotNullExpressionValue(r110, "parent.findViewById(R.id.close_icon)");
        ImageView r111 = (ImageView) r110;
        this.f6384p = r111;
        this.G = true;
        TypedArray r112 = r10.obtainStyledAttributes(r11, l.OChip);
        r17.setImageDrawable(r112.getDrawable(l.OChip_oui_chip_icon));
        r19.setText(r112.getText(l.OChip_oui_text));
        r111.setImageDrawable(r112.getDrawable(l.OChip_oui_close_icon));
        this.f6385q = r112.getColor(l.OChip_oui_chip_icon_tint_color, 0);
        this.f6386r = r112.getColor(l.OChip_oui_close_icon_tint_color, 0);
        this.f6387s = r112.getColor(l.OChip_oui_text_color, 0);
        this.f6388t = r112.getColor(l.OChip_oui_text_color_disabled, 0);
        this.f6389u = r112.getColor(l.OChip_oui_widgetBgColor, 0);
        this.f6390v = r112.getColor(l.OChip_oui_widgetBgColorDisabled, 0);
        this.f6391w = r112.getBoolean(l.OChip_oui_chip_toggleable, false);
        this.f6394z = r112.getDimensionPixelSize(l.OChip_oui_widgetPaddingL, 0);
        this.A = r112.getDimensionPixelSize(l.OChip_oui_widgetPaddingR, 0);
        this.B = r112.getDimensionPixelSize(l.OChip_oui_chipIconSpaceL, 0);
        this.C = r112.getDimensionPixelSize(l.OChip_oui_chipIconSpaceR, 0);
        r15.setPadding(this.f6394z, r15.getPaddingTop(), this.A, r15.getPaddingBottom());
        int r20 = r112.getColor(l.OChip_oui_widgetPressColor, 0);
        this.D = r20;
        if (r20 == 0) goto L5;
        r15.setOverridePressColor(r20);
        r15.refreshColors("OChip");
    L5:
        Intrinsics.checkNotNullExpressionValue(r112, "this");
        this.E = g(r10, r112);
        r112.recycle();
        setChangeAlphaWhenPress(false);
        if (r17.getDrawable() == null) goto L8;
        boolean r21 = true;
    L9:
        e(r21);
        if (r111.getDrawable() == null) goto L12;
        boolean r22 = true;
    L13:
        f(r22);
        i(true);
        Resources r113 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r113, "Resources.getSystem()");
        int r23 = MathKt.roundToInt(TypedValue.applyDimension(1, 99, r113.getDisplayMetrics()));
        if (this.E == false) goto L16;
        ea.b.a("OChip", "initShadows, have shadow");
        setShadowCornerRadius(r23);
        r15.setRadius(r23);
    L17:
        setClipChildren(false);
        return;
    L16:
        setRadius(r23);
        goto L17
    L12:
        r22 = false;
        goto L13
    L8:
        r21 = false;
        goto L9
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

    public static final /* synthetic */ ImageView c(OChip r10) {
        return r10.f6384p;
    }

    public static final /* synthetic */ View.OnClickListener d(OChip r10) {
        return r10.f6393y;
    }

    private final void e(boolean r10) {
        if (r10 == false) goto L5;
        TextView r11 = this.f6383o;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        Objects.requireNonNull(r12, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r12;
        r13.setMarginStart(this.B);
        r11.setLayoutParams(r13);
        this.f6382n.setVisibility(0);
        return;
    L5:
        TextView r14 = this.f6383o;
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        Objects.requireNonNull(r15, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r15;
        r16.setMarginStart(0);
        r14.setLayoutParams(r16);
        this.f6382n.setVisibility(8);
    }

    private final void f(boolean r10) {
        if (r10 == false) goto L5;
        ImageView r11 = this.f6384p;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        Objects.requireNonNull(r12, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r12;
        r13.setMarginStart(this.C);
        r11.setLayoutParams(r13);
        this.f6384p.setVisibility(0);
        this.f6384p.setOnClickListener(new b(this));
        return;
    L5:
        ImageView r14 = this.f6384p;
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        Objects.requireNonNull(r15, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r15;
        r16.setMarginStart(0);
        r14.setLayoutParams(r16);
        this.f6384p.setVisibility(8);
    }

    private final boolean g(Context r10, TypedArray r11) {
        int r12 = r11.getResourceId(l.OChip_oui_widgetShadowNormal, 0);
        if (r12 == 0) goto L5;
        boolean r13 = true;
    L6:
        if (r12 == 0) goto L8;
        List<p> r14 = k.v(r10, r12);
        List<p> r15 = CollectionsKt.listOf(new p[]{r14.get(0), r14.get(1)});
        this.F = r15;
        Intrinsics.checkNotNull(r15);
        p r16 = (p) CollectionsKt.getOrNull(r15, 0);
        List<p> r17 = this.F;
        Intrinsics.checkNotNull(r17);
        setShadow(r16, (p) CollectionsKt.getOrNull(r17, 1));
    L8:
        return r13;
    L5:
        r13 = false;
        goto L6
    }

    private final void i(boolean r10) {
        if (r10 == false) goto L19;
        int r11 = this.f6389u;
        if (r11 == 0) goto L7;
        this.f6381m.setBackgroundColor(r11);
    L7:
        if (this.f6385q == 0) goto L12;
        Drawable r12 = this.f6382n.getDrawable();
        if (r12 == null) goto L12;
        r12.setTint(this.f6385q);
    L12:
        if (this.f6386r == 0) goto L16;
        Drawable r13 = this.f6384p.getDrawable();
        if (r13 == null) goto L16;
        r13.setTint(this.f6386r);
    L16:
        int r14 = this.f6387s;
        if (r14 == 0) goto L29;
        this.f6383o.setTextColor(r14);
        return;
    L29:
        return;
    L19:
        int r15 = this.f6390v;
        if (r15 == 0) goto L23;
        this.f6381m.setBackgroundColor(r15);
    L23:
        if (this.f6388t == 0) goto L31;
        Drawable r16 = this.f6382n.getDrawable();
        if (r16 == null) goto L27;
        r16.setTint(this.f6388t);
    L27:
        this.f6383o.setTextColor(this.f6388t);
        return;
    }

    public final CharSequence getText() {
        CharSequence r10 = this.f6383o.getText();
        Intrinsics.checkNotNullExpressionValue(r10, "textView.text");
        return r10;
    }

    public final boolean h() {
        return this.G;
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.f6391w == false) goto L6;
        setOn(!h());
    L6:
        return super.performClick();
    }

    public final void setOn(boolean r10) {
        if (this.G == r10) goto L8;
        this.G = r10;
        i(r10);
        Function2<? super OChip, ? super Boolean, Unit> r11 = this.f6392x;
        if (r11 == null) goto L9;
        Unit r12 = r11.invoke(this, Boolean.valueOf(this.G));
        return;
    L9:
        return;
    }

    public final void setOnCheckedListener(Function2<? super OChip, ? super Boolean, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "l");
        this.f6392x = r10;
    }

    public final void setOnCloseListener(View.OnClickListener r10) {
        this.f6393y = r10;
    }

    public final void setText(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, EventBody.KEY_VALUE);
        this.f6383o.setText(r10);
    }
}
