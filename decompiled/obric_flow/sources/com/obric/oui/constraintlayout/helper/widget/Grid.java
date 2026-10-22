package com.obric.oui.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.internal.view.SupportMenu;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.constraintlayout.widget.R$styleable;
import com.obric.oui.constraintlayout.widget.VirtualLayout;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: loaded from: classes3.dex */
public class Grid extends VirtualLayout {
    public final HashSet A;
    public int[] B;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View[] f12622l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ConstraintLayout f12623m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f12624n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f12625o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f12626p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f12627q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f12628r;
    public String s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f12629t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f12630u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f12631v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f12632w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f12633x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f12634y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean[][] f12635z;

    public Grid(Context r5) {
        super(r5);
        this.f12634y = 0;
        this.A = new HashSet();
    }

    public static int[][] B(String r10) {
        String[] r11 = r10.split(",");
        int[][] r5 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{r11.length, 3});
        int r12 = 0;
    L4:
        if (r12 >= r11.length) goto L6;
        String[] r13 = r11[r12].trim().split(":");
        String[] r14 = r13[1].split("x");
        r5[r12][0] = Integer.parseInt(r13[0]);
        r5[r12][1] = Integer.parseInt(r14[0]);
        r5[r12][2] = Integer.parseInt(r14[1]);
        r12 = r12 + 1;
        goto L4
    L6:
        return r5;
    }

    public static float[] C(int r5, String r10) {
        float[] r11 = null;
        if (r10 != null) goto L5;
    L13:
        return r11;
    L5:
        if (r10.trim().isEmpty() == true) goto L13;
        String[] r12 = r10.split(",");
        if (r12.length == r5) goto L10;
        return null;
    L10:
        r11 = new float[r5];
        int r13 = 0;
    L11:
        if (r13 >= r5) goto L13;
        r11[r13] = Float.parseFloat(r12[r13].trim());
        r13 = r13 + 1;
        goto L11
    }

    private int getNextPosition() {
        boolean r5 = false;
        int r10 = 0;
    L3:
        if (r5 == true) goto L12;
        r10 = this.f12634y;
        if (r10 >= (this.f12624n * this.f12626p)) goto L6;
        int r11 = x(r10);
        int r12 = w(this.f12634y);
        boolean[] r13 = this.f12635z[r11];
        if (r13[r12] == false) goto L11;
        r13[r12] = false;
        r5 = true;
    L11:
        this.f12634y++;
        goto L3
    L6:
        return -1;
    L12:
        return r10;
    }

    public static void s(View r5) {
        ConstraintLayout.LayoutParams r10 = (ConstraintLayout.LayoutParams) r5.getLayoutParams();
        r10.H = -1.0f;
        r10.f = -1;
        r10.e = -1;
        r10.g = -1;
        r10.f13010h = -1;
        ((ViewGroup.MarginLayoutParams) r10).leftMargin = -1;
        r5.setLayoutParams(r10);
    }

    public static void t(View r5) {
        ConstraintLayout.LayoutParams r10 = (ConstraintLayout.LayoutParams) r5.getLayoutParams();
        r10.I = -1.0f;
        r10.f13013j = -1;
        r10.f13012i = -1;
        r10.f13015k = -1;
        r10.f13017l = -1;
        ((ViewGroup.MarginLayoutParams) r10).topMargin = -1;
        r5.setLayoutParams(r10);
    }

    public final View A() {
        View r5 = new View(getContext());
        r5.setId(View.generateViewId());
        r5.setVisibility(4);
        ConstraintLayout.LayoutParams r10 = new ConstraintLayout.LayoutParams(0, 0);
        this.f12623m.addView(r5, r10);
        return r5;
    }

    public final void D() {
        int r5 = this.f12625o;
        if (r5 == 0) goto L8;
        int r10 = this.f12627q;
        if (r10 == 0) goto L8;
        this.f12624n = r5;
        this.f12626p = r10;
        return;
    L8:
        int r11 = this.f12627q;
        if (r11 <= 0) goto L11;
        this.f12626p = r11;
        this.f12624n = ((this.f12985b + r11) - 1) / r11;
        return;
    L11:
        if (r5 <= 0) goto L13;
        this.f12624n = r5;
        this.f12626p = ((this.f12985b + r5) - 1) / r5;
        return;
    L13:
        int r12 = (int) (Math.sqrt(this.f12985b) + 1.5d);
        this.f12624n = r12;
        this.f12626p = ((this.f12985b + r12) - 1) / r12;
    }

    public String getColumnWeights() {
        return this.f12630u;
    }

    public int getColumns() {
        return this.f12627q;
    }

    public float getHorizontalGaps() {
        return this.f12631v;
    }

    public int getOrientation() {
        return this.f12633x;
    }

    public String getRowWeights() {
        return this.f12629t;
    }

    public int getRows() {
        return this.f12625o;
    }

    public String getSkips() {
        return this.s;
    }

    public String getSpans() {
        return this.f12628r;
    }

    public float getVerticalGaps() {
        return this.f12632w;
    }

    @Override // com.obric.oui.constraintlayout.widget.VirtualLayout, com.obric.oui.constraintlayout.widget.ConstraintHelper
    public final void k(AttributeSet r10) {
        super.k(r10);
        this.e = true;
        if (r10 == null) goto L55;
        TypedArray r11 = getContext().obtainStyledAttributes(r10, R$styleable.Grid);
        int r5 = r11.getIndexCount();
        int r12 = 0;
    L5:
        if (r12 >= r5) goto L40;
        int r13 = r11.getIndex(r12);
        if (r13 != R$styleable.Grid_grid_rows) goto L10;
        this.f12625o = r11.getInteger(r13, 0);
    L39:
        r12 = r12 + 1;
        goto L5
    L10:
        if (r13 != R$styleable.Grid_grid_columns) goto L13;
        this.f12627q = r11.getInteger(r13, 0);
        goto L39
    L13:
        if (r13 != R$styleable.Grid_grid_spans) goto L16;
        this.f12628r = r11.getString(r13);
        goto L39
    L16:
        if (r13 != R$styleable.Grid_grid_skips) goto L19;
        this.s = r11.getString(r13);
        goto L39
    L19:
        if (r13 != R$styleable.Grid_grid_rowWeights) goto L22;
        this.f12629t = r11.getString(r13);
        goto L39
    L22:
        if (r13 != R$styleable.Grid_grid_columnWeights) goto L25;
        this.f12630u = r11.getString(r13);
        goto L39
    L25:
        if (r13 != R$styleable.Grid_grid_orientation) goto L28;
        this.f12633x = r11.getInt(r13, 0);
        goto L39
    L28:
        if (r13 != R$styleable.Grid_grid_horizontalGaps) goto L31;
        this.f12631v = r11.getDimension(r13, 0.0f);
        goto L39
    L31:
        if (r13 != R$styleable.Grid_grid_verticalGaps) goto L34;
        this.f12632w = r11.getDimension(r13, 0.0f);
        goto L39
    L34:
        if (r13 != R$styleable.Grid_grid_validateInputs) goto L37;
        r11.getBoolean(r13, false);
        goto L39
    L37:
        if (r13 != R$styleable.Grid_grid_useRtl) goto L39;
        r11.getBoolean(r13, false);
        goto L39
    L40:
        D();
        y();
        r11.recycle();
        return;
    }

    @Override // com.obric.oui.constraintlayout.widget.VirtualLayout, com.obric.oui.constraintlayout.widget.ConstraintHelper, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f12623m = (ConstraintLayout) getParent();
        v(false);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper, android.view.View
    public final void onDraw(Canvas r17) {
        if (isInEditMode() == true) goto L5;
        return;
    L5:
        Paint r5 = new Paint();
        r5.setColor(SupportMenu.CATEGORY_MASK);
        r5.setStyle(Paint.Style.STROKE);
        int r10 = getTop();
        int r11 = getLeft();
        int r12 = getBottom();
        int r13 = getRight();
        View[] r14 = this.f12622l;
        int r15 = r14.length;
        int r16 = 0;
    L6:
        if (r16 >= r15) goto L8;
        View r18 = r14[r16];
        int r19 = r18.getLeft() - r11;
        int r110 = r18.getTop() - r10;
        int r20 = r18.getRight() - r11;
        int r111 = r18.getBottom() - r10;
        r17.drawRect(r19, 0.0f, r20, r12 - r10, r5);
        r17.drawRect(0.0f, r110, r13 - r11, r111, r5);
        r16 = r16 + 1;
        goto L6
    }

    public void setColumnWeights(String r5) {
        String r10 = this.f12630u;
        if (r10 != null) goto L5;
    L7:
        this.f12630u = r5;
        v(true);
        invalidate();
        return;
    L5:
        if (r10.equals(r5) == false) goto L7;
    }

    public void setColumns(int r5) {
        if (r5 <= 50) goto L6;
        return;
    L6:
        if (this.f12627q != r5) goto L8;
        return;
    L8:
        this.f12627q = r5;
        D();
        y();
        v(false);
        invalidate();
    }

    public void setHorizontalGaps(float r5) {
        if (r5 >= 0.0f) goto L6;
        return;
    L6:
        if (this.f12631v != r5) goto L8;
        return;
    L8:
        this.f12631v = r5;
        v(true);
        invalidate();
    }

    public void setOrientation(int r5) {
        if (r5 == 0) goto L7;
        if (r5 == 1) goto L7;
        return;
    L7:
        if (this.f12633x != r5) goto L9;
        return;
    L9:
        this.f12633x = r5;
        v(true);
        invalidate();
    }

    public void setRowWeights(String r5) {
        String r10 = this.f12629t;
        if (r10 != null) goto L5;
    L7:
        this.f12629t = r5;
        v(true);
        invalidate();
        return;
    L5:
        if (r10.equals(r5) == false) goto L7;
    }

    public void setRows(int r5) {
        if (r5 <= 50) goto L6;
        return;
    L6:
        if (this.f12625o != r5) goto L8;
        return;
    L8:
        this.f12625o = r5;
        D();
        y();
        v(false);
        invalidate();
    }

    public void setSkips(String r5) {
        String r10 = this.s;
        if (r10 != null) goto L5;
    L7:
        this.s = r5;
        v(true);
        invalidate();
        return;
    L5:
        if (r10.equals(r5) == false) goto L7;
    }

    public void setSpans(CharSequence r5) {
        String r10 = this.f12628r;
        if (r10 != null) goto L5;
    L7:
        this.f12628r = r5.toString();
        v(true);
        invalidate();
        return;
    L5:
        if (r10.contentEquals(r5) == false) goto L7;
    }

    public void setVerticalGaps(float r5) {
        if (r5 >= 0.0f) goto L6;
        return;
    L6:
        if (this.f12632w != r5) goto L8;
        return;
    L8:
        this.f12632w = r5;
        v(true);
        invalidate();
    }

    public final void u(View r5, int r10, int r11, int r12, int r13) {
        ConstraintLayout.LayoutParams r14 = (ConstraintLayout.LayoutParams) r5.getLayoutParams();
        int[] r15 = this.B;
        r14.e = r15[r11];
        r14.f13012i = r15[r10];
        r14.f13010h = r15[(r11 + r13) - 1];
        r14.f13017l = r15[(r10 + r12) - 1];
        r5.setLayoutParams(r14);
    }

    public final void v(boolean r15) {
        if (this.f12623m != null) goto L5;
        return;
    L5:
        if (this.f12624n >= 1) goto L7;
        return;
    L7:
        if (this.f12626p < 1) goto L149;
        HashSet r5 = this.A;
        int r10 = 0;
        if (r15 == false) goto L20;
        int r16 = 0;
    L13:
        if (r16 >= this.f12635z.length) goto L19;
        int r11 = 0;
    L15:
        boolean[][] r12 = this.f12635z;
        if (r11 >= r12[0].length) goto L18;
        r12[r16][r11] = true;
        r11 = r11 + 1;
        goto L15
    L18:
        r16 = r16 + 1;
        goto L13
    L19:
        r5.clear();
    L20:
        this.f12634y = 0;
        int r17 = Math.max(this.f12624n, this.f12626p);
        View[] r13 = this.f12622l;
        if (r13 != null) goto L27;
        this.f12622l = new View[r17];
        int r14 = 0;
    L23:
        View[] r18 = this.f12622l;
        if (r14 >= r18.length) goto L40;
        r18[r14] = A();
        r14 = r14 + 1;
    L40:
        this.B = new int[r17];
        int r19 = 0;
    L41:
        View[] r20 = this.f12622l;
        if (r19 >= r20.length) goto L44;
        this.B[r19] = r20[r19].getId();
        r19 = r19 + 1;
        goto L41
    L44:
        int r110 = getId();
        int r21 = Math.max(this.f12624n, this.f12626p);
        float[] r22 = C(this.f12624n, this.f12629t);
        if (this.f12624n != 1) goto L47;
        ConstraintLayout.LayoutParams r23 = (ConstraintLayout.LayoutParams) this.f12622l[0].getLayoutParams();
        t(this.f12622l[0]);
        r23.f13012i = r110;
        r23.f13017l = r110;
        this.f12622l[0].setLayoutParams(r23);
    L65:
        int r111 = getId();
        int r24 = Math.max(this.f12624n, this.f12626p);
        float[] r25 = C(this.f12626p, this.f12630u);
        ConstraintLayout.LayoutParams r26 = (ConstraintLayout.LayoutParams) this.f12622l[0].getLayoutParams();
        if (this.f12626p != 1) goto L68;
        s(this.f12622l[0]);
        r26.e = r111;
        r26.f13010h = r111;
        this.f12622l[0].setLayoutParams(r26);
    L86:
        String r112 = this.s;
        if (r112 != null) goto L89;
    L99:
        String r113 = this.f12628r;
        if (r113 != null) goto L102;
    L112:
        View[] r114 = j(this.f12623m);
    L114:
        if (r10 >= this.f12985b) goto L150;
        if (r5.contains(Integer.valueOf(this.f12984a[r10])) == true) goto L122;
        int r27 = getNextPosition();
        int r28 = x(r27);
        int r29 = w(r27);
        if (r27 == (-1)) goto L151;
        u(r114[r10], r28, r29, 1, 1);
        goto L122
    L151:
        return;
    L122:
        r10 = r10 + 1;
        goto L114
    L150:
        return;
    L102:
        if (r113.trim().isEmpty() == true) goto L112;
        int[][] r115 = B(this.f12628r);
        if (r115 == null) goto L112;
        int[] r30 = this.f12984a;
        View[] r31 = j(this.f12623m);
        int r32 = 0;
    L107:
        if (r32 >= r115.length) goto L112;
        int r116 = x(r115[r32][0]);
        int r117 = w(r115[r32][0]);
        int[] r33 = r115[r32];
        if (z(r116, r117, r33[1], r33[2]) == false) goto L112;
        View r34 = r31[r32];
        int[] r35 = r115[r32];
        u(r34, r116, r117, r35[1], r35[2]);
        r5.add(Integer.valueOf(r30[r32]));
        r32 = r32 + 1;
        goto L107
    L89:
        if (r112.trim().isEmpty() == true) goto L99;
        int[][] r118 = B(this.s);
        if (r118 == null) goto L99;
        int r36 = 0;
    L94:
        if (r36 >= r118.length) goto L99;
        int r37 = x(r118[r36][0]);
        int r38 = w(r118[r36][0]);
        int[] r39 = r118[r36];
        if (z(r37, r38, r39[1], r39[2]) == false) goto L99;
        r36 = r36 + 1;
        goto L94
    L68:
        int r40 = 0;
    L69:
        int r41 = this.f12626p;
        if (r40 >= r41) goto L84;
        ConstraintLayout.LayoutParams r42 = (ConstraintLayout.LayoutParams) this.f12622l[r40].getLayoutParams();
        s(this.f12622l[r40]);
        if (r25 == null) goto L74;
        r42.H = r25[r40];
    L74:
        if (r40 <= 0) goto L76;
        r42.f = this.B[r40 - 1];
    L78:
        if (r40 >= (this.f12626p - 1)) goto L80;
        r42.g = this.B[r40 + 1];
    L81:
        if (r40 <= 0) goto L83;
        ((ViewGroup.MarginLayoutParams) r42).leftMargin = (int) this.f12631v;
    L83:
        this.f12622l[r40].setLayoutParams(r42);
        r40 = r40 + 1;
        goto L69
    L80:
        r42.f13010h = r111;
        goto L81
    L76:
        r42.e = r111;
    L84:
        if (r41 >= r24) goto L86;
        ConstraintLayout.LayoutParams r43 = (ConstraintLayout.LayoutParams) this.f12622l[r41].getLayoutParams();
        s(this.f12622l[r41]);
        r43.e = r111;
        r43.f13010h = r111;
        this.f12622l[r41].setLayoutParams(r43);
        r41 = r41 + 1;
        goto L84
    L47:
        int r44 = 0;
    L48:
        int r45 = this.f12624n;
        if (r44 >= r45) goto L63;
        ConstraintLayout.LayoutParams r46 = (ConstraintLayout.LayoutParams) this.f12622l[r44].getLayoutParams();
        t(this.f12622l[r44]);
        if (r22 == null) goto L53;
        r46.I = r22[r44];
    L53:
        if (r44 <= 0) goto L55;
        r46.f13013j = this.B[r44 - 1];
    L57:
        if (r44 >= (this.f12624n - 1)) goto L59;
        r46.f13015k = this.B[r44 + 1];
    L60:
        if (r44 <= 0) goto L62;
        ((ViewGroup.MarginLayoutParams) r46).topMargin = (int) this.f12631v;
    L62:
        this.f12622l[r44].setLayoutParams(r46);
        r44 = r44 + 1;
        goto L48
    L59:
        r46.f13017l = r110;
        goto L60
    L55:
        r46.f13012i = r110;
    L63:
        if (r45 >= r21) goto L65;
        ConstraintLayout.LayoutParams r47 = (ConstraintLayout.LayoutParams) this.f12622l[r45].getLayoutParams();
        t(this.f12622l[r45]);
        r47.f13012i = r110;
        r47.f13017l = r110;
        this.f12622l[r45].setLayoutParams(r47);
        r45 = r45 + 1;
        goto L63
    L27:
        if (r17 == r13.length) goto L40;
        View[] r48 = new View[r17];
        int r49 = 0;
    L29:
        if (r49 >= r17) goto L35;
        View[] r50 = this.f12622l;
        if (r49 >= r50.length) goto L33;
        r48[r49] = r50[r49];
    L34:
        r49 = r49 + 1;
        goto L29
    L33:
        r48[r49] = A();
        goto L34
    L35:
        int r51 = r17;
    L36:
        View[] r52 = this.f12622l;
        if (r51 >= r52.length) goto L39;
        this.f12623m.removeView(r52[r51]);
        r51 = r51 + 1;
        goto L36
    L39:
        this.f12622l = r48;
        goto L40
    }

    public final int w(int r5) {
        if (this.f12633x != 1) goto L7;
        return r5 / this.f12624n;
    L7:
        return r5 % this.f12626p;
    }

    public final int x(int r5) {
        if (this.f12633x != 1) goto L7;
        return r5 % this.f12624n;
    L7:
        return r5 / this.f12626p;
    }

    public final void y() {
        int r5 = 0;
        boolean[][] r10 = (boolean[][]) Array.newInstance(Boolean.TYPE, new int[]{this.f12624n, this.f12626p});
        this.f12635z = r10;
        int r11 = r10.length;
    L3:
        if (r5 >= r11) goto L5;
        Arrays.fill(r10[r5], true);
        r5 = r5 + 1;
        goto L3
    }

    public final boolean z(int r10, int r11, int r12, int r13) {
        int r5 = r10;
    L4:
        if (r5 >= (r10 + r12)) goto L18;
        int r14 = r11;
    L7:
        if (r14 >= (r11 + r13)) goto L17;
        boolean[][] r15 = this.f12635z;
        if (r5 >= r15.length) goto L16;
        if (r14 >= r15[0].length) goto L16;
        boolean[] r16 = r15[r5];
        if (r16[r14] == false) goto L16;
        r16[r14] = false;
        r14 = r14 + 1;
    L16:
        return false;
    L17:
        r5 = r5 + 1;
        goto L4
    L18:
        return true;
    }

    public Grid(Context r5, AttributeSet r10) {
        super(r5, r10);
        this.f12634y = 0;
        this.A = new HashSet();
    }

    public Grid(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.f12634y = 0;
        this.A = new HashSet();
    }
}
