package com.ss.android.lark.feed.shared.data.preview;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Chatter;
import com.bytedance.lark.pb.basic.v1.Tag;
import com.bytedance.lark.pb.feed.v1.AIKnowledgeQueryStatus;
import com.ss.android.lark.biz.im.api.ChatNotMemberType;
import com.ss.android.lark.biz.im.api.FeedTeamInfo;
import com.ss.android.lark.biz.im.api.FocusInfo;
import com.ss.android.lark.biz.im.api.MessageType;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.tab.v1.space.DocTabPayload;
import com.ss.android.lark.chat.entity.Item;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chat.ChatTeamInfo;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.parser.internal.a0;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ChatFeedPreview extends FeedPreview {
    private AIKnowledgeQueryStatus atKnowledgeAiQueryStatus;
    private ArrayList<ChatTeamInfo> boundTeamInfos;
    private Chat.ChatMode chatMode;
    private ChatNotMemberType chatNotMemberType;
    private int chatReadable;
    private Chat.Role chatRole;
    private Chat.Type chatType;
    private int chatterApplyCount;
    private boolean digestIsQuery;
    private FocusInfo focusInfo;
    private boolean isAIBotChat;
    private boolean isAIMainChat;
    private boolean isBotChat;
    private boolean isBotMute;
    private boolean isChatAdmin;
    private boolean isChatOwner;
    private boolean isCrossWithKa;
    private boolean isDepartment;
    private boolean isFrozen;
    private boolean isMeeting;
    private boolean isMyThreadUpdated;
    private boolean isOfficialOncall;
    private boolean isOfflineOncall;
    private boolean isPublic;
    private boolean isSecret;
    private boolean isShowAgentTag;
    private boolean isShowBotTag;
    private boolean isSpecialFocus;
    private boolean isSuper;
    private boolean isTenantChat;
    private boolean isUserCountVisible;
    private ArrayList<Item> items;
    private ArrayList<FeedTeamInfo> joinedTeamInfos;
    private boolean lastHasSmartReply;
    private Message.Type lastMessageType;
    private String miniAvatarKey;
    private String onCallId;
    private String orderAvatarKey;
    private String p2pChatterId;
    private boolean showSwitch;
    private List<Chatter.ChatterCustomStatus> status;
    private List<Tag> tags;
    private int userCount;
    private long zenModeEndTime;

    @Override // com.ss.android.lark.feed.shared.data.preview.FeedPreview, com.ss.android.lark.feed.app.entity.UIFeedCard
    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), Boolean.valueOf(this.isBotChat), Boolean.valueOf(this.isBotMute), Boolean.valueOf(this.isMeeting), Boolean.valueOf(this.isSecret), this.chatType, Boolean.valueOf(this.isDepartment), Boolean.valueOf(this.isTenantChat), Boolean.valueOf(this.isSuper), Boolean.valueOf(this.isOfflineOncall), this.onCallId, this.chatRole, this.focusInfo, Integer.valueOf(this.chatterApplyCount), Boolean.valueOf(this.isSpecialFocus), Boolean.valueOf(this.showSwitch), this.orderAvatarKey, Integer.valueOf(this.userCount), Boolean.valueOf(this.isUserCountVisible), this.items, this.joinedTeamInfos, this.boundTeamInfos, Boolean.valueOf(this.isFrozen), Boolean.valueOf(this.isAIMainChat), Boolean.valueOf(this.isAIBotChat), Boolean.valueOf(this.lastHasSmartReply), this.atKnowledgeAiQueryStatus, Boolean.valueOf(this.digestIsQuery), this.tags, Boolean.valueOf(this.isChatAdmin), Boolean.valueOf(this.isChatOwner), this.chatNotMemberType});
    }

    public boolean isShowOnCallTag() {
        if (TextUtils.isEmpty(this.onCallId) == false) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.equals(this.onCallId, DocTabPayload.DocType.UNKNOWN) == true) goto L7;
        return true;
    }

    public ChatFeedPreview() {
        this.isUserCountVisible = true;
        this.chatReadable = 0;
    }

    @Override // com.ss.android.lark.feed.shared.data.preview.FeedPreview, com.ss.android.lark.feed.app.entity.UIFeedCard
    public ChatFeedPreview clone() throws CloneNotSupportedException {
        ChatFeedPreview r0 = (ChatFeedPreview) super.clone();
        r0.isBotChat = this.isBotChat;
        r0.isBotMute = this.isBotMute;
        r0.isMeeting = this.isMeeting;
        r0.isSecret = this.isSecret;
        r0.isShowBotTag = this.isShowBotTag;
        r0.isCrossWithKa = this.isCrossWithKa;
        r0.chatType = this.chatType;
        r0.chatMode = this.chatMode;
        r0.lastMessageType = this.lastMessageType;
        r0.isDepartment = this.isDepartment;
        r0.isTenantChat = this.isTenantChat;
        r0.isSuper = this.isSuper;
        r0.isPublic = this.isPublic;
        r0.isOfficialOncall = this.isOfficialOncall;
        r0.isOfflineOncall = this.isOfflineOncall;
        r0.onCallId = this.onCallId;
        r0.zenModeEndTime = this.zenModeEndTime;
        r0.miniAvatarKey = this.miniAvatarKey;
        r0.p2pChatterId = this.p2pChatterId;
        r0.isMyThreadUpdated = this.isMyThreadUpdated;
        r0.tags = this.tags;
        r0.focusInfo = this.focusInfo;
        r0.chatterApplyCount = this.chatterApplyCount;
        r0.isSpecialFocus = this.isSpecialFocus;
        r0.status = this.status;
        r0.chatRole = this.chatRole;
        r0.orderAvatarKey = this.orderAvatarKey;
        r0.showSwitch = this.showSwitch;
        r0.userCount = this.userCount;
        r0.isUserCountVisible = this.isUserCountVisible;
        r0.isFrozen = this.isFrozen;
        r0.items = this.items;
        r0.joinedTeamInfos = this.joinedTeamInfos;
        r0.boundTeamInfos = this.boundTeamInfos;
        r0.isAIMainChat = this.isAIMainChat;
        r0.isAIBotChat = this.isAIBotChat;
        r0.isChatAdmin = this.isChatAdmin;
        r0.chatNotMemberType = this.chatNotMemberType;
        r0.isChatOwner = this.isChatOwner;
        r0.lastHasSmartReply = this.lastHasSmartReply;
        r0.atKnowledgeAiQueryStatus = this.atKnowledgeAiQueryStatus;
        r0.digestIsQuery = this.digestIsQuery;
        r0.setFeedNameTag(getFeedNameTag());
        return r0;
    }

    public AIKnowledgeQueryStatus getAtKnowledgeAiQueryStatus() {
        return this.atKnowledgeAiQueryStatus;
    }

    public ArrayList<ChatTeamInfo> getBoundTeamInfos() {
        return this.boundTeamInfos;
    }

    @Override // com.ss.android.lark.feed.app.entity.UIFeedCard
    public Chat.ChatMode getChatMode() {
        return this.chatMode;
    }

    public ChatNotMemberType getChatNotMemberType() {
        return this.chatNotMemberType;
    }

    public int getChatReadable() {
        return this.chatReadable;
    }

    public Chat.Role getChatRole() {
        return this.chatRole;
    }

    public Chat.Type getChatType() {
        return this.chatType;
    }

    public int getChatterApplyCount() {
        return this.chatterApplyCount;
    }

    public FocusInfo getFocusInfo() {
        return this.focusInfo;
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public ArrayList<FeedTeamInfo> getJoinedTeamInfos() {
        return this.joinedTeamInfos;
    }

    public boolean getLastHasSmartReply() {
        return this.lastHasSmartReply;
    }

    public Message.Type getLastMessageType() {
        return this.lastMessageType;
    }

    public String getMiniAvatarKey() {
        return this.miniAvatarKey;
    }

    public String getOnCallId() {
        return this.onCallId;
    }

    public String getOrderAvatarKey() {
        return this.orderAvatarKey;
    }

    public String getP2pChatterId() {
        return this.p2pChatterId;
    }

    public boolean getShowSwitch() {
        return this.showSwitch;
    }

    public List<Chatter.ChatterCustomStatus> getStatus() {
        return this.status;
    }

    public List<Tag> getTags() {
        return this.tags;
    }

    public int getUserCount() {
        return this.userCount;
    }

    public long getZenModeEndTime() {
        return this.zenModeEndTime;
    }

    public boolean isAIBotChat() {
        return this.isAIBotChat;
    }

    public boolean isAIMainChat() {
        return this.isAIMainChat;
    }

    public boolean isBotChat() {
        return this.isBotChat;
    }

    public boolean isBotMute() {
        return this.isBotMute;
    }

    public boolean isChatAdmin() {
        return this.isChatAdmin;
    }

    public boolean isChatOwner() {
        return this.isChatOwner;
    }

    public boolean isCrossWithKa() {
        return this.isCrossWithKa;
    }

    public boolean isDepartment() {
        return this.isDepartment;
    }

    public boolean isDigestIsQuery() {
        return this.digestIsQuery;
    }

    public boolean isFrozen() {
        return this.isFrozen;
    }

    public boolean isMeeting() {
        return this.isMeeting;
    }

    public boolean isMyThreadUpdated() {
        return this.isMyThreadUpdated;
    }

    public boolean isOfficialOncall() {
        return this.isOfficialOncall;
    }

    public boolean isOfflineOncall() {
        return this.isOfflineOncall;
    }

    public boolean isPublic() {
        return this.isPublic;
    }

    public boolean isSecret() {
        return this.isSecret;
    }

    public boolean isShowAgentTag() {
        return this.isShowAgentTag;
    }

    public boolean isShowBotTag() {
        return this.isShowBotTag;
    }

    public boolean isShowSwitch() {
        return this.showSwitch;
    }

    public boolean isSpecialFocus() {
        return this.isSpecialFocus;
    }

    public boolean isSuper() {
        return this.isSuper;
    }

    public boolean isTenantChat() {
        return this.isTenantChat;
    }

    public boolean isUserCountVisible() {
        return this.isUserCountVisible;
    }

    @Override // com.ss.android.lark.feed.shared.data.preview.FeedPreview, com.ss.android.lark.feed.app.entity.UIFeedCard
    public /* bridge */ /* synthetic */ UIFeedCard clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // com.ss.android.lark.feed.shared.data.preview.FeedPreview, com.ss.android.lark.feed.app.entity.UIFeedCard
    public /* bridge */ /* synthetic */ FeedPreview clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // com.ss.android.lark.feed.shared.data.preview.FeedPreview, com.ss.android.lark.feed.app.entity.UIFeedCard
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo1165clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // com.ss.android.lark.feed.shared.data.preview.FeedPreview, com.ss.android.lark.feed.app.entity.UIFeedCard
    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (r8 != null) goto L8;
    L80:
        return false;
    L8:
        if (getClass() != r8.getClass()) goto L80;
        if (super.equals(r8) == true) goto L13;
        return false;
    L13:
        ChatFeedPreview r9 = (ChatFeedPreview) r8;
        if (this.isBotChat == r9.isBotChat) goto L16;
    L78:
        return false;
    L16:
        if (this.isBotMute != r9.isBotMute) goto L78;
        if (this.isMeeting != r9.isMeeting) goto L78;
        if (this.isSecret != r9.isSecret) goto L78;
        if (this.isDepartment != r9.isDepartment) goto L78;
        if (this.isTenantChat != r9.isTenantChat) goto L78;
        if (this.isSuper != r9.isSuper) goto L78;
        if (this.isOfflineOncall != r9.isOfflineOncall) goto L78;
        if (this.chatType != r9.chatType) goto L78;
        if (Objects.equals(this.onCallId, r9.onCallId) == false) goto L78;
        if (this.chatRole != r9.chatRole) goto L78;
        if (this.zenModeEndTime != r9.zenModeEndTime) goto L78;
        if (this.showSwitch != r9.showSwitch) goto L78;
        if (Objects.equals(this.orderAvatarKey, r9.orderAvatarKey) == false) goto L78;
        if (Objects.equals(this.focusInfo, r9.focusInfo) == false) goto L78;
        if (this.chatterApplyCount != r9.chatterApplyCount) goto L78;
        if (this.isSpecialFocus != r9.isSpecialFocus) goto L78;
        if (this.userCount != r9.userCount) goto L78;
        if (this.isUserCountVisible != r9.isUserCountVisible) goto L78;
        if (Objects.equals(this.items, r9.items) == false) goto L78;
        if (Objects.equals(this.joinedTeamInfos, r9.joinedTeamInfos) == false) goto L78;
        if (this.isFrozen != r9.isFrozen) goto L78;
        if (Objects.equals(this.boundTeamInfos, r9.boundTeamInfos) == false) goto L78;
        if (this.isAIMainChat != r9.isAIMainChat) goto L78;
        if (this.isAIBotChat != r9.isAIBotChat) goto L78;
        if (this.isChatAdmin != r9.isChatAdmin) goto L78;
        if (this.isChatOwner != r9.isChatOwner) goto L78;
        if (this.chatNotMemberType != r9.chatNotMemberType) goto L78;
        if (this.lastHasSmartReply != r9.lastHasSmartReply) goto L78;
        if (this.atKnowledgeAiQueryStatus != r9.atKnowledgeAiQueryStatus) goto L78;
        if (this.digestIsQuery != r9.digestIsQuery) goto L78;
        if (Objects.equals(this.tags, r9.tags) == false) goto L78;
        return true;
    }

    @Override // com.ss.android.lark.feed.shared.data.preview.FeedPreview, com.ss.android.lark.feed.app.entity.UIFeedCard
    public boolean exactlyCompare(Object r8) {
        if (r8 != null) goto L5;
    L99:
        return false;
    L5:
        if ((r8 instanceof ChatFeedPreview) == false) goto L99;
        if (this != r8) goto L10;
        return true;
    L10:
        ChatFeedPreview r1 = (ChatFeedPreview) r8;
        if (r1.isBotChat == this.isBotChat) goto L14;
        return false;
    L14:
        if (r1.isBotMute == this.isBotMute) goto L17;
        return false;
    L17:
        if (r1.isDepartment == this.isDepartment) goto L20;
        return false;
    L20:
        if (r1.isSuper == this.isSuper) goto L23;
        return false;
    L23:
        if (Objects.equals(a0.a(r1.getTagData()), a0.a(getTagData())) == true) goto L26;
        return false;
    L26:
        if (r1.isTenantChat == this.isTenantChat) goto L29;
        return false;
    L29:
        if (r1.chatType == this.chatType) goto L32;
        return false;
    L32:
        if (TextUtils.equals(r1.onCallId, this.onCallId) == true) goto L35;
        return false;
    L35:
        if (r1.isOfflineOncall == this.isOfflineOncall) goto L38;
        return false;
    L38:
        if (r1.zenModeEndTime == this.zenModeEndTime) goto L41;
        return false;
    L41:
        if (r1.chatRole == this.chatRole) goto L44;
        return false;
    L44:
        if (Objects.equals(this.focusInfo, r1.focusInfo) == true) goto L47;
        return false;
    L47:
        if (this.chatterApplyCount == r1.chatterApplyCount) goto L50;
        return false;
    L50:
        if (this.isSpecialFocus == r1.isSpecialFocus) goto L53;
        return false;
    L53:
        if (r1.showSwitch == this.showSwitch) goto L56;
        return false;
    L56:
        if (Objects.equals(r1.orderAvatarKey, this.orderAvatarKey) == true) goto L59;
        return false;
    L59:
        if (Objects.equals(this.items, r1.items) == true) goto L62;
        return false;
    L62:
        if (Objects.equals(this.joinedTeamInfos, r1.joinedTeamInfos) == true) goto L65;
        return false;
    L65:
        if (Objects.equals(this.boundTeamInfos, r1.boundTeamInfos) == true) goto L68;
        return false;
    L68:
        if (this.isFrozen == r1.isFrozen) goto L71;
        return false;
    L71:
        if (this.isAIMainChat == r1.isAIMainChat) goto L74;
        return false;
    L74:
        if (this.isAIBotChat == r1.isAIBotChat) goto L77;
        return false;
    L77:
        if (this.isChatAdmin == r1.isChatAdmin) goto L80;
        return false;
    L80:
        if (this.isChatOwner == r1.isChatOwner) goto L83;
        return false;
    L83:
        if (this.chatNotMemberType == r1.chatNotMemberType) goto L86;
        return false;
    L86:
        if (this.lastHasSmartReply == r1.lastHasSmartReply) goto L89;
        return false;
    L89:
        if (this.atKnowledgeAiQueryStatus == r1.atKnowledgeAiQueryStatus) goto L92;
        return false;
    L92:
        if (this.digestIsQuery == r1.digestIsQuery) goto L95;
        return false;
    L95:
        if (Objects.equals(this.tags, r1.tags) == true) goto L98;
        return false;
    L98:
        return super.exactlyCompare(r8);
    }

    public boolean hasHighPriorityDisplay(MessageType r4) {
        if (r4 != MessageType.AT) goto L10;
        if (getAtInfo() != null) goto L28;
        return false;
    L28:
        return true;
    L10:
        if (r4 != MessageType.URGENT) goto L14;
        return isContainMarkType(UIFeedCard.MarkType.URGENT);
    L14:
        if (r4 != MessageType.FOCUS) goto L21;
        if (getFocusInfo() != null) goto L29;
        return false;
    L29:
        return true;
    L21:
        if (r4 == MessageType.CHATTER_APPLY) goto L23;
        return false;
    L23:
        if (getChatterApplyCount() > 0) goto L30;
        return false;
    L30:
        return true;
    }

    public void setAIBotChat(boolean r1) {
        this.isAIBotChat = r1;
    }

    public void setAIMainChat(boolean r1) {
        this.isAIMainChat = r1;
    }

    public void setAtKnowledgeAiQueryStatus(AIKnowledgeQueryStatus r1) {
        this.atKnowledgeAiQueryStatus = r1;
    }

    public void setBotChat(boolean r1) {
        this.isBotChat = r1;
    }

    public void setBotMute(boolean r1) {
        this.isBotMute = r1;
    }

    public void setBoundTeamInfos(ArrayList<ChatTeamInfo> r1) {
        this.boundTeamInfos = r1;
    }

    public void setChatAdmin(boolean r1) {
        this.isChatAdmin = r1;
    }

    @Override // com.ss.android.lark.feed.app.entity.UIFeedCard
    public void setChatMode(Chat.ChatMode r1) {
        this.chatMode = r1;
    }

    public void setChatNotMemberType(ChatNotMemberType r1) {
        this.chatNotMemberType = r1;
    }

    public void setChatOwner(boolean r1) {
        this.isChatOwner = r1;
    }

    public void setChatReadable(int r1) {
        this.chatReadable = r1;
    }

    public void setChatRole(Chat.Role r1) {
        this.chatRole = r1;
    }

    public void setChatType(Chat.Type r1) {
        this.chatType = r1;
    }

    public void setChatterApplyCount(int r1) {
        this.chatterApplyCount = r1;
    }

    public void setCrossWithKa(boolean r1) {
        this.isCrossWithKa = r1;
    }

    public void setDepartment(boolean r1) {
        this.isDepartment = r1;
    }

    public void setDigestIsQuery(boolean r1) {
        this.digestIsQuery = r1;
    }

    public void setFocusInfo(FocusInfo r1) {
        this.focusInfo = r1;
    }

    public void setFrozen(boolean r1) {
        this.isFrozen = r1;
    }

    public void setItems(ArrayList<Item> r1) {
        this.items = r1;
    }

    public void setJoinedTeamInfos(ArrayList<FeedTeamInfo> r1) {
        this.joinedTeamInfos = r1;
    }

    public void setLastHasSmartReply(boolean r1) {
        this.lastHasSmartReply = r1;
    }

    public void setLastMessageType(Message.Type r1) {
        this.lastMessageType = r1;
    }

    public void setMeeting(boolean r1) {
        this.isMeeting = r1;
    }

    public void setMiniAvatarKey(String r1) {
        this.miniAvatarKey = r1;
    }

    public void setMyThreadUpdated(boolean r1) {
        this.isMyThreadUpdated = r1;
    }

    public void setOfficialOncall(boolean r1) {
        this.isOfficialOncall = r1;
    }

    @Override // com.ss.android.lark.feed.app.entity.UIFeedCard
    public void setOfflineOncall(boolean r1) {
        this.isOfflineOncall = r1;
    }

    public void setOnCallId(String r1) {
        this.onCallId = r1;
    }

    public void setOrderAvatarKey(String r1) {
        this.orderAvatarKey = r1;
    }

    public void setP2pChatterId(String r1) {
        this.p2pChatterId = r1;
    }

    public void setPublic(boolean r1) {
        this.isPublic = r1;
    }

    public void setSecret(boolean r1) {
        this.isSecret = r1;
    }

    public void setShowAgentTag(boolean r1) {
        this.isShowAgentTag = r1;
    }

    public void setShowBotTag(boolean r1) {
        this.isShowBotTag = r1;
    }

    public void setShowSwitch(boolean r1) {
        this.showSwitch = r1;
    }

    public void setSpecialFocus(boolean r1) {
        this.isSpecialFocus = r1;
    }

    public void setStatus(List<Chatter.ChatterCustomStatus> r1) {
        this.status = r1;
    }

    public void setSuper(boolean r1) {
        this.isSuper = r1;
    }

    public void setTags(List<Tag> r1) {
        this.tags = r1;
    }

    public void setTenantChat(boolean r1) {
        this.isTenantChat = r1;
    }

    public void setUserCount(int r1) {
        this.userCount = r1;
    }

    public void setUserCountVisible(boolean r1) {
        this.isUserCountVisible = r1;
    }

    public void setZenModeEndTime(long r1) {
        this.zenModeEndTime = r1;
    }

    @Override // com.ss.android.lark.feed.app.entity.UIFeedCard
    public boolean shortcutCompare(Object r5) {
        if ((r5 instanceof ChatFeedPreview) == true) goto L5;
        return false;
    L5:
        if (this != r5) goto L8;
        return true;
    L8:
        ChatFeedPreview r0 = (ChatFeedPreview) r5;
        if (this.isSecret == r0.isSecret) goto L12;
        return false;
    L12:
        if (this.chatType == r0.chatType) goto L15;
        return false;
    L15:
        if (TextUtils.equals(this.p2pChatterId, r0.p2pChatterId) == true) goto L18;
        return false;
    L18:
        if (this.showSwitch == r0.showSwitch) goto L21;
        return false;
    L21:
        if (TextUtils.equals(this.orderAvatarKey, r0.orderAvatarKey) == true) goto L24;
        return false;
    L24:
        if (Objects.equals(this.tags, r0.tags) == true) goto L27;
        return false;
    L27:
        return super.shortcutCompare(r5);
    }
}
