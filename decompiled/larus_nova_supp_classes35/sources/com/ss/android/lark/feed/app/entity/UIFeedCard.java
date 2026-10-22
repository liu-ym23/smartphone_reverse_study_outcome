package com.ss.android.lark.feed.app.entity;

import android.text.TextUtils;
import com.bytedance.lark.pb.feed.v1.AppFeedCardType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.biz.im.api.UrgentInfo;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.tab.v1.space.DocTabPayload;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.reaction.Reaction;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class UIFeedCard implements Comparable<UIFeedCard>, Cloneable, Serializable, IBadgeable {
    private String appId;
    private AtInfo atInfo;
    protected String avatarId;
    protected String avatarKey;
    private String bizId;
    private AppFeedCardType bizType;
    private int canSetStranger;
    private Chat.ChatMode chatMode;
    private boolean checkUser;
    protected ArrayList<DigestElement> digestMessage;
    private long displayTime;
    protected ArrayList<DigestElement> draftDigestMessage;
    private String draftMessage;
    private FeedCard.Type entityType;
    protected ArrayList<FeedCardButton> feedCardButtons;
    private FeedCard.FeedType feedType;
    private FlowDisplayType flowDisplayType;
    private String id;
    private boolean isBlocked;
    protected boolean isCrossTenant;
    private boolean isDisplayInShortcut;
    private boolean isExpiredFoldHint;
    private boolean isFake;
    private boolean isFirstTopRank;
    protected boolean isFlag;
    private boolean isFlowMainBot;
    private boolean isOfflineOncall;
    private boolean isPriorityProcessing;
    private boolean isRedBadge;
    protected boolean isRemind;
    protected boolean isShortCutFeed;
    private boolean isStranger;
    private boolean isSwipeRightPinned;
    private boolean isSwipedLeftPinned;
    private volatile transient WeakReference<DataObserver> mDataObserver;
    private int markType;
    private AutoMuteSettingNoticeType muteNoticeType;
    private MutexMarkType mutexMarkType;
    protected String name;
    private long onTopRankTime;
    private String parentCardId;
    private long rankPriority;
    private long rankTime;
    protected int reactionCount;
    protected int reactionDisplayCount;
    protected ArrayList<Reaction> reactions;
    private int shortcutPosition;
    private String uid;
    protected long unreadCount;
    private long updateTime;
    private ArrayList<UrgentInfo> urgentInfos;

    public static class AtInfo implements Serializable {
        private String atContent;
        private long atDisplayTime;
        private long atRankTime;
        private com.bytedance.lark.pb.feed.v1.AtInfo.AtType atType;
        private String avatarKey;
        private String id;
        private String localizedUserName;

        public int hashCode() {
            String r0 = this.avatarKey;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.localizedUserName;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public String getAtContent() {
            return this.atContent;
        }

        public long getAtDisplayTime() {
            return this.atDisplayTime;
        }

        public long getAtRankTime() {
            return this.atRankTime;
        }

        public com.bytedance.lark.pb.feed.v1.AtInfo.AtType getAtType() {
            return this.atType;
        }

        public String getAvatarKey() {
            return this.avatarKey;
        }

        public String getId() {
            return this.id;
        }

        public String getLocalizedUserName() {
            return this.localizedUserName;
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if (r4 != null) goto L8;
        L21:
            return false;
        L8:
            if (getClass() != r4.getClass()) goto L21;
            AtInfo r5 = (AtInfo) r4;
            if (Objects.equals(this.avatarKey, r5.avatarKey) == true) goto L14;
            return false;
        L14:
            if (this.atType == r5.atType) goto L17;
            return false;
        L17:
            if (Objects.equals(this.atContent, r5.atContent) == true) goto L20;
            return false;
        L20:
            return Objects.equals(this.localizedUserName, r5.localizedUserName);
        }

        public void setAtContent(String r1) {
            this.atContent = r1;
        }

        public void setAtDisplayTime(long r1) {
            this.atDisplayTime = r1;
        }

        public void setAtRankTime(long r1) {
            this.atRankTime = r1;
        }

        public void setAtType(com.bytedance.lark.pb.feed.v1.AtInfo.AtType r1) {
            this.atType = r1;
        }

        public void setAvatarKey(String r1) {
            this.avatarKey = r1;
        }

        public void setId(String r1) {
            this.id = r1;
        }

        public void setLocalizedUserName(String r1) {
            this.localizedUserName = r1;
        }

        public AtInfo(String r1, String r2, String r3) {
            this.id = r1;
            this.avatarKey = r2;
            this.localizedUserName = r3;
        }
    }

    public interface DataObserver {
        void onChanged(String r1);
    }

    public static final enum FlowDisplayType extends Enum<FlowDisplayType> {
        private static final /* synthetic */ FlowDisplayType[] $VALUES = null;
        public static final FlowDisplayType FLOW_LOCAL = null;
        public static final FlowDisplayType FROM_SERVER = null;
        public static final FlowDisplayType KV_STORAGE = null;
        public static final FlowDisplayType UNKNOWN = null;
        private final int value;

        static {
            FlowDisplayType r0 = new FlowDisplayType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            FlowDisplayType r1 = new FlowDisplayType("KV_STORAGE", 1, 1);
            KV_STORAGE = r1;
            FlowDisplayType r3 = new FlowDisplayType("FLOW_LOCAL", 2, 2);
            FLOW_LOCAL = r3;
            FlowDisplayType r5 = new FlowDisplayType("FROM_SERVER", 3, 3);
            FROM_SERVER = r5;
            $VALUES = new FlowDisplayType[]{r0, r1, r3, r5};
        }

        public static FlowDisplayType[] values() {
            return (FlowDisplayType[]) $VALUES.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static FlowDisplayType valueOf(String r1) {
            return (FlowDisplayType) a.a(FlowDisplayType.class, r1);
        }

        private FlowDisplayType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum MarkType extends Enum<MarkType> {
        private static final /* synthetic */ MarkType[] $VALUES = null;
        public static final MarkType AT_ALL = null;
        public static final MarkType AT_USER = null;
        public static final MarkType NO_REMIND_UNREAD = null;
        public static final MarkType UNKNOWN = null;
        public static final MarkType URGENT = null;
        private final int value;

        static {
            MarkType r0 = new MarkType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            MarkType r1 = new MarkType("URGENT", 1, 2);
            URGENT = r1;
            MarkType r3 = new MarkType("AT_USER", 2, 4);
            AT_USER = r3;
            MarkType r6 = new MarkType("AT_ALL", 3, 8);
            AT_ALL = r6;
            MarkType r8 = new MarkType("NO_REMIND_UNREAD", 4, 16);
            NO_REMIND_UNREAD = r8;
            $VALUES = new MarkType[]{r0, r1, r3, r6, r8};
        }

        public static MarkType[] values() {
            return (MarkType[]) $VALUES.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static MarkType valueOf(String r1) {
            return (MarkType) a.a(MarkType.class, r1);
        }

        private MarkType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public String getLog() {
        return BuildConfig.FLAVOR;
    }

    public boolean hasHighPriorityDisplay() {
        return false;
    }

    @Override // com.ss.android.lark.feed.app.entity.IBadgeable
    public int getBadgeCount() {
        return (int) this.unreadCount;
    }

    public Map<String, Object> getEventParams() {
        return new HashMap();
    }

    public MutexMarkType getMutexMarkType() {
        if (this.draftMessage == null) goto L7;
        return MutexMarkType.DRAFT;
    L7:
        return this.mutexMarkType;
    }

    public int getReactionCount() {
        if (this.draftMessage == null) goto L6;
        return 0;
    L6:
        return this.reactionCount;
    }

    public int getReactionDisplayCount() {
        if (this.draftMessage == null) goto L6;
        return 0;
    L6:
        return this.reactionDisplayCount;
    }

    public List<Reaction> getReactions() {
        if (this.draftMessage == null) goto L6;
        return null;
    L6:
        return this.reactions;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.id, this.entityType, this.feedType, this.uid, Boolean.valueOf(this.checkUser), Long.valueOf(this.updateTime), Long.valueOf(this.rankTime), Long.valueOf(this.displayTime), Long.valueOf(this.rankPriority), Boolean.valueOf(this.isSwipedLeftPinned), Boolean.valueOf(this.isSwipeRightPinned), this.parentCardId, this.chatMode, this.mDataObserver, Boolean.valueOf(this.isOfflineOncall), Boolean.valueOf(this.isRemind), Boolean.valueOf(this.isShortCutFeed), this.name, this.avatarId, this.avatarKey, Long.valueOf(this.unreadCount), this.digestMessage, this.atInfo, Integer.valueOf(this.shortcutPosition), Boolean.valueOf(this.isDisplayInShortcut), this.appId, this.bizId, this.bizType, Integer.valueOf(this.markType), Boolean.valueOf(this.isStranger), Boolean.valueOf(this.isBlocked), Integer.valueOf(this.canSetStranger), this.urgentInfos, this.mutexMarkType, this.draftMessage, this.reactions, Integer.valueOf(this.reactionCount), Integer.valueOf(this.reactionDisplayCount), this.draftDigestMessage, Boolean.valueOf(this.isCrossTenant), this.feedCardButtons, Integer.valueOf(this.muteNoticeType.getNumber()), Boolean.valueOf(this.isRedBadge), Boolean.valueOf(this.isFlowMainBot)});
    }

    public boolean isInChatBox() {
        if (TextUtils.isEmpty(this.parentCardId) == false) goto L5;
    L7:
        return false;
    L5:
        if (DocTabPayload.DocType.UNKNOWN.equals(this.parentCardId) == true) goto L7;
        return true;
    }

    public void notifyDataChanged() {
        if (this.mDataObserver != null) goto L5;
        return;
    L5:
        DataObserver r0 = this.mDataObserver.get();
        if (r0 == null) goto L9;
        r0.onChanged(this.id);
        return;
    }

    public String toString() {
        return "UIFeedCard{id='" + this.id + "', feedType=" + this.feedType + "'}";
    }

    public UIFeedCard() {
        this.bizType = AppFeedCardType.UNKNOWN_APP_FEED_CARD_TYPE;
        this.bizId = BuildConfig.FLAVOR;
        this.appId = BuildConfig.FLAVOR;
        this.rankPriority = 2147483647L;
        this.isDisplayInShortcut = false;
        this.urgentInfos = new ArrayList();
        this.canSetStranger = 0;
        this.muteNoticeType = AutoMuteSettingNoticeType.UNKNOWN;
        this.isRedBadge = true;
        this.flowDisplayType = FlowDisplayType.UNKNOWN;
        this.isFlowMainBot = false;
    }

    public UIFeedCard clone() throws CloneNotSupportedException {
        return (UIFeedCard) super.clone();
    }

    public long getRealRankTime() {
        return getRankTime();
    }

    public String getAppId() {
        return this.appId;
    }

    public AtInfo getAtInfo() {
        return this.atInfo;
    }

    public String getAvatarId() {
        return this.avatarId;
    }

    public String getAvatarKey() {
        return this.avatarKey;
    }

    public String getBizId() {
        return this.bizId;
    }

    public AppFeedCardType getBizType() {
        return this.bizType;
    }

    public int getCanSetStranger() {
        return this.canSetStranger;
    }

    public Chat.ChatMode getChatMode() {
        return this.chatMode;
    }

    public List<DigestElement> getDigestMessage() {
        return this.digestMessage;
    }

    public long getDisplayTime() {
        return this.displayTime;
    }

    public List<DigestElement> getDraftDigestMessage() {
        return this.draftDigestMessage;
    }

    public String getDraftMessage() {
        return this.draftMessage;
    }

    public ArrayList<FeedCardButton> getFeedCardButtons() {
        return this.feedCardButtons;
    }

    public FeedCard.FeedType getFeedType() {
        return this.feedType;
    }

    public FlowDisplayType getFlowDisplayType() {
        return this.flowDisplayType;
    }

    public String getId() {
        return this.id;
    }

    public boolean getIsDisplayInShortcut() {
        return this.isDisplayInShortcut;
    }

    public boolean getIsExpiredFoldHint() {
        return this.isExpiredFoldHint;
    }

    public boolean getIsFake() {
        return this.isFake;
    }

    public boolean getIsFirstTopRank() {
        return this.isFirstTopRank;
    }

    public boolean getIsFlowMainBot() {
        return this.isFlowMainBot;
    }

    public boolean getIsPriorityProcessing() {
        return this.isPriorityProcessing;
    }

    public int getMarkType() {
        return this.markType;
    }

    @Override // com.ss.android.lark.feed.app.entity.IBadgeable
    public AutoMuteSettingNoticeType getMuteNoticeType() {
        return this.muteNoticeType;
    }

    public String getName() {
        return this.name;
    }

    public boolean getOfflineOncall() {
        return this.isOfflineOncall;
    }

    public long getOnTopRankTime() {
        return this.onTopRankTime;
    }

    public String getParentCardId() {
        return this.parentCardId;
    }

    public long getRankPriority() {
        return this.rankPriority;
    }

    public long getRankTime() {
        return this.rankTime;
    }

    public int getShortcutPosition() {
        return this.shortcutPosition;
    }

    public FeedCard.Type getType() {
        return this.entityType;
    }

    public String getUid() {
        return this.uid;
    }

    public long getUnreadCount() {
        return this.unreadCount;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public ArrayList<UrgentInfo> getUrgentInfos() {
        return this.urgentInfos;
    }

    public boolean isBlocked() {
        return this.isBlocked;
    }

    public boolean isCheckUser() {
        return this.checkUser;
    }

    public boolean isCrossTenant() {
        return this.isCrossTenant;
    }

    public boolean isFlag() {
        return this.isFlag;
    }

    @Override // com.ss.android.lark.feed.app.entity.IBadgeable
    public boolean isRedBadge() {
        return this.isRedBadge;
    }

    @Override // com.ss.android.lark.feed.app.entity.IBadgeable
    public boolean isRemind() {
        return this.isRemind;
    }

    public boolean isShortCut() {
        return this.isShortCutFeed;
    }

    public boolean isStranger() {
        return this.isStranger;
    }

    public boolean isSwipeRightPinned() {
        return this.isSwipeRightPinned;
    }

    public boolean isSwipedLeftPinned() {
        return this.isSwipedLeftPinned;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object mo1165clone() throws CloneNotSupportedException {
        return clone();
    }

    public UIFeedCard(UIFeedCard r3) {
        this.bizType = AppFeedCardType.UNKNOWN_APP_FEED_CARD_TYPE;
        this.bizId = BuildConfig.FLAVOR;
        this.appId = BuildConfig.FLAVOR;
        this.rankPriority = 2147483647L;
        this.isDisplayInShortcut = false;
        this.urgentInfos = new ArrayList();
        this.canSetStranger = 0;
        this.muteNoticeType = AutoMuteSettingNoticeType.UNKNOWN;
        this.isRedBadge = true;
        this.flowDisplayType = FlowDisplayType.UNKNOWN;
        this.isFlowMainBot = false;
        if (r3 != null) goto L5;
        return;
    L5:
        this.id = r3.getId();
        this.entityType = r3.getType();
        this.feedType = r3.getFeedType();
        this.bizType = r3.bizType;
        this.bizId = r3.bizId;
        this.appId = r3.appId;
        this.rankTime = r3.getRankTime();
        this.displayTime = r3.getDisplayTime();
        this.updateTime = r3.getUpdateTime();
        this.chatMode = r3.getChatMode();
        this.parentCardId = r3.getParentCardId();
        this.chatMode = r3.getChatMode();
        this.isOfflineOncall = r3.getOfflineOncall();
        this.isRemind = r3.isRemind();
        this.onTopRankTime = r3.onTopRankTime;
        this.isPriorityProcessing = r3.isPriorityProcessing;
        this.isShortCutFeed = r3.isShortCut();
        this.markType = r3.markType;
        this.urgentInfos = r3.urgentInfos;
        this.isFlag = r3.isFlag();
        this.name = r3.name;
        this.avatarId = r3.avatarId;
        this.avatarKey = r3.avatarKey;
        this.unreadCount = r3.unreadCount;
        this.digestMessage = r3.digestMessage;
        this.atInfo = r3.atInfo;
        this.shortcutPosition = r3.shortcutPosition;
        this.isDisplayInShortcut = r3.isDisplayInShortcut;
        this.draftMessage = r3.draftMessage;
        this.mutexMarkType = r3.mutexMarkType;
        this.draftDigestMessage = r3.draftDigestMessage;
        this.reactions = r3.reactions;
        this.reactionDisplayCount = r3.reactionDisplayCount;
        this.reactionCount = r3.reactionCount;
        this.isCrossTenant = r3.isCrossTenant;
        this.feedCardButtons = r3.feedCardButtons;
        this.muteNoticeType = AutoMuteSettingNoticeType.valueOf(Integer.valueOf(r3.muteNoticeType.getNumber()));
        this.isStranger = r3.isStranger;
        this.isBlocked = r3.isBlocked;
        this.canSetStranger = r3.canSetStranger;
        this.isRedBadge = r3.isRedBadge;
        this.isFlowMainBot = r3.isFlowMainBot;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(UIFeedCard r8) {
        if (r8 != null) goto L5;
        return 1;
    L5:
        boolean r1 = UIFeedCardExtraKt.isOnTop(this);
        boolean r2 = UIFeedCardExtraKt.isOnTop(r8);
        if (r1 == false) goto L14;
        if (r2 == false) goto L14;
        if (getOnTopRankTime() <= r8.getOnTopRankTime()) goto L12;
        return -1;
    L12:
        if (getOnTopRankTime() >= r8.getOnTopRankTime()) goto L20;
        return 1;
    L20:
        long r3 = getRealRankTime();
        long r4 = r8.getRealRankTime();
        if (r3 >= r4) goto L23;
        return 1;
    L23:
        if (r3 <= r4) goto L25;
        return -1;
    L25:
        FeedCard.Type r0 = this.entityType;
        FeedCard.Type r5 = FeedCard.Type.DOUBAO_CONVERSATION;
        if (r0 != r5) goto L28;
    L32:
        return 0;
    L28:
        if (r8.entityType == r5) goto L32;
        return r8.getId().compareTo(getId());
    L14:
        if (r1 == true) goto L17;
        if (r2 == false) goto L17;
        return 1;
    L17:
        if (r1 == false) goto L20;
        if (r2 == true) goto L20;
        return -1;
    }

    public boolean equals(Object r8) {
        if (r8 != null) goto L5;
        return false;
    L5:
        if ((r8 instanceof UIFeedCard) == true) goto L8;
        return false;
    L8:
        if (this != r8) goto L10;
        return true;
    L10:
        UIFeedCard r9 = (UIFeedCard) r8;
        if (this.isRemind == r9.isRemind()) goto L14;
        return false;
    L14:
        if (this.muteNoticeType.getNumber() == r9.muteNoticeType.getNumber()) goto L17;
        return false;
    L17:
        if (TextUtils.equals(getId(), r9.getId()) == true) goto L19;
        return false;
    L19:
        if (Objects.equals(this.name, r9.name) == true) goto L21;
        return false;
    L21:
        if (Objects.equals(this.avatarId, r9.avatarId) == true) goto L23;
        return false;
    L23:
        if (Objects.equals(this.avatarKey, r9.avatarKey) == true) goto L25;
        return false;
    L25:
        if (this.unreadCount == r9.unreadCount) goto L27;
        return false;
    L27:
        if (this.shortcutPosition == r9.shortcutPosition) goto L29;
        return false;
    L29:
        if (this.isDisplayInShortcut == r9.isDisplayInShortcut) goto L31;
        return false;
    L31:
        if (digestMessageEquals(this.digestMessage, r9.digestMessage) == true) goto L33;
        return false;
    L33:
        if (Objects.equals(this.atInfo, r9.atInfo) == true) goto L35;
        return false;
    L35:
        if (Objects.equals(this.bizId, r9.bizId) == true) goto L37;
        return false;
    L37:
        if (Objects.equals(this.appId, r9.appId) == true) goto L39;
        return false;
    L39:
        if (this.bizType == r9.bizType) goto L41;
        return false;
    L41:
        if (this.feedType == r9.feedType) goto L43;
        return false;
    L43:
        if (this.entityType == r9.entityType) goto L45;
        return false;
    L45:
        if (this.markType == r9.markType) goto L47;
        return false;
    L47:
        if (this.isStranger == r9.isStranger) goto L49;
        return false;
    L49:
        if (this.isBlocked == r9.isBlocked) goto L51;
        return false;
    L51:
        if (Objects.equals(Integer.valueOf(this.canSetStranger), Integer.valueOf(r9.canSetStranger)) == true) goto L53;
        return false;
    L53:
        if (this.isRedBadge == r9.isRedBadge) goto L55;
        return false;
    L55:
        if (this.mutexMarkType == r9.mutexMarkType) goto L57;
        return false;
    L57:
        if (Objects.equals(this.draftMessage, r9.draftMessage) == true) goto L59;
        return false;
    L59:
        if (this.isCrossTenant == r9.isCrossTenant) goto L61;
        return false;
    L61:
        if (this.reactionCount == r9.reactionCount) goto L63;
        return false;
    L63:
        if (this.reactionDisplayCount == r9.reactionDisplayCount) goto L65;
        return false;
    L65:
        if (reactionEquals(this.reactions, r9.reactions) == true) goto L67;
        return false;
    L67:
        if (Objects.equals(this.draftDigestMessage, r9.draftDigestMessage) == true) goto L69;
        return false;
    L69:
        if (feedCardButtonsEquals(this.feedCardButtons, r9.feedCardButtons) == true) goto L71;
        return false;
    L71:
        if (urgentInfosEquals(this.urgentInfos, r9.urgentInfos) == true) goto L73;
        return false;
    L73:
        if (this.isFlowMainBot != r9.isFlowMainBot) goto L105;
        return true;
    L105:
        return false;
    }

    public boolean exactlyCompare(Object r7) {
        if (r7 != null) goto L5;
    L107:
        return false;
    L5:
        if ((r7 instanceof UIFeedCard) == false) goto L107;
        if (this != r7) goto L10;
        return true;
    L10:
        UIFeedCard r8 = (UIFeedCard) r7;
        if (r8.getDisplayTime() == getDisplayTime()) goto L14;
        return false;
    L14:
        if (r8.getRankTime() == getRankTime()) goto L17;
        return false;
    L17:
        if (r8.onTopRankTime == this.onTopRankTime) goto L20;
        return false;
    L20:
        if (r8.isPriorityProcessing == this.isPriorityProcessing) goto L23;
        return false;
    L23:
        if (r8.isFirstTopRank == this.isFirstTopRank) goto L26;
        return false;
    L26:
        if (r8.isExpiredFoldHint == this.isExpiredFoldHint) goto L29;
        return false;
    L29:
        if (TextUtils.equals(r8.getParentCardId(), this.parentCardId) == true) goto L32;
        return false;
    L32:
        if (r8.isRemind == this.isRemind) goto L35;
        return false;
    L35:
        if (r8.isCrossTenant == this.isCrossTenant) goto L38;
        return false;
    L38:
        if (r8.isShortCutFeed == this.isShortCutFeed) goto L41;
        return false;
    L41:
        if (r8.markType == this.markType) goto L44;
        return false;
    L44:
        if (r8.isStranger == this.isStranger) goto L47;
        return false;
    L47:
        if (r8.isBlocked == this.isBlocked) goto L50;
        return false;
    L50:
        if (Objects.equals(Integer.valueOf(this.canSetStranger), Integer.valueOf(r8.canSetStranger)) == true) goto L53;
        return false;
    L53:
        if (TextUtils.equals(this.name, r8.name) == true) goto L56;
        return false;
    L56:
        if (TextUtils.equals(this.avatarKey, r8.avatarKey) == true) goto L59;
        return false;
    L59:
        if (r8.unreadCount == this.unreadCount) goto L62;
        return false;
    L62:
        if (digestMessageEquals(this.digestMessage, r8.digestMessage) == true) goto L65;
        return false;
    L65:
        if (TextUtils.equals(this.draftMessage, r8.draftMessage) == true) goto L68;
        return false;
    L68:
        if (r8.isFlag == this.isFlag) goto L71;
        return false;
    L71:
        if (Objects.equals(r8.atInfo, this.atInfo) == true) goto L74;
        return false;
    L74:
        if (TextUtils.equals(this.draftMessage, r8.draftMessage) == true) goto L77;
        return false;
    L77:
        if (r8.mutexMarkType == this.mutexMarkType) goto L80;
        return false;
    L80:
        if (reactionEquals(this.reactions, r8.reactions) == true) goto L83;
        return false;
    L83:
        if (this.reactionCount != r8.reactionCount) goto L107;
        if (this.reactionDisplayCount != r8.reactionDisplayCount) goto L107;
        if (feedCardButtonsEquals(this.feedCardButtons, r8.feedCardButtons) == true) goto L91;
        return false;
    L91:
        if (urgentInfosEquals(this.urgentInfos, r8.urgentInfos) == true) goto L94;
        return false;
    L94:
        if (TextUtils.equals(this.appId, r8.appId) == true) goto L97;
        return false;
    L97:
        if (this.muteNoticeType.getNumber() == r8.muteNoticeType.getNumber()) goto L100;
        return false;
    L100:
        if (this.isRedBadge == r8.isRedBadge) goto L103;
        return false;
    L103:
        if (this.isFlowMainBot == r8.isFlowMainBot) goto L106;
        return false;
    L106:
        return TextUtils.equals(getId(), r8.getId());
    }

    public boolean isContainMarkType(MarkType r2) {
        int r0 = this.markType;
        if ((r2.getNumber() & r0) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void setAppId(String r1) {
        this.appId = r1;
    }

    public void setAtInfo(AtInfo r1) {
        this.atInfo = r1;
    }

    public void setAvatarId(String r1) {
        this.avatarId = r1;
    }

    public void setAvatarKey(String r1) {
        this.avatarKey = r1;
    }

    public void setBizId(String r1) {
        this.bizId = r1;
    }

    public void setBizType(AppFeedCardType r1) {
        this.bizType = r1;
    }

    public void setBlocked(boolean r1) {
        this.isBlocked = r1;
    }

    public void setCanSetStranger(int r1) {
        this.canSetStranger = r1;
    }

    public void setChatMode(Chat.ChatMode r1) {
        this.chatMode = r1;
    }

    public void setCheckUser(boolean r1) {
        this.checkUser = r1;
    }

    public void setCrossTenant(boolean r1) {
        this.isCrossTenant = r1;
    }

    public void setDataObserver(DataObserver r2) {
        this.mDataObserver = new WeakReference(r2);
    }

    public void setDigestMessage(ArrayList<DigestElement> r1) {
        this.digestMessage = r1;
    }

    public void setDisplayTime(long r1) {
        this.displayTime = r1;
    }

    public void setDraftDigestMessage(ArrayList<DigestElement> r1) {
        this.draftDigestMessage = r1;
    }

    public void setDraftMessage(String r1) {
        this.draftMessage = r1;
    }

    public void setFeedCardButtons(ArrayList<FeedCardButton> r1) {
        this.feedCardButtons = r1;
    }

    public void setFeedType(FeedCard.FeedType r1) {
        this.feedType = r1;
    }

    public void setFlag(boolean r1) {
        this.isFlag = r1;
    }

    public void setFlowDisplayType(FlowDisplayType r1) {
        this.flowDisplayType = r1;
    }

    public void setId(String r1) {
        this.id = r1;
    }

    public void setIsDisplayInShortcut(boolean r1) {
        this.isDisplayInShortcut = r1;
    }

    public void setIsExpiredFoldHint(boolean r1) {
        this.isExpiredFoldHint = r1;
    }

    public void setIsFake(boolean r1) {
        this.isFake = r1;
    }

    public void setIsFirstTopRank(boolean r1) {
        this.isFirstTopRank = r1;
    }

    public void setIsFlowMainBot(boolean r1) {
        this.isFlowMainBot = r1;
    }

    public void setIsPriorityProcessing(boolean r1) {
        this.isPriorityProcessing = r1;
    }

    public void setMarkType(int r1) {
        this.markType = r1;
    }

    public void setMuteNoticeType(AutoMuteSettingNoticeType r1) {
        this.muteNoticeType = AutoMuteSettingNoticeType.forNumber(Integer.valueOf(r1.getNumber()));
    }

    public void setMutexMarkType(MutexMarkType r1) {
        this.mutexMarkType = r1;
    }

    public void setName(String r1) {
        this.name = r1;
    }

    public void setOfflineOncall(boolean r1) {
        this.isOfflineOncall = r1;
    }

    public void setOnTopRankTime(long r1) {
        this.onTopRankTime = r1;
    }

    public void setParentCardId(String r1) {
        this.parentCardId = r1;
    }

    public void setRankPriority(long r1) {
        this.rankPriority = r1;
    }

    public void setRankTime(long r1) {
        this.rankTime = r1;
    }

    public void setReactionCount(int r1) {
        this.reactionCount = r1;
    }

    public void setReactionDisplayCount(int r1) {
        this.reactionDisplayCount = r1;
    }

    public void setReactions(ArrayList<Reaction> r1) {
        this.reactions = r1;
    }

    public void setRedBadge(boolean r1) {
        this.isRedBadge = r1;
    }

    public void setRemind(boolean r1) {
        this.isRemind = r1;
    }

    public void setShortCut(boolean r1) {
        this.isShortCutFeed = r1;
    }

    public void setShortcutPosition(int r1) {
        this.shortcutPosition = r1;
    }

    public void setStranger(boolean r1) {
        this.isStranger = r1;
    }

    public void setSwipeRightPinned(boolean r1) {
        this.isSwipeRightPinned = r1;
    }

    public void setSwipedLeftPinned(boolean r1) {
        this.isSwipedLeftPinned = r1;
    }

    public void setType(FeedCard.Type r1) {
        this.entityType = r1;
    }

    public void setUid(String r1) {
        this.uid = r1;
    }

    public void setUnreadCount(long r1) {
        this.unreadCount = r1;
    }

    public void setUpdateTime(long r1) {
        this.updateTime = r1;
    }

    public void setUrgentInfos(ArrayList<UrgentInfo> r1) {
        this.urgentInfos = r1;
    }

    public boolean shortcutCompare(Object r8) {
        if ((r8 instanceof UIFeedCard) == true) goto L6;
        return false;
    L6:
        if (this != r8) goto L8;
        return true;
    L8:
        UIFeedCard r9 = (UIFeedCard) r8;
        if (TextUtils.equals(this.id, r9.id) == true) goto L12;
        return false;
    L12:
        if (this.entityType == r9.entityType) goto L15;
        return false;
    L15:
        if (this.bizType == r9.bizType) goto L18;
        return false;
    L18:
        if (TextUtils.equals(this.bizId, r9.bizId) == true) goto L21;
        return false;
    L21:
        if (TextUtils.equals(this.appId, r9.appId) == true) goto L24;
        return false;
    L24:
        if (this.chatMode == r9.chatMode) goto L27;
        return false;
    L27:
        if (this.isRemind == r9.isRemind) goto L30;
        return false;
    L30:
        if (this.markType == r9.markType) goto L33;
        return false;
    L33:
        if (this.isStranger == r9.isStranger) goto L36;
        return false;
    L36:
        if (this.isBlocked == r9.isBlocked) goto L39;
        return false;
    L39:
        if (Objects.equals(Integer.valueOf(this.canSetStranger), Integer.valueOf(r9.canSetStranger)) == true) goto L42;
        return false;
    L42:
        if (this.feedType == r9.feedType) goto L45;
        return false;
    L45:
        if (TextUtils.equals(this.name, r9.name) == true) goto L48;
        return false;
    L48:
        if (TextUtils.equals(this.avatarId, r9.avatarId) == true) goto L51;
        return false;
    L51:
        if (TextUtils.equals(this.avatarKey, r9.avatarKey) == true) goto L54;
        return false;
    L54:
        if (this.unreadCount == r9.unreadCount) goto L57;
        return false;
    L57:
        if (this.shortcutPosition == r9.shortcutPosition) goto L60;
        return false;
    L60:
        if (this.isDisplayInShortcut == r9.isDisplayInShortcut) goto L63;
        return false;
    L63:
        if (this.bizType == r9.bizType) goto L66;
        return false;
    L66:
        if (this.isFlag == r9.isFlag) goto L69;
        return false;
    L69:
        if (this.muteNoticeType.getNumber() == r9.muteNoticeType.getNumber()) goto L72;
        return false;
    L72:
        if (this.isRedBadge == r9.isRedBadge) goto L75;
        return false;
    L75:
        if (TextUtils.equals(this.bizId, r9.bizId) == true) goto L77;
        return false;
    L77:
        return true;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UIFeedCard r1) {
        return compareTo2(r1);
    }

    public static boolean feedCardButtonsEquals(List<FeedCardButton> r7, List<FeedCardButton> r8) {
        if (r7 != null) goto L7;
        if (r8 != null) goto L7;
        return true;
    L7:
        if (r7 == null) goto L30;
        if (r8 == null) goto L30;
        if (r7.size() != r8.size()) goto L30;
        int r2 = 0;
    L14:
        if (r2 >= r7.size()) goto L29;
        FeedCardButton r3 = (FeedCardButton) ListProtector.get(r7, r2);
        FeedCardButton r4 = (FeedCardButton) ListProtector.get(r8, r2);
        if (r3 != null) goto L18;
        boolean r5 = true;
    L19:
        if (r4 != null) goto L21;
        boolean r6 = true;
    L22:
        if (r5 != r6) goto L28;
        if (r3 == null) goto L27;
        if (r3.isContentSame(r4) == false) goto L28;
    L27:
        r2 = r2 + 1;
    L28:
        return false;
    L21:
        r6 = false;
        goto L22
    L18:
        r5 = false;
        goto L19
    L29:
        return true;
    L30:
        return false;
    }

    private boolean reactionEquals(List<Reaction> r8, List<Reaction> r9) {
        if (r8 != null) goto L7;
        if (r9 != null) goto L7;
        return true;
    L7:
        if (r8 == null) goto L30;
        if (r9 == null) goto L30;
        if (r8.size() != r9.size()) goto L30;
        int r2 = 0;
    L14:
        if (r2 >= r8.size()) goto L29;
        Reaction r3 = (Reaction) ListProtector.get(r8, r2);
        Reaction r4 = (Reaction) ListProtector.get(r9, r2);
        if (r3 != null) goto L18;
        boolean r5 = true;
    L19:
        if (r4 != null) goto L21;
        boolean r6 = true;
    L22:
        if (r5 != r6) goto L28;
        if (r3 == null) goto L27;
        if (r3.isContentSame(r4) == false) goto L28;
    L27:
        r2 = r2 + 1;
    L28:
        return false;
    L21:
        r6 = false;
        goto L22
    L18:
        r5 = false;
        goto L19
    L29:
        return true;
    L30:
        return false;
    }

    public static boolean urgentInfosEquals(List<UrgentInfo> r7, List<UrgentInfo> r8) {
        if (r7 != null) goto L7;
        if (r8 != null) goto L7;
        return true;
    L7:
        if (r7 == null) goto L30;
        if (r8 == null) goto L30;
        if (r7.size() != r8.size()) goto L30;
        int r2 = 0;
    L14:
        if (r2 >= r7.size()) goto L29;
        UrgentInfo r3 = (UrgentInfo) ListProtector.get(r7, r2);
        UrgentInfo r4 = (UrgentInfo) ListProtector.get(r8, r2);
        if (r3 != null) goto L18;
        boolean r5 = true;
    L19:
        if (r4 != null) goto L21;
        boolean r6 = true;
    L22:
        if (r5 != r6) goto L28;
        if (r3 == null) goto L27;
        if (r3.isContentSame(r4) == false) goto L28;
    L27:
        r2 = r2 + 1;
    L28:
        return false;
    L21:
        r6 = false;
        goto L22
    L18:
        r5 = false;
        goto L19
    L29:
        return true;
    L30:
        return false;
    }

    public boolean digestMessageEquals(List<DigestElement> r8, List<DigestElement> r9) {
        if (r8 != null) goto L7;
        if (r9 != null) goto L7;
        return true;
    L7:
        if (r8 == null) goto L30;
        if (r9 == null) goto L30;
        if (r8.size() != r9.size()) goto L30;
        int r2 = 0;
    L14:
        if (r2 >= r8.size()) goto L29;
        DigestElement r3 = (DigestElement) ListProtector.get(r8, r2);
        DigestElement r4 = (DigestElement) ListProtector.get(r9, r2);
        if (r3 != null) goto L18;
        boolean r5 = true;
    L19:
        if (r4 != null) goto L21;
        boolean r6 = true;
    L22:
        if (r5 != r6) goto L28;
        if (r3 == null) goto L27;
        if (r3.isContentSame(r4) == false) goto L28;
    L27:
        r2 = r2 + 1;
    L28:
        return false;
    L21:
        r6 = false;
        goto L22
    L18:
        r5 = false;
        goto L19
    L29:
        return true;
    L30:
        return false;
    }

    public List<DigestElement> getDigestMessage(boolean r2, String r3) {
        if (TextUtils.isEmpty(r3) == true) goto L14;
        if (r2 == true) goto L14;
        ArrayList r4 = new ArrayList();
        ArrayList<DigestElement> r0 = this.draftDigestMessage;
        if (r0 == null) goto L9;
        r4.addAll(r0);
    L12:
        ListProtector.add(r4, 0, new TextProperty(r3));
        return r4;
    L9:
        ArrayList<DigestElement> r1 = this.digestMessage;
        if (r1 == null) goto L12;
        r4.addAll(r1);
    L14:
        ArrayList<DigestElement> r5 = this.draftDigestMessage;
        if (r5 == null) goto L18;
        return r5;
    L18:
        return this.digestMessage;
    }
}
