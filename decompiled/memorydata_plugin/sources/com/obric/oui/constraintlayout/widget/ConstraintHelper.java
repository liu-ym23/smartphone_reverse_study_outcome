package com.obric.oui.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.obric.oui.constraintlayout.core.widgets.g;
import com.obric.oui.constraintlayout.core.widgets.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ConstraintHelper extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View[] f13744a;
    protected int[] j;
    protected int k;
    protected Context l;
    protected g m;
    protected boolean n;
    protected String o;
    protected String p;
    protected HashMap<Integer, String> q;

    public ConstraintHelper(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        super(r5);
        this.j = new int[32];
        this.n = false;
        this.f13744a = null;
        this.q = new HashMap();
        this.l = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
        a(null);
    }

    public ConstraintHelper(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r5, r6);
        this.j = new int[32];
        this.n = false;
        this.f13744a = null;
        this.q = new HashMap();
        this.l = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
        a(r6);
    }

    public ConstraintHelper(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r6, r7, r5);
        this.j = new int[32];
        this.n = false;
        this.f13744a = null;
        this.q = new HashMap();
        this.l = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
        a(r7);
    }

    private int a(ConstraintLayout r7, String r8) {
        if (r8 == null) goto L20;
        if (r7 == null) goto L20;
        Resources r6 = ZeusTransformUtils.getResources(this.l, "com.obric.memorydata.plugin");
        if (r6 != null) goto L9;
        return 0;
    L9:
        int r1 = r7.getChildCount();
        int r2 = 0;
    L10:
        if (r2 >= r1) goto L20;
        View r3 = r7.getChildAt(r2);
        if (r3.getId() == (-1)) goto L19;
        String r4 = null;
        r4 = r6.getResourceEntryName(r3.getId());     // Catch: Resources.NotFoundException -> L21
    L16:
        if (r8.equals(r4) == false) goto L19;
        return r3.getId();
    L19:
        r2 = r2 + 1;
    L20:
        return 0;
    }

    private void a(int r4) {
        if (r4 != getId()) goto L5;
        return;
    L5:
        int r0 = this.k + 1;
        int[] r1 = this.j;
        if (r0 <= r1.length) goto L8;
        this.j = Arrays.copyOf(r1, r1.length * 2);
    L8:
        int[] r2 = this.j;
        int r3 = this.k;
        r2[r3] = r4;
        this.k = r3 + 1;
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
        String r5 = r4.trim();
        int r0 = c(r5);
        if (r0 == 0) goto L12;
        this.q.put(Integer.valueOf(r0), r5);
        a(r0);
        return;
    L12:
        Log.w("ConstraintHelper", "Could not find id of \"" + r5 + "\"");
    }

    private void b(String r9) {
        if (r9 != null) goto L4;
        return;
    L4:
        if (r9.length() != 0) goto L7;
        return;
    L7:
        if (this.l != null) goto L9;
        return;
    L9:
        String r10 = r9.trim();
        ConstraintLayout r0 = null;
        if (ZeusTransformUtils.instanceOf(getParent(), ConstraintLayout.class) == false) goto L13;
        r0 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(getParent(), ConstraintLayout.class, "com.obric.memorydata.plugin");
    L13:
        if (r0 != null) goto L16;
        Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
        return;
    L16:
        int r3 = r0.getChildCount();
        int r4 = 0;
    L17:
        if (r4 >= r3) goto L34;
        View r5 = r0.getChildAt(r4);
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r6, ConstraintLayout.LayoutParams.class) == false) goto L26;
        if (r10.equals(((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r6, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin")).ac) == false) goto L26;
        if (r5.getId() != (-1)) goto L25;
        Log.w("ConstraintHelper", "to use ConstraintTag view " + r5.getClass().getSimpleName() + " must have an ID");
        goto L26
    L25:
        a(r5.getId());
    L26:
        r4 = r4 + 1;
        goto L17
    }

    private int c(String r7) {
        if (ZeusTransformUtils.instanceOf(getParent(), ConstraintLayout.class) == false) goto L5;
        ConstraintLayout r0 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(getParent(), ConstraintLayout.class, "com.obric.memorydata.plugin");
    L6:
        int r4 = 0;
        if (isInEditMode() == false) goto L12;
        if (r0 == null) goto L12;
        Object r3 = r0.getDesignInformation(0, r7);
        if (ZeusTransformUtils.instanceOf(r3, Integer.class) == false) goto L12;
        r4 = ((Integer) ZeusTransformUtils.preCheckCast(r3, Integer.class, "com.obric.memorydata.plugin")).intValue();
    L12:
        if (r4 != 0) goto L15;
        if (r0 == null) goto L15;
        r4 = a(r0, r7);
    L15:
        if (r4 == 0) goto L21;
    L17:
        if (r4 == 0) goto L19;
        return r4;
    L19:
        return ZeusTransformUtils.getIdentifier(ZeusTransformUtils.getResources(this.l, "com.obric.memorydata.plugin"), r7, OaidModel.KEY_ID, this.l.getPackageName(), "com.obric.memorydata.plugin");
    L21:
        r4 = R.id.class.getField(r7).getInt(null);     // Catch: Exception -> L20
        goto L17
    L5:
        r0 = null;
        goto L6
    }

    private int[] d(String r6) {
        String[] r7 = r6.split(",");
        int[] r0 = new int[r7.length];
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r1 >= r7.length) goto L10;
        int r3 = c(r7[r1].trim());
        if (r3 == 0) goto L8;
        r0[r2] = r3;
        r2 = r2 + 1;
    L8:
        r1 = r1 + 1;
        goto L4
    L10:
        if (r2 != r7.length) goto L12;
        return r0;
    L12:
        return Arrays.copyOf(r0, r2);
    }

    public void a(AttributeSet r7) {
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L19;
        TypedArray r9 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes(r8, R.styleable.ConstraintLayout_Layout);
        int r0 = r9.getIndexCount();
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L13;
        int r2 = r9.getIndex(r1);
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_constraint_referenced_ids, "styleable", "ConstraintLayout_Layout_constraint_referenced_ids")) goto L10;
        String r3 = r9.getString(r2);
        this.o = r3;
        setIds(r3);
    L12:
        r1 = r1 + 1;
        goto L5
    L10:
        if (r2 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_constraint_referenced_tags, "styleable", "ConstraintLayout_Layout_constraint_referenced_tags")) goto L12;
        String r4 = r9.getString(r2);
        this.p = r4;
        setReferenceTags(r4);
        goto L12
    L13:
        r9.recycle();
        return;
    }

    public void a(ConstraintWidget r1, boolean r2) {
    }

    public void a(com.obric.oui.constraintlayout.core.widgets.d r4, g r5, SparseArray<ConstraintWidget> r6) {
        g r7 = (g) ZeusTransformUtils.wrapperContextForParams(r5, g.class, "com.obric.memorydata.plugin");
        r7.j();
        int r8 = 0;
    L4:
        if (r8 >= this.k) goto L6;
        r7.a((ConstraintWidget) ZeusTransformUtils.preCheckCast(r6.get(this.j[r8]), ConstraintWidget.class, "com.obric.memorydata.plugin"));
        r8 = r8 + 1;
        goto L4
    }

    public void a(ConstraintLayout r1) {
    }

    public void a(b.a r3, h r4, ConstraintLayout.LayoutParams r5, SparseArray<ConstraintWidget> r6) {
        if (r3.e.ak == null) goto L6;
        setReferencedIds(r3.e.ak);
    L11:
        if (r4 == null) goto L21;
        r4.j();
        if (r3.e.ak == null) goto L25;
        int r2 = 0;
    L16:
        if (r2 >= r3.e.ak.length) goto L26;
        ConstraintWidget r7 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r6.get(r3.e.ak[r2]), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L20;
        r4.a(r7);
    L20:
        r2 = r2 + 1;
        goto L16
    L26:
        return;
    L25:
        return;
    L21:
        return;
    L6:
        if (r3.e.al == null) goto L11;
        if (r3.e.al.length() <= 0) goto L10;
        b.C0744b r8 = r3.e;
        r8.ak = d(r3.e.al);
        goto L11
    L10:
        r3.e.ak = null;
        goto L11
    }

    public void b(ConstraintLayout r1) {
    }

    public void c(ConstraintLayout r1) {
    }

    public void d() {
        if (this.m != null) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r0 = getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r0, ConstraintLayout.LayoutParams.class) == false) goto L9;
        ConstraintLayout.LayoutParams r1 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r0, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        r1.av = (ConstraintWidget) ZeusTransformUtils.preCheckCast(this.m, ConstraintWidget.class, "com.obric.memorydata.plugin");
        return;
    }

    public void d(ConstraintLayout r6) {
        int r0 = getVisibility();
        float r1 = getElevation();
        int r2 = 0;
    L4:
        if (r2 >= this.k) goto L11;
        View r3 = r6.getViewById(this.j[r2]);
        if (r3 == null) goto L10;
        r3.setVisibility(r0);
        if (r1 <= 0.0f) goto L10;
        r3.setTranslationZ(r3.getTranslationZ() + r1);
    L10:
        r2 = r2 + 1;
        goto L4
    }

    public void e() {
        ViewParent r0 = getParent();
        if (r0 != null) goto L5;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r0, ConstraintLayout.class) == false) goto L9;
        d((ConstraintLayout) ZeusTransformUtils.preCheckCast(r0, ConstraintLayout.class, "com.obric.memorydata.plugin"));
        return;
    }

    public void e(ConstraintLayout r6) {
        if (isInEditMode() == false) goto L5;
        setIds(this.o);
    L5:
        g r0 = this.m;
        if (r0 != null) goto L8;
        return;
    L8:
        r0.j();
        int r1 = 0;
    L10:
        if (r1 >= this.k) goto L19;
        int r2 = this.j[r1];
        View r3 = r6.getViewById(r2);
        if (r3 != null) goto L16;
        String r4 = (String) ZeusTransformUtils.preCheckCast(this.q.get(Integer.valueOf(r2)), String.class, "com.obric.memorydata.plugin");
        int r5 = a(r6, r4);
        if (r5 == 0) goto L16;
        this.j[r1] = r5;
        this.q.put(Integer.valueOf(r5), r4);
        r3 = r6.getViewById(r5);
    L16:
        if (r3 == null) goto L18;
        this.m.a(r6.getViewWidget(r3));
    L18:
        r1 = r1 + 1;
        goto L10
    L19:
        this.m.a(r6.mLayoutWidget);
    }

    public View[] f(ConstraintLayout r4) {
        View[] r0 = this.f13744a;
        if (r0 != null) goto L5;
    L6:
        this.f13744a = new View[this.k];
    L7:
        int r1 = 0;
    L9:
        if (r1 >= this.k) goto L12;
        int r2 = this.j[r1];
        this.f13744a[r1] = r4.getViewById(r2);
        r1 = r1 + 1;
        goto L9
    L12:
        return this.f13744a;
    L5:
        if (r0.length == this.k) goto L7;
        goto L6
    }

    public void g(ConstraintLayout r1) {
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.j, this.k);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String r0 = this.o;
        if (r0 == null) goto L5;
        setIds(r0);
    L5:
        String r1 = this.p;
        if (r1 == null) goto L9;
        setReferenceTags(r1);
        return;
    }

    @Override // android.view.View
    public void onDraw(Canvas r1) {
    }

    @Override // android.view.View
    public void onMeasure(int r2, int r3) {
        if (this.n == false) goto L5;
        super.onMeasure(r2, r3);
        return;
    L5:
        setMeasuredDimension(0, 0);
    }

    public void setIds(String r4) {
        this.o = r4;
        if (r4 != null) goto L5;
        return;
    L5:
        int r0 = 0;
        this.k = 0;
    L6:
        int r1 = r4.indexOf(44, r0);
        if (r1 == (-1)) goto L8;
        a(r4.substring(r0, r1));
        r0 = r1 + 1;
        goto L6
    L8:
        a(r4.substring(r0));
    }

    public void setReferenceTags(String r4) {
        this.p = r4;
        if (r4 != null) goto L5;
        return;
    L5:
        int r0 = 0;
        this.k = 0;
    L6:
        int r1 = r4.indexOf(44, r0);
        if (r1 == (-1)) goto L8;
        b(r4.substring(r0, r1));
        r0 = r1 + 1;
        goto L6
    L8:
        b(r4.substring(r0));
    }

    public void setReferencedIds(int[] r3) {
        this.o = null;
        int r0 = 0;
        this.k = 0;
    L4:
        if (r0 >= r3.length) goto L6;
        a(r3[r0]);
        r0 = r0 + 1;
        goto L4
    }

    @Override // android.view.View
    public void setTag(int r1, Object r2) {
        super.setTag(r1, r2);
        if (r2 == null) goto L5;
        return;
    L5:
        if (this.o != null) goto L9;
        a(r1);
        return;
    }
}
