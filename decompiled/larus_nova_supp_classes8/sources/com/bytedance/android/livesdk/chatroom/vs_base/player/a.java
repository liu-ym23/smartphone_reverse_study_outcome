package com.bytedance.android.livesdk.chatroom.vs_base.player;

import com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface a {
    IPlayerProgressService a(DataCenter r1);

    void releaseService(DataCenter r1);
}
