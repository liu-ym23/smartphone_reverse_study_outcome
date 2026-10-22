package io.noties.markwon.core.spans;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* JADX INFO: loaded from: classes6.dex */
public class f extends MetricAffectingSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final io.noties.markwon.core.c f16465a;

    public f(io.noties.markwon.core.c r1) {
        this.f16465a = r1;
    }

    private void a(TextPaint r1) {
        this.f16465a.c(r1);
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint r1) {
        a(r1);
        r1.bgColor = this.f16465a.e(r1);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint r1) {
        a(r1);
    }
}
