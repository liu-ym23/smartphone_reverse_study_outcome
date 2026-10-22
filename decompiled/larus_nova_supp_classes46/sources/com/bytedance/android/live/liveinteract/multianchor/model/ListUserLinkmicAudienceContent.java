package com.bytedance.android.live.liveinteract.multianchor.model;

import com.bytedance.android.live.base.model.user.n0;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.livesdk.link.model.bridge.Linkmic2DAvatar;
import com.bytedance.android.livesdk.link.model.bridge.l1;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class ListUserLinkmicAudienceContent extends FlexModelBase<l1> implements l1 {

    @SerializedName("ai_guest_type")
    public int aiGuestType;

    @SerializedName("chorus_guest_status")
    public long chorusGuestStatus;

    @SerializedName("extra")
    public String extra;

    @IgnoreProtoFieldCheck
    @SerializedName("in_waiting_list")
    public boolean isInWaitingList;

    @SerializedName("is_mic_hidden")
    public boolean isMicHidden;

    @IgnoreProtoFieldCheck
    @SerializedName("linkmic_2d_avatar")
    public Linkmic2DAvatar linkmic2DAvatar;

    @SerializedName("app_id")
    public long mAppId;

    @SerializedName("client_version")
    public long mClientVersion;

    @SerializedName("current_time")
    public long mCurrentTime;

    @SerializedName("device_platform")
    public String mDevicePlatform;

    @SerializedName("expected_leave_time")
    public long mExpectLeaveTime;

    @SerializedName("fan_ticket")
    public long mFanTicket;

    @SerializedName("fan_ticket_fuzzy_str")
    public String mFanTicketFuzzyStr;

    @SerializedName("fan_ticket_real_str")
    public String mFanTicketRealStr;

    @SerializedName("is_anonymous")
    public boolean mIsAnonymous;

    @SerializedName("is_enlarged")
    public boolean mIsEnlarged;

    @SerializedName("host_permission")
    public boolean mIsHost;

    @SerializedName("join_channel_time")
    public long mJoinChannelTime;

    @SerializedName("list_user_role")
    public int mListUserRole;

    @SerializedName("paid_count")
    public long mPaidCount;

    @SerializedName("self_discipline_duration")
    public long mSelfDisciplineDurationTime;

    @SerializedName("mic_dress")
    public MicDress micDress;

    @SerializedName("origin_link_type")
    public long originLinkType;

    @SerializedName("rank_contributor_ids")
    public List<Long> rankUserIds;

    @SerializedName("rank_contributor_open_ids")
    public List<String> rankUserOpenIds;

    @SerializedName("self_discipline_start_time_ms")
    public long selfDisciplineStartTime;

    @SerializedName("self_discripline_target_duration")
    public long selfDisciplineTargetDuration;

    @SerializedName("themed_competition_role")
    public int themedCompetitionRole;

    public ListUserLinkmicAudienceContent() {
        super(l1.class);
    }

    public List<String> getRankUserIdStrList() {
        List<String> r0 = this.rankUserOpenIds;
        int r1 = n0.a;
        o0.a.getClass();
        return o0.a.h(r0);
    }

    public int getAiGuestType() {
        return this.aiGuestType;
    }

    public long getAppId() {
        return this.mAppId;
    }

    public long getChorusGuestStatus() {
        return this.chorusGuestStatus;
    }

    public long getClientVersion() {
        return this.mClientVersion;
    }

    public long getCurrentTime() {
        return this.mCurrentTime;
    }

    public String getDevicePlatform() {
        return this.mDevicePlatform;
    }

    public long getExpectLeaveTime() {
        return this.mExpectLeaveTime;
    }

    public long getFanTicket() {
        return this.mFanTicket;
    }

    public String getFanTicketFuzzyStr() {
        return this.mFanTicketFuzzyStr;
    }

    public String getFanTicketRealStr() {
        return this.mFanTicketRealStr;
    }

    public long getJoinChannelTime() {
        return this.mJoinChannelTime;
    }

    public Linkmic2DAvatar getLinkmic2DAvatar() {
        return this.linkmic2DAvatar;
    }

    public int getListUserRole() {
        return this.mListUserRole;
    }

    public kd1.b getMicDress() {
        return this.micDress;
    }

    public long getOriginLinkType() {
        return this.originLinkType;
    }

    public long getPaidCount() {
        return this.mPaidCount;
    }

    public long getSelfDisciplineDurationTime() {
        return this.mSelfDisciplineDurationTime;
    }

    public long getSelfDisciplineStartTime() {
        return this.selfDisciplineStartTime;
    }

    public long getSelfDisciplineTargetDuration() {
        return this.selfDisciplineTargetDuration;
    }

    public int getThemedCompetitionRole() {
        return this.themedCompetitionRole;
    }

    public boolean isAnonymous() {
        return this.mIsAnonymous;
    }

    public boolean isEnlarged() {
        return this.mIsEnlarged;
    }

    public boolean isHost() {
        return this.mIsHost;
    }

    public boolean isMicHidden() {
        return this.isMicHidden;
    }

    public void setAiGuestType(int r1) {
        this.aiGuestType = r1;
    }

    public void setAppId(long r1) {
        this.mAppId = r1;
    }

    public void setChorusGuestStatus(long r1) {
        this.chorusGuestStatus = r1;
    }

    public void setClientVersion(long r1) {
        this.mClientVersion = r1;
    }

    public void setCurrentTime(long r1) {
        this.mCurrentTime = r1;
    }

    public void setDevicePlatform(String r1) {
        this.mDevicePlatform = r1;
    }

    public void setExpectLeaveTime(long r1) {
        this.mExpectLeaveTime = r1;
    }

    public void setFanTicket(long r1) {
        this.mFanTicket = r1;
    }

    public void setFanTicketFuzzyStr(String r1) {
        this.mFanTicketFuzzyStr = r1;
    }

    public void setFanTicketRealStr(String r1) {
        this.mFanTicketRealStr = r1;
    }

    public void setHost(boolean r1) {
        this.mIsHost = r1;
    }

    public void setJoinChannelTime(long r1) {
        this.mJoinChannelTime = r1;
    }

    public void setLinkmic2DAvatar(Linkmic2DAvatar r1) {
        this.linkmic2DAvatar = r1;
    }

    public void setListUserRole(int r1) {
        this.mListUserRole = r1;
    }

    public void setMicDress(kd1.b r1) {
        this.micDress = (MicDress) r1;
    }

    public void setMicHidden(boolean r1) {
        this.isMicHidden = r1;
    }

    public void setOriginLinkType(long r1) {
        this.originLinkType = r1;
    }

    public void setSelfDisciplineDurationTime(long r1) {
        this.mSelfDisciplineDurationTime = r1;
    }

    public void setSelfDisciplineTargetDuration(long r1) {
        this.selfDisciplineTargetDuration = r1;
    }

    public void setThemedCompetitionRole(int r1) {
        this.themedCompetitionRole = r1;
    }
}
