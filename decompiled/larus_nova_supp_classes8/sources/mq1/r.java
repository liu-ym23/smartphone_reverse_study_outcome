package mq1;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerProgressServiceContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.IReplayInnerProgressService;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface r {
    IReplayInnerProgressService a(DataCenter r1);

    com.bytedance.android.livesdk.chatroom.vs_base.player.seekbar.b c(Context r1, ReplayDataContext r2, PlayerProgressServiceContext r3);

    void d();

    dl1.e f(vq1.b.a r1, long r2, String r4, com.bytedance.android.livesdk.chatroom.vs_base.session.video.a r5, DataCenter r6);

    void g();

    void h(long r1, Bundle r3, vq1.a r4);

    tk1.e i();

    void releaseService(DataCenter r1);
}
