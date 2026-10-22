package com.bytedance.android.live.liveinteract.interactivesong.panel;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ InteractiveSongMvManager a;

    public b(InteractiveSongMvManager r1) {
        this.a = r1;
    }

    public final void accept(Object r6) {
        Long r7 = (Long) r6;
        long r0 = System.currentTimeMillis();
        InteractiveSongMvManager r8 = this.a;
        if ((r0 - r8.p) <= r8.a) goto L11;
        com.bytedance.android.livesdk.ktvapi.model.mv.c r9 = r8.i;
        if (r9 == null) goto L9;
        com.bytedance.android.livesdk.ktvapi.model.mv.h r10 = r9.a();
        if (r10 == null) goto L9;
        r10.pause();
    L9:
        this.a.m = false;
        return;
    }
}
