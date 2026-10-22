package com.bytedance.android.live.liveinteract.interactivesong.impl;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ InteractiveSongWidget a;

    public b(InteractiveSongWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        Integer r6 = (Integer) r5;
        if (InteractiveSongContext.Companion.f() == true) goto L5;
        return;
    L5:
        if (r6 != null) goto L8;
    L9:
        if (r6 != null) goto L12;
    L14:
        if (r6 != null) goto L17;
        return;
    L17:
        if (r6.intValue() != 1) goto L21;
        InteractiveSongWidget r7 = this.a;
        boolean r1 = li0.d.g(null);
        int r2 = InteractiveSongWidget.C;
        r7.Jq(r1, null);
        return;
    L21:
        return;
    L12:
        if (r6.intValue() != 0) goto L14;
    L13:
        InteractiveSongWidget r3 = this.a;
        int r4 = InteractiveSongWidget.C;
        r3.Jq(true, null);
        goto L14
    L8:
        if (r6.intValue() == 4) goto L13;
        goto L9
    }
}
