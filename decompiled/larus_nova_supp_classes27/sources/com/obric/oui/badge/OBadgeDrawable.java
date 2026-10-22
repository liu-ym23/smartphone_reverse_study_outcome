package com.obric.oui.badge;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import pla.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class OBadgeDrawable extends Drawable {
    public static final /* synthetic */ int G = 0;
    public BadgeGravity A;
    public int B;
    public int C;
    public int D;
    public boolean E;
    public float F;
    public final Context a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final float f;
    public final float g;
    public final float h;
    public final float i;
    public final float j;
    public final Paint k;
    public final TextPaint l;
    public final Rect m;
    public final RectF n;
    public float o;
    public float p;
    public float q;
    public float r;
    public boolean s;
    public boolean t;
    public Rect u;
    public View v;
    public View w;
    public String x;
    public Integer y;
    public int z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/badge/OBadgeDrawable$BadgeGravity;", "", "TOP_START", "TOP_END", "CENTER", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
    public static final enum BadgeGravity extends Enum<BadgeGravity> {
        public static final BadgeGravity CENTER = null;
        public static final BadgeGravity TOP_END = null;
        public static final BadgeGravity TOP_START = null;
        public static final /* synthetic */ BadgeGravity[] a = null;

        public static BadgeGravity valueOf(String r1) {
            return (BadgeGravity) r27.a.a(BadgeGravity.class, r1);
        }

        public static BadgeGravity[] values() {
            return (BadgeGravity[]) a.clone();
        }

        static {
            BadgeGravity r0 = new BadgeGravity("TOP_START", 0);
            TOP_START = r0;
            BadgeGravity r1 = new BadgeGravity("TOP_END", 1);
            TOP_END = r1;
            BadgeGravity r3 = new BadgeGravity("CENTER", 2);
            CENTER = r3;
            a = new BadgeGravity[]{r0, r1, r3};
        }

        public BadgeGravity(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[BadgeGravity.values().length];
            r0[BadgeGravity.TOP_START.ordinal()] = 1;
            r0[BadgeGravity.TOP_END.ordinal()] = 2;
            r0[BadgeGravity.CENTER.ordinal()] = 3;
            a = r0;
        }
    }

    static {
    }

    public final void a() {
        this.s = true;
        invalidateSelf();
        View r0 = this.v;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        f(r0, this.w);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    public final void g() {
        if (this.t == true) goto L5;
        return;
    L5:
        String r0 = this.x;
        Integer r1 = this.y;
        if (r1 != null) goto L8;
    L10:
        if (r0 != null) goto L12;
    L15:
        boolean r2 = true;
    L16:
        if (r2 == false) goto L18;
        float r3 = this.c;
        this.q = r3;
        this.r = r3;
    L22:
        float r4 = this.q / 2.0f;
        float r5 = this.r / 2.0f;
        int r6 = MathKt.roundToInt(this.o - r4);
        int r7 = MathKt.roundToInt(this.p - r5);
        int r8 = MathKt.roundToInt(this.o + r4);
        int r9 = MathKt.roundToInt(this.p + r5);
        Rect r10 = this.u;
        if (r10 == null) goto L37;
        float r11 = this.d;
        int r12 = b.a[this.A.ordinal()];
        if (r12 == 1) goto L31;
        if (r12 != 2) goto L34;
        float r13 = r8 - r10.right;
        if (r13 <= r11) goto L34;
        int r14 = MathKt.roundToInt(r13 - r11);
        r6 = r6 - r14;
        r8 = r8 - r14;
    L34:
        float r15 = r10.top - r7;
        if (r15 <= r11) goto L37;
        int r16 = MathKt.roundToInt(r15 - r11);
        r7 = r7 + r16;
        r9 = r9 + r16;
        goto L37
    L31:
        float r17 = r10.left - r6;
        if (r17 <= r11) goto L34;
        int r18 = MathKt.roundToInt(r17 - r11);
        r6 = r6 + r18;
        r8 = r8 + r18;
    L37:
        setBounds(r6, r7, r8, r9);
        this.s = false;
        return;
    L18:
        this.l.getTextBounds(r0, 0, r0.length(), this.m);
        float r20 = this.m.width() + this.j;
        float r21 = this.b;
        float r22 = this.e;
        float r23 = RangesKt.coerceAtLeast(r20 + (2 * r21), r22);
        if (r23 > r22) goto L21;
        float r24 = Math.max(r23, r22);
        this.q = r24;
        this.r = r24;
        goto L22
    L21:
        this.q = r23;
        this.r = r22;
        goto L22
    L12:
        if (r0.length() == 0) goto L15;
        r2 = false;
        goto L16
    L8:
        if (r1.intValue() == 0) goto L10;
        this.q = this.h;
        this.r = this.i;
        goto L22
    }

    public OBadgeDrawable(Context r8) {
        this.a = r8;
        this.b = d.d(r8, 4.0f);
        d.d(r8, 4.0f);
        this.c = d.d(r8, 8.0f);
        this.d = d.d(r8, 5.0f);
        this.e = d.d(r8, 18.0f);
        Intrinsics.checkNotNullParameter(r8, "<this>");
        this.f = d.d(r8, (float) 1.5d);
        this.g = d.e(r8, 5);
        this.h = d.d(r8, 23.0f);
        this.i = d.d(r8, 18.0f);
        this.j = d.d(r8, 1.0f);
        Paint r0 = new Paint(1);
        r0.setStyle(Paint.Style.FILL);
        r0.setColor(ContextCompat.getColor(r8, 2131105369));
        this.k = r0;
        TextPaint r1 = new TextPaint(1);
        r1.setTextAlign(Paint.Align.CENTER);
        if (Build.VERSION.SDK_INT < 28) goto L5;
        r1.setTypeface(Typeface.create(r1.getTypeface(), 500, false));
    L6:
        r1.setColor(ContextCompat.getColor(r8, 2131109391));
        Intrinsics.checkNotNullParameter(r8, "<this>");
        r1.setTextSize(TypedValue.applyDimension(2, 12.0f, d.a(r8.getResources())));
        this.l = r1;
        this.m = new Rect();
        this.n = new RectF();
        this.s = true;
        this.z = 9999;
        this.A = BadgeGravity.TOP_END;
        this.C = ContextCompat.getColor(r8, 2131105369);
        this.D = ContextCompat.getColor(r8, 2131109391);
        this.E = true;
        this.F = 12.0f;
        return;
    L5:
        r1.setFakeBoldText(true);
        goto L6
    }

    public final String b(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L15;
    L13:
        return r4;
    L15:
        Integer r0 = CastIntegerProtector.valueOf(String.valueOf(r4));     // Catch: Exception -> L11
        if (r0.intValue() <= this.z) goto L8;
        StringBuilder r5 = new StringBuilder();     // Catch: Exception -> L11
        r5.append(this.z);     // Catch: Exception -> L11
        r5.append('+');     // Catch: Exception -> L11
        r4 = r5.toString();     // Catch: Exception -> L11
    L14:
    L8:
        if (r0.intValue() >= 0) goto L14;
        r4 = "";
    L12:
        throw new IllegalArgumentException(Intrinsics.stringPlus("Excepted a int but get ", this.x));
    }

    public final void c(int r2) {
        if (this.C != r2) goto L5;
        return;
    L5:
        this.C = r2;
        this.k.setColor(r2);
        invalidateSelf();
    }

    public final void d(String r2) {
        if (Intrinsics.areEqual(this.x, r2) == false) goto L5;
        return;
    L5:
        String r3 = b(r2);
        this.x = r3;
        if (r3 == null) goto L13;
        Intrinsics.checkNotNull(r3);
        if (r3.length() <= 0) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L13;
        this.y = null;
        goto L13
    L10:
        r4 = false;
    L13:
        a();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r8) {
        Intrinsics.checkNotNullParameter(r8, "canvas");
        if (isVisible() == true) goto L6;
        return;
    L6:
        if (this.t == true) goto L9;
        return;
    L9:
        if (this.s == false) goto L12;
        g();
    L12:
        if (this.q > 0.0f) goto L14;
        return;
    L14:
        if (this.r <= 0.0f) goto L36;
        this.n.set(getBounds().left, getBounds().top, getBounds().right, getBounds().bottom);
        float r0 = this.r / 2.0f;
        r8.drawRoundRect(this.n, r0, r0, this.k);
        String r1 = this.x;
        if (r1 != null) goto L19;
    L22:
        boolean r3 = true;
    L23:
        if (r3 == true) goto L25;
        r8.drawText(r1, this.n.centerX(), this.n.centerY() - ((this.l.ascent() + this.l.descent()) / 2.0f), this.l);
    L25:
        Integer r2 = this.y;
        if (r2 == null) goto L34;
        if (r2 != null) goto L30;
    L31:
        float r4 = this.n.centerX();
        float r5 = this.n.centerY();
        float r6 = this.f;
        Paint r7 = new Paint();
        Integer r9 = this.y;
        Intrinsics.checkNotNull(r9);
        r7.setColor(r9.intValue());
        r7.setAntiAlias(true);
        r8.drawCircle(r4, r5, r6, r7);
        r8.drawCircle(r4 - this.g, r5, r6, r7);
        r8.drawCircle(r4 + this.g, r5, r6, r7);
        return;
    L30:
        if (r2.intValue() != 0) goto L31;
        return;
    L34:
        return;
    L19:
        if (r1.length() == 0) goto L22;
        r3 = false;
        goto L23
    }

    public final void e(boolean r4) {
        if (this.E != r4) goto L5;
        return;
    L5:
        this.E = r4;
        Resources r5 = this.a.getResources();
        DisplayMetrics r6 = WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics());
        TextPaint r0 = this.l;
        if (this.E == false) goto L8;
        float r7 = TypedValue.applyDimension(2, this.F, r6);
    L9:
        r0.setTextSize(r7);
        a();
        return;
    L8:
        r7 = TypedValue.applyDimension(1, this.F, r6);
        goto L9
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r2) {
        this.k.setAlpha(r2);
        this.l.setAlpha(r2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r2) {
        this.k.setColorFilter(r2);
        this.l.setColorFilter(r2);
        invalidateSelf();
    }

    public final void f(View r8, View r9) {
        Intrinsics.checkNotNullParameter(r8, "anchor");
        this.v = r8;
        this.w = r9;
        Rect r0 = new Rect();
        if (r9 == null) goto L5;
        int[] r4 = new int[2];
        int[] r5 = new int[2];
        r8.getLocationInWindow(r4);
        r9.getLocationInWindow(r5);
        int r10 = r4[0] - r5[0];
        int r6 = r4[1] - r5[1];
        r0.set(r10, r6, r8.getWidth() + r10, r8.getHeight() + r6);
    L6:
        this.u = new Rect(r0);
        if (ViewCompat.getLayoutDirection(r8) != 1) goto L9;
        boolean r11 = true;
    L10:
        BadgeGravity r12 = this.A;
        int[] r7 = b.a;
        int r13 = r7[r12.ordinal()];
        if (r13 == 1) goto L20;
        if (r13 == 2) goto L17;
        if (r13 != 3) goto L16;
        int r14 = r0.right;
        int r15 = r14 - ((r14 - r0.left) / 2);
    L24:
        if (r7[this.A.ordinal()] != 3) goto L26;
        int r16 = r0.bottom;
        int r17 = r16 - ((r16 - r0.top) / 2);
    L27:
        this.o = r15 + 0;
        this.p = r17 + this.B;
        this.t = true;
        this.s = true;
        g();
        return;
    L26:
        r17 = r0.top;
        goto L27
    L16:
        throw new NoWhenBranchMatchedException();
    L17:
        if (r11 == false) goto L19;
        r15 = r0.left;
        goto L24
    L19:
        r15 = r0.right;
        goto L24
    L20:
        if (r11 == false) goto L22;
        r15 = r0.right;
        goto L24
    L22:
        r15 = r0.left;
        goto L24
    L9:
        r11 = false;
        goto L10
    L5:
        r8.getDrawingRect(r0);
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean r1, boolean r2) {
        boolean r3 = super.setVisible(r1, r2);
        if (r3 == false) goto L5;
        invalidateSelf();
    L5:
        return r3;
    }
}
