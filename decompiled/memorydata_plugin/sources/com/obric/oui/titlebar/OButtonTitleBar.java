package com.obric.oui.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
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
public class OButtonTitleBar extends OTitleBar implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ImageView f14728a;
    private TextView c;
    private com.obric.oui.titlebar.a.a d;
    private Drawable e;
    private View f;
    private int g;
    private int h;

    public OButtonTitleBar(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public OButtonTitleBar(Context r3, AttributeSet r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), 0);
    }

    public OButtonTitleBar(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r6, r7, r5);
        this.h = 0;
        a(r6);
        if (r7 == null) goto L6;
        a(r6, r7);
        return;
    }

    private void a(Context r5) {
        inflate((Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.layout.o_view_button_title_bar, "layout", "o_view_button_title_bar"), this);
        this.f14728a = (ImageView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.back_btn, OaidModel.KEY_ID, "back_btn")), ImageView.class, "com.obric.memorydata.plugin");
        this.f14756b = (TextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.title, OaidModel.KEY_ID, "title")), TextView.class, "com.obric.memorydata.plugin");
        this.c = (TextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.right_btn, OaidModel.KEY_ID, "right_btn")), TextView.class, "com.obric.memorydata.plugin");
        this.f = findViewById(ZeusTransformUtils.mapRes(R.id.line, OaidModel.KEY_ID, "line"));
        this.f14728a.setOnClickListener(this);
        this.c.setOnClickListener(this);
        com.obric.oui.common.widget.a r6 = new com.obric.oui.common.widget.a(0.5f, 1.0f);
        this.f14728a.setOnTouchListener(r6);
        this.c.setOnTouchListener(r6);
    }

    private void a(Context r12, AttributeSet r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin");
        TypedArray r15 = r14.obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r13, AttributeSet.class, "com.obric.memorydata.plugin"), R.styleable.OButtonTitleBar);
        String r0 = r15.getString(ZeusTransformUtils.mapRes(R.styleable.OButtonTitleBar_oui_centerText, "styleable", "OButtonTitleBar_oui_centerText"));
        float r2 = r15.getDimension(ZeusTransformUtils.mapRes(R.styleable.OButtonTitleBar_oui_centerTextSize, "styleable", "OButtonTitleBar_oui_centerTextSize"), h.a(17));
        int r3 = r15.getColor(ZeusTransformUtils.mapRes(R.styleable.OButtonTitleBar_oui_centerTextColor, "styleable", "OButtonTitleBar_oui_centerTextColor"), ContextCompat.getColor(r14, ZeusTransformUtils.mapRes(R.color.TextPrimary, TypedValues.Custom.S_COLOR, "TextPrimary")));
        this.f14756b.setText(r0);
        int r4 = 0;
        this.f14756b.setTextSize(0, r2);
        this.f14756b.setTextColor(r3);
        String r1 = r15.getString(ZeusTransformUtils.mapRes(R.styleable.OButtonTitleBar_oui_rightButtonText, "styleable", "OButtonTitleBar_oui_rightButtonText"));
        int r5 = r15.getInt(ZeusTransformUtils.mapRes(R.styleable.OButtonTitleBar_oui_rightButtonType, "styleable", "OButtonTitleBar_oui_rightButtonType"), 1);
        float r7 = r15.getDimension(ZeusTransformUtils.mapRes(R.styleable.OButtonTitleBar_oui_rightButtonTextSize, "styleable", "OButtonTitleBar_oui_rightButtonTextSize"), h.a(17.0f));
        int r8 = r15.getColor(ZeusTransformUtils.mapRes(R.styleable.OButtonTitleBar_oui_rightButtonTextColor, "styleable", "OButtonTitleBar_oui_rightButtonTextColor"), 0);
        this.e = r15.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OButtonTitleBar_oui_rightButtonTextBackground, "styleable", "OButtonTitleBar_oui_rightButtonTextBackground"));
        int r9 = r15.getInt(ZeusTransformUtils.mapRes(R.styleable.OButtonTitleBar_oui_rightButtonVisible, "styleable", "OButtonTitleBar_oui_rightButtonVisible"), 0);
        this.c.setText(r1);
        this.h = r5;
        TextView r6 = this.c;
        if (r5 != 1) goto L5;
        r6.setTypeface(Typeface.defaultFromStyle(1));
        TextView r10 = this.c;
        int r11 = ZeusTransformUtils.mapRes(R.color.Primary, TypedValues.Custom.S_COLOR, "Primary");
    L6:
        r10.setTextColor(ContextCompat.getColor(r14, r11));
        this.c.setTextSize(0, r7);
        if (r8 == 0) goto L9;
        this.c.setTextColor(r8);
    L9:
        Drawable r16 = this.e;
        if (r16 == null) goto L12;
        this.c.setBackground(r16);
    L12:
        this.c.setVisibility(r9);
        boolean r17 = r15.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OButtonTitleBar_oui_dividerVisible, "styleable", "OButtonTitleBar_oui_dividerVisible"), false);
        View r18 = this.f;
        if (r17 == true) goto L16;
        r4 = 4;
    L16:
        r18.setVisibility(r4);
        int r19 = r15.getColor(ZeusTransformUtils.mapRes(R.styleable.OButtonTitleBar_oui_dividerColor, "styleable", "OButtonTitleBar_oui_dividerColor"), ContextCompat.getColor(r14, ZeusTransformUtils.mapRes(R.color.LinePrimary, TypedValues.Custom.S_COLOR, "LinePrimary")));
        this.g = r19;
        this.f.setBackgroundColor(r19);
        r15.recycle();
        return;
    L5:
        r6.setTypeface(Typeface.defaultFromStyle(0));
        r10 = this.c;
        r11 = ZeusTransformUtils.mapRes(R.color.TextPrimary, TypedValues.Custom.S_COLOR, "TextPrimary");
        goto L6
    }

    public TextView getEndBtn() {
        return this.c;
    }

    public int getEndButtonType() {
        return this.h;
    }

    public ImageView getStartBtn() {
        return this.f14728a;
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
        if (r5.getId() != ZeusTransformUtils.mapRes(R.id.back_btn, OaidModel.KEY_ID, "back_btn")) goto L8;
        this.d.a(r5);
        return;
    L8:
        if (r5.getId() != ZeusTransformUtils.mapRes(R.id.right_btn, OaidModel.KEY_ID, "right_btn")) goto L13;
        this.d.b(r5);
        return;
    }

    @Override // com.obric.oui.titlebar.OTitleBar
    public void setDividerLineBackground(int r1) {
        this.f.setBackgroundColor(r1);
    }

    public void setOnTitleBarClickListener(com.obric.oui.titlebar.a.a r3) {
        this.d = (com.obric.oui.titlebar.a.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.titlebar.a.a.class, "com.obric.memorydata.plugin");
    }
}
