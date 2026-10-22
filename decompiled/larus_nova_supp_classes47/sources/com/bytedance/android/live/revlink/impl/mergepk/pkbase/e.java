package com.bytedance.android.live.revlink.impl.mergepk.pkbase;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.PkBaseResult;
import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.IBattleUserInfo;
import com.bytedance.android.livesdk.link.model.aa;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.c3;
import com.bytedance.android.livesdk.link.model.ca;
import com.bytedance.android.livesdk.link.model.h3;
import com.bytedance.android.livesdk.link.model.h7;
import com.bytedance.android.livesdk.link.model.m3;
import com.bytedance.android.livesdk.link.model.n3;
import com.bytedance.android.livesdk.link.model.p0;
import com.bytedance.android.livesdk.link.model.r;
import com.bytedance.android.livesdk.link.model.w2;
import com.bytedance.android.livesdk.link.model.z;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface e {
    MutableLiveData<z> getAudioPunishInfo();

    MutableLiveData<Long> getAudioPunishRemainTime();

    List<String> getAudioPunishUserIds();

    LiveData<List<cf2.a>> getBaseScoreState();

    LiveData<Long> getBaseTimeLeft();

    LiveData<String> getBattleEffectInfo();

    c21.f getBattlePlayMode();

    LiveData<com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a> getBattleScoreData();

    IBaseBattleSetting getBattleSettings();

    LiveData<c3> getBattleStatsMeta();

    m3 getBreakThoughConfig();

    n3 getBreakThroughInfo();

    com.bytedance.android.live.revlink.impl.mergepk.pkbase.subplaymode.a getBreakThroughService();

    long getBreakThroughStage();

    int getCloudCollaboratePanelType();

    Map<String, String> getCommonLogParams();

    int getCompletePkCount();

    IBattleConfigSetting getConfigSetting();

    PkBaseStateMachine.c getCurPKBaseState();

    Map<String, PkBaseResult> getCurPkResultMap();

    int getCustomizePlayType();

    String getFlexActivityId();

    ca getInteractPkInfo();

    c21.f getLastBattlePlayMode();

    MutableLiveData<Boolean> getLastBattleResultVisible();

    LiveData<List<h7.b>> getLeftMvpRankList();

    LiveData<String> getNeedShowLastResult();

    com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a getPkAnchorLauncher();

    LiveData<Map<String, PkBaseResult>> getPkBaseResult();

    LiveData<PkBaseStateMachine.c> getPkBaseState();

    LiveData<String> getPkGuestListStr();

    long getPkId();

    int getPkPlayTimes();

    b getPkSkinConfig();

    long getPkStartTimeMs();

    h3 getPkTitleConfig();

    h3 getPunishTitleConfig();

    LiveData<List<h7.b>> getRightMvpRankList();

    p0 getServerBattleAttachedInfo();

    Map<String, String> getServerEventTrackingInfo();

    w2 getShellConfig();

    String getShortPlayName();

    long getStartPenaltyTimeMs();

    LiveData<PlayMode> getTeamMode();

    String getTeamModeStr();

    LiveData<String> getTeamTaskLynxData();

    int getThroneFightEvenCount();

    i31.c getTitleConfig();

    Map<String, Long> getUserIdToTeamId();

    Map<String, IBattleUserInfo> getUserInfoMap();

    aa getVoteSetting();

    boolean inClassicDoublePK();

    boolean isBattleShow();

    boolean isCustomPKPlay(boolean r1);

    boolean isCustomizePkPlay();

    boolean isInAudioPunish(String r1);

    boolean isInBreakThrough();

    boolean isInCloudCollaborate();

    boolean isInCompetition();

    boolean isInInteractPk();

    boolean isInRobC();

    boolean isInSpecifyGiftPk();

    boolean isInVote();

    boolean isNormalPk();

    boolean isOnceMoreBattle();

    @Deprecated(message = "逐步弃用，用BattlePlayMode判断玩法")
    PkBaseDataContext.PKModType modType();

    void notifyPkContext(r r1, boolean r2);

    int queryLaunchToBizTypeAndReset();

    long startTimeMs();
}
