package com.obric.oui.paneltitlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.util.h;
import com.obric.oui.common.util.o;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\u0018\u0000 ,2\u00020\u0001:\u0001,B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J0\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007H\u0014J\u0018\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0014J\u0010\u0010&\u001a\u00020\u001c2\b\u0010'\u001a\u0004\u0018\u00010\u0014J\u0010\u0010(\u001a\u00020\u001c2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010)\u001a\u00020\u001c2\b\u0010\u000f\u001a\u0004\u0018\u00010\nJ\u000e\u0010*\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\fR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/obric/oui/paneltitlebar/OPanelTitleBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "info", "", "showExpandIcon", "", "showInfo", "showInfoIcon", "title", "type", "vActionContainer", "Landroid/widget/FrameLayout;", "vActionView", "Landroid/view/View;", "vExpandIcon", "Landroid/widget/ImageView;", "vInfoIcon", "vInfoText", "Lcom/obric/oui/text/OTextView;", "vTitleText", "inflate", "", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setActionView", "view", "setInfo", "setTitle", "setType", "show", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OPanelTitleBar extends ConstraintLayout {
    public static final a Companion = null;
    public static final int DISPLAY = 0;
    public static final int REGULAR = 1;
    private String info;
    private boolean showExpandIcon;
    private boolean showInfo;
    private boolean showInfoIcon;
    private String title;
    private int type;
    private FrameLayout vActionContainer;
    private View vActionView;
    private ImageView vExpandIcon;
    private ImageView vInfoIcon;
    private OTextView vInfoText;
    private OTextView vTitleText;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/paneltitlebar/OPanelTitleBar$Companion;", "", "()V", "DISPLAY", "", "REGULAR", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public OPanelTitleBar(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OPanelTitleBar(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OPanelTitleBar(Context r5, AttributeSet r6, int r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, r7);
        boolean r0 = true;
        this.type = 1;
        TypedArray r10 = r8.getTheme().obtainStyledAttributes(r9, R.styleable.OPanelTitleBar, r7, 0);
        this.type = r10.getInt(ZeusTransformUtils.mapRes(R.styleable.OPanelTitleBar_oui_panel_type, "styleable", "OPanelTitleBar_oui_panel_type"), 1);
        this.showInfo = r10.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OPanelTitleBar_oui_panel_show_info, "styleable", "OPanelTitleBar_oui_panel_show_info"), true);
        this.showInfoIcon = r10.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OPanelTitleBar_oui_panel_show_info_icon, "styleable", "OPanelTitleBar_oui_panel_show_info_icon"), false);
        this.showExpandIcon = r10.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OPanelTitleBar_oui_panel_show_expand_icon, "styleable", "OPanelTitleBar_oui_panel_show_expand_icon"), false);
        this.title = r10.getString(ZeusTransformUtils.mapRes(R.styleable.OPanelTitleBar_oui_panel_title, "styleable", "OPanelTitleBar_oui_panel_title"));
        this.info = r10.getString(ZeusTransformUtils.mapRes(R.styleable.OPanelTitleBar_oui_panel_info, "styleable", "OPanelTitleBar_oui_panel_info"));
        r10.recycle();
        inflate(this.type);
        setTitle(this.title);
        setInfo(this.info);
        if (this.showInfo == false) goto L13;
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(this.info, CharSequence.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L7;
    L10:
        boolean r12 = true;
    L11:
        if (r12 == true) goto L13;
    L14:
        showInfo(r0);
        showExpandIcon(this.showExpandIcon);
        showInfoIcon(this.showInfoIcon);
        return;
    L7:
        if (r11.length() == 0) goto L10;
        r12 = false;
    L13:
        r0 = false;
        goto L14
    }

    public /* synthetic */ OPanelTitleBar(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
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

    private final void inflate(int r9) {
        if (r9 == 0) goto L5;
        setPadding(h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12), h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12), h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12), h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12));
        int r10 = ZeusTransformUtils.mapRes(R.layout.o_panel_title_bar_regular, "layout", "o_panel_title_bar_regular");
    L6:
        removeAllViews();
        View r11 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), r10, (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"), true, "com.obric.memorydata.plugin");
        this.vTitleText = (OTextView) ZeusTransformUtils.preCheckCast(r11.findViewById(ZeusTransformUtils.mapRes(R.id.panel_title, OaidModel.KEY_ID, "panel_title")), OTextView.class, "com.obric.memorydata.plugin");
        this.vInfoText = (OTextView) ZeusTransformUtils.preCheckCast(r11.findViewById(ZeusTransformUtils.mapRes(R.id.panel_info, OaidModel.KEY_ID, "panel_info")), OTextView.class, "com.obric.memorydata.plugin");
        this.vExpandIcon = (ImageView) ZeusTransformUtils.preCheckCast(r11.findViewById(ZeusTransformUtils.mapRes(R.id.panel_expand_icon, OaidModel.KEY_ID, "panel_expand_icon")), ImageView.class, "com.obric.memorydata.plugin");
        this.vInfoIcon = (ImageView) ZeusTransformUtils.preCheckCast(r11.findViewById(ZeusTransformUtils.mapRes(R.id.panel_info_icon, OaidModel.KEY_ID, "panel_info_icon")), ImageView.class, "com.obric.memorydata.plugin");
        this.vActionContainer = (FrameLayout) ZeusTransformUtils.preCheckCast(r11.findViewById(ZeusTransformUtils.mapRes(R.id.panel_action_container, OaidModel.KEY_ID, "panel_action_container")), FrameLayout.class, "com.obric.memorydata.plugin");
        return;
    L5:
        setPadding(h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12), h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 14), h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12), h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 8));
        r10 = ZeusTransformUtils.mapRes(R.layout.o_panel_title_bar_display, "layout", "o_panel_title_bar_display");
        goto L6
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    public final void setActionView(View r4) {
        this.vActionView = r4;
        FrameLayout r0 = this.vActionContainer;
        if (r0 == null) goto L6;
        r0.removeAllViews();
    L6:
        if (r4 != null) goto L8;
        return;
    L8:
        FrameLayout r3 = this.vActionContainer;
        if (r3 == null) goto L13;
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(-2, -2);
        r1.gravity = 21;
        Unit r2 = Unit.INSTANCE;
        r3.addView(r4, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        return;
    }

    public final void setInfo(String r3) {
        this.info = r3;
        OTextView r2 = this.vInfoText;
        if (r2 == null) goto L7;
        r2.setText((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"));
        return;
    }

    public final void setTitle(String r3) {
        this.title = r3;
        OTextView r2 = this.vTitleText;
        if (r2 == null) goto L7;
        r2.setText((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"));
        return;
    }

    public final void setType(int r2) {
        if (r2 == 0) goto L6;
        if (r2 == 1) goto L6;
        return;
    L6:
        if (r2 == this.type) goto L13;
        this.type = r2;
        inflate(r2);
        setTitle(this.title);
        setInfo(this.info);
        showInfo(this.showInfo);
        showExpandIcon(this.showExpandIcon);
        showInfoIcon(this.showInfoIcon);
        View r3 = this.vActionView;
        if (r3 == null) goto L14;
        setActionView(r3);
        return;
    L14:
        return;
    }

    public final void showExpandIcon(boolean r3) {
        this.showExpandIcon = r3;
        ImageView r2 = this.vExpandIcon;
        if (r2 == null) goto L7;
        o.a((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin"), r3);
        return;
    }

    public final void showInfo(boolean r3) {
        this.showInfo = r3;
        OTextView r2 = this.vInfoText;
        if (r2 == null) goto L7;
        o.a((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin"), r3);
        return;
    }

    public final void showInfoIcon(boolean r3) {
        this.showInfoIcon = r3;
        ImageView r2 = this.vInfoIcon;
        if (r2 == null) goto L7;
        o.a((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin"), r3);
        return;
    }
}
