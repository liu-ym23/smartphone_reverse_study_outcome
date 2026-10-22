package com.bytedance.android.live.liveinteract.videotalk.utils;

import com.bytedance.android.live.liveinteract.utils.e0;
import io.reactivex.functions.Consumer;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class p<T> implements Consumer {
    public final /* synthetic */ o a;

    public p(o r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        com.bytedance.android.live.network.response.e r4 = (com.bytedance.android.live.network.response.e) r3;
        if (r4 == null) goto L6;
        SimpleDateFormat r0 = e0.a;
        e0.c(this.a.e, r4, "video_live_link");
        return;
    }
}
