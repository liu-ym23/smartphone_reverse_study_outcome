package com.bytedance.android.live.liveinteract.voicechat.subtitle;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ LinkmicSubtitleBusinessWidget a;

    public d(LinkmicSubtitleBusinessWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Long r4 = (Long) r3;
        this.a.h.put("enterRoomSmooth", Boolean.FALSE);
    }
}
