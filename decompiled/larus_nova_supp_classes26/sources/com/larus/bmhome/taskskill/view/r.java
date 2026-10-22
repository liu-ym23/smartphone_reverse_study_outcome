package com.larus.bmhome.taskskill.view;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class r extends ClickableSpan {
    public final /* synthetic */ PcConnectionStatusView a;

    public r(PcConnectionStatusView r1) {
        this.a = r1;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r2) {
        Intrinsics.checkNotNullParameter(r2, "widget");
        PcConnectionStatusView r3 = this.a;
        PcConnectionStatusAction r0 = r3.q;
        if (r0 == null) goto L8;
        Function1<PcConnectionStatusAction, Unit> r4 = r3.getOnActionClick();
        if (r4 == null) goto L9;
        r4.invoke(r0);
        return;
    L9:
        return;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r2) {
        Intrinsics.checkNotNullParameter(r2, "drawState");
        super.updateDrawState(r2);
        r2.setUnderlineText(false);
    }
}
