package com.bytedance.android.live.liveinteract.plantform.model;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.multianchor.model.ListUserExtra;
import com.bytedance.android.live.liveinteract.multianchor.model.MicDress;
import com.bytedance.android.livesdk.link.model.bridge.Linkmic2DAvatar;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.UserHighScoreSongTag;
import com.bytedance.android.livesdk.message.model.fc;
import com.bytedance.android.livesdkapi.depend.model.live.linker.CityEffect;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ICityEffect;
import com.bytedance.android.livesdkapi.depend.model.live.linker.IMatchEffect;
import com.bytedance.android.livesdkapi.depend.model.live.linker.MatchEffect;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class LinkPlayerInfo extends FlexModelBase<ILinkPlayerInfoBridge> implements com.bytedance.android.live.liveinteract.plantform.base.h, Cloneable, ILinkPlayerInfoBridge {
    public static final int INTERACTING_STATE_OFFLINE = 1;
    public static final int INTERACTING_STATE_ONLINE = 0;
    public static final int INTERESTED_TYPE_FOLLOWER = 3;
    public static final int INTERESTED_TYPE_MUTUAL = 1;
    public static final int INTERESTED_TYPE_RECENT_LINKED = 2;
    public static final int INTERESTED_TYPE_UNKNOWN = 0;
    public static final int INVITEE_TYPE_FANS = 3;
    public static final int INVITEE_TYPE_MUTUAL = 2;
    public static final int INVITEE_TYPE_NONE = 0;
    public static final int INVITEE_TYPE_ROOM_AUDIENCE = 1;
    public static final int KICK_OUT_FROM_GAME = 2;
    public static final int KICK_OUT_FROM_PANEL = 1;
    public static final int LINK_STATUS_FINISHED = 3;
    public static final int LINK_STATUS_LINKED = 2;
    public static final int LINK_STATUS_UNKNOWN = 0;
    public static final int LINK_STATUS_WAITING = 1;
    public static final int LINK_TYPE_AUDIO = 2;
    public static final int LINK_TYPE_DIGIT_AVATAR = 3;
    public static final int LINK_TYPE_UNKNOWN = 0;
    public static final int LINK_TYPE_VIDEO = 1;
    private static final int MAX_NAME_LENGTH = 6;
    public static final int MC_STATUS_KTV_HOST = 1;
    public static final int MC_STATUS_NOTHING = 0;
    public static final int ROLE_TYPE_LEADER = 1;
    public static final int ROLE_TYPE_PLAYER = 2;
    public static final int ROLE_TYPE_UNKNOWN = 0;
    public static final int SILENCE_BY_ANCHOR = 2;
    public static final int SILENCE_BY_GAME = 4;
    public static final int SILENCE_BY_SELF = 1;
    public static final int SILENCE_PASSIVE = 3;
    public static final int SILENCE_UNKONWN = -1;
    public static final int UNSILENCE = 0;
    public static final int USER_FROM_TYPE_BY_LINKED_USER = 4;
    public static final int USER_FROM_TYPE_KTV_ADD_SONG = 2;
    public static final int USER_FROM_TYPE_KTV_GRAB_SONG = 3;
    public static final int USER_FROM_TYPE_NONE = 0;
    public static final int USER_FROM_TYPE_NORMAL = 1;
    public transient String activeName;

    @SerializedName("add_price_time_ms")
    public long addPriceTime;
    public int aiGuestType;

    @IgnoreProtoFieldCheck
    @SerializedName("already_invited")
    public boolean alreadyInvited;

    @SerializedName("app_id")
    public long appId;

    @SerializedName("apply_type")
    public int applyTypeNew;
    public transient String buttonText;

    @SerializedName("chorus_guest_status")
    public long chorusGuestStatus;

    @IgnoreProtoFieldCheck
    @SerializedName("client_ui_position")
    private int clientUIPosition;

    @SerializedName("client_version")
    public long clientVersion;
    public transient String cornerMarkUrl;

    @SerializedName("device_platform")
    public String devicePlatform;

    @SerializedName("event_info")
    public ListUserEventInfo eventInfo;

    @SerializedName("fuzzy_fan_ticket")
    public String fuzzyFanTicket;

    @SerializedName("interested_type")
    public int[] interestedType;

    @SerializedName("invite_list_user_info")
    public InviteListUserInfo inviteListUserInfo;

    @SerializedName("invitee_type")
    public int inviteeType;

    @SerializedName("is_active")
    public boolean isActive;

    @SerializedName("is_add_price")
    public boolean isAddPrice;
    public boolean isAnchorPlayer;

    @SerializedName("is_anonymous")
    public boolean isAnonymous;
    public transient boolean isBackground;

    @IgnoreProtoFieldCheck
    @SerializedName("is_enlarged")
    public boolean isEnlarged;
    public transient boolean isHasApplied;
    public transient boolean isHasInvited;

    @SerializedName("host_permission")
    public boolean isHost;
    public transient boolean isInWaitingList;
    public transient boolean isInviting;
    public boolean isMicHidden;
    public transient boolean isOpenSendGift;
    public Boolean isPaidUserLeave;
    public transient boolean isSelfBackground;
    public transient boolean isSelfPreOn;

    @SerializedName("join_teamfight_info")
    public TeamFightJoinTeamInfo joinTeamFightInfo;
    public transient long kSongUid;

    @IgnoreProtoFieldCheck
    @SerializedName("last_active_time_ms")
    public long lastActiveTimeMillis;

    @SerializedName("last_invited_time_ms")
    public long lastInvitedTimeMillis;

    @SerializedName("link_duration")
    public int linkDuration;

    @SerializedName("linked_list_user_info")
    public LinkedListUserInfo linkedListUserInfo;

    @IgnoreProtoFieldCheck
    @SerializedName("linkmic_2d_avatar")
    public Linkmic2DAvatar linkmic2DAvatar;

    @SerializedName("list_user_from_type")
    public int listUserFromType;

    @IgnoreProtoFieldCheck
    @SerializedName("list_user_role")
    public int listUserRole;

    @SerializedName("list_user_type")
    public int listUserType;

    @SerializedName("location")
    public String location;
    public transient int mApplyType;
    public transient CityEffect mCityEffect;

    @SerializedName("fan_ticket")
    public long mFanTicket;
    public transient String mFanTicketDisplayStr;
    public transient boolean mHasExposed;

    @SerializedName("linkmic_id_str")
    public String mInteractIdStr;
    private transient int mInteractingState;

    @SerializedName("invitor")
    public IBaseUser mInvitor;
    public transient boolean mIsJoinUser;
    public transient boolean mIsLinkRoomUser;
    public transient long mLinkRoomId;

    @SerializedName("link_status")
    public int mLinkStatus;

    @SerializedName("link_type")
    public int mLinkType;

    @IgnoreProtoFieldCheck
    @SerializedName("linkmic_unique_id")
    public String mLinkmicUniqueIdStr;
    public transient MatchEffect mMatchEffect;

    @SerializedName("modify_time")
    public long mModifyTime;

    @SerializedName("role_type")
    public int mRoleType;
    public transient int mRoomLinkSilenceStatus;
    public transient boolean mShowCityEffect;

    @SerializedName("user")
    public IBaseUser mUser;

    @SerializedName("mc_status")
    public long mcStatus;
    public int mediaType;
    public MicDress micDress;

    @SerializedName("mic_pos_tag_info")
    public MicPosTagInfo micPosTagInfo;

    @SerializedName("modify_time_in_nano")
    public long modifyTimeInNano;

    @IgnoreProtoFieldCheck
    @SerializedName("order_song_count")
    public long orderedSongCount;
    public long originLinkType;
    public Map.Entry<Long, ? extends g2> otherRoomInfo;
    public transient boolean outOfDate;
    public long paidAmount;
    public long paidCount;

    @SerializedName("payed_money")
    public int paidMoney;
    public int positionType;

    @SerializedName("rank")
    public long rank;
    public long selfDisciplineDuration;
    public long selfDisciplineTargetDuration;

    @SerializedName("silence_status")
    public int silenceStatus;

    @SerializedName("song_list")
    public List<KtvMusic> songList;
    public int stats;

    @SerializedName("tag")
    public ListUserTag tag;

    @SerializedName("tags")
    public List<ListTag> tags;
    public transient int talkState;
    public int themedCompetitionRole;

    @IgnoreProtoFieldCheck
    @SerializedName("high_score_song_tag")
    public UserHighScoreSongTag userHighScoreSongTag;

    @SerializedName("user_position")
    public int userPosition;

    @SerializedName("user_relation_type")
    public long userRelationType;
    public transient int verifyStatus;

    @SerializedName("waiting_list_user_info")
    public WaitingListUserInfo waitingListUserInfo;

    public static final enum McStatus extends Enum<McStatus> {
        public static final McStatus KTV_HOST = null;
        public static final McStatus UNKNOWN = null;
        public static final /* synthetic */ McStatus[] a = null;

        static {
            McStatus r0 = new McStatus("UNKNOWN", 0);
            UNKNOWN = r0;
            McStatus r1 = new McStatus("KTV_HOST", 1);
            KTV_HOST = r1;
            a = new McStatus[]{r0, r1};
        }

        public static McStatus[] values() {
            return (McStatus[]) a.clone();
        }

        public static McStatus valueOf(String r1) {
            return (McStatus) r27.a.a(McStatus.class, r1);
        }

        public McStatus(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean isSelfPreOn() {
        return false;
    }

    public LinkPlayerInfo() {
        super(ILinkPlayerInfoBridge.class);
        this.mFanTicketDisplayStr = "0";
        this.lastActiveTimeMillis = -1;
        this.lastInvitedTimeMillis = -1;
        this.isAddPrice = false;
        this.addPriceTime = 0;
        this.isPaidUserLeave = Boolean.FALSE;
        this.clientUIPosition = ILinkPlayerInfoBridge.DEFAULT_ClIENT_UI_POSITION;
        this.kSongUid = 0;
        this.rank = 0;
        this.mInteractingState = 0;
    }

    private String getUserId() {
        IBaseUser r0 = this.mUser;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getUserId();
    }

    public LinkPlayerInfo copy() {
        LinkPlayerInfo r0 = new LinkPlayerInfo();
        r0.setFanTicket(getFanTicket());
        r0.mFanTicketDisplayStr = this.mFanTicketDisplayStr;
        r0.mInteractIdStr = this.mInteractIdStr;
        r0.mLinkmicUniqueIdStr = this.mLinkmicUniqueIdStr;
        r0.setUser(getUser());
        r0.setModifyTime(getModifyTime());
        r0.setLinkStatus(getLinkStatus());
        r0.setLinkType(getLinkType());
        r0.setRoleType(getRoleType());
        r0.listUserRole = this.listUserRole;
        r0.paidMoney = this.paidMoney;
        r0.linkDuration = this.linkDuration;
        r0.userPosition = this.userPosition;
        r0.silenceStatus = this.silenceStatus;
        r0.location = this.location;
        r0.modifyTimeInNano = this.modifyTimeInNano;
        r0.talkState = this.talkState;
        r0.isOpenSendGift = this.isOpenSendGift;
        r0.isHasInvited = this.isHasInvited;
        r0.isHasApplied = this.isHasApplied;
        r0.isHost = this.isHost;
        r0.mediaType = this.mediaType;
        r0.cornerMarkUrl = this.cornerMarkUrl;
        r0.clientVersion = this.clientVersion;
        r0.appId = this.appId;
        r0.devicePlatform = this.devicePlatform;
        r0.mApplyType = this.mApplyType;
        r0.applyTypeNew = this.applyTypeNew;
        r0.linkedListUserInfo = this.linkedListUserInfo;
        r0.isBackground = this.isBackground;
        r0.isSelfBackground = this.isSelfBackground;
        r0.mMatchEffect = this.mMatchEffect;
        r0.mCityEffect = this.mCityEffect;
        r0.mShowCityEffect = this.mShowCityEffect;
        r0.mIsJoinUser = this.mIsJoinUser;
        r0.micDress = this.micDress;
        r0.isEnlarged = this.isEnlarged;
        r0.linkmic2DAvatar = this.linkmic2DAvatar;
        r0.chorusGuestStatus = this.chorusGuestStatus;
        r0.originLinkType = this.originLinkType;
        r0.selfDisciplineDuration = this.selfDisciplineDuration;
        r0.selfDisciplineTargetDuration = this.selfDisciplineTargetDuration;
        r0.themedCompetitionRole = this.themedCompetitionRole;
        r0.waitingListUserInfo = this.waitingListUserInfo;
        r0.rank = this.rank;
        r0.paidCount = this.paidCount;
        r0.stats = this.stats;
        r0.mcStatus = this.mcStatus;
        r0.mIsLinkRoomUser = this.mIsLinkRoomUser;
        r0.mLinkRoomId = this.mLinkRoomId;
        r0.mRoomLinkSilenceStatus = this.mRoomLinkSilenceStatus;
        r0.isAnonymous = this.isAnonymous;
        r0.micPosTagInfo = this.micPosTagInfo;
        r0.userHighScoreSongTag = this.userHighScoreSongTag;
        r0.isPaidUserLeave = this.isPaidUserLeave;
        return r0;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getClientUIPosition() {
        int r0 = this.clientUIPosition;
        if (r0 == Integer.MIN_VALUE) goto L5;
        return r0;
    L5:
        return this.userPosition;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getExpectLeaveTime() {
        LinkedListUserInfo r0 = this.linkedListUserInfo;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.expectLeaveTime;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getJoinChannelTime() {
        LinkedListUserInfo r0 = this.linkedListUserInfo;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.joinChannelTime;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public Long getKSongUid() {
        return Long.valueOf(this.kSongUid);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getLinkDuration() {
        return this.linkDuration;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getLinkMicPosTagType() {
        MicPosTagInfo r0 = this.micPosTagInfo;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getTagType();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getPaidLinkCurrentTime() {
        LinkedListUserInfo r0 = this.linkedListUserInfo;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.currentTime;
    }

    public String getRelationship() {
        IBaseUser r0 = this.mUser;
        if (r0 != null) goto L5;
        return "null";
    L5:
        return r0.getRelationship();
    }

    public String getTopR() {
        long r0 = this.rank;
        if (r0 != 1) goto L6;
        return "top1";
    L6:
        if (r0 != 2) goto L9;
        return "top2";
    L9:
        if (r0 != 3) goto L11;
        return "top3";
    L11:
        return "null";
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getUserPosition() {
        int r0 = this.clientUIPosition;
        if (r0 == Integer.MIN_VALUE) goto L6;
        return r0;
    L6:
        return this.userPosition;
    }

    public boolean hasSpecialRadioEffect() {
        MicDress r0 = this.micDress;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.voiceWave == null) goto L7;
        return true;
    }

    public boolean isKtvHost() {
        if (this.mcStatus != McStatus.KTV_HOST.ordinal()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean isPaidUserLeave() {
        return this.isPaidUserLeave.booleanValue();
    }

    public boolean isTalking() {
        if (this.talkState <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    /* JADX INFO: renamed from: getCityEffect, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ ICityEffect mo254getCityEffect() {
        return getCityEffect();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public /* bridge */ /* synthetic */ i getInviteListUserInfo() {
        return getInviteListUserInfo();
    }

    public String toString() {
        if (getUser() == null) goto L5;
        String r0 = getUser().getNickName();
        String r1 = getUser().getIdString();
    L7:
        return "LinkPlayerInfo{mInteractIdStr='" + this.mInteractIdStr + "'mLinkmicUniqueIdStr='" + this.mLinkmicUniqueIdStr + "'nickName='" + r0 + "'id=" + r1 + "position='" + this.userPosition + "'mediaType='" + this.mediaType + "'mLinkType='" + this.mLinkType + "'isBackground='" + this.isBackground + "'}";
    L5:
        r0 = "";
        r1 = "";
        goto L7
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public String getActiveName() {
        return this.activeName;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getAddPriceTime() {
        return this.addPriceTime;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getAiGuestType() {
        return this.aiGuestType;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean getAlreadyInvited() {
        return this.alreadyInvited;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getAppId() {
        return this.appId;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getApplyType() {
        return this.mApplyType;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getApplyTypeNew() {
        return this.applyTypeNew;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public IBaseUser getBaseUser() {
        return this.mUser;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public String getButtonText() {
        return this.buttonText;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getChorusGuestStatus() {
        return this.chorusGuestStatus;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getClientVersion() {
        return this.clientVersion;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public String getCornerMarkUrl() {
        return this.cornerMarkUrl;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public String getDevicePlatform() {
        return this.devicePlatform;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public c0 getEventInfo() {
        return this.eventInfo;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getFanTicket() {
        return this.mFanTicket;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public String getFanTicketDisplayStr() {
        return this.mFanTicketDisplayStr;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public String getFuzzyFanTicket() {
        return this.fuzzyFanTicket;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public String getInteractId() {
        return this.mInteractIdStr;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getInteractingState() {
        return this.mInteractingState;
    }

    public int[] getInterestedType() {
        return this.interestedType;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getInviteeType() {
        return this.inviteeType;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public IBaseUser getInvitor() {
        return this.mInvitor;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public j0 getJoinTeamFightInfo() {
        return this.joinTeamFightInfo;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getLastActiveTimeMillis() {
        return this.lastActiveTimeMillis;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getLastInvitedTimeMillis() {
        return this.lastInvitedTimeMillis;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public String getLinkMicUniqueIdStr() {
        return this.mLinkmicUniqueIdStr;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getLinkRoomId() {
        return this.mLinkRoomId;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getLinkStatus() {
        return this.mLinkStatus;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getLinkType() {
        return this.mLinkType;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public o getLinkedListUserInfo() {
        return this.linkedListUserInfo;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public Linkmic2DAvatar getLinkmic2DAvatar() {
        return this.linkmic2DAvatar;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getListUserFromType() {
        return this.listUserFromType;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getListUserRole() {
        return this.listUserRole;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getListUserType() {
        return this.listUserType;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public String getLocation() {
        return this.location;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getMFanTicket() {
        return this.mFanTicket;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public String getMInteractIdStr() {
        return this.mInteractIdStr;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public IBaseUser getMInvitor() {
        return this.mInvitor;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean getMIsJoinUser() {
        return this.mIsJoinUser;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public String getMLinkMicUniqueIdStr() {
        return this.mLinkmicUniqueIdStr;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getMLinkStatus() {
        return this.mLinkStatus;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getMLinkType() {
        return this.mLinkType;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getMModifyTime() {
        return this.mModifyTime;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getMRoleType() {
        return this.mRoleType;
    }

    public IBaseUser getMUser() {
        return this.mUser;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public IMatchEffect getMatchEffect() {
        return this.mMatchEffect;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getMcStatus() {
        return this.mcStatus;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getMediaType() {
        return this.mediaType;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public kd1.b getMicDress() {
        return this.micDress;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public g0 getMicPosTagInfo() {
        return this.micPosTagInfo;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getModifyTime() {
        return this.mModifyTime;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getModifyTimeInNano() {
        return this.modifyTimeInNano;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getOrderedSongCount() {
        return this.orderedSongCount;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getOriginLinkType() {
        return this.originLinkType;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public Map.Entry<Long, g2> getOtherRoomInfo() {
        return this.otherRoomInfo;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getPaidAmount() {
        return this.paidAmount;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getPaidCount() {
        return this.paidCount;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getPaidMoney() {
        return this.paidMoney;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getPositionType() {
        return this.positionType;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getRank() {
        return this.rank;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getRoleType() {
        return this.mRoleType;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getRoomLinkSilenceStatus() {
        return this.mRoomLinkSilenceStatus;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getSelfDisciplineDuration() {
        return this.selfDisciplineDuration;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getSelfDisciplineDurationTime() {
        return this.selfDisciplineDuration;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getSelfDisciplineTargetDuration() {
        return this.selfDisciplineTargetDuration;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean getShowCityEffect() {
        return this.mShowCityEffect;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getSilenceStatus() {
        return this.silenceStatus;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public List<KtvMusic> getSongList() {
        return this.songList;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getStats() {
        return this.stats;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public ListUserTag getTag() {
        return this.tag;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public List<v> getTags() {
        return this.tags;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getTalkState() {
        return this.talkState;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getThemedCompetitionRole() {
        return this.themedCompetitionRole;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public IBaseUser getUser() {
        return this.mUser;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public fc getUserHighScoreSongTag() {
        return this.userHighScoreSongTag;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getUserPositionFlex() {
        return this.userPosition;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public long getUserRelationType() {
        return this.userRelationType;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public int getVerifyStatus() {
        return this.verifyStatus;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public o0 getWaitingListUserInfo() {
        return this.waitingListUserInfo;
    }

    public int getmApplyType() {
        return this.mApplyType;
    }

    public CityEffect getmCityEffect() {
        return this.mCityEffect;
    }

    public long getmFanTicket() {
        return this.mFanTicket;
    }

    public String getmFanTicketDisplayStr() {
        return this.mFanTicketDisplayStr;
    }

    public String getmInteractIdStr() {
        return this.mInteractIdStr;
    }

    public int getmInteractingState() {
        return this.mInteractingState;
    }

    public IBaseUser getmInvitor() {
        return this.mInvitor;
    }

    public int getmLinkType() {
        return this.mLinkType;
    }

    public MatchEffect getmMatchEffect() {
        return this.mMatchEffect;
    }

    public long getmModifyTime() {
        return this.mModifyTime;
    }

    public int getmRoleType() {
        return this.mRoleType;
    }

    public IBaseUser getmUser() {
        return this.mUser;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean isActive() {
        return this.isActive;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean isAddPrice() {
        return this.isAddPrice;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean isAlreadyInvited() {
        return this.alreadyInvited;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean isAnchorPlayer() {
        return this.isAnchorPlayer;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean isAnonymous() {
        return this.isAnonymous;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean isBackground() {
        return this.isBackground;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean isEnlarged() {
        return this.isEnlarged;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean isHasApplied() {
        return this.isHasApplied;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean isHasExposed() {
        return this.mHasExposed;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean isHasInvited() {
        return this.isHasInvited;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean isHost() {
        return this.isHost;
    }

    public boolean isInWaitingList() {
        return this.isInWaitingList;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean isInviting() {
        return this.isInviting;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean isIsAddPrice() {
        return this.isAddPrice;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean isIsAnonymous() {
        return this.isAnonymous;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean isIsEnlarged() {
        return this.isEnlarged;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean isIsHost() {
        return this.isHost;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean isLinkRoomUser() {
        return this.mIsLinkRoomUser;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean isMicHidden() {
        return this.isMicHidden;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean isOpenSendGift() {
        return this.isOpenSendGift;
    }

    public boolean isOutOfDate() {
        return this.outOfDate;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean isSelfBackground() {
        return this.isSelfBackground;
    }

    public boolean ismHasExposed() {
        return this.mHasExposed;
    }

    public boolean ismIsJoinUser() {
        return this.mIsJoinUser;
    }

    public boolean ismIsLinkRoomUser() {
        return this.mIsLinkRoomUser;
    }

    public boolean ismShowCityEffect() {
        return this.mShowCityEffect;
    }

    public CityEffect getCityEffect() {
        return this.mCityEffect;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public InviteListUserInfo getInviteListUserInfo() {
        return this.inviteListUserInfo;
    }

    public static String getUserNameWithCut(String r3) {
        if (r3 != null) goto L4;
        return "";
    L4:
        if (r3.length() > 6) goto L7;
        return r3;
    L7:
        return r3.subSequence(0, 5) + "...";
    }

    public boolean isEnlargePlayer(long r2) {
        IBaseUser r0 = this.mUser;
        if (r0 != null) goto L5;
        return false;
    L5:
        return TextUtils.equals(r0.getIdString(), String.valueOf(r2));
    }

    public boolean isEqual(LinkPlayerInfo r8) {
        if (r8 != null) goto L6;
        return false;
    L6:
        if (this != r8) goto L9;
        return true;
    L9:
        if (this.mFanTicket == r8.mFanTicket) goto L11;
        return false;
    L11:
        if (TextUtils.equals(this.mFanTicketDisplayStr, r8.mFanTicketDisplayStr) == false) goto L201;
        IBaseUser r2 = this.mUser;
        if (r2 != null) goto L15;
        return false;
    L15:
        if (r2.equals(r8.mUser) == false) goto L203;
        IBaseUser r3 = this.mInvitor;
        if (r3 == null) goto L19;
    L20:
        if (r3 != null) goto L22;
        return false;
    L22:
        if (r3.equals(r8.mInvitor) == true) goto L24;
        return false;
    L24:
        if (this.mModifyTime == r8.mModifyTime) goto L26;
        return false;
    L26:
        if (this.mLinkStatus == r8.mLinkStatus) goto L28;
        return false;
    L28:
        if (this.mLinkType == r8.mLinkType) goto L30;
        return false;
    L30:
        if (this.mRoleType == r8.mRoleType) goto L32;
        return false;
    L32:
        if (this.paidMoney == r8.paidMoney) goto L34;
        return false;
    L34:
        if (this.linkDuration == r8.linkDuration) goto L36;
        return false;
    L36:
        if (this.userPosition == r8.userPosition) goto L38;
        return false;
    L38:
        if (this.silenceStatus == r8.silenceStatus) goto L40;
        return false;
    L40:
        if (TextUtils.equals(this.mInteractIdStr, r8.mInteractIdStr) == true) goto L42;
        return false;
    L42:
        if (TextUtils.equals(this.mLinkmicUniqueIdStr, r8.mLinkmicUniqueIdStr) == true) goto L44;
        return false;
    L44:
        if (TextUtils.equals(this.location, r8.location) == true) goto L46;
        return false;
    L46:
        if (this.userRelationType == r8.userRelationType) goto L48;
        return false;
    L48:
        if (this.modifyTimeInNano == r8.modifyTimeInNano) goto L50;
        return false;
    L50:
        if (this.isHost != r8.isHost) goto L219;
        List<KtvMusic> r4 = this.songList;
        if (r4 == null) goto L54;
    L55:
        if (r4 != null) goto L57;
        return false;
    L57:
        if (isSameKtvMusic(r8.songList) == true) goto L59;
        return false;
    L59:
        if (this.orderedSongCount == r8.orderedSongCount) goto L61;
        return false;
    L61:
        if (this.isActive == r8.isActive) goto L63;
        return false;
    L63:
        if (this.lastActiveTimeMillis == r8.lastActiveTimeMillis) goto L65;
        return false;
    L65:
        if (this.lastInvitedTimeMillis == r8.lastInvitedTimeMillis) goto L67;
        return false;
    L67:
        if (this.isAddPrice == r8.isAddPrice) goto L69;
        return false;
    L69:
        if (this.addPriceTime != r8.addPriceTime) goto L227;
        TeamFightJoinTeamInfo r5 = this.joinTeamFightInfo;
        if (r5 == null) goto L73;
    L74:
        if (r5 != null) goto L76;
        return false;
    L76:
        if (r5.equals(r8.joinTeamFightInfo) == true) goto L78;
        return false;
    L78:
        if (this.listUserType == r8.listUserType) goto L80;
        return false;
    L80:
        if (this.listUserFromType != r8.listUserFromType) goto L231;
        WaitingListUserInfo r6 = this.waitingListUserInfo;
        if (r6 == null) goto L84;
    L85:
        if (r6 != null) goto L87;
        return false;
    L87:
        if (r6.equals(r8.waitingListUserInfo) == true) goto L89;
        return false;
    L89:
        if (this.mcStatus != r8.mcStatus) goto L234;
        InviteListUserInfo r7 = this.inviteListUserInfo;
        if (r7 == null) goto L93;
    L94:
        if (r7 != null) goto L96;
        return false;
    L96:
        if (r7.equals(r8.inviteListUserInfo) == false) goto L236;
    L97:
        LinkedListUserInfo r9 = this.linkedListUserInfo;
        if (r9 == null) goto L100;
    L101:
        if (r9 != null) goto L103;
        return false;
    L103:
        if (r9.same(r8.linkedListUserInfo) == true) goto L105;
        return false;
    L105:
        if (this.listUserRole == r8.listUserRole) goto L107;
        return false;
    L107:
        if (TextUtils.equals(this.fuzzyFanTicket, r8.fuzzyFanTicket) == false) goto L240;
        MicPosTagInfo r10 = this.micPosTagInfo;
        if (r10 == null) goto L111;
    L112:
        if (r10 != null) goto L114;
        return false;
    L114:
        if (r10.equals(r8.micPosTagInfo) == true) goto L116;
        return false;
    L116:
        if (this.isSelfPreOn != r8.isSelfPreOn) goto L243;
        MicDress r11 = this.micDress;
        if (r11 == null) goto L120;
    L121:
        if (r11 != null) goto L123;
        return false;
    L123:
        if (r11.isEqual(r8.micDress) == true) goto L125;
        return false;
    L125:
        if (this.paidCount == r8.paidCount) goto L127;
        return false;
    L127:
        if (this.selfDisciplineDuration == r8.selfDisciplineDuration) goto L129;
        return false;
    L129:
        if (this.selfDisciplineTargetDuration == r8.selfDisciplineTargetDuration) goto L131;
        return false;
    L131:
        if (this.isPaidUserLeave == r8.isPaidUserLeave) goto L133;
        return false;
    L133:
        if (this.paidAmount == r8.paidAmount) goto L135;
        return false;
    L135:
        if (this.isBackground == r8.isBackground) goto L137;
        return false;
    L137:
        if (this.isSelfBackground == r8.isSelfBackground) goto L139;
        return false;
    L139:
        if (this.isEnlarged == r8.isEnlarged) goto L141;
        return false;
    L141:
        if (this.isAnonymous == r8.isAnonymous) goto L143;
        return false;
    L143:
        if (this.talkState == r8.talkState) goto L145;
        return false;
    L145:
        if (this.mediaType == r8.mediaType) goto L147;
        return false;
    L147:
        if (this.stats == r8.stats) goto L149;
        return false;
    L149:
        if (TextUtils.equals(this.activeName, r8.activeName) == true) goto L151;
        return false;
    L151:
        if (this.verifyStatus == r8.verifyStatus) goto L153;
        return false;
    L153:
        if (this.isInviting == r8.isInviting) goto L155;
        return false;
    L155:
        if (this.isOpenSendGift == r8.isOpenSendGift) goto L157;
        return false;
    L157:
        if (this.isHasInvited == r8.isHasInvited) goto L159;
        return false;
    L159:
        if (this.isHasApplied == r8.isHasApplied) goto L161;
        return false;
    L161:
        if (this.mApplyType == r8.mApplyType) goto L163;
        return false;
    L163:
        if (this.applyTypeNew != r8.applyTypeNew) goto L265;
        MatchEffect r12 = this.mMatchEffect;
        if (r12 == null) goto L167;
    L168:
        if (r12 != null) goto L170;
        return false;
    L170:
        if (r12.equals(r8.mMatchEffect) == false) goto L267;
    L171:
        CityEffect r13 = this.mCityEffect;
        if (r13 == null) goto L174;
    L175:
        if (r13 != null) goto L177;
        return false;
    L177:
        if (r13.equals(r8.mCityEffect) == true) goto L179;
        return false;
    L179:
        if (this.mShowCityEffect == r8.mShowCityEffect) goto L181;
        return false;
    L181:
        if (this.mIsJoinUser == r8.mIsJoinUser) goto L183;
        return false;
    L183:
        if (this.mHasExposed == r8.mHasExposed) goto L185;
        return false;
    L185:
        if (this.mIsLinkRoomUser == r8.mIsLinkRoomUser) goto L187;
        return false;
    L187:
        if (this.mLinkRoomId == r8.mLinkRoomId) goto L189;
        return false;
    L189:
        if (this.mRoomLinkSilenceStatus == r8.mRoomLinkSilenceStatus) goto L191;
        return false;
    L191:
        if (this.clientVersion == r8.clientVersion) goto L193;
        return false;
    L193:
        if (this.appId == r8.appId) goto L195;
        return false;
    L195:
        if (TextUtils.equals(this.devicePlatform, r8.devicePlatform) == true) goto L197;
        return false;
    L197:
        if (this.rank != r8.rank) goto L279;
        return true;
    L279:
        return false;
    L174:
        if (r8.mCityEffect == null) goto L179;
    L267:
        return false;
    L167:
        if (r8.mMatchEffect == null) goto L171;
    L265:
        return false;
    L120:
        if (r8.micDress == null) goto L125;
    L243:
        return false;
    L111:
        if (r8.micPosTagInfo == null) goto L116;
    L240:
        return false;
    L100:
        if (r8.linkedListUserInfo == null) goto L105;
    L236:
        return false;
    L93:
        if (r8.inviteListUserInfo == null) goto L97;
    L234:
        return false;
    L84:
        if (r8.waitingListUserInfo == null) goto L89;
    L231:
        return false;
    L73:
        if (r8.joinTeamFightInfo == null) goto L78;
    L227:
        return false;
    L54:
        if (r8.songList == null) goto L59;
    L219:
        return false;
    L19:
        if (r8.mInvitor == null) goto L24;
    L203:
        return false;
    L201:
        return false;
    }

    public boolean isSameKtvMusic(List<KtvMusic> r6) {
        List<KtvMusic> r0 = this.songList;
        if (r0 != null) goto L7;
        if (r6 != null) goto L7;
        return true;
    L7:
        if (r0 == null) goto L18;
        if (r6 == null) goto L18;
        int r1 = 0;
    L12:
        if (r1 >= this.songList.size()) goto L17;
        if (((KtvMusic) ListProtector.get(this.songList, r1)).isSameKtvMusic((KtvMusic) ListProtector.get(r6, r1)) == false) goto L15;
        r1 = r1 + 1;
        goto L12
    L15:
        return false;
    L17:
        return true;
    L18:
        return false;
    }

    public void setActive(boolean r1) {
        this.isActive = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setActiveName(String r1) {
        this.activeName = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setAddPrice(boolean r1) {
        this.isAddPrice = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setAddPriceTime(long r1) {
        this.addPriceTime = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setAiGuestType(int r1) {
        this.aiGuestType = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setAlreadyInvited(boolean r1) {
        this.alreadyInvited = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setAnchorPlayer(boolean r1) {
        this.isAnchorPlayer = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setAnonymous(boolean r1) {
        this.isAnonymous = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setAppId(long r1) {
        this.appId = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setApplyType(int r1) {
        this.mApplyType = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setApplyTypeNew(int r1) {
        this.applyTypeNew = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setBackground(boolean r1) {
        this.isBackground = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setButtonText(String r1) {
        this.buttonText = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setChorusGuestStatus(long r1) {
        this.chorusGuestStatus = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setCityEffect(ICityEffect r1) {
        this.mCityEffect = (CityEffect) r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setClientUIPosition(int r1) {
        this.clientUIPosition = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setClientVersion(long r1) {
        this.clientVersion = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setCornerMarkUrl(String r1) {
        this.cornerMarkUrl = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setDevicePlatform(String r1) {
        this.devicePlatform = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setEnlarged(boolean r1) {
        this.isEnlarged = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setEventInfo(c0 r1) {
        this.eventInfo = (ListUserEventInfo) r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setFanTicket(long r1) {
        this.mFanTicket = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setFanTicketDisplayStr(String r1) {
        this.mFanTicketDisplayStr = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setFuzzyFanTicket(String r1) {
        this.fuzzyFanTicket = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setHasApplied(boolean r1) {
        this.isHasApplied = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setHasExposed(boolean r1) {
        this.mHasExposed = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setHasInvited(boolean r1) {
        this.isHasInvited = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setHost(boolean r1) {
        this.isHost = r1;
    }

    public void setInWaitingList(boolean r1) {
        this.isInWaitingList = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setInteractId(String r1) {
        this.mInteractIdStr = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setInteractingState(int r1) {
        this.mInteractingState = r1;
    }

    public void setInterestedType(int[] r1) {
        this.interestedType = r1;
    }

    public void setInviteListUserInfo(InviteListUserInfo r1) {
        this.inviteListUserInfo = r1;
    }

    public void setInviteeType(int r1) {
        this.inviteeType = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setInviting(boolean r1) {
        this.isInviting = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setInvitor(IBaseUser r1) {
        this.mInvitor = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setJoinTeamFightInfo(j0 r1) {
        this.joinTeamFightInfo = (TeamFightJoinTeamInfo) r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setKSongUid(Long r3) {
        this.kSongUid = r3.longValue();
    }

    public void setLastActiveTimeMillis(long r1) {
        this.lastActiveTimeMillis = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setLastInvitedTimeMillis(long r1) {
        this.lastInvitedTimeMillis = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setLinkDuration(long r1) {
        this.linkDuration = (int) r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setLinkMicUniqueIdStr(String r1) {
        this.mLinkmicUniqueIdStr = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setLinkRoomId(long r1) {
        this.mLinkRoomId = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setLinkRoomUser(boolean r1) {
        this.mIsLinkRoomUser = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setLinkStatus(int r1) {
        this.mLinkStatus = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setLinkType(int r1) {
        this.mLinkType = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setLinkedListUserInfo(o r1) {
        this.linkedListUserInfo = (LinkedListUserInfo) r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setLinkmic2DAvatar(Linkmic2DAvatar r1) {
        this.linkmic2DAvatar = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setListUserFromType(int r1) {
        this.listUserFromType = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setListUserRole(int r1) {
        this.listUserRole = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setListUserType(int r1) {
        this.listUserType = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setLocation(String r1) {
        this.location = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setMInteractIdStr(String r1) {
        this.mInteractIdStr = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setMIsJoinUser(boolean r1) {
        this.mIsJoinUser = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setMLinkMicUniqueIdStr(String r1) {
        this.mLinkmicUniqueIdStr = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setMLinkStatus(int r1) {
        this.mLinkStatus = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setMatchEffect(IMatchEffect r1) {
        this.mMatchEffect = (MatchEffect) r1;
    }

    public void setMcStatus(int r3) {
        this.mcStatus = r3;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setMediaType(int r1) {
        this.mediaType = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setMicDress(kd1.b r1) {
        this.micDress = (MicDress) r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setMicHidden(boolean r1) {
        this.isMicHidden = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setMicPosTagInfo(g0 r1) {
        this.micPosTagInfo = (MicPosTagInfo) r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setModifyTime(long r1) {
        this.mModifyTime = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setModifyTimeInNano(long r1) {
        this.modifyTimeInNano = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setOpenSendGift(boolean r1) {
        this.isOpenSendGift = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setOrderedSongCount(long r1) {
        this.orderedSongCount = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setOriginLinkType(long r1) {
        this.originLinkType = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setOtherRoomInfo(Map.Entry<Long, ? extends g2> r1) {
        this.otherRoomInfo = r1;
    }

    public void setOutOfDate(boolean r1) {
        this.outOfDate = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setPaidAmount(long r1) {
        this.paidAmount = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setPaidCount(long r1) {
        this.paidCount = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setPaidMoney(int r1) {
        this.paidMoney = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setPaidUserLeave(boolean r1) {
        this.isPaidUserLeave = Boolean.valueOf(r1);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setPositionType(int r1) {
        this.positionType = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setRank(long r1) {
        this.rank = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setRoleType(int r1) {
        this.mRoleType = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setRoomLinkSilenceStatus(int r1) {
        this.mRoomLinkSilenceStatus = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setSelfBackground(boolean r1) {
        this.isSelfBackground = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setSelfDisciplineDuration(long r1) {
        this.selfDisciplineDuration = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setSelfDisciplineDurationTime(long r1) {
        this.selfDisciplineDuration = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setSelfDisciplineTargetDuration(long r1) {
        this.selfDisciplineTargetDuration = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setSelfPreOn(boolean r1) {
        this.isSelfPreOn = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setShowCityEffect(boolean r1) {
        this.mShowCityEffect = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setSilenceStatus(int r1) {
        this.silenceStatus = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setSongList(List<KtvMusic> r1) {
        this.songList = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setStats(int r1) {
        this.stats = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setTag(ListUserTag r1) {
        this.tag = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setTags(List<? extends v> r1) {
        this.tags = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setTalkState(int r1) {
        this.talkState = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setThemedCompetitionRole(int r1) {
        this.themedCompetitionRole = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setUser(IBaseUser r1) {
        this.mUser = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setUserHighScoreSongTag(fc r1) {
        this.userHighScoreSongTag = (UserHighScoreSongTag) r1;
    }

    public void setUserPosition(long r1) {
        this.userPosition = (int) r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setUserPositionFlex(int r1) {
        this.userPosition = r1;
    }

    public void setUserRelationType(long r1) {
        this.userRelationType = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setVerifyStatus(int r1) {
        this.verifyStatus = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setWaitingListUserInfo(o0 r1) {
        this.waitingListUserInfo = (WaitingListUserInfo) r1;
    }

    public void setmApplyType(int r1) {
        this.mApplyType = r1;
    }

    public void setmCityEffect(CityEffect r1) {
        this.mCityEffect = r1;
    }

    public void setmFanTicket(long r1) {
        this.mFanTicket = r1;
    }

    public void setmFanTicketDisplayStr(String r1) {
        this.mFanTicketDisplayStr = r1;
    }

    public void setmHasExposed(boolean r1) {
        this.mHasExposed = r1;
    }

    public void setmInteractIdStr(String r1) {
        this.mInteractIdStr = r1;
    }

    public void setmInteractingState(int r1) {
        this.mInteractingState = r1;
    }

    public void setmInvitor(IBaseUser r1) {
        this.mInvitor = r1;
    }

    public void setmIsJoinUser(boolean r1) {
        this.mIsJoinUser = r1;
    }

    public void setmIsLinkRoomUser(boolean r1) {
        this.mIsLinkRoomUser = r1;
    }

    public void setmLinkType(int r1) {
        this.mLinkType = r1;
    }

    public void setmMatchEffect(MatchEffect r1) {
        this.mMatchEffect = r1;
    }

    public void setmModifyTime(long r1) {
        this.mModifyTime = r1;
    }

    public void setmRoleType(int r1) {
        this.mRoleType = r1;
    }

    public void setmShowCityEffect(boolean r1) {
        this.mShowCityEffect = r1;
    }

    public void setmUser(IBaseUser r1) {
        this.mUser = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void update(ILinkPlayerInfoBridge r6) {
        if ((r6 instanceof LinkPlayerInfo) == false) goto L14;
        LinkPlayerInfo r7 = (LinkPlayerInfo) r6;
        if (r7 != null) goto L7;
        return;
    L7:
        if (TextUtils.equals(this.mUser.getIdString(), r7.mUser.getIdString()) == false) goto L16;
        this.mFanTicket = r7.mFanTicket;
        this.mFanTicketDisplayStr = r7.mFanTicketDisplayStr;
        this.mUser = r7.mUser;
        long r0 = r7.mModifyTime;
        if (r0 <= this.mModifyTime) goto L12;
        this.mModifyTime = r0;
    L12:
        this.mLinkStatus = r7.mLinkStatus;
        this.mLinkType = r7.mLinkType;
        this.mRoleType = r7.mRoleType;
        this.listUserRole = r7.listUserRole;
        this.paidMoney = r7.paidMoney;
        this.paidCount = r7.paidCount;
        this.linkedListUserInfo = r7.linkedListUserInfo;
        this.micDress = r7.micDress;
        this.isEnlarged = r7.isEnlarged;
        this.linkmic2DAvatar = r7.linkmic2DAvatar;
        this.chorusGuestStatus = r7.chorusGuestStatus;
        this.selfDisciplineDuration = r7.selfDisciplineDuration;
        this.selfDisciplineTargetDuration = r7.selfDisciplineTargetDuration;
        this.themedCompetitionRole = r7.themedCompetitionRole;
        this.waitingListUserInfo = r7.waitingListUserInfo;
        this.rank = r7.rank;
        this.silenceStatus = r7.silenceStatus;
        this.mIsLinkRoomUser = r7.mIsLinkRoomUser;
        this.mLinkRoomId = r7.mLinkRoomId;
        this.mRoomLinkSilenceStatus = r7.mRoomLinkSilenceStatus;
        return;
    L16:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public boolean isEqual(ILinkPlayerInfoBridge r1) {
        return isEqual((LinkPlayerInfo) r1);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setMcStatus(long r1) {
        this.mcStatus = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge
    public void setUserPosition(int r1) {
        this.userPosition = r1;
    }

    public void update(LinkPlayerInfo r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (TextUtils.equals(this.mUser.getIdString(), r6.mUser.getIdString()) == false) goto L12;
        this.mFanTicket = r6.mFanTicket;
        this.mFanTicketDisplayStr = r6.mFanTicketDisplayStr;
        this.mUser = r6.mUser;
        long r0 = r6.mModifyTime;
        if (r0 <= this.mModifyTime) goto L9;
        this.mModifyTime = r0;
    L9:
        this.mLinkStatus = r6.mLinkStatus;
        this.mLinkType = r6.mLinkType;
        this.mRoleType = r6.mRoleType;
        this.listUserRole = r6.listUserRole;
        this.paidMoney = r6.paidMoney;
        this.paidCount = r6.paidCount;
        this.linkedListUserInfo = r6.linkedListUserInfo;
        this.micDress = r6.micDress;
        this.isEnlarged = r6.isEnlarged;
        this.linkmic2DAvatar = r6.linkmic2DAvatar;
        this.chorusGuestStatus = r6.chorusGuestStatus;
        this.selfDisciplineDuration = r6.selfDisciplineDuration;
        this.selfDisciplineTargetDuration = r6.selfDisciplineTargetDuration;
        this.themedCompetitionRole = r6.themedCompetitionRole;
        this.waitingListUserInfo = r6.waitingListUserInfo;
        this.rank = r6.rank;
        this.silenceStatus = r6.silenceStatus;
        this.mIsLinkRoomUser = r6.mIsLinkRoomUser;
        this.mLinkRoomId = r6.mLinkRoomId;
        this.mRoomLinkSilenceStatus = r6.mRoomLinkSilenceStatus;
        return;
    }

    public void updateByLinkUser(com.bytedance.android.livesdk.link.model.bridge.k r8, ListUserExtra r9) {
        this.mUser = r8.getUser();
        this.mInteractIdStr = r8.getLinkMicIdStr();
        this.mLinkStatus = r8.getStatus();
        this.userPosition = r8.getUserPosition();
        this.silenceStatus = r8.getSilenceStatus();
        this.mModifyTime = r8.getModifyTime();
        this.mRoleType = r8.getRoleType();
        this.mLinkType = r8.getLinkType();
        this.mediaType = r8.getApplyType();
        boolean r4 = true;
        if (r8.isBackground() != 1) goto L5;
        boolean r0 = true;
    L6:
        this.isBackground = r0;
        if (r8.getContent() == null) goto L12;
        if (r8.getContent().getLinkMicAudienceContent() == null) goto L12;
        this.linkmic2DAvatar = r8.getContent().getLinkMicAudienceContent().getLinkmic2DAvatar();
    L12:
        if (r8.getContent() != null) goto L14;
    L18:
        r4 = false;
    L19:
        this.isEnlarged = r4;
        if (r8.getContent() != null) goto L22;
    L24:
        if (r9 == null) goto L27;
        this.mFanTicket = r9.fanTicket;
        this.listUserRole = r9.listUserRole;
        this.linkedListUserInfo = LinkedListUserInfo.copy(r9.joinChannelTime, r9.expectLeaveTime, r9.currentTime);
        return;
    L27:
        return;
    L22:
        if (r8.getContent().getLinkMicAudienceContent() == null) goto L24;
        this.selfDisciplineDuration = r8.getContent().getLinkMicAudienceContent().getSelfDisciplineDurationTime();
        this.selfDisciplineTargetDuration = r8.getContent().getLinkMicAudienceContent().getSelfDisciplineDurationTime();
        this.themedCompetitionRole = r8.getContent().getLinkMicAudienceContent().getThemedCompetitionRole();
        this.chorusGuestStatus = r8.getContent().getLinkMicAudienceContent().getChorusGuestStatus();
        goto L24
    L14:
        if (r8.getContent().getLinkMicAudienceContent() == null) goto L18;
        if (r8.getContent().getLinkMicAudienceContent().isEnlarged() == false) goto L18;
    L5:
        r0 = false;
        goto L6
    }
}
