package wpb;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.Flowable;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements e {
    public final String a;
    public final int b;
    public final int c;
    public final Integer d;

    public static final class a {
    }

    static {
    }

    @Override // wpb.e
    public final Flowable<Bitmap> a(Drawable r9) {
        Bitmap r10 = Bitmap.createBitmap(this.b, this.c, Bitmap.Config.ARGB_8888);
        Canvas r0 = new Canvas(r10);
        String r1 = this.a;
        int r2 = 0;
        if (r1 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == true) goto L50;
        int r5 = 0;
    L13:
        if (r5 >= r1.length()) goto L50;
        char r6 = r1.charAt(r5);
        int r7 = ypb.b.a;
        if (r6 == 8205) goto L46;
        if (r6 != 0) goto L18;
    L45:
        boolean r8 = false;
    L47:
        if (r8 == true) goto L48;
        r5 = r5 + 1;
        goto L13
    L48:
        boolean r3 = true;
    L51:
        if (r3 == false) goto L53;
        String r11 = this.a;
    L54:
        Paint r12 = new Paint();
        if (this.d == null) goto L57;
        r2 = UDColorUtils.getColor(LarkContext.getApplication(), this.d.intValue());
    L57:
        r12.setColor(r2);
        r12.setStyle(Paint.Style.FILL);
        r12.setTextSize(UIUtils.sp2px(LarkContext.getApplication(), 24.0f));
        int r13 = h18.e.a;
        r12.setTypeface(h18.e.b(LarkContext.getApplication(), 1));
        Paint.FontMetrics r14 = r12.getFontMetrics();
        float r15 = 2;
        r0.drawText(r11, (this.b - r12.measureText(r11)) / r15, (this.c / 2) - ((r14.descent + r14.ascent) / r15), r12);
        return Flowable.just(r10);
    L53:
        r11 = this.a.toUpperCase(Locale.ROOT);
        goto L54
    L18:
        if (r6 == '\t') goto L45;
        if (r6 == '\n') goto L45;
        if (r6 == '\r') goto L45;
        if (' ' <= r6) goto L26;
    L28:
        boolean r16 = false;
    L29:
        if (r16 == true) goto L45;
        if (57344 <= r6) goto L33;
    L35:
        boolean r17 = false;
    L36:
        if (r17 == true) goto L45;
        if (0 <= r6) goto L40;
    L42:
        boolean r18 = false;
    L43:
        if (r18 == true) goto L45;
    L40:
        if (r6 >= 0) goto L42;
        r18 = true;
        goto L43
    L33:
        if (r6 >= 65534) goto L35;
        r17 = true;
        goto L36
    L26:
        if (r6 >= 55296) goto L28;
        r16 = true;
    L46:
        r8 = true;
    L50:
        r3 = false;
        goto L51
    L5:
        if (r1.length() == 0) goto L8;
        r4 = false;
        goto L9
    }

    public f(String r2, int r3, int r4, Integer r5) {
        Intrinsics.checkNotNullParameter(r2, "text");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
