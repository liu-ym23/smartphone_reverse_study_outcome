package com.ss.android.lark.passport.flow.core.widget;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import uzb.l;
import vyb.d;
import vyb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class CommonTitleBar extends ConstraintLayout {
    public static final /* synthetic */ int s = 0;
    public CharSequence a;
    public int b;
    public float c;
    public float d;
    public int e;
    public final int f;
    public int g;
    public final boolean h;
    public int i;
    public String j;
    public ImageView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public FrameLayout o;
    public b p;
    public final Context q;
    public Activity r;

    public interface a {
        View getActionView();
    }

    public interface b {
        void a();

        void b();

        void c();

        void d();
    }

    public static abstract class c implements b {
        public c() {
        }

        @Override // com.ss.android.lark.passport.flow.core.widget.CommonTitleBar.b
        public final void a() {
        }

        @Override // com.ss.android.lark.passport.flow.core.widget.CommonTitleBar.b
        public final void c() {
        }

        @Override // com.ss.android.lark.passport.flow.core.widget.CommonTitleBar.b
        public final void d() {
        }
    }

    public final void R5() {
        this.k.setVisibility(0);
        setLeftIconDrawable(2131247179);
    }

    public TextView getRightTextView() {
        return this.n;
    }

    public TextView getTitleView() {
        return this.m;
    }

    public CommonTitleBar(Context r2) {
        this(r2, null);
    }

    private void setLeftIconDrawable(int r3) {
        int r0 = UDColorUtils.getColor(this.q, 2131102418);
        Drawable r4 = UDIconUtils.getIconDrawable(this.q, r3, r0);
        this.k.setImageDrawable(r4);
    }

    public void setLeftClickAction(a r4) {
        this.g = 2;
        this.l.setVisibility(8);
        this.k.setVisibility(8);
        this.o.setVisibility(0);
        this.o.addView(r4.getActionView(), new FrameLayout.LayoutParams(-2, -2));
        this.o.setOnClickListener(new e());
    }

    public void setLeftIconRes(int r3) {
        this.i = r3;
        this.l.setVisibility(8);
        this.k.setVisibility(0);
        this.o.setVisibility(8);
        setLeftIconDrawable(this.i);
    }

    public void setLeftText(String r3) {
        this.g = 1;
        this.l.setVisibility(0);
        this.k.setVisibility(8);
        this.o.setVisibility(8);
        this.j = r3;
        this.l.setText(r3);
    }

    public void setLeftTextColor(int r2) {
        this.e = r2;
        this.l.setTextColor(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setLeftTextSize(float r2) {
        this.d = l.c(getContext(), r2);
        this.l.setTextSize(r2);
    }

    public void setRightTvEnable(boolean r2) {
        this.n.setEnabled(r2);
    }

    public void setRithtText(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        this.n.setVisibility(8);
        return;
    L5:
        this.n.setVisibility(0);
        this.n.setText(r3);
        if (this.h == true) goto L10;
        this.n.setTextColor(this.f);
        return;
    }

    public void setTitleClickListener(b r1) {
        this.p = r1;
    }

    public void setTitleColor(int r2) {
        this.b = r2;
        this.m.setTextColor(r2);
    }

    public void setTitleText(CharSequence r2) {
        this.a = r2;
        TextView r0 = this.m;
        if (TextUtils.isEmpty(r2) == false) goto L5;
        int r3 = 8;
    L6:
        r0.setVisibility(r3);
        this.m.setText(this.a);
        return;
    L5:
        r3 = 0;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setTitleTextSize(int r2) {
        float r3 = r2;
        this.c = l.c(getContext(), r3);
        this.m.setTextSize(r3);
    }

    public CommonTitleBar(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CommonTitleBar(Context r11, AttributeSet r12, int r13) {
        super(r11, r12, r13);
        this.a = "";
        l.b(getContext(), R.color.transparent);
        this.b = l.b(getContext(), 2131106622);
        this.c = l.c(getContext(), 17.0f);
        this.d = l.c(getContext(), 17.0f);
        this.e = l.b(getContext(), 2131106622);
        this.f = l.b(getContext(), 2131106622);
        this.g = 0;
        this.h = false;
        this.i = 2131247178;
        this.j = "";
        this.q = r11;
        TypedArray r14 = getContext().obtainStyledAttributes(r12, new int[]{2130970095, 2130970096, 2130970097, 2130970098, 2130970099, 2130970100, 2130970101, 2130970102, 2130970103, 2130970104, 2130970105, 2130970106, 2130970107, 2130970108, 2130970109});
        this.a = r14.getString(12);
        int r15 = r14.getColor(0, r11.getResources().getColor(R.color.transparent));
        this.b = r14.getColor(11, r11.getResources().getColor(2131106622));
        this.i = r14.getResourceId(1, 2131247178);
        int r4 = r14.getDimensionPixelOffset(2, l.a(getContext(), 16.0f));
        this.j = r14.getString(3);
        String r7 = r14.getString(8);
        this.c = r14.getDimension(13, l.c(getContext(), 17.0f));
        this.d = r14.getDimension(5, l.c(getContext(), 17.0f));
        this.e = r14.getColor(4, r11.getResources().getColor(2131106622));
        boolean r3 = r14.getBoolean(14, false);
        this.h = r3;
        if (r3 == true) goto L5;
        this.f = r14.getColor(9, r11.getResources().getColor(2131106622));
    L5:
        this.g = r14.getInteger(6, 0);
        r14.recycle();
        LayoutInflater.from(getContext()).inflate(2131564168, this, true);
        this.p = new com.ss.android.lark.passport.flow.core.widget.a(this);
        setBackgroundColor(r15);
        this.k = (ImageView) findViewById(2131377773);
        this.l = (TextView) findViewById(2131377814);
        this.m = (TextView) findViewById(2131365396);
        this.n = (TextView) findViewById(2131391310);
        this.m.setClickable(false);
        this.o = (FrameLayout) findViewById(2131377754);
        TextView r16 = this.m;
        if (TextUtils.isEmpty(this.a) == false) goto L8;
        int r17 = 8;
    L9:
        r16.setVisibility(r17);
        this.m.setText(this.a);
        this.m.setTextColor(this.b);
        TextView r18 = this.m;
        Context r19 = getContext();
        int r110 = (int) this.c;
        Resources r111 = r19.getResources();
        r18.setTextSize((int) ((r110 / WindowDisplayMetricsOverride.apply(r111, r111.getDisplayMetrics()).scaledDensity) + 0.5f));
        TextView r112 = this.m;
        int r113 = h18.e.a;
        r112.setTypeface(h18.e.b(getContext(), 1));
        setRithtText(r7);
        int r114 = this.g;
        if (r114 == 0) goto L16;
        if (r114 == 1) goto L15;
        if (r114 != 2) goto L17;
        this.l.setVisibility(8);
        this.k.setVisibility(8);
        this.o.setVisibility(0);
    L17:
        ((ViewGroup.MarginLayoutParams) this.k.getLayoutParams()).leftMargin = r4;
        ((ViewGroup.MarginLayoutParams) this.l.getLayoutParams()).leftMargin = r4;
        ((ViewGroup.MarginLayoutParams) this.o.getLayoutParams()).leftMargin = r4;
        this.k.setOnClickListener(new vyb.a(this));
        this.l.setOnClickListener(new vyb.b(this));
        this.m.setOnClickListener(new vyb.c(this));
        this.n.setOnClickListener(new d(this));
        return;
    L15:
        this.l.setVisibility(0);
        this.k.setVisibility(8);
        this.o.setVisibility(8);
        this.l.setText(this.j);
        TextView r115 = this.l;
        Context r116 = getContext();
        int r0 = (int) this.d;
        Resources r117 = r116.getResources();
        r115.setTextSize((int) ((r0 / WindowDisplayMetricsOverride.apply(r117, r117.getDisplayMetrics()).scaledDensity) + 0.5f));
        this.l.setTextColor(this.e);
        goto L17
    L16:
        this.l.setVisibility(8);
        this.k.setVisibility(0);
        this.o.setVisibility(8);
        setLeftIconDrawable(this.i);
        goto L17
    L8:
        r17 = 0;
        goto L9
    }
}
