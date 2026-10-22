package com.lynx.smartrefresh.layout.footer;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.lynx.smartrefresh.layout.SmartRefreshLayout;
import com.lynx.smartrefresh.layout.constant.RefreshState;
import com.lynx.smartrefresh.layout.internal.InternalClassics;
import m6a.e;
import m6a.h;
import m6a.i;
import n6a.b;
import p6a.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class ClassicsFooter extends InternalClassics<ClassicsFooter> implements e {
    public final String q;
    public final String r;
    public final String s;
    public final String t;
    public final String u;
    public final String v;
    public final String w;
    public boolean x;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RefreshState.values().length];
            a = r0;
            r0[RefreshState.None.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            a[RefreshState.PullUpToLoad.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            a[RefreshState.Loading.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            a[RefreshState.LoadReleased.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            a[RefreshState.ReleaseToLoad.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            a[RefreshState.Refreshing.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public ClassicsFooter(Context r2) {
        this(r2, null);
    }

    @Override // p6a.b, m6a.e
    public final boolean c(boolean r3) {
        if (this.x == r3) goto L10;
        this.x = r3;
        ImageView r0 = this.e;
        if (r3 == false) goto L7;
        this.d.setText(this.w);
        r0.setVisibility(8);
        return true;
    L7:
        this.d.setText(this.q);
        r0.setVisibility(0);
        return true;
    L10:
        return true;
    }

    @Override // com.lynx.smartrefresh.layout.internal.InternalClassics, p6a.b, m6a.g
    public void setPrimaryColors(int... r3) {
        if (this.b != b.e) goto L6;
        super.setPrimaryColors(r3);
        return;
    }

    public ClassicsFooter(Context r9, AttributeSet r10) {
        super(r9, r10, 0);
        this.x = false;
        View.inflate(r9, 2131564895, this);
        ImageView r1 = (ImageView) findViewById(2131387139);
        this.e = r1;
        ImageView r2 = (ImageView) findViewById(2131387141);
        this.f = r2;
        this.d = (TextView) findViewById(2131387142);
        TypedArray r11 = r9.obtainStyledAttributes(r10, new int[]{2130974146, 2130974148, 2130974152, 2130974153, 2130974154, 2130974155, 2130974156, 2130974157, 2130974179, 2130974196, 2130974201, 2130974202, 2130974203, 2130974204, 2130974205, 2130974206, 2130974207, 2130974210});
        RelativeLayout.LayoutParams r3 = (RelativeLayout.LayoutParams) r1.getLayoutParams();
        RelativeLayout.LayoutParams r4 = (RelativeLayout.LayoutParams) r2.getLayoutParams();
        int r5 = r11.getDimensionPixelSize(4, r6a.b.c(20.0f));
        r4.rightMargin = r5;
        r3.rightMargin = r5;
        r3.width = r11.getLayoutDimension(3, r3.width);
        r3.height = r11.getLayoutDimension(3, r3.height);
        r4.width = r11.getLayoutDimension(6, r4.width);
        r4.height = r11.getLayoutDimension(6, r4.height);
        r3.width = r11.getLayoutDimension(7, r3.width);
        r3.height = r11.getLayoutDimension(7, r3.height);
        r4.width = r11.getLayoutDimension(7, r4.width);
        r4.height = r11.getLayoutDimension(7, r4.height);
        this.m = r11.getInt(8, this.m);
        this.b = b.h[r11.getInt(1, this.b.a)];
        if (r11.hasValue(2) == false) goto L6;
        this.e.setImageDrawable(r11.getDrawable(2));
    L9:
        if (r11.hasValue(5) == false) goto L12;
        this.f.setImageDrawable(r11.getDrawable(5));
    L15:
        if (r11.hasValue(17) == false) goto L18;
        this.d.setTextSize(0, r11.getDimensionPixelSize(17, r6a.b.c(16.0f)));
    L18:
        if (r11.hasValue(9) == false) goto L23;
        int r6 = r11.getColor(9, 0);
        this.k = true;
        this.l = r6;
        h r7 = this.g;
        if (r7 == null) goto L23;
        ((SmartRefreshLayout.i) r7).c(this, r6);
    L23:
        if (r11.hasValue(0) == false) goto L26;
        g(r11.getColor(0, 0));
    L26:
        if (r11.hasValue(14) == false) goto L28;
        this.q = r11.getString(14);
    L30:
        if (r11.hasValue(16) == false) goto L32;
        this.r = r11.getString(16);
    L34:
        if (r11.hasValue(12) == false) goto L36;
        this.s = r11.getString(12);
    L38:
        if (r11.hasValue(15) == false) goto L40;
        this.t = r11.getString(15);
    L42:
        if (r11.hasValue(11) == false) goto L44;
        this.u = r11.getString(11);
    L46:
        if (r11.hasValue(10) == false) goto L48;
        this.v = r11.getString(10);
    L50:
        if (r11.hasValue(13) == false) goto L52;
        this.w = r11.getString(13);
    L53:
        r11.recycle();
        r2.animate().setInterpolator(null);
        TextView r12 = this.d;
        if (isInEditMode() == false) goto L56;
        String r13 = this.s;
    L57:
        r12.setText(r13);
        if (isInEditMode() == false) goto L60;
        r1.setVisibility(8);
        return;
    L60:
        r2.setVisibility(8);
        return;
    L56:
        r13 = this.q;
        goto L57
    L52:
        this.w = r9.getString(2131914118);
        goto L53
    L48:
        this.v = r9.getString(2131914115);
        goto L50
    L44:
        this.u = r9.getString(2131914116);
        goto L46
    L40:
        this.t = r9.getString(2131914120);
        goto L42
    L36:
        this.s = r9.getString(2131914117);
        goto L38
    L32:
        this.r = r9.getString(2131914121);
        goto L34
    L28:
        this.q = r9.getString(2131914119);
        goto L30
    L12:
        if (this.f.getDrawable() != null) goto L15;
        d r8 = new d();
        this.i = r8;
        r8.a(-10066330);
        this.f.setImageDrawable(this.i);
        goto L15
    L6:
        if (this.e.getDrawable() != null) goto L9;
        p6a.a r14 = new p6a.a();
        this.h = r14;
        r14.a(-10066330);
        this.e.setImageDrawable(this.h);
        goto L9
    }

    @Override // com.lynx.smartrefresh.layout.internal.InternalClassics, p6a.b, m6a.g
    public final int e(SmartRefreshLayout r3, boolean r4) {
        if (this.x == true) goto L10;
        TextView r0 = this.d;
        if (r4 == false) goto L7;
        String r1 = this.u;
    L8:
        r0.setText(r1);
        return super.e(r3, r4);
    L7:
        r1 = this.v;
        goto L8
    L10:
        return 0;
    }

    @Override // p6a.b, q6a.e
    public final void i(i r2, RefreshState r3, RefreshState r4) {
        ImageView r5 = this.e;
        if (this.x == false) goto L5;
        return;
    L5:
        switch(a.a[r4.ordinal()]) {
            case 1: goto L10;
            case 2: goto L11;
            case 3: goto L9;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L17;
        };
    L7:
        this.d.setText(this.t);
        r5.setVisibility(8);
        return;
    L8:
        this.d.setText(this.r);
        r5.animate().rotation(0.0f);
        return;
    L9:
        r5.setVisibility(8);
        this.d.setText(this.s);
        return;
    L10:
        r5.setVisibility(0);
    L11:
        this.d.setText(this.q);
        r5.animate().rotation(180.0f);
        return;
    }

    @Override // com.lynx.smartrefresh.layout.internal.InternalClassics, p6a.b, m6a.g
    public final void n(i r2, int r3, int r4) {
        if (this.x == true) goto L6;
        super.n(r2, r3, r4);
        return;
    }
}
