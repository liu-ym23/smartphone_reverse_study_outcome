package com.ss.android.lark.officesdk.minutes.ui.foundation.widget;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class f implements View.OnClickListener {
    public long a;
    public final /* synthetic */ long b;
    public final /* synthetic */ Function1<View, Unit> c;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        Intrinsics.checkNotNullParameter(r8, "v");
        long r0 = System.currentTimeMillis();
        if ((r0 - this.a) < this.b) goto L6;
        this.a = r0;
        this.c.invoke(r8);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(long r1, Function1<? super View, Unit> r3) {
        this.b = r1;
        this.c = r3;
    }
}
