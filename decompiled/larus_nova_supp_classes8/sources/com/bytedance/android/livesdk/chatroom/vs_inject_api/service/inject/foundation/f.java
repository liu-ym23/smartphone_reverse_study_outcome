package com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation;

import android.content.Context;
import com.bytedance.android.live.base.model.message.q5;
import com.bytedance.android.live.base.model.message.r5;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface f {
    void a(vlc.d r1, Map<String, String> r2);

    vlc.d c(Context r1, long r2, String r4, ylc.e r5, String r6);

    void d(vlc.d r1);

    ylc.e f(long r1);

    void g();

    void h(vlc.d r1, String r2);

    q5 i();

    r5 j();

    void k();

    vlc.d n(DataCenter r1);

    vlc.d provideSeekMessageManager(Context r1, DataCenter r2, boolean r3, long r4, long r6, int r8, long r9);
}
