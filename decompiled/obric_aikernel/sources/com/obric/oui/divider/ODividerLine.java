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
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.obric.oui.common.util.f;
import u8.c;
import u8.h;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
public class ODividerLine extends LinearLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f6525c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TextView f6526g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private View f6527h;

    public ODividerLine(Context r10) {
        this(r10, null);
    }

    public ODividerLine(Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, 0);
    }

    public ODividerLine(Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        b(r10);
        a(r10, r11);
    }

    protected void a(Context r10, AttributeSet r11) {
        Log.d("SETTING", "getBaseStyle() called with: context = [" + r10 + "], attrs = [" + r11 + "]");
        TypedArray r12 = r10.obtainStyledAttributes(r11, l.ODividerLine);
        if (r12.getBoolean(l.ODividerLine_oui_hideLine, false) == false) goto L5;
        this.f6527h.setVisibility(8);
    L5:
        this.f6527h.setBackgroundColor(ContextCompat.getColor(r10, c.LinePrimary));
        this.f6525c.setBackgroundColor(ContextCompat.getColor(r10, c.BGPrimary));
        String r13 = r12.getString(l.ODividerLine_oui_startText);
        if (TextUtils.isEmpty(r13) == true) goto L8;
        this.f6526g.setText(r13);
    L9:
        this.f6526g.setTextColor(ContextCompat.getColor(r10, c.TextTertiary));
        if (r12.getBoolean(l.ODividerLine_oui_isStartAllCap, false) == false) goto L12;
        this.f6526g.setAllCaps(true);
    L12:
        r12.recycle();
        return;
    L8:
        this.f6526g.setVisibility(8);
        ((ViewGroup.MarginLayoutParams) this.f6527h.getLayoutParams()).bottomMargin = f.b(4);
        goto L9
    }

    @CallSuper
    protected void b(Context r10) {
        View r11 = View.inflate(r10, h.o_view_divider_line, this);
        this.f6525c = r11;
        this.f6526g = (TextView) r11.findViewById(u8.f.tv_left_text);
        this.f6527h = this.f6525c.findViewById(u8.f.underline);
        this.f6525c.setBackgroundColor(ContextCompat.getColor(r10, c.BGPrimary));
    }

    public TextView getTxtLeft() {
        return this.f6526g;
    }
}
