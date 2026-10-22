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
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.lynx.tasm.utils.a;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;

/* JADX INFO: loaded from: classes3.dex */
public class ODividerLine extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f13182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f13183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f13184c;

    public ODividerLine(Context r5) {
        this(r5, null);
    }

    public TextView getTxtLeft() {
        return this.f13183b;
    }

    public ODividerLine(Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, 0);
    }

    public ODividerLine(Context r5, @Nullable AttributeSet r10, int r11) {
        super(r5, r10, r11);
        View r12 = View.inflate(r5, R$layout.o_view_divider_line, this);
        this.f13182a = r12;
        this.f13183b = (TextView) r12.findViewById(R$id.tv_left_text);
        this.f13184c = this.f13182a.findViewById(R$id.underline);
        this.f13182a.setBackgroundColor(ContextCompat.getColor(r5, R$color.BGPrimary));
        Log.d("SETTING", "getBaseStyle() called with: context = [" + r5 + "], attrs = [" + r10 + "]");
        TypedArray r13 = r5.obtainStyledAttributes(r10, R$styleable.ODividerLine);
        if (r13.getBoolean(R$styleable.ODividerLine_oui_hideLine, false) == false) goto L5;
        this.f13184c.setVisibility(8);
    L5:
        this.f13184c.setBackgroundColor(ContextCompat.getColor(r5, R$color.LinePrimary));
        this.f13182a.setBackgroundColor(ContextCompat.getColor(r5, R$color.BGPrimary));
        String r14 = r13.getString(R$styleable.ODividerLine_oui_startText);
        if (TextUtils.isEmpty(r14) == true) goto L8;
        this.f13183b.setText(r14);
    L9:
        this.f13183b.setTextColor(ContextCompat.getColor(r5, R$color.TextTertiary));
        if (r13.getBoolean(R$styleable.ODividerLine_oui_isStartAllCap, false) == false) goto L12;
        this.f13183b.setAllCaps(true);
    L12:
        r13.recycle();
        return;
    L8:
        this.f13183b.setVisibility(8);
        ((ViewGroup.MarginLayoutParams) this.f13184c.getLayoutParams()).bottomMargin = a.u(4);
        goto L9
    }
}
