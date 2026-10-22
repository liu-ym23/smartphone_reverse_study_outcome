package com.larksuite.component.ui.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import j08.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class LKUIStandardNavigationBar extends RelativeLayout {
    public int a;
    public int b;
    public int c;
    public int d;
    public String e;
    public int f;
    public float g;
    public RightStyle h;
    public String i;
    public int j;
    public float k;
    public final LinearLayout l;
    public final ImageView m;
    public final ImageView n;
    public final LinearLayout o;
    public final ImageView p;
    public final ImageView q;
    public final TextView r;
    public final TextView s;

    public static final enum RightStyle extends Enum<RightStyle> {
        public static final RightStyle ICON = null;
        public static final RightStyle TEXT = null;
        public static final /* synthetic */ RightStyle[] a = null;

        static {
            RightStyle r0 = new RightStyle("ICON", 0);
            ICON = r0;
            RightStyle r1 = new RightStyle("TEXT", 1);
            TEXT = r1;
            a = new RightStyle[]{r0, r1};
        }

        public static RightStyle[] values() {
            return (RightStyle[]) a.clone();
        }

        public static RightStyle valueOf(String r1) {
            return (RightStyle) r27.a.a(RightStyle.class, r1);
        }

        public RightStyle(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RightStyle.values().length];
            a = r0;
            r0[RightStyle.ICON.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            a[RightStyle.TEXT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public final void a() {
        int r0 = a.a[this.h.ordinal()];
        if (r0 != 1) goto L5;
        this.s.setVisibility(8);
        this.p.setVisibility(0);
        this.q.setVisibility(0);
        return;
    L5:
        if (r0 != 2) goto L11;
        this.s.setVisibility(0);
        this.p.setVisibility(8);
        this.q.setVisibility(8);
        return;
    }

    public LinearLayout getLeftContainer() {
        return this.l;
    }

    public ImageView getLeftImageView1() {
        return this.m;
    }

    public ImageView getLeftImageView2() {
        return this.n;
    }

    public LinearLayout getRightContainer() {
        return this.o;
    }

    public ImageView getRightImageView1() {
        return this.p;
    }

    public ImageView getRightImageView2() {
        return this.q;
    }

    public TextView getRightTextView() {
        return this.s;
    }

    public String getTitle() {
        return this.i;
    }

    public TextView getTitleView() {
        return this.r;
    }

    public LKUIStandardNavigationBar(Context r2) {
        this(r2, null);
    }

    public void setLeftDrawable1Res(int r2) {
        this.a = r2;
        this.m.setImageResource(r2);
    }

    public void setLeftDrawable2Res(int r2) {
        this.b = r2;
        this.n.setImageResource(r2);
    }

    public void setRightDrawable1Res(int r2) {
        this.c = r2;
        this.p.setImageResource(r2);
    }

    public void setRightDrawable2Res(int r2) {
        this.d = r2;
        this.q.setImageResource(r2);
    }

    public void setRightStyle(RightStyle r1) {
        this.h = r1;
        a();
    }

    public void setRightText(String r2) {
        this.e = r2;
        this.s.setText(r2);
    }

    public void setRightTextColor(int r2) {
        this.f = r2;
        this.s.setTextColor(r2);
    }

    public void setRightTextSize(float r2) {
        this.g = r2;
        this.s.setTextSize(r2);
    }

    public void setTitle(String r2) {
        this.i = r2;
        this.r.setText(r2);
    }

    public void setTitleTextColor(int r2) {
        this.j = r2;
        this.r.setTextColor(r2);
    }

    public void setTitleTextSize(float r2) {
        this.k = r2;
        this.r.setTextSize(r2);
    }

    public LKUIStandardNavigationBar(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public LKUIStandardNavigationBar(Context r12, AttributeSet r13, int r14) {
        super(r12, r13, r14);
        this.a = 2131243846;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        RightStyle r15 = RightStyle.ICON;
        this.h = r15;
        RelativeLayout.inflate(getContext(), 2131563568, this);
        this.l = (LinearLayout) findViewById(2131377696);
        ImageView r0 = (ImageView) findViewById(2131377700);
        this.m = r0;
        ImageView r1 = (ImageView) findViewById(2131377701);
        this.n = r1;
        TextView r2 = (TextView) findViewById(2131388772);
        this.r = r2;
        this.o = (LinearLayout) findViewById(2131384504);
        ImageView r3 = (ImageView) findViewById(2131384515);
        this.p = r3;
        ImageView r4 = (ImageView) findViewById(2131384516);
        this.q = r4;
        TextView r5 = (TextView) findViewById(2131384528);
        this.s = r5;
        if (r13 == null) goto L5;
        TypedArray r16 = getContext().obtainStyledAttributes(r13, new int[]{2130974215, 2130974216, 2130974217, 2130974218, 2130974219, 2130974220, 2130974221, 2130974222, 2130974223, 2130974224, 2130974225});
        this.a = r16.getResourceId(0, this.a);
        this.b = r16.getResourceId(1, this.b);
        this.c = r16.getResourceId(2, this.c);
        this.d = r16.getResourceId(3, this.d);
        this.i = r16.getString(5);
        this.j = r16.getColor(9, ContextCompat.getColor(getContext(), 2131103463));
        this.k = r16.getDimension(10, b.e(getContext(), 17.0f));
        this.e = r16.getString(4);
        this.f = r16.getColor(7, ContextCompat.getColor(getContext(), 2131103463));
        this.g = r16.getDimension(8, b.e(getContext(), 16.0f));
        this.h = RightStyle.values()[r16.getInt(6, r15.ordinal())];
        r16.recycle();
    L6:
        r0.setImageResource(this.a);
        r1.setImageResource(this.b);
        r3.setImageResource(this.c);
        r4.setImageResource(this.d);
        r2.setText(this.i);
        r2.setTextSize(0, a08.b.a(this.k, getContext()));
        r2.setTextColor(this.j);
        r5.setText(this.e);
        r5.setTextSize(0, a08.b.a(this.g, getContext()));
        r5.setTextColor(this.f);
        a();
        return;
    L5:
        this.k = b.e(getContext(), 17.0f);
        this.j = ContextCompat.getColor(getContext(), 2131103463);
        this.g = b.e(getContext(), 16.0f);
        this.f = ContextCompat.getColor(getContext(), 2131103463);
        goto L6
    }
}
