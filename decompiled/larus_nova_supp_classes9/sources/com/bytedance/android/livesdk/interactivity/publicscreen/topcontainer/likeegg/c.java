package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ CompositeImagePreviewDialog a;

    public c(CompositeImagePreviewDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        if (this.a.k0.length() <= 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L11;
        CompositeImagePreviewDialog r4 = this.a;
        Function1<? super String, Unit> r0 = r4.B;
        if (r0 == null) goto L12;
        Unit r5 = (Unit) r0.invoke(r4.k0);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r3 = false;
        goto L6
    }
}
