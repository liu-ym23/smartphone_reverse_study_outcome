package com.obric.oui.infopanel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import cn.nubia.neopush.commons.Constant;
import com.lynx.tasm.behavior.m;
import com.lynx.tasm.utils.a;
import com.lynx.tasm.utils.d;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\nJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0010J\r\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u001a\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u001b\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/obric/oui/infopanel/OInfoPanelView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/widget/ImageView;", "getTopBannerView", "()Landroid/widget/ImageView;", "getTopImgView", "", "resId", "", "setInsetTopImg", "(I)V", "setUnInsetImg", "Landroid/view/ViewGroup;", "getCustomContainer", "()Landroid/view/ViewGroup;", "", Constant.TITLE, "setTitle", "(Ljava/lang/CharSequence;)V", "desc", "setDesc", "setScrollableDesc", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OInfoPanelView extends ConstraintLayout {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f13512o = 0;
    public final ViewGroup g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ViewGroup f13513h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ViewGroup f13514i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ImageView f13515j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final OTextView f13516k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final OTextView f13517l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final NestedScrollView f13518m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final m f13519n;

    @JvmOverloads
    public OInfoPanelView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, null);
    }

    public final ViewGroup getCustomContainer() {
        return this.f13514i;
    }

    public final ImageView getTopBannerView() {
        this.g.setPadding(0, 0, 0, 0);
        ViewGroup r5 = this.f13513h;
        if (r5.getLayoutParams() == null) goto L10;
        ViewGroup.LayoutParams r10 = r5.getLayoutParams();
        if (r10 == null) goto L8;
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) r10;
        r11.setMargins(r11.leftMargin, a.B(24, this), r11.rightMargin, r11.bottomMargin);
        r5.setLayoutParams(r11);
        goto L10
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L10:
        return this.f13515j;
    }

    public final ImageView getTopImgView() {
        int r5 = a.B(32, this);
        this.g.setPadding(0, r5, 0, 0);
        ViewGroup r10 = this.f13513h;
        if (r10.getLayoutParams() == null) goto L10;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if (r11 == null) goto L8;
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r11;
        r12.setMargins(r12.leftMargin, a.B(16, this), r12.rightMargin, r12.bottomMargin);
        r10.setLayoutParams(r12);
        goto L10
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L10:
        return this.f13515j;
    }

    public final void setDesc(CharSequence r5) {
        OTextView r10 = this.f13517l;
        if (r5 != null) goto L9;
        d.s(r10);
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if (r11 == null) goto L8;
        ((ViewGroup.MarginLayoutParams) r11).topMargin = 0;
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L9:
        r10.setText(r5);
        d.t(r10);
    }

    public final void setInsetTopImg(int r5) {
        getTopBannerView().setImageResource(r5);
    }

    public final void setScrollableDesc(CharSequence r5) {
        setDesc(r5);
        getViewTreeObserver().addOnGlobalLayoutListener(this.f13519n);
    }

    public final void setTitle(CharSequence r5) {
        Intrinsics.checkNotNullParameter(r5, Constant.TITLE);
        this.f13516k.setText(r5);
    }

    public final void setUnInsetImg(int r5) {
        getTopImgView().setImageResource(r5);
    }

    @JvmOverloads
    public OInfoPanelView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10);
        setMinimumHeight(a.B(290, this));
        View.inflate(r5, R$layout.o_info_panel_frame, this);
        ConstraintLayout.LayoutParams r11 = new ConstraintLayout.LayoutParams(-1, -2);
        setMinHeight(a.B(290, this));
        setLayoutParams(r11);
        this.g = (ViewGroup) findViewById(R$id.header_container);
        this.f13513h = (ViewGroup) findViewById(R$id.content_container);
        this.f13518m = (NestedScrollView) findViewById(R$id.desc_container);
        this.f13514i = (ViewGroup) findViewById(R$id.custom_container);
        this.f13515j = (ImageView) findViewById(R$id.iv_illustration);
        this.f13516k = (OTextView) findViewById(R$id.tv_title);
        OTextView r12 = (OTextView) findViewById(R$id.tv_desc);
        r12.setLineHeight(MathKt.roundToInt(((double) r12.getTextSize()) * 1.4d));
        this.f13517l = r12;
        this.f13519n = new m(this, r5);
    }
}
