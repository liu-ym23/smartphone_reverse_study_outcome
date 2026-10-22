package com.ivy.ivykit.plugin.impl.render;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.obric.launcher.widget.R$drawable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends LinearLayout {
    public h(Context r10, Function0 r11) {
        Intrinsics.checkNotNullParameter(r11, "buttonClick");
        super(r10);
        setOrientation(1);
        setGravity(17);
        setBackgroundColor(-1);
        ImageView r5 = new ImageView(r10);
        LinearLayout.LayoutParams r12 = new LinearLayout.LayoutParams(200, 200);
        r12.setMargins(0, 0, 0, 100);
        r5.setLayoutParams(r12);
        r5.setImageResource(R$drawable.img_forbid_light);
        addView(r5);
        TextView r13 = new TextView(r10);
        LinearLayout.LayoutParams r14 = new LinearLayout.LayoutParams(-2, -2);
        r14.setMargins(0, 0, 0, 25);
        r13.setLayoutParams(r14);
        r13.setTextColor(Color.parseColor("#161823"));
        r13.setText("你要访问的网站存在风险");
        r13.setTextSize(17.0f);
        r13.setTypeface(null, 1);
        r13.setGravity(17);
        addView(r13);
        TextView r15 = new TextView(r10);
        LinearLayout.LayoutParams r16 = new LinearLayout.LayoutParams(-2, -2);
        r16.setMargins(0, 0, 0, 145);
        r15.setLayoutParams(r16);
        r15.setTextColor(Color.parseColor("#99161823"));
        r15.setText("继续访问可能会导致个人隐私泄露,账号被盗用等危害");
        r15.setTextSize(14.0f);
        r15.setTypeface(null, 1);
        addView(r15);
        Button r17 = new Button(r10);
        r17.setLayoutParams(new LinearLayout.LayoutParams(500, -2));
        r17.setText("继续访问");
        r17.setTextSize(16.0f);
        r17.setTypeface(Typeface.DEFAULT_BOLD);
        r17.setTextColor(Color.parseColor("#161823"));
        GradientDrawable r18 = new GradientDrawable();
        r18.setCornerRadius(10.0f);
        r18.setColor(Color.parseColor("#09161823"));
        r17.setBackground(r18);
        r17.setOnClickListener(new g(0, r11));
        addView(r17);
    }
}
