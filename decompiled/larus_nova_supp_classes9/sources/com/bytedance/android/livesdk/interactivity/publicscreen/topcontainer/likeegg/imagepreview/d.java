package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.imagepreview;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ PreviewItemAdapter a;
    public final /* synthetic */ k b;
    public final /* synthetic */ int c;

    public d(PreviewItemAdapter r1, k r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        k r4 = this.b;
        if (r4 == null) goto L8;
        Function2<? super Integer, ? super k, Unit> r0 = this.a.b;
        if (r0 == null) goto L9;
        Unit r5 = (Unit) r0.invoke(Integer.valueOf(this.c), r4);
        return;
    L9:
        return;
    }
}
