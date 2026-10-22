package com.lynx.smartrefresh.layout.header;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.lynx.smartrefresh.layout.SmartRefreshLayout;
import com.lynx.smartrefresh.layout.constant.RefreshState;
import com.lynx.smartrefresh.layout.internal.InternalClassics;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import m6a.f;
import m6a.h;
import m6a.i;
import p6a.d;
import r6a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class ClassicsHeader extends InternalClassics<ClassicsHeader> implements f {
    public final String A;
    public final String B;
    public final String C;
    public final String D;
    public final String q;
    public Date r;
    public final TextView s;
    public final SharedPreferences t;
    public final DateFormat u;
    public final boolean v;
    public final String w;
    public final String x;
    public final String y;
    public final String z;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RefreshState.values().length];
            a = r0;
            r0[RefreshState.None.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            a[RefreshState.PullDownToRefresh.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            a[RefreshState.Refreshing.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            a[RefreshState.RefreshReleased.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            a[RefreshState.ReleaseToRefresh.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            a[RefreshState.ReleaseToTwoLevel.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            a[RefreshState.Loading.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public ClassicsHeader(Context r2) {
        this(r2, null);
    }

    @Override // com.lynx.smartrefresh.layout.internal.InternalClassics
    public final void g(int r4) {
        this.s.setTextColor((16777215 & r4) | (-872415232));
        super.g(r4);
    }

    public final void l(Date r5) {
        this.r = r5;
        this.s.setText(this.u.format(r5));
        if (this.t != null) goto L5;
        return;
    L5:
        if (isInEditMode() == true) goto L9;
        this.t.edit().putLong(this.q, r5.getTime()).apply();
        return;
    }

    public ClassicsHeader(Context r11, AttributeSet r12) {
        super(r11, r12, 0);
        this.q = "LAST_UPDATE_TIME";
        this.v = true;
        View.inflate(r11, 2131564896, this);
        ImageView r2 = (ImageView) findViewById(2131387139);
        this.e = r2;
        TextView r3 = (TextView) findViewById(2131387143);
        this.s = r3;
        ImageView r4 = (ImageView) findViewById(2131387141);
        this.f = r4;
        this.d = (TextView) findViewById(2131387142);
        TypedArray r13 = r11.obtainStyledAttributes(r12, new int[]{2130974146, 2130974148, 2130974152, 2130974153, 2130974154, 2130974155, 2130974156, 2130974157, 2130974166, 2130974179, 2130974196, 2130974201, 2130974202, 2130974203, 2130974205, 2130974206, 2130974207, 2130974208, 2130974209, 2130974210, 2130974211, 2130974212});
        RelativeLayout.LayoutParams r5 = (RelativeLayout.LayoutParams) r2.getLayoutParams();
        RelativeLayout.LayoutParams r6 = (RelativeLayout.LayoutParams) r4.getLayoutParams();
        new LinearLayout.LayoutParams(-2, -2).topMargin = r13.getDimensionPixelSize(20, b.c(0.0f));
        int r7 = r13.getDimensionPixelSize(4, b.c(20.0f));
        r6.rightMargin = r7;
        r5.rightMargin = r7;
        r5.width = r13.getLayoutDimension(3, r5.width);
        r5.height = r13.getLayoutDimension(3, r5.height);
        r6.width = r13.getLayoutDimension(6, r6.width);
        r6.height = r13.getLayoutDimension(6, r6.height);
        r5.width = r13.getLayoutDimension(7, r5.width);
        r5.height = r13.getLayoutDimension(7, r5.height);
        r6.width = r13.getLayoutDimension(7, r6.width);
        r6.height = r13.getLayoutDimension(7, r6.height);
        this.m = r13.getInt(9, this.m);
        boolean r8 = r13.getBoolean(8, true);
        this.v = r8;
        this.b = n6a.b.h[r13.getInt(1, this.b.a)];
        if (r13.hasValue(2) == false) goto L6;
        this.e.setImageDrawable(r13.getDrawable(2));
    L9:
        if (r13.hasValue(5) == false) goto L12;
        this.f.setImageDrawable(r13.getDrawable(5));
    L15:
        if (r13.hasValue(19) == false) goto L18;
        this.d.setTextSize(0, r13.getDimensionPixelSize(19, b.c(16.0f)));
    L18:
        if (r13.hasValue(18) == false) goto L21;
        r3.setTextSize(0, r13.getDimensionPixelSize(18, b.c(12.0f)));
    L21:
        if (r13.hasValue(10) == false) goto L26;
        int r9 = r13.getColor(10, 0);
        this.k = true;
        this.l = r9;
        h r1 = this.g;
        if (r1 == null) goto L26;
        ((SmartRefreshLayout.i) r1).c(this, r9);
    L26:
        if (r13.hasValue(0) == false) goto L29;
        int r10 = r13.getColor(0, 0);
        r3.setTextColor((16777215 & r10) | (-872415232));
        super.g(r10);
    L29:
        if (r13.hasValue(14) == false) goto L31;
        this.w = r13.getString(14);
    L33:
        if (r13.hasValue(13) == false) goto L35;
        this.y = r13.getString(13);
    L37:
        if (r13.hasValue(16) == false) goto L39;
        this.z = r13.getString(16);
    L41:
        if (r13.hasValue(12) == false) goto L43;
        this.A = r13.getString(12);
    L45:
        if (r13.hasValue(11) == false) goto L47;
        this.B = r13.getString(11);
    L49:
        if (r13.hasValue(17) == false) goto L51;
        this.D = r13.getString(17);
    L53:
        if (r13.hasValue(15) == false) goto L55;
        this.x = r13.getString(15);
    L57:
        if (r13.hasValue(21) == false) goto L59;
        this.C = r13.getString(21);
    L60:
        this.u = new SimpleDateFormat(this.C, Locale.getDefault());
        r13.recycle();
        r4.animate().setInterpolator(null);
        if (r8 == false) goto L63;
        int r14 = 0;
    L64:
        r3.setVisibility(r14);
        TextView r15 = this.d;
        if (isInEditMode() == false) goto L67;
        String r16 = this.x;
    L68:
        r15.setText(r16);
        if (isInEditMode() == false) goto L71;
        r2.setVisibility(8);
    L84:
    L80:
        th = move-exception;
        th.printStackTrace();
    L82:
        String r17 = this.q + r11.getClass().getName();
        this.q = r17;
        SharedPreferences r18 = r11.getSharedPreferences("ClassicsHeader", 0);
        this.t = r18;
        l(new Date(r18.getLong(r17, System.currentTimeMillis())));
        return;
    L73:
        if ((r11 instanceof FragmentActivity) == false) goto L82;
        FragmentManager r19 = ((FragmentActivity) r11).getSupportFragmentManager();     // Catch: Throwable -> L80
        if (r19 == null) goto L82;
        if (r19.getFragments().size() <= 0) goto L82;
        l(new Date());     // Catch: Throwable -> L80
        return;
    L71:
        r4.setVisibility(8);
        goto L84
    L67:
        r16 = this.w;
        goto L68
    L63:
        r14 = 8;
        goto L64
    L59:
        this.C = r11.getString(2131914129);
        goto L60
    L55:
        this.x = r11.getString(2131914126);
        goto L57
    L51:
        this.D = r11.getString(2131914128);
        goto L53
    L47:
        this.B = r11.getString(2131914122);
        goto L49
    L43:
        this.A = r11.getString(2131914123);
        goto L45
    L39:
        this.z = r11.getString(2131914127);
        goto L41
    L35:
        this.y = r11.getString(2131914124);
        goto L37
    L31:
        this.w = r11.getString(2131914125);
        goto L33
    L12:
        if (this.f.getDrawable() != null) goto L15;
        d r20 = new d();
        this.i = r20;
        r20.a(-10066330);
        this.f.setImageDrawable(this.i);
        goto L15
    L6:
        if (this.e.getDrawable() != null) goto L9;
        p6a.a r21 = new p6a.a();
        this.h = r21;
        r21.a(-10066330);
        this.e.setImageDrawable(this.h);
        goto L9
    }

    @Override // com.lynx.smartrefresh.layout.internal.InternalClassics, p6a.b, m6a.g
    public final int e(SmartRefreshLayout r3, boolean r4) {
        if (r4 == false) goto L6;
        this.d.setText(this.A);
        if (this.r == null) goto L8;
        l(new Date());
    L8:
        return super.e(r3, r4);
    L6:
        this.d.setText(this.B);
        goto L8
    }

    @Override // p6a.b, q6a.e
    public final void i(i r4, RefreshState r5, RefreshState r6) {
        ImageView r7 = this.e;
        TextView r8 = this.s;
        int r2 = 8;
        switch(a.a[r6.ordinal()]) {
            case 1: goto L13;
            case 2: goto L16;
            case 3: goto L11;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L5;
            default: goto L22;
        };
    L5:
        r7.setVisibility(8);
        if (this.v == false) goto L8;
        r2 = 4;
    L8:
        r8.setVisibility(r2);
        this.d.setText(this.y);
        return;
    L9:
        this.d.setText(this.D);
        r7.animate().rotation(0.0f);
        return;
    L10:
        this.d.setText(this.z);
        r7.animate().rotation(180.0f);
        return;
    L11:
        this.d.setText(this.x);
        r7.setVisibility(8);
        return;
    L16:
        this.d.setText(this.w);
        r7.setVisibility(0);
        r7.animate().rotation(0.0f);
        return;
    L22:
        return;
    L13:
        if (this.v == false) goto L15;
        r2 = 0;
    L15:
        r8.setVisibility(r2);
        goto L16
    }
}
