package com.obric.oui.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.obric.memorydata.plugin.R;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.constraintlayout.widget.VirtualLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes5.dex */
public class Grid extends VirtualLayout {
    private boolean A;
    private boolean[][] B;
    private int[] C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ConstraintLayout f13653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Set<Integer> f13654b;
    private final int c;
    private final int d;
    private View[] e;
    private int f;
    private int g;
    private int h;
    private int i;
    private String r;
    private String s;
    private String t;
    private String u;
    private float v;
    private float w;
    private int x;
    private int y;
    private boolean z;

    public Grid(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
        this.c = 50;
        this.d = 50;
        this.y = 0;
        this.f13654b = new HashSet();
    }

    public Grid(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"));
        this.c = 50;
        this.d = 50;
        this.y = 0;
        this.f13654b = new HashSet();
    }

    public Grid(Context r3, AttributeSet r4, int r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), r5);
        this.c = 50;
        this.d = 50;
        this.y = 0;
        this.f13654b = new HashSet();
    }

    private int a(int r3) {
        if (this.x != 1) goto L7;
        return r3 % this.f;
    L7:
        return r3 / this.h;
    }

    private ConstraintLayout.LayoutParams a(View r2) {
        return (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
    }

    private void a() {
        int r0 = this.g;
        if (r0 == 0) goto L8;
        int r1 = this.i;
        if (r1 == 0) goto L8;
        this.f = r0;
        this.h = r1;
        return;
    L8:
        int r2 = this.i;
        if (r2 <= 0) goto L11;
        this.h = r2;
        this.f = ((this.k + this.h) - 1) / this.i;
        return;
    L11:
        if (r0 <= 0) goto L13;
        this.f = r0;
        int r3 = this.k;
        int r4 = this.g;
    L14:
        this.h = ((r3 + r4) - 1) / r4;
        return;
    L13:
        this.f = (int) (Math.sqrt(this.k) + 1.5d);
        r3 = this.k;
        r4 = this.f;
        goto L14
    }

    private void a(View r3, int r4, int r5, int r6, int r7) {
        ConstraintLayout.LayoutParams r0 = a(r3);
        r0.e = this.C[r5];
        r0.i = this.C[r4];
        r0.h = this.C[(r5 + r7) - 1];
        r0.l = this.C[(r4 + r6) - 1];
        r3.setLayoutParams(r0);
    }

    private boolean a(int r6, int r7, int r8, int r9) {
        int r0 = r6;
    L4:
        if (r0 >= (r6 + r8)) goto L18;
        int r1 = r7;
    L7:
        if (r1 >= (r7 + r9)) goto L17;
        boolean[][] r2 = this.B;
        if (r0 >= r2.length) goto L16;
        if (r1 >= r2[0].length) goto L16;
        if (r2[r0][r1] == false) goto L16;
        r2[r0][r1] = false;
        r1 = r1 + 1;
    L16:
        return false;
    L17:
        r0 = r0 + 1;
        goto L4
    L18:
        return true;
    }

    private boolean a(CharSequence r2) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        return true;
    }

    private boolean a(String r1) {
        return true;
    }

    private boolean a(boolean r6) {
        if (this.f13653a != null) goto L5;
        return false;
    L5:
        if (this.f >= 1) goto L7;
        return false;
    L7:
        if (this.h < 1) goto L45;
        if (r6 == false) goto L19;
        int r7 = 0;
    L12:
        if (r7 >= this.B.length) goto L18;
        int r0 = 0;
    L14:
        boolean[][] r3 = this.B;
        if (r0 >= r3[0].length) goto L17;
        r3[r7][r0] = true;
        r0 = r0 + 1;
        goto L14
    L17:
        r7 = r7 + 1;
        goto L12
    L18:
        this.f13654b.clear();
    L19:
        this.y = 0;
        i();
        String r8 = this.s;
        if (r8 != null) goto L22;
    L26:
        boolean r9 = true;
    L27:
        String r1 = this.r;
        if (r1 == null) goto L35;
        if (r1.trim().isEmpty() == true) goto L35;
        int[][] r2 = b(this.r);
        if (r2 == null) goto L35;
        r9 = r9 & a(this.j, r2);
    L35:
        if ((r9 & c()) == true) goto L39;
        if (this.z == false) goto L39;
        return false;
    L39:
        return true;
    L22:
        if (r8.trim().isEmpty() == true) goto L26;
        int[][] r10 = b(this.s);
        if (r10 == null) goto L26;
        r9 = a(r10) & true;
        goto L27
    L45:
        return false;
    }

    private boolean a(int[] r12, int[][] r13) {
        View[] r0 = f(this.f13653a);
        int r2 = 0;
    L4:
        if (r2 >= r13.length) goto L9;
        int r7 = a(r13[r2][0]);
        int r8 = b(r13[r2][0]);
        if (a(r7, r8, r13[r2][1], r13[r2][2]) == false) goto L7;
        a(r0[r2], r7, r8, r13[r2][1], r13[r2][2]);
        this.f13654b.add(Integer.valueOf(r12[r2]));
        r2 = r2 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    private boolean a(int[][] r8) {
        int r1 = 0;
    L4:
        if (r1 >= r8.length) goto L9;
        if (a(a(r8[r1][0]), b(r8[r1][0]), r8[r1][1], r8[r1][2]) == false) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    private float[] a(int r3, String r4) {
        float[] r2 = null;
        if (r4 != null) goto L5;
    L13:
        return r2;
    L5:
        if (r4.trim().isEmpty() == true) goto L13;
        String[] r5 = r4.split(",");
        if (r5.length == r3) goto L10;
        return null;
    L10:
        r2 = new float[r3];
        int r0 = 0;
    L11:
        if (r0 >= r3) goto L13;
        r2[r0] = Float.parseFloat(r5[r0].trim());
        r0 = r0 + 1;
        goto L11
    }

    private int b(int r3) {
        if (this.x != 1) goto L7;
        return r3 / this.f;
    L7:
        return r3 % this.h;
    }

    private void b() {
        int r1 = 0;
        boolean[][] r0 = (boolean[][]) Array.newInstance(boolean.class, new int[]{this.f, this.h});
        this.B = r0;
        int r4 = r0.length;
    L3:
        if (r1 >= r4) goto L5;
        Arrays.fill(r0[r1], true);
        r1 = r1 + 1;
        goto L3
    }

    private void b(View r2) {
        ConstraintLayout.LayoutParams r1 = a(r2);
        r1.M = -1.0f;
        r1.j = -1;
        r1.i = -1;
        r1.k = -1;
        r1.l = -1;
        r1.topMargin = -1;
        r2.setLayoutParams(r1);
    }

    private int[][] b(String r8) {
        if (a(r8) == true) goto L6;
        return null;
    L6:
        String[] r7 = r8.split(",");
        int[][] r9 = (int[][]) Array.newInstance(int.class, new int[]{r7.length, 3});
        int r2 = 0;
    L8:
        if (r2 >= r7.length) goto L10;
        String[] r4 = r7[r2].trim().split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        String[] r5 = r4[1].split("x");
        r9[r2][0] = Integer.parseInt(r4[0]);
        r9[r2][1] = Integer.parseInt(r5[0]);
        r9[r2][2] = Integer.parseInt(r5[1]);
        r2 = r2 + 1;
        goto L8
    L10:
        return r9;
    }

    private void c(View r2) {
        ConstraintLayout.LayoutParams r1 = a(r2);
        r1.L = -1.0f;
        r1.f = -1;
        r1.e = -1;
        r1.g = -1;
        r1.h = -1;
        r1.leftMargin = -1;
        r2.setLayoutParams(r1);
    }

    private boolean c() {
        View[] r0 = f(this.f13653a);
        int r2 = 0;
    L4:
        if (r2 >= this.k) goto L13;
        if (this.f13654b.contains(Integer.valueOf(this.j[r2])) == true) goto L12;
        int r3 = getNextPosition();
        int r6 = a(r3);
        int r7 = b(r3);
        if (r3 == (-1)) goto L10;
        a(r0[r2], r6, r7, 1, 1);
        goto L12
    L10:
        return false;
    L12:
        r2 = r2 + 1;
        goto L4
    L13:
        return true;
    }

    private void f() {
        int r0 = getId();
        int r1 = Math.max(this.f, this.h);
        float[] r2 = a(this.h, this.u);
        int r4 = 0;
        ConstraintLayout.LayoutParams r3 = a(this.e[0]);
        if (this.h != 1) goto L6;
        c(this.e[0]);
        r3.e = r0;
        r3.h = r0;
        this.e[0].setLayoutParams(r3);
        return;
    L6:
        int r5 = this.h;
        if (r4 >= r5) goto L21;
        ConstraintLayout.LayoutParams r6 = a(this.e[r4]);
        c(this.e[r4]);
        if (r2 == null) goto L11;
        r6.L = r2[r4];
    L11:
        if (r4 <= 0) goto L13;
        r6.f = this.C[r4 - 1];
    L15:
        if (r4 >= (this.h - 1)) goto L17;
        r6.g = this.C[r4 + 1];
    L18:
        if (r4 <= 0) goto L20;
        r6.leftMargin = (int) this.v;
    L20:
        this.e[r4].setLayoutParams(r6);
        r4 = r4 + 1;
        goto L6
    L17:
        r6.h = r0;
        goto L18
    L13:
        r6.e = r0;
    L21:
        if (r5 >= r1) goto L23;
        ConstraintLayout.LayoutParams r7 = a(this.e[r5]);
        c(this.e[r5]);
        r7.e = r0;
        r7.h = r0;
        this.e[r5].setLayoutParams(r7);
        r5 = r5 + 1;
        goto L21
    }

    private void g() {
        int r0 = getId();
        int r1 = Math.max(this.f, this.h);
        float[] r2 = a(this.f, this.t);
        int r4 = 0;
        if (this.f != 1) goto L6;
        ConstraintLayout.LayoutParams r3 = a(this.e[0]);
        b(this.e[0]);
        r3.i = r0;
        r3.l = r0;
        this.e[0].setLayoutParams(r3);
        return;
    L6:
        int r5 = this.f;
        if (r4 >= r5) goto L21;
        ConstraintLayout.LayoutParams r6 = a(this.e[r4]);
        b(this.e[r4]);
        if (r2 == null) goto L11;
        r6.M = r2[r4];
    L11:
        if (r4 <= 0) goto L13;
        r6.j = this.C[r4 - 1];
    L15:
        if (r4 >= (this.f - 1)) goto L17;
        r6.k = this.C[r4 + 1];
    L18:
        if (r4 <= 0) goto L20;
        r6.topMargin = (int) this.v;
    L20:
        this.e[r4].setLayoutParams(r6);
        r4 = r4 + 1;
        goto L6
    L17:
        r6.l = r0;
        goto L18
    L13:
        r6.i = r0;
    L21:
        if (r5 >= r1) goto L23;
        ConstraintLayout.LayoutParams r7 = a(this.e[r5]);
        b(this.e[r5]);
        r7.i = r0;
        r7.l = r0;
        this.e[r5].setLayoutParams(r7);
        r5 = r5 + 1;
        goto L21
    }

    private int getNextPosition() {
        boolean r1 = false;
        int r2 = 0;
    L3:
        if (r1 == true) goto L12;
        r2 = this.y;
        if (r2 >= (this.f * this.h)) goto L6;
        int r3 = a(r2);
        int r4 = b(this.y);
        boolean[][] r5 = this.B;
        if (r5[r3][r4] == false) goto L11;
        r5[r3][r4] = false;
        r1 = true;
    L11:
        this.y++;
        goto L3
    L6:
        return -1;
    L12:
        return r2;
    }

    private View h() {
        View r0 = new View((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        r0.setId(View.generateViewId());
        r0.setVisibility(4);
        ConstraintLayout.LayoutParams r1 = new ConstraintLayout.LayoutParams(0, 0);
        this.f13653a.addView(r0, r1);
        return r0;
    }

    private void i() {
        int r0 = Math.max(this.f, this.h);
        View[] r1 = this.e;
        int r2 = 0;
        if (r1 != null) goto L9;
        this.e = new View[r0];
        int r3 = 0;
    L5:
        View[] r4 = this.e;
        if (r3 >= r4.length) goto L22;
        r4[r3] = h();
        r3 = r3 + 1;
    L22:
        this.C = new int[r0];
    L23:
        View[] r5 = this.e;
        if (r2 >= r5.length) goto L26;
        this.C[r2] = r5[r2].getId();
        r2 = r2 + 1;
        goto L23
    L26:
        g();
        f();
        return;
    L9:
        if (r0 == r1.length) goto L22;
        View[] r6 = new View[r0];
        int r7 = 0;
    L11:
        if (r7 >= r0) goto L17;
        View[] r8 = this.e;
        if (r7 >= r8.length) goto L15;
        r6[r7] = r8[r7];
    L16:
        r7 = r7 + 1;
        goto L11
    L15:
        r6[r7] = h();
        goto L16
    L17:
        int r9 = r0;
    L18:
        View[] r10 = this.e;
        if (r9 >= r10.length) goto L21;
        this.f13653a.removeView(r10[r9]);
        r9 = r9 + 1;
        goto L18
    L21:
        this.e = r6;
        goto L22
    }

    @Override // com.obric.oui.constraintlayout.widget.VirtualLayout, com.obric.oui.constraintlayout.widget.ConstraintHelper
    public void a(AttributeSet r9) {
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r9, AttributeSet.class, "com.obric.memorydata.plugin");
        super.a(r10);
        this.n = true;
        if (r10 == null) goto L55;
        TypedArray r11 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes(r10, R.styleable.Grid);
        int r0 = r11.getIndexCount();
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L40;
        int r3 = r11.getIndex(r2);
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.Grid_grid_rows, "styleable", "Grid_grid_rows")) goto L10;
        this.g = r11.getInteger(r3, 0);
    L39:
        r2 = r2 + 1;
        goto L5
    L10:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.Grid_grid_columns, "styleable", "Grid_grid_columns")) goto L13;
        this.i = r11.getInteger(r3, 0);
        goto L39
    L13:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.Grid_grid_spans, "styleable", "Grid_grid_spans")) goto L16;
        this.r = r11.getString(r3);
        goto L39
    L16:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.Grid_grid_skips, "styleable", "Grid_grid_skips")) goto L19;
        this.s = r11.getString(r3);
        goto L39
    L19:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.Grid_grid_rowWeights, "styleable", "Grid_grid_rowWeights")) goto L22;
        this.t = r11.getString(r3);
        goto L39
    L22:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.Grid_grid_columnWeights, "styleable", "Grid_grid_columnWeights")) goto L25;
        this.u = r11.getString(r3);
        goto L39
    L25:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.Grid_grid_orientation, "styleable", "Grid_grid_orientation")) goto L28;
        this.x = r11.getInt(r3, 0);
        goto L39
    L28:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.Grid_grid_horizontalGaps, "styleable", "Grid_grid_horizontalGaps")) goto L31;
        this.v = r11.getDimension(r3, 0.0f);
        goto L39
    L31:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.Grid_grid_verticalGaps, "styleable", "Grid_grid_verticalGaps")) goto L34;
        this.w = r11.getDimension(r3, 0.0f);
        goto L39
    L34:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.Grid_grid_validateInputs, "styleable", "Grid_grid_validateInputs")) goto L37;
        this.z = r11.getBoolean(r3, false);
        goto L39
    L37:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.Grid_grid_useRtl, "styleable", "Grid_grid_useRtl")) goto L39;
        this.A = r11.getBoolean(r3, false);
        goto L39
    L40:
        a();
        b();
        r11.recycle();
        return;
    }

    public String getColumnWeights() {
        return this.u;
    }

    public int getColumns() {
        return this.i;
    }

    public float getHorizontalGaps() {
        return this.v;
    }

    public int getOrientation() {
        return this.x;
    }

    public String getRowWeights() {
        return this.t;
    }

    public int getRows() {
        return this.g;
    }

    public String getSkips() {
        return this.s;
    }

    public String getSpans() {
        return this.r;
    }

    public float getVerticalGaps() {
        return this.w;
    }

    @Override // com.obric.oui.constraintlayout.widget.VirtualLayout, com.obric.oui.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f13653a = (ConstraintLayout) ZeusTransformUtils.preCheckCast(getParent(), ConstraintLayout.class, "com.obric.memorydata.plugin");
        a(false);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onDraw(Canvas r17) {
        super.onDraw(r17);
        if (isInEditMode() == true) goto L5;
        return;
    L5:
        Paint r0 = new Paint();
        r0.setColor(-65536);
        r0.setStyle(Paint.Style.STROKE);
        int r7 = getTop();
        int r8 = getLeft();
        int r9 = getBottom();
        int r10 = getRight();
        View[] r11 = this.e;
        int r12 = r11.length;
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L8;
        View r1 = r11[r13];
        int r2 = r1.getLeft() - r8;
        int r14 = r1.getTop() - r7;
        int r3 = r1.getRight() - r8;
        int r15 = r1.getBottom() - r7;
        r17.drawRect(r2, 0.0f, r3, r9 - r7, r0);
        r17.drawRect(0.0f, r14, r10 - r8, r15, r0);
        r13 = r13 + 1;
        goto L6
    }

    public void setColumnWeights(String r2) {
        if (a(r2) == true) goto L5;
        return;
    L5:
        String r0 = this.u;
        if (r0 != null) goto L8;
    L10:
        this.u = r2;
        a(true);
        invalidate();
        return;
    L8:
        if (r0.equals(r2) == false) goto L10;
    }

    public void setColumns(int r2) {
        if (r2 <= 50) goto L6;
        return;
    L6:
        if (this.i != r2) goto L8;
        return;
    L8:
        this.i = r2;
        a();
        b();
        a(false);
        invalidate();
    }

    public void setHorizontalGaps(float r2) {
        if (r2 >= 0.0f) goto L6;
        return;
    L6:
        if (this.v != r2) goto L8;
        return;
    L8:
        this.v = r2;
        a(true);
        invalidate();
    }

    public void setOrientation(int r3) {
        if (r3 == 0) goto L7;
        if (r3 == 1) goto L7;
        return;
    L7:
        if (this.x != r3) goto L9;
        return;
    L9:
        this.x = r3;
        a(true);
        invalidate();
    }

    public void setRowWeights(String r2) {
        if (a(r2) == true) goto L5;
        return;
    L5:
        String r0 = this.t;
        if (r0 != null) goto L8;
    L10:
        this.t = r2;
        a(true);
        invalidate();
        return;
    L8:
        if (r0.equals(r2) == false) goto L10;
    }

    public void setRows(int r2) {
        if (r2 <= 50) goto L6;
        return;
    L6:
        if (this.g != r2) goto L8;
        return;
    L8:
        this.g = r2;
        a();
        b();
        a(false);
        invalidate();
    }

    public void setSkips(String r2) {
        if (a(r2) == true) goto L5;
        return;
    L5:
        String r0 = this.s;
        if (r0 != null) goto L8;
    L10:
        this.s = r2;
        a(true);
        invalidate();
        return;
    L8:
        if (r0.equals(r2) == false) goto L10;
    }

    public void setSpans(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (a(r4) == true) goto L5;
        return;
    L5:
        String r0 = this.r;
        if (r0 != null) goto L8;
    L10:
        this.r = r4.toString();
        a(true);
        invalidate();
        return;
    L8:
        if (r0.contentEquals(r4) == false) goto L10;
    }

    public void setVerticalGaps(float r2) {
        if (r2 >= 0.0f) goto L6;
        return;
    L6:
        if (this.w != r2) goto L8;
        return;
    L8:
        this.w = r2;
        a(true);
        invalidate();
    }
}
