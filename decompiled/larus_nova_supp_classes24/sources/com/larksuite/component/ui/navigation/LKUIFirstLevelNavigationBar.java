package com.larksuite.component.ui.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import j08.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class LKUIFirstLevelNavigationBar extends RelativeLayout {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public String f;
    public int g;
    public float h;
    public final TextView i;
    public final ImageView j;
    public final ImageView k;
    public final ImageView l;
    public final ImageView m;
    public final ImageView n;

    public ImageView getLeftImageView() {
        return this.j;
    }

    public ImageView getRightImageView1() {
        return this.k;
    }

    public ImageView getRightImageView2() {
        return this.l;
    }

    public ImageView getRightImageView3() {
        return this.m;
    }

    public ImageView getRightImageView4() {
        return this.n;
    }

    public String getTitle() {
        return this.f;
    }

    public TextView getTitleView() {
        return this.i;
    }

    public LKUIFirstLevelNavigationBar(Context r2) {
        this(r2, null);
    }

    public void setLeftDrawableRes(int r2) {
        this.a = r2;
        this.j.setImageResource(r2);
    }

    public void setRightDrawable1Res(int r2) {
        this.b = r2;
        this.k.setImageResource(r2);
    }

    public void setRightDrawable2Res(int r2) {
        this.c = r2;
        this.l.setImageResource(r2);
    }

    public void setRightDrawable3Res(int r2) {
        this.d = r2;
        this.m.setImageResource(r2);
    }

    public void setRightDrawable4Res(int r2) {
        this.e = r2;
        this.n.setImageResource(r2);
    }

    public void setTitle(String r2) {
        this.f = r2;
        this.i.setText(r2);
    }

    public void setTitleTextColor(int r2) {
        this.g = r2;
        this.i.setTextColor(r2);
    }

    public void setTitleTextSize(float r2) {
        this.h = r2;
        this.i.setTextSize(r2);
    }

    public LKUIFirstLevelNavigationBar(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public LKUIFirstLevelNavigationBar(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        RelativeLayout.inflate(r10, 2131563565, this);
        TextView r13 = (TextView) findViewById(2131388772);
        this.i = r13;
        ImageView r0 = (ImageView) findViewById(2131377698);
        this.j = r0;
        ImageView r1 = (ImageView) findViewById(2131384508);
        this.k = r1;
        ImageView r2 = (ImageView) findViewById(2131384509);
        this.l = r2;
        ImageView r3 = (ImageView) findViewById(2131384510);
        this.m = r3;
        ImageView r4 = (ImageView) findViewById(2131384511);
        this.n = r4;
        if (r11 == null) goto L5;
        TypedArray r14 = getContext().obtainStyledAttributes(r11, new int[]{2130970061, 2130970062, 2130970063, 2130970064, 2130970065, 2130970066, 2130970067, 2130970068});
        this.a = r14.getResourceId(0, this.a);
        this.b = r14.getResourceId(1, this.b);
        this.c = r14.getResourceId(2, this.c);
        this.d = r14.getResourceId(3, this.d);
        this.e = r14.getResourceId(4, this.e);
        this.f = r14.getString(5);
        this.g = r14.getColor(6, ContextCompat.getColor(getContext(), 2131103463));
        this.h = r14.getDimension(7, b.e(getContext(), 26.0f));
        r14.recycle();
    L6:
        r13.setText(this.f);
        r13.setTextSize(0, a08.b.a(this.h, r13.getContext()));
        r13.setTextColor(this.g);
        r0.setImageResource(this.a);
        r1.setImageResource(this.b);
        r2.setImageResource(this.c);
        r3.setImageResource(this.d);
        r4.setImageResource(this.e);
        return;
    L5:
        this.h = b.e(getContext(), 26.0f);
        this.g = ContextCompat.getColor(getContext(), 2131103463);
        goto L6
    }
}
