package com.larus.setting.impl;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.larus.common_ui.widget.roundlayout.RoundTextView;
import com.larus.setting.impl.databinding.LarusPageSettingFontAndThemeBinding;
import kotlin.Lazy;
import kotlin.Unit;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a1 implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ FontAndThemeSettingFragment a;
    public final /* synthetic */ LarusPageSettingFontAndThemeBinding b;
    public final /* synthetic */ ConstraintLayout c;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        FontAndThemeSettingFragment r0 = this.a;
        if (r0.i == true) goto L56;
        r0.i = true;
        LarusPageSettingFontAndThemeBinding r1 = r0.d;
        if (r1 == null) goto L26;
        ConstraintLayout r4 = r1.n;
        if (r4.getLayoutParams().height > 0) goto L25;
        int r5 = r4.getMeasuredWidth();
        if (r5 <= 0) goto L25;
        ViewGroup.LayoutParams r6 = r1.o.getLayoutParams();
        if (r6.height == (-2)) goto L14;
        r6.height = -2;
        r1.o.setLayoutParams(r6);
    L14:
        if (r1.o.getMeasuredWidth() <= 0) goto L25;
        RoundTextView r7 = r1.y;
        RoundTextView r8 = r1.x;
        float r9 = r7.getTextSize();
        float r10 = r8.getTextSize();
        Lazy r11 = we8.e.a;
        float r2 = c7.c(Integer.valueOf(we8.e.c(r0.m, r0.h)));
        r7.setTextSize(0, r9 + r2);
        r8.setTextSize(0, r2 + r10);
        r4.measure(View.MeasureSpec.makeMeasureSpec(r5, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        int r3 = r1.o.getMeasuredHeight();
        if (r3 <= 0) goto L20;
        ViewGroup.LayoutParams r12 = r1.o.getLayoutParams();
        if (r12.height == r3) goto L20;
        r12.height = r3;
        r1.o.setLayoutParams(r12);
    L20:
        r7.setTextSize(0, r9);
        r8.setTextSize(0, r10);
        int r13 = r4.getMeasuredHeight();
        if (r13 <= 0) goto L25;
        ViewGroup.LayoutParams r14 = r4.getLayoutParams();
        if (r14.height == r13) goto L25;
        r14.height = r13;
        r4.setLayoutParams(r14);
    L25:
        Unit r15 = Unit.INSTANCE;
    L26:
        FontAndThemeSettingFragment r16 = this.a;
        LarusPageSettingFontAndThemeBinding r17 = r16.d;
        if (r17 != null) goto L30;
    L48:
        FontAndThemeSettingFragment r18 = this.a;
        Integer r19 = r18.j;
        if (r19 != null) goto L51;
    L55:
        return false;
    L51:
        if (r18.k == false) goto L55;
        NestedScrollView r20 = this.b.v;
        if (r20.getScrollY() == r19.intValue()) goto L55;
        this.a.k = false;
        r20.scrollTo(0, r19.intValue());
        goto L55
    L30:
        if (r16.l == false) goto L32;
    L45:
        LarusPageSettingFontAndThemeBinding r21 = r16.d;
        if (r21 == null) goto L48;
        r21.c.setVisibility(0);
        r21.d.setVisibility(8);
        Unit r22 = Unit.INSTANCE;
        goto L48
    L32:
        if (FontAndThemeSettingFragment.T90(r17.C) == false) goto L34;
    L39:
        boolean r23 = true;
    L40:
        if (r23 == false) goto L45;
        LarusPageSettingFontAndThemeBinding r24 = r16.d;
        if (r24 == null) goto L44;
        r24.c.setVisibility(8);
        r24.d.setVisibility(0);
        Unit r25 = Unit.INSTANCE;
    L44:
        r16.l = true;
        goto L48
    L34:
        if (FontAndThemeSettingFragment.T90(r17.E) == true) goto L39;
        if (FontAndThemeSettingFragment.T90(r17.A) == true) goto L39;
        r23 = false;
        goto L40
    L56:
        this.c.getViewTreeObserver().removeOnPreDrawListener(this);
        return true;
    }

    public a1(FontAndThemeSettingFragment r1, LarusPageSettingFontAndThemeBinding r2, ConstraintLayout r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
