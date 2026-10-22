package ck0;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.bytedance.android.live.core.utils.s1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements b {
    public final Context a;

    /* JADX INFO: renamed from: ck0.a$a, reason: collision with other inner class name */
    public static final class C0008a extends MetricAffectingSpan {
        public final /* synthetic */ a a;

        public C0008a(a r1) {
            this.a = r1;
        }

        @Override // android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r3) {
            Intrinsics.checkNotNullParameter(r3, "paint");
            r3.setTypeface(Typeface.createFromAsset(this.a.getContext().getAssets(), "fonts/clarity_mono_bold.otf"));
            r3.setFakeBoldText(false);
            r3.setTextSize(s1.I(14.0f));
        }

        @Override // android.text.style.MetricAffectingSpan
        public final void updateMeasureState(TextPaint r3) {
            Intrinsics.checkNotNullParameter(r3, "paint");
            r3.setTypeface(Typeface.createFromAsset(this.a.getContext().getAssets(), "fonts/clarity_mono_bold.otf"));
            r3.setFakeBoldText(false);
            r3.setTextSize(s1.I(14.0f));
        }
    }

    @Override // ck0.b
    public final MetricAffectingSpan a() {
        return new C0008a(this);
    }

    public final Context getContext() {
        return this.a;
    }

    public a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }
}
