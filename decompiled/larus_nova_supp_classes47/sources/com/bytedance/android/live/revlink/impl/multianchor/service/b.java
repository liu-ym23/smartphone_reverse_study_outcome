package com.bytedance.android.live.revlink.impl.multianchor.service;

import com.bytedance.android.livesdk.link.model.ILinkerKickOutContent;
import com.bytedance.android.livesdk.link.model.b7;
import com.bytedance.android.livesdk.link.model.bridge.f0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface b {
    void finishInternal(Function0<Unit> r1, String r2, boolean r3);

    f31.j getEndingLinkStatus();

    com.bytedance.android.live.revlink.impl.multianchor.ui.i getMuteManager();

    int getWindowCount();

    void kickOut(String r1, String r2, ILinkerKickOutContent.KickOutSource r3);

    void onReceiveSwitchChannelReply(b7 r1);

    void receiveChorusMessage(f0 r1);

    void setAnchorLinkFinisher(boolean r1);

    void setFollowState(String r1, boolean r2, String r3);

    void startSwitchPk(com.bytedance.android.live.revlink.impl.mergepk.pkdouble.g r1);
}
