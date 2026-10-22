package com.obric.oui.header;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.oui.image.OImageAppIcon;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public class HeaderInfoView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f13887a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private OImageAppIcon f13888b;
    private OTextView c;
    private OTextView d;
    private FrameLayout e;

    static {
        f13887a = new int[]{R.attr.padding, R.attr.paddingTop, R.attr.paddingBottom};
    }

    public HeaderInfoView(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public HeaderInfoView(Context r3, AttributeSet r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), 0);
    }

    public HeaderInfoView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r6, r7, r5);
        a(r6, r7);
    }

    private int a(int r2) {
        return (int) TypedValue.applyDimension(1, r2, ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics());
    }

    private void a() {
        this.f13888b = (OImageAppIcon) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.header_info_icon, OaidModel.KEY_ID, "header_info_icon")), OImageAppIcon.class, "com.obric.memorydata.plugin");
        this.c = (OTextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.header_info_title, OaidModel.KEY_ID, "header_info_title")), OTextView.class, "com.obric.memorydata.plugin");
        this.d = (OTextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.header_info_subtitle, OaidModel.KEY_ID, "header_info_subtitle")), OTextView.class, "com.obric.memorydata.plugin");
        this.e = (FrameLayout) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.header_info_custom_content_container, OaidModel.KEY_ID, "header_info_custom_content_container")), FrameLayout.class, "com.obric.memorydata.plugin");
    }

    private void a(Context r5, AttributeSet r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.memorydata.plugin");
        ZeusTransformUtils.inflate(LayoutInflater.from(r7), ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.layout.header_info_view_layout, "layout", "header_info_view_layout"), this, true, "com.obric.memorydata.plugin");
        setGravity(1);
        setOrientation(1);
        a();
        a(r8);
        b(r8);
    }

    private void a(AttributeSet r5) {
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin");
        TypedArray r7 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes(r6, f13887a);
        boolean r0 = r7.hasValue(0);     // Catch: Throwable -> L19
        if (r0 == false) goto L6;
    L9:
        int r1 = getPaddingTop();     // Catch: Throwable -> L19
    L10:
        if (r0 == false) goto L12;
    L15:
        int r2 = getPaddingBottom();     // Catch: Throwable -> L19
    L16:
        setPadding(getPaddingLeft(), r1, getPaddingRight(), r2);     // Catch: Throwable -> L19
        r7.recycle();
        return;
    L12:
        if (r7.hasValue(2) == true) goto L15;
        r2 = a(24);     // Catch: Throwable -> L19
        goto L16
    L6:
        if (r7.hasValue(1) == true) goto L9;
        r1 = a(96);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        r7.recycle();
        throw th;
    }

    private void b(AttributeSet r10) {
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        TypedArray r12 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes(r11, com.obric.memorydata.plugin.R.styleable.HeaderInfoView, 0, 0);
    L20:
        th = move-exception;
        r12.recycle();
        throw th;
    L4:
        if (r12.hasValue(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.HeaderInfoView_oui_headerInfo_icon, "styleable", "HeaderInfoView_oui_headerInfo_icon")) == false) goto L7;
        setIcon(r12.getDrawable(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.HeaderInfoView_oui_headerInfo_icon, "styleable", "HeaderInfoView_oui_headerInfo_icon")));     // Catch: Throwable -> L20
    L7:
        if (r12.hasValue(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.HeaderInfoView_oui_headerInfo_title, "styleable", "HeaderInfoView_oui_headerInfo_title")) == false) goto L10;
        setTitle(r12.getString(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.HeaderInfoView_oui_headerInfo_title, "styleable", "HeaderInfoView_oui_headerInfo_title")));     // Catch: Throwable -> L20
    L10:
        if (r12.hasValue(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.HeaderInfoView_oui_headerInfo_titleColor, "styleable", "HeaderInfoView_oui_headerInfo_titleColor")) == false) goto L13;
        setTitleColor(r12.getColor(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.HeaderInfoView_oui_headerInfo_titleColor, "styleable", "HeaderInfoView_oui_headerInfo_titleColor"), this.c.getCurrentTextColor()));     // Catch: Throwable -> L20
    L13:
        if (r12.hasValue(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.HeaderInfoView_oui_headerInfo_subtitle, "styleable", "HeaderInfoView_oui_headerInfo_subtitle")) == false) goto L16;
        setSubtitle(r12.getString(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.HeaderInfoView_oui_headerInfo_subtitle, "styleable", "HeaderInfoView_oui_headerInfo_subtitle")));     // Catch: Throwable -> L20
    L16:
        if (r12.hasValue(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.HeaderInfoView_oui_headerInfo_subtitleColor, "styleable", "HeaderInfoView_oui_headerInfo_subtitleColor")) == false) goto L18;
        setSubtitleColor(r12.getColor(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.HeaderInfoView_oui_headerInfo_subtitleColor, "styleable", "HeaderInfoView_oui_headerInfo_subtitleColor"), this.d.getCurrentTextColor()));     // Catch: Throwable -> L20
    L18:
        r12.recycle();
    }

    public FrameLayout getCustomContentContainer() {
        return this.e;
    }

    public OImageAppIcon getIconView() {
        return this.f13888b;
    }

    public OTextView getSubtitleView() {
        return this.d;
    }

    public OTextView getTitleView() {
        return this.c;
    }

    public void setIcon(int r2) {
        this.f13888b.setImageResource(r2);
        OImageAppIcon r1 = this.f13888b;
        if (r2 != 0) goto L5;
        int r3 = 8;
    L6:
        r1.setVisibility(r3);
        return;
    L5:
        r3 = 0;
        goto L6
    }

    public void setIcon(Drawable r2) {
        this.f13888b.setImageDrawable(r2);
        OImageAppIcon r1 = this.f13888b;
        if (r2 != null) goto L5;
        int r3 = 8;
    L6:
        r1.setVisibility(r3);
        return;
    L5:
        r3 = 0;
        goto L6
    }

    public void setImagePackageName(String r3) {
        if (r3 != null) goto L4;
    L8:
        setIcon((Drawable) ZeusTransformUtils.preCheckCast(null, Drawable.class, "com.obric.memorydata.plugin"));
        return;
    L4:
        if (r3.trim().isEmpty() == true) goto L8;
        this.f13888b.setImagePackageName(r3);
        this.f13888b.setVisibility(0);
    }

    public void setSubtitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.d.setText(r4);
        OTextView r2 = this.d;
        if (TextUtils.isEmpty(r4) == false) goto L5;
        int r5 = 8;
    L6:
        r2.setVisibility(r5);
        return;
    L5:
        r5 = 0;
        goto L6
    }

    public void setSubtitleColor(int r1) {
        this.d.setTextColor(r1);
    }

    public void setTitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.c.setText(r4);
        OTextView r2 = this.c;
        if (TextUtils.isEmpty(r4) == false) goto L5;
        int r5 = 8;
    L6:
        r2.setVisibility(r5);
        return;
    L5:
        r5 = 0;
        goto L6
    }

    public void setTitleColor(int r1) {
        this.c.setTextColor(r1);
    }
}
