package com.obric.oui.paneltitlebar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.oui.common.util.k;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import u8.f;
import u8.h;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 42\u00020\u0001:\u00015B'\b\u0007\u0012\u0006\u0010.\u001a\u00020-\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010/\u0012\b\b\u0002\u00101\u001a\u00020\u0002¢\u0006\u0004\b2\u00103J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0018\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002H\u0014J0\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0014R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010#\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010\u001fR\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010'R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010(R\u0018\u0010)\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010\u000e\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010(R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010,R\u0016\u0010\u0010\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010(R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010,¨\u00066"}, d2 = {"Lcom/obric/oui/paneltitlebar/OPanelTitleBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", WsConstants.KEY_CONNECTION_TYPE, "", "inflate", "setType", "", "title", "setTitle", "info", "setInfo", "", "show", "showInfoIcon", "showInfo", "showExpandIcon", "Landroid/view/View;", "view", "setActionView", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "changed", "left", "top", "right", "bottom", "onLayout", "Landroid/widget/ImageView;", "vInfoIcon", "Landroid/widget/ImageView;", "Landroid/widget/FrameLayout;", "vActionContainer", "Landroid/widget/FrameLayout;", "vExpandIcon", "Lcom/obric/oui/text/OTextView;", "vTitleText", "Lcom/obric/oui/text/OTextView;", "I", "Z", "vInfoText", "vActionView", "Landroid/view/View;", "Ljava/lang/String;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "a", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
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

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    @JvmOverloads
    public OPanelTitleBar(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public OPanelTitleBar(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public OPanelTitleBar(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        boolean r13 = true;
        this.type = 1;
        TypedArray r14 = r10.getTheme().obtainStyledAttributes(r11, l.OPanelTitleBar, r12, 0);
        this.type = r14.getInt(l.OPanelTitleBar_oui_panel_type, 1);
        this.showInfo = r14.getBoolean(l.OPanelTitleBar_oui_panel_show_info, true);
        this.showInfoIcon = r14.getBoolean(l.OPanelTitleBar_oui_panel_show_info_icon, false);
        this.showExpandIcon = r14.getBoolean(l.OPanelTitleBar_oui_panel_show_expand_icon, false);
        this.title = r14.getString(l.OPanelTitleBar_oui_panel_title);
        this.info = r14.getString(l.OPanelTitleBar_oui_panel_info);
        r14.recycle();
        inflate(this.type);
        setTitle(this.title);
        setInfo(this.info);
        if (this.showInfo == false) goto L13;
        String r15 = this.info;
        if (r15 != null) goto L7;
    L10:
        boolean r16 = true;
    L11:
        if (r16 == true) goto L13;
    L14:
        showInfo(r13);
        showExpandIcon(this.showExpandIcon);
        showInfoIcon(this.showInfoIcon);
        return;
    L7:
        if (r15.length() == 0) goto L10;
        r16 = false;
    L13:
        r13 = false;
        goto L14
    }

    public /* synthetic */ OPanelTitleBar(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    private final void inflate(int r10) {
        if (r10 == 0) goto L5;
        float r11 = 12;
        Resources r12 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r12, "Resources.getSystem()");
        int r13 = MathKt.roundToInt(TypedValue.applyDimension(1, r11, r12.getDisplayMetrics()));
        Resources r14 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r14, "Resources.getSystem()");
        int r15 = MathKt.roundToInt(TypedValue.applyDimension(1, r11, r14.getDisplayMetrics()));
        Resources r16 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r16, "Resources.getSystem()");
        int r17 = MathKt.roundToInt(TypedValue.applyDimension(1, r11, r16.getDisplayMetrics()));
        Resources r18 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r18, "Resources.getSystem()");
        setPadding(r13, r15, r17, MathKt.roundToInt(TypedValue.applyDimension(1, r11, r18.getDisplayMetrics())));
        int r19 = h.o_panel_title_bar_regular;
    L6:
        removeAllViews();
        View r20 = LayoutInflater.from(getContext()).inflate(r19, this, true);
        this.vTitleText = (OTextView) r20.findViewById(f.panel_title);
        this.vInfoText = (OTextView) r20.findViewById(f.panel_info);
        this.vExpandIcon = (ImageView) r20.findViewById(f.panel_expand_icon);
        this.vInfoIcon = (ImageView) r20.findViewById(f.panel_info_icon);
        this.vActionContainer = (FrameLayout) r20.findViewById(f.panel_action_container);
        return;
    L5:
        float r21 = 12;
        Resources r22 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r22, "Resources.getSystem()");
        int r23 = MathKt.roundToInt(TypedValue.applyDimension(1, r21, r22.getDisplayMetrics()));
        Resources r24 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r24, "Resources.getSystem()");
        int r25 = MathKt.roundToInt(TypedValue.applyDimension(1, 14, r24.getDisplayMetrics()));
        Resources r26 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r26, "Resources.getSystem()");
        int r27 = MathKt.roundToInt(TypedValue.applyDimension(1, r21, r26.getDisplayMetrics()));
        Resources r28 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r28, "Resources.getSystem()");
        setPadding(r23, r25, r27, MathKt.roundToInt(TypedValue.applyDimension(1, 8, r28.getDisplayMetrics())));
        r19 = h.o_panel_title_bar_display;
        goto L6
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
    }

    public final void setActionView(View r10) {
        this.vActionView = r10;
        FrameLayout r11 = this.vActionContainer;
        if (r11 == null) goto L5;
        r11.removeAllViews();
    L5:
        if (r10 != null) goto L7;
        return;
    L7:
        FrameLayout r12 = this.vActionContainer;
        if (r12 == null) goto L11;
        FrameLayout.LayoutParams r13 = new FrameLayout.LayoutParams(-2, -2);
        r13.gravity = 21;
        Unit r14 = Unit.INSTANCE;
        r12.addView(r10, r13);
        return;
    }

    public final void setInfo(String r10) {
        this.info = r10;
        OTextView r11 = this.vInfoText;
        if (r11 == null) goto L6;
        r11.setText(r10);
        return;
    }

    public final void setTitle(String r10) {
        this.title = r10;
        OTextView r11 = this.vTitleText;
        if (r11 == null) goto L6;
        r11.setText(r10);
        return;
    }

    public final void setType(int r10) {
        if (r10 == 0) goto L6;
        if (r10 == 1) goto L6;
        return;
    L6:
        if (r10 == this.type) goto L12;
        this.type = r10;
        inflate(r10);
        setTitle(this.title);
        setInfo(this.info);
        showInfo(this.showInfo);
        showExpandIcon(this.showExpandIcon);
        showInfoIcon(this.showInfoIcon);
        View r11 = this.vActionView;
        if (r11 == null) goto L13;
        setActionView(r11);
        return;
    L13:
        return;
    }

    public final void showExpandIcon(boolean r10) {
        this.showExpandIcon = r10;
        ImageView r11 = this.vExpandIcon;
        if (r11 == null) goto L6;
        k.k(r11, r10);
        return;
    }

    public final void showInfo(boolean r10) {
        this.showInfo = r10;
        OTextView r11 = this.vInfoText;
        if (r11 == null) goto L6;
        k.k(r11, r10);
        return;
    }

    public final void showInfoIcon(boolean r10) {
        this.showInfoIcon = r10;
        ImageView r11 = this.vInfoIcon;
        if (r11 == null) goto L6;
        k.k(r11, r10);
        return;
    }
}
