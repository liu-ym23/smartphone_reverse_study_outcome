package com.larus.dora.impl.feedback;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class i0 extends ClickableSpan {
    public final /* synthetic */ DoraGFeedbackFragment a;
    public final /* synthetic */ int b;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r2) {
        Intrinsics.checkNotNullParameter(r2, "widget");
        DoraGFeedbackFragment r3 = this.a;
        int r0 = DoraGFeedbackFragment.r;
        r3.Z90(false);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r2) {
        Intrinsics.checkNotNullParameter(r2, "ds");
        r2.setColor(this.b);
        r2.setUnderlineText(false);
    }

    public i0(DoraGFeedbackFragment r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
