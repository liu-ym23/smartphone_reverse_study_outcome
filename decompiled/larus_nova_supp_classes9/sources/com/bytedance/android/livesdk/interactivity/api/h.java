package com.bytedance.android.livesdk.interactivity.api;

import android.view.ViewGroup;
import com.bytedance.android.livesdk.interactivity.api.comment.data.InputPanelComponentSyncDataModel;
import com.bytedance.android.livesdk.interactivity.api.comment.data.IntercomSyncDataModel;
import com.bytedance.android.livesdk.interactivity.api.entity.RiskAdviseSyncModel;
import com.bytedance.android.livesdk.interactivity.api.like.datacontext.DiggContext;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.AIClone;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.InputFunctionList;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.t;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.w;
import com.bytedance.android.livesdk.interactivity.api.quickcomment.event.BackRoomViewState;
import com.bytedance.android.livesdk.interactivity.api.utils.PSTopMessagePayload;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface h {
    com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.emoji.d> getActivityEmojiManager();

    com.bytedance.live.datacontext.j<AIClone> getAiCloneItem();

    com.bytedance.live.datacontext.j<k22.b> getAiCloneManager();

    com.bytedance.live.datacontext.m<Boolean> getAiEntranceHasShow();

    com.bytedance.live.datacontext.m<Boolean> getAnswerQuestionShow();

    com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.api.l> getAudienceOperateManager();

    com.bytedance.live.datacontext.k<o52.a> getBackRoomChanged();

    com.bytedance.live.datacontext.n<BackRoomViewState> getBackRoomViewState();

    com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.b> getBarrageContext();

    l22.d getBaseUserActionCollector();

    com.bytedance.live.datacontext.m<Boolean> getChatChannelLandscapeDialogState();

    com.bytedance.live.datacontext.j<h32.a> getDegradeManager();

    com.bytedance.live.datacontext.j<DiggContext> getDiggContext();

    com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.api.g> getFrequentChatInfo();

    com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.emoji.e> getFusionEmojiManager();

    com.bytedance.live.datacontext.m<Boolean> getHasAllPluginLoaded();

    Boolean getHasChangeOrientation();

    com.bytedance.live.datacontext.m<Boolean> getHasLoadModel();

    com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.k> getHighlightContext();

    com.bytedance.live.datacontext.j<Boolean> getHighlightEnable();

    com.bytedance.live.datacontext.j<r42.h> getHistoryDataManager();

    com.bytedance.live.datacontext.j<InputFunctionList> getInputFunctionInfo();

    com.bytedance.live.datacontext.j<InputPanelComponentSyncDataModel> getInputPanelComponentSyncDataModelModel();

    com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.base.b> getInteractivityStat();

    com.bytedance.live.datacontext.j<IntercomSyncDataModel> getIntercomSyncDataModel();

    com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.interactivity.api.publicscreen.api.r> getLikeIconInfo();

    com.bytedance.live.datacontext.j<com.bytedance.android.live.pushstream.d> getLiveStream();

    com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.emoji.f> getLowPcuGuideChatManager();

    com.bytedance.live.datacontext.m<Integer> getMarkHighlightStatusCode();

    com.bytedance.live.datacontext.m<t> getMatchChatInfo();

    com.bytedance.live.datacontext.n<ViewGroup> getMatchTrayRootView();

    com.bytedance.live.datacontext.n<b42.b> getMultiCameraContext();

    com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a> getMultiChatTabAreaStateManager();

    com.bytedance.live.datacontext.m<Boolean> getMyLiveEntranceHasShow();

    com.bytedance.live.datacontext.n<f52.b> getPsTopContainer();

    com.bytedance.live.datacontext.j<PSTopMessagePayload> getPsTopMessage();

    com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a> getPublicScreenAreaStateManager();

    com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.l> getPublicScreenContext();

    com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.quickcomment.f> getQuickCommentManager();

    com.bytedance.live.datacontext.m<w> getRecommendShortcutEmoji();

    com.bytedance.live.datacontext.j<RiskAdviseSyncModel> getRiskAdviseSyncModel();

    com.bytedance.live.datacontext.m<Integer> getSendCommentCount();

    com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.b> getSquareTabManager();

    com.bytedance.live.datacontext.j<a32.a> getToolbarAndCommentShowCtrlManager();

    com.bytedance.live.datacontext.j<t22.g> getTopicTipManager();

    com.bytedance.live.datacontext.j<Long> getUserFansCountOnStart();

    com.bytedance.live.datacontext.j<Integer> getUserHonorLevelOnStart();

    boolean isAlive();

    com.bytedance.live.datacontext.m<Boolean> isFirstMessageConsumed();

    com.bytedance.live.datacontext.m<Boolean> isUserBannedTalk();
}
