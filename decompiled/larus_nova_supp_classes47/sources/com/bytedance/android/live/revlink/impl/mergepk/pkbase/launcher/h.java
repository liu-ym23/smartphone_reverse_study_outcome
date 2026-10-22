package com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ PkAnchorLauncher a;

    public h(PkAnchorLauncher r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Long r4 = (Long) r3;
        this.a.h.setValue(c21.c.C0008c.a);
        this.a.l.setValue(new a.c(null));
    }
}
