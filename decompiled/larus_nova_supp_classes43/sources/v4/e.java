package v4;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.BackgroundColorSpan;
import com.bytedance.ai.debug.IAISDKDebugService$Gravity;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e extends Drawable {
    public static final int g = 0;
    public static final float h = 0.0f;
    public final Integer a;
    public final IAISDKDebugService$Gravity b;
    public final TextPaint c;
    public final Lazy d;
    public final Rect e;
    public String f;

    public static final class a {
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java", replaceWith = @ReplaceWith(expression = "PixelFormat.OPAQUE", imports = {"android.graphics.PixelFormat"}))
    public final int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r1) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r1) {
    }

    static {
        g = ColorProtector.parseColor("#a6f23131");
        h = 10.0f;
    }

    public e() {
        this(null, IAISDKDebugService$Gravity.BOTTOM_CENTER);
    }

    public final int b() {
        return ((Number) this.d.getValue()).intValue();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        String r0 = this.f;
        if (r0 == null) goto L58;
        boolean r11 = true;
        int r12 = 0;
        if (r0.length() <= 0) goto L7;
        boolean r1 = true;
    L8:
        Integer r13 = null;
        if (r1 == true) goto L12;
        r0 = null;
    L12:
        if (r0 == null) goto L59;
        Integer r14 = Integer.valueOf(getBounds().width());
        if (r14.intValue() <= 0) goto L17;
        boolean r15 = true;
    L18:
        if (r15 == true) goto L21;
        r14 = null;
    L21:
        if (r14 == null) goto L24;
        int r16 = r14.intValue();
    L32:
        int r17 = RangesKt.coerceAtLeast(r16 - b(), 1);
        if (r17 > 0) goto L35;
        return;
    L35:
        SpannableString r18 = new SpannableString(r0);
        Integer r19 = this.a;
        if (r19 == null) goto L38;
        int r20 = r19.intValue();
    L39:
        r18.setSpan(new BackgroundColorSpan(r20), 0, r0.length(), 33);
        if (this.b != IAISDKDebugService$Gravity.BOTTOM_CENTER) goto L42;
        Layout.Alignment r21 = Layout.Alignment.ALIGN_CENTER;
    L43:
        StaticLayout r22 = a(r18, r17, r21);
        int r23 = r22.getHeight();
        Integer r24 = Integer.valueOf(getBounds().height());
        if (r24.intValue() > 0) goto L47;
        r11 = false;
    L47:
        if (r11 == false) goto L49;
        r13 = r24;
    L49:
        if (r13 == null) goto L52;
        r12 = r13.intValue();
    L56:
        int r25 = RangesKt.coerceAtLeast(r12, r23);
        r10.save();
        r10.translate(b(), r25 - r23);
        r22.draw(r10);
        r10.restore();
        return;
    L52:
        if (r10.getClipBounds(this.e) == false) goto L56;
        if (this.e.height() <= 0) goto L56;
        r12 = this.e.height();
        goto L56
    L42:
        r21 = Layout.Alignment.ALIGN_NORMAL;
        goto L43
    L38:
        r20 = g;
        goto L39
    L24:
        if (r10.getClipBounds(this.e) == true) goto L26;
    L28:
        String r26 = this.f;
        if (r26 == null) goto L31;
        r16 = RangesKt.coerceAtLeast((int) this.c.measureText(r26), 1);
        goto L32
    L31:
        r16 = 0;
        goto L32
    L26:
        if (this.e.width() <= 0) goto L28;
        r16 = this.e.width();
        goto L32
    L17:
        r15 = false;
        goto L18
    L59:
        return;
    L7:
        r1 = false;
        goto L8
    }

    public e(Integer r10, IAISDKDebugService$Gravity r11) {
        Intrinsics.checkNotNullParameter(r11, "gravity");
        this.a = r10;
        this.b = r11;
        TextPaint r12 = new TextPaint();
        r12.setTextSize(n2.a.a(Float.valueOf(13.0f)));
        r12.setColor(-1);
        r12.setTextAlign(Paint.Align.LEFT);
        this.c = r12;
        this.d = LazyKt.lazy(new d(this));
        this.e = new Rect();
    }

    public final StaticLayout a(CharSequence r10, int r11, Layout.Alignment r12) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        StaticLayout r13 = StaticLayout.Builder.obtain(r10, 0, r10.length(), this.c, r11).setAlignment(r12).setLineSpacing(0.0f, 1.0f).setIncludePad(false).build();
        Intrinsics.checkNotNull(r13);
        return r13;
    L6:
        return new StaticLayout(r10, this.c, r11, r12, 1.0f, 0.0f, false);
    }
}
