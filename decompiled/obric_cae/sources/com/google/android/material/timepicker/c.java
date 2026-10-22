package com.google.android.material.timepicker;

import aa.h;
import aa.j;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.cae.R;
import j0.h0;
import j0.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class c extends ConstraintLayout {
    public final androidx.activity.d A;
    public int B;
    public aa.f C;

    public c(Context r8, AttributeSet r10) {
        this(r8, r10, 0);
    }

    @Override // android.view.ViewGroup
    public final void addView(View r8, int r10, ViewGroup.LayoutParams r11) {
        super.addView(r8, r10, r11);
        if (r8.getId() != (-1)) goto L5;
        WeakHashMap<View, h0> r12 = w.f8437a;
        r8.setId(w.e.a());
    L5:
        Handler r13 = getHandler();
        if (r13 == null) goto L9;
        androidx.activity.d r14 = this.A;
        r13.removeCallbacks(r14);
        r13.post(r14);
        return;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        s();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public final void onViewRemoved(View r8) {
        super.onViewRemoved(r8);
        Handler r10 = getHandler();
        if (r10 == null) goto L6;
        androidx.activity.d r11 = this.A;
        r10.removeCallbacks(r11);
        r10.post(r11);
        return;
    }

    public void s() {
        androidx.constraintlayout.widget.d r8 = new androidx.constraintlayout.widget.d();
        r8.c(this);
        HashMap r10 = new HashMap();
        int r11 = 0;
    L4:
        if (r11 >= getChildCount()) goto L18;
        View r12 = getChildAt(r11);
        if (r12.getId() == R.id.circle_center) goto L17;
        if ("skip".equals(r12.getTag()) == true) goto L17;
        int r13 = (Integer) r12.getTag(R.id.material_clock_level);
        if (r13 != null) goto L14;
        r13 = 1;
    L14:
        if (r10.containsKey(r13) == true) goto L16;
        r10.put(r13, new ArrayList());
    L16:
        ((List) r10.get(r13)).add(r12);
    L17:
        r11 = r11 + 1;
        goto L4
    L18:
        Iterator r14 = r10.entrySet().iterator();
    L20:
        if (r14.hasNext() == false) goto L31;
        Map.Entry r15 = (Map.Entry) r14.next();
        List r16 = (List) r15.getValue();
        int r17 = ((Integer) r15.getKey()).intValue();
        int r18 = this.B;
        if (r17 != 2) goto L24;
        r18 = Math.round(r18 * 0.66f);
    L24:
        Iterator r19 = r16.iterator();
        float r20 = 0.0f;
    L26:
        if (r19.hasNext() == false) goto L20;
        int r21 = ((View) r19.next()).getId();
        HashMap<Integer, androidx.constraintlayout.widget.d.a> r22 = r8.f1443c;
        if (r22.containsKey(Integer.valueOf(r21)) == true) goto L30;
        r22.put(Integer.valueOf(r21), new androidx.constraintlayout.widget.d.a());
    L30:
        androidx.constraintlayout.widget.d.b r23 = r22.get(Integer.valueOf(r21)).f1447d;
        r23.f1502z = R.id.circle_center;
        r23.A = r18;
        r23.B = r20;
        r20 = r20 + (360.0f / r16.size());
        goto L26
    L31:
        r8.a(this);
    }

    @Override // android.view.View
    public final void setBackgroundColor(int r8) {
        this.C.k(ColorStateList.valueOf(r8));
    }

    public c(Context r8, AttributeSet r10, int r11) {
        super(r8, r10, r11);
        LayoutInflater.from(r8).inflate(R.layout.material_radial_view_group, this);
        aa.f r12 = new aa.f();
        this.C = r12;
        h r13 = new h(0.5f);
        j r14 = r12.f139a.f156a;
        r14.getClass();
        j.a r15 = new j.a(r14);
        r15.f196e = r13;
        r15.f197f = r13;
        r15.f198g = r13;
        r15.f199h = r13;
        r12.setShapeAppearanceModel(new j(r15));
        this.C.k(ColorStateList.valueOf(-1));
        aa.f r16 = this.C;
        WeakHashMap<View, h0> r17 = w.f8437a;
        w.d.q(this, r16);
        TypedArray r18 = r8.obtainStyledAttributes(r10, g9.a.f7780u, r11, 0);
        this.B = r18.getDimensionPixelSize(0, 0);
        this.A = new androidx.activity.d(this, 16);
        r18.recycle();
    }
}
