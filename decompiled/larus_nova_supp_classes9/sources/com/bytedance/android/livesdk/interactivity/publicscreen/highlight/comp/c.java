package com.bytedance.android.livesdk.interactivity.publicscreen.highlight.comp;

import android.widget.TextView;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.PSHighlightRenderHelper;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ PSHighlightCommonComp a;

    public c(PSHighlightCommonComp r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        o42.b r3 = (o42.b) r2;
        PSHighlightCommonComp r4 = this.a;
        PSHighlightRenderHelper.b(r4.e, r4.g);
        PSHighlightCommonComp r5 = this.a;
        if (PSHighlightCommonComp.r(r5, r5.k) == false) goto L9;
        TextView r6 = this.a.g;
        if (r6 == null) goto L10;
        r6.post(new d(r6));
        return;
    L10:
        return;
    }
}
