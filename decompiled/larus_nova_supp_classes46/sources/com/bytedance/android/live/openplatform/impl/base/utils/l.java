package com.bytedance.android.live.openplatform.impl.base.utils;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l implements View.OnClickListener {
    public final /* synthetic */ Ref.LongRef a;
    public final /* synthetic */ long b;
    public final /* synthetic */ Function0 c;

    public l(Ref.LongRef r1, long r2, Function0 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        long r0 = System.currentTimeMillis() - this.a.element;
        if (Math.abs(r0) < this.b) goto L7;
        Function0 r8 = this.c;
        if (r8 == null) goto L7;
        Unit r9 = (Unit) r8.invoke();
    L7:
        this.a.element += r0;
    }
}
