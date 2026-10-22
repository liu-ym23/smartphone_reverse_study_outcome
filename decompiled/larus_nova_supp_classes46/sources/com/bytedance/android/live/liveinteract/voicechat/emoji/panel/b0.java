package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b0<T> implements Consumer {
    public final /* synthetic */ s a;

    public b0(s r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        s r0 = this.a;
        r0.c = false;
        s.a r1 = (s.a) ((q46.b) r0).a;
        if (r1 == null) goto L6;
        r1.U2(r4);
        return;
    }
}
