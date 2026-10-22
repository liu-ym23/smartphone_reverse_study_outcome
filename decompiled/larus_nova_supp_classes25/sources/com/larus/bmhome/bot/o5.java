package com.larus.bmhome.bot;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class o5 implements com.larus.common_ui.dialog.p0 {
    public final /* synthetic */ Function1<Boolean, Unit> a;

    public final void confirm() {
        Function1<Boolean, Unit> r0 = this.a;
        if (r0 == null) goto L6;
        r0.invoke(Boolean.TRUE);
        return;
    }

    public o5(n0 r1) {
        this.a = r1;
    }
}
