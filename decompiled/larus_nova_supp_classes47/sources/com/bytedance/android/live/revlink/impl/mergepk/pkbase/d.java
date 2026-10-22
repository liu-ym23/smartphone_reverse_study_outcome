package com.bytedance.android.live.revlink.impl.mergepk.pkbase;

import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.bytedance.android.livesdk.link.model.a5;
import com.bytedance.android.livesdk.link.model.c5;
import com.bytedance.android.livesdk.link.model.f1;
import com.bytedance.android.livesdk.link.model.y4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface d {
    void onBizFinishCallback(PkBaseStateMachine.Source r1, f1 r2, Throwable r3);

    void onBizFinished(boolean r1, PkBaseStateMachine.c r2, PkBaseStateMachine.c r3, boolean r4);

    void onBizPK(com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r1, PkBaseStateMachine.c r2, PkBaseStateMachine.c r3, PkBaseStateMachine.Source r4, boolean r5, PlayMode r6);

    void onBizPenal(com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r1, PkBaseStateMachine.Source r2, PkBaseStateMachine.c r3);

    void onBizReceiveBattleEndPunishMsg(y4 r1);

    void onBizReceiveBattleFinishMsg(a5 r1);

    void onBizReceiveBattleMsg(c5 r1);
}
