package com.bytedance.android.livesdk.interactivity.interactive;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b0<T> implements Consumer {
    public final /* synthetic */ LiveInteractiveHelper a;

    public b0(LiveInteractiveHelper r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        if (((Boolean) r4).booleanValue() == true) goto L5;
        this.a.p(false);
        return;
    L5:
        if (this.a.c() != true) goto L13;
        LiveInteractiveHelper r5 = this.a;
        if (r5.k == 1) goto L9;
        return;
    L9:
        if (r5.j != 0) goto L15;
        r5.s(false);
        return;
    L15:
        return;
    }
}
