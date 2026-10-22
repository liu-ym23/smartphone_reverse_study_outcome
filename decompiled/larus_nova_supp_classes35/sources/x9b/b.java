package x9b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.Layout;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.text.style.LineBackgroundSpan;
import android.text.style.MetricAffectingSpan;
import androidx.core.graphics.ColorUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremd.base.parse.j;
import com.ss.android.lark.coremd.base.parse.k;
import com.ss.android.lark.coremd.base.theme.CodeBlockThemeData;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b extends MetricAffectingSpan implements LeadingMarginSpan, LineBackgroundSpan {
    public final Context a;
    public final String b;
    public final j c;
    public final RectF d;
    public final Paint e;
    public final Path f;
    public final TextPaint g;
    public final float[] h;

    public static final class a {
    }

    static {
    }

    @Override // android.text.style.LeadingMarginSpan
    public final void drawLeadingMargin(Canvas r1, Paint r2, int r3, int r4, int r5, int r6, int r7, CharSequence r8, int r9, int r10, boolean r11, Layout r12) {
        Intrinsics.checkNotNullParameter(r1, "c");
        Intrinsics.checkNotNullParameter(r2, "p");
        Intrinsics.checkNotNullParameter(r8, "text");
        Intrinsics.checkNotNullParameter(r12, "layout");
    }

    public final void a(TextPaint r6) {
        CodeBlockThemeData r0 = k.b.d(this.c);
        Context r1 = this.a;
        com.ss.android.lark.coremd.ext.c r2 = r0.e;
        KProperty<Object>[] r3 = CodeBlockThemeData.j;
        int r4 = UIUtils.getColor(r1, ((Number) r2.getValue(r0, r3[1])).intValue());
        if (r4 == 0) goto L5;
        r6.setColor(r4);
        this.g.setColor(r4);
    L6:
        int r5 = ((Number) r0.h.getValue(r0, r3[4])).intValue();
        if (r5 <= 0) goto L9;
        float r7 = UIUtils.dp2px(this.a, r5);
        r6.setTextSize(r7);
        this.g.setTextSize(r7);
        return;
    L9:
        this.g.setTextSize(r6.getTextSize());
        return;
    L5:
        this.g.setColor(r6.getColor());
        goto L6
    }

    @Override // android.text.style.LeadingMarginSpan
    public final int getLeadingMargin(boolean r2) {
        return UIUtils.dp2px(this.a, 8.0f);
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r2) {
        Intrinsics.checkNotNullParameter(r2, "ds");
        a(r2);
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint r2) {
        Intrinsics.checkNotNullParameter(r2, "p");
        a(r2);
    }

    public b(Context r2, String r3, j r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "language");
        Intrinsics.checkNotNullParameter(r4, "theme");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = com.ss.android.lark.coremd.utils.e.b;
        this.e = com.ss.android.lark.coremd.utils.e.c;
        this.f = com.ss.android.lark.coremd.utils.e.e;
        this.g = com.ss.android.lark.coremd.utils.e.d;
        this.h = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    @Override // android.text.style.LineBackgroundSpan
    public final void drawBackground(Canvas r4, Paint r5, int r6, int r7, int r8, int r9, int r10, CharSequence r11, int r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r4, "c");
        Intrinsics.checkNotNullParameter(r5, "p");
        Intrinsics.checkNotNullParameter(r11, "text");
        CodeBlockThemeData r15 = k.b.d(this.c);
        float r16 = UIUtils.dp2px(this.a, ((Number) r15.i.getValue(r15, CodeBlockThemeData.j[5])).floatValue());
        this.e.setStyle(Paint.Style.FILL);
        boolean r17 = r11 instanceof Spanned;
        boolean r0 = true;
        if (r17 == true) goto L5;
    L7:
        boolean r18 = false;
    L8:
        if (r17 == true) goto L10;
    L12:
        r0 = false;
    L13:
        int r19 = 0;
    L15:
        if (r19 >= 8) goto L17;
        this.h[r19] = 0.0f;
        r19 = r19 + 1;
        goto L15
    L17:
        float[] r110 = this.h;
        if (r18 == false) goto L22;
        int r111 = 0;
    L20:
        if (r111 >= 4) goto L22;
        r110[r111] = r16;
        r111 = r111 + 1;
    L22:
        if (r0 == false) goto L26;
        int r112 = 0;
    L24:
        if (r112 >= 4) goto L26;
        r110[r112 + 4] = r16;
        r112 = r112 + 1;
    L26:
        float r20 = r6;
        float r21 = r8;
        this.d.set(r20, r21, r7, r10);
        Path r22 = this.f;
        r22.reset();
        r22.addRoundRect(this.d, r110, Path.Direction.CW);
        if (r18 == false) goto L31;
        com.ss.android.lark.coremd.ext.c r23 = r15.f;
        KProperty<Object>[] r24 = CodeBlockThemeData.j;
        if (((Number) r23.getValue(r15, r24[2])).intValue() == 0) goto L35;
        this.e.setColor(UIUtils.getColor(this.a, ((Number) r15.f.getValue(r15, r24[2])).intValue()));
    L35:
        if (r18 == true) goto L39;
        if (r0 == true) goto L39;
        r4.drawRect(this.d, this.e);
    L40:
        if (r18 == false) goto L46;
        r4.drawText(this.b, r20 + getLeadingMargin(false), r21 + Math.abs(this.g.getFontMetrics().top), this.g);
        return;
    L46:
        return;
    L39:
        r4.drawPath(this.f, this.e);
        goto L40
    L31:
        int r25 = UIUtils.getColor(this.a, ((Number) r15.g.getValue(r15, CodeBlockThemeData.j[3])).intValue());
        if (r25 != 0) goto L34;
        r25 = ColorUtils.setAlphaComponent(r25, 25);
    L34:
        this.e.setColor(r25);
        goto L35
    L10:
        if (((Spanned) r11).getSpanEnd(this) > r13) goto L12;
    L5:
        if (((Spanned) r11).getSpanStart(this) < r12) goto L7;
        r18 = true;
        goto L8
    }
}
