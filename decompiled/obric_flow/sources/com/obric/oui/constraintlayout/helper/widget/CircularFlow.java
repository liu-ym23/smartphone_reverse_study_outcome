package com.obric.oui.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.constraintlayout.widget.R$styleable;
import com.obric.oui.constraintlayout.widget.VirtualLayout;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class CircularFlow extends VirtualLayout {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static int f12610v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static float f12611w;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ConstraintLayout f12612l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f12613m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float[] f12614n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int[] f12615o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f12616p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f12617q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f12618r;
    public String s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Float f12619t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Integer f12620u;

    public CircularFlow(Context r5) {
        super(r5);
    }

    private void setAngles(String r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        int r10 = 0;
        this.f12617q = 0;
    L5:
        int r11 = r5.indexOf(44, r10);
        if (r11 == (-1)) goto L7;
        s(r5.substring(r10, r11).trim());
        r10 = r11 + 1;
        goto L5
    L7:
        s(r5.substring(r10).trim());
    }

    private void setRadius(String r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        int r10 = 0;
        this.f12616p = 0;
    L5:
        int r11 = r5.indexOf(44, r10);
        if (r11 == (-1)) goto L7;
        t(r5.substring(r10, r11).trim());
        r10 = r11 + 1;
        goto L5
    L7:
        t(r5.substring(r10).trim());
    }

    public float[] getAngles() {
        return Arrays.copyOf(this.f12614n, this.f12617q);
    }

    public int[] getRadius() {
        return Arrays.copyOf(this.f12615o, this.f12616p);
    }

    @Override // com.obric.oui.constraintlayout.widget.VirtualLayout, com.obric.oui.constraintlayout.widget.ConstraintHelper
    public final void k(AttributeSet r10) {
        super.k(r10);
        if (r10 == null) goto L31;
        TypedArray r11 = getContext().obtainStyledAttributes(r10, R$styleable.ConstraintLayout_Layout);
        int r5 = r11.getIndexCount();
        int r12 = 0;
    L5:
        if (r12 >= r5) goto L22;
        int r13 = r11.getIndex(r12);
        if (r13 != R$styleable.ConstraintLayout_Layout_circularflow_viewCenter) goto L10;
        this.f12613m = r11.getResourceId(r13, 0);
    L21:
        r12 = r12 + 1;
        goto L5
    L10:
        if (r13 != R$styleable.ConstraintLayout_Layout_circularflow_angles) goto L13;
        String r14 = r11.getString(r13);
        this.f12618r = r14;
        setAngles(r14);
        goto L21
    L13:
        if (r13 != R$styleable.ConstraintLayout_Layout_circularflow_radiusInDP) goto L16;
        String r15 = r11.getString(r13);
        this.s = r15;
        setRadius(r15);
        goto L21
    L16:
        if (r13 != R$styleable.ConstraintLayout_Layout_circularflow_defaultAngle) goto L19;
        Float r16 = Float.valueOf(r11.getFloat(r13, f12611w));
        this.f12619t = r16;
        setDefaultAngle(r16.floatValue());
        goto L21
    L19:
        if (r13 != R$styleable.ConstraintLayout_Layout_circularflow_defaultRadius) goto L21;
        Integer r17 = Integer.valueOf(r11.getDimensionPixelSize(r13, f12610v));
        this.f12620u = r17;
        setDefaultRadius(r17.intValue());
        goto L21
    L22:
        r11.recycle();
        return;
    }

    @Override // com.obric.oui.constraintlayout.widget.VirtualLayout, com.obric.oui.constraintlayout.widget.ConstraintHelper, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        String r5 = this.f12618r;
        if (r5 == null) goto L5;
        this.f12614n = new float[1];
        setAngles(r5);
    L5:
        String r10 = this.s;
        if (r10 == null) goto L8;
        this.f12615o = new int[1];
        setRadius(r10);
    L8:
        Float r11 = this.f12619t;
        if (r11 == null) goto L11;
        setDefaultAngle(r11.floatValue());
    L11:
        Integer r12 = this.f12620u;
        if (r12 == null) goto L14;
        setDefaultRadius(r12.intValue());
    L14:
        this.f12612l = (ConstraintLayout) getParent();
        int r13 = 0;
    L16:
        if (r13 >= this.f12985b) goto L50;
        View r14 = this.f12612l.e(this.f12984a[r13]);
        if (r14 == null) goto L49;
        int r15 = f12610v;
        float r16 = f12611w;
        int[] r17 = this.f12615o;
        HashMap r18 = this.f12988i;
        if (r17 != null) goto L23;
    L25:
        Integer r19 = this.f12620u;
        if (r19 != null) goto L28;
    L33:
        Log.e("CircularFlow", "Added radius to view with id: " + ((String) r18.get(Integer.valueOf(r14.getId()))));
    L34:
        float[] r20 = this.f12614n;
        if (r20 != null) goto L37;
    L39:
        Float r21 = this.f12619t;
        if (r21 != null) goto L42;
    L47:
        Log.e("CircularFlow", "Added angle to view with id: " + ((String) r18.get(Integer.valueOf(r14.getId()))));
    L48:
        ConstraintLayout.LayoutParams r22 = (ConstraintLayout.LayoutParams) r14.getLayoutParams();
        r22.f13028r = r16;
        r22.f13024p = this.f12613m;
        r22.f13026q = r15;
        r14.setLayoutParams(r22);
        goto L49
    L42:
        if (r21.floatValue() == (-1.0f)) goto L47;
        this.f12617q++;
        if (this.f12614n != null) goto L46;
        this.f12614n = new float[1];
    L46:
        float[] r23 = getAngles();
        this.f12614n = r23;
        r23[this.f12617q - 1] = r16;
        goto L48
    L37:
        if (r13 >= r20.length) goto L39;
        r16 = r20[r13];
        goto L48
    L28:
        if (r19.intValue() == (-1)) goto L33;
        this.f12616p++;
        if (this.f12615o != null) goto L32;
        this.f12615o = new int[1];
    L32:
        int[] r24 = getRadius();
        this.f12615o = r24;
        r24[this.f12616p - 1] = r15;
        goto L34
    L23:
        if (r13 >= r17.length) goto L25;
        r15 = r17[r13];
    L49:
        r13 = r13 + 1;
        goto L16
    L50:
        e();
    }

    public final void s(String r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.length() != 0) goto L7;
        return;
    L7:
        if (this.f12986c != null) goto L9;
        return;
    L9:
        float[] r10 = this.f12614n;
        if (r10 != null) goto L13;
        return;
    L13:
        if ((this.f12617q + 1) <= r10.length) goto L15;
        this.f12614n = Arrays.copyOf(r10, r10.length + 1);
    L15:
        this.f12614n[this.f12617q] = Integer.parseInt(r5);
        this.f12617q++;
    }

    public void setDefaultAngle(float r5) {
        f12611w = r5;
    }

    public void setDefaultRadius(int r5) {
        f12610v = r5;
    }

    public final void t(String r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.length() == 0) goto L18;
        Context r10 = this.f12986c;
        if (r10 != null) goto L9;
        return;
    L9:
        int[] r11 = this.f12615o;
        if (r11 != null) goto L13;
        return;
    L13:
        if ((this.f12616p + 1) <= r11.length) goto L15;
        this.f12615o = Arrays.copyOf(r11, r11.length + 1);
    L15:
        this.f12615o[this.f12616p] = (int) (Integer.parseInt(r5) * r10.getResources().getDisplayMetrics().density);
        this.f12616p++;
        return;
    }

    public CircularFlow(Context r5, AttributeSet r10) {
        super(r5, r10);
    }

    public CircularFlow(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
    }
}
