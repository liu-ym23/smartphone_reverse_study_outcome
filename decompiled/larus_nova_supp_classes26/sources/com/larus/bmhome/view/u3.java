package com.larus.bmhome.view;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.larus.platform.service.q;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class u3 extends ClickableSpan {
    public final /* synthetic */ MessageRiskWarningTextView a;
    public final /* synthetic */ String b;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r5) {
        Intrinsics.checkNotNullParameter(r5, "widget");
        q.a.e(this.a.getContext(), com.larus.utils.f.c(new Pair[]{TuplesKt.to("link_url", this.b)}), null);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r5) {
        Intrinsics.checkNotNullParameter(r5, "ds");
        super.updateDrawState(r5);
        r5.setUnderlineText(false);
        r5.setColor(ContextCompat.getColor(this.a.getContext(), v19.c.b(2130972125, this.a.getContext(), 2131103209)));
    }

    public u3(MessageRiskWarningTextView r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
