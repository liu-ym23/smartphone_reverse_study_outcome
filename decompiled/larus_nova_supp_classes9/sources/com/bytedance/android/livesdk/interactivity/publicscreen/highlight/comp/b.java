package com.bytedance.android.livesdk.interactivity.publicscreen.highlight.comp;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.o;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ PSHighlightCommonComp a;

    public b(PSHighlightCommonComp r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Long r4 = (Long) r3;
        if (this.a.g() == true) goto L5;
        this.a.s(false, new PSHighlightCommonComp$countdownDismiss$1$1(this));
        return;
    L5:
        o.c("highlight common comp is destroyed");
    }
}
