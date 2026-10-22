package com.obric.oui.indexscrollbar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.obric.cae.R;
import he.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kc.c;
import kc.d;
import ne.g;

/* JADX INFO: loaded from: classes2.dex */
public final class LettersBar extends View {
    public final d A;
    public int B;
    public String C;
    public float D;
    public float E;
    public int F;
    public int G;
    public int H;
    public final c I;
    public final kc.b J;
    public long K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<kc.a> f6316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6317b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f6318m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Bitmap[] f6319n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f6320o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f6321p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f6322q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f6323r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f6324s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f6325t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Paint f6326u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f6327v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f6328w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Bitmap f6329x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f6330y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f6331z;

    public interface a {
    }

    public interface b {
    }

    public LettersBar(Context r8, AttributeSet r10) {
        i.f(r8, "context");
        super(r8, r10, 0);
        this.f6317b = -1;
        this.f6318m = true;
        Paint r11 = new Paint();
        this.f6326u = r11;
        this.A = new d(r8);
        Resources r12 = r8.getResources();
        this.f6321p = r12.getDimensionPixelSize(R.dimen.letters_bar_single_letter_min_height);
        this.f6320o = l6.a.G(14);
        this.f6322q = r12.getDimensionPixelOffset(R.dimen.letters_bar_letter_font_size);
        this.f6323r = r12.getDimensionPixelOffset(R.dimen.letters_bar_letter_locale_font_size);
        this.f6324s = getPaddingLeft() + (this.f6320o / 2);
        BitmapFactory.decodeResource(r12, R.drawable.letters_bar_highlight_icon);
        Drawable r13 = r12.getDrawable(R.drawable.letters_bar_highlight_icon);
        i.e(r13, "iconDrawable");
        int r14 = r13.getIntrinsicWidth() / 2;
        r13.getIntrinsicHeight();
        this.f6327v = r12.getColor(R.color.oui_functional_blue_6);
        this.f6328w = r12.getColor(R.color.oui_text_3b);
        Bitmap r15 = BitmapFactory.decodeResource(r12, R.drawable.letters_bar_dot);
        this.f6329x = r15;
        int r16 = this.f6324s;
        i.c(r15);
        this.f6330y = r16 - (r15.getWidth() / 2);
        r11.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
        r11.setTextSize(this.f6322q);
        r11.setAntiAlias(true);
        Resources r17 = r8.getResources();
        i.e(r17, "context.resources");
        this.B = r17.getDisplayMetrics().widthPixels;
        this.G = -1;
        this.H = -1;
        this.I = new c(this);
        this.J = new kc.b(this);
        this.K = -1;
    }

    public static final /* synthetic */ void a(LettersBar r8, int r10) {
        r8.setTouchedLetter(r10);
    }

    private final void setLetterPaint(int r8) {
        if (this.f6317b != r8) goto L5;
        boolean r10 = true;
    L6:
        Paint r11 = this.f6326u;
        if (r10 == false) goto L9;
        int r12 = this.f6327v;
    L10:
        r11.setColor(r12);
        r11.setFakeBoldText(false);
        Resources r13 = Resources.getSystem();
        i.e(r13, "Resources.getSystem()");
        r11.setTextSize(TypedValue.applyDimension(1, 10, r13.getDisplayMetrics()));
        List<kc.a> r14 = this.f6316a;
        i.c(r14);
        if (g.v0(r14.get(r8).f9102b, ".") == true) goto L17;
        List<kc.a> r15 = this.f6316a;
        i.c(r15);
        if (r15.get(r8).f9101a != 1) goto L15;
        r11.setTextSize(this.f6323r);
        r11.setFakeBoldText(true);
        return;
    L15:
        r11.setTextSize(this.f6322q);
        return;
    L17:
        return;
    L9:
        r12 = this.f6328w;
        goto L10
    L5:
        r10 = false;
        goto L6
    }

    private final void setTouchedLetter(int r8) {
        this.f6317b = r8;
        invalidate();
    }

    public final ArrayList<Integer> b() {
        ArrayList<Integer> r8 = new ArrayList();
        int r10 = this.f6325t;
        List<kc.a> r11 = this.f6316a;
        i.c(r11);
        if ((r10 / r11.size()) >= this.f6321p) goto L5;
        List<kc.a> r12 = this.f6316a;
        i.c(r12);
        int r13 = (int) Math.max(2.0d, ((int) Math.ceil(r12.size() / ((this.f6325t / this.f6321p) - 2))) * 2);
    L6:
        r8.add(0);
        List<kc.a> r14 = this.f6316a;
        i.c(r14);
        if (r13 >= (r14.size() / 2)) goto L12;
        int r15 = r13;
    L9:
        List<kc.a> r16 = this.f6316a;
        i.c(r16);
        if (r15 >= (r16.size() - 1)) goto L12;
        r8.add(Integer.valueOf(r15));
        r15 = r15 + r13;
    L12:
        List<kc.a> r17 = this.f6316a;
        i.c(r17);
        if (r13 >= r17.size()) goto L15;
        List<kc.a> r18 = this.f6316a;
        i.c(r18);
        r8.add(Integer.valueOf(r18.size() - 1));
    L15:
        return r8;
    L5:
        r13 = 1;
        goto L6
    }

