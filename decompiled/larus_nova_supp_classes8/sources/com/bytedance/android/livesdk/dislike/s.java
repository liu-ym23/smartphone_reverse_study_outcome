package com.bytedance.android.livesdk.dislike;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s implements View.OnClickListener {
    public final /* synthetic */ LongPressGuideView a;

    public s(LongPressGuideView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        LongPressGuideView r3 = this.a;
        Function1<? super View, Unit> r0 = r3.b;
        if (r0 == null) goto L6;
        Unit r4 = (Unit) r0.invoke(r3);
        return;
    }
}
