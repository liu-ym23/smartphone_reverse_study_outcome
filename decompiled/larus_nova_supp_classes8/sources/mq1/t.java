package mq1;

import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.IReplayInnerProgressService;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface t {
    p a(DataCenter r1);

    u provideVSPlayerTipService(DataCenter r1);

    v provideVSPlayerViewControlService(DataCenter r1);

    IReplayInnerProgressService provideVSProgressService(DataCenter r1);

    void releaseService(DataCenter r1);
}
