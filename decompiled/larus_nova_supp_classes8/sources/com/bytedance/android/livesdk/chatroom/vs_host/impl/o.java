package com.bytedance.android.livesdk.chatroom.vs_host.impl;

import com.bytedance.android.livesdk.interactivity.interactive.j0;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o implements com.bytedance.android.live.platformplayer.utils.h {
    public final /* synthetic */ Function1 a;

    public o(j0 r1) {
        this.a = r1;
    }

    public final void a(ILivePlayerClient r2) {
        this.a.invoke(r2.getEventHub());
    }
}