    @Override // android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r17) {
        i.f(r17, "event");
        super.dispatchTouchEvent(r17);
        int r8 = r17.getAction();
        float r10 = r17.getY();
        this.G = this.f6317b;
        float r11 = (r10 - getPaddingTop()) / ((getHeight() - getPaddingTop()) - getPaddingBottom());
        List<kc.a> r12 = this.f6316a;
        i.c(r12);
        int r13 = (int) (r11 * r12.size());
        this.H = r13;
        c r14 = this.I;
        kc.b r15 = this.J;
        d r16 = this.A;
        if (r8 != 0) goto L5;
        removeCallbacks(r15);
        this.D = r17.getX();
        this.E = r17.getY();
        ViewConfiguration r18 = ViewConfiguration.get(getContext());
        i.e(r18, "ViewConfiguration.get(context)");
        this.F = r18.getScaledTouchSlop();
        if (r16.b() == true) goto L45;
        this.K = System.currentTimeMillis();
        postDelayed(r14, 200);
    L45:
        this.C = null;
    L46:
        setShowBg(false);
    L47:
        return true;
    L5:
        if (r8 != 1) goto L7;
        removeCallbacks(r14);
        if ((System.currentTimeMillis() - this.K) >= 100) goto L31;
        if (r16.b() == true) goto L31;
        this.K = -1;
        r14.run();
        postDelayed(r15, 200);
        return true;
    L31:
        if (r16.b() == false) goto L33;
        removeCallbacks(r15);
    L33:
        this.K = -1;
        if (this.f6318m == false) goto L40;
        if (r13 < 0) goto L39;
        List<kc.a> r19 = this.f6316a;
        i.c(r19);
        if (r13 >= r19.size()) goto L39;
        setTouchedLetter(r13);
    L39:
        r16.a();
        setTouchedLetter(-1);
        setShowBg(false);
    L41:
        invalidate();
        goto L47
    L40:
        r16.a();
        goto L41
    L7:
        if (r8 == 2) goto L16;
        if (r8 != 3) goto L47;
        removeCallbacks(r14);
        if (r16.b() == false) goto L14;
        removeCallbacks(r15);
    L14:
        this.K = -1;
        r16.a();
        setTouchedLetter(-1);
        goto L47
    L16:
        if (Math.sqrt(Math.pow(r17.getY() - this.E, 2.0d) + Math.pow(r17.getX() - this.D, 2.0d)) >= this.F) goto L19;
        return true;
    L19:
        if (r16.b() == false) goto L46;
        if (r13 < 0) goto L46;
        List<kc.a> r20 = this.f6316a;
        i.c(r20);
        if (r13 >= r20.size()) goto L46;
        setTouchedLetter(r13);
        goto L46
    }

    public final Runnable getDismissPopupTask() {
        return this.J;
    }

    public final float getDownX() {
        return this.D;
    }

    public final float getDownY() {
        return this.E;
    }

    public final int getMHasChosenLetterFontColor() {
        return this.f6327v;
    }

    public final int getMNoChosenLetterFontColor() {
        return this.f6328w;
    }

    public final int getNewChosen() {
        return this.H;
    }

    public final int getOldChosen() {
        return this.G;
    }

    public final Runnable getShowPopupTask() {
        return this.I;
    }

    public final long getShowPopupTaskStartTime() {
        return this.K;
    }

    public final int getTouchSlop() {
        return this.F;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r17) {
        i.f(r17, "canvas");
        super.onDraw(r17);
        r17.save();
        r17.translate(0.0f, getPaddingTop());
        ArrayList<Integer> r8 = b();
        float r10 = (float) Math.max(this.f6325t / r8.size(), this.f6321p);
        Iterator<Integer> r11 = r8.iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L47;
        Integer r13 = r11.next();
        i.e(r13, "index");
        setLetterPaint(r13.intValue());
        float r14 = this.f6324s;
        Paint r15 = this.f6326u;
        List<kc.a> r16 = this.f6316a;
        i.c(r16);
        float r18 = 2;
        float r19 = r14 - (r15.measureText(r16.get(r13.intValue()).f9102b) / r18);
        float r110 = (r10 / r18) + (r12 * r10);
        if (this.f6317b != r13.intValue()) goto L8;
        boolean r20 = true;
    L9:
        if (r20 == true) goto L11;
    L13:
        List<kc.a> r21 = this.f6316a;
        i.c(r21);
        if (r21.get(r13.intValue()).f9101a != 2) goto L42;
        int r22 = r13.intValue();
        List<kc.a> r23 = this.f6316a;
        i.c(r23);
        Bitmap[] r24 = r23.get(r22).f9103c;
        i.c(r24);
        int r25 = this.f6317b;
        if (r25 != r22) goto L18;
        boolean r26 = true;
    L19:
        if (r26 == true) goto L21;
    L23:
        boolean r27 = false;
    L25:
        if (r25 == (-1)) goto L27;
        boolean r28 = true;
    L28:
        if (r28 == false) goto L30;
    L33:
        boolean r29 = true;
    L34:
        if (r27 == false) goto L38;
        Bitmap r30 = r24[2];
        i.c(r30);
        int r31 = r30.getHeight();
        Bitmap r32 = r24[2];
        i.c(r32);
        float r33 = this.f6324s - (r32.getWidth() / 2);
        Bitmap r34 = r24[2];
        int r111 = 2;
    L41:
        i.c(r34);
        r17.drawBitmap(r34, r33, r110 - (r31 / r111), null);
    L46:
        r12 = r12 + 1;
        goto L4
    L38:
        if (r29 == false) goto L40;
        Bitmap r35 = r24[1];
        i.c(r35);
        int r36 = r35.getHeight();
        Bitmap r112 = r24[1];
        i.c(r112);
        float r37 = this.f6324s - (r112.getWidth() / 2);
        r34 = r24[1];
        r31 = r36;
        r111 = 2;
        r33 = r37;
        goto L41
    L40:
        Bitmap r38 = r24[0];
        i.c(r38);
        r31 = r38.getHeight();
        Bitmap r39 = r24[0];
        i.c(r39);
        r111 = 2;
        r33 = this.f6324s - (r39.getWidth() / 2);
        r34 = r24[0];
        goto L41
    L30:
        if (this.f6318m == false) goto L33;
        r29 = false;
        goto L34
    L27:
        r28 = false;
        goto L28
    L21:
        if (this.f6318m == false) goto L23;
        r27 = true;
        goto L25
    L18:
        r26 = false;
        goto L19
    L42:
        int r40 = r13.intValue();
        List<kc.a> r113 = this.f6316a;
        i.c(r113);
        String r41 = r113.get(r40).f9102b;
        if (g.v0(r41, ".") == false) goto L45;
        Bitmap r42 = this.f6329x;
        i.c(r42);
        float r114 = r110 - (r42.getHeight() / 2);
        Bitmap r43 = this.f6329x;
        i.c(r43);
        r17.drawBitmap(r43, this.f6330y, r114, null);
        goto L46
    L45:
        Paint.FontMetricsInt r44 = r15.getFontMetricsInt();
        int r115 = r44.bottom;
        int r45 = r44.top;
        r17.drawText(r41, r19, (r110 - ((r115 - r45) / 2)) - r45, r15);
        goto L46
    L11:
        if (this.f6318m == false) goto L13;
        Paint r46 = new Paint();
        Context r116 = getContext();
        i.e(r116, "context");
        r46.setColor(r116.getResources().getColor(R.color.Transparent));
        int r117 = l6.a.G(14);
        l6.a.G(14);
        float r118 = r117 / 2.0f;
        float r119 = this.f6324s;
        r17.drawRoundRect(new RectF(r119 - r118, r110 - r118, r119 + r118, r110 + r118), r118, r118, r46);
        goto L13
    L8:
        r20 = false;
        goto L9
    L47:
        r17.restore();
    }

    @Override // android.view.View
    public final void onMeasure(int r8, int r10) {
        super.onMeasure(r8, r10);
        int r11 = View.MeasureSpec.getMode(r10);
        int r12 = View.MeasureSpec.getSize(r10);
        if (r11 != Integer.MIN_VALUE) goto L6;
    L9:
        this.f6325t = (r12 - getPaddingTop()) - getPaddingBottom();
        return;
    L6:
        if (r11 == 1073741824) goto L9;
        r12 = 0;
        goto L9
    }

    public final void setBitmapsSelected(Bitmap[] r8) {
        this.f6319n = r8;
    }

    public final void setDownX(float r8) {
        this.D = r8;
    }

    public final void setDownY(float r8) {
        this.E = r8;
    }

    public final void setLetters(List<kc.a> r8) {
        this.f6316a = r8;
    }

    public final void setListener(a r8) {
    }

    public final void setMHasChosenLetterFontColor(int r8) {
        this.f6327v = r8;
    }

    public final void setMNoChosenLetterFontColor(int r8) {
        this.f6328w = r8;
    }

    public final void setNewChosen(int r8) {
        this.H = r8;
    }

    public final void setOldChosen(int r8) {
        this.G = r8;
    }

    public final void setOnBackgroundVisibleChangedListener(b r8) {
    }

    public final void setSettled(boolean r8) {
        this.f6318m = r8;
        if (r8 == false) goto L5;
        setTouchedLetter(-1);
    L5:
        invalidate();
    }

    public final void setShowBg(boolean r8) {
        if (this.f6331z == r8) goto L10;
        this.f6331z = r8;
        if (r8 == false) goto L7;
        Drawable r10 = getResources().getDrawable(R.drawable.letters_bar_background);
    L8:
        setBackground(r10);
        return;
    L7:
        r10 = null;
        goto L8
    }

    public final void setShowPopupTaskStartTime(long r8) {
        this.K = r8;
    }

    public final void setTouchSlop(int r8) {
        this.F = r8;
    }
}
