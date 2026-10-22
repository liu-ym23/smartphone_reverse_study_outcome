package pb2;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.bytedance.live.richcontent.model.style.ImageStyle;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class a extends lk6.c {
    public jb2.b m;

    public a(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        super(r2);
    }

    public final void g(ImageStyle r8, int r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "style");
        int r1 = com.bytedance.live.richcontent.utils.b.a;
        Intrinsics.checkNotNullParameter(this, "span");
        Intrinsics.checkNotNullParameter(r8, "style");
        Intrinsics.checkNotNullParameter(r8, "style");
        int r0 = r8.b;
        int r2 = r8.c;
        float r3 = r8.d;
        int r4 = com.bytedance.live.richcontent.utils.a.a[r8.a.ordinal()];
        if (r4 != 1) goto L5;
        r2 = r9;
        r0 = r10;
    L26:
        if (r2 <= 0) goto L31;
        if (r0 <= 0) goto L31;
        r10 = r0;
        r9 = r2;
    L31:
        if (r9 <= 0) goto L33;
        if (r10 <= 0) goto L33;
    L34:
        if (r9 <= 0) goto L54;
        if (r10 <= 0) goto L54;
        int r5 = r8.e;
        if (r5 <= 0) goto L39;
    L40:
        float r6 = 1.0f;
        if (r10 <= r5) goto L44;
        if (r5 <= 0) goto L44;
        float r7 = r5 / r10;
    L45:
        int r11 = r8.f;
        if (r9 <= r11) goto L49;
        if (r11 <= 0) goto L49;
        r6 = r11 / r9;
    L49:
        float r13 = RangesKt.coerceAtMost(r7, r6);
        if (r13 <= 0) goto L54;
        if (r13 >= 1) goto L54;
        r9 = (int) (r9 * r13);
        r10 = (int) (r10 * r13);
    L44:
        r7 = 1.0f;
        goto L45
    L39:
        if (r8.f > 0) goto L40;
    L54:
        Pair r14 = new Pair(Integer.valueOf(r9), Integer.valueOf(r10));
        setWidthAndHeight(((Number) r14.component1()).intValue(), ((Number) r14.component2()).intValue());
        int r15 = r8.n;
        int r16 = r8.o;
        ((lk6.c) this).e = r15;
        ((lk6.c) this).f = r16;
        ((lk6.c) this).c = r8.l.getValue();
        ((lk6.c) this).d = r8.m;
        f(r8.t);
        c(r8.u);
        d(r8.r);
        e(r8.s);
        ((lk6.c) this).g = r8.q;
        ((lk6.c) this).h = r8.p;
        return;
    L33:
        r9 = 0;
        r10 = 0;
        goto L34
    L5:
        if (r4 == 2) goto L26;
        if (r4 == 3) goto L23;
        float r17 = 0.0f;
        if (r4 != 4) goto L11;
        float r18 = r0;
        if (r10 == 0) goto L22;
        r17 = r9 / r10;
    L22:
        r2 = (int) (r18 * r17);
        goto L26
    L11:
        if (r4 != 5) goto L17;
        float r19 = r2;
        if (r9 != 0) goto L15;
        r3 = 0.0f;
    L24:
        r0 = (int) (r19 * r3);
        goto L26
    L15:
        r3 = r10 / r9;
        goto L24
    L17:
        throw new NoWhenBranchMatchedException();
    L23:
        r2 = (int) (r9 * r3);
        r19 = r10;
        goto L24
    }

    public int getSize(Paint r2, CharSequence r3, int r4, int r5, Paint.FontMetricsInt r6) {
        Intrinsics.checkNotNullParameter(r2, "paint");
        int r7 = super.getSize(r2, r3, r4, r5, r6);
        if (r6 == null) goto L5;
        int r8 = b(r2.getFontMetricsInt());
        r6.top = r8;
        r6.ascent = r8;
        int r9 = ((lk6.c) this).b;
        r6.bottom = r9 + r8;
        r6.descent = r9 + r8;
    L5:
        return r7;
    }
}
