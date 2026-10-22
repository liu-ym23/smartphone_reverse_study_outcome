package mq1;

import com.bytedance.android.livesdk.chatroom.replay.player.viewcontrol.ReplayPlayerBackgroundWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface s {
    p a(DataCenter r1);

    j70.h<? extends h70.b> c(String r1);

    bl1.m d();

    ReplayPlayerBackgroundWidget f();

    aq1.b g();

    com.bytedance.android.livesdk.chatroom.replay.toolbar.behavior.i h(ToolbarButton r1);

    com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 i(DataCenter r1);

    u provideVSPlayerTipService(DataCenter r1);

    v provideVSPlayerViewControlService(DataCenter r1);

    void releaseService(DataCenter r1);
}
