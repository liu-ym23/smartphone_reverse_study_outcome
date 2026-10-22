package com.bytedance.android.livesdk.interactivity.medialink.ui;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.bytedance.android.live.core.utils.s1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class u implements t {

    public static final class a extends MetricAffectingSpan {
        public a() {
        }

        @Override // android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r2) {
            Intrinsics.checkNotNullParameter(r2, "paint");
            r2.setTypeface(Typeface.DEFAULT);
            r2.setFakeBoldText(true);
            r2.setTextSize(s1.f(12.0f));
            r2.baselineShift = -s1.f(1.0f);
        }

        @Override // android.text.style.MetricAffectingSpan
        public final void updateMeasureState(TextPaint r2) {
            Intrinsics.checkNotNullParameter(r2, "paint");
            r2.setTypeface(Typeface.DEFAULT);
            r2.setFakeBoldText(true);
            r2.setTextSize(s1.f(12.0f));
            r2.baselineShift = -s1.f(1.0f);
        }
    }

    public u() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.ui.t
    public final MetricAffectingSpan a() {
        return new a();
    }
}
