package com.ss.android.lark.chat.entity.chat;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Tag;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.lark.chat.entity.tag.TagData;
import com.ss.android.lark.chat.entity.translate.LanguageInfo;
import com.ss.android.lark.chat.export.entity.chat.OpenChat;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class Chat implements OpenChat, Serializable {
    private static final long serialVersionUID = -4912521595824753252L;
    private AddMemberPermission addMemberPermission;
    private AdminPostSetting adminPostSetting;
    private AtAllPermission atAllPermission;
    private Long atKnowledgeQueryCreateTime;
    private Long atKnowledgeQueryId;
    private String avatarKey;
    private BannerSetting bannerSetting;
    private boolean bannerSettingAdmin;
    private String bannerText;
    private List<ChatTeamInfo> boundTeamInfos;
    private int burnLife;
    private BuzzPermissionSetting buzzPermissionSetting;
    private boolean canBeSortedAlphabetically;
    private boolean canTranslateName;
    private ChatAnnouncement chatAnnouncement;
    private ChatDisplayModeSetting chatDisplayModeSetting;
    private ChatMode chatMode;
    private ChatOptionInfo chatOptionInfo;
    private ChatPinPermissionSetting chatPinPermissionSetting;
    private ChatTabPermissionSetting chatTabPermissionSetting;
    private ChatTnsInfo chatTnsInfo;
    private boolean chatable;
    private Map<Integer, Integer> chatterExtraStates;
    private String createTime;
    private CreateVideoConferenceSetting createVideoConferenceSetting;
    private DefaultDisplaySetting defaultDisplaySetting;
    private String description;
    private DoubaoSetting doubaoSetting;
    private int firstMessagePosition;
    private GroupMailSendPermissionType groupMailSendType;
    private boolean hasVCChatPermission;
    private boolean hasWatermark;
    private String id;
    private boolean isAIBotChat;
    private boolean isAIMainChat;
    private boolean isAccept;
    private boolean isAdmin;
    private boolean isAllowPost;
    private boolean isArchived;
    private boolean isAutoTranslate;
    private boolean isChatterReady;
    private boolean isCrossTenant;
    private boolean isCrossWithKa;
    private boolean isCustomAvatar;
    private boolean isCustomerService;
    private boolean isDeleted;
    private boolean isDissolved;
    private boolean isFake;
    private boolean isFlag;
    private boolean isFrozen;
    private boolean isGroupMailEnable;
    private boolean isInBox;
    private boolean isMeeting;
    private boolean isOcicService;
    private boolean isOfficialOncall;
    private boolean isOfflineOncall;
    private boolean isOnlyOwnerEditGroupInfo;
    private boolean isPublic;
    private boolean isRemind;
    private boolean isSecret;
    private boolean isShotCut;
    private boolean isShowApplyBanner;
    private boolean isSuper;
    private boolean isTenant;
    private boolean isUserCountVisible;
    private boolean is_department;
    private boolean is_public;
    private SystemMessageVisible joinMessageVisible;
    private String key;
    private String lastDraftId;
    private String lastMessageId;
    private int lastMessagePosition;
    private int lastMessagePositionBadgeCount;
    private String lastThreadId;
    private int lastThreadPosition;
    private int lastThreadPositionBadgeCount;
    private String lastVisibleMessageId;
    private int lastVisibleMessagePosition;
    private String lastVisibleThreadId;
    private int lastVisibleThreadPosition;
    private AddMemberApply mAddMemberApply;
    private String mAnonymousId;
    private AnonymousSetting mAnonymousSetting;
    private long mAnonymousTotalQuota;
    private ChatUserAutoMuteSetting mChatUserAutoMuteSetting;
    private boolean mIsDelayed;
    private boolean mIsMuteAtAll;
    private MessageVisibilitySetting mMessageVisibilitySetting;
    private long mThemeId;
    private int memberCount;
    private MessagePosition messagePosition;
    private String miniAvatarKey;
    private boolean muteable;
    private int myThreadsUnreadCount;
    private String name;
    private String nameMajorLanguage;
    private String namePinyin;
    private String nameTranslateLanguage;
    private String onCallId;
    private String ownerId;
    private String p2pChatterId;
    private PinPermissionSetting pinPermissionSetting;
    private String postDraftId;
    private PostType postType;
    private int putChatterApplyCount;
    private SystemMessageVisible quitMessageVisible;
    private String reEditDraftId;
    private int readPosition;
    private int readPositionBadgeCount;
    private int readThreadPosition;
    private int readThreadPositionBadgeCount;
    private float recentReadOffset;
    private int recentReadPosition;
    private RestrictedModeSetting restrictedModeSetting;
    Role role;
    private String scheduleDraftId;
    private ShareCardPermission shareCardPermission;
    private boolean shouldDisplayTranslatedName;
    private boolean showBannerTitle;
    private List<SideBarButton> sideBarButtons;
    private String sideBarId;
    private Status status;
    private TagData tagData;
    private List<Tag> tags;
    private String tenantId;
    private String textDraftId;
    private long threadLastTimeStamp;
    private long threadReadTimeStamp;
    private TopNoticePermissionSetting topNoticePermissionSetting;
    private String translatedName;
    private Type type;
    private boolean typingTranslateHasAutoOpened;
    private TypingTranslateSetting typingTranslateSetting;
    private long updateTime;
    private int userCount;
    private UserCountVisibleSetting userCountVisibleSetting;

    public static final enum AddMemberApply extends Enum<AddMemberApply> {
        public static final AddMemberApply NEED_APPLY = null;
        public static final AddMemberApply NO_APPLY = null;
        public static final AddMemberApply UNKNOWN = null;
        public static final /* synthetic */ AddMemberApply[] a = null;
        private final int value;

        static {
            AddMemberApply r0 = new AddMemberApply("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            AddMemberApply r1 = new AddMemberApply("NO_APPLY", 1, 1);
            NO_APPLY = r1;
            AddMemberApply r3 = new AddMemberApply("NEED_APPLY", 2, 2);
            NEED_APPLY = r3;
            a = new AddMemberApply[]{r0, r1, r3};
        }

        public static AddMemberApply[] values() {
            return (AddMemberApply[]) a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static AddMemberApply forNumber(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return UNKNOWN;
        L10:
            return NEED_APPLY;
        L12:
            return NO_APPLY;
        L14:
            return UNKNOWN;
        }

        public static AddMemberApply valueOf(String r1) {
            return (AddMemberApply) r27.a.a(AddMemberApply.class, r1);
        }

        public static AddMemberApply valueOf(int r0) {
            return forNumber(r0);
        }

        public AddMemberApply(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum AddMemberPermission extends Enum<AddMemberPermission> {
        public static final AddMemberPermission ALL_MEMBERS = null;
        public static final AddMemberPermission ONLY_OWNER = null;
        public static final AddMemberPermission UNKNOWN = null;
        public static final /* synthetic */ AddMemberPermission[] a = null;
        private final int value;

        static {
            AddMemberPermission r0 = new AddMemberPermission("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            AddMemberPermission r1 = new AddMemberPermission("ALL_MEMBERS", 1, 1);
            ALL_MEMBERS = r1;
            AddMemberPermission r3 = new AddMemberPermission("ONLY_OWNER", 2, 2);
            ONLY_OWNER = r3;
            a = new AddMemberPermission[]{r0, r1, r3};
        }

        public static AddMemberPermission[] values() {
            return (AddMemberPermission[]) a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static AddMemberPermission forNumber(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return UNKNOWN;
        L10:
            return ONLY_OWNER;
        L12:
            return ALL_MEMBERS;
        L14:
            return UNKNOWN;
        }

        public static AddMemberPermission valueOf(String r1) {
            return (AddMemberPermission) r27.a.a(AddMemberPermission.class, r1);
        }

        public static AddMemberPermission valueOf(int r0) {
            return forNumber(r0);
        }

        public AddMemberPermission(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum AdminPostSetting extends Enum<AdminPostSetting> {
        public static final AdminPostSetting ALLOW_POST = null;
        public static final AdminPostSetting BANNED_POST = null;
        public static final AdminPostSetting UNKNOWN = null;
        public static final /* synthetic */ AdminPostSetting[] a = null;
        private final int value;

        static {
            AdminPostSetting r0 = new AdminPostSetting("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            AdminPostSetting r1 = new AdminPostSetting("ALLOW_POST", 1, 1);
            ALLOW_POST = r1;
            AdminPostSetting r3 = new AdminPostSetting("BANNED_POST", 2, 2);
            BANNED_POST = r3;
            a = new AdminPostSetting[]{r0, r1, r3};
        }

        public static AdminPostSetting[] values() {
            return (AdminPostSetting[]) a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static AdminPostSetting forNumber(int r1) {
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L9;
            return UNKNOWN;
        L9:
            return BANNED_POST;
        L11:
            return ALLOW_POST;
        }

        public static AdminPostSetting valueOf(String r1) {
            return (AdminPostSetting) r27.a.a(AdminPostSetting.class, r1);
        }

        public static AdminPostSetting valueOf(int r0) {
            return forNumber(r0);
        }

        public AdminPostSetting(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum AnonymousSetting extends Enum<AnonymousSetting> {
        public static final AnonymousSetting ALLOWED = null;
        public static final AnonymousSetting INVISIBLE = null;
        public static final AnonymousSetting INVISIBLE_ALLOWED = null;
        public static final AnonymousSetting NOT_ALLOWED = null;
        public static final AnonymousSetting UNKNOWN = null;
        public static final /* synthetic */ AnonymousSetting[] a = null;
        private final int value;

        static {
            AnonymousSetting r0 = new AnonymousSetting("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            AnonymousSetting r1 = new AnonymousSetting("INVISIBLE", 1, 1);
            INVISIBLE = r1;
            AnonymousSetting r3 = new AnonymousSetting("NOT_ALLOWED", 2, 2);
            NOT_ALLOWED = r3;
            AnonymousSetting r5 = new AnonymousSetting("ALLOWED", 3, 3);
            ALLOWED = r5;
            AnonymousSetting r7 = new AnonymousSetting("INVISIBLE_ALLOWED", 4, 100);
            INVISIBLE_ALLOWED = r7;
            a = new AnonymousSetting[]{r0, r1, r3, r5, r7};
        }

        public static AnonymousSetting[] values() {
            return (AnonymousSetting[]) a.clone();
        }

        public String getDisplay() {
            return toString();
        }

        public int getNumber() {
            return this.value;
        }

        public static AnonymousSetting forNumber(int r5) {
            AnonymousSetting[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L9;
            AnonymousSetting r3 = r0[r2];
            if (r3.getNumber() == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L9:
            return UNKNOWN;
        }

        public static AnonymousSetting valueOf(String r1) {
            return (AnonymousSetting) r27.a.a(AnonymousSetting.class, r1);
        }

        public static AnonymousSetting valueOf(int r0) {
            return forNumber(r0);
        }

        public AnonymousSetting(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum AtAllPermission extends Enum<AtAllPermission> {
        public static final AtAllPermission ALL_MEMBERS = null;
        public static final AtAllPermission ONLY_OWNER = null;
        public static final AtAllPermission UNKNOWN = null;
        public static final /* synthetic */ AtAllPermission[] a = null;
        private final int value;

        static {
            AtAllPermission r0 = new AtAllPermission("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            AtAllPermission r1 = new AtAllPermission("ALL_MEMBERS", 1, 1);
            ALL_MEMBERS = r1;
            AtAllPermission r3 = new AtAllPermission("ONLY_OWNER", 2, 2);
            ONLY_OWNER = r3;
            a = new AtAllPermission[]{r0, r1, r3};
        }

        public static AtAllPermission[] values() {
            return (AtAllPermission[]) a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static AtAllPermission forNumber(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return UNKNOWN;
        L10:
            return ONLY_OWNER;
        L12:
            return ALL_MEMBERS;
        L14:
            return UNKNOWN;
        }

        public static AtAllPermission valueOf(String r1) {
            return (AtAllPermission) r27.a.a(AtAllPermission.class, r1);
        }

        public static AtAllPermission valueOf(int r0) {
            return forNumber(r0);
        }

        public AtAllPermission(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum BuzzPermissionSetting extends Enum<BuzzPermissionSetting> {
        public static final BuzzPermissionSetting ALL_MEMBERS = null;
        public static final BuzzPermissionSetting ONLY_MANAGER = null;
        public static final BuzzPermissionSetting UNKNOWN = null;
        public static final /* synthetic */ BuzzPermissionSetting[] a = null;
        private final int value;

        static {
            BuzzPermissionSetting r0 = new BuzzPermissionSetting("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            BuzzPermissionSetting r1 = new BuzzPermissionSetting("ALL_MEMBERS", 1, 1);
            ALL_MEMBERS = r1;
            BuzzPermissionSetting r3 = new BuzzPermissionSetting("ONLY_MANAGER", 2, 2);
            ONLY_MANAGER = r3;
            a = new BuzzPermissionSetting[]{r0, r1, r3};
        }

        public static BuzzPermissionSetting[] values() {
            return (BuzzPermissionSetting[]) a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static BuzzPermissionSetting forNumber(int r1) {
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L9;
            return UNKNOWN;
        L9:
            return ONLY_MANAGER;
        L11:
            return ALL_MEMBERS;
        }

        public static BuzzPermissionSetting valueOf(String r1) {
            return (BuzzPermissionSetting) r27.a.a(BuzzPermissionSetting.class, r1);
        }

        public static BuzzPermissionSetting valueOf(int r0) {
            return forNumber(r0);
        }

        public BuzzPermissionSetting(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum ChatMode extends Enum<ChatMode> {
        public static final ChatMode DEFAULT = null;
        public static final ChatMode THREAD = null;
        public static final ChatMode THREAD_V2 = null;
        public static final ChatMode UNKNOWN = null;
        public static final /* synthetic */ ChatMode[] a = null;
        private final int value;

        static {
            ChatMode r0 = new ChatMode("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            ChatMode r1 = new ChatMode("DEFAULT", 1, 1);
            DEFAULT = r1;
            ChatMode r3 = new ChatMode("THREAD", 2, 2);
            THREAD = r3;
            ChatMode r5 = new ChatMode("THREAD_V2", 3, 3);
            THREAD_V2 = r5;
            a = new ChatMode[]{r0, r1, r3, r5};
        }

        public static ChatMode[] values() {
            return (ChatMode[]) a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static ChatMode forNumber(int r1) {
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L13;
            if (r1 == 3) goto L11;
            return UNKNOWN;
        L11:
            return THREAD_V2;
        L13:
            return THREAD;
        L15:
            return DEFAULT;
        }

        public static ChatMode valueOf(String r1) {
            return (ChatMode) r27.a.a(ChatMode.class, r1);
        }

        public static ChatMode valueOf(int r0) {
            return forNumber(r0);
        }

        public ChatMode(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum ChatPinPermissionSetting extends Enum<ChatPinPermissionSetting> {
        public static final ChatPinPermissionSetting ALL_MEMBERS = null;
        public static final ChatPinPermissionSetting ONLY_MANAGER = null;
        public static final ChatPinPermissionSetting UNKNOWN = null;
        public static final /* synthetic */ ChatPinPermissionSetting[] a = null;
        private final int value;

        static {
            ChatPinPermissionSetting r0 = new ChatPinPermissionSetting("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            ChatPinPermissionSetting r1 = new ChatPinPermissionSetting("ALL_MEMBERS", 1, 1);
            ALL_MEMBERS = r1;
            ChatPinPermissionSetting r3 = new ChatPinPermissionSetting("ONLY_MANAGER", 2, 2);
            ONLY_MANAGER = r3;
            a = new ChatPinPermissionSetting[]{r0, r1, r3};
        }

        public static ChatPinPermissionSetting[] values() {
            return (ChatPinPermissionSetting[]) a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static ChatPinPermissionSetting forNumber(int r1) {
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L9;
            return UNKNOWN;
        L9:
            return ONLY_MANAGER;
        L11:
            return ALL_MEMBERS;
        }

        public static ChatPinPermissionSetting valueOf(String r1) {
            return (ChatPinPermissionSetting) r27.a.a(ChatPinPermissionSetting.class, r1);
        }

        public static ChatPinPermissionSetting valueOf(int r0) {
            return forNumber(r0);
        }

        public ChatPinPermissionSetting(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum ChatTabPermissionSetting extends Enum<ChatTabPermissionSetting> {
        public static final ChatTabPermissionSetting ALL_MEMBERS = null;
        public static final ChatTabPermissionSetting ONLY_MANAGER = null;
        public static final ChatTabPermissionSetting UNKNOWN = null;
        public static final /* synthetic */ ChatTabPermissionSetting[] a = null;
        private final int value;

        static {
            ChatTabPermissionSetting r0 = new ChatTabPermissionSetting("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            ChatTabPermissionSetting r1 = new ChatTabPermissionSetting("ALL_MEMBERS", 1, 1);
            ALL_MEMBERS = r1;
            ChatTabPermissionSetting r3 = new ChatTabPermissionSetting("ONLY_MANAGER", 2, 2);
            ONLY_MANAGER = r3;
            a = new ChatTabPermissionSetting[]{r0, r1, r3};
        }

        public static ChatTabPermissionSetting[] values() {
            return (ChatTabPermissionSetting[]) a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static ChatTabPermissionSetting forNumber(int r1) {
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L9;
            return UNKNOWN;
        L9:
            return ONLY_MANAGER;
        L11:
            return ALL_MEMBERS;
        }

        public static ChatTabPermissionSetting valueOf(String r1) {
            return (ChatTabPermissionSetting) r27.a.a(ChatTabPermissionSetting.class, r1);
        }

        public static ChatTabPermissionSetting valueOf(int r0) {
            return forNumber(r0);
        }

        public ChatTabPermissionSetting(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum CreateVideoConferenceSetting extends Enum<CreateVideoConferenceSetting> {
        public static final CreateVideoConferenceSetting ALL_MEMBERS = null;
        public static final CreateVideoConferenceSetting ONLY_MANAGER = null;
        public static final CreateVideoConferenceSetting UNKNOWN = null;
        public static final /* synthetic */ CreateVideoConferenceSetting[] a = null;
        private final int value;

        static {
            CreateVideoConferenceSetting r0 = new CreateVideoConferenceSetting("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            CreateVideoConferenceSetting r1 = new CreateVideoConferenceSetting("ALL_MEMBERS", 1, 1);
            ALL_MEMBERS = r1;
            CreateVideoConferenceSetting r3 = new CreateVideoConferenceSetting("ONLY_MANAGER", 2, 2);
            ONLY_MANAGER = r3;
            a = new CreateVideoConferenceSetting[]{r0, r1, r3};
        }

        public static CreateVideoConferenceSetting[] values() {
            return (CreateVideoConferenceSetting[]) a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static CreateVideoConferenceSetting forNumber(int r1) {
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L9;
            return UNKNOWN;
        L9:
            return ONLY_MANAGER;
        L11:
            return ALL_MEMBERS;
        }

        public static CreateVideoConferenceSetting valueOf(String r1) {
            return (CreateVideoConferenceSetting) r27.a.a(CreateVideoConferenceSetting.class, r1);
        }

        public static CreateVideoConferenceSetting valueOf(int r0) {
            return forNumber(r0);
        }

        public CreateVideoConferenceSetting(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum DefaultDisplaySetting extends Enum<DefaultDisplaySetting> {
        public static final DefaultDisplaySetting CHAT_MENU = null;
        public static final DefaultDisplaySetting INPUT_BOX = null;
        public static final DefaultDisplaySetting UNKNOWN = null;
        public static final /* synthetic */ DefaultDisplaySetting[] a = null;
        private final int value;

        static {
            DefaultDisplaySetting r0 = new DefaultDisplaySetting("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            DefaultDisplaySetting r1 = new DefaultDisplaySetting("INPUT_BOX", 1, 1);
            INPUT_BOX = r1;
            DefaultDisplaySetting r3 = new DefaultDisplaySetting("CHAT_MENU", 2, 2);
            CHAT_MENU = r3;
            a = new DefaultDisplaySetting[]{r0, r1, r3};
        }

        public static DefaultDisplaySetting[] values() {
            return (DefaultDisplaySetting[]) a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static DefaultDisplaySetting forNumber(int r1) {
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L9;
            return UNKNOWN;
        L9:
            return CHAT_MENU;
        L11:
            return INPUT_BOX;
        }

        public static DefaultDisplaySetting valueOf(String r1) {
            return (DefaultDisplaySetting) r27.a.a(DefaultDisplaySetting.class, r1);
        }

        public static DefaultDisplaySetting valueOf(int r0) {
            return forNumber(r0);
        }

        public DefaultDisplaySetting(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static class DoubaoSetting implements Serializable {
        private boolean doubaoProactiveReplyEnabled;
        private boolean doubaoUsingEnabled;

        public DoubaoSetting() {
            this.doubaoUsingEnabled = true;
            this.doubaoProactiveReplyEnabled = false;
        }

        public boolean isDoubaoProactiveReplyEnabled() {
            return this.doubaoProactiveReplyEnabled;
        }

        public boolean isDoubaoUsingEnabled() {
            return this.doubaoUsingEnabled;
        }

        public static DoubaoSetting from(com.bytedance.lark.pb.basic.v1.Chat.DoubaoSetting r2) {
            DoubaoSetting r0 = new DoubaoSetting();
            if (r2 == null) goto L5;
            r0.doubaoUsingEnabled = r2.doubao_using_enabled.booleanValue();
            r0.doubaoProactiveReplyEnabled = r2.doubao_proactive_reply_enabled.booleanValue();
        L5:
            return r0;
        }

        public void setDoubaoProactiveReplyEnabled(boolean r1) {
            this.doubaoProactiveReplyEnabled = r1;
        }

        public void setDoubaoUsingEnabled(boolean r1) {
            this.doubaoUsingEnabled = r1;
        }
    }

    public static final enum GroupMailSendPermissionType extends Enum<GroupMailSendPermissionType> {
        public static final GroupMailSendPermissionType ANYONE = null;
        public static final GroupMailSendPermissionType ONLY_ADMIN = null;
        public static final GroupMailSendPermissionType ONLY_MEMBER = null;
        public static final GroupMailSendPermissionType ONLY_TENANT = null;
        public static final GroupMailSendPermissionType UNKNOWN = null;
        public static final /* synthetic */ GroupMailSendPermissionType[] a = null;
        private final int value;

        static {
            GroupMailSendPermissionType r0 = new GroupMailSendPermissionType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            GroupMailSendPermissionType r1 = new GroupMailSendPermissionType("ONLY_ADMIN", 1, 1);
            ONLY_ADMIN = r1;
            GroupMailSendPermissionType r3 = new GroupMailSendPermissionType("ONLY_MEMBER", 2, 2);
            ONLY_MEMBER = r3;
            GroupMailSendPermissionType r5 = new GroupMailSendPermissionType("ONLY_TENANT", 3, 3);
            ONLY_TENANT = r5;
            GroupMailSendPermissionType r7 = new GroupMailSendPermissionType("ANYONE", 4, 4);
            ANYONE = r7;
            a = new GroupMailSendPermissionType[]{r0, r1, r3, r5, r7};
        }

        public static GroupMailSendPermissionType[] values() {
            return (GroupMailSendPermissionType[]) a.clone();
        }

        public String getDisplay() {
            int r0 = getNumber();
            if (r0 != 1) goto L5;
            return "AdminOnly";
        L5:
            if (r0 != 2) goto L7;
            return "GroupMember";
        L7:
            if (r0 != 3) goto L9;
            return "Tenant";
        L9:
            if (r0 == 4) goto L12;
            return "UNKNOWN";
        L12:
            return "All";
        }

        public int getNumber() {
            return this.value;
        }

        public static GroupMailSendPermissionType forNumber(int r1) {
            if (r1 == 1) goto L19;
            if (r1 == 2) goto L17;
            if (r1 == 3) goto L15;
            if (r1 == 4) goto L13;
            return UNKNOWN;
        L13:
            return ANYONE;
        L15:
            return ONLY_TENANT;
        L17:
            return ONLY_MEMBER;
        L19:
            return ONLY_ADMIN;
        }

        public static GroupMailSendPermissionType valueOf(String r1) {
            return (GroupMailSendPermissionType) r27.a.a(GroupMailSendPermissionType.class, r1);
        }

        public static GroupMailSendPermissionType valueOf(int r0) {
            return forNumber(r0);
        }

        public GroupMailSendPermissionType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum MessagePosition extends Enum<MessagePosition> {
        public static final MessagePosition NEWEST_UNREAD = null;
        public static final MessagePosition RECENT_LEFT = null;
        public static final MessagePosition UNKNOWN = null;
        public static final /* synthetic */ MessagePosition[] a = null;
        private final int value;

        static {
            MessagePosition r0 = new MessagePosition("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            MessagePosition r1 = new MessagePosition("RECENT_LEFT", 1, 1);
            RECENT_LEFT = r1;
            MessagePosition r3 = new MessagePosition("NEWEST_UNREAD", 2, 2);
            NEWEST_UNREAD = r3;
            a = new MessagePosition[]{r0, r1, r3};
        }

        public static MessagePosition[] values() {
            return (MessagePosition[]) a.clone();
        }

        public String desc() {
            int r0 = this.value;
            if (r0 != 1) goto L5;
            return "RECENT_LEFT";
        L5:
            if (r0 == 2) goto L8;
            return "UNKNOWN";
        L8:
            return "NEWEST_UNREAD";
        }

        public int getNumber() {
            return this.value;
        }

        public static MessagePosition forNumber(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return UNKNOWN;
        L10:
            return NEWEST_UNREAD;
        L12:
            return RECENT_LEFT;
        L14:
            return UNKNOWN;
        }

        public static MessagePosition valueOf(String r1) {
            return (MessagePosition) r27.a.a(MessagePosition.class, r1);
        }

        public static MessagePosition valueOf(int r0) {
            return forNumber(r0);
        }

        public MessagePosition(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum MessageVisibilitySetting extends Enum<MessageVisibilitySetting> {
        public static final MessageVisibilitySetting ALL_MESSAGES = null;
        public static final MessageVisibilitySetting ONLY_NEW_MESSAGES = null;
        public static final MessageVisibilitySetting UNKNOWN = null;
        public static final /* synthetic */ MessageVisibilitySetting[] a = null;
        private final int value;

        static {
            MessageVisibilitySetting r0 = new MessageVisibilitySetting("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            MessageVisibilitySetting r1 = new MessageVisibilitySetting("ALL_MESSAGES", 1, 1);
            ALL_MESSAGES = r1;
            MessageVisibilitySetting r3 = new MessageVisibilitySetting("ONLY_NEW_MESSAGES", 2, 2);
            ONLY_NEW_MESSAGES = r3;
            a = new MessageVisibilitySetting[]{r0, r1, r3};
        }

        public static MessageVisibilitySetting[] values() {
            return (MessageVisibilitySetting[]) a.clone();
        }

        public static MessageVisibilitySetting forNumber(int r1) {
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L9;
            return UNKNOWN;
        L9:
            return ONLY_NEW_MESSAGES;
        L11:
            return ALL_MESSAGES;
        }

        public static MessageVisibilitySetting valueOf(String r1) {
            return (MessageVisibilitySetting) r27.a.a(MessageVisibilitySetting.class, r1);
        }

        public static MessageVisibilitySetting valueOf(int r0) {
            return forNumber(r0);
        }

        public MessageVisibilitySetting(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum PinPermissionSetting extends Enum<PinPermissionSetting> {
        public static final PinPermissionSetting ALL_MEMBERS = null;
        public static final PinPermissionSetting ONLY_MANAGER = null;
        public static final PinPermissionSetting UNKNOWN = null;
        public static final /* synthetic */ PinPermissionSetting[] a = null;
        private final int value;

        static {
            PinPermissionSetting r0 = new PinPermissionSetting("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            PinPermissionSetting r1 = new PinPermissionSetting("ALL_MEMBERS", 1, 1);
            ALL_MEMBERS = r1;
            PinPermissionSetting r3 = new PinPermissionSetting("ONLY_MANAGER", 2, 2);
            ONLY_MANAGER = r3;
            a = new PinPermissionSetting[]{r0, r1, r3};
        }

        public static PinPermissionSetting[] values() {
            return (PinPermissionSetting[]) a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static PinPermissionSetting forNumber(int r1) {
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L9;
            return UNKNOWN;
        L9:
            return ONLY_MANAGER;
        L11:
            return ALL_MEMBERS;
        }

        public static PinPermissionSetting valueOf(String r1) {
            return (PinPermissionSetting) r27.a.a(PinPermissionSetting.class, r1);
        }

        public static PinPermissionSetting valueOf(int r0) {
            return forNumber(r0);
        }

        public PinPermissionSetting(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum PostType extends Enum<PostType> {
        public static final PostType ANYONE = null;
        public static final PostType ONLY_ADMIN = null;
        public static final PostType UNKNOWN_POST_TYPE = null;
        public static final PostType WHITE_LIST = null;
        public static final /* synthetic */ PostType[] a = null;
        private final int value;

        static {
            PostType r0 = new PostType("UNKNOWN_POST_TYPE", 0, 0);
            UNKNOWN_POST_TYPE = r0;
            PostType r1 = new PostType("ANYONE", 1, 1);
            ANYONE = r1;
            PostType r3 = new PostType("ONLY_ADMIN", 2, 2);
            ONLY_ADMIN = r3;
            PostType r5 = new PostType("WHITE_LIST", 3, 3);
            WHITE_LIST = r5;
            a = new PostType[]{r0, r1, r3, r5};
        }

        public static PostType[] values() {
            return (PostType[]) a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static PostType forNumber(int r1) {
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L13;
            if (r1 == 3) goto L11;
            return UNKNOWN_POST_TYPE;
        L11:
            return WHITE_LIST;
        L13:
            return ONLY_ADMIN;
        L15:
            return ANYONE;
        }

        public static PostType valueOf(String r1) {
            return (PostType) r27.a.a(PostType.class, r1);
        }

        public static PostType valueOf(int r0) {
            return forNumber(r0);
        }

        public PostType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static class RestrictedModeSetting implements Serializable {
        private Participant copy;
        private Participant download;
        private Participant forward;
        private OnTimeDelMsgSetting onTimeDelMsgSetting;
        private Participant screenshot;
        private boolean switch_;
        private RestrictedWhiteListSetting whiteListSetting;

        public static class OnTimeDelMsgSetting implements Serializable {
            private long aliveTime;
            private boolean status;

            public OnTimeDelMsgSetting() {
            }

            public long getAliveTime() {
                return this.aliveTime;
            }

            public boolean getStatus() {
                return this.status;
            }

            public void setAliveTime(long r1) {
                this.aliveTime = r1;
            }

            public void setStatus(boolean r1) {
                this.status = r1;
            }
        }

        public static final enum Participant extends Enum<Participant> {
            public static final Participant ALL_MEMBERS = null;
            public static final Participant NO_MEMBER = null;
            public static final Participant UNKNOWN = null;
            public static final /* synthetic */ Participant[] a = null;
            private final int value;

            static {
                Participant r0 = new Participant("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Participant r1 = new Participant("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r1;
                Participant r3 = new Participant("NO_MEMBER", 2, 2);
                NO_MEMBER = r3;
                a = new Participant[]{r0, r1, r3};
            }

            public static Participant[] values() {
                return (Participant[]) a.clone();
            }

            public int getNumber() {
                return this.value;
            }

            public static Participant forNumber(int r1) {
                if (r1 == 1) goto L11;
                if (r1 == 2) goto L9;
                return UNKNOWN;
            L9:
                return NO_MEMBER;
            L11:
                return ALL_MEMBERS;
            }

            public static Participant valueOf(String r1) {
                return (Participant) r27.a.a(Participant.class, r1);
            }

            public static Participant valueOf(int r0) {
                return forNumber(r0);
            }

            public Participant(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public RestrictedModeSetting() {
            this.switch_ = false;
            Participant r0 = Participant.NO_MEMBER;
            this.copy = r0;
            this.forward = r0;
            this.download = r0;
            this.screenshot = r0;
        }

        public Participant getCopy() {
            return this.copy;
        }

        public Participant getDownload() {
            return this.download;
        }

        public Participant getForward() {
            return this.forward;
        }

        public OnTimeDelMsgSetting getOnTimeDelMsgSetting() {
            return this.onTimeDelMsgSetting;
        }

        public Participant getScreenshot() {
            return this.screenshot;
        }

        public boolean getSwitch() {
            return this.switch_;
        }

        public RestrictedWhiteListSetting getWhiteListSetting() {
            return this.whiteListSetting;
        }

        public void setCopy(Participant r1) {
            this.copy = r1;
        }

        public void setDownload(Participant r1) {
            this.download = r1;
        }

        public void setForward(Participant r1) {
            this.forward = r1;
        }

        public void setOnTimeDelMsgSetting(OnTimeDelMsgSetting r1) {
            this.onTimeDelMsgSetting = r1;
        }

        public void setScreenshot(Participant r1) {
            this.screenshot = r1;
        }

        public void setSwitch(boolean r1) {
            this.switch_ = r1;
        }

        public void setWhiteListSetting(RestrictedWhiteListSetting r1) {
            this.whiteListSetting = r1;
        }
    }

    public static class RestrictedWhiteListSetting implements Serializable {
        private boolean hitWhiteList;
        private LevelEnum level;
        private LinkedList<Long> memberListUserIds;

        public static final enum LevelEnum extends Enum<LevelEnum> {
            public static final LevelEnum MEMBER_LIST = null;
            public static final LevelEnum NO_MEMBER = null;
            public static final LevelEnum ONLY_ADMIN_AND_OWNER = null;
            public static final LevelEnum UNKNOWN = null;
            public static final /* synthetic */ LevelEnum[] a = null;
            private final int value;

            static {
                LevelEnum r0 = new LevelEnum("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                LevelEnum r1 = new LevelEnum("NO_MEMBER", 1, 1);
                NO_MEMBER = r1;
                LevelEnum r3 = new LevelEnum("ONLY_ADMIN_AND_OWNER", 2, 2);
                ONLY_ADMIN_AND_OWNER = r3;
                LevelEnum r5 = new LevelEnum("MEMBER_LIST", 3, 3);
                MEMBER_LIST = r5;
                a = new LevelEnum[]{r0, r1, r3, r5};
            }

            public static LevelEnum[] values() {
                return (LevelEnum[]) a.clone();
            }

            public int getNumber() {
                return this.value;
            }

            public static LevelEnum forNumber(int r1) {
                if (r1 == 1) goto L15;
                if (r1 == 2) goto L13;
                if (r1 == 3) goto L11;
                return UNKNOWN;
            L11:
                return MEMBER_LIST;
            L13:
                return ONLY_ADMIN_AND_OWNER;
            L15:
                return NO_MEMBER;
            }

            public static LevelEnum valueOf(String r1) {
                return (LevelEnum) r27.a.a(LevelEnum.class, r1);
            }

            public static LevelEnum valueOf(int r0) {
                return forNumber(r0);
            }

            public LevelEnum(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public RestrictedWhiteListSetting() {
            this.level = LevelEnum.UNKNOWN;
        }

        public LevelEnum getLevel() {
            return this.level;
        }

        public LinkedList<Long> getMemberListUserIds() {
            return this.memberListUserIds;
        }

        public boolean isHitWhiteList() {
            return this.hitWhiteList;
        }

        public void setHitWhiteList(boolean r1) {
            this.hitWhiteList = r1;
        }

        public void setLevel(LevelEnum r1) {
            this.level = r1;
        }

        public void setMemberListUserIds(LinkedList<Long> r1) {
            this.memberListUserIds = r1;
        }
    }

    public static final enum Role extends Enum<Role> {
        public static final Role IGNORE = null;
        public static final Role MEMBER = null;
        public static final Role THREAD_FOLLOWER = null;
        public static final Role VISITOR = null;
        public static final /* synthetic */ Role[] a = null;
        private final int value;

        static {
            Role r0 = new Role("IGNORE", 0, 0);
            IGNORE = r0;
            Role r1 = new Role("MEMBER", 1, 1);
            MEMBER = r1;
            Role r3 = new Role("VISITOR", 2, 2);
            VISITOR = r3;
            Role r5 = new Role("THREAD_FOLLOWER", 3, 3);
            THREAD_FOLLOWER = r5;
            a = new Role[]{r0, r1, r3, r5};
        }

        public static Role[] values() {
            return (Role[]) a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static Role forNumber(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            return IGNORE;
        L12:
            return THREAD_FOLLOWER;
        L14:
            return VISITOR;
        L16:
            return MEMBER;
        L18:
            return IGNORE;
        }

        public static Role valueOf(String r1) {
            return (Role) r27.a.a(Role.class, r1);
        }

        public static Role valueOf(int r0) {
            return forNumber(r0);
        }

        public Role(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum ShareCardPermission extends Enum<ShareCardPermission> {
        public static final ShareCardPermission ALLOWED = null;
        public static final ShareCardPermission NOT_ALLOWED = null;
        public static final ShareCardPermission UNKNOWN = null;
        public static final /* synthetic */ ShareCardPermission[] a = null;
        private final int value;

        static {
            ShareCardPermission r0 = new ShareCardPermission("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            ShareCardPermission r1 = new ShareCardPermission("ALLOWED", 1, 1);
            ALLOWED = r1;
            ShareCardPermission r3 = new ShareCardPermission("NOT_ALLOWED", 2, 2);
            NOT_ALLOWED = r3;
            a = new ShareCardPermission[]{r0, r1, r3};
        }

        public static ShareCardPermission[] values() {
            return (ShareCardPermission[]) a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static ShareCardPermission forNumber(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return UNKNOWN;
        L10:
            return NOT_ALLOWED;
        L12:
            return ALLOWED;
        L14:
            return UNKNOWN;
        }

        public static ShareCardPermission valueOf(String r1) {
            return (ShareCardPermission) r27.a.a(ShareCardPermission.class, r1);
        }

        public static ShareCardPermission valueOf(int r0) {
            return forNumber(r0);
        }

        public ShareCardPermission(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum Status extends Enum<Status> {
        public static final Status ARCHIVE = null;
        public static final Status DELETED = null;
        public static final Status NORMAL = null;
        public static final /* synthetic */ Status[] a = null;
        private final int value;

        static {
            Status r0 = new Status("NORMAL", 0, 0);
            NORMAL = r0;
            Status r1 = new Status("ARCHIVE", 1, 1);
            ARCHIVE = r1;
            Status r3 = new Status("DELETED", 2, 2);
            DELETED = r3;
            a = new Status[]{r0, r1, r3};
        }

        public static Status[] values() {
            return (Status[]) a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static Status forNumber(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return NORMAL;
        L10:
            return DELETED;
        L12:
            return ARCHIVE;
        L14:
            return NORMAL;
        }

        public static Status valueOf(String r1) {
            return (Status) r27.a.a(Status.class, r1);
        }

        public static Status valueOf(int r0) {
            return forNumber(r0);
        }

        public Status(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum SystemMessageVisible extends Enum<SystemMessageVisible> {
        public static final SystemMessageVisible ALL_MEMBERS = null;
        public static final SystemMessageVisible NOT_ANYONE = null;
        public static final SystemMessageVisible ONLY_OWNER = null;
        public static final SystemMessageVisible UNKNOWN = null;
        public static final /* synthetic */ SystemMessageVisible[] a = null;
        private final int value;

        static {
            SystemMessageVisible r0 = new SystemMessageVisible("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            SystemMessageVisible r1 = new SystemMessageVisible("ONLY_OWNER", 1, 1);
            ONLY_OWNER = r1;
            SystemMessageVisible r3 = new SystemMessageVisible("ALL_MEMBERS", 2, 2);
            ALL_MEMBERS = r3;
            SystemMessageVisible r5 = new SystemMessageVisible("NOT_ANYONE", 3, 3);
            NOT_ANYONE = r5;
            a = new SystemMessageVisible[]{r0, r1, r3, r5};
        }

        public static SystemMessageVisible[] values() {
            return (SystemMessageVisible[]) a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static SystemMessageVisible forNumber(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            return UNKNOWN;
        L12:
            return NOT_ANYONE;
        L14:
            return ALL_MEMBERS;
        L16:
            return ONLY_OWNER;
        L18:
            return UNKNOWN;
        }

        public static SystemMessageVisible valueOf(String r1) {
            return (SystemMessageVisible) r27.a.a(SystemMessageVisible.class, r1);
        }

        public static SystemMessageVisible valueOf(int r0) {
            return forNumber(r0);
        }

        public SystemMessageVisible(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum TopNoticePermissionSetting extends Enum<TopNoticePermissionSetting> {
        public static final TopNoticePermissionSetting ALL_MEMBER = null;
        public static final TopNoticePermissionSetting ONLY_MANAGER = null;
        public static final TopNoticePermissionSetting UNKNOWN = null;
        public static final /* synthetic */ TopNoticePermissionSetting[] a = null;
        private final int value;

        static {
            TopNoticePermissionSetting r0 = new TopNoticePermissionSetting("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            TopNoticePermissionSetting r1 = new TopNoticePermissionSetting("ALL_MEMBER", 1, 1);
            ALL_MEMBER = r1;
            TopNoticePermissionSetting r3 = new TopNoticePermissionSetting("ONLY_MANAGER", 2, 2);
            ONLY_MANAGER = r3;
            a = new TopNoticePermissionSetting[]{r0, r1, r3};
        }

        public static TopNoticePermissionSetting[] values() {
            return (TopNoticePermissionSetting[]) a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static TopNoticePermissionSetting fromValue(int r5) {
            TopNoticePermissionSetting[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L9;
            TopNoticePermissionSetting r3 = r0[r2];
            if (r3.value == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L9:
            return UNKNOWN;
        }

        public static TopNoticePermissionSetting valueOf(String r1) {
            return (TopNoticePermissionSetting) r27.a.a(TopNoticePermissionSetting.class, r1);
        }

        public TopNoticePermissionSetting(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum Type extends Enum<Type> {
        public static final Type GROUP = null;
        public static final Type P2P = null;
        public static final Type THREAD_DETAIL = null;
        public static final Type TOPIC_GROUP = null;
        public static final Type UNKNOWN = null;
        public static final /* synthetic */ Type[] a = null;
        private final int value;

        static {
            Type r0 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Type r1 = new Type("P2P", 1, 1);
            P2P = r1;
            Type r3 = new Type("GROUP", 2, 2);
            GROUP = r3;
            Type r5 = new Type("TOPIC_GROUP", 3, 3);
            TOPIC_GROUP = r5;
            Type r7 = new Type("THREAD_DETAIL", 4, 4);
            THREAD_DETAIL = r7;
            a = new Type[]{r0, r1, r3, r5, r7};
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static Type forNumber(int r1) {
            if (r1 == 1) goto L19;
            if (r1 == 2) goto L17;
            if (r1 == 3) goto L15;
            if (r1 == 4) goto L13;
            return UNKNOWN;
        L13:
            return THREAD_DETAIL;
        L15:
            return TOPIC_GROUP;
        L17:
            return GROUP;
        L19:
            return P2P;
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public static Type valueOf(int r0) {
            return forNumber(r0);
        }

        public Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static class TypingTranslateSetting implements Serializable {
        private boolean canAutoOpenV3;
        private boolean isOpen;
        private LanguageInfo languageInfo;
        private com.bytedance.lark.pb.basic.v1.Chat.TypingTranslateSetting.OpenMode openMode;
        private boolean translateWithOrigin;
        private long updateTime;

        public int hashCode() {
            return Objects.hash(new Object[]{Boolean.valueOf(this.isOpen), this.languageInfo, Boolean.valueOf(this.translateWithOrigin), Boolean.valueOf(this.canAutoOpenV3), this.openMode});
        }

        public TypingTranslateSetting() {
            this.canAutoOpenV3 = false;
            this.openMode = com.bytedance.lark.pb.basic.v1.Chat.TypingTranslateSetting.OpenMode.MANUAL;
        }

        public boolean getIsOpen() {
            return this.isOpen;
        }

        public LanguageInfo getLanguageInfo() {
            return this.languageInfo;
        }

        public com.bytedance.lark.pb.basic.v1.Chat.TypingTranslateSetting.OpenMode getOpenMode() {
            return this.openMode;
        }

        public long getUpdateTime() {
            return this.updateTime;
        }

        public boolean isCanAutoOpenV3() {
            return this.canAutoOpenV3;
        }

        public boolean isTranslateWithOrigin() {
            return this.translateWithOrigin;
        }

        public static TypingTranslateSetting from(com.bytedance.lark.pb.basic.v1.Chat.TypingTranslateSetting r3) {
            TypingTranslateSetting r0 = new TypingTranslateSetting();
            if (r3 != null) goto L5;
            return r0;
        L5:
            r0.isOpen = r3.is_open.booleanValue();
            String r2 = r3.target_language;
            r0.languageInfo = new LanguageInfo(r2, r2);
            r0.translateWithOrigin = r3.enable_use_translated_original.booleanValue();
            r0.updateTime = r3.update_time_ns.longValue();
            r0.canAutoOpenV3 = r3.can_auto_open_v3.booleanValue();
            r0.openMode = r3.open_mode;
            return r0;
        }

        public boolean equals(Object r8) {
            if ((r8 instanceof TypingTranslateSetting) == true) goto L5;
            return false;
        L5:
            TypingTranslateSetting r9 = (TypingTranslateSetting) r8;
            if (this.isOpen != r9.isOpen) goto L8;
            boolean r0 = true;
        L10:
            if (this.translateWithOrigin != r9.translateWithOrigin) goto L12;
            boolean r2 = true;
        L14:
            if (this.canAutoOpenV3 != r9.canAutoOpenV3) goto L16;
            boolean r4 = true;
        L18:
            if (this.openMode != r9.openMode) goto L20;
            boolean r5 = true;
        L21:
            LanguageInfo r6 = this.languageInfo;
            LanguageInfo r10 = r9.languageInfo;
            if (r6 != null) goto L25;
            if (r10 != null) goto L25;
            return r0;
        L25:
            if (r2 == false) goto L35;
            if (r0 == false) goto L36;
            if (r4 == false) goto L37;
            if (r5 == false) goto L38;
            if (r6 == null) goto L39;
            if (r10 != null) goto L32;
            return false;
        L32:
            if (Objects.equals(r6.getKey(), r10.getKey()) == false) goto L41;
            return true;
        L41:
            return false;
        L39:
            return false;
        L38:
            return false;
        L37:
            return false;
        L36:
            return false;
        L35:
            return false;
        L20:
            r5 = false;
            goto L21
        L16:
            r4 = false;
            goto L18
        L12:
            r2 = false;
            goto L14
        L8:
            r0 = false;
            goto L10
        }

        public void setCanAutoOpenV3(boolean r1) {
            this.canAutoOpenV3 = r1;
        }

        public void setIsOpen(boolean r1) {
            this.isOpen = r1;
        }

        public void setLanguageInfo(LanguageInfo r1) {
            this.languageInfo = r1;
        }

        public void setOpenMode(com.bytedance.lark.pb.basic.v1.Chat.TypingTranslateSetting.OpenMode r1) {
            this.openMode = r1;
        }

        public void setTranslateWithOrigin(boolean r1) {
            this.translateWithOrigin = r1;
        }

        public void setUpdateTime(long r1) {
            this.updateTime = r1;
        }
    }

    public static final enum UserCountVisibleSetting extends Enum<UserCountVisibleSetting> implements Serializable {
        public static final UserCountVisibleSetting ALL_MEMBERS = null;
        public static final UserCountVisibleSetting ONLY_MANAGER = null;
        public static final UserCountVisibleSetting UNKNOWN = null;
        public static final /* synthetic */ UserCountVisibleSetting[] a = null;
        private final int value;

        static {
            UserCountVisibleSetting r0 = new UserCountVisibleSetting("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            UserCountVisibleSetting r1 = new UserCountVisibleSetting("ALL_MEMBERS", 1, 1);
            ALL_MEMBERS = r1;
            UserCountVisibleSetting r3 = new UserCountVisibleSetting("ONLY_MANAGER", 2, 2);
            ONLY_MANAGER = r3;
            a = new UserCountVisibleSetting[]{r0, r1, r3};
        }

        public static UserCountVisibleSetting[] values() {
            return (UserCountVisibleSetting[]) a.clone();
        }

        public String toDescString() {
            int r0 = this.value;
            if (r0 != 1) goto L5;
            return "ALL_MEMBERS";
        L5:
            if (r0 == 2) goto L8;
            return "UNKNOWN";
        L8:
            return "ONLY_MANAGER";
        }

        public int getNumber() {
            return this.value;
        }

        public static UserCountVisibleSetting forNumber(int r1) {
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L9;
            return UNKNOWN;
        L9:
            return ONLY_MANAGER;
        L11:
            return ALL_MEMBERS;
        }

        public static UserCountVisibleSetting valueOf(String r1) {
            return (UserCountVisibleSetting) r27.a.a(UserCountVisibleSetting.class, r1);
        }

        public static UserCountVisibleSetting valueOf(int r0) {
            return forNumber(r0);
        }

        public UserCountVisibleSetting(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public boolean canSeeHistoryMessage() {
        if (this.mMessageVisibilitySetting != MessageVisibilitySetting.ALL_MESSAGES) goto L5;
        return true;
    L5:
        return false;
    }

    public String getEntityId() {
        if (this.type != Type.P2P) goto L7;
        return getP2pChatterId();
    L7:
        return getId();
    }

    public int getNewMessageCount() {
        return this.lastMessagePosition - this.readPosition;
    }

    @Override // com.ss.android.lark.chat.export.entity.chat.OpenChat
    public String getP2pChatterId() {
        String r0 = this.p2pChatterId;
        if (r0 != null) goto L7;
        return BuildConfig.FLAVOR;
    L7:
        return r0;
    }

    public int getThreadUnReadBadgeCount() {
        return Math.min(this.lastThreadPositionBadgeCount - this.readThreadPositionBadgeCount, this.lastThreadPosition - this.readThreadPosition);
    }

    public int getUnReadBadgeCount() {
        return Math.min(this.lastMessagePositionBadgeCount - this.readPositionBadgeCount, this.lastMessagePosition - this.readPosition);
    }

    public int getUnReadMessageCount() {
        return this.lastMessagePosition - this.readPosition;
    }

    public boolean isAnonymousSecret() {
        if (this.isSecret == false) goto L9;
        AnonymousSetting r0 = this.mAnonymousSetting;
        if (r0 != AnonymousSetting.ALLOWED) goto L7;
    L8:
        return true;
    L7:
        if (r0 == AnonymousSetting.INVISIBLE_ALLOWED) goto L8;
    L9:
        return false;
    }

    public boolean isDeleted() {
        if (this.status != Status.DELETED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.lark.chat.export.entity.chat.OpenChat
    public boolean isGroup() {
        if (this.type != Type.GROUP) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.lark.chat.export.entity.chat.OpenChat
    public boolean isMember() {
        if (this.role != Role.MEMBER) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.lark.chat.export.entity.chat.OpenChat
    public boolean isOnCall() {
        if (TextUtils.isEmpty(this.onCallId) == false) goto L5;
    L7:
        return false;
    L5:
        if (CastLongProtector.parseLong(this.onCallId) == 0) goto L7;
        return true;
    }

    @Override // com.ss.android.lark.chat.export.entity.chat.OpenChat
    public boolean isOnlyManagerCreateVC() {
        if (this.createVideoConferenceSetting != CreateVideoConferenceSetting.ONLY_MANAGER) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isThread() {
        ChatMode r0 = this.chatMode;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0 != ChatMode.THREAD_V2) goto L7;
        return true;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("Chat{id='");
        r0.append(this.id);
        r0.append("', isSecret=");
        r0.append(this.isSecret);
        r0.append(", uCount=");
        r0.append(this.userCount);
        r0.append(", isUserCountVisible=");
        r0.append(this.isUserCountVisible);
        r0.append(", lastMsgId=");
        r0.append(this.lastMessageId);
        r0.append(", lastMsgPos=");
        r0.append(this.lastMessagePosition);
        r0.append(", lastMsgPosBgCount=");
        r0.append(this.lastMessagePositionBadgeCount);
        r0.append(", readPos=");
        r0.append(this.readPosition);
        r0.append(", readPosBgCount=");
        r0.append(this.readPositionBadgeCount);
        r0.append(", rTPos=");
        r0.append(this.readThreadPosition);
        r0.append(", lTPos=");
        r0.append(this.lastThreadPosition);
        r0.append(", rTBadge=");
        r0.append(this.readThreadPositionBadgeCount);
        r0.append(", lTBadge=");
        r0.append(this.lastThreadPositionBadgeCount);
        r0.append(", lTVisiblePos=");
        r0.append(this.lastVisibleThreadPosition);
        r0.append(", recentReadPos=");
        r0.append(this.recentReadPosition);
        r0.append(", isFlag=");
        r0.append(this.isFlag);
        r0.append(", tagData=");
        Object r1 = this.tagData;
        if (r1 != null) goto L5;
        r1 = "null";
    L5:
        r0.append(r1);
        r0.append(",hasVCChatPermission=");
        r0.append(this.hasVCChatPermission);
        r0.append(",isAIMainChat=");
        r0.append(this.isAIMainChat);
        r0.append(",isAIBotChat=");
        r0.append(this.isAIBotChat);
        r0.append('}');
        return r0.toString();
    }

    public Chat() {
        this.role = Role.IGNORE;
        this.firstMessagePosition = -1;
        this.messagePosition = MessagePosition.RECENT_LEFT;
        this.atAllPermission = AtAllPermission.ALL_MEMBERS;
        this.addMemberPermission = AddMemberPermission.ALL_MEMBERS;
        SystemMessageVisible r0 = SystemMessageVisible.ONLY_OWNER;
        this.joinMessageVisible = r0;
        this.quitMessageVisible = r0;
        this.shareCardPermission = ShareCardPermission.ALLOWED;
        this.burnLife = 30;
        this.isAllowPost = true;
        this.postType = PostType.ANYONE;
        this.isGroupMailEnable = false;
        this.groupMailSendType = GroupMailSendPermissionType.UNKNOWN;
        this.mAnonymousSetting = AnonymousSetting.INVISIBLE;
        this.topNoticePermissionSetting = TopNoticePermissionSetting.UNKNOWN;
        this.buzzPermissionSetting = BuzzPermissionSetting.ALL_MEMBERS;
        this.createVideoConferenceSetting = CreateVideoConferenceSetting.ALL_MEMBERS;
        this.pinPermissionSetting = PinPermissionSetting.ALL_MEMBERS;
        this.typingTranslateSetting = new TypingTranslateSetting();
        this.chatTabPermissionSetting = ChatTabPermissionSetting.ALL_MEMBERS;
        this.chatPinPermissionSetting = ChatPinPermissionSetting.ALL_MEMBERS;
        this.restrictedModeSetting = new RestrictedModeSetting();
        this.adminPostSetting = AdminPostSetting.ALLOW_POST;
        this.defaultDisplaySetting = DefaultDisplaySetting.INPUT_BOX;
        this.chatDisplayModeSetting = ChatDisplayModeSetting.UNKNOWN;
        this.userCountVisibleSetting = UserCountVisibleSetting.ALL_MEMBERS;
        this.doubaoSetting = new DoubaoSetting();
        this.isUserCountVisible = true;
        this.chatterExtraStates = new HashMap();
        this.mIsMuteAtAll = false;
        this.mIsDelayed = false;
        this.tagData = null;
    }

    public int getFirstUnReadMessageBadgeCount() {
        return getReadPositionBadgeCount() + 1;
    }

    @Override // com.ss.android.lark.chat.export.entity.chat.OpenChat
    public String getGroupOwnerId() {
        if (isP2PChat() == false) goto L6;
        return BuildConfig.FLAVOR;
    L6:
        return this.ownerId;
    }

    public int getNoBadgedNewMessageCount() {
        return getNewMessageCount() - getUnReadBadgeCount();
    }

    @Override // com.ss.android.lark.chat.export.entity.chat.OpenChat
    public boolean isAIChat() {
        if (isAIMainChat() == false) goto L5;
    L8:
        return true;
    L5:
        if (isAIBotChat() == true) goto L8;
        return false;
    }

    @Override // com.ss.android.lark.chat.export.entity.chat.OpenChat
    public boolean isP2PChat() {
        if (getType() != Type.P2P) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.lark.chat.export.entity.chat.OpenChat
    public boolean isSoloChat() {
        if (isGroup() == false) goto L5;
    L7:
        return false;
    L5:
        if (this.memberCount != 1) goto L7;
        return true;
    }

    @Override // com.ss.android.lark.chat.export.entity.chat.OpenChat
    public boolean needEnterChatApply() {
        if (getAddMemberApply() != AddMemberApply.NEED_APPLY) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean canTranslateName() {
        return this.canTranslateName;
    }

    public AddMemberApply getAddMemberApply() {
        return this.mAddMemberApply;
    }

    public AddMemberPermission getAddMemberPermission() {
        return this.addMemberPermission;
    }

    public AdminPostSetting getAdminPostSetting() {
        return this.adminPostSetting;
    }

    public String getAnonymousId() {
        return this.mAnonymousId;
    }

    public AnonymousSetting getAnonymousSetting() {
        return this.mAnonymousSetting;
    }

    public long getAnonymousTotalQuota() {
        return this.mAnonymousTotalQuota;
    }

    public AtAllPermission getAtAllPermission() {
        return this.atAllPermission;
    }

    public Long getAtKnowledgeQueryCreateTime() {
        return this.atKnowledgeQueryCreateTime;
    }

    public Long getAtKnowledgeQueryId() {
        return this.atKnowledgeQueryId;
    }

    @Override // com.ss.android.lark.chat.export.entity.chat.OpenChat
    public String getAvatarKey() {
        return this.avatarKey;
    }

    public BannerSetting getBannerSetting() {
        return this.bannerSetting;
    }

    public boolean getBannerSettingAdmin() {
        return this.bannerSettingAdmin;
    }

    public String getBannerText() {
        return this.bannerText;
    }

    public List<ChatTeamInfo> getBoundTeamInfos() {
        return this.boundTeamInfos;
    }

    public int getBurnLife() {
        return this.burnLife;
    }

    public BuzzPermissionSetting getBuzzPermissionSetting() {
        return this.buzzPermissionSetting;
    }

    public ChatAnnouncement getChatAnnouncement() {
        return this.chatAnnouncement;
    }

    public ChatDisplayModeSetting getChatDisplayModeSetting() {
        return this.chatDisplayModeSetting;
    }

    public ChatMode getChatMode() {
        return this.chatMode;
    }

    public ChatOptionInfo getChatOptionInfo() {
        return this.chatOptionInfo;
    }

    public ChatPinPermissionSetting getChatPinPermissionSetting() {
        return this.chatPinPermissionSetting;
    }

    public ChatTabPermissionSetting getChatTabPermissionSetting() {
        return this.chatTabPermissionSetting;
    }

    public ChatTnsInfo getChatTnsInfo() {
        return this.chatTnsInfo;
    }

    public Map<Integer, Integer> getChatterExtraStates() {
        return this.chatterExtraStates;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public CreateVideoConferenceSetting getCreateVideoConferenceSetting() {
        return this.createVideoConferenceSetting;
    }

    public DefaultDisplaySetting getDefaultDisplaySetting() {
        return this.defaultDisplaySetting;
    }

    public String getDescription() {
        return this.description;
    }

    public DoubaoSetting getDoubaoSetting() {
        return this.doubaoSetting;
    }

    public int getFirstMessagePosition() {
        return this.firstMessagePosition;
    }

    public GroupMailSendPermissionType getGroupMailSendType() {
        return this.groupMailSendType;
    }

    public boolean getHasVCChatPermission() {
        return this.hasVCChatPermission;
    }

    @Override // com.ss.android.lark.chat.export.entity.chat.OpenChat
    public String getId() {
        return this.id;
    }

    public SystemMessageVisible getJoinMessageVisible() {
        return this.joinMessageVisible;
    }

    public String getKey() {
        return this.key;
    }

    public String getLastDraftId() {
        return this.lastDraftId;
    }

    public String getLastMessageId() {
        return this.lastMessageId;
    }

    public int getLastMessagePosition() {
        return this.lastMessagePosition;
    }

    public int getLastMessagePositionBadgeCount() {
        return this.lastMessagePositionBadgeCount;
    }

    public String getLastThreadId() {
        return this.lastThreadId;
    }

    public int getLastThreadPosition() {
        return this.lastThreadPosition;
    }

    public int getLastThreadPositionBadgeCount() {
        return this.lastThreadPositionBadgeCount;
    }

    public String getLastVisibleMessageId() {
        return this.lastVisibleMessageId;
    }

    public int getLastVisibleMessagePosition() {
        return this.lastVisibleMessagePosition;
    }

    public String getLastVisibleThreadId() {
        return this.lastVisibleThreadId;
    }

    public int getLastVisibleThreadPosition() {
        return this.lastVisibleThreadPosition;
    }

    public int getMemberCount() {
        return this.memberCount;
    }

    public MessagePosition getMessagePosition() {
        return this.messagePosition;
    }

    public MessageVisibilitySetting getMessageVisibilitySetting() {
        return this.mMessageVisibilitySetting;
    }

    public String getMiniAvatarKey() {
        return this.miniAvatarKey;
    }

    public int getMyThreadsUnreadCount() {
        return this.myThreadsUnreadCount;
    }

    @Override // com.ss.android.lark.chat.export.entity.chat.OpenChat
    public String getName() {
        return this.name;
    }

    public String getNameMajorLanguage() {
        return this.nameMajorLanguage;
    }

    public String getNamePinyin() {
        return this.namePinyin;
    }

    public String getNameTranslateLanguage() {
        return this.nameTranslateLanguage;
    }

    public String getOnCallId() {
        return this.onCallId;
    }

    public String getOwnerId() {
        return this.ownerId;
    }

    public PinPermissionSetting getPinPermissionSetting() {
        return this.pinPermissionSetting;
    }

    public String getPostDraftId() {
        return this.postDraftId;
    }

    public PostType getPostType() {
        return this.postType;
    }

    public int getPutChatterApplyCount() {
        return this.putChatterApplyCount;
    }

    public SystemMessageVisible getQuitMessageVisible() {
        return this.quitMessageVisible;
    }

    public String getReEditDraftId() {
        return this.reEditDraftId;
    }

    public int getReadPosition() {
        return this.readPosition;
    }

    public int getReadPositionBadgeCount() {
        return this.readPositionBadgeCount;
    }

    public int getReadThreadPosition() {
        return this.readThreadPosition;
    }

    public int getReadThreadPositionBadgeCount() {
        return this.readThreadPositionBadgeCount;
    }

    public float getRecentReadOffset() {
        return this.recentReadOffset;
    }

    public int getRecentReadPosition() {
        return this.recentReadPosition;
    }

    public RestrictedModeSetting getRestrictedModeSetting() {
        return this.restrictedModeSetting;
    }

    public Role getRole() {
        return this.role;
    }

    public String getScheduleDraftId() {
        return this.scheduleDraftId;
    }

    public ShareCardPermission getShareCardPermission() {
        return this.shareCardPermission;
    }

    public List<SideBarButton> getSideBarButtons() {
        return this.sideBarButtons;
    }

    public String getSideBarId() {
        return this.sideBarId;
    }

    public Status getStatus() {
        return this.status;
    }

    public TagData getTagData() {
        return this.tagData;
    }

    public List<Tag> getTags() {
        return this.tags;
    }

    public String getTenantId() {
        return this.tenantId;
    }

    public String getTextDraftId() {
        return this.textDraftId;
    }

    public long getThemeId() {
        return this.mThemeId;
    }

    public long getThreadLastTimeStamp() {
        return this.threadLastTimeStamp;
    }

    public long getThreadReadTimeStamp() {
        return this.threadReadTimeStamp;
    }

    public TopNoticePermissionSetting getTopNoticePermissionSetting() {
        return this.topNoticePermissionSetting;
    }

    public String getTranslatedName() {
        return this.translatedName;
    }

    public Type getType() {
        return this.type;
    }

    public TypingTranslateSetting getTypingTranslateSetting() {
        return this.typingTranslateSetting;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public ChatUserAutoMuteSetting getUserAutoMuteSetting() {
        return this.mChatUserAutoMuteSetting;
    }

    @Override // com.ss.android.lark.chat.export.entity.chat.OpenChat
    public int getUserCount() {
        return this.userCount;
    }

    public UserCountVisibleSetting getUserCountVisibleSetting() {
        return this.userCountVisibleSetting;
    }

    @Override // com.ss.android.lark.chat.export.entity.chat.OpenChat
    public boolean isAIBotChat() {
        return this.isAIBotChat;
    }

    @Override // com.ss.android.lark.chat.export.entity.chat.OpenChat
    public boolean isAIMainChat() {
        return this.isAIMainChat;
    }

    public boolean isAccept() {
        return this.isAccept;
    }

    @Override // com.ss.android.lark.chat.export.entity.chat.OpenChat
    public boolean isAdmin() {
        return this.isAdmin;
    }

    @Override // com.ss.android.lark.chat.export.entity.chat.OpenChat
    public boolean isAllowPost() {
        return this.isAllowPost;
    }

    public boolean isAutoTranslate() {
        return this.isAutoTranslate;
    }

    public boolean isCanBeSortedAlphabetically() {
        return this.canBeSortedAlphabetically;
    }

    public boolean isChatable() {
        return this.chatable;
    }

    @Override // com.ss.android.lark.chat.export.entity.chat.OpenChat
    public boolean isCrossTenant() {
        return this.isCrossTenant;
    }

    @Override // com.ss.android.lark.chat.export.entity.chat.OpenChat
    public boolean isCrossWithKa() {
        return this.isCrossWithKa;
    }

    public boolean isCustomAvatar() {
        return this.isCustomAvatar;
    }

    @Override // com.ss.android.lark.chat.export.entity.chat.OpenChat
    public boolean isCustomerService() {
        return this.isCustomerService;
    }

    public boolean isDelayed() {
        return this.mIsDelayed;
    }

    public boolean isDissolved() {
        return this.isDissolved;
    }

    public boolean isFake() {
        return this.isFake;
    }

    public boolean isFlag() {
        return this.isFlag;
    }

    public boolean isFrozen() {
        return this.isFrozen;
    }

    public boolean isGroupMailEnable() {
        return this.isGroupMailEnable;
    }

    public boolean isHasWatermark() {
        return this.hasWatermark;
    }

    public boolean isInBox() {
        return this.isInBox;
    }

    @Override // com.ss.android.lark.chat.export.entity.chat.OpenChat
    public boolean isMeeting() {
        return this.isMeeting;
    }

    public boolean isMuteAtAll() {
        return this.mIsMuteAtAll;
    }

    public boolean isMuteable() {
        return this.muteable;
    }

    public boolean isOcicService() {
        return this.isOcicService;
    }

    public boolean isOfficialOncall() {
        return this.isOfficialOncall;
    }

    public boolean isOfflineOncall() {
        return this.isOfflineOncall;
    }

    public boolean isOnlyOwnerEditGroupInfo() {
        return this.isOnlyOwnerEditGroupInfo;
    }

    public boolean isPublic() {
        return this.isPublic;
    }

    public boolean isRemind() {
        return this.isRemind;
    }

    @Override // com.ss.android.lark.chat.export.entity.chat.OpenChat
    public boolean isSecret() {
        return this.isSecret;
    }

    public boolean isShotCut() {
        return this.isShotCut;
    }

    public boolean isShowApplyBanner() {
        return this.isShowApplyBanner;
    }

    public boolean isShowBannerTitle() {
        return this.showBannerTitle;
    }

    public boolean isSuper() {
        return this.isSuper;
    }

    public boolean isTenant() {
        return this.isTenant;
    }

    public boolean isTypingTranslateHasAutoOpened() {
        return this.typingTranslateHasAutoOpened;
    }

    public boolean isUserCountVisible() {
        return this.isUserCountVisible;
    }

    public boolean is_department() {
        return this.is_department;
    }

    public boolean shouldDisplayTranslatedName() {
        return this.shouldDisplayTranslatedName;
    }

    public boolean equals(Object r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (this != r5) goto L9;
        return true;
    L9:
        if ((r5 instanceof Chat) == true) goto L11;
        return false;
    L11:
        Chat r6 = (Chat) r5;
        String r2 = this.id;
        if (r2 == null) goto L14;
        boolean r3 = r2.equals(r6.getId());
    L18:
        if (r3 == true) goto L21;
        return false;
    L21:
        if (this.burnLife != r6.burnLife) goto L23;
        boolean r4 = true;
    L24:
        if (r4 == true) goto L26;
        return false;
    L26:
        Type r7 = this.type;
        Type r8 = r6.getType();
        if (r7 != null) goto L31;
        if (r8 != null) goto L32;
        return true;
    L32:
        return false;
    L31:
        return r7.equals(r8);
    L23:
        r4 = false;
        goto L24
    L14:
        if (r6.getId() != null) goto L16;
        r3 = true;
        goto L18
    L16:
        r3 = false;
        goto L18
    }

    public boolean exactlyCompare(Chat r8) {
        if (r8 != null) goto L6;
        return false;
    L6:
        if (this != r8) goto L8;
        return true;
    L8:
        String r2 = this.id;
        if (r2 == null) goto L11;
        boolean r3 = r2.equals(r8.getId());
    L15:
        if (r3 == true) goto L18;
        return false;
    L18:
        if (this.updateTime != r8.updateTime) goto L20;
        boolean r4 = true;
    L21:
        if (r4 == true) goto L24;
        return false;
    L24:
        if (TextUtils.equals(this.name, r8.name) == true) goto L26;
        return false;
    L26:
        Type r5 = this.type;
        Type r9 = r8.getType();
        if (r5 != null) goto L31;
        if (r9 != null) goto L32;
        return true;
    L32:
        return false;
    L31:
        return r5.equals(r9);
    L20:
        r4 = false;
        goto L21
    L11:
        if (r8.getId() != null) goto L13;
        r3 = true;
        goto L15
    L13:
        r3 = false;
        goto L15
    }

    public void setAIBotChat(boolean r1) {
        this.isAIBotChat = r1;
    }

    public void setAIMainChat(boolean r1) {
        this.isAIMainChat = r1;
    }

    public void setAccept(boolean r1) {
        this.isAccept = r1;
    }

    public void setAddMemberApply(AddMemberApply r1) {
        this.mAddMemberApply = r1;
    }

    public void setAddMemberPermission(AddMemberPermission r1) {
        this.addMemberPermission = r1;
    }

    public void setAdmin(boolean r1) {
        this.isAdmin = r1;
    }

    public void setAdminPostSetting(AdminPostSetting r1) {
        this.adminPostSetting = r1;
    }

    public void setAllowPost(boolean r1) {
        this.isAllowPost = r1;
    }

    public void setAnonymousId(String r1) {
        this.mAnonymousId = r1;
    }

    public void setAnonymousSetting(AnonymousSetting r1) {
        this.mAnonymousSetting = r1;
    }

    public void setAnonymousTotalQuota(long r1) {
        this.mAnonymousTotalQuota = r1;
    }

    public void setAtAllPermission(AtAllPermission r1) {
        this.atAllPermission = r1;
    }

    public void setAtKnowledgeQueryCreateTime(Long r1) {
        this.atKnowledgeQueryCreateTime = r1;
    }

    public void setAtKnowledgeQueryId(Long r1) {
        this.atKnowledgeQueryId = r1;
    }

    public void setAutoTranslate(boolean r1) {
        this.isAutoTranslate = r1;
    }

    public void setAvatarKey(String r1) {
        this.avatarKey = r1;
    }

    public void setBannerSetting(BannerSetting r1) {
        this.bannerSetting = r1;
    }

    public void setBannerSettingAdmin(boolean r1) {
        this.bannerSettingAdmin = r1;
    }

    public void setBannerText(String r1) {
        this.bannerText = r1;
    }

    public void setBoundTeamInfos(List<ChatTeamInfo> r1) {
        this.boundTeamInfos = r1;
    }

    public void setBurnLife(int r1) {
        this.burnLife = r1;
    }

    public void setBuzzPermissionSetting(BuzzPermissionSetting r1) {
        this.buzzPermissionSetting = r1;
    }

    public void setCanBeSortedAlphabetically(boolean r1) {
        this.canBeSortedAlphabetically = r1;
    }

    public void setCanTranslateName(boolean r1) {
        this.canTranslateName = r1;
    }

    public void setChatAnnouncement(ChatAnnouncement r1) {
        this.chatAnnouncement = r1;
    }

    public void setChatDisplayModeSetting(ChatDisplayModeSetting r1) {
        this.chatDisplayModeSetting = r1;
    }

    public void setChatMode(ChatMode r1) {
        this.chatMode = r1;
    }

    public void setChatOptionInfo(ChatOptionInfo r1) {
        this.chatOptionInfo = r1;
    }

    public void setChatPinPermissionSetting(ChatPinPermissionSetting r1) {
        this.chatPinPermissionSetting = r1;
    }

    public void setChatTabPermissionSetting(ChatTabPermissionSetting r1) {
        this.chatTabPermissionSetting = r1;
    }

    public void setChatTnsInfo(ChatTnsInfo r1) {
        this.chatTnsInfo = r1;
    }

    public void setChatable(boolean r1) {
        this.chatable = r1;
    }

    public void setChatterExtraStates(Map<Integer, Integer> r1) {
        this.chatterExtraStates = r1;
    }

    public void setCreateTime(String r1) {
        this.createTime = r1;
    }

    public void setCreateVideoConferenceSetting(CreateVideoConferenceSetting r1) {
        this.createVideoConferenceSetting = r1;
    }

    public void setCrossTenant(boolean r1) {
        this.isCrossTenant = r1;
    }

    public void setCrossWithKa(boolean r1) {
        this.isCrossWithKa = r1;
    }

    public void setCustomerService(boolean r1) {
        this.isCustomerService = r1;
    }

    public void setDefaultDisplaySetting(DefaultDisplaySetting r1) {
        this.defaultDisplaySetting = r1;
    }

    public void setDescription(String r1) {
        this.description = r1;
    }

    public void setDissolved(boolean r1) {
        this.isDissolved = r1;
    }

    public void setDoubaoSetting(DoubaoSetting r1) {
        this.doubaoSetting = r1;
    }

    public void setFake(boolean r1) {
        this.isFake = r1;
    }

    public void setFirstMessagePosition(int r1) {
        this.firstMessagePosition = r1;
    }

    public void setFlag(boolean r1) {
        this.isFlag = r1;
    }

    public void setFrozen(boolean r1) {
        this.isFrozen = r1;
    }

    public void setGroupMailEnable(boolean r1) {
        this.isGroupMailEnable = r1;
    }

    public void setGroupMailSendType(GroupMailSendPermissionType r1) {
        this.groupMailSendType = r1;
    }

    public void setHasVCChatPermission(boolean r1) {
        this.hasVCChatPermission = r1;
    }

    public void setHasWatermark(boolean r1) {
        this.hasWatermark = r1;
    }

    public void setId(String r1) {
        this.id = r1;
    }

    public void setInBox(boolean r1) {
        this.isInBox = r1;
    }

    public void setIsCustomAvatar(boolean r1) {
        this.isCustomAvatar = r1;
    }

    public void setIsDelayed(boolean r1) {
        this.mIsDelayed = r1;
    }

    public void setIsMuteAtAll(boolean r1) {
        this.mIsMuteAtAll = r1;
    }

    public void setIsOcicService(boolean r1) {
        this.isOcicService = r1;
    }

    public void setIs_department(boolean r1) {
        this.is_department = r1;
    }

    public void setIs_public(boolean r1) {
        this.is_public = r1;
    }

    public void setJoinMessageVisible(SystemMessageVisible r1) {
        this.joinMessageVisible = r1;
    }

    public void setKey(String r1) {
        this.key = r1;
    }

    public void setLastDraftId(String r1) {
        this.lastDraftId = r1;
    }

    public void setLastMessageId(String r1) {
        this.lastMessageId = r1;
    }

    public void setLastMessagePosition(int r1) {
        this.lastMessagePosition = r1;
    }

    public void setLastMessagePositionBadgeCount(int r1) {
        this.lastMessagePositionBadgeCount = r1;
    }

    public void setLastThreadId(String r1) {
        this.lastThreadId = r1;
    }

    public void setLastThreadPosition(int r1) {
        this.lastThreadPosition = r1;
    }

    public void setLastThreadPositionBadgeCount(int r1) {
        this.lastThreadPositionBadgeCount = r1;
    }

    public void setLastVisibleMessageId(String r1) {
        this.lastVisibleMessageId = r1;
    }

    public void setLastVisibleMessagePosition(int r1) {
        this.lastVisibleMessagePosition = r1;
    }

    public void setLastVisibleThreadId(String r1) {
        this.lastVisibleThreadId = r1;
    }

    public void setLastVisibleThreadPosition(int r1) {
        this.lastVisibleThreadPosition = r1;
    }

    public void setMeeting(boolean r1) {
        this.isMeeting = r1;
    }

    public void setMemberCount(int r1) {
        this.memberCount = r1;
    }

    public void setMessagePosition(MessagePosition r1) {
        this.messagePosition = r1;
    }

    public void setMessageVisibilitySetting(MessageVisibilitySetting r1) {
        this.mMessageVisibilitySetting = r1;
    }

    public void setMiniAvatarKey(String r1) {
        this.miniAvatarKey = r1;
    }

    public void setMuteable(boolean r1) {
        this.muteable = r1;
    }

    public void setMyThreadsUnreadCount(int r1) {
        this.myThreadsUnreadCount = r1;
    }

    public void setName(String r1) {
        this.name = r1;
    }

    public void setNameMajorLanguage(String r1) {
        this.nameMajorLanguage = r1;
    }

    public void setNamePinyin(String r1) {
        this.namePinyin = r1;
    }

    public void setNameTranslateLanguage(String r1) {
        this.nameTranslateLanguage = r1;
    }

    public void setOfficialOncall(boolean r1) {
        this.isOfficialOncall = r1;
    }

    public void setOfflineOncall(Boolean r1) {
        this.isOfflineOncall = r1.booleanValue();
    }

    public void setOnCallId(String r1) {
        this.onCallId = r1;
    }

    public void setOnlyOwnerEditGroupInfo(boolean r1) {
        this.isOnlyOwnerEditGroupInfo = r1;
    }

    public void setOwnerId(String r1) {
        this.ownerId = r1;
    }

    public void setP2pChatterId(String r1) {
        this.p2pChatterId = r1;
    }

    public void setPinPermissionSetting(PinPermissionSetting r1) {
        this.pinPermissionSetting = r1;
    }

    public void setPostDraftId(String r1) {
        this.postDraftId = r1;
    }

    public void setPostType(PostType r1) {
        this.postType = r1;
    }

    public void setPublic(boolean r1) {
        this.isPublic = r1;
    }

    public void setPutChatterApplyCount(int r1) {
        this.putChatterApplyCount = r1;
    }

    public void setQuitMessageVisible(SystemMessageVisible r1) {
        this.quitMessageVisible = r1;
    }

    public void setReEditDraftId(String r1) {
        this.reEditDraftId = r1;
    }

    public void setReadPosition(int r1) {
        this.readPosition = r1;
    }

    public void setReadPositionBadgeCount(int r1) {
        this.readPositionBadgeCount = r1;
    }

    public void setReadThreadPosition(int r1) {
        this.readThreadPosition = r1;
    }

    public void setReadThreadPositionBadgeCount(int r1) {
        this.readThreadPositionBadgeCount = r1;
    }

    public void setRecentReadOffset(float r1) {
        this.recentReadOffset = r1;
    }

    public void setRecentReadPosition(int r1) {
        this.recentReadPosition = r1;
    }

    public void setRemind(boolean r1) {
        this.isRemind = r1;
    }

    public void setRestrictedModeSetting(RestrictedModeSetting r1) {
        this.restrictedModeSetting = r1;
    }

    public void setRole(Role r1) {
        this.role = r1;
    }

    public void setScheduleDraftId(String r1) {
        this.scheduleDraftId = r1;
    }

    public void setSecret(boolean r1) {
        this.isSecret = r1;
    }

    public void setShareCardPermission(ShareCardPermission r1) {
        this.shareCardPermission = r1;
    }

    public void setShotCut(boolean r1) {
        this.isShotCut = r1;
    }

    public void setShouldDisplayTranslatedName(boolean r1) {
        this.shouldDisplayTranslatedName = r1;
    }

    public void setShowApplyBanner(boolean r1) {
        this.isShowApplyBanner = r1;
    }

    public void setShowBannerTitle(boolean r1) {
        this.showBannerTitle = r1;
    }

    public void setSideBarButtons(List<SideBarButton> r1) {
        this.sideBarButtons = r1;
    }

    public void setSideBarId(String r1) {
        this.sideBarId = r1;
    }

    public void setStatus(Status r1) {
        this.status = r1;
    }

    public void setSuper(boolean r1) {
        this.isSuper = r1;
    }

    public void setTagData(TagData r1) {
        this.tagData = r1;
    }

    public void setTags(List<Tag> r1) {
        this.tags = r1;
    }

    public void setTenant(boolean r1) {
        this.isTenant = r1;
    }

    public void setTenantId(String r1) {
        this.tenantId = r1;
    }

    public void setTextDraftId(String r1) {
        this.textDraftId = r1;
    }

    public void setThemeId(long r1) {
        this.mThemeId = r1;
    }

    public void setThreadLastTimeStamp(long r1) {
        this.threadLastTimeStamp = r1;
    }

    public void setThreadReadTimeStamp(long r1) {
        this.threadReadTimeStamp = r1;
    }

    public void setTopNoticePermissionSetting(TopNoticePermissionSetting r1) {
        this.topNoticePermissionSetting = r1;
    }

    public void setTranslatedName(String r1) {
        this.translatedName = r1;
    }

    public void setType(Type r1) {
        this.type = r1;
    }

    public void setTypingTranslateHasAutoOpened(boolean r1) {
        this.typingTranslateHasAutoOpened = r1;
    }

    public void setTypingTranslateSetting(TypingTranslateSetting r1) {
        this.typingTranslateSetting = r1;
    }

    public void setUpdateTime(long r1) {
        this.updateTime = r1;
    }

    public void setUserAutoMuteSetting(ChatUserAutoMuteSetting r1) {
        this.mChatUserAutoMuteSetting = r1;
    }

    public void setUserCount(int r1) {
        this.userCount = r1;
    }

    public void setUserCountVisible(boolean r1) {
        this.isUserCountVisible = r1;
    }

    public void setUserCountVisibleSetting(UserCountVisibleSetting r1) {
        this.userCountVisibleSetting = r1;
    }
}
