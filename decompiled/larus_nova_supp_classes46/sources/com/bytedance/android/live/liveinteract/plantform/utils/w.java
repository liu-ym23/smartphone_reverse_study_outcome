package com.bytedance.android.live.liveinteract.plantform.utils;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class w<T> implements Consumer {
    public final /* synthetic */ u a;

    public w(u r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        if (((PublicStreamPlayState) r3).usingMcu() == false) goto L7;
        sh0.i0 r4 = sh0.j0.e(this.a.l);
        if (r4 == null) goto L11;
        int r1 = sh0.h0.a;
        r4.b("is_public_stream_pulling", Boolean.TRUE);
        return;
    L11:
        return;
    L7:
        sh0.i0 r5 = sh0.j0.e(this.a.l);
        if (r5 == null) goto L13;
        int r2 = sh0.h0.a;
        r5.b("is_public_stream_pulling", Boolean.FALSE);
        return;
    }
}
