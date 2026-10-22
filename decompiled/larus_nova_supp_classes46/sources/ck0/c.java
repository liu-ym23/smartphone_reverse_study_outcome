package ck0;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.bytedance.android.live.core.utils.s1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements b {

    public static final class a extends MetricAffectingSpan {
        public a() {
        }

        @Override // android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r2) {
            Intrinsics.checkNotNullParameter(r2, "paint");
            r2.setTypeface(Typeface.DEFAULT);
            r2.setFakeBoldText(true);
            r2.setTextSize(s1.I(12.0f));
            r2.baselineShift = -((int) s1.I(1.0f));
        }

        @Override // android.text.style.MetricAffectingSpan
        public final void updateMeasureState(TextPaint r2) {
            Intrinsics.checkNotNullParameter(r2, "paint");
            r2.setTypeface(Typeface.DEFAULT);
            r2.setFakeBoldText(true);
            r2.setTextSize(s1.I(12.0f));
            r2.baselineShift = -((int) s1.I(1.0f));
        }
    }

    public c() {
    }

    @Override // ck0.b
    public final MetricAffectingSpan a() {
        return new a();
    }
}
