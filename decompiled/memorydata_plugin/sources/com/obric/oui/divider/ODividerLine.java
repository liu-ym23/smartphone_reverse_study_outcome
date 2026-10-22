package com.obric.oui.divider;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.util.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public class ODividerLine extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f13837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextView f13838b;
    private View c;

    public ODividerLine(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public ODividerLine(Context r3, AttributeSet r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), 0);
    }

    public ODividerLine(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r6, r7, r5);
        a(r6);
        a(r6, r7);
    }

    public void a(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        View r0 = ZeusTransformUtils.inflate(r7, ZeusTransformUtils.mapRes(R.layout.o_view_divider_line, "layout", "o_view_divider_line"), this, "com.obric.memorydata.plugin");
        this.f13837a = r0;
        this.f13838b = (TextView) ZeusTransformUtils.preCheckCast(r0.findViewById(ZeusTransformUtils.mapRes(R.id.tv_left_text, OaidModel.KEY_ID, "tv_left_text")), TextView.class, "com.obric.memorydata.plugin");
        this.c = this.f13837a.findViewById(ZeusTransformUtils.mapRes(R.id.underline, OaidModel.KEY_ID, "underline"));
        this.f13837a.setBackgroundColor(ContextCompat.getColor(r7, ZeusTransformUtils.mapRes(R.color.BGPrimary, TypedValues.Custom.S_COLOR, "BGPrimary")));
    }

    public void a(Context r9, AttributeSet r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r12 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Log.d("SETTING", "getBaseStyle() called with: context = [" + r11 + "], attrs = [" + r12 + "]");
        TypedArray r13 = r11.obtainStyledAttributes(r12, R.styleable.ODividerLine);
        if (r13.getBoolean(ZeusTransformUtils.mapRes(R.styleable.ODividerLine_oui_hideLine, "styleable", "ODividerLine_oui_hideLine"), false) == false) goto L5;
        this.c.setVisibility(8);
    L5:
        this.c.setBackgroundColor(ContextCompat.getColor(r11, ZeusTransformUtils.mapRes(R.color.LinePrimary, TypedValues.Custom.S_COLOR, "LinePrimary")));
        this.f13837a.setBackgroundColor(ContextCompat.getColor(r11, ZeusTransformUtils.mapRes(R.color.BGPrimary, TypedValues.Custom.S_COLOR, "BGPrimary")));
        String r0 = r13.getString(ZeusTransformUtils.mapRes(R.styleable.ODividerLine_oui_startText, "styleable", "ODividerLine_oui_startText"));
        if (TextUtils.isEmpty(r0) == true) goto L8;
        this.f13838b.setText(r0);
    L9:
        this.f13838b.setTextColor(ContextCompat.getColor(r11, ZeusTransformUtils.mapRes(R.color.TextTertiary, TypedValues.Custom.S_COLOR, "TextTertiary")));
        if (r13.getBoolean(ZeusTransformUtils.mapRes(R.styleable.ODividerLine_oui_isStartAllCap, "styleable", "ODividerLine_oui_isStartAllCap"), false) == false) goto L12;
        this.f13838b.setAllCaps(true);
    L12:
        r13.recycle();
        return;
    L8:
        this.f13838b.setVisibility(8);
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(this.c.getLayoutParams(), ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin")).bottomMargin = h.a(4);
        goto L9
    }

    public TextView getTxtLeft() {
        return this.f13838b;
    }
}
