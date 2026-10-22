package com.bytedance.android.live.ktv.common.ordersong.view;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements c90.a.c {
    public final /* synthetic */ SongTextSwitcher a;

    @Override // c90.a.c
    public final void bubbleDismiss() {
        Function1<Boolean, Unit> r0 = this.a.getOnWindowStateListener();
        if (r0 == null) goto L5;
        Unit r1 = (Unit) r0.invoke(Boolean.TRUE);
    L5:
        SongTextSwitcher r2 = this.a;
        r2.g = false;
        r2.h = false;
    }

    public b(SongTextSwitcher r1) {
        this.a = r1;
    }
}
