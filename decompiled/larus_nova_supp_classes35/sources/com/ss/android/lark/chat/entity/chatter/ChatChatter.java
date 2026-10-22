package com.ss.android.lark.chat.entity.chatter;

import com.ss.android.lark.chat.export.entity.chatter.IChatterDesc;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ChatChatter extends Chatter {
    String chatId;
    Chatter chatter;
    boolean isOutChatUser;
    String nickName;
    int onCallRole;
    String openId;
    private final List<TagInfo> tagInfos;

    @Retention(RetentionPolicy.SOURCE)
    public @interface OncallRole {
        public static final int ONCALL = 4;
        public static final int ONCALL_HELPER = 5;
        public static final int UNKNOWN = 0;
        public static final int USER = 3;
        public static final int USER_HELPER = 6;
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter, com.ss.android.lark.chat.export.entity.chatter.OpenChatter
    public o5b.a getAccess() {
        return this.chatter.getAccess();
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter
    public AccessInfo getAccessInfo() {
        return this.chatter.getAccessInfo();
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter, com.ss.android.lark.chat.export.entity.chatter.OpenChatter
    public String getAlias() {
        return this.chatter.getAlias();
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter
    public String getAnotherName() {
        return this.chatter.getAnotherName();
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter, com.ss.android.lark.chat.export.entity.chatter.OpenChatter
    public String getAvatarKey() {
        return this.chatter.getAvatarKey();
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter
    public AvatarMedal getAvatarMedal() {
        return this.chatter.getAvatarMedal();
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter
    public int getBotExtraType() {
        return this.chatter.getBotExtraType();
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter
    public ChatterSensitiveInfo getChatterSensitiveInfo() {
        return this.chatter.getChatterSensitiveInfo();
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter
    public List<String> getCommonLocales() {
        return this.chatter.getCommonLocales();
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter, com.ss.android.lark.chat.export.entity.chatter.OpenChatter
    public List<ChatterCustomStatus> getCustomStatus() {
        return this.chatter.getCustomStatus();
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter, com.ss.android.lark.chat.export.entity.chatter.OpenChatter
    public IChatterDesc getDesc() {
        return this.chatter.getDesc();
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter
    public ChatterDescription getDescription() {
        return this.chatter.getDescription();
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter, com.ss.android.lark.chat.export.entity.chatter.OpenChatter
    public String getEnName() {
        return this.chatter.getEnName();
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter
    public String getFullDepartmentName() {
        return this.chatter.getFullDepartmentName();
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter, com.ss.android.lark.chat.export.entity.chatter.OpenChatter
    public String getId() {
        return this.chatter.getId();
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter, com.ss.android.lark.chat.export.entity.chatter.OpenChatter
    public String getLocalizedName() {
        return this.chatter.getLocalizedName();
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter
    public String getMajorLanguage() {
        return this.chatter.getMajorLanguage();
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter, com.ss.android.lark.chat.export.entity.chatter.OpenChatter
    public String getName() {
        return this.chatter.getName();
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter
    public String getNamePinyin() {
        return this.chatter.getNamePinyin();
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter, com.ss.android.lark.chat.export.entity.chatter.OpenChatter
    public String getNamePy() {
        return this.chatter.getNamePy();
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter, com.ss.android.lark.chat.export.entity.chatter.OpenChatter
    public String getNameWithAnotherName() {
        return this.chatter.getNameWithAnotherName();
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter
    public String getOpenAppId() {
        Chatter r0 = this.chatter;
        if (r0 != null) goto L7;
        return BuildConfig.FLAVOR;
    L7:
        return r0.getOpenAppId();
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter
    public UserPrivateDescription getPrivateDescription() {
        return this.chatter.getPrivateDescription();
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter
    public boolean getRegistered() {
        return this.chatter.getRegistered();
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter
    public int getStatus() {
        return this.chatter.getStatus();
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter, com.ss.android.lark.chat.export.entity.chatter.OpenChatter
    public String getTenantId() {
        return this.chatter.getTenantId();
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter
    public TimeZone getTimeZone() {
        return this.chatter.getTimeZone();
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter
    public Chatter.ChatterType getType() {
        return this.chatter.getType();
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter
    public long getUpdateTime() {
        return this.chatter.getUpdateTime();
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter
    public String getWithBotTag() {
        return this.chatter.getWithBotTag();
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter
    public WorkStatus getWorkStatus() {
        return this.chatter.getWorkStatus();
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter, com.ss.android.lark.chat.export.entity.chatter.OpenChatter
    public long getZenModeEndTime() {
        return this.chatter.getZenModeEndTime();
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter
    public boolean isAcceptSmsPhoneUrgent() {
        return this.chatter.isAcceptSmsPhoneUrgent();
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter
    public boolean isAnonymous() {
        return this.chatter.isAnonymous();
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter
    public boolean isBotAgent() {
        return this.chatter.isBotAgent();
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter
    public boolean isDefaultAvatar() {
        return this.chatter.isDefaultAvatar();
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter, com.ss.android.lark.chat.export.entity.chatter.OpenChatter
    public boolean isFrozen() {
        return this.chatter.isFrozen();
    }

    public boolean isOncallDuty() {
        int r0 = this.onCallRole;
        if (r0 != 4) goto L5;
    L8:
        return true;
    L5:
        if (r0 == 5) goto L8;
        return false;
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter
    public boolean isProfileEnable() {
        return this.chatter.isProfileEnable();
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter
    public boolean isSpecialFocus() {
        return this.chatter.isSpecialFocus();
    }

    private ChatChatter() {
        this.openId = BuildConfig.FLAVOR;
        this.onCallRole = 0;
        this.tagInfos = new ArrayList();
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter
    public boolean showAgentTag() {
        return getChatter().showAgentTag();
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter
    public boolean showBotTag() {
        return getChatter().showBotTag();
    }

    public String getChatId() {
        return this.chatId;
    }

    public Chatter getChatter() {
        return this.chatter;
    }

    public String getNickName() {
        return this.nickName;
    }

    public int getOnCallRole() {
        return this.onCallRole;
    }

    public String getOpenId() {
        return this.openId;
    }

    public List<TagInfo> getTagInfos() {
        return this.tagInfos;
    }

    public boolean isOutChatUser() {
        return this.isOutChatUser;
    }

    public ChatChatter(Chatter r2) {
        this.openId = BuildConfig.FLAVOR;
        this.onCallRole = 0;
        this.tagInfos = new ArrayList();
        this.chatter = r2;
        setTagData(r2.getTagData());
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter, java.lang.Comparable
    public int compareTo(Object r2) {
        if ((r2 instanceof ChatChatter) == true) goto L7;
        return 0;
    L7:
        return this.chatter.compareTo(((ChatChatter) r2).chatter);
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter
    public boolean equals(Object r2) {
        if ((r2 instanceof Chatter) == true) goto L5;
        return false;
    L5:
        return getId().equals(((Chatter) r2).getId());
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter
    public boolean isContentSame(Chatter r4) {
        if ((r4 instanceof ChatChatter) == true) goto L5;
        return false;
    L5:
        ChatChatter r5 = (ChatChatter) r4;
        if (y28.a.c(this.chatter, r5.chatter) == true) goto L8;
        return false;
    L8:
        if (y28.a.a(this.chatId, r5.chatId) == true) goto L10;
        return false;
    L10:
        if (y28.a.a(this.nickName, r5.nickName) == true) goto L12;
        return false;
    L12:
        if (y28.a.a(Integer.valueOf(this.onCallRole), Integer.valueOf(r5.onCallRole)) == false) goto L18;
        return true;
    L18:
        return false;
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter
    public /* bridge */ /* synthetic */ boolean isItemSame(y28.b r1) {
        return isItemSame((Chatter) r1);
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter
    public void setAccessInfo(AccessInfo r2) {
        this.chatter.setAccessInfo(r2);
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter
    public void setAnotherName(String r2) {
        this.chatter.setAnotherName(r2);
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter
    public void setAvatarKey(String r2) {
        this.chatter.setAvatarKey(r2);
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter
    public void setAvatarMedal(AvatarMedal r2) {
        this.chatter.setAvatarMedal(r2);
    }

    public void setChatId(String r1) {
        this.chatId = r1;
    }

    public void setChatter(Chatter r1) {
        this.chatter = r1;
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter
    public void setChatterSensitiveInfo(ChatterSensitiveInfo r2) {
        this.chatter.setChatterSensitiveInfo(r2);
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter
    public void setDefaultAvatar(boolean r2) {
        this.chatter.setDefaultAvatar(r2);
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter
    public void setLocalizedName(String r2) {
        this.chatter.setLocalizedName(r2);
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter
    public void setMajorLanguage(String r2) {
        this.chatter.setMajorLanguage(r2);
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter
    public void setNameWithAnotherName(String r2) {
        this.chatter.setNameWithAnotherName(r2);
    }

    public void setNickName(String r1) {
        this.nickName = r1;
    }

    public void setOnCallRole(int r1) {
        this.onCallRole = r1;
    }

    public void setOpenId(String r1) {
        if (r1 != null) goto L4;
        r1 = BuildConfig.FLAVOR;
    L4:
        this.openId = r1;
    }

    public void setOutChatUser(boolean r1) {
        this.isOutChatUser = r1;
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter
    public void setPrivateDescription(UserPrivateDescription r2) {
        this.chatter.setPrivateDescription(r2);
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter
    public void setProfileEnable(boolean r2) {
        this.chatter.setProfileEnable(r2);
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter
    public void setSpecialFocus(boolean r2) {
        this.chatter.setSpecialFocus(r2);
    }

    public void setTagInfos(List<TagInfo> r2) {
        this.tagInfos.clear();
        this.tagInfos.addAll(r2);
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter
    public void setTimeZone(TimeZone r2) {
        this.chatter.setTimeZone(r2);
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter
    public void setWorkStatus(WorkStatus r2) {
        this.chatter.setWorkStatus(r2);
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter
    public void setZenModeEndTime(long r2) {
        this.chatter.setZenModeEndTime(r2);
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter
    public /* bridge */ /* synthetic */ boolean isContentSame(y28.b r1) {
        return isContentSame((Chatter) r1);
    }

    @Override // com.ss.android.lark.chat.entity.chatter.Chatter
    public boolean isItemSame(Chatter r1) {
        return equals(r1);
    }
}
