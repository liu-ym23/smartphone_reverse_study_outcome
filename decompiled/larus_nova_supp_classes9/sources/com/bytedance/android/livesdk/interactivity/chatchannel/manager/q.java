package com.bytedance.android.livesdk.interactivity.chatchannel.manager;

import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.ChatChannelUtils;
import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class q<T> implements Consumer {
    public final /* synthetic */ ChatChannelGreetingManager a;
    public final /* synthetic */ long b;
    public final /* synthetic */ String c;

    public q(ChatChannelGreetingManager r1, long r2, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    public final void accept(Object r8) {
        Throwable r9 = (Throwable) r8;
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.c(this.b, BuildConfig.FLAVOR, 0, this.c, r9);
        com.bytedance.android.livesdk.interactivity.api.monitor.a.d("room_channel_comment", r9.getMessage(), r9);
        int r0 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.a;
        s22.e r1 = ChatChannelUtils.b(this.a.t);
        if (r1 == null) goto L5;
        s22.a r2 = r1.getChannel(this.b);
    L6:
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.a(r2, "IMEmoji", r9, this.a.k);
        this.a.j = false;
        return;
    L5:
        r2 = null;
        goto L6
    }
}
