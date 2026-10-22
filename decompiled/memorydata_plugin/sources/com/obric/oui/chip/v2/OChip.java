package com.obric.oui.chip.v2;

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
import com.obric.oui.c.a.b;
import com.obric.oui.common.style.f;
import com.obric.oui.common.style.k;
import com.obric.oui.common.util.h;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.layout.OUILinearLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u0000 ^2\u00020\u0001:\u0001^B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010C\u001a\u00020(2\u0006\u0010D\u001a\u00020\u001dH\u0002J\u0010\u0010E\u001a\u00020(2\u0006\u0010D\u001a\u00020\u001dH\u0002J\u0010\u0010F\u001a\u00020(2\u0006\u0010D\u001a\u00020\u001dH\u0002J\u0018\u0010G\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010H\u001a\u00020IH\u0002J\b\u0010J\u001a\u00020\u001dH\u0016J\u000e\u0010K\u001a\u00020(2\u0006\u0010\r\u001a\u00020\u0007J\u000e\u0010L\u001a\u00020(2\u0006\u0010\u0018\u001a\u00020\u0007J\u000e\u0010M\u001a\u00020(2\u0006\u00108\u001a\u00020\u0007J\u000e\u0010N\u001a\u00020(2\u0006\u00109\u001a\u00020\u0007J\u000e\u0010O\u001a\u00020(2\u0006\u0010\u001b\u001a\u00020\u0007J\u0010\u0010P\u001a\u00020(2\u0006\u0010Q\u001a\u00020\u0007H\u0016J\u0010\u0010R\u001a\u00020(2\u0006\u0010S\u001a\u00020\u0007H\u0016J>\u0010T\u001a\u00020(26\u0010U\u001a2\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020(0$J\u0010\u0010V\u001a\u00020(2\b\u0010U\u001a\u0004\u0018\u00010*J\u000e\u0010W\u001a\u00020(2\u0006\u0010X\u001a\u00020\u001dJ\u000e\u0010Y\u001a\u00020(2\u0006\u0010?\u001a\u00020\u0007J\u000e\u0010Z\u001a\u00020(2\u0006\u0010@\u001a\u00020\u0007J\u000e\u0010[\u001a\u00020(2\u0006\u0010\\\u001a\u00020\u001dJ\u0010\u0010]\u001a\u00020(2\u0006\u0010\u001f\u001a\u00020\u001dH\u0002R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\fR\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\fR\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R@\u0010#\u001a4\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020(\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010+\u001a\n -*\u0004\u0018\u00010,0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010/\u001a\n\u0012\u0004\u0012\u000201\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R$\u00103\u001a\u0002022\u0006\u0010\u001e\u001a\u0002028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u000e\u00108\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010:\u001a\u00020;¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u000e\u0010>\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006_"}, d2 = {"Lcom/obric/oui/chip/v2/OChip;", "Lcom/obric/oui/layout/OUIFrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "arrowIcon", "Landroid/widget/ImageView;", "getArrowIcon", "()Landroid/widget/ImageView;", "arrowIconTintColor", "chipArrowSpaceL", "chipArrowSpaceR", "chipContainer", "Lcom/obric/oui/layout/OUILinearLayout;", "getChipContainer", "()Lcom/obric/oui/layout/OUILinearLayout;", "chipIcon", "getChipIcon", "chipIconSpaceL", "chipIconSpaceR", "chipIconTintColor", "closeIcon", "getCloseIcon", "closeIconTintColor", "haveShadow", "", EventBody.KEY_VALUE, "isOn", "()Z", "setOn", "(Z)V", "onCheckedListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "view", "", "onCloseListener", "Landroid/view/View$OnClickListener;", "parent", "Landroid/view/View;", "kotlin.jvm.PlatformType", "pressColor", "shadowsNormal", "", "Lcom/obric/oui/common/style/Shadow;", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "textColor", "textColorDisabled", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "toggleable", "widgetBgColor", "widgetBgColorDisabled", "widgetPaddingLeft", "widgetPaddingRight", "initArrowIcon", "enable", "initChipIcon", "initCloseIcon", "initShadows", "typedArray", "Landroid/content/res/TypedArray;", "performClick", "setArrowIconTintColor", "setChipIconTintColor", "setChipTextColor", "setChipTextColorDisabled", "setCloseIconTintColor", "setMinimumHeight", "minHeight", "setMinimumWidth", "minWidth", "setOnCheckedListener", "l", "setOnCloseListener", "setToggleable", "isToggleable", "setWidgetBgColor", "setWidgetBgColorDisabled", "updateCloseIcon", "visible", "updateColors", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OChip extends OUIFrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13455a = null;
    private boolean A;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final View f13456b;
    private final OUILinearLayout c;
    private final ImageView d;
    private final TextView e;
    private final ImageView f;
    private final ImageView g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private boolean o;
    private Function2<? super OChip, ? super Boolean, Unit> p;
    private View.OnClickListener q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private boolean y;
    private List<k> z;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/chip/v2/OChip$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f13455a = new a(null);
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

    public OChip(Context r18, AttributeSet r19, int r20) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r18, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r19, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10, r20, null, 8, null);
        View r0 = FrameLayout.inflate(r9, ZeusTransformUtils.mapRes(R.layout.o_chip_v2, "layout", "o_chip_v2"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"));
        this.f13456b = r0;
        View r1 = r0.findViewById(ZeusTransformUtils.mapRes(R.id.chip_container, OaidModel.KEY_ID, "chip_container"));
        Intrinsics.checkNotNullExpressionValue(r1, "parent.findViewById(R.id.chip_container)");
        OUILinearLayout r2 = (OUILinearLayout) ZeusTransformUtils.preCheckCast(r1, OUILinearLayout.class, "com.obric.memorydata.plugin");
        this.c = r2;
        View r3 = r0.findViewById(ZeusTransformUtils.mapRes(R.id.chip_icon, OaidModel.KEY_ID, "chip_icon"));
        Intrinsics.checkNotNullExpressionValue(r3, "parent.findViewById(R.id.chip_icon)");
        ImageView r4 = (ImageView) ZeusTransformUtils.preCheckCast(r3, ImageView.class, "com.obric.memorydata.plugin");
        this.d = r4;
        View r5 = r0.findViewById(ZeusTransformUtils.mapRes(R.id.chip_text, OaidModel.KEY_ID, "chip_text"));
        Intrinsics.checkNotNullExpressionValue(r5, "parent.findViewById(R.id.chip_text)");
        this.e = (TextView) ZeusTransformUtils.preCheckCast(r5, TextView.class, "com.obric.memorydata.plugin");
        View r6 = r0.findViewById(ZeusTransformUtils.mapRes(R.id.close_icon, OaidModel.KEY_ID, "close_icon"));
        Intrinsics.checkNotNullExpressionValue(r6, "parent.findViewById(R.id.close_icon)");
        ImageView r7 = (ImageView) ZeusTransformUtils.preCheckCast(r6, ImageView.class, "com.obric.memorydata.plugin");
        this.f = r7;
        View r8 = r0.findViewById(ZeusTransformUtils.mapRes(R.id.arrow_icon, OaidModel.KEY_ID, "arrow_icon"));
        Intrinsics.checkNotNullExpressionValue(r8, "parent.findViewById(R.id.arrow_icon)");
        ImageView r11 = (ImageView) ZeusTransformUtils.preCheckCast(r8, ImageView.class, "com.obric.memorydata.plugin");
        this.g = r11;
        this.A = true;
        TypedArray r12 = r9.obtainStyledAttributes(r10, R.styleable.OChip);
        getChipIcon().setImageDrawable(r12.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_chip_icon, "styleable", "OChip_oui_chip_icon")));
        getTextView().setText(r12.getText(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_text, "styleable", "OChip_oui_text")));
        getCloseIcon().setImageDrawable(r12.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_close_icon, "styleable", "OChip_oui_close_icon")));
        getArrowIcon().setImageDrawable(r12.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_chipArrowIcon, "styleable", "OChip_oui_chipArrowIcon")));
        this.h = r12.getColor(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_chip_icon_tint_color, "styleable", "OChip_oui_chip_icon_tint_color"), 0);
        this.i = r12.getColor(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_close_icon_tint_color, "styleable", "OChip_oui_close_icon_tint_color"), 0);
        this.j = r12.getColor(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_arrow_icon_tint_color, "styleable", "OChip_oui_arrow_icon_tint_color"), 0);
        this.k = r12.getColor(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_text_color, "styleable", "OChip_oui_text_color"), 0);
        this.l = r12.getColor(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_text_color_disabled, "styleable", "OChip_oui_text_color_disabled"), 0);
        this.m = r12.getColor(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_widgetBgColor, "styleable", "OChip_oui_widgetBgColor"), 0);
        this.n = r12.getColor(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_widgetBgColorDisabled, "styleable", "OChip_oui_widgetBgColorDisabled"), 0);
        this.o = r12.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_chip_toggleable, "styleable", "OChip_oui_chip_toggleable"), false);
        this.r = r12.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_widgetPaddingL, "styleable", "OChip_oui_widgetPaddingL"), 0);
        this.s = r12.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_widgetPaddingR, "styleable", "OChip_oui_widgetPaddingR"), 0);
        this.t = r12.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_chipIconSpaceL, "styleable", "OChip_oui_chipIconSpaceL"), 0);
        this.u = r12.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_chipIconSpaceR, "styleable", "OChip_oui_chipIconSpaceR"), 0);
        this.v = r12.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_chipArrowSpaceL, "styleable", "OChip_oui_chipArrowSpaceL"), 0);
        this.w = r12.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_chipArrowSpaceR, "styleable", "OChip_oui_chipArrowSpaceR"), 0);
        getChipContainer().setPadding(this.r, getChipContainer().getPaddingTop(), this.s, getChipContainer().getPaddingBottom());
        int r13 = r12.getColor(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_widgetPressColor, "styleable", "OChip_oui_widgetPressColor"), 0);
        this.x = r13;
        if (r13 == 0) goto L5;
        getChipContainer().setOverridePressColor(this.x);
        getChipContainer().refreshColors("OChip");
    L5:
        Intrinsics.checkNotNullExpressionValue(r12, "this");
        this.y = a(r9, r12);
        r12.recycle();
        TypedArray r14 = r9.obtainStyledAttributes(r10, new int[]{android.R.attr.minWidth, android.R.attr.minHeight});
        int r15 = r14.getDimensionPixelSize(0, 0);
        int r16 = r14.getDimensionPixelSize(1, 0);
        if (r15 <= 0) goto L8;
        getChipContainer().setMinimumWidth(r15);
    L8:
        if (r16 <= 0) goto L10;
        getChipContainer().setMinimumHeight(r16);
    L10:
        r14.recycle();
        setChangeAlphaWhenPress(false);
        if (r4.getDrawable() == null) goto L13;
        boolean r17 = true;
    L14:
        b(r17);
        if (r7.getDrawable() == null) goto L17;
        boolean r21 = true;
    L18:
        c(r21);
        if (r11.getDrawable() == null) goto L21;
        boolean r22 = true;
    L22:
        d(r22);
        a(true);
        int r23 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 99);
        if (this.y == false) goto L25;
        b.b("OChip", "initShadows, have shadow");
        setShadowCornerRadius(r23);
        r2.setRadius(r23);
    L26:
        setClipChildren(false);
        return;
    L25:
        setRadius(r23);
        goto L26
    L21:
        r22 = false;
        goto L22
    L17:
        r21 = false;
        goto L18
    L13:
        r17 = false;
        goto L14
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

    private static final void a(OChip r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        if (r2.isEnabled() == false) goto L9;
        View.OnClickListener r4 = r2.q;
        if (r4 == null) goto L10;
        r4.onClick((View) ZeusTransformUtils.preCheckCast(r2.f, View.class, "com.obric.memorydata.plugin"));
        return;
    L10:
        return;
    }

    private final void a(boolean r2) {
        if (r2 == false) goto L27;
        int r3 = this.m;
        if (r3 == 0) goto L7;
        this.c.setBackgroundColor(r3);
    L7:
        if (this.h == 0) goto L13;
        Drawable r4 = this.d.getDrawable();
        if (r4 == null) goto L13;
        r4.setTint(this.h);
    L13:
        if (this.i == 0) goto L19;
        Drawable r5 = this.f.getDrawable();
        if (r5 == null) goto L19;
        r5.setTint(this.i);
    L19:
        if (this.j == 0) goto L24;
        Drawable r6 = this.g.getDrawable();
        if (r6 == null) goto L24;
        r6.setTint(this.j);
    L24:
        int r7 = this.k;
        if (r7 == 0) goto L38;
        this.e.setTextColor(r7);
        return;
    L38:
        return;
    L27:
        int r8 = this.n;
        if (r8 == 0) goto L31;
        this.c.setBackgroundColor(r8);
    L31:
        if (this.l == 0) goto L40;
        Drawable r9 = this.d.getDrawable();
        if (r9 == null) goto L36;
        r9.setTint(this.l);
    L36:
        this.e.setTextColor(this.l);
        return;
    }

    private final boolean a(Context r6, TypedArray r7) {
        List<k> r8 = f.a((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin"), r7, ZeusTransformUtils.mapRes(R.styleable.OChip_oui_widgetShadowNormal, "styleable", "OChip_oui_widgetShadowNormal"));
        if (r8 == null) goto L5;
        this.z = r8;
        Intrinsics.checkNotNull(r8);
        k r2 = (k) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r8, 0), k.class, "com.obric.memorydata.plugin");
        List<k> r3 = this.z;
        Intrinsics.checkNotNull(r3);
        a(r2, (k) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r3, 1), k.class, "com.obric.memorydata.plugin"));
    L5:
        if (r8 == null) goto L8;
        return true;
    L8:
        return false;
    }

    private final void b(boolean r5) {
        if (r5 == false) goto L5;
        View r6 = (View) ZeusTransformUtils.preCheckCast(this.e, View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r3 = r6.getLayoutParams();
        Objects.requireNonNull(r3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.LayoutParams r1 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin"), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin")).setMarginStart(this.t);
        r6.setLayoutParams(r1);
        this.d.setVisibility(0);
        return;
    L5:
        View r7 = (View) ZeusTransformUtils.preCheckCast(this.e, View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r4 = r7.getLayoutParams();
        Objects.requireNonNull(r4, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.LayoutParams r2 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r4, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin"), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin")).setMarginStart(0);
        r7.setLayoutParams(r2);
        this.d.setVisibility(8);
    }

    private final void c(boolean r5) {
        if (r5 == false) goto L5;
        View r6 = (View) ZeusTransformUtils.preCheckCast(this.f, View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r3 = r6.getLayoutParams();
        Objects.requireNonNull(r3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.LayoutParams r1 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin"), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin")).setMarginStart(this.u);
        r6.setLayoutParams(r1);
        this.f.setVisibility(0);
        this.f.setOnClickListener(new $$Lambda$OChip$dFCF88dJlLwicNuh6h1NwrVTddQ(this));
        return;
    L5:
        View r7 = (View) ZeusTransformUtils.preCheckCast(this.f, View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r4 = r7.getLayoutParams();
        Objects.requireNonNull(r4, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.LayoutParams r2 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r4, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin"), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin")).setMarginStart(0);
        r7.setLayoutParams(r2);
        this.f.setVisibility(8);
    }

    private final void d(boolean r5) {
        if (r5 == false) goto L5;
        View r6 = (View) ZeusTransformUtils.preCheckCast(this.g, View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r3 = r6.getLayoutParams();
        Objects.requireNonNull(r3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.LayoutParams r1 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin"), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin")).setMarginStart(this.v);
        r6.setLayoutParams(r1);
        this.g.setVisibility(0);
        return;
    L5:
        View r7 = (View) ZeusTransformUtils.preCheckCast(this.g, View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r4 = r7.getLayoutParams();
        Objects.requireNonNull(r4, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.LayoutParams r2 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r4, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin"), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin")).setMarginStart(0);
        r7.setLayoutParams(r2);
        this.g.setVisibility(8);
    }

    public static /* synthetic */ void lambda$dFCF88dJlLwicNuh6h1NwrVTddQ(OChip r0, View r1) {
        a(r0, r1);
    }

    public final boolean a() {
        return this.A;
    }

    public final ImageView getArrowIcon() {
        return this.g;
    }

    public final OUILinearLayout getChipContainer() {
        return this.c;
    }

    public final ImageView getChipIcon() {
        return this.d;
    }

    public final ImageView getCloseIcon() {
        return this.f;
    }

    public final CharSequence getText() {
        CharSequence r1 = this.e.getText();
        Intrinsics.checkNotNullExpressionValue(r1, "textView.text");
        return r1;
    }

    public final TextView getTextView() {
        return this.e;
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.o == false) goto L6;
        setOn(!a());
    L6:
        return super.performClick();
    }

    public final void setArrowIconTintColor(int r2) {
        if (r2 == 0) goto L10;
        this.j = r2;
        if (a() == false) goto L11;
        Drawable r1 = this.g.getDrawable();
        if (r1 == null) goto L12;
        r1.setTint(r2);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void setChipIconTintColor(int r2) {
        if (r2 == 0) goto L10;
        this.h = r2;
        if (a() == false) goto L11;
        Drawable r1 = this.d.getDrawable();
        if (r1 == null) goto L12;
        r1.setTint(r2);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void setChipTextColor(int r2) {
        if (r2 == 0) goto L7;
        this.k = r2;
        if (a() == false) goto L8;
        this.e.setTextColor(r2);
        return;
    L8:
        return;
    }

    public final void setChipTextColorDisabled(int r2) {
        if (r2 == 0) goto L11;
        this.l = r2;
        if (a() == true) goto L12;
        Drawable r0 = this.d.getDrawable();
        if (r0 == null) goto L9;
        r0.setTint(r2);
    L9:
        this.e.setTextColor(r2);
        return;
    L12:
        return;
    }

    public final void setCloseIconTintColor(int r2) {
        if (r2 == 0) goto L10;
        this.i = r2;
        if (a() == false) goto L11;
        Drawable r1 = this.f.getDrawable();
        if (r1 == null) goto L12;
        r1.setTint(r2);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // android.view.View
    public void setMinimumHeight(int r1) {
        super.setMinimumHeight(r1);
        this.c.setMinimumHeight(r1);
    }

    @Override // android.view.View
    public void setMinimumWidth(int r1) {
        super.setMinimumWidth(r1);
        this.c.setMinimumWidth(r1);
    }

    public final void setOn(boolean r2) {
        if (this.A == r2) goto L9;
        this.A = r2;
        a(r2);
        Function2<? super OChip, ? super Boolean, Unit> r3 = this.p;
        if (r3 == null) goto L10;
        r3.invoke(this, Boolean.valueOf(this.A));
        return;
    L10:
        return;
    }

    public final void setOnCheckedListener(Function2<? super OChip, ? super Boolean, Unit> r3) {
        Function2<? super OChip, ? super Boolean, Unit> r4 = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "l");
        this.p = r4;
    }

    public final void setOnCloseListener(View.OnClickListener r3) {
        this.q = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.memorydata.plugin");
    }

    public final void setText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, EventBody.KEY_VALUE);
        this.e.setText(r4);
    }

    public final void setToggleable(boolean r1) {
        this.o = r1;
    }

    public final void setWidgetBgColor(int r2) {
        if (r2 == 0) goto L7;
        this.m = r2;
        if (a() == false) goto L8;
        this.c.setBackgroundColor(r2);
        return;
    L8:
        return;
    }

    public final void setWidgetBgColorDisabled(int r2) {
        if (r2 == 0) goto L7;
        this.n = r2;
        if (a() == true) goto L8;
        this.c.setBackgroundColor(r2);
        return;
    L8:
        return;
    }
}
