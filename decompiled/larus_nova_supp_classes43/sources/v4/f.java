package v4;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import com.bytedance.ai.debug.IAISDKDebugService$Gravity;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Deprecated;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f extends Drawable implements com.bytedance.ai.debug.e {
    public static final int h = 0;
    public static final int i = 0;
    public static final float j = 0.0f;
    public static final float k = 0.0f;
    public static final float l = 0.0f;
    public static final float m = 0.0f;
    public static final float n = 0.0f;
    public static final float o = 0.0f;
    public static final float p = 0.0f;
    public static final float q = 0.0f;
    public static final float r = 0.0f;
    public final IAISDKDebugService$Gravity a;
    public final TextPaint b;
    public final Paint c;
    public final RectF d;
    public String e;
    public Float f;
    public Float g;

    public static final class a {
        public final float a;
        public final float b;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (Float.compare(this.a, r11.a) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.b, r11.b) == 0) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b);
        }

        public final String toString() {
            return "BadgeSize(width=" + this.a + ", height=" + this.b + ')';
        }

        public a(float r1, float r10) {
            this.a = r1;
            this.b = r10;
        }
    }

    public static final class b {
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[IAISDKDebugService$Gravity.values().length];
            r0[IAISDKDebugService$Gravity.TOP_LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[IAISDKDebugService$Gravity.TOP_RIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[IAISDKDebugService$Gravity.BOTTOM_RIGHT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[IAISDKDebugService$Gravity.BOTTOM_LEFT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[IAISDKDebugService$Gravity.BOTTOM_CENTER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java")
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r1) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r1) {
    }

    static {
        h = ColorProtector.parseColor("#CC53493D");
        i = -1;
        Float r0 = Float.valueOf(12.0f);
        j = n2.a.a(r0);
        k = n2.a.a(Float.valueOf(7.0f));
        Float r1 = Float.valueOf(10.0f);
        l = n2.a.a(r1);
        m = n2.a.a(r0);
        n = n2.a.a(r0);
        o = n2.a.a(r0);
        p = n2.a.a(r0);
        q = n2.a.a(r0);
        r = n2.a.a(r1);
    }

    public f() {
        this(IAISDKDebugService$Gravity.BOTTOM_LEFT);
    }

    public final a d() {
        float r0 = this.b.measureText(this.e);
        Paint.FontMetrics r1 = this.b.getFontMetrics();
        float r10 = r1.bottom - r1.top;
        return new a((j * 2.0f) + r0, r10 + (k * 2.0f));
    }

    public f(IAISDKDebugService$Gravity r10) {
        Intrinsics.checkNotNullParameter(r10, "gravity");
        this.a = r10;
        TextPaint r11 = new TextPaint(1);
        r11.setColor(i);
        r11.setTextSize(n2.a.a(Float.valueOf(14.0f)));
        r11.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        this.b = r11;
        Paint r12 = new Paint(1);
        r12.setColor(h);
        r12.setStyle(Paint.Style.FILL);
        this.c = r12;
        this.d = new RectF();
        this.e = "";
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        if (StringsKt.isBlank(this.e) == false) goto L5;
        return;
    L5:
        RectF r0 = c(getBounds().width(), getBounds().height());
        if (r0.width() > 0.0f) goto L8;
        return;
    L8:
        if (r0.height() <= 0.0f) goto L13;
        float r1 = l;
        r10.drawRoundRect(r0, r1, r1, this.c);
        r10.drawText(this.e, r0.left + j, r0.centerY() - ((this.b.descent() + this.b.ascent()) / 2.0f), this.b);
        return;
    }

    @Override // com.bytedance.ai.debug.e
    public final RectF a(int r10, int r11) {
        return new RectF(c(r10, r11));
    }

    public final RectF c(float r13, float r14) {
        if (r13 > 0.0f) goto L5;
    L39:
        this.d.setEmpty();
        return this.d;
    L5:
        if (r14 <= 0.0f) goto L39;
        if (StringsKt.isBlank(this.e) == true) goto L39;
        a r1 = d();
        float r10 = RangesKt.coerceAtLeast(r13 - r1.a, 0.0f);
        float r11 = RangesKt.coerceAtLeast(r14 - r1.b, 0.0f);
        IAISDKDebugService$Gravity r12 = this.a;
        int[] r15 = c.a;
        int r16 = r15[r12.ordinal()];
        if (r16 == 1) goto L19;
        if (r16 == 2) goto L18;
        if (r16 == 3) goto L18;
        if (r16 == 4) goto L18;
        if (r16 == 5) goto L18;
        throw new NoWhenBranchMatchedException();
    L18:
        float r17 = RangesKt.coerceAtLeast((r13 - n) - r1.a, 0.0f);
    L20:
        int r18 = r15[this.a.ordinal()];
        if (r18 == 1) goto L30;
        if (r18 == 2) goto L30;
        if (r18 == 3) goto L29;
        if (r18 == 4) goto L29;
        if (r18 == 5) goto L29;
        throw new NoWhenBranchMatchedException();
    L29:
        float r19 = RangesKt.coerceAtLeast((r14 - p) - r1.b, 0.0f);
    L31:
        Float r20 = this.f;
        if (r20 == null) goto L34;
        r17 = r20.floatValue();
    L34:
        float r21 = RangesKt.coerceIn(r17, 0.0f, r10);
        Float r22 = this.g;
        if (r22 == null) goto L37;
        r19 = r22.floatValue();
    L37:
        float r0 = RangesKt.coerceIn(r19, 0.0f, r11);
        this.d.set(r21, r0, RangesKt.coerceAtMost(r1.a + r21, r13), RangesKt.coerceAtMost(r1.b + r0, r14));
        return this.d;
    L30:
        r19 = RangesKt.coerceAtLeast(o, 0.0f);
        goto L31
    L19:
        r17 = RangesKt.coerceAtLeast(m, 0.0f);
        goto L20
    }

    @Override // com.bytedance.ai.debug.e
    public final void b(int r10, int r11, float r12, float r13) {
        if (r10 <= 0) goto L9;
        if (r11 > 0) goto L5;
        return;
    L5:
        if (StringsKt.isBlank(this.e) == true) goto L11;
        a r0 = d();
        float r14 = RangesKt.coerceAtLeast(r10 - r0.a, 0.0f);
        float r15 = RangesKt.coerceAtLeast(r11 - r0.b, 0.0f);
        this.f = Float.valueOf(RangesKt.coerceIn(r12, 0.0f, r14));
        this.g = Float.valueOf(RangesKt.coerceIn(r13, 0.0f, r15));
        invalidateSelf();
        return;
    L11:
        return;
    }
}
