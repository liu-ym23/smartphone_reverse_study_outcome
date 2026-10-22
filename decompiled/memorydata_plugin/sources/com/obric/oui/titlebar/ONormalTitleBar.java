package com.obric.oui.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.util.h;
import com.obric.oui.common.util.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class ONormalTitleBar extends OTitleBar implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ImageView f14754a;
    private ImageView c;
    private com.obric.oui.titlebar.a.a d;
    private View e;
    private TextView f;

    public ONormalTitleBar(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public ONormalTitleBar(Context r3, AttributeSet r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), 0);
    }

    public ONormalTitleBar(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r6, r7, r5);
        a(r6);
        if (r7 == null) goto L6;
        a(r6, r7);
        return;
    }

    private void a(Context r5) {
        inflate((Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.layout.o_view_normal_title_bar, "layout", "o_view_normal_title_bar"), this);
        this.f14754a = (ImageView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.back_btn, OaidModel.KEY_ID, "back_btn")), ImageView.class, "com.obric.memorydata.plugin");
        this.f14756b = (TextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.title, OaidModel.KEY_ID, "title")), TextView.class, "com.obric.memorydata.plugin");
        this.c = (ImageView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.right_btn, OaidModel.KEY_ID, "right_btn")), ImageView.class, "com.obric.memorydata.plugin");
        this.e = findViewById(ZeusTransformUtils.mapRes(R.id.line, OaidModel.KEY_ID, "line"));
        this.f = (TextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.text_left, OaidModel.KEY_ID, "text_left")), TextView.class, "com.obric.memorydata.plugin");
        this.f14754a.setOnClickListener(this);
        this.c.setOnClickListener(this);
        this.f.setOnClickListener(this);
        com.obric.oui.common.widget.a r6 = new com.obric.oui.common.widget.a(0.5f, 1.0f);
        this.f14754a.setOnTouchListener(r6);
        this.c.setOnTouchListener(r6);
        this.f.setOnTouchListener(r6);
    }

    private void a(Context r8, AttributeSet r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        TypedArray r11 = r10.obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r9, AttributeSet.class, "com.obric.memorydata.plugin"), R.styleable.ONormalTitleBar);
        String r0 = r11.getString(ZeusTransformUtils.mapRes(R.styleable.ONormalTitleBar_oui_centerText, "styleable", "ONormalTitleBar_oui_centerText"));
        float r2 = r11.getDimension(ZeusTransformUtils.mapRes(R.styleable.ONormalTitleBar_oui_centerTextSize, "styleable", "ONormalTitleBar_oui_centerTextSize"), h.a(17));
        int r3 = r11.getColor(ZeusTransformUtils.mapRes(R.styleable.ONormalTitleBar_oui_centerTextColor, "styleable", "ONormalTitleBar_oui_centerTextColor"), ContextCompat.getColor(r10, ZeusTransformUtils.mapRes(R.color.TextPrimary, TypedValues.Custom.S_COLOR, "TextPrimary")));
        this.f14756b.setText(r0);
        int r4 = 0;
        this.f14756b.setTextSize(0, r2);
        this.f14756b.setTextColor(r3);
        Drawable r1 = r11.getDrawable(ZeusTransformUtils.mapRes(R.styleable.ONormalTitleBar_oui_rightDrawable, "styleable", "ONormalTitleBar_oui_rightDrawable"));
        if (r11.hasValue(ZeusTransformUtils.mapRes(R.styleable.ONormalTitleBar_oui_rightDrawableTint, "styleable", "ONormalTitleBar_oui_rightDrawableTint")) == false) goto L6;
        if (r1 == null) goto L6;
        int r5 = r11.getColor(ZeusTransformUtils.mapRes(R.styleable.ONormalTitleBar_oui_rightDrawableTint, "styleable", "ONormalTitleBar_oui_rightDrawableTint"), 0);
        r1 = r1.mutate();
        DrawableCompat.setTint(r1, r5);
    L6:
        if (r1 == null) goto L8;
        this.c.setImageDrawable(r1);
    L8:
        boolean r6 = r11.getBoolean(ZeusTransformUtils.mapRes(R.styleable.ONormalTitleBar_oui_dividerVisible, "styleable", "ONormalTitleBar_oui_dividerVisible"), true);
        View r7 = this.e;
        if (r6 == true) goto L12;
        r4 = 8;
    L12:
        r7.setVisibility(r4);
        this.e.setBackgroundColor(r11.getColor(ZeusTransformUtils.mapRes(R.styleable.ONormalTitleBar_oui_dividerColor, "styleable", "ONormalTitleBar_oui_dividerColor"), ContextCompat.getColor(r10, ZeusTransformUtils.mapRes(R.color.LinePrimary, TypedValues.Custom.S_COLOR, "LinePrimary"))));
        r11.recycle();
    }

    public ImageView getEndBtn() {
        return this.c;
    }

    public ImageView getStartBtn() {
        return this.f14754a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getStartBtn() == null) goto L6;
        o.a(getStartBtn(), h.a(44), h.a(44), false);
    L6:
        if (getEndBtn() == null) goto L9;
        o.a(getEndBtn(), h.a(44), h.a(44), false);
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r5) {
        if (this.d != null) goto L5;
        return;
    L5:
        if (r5.getId() != ZeusTransformUtils.mapRes(R.id.back_btn, OaidModel.KEY_ID, "back_btn")) goto L7;
    L12:
        this.d.a(r5);
        return;
    L7:
        if (r5.getId() == ZeusTransformUtils.mapRes(R.id.text_left, OaidModel.KEY_ID, "text_left")) goto L12;
        if (r5.getId() != ZeusTransformUtils.mapRes(R.id.right_btn, OaidModel.KEY_ID, "right_btn")) goto L15;
        this.d.b(r5);
        return;
    }

    public void setCenterText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.f14756b.setText(r4);
    }

    public void setDividerHeight(int r2) {
        ViewGroup.LayoutParams r0 = this.e.getLayoutParams();
        r0.height = r2;
        this.e.setLayoutParams(r0);
    }

    @Override // com.obric.oui.titlebar.OTitleBar
    public void setDividerLineBackground(int r1) {
        this.e.setBackgroundColor(r1);
    }

    public void setEndBtnIcon(int r1) {
        this.c.setImageResource(r1);
    }

    public void setOnTitleBarClickListener(com.obric.oui.titlebar.a.a r3) {
        this.d = (com.obric.oui.titlebar.a.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.titlebar.a.a.class, "com.obric.memorydata.plugin");
    }

    public void setStartBtnIcon(int r1) {
        this.f14754a.setImageResource(r1);
    }

    public void setStartText(String r3) {
        this.f14754a.setVisibility(8);
        this.f.setVisibility(0);
        this.f.setText(r3);
    }

    public void setStartTextSize(float r2) {
        this.f.setTextSize(0, r2);
    }
}
