package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.bytedance.android.livesdk.link.model.IBattleUserInfo;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface b {
    long G();

    LiveData<PlayMode> H();

    LiveData<Long> I();

    String getAnchorId();

    IBaseBattleSetting getBattleSettings();

    Map<String, IBattleUserInfo> getBattleUserInfoMap();

    LiveData<Integer> getPkResult();

    LiveData<com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a> getScoreState();

    com.bytedance.android.live.revlink.impl.mergepk.pkbase.b getSkinConfig();

    LiveData<String> getTeamTaskLynxData();

    Map<String, Long> getUserIdToTeamId();
}
