package com.obric.oui.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.util.h;
import com.obric.oui.common.util.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class OTextTitleBar extends OTitleBar implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f14755a;
    private TextView c;
    private com.obric.oui.titlebar.a.a d;
    private ImageView e;
    private boolean f;
    private boolean g;
    private View h;
    private int i;

    public OTextTitleBar(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public OTextTitleBar(Context r3, AttributeSet r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), 0);
    }

    public OTextTitleBar(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r6, r7, r5);
        this.i = 0;
        a(r6);
        if (r7 == null) goto L6;
        a(r6, r7);
        return;
    }

    private void a(Context r5) {
        inflate((Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.layout.o_view_text_title_bar, "layout", "o_view_text_title_bar"), this);
        this.f14755a = (TextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.text_left, OaidModel.KEY_ID, "text_left")), TextView.class, "com.obric.memorydata.plugin");
        this.f14756b = (TextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.title, OaidModel.KEY_ID, "title")), TextView.class, "com.obric.memorydata.plugin");
        this.c = (TextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.text_right, OaidModel.KEY_ID, "text_right")), TextView.class, "com.obric.memorydata.plugin");
        this.e = (ImageView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.back_btn, OaidModel.KEY_ID, "back_btn")), ImageView.class, "com.obric.memorydata.plugin");
        this.h = findViewById(ZeusTransformUtils.mapRes(R.id.line, OaidModel.KEY_ID, "line"));
        this.e.setOnClickListener(this);
        this.f14755a.setOnClickListener(this);
        this.c.setOnClickListener(this);
        com.obric.oui.common.widget.a r6 = new com.obric.oui.common.widget.a(0.5f, 1.0f);
        this.e.setOnTouchListener(r6);
        this.f14755a.setOnTouchListener(r6);
        this.c.setOnTouchListener(r6);
    }

    private void a(Context r12, AttributeSet r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin");
        TypedArray r15 = r14.obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r13, AttributeSet.class, "com.obric.memorydata.plugin"), R.styleable.OTextTitleBar);
        String r0 = r15.getString(ZeusTransformUtils.mapRes(R.styleable.OTextTitleBar_oui_centerText, "styleable", "OTextTitleBar_oui_centerText"));
        float r2 = r15.getDimension(ZeusTransformUtils.mapRes(R.styleable.OTextTitleBar_oui_centerTextSize, "styleable", "OTextTitleBar_oui_centerTextSize"), h.a(17));
        int r3 = r15.getColor(ZeusTransformUtils.mapRes(R.styleable.OTextTitleBar_oui_centerTextColor, "styleable", "OTextTitleBar_oui_centerTextColor"), ContextCompat.getColor(r14, ZeusTransformUtils.mapRes(R.color.TextPrimary, TypedValues.Custom.S_COLOR, "TextPrimary")));
        this.f14756b.setText(r0);
        this.f14756b.setTextSize(0, r2);
        this.f14756b.setTextColor(r3);
        this.f = r15.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OTextTitleBar_oui_useBackIcon, "styleable", "OTextTitleBar_oui_useBackIcon"), false);
        boolean r1 = r15.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OTextTitleBar_oui_useCloseIcon, "styleable", "OTextTitleBar_oui_useCloseIcon"), false);
        this.g = r1;
        if (this.f == false) goto L6;
        this.e.setVisibility(0);
        this.f14755a.setVisibility(8);
        ImageView r4 = this.e;
        int r5 = R.string.oui_iv_back_desc;
        String r8 = "oui_iv_back_desc";
    L5:
        r4.setContentDescription(r14.getString(ZeusTransformUtils.mapRes(r5, TypedValues.Custom.S_STRING, r8)));
    L9:
        int r6 = r15.getInt(ZeusTransformUtils.mapRes(R.styleable.OTextTitleBar_oui_rightButtonType, "styleable", "OTextTitleBar_oui_rightButtonType"), 1);
        this.i = r6;
        if (r6 != 1) goto L12;
        TextView r7 = this.c;
        int r9 = ZeusTransformUtils.mapRes(R.color.Primary, TypedValues.Custom.S_COLOR, "Primary");
    L13:
        r7.setTextColor(ContextCompat.getColor(r14, r9));
        String r10 = r15.getString(ZeusTransformUtils.mapRes(R.styleable.OTextTitleBar_oui_rightButtonText, "styleable", "OTextTitleBar_oui_rightButtonText"));
        float r11 = r15.getDimension(ZeusTransformUtils.mapRes(R.styleable.OTextTitleBar_oui_rightTextSize, "styleable", "OTextTitleBar_oui_rightTextSize"), h.a(15));
        int r16 = r15.getColor(ZeusTransformUtils.mapRes(R.styleable.OTextTitleBar_oui_rightTextColor, "styleable", "OTextTitleBar_oui_rightTextColor"), ContextCompat.getColor(r14, ZeusTransformUtils.mapRes(R.color.TextPrimary, TypedValues.Custom.S_COLOR, "TextPrimary")));
        int r17 = r15.getInt(ZeusTransformUtils.mapRes(R.styleable.OTextTitleBar_oui_rightTextVisible, "styleable", "OTextTitleBar_oui_rightTextVisible"), 0);
        this.c.setText(r10);
        this.c.setTextSize(0, r11);
        if (r15.hasValue(ZeusTransformUtils.mapRes(R.styleable.OTextTitleBar_oui_rightTextColor, "styleable", "OTextTitleBar_oui_rightTextColor")) == false) goto L16;
        this.c.setTextColor(r16);
    L16:
        this.c.setVisibility(r17);
        this.h.setVisibility(r15.getInt(ZeusTransformUtils.mapRes(R.styleable.OTextTitleBar_oui_dividerVisible, "styleable", "OTextTitleBar_oui_dividerVisible"), 0));
        this.h.setBackgroundColor(r15.getColor(ZeusTransformUtils.mapRes(R.styleable.OTextTitleBar_oui_dividerColor, "styleable", "OTextTitleBar_oui_dividerColor"), ContextCompat.getColor(r14, ZeusTransformUtils.mapRes(R.color.LinePrimary, TypedValues.Custom.S_COLOR, "LinePrimary"))));
        r15.recycle();
        return;
    L12:
        r7 = this.c;
        r9 = ZeusTransformUtils.mapRes(R.color.TextPrimary, TypedValues.Custom.S_COLOR, "TextPrimary");
        goto L13
    L6:
        if (r1 == false) goto L8;
        this.e.setVisibility(0);
        this.e.setImageResource(ZeusTransformUtils.mapRes(R.drawable.o_ic_titlebar_close, "drawable", "o_ic_titlebar_close"));
        this.f14755a.setVisibility(8);
        r4 = this.e;
        r5 = R.string.oui_iv_close_desc;
        r8 = "oui_iv_close_desc";
        goto L5
    L8:
        String r18 = r15.getString(ZeusTransformUtils.mapRes(R.styleable.OTextTitleBar_oui_leftButtonText, "styleable", "OTextTitleBar_oui_leftButtonText"));
        float r19 = r15.getDimension(ZeusTransformUtils.mapRes(R.styleable.OTextTitleBar_oui_leftTextSize, "styleable", "OTextTitleBar_oui_leftTextSize"), h.a(15));
        int r20 = r15.getColor(ZeusTransformUtils.mapRes(R.styleable.OTextTitleBar_oui_leftTextColor, "styleable", "OTextTitleBar_oui_leftTextColor"), ContextCompat.getColor(r14, ZeusTransformUtils.mapRes(R.color.TextPrimary, TypedValues.Custom.S_COLOR, "TextPrimary")));
        this.e.setVisibility(8);
        this.f14755a.setVisibility(0);
        this.f14755a.setText(r18);
        this.f14755a.setTextSize(0, r19);
        this.f14755a.setTextColor(r20);
        goto L9
    }

    public ImageView getBackBtn() {
        return this.e;
    }

    public int getEndButtonType() {
        return this.i;
    }

    public TextView getEndText() {
        return this.c;
    }

    public TextView getStartText() {
        return this.f14755a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextView r0 = this.f14755a;
        if (r0 == null) goto L5;
        o.a(r0, h.a(44), h.a(44), false);
    L5:
        TextView r5 = this.c;
        if (r5 == null) goto L9;
        o.a(r5, h.a(44), h.a(44), false);
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
        if (r5.getId() != ZeusTransformUtils.mapRes(R.id.text_right, OaidModel.KEY_ID, "text_right")) goto L15;
        this.d.b(r5);
        return;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int r0 = h.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        int r1 = ((r0 / 2) - Math.max(this.f14755a.getMeasuredWidth(), this.c.getMeasuredWidth())) * 2;
        this.f14756b.setMaxWidth(Math.max(r1, h.a(112)));
    }

    @Override // com.obric.oui.titlebar.OTitleBar
    public void setDividerLineBackground(int r1) {
        this.h.setBackgroundColor(r1);
    }

    public void setEndText(int r1) {
        this.c.setText(r1);
    }

    public void setEndText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.c.setText(r4);
    }

    public void setEndTextColor(int r1) {
        this.c.setTextColor(r1);
    }

    public void setEndTextSize(float r1) {
        this.c.setTextSize(r1);
    }

    public void setLineBackground(int r1) {
        this.h.setBackgroundColor(r1);
    }

    public void setOnTitleBarClickListener(com.obric.oui.titlebar.a.a r3) {
        this.d = (com.obric.oui.titlebar.a.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.titlebar.a.a.class, "com.obric.memorydata.plugin");
    }

    public void setStartText(int r1) {
        this.f14755a.setText(r1);
    }

    public void setStartText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.f14755a.setText(r4);
    }

    public void setStartTextColor(int r1) {
        this.f14755a.setTextColor(r1);
    }

    public void setStartTextSize(float r1) {
        this.f14755a.setTextSize(r1);
    }

    public void setUseBackIcon(boolean r6) {
        if (this.f == r6) goto L13;
        this.f = r6;
        ImageView r0 = this.e;
        int r1 = 0;
        if (r6 == false) goto L7;
        int r7 = 0;
    L8:
        r0.setVisibility(r7);
        this.e.setImageResource(ZeusTransformUtils.mapRes(R.drawable.o_ic_titlebar_back, "drawable", "o_ic_titlebar_back"));
        TextView r8 = this.f14755a;
        if (this.f == false) goto L11;
        r1 = 8;
    L11:
        r8.setVisibility(r1);
        this.e.setContentDescription(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.oui_iv_back_desc, TypedValues.Custom.S_STRING, "oui_iv_back_desc")));
        return;
    L7:
        r7 = 8;
        goto L8
    }

    public void setUseCloseIcon(boolean r6) {
        if (this.g == r6) goto L13;
        this.g = r6;
        ImageView r0 = this.e;
        int r1 = 0;
        if (r6 == false) goto L7;
        int r7 = 0;
    L8:
        r0.setVisibility(r7);
        this.e.setImageResource(ZeusTransformUtils.mapRes(R.drawable.o_ic_titlebar_close, "drawable", "o_ic_titlebar_close"));
        TextView r8 = this.f14755a;
        if (this.g == false) goto L11;
        r1 = 8;
    L11:
        r8.setVisibility(r1);
        this.e.setContentDescription(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.oui_iv_close_desc, TypedValues.Custom.S_STRING, "oui_iv_close_desc")));
        return;
    L7:
        r7 = 8;
        goto L8
    }
}
