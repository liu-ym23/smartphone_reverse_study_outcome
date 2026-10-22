package com.bytedance.android.live.liveinteract.voicechat.subtitle;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ LinkmicSubtitleBusinessWidget a;

    public e(LinkmicSubtitleBusinessWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        int r3 = ((com.bytedance.android.livesdk.chatroom.viewmodel.i) r2).b;
        if (r3 == 0) goto L6;
        this.a.u = r3;
        return;
    }
}
