package com.obric.oui.paneltitlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import cn.nubia.neopush.commons.Constant;
import com.lynx.tasm.utils.a;
import com.lynx.tasm.utils.d;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0013\u0010\u0011J\u0017\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/obric/oui/paneltitlebar/OPanelTitleBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "type", "", "setType", "(I)V", "", Constant.TITLE, "setTitle", "(Ljava/lang/String;)V", "info", "setInfo", "Landroid/view/View;", "view", "setActionView", "(Landroid/view/View;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OPanelTitleBar extends ConstraintLayout {
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f14028h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f14029i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f14030j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f14031k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f14032l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public OTextView f14033m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public OTextView f14034n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ImageView f14035o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ImageView f14036p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public FrameLayout f14037q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View f14038r;

    @JvmOverloads
    public OPanelTitleBar(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public final void e(int r5) {
        if (r5 == 0) goto L7;
        if (r5 == 1) goto L6;
        setPadding(a.B(12, this), a.B(12, this), a.B(12, this), a.B(12, this));
        int r10 = R$layout.o_panel_title_bar_regular;
    L8:
        removeAllViews();
        View r11 = LayoutInflater.from(getContext()).inflate(r10, this, true);
        this.f14033m = (OTextView) r11.findViewById(R$id.panel_title);
        this.f14034n = (OTextView) r11.findViewById(R$id.panel_info);
        this.f14035o = (ImageView) r11.findViewById(R$id.panel_expand_icon);
        this.f14036p = (ImageView) r11.findViewById(R$id.panel_info_icon);
        this.f14037q = (FrameLayout) r11.findViewById(R$id.panel_action_container);
        return;
    L6:
        setPadding(a.B(12, this), a.B(12, this), a.B(12, this), a.B(12, this));
        r10 = R$layout.o_panel_title_bar_regular;
        goto L8
    L7:
        setPadding(a.B(12, this), a.B(14, this), a.B(12, this), a.B(8, this));
        r10 = R$layout.o_panel_title_bar_display;
        goto L8
    }

    public final void setActionView(View r5) {
        this.f14038r = r5;
        FrameLayout r10 = this.f14037q;
        if (r10 == null) goto L6;
        r10.removeAllViews();
    L6:
        if (r5 != null) goto L8;
        return;
    L8:
        FrameLayout r11 = this.f14037q;
        if (r11 == null) goto L13;
        FrameLayout.LayoutParams r12 = new FrameLayout.LayoutParams(-2, -2);
        r12.gravity = 21;
        Unit r13 = Unit.INSTANCE;
        r11.addView(r5, r12);
        return;
    }

    public final void setInfo(String r5) {
        this.f14032l = r5;
        OTextView r10 = this.f14034n;
        if (r10 == null) goto L7;
        r10.setText(r5);
        return;
    }

    public final void setTitle(String r5) {
        this.f14031k = r5;
        OTextView r10 = this.f14033m;
        if (r10 == null) goto L7;
        r10.setText(r5);
        return;
    }

    public final void setType(int r5) {
        if (r5 == 0) goto L6;
        if (r5 == 1) goto L6;
        return;
    L6:
        if (r5 == this.g) goto L25;
        this.g = r5;
        e(r5);
        setTitle(this.f14031k);
        setInfo(this.f14032l);
        boolean r10 = this.f14028h;
        this.f14028h = r10;
        OTextView r11 = this.f14034n;
        if (r11 == null) goto L12;
        d.x(r11, r10);
    L12:
        boolean r12 = this.f14030j;
        this.f14030j = r12;
        ImageView r13 = this.f14035o;
        if (r13 == null) goto L16;
        d.x(r13, r12);
    L16:
        boolean r14 = this.f14029i;
        this.f14029i = r14;
        ImageView r15 = this.f14036p;
        if (r15 == null) goto L20;
        d.x(r15, r14);
    L20:
        View r16 = this.f14038r;
        if (r16 == null) goto L26;
        setActionView(r16);
        return;
    L26:
        return;
    }

    @JvmOverloads
    public OPanelTitleBar(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OPanelTitleBar(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public OPanelTitleBar(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        boolean r12 = true;
        this.g = 1;
        TypedArray r13 = r5.getTheme().obtainStyledAttributes(r10, R$styleable.OPanelTitleBar, r11, 0);
        this.g = r13.getInt(R$styleable.OPanelTitleBar_oui_panel_type, 1);
        this.f14028h = r13.getBoolean(R$styleable.OPanelTitleBar_oui_panel_show_info, true);
        this.f14029i = r13.getBoolean(R$styleable.OPanelTitleBar_oui_panel_show_info_icon, false);
        this.f14030j = r13.getBoolean(R$styleable.OPanelTitleBar_oui_panel_show_expand_icon, false);
        this.f14031k = r13.getString(R$styleable.OPanelTitleBar_oui_panel_title);
        this.f14032l = r13.getString(R$styleable.OPanelTitleBar_oui_panel_info);
        r13.recycle();
        e(this.g);
        setTitle(this.f14031k);
        setInfo(this.f14032l);
        if (this.f14028h == false) goto L8;
        String r14 = this.f14032l;
        if (r14 == null) goto L8;
        if (r14.length() == 0) goto L8;
    L9:
        this.f14028h = r12;
        OTextView r15 = this.f14034n;
        if (r15 == null) goto L13;
        d.x(r15, r12);
    L13:
        boolean r16 = this.f14030j;
        this.f14030j = r16;
        ImageView r17 = this.f14035o;
        if (r17 == null) goto L17;
        d.x(r17, r16);
    L17:
        boolean r18 = this.f14029i;
        this.f14029i = r18;
        ImageView r19 = this.f14036p;
        if (r19 == null) goto L22;
        d.x(r19, r18);
        return;
    L22:
        return;
    L8:
        r12 = false;
        goto L9
    }
}
