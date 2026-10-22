package com.bytedance.android.livesdk.interactivity.medialink.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.bytedance.android.live.core.utils.s1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class s implements t {
    public final Context a;

    public static final class a extends MetricAffectingSpan {
        public final /* synthetic */ s a;

        public a(s r1) {
            this.a = r1;
        }

        @Override // android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r3) {
            Intrinsics.checkNotNullParameter(r3, "paint");
            r3.setTypeface(Typeface.createFromAsset(this.a.getContext().getAssets(), "fonts/clarity_mono_bold.otf"));
            r3.setFakeBoldText(false);
            r3.setTextSize(s1.f(14.0f));
        }

        @Override // android.text.style.MetricAffectingSpan
        public final void updateMeasureState(TextPaint r3) {
            Intrinsics.checkNotNullParameter(r3, "paint");
            r3.setTypeface(Typeface.createFromAsset(this.a.getContext().getAssets(), "fonts/clarity_mono_bold.otf"));
            r3.setFakeBoldText(false);
            r3.setTextSize(s1.f(14.0f));
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.ui.t
    public final MetricAffectingSpan a() {
        return new a(this);
    }

    public final Context getContext() {
        return this.a;
    }

    public s(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }
}
