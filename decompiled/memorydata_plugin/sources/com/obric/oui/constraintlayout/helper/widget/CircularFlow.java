package com.obric.oui.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.obric.memorydata.plugin.R;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.constraintlayout.widget.VirtualLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class CircularFlow extends VirtualLayout {
    private static int c;
    private static float d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ConstraintLayout f13650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f13651b;
    private float[] e;
    private int[] f;
    private int g;
    private int h;
    private String i;
    private String r;
    private Float s;
    private Integer t;

    static {
    }

    public CircularFlow(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
    }

    public CircularFlow(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"));
    }

    public CircularFlow(Context r3, AttributeSet r4, int r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), r5);
    }

    private void a() {
        this.f13650a = (ConstraintLayout) ZeusTransformUtils.preCheckCast(getParent(), ConstraintLayout.class, "com.obric.memorydata.plugin");
        int r0 = 0;
    L4:
        if (r0 >= this.k) goto L38;
        View r1 = this.f13650a.getViewById(this.j[r0]);
        if (r1 == null) goto L37;
        int r3 = c;
        float r4 = d;
        int[] r5 = this.f;
        if (r5 != null) goto L11;
    L13:
        Integer r6 = this.t;
        if (r6 != null) goto L16;
    L21:
        Log.e("CircularFlow", "Added radius to view with id: " + ((String) ZeusTransformUtils.preCheckCast(this.q.get(Integer.valueOf(r1.getId())), String.class, "com.obric.memorydata.plugin")));
    L22:
        float[] r7 = this.e;
        if (r7 != null) goto L25;
    L27:
        Float r8 = this.s;
        if (r8 != null) goto L30;
    L35:
        Log.e("CircularFlow", "Added angle to view with id: " + ((String) ZeusTransformUtils.preCheckCast(this.q.get(Integer.valueOf(r1.getId())), String.class, "com.obric.memorydata.plugin")));
    L36:
        ConstraintLayout.LayoutParams r9 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r1.getLayoutParams(), ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        r9.r = r4;
        r9.p = this.f13651b;
        r9.q = r3;
        r1.setLayoutParams(r9);
        goto L37
    L30:
        if (r8.floatValue() == (-1.0f)) goto L35;
        this.h++;
        if (this.e != null) goto L34;
        this.e = new float[1];
    L34:
        float[] r10 = getAngles();
        this.e = r10;
        r10[this.h - 1] = r4;
        goto L36
    L25:
        if (r0 >= r7.length) goto L27;
        r4 = r7[r0];
        goto L36
    L16:
        if (r6.intValue() == (-1)) goto L21;
        this.g++;
        if (this.f != null) goto L20;
        this.f = new int[1];
    L20:
        int[] r11 = getRadius();
        this.f = r11;
        r11[this.g - 1] = r3;
        goto L22
    L11:
        if (r0 >= r5.length) goto L13;
        r3 = r5[r0];
    L37:
        r0 = r0 + 1;
        goto L4
    L38:
        e();
    }

    private void a(String r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.length() != 0) goto L7;
        return;
    L7:
        if (this.l != null) goto L9;
        return;
    L9:
        float[] r0 = this.e;
        if (r0 != null) goto L13;
        return;
    L13:
        if ((this.h + 1) <= r0.length) goto L15;
        this.e = Arrays.copyOf(r0, r0.length + 1);
    L15:
        this.e[this.h] = Integer.parseInt(r4);
        this.h++;
    }

    private void b(String r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.length() != 0) goto L7;
        return;
    L7:
        if (this.l != null) goto L9;
        return;
    L9:
        int[] r0 = this.f;
        if (r0 != null) goto L13;
        return;
    L13:
        if ((this.g + 1) <= r0.length) goto L15;
        this.f = Arrays.copyOf(r0, r0.length + 1);
    L15:
        this.f[this.g] = (int) (Integer.parseInt(r5) * ZeusTransformUtils.getResources(this.l, "com.obric.memorydata.plugin").getDisplayMetrics().density);
        this.g++;
    }

    private void setAngles(String r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        int r0 = 0;
        this.h = 0;
    L5:
        int r1 = r4.indexOf(44, r0);
        if (r1 == (-1)) goto L7;
        a(r4.substring(r0, r1).trim());
        r0 = r1 + 1;
        goto L5
    L7:
        a(r4.substring(r0).trim());
    }

    private void setRadius(String r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        int r0 = 0;
        this.g = 0;
    L5:
        int r1 = r4.indexOf(44, r0);
        if (r1 == (-1)) goto L7;
        b(r4.substring(r0, r1).trim());
        r0 = r1 + 1;
        goto L5
    L7:
        b(r4.substring(r0).trim());
    }

    @Override // com.obric.oui.constraintlayout.widget.VirtualLayout, com.obric.oui.constraintlayout.widget.ConstraintHelper
    public void a(AttributeSet r8) {
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r8, AttributeSet.class, "com.obric.memorydata.plugin");
        super.a(r9);
        if (r9 == null) goto L31;
        TypedArray r10 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes(r9, R.styleable.ConstraintLayout_Layout);
        int r0 = r10.getIndexCount();
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L22;
        int r3 = r10.getIndex(r2);
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_circularflow_viewCenter, "styleable", "ConstraintLayout_Layout_circularflow_viewCenter")) goto L10;
        this.f13651b = r10.getResourceId(r3, 0);
    L21:
        r2 = r2 + 1;
        goto L5
    L10:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_circularflow_angles, "styleable", "ConstraintLayout_Layout_circularflow_angles")) goto L13;
        String r4 = r10.getString(r3);
        this.i = r4;
        setAngles(r4);
        goto L21
    L13:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_circularflow_radiusInDP, "styleable", "ConstraintLayout_Layout_circularflow_radiusInDP")) goto L16;
        String r5 = r10.getString(r3);
        this.r = r5;
        setRadius(r5);
        goto L21
    L16:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_circularflow_defaultAngle, "styleable", "ConstraintLayout_Layout_circularflow_defaultAngle")) goto L19;
        Float r6 = Float.valueOf(r10.getFloat(r3, d));
        this.s = r6;
        setDefaultAngle(r6.floatValue());
        goto L21
    L19:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_circularflow_defaultRadius, "styleable", "ConstraintLayout_Layout_circularflow_defaultRadius")) goto L21;
        Integer r7 = Integer.valueOf(r10.getDimensionPixelSize(r3, c));
        this.t = r7;
        setDefaultRadius(r7.intValue());
        goto L21
    L22:
        r10.recycle();
        return;
    }

    public float[] getAngles() {
        return Arrays.copyOf(this.e, this.h);
    }

    public int[] getRadius() {
        return Arrays.copyOf(this.f, this.g);
    }

    @Override // com.obric.oui.constraintlayout.widget.VirtualLayout, com.obric.oui.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String r0 = this.i;
        if (r0 == null) goto L5;
        this.e = new float[1];
        setAngles(r0);
    L5:
        String r1 = this.r;
        if (r1 == null) goto L8;
        this.f = new int[1];
        setRadius(r1);
    L8:
        Float r2 = this.s;
        if (r2 == null) goto L11;
        setDefaultAngle(r2.floatValue());
    L11:
        Integer r3 = this.t;
        if (r3 == null) goto L14;
        setDefaultRadius(r3.intValue());
    L14:
        a();
    }

    public void setDefaultAngle(float r1) {
        d = r1;
    }

    public void setDefaultRadius(int r1) {
        c = r1;
    }
}
