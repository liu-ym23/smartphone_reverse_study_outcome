package com.larus.business.markdown.impl.markwon.custom.title;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b extends ClickableSpan {
    public final c a;
    public final gw8.a b;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r3) {
        Intrinsics.checkNotNullParameter(r3, "widget");
        this.b.a(r3, this.a);
        if ((r3 instanceof TextView) == false) goto L5;
        TextView r4 = (TextView) r3;
    L6:
        if (r4 == null) goto L10;
        r4.setHighlightColor(0);
        return;
    L10:
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r2) {
        Intrinsics.checkNotNullParameter(r2, "ds");
        r2.setUnderlineText(false);
    }

    public b(c r2, gw8.a r3) {
        Intrinsics.checkNotNullParameter(r2, "fullScreenDetailInfoSpan");
        Intrinsics.checkNotNullParameter(r3, "listener");
        this.a = r2;
        this.b = r3;
    }
}
