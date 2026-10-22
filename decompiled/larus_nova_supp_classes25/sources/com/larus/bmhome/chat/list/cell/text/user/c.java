package com.larus.bmhome.chat.list.cell.text.user;

import android.text.TextPaint;
import android.view.View;
import com.larus.bmhome.chat.layout.widget.w0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c extends w0 {
    public final Function1<View, Unit> c;

    /* JADX WARN: Multi-variable type inference failed */
    public c(Function1<? super View, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "onResourceClick");
        super(null, null);
        this.c = r2;
    }

    @Override // com.larus.bmhome.chat.layout.widget.w0, android.text.style.ClickableSpan
    public final void onClick(View r2) {
        Intrinsics.checkNotNullParameter(r2, "widget");
        this.c.invoke(r2);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r2) {
        Intrinsics.checkNotNullParameter(r2, "ds");
        r2.setUnderlineText(false);
    }
}
