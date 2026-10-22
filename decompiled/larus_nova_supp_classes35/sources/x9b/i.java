package x9b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;
import android.text.style.LineHeightSpan;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremd.base.parse.j;
import com.ss.android.lark.coremd.base.parse.k;
import com.ss.android.lark.coremd.base.theme.ThematicBreakThemeData;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i implements LeadingMarginSpan, LineHeightSpan {
    public final Context a;
    public final j b;
    public final Rect c;
    public final Paint d;

    @Override // android.text.style.LeadingMarginSpan
    public final int getLeadingMargin(boolean r1) {
        return 0;
    }

    public i(Context r2, j r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "theme");
        this.a = r2;
        this.b = r3;
        this.c = com.ss.android.lark.coremd.utils.e.a;
        this.d = com.ss.android.lark.coremd.utils.e.c;
    }

    @Override // android.text.style.LineHeightSpan
    public final void chooseHeight(CharSequence r1, int r2, int r3, int r4, int r5, Paint.FontMetricsInt r6) {
        Intrinsics.checkNotNullParameter(r1, "text");
        Intrinsics.checkNotNullParameter(r6, "fm");
        r6.ascent = -10;
        r6.descent = 10;
        r6.top = 0;
        r6.bottom = 0;
    }

    @Override // android.text.style.LeadingMarginSpan
    public final void drawLeadingMargin(Canvas r2, Paint r3, int r4, int r5, int r6, int r7, int r8, CharSequence r9, int r10, int r11, boolean r12, Layout r13) {
        Intrinsics.checkNotNullParameter(r2, "c");
        Intrinsics.checkNotNullParameter(r3, "p");
        Intrinsics.checkNotNullParameter(r9, "text");
        Intrinsics.checkNotNullParameter(r13, "layout");
        ThematicBreakThemeData r14 = k.b.i(this.b);
        int r15 = r6 + ((r8 - r6) / 2);
        this.d.set(r3);
        Paint r16 = this.d;
        Context r17 = this.a;
        com.ss.android.lark.coremd.ext.c r18 = r14.e;
        KProperty<Object>[] r19 = ThematicBreakThemeData.g;
        r16.setColor(UIUtils.getColor(r17, ((Number) r18.getValue(r14, r19[1])).intValue()));
        this.d.setStyle(Paint.Style.FILL);
        this.d.setStrokeWidth(UIUtils.dp2px(this.a, ((Number) r14.f.getValue(r14, r19[2])).intValue()));
        int r20 = MathKt.roundToInt(this.d.getStrokeWidth()) / MathKt.roundToInt(2.0f);
        if (r5 <= 0) goto L5;
        int r21 = r2.getWidth();
    L6:
        this.c.set(r4, r15 - r20, r21, r15 + r20);
        r2.drawRect(this.c, this.d);
        return;
    L5:
        r21 = r4;
        r4 = r4 - r2.getWidth();
        goto L6
    }
}
