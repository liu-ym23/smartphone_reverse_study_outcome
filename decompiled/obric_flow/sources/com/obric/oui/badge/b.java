package com.obric.oui.badge;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.obric.common.oui.R$color;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import org.threeten.bp.chrono.HijrahDate;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends Drawable {
    public static final /* synthetic */ int G = 0;
    public OBadgeDrawable$BadgeGravity A;
    public int B;
    public int C;
    public int D;
    public boolean E;
    public float F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f11979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f11980c;
    public final float d;
    public final float e;
    public final float f;
    public final float g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f11981h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f11982i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f11983j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Paint f11984k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final TextPaint f11985l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Rect f11986m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final RectF f11987n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f11988o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f11989p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f11990q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f11991r;
    public boolean s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f11992t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Rect f11993u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View f11994v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View f11995w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f11996x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Integer f11997y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f11998z;

    public b(Context r10) {
        this.f11978a = r10;
        this.f11979b = com.lynx.tasm.utils.a.s(r10, 4.0f);
        com.lynx.tasm.utils.a.s(r10, 4.0f);
        this.f11980c = com.lynx.tasm.utils.a.s(r10, 8.0f);
        this.d = com.lynx.tasm.utils.a.s(r10, 5.0f);
        this.e = com.lynx.tasm.utils.a.s(r10, 18.0f);
        Intrinsics.checkNotNullParameter(r10, "<this>");
        this.f = com.lynx.tasm.utils.a.s(r10, (float) 1.5d);
        this.g = com.lynx.tasm.utils.a.r(5, r10);
        this.f11981h = com.lynx.tasm.utils.a.s(r10, 23.0f);
        this.f11982i = com.lynx.tasm.utils.a.s(r10, 18.0f);
        this.f11983j = com.lynx.tasm.utils.a.s(r10, 1.0f);
        Paint r5 = new Paint(1);
        r5.setStyle(Paint.Style.FILL);
        r5.setColor(ContextCompat.getColor(r10, R$color.oui_red_6));
        this.f11984k = r5;
        TextPaint r11 = new TextPaint(1);
        r11.setTextAlign(Paint.Align.CENTER);
        r11.setTypeface(Typeface.create(r11.getTypeface(), 500, false));
        r11.setColor(ContextCompat.getColor(r10, R$color.white));
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r11.setTextSize(TypedValue.applyDimension(2, 12.0f, r10.getResources().getDisplayMetrics()));
        this.f11985l = r11;
        this.f11986m = new Rect();
        this.f11987n = new RectF();
        this.s = true;
        this.f11998z = HijrahDate.MAX_VALUE_OF_ERA;
        this.A = OBadgeDrawable$BadgeGravity.TOP_END;
        this.C = ContextCompat.getColor(r10, R$color.oui_red_6);
        this.D = ContextCompat.getColor(r10, R$color.white);
        this.E = true;
        this.F = 12.0f;
    }

    public final void a() {
        this.s = true;
        invalidateSelf();
        View r5 = this.f11994v;
        if (r5 == null) goto L6;
        Intrinsics.checkNotNull(r5);
        f(r5, this.f11995w);
        return;
    }

    public final String b(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L15;
    L13:
        return r5;
    L15:
        Integer r10 = Integer.valueOf(String.valueOf(r5));     // Catch: Exception -> L11
        if (r10.intValue() <= this.f11998z) goto L8;
        StringBuilder r11 = new StringBuilder();     // Catch: Exception -> L11
        r11.append(this.f11998z);     // Catch: Exception -> L11
        r11.append('+');     // Catch: Exception -> L11
        r5 = r11.toString();     // Catch: Exception -> L11
    L14:
    L8:
        if (r10.intValue() >= 0) goto L14;
        r5 = "";
    L12:
        throw new IllegalArgumentException(Intrinsics.stringPlus("Excepted a int but get ", this.f11996x));
    }

    public final void c(int r5) {
        if (this.C != r5) goto L5;
        return;
    L5:
        this.C = r5;
        this.f11984k.setColor(r5);
        invalidateSelf();
    }

    public final void d(String r5) {
        if (Intrinsics.areEqual(this.f11996x, r5) == false) goto L5;
        return;
    L5:
        String r10 = b(r5);
        this.f11996x = r10;
        if (r10 == null) goto L10;
        Intrinsics.checkNotNull(r10);
        if (r10.length() <= 0) goto L10;
        this.f11997y = null;
    L10:
        a();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        if (isVisible() == true) goto L6;
        return;
    L6:
        if (this.f11992t == true) goto L9;
        return;
    L9:
        if (this.s == false) goto L12;
        g();
    L12:
        if (this.f11990q > 0.0f) goto L14;
        return;
    L14:
        if (this.f11991r <= 0.0f) goto L31;
        RectF r5 = this.f11987n;
        r5.set(getBounds().left, getBounds().top, getBounds().right, getBounds().bottom);
        float r11 = this.f11991r / 2.0f;
        r10.drawRoundRect(r5, r11, r11, this.f11984k);
        String r12 = this.f11996x;
        if (r12 != null) goto L19;
    L22:
        Integer r13 = this.f11997y;
        if (r13 != null) goto L25;
        return;
    L25:
        if (r13.intValue() == 0) goto L30;
        float r14 = r5.centerX();
        float r15 = r5.centerY();
        Paint r16 = new Paint();
        Integer r17 = this.f11997y;
        Intrinsics.checkNotNull(r17);
        r16.setColor(r17.intValue());
        r16.setAntiAlias(true);
        float r18 = this.f;
        r10.drawCircle(r14, r15, r18, r16);
        float r19 = this.g;
        r10.drawCircle(r14 - r19, r15, r18, r16);
        r10.drawCircle(r14 + r19, r15, r18, r16);
        return;
    L30:
        return;
    L19:
        if (r12.length() == 0) goto L22;
        float r20 = r5.centerX();
        float r21 = r5.centerY();
        TextPaint r22 = this.f11985l;
        r10.drawText(r12, r20, r21 - ((r22.descent() + r22.ascent()) / 2.0f), r22);
        goto L22
    }

    public final void e(boolean r5) {
        if (this.E != r5) goto L5;
        return;
    L5:
        this.E = r5;
        DisplayMetrics r10 = this.f11978a.getResources().getDisplayMetrics();
        TextPaint r11 = this.f11985l;
        if (this.E == false) goto L8;
        float r12 = TypedValue.applyDimension(2, this.F, r10);
    L9:
        r11.setTextSize(r12);
        a();
        return;
    L8:
        r12 = TypedValue.applyDimension(1, this.F, r10);
        goto L9
    }

    public final void f(View r10, View r11) {
        Intrinsics.checkNotNullParameter(r10, "anchor");
        this.f11994v = r10;
        this.f11995w = r11;
        Rect r5 = new Rect();
        if (r11 == null) goto L5;
        int[] r12 = new int[2];
        int[] r13 = new int[2];
        r10.getLocationInWindow(r12);
        r11.getLocationInWindow(r13);
        int r14 = r12[0] - r13[0];
        int r15 = r12[1] - r13[1];
        r5.set(r14, r15, r10.getWidth() + r14, r10.getHeight() + r15);
    L6:
        this.f11993u = new Rect(r5);
        if (ViewCompat.getLayoutDirection(r10) != 1) goto L9;
        boolean r16 = true;
    L10:
        OBadgeDrawable$BadgeGravity r17 = this.A;
        int[] r18 = a.f11977a;
        int r19 = r18[r17.ordinal()];
        if (r19 == 1) goto L20;
        if (r19 == 2) goto L17;
        if (r19 != 3) goto L16;
        int r20 = r5.right;
        int r21 = r20 - ((r20 - r5.left) / 2);
    L24:
        if (r18[this.A.ordinal()] != 3) goto L26;
        int r22 = r5.bottom;
        int r23 = r22 - ((r22 - r5.top) / 2);
    L27:
        this.f11988o = r21 + 0;
        this.f11989p = r23 + this.B;
        this.f11992t = true;
        this.s = true;
        g();
        return;
    L26:
        r23 = r5.top;
        goto L27
    L16:
        throw new NoWhenBranchMatchedException();
    L17:
        if (r16 == false) goto L19;
        r21 = r5.left;
        goto L24
    L19:
        r21 = r5.right;
        goto L24
    L20:
        if (r16 == false) goto L22;
        r21 = r5.right;
        goto L24
    L22:
        r21 = r5.left;
        goto L24
    L9:
        r16 = false;
        goto L10
    L5:
        r10.getDrawingRect(r5);
        goto L6
    }

    public final void g() {
        if (this.f11992t == true) goto L5;
        return;
    L5:
        String r5 = this.f11996x;
        Integer r10 = this.f11997y;
        if (r10 != null) goto L8;
    L10:
        if (r5 != null) goto L12;
    L18:
        float r11 = this.f11980c;
        this.f11990q = r11;
        this.f11991r = r11;
    L19:
        float r12 = this.f11990q / 2.0f;
        float r13 = this.f11991r / 2.0f;
        int r14 = MathKt.roundToInt(this.f11988o - r12);
        int r15 = MathKt.roundToInt(this.f11989p - r13);
        int r16 = MathKt.roundToInt(this.f11988o + r12);
        int r17 = MathKt.roundToInt(this.f11989p + r13);
        Rect r18 = this.f11993u;
        if (r18 == null) goto L34;
        int r19 = a.f11977a[this.A.ordinal()];
        float r20 = this.d;
        if (r19 == 1) goto L28;
        if (r19 != 2) goto L31;
        float r21 = r16 - r18.right;
        if (r21 <= r20) goto L31;
        int r22 = MathKt.roundToInt(r21 - r20);
        r14 = r14 - r22;
        r16 = r16 - r22;
    L31:
        float r23 = r18.top - r15;
        if (r23 <= r20) goto L34;
        int r24 = MathKt.roundToInt(r23 - r20);
        r15 = r15 + r24;
        r17 = r17 + r24;
        goto L34
    L28:
        float r25 = r18.left - r14;
        if (r25 <= r20) goto L31;
        int r26 = MathKt.roundToInt(r25 - r20);
        r14 = r14 + r26;
        r16 = r16 + r26;
    L34:
        setBounds(r14, r15, r16, r17);
        this.s = false;
        return;
    L12:
        if (r5.length() == 0) goto L18;
        TextPaint r27 = this.f11985l;
        int r28 = r5.length();
        Rect r29 = this.f11986m;
        r27.getTextBounds(r5, 0, r28, r29);
        float r30 = (2 * this.f11979b) + (r29.width() + this.f11983j);
        float r31 = this.e;
        float r32 = RangesKt.coerceAtLeast(r30, r31);
        if (r32 > r31) goto L17;
        float r33 = Math.max(r32, r31);
        this.f11990q = r33;
        this.f11991r = r33;
        goto L19
    L17:
        this.f11990q = r32;
        this.f11991r = r31;
        goto L19
    L8:
        if (r10.intValue() == 0) goto L10;
        this.f11990q = this.f11981h;
        this.f11991r = this.f11982i;
        goto L19
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r5) {
        this.f11984k.setAlpha(r5);
        this.f11985l.setAlpha(r5);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r5) {
        this.f11984k.setColorFilter(r5);
        this.f11985l.setColorFilter(r5);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean r5, boolean r10) {
        boolean r11 = super.setVisible(r5, r10);
        if (r11 == false) goto L5;
        invalidateSelf();
    L5:
        return r11;
    }
}
