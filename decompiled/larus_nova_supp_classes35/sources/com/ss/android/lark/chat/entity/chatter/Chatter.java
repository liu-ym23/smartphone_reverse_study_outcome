package com.ss.android.lark.chat.entity.chatter;

import android.text.TextUtils;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.tab.v1.space.DocTabPayload;
import com.ss.android.lark.chat.entity.tag.TagData;
import com.ss.android.lark.chat.export.entity.chatter.IChatterDesc;
import com.ss.android.lark.chat.export.entity.chatter.OpenChatter;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class Chatter implements uxb.a, OpenChatter, Serializable, Comparable, y28.b<Chatter> {
    public static final String BOT_TAG = "bot";
    private static final int FLAG_DEMISSION = 2;
    private static final long serialVersionUID = 7837580756091984831L;
    private boolean acceptSmsPhoneUrgent;
    private AccessInfo accessInfo;
    private String alias;
    private String anotherName;
    private String another_name;
    private String avatarKey;
    private AvatarMedal avatarMedal;
    private List<String> avatarUrls;
    private int botExtraType;
    private boolean canJoinGroup;
    private ChatterSensitiveInfo chatterSensitiveInfo;
    private ArrayList<String> commonLocales;
    private String creatorId;
    private List<ChatterCustomStatus> customStatus;
    private ChatterDescription description;
    private String enName;
    private String fullDepartmentName;
    private String id;
    private boolean inContacts;
    private boolean isAgent;
    private boolean isAnonymous;
    private boolean isCollaboration;
    private boolean isCrossTenant;
    private boolean isDefaultAvatar;
    private boolean isFrozen;
    private boolean isRegistered;
    private boolean isSpecialFocus;
    private String localizedName;
    private String majorLanguage;
    private BotMutedInfo mutedInfo;
    private String name;
    private String namePinyin;
    private String namePy;
    private String nameWithAnotherName;
    private String openAppId;
    private UserPrivateDescription privateDescription;
    private boolean profileEnable;
    private int status;
    private TagData tagData;
    private String tenantId;
    private List<String> thumbnails;
    private TimeZone timeZone;
    private ChatterType type;
    private long updateTime;
    private long weight;
    private String withBotTag;
    private WorkStatus workStatus;
    private long zenModeEndTime;

    public static final enum ChatterType extends Enum<ChatterType> {
        public static final ChatterType AI = null;
        public static final ChatterType BOT = null;
        public static final ChatterType DOUBAO = null;
        public static final ChatterType KNOWLEDGE_AI = null;
        public static final ChatterType UNKNOWN = null;
        public static final ChatterType USER = null;
        public static final /* synthetic */ ChatterType[] a = null;
        private final int value;

        static {
            ChatterType r0 = new ChatterType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            ChatterType r1 = new ChatterType("USER", 1, 1);
            USER = r1;
            ChatterType r3 = new ChatterType("BOT", 2, 2);
            BOT = r3;
            ChatterType r5 = new ChatterType("AI", 3, 3);
            AI = r5;
            ChatterType r7 = new ChatterType("DOUBAO", 4, 4);
            DOUBAO = r7;
            ChatterType r9 = new ChatterType("KNOWLEDGE_AI", 5, 1004);
            KNOWLEDGE_AI = r9;
            a = new ChatterType[]{r0, r1, r3, r5, r7, r9};
        }

        public static ChatterType[] values() {
            return (ChatterType[]) a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static ChatterType forNumber(int r1) {
            if (r1 == 1) goto L23;
            if (r1 == 2) goto L21;
            if (r1 == 3) goto L19;
            if (r1 == 4) goto L17;
            if (r1 == 1004) goto L15;
            return UNKNOWN;
        L15:
            return KNOWLEDGE_AI;
        L17:
            return DOUBAO;
        L19:
            return AI;
        L21:
            return BOT;
        L23:
            return USER;
        }

        public static ChatterType valueOf(String r1) {
            return (ChatterType) r27.a.a(ChatterType.class, r1);
        }

        public static ChatterType valueOf(int r0) {
            return forNumber(r0);
        }

        public ChatterType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public o5b.a getAccess() {
        AccessInfo r0 = this.accessInfo;
        if (r0 != null) goto L7;
        o5b.a.k2.getClass();
        return o5b.a.C0268a.b;
    L7:
        return r0;
    }

    public String getAvatarKey() {
        String r0 = this.avatarKey;
        if (r0 != null) goto L6;
        return BuildConfig.FLAVOR;
    L6:
        return r0;
    }

    public IChatterDesc getDesc() {
        ChatterDescription r0 = this.description;
        if (r0 != null) goto L7;
        IChatterDesc.F1.getClass();
        return IChatterDesc.a.b;
    L7:
        return r0;
    }

    public String getNamePy() {
        if (TextUtils.isEmpty(this.namePy) == false) goto L6;
        return "#";
    L6:
        return this.namePy;
    }

    public boolean isCustomer() {
        return DocTabPayload.DocType.UNKNOWN.equals(this.tenantId);
    }

    public void setDimission() {
        int r0 = this.status;
        if ((r0 & 2) != 0) goto L6;
        this.status = r0 | 2;
        return;
    }

    public boolean showAgentTag() {
        if (ChatterType.BOT == getType()) goto L5;
    L9:
        return false;
    L5:
        if (BOT_TAG.equals(this.withBotTag) == false) goto L9;
        if (this.isAgent == false) goto L9;
        return true;
    }

    public boolean showBotTag() {
        if (ChatterType.BOT == getType()) goto L5;
    L9:
        return false;
    L5:
        if (BOT_TAG.equals(this.withBotTag) == false) goto L9;
        if (this.isAgent == true) goto L9;
        return true;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("Chatter{id='");
        r0.append(this.id);
        r0.append("', name='");
        r0.append(this.name);
        r0.append("', status=");
        r0.append(this.status);
        r0.append(", type=");
        r0.append(this.type);
        r0.append(", withBotTag='");
        r0.append(this.withBotTag);
        r0.append("', boeExtType='");
        r0.append(this.botExtraType);
        r0.append("', isAgent='");
        r0.append(this.isAgent);
        r0.append("', inContacts=");
        r0.append(this.inContacts);
        r0.append(", canJoinGroup=");
        r0.append(this.canJoinGroup);
        r0.append(", profileEnable=");
        r0.append(this.profileEnable);
        r0.append(", tagData=");
        Object r1 = this.tagData;
        if (r1 != null) goto L5;
        r1 = "null";
    L5:
        r0.append(r1);
        r0.append('}');
        return r0.toString();
    }

    public Chatter() {
        this.description = new ChatterDescription();
        this.isCrossTenant = false;
        this.isCollaboration = false;
        this.isSpecialFocus = false;
        this.isDefaultAvatar = false;
        this.mutedInfo = null;
        this.tagData = null;
        this.fullDepartmentName = null;
        this.chatterSensitiveInfo = null;
        this.commonLocales = null;
    }

    @Override // com.ss.android.lark.chat.export.entity.chatter.OpenChatter
    public boolean isBot() {
        if (getType() != ChatterType.BOT) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isBotAgent() {
        return showAgentTag();
    }

    @Override // com.ss.android.lark.chat.export.entity.chatter.OpenChatter
    public boolean isDimission() {
        if (getType() != ChatterType.BOT) goto L6;
        return false;
    L6:
        if (getType() != ChatterType.AI) goto L9;
        return false;
    L9:
        if ((getStatus() & 2) != 2) goto L12;
        return true;
    L12:
        return false;
    }

    public boolean isUser() {
        if (getType() != ChatterType.USER) goto L5;
        return true;
    L5:
        return false;
    }

    public AccessInfo getAccessInfo() {
        return this.accessInfo;
    }

    public String getAlias() {
        return this.alias;
    }

    public String getAnotherName() {
        return this.anotherName;
    }

    public String getAnother_name() {
        return this.another_name;
    }

    public AvatarMedal getAvatarMedal() {
        return this.avatarMedal;
    }

    public List<String> getAvatarUrls() {
        return this.avatarUrls;
    }

    public int getBotExtraType() {
        return this.botExtraType;
    }

    public ChatterSensitiveInfo getChatterSensitiveInfo() {
        return this.chatterSensitiveInfo;
    }

    public List<String> getCommonLocales() {
        return this.commonLocales;
    }

    public List<ChatterCustomStatus> getCustomStatus() {
        return this.customStatus;
    }

    public ChatterDescription getDescription() {
        return this.description;
    }

    public String getEnName() {
        return this.enName;
    }

    public String getFullDepartmentName() {
        return this.fullDepartmentName;
    }

    public String getId() {
        return this.id;
    }

    public String getLocalizedName() {
        return this.localizedName;
    }

    public String getMajorLanguage() {
        return this.majorLanguage;
    }

    public BotMutedInfo getMutedInfo() {
        return this.mutedInfo;
    }

    public String getName() {
        return this.name;
    }

    public String getNamePinyin() {
        return this.namePinyin;
    }

    public String getNameWithAnotherName() {
        return this.nameWithAnotherName;
    }

    public String getOpenAppId() {
        return this.openAppId;
    }

    public UserPrivateDescription getPrivateDescription() {
        return this.privateDescription;
    }

    public boolean getRegistered() {
        return this.isRegistered;
    }

    public int getStatus() {
        return this.status;
    }

    public TagData getTagData() {
        return this.tagData;
    }

    public String getTenantId() {
        return this.tenantId;
    }

    public List<String> getThumbnails() {
        return this.thumbnails;
    }

    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    public ChatterType getType() {
        return this.type;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public String getWithBotTag() {
        return this.withBotTag;
    }

    public WorkStatus getWorkStatus() {
        return this.workStatus;
    }

    public long getZenModeEndTime() {
        return this.zenModeEndTime;
    }

    public boolean isAcceptSmsPhoneUrgent() {
        return this.acceptSmsPhoneUrgent;
    }

    public boolean isAgent() {
        return this.isAgent;
    }

    public boolean isAnonymous() {
        return this.isAnonymous;
    }

    public boolean isCanJoinGroup() {
        return this.canJoinGroup;
    }

    public boolean isCollaboration() {
        return this.isCollaboration;
    }

    public boolean isCrossTenant() {
        return this.isCrossTenant;
    }

    public boolean isDefaultAvatar() {
        return this.isDefaultAvatar;
    }

    public boolean isFrozen() {
        return this.isFrozen;
    }

    public boolean isInContacts() {
        return this.inContacts;
    }

    public boolean isProfileEnable() {
        return this.profileEnable;
    }

    @Override // com.ss.android.lark.chat.export.entity.chatter.OpenChatter
    public boolean isRegistered() {
        return this.isRegistered;
    }

    public boolean isSpecialFocus() {
        return this.isSpecialFocus;
    }

    public int compareTo(Object r5) {
        if ((r5 instanceof Chatter) == false) goto L24;
        String r0 = this.localizedName;
        if (TextUtils.isEmpty(this.namePy) == false) goto L7;
    L9:
        Chatter r6 = (Chatter) r5;
        String r1 = r6.getNamePy();
        if (TextUtils.isEmpty(r1) == false) goto L12;
    L13:
        r1 = r6.getLocalizedName();
    L15:
        if (TextUtils.isEmpty(r0) == false) goto L17;
        return 0;
    L17:
        if (TextUtils.isEmpty(r0) == false) goto L19;
        return 0;
    L19:
        if (r0.compareToIgnoreCase(r1) != 0) goto L23;
        return this.id.compareTo(r6.getId());
    L23:
        return r0.compareToIgnoreCase(r1);
    L12:
        if (r1.equals("#") == false) goto L15;
    L7:
        if (this.namePy.equals("#") == true) goto L9;
        r0 = this.namePy;
        goto L9
    L24:
        return 0;
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof Chatter) == true) goto L5;
        return false;
    L5:
        return getId().equals(((Chatter) r2).getId());
    }

    public boolean exactlyCompare(Chatter r3) {
        boolean r0 = equals(r3);
        if (r0 == true) goto L5;
    L8:
        return r0;
    L5:
        if (TextUtils.equals(r3.getAvatarKey(), getAvatarKey()) == true) goto L8;
        return false;
    }

    public boolean isContentSame(Chatter r7) {
        if (y28.a.a(this.name, r7.getName()) == true) goto L6;
        return false;
    L6:
        if (y28.a.a(this.localizedName, r7.localizedName) == true) goto L9;
        return false;
    L9:
        if (y28.a.a(this.alias, r7.alias) == true) goto L12;
        return false;
    L12:
        if (this.status == r7.getStatus()) goto L15;
        return false;
    L15:
        if (y28.a.a(this.avatarKey, r7.getAvatarKey()) == true) goto L18;
        return false;
    L18:
        if (this.updateTime == r7.getUpdateTime()) goto L21;
        return false;
    L21:
        if (y28.a.a(this.namePy, r7.getNamePy()) == true) goto L24;
        return false;
    L24:
        if (y28.a.a(this.description, r7.getDescription()) == true) goto L27;
        return false;
    L27:
        if (y28.a.a(this.privateDescription, r7.getPrivateDescription()) == true) goto L30;
        return false;
    L30:
        if (y28.a.a(this.enName, r7.getEnName()) == true) goto L33;
        return false;
    L33:
        if (y28.a.a(this.workStatus, r7.getWorkStatus()) == true) goto L36;
        return false;
    L36:
        if (y28.a.a(this.customStatus, r7.getCustomStatus()) == true) goto L39;
        return false;
    L39:
        if (Objects.equals(this.avatarMedal, r7.avatarMedal) == true) goto L42;
        return false;
    L42:
        if (y28.a.c(this.mutedInfo, r7.mutedInfo) == true) goto L45;
        return false;
    L45:
        if (y28.a.a(this.tagData, r7.tagData) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public /* bridge */ /* synthetic */ boolean isItemSame(y28.b r1) {
        return isItemSame((Chatter) r1);
    }

    public void setAcceptSmsPhoneUrgent(boolean r1) {
        this.acceptSmsPhoneUrgent = r1;
    }

    public void setAccessInfo(AccessInfo r1) {
        this.accessInfo = r1;
    }

    public void setAgent(boolean r1) {
        this.isAgent = r1;
    }

    public void setAlias(String r1) {
        this.alias = r1;
    }

    public void setAnonymous(boolean r1) {
        this.isAnonymous = r1;
    }

    public void setAnotherName(String r1) {
        this.anotherName = r1;
    }

    public void setAnother_name(String r1) {
        this.another_name = r1;
    }

    public void setAvatarKey(String r1) {
        this.avatarKey = r1;
    }

    public void setAvatarMedal(AvatarMedal r1) {
        this.avatarMedal = r1;
    }

    public void setAvatarUrls(List<String> r1) {
        this.avatarUrls = r1;
    }

    public void setBotExtraType(int r1) {
        this.botExtraType = r1;
    }

    public void setCanJoinGroup(boolean r1) {
        this.canJoinGroup = r1;
    }

    public void setChatterSensitiveInfo(ChatterSensitiveInfo r1) {
        this.chatterSensitiveInfo = r1;
    }

    public void setCollaboration(boolean r1) {
        this.isCollaboration = r1;
    }

    public void setCommonLocales(List<String> r2) {
        this.commonLocales = new ArrayList(r2);
    }

    public void setCreatorId(String r1) {
        this.creatorId = r1;
    }

    public void setCrossTenant(boolean r1) {
        this.isCrossTenant = r1;
    }

    public void setCustomStatus(List<ChatterCustomStatus> r1) {
        this.customStatus = r1;
    }

    public void setDefaultAvatar(boolean r1) {
        this.isDefaultAvatar = r1;
    }

    public void setDescription(ChatterDescription r1) {
        this.description = r1;
    }

    public void setEnName(String r1) {
        this.enName = r1;
    }

    public void setFrozen(boolean r1) {
        this.isFrozen = r1;
    }

    public void setFullDepartmentName(String r1) {
        this.fullDepartmentName = r1;
    }

    public void setId(String r1) {
        this.id = r1;
    }

    public void setInContacts(boolean r1) {
        this.inContacts = r1;
    }

    public void setLocalizedName(String r1) {
        this.localizedName = r1;
    }

    public void setMajorLanguage(String r1) {
        this.majorLanguage = r1;
    }

    public void setMutedInfo(BotMutedInfo r1) {
        this.mutedInfo = r1;
    }

    public void setName(String r1) {
        this.name = r1;
    }

    public void setNamePinyin(String r1) {
        this.namePinyin = r1;
    }

    public void setNamePy(String r1) {
        this.namePy = r1;
    }

    public void setNameWithAnotherName(String r1) {
        this.nameWithAnotherName = r1;
    }

    public void setOpenAppId(String r1) {
        this.openAppId = r1;
    }

    public void setPrivateDescription(UserPrivateDescription r1) {
        this.privateDescription = r1;
    }

    public void setProfileEnable(boolean r1) {
        this.profileEnable = r1;
    }

    public void setRegistered(boolean r1) {
        this.isRegistered = r1;
    }

    public void setSpecialFocus(boolean r1) {
        this.isSpecialFocus = r1;
    }

    public void setStatus(int r1) {
        this.status = r1;
    }

    public void setTagData(TagData r1) {
        this.tagData = r1;
    }

    public void setTenantId(String r1) {
        this.tenantId = r1;
    }

    public void setThumbnails(List<String> r1) {
        this.thumbnails = r1;
    }

    public void setTimeZone(TimeZone r1) {
        this.timeZone = r1;
    }

    public void setType(ChatterType r1) {
        this.type = r1;
    }

    public void setUpdateTime(long r1) {
        this.updateTime = r1;
    }

    public void setWithBotTag(String r1) {
        this.withBotTag = r1;
    }

    public void setWorkStatus(WorkStatus r1) {
        this.workStatus = r1;
    }

    public void setZenModeEndTime(long r1) {
        this.zenModeEndTime = r1;
    }

    public /* bridge */ /* synthetic */ boolean isContentSame(y28.b r1) {
        return isContentSame((Chatter) r1);
    }

    public boolean isItemSame(Chatter r1) {
        return equals(r1);
    }
}
