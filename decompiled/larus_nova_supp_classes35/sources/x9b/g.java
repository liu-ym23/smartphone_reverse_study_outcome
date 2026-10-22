package x9b;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.coremd.base.parse.j;
import com.ss.android.lark.coremd.base.parse.k;
import com.ss.android.lark.coremd.base.theme.HeadingThemeData;
import com.ss.android.lark.coremd.ext.m;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g extends MetricAffectingSpan {
    public final j a;
    public final int b;

    public final void a(TextPaint r6) {
        HeadingThemeData r0 = k.b.e(this.a);
        m r1 = r0.e;
        KProperty<Object>[] r2 = HeadingThemeData.g;
        if (((Typeface) r1.getValue(r0, r2[1])) == null) goto L5;
        r6.setTypeface((Typeface) r0.e.getValue(r0, r2[1]));
    L5:
        r6.setFakeBoldText(true);
        List<Float> r3 = r0.h();
        if (r3.size() < this.b) goto L9;
        r6.setTextSize(r6.getTextSize() * ((Number) ListProtector.get(r3, this.b - 1)).floatValue());
        return;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r2) {
        Intrinsics.checkNotNullParameter(r2, "tp");
        a(r2);
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint r2) {
        Intrinsics.checkNotNullParameter(r2, "p");
        a(r2);
    }

    public g(j r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "theme");
        this.a = r2;
        this.b = r3;
    }
}
