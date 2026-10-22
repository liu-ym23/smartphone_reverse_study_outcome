package com.larus.bmhome.bot;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class p5 implements com.larus.common_ui.dialog.u {
    public final /* synthetic */ Function1<Boolean, Unit> a;

    public final void cancel() {
        Function1<Boolean, Unit> r0 = this.a;
        if (r0 == null) goto L6;
        r0.invoke(Boolean.FALSE);
        return;
    }

    public p5(n0 r1) {
        this.a = r1;
    }
}
