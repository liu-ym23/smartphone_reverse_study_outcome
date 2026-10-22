package com.ss.android.lark.chat.entity.message;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.File;
import com.bytedance.lark.pb.basic.v1.ImageTranslationAbility;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.AuthorityParam;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.chat.entity.Channel;
import com.ss.android.lark.chat.entity.chat.ChatDisplayModeSetting;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.entity.message.content.BaseFileContent;
import com.ss.android.lark.chat.entity.message.content.BaseTextContent;
import com.ss.android.lark.chat.entity.message.content.ImageContent;
import com.ss.android.lark.chat.entity.message.content.MediaContent;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.chat.export.entity.message.MessageType;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.i;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import uxb.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class Message implements c, p5b.b, Serializable, Cloneable, Comparable<Message>, y28.b<Message> {
    private static final long serialVersionUID = -2587494770206633286L;
    private String aiAnswerRawData;
    private long aiChatModeId;
    private AIInfo aiInfo;
    private com.bytedance.lark.pb.basic.v1.Message.AIMessageLikeFeedbackStatus aiMessageLikeFeedbackStatus;
    private com.bytedance.lark.pb.basic.v1.Message.AIMessageType aiMessageType;
    private AISmartReply aiSmartReply;
    private MessageAnalysisConfig analysisConfigs;
    private String appInfoItemName;
    private final List<String> atBotIds;
    private int badgeCount;
    private int burnLife;
    private long burnTime;
    private String cId;
    private boolean canShowAiProcess;
    private Channel channel;
    private int characterLength;
    private ChatDisplayModeSetting chatDisplayModeSetting;
    private String chatId;
    private int contentVersion;
    private CotContent cotContent;
    private long createTime;
    private long createTimeInMills;
    private String cryptoToken;
    private HashMap<Integer, com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Behavior> disabledAction;
    private MessageSourceDisplayPolicy displayPolicy;
    private MessageDLPState dlpState;
    private MessageEditInfo editInfo;
    private HashMap<Class<?>, Object> extras;
    private FileDeletedStatus fileDeletedStatus;
    private String foldId;
    private String fromChatterTenantId;
    private String fromId;
    private FromType fromType;
    private boolean hasFollowUP;
    private String id;
    private Map<String, ImageTranslationAbility> imageTranslationAbility;
    private boolean isAtAll;
    private boolean isAtMe;
    private boolean isAutoTranslatedForReceiver;
    private boolean isBadged;
    private boolean isBurned;
    private boolean isCleaned;
    private boolean isCryptoIntermediate;
    private boolean isDeCryptFailed;
    private boolean isDing;
    private boolean isEphemeral;
    private boolean isFlag;
    private boolean isForwardFromFriend;
    private boolean isFromMe;
    private boolean isIncludeDocUrl;
    private boolean isNewTopic;
    private boolean isNoTraceDelete;
    private boolean isNotified;
    private boolean isOnTimeDel;
    private boolean isOtherAtMe;
    private boolean isReEditable;
    private boolean isRemoved;
    private boolean isRestricted;
    private boolean isSecretChatDecryptedFailed;
    private boolean isShared;
    private boolean isSourceFileDelete;
    private boolean isStaticResourceMessageRecalled;
    private boolean isSyncMsgDep;
    private boolean isThreadForwardRootMessage;
    private boolean isTranslatedManually;
    private boolean isUntranslatable;
    private boolean isVisible;
    private int mMeReadType;
    private Content messageContent;
    private String messageLanguage;
    private LinkedHashMap<String, com.bytedance.lark.pb.basic.v1.MessageLink> messageLinkMap;
    private HashMap<Integer, String> messageLocalDataInfoMap;
    private int originBadgeCount;
    private String originalSenderId;
    private String parentId;
    private String parentSourceId;
    private PartialReplyInfo partialReplyInfo;
    private int position;
    private String postDraftId;
    private String preprocessKey;
    private List<String> readAtChatterIds;
    private int readCount;
    private String recallerId;
    private RecallerIdentity recallerIdentity;
    private int replyCount;
    private String replyInThreadDraftId;
    private String rootId;
    private String scheduleDraftId;
    private MessageSecurityESCReviewExtra securityESCReviewExtra;
    private SendStatus sendStatus;
    private MessageSenderAppInfo senderAppInfo;
    private boolean setGrey;
    private String sourceId;
    private SourceType sourceType;
    private Status status;
    private long streamSequenceId;
    private MessageStreamStatus streamStatus;
    private SyncToChatMessageType syncToChatMessageType;
    private long syncToChatRelatedMessageId;
    private long syncToChatThreadRootId;
    private String textDraftId;
    private int threadBadgeCount;
    private String threadId;
    private ThreadMessageType threadMessageType;
    private int threadPosition;
    private int translateDisplayRule;
    private String translateLanguage;
    private Type type;
    private int unReadCount;
    private long updateTime;
    private ValidateIMFileResult validateIMFileResult;

    public static final enum FileDeletedStatus extends Enum<FileDeletedStatus> {
        public static final FileDeletedStatus FREED_UP = null;
        public static final FileDeletedStatus NORMAL = null;
        public static final FileDeletedStatus RECALLED = null;
        public static final FileDeletedStatus RECOVERABLE = null;
        public static final FileDeletedStatus UNRECOVERABLE = null;
        public static final /* synthetic */ FileDeletedStatus[] a = null;
        private final int value;

        static {
            FileDeletedStatus r0 = new FileDeletedStatus("NORMAL", 0, 0);
            NORMAL = r0;
            FileDeletedStatus r1 = new FileDeletedStatus("RECOVERABLE", 1, 1);
            RECOVERABLE = r1;
            FileDeletedStatus r3 = new FileDeletedStatus("UNRECOVERABLE", 2, 2);
            UNRECOVERABLE = r3;
            FileDeletedStatus r5 = new FileDeletedStatus("RECALLED", 3, 3);
            RECALLED = r5;
            FileDeletedStatus r7 = new FileDeletedStatus("FREED_UP", 4, 4);
            FREED_UP = r7;
            a = new FileDeletedStatus[]{r0, r1, r3, r5, r7};
        }

        public static FileDeletedStatus[] values() {
            return (FileDeletedStatus[]) a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static FileDeletedStatus fromValue(int r1) {
            if (r1 == 0) goto L22;
            if (r1 == 1) goto L20;
            if (r1 == 2) goto L18;
            if (r1 == 3) goto L16;
            if (r1 == 4) goto L14;
            return null;
        L14:
            return FREED_UP;
        L16:
            return RECALLED;
        L18:
            return UNRECOVERABLE;
        L20:
            return RECOVERABLE;
        L22:
            return NORMAL;
        }

        public static FileDeletedStatus valueOf(String r1) {
            return (FileDeletedStatus) r27.a.a(FileDeletedStatus.class, r1);
        }

        public FileDeletedStatus(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum FromType extends Enum<FromType> {
        public static final FromType BOT = null;
        public static final FromType USER = null;
        public static final /* synthetic */ FromType[] a = null;
        private final int value;

        static {
            FromType r0 = new FromType("USER", 0, 1);
            USER = r0;
            FromType r1 = new FromType("BOT", 1, 2);
            BOT = r1;
            a = new FromType[]{r0, r1};
        }

        public static FromType[] values() {
            return (FromType[]) a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static FromType forNumber(int r1) {
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L9;
            return null;
        L9:
            return BOT;
        L11:
            return USER;
        }

        public static FromType valueOf(String r1) {
            return (FromType) r27.a.a(FromType.class, r1);
        }

        public static FromType valueOf(int r0) {
            return forNumber(r0);
        }

        public FromType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum RecallerIdentity extends Enum<RecallerIdentity> {
        public static final RecallerIdentity ADMINISTRATOR = null;
        public static final RecallerIdentity DOUBAO_QUERY_OWNER = null;
        public static final RecallerIdentity ENTERPRISE_ADMINISTRATOR = null;
        public static final RecallerIdentity GROUP_ADMIN = null;
        public static final RecallerIdentity OWNER = null;
        public static final RecallerIdentity UNKNOWN_IDENTITY = null;
        public static final /* synthetic */ RecallerIdentity[] a = null;
        private final int value;

        static {
            RecallerIdentity r0 = new RecallerIdentity("UNKNOWN_IDENTITY", 0, 0);
            UNKNOWN_IDENTITY = r0;
            RecallerIdentity r1 = new RecallerIdentity("OWNER", 1, 1);
            OWNER = r1;
            RecallerIdentity r3 = new RecallerIdentity("ADMINISTRATOR", 2, 2);
            ADMINISTRATOR = r3;
            RecallerIdentity r5 = new RecallerIdentity("GROUP_ADMIN", 3, 3);
            GROUP_ADMIN = r5;
            RecallerIdentity r7 = new RecallerIdentity("ENTERPRISE_ADMINISTRATOR", 4, 4);
            ENTERPRISE_ADMINISTRATOR = r7;
            RecallerIdentity r9 = new RecallerIdentity("DOUBAO_QUERY_OWNER", 5, 5);
            DOUBAO_QUERY_OWNER = r9;
            a = new RecallerIdentity[]{r0, r1, r3, r5, r7, r9};
        }

        public static RecallerIdentity[] values() {
            return (RecallerIdentity[]) a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static RecallerIdentity forNumber(int r1) {
            if (r1 == 0) goto L26;
            if (r1 == 1) goto L24;
            if (r1 == 2) goto L22;
            if (r1 == 3) goto L20;
            if (r1 == 4) goto L18;
            if (r1 == 5) goto L16;
            return UNKNOWN_IDENTITY;
        L16:
            return DOUBAO_QUERY_OWNER;
        L18:
            return ENTERPRISE_ADMINISTRATOR;
        L20:
            return GROUP_ADMIN;
        L22:
            return ADMINISTRATOR;
        L24:
            return OWNER;
        L26:
            return UNKNOWN_IDENTITY;
        }

        public static RecallerIdentity valueOf(String r1) {
            return (RecallerIdentity) r27.a.a(RecallerIdentity.class, r1);
        }

        public static RecallerIdentity valueOf(int r0) {
            return forNumber(r0);
        }

        public RecallerIdentity(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum SourceType extends Enum<SourceType> {
        public static final SourceType TYPE_FROM_CHAT_HISTORY = null;
        public static final SourceType TYPE_FROM_CHAT_PIN = null;
        public static final SourceType TYPE_FROM_FAVORITE = null;
        public static final SourceType TYPE_FROM_FLAG = null;
        public static final SourceType TYPE_FROM_MERGEFORWARD = null;
        public static final SourceType TYPE_FROM_MESSAGE = null;
        public static final SourceType TYPE_FROM_TODO_REFER_RESOURCE = null;
        public static final SourceType TYPE_FROM_UNKONWN = null;
        public static final /* synthetic */ SourceType[] a = null;
        private final int value;

        static {
            SourceType r0 = new SourceType("TYPE_FROM_UNKONWN", 0, 0);
            TYPE_FROM_UNKONWN = r0;
            SourceType r1 = new SourceType("TYPE_FROM_MESSAGE", 1, 1);
            TYPE_FROM_MESSAGE = r1;
            SourceType r3 = new SourceType("TYPE_FROM_MERGEFORWARD", 2, 2);
            TYPE_FROM_MERGEFORWARD = r3;
            SourceType r5 = new SourceType("TYPE_FROM_FAVORITE", 3, 3);
            TYPE_FROM_FAVORITE = r5;
            SourceType r7 = new SourceType("TYPE_FROM_TODO_REFER_RESOURCE", 4, 4);
            TYPE_FROM_TODO_REFER_RESOURCE = r7;
            SourceType r9 = new SourceType("TYPE_FROM_CHAT_PIN", 5, 5);
            TYPE_FROM_CHAT_PIN = r9;
            SourceType r11 = new SourceType("TYPE_FROM_CHAT_HISTORY", 6, 6);
            TYPE_FROM_CHAT_HISTORY = r11;
            SourceType r13 = new SourceType("TYPE_FROM_FLAG", 7, 7);
            TYPE_FROM_FLAG = r13;
            a = new SourceType[]{r0, r1, r3, r5, r7, r9, r11, r13};
        }

        public static SourceType[] values() {
            return (SourceType[]) a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static SourceType valueOf(int r0) {
            switch(r0) {
                case 0: goto L12;
                case 1: goto L20;
                case 2: goto L19;
                case 3: goto L18;
                case 4: goto L17;
                case 5: goto L16;
                case 6: goto L15;
                case 7: goto L14;
                default: goto L13;
            };
        L13:
            return TYPE_FROM_UNKONWN;
        L14:
            return TYPE_FROM_FLAG;
        L15:
            return TYPE_FROM_CHAT_HISTORY;
        L16:
            return TYPE_FROM_CHAT_PIN;
        L17:
            return TYPE_FROM_TODO_REFER_RESOURCE;
        L18:
            return TYPE_FROM_FAVORITE;
        L19:
            return TYPE_FROM_MERGEFORWARD;
        L20:
            return TYPE_FROM_MESSAGE;
        L12:
            return TYPE_FROM_UNKONWN;
        }

        public static SourceType valueOf(String r1) {
            return (SourceType) r27.a.a(SourceType.class, r1);
        }

        public SourceType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum Status extends Enum<Status> {
        public static final Status DELETED = null;
        public static final Status MODIFIED = null;
        public static final Status NORMAL = null;
        public static final /* synthetic */ Status[] a = null;
        private final int value;

        static {
            Status r0 = new Status("NORMAL", 0, 1);
            NORMAL = r0;
            Status r1 = new Status("DELETED", 1, 2);
            DELETED = r1;
            Status r4 = new Status("MODIFIED", 2, 3);
            MODIFIED = r4;
            a = new Status[]{r0, r1, r4};
        }

        public static Status[] values() {
            return (Status[]) a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static Status forNumber(int r1) {
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L13;
            if (r1 == 3) goto L11;
            return null;
        L11:
            return MODIFIED;
        L13:
            return DELETED;
        L15:
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

    public static final enum SyncToChatMessageType extends Enum<SyncToChatMessageType> {
        public static final SyncToChatMessageType SYNC_TO_CHAT_SOURCE_MESSAGE = null;
        public static final SyncToChatMessageType SYNC_TO_CHAT_TARGET_MESSAGE = null;
        public static final SyncToChatMessageType UNKNOWN_SYNC_TO_CHAT_MESSAGE_TYPE = null;
        public static final /* synthetic */ SyncToChatMessageType[] a = null;
        private final int value;

        static {
            SyncToChatMessageType r0 = new SyncToChatMessageType("UNKNOWN_SYNC_TO_CHAT_MESSAGE_TYPE", 0, 0);
            UNKNOWN_SYNC_TO_CHAT_MESSAGE_TYPE = r0;
            SyncToChatMessageType r1 = new SyncToChatMessageType("SYNC_TO_CHAT_TARGET_MESSAGE", 1, 1);
            SYNC_TO_CHAT_TARGET_MESSAGE = r1;
            SyncToChatMessageType r3 = new SyncToChatMessageType("SYNC_TO_CHAT_SOURCE_MESSAGE", 2, 2);
            SYNC_TO_CHAT_SOURCE_MESSAGE = r3;
            a = new SyncToChatMessageType[]{r0, r1, r3};
        }

        public static SyncToChatMessageType[] values() {
            return (SyncToChatMessageType[]) a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static SyncToChatMessageType fromValue(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return SYNC_TO_CHAT_SOURCE_MESSAGE;
        L12:
            return SYNC_TO_CHAT_TARGET_MESSAGE;
        L14:
            return UNKNOWN_SYNC_TO_CHAT_MESSAGE_TYPE;
        }

        public static SyncToChatMessageType valueOf(String r1) {
            return (SyncToChatMessageType) r27.a.a(SyncToChatMessageType.class, r1);
        }

        public SyncToChatMessageType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum ThreadMessageType extends Enum<ThreadMessageType> {
        public static final ThreadMessageType THREAD_REPLY_MESSAGE = null;
        public static final ThreadMessageType THREAD_ROOT_MESSAGE = null;
        public static final ThreadMessageType UNKNOWN_THREAD_MESSAGE = null;
        public static final /* synthetic */ ThreadMessageType[] a = null;
        private final int value;

        static {
            ThreadMessageType r0 = new ThreadMessageType("UNKNOWN_THREAD_MESSAGE", 0, 0);
            UNKNOWN_THREAD_MESSAGE = r0;
            ThreadMessageType r1 = new ThreadMessageType("THREAD_ROOT_MESSAGE", 1, 1);
            THREAD_ROOT_MESSAGE = r1;
            ThreadMessageType r3 = new ThreadMessageType("THREAD_REPLY_MESSAGE", 2, 2);
            THREAD_REPLY_MESSAGE = r3;
            a = new ThreadMessageType[]{r0, r1, r3};
        }

        public static ThreadMessageType[] values() {
            return (ThreadMessageType[]) a.clone();
        }

        public static ThreadMessageType fromValue(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return THREAD_REPLY_MESSAGE;
        L12:
            return THREAD_ROOT_MESSAGE;
        L14:
            return UNKNOWN_THREAD_MESSAGE;
        }

        public static ThreadMessageType valueOf(String r1) {
            return (ThreadMessageType) r27.a.a(ThreadMessageType.class, r1);
        }

        public ThreadMessageType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum Type extends Enum<Type> {
        public static final Type AUDIO = null;
        public static final Type CALENDAR = null;
        public static final Type CARD = null;
        public static final Type COMMERCIALIZED_HONGBAO = null;
        public static final Type DOUBAO = null;
        public static final Type EMAIL = null;
        public static final Type FILE = null;
        public static final Type FOLDER = null;
        public static final Type GENERAL_CALENDAR = null;
        public static final Type IMAGE = null;
        public static final Type LOCATION = null;
        public static final Type MEDIA = null;
        public static final Type MERGE_FORWARD = null;
        public static final Type POST = null;
        public static final Type RED_PACKET = null;
        public static final Type SHARE_CALENDAR_EVENT = null;
        public static final Type SHARE_GROUP_CHAT = null;
        public static final Type SHARE_USER_CARD = null;
        public static final Type STICKER = null;
        public static final Type SYSTEM = null;
        public static final Type TEXT = null;
        public static final Type TEXT_IMAGE = null;
        public static final Type TODO = null;
        public static final Type UNKNOWN = null;
        public static final Type VIDEO_CHAT = null;
        public static final Type VOTE = null;
        public static final /* synthetic */ Type[] a = null;
        private final int value;

        static {
            Type r0 = new Type("UNKNOWN", 0, -1);
            UNKNOWN = r0;
            Type r1 = new Type("TEXT_IMAGE", 1, 1);
            TEXT_IMAGE = r1;
            Type r2 = new Type("POST", 2, 2);
            POST = r2;
            Type r4 = new Type("FILE", 3, 3);
            FILE = r4;
            Type r6 = new Type("TEXT", 4, 4);
            TEXT = r6;
            Type r8 = new Type("IMAGE", 5, 5);
            IMAGE = r8;
            Type r10 = new Type("SYSTEM", 6, 6);
            SYSTEM = r10;
            Type r12 = new Type("AUDIO", 7, 7);
            AUDIO = r12;
            Type r14 = new Type("EMAIL", 8, 8);
            EMAIL = r14;
            Type r15 = new Type("SHARE_GROUP_CHAT", 9, 9);
            SHARE_GROUP_CHAT = r15;
            Type r13 = new Type("STICKER", 10, 10);
            STICKER = r13;
            Type r11 = new Type("MERGE_FORWARD", 11, 11);
            MERGE_FORWARD = r11;
            Type r9 = new Type("CALENDAR", 12, 12);
            CALENDAR = r9;
            Type r7 = new Type("CARD", 13, 13);
            CARD = r7;
            Type r5 = new Type("MEDIA", 14, 15);
            MEDIA = r5;
            Type r3 = new Type("SHARE_CALENDAR_EVENT", 15, 16);
            SHARE_CALENDAR_EVENT = r3;
            Type r16 = new Type("RED_PACKET", 16, 17);
            RED_PACKET = r16;
            Type r17 = new Type("GENERAL_CALENDAR", 17, 18);
            GENERAL_CALENDAR = r17;
            Type r18 = new Type("VIDEO_CHAT", 18, 19);
            VIDEO_CHAT = r18;
            Type r19 = new Type("LOCATION", 19, 20);
            LOCATION = r19;
            Type r20 = new Type("COMMERCIALIZED_HONGBAO", 20, 22);
            COMMERCIALIZED_HONGBAO = r20;
            Type r21 = new Type("SHARE_USER_CARD", 21, 23);
            SHARE_USER_CARD = r21;
            Type r22 = new Type("TODO", 22, 24);
            TODO = r22;
            Type r23 = new Type("FOLDER", 23, 25);
            FOLDER = r23;
            Type r24 = new Type("VOTE", 24, 27);
            VOTE = r24;
            Type r25 = new Type("DOUBAO", 25, 29);
            DOUBAO = r25;
            a = new Type[]{r0, r1, r2, r4, r6, r8, r10, r12, r14, r15, r13, r11, r9, r7, r5, r3, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25};
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static /* synthetic */ int access$000(Type r0) {
            return r0.value;
        }

        public static Type forNumber(int r0) {
            switch(r0) {
                case 1: goto L54;
                case 2: goto L52;
                case 3: goto L50;
                case 4: goto L48;
                case 5: goto L46;
                case 6: goto L44;
                case 7: goto L42;
                case 8: goto L40;
                case 9: goto L38;
                case 10: goto L36;
                case 11: goto L34;
                case 12: goto L32;
                case 13: goto L30;
                case 14: goto L4;
                case 15: goto L28;
                case 16: goto L26;
                case 17: goto L24;
                case 18: goto L22;
                case 19: goto L20;
                case 20: goto L18;
                case 21: goto L4;
                case 22: goto L16;
                case 23: goto L14;
                case 24: goto L12;
                case 25: goto L10;
                case 26: goto L4;
                case 27: goto L8;
                case 28: goto L4;
                case 29: goto L6;
                default: goto L4;
            };
        L4:
            return UNKNOWN;
        L6:
            return DOUBAO;
        L8:
            return VOTE;
        L10:
            return FOLDER;
        L12:
            return TODO;
        L14:
            return SHARE_USER_CARD;
        L16:
            return COMMERCIALIZED_HONGBAO;
        L18:
            return LOCATION;
        L20:
            return VIDEO_CHAT;
        L22:
            return GENERAL_CALENDAR;
        L24:
            return RED_PACKET;
        L26:
            return SHARE_CALENDAR_EVENT;
        L28:
            return MEDIA;
        L30:
            return CARD;
        L32:
            return CALENDAR;
        L34:
            return MERGE_FORWARD;
        L36:
            return STICKER;
        L38:
            return SHARE_GROUP_CHAT;
        L40:
            return EMAIL;
        L42:
            return AUDIO;
        L44:
            return SYSTEM;
        L46:
            return IMAGE;
        L48:
            return TEXT;
        L50:
            return FILE;
        L52:
            return POST;
        L54:
            return TEXT_IMAGE;
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

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Type.values().length];
            a = r0;
            r0[Type.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            a[Type.MEDIA.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            a[Type.FILE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            a[Type.FOLDER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            a[Type.MERGE_FORWARD.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            a[Type.TEXT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            a[Type.POST.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public static class b {
        public String a;
        public Long b;
        public String c;
        public Type d;
        public int e;

        public b() {
            this.b = null;
            this.e = PluginList.LEVEL_NOT_SET;
        }
    }

    public boolean canShow() {
        if (this.isRemoved == false) goto L5;
    L9:
        return false;
    L5:
        if (this.isVisible == false) goto L9;
        if (this.isBurned == true) goto L9;
        return true;
    }

    public List<String> getAuthFileKeys() {
        ArrayList r0 = new ArrayList();
        if ((getContent() instanceof BaseFileContent) == false) goto L8;
        String r1 = ((BaseFileContent) getContent()).getKey();
        if (TextUtils.isEmpty(r1) == true) goto L33;
        r0.add(r1);
    L33:
        return r0;
    L8:
        if ((getContent() instanceof ImageContent) == false) goto L17;
        ImageSet r2 = ((ImageContent) getContent()).getImageSet();
        if (r2 == null) goto L33;
        if (r2.getOrigin() == null) goto L33;
        String r3 = r2.getOrigin().getKey();
        if (TextUtils.isEmpty(r3) == true) goto L33;
        r0.add(r3);
        goto L33
    L17:
        if ((getContent() instanceof MediaContent) == false) goto L22;
        String r4 = ((MediaContent) getContent()).getKey();
        if (TextUtils.isEmpty(r4) == true) goto L33;
        r0.add(r4);
        goto L33
    L22:
        if ((getContent() instanceof BaseTextContent) == false) goto L33;
        BaseTextContent r5 = (BaseTextContent) getContent();
        r0.addAll(i.k(r5.getRichText()));
        if (CollectionUtils.isEmpty(r5.getAttachments()) == true) goto L33;
        Iterator<File> r6 = r5.getAttachments().iterator();
    L27:
        if (r6.hasNext() == false) goto L33;
        File r7 = r6.next();
        if (r7 == null) goto L27;
        if (TextUtils.isEmpty(r7.key) == true) goto L27;
        r0.add(r7.key);
        goto L27
    }

    public MessageType getMessageType() {
        Type r0 = this.type;
        if (r0 != null) goto L7;
        return MessageType.UNKNOWN;
    L7:
        return MessageType.forNumber(Type.access$000(r0));
    }

    public SendStatus getSendStatus() {
        SendStatus r0 = this.sendStatus;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return SendStatus.SUCCESS;
    }

    public int hashCode() {
        String r0 = this.id;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.chatId;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.cId;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public boolean isMeRead() {
        if (this.mMeReadType <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isMessageDisable() {
        if (this.isRemoved == false) goto L5;
    L10:
        return true;
    L5:
        if (this.status == Status.DELETED) goto L10;
        if (this.isVisible == false) goto L10;
        return false;
    }

    public boolean isPreMessage() {
        return TextUtils.equals(this.id, this.cId);
    }

    public boolean isRecalled() {
        if (this.status != Status.DELETED) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isReplyInThreadChildMessage() {
        if (TextUtils.isEmpty(this.threadId) == false) goto L5;
    L7:
        return false;
    L5:
        if (this.threadMessageType != ThreadMessageType.THREAD_REPLY_MESSAGE) goto L7;
        return true;
    }

    public boolean isReplyInThreadRootMessage() {
        if (TextUtils.isEmpty(this.threadId) == false) goto L5;
    L7:
        return false;
    L5:
        if (this.threadMessageType != ThreadMessageType.THREAD_ROOT_MESSAGE) goto L7;
        return true;
    }

    public boolean isSecret() {
        if (this.burnLife <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isSecretEncrypted() {
        return !TextUtils.isEmpty(this.cryptoToken);
    }

    public boolean isSourceFileDelete() {
        if (this.isSourceFileDelete == false) goto L5;
    L8:
        return true;
    L5:
        if (this.isStaticResourceMessageRecalled == true) goto L8;
        return false;
    }

    public boolean isThreadTopic() {
        if (TextUtils.isEmpty(this.threadId) == false) goto L5;
    L7:
        return false;
    L5:
        if (this.threadMessageType != ThreadMessageType.UNKNOWN_THREAD_MESSAGE) goto L7;
        return true;
    }

    public boolean isTranslatedByDisplayRule() {
        int r0 = this.translateDisplayRule;
        if (r0 == 1) goto L6;
        if (r0 == 0) goto L6;
        return true;
    L6:
        return false;
    }

    public boolean needAuth() {
        switch(a.a[this.type.ordinal()]) {
            case 1: goto L15;
            case 2: goto L15;
            case 3: goto L15;
            case 4: goto L15;
            case 5: goto L15;
            case 6: goto L5;
            case 7: goto L5;
            default: goto L18;
        };
    L5:
        BaseTextContent r0 = (BaseTextContent) getContent();
        RichText r2 = r0.getRichText();
        if (r2 == null) goto L14;
        List r3 = r2.getImageIds();
        List r4 = r2.getMediaIds();
        if (CollectionUtils.isEmpty(r3) == true) goto L11;
        return true;
    L11:
        if (CollectionUtils.isEmpty(r4) == true) goto L14;
        return true;
    L14:
        if (CollectionUtils.isEmpty(r0.getAttachments()) == false) goto L15;
        return false;
    L15:
        return true;
    L18:
        return false;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("Message{type=");
        r0.append(getType());
        r0.append(" cId=");
        r0.append(this.cId);
        r0.append(" id=");
        r0.append(this.id);
        r0.append(" cTime=");
        r0.append(this.createTime);
        r0.append(" uTime=");
        r0.append(this.updateTime);
        r0.append(" fromId=");
        r0.append(this.fromId);
        r0.append(" fromChatterTenantId=");
        r0.append(this.fromChatterTenantId);
        r0.append(" isFromMe");
        r0.append(this.isFromMe);
        r0.append(" position=");
        r0.append(this.position);
        r0.append(" badgeCount=");
        r0.append(this.badgeCount);
        r0.append(" status=");
        r0.append(this.status);
        r0.append(" chatId=");
        r0.append(this.chatId);
        r0.append(" parentId=");
        r0.append(this.parentId);
        r0.append(" isDing=");
        r0.append(this.isDing);
        r0.append(" isVisible=");
        r0.append(this.isVisible);
        r0.append(" isBurned=");
        r0.append(this.isBurned);
        r0.append(" meRead=");
        r0.append(this.mMeReadType);
        r0.append(" read=");
        r0.append(this.readCount);
        r0.append(" unRead=");
        r0.append(this.unReadCount);
        r0.append(" reply=");
        r0.append(this.replyCount);
        r0.append(" sendStatus=");
        r0.append(this.sendStatus);
        r0.append(" burnTime=");
        r0.append(this.burnTime);
        r0.append(" syncDependency=");
        r0.append(this.isSyncMsgDep);
        r0.append(" isFlag=");
        r0.append(this.isFlag);
        r0.append(" dlpState=");
        r0.append(this.dlpState);
        r0.append(" validateIMFileResult=");
        r0.append(this.validateIMFileResult);
        r0.append(" FileDeletedStatus=");
        r0.append(this.fileDeletedStatus);
        r0.append(" foldId=");
        r0.append(this.foldId);
        r0.append(" isRestricted=");
        r0.append(this.isRestricted);
        r0.append(" setGrey=");
        r0.append(this.setGrey);
        r0.append(" disabledAction=");
        r0.append(this.disabledAction);
        r0.append(" update=");
        r0.append(this.updateTime);
        r0.append(" secretMessageDecryptedFailed=");
        r0.append(this.isSecretChatDecryptedFailed);
        Content r1 = this.messageContent;
        if (r1 != null) goto L5;
    L10:
        r0.append(" chatDisplayModeSetting=");
        r0.append(this.chatDisplayModeSetting);
        r0.append(" streamStatus=");
        r0.append(this.streamStatus);
        r0.append(" aiMessageType=");
        com.bytedance.lark.pb.basic.v1.Message.AIMessageType r2 = this.aiMessageType;
        if (r2 == null) goto L13;
        Integer r3 = Integer.valueOf(r2.getValue());
    L14:
        r0.append(r3);
        r0.append(" hasFollowUP=");
        r0.append(this.hasFollowUP);
        r0.append("}");
        return r0.toString();
    L13:
        r3 = null;
        goto L14
    L5:
        if (r1.toString().startsWith(this.messageContent.getClass().getName()) == true) goto L8;
        r0.append(" content=");
        r0.append(this.messageContent.toString());
    L8:
        if ((this.messageContent instanceof ImageContent) == false) goto L10;
        r0.append(" ImageContent content=");
        r0.append(((ImageContent) this.messageContent).getRiskObjectKeys());
        goto L10
    }

    public Message() {
        this.isShared = false;
        this.isVisible = true;
        this.isEphemeral = false;
        this.fileDeletedStatus = FileDeletedStatus.NORMAL;
        this.mMeReadType = 0;
        this.sendStatus = SendStatus.SUCCESS;
        this.originalSenderId = BuildConfig.FLAVOR;
        this.readAtChatterIds = new ArrayList();
        this.atBotIds = new ArrayList();
        this.burnLife = -1;
        this.cryptoToken = null;
        this.isSecretChatDecryptedFailed = false;
        this.isDeCryptFailed = false;
        this.createTimeInMills = 0;
        this.editInfo = new MessageEditInfo();
        this.foldId = BuildConfig.FLAVOR;
        this.isCleaned = false;
        this.chatDisplayModeSetting = ChatDisplayModeSetting.UNKNOWN;
        this.validateIMFileResult = null;
        this.streamStatus = MessageStreamStatus.Unknown;
        this.aiChatModeId = 0;
        this.syncToChatThreadRootId = 0;
        this.syncToChatRelatedMessageId = 0;
        this.isNewTopic = false;
        this.appInfoItemName = null;
        this.senderAppInfo = null;
        this.displayPolicy = null;
        this.hasFollowUP = true;
    }

    public Message clone() {
        Message r0 = (Message) super.clone();     // Catch: CloneNotSupportedException -> L6
        if ((r0.getContent() instanceof MergeForwardContent) == false) goto L5;
        r0.setMessageContent(((MergeForwardContent) r0.getContent()).clone());     // Catch: CloneNotSupportedException -> L6
    L5:
        return r0;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public boolean isMultiResourceAuth() {
        if (getAuthFileKeys().size() > 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isReEditable() {
        if (getStatus() == Status.DELETED) goto L5;
    L7:
        return false;
    L5:
        if (this.isReEditable == false) goto L7;
        return true;
    }

    public boolean canShowAiProcess() {
        return this.canShowAiProcess;
    }

    public com.bytedance.lark.pb.basic.v1.Message.AIMessageLikeFeedbackStatus getAIMessageLikeFeedbackStatus() {
        return this.aiMessageLikeFeedbackStatus;
    }

    public String getAiAnswerRawData() {
        return this.aiAnswerRawData;
    }

    public long getAiChatModeId() {
        return this.aiChatModeId;
    }

    public AIInfo getAiInfo() {
        return this.aiInfo;
    }

    public com.bytedance.lark.pb.basic.v1.Message.AIMessageType getAiMessageType() {
        return this.aiMessageType;
    }

    public AISmartReply getAiSmartReply() {
        return this.aiSmartReply;
    }

    public MessageAnalysisConfig getAnalysisConfigs() {
        return this.analysisConfigs;
    }

    public String getAppInfoItemName() {
        return this.appInfoItemName;
    }

    public List<String> getAtBotIds() {
        return this.atBotIds;
    }

    public int getBadgeCount() {
        return this.badgeCount;
    }

    public int getBurnLife() {
        return this.burnLife;
    }

    public long getBurnTime() {
        return this.burnTime;
    }

    public Channel getChannel() {
        return this.channel;
    }

    public int getCharacterLength() {
        return this.characterLength;
    }

    public ChatDisplayModeSetting getChatDisplayModeSetting() {
        return this.chatDisplayModeSetting;
    }

    public String getChatId() {
        return this.chatId;
    }

    @Override // p5b.b
    public <T extends Content> T getContent() {
        return (T) this.messageContent;
    }

    public int getContentVersion() {
        return this.contentVersion;
    }

    public CotContent getCotContent() {
        return this.cotContent;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public long getCreateTimeInMills() {
        return this.createTimeInMills;
    }

    public String getCryptoToken() {
        return this.cryptoToken;
    }

    public Map<Integer, com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Behavior> getDisabledAction() {
        return this.disabledAction;
    }

    public MessageSourceDisplayPolicy getDisplayPolicy() {
        return this.displayPolicy;
    }

    public MessageDLPState getDlpState() {
        return this.dlpState;
    }

    public MessageEditInfo getEditInfo() {
        return this.editInfo;
    }

    public Map<Class<?>, Object> getExtras() {
        return this.extras;
    }

    public FileDeletedStatus getFileDeletedStatus() {
        return this.fileDeletedStatus;
    }

    public String getFoldId() {
        return this.foldId;
    }

    public String getFromChatterTenantId() {
        return this.fromChatterTenantId;
    }

    public String getFromId() {
        return this.fromId;
    }

    public FromType getFromType() {
        return this.fromType;
    }

    public String getId() {
        return this.id;
    }

    public Map<String, ImageTranslationAbility> getImageTranslationAbility() {
        return this.imageTranslationAbility;
    }

    public int getMeReadType() {
        return this.mMeReadType;
    }

    public <T extends uxb.b> T getMessageContent() {
        return this.messageContent;
    }

    public String getMessageLanguage() {
        return this.messageLanguage;
    }

    public LinkedHashMap<String, com.bytedance.lark.pb.basic.v1.MessageLink> getMessageLinkMap() {
        return this.messageLinkMap;
    }

    public HashMap<Integer, String> getMessageLocalDataInfoMap() {
        return this.messageLocalDataInfoMap;
    }

    public int getOriginBadgeCount() {
        return this.originBadgeCount;
    }

    public String getOriginalSenderId() {
        return this.originalSenderId;
    }

    public String getParentId() {
        return this.parentId;
    }

    public String getParentSourceId() {
        return this.parentSourceId;
    }

    public PartialReplyInfo getPartialReplyInfo() {
        return this.partialReplyInfo;
    }

    public int getPosition() {
        return this.position;
    }

    public String getPostDraftId() {
        return this.postDraftId;
    }

    public String getPreprocessKey() {
        return this.preprocessKey;
    }

    public List<String> getReadAtChatterIds() {
        return this.readAtChatterIds;
    }

    public int getReadCount() {
        return this.readCount;
    }

    public String getRecallerId() {
        return this.recallerId;
    }

    public RecallerIdentity getRecallerIdentity() {
        return this.recallerIdentity;
    }

    public int getReplyCount() {
        return this.replyCount;
    }

    public String getReplyInThreadDraftId() {
        return this.replyInThreadDraftId;
    }

    public String getRootId() {
        return this.rootId;
    }

    public String getScheduleDraftId() {
        return this.scheduleDraftId;
    }

    public MessageSecurityESCReviewExtra getSecurityESCReviewExtra() {
        return this.securityESCReviewExtra;
    }

    public MessageSenderAppInfo getSenderAppInfo() {
        return this.senderAppInfo;
    }

    public String getSourceId() {
        return this.sourceId;
    }

    public SourceType getSourceType() {
        return this.sourceType;
    }

    public Status getStatus() {
        return this.status;
    }

    public long getStreamSequenceId() {
        return this.streamSequenceId;
    }

    public MessageStreamStatus getStreamStatus() {
        return this.streamStatus;
    }

    public SyncToChatMessageType getSyncToChatMessageType() {
        return this.syncToChatMessageType;
    }

    public long getSyncToChatRelatedMessageId() {
        return this.syncToChatRelatedMessageId;
    }

    public long getSyncToChatThreadRootId() {
        return this.syncToChatThreadRootId;
    }

    public String getTextDraftId() {
        return this.textDraftId;
    }

    public int getThreadBadgeCount() {
        return this.threadBadgeCount;
    }

    public String getThreadId() {
        return this.threadId;
    }

    public ThreadMessageType getThreadMessageType() {
        return this.threadMessageType;
    }

    public int getThreadPosition() {
        return this.threadPosition;
    }

    @Override // p5b.b
    public int getTranslateDisplayRule() {
        return this.translateDisplayRule;
    }

    public String getTranslateLanguage() {
        return this.translateLanguage;
    }

    public Type getType() {
        return this.type;
    }

    public int getUnReadCount() {
        return this.unReadCount;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public ValidateIMFileResult getValidateIMFileResult() {
        return this.validateIMFileResult;
    }

    public String getcId() {
        return this.cId;
    }

    public boolean isAtAll() {
        return this.isAtAll;
    }

    public boolean isAtMe() {
        return this.isAtMe;
    }

    public boolean isAutoTranslatedForReceiver() {
        return this.isAutoTranslatedForReceiver;
    }

    public boolean isBadged() {
        return this.isBadged;
    }

    public boolean isBurned() {
        return this.isBurned;
    }

    public boolean isCleaned() {
        return this.isCleaned;
    }

    public boolean isCryptoIntermediate() {
        return this.isCryptoIntermediate;
    }

    public boolean isDecryptFailed() {
        return this.isDeCryptFailed;
    }

    public boolean isDing() {
        return this.isDing;
    }

    public boolean isEphemeral() {
        return this.isEphemeral;
    }

    public boolean isFlag() {
        return this.isFlag;
    }

    public boolean isForwardFromFriend() {
        return this.isForwardFromFriend;
    }

    public boolean isFromMe() {
        return this.isFromMe;
    }

    public boolean isHasFollowUP() {
        return this.hasFollowUP;
    }

    public boolean isIncludeDocUrl() {
        return this.isIncludeDocUrl;
    }

    public boolean isNewTopic() {
        return this.isNewTopic;
    }

    public boolean isNoTraceDelete() {
        return this.isNoTraceDelete;
    }

    public boolean isNotified() {
        return this.isNotified;
    }

    public boolean isOnTimeDel() {
        return this.isOnTimeDel;
    }

    public boolean isOtherAtMe() {
        return this.isOtherAtMe;
    }

    public boolean isRemoved() {
        return this.isRemoved;
    }

    public boolean isRestricted() {
        return this.isRestricted;
    }

    public boolean isSecretChatDecryptedFailed() {
        return this.isSecretChatDecryptedFailed;
    }

    public boolean isSetGrey() {
        return this.setGrey;
    }

    public boolean isShared() {
        return this.isShared;
    }

    public boolean isSyncMsgDep() {
        return this.isSyncMsgDep;
    }

    public boolean isThreadForwardRootMessage() {
        return this.isThreadForwardRootMessage;
    }

    public boolean isTranslatedManually() {
        return this.isTranslatedManually;
    }

    public boolean isUntranslatable() {
        return this.isUntranslatable;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m516clone() throws CloneNotSupportedException {
        return clone();
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Message r8) {
        if (r8 != null) goto L5;
    L25:
        return 0;
    L5:
        if (getPosition() >= r8.getPosition()) goto L8;
        return -1;
    L8:
        if (getPosition() <= r8.getPosition()) goto L11;
        return 1;
    L11:
        if (getPosition() != r8.getPosition()) goto L25;
        if (isPreMessage() != r8.isPreMessage()) goto L22;
        long r1 = getCreateTime();
        long r5 = r8.getCreateTime();
        if (r1 >= r5) goto L17;
        return -1;
    L17:
        if (r1 == r5) goto L27;
        return 1;
    L27:
        return 0;
    L22:
        if (isPreMessage() == false) goto L28;
        return 1;
    L28:
        return -1;
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if (r4 != null) goto L8;
    L31:
        return false;
    L8:
        if (getClass() != r4.getClass()) goto L31;
        Message r5 = (Message) r4;
        if (Objects.equals(this.id, r5.id) == true) goto L14;
        return false;
    L14:
        if (Objects.equals(this.chatId, r5.chatId) == true) goto L17;
        return false;
    L17:
        if (Objects.equals(this.translateLanguage, r5.translateLanguage) == true) goto L20;
        return false;
    L20:
        if (Objects.equals(Integer.valueOf(this.translateDisplayRule), Integer.valueOf(r5.translateDisplayRule)) == true) goto L22;
        return false;
    L22:
        Type r1 = this.type;
        Type r2 = Type.MERGE_FORWARD;
        if (r1 != r2) goto L30;
        if (r5.type != r2) goto L30;
        if (((MergeForwardContent) this.messageContent).equals((MergeForwardContent) r5.messageContent) == true) goto L30;
        return false;
    L30:
        return Objects.equals(this.cId, r5.cId);
    }

    public boolean exactlyCompare(Message r5) {
        boolean r0 = equals(r5);
        if (r0 == true) goto L6;
        return false;
    L6:
        if (r5.isRemoved() == false) goto L9;
        return false;
    L9:
        if (this.mMeReadType == r5.getMeReadType()) goto L12;
        return false;
    L12:
        if (getStatus() != null) goto L14;
    L20:
        return false;
    L14:
        if (r5.getStatus() == null) goto L20;
        if (getStatus().getNumber() == r5.getStatus().getNumber()) goto L19;
        return false;
    L19:
        return r0;
    }

    public boolean isContentSame(Message r10) {
        if (this.type == r10.getType()) goto L6;
        return false;
    L6:
        if (getStatus() == r10.getStatus()) goto L8;
        return false;
    L8:
        boolean r1 = true;
        if (this.isRemoved == false) goto L14;
        if (r10.isRemoved == false) goto L14;
        return true;
    L14:
        if (getStatus() != Status.DELETED) goto L20;
        if (this.isReEditable != r10.isReEditable) goto L109;
        return true;
    L109:
        return false;
    L20:
        if (getSendStatus() == r10.getSendStatus()) goto L23;
        return false;
    L23:
        if (this.readCount == r10.getReadCount()) goto L25;
    L100:
        return false;
    L25:
        if (this.unReadCount != r10.getUnReadCount()) goto L100;
        if (this.replyCount == r10.getReplyCount()) goto L31;
        return false;
    L31:
        if (getUpdateTime() == r10.getUpdateTime()) goto L34;
        return false;
    L34:
        if (this.isFlag == r10.isFlag()) goto L37;
        return false;
    L37:
        if (this.isRestricted == r10.isRestricted()) goto L40;
        return false;
    L40:
        if (this.setGrey == r10.isSetGrey()) goto L43;
        return false;
    L43:
        if (this.validateIMFileResult == r10.validateIMFileResult) goto L45;
        return false;
    L45:
        HashMap<Integer, com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Behavior> r0 = this.disabledAction;
        HashMap<Integer, com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Behavior> r3 = r10.disabledAction;
        if (r0 != null) goto L49;
        if (r3 != null) goto L49;
    L67:
        if (r1 == true) goto L70;
        return false;
    L70:
        if (this.isSecretChatDecryptedFailed == r10.isSecretChatDecryptedFailed) goto L73;
        return false;
    L73:
        if (TextUtils.equals(getMessageLanguage(), r10.getMessageLanguage()) == false) goto L100;
        if (TextUtils.equals(getTranslateLanguage(), r10.getTranslateLanguage()) == false) goto L100;
        if (getTranslateDisplayRule() != r10.getTranslateDisplayRule()) goto L100;
        if (isAutoTranslatedForReceiver() != r10.isAutoTranslatedForReceiver()) goto L100;
        if (isTranslatedManually() != r10.isTranslatedManually()) goto L100;
        if (y28.a.c(getContent(), r10.getContent()) == true) goto L87;
        return false;
    L87:
        if (Objects.equals(this.streamStatus, r10.streamStatus) == true) goto L90;
        return false;
    L90:
        if (this.streamSequenceId == r10.streamSequenceId) goto L93;
        return false;
    L93:
        if (this.aiMessageLikeFeedbackStatus == r10.aiMessageLikeFeedbackStatus) goto L96;
        return false;
    L96:
        if (this.hasFollowUP == r10.hasFollowUP) goto L99;
        return false;
    L99:
        return y28.a.c(this.aiSmartReply, r10.aiSmartReply);
    L49:
        if (r0 == null) goto L66;
        if (r3 == null) goto L66;
        if (r0.size() != r3.size()) goto L66;
        Iterator<Integer> r4 = r0.keySet().iterator();
    L57:
        if (r4.hasNext() == false) goto L67;
        Integer r5 = r4.next();
        com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Behavior r6 = r0.get(r5);
        com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Behavior r7 = r3.get(r5);
        if (r6 == null) goto L57;
        if (r7 == null) goto L66;
        if (r6.display_mode != r7.display_mode) goto L66;
        if (r6.code.equals(r7.code) == true) goto L57;
    L66:
        r1 = false;
        goto L67
    }

    public boolean isItemSame(Message r2) {
        if (this != r2) goto L6;
        return true;
    L6:
        return this.cId.equals(r2.getcId());
    }

    public void setAIMessageLikeFeedbackStatus(com.bytedance.lark.pb.basic.v1.Message.AIMessageLikeFeedbackStatus r1) {
        this.aiMessageLikeFeedbackStatus = r1;
    }

    public void setAiAnswerRawData(String r1) {
        this.aiAnswerRawData = r1;
    }

    public void setAiChatModeId(long r1) {
        this.aiChatModeId = r1;
    }

    public void setAiInfo(AIInfo r1) {
        this.aiInfo = r1;
    }

    public void setAiMessageType(com.bytedance.lark.pb.basic.v1.Message.AIMessageType r1) {
        this.aiMessageType = r1;
    }

    public void setAiSmartReply(AISmartReply r1) {
        this.aiSmartReply = r1;
    }

    public void setAnalysisConfigs(MessageAnalysisConfig r1) {
        this.analysisConfigs = r1;
    }

    public void setAppInfoItemName(String r1) {
        this.appInfoItemName = r1;
    }

    public void setAtAll(boolean r1) {
        this.isAtAll = r1;
    }

    public void setAtBotIds(List<String> r2) {
        CollectionUtils.resetToList(this.atBotIds, r2);
    }

    public void setAtMe(boolean r1) {
        this.isAtMe = r1;
    }

    public void setAutoTranslatedForReceiver(boolean r1) {
        this.isAutoTranslatedForReceiver = r1;
    }

    public void setBadgeCount(int r1) {
        this.badgeCount = r1;
    }

    public void setBadged(boolean r1) {
        this.isBadged = r1;
    }

    public void setBurnLife(int r1) {
        this.burnLife = r1;
    }

    public void setBurnTime(long r1) {
        this.burnTime = r1;
    }

    public void setBurned(boolean r1) {
        this.isBurned = r1;
    }

    public void setCanShowAiProcess(boolean r1) {
        this.canShowAiProcess = r1;
    }

    public void setChannel(Channel r1) {
        this.channel = r1;
    }

    public void setCharacterLength(int r1) {
        this.characterLength = r1;
    }

    public void setChatDisplayModeSetting(ChatDisplayModeSetting r1) {
        this.chatDisplayModeSetting = r1;
    }

    public void setChatId(String r1) {
        this.chatId = r1;
    }

    public void setCleaned(boolean r1) {
        this.isCleaned = r1;
    }

    public void setContentVersion(int r1) {
        this.contentVersion = r1;
    }

    public void setCotContent(CotContent r1) {
        this.cotContent = r1;
    }

    public void setCreateTime(long r1) {
        this.createTime = r1;
    }

    public void setCreateTimeInMills(long r1) {
        this.createTimeInMills = r1;
    }

    public void setCryptoToken(String r1) {
        this.cryptoToken = r1;
    }

    public void setDeCryptFailed(boolean r1) {
        this.isDeCryptFailed = r1;
    }

    public void setDing(boolean r1) {
        this.isDing = r1;
    }

    public void setDisabledAction(Map<Integer, com.bytedance.lark.pb.basic.v1.Message.DisabledAction.Behavior> r2) {
        if (r2 == null) goto L5;
        this.disabledAction = new HashMap(r2);
        return;
    }

    public void setDisplayPolicy(MessageSourceDisplayPolicy r1) {
        this.displayPolicy = r1;
    }

    public void setDlpState(MessageDLPState r1) {
        this.dlpState = r1;
    }

    public void setEditInfo(MessageEditInfo r1) {
        this.editInfo = r1;
    }

    public void setEphemeral(boolean r1) {
        this.isEphemeral = r1;
    }

    public void setFileDeletedStatus(FileDeletedStatus r1) {
        this.fileDeletedStatus = r1;
    }

    public void setFlag(boolean r1) {
        this.isFlag = r1;
    }

    public void setFoldId(String r1) {
        this.foldId = r1;
    }

    public void setForwardFromFriend(boolean r1) {
        this.isForwardFromFriend = r1;
    }

    public void setFromChatterTenantId(String r1) {
        this.fromChatterTenantId = r1;
    }

    public void setFromId(String r1) {
        this.fromId = r1;
    }

    public void setFromType(FromType r1) {
        this.fromType = r1;
    }

    public void setGrey(boolean r1) {
        this.setGrey = r1;
    }

    public void setHasFollowUP(boolean r1) {
        this.hasFollowUP = r1;
    }

    public void setId(String r1) {
        this.id = r1;
    }

    public void setImageTranslationAbility(Map<String, ImageTranslationAbility> r1) {
        this.imageTranslationAbility = r1;
    }

    public void setIncludeDocUrl(boolean r1) {
        this.isIncludeDocUrl = r1;
    }

    public void setIsCryptoIntermediate(boolean r1) {
        this.isCryptoIntermediate = r1;
    }

    public void setIsFromMe(boolean r1) {
        this.isFromMe = r1;
    }

    public void setIsRestricted(boolean r1) {
        this.isRestricted = r1;
    }

    public void setIsSyncMsgDep(boolean r1) {
        this.isSyncMsgDep = r1;
    }

    public void setIsUnTranslatable(boolean r1) {
        this.isUntranslatable = r1;
    }

    public void setMeReadType(int r1) {
        this.mMeReadType = r1;
    }

    public void setMessageContent(Content r1) {
        this.messageContent = r1;
    }

    public void setMessageLanguage(String r1) {
        this.messageLanguage = r1;
    }

    public void setMessageLinkMap(LinkedHashMap<String, com.bytedance.lark.pb.basic.v1.MessageLink> r1) {
        this.messageLinkMap = r1;
    }

    public void setMessageLocalDataInfoMap(HashMap<Integer, String> r1) {
        this.messageLocalDataInfoMap = r1;
    }

    public void setMessageType(MessageType r1) {
        setType(Type.forNumber(r1.getNumber()));
    }

    public void setNewTopic(boolean r1) {
        this.isNewTopic = r1;
    }

    public void setNoTraceDelete(boolean r1) {
        this.isNoTraceDelete = r1;
    }

    public void setNotified(boolean r1) {
        this.isNotified = r1;
    }

    public void setOnTimeDel(boolean r1) {
        this.isOnTimeDel = r1;
    }

    public void setOriginBadgeCount(int r1) {
        this.originBadgeCount = r1;
    }

    public void setOriginalSenderId(String r1) {
        this.originalSenderId = r1;
    }

    public void setOtherAtMe(boolean r1) {
        this.isOtherAtMe = r1;
    }

    public void setParentId(String r1) {
        this.parentId = r1;
    }

    public void setParentSourceId(String r1) {
        this.parentSourceId = r1;
    }

    public void setPartialReplyInfo(PartialReplyInfo r1) {
        this.partialReplyInfo = r1;
    }

    public void setPosition(int r1) {
        this.position = r1;
    }

    public void setPostDraftId(String r1) {
        this.postDraftId = r1;
    }

    public void setPreprocessKey(String r1) {
        this.preprocessKey = r1;
    }

    public void setReEditable(boolean r1) {
        this.isReEditable = r1;
    }

    public void setReadAtChatterIds(List<String> r1) {
        this.readAtChatterIds = r1;
    }

    public void setReadCount(int r1) {
        this.readCount = r1;
    }

    public void setRecallerId(String r1) {
        this.recallerId = r1;
    }

    public void setRecallerIdentity(RecallerIdentity r1) {
        this.recallerIdentity = r1;
    }

    public void setRemoved(boolean r1) {
        this.isRemoved = r1;
    }

    public void setReplyCount(int r1) {
        this.replyCount = r1;
    }

    public void setReplyInThreadDraftId(String r1) {
        this.replyInThreadDraftId = r1;
    }

    public void setRootId(String r1) {
        this.rootId = r1;
    }

    public void setScheduleDraftId(String r1) {
        this.scheduleDraftId = r1;
    }

    public void setSecretChatDecryptedFailed(boolean r1) {
        this.isSecretChatDecryptedFailed = r1;
    }

    public void setSecurityESCReviewExtra(MessageSecurityESCReviewExtra r1) {
        this.securityESCReviewExtra = r1;
    }

    public void setSendStatus(SendStatus r1) {
        this.sendStatus = r1;
    }

    public void setSenderAppInfo(MessageSenderAppInfo r1) {
        this.senderAppInfo = r1;
    }

    public void setShared(boolean r1) {
        this.isShared = r1;
    }

    public void setSourceFileDelete(boolean r1) {
        this.isSourceFileDelete = r1;
    }

    public void setSourceId(String r1) {
        this.sourceId = r1;
    }

    public void setSourceType(SourceType r1) {
        this.sourceType = r1;
    }

    public void setStatus(Status r1) {
        this.status = r1;
    }

    public void setStreamSequenceId(long r1) {
        this.streamSequenceId = r1;
    }

    public void setStreamStatus(MessageStreamStatus r1) {
        this.streamStatus = r1;
    }

    public void setSyncToChatMessageType(SyncToChatMessageType r1) {
        this.syncToChatMessageType = r1;
    }

    public void setSyncToChatRelatedMessageId(long r1) {
        this.syncToChatRelatedMessageId = r1;
    }

    public void setSyncToChatThreadRootId(long r1) {
        this.syncToChatThreadRootId = r1;
    }

    public void setTextDraftId(String r1) {
        this.textDraftId = r1;
    }

    public void setThreadBadgeCount(int r1) {
        this.threadBadgeCount = r1;
    }

    public void setThreadForwardRootMessage(boolean r1) {
        this.isThreadForwardRootMessage = r1;
    }

    public void setThreadId(String r1) {
        this.threadId = r1;
    }

    public void setThreadMessageType(ThreadMessageType r1) {
        this.threadMessageType = r1;
    }

    public void setThreadPosition(int r1) {
        this.threadPosition = r1;
    }

    public void setTranslateDisplayRule(int r1) {
        this.translateDisplayRule = r1;
    }

    public void setTranslateLanguage(String r1) {
        this.translateLanguage = r1;
    }

    public void setTranslatedManually(boolean r1) {
        this.isTranslatedManually = r1;
    }

    public void setType(Type r1) {
        this.type = r1;
    }

    public void setUnReadCount(int r1) {
        this.unReadCount = r1;
    }

    public void setUpdateTime(long r1) {
        this.updateTime = r1;
    }

    public void setValidateIMFileResult(ValidateIMFileResult r1) {
        this.validateIMFileResult = r1;
    }

    public void setVisible(boolean r1) {
        this.isVisible = r1;
    }

    public void setcId(String r1) {
        this.cId = r1;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Message r1) {
        return compareTo2(r1);
    }

    public /* bridge */ /* synthetic */ boolean isContentSame(y28.b r1) {
        return isContentSame((Message) r1);
    }

    public /* bridge */ /* synthetic */ boolean isItemSame(y28.b r1) {
        return isItemSame((Message) r1);
    }

    public <T> void putExtra(Class<T> r2, T r3) {
        if (this.extras != null) goto L5;
        this.extras = new HashMap();
    L5:
        this.extras.put(r2, r3);
    }

    public AuthorityParam toAuthorityParam(String r6, String r7) {
        AuthorityParam.a r0 = new AuthorityParam.a();
        r0.a = getId();
        String r1 = getFromId();
        int r2 = AuthorityParam.j;
        AuthorityParam.Companion.AuthScene r3 = AuthorityParam.Companion.AuthScene.IM_FILE_LIST_AUTH;
        r0.d = Long.valueOf(AuthorityParam.Companion.a(r1, r3));
        r0.c = Long.valueOf(AuthorityParam.Companion.a(getFromChatterTenantId(), r3));
        r0.f = AuthorityParam.Companion.a(r6, r3);
        r0.e = AuthorityParam.Companion.a(r7, r3);
        AuthorityParam.AuthorityExtraParam r8 = new AuthorityParam.AuthorityExtraParam(isPreMessage(), isFromMe(), isMultiResourceAuth());
        Intrinsics.checkNotNullParameter(r8, "authorityExtraParam");
        r0.i = r8;
        r0.b = this.chatId;
        List<String> r9 = getAuthFileKeys();
        Intrinsics.checkNotNullParameter(r9, "fileKeys");
        r0.h = r9;
        return r0.a();
    }
}
