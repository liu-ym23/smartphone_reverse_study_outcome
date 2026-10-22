package com.obric.oui.picker.reels.views;

import ac.k;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewParent;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.cae.R;
import he.i;
import he.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ne.g;

/* JADX INFO: loaded from: classes2.dex */
public final class WheelView extends View {
    public CharSequence A;
    public Integer B;
    public float C;
    public int D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6428b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f6429m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f6430n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f6431o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f6432p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Rect f6433q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Rect f6434r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Rect f6435s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final xd.f f6436t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final xd.f f6437u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final xd.f f6438v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final xd.f f6439w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final xd.f f6440x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final xd.f f6441y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ArrayList f6442z;

    public static final class a extends j implements ge.a<Paint> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6443a = null;

        static {
            f6443a = new a();
        }

        public a() {
            super(0);
        }

        @Override // ge.a
        public final Paint f() {
            return new Paint();
        }
    }

    public static final class b extends j implements ge.a<Paint> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f6444a = null;

        static {
            f6444a = new b();
        }

        public b() {
            super(0);
        }

        @Override // ge.a
        public final Paint f() {
            return new Paint();
        }
    }

    public static final class c extends j implements ge.a<nc.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WheelView f6445a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f6446b;

        public c(Context r8, WheelView r10) {
            this.f6445a = r10;
            this.f6446b = r8;
            super(0);
        }

        @Override // ge.a
        public final nc.b f() {
            return new nc.b(this.f6446b, this.f6445a);
        }
    }

    public static final class d extends j implements ge.a<TextPaint> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f6447a = null;

        static {
            f6447a = new d();
        }

        public d() {
            super(0);
        }

        @Override // ge.a
        public final TextPaint f() {
            TextPaint r8 = new TextPaint();
            r8.setAntiAlias(true);
            return r8;
        }
    }

    public static final class e extends j implements ge.a<TextPaint> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f6448a = null;

        static {
            f6448a = new e();
        }

        public e() {
            super(0);
        }

        @Override // ge.a
        public final TextPaint f() {
            TextPaint r8 = new TextPaint();
            r8.setAntiAlias(true);
            return r8;
        }
    }

    public static final class f extends j implements ge.a<TextPaint> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f6449a = null;

        static {
            f6449a = new f();
        }

        public f() {
            super(0);
        }

        @Override // ge.a
        public final TextPaint f() {
            TextPaint r8 = new TextPaint();
            r8.setAntiAlias(true);
            return r8;
        }
    }

    public WheelView(Context r23, AttributeSet r24) {
        i.f(r23, "context");
        super(r23, r24);
        this.f6429m = 5;
        float r8 = 343;
        this.f6430n = android.aimedia.a.a("Resources.getSystem()", 1, r8);
        float r10 = 40;
        this.f6431o = android.aimedia.a.a("Resources.getSystem()", 1, r10);
        this.f6432p = android.aimedia.a.a("Resources.getSystem()", 1, 48);
        this.f6436t = defpackage.c.R(f.f6449a);
        this.f6437u = defpackage.c.R(e.f6448a);
        this.f6438v = defpackage.c.R(d.f6447a);
        this.f6439w = defpackage.c.R(a.f6443a);
        this.f6440x = defpackage.c.R(b.f6444a);
        this.f6441y = defpackage.c.R(new c(r23, this));
        this.f6442z = new ArrayList();
        float r11 = 8;
        this.D = android.aimedia.a.a("Resources.getSystem()", 1, r11);
        TypedArray r12 = r23.obtainStyledAttributes(r24, nb.a.f9510x);
        i.e(r12, "context.obtainStyledAttr…, R.styleable.OWheelView)");
        boolean r13 = r12.getBoolean(0, false);
        int r14 = r12.getInt(10, 0);
        boolean r15 = r12.getBoolean(9, false);
        int r16 = r12.getInt(4, 5);
        Resources r17 = Resources.getSystem();
        i.e(r17, "Resources.getSystem()");
        int r18 = r12.getDimensionPixelOffset(6, l6.a.I0(TypedValue.applyDimension(1, r8, r17.getDisplayMetrics())));
        Resources r19 = Resources.getSystem();
        i.e(r19, "Resources.getSystem()");
        int r20 = r12.getDimensionPixelOffset(5, l6.a.I0(TypedValue.applyDimension(1, r10, r19.getDisplayMetrics())));
        Resources r110 = Resources.getSystem();
        i.e(r110, "Resources.getSystem()");
        int r21 = r12.getDimensionPixelSize(12, l6.a.I0(TypedValue.applyDimension(2, 18, r110.getDisplayMetrics())));
        Resources r111 = Resources.getSystem();
        i.e(r111, "Resources.getSystem()");
        int r112 = r12.getDimensionPixelSize(12, l6.a.I0(TypedValue.applyDimension(2, 14, r111.getDisplayMetrics())));
        Object r113 = androidx.core.content.a.f1674a;
        int r114 = r12.getColor(11, androidx.core.content.a.c.a(r23, R.color.oui_basic_text_1));
        int r22 = r12.getColor(7, androidx.core.content.a.c.a(r23, R.color.oui_accent_6_bg));
        Resources r25 = Resources.getSystem();
        i.e(r25, "Resources.getSystem()");
        int r26 = r12.getDimensionPixelSize(8, l6.a.I0(TypedValue.applyDimension(2, 22, r25.getDisplayMetrics())));
        int r115 = r12.getColor(2, androidx.core.content.a.c.a(r23, R.color.oui_fill_element_2));
        Resources r116 = Resources.getSystem();
        i.e(r116, "Resources.getSystem()");
        int r27 = r12.getDimensionPixelOffset(3, l6.a.I0(TypedValue.applyDimension(1, r11, r116.getDisplayMetrics())));
        CharSequence[] r117 = r12.getTextArray(1);
        if (r117 == null) goto L7;
        ArrayList r118 = new ArrayList(r117.length);
        int r28 = r117.length;
        int r29 = 0;
    L5:
        if (r29 >= r28) goto L8;
        CharSequence r119 = r117[r29];
        r29 = r29 + 1;
        r118.add(r119.toString());
        r28 = r28;
    L8:
        r12.recycle();
        setCyclic(r13);
        setShowDivider(r15);
        setStartIndex(r14);
        setItemCount(r16);
        setItemWidthPx(r18);
        setItemHeightPx(r20);
        setHighlightConorRadiusPx(r27);
        TextPaint r30 = getMTextPaint();
        r30.setTextAlign(Paint.Align.CENTER);
        r30.setTextSize(r21);
        r30.setColor(r114);
        boolean r31 = false;
        r30.setTypeface(Typeface.create(null, 400, false));
        TextPaint r32 = getMTagTextPaint();
        r32.setTextAlign(Paint.Align.LEFT);
        r32.setTextSize(r112);
        r32.setColor(r114);
        r32.setTypeface(Typeface.create(null, 480, false));
        TextPaint r33 = getMSelectedTextPaint();
        r33.setTextAlign(Paint.Align.CENTER);
        r33.setTextSize(r26);
        r33.setColor(r22);
        r33.setTypeface(Typeface.create(null, 500, false));
        Paint r34 = getMDividerPaint();
        Resources r35 = Resources.getSystem();
        i.e(r35, "Resources.getSystem()");
        r34.setStrokeWidth(TypedValue.applyDimension(1, (float) 0.5d, r35.getDisplayMetrics()));
        r34.setColor(androidx.core.content.a.c.a(r23, R.color.LinePrimary));
        Paint r36 = getMHighlightPaint();
        r36.setStyle(Paint.Style.FILL);
        r36.setColor(r115);
        if (r118 != null) goto L11;
    L12:
        r31 = true;
    L13:
        if (r31 == true) goto L15;
        setEntries(r118);
    L15:
        setVerticalFadingEdgeEnabled(true);
        Resources r37 = Resources.getSystem();
        i.e(r37, "Resources.getSystem()");
        setFadingEdgeLength(l6.a.I0(TypedValue.applyDimension(1, r10, r37.getDisplayMetrics())));
        return;
    L11:
        if (r118.isEmpty() == false) goto L13;
    L7:
        r118 = null;
        goto L8
    }

    private final Paint getMDividerPaint() {
        return (Paint) this.f6439w.getValue();
    }

    private final Paint getMHighlightPaint() {
        return (Paint) this.f6440x.getValue();
    }

    private final nc.b getMScroller() {
        return (nc.b) this.f6441y.getValue();
    }

    private final TextPaint getMSelectedTextPaint() {
        return (TextPaint) this.f6438v.getValue();
    }

    private final TextPaint getMTagTextPaint() {
        return (TextPaint) this.f6437u.getValue();
    }

    private final TextPaint getMTextPaint() {
        return (TextPaint) this.f6436t.getValue();
    }

    private final int getWheelHeight() {
        return (((this.f6429m - 1) * this.f6431o) + (getPaddingBottom() + getPaddingTop())) + this.f6432p;
    }

    private final int getWheelWidth() {
        int r8 = getPaddingLeft();
        return (getPaddingRight() + r8) + this.f6430n;
    }

    @Override // android.view.View
    public final void computeScroll() {
        nc.b r8 = getMScroller();
        if (r8.f9515c == false) goto L9;
        r8.f9515c = r8.computeScrollOffset();
        r8.a(r8.getCurrY() - r8.f9513a, "computeScroll");
        if (r8.f9515c == false) goto L7;
        r8.f9519g.postInvalidate();
        return;
    L7:
        nc.b.c(r8);
        return;
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        return 1.0f;
    }

    public final int getClipMiddleRectBottom() {
        Rect r8 = this.f6434r;
        if (r8 != null) goto L7;
        return 0;
    L7:
        return r8.bottom;
    }

    public final int getClipMiddleRectTop() {
        Rect r8 = this.f6434r;
        if (r8 != null) goto L7;
        return 0;
    L7:
        return r8.top;
    }

    public final int getCurrentIndex() {
        return getMScroller().b();
    }

    public final String getCurrentItem() {
        int r8 = getCurrentIndex();
        ArrayList r10 = this.f6442z;
        if (r8 >= 0) goto L8;
        if (r8 < r10.size()) goto L8;
        return null;
    L8:
        return (String) r10.get(r8);
    }

    public final int getHighlightColor() {
        return getMHighlightPaint().getColor();
    }

    public final int getHighlightConorRadiusPx() {
        return this.D;
    }

    public final int getItemCount() {
        return this.f6429m;
    }

    public final int getItemHeightPx() {
        return this.f6431o;
    }

    public final int getItemSize() {
        return this.f6442z.size();
    }

    public final int getItemWidthPx() {
        return this.f6430n;
    }

    public final nc.a getOnWheelChangedListener() {
        getMScroller().getClass();
        return null;
    }

    public final int getSelectedItemHeightPx() {
        return this.f6432p;
    }

    public final int getSelectedTextColor() {
        return getMSelectedTextPaint().getColor();
    }

    public final float getSelectedTextSizePx() {
        return getMSelectedTextPaint().getTextSize();
    }

    public final boolean getShowBottomLeftCorner() {
        return this.H;
    }

    public final boolean getShowBottomRightCorner() {
        return this.I;
    }

    public final boolean getShowDivider() {
        return this.f6427a;
    }

    public final boolean getShowTopLeftCorner() {
        return this.F;
    }

    public final boolean getShowTopRightCorner() {
        return this.G;
    }

    public final int getStartIndex() {
        return this.f6428b;
    }

    public final Integer getTagGap() {
        return this.B;
    }

    public final int getTextColor() {
        return getMTextPaint().getColor();
    }

    public final float getTextSizePx() {
        return getMTextPaint().getTextSize();
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        return 1.0f;
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        nc.b r8 = getMScroller();
        Context r10 = getContext();
        i.e(r10, "context");
        r8.getClass();
        k.b(r10, new int[]{R.raw.reel_picker});
    }

    @Override // android.view.View
    public final void onDraw(Canvas r19) {
        i.f(r19, "canvas");
        nc.b r8 = getMScroller();
        WheelView r10 = r8.f9519g;
        int r11 = 0;
        if (r10.getItemHeightPx() != 0) goto L5;
        int r12 = 0;
    L6:
        nc.b r13 = getMScroller();
        WheelView r14 = r13.f9519g;
        if (r14.getItemHeightPx() != 0) goto L9;
        int r15 = 0;
    L10:
        int r16 = 2;
        int r17 = (this.f6429m + 1) / 2;
        int r18 = r12 - r17;
        if (r15 >= 0) goto L13;
        r18 = r18 - 1;
        int r20 = r12 + r17;
    L16:
        int r110 = r20;
        int r111 = r18;
    L17:
        if (r111 >= r110) goto L66;
        ArrayList r21 = this.f6442z;
        int r22 = r21.size();
        if (r22 != 0) goto L22;
    L31:
        String r23 = null;
    L32:
        String r112 = r23;
        if (r112 == null) goto L64;
        Rect r24 = this.f6434r;
        i.c(r24);
        int r25 = r24.centerX();
        Rect r26 = this.f6434r;
        i.c(r26);
        int r27 = r26.centerY();
        Paint.FontMetrics r28 = getMTextPaint().getFontMetrics();
        float r29 = r16;
        int r113 = (int) ((r28.top + r28.bottom) / r29);
        Paint.FontMetrics r30 = getMSelectedTextPaint().getFontMetrics();
        int r31 = (int) ((r30.top + r30.bottom) / r29);
        nc.b r32 = getMScroller();
        WheelView r33 = r32.f9519g;
        if (r33.getItemHeightPx() != 0) goto L37;
        int r34 = r11;
    L38:
        int r35 = this.f6431o;
        int r36 = ((r111 - r34) * r35) - r15;
        float r37 = (this.f6432p - r35) / 2.0f;
        if (r37 > r11) goto L41;
        float r38 = r36;
    L45:
        int r39 = this.f6431o;
        if (1 > r36) goto L50;
        if (r39 <= r36) goto L50;
        r19.save();
        Rect r40 = this.f6434r;
        i.c(r40);
        r19.clipRect(r40);
        float r114 = r25;
        float r115 = r27 + r38;
        r19.drawText(r112, 0, r112.length(), r114, r115 - r31, getMSelectedTextPaint());
        r19.restore();
        r19.save();
        Rect r41 = this.f6435s;
    L56:
        i.c(r41);
        r19.clipRect(r41);
        int r42 = r112.length();
        TextPaint r43 = getMTextPaint();
        float r44 = r114;
        float r45 = r115 - r113;
    L63:
        r19.drawText(r112, 0, r42, r44, r45, r43);
        r19.restore();
    L50:
        if (r36 < r39) goto L52;
        r19.save();
        Rect r46 = this.f6435s;
    L60:
        i.c(r46);
        r19.clipRect(r46);
        int r47 = r112.length();
        float r48 = r25;
        float r49 = (r27 + r38) - r113;
        TextPaint r50 = getMTextPaint();
    L62:
        r44 = r48;
        r45 = r49;
        r43 = r50;
        r42 = r47;
        goto L63
    L52:
        if (r36 < 0) goto L54;
    L57:
        int r51 = -r39;
        r19.save();
        if (r36 > r51) goto L61;
        r46 = this.f6433q;
        goto L60
    L61:
        Rect r52 = this.f6434r;
        i.c(r52);
        r19.clipRect(r52);
        int r53 = r112.length();
        r48 = r25;
        r49 = (r27 + r38) - r31;
        r50 = getMSelectedTextPaint();
        r47 = r53;
        goto L62
    L54:
        if (r36 <= (-r39)) goto L57;
        r19.save();
        Rect r54 = this.f6434r;
        i.c(r54);
        r19.clipRect(r54);
        r114 = r25;
        r115 = r27 + r38;
        r19.drawText(r112, 0, r112.length(), r114, r115 - r31, getMSelectedTextPaint());
        r19.restore();
        r19.save();
        r41 = this.f6433q;
        goto L56
    L41:
        float r55 = r35;
        if (Math.abs(r36) > r55) goto L44;
        r38 = ((r37 / r55) + 1.0f) * r36;
        goto L45
    L44:
        float r56 = r36;
        r38 = r56 + (Math.signum(r56) * r37);
        goto L45
    L37:
        r34 = r32.f9513a / r33.getItemHeightPx();
    L64:
        r111 = r111 + 1;
        r11 = 0;
        r16 = 2;
        goto L17
    L22:
        if (this.E == false) goto L26;
        int r57 = r111 % r22;
        if (r57 >= 0) goto L30;
        r57 = r57 + r22;
    L30:
        r23 = (String) r21.get(r57);
        goto L32
    L26:
        if (r111 < 0) goto L31;
        if (r22 <= r111) goto L31;
        r57 = r111;
        goto L30
    L66:
        if (this.f6427a == false) goto L71;
        Rect r58 = this.f6434r;
        if (r58 == null) goto L71;
        float r59 = r58.left;
        float r60 = r58.top;
        r19.drawLine(r59, r60, r58.right, r60, getMDividerPaint());
        float r61 = r58.left;
        float r62 = r58.bottom;
        r19.drawLine(r61, r62, r58.right, r62, getMDividerPaint());
    L71:
        CharSequence r63 = this.A;
        if (r63 == null) goto L82;
        Rect r64 = this.f6434r;
        i.c(r64);
        int r65 = r64.centerY();
        Rect r66 = this.f6434r;
        i.c(r66);
        int r67 = r66.centerX();
        Paint.FontMetrics r68 = getMTagTextPaint().getFontMetrics();
        float r69 = r68.top + r68.bottom;
        float r70 = 2;
        int r71 = (int) (r69 / r70);
        Integer r72 = this.B;
        if (r72 == null) goto L76;
        int r73 = r72.intValue();
    L77:
        r19.drawText(r63, 0, r63.length(), ((this.C / r70) + r67) + r73, r65 - r71, getMTagTextPaint());
        return;
    L76:
        r73 = android.aimedia.a.a("Resources.getSystem()", 1, r70);
        goto L77
    L82:
        return;
    L13:
        r20 = r12 + r17;
        if (r15 <= 0) goto L16;
        r20 = r20 + 1;
        goto L16
    L9:
        r15 = r13.f9513a % r14.getItemHeightPx();
        goto L10
    L5:
        r12 = r8.f9513a / r10.getItemHeightPx();
        goto L6
    }

    @Override // android.view.View
    public final void onMeasure(int r10, int r11) {
        int r8 = View.MeasureSpec.getMode(r10);
        int r12 = View.MeasureSpec.getSize(r10);
        int r13 = View.MeasureSpec.getMode(r11);
        int r14 = View.MeasureSpec.getSize(r11);
        float r15 = this.C;
        if (this.A == null) goto L9;
        float r16 = getMTagTextPaint().measureText(String.valueOf(this.A));
        Integer r17 = this.B;
        if (r17 == null) goto L7;
        int r18 = r17.intValue();
    L8:
        float r19 = 2 * ((r18 + r16) + android.aimedia.a.a("Resources.getSystem()", 1, 16));
    L10:
        int r20 = Math.max((int) (r19 + r15), getMinimumWidth());
        if (r8 == Integer.MIN_VALUE) goto L14;
        if (r8 == 1073741824) goto L15;
        r12 = r20;
    L15:
        if (r13 == 1073741824) goto L18;
        r14 = getWheelHeight();
    L18:
        setMeasuredDimension(r12, r14);
        int r21 = getPaddingLeft();
        int r110 = getMeasuredWidth() - getPaddingRight();
        int r22 = getPaddingTop();
        int r23 = getMeasuredHeight() - getPaddingBottom();
        int r24 = (r22 + r23) / 2;
        Rect r25 = new Rect();
        r25.left = r21;
        r25.right = r110;
        int r26 = this.f6432p / 2;
        r25.top = r24 - r26;
        r25.bottom = r26 + r24;
        xd.j r27 = xd.j.f13877a;
        this.f6434r = r25;
        Rect r28 = new Rect();
        r28.left = r21;
        r28.right = r110;
        r28.top = r22;
        r28.bottom = r24 - (this.f6432p / 2);
        this.f6433q = r28;
        Rect r29 = new Rect();
        r29.left = r21;
        r29.right = r110;
        r29.top = (this.f6432p / 2) + r24;
        r29.bottom = r23;
        this.f6435s = r29;
        return;
    L14:
        r12 = Math.min(r20, r12);
        goto L15
    L7:
        r18 = android.aimedia.a.a("Resources.getSystem()", 1, 2);
        goto L8
    L9:
        r19 = android.aimedia.a.a("Resources.getSystem()", 1, 28);
        goto L10
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r23) {
        i.f(r23, "event");
        nc.b r8 = getMScroller();
        r8.getClass();
        if (r8.f9516d != null) goto L5;
        r8.f9516d = VelocityTracker.obtain();
    L5:
        VelocityTracker r10 = r8.f9516d;
        if (r10 == null) goto L8;
        r10.addMovement(r23);
    L8:
        int r11 = r23.getAction();
        boolean r12 = false;
        WheelView r13 = r8.f9519g;
        if (r11 == 0) goto L105;
        VelocityTracker r14 = null;
        if (r11 == 1) goto L29;
        if (r11 != 2) goto L14;
        float r15 = r23.getY();
        int r16 = (int) (r15 - r8.f9514b);
        if (r16 == 0) goto L28;
        r8.f9517e = true;
        r8.a(-r16, "touchEvent");
        r13.invalidate();
    L28:
        r8.f9514b = r15;
        return true;
    L14:
        if (r11 == 3) goto L17;
        return true;
    L17:
        if (r8.f9517e == false) goto L19;
        nc.b.c(r8);
    L19:
        VelocityTracker r17 = r8.f9516d;
        if (r17 == null) goto L22;
        r17.recycle();
    L22:
        r8.f9516d = null;
        r8.f9517e = false;
        ViewParent r18 = r13.getParent();
        if (r18 == null) goto L114;
    L103:
        r18.requestDisallowInterceptTouchEvent(r12);
    L104:
        return true;
    L114:
        return true;
    L29:
        VelocityTracker r19 = r8.f9516d;
        if (r19 == null) goto L32;
        r19.computeCurrentVelocity(1000);
    L32:
        VelocityTracker r20 = r8.f9516d;
        if (r20 == null) goto L35;
        float r21 = r20.getYVelocity();
    L36:
        float r22 = 0;
        if (Math.abs(r21) <= r22) goto L90;
        int r24 = r13.getItemHeightPx() * (r13.getItemSize() - 1);
        int r25 = r13.getItemHeightPx() * 0;
        r8.f9515c = true;
        boolean r26 = r13.E;
        int r27 = r13.getItemHeightPx();
        int r28 = r8.f9513a;
        if (r26 == false) goto L41;
        int r29 = ((int) (-r21)) / 2;
        int r110 = Integer.MIN_VALUE;
        int r111 = 0;
        int r112 = Integer.MAX_VALUE;
    L43:
        if (t2.b.A == true) goto L45;
        zc.b.b("ScrollerExt", "calculateSnapVelocity, reflect failed, use original velocityY: " + r29);
        int r30 = r29;
        nc.b r210 = r8;
        r28 = r28;
        r110 = r110;
        int r113 = r112;
        int r211 = r111;
        WheelView r212 = r13;
    L89:
        r210.fling(0, r28, 0, r30, 0, 0, r110, r113, 0, r211);
        r14 = null;
        r8 = r210;
    L95:
        r212.invalidate();
    L97:
        VelocityTracker r31 = r8.f9516d;
        if (r31 == null) goto L100;
        r31.recycle();
    L100:
        r8.f9516d = r14;
        r18 = r212.getParent();
        if (r18 == null) goto L104;
        r12 = false;
        goto L103
    L45:
        if (r29 == 0) goto L87;
        float r32 = r28;
        float r33 = r27;
        float r34 = t2.b.B(r8, r29) + r32;
        double r35 = r34 / r33;
        float r114 = ((float) Math.floor(r35)) * r33;
        float r36 = ((float) Math.ceil(r35)) * r33;
        if (Math.abs(r34 - r114) < Math.abs(r36 - r34)) goto L50;
        r114 = r36;
    L50:
        if (r29 <= 0) goto L52;
        byte r37 = 1;
    L53:
        if (r29 <= 0) goto L55;
        int r38 = 40000;
        int r39 = 0;
    L56:
        float r40 = Float.MAX_VALUE;
        int r115 = 0;
        int r116 = r29;
        r212 = r13;
    L58:
        if (r115 >= 20) goto L86;
        int r117 = (r39 + r38) / 2;
        r211 = r111;
        float r118 = t2.b.B(r8, r117) + r32;
        r113 = r112;
        float r119 = r118 - r114;
        if (Math.abs(r119) >= r40) goto L62;
        r40 = Math.abs(r119);
        int r120 = r117;
    L63:
        r210 = r8;
        float r213 = r22;
        StringBuilder r41 = defpackage.a.g("calculateSnapVelocity, iteration: ", r115, ", mid: ", r117, ", low: ");
        defpackage.b.q(r41, r39, ", high: ", r38, ", diff: ");
        r41.append(r119);
        r41.append(", dist: ");
        r41.append(r118);
        r41.append(", targetDistance: ");
        r41.append(r114);
        r41.append(", bestDiff: ");
        r41.append(r40);
        r41.append(", bestVelocity: ");
        defpackage.b.q(r41, r120, ", velocityY: ", r29, ", currentOffset: ");
        r41.append(r32);
        zc.b.g("ScrollerExt", r41.toString());
        if (r37 <= 0) goto L71;
        if (r119 >= r213) goto L68;
    L75:
        if (r37 <= 0) goto L80;
        if (r119 > r213) goto L82;
    L81:
        r39 = r117 + 1;
    L83:
        if (r39 > r38) goto L84;
        r115 = r115 + 1;
        r111 = r211;
        r116 = r120;
        r112 = r113;
        r110 = r110;
        r28 = r28;
        r8 = r210;
        r22 = r213;
    L84:
        r29 = r120;
    L88:
        r30 = r29;
    L82:
        r38 = r117 - 1;
        goto L83
    L80:
        if (r119 >= r213) goto L82;
    L68:
        if (Math.abs(r119) > 0.3f) goto L75;
    L71:
        if (r119 > r213) goto L75;
        if (Math.abs(r119) > 0.3f) goto L75;
    L62:
        r120 = r116;
        goto L63
    L86:
        r210 = r8;
        r28 = r28;
        r110 = r110;
        r113 = r112;
        r211 = r111;
        r29 = r116;
        goto L88
    L55:
        r39 = -40000;
        r38 = 0;
        goto L56
    L52:
        r37 = -1;
        goto L53
    L87:
        r210 = r8;
        r28 = r28;
        r110 = r110;
        r113 = r112;
        r211 = r111;
        r212 = r13;
        goto L88
    L41:
        r111 = r25;
        r29 = ((int) (-r21)) / 2;
        r110 = 0;
        r112 = r24;
        goto L43
    L90:
        r212 = r13;
        if (r8.f9517e == true) goto L96;
        float r42 = r23.getY() - (r212.getHeight() / 2.0f);
        if (Math.abs(r42) <= 1) goto L97;
        r8.f9515c = true;
        r8.f("ACTION_UP", r8.f9513a, (int) r42, 200);
        goto L95
    L96:
        nc.b.c(r8);
        goto L97
    L35:
        r21 = 0.0f;
        goto L36
    L105:
        ViewParent r43 = r13.getParent();
        if (r43 == null) goto L108;
        r43.requestDisallowInterceptTouchEvent(true);
    L108:
        r8.f9514b = r23.getY();
        r8.forceFinished(true);
        r8.f9517e = false;
        r8.f9515c = false;
        return true;
    }

    public final void setCurrentIndex(int r8) {
        getMScroller().e(r8, false);
    }

    public final void setCyclic(boolean r8) {
        this.E = r8;
        nc.b r10 = getMScroller();
        r10.f9515c = false;
        r10.f9513a = 0;
        r10.f9518f = -1;
        r10.d("reset");
        r10.forceFinished(true);
        invalidate();
    }

    public final void setEntries(List<String> r8) {
        ArrayList r10 = this.f6442z;
        r10.clear();
        this.C = 0.0f;
        if (r8 != null) goto L5;
    L8:
        boolean r11 = true;
    L9:
        if (r11 == true) goto L14;
        r10.addAll(r8);
        Iterator r12 = r10.iterator();
    L12:
        if (r12.hasNext() == false) goto L14;
        this.C = Math.max(this.C, getMSelectedTextPaint().measureText((String) r12.next()));
    L14:
        nc.b r13 = getMScroller();
        r13.f9515c = false;
        r13.f9513a = 0;
        r13.f9518f = -1;
        r13.d("reset");
        r13.forceFinished(true);
        getMScroller().e(this.f6428b, false);
        requestLayout();
        return;
    L5:
        if (r8.isEmpty() == true) goto L8;
        r11 = false;
        goto L9
    }

    public final void setHighlightColor(int r8) {
        getMHighlightPaint().setColor(r8);
        invalidate();
    }

    public final void setHighlightConorRadiusPx(int r8) {
        this.D = r8;
        invalidate();
    }

    public final void setItemCount(int r8) {
        this.f6429m = r8;
        invalidate();
    }

    public final void setItemHeightPx(int r8) {
        this.f6431o = r8;
        invalidate();
    }

    public final void setItemWidthPx(int r8) {
        this.f6430n = r8;
        invalidate();
    }

    public final void setOnWheelChangedListener(nc.a r8) {
        getMScroller().getClass();
    }

    public final void setSelectedItemHeightPx(int r8) {
        this.f6432p = r8;
        invalidate();
    }

    public final void setSelectedTextColor(int r8) {
        getMSelectedTextPaint().setColor(r8);
        invalidate();
    }

    public final void setSelectedTextSizePx(float r8) {
        getMSelectedTextPaint().setTextSize(r8);
        invalidate();
    }

    public final void setShowBottomLeftCorner(boolean r8) {
        this.H = r8;
    }

    public final void setShowBottomRightCorner(boolean r8) {
        this.I = r8;
    }

    public final void setShowDivider(boolean r8) {
        this.f6427a = r8;
        invalidate();
    }

    public final void setShowTopLeftCorner(boolean r8) {
        this.F = r8;
    }

    public final void setShowTopRightCorner(boolean r8) {
        this.G = r8;
    }

    public final void setStartIndex(int r8) {
        this.f6428b = r8;
        getMScroller().e(r8, false);
    }

    public final void setTagGap(Integer r8) {
        this.B = r8;
        invalidate();
    }

    public final void setTagText(CharSequence r8) {
        i.f(r8, LocationMonitorConst.TAG);
        if ((!g.s0(r8)) == false) goto L6;
        this.A = r8;
        invalidate();
        return;
    }

    public final void setTextColor(int r8) {
        getMTextPaint().setColor(r8);
        invalidate();
    }

    public final void setTextSizePx(float r8) {
        getMTextPaint().setTextSize(r8);
        invalidate();
    }

    public final void setEntries(String... r8) {
        i.f(r8, "entries");
        setEntries(yd.e.w0(r8));
    }
}
