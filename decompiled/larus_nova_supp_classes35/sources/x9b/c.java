package x9b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.LineBackgroundSpan;
import android.text.style.MetricAffectingSpan;
import androidx.core.graphics.ColorUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremd.base.parse.j;
import com.ss.android.lark.coremd.base.parse.k;
import com.ss.android.lark.coremd.base.theme.InlineCodeThemeData;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c extends MetricAffectingSpan implements LineBackgroundSpan {
    public final Context a;
    public final j b;
    public final InlineCodeThemeData c;

    public static final class a {
    }

    static {
    }

    @Override // android.text.style.LineBackgroundSpan
    public final void drawBackground(Canvas r1, Paint r2, int r3, int r4, int r5, int r6, int r7, CharSequence r8, int r9, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r1, "canvas");
        Intrinsics.checkNotNullParameter(r2, "paint");
        Intrinsics.checkNotNullParameter(r8, "text");
    }

    public final void a(TextPaint r6) {
        Context r0 = this.a;
        InlineCodeThemeData r1 = this.c;
        com.ss.android.lark.coremd.ext.c r2 = r1.f;
        KProperty<Object>[] r3 = InlineCodeThemeData.h;
        int r4 = UIUtils.getColor(r0, ((Number) r2.getValue(r1, r3[2])).intValue());
        if (r4 != 0) goto L5;
        r4 = ColorUtils.setAlphaComponent(r6.getColor(), 25);
    L5:
        r6.bgColor = r4;
        Context r5 = this.a;
        InlineCodeThemeData r7 = this.c;
        r6.setColor(UIUtils.getColor(r5, ((Number) r7.e.getValue(r7, r3[1])).intValue()));
        Context r8 = this.a;
        InlineCodeThemeData r9 = this.c;
        int r10 = UIUtils.dp2px(r8, ((Number) r9.g.getValue(r9, r3[3])).intValue());
        if (r10 <= 0) goto L9;
        r6.setTextSize(r10);
        return;
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

    public c(Context r2, j r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "theme");
        this.a = r2;
        this.b = r3;
        this.c = k.b.f(r3);
    }
}
