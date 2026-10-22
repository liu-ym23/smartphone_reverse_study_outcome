package com.bytedance.android.livesdk.interactivity.interactive;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ LiveInteractiveAnnieXHelper a;

    public e(LiveInteractiveAnnieXHelper r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        if (((Boolean) r4).booleanValue() == true) goto L5;
        this.a.p(false);
        return;
    L5:
        if (this.a.c() != true) goto L13;
        LiveInteractiveAnnieXHelper r5 = this.a;
        if (r5.m == 1) goto L9;
        return;
    L9:
        if (r5.l != 0) goto L15;
        r5.s(false);
        return;
    L15:
        return;
    }
}
