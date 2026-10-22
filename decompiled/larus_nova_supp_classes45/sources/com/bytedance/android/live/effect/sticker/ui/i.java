package com.bytedance.android.live.effect.sticker.ui;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i implements View.OnClickListener {
    public final /* synthetic */ RecommendKeywordView a;

    public i(RecommendKeywordView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        Function0<Unit> r2 = this.a.b;
        if (r2 == null) goto L6;
        Unit r3 = (Unit) r2.invoke();
        return;
    }
}
