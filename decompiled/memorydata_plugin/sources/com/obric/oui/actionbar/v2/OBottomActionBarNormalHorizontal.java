package com.obric.oui.actionbar.v2;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.c.a.b;
import com.obric.oui.common.util.h;
import com.obric.oui.divider.ODivider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\n\u0018\u0000 -2\u00020\u0001:\u0001-B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0006\u0010\u001c\u001a\u00020\bJ\u0006\u0010\u001d\u001a\u00020\bJ\u0006\u0010\u001e\u001a\u00020\u001bJ\u0006\u0010\u001f\u001a\u00020\u0018J\u0006\u0010 \u001a\u00020\u0018J\u000e\u0010 \u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0016J\u0006\u0010!\u001a\u00020\u0018J\u0014\u0010\"\u001a\u00020\u00182\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00160$J\u000e\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u0016J\u000e\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\bJ\u000e\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\u001bJ\u000e\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\bR\u0014\u0010\u0007\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u000e\u0010\r\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/obric/oui/actionbar/v2/OBottomActionBarNormalHorizontal;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "BOTTOM_ACTION_PADDING_BOTTOM", "", "getBOTTOM_ACTION_PADDING_BOTTOM", "()I", "BOTTOM_ACTION_PADDING_BOTTOM_WITH_THREE_BTN_MODE", "getBOTTOM_ACTION_PADDING_BOTTOM_WITH_THREE_BTN_MODE", "buttonGap", "defaultPaddingBottom", "divider", "Lcom/obric/oui/divider/ODivider;", "headerContainer", "horizontalContainer", "Landroid/widget/LinearLayout;", "maxButtons", "root", "Landroid/view/View;", "addButton", "", "button", "isSingleButton", "", "getButtonCount", "getMaxButtonCount", "hasHeaderView", "removeAllButtons", "removeButton", "removeHeaderView", "setButtons", "buttons", "", "setHeaderView", "headerView", "setMaxButtonCount", "maxCount", "showDivider", "show", "updateLayoutForInsetBottom", "insetBottom", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBottomActionBarNormalHorizontal extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13280a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f13281b;
    private final int c;
    private ODivider d;
    private View e;
    private LinearLayout f;
    private FrameLayout g;
    private int h;
    private int i;
    private int j;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/actionbar/v2/OBottomActionBarNormalHorizontal$Companion;", "", "()V", "MAX_BUTTONS", "", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f13280a = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OBottomActionBarNormalHorizontal(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public OBottomActionBarNormalHorizontal(Context r10, AttributeSet r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r13 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "context");
        super(r12, r13);
        this.f13281b = 24;
        this.c = 40;
        this.h = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12);
        this.i = 2;
        ZeusTransformUtils.inflate(r12, ZeusTransformUtils.mapRes(R.layout.o_widget_bottom_action_bar_v2_normal_horizontal, "layout", "o_widget_bottom_action_bar_v2_normal_horizontal"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        View r0 = findViewById(ZeusTransformUtils.mapRes(R.id.bottom_action_bar_root, OaidModel.KEY_ID, "bottom_action_bar_root"));
        Intrinsics.checkNotNullExpressionValue(r0, "findViewById(R.id.bottom_action_bar_root)");
        this.e = r0;
        this.j = r0.getPaddingBottom();
        ODivider r1 = new ODivider(r12, null, 0, 6, null);
        this.d = r1;
        addView((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.memorydata.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 0.6d)), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        View r2 = findViewById(ZeusTransformUtils.mapRes(R.id.action_bar_horizontal_container, OaidModel.KEY_ID, "action_bar_horizontal_container"));
        Intrinsics.checkNotNullExpressionValue(r2, "findViewById(R.id.action_bar_horizontal_container)");
        this.f = (LinearLayout) ZeusTransformUtils.preCheckCast(r2, LinearLayout.class, "com.obric.memorydata.plugin");
        View r3 = findViewById(ZeusTransformUtils.mapRes(R.id.action_bar_header_container, OaidModel.KEY_ID, "action_bar_header_container"));
        Intrinsics.checkNotNullExpressionValue(r3, "findViewById(R.id.action_bar_header_container)");
        this.g = (FrameLayout) ZeusTransformUtils.preCheckCast(r3, FrameLayout.class, "com.obric.memorydata.plugin");
        setClipChildren(false);
        setClipToPadding(false);
        int[] r4 = R.styleable.OBottomActionBar;
        Intrinsics.checkNotNullExpressionValue(r4, "OBottomActionBar");
        TypedArray r14 = r12.obtainStyledAttributes(r13, r4, 0, 0);
        Intrinsics.checkNotNullExpressionValue(r14, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        if (r14.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OBottomActionBar_oui_widgetFitInsetBottom, "styleable", "OBottomActionBar_oui_widgetFitInsetBottom"), true) == false) goto L5;
        com.obric.oui.window.a r15 = com.obric.oui.window.a.f14878a;
        a(com.obric.oui.window.a.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), null, true).e);
        setOnApplyWindowInsetsListener(new $$Lambda$OBottomActionBarNormalHorizontal$7ty1bb4ECAnH25OMX4SX_UOdYf8(this));
    L5:
        r14.recycle();
    }

    public /* synthetic */ OBottomActionBarNormalHorizontal(Context r2, AttributeSet r3, int r4, DefaultConstructorMarker r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    private static final WindowInsets a(OBottomActionBarNormalHorizontal r1, View r2, WindowInsets r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$noName_0");
        Intrinsics.checkNotNullParameter(r3, "insets");
        com.obric.oui.window.a r4 = com.obric.oui.window.a.f14878a;
        r1.a(com.obric.oui.window.a.a((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.memorydata.plugin"), r3, true).e);
        return r3;
    }

    private final void a(View r5, boolean r6) {
        ViewGroup.LayoutParams r0 = r5.getLayoutParams();
        if (r0 == null) goto L5;
        LinearLayout.LayoutParams r2 = new LinearLayout.LayoutParams(r0.width, r0.height);
    L6:
        if (r6 == false) goto L8;
        r2.width = -1;
    L9:
        LinearLayout r7 = this.f;
        if (r7.getChildCount() <= 0) goto L12;
        r2.leftMargin = this.h;
    L12:
        Unit r4 = Unit.INSTANCE;
        r7.addView(r5, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        return;
    L8:
        r2.width = 0;
        r2.weight = 1.0f;
        goto L9
    L5:
        r2 = new LinearLayout.LayoutParams(-1, -2);
        goto L6
    }

    public static /* synthetic */ WindowInsets lambda$7ty1bb4ECAnH25OMX4SX_UOdYf8(OBottomActionBarNormalHorizontal r0, View r1, WindowInsets r2) {
        return a(r0, r1, r2);
    }

    public final void a(int r8) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        if (com.obric.oui.window.a.f(r0) == true) goto L7;
        if (r8 <= 0) goto L7;
        int r1 = this.c;
    L8:
        View r2 = this.e;
        r2.setPaddingRelative(r2.getPaddingLeft(), this.e.getPaddingTop(), this.e.getPaddingRight(), Math.max(r8, h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r1)));
        return;
    L7:
        r1 = this.f13281b;
        goto L8
    }

    public final int getBOTTOM_ACTION_PADDING_BOTTOM() {
        return this.f13281b;
    }

    public final int getBOTTOM_ACTION_PADDING_BOTTOM_WITH_THREE_BTN_MODE() {
        return this.c;
    }

    public final int getButtonCount() {
        return this.f.getChildCount();
    }

    public final int getMaxButtonCount() {
        return this.i;
    }

    public final void setButtons(List<? extends View> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "buttons");
        if (r7.size() <= this.i) goto L6;
        b.d("OBottomActionBarNormalHorizontal", "Cannot set more than " + this.i + " buttons");
        return;
    L6:
        this.f.removeAllViews();
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r0.hasNext() == false) goto L14;
        View r2 = (View) ZeusTransformUtils.preCheckCast(r0.next(), View.class, "com.obric.memorydata.plugin");
        boolean r4 = true;
        if (r7.size() == 1) goto L13;
        r4 = false;
    L13:
        a(r2, r4);
        goto L8
    }

    public final void setHeaderView(View r3) {
        Intrinsics.checkNotNullParameter(r3, "headerView");
        this.g.removeAllViews();
        this.g.addView(r3);
        ViewGroup.LayoutParams r4 = this.f.getLayoutParams();
        Objects.requireNonNull(r4, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r4, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        r5.topMargin = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 8);
    }

    public final void setMaxButtonCount(int r3) {
        if (this.f.getChildCount() <= r3) goto L6;
        b.e("OBottomActionBarNormalHorizontal", "Cannot set max button count to less than current button count");
        return;
    L6:
        if (r3 <= 0) goto L8;
        this.i = r3;
        return;
    L8:
        b.e("OBottomActionBarNormalHorizontal", "Max button count must be greater than 0");
    }
}
