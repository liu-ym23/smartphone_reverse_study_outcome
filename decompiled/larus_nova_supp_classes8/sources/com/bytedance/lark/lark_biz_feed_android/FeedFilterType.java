package com.bytedance.lark.lark_biz_feed_android;

import com.bytedance.android.livesdk.dsl.api.DSLType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001f\b\u0086\u0081\u0002\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001$B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#¨\u0006%"}, d2 = {"Lcom/bytedance/lark/lark_biz_feed_android/FeedFilterType;", "", "(Ljava/lang/String;I)V", "into", "Llark_biz_feed/proto/FeedFilterType;", "intoInt", "", DSLType.Unknown, "Inbox", "AtMe", "Unread", "Delayed", "Doc", "P2pChat", "GroupChat", "Bot", "HelpDesk", "TopicGroup", "Done", "CryptoChat", "Message", "Mute", "Group", "Team", "DeprecatedAtMeOnly", "Tag", "Flag", "Thread", "UnreadOverDays", "CalendarGroup", "InstantMeetingGroup", "Collapsed", "AllMessage", "ExpiredFold", "MarkAsDeleted", "MessageWithoutDoubao", "Companion", "lark_biz_feed_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum FeedFilterType extends Enum<FeedFilterType> {
    public static final FeedFilterType AllMessage = null;
    public static final FeedFilterType AtMe = null;
    public static final FeedFilterType Bot = null;
    public static final FeedFilterType CalendarGroup = null;
    public static final FeedFilterType Collapsed = null;
    public static final a Companion = null;
    public static final FeedFilterType CryptoChat = null;
    public static final FeedFilterType Delayed = null;
    public static final FeedFilterType DeprecatedAtMeOnly = null;
    public static final FeedFilterType Doc = null;
    public static final FeedFilterType Done = null;
    public static final FeedFilterType ExpiredFold = null;
    public static final FeedFilterType Flag = null;
    public static final FeedFilterType Group = null;
    public static final FeedFilterType GroupChat = null;
    public static final FeedFilterType HelpDesk = null;
    public static final FeedFilterType Inbox = null;
    public static final FeedFilterType InstantMeetingGroup = null;
    public static final FeedFilterType MarkAsDeleted = null;
    public static final FeedFilterType Message = null;
    public static final FeedFilterType MessageWithoutDoubao = null;
    public static final FeedFilterType Mute = null;
    public static final FeedFilterType P2pChat = null;
    public static final FeedFilterType Tag = null;
    public static final FeedFilterType Team = null;
    public static final FeedFilterType Thread = null;
    public static final FeedFilterType TopicGroup = null;
    public static final FeedFilterType Unknown = null;
    public static final FeedFilterType Unread = null;
    public static final FeedFilterType UnreadOverDays = null;
    public static final /* synthetic */ FeedFilterType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static FeedFilterType a(int r1) {
            switch(r1) {
                case 0: goto L34;
                case 1: goto L62;
                case 2: goto L61;
                case 3: goto L60;
                case 4: goto L59;
                case 5: goto L58;
                case 6: goto L57;
                case 7: goto L56;
                case 8: goto L55;
                case 9: goto L54;
                case 10: goto L53;
                case 11: goto L52;
                case 12: goto L51;
                case 13: goto L50;
                case 14: goto L49;
                case 15: goto L48;
                case 16: goto L47;
                case 17: goto L46;
                case 18: goto L45;
                case 19: goto L44;
                case 20: goto L43;
                case 21: goto L42;
                case 22: goto L41;
                case 23: goto L40;
                case 24: goto L39;
                case 25: goto L38;
                case 26: goto L37;
                case 27: goto L36;
                case 28: goto L35;
                default: goto L4;
            };
        L4:
            throw new RuntimeException("Unmatched primitive enum value: FeedFilterType with ");
        L35:
            return FeedFilterType.MessageWithoutDoubao;
        L36:
            return FeedFilterType.MarkAsDeleted;
        L37:
            return FeedFilterType.ExpiredFold;
        L38:
            return FeedFilterType.AllMessage;
        L39:
            return FeedFilterType.Collapsed;
        L40:
            return FeedFilterType.InstantMeetingGroup;
        L41:
            return FeedFilterType.CalendarGroup;
        L42:
            return FeedFilterType.UnreadOverDays;
        L43:
            return FeedFilterType.Thread;
        L44:
            return FeedFilterType.Flag;
        L45:
            return FeedFilterType.Tag;
        L46:
            return FeedFilterType.DeprecatedAtMeOnly;
        L47:
            return FeedFilterType.Team;
        L48:
            return FeedFilterType.Group;
        L49:
            return FeedFilterType.Mute;
        L50:
            return FeedFilterType.Message;
        L51:
            return FeedFilterType.CryptoChat;
        L52:
            return FeedFilterType.Done;
        L53:
            return FeedFilterType.TopicGroup;
        L54:
            return FeedFilterType.HelpDesk;
        L55:
            return FeedFilterType.Bot;
        L56:
            return FeedFilterType.GroupChat;
        L57:
            return FeedFilterType.P2pChat;
        L58:
            return FeedFilterType.Doc;
        L59:
            return FeedFilterType.Delayed;
        L60:
            return FeedFilterType.Unread;
        L61:
            return FeedFilterType.AtMe;
        L62:
            return FeedFilterType.Inbox;
        L34:
            return FeedFilterType.Unknown;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[FeedFilterType.values().length];
            r0[FeedFilterType.Unknown.ordinal()] = 1;     // Catch: NoSuchFieldError -> L34
        L81:
            r0[FeedFilterType.Inbox.ordinal()] = 2;     // Catch: NoSuchFieldError -> L35
        L93:
            r0[FeedFilterType.AtMe.ordinal()] = 3;     // Catch: NoSuchFieldError -> L36
        L99:
            r0[FeedFilterType.Unread.ordinal()] = 4;     // Catch: NoSuchFieldError -> L37
        L103:
            r0[FeedFilterType.Delayed.ordinal()] = 5;     // Catch: NoSuchFieldError -> L38
        L107:
            r0[FeedFilterType.Doc.ordinal()] = 6;     // Catch: NoSuchFieldError -> L39
        L117:
            r0[FeedFilterType.P2pChat.ordinal()] = 7;     // Catch: NoSuchFieldError -> L40
        L71:
            r0[FeedFilterType.GroupChat.ordinal()] = 8;     // Catch: NoSuchFieldError -> L41
        L83:
            r0[FeedFilterType.Bot.ordinal()] = 9;     // Catch: NoSuchFieldError -> L42
        L85:
            r0[FeedFilterType.HelpDesk.ordinal()] = 10;     // Catch: NoSuchFieldError -> L43
        L95:
            r0[FeedFilterType.TopicGroup.ordinal()] = 11;     // Catch: NoSuchFieldError -> L44
        L111:
            r0[FeedFilterType.Done.ordinal()] = 12;     // Catch: NoSuchFieldError -> L45
        L119:
            r0[FeedFilterType.CryptoChat.ordinal()] = 13;     // Catch: NoSuchFieldError -> L46
        L63:
            r0[FeedFilterType.Message.ordinal()] = 14;     // Catch: NoSuchFieldError -> L47
        L69:
            r0[FeedFilterType.Mute.ordinal()] = 15;     // Catch: NoSuchFieldError -> L48
        L89:
            r0[FeedFilterType.Group.ordinal()] = 16;     // Catch: NoSuchFieldError -> L49
        L97:
            r0[FeedFilterType.Team.ordinal()] = 17;     // Catch: NoSuchFieldError -> L50
        L101:
            r0[FeedFilterType.DeprecatedAtMeOnly.ordinal()] = 18;     // Catch: NoSuchFieldError -> L51
        L109:
            r0[FeedFilterType.Tag.ordinal()] = 19;     // Catch: NoSuchFieldError -> L52
        L67:
            r0[FeedFilterType.Flag.ordinal()] = 20;     // Catch: NoSuchFieldError -> L53
        L75:
            r0[FeedFilterType.Thread.ordinal()] = 21;     // Catch: NoSuchFieldError -> L54
        L77:
            r0[FeedFilterType.UnreadOverDays.ordinal()] = 22;     // Catch: NoSuchFieldError -> L55
        L87:
            r0[FeedFilterType.CalendarGroup.ordinal()] = 23;     // Catch: NoSuchFieldError -> L56
        L105:
            r0[FeedFilterType.InstantMeetingGroup.ordinal()] = 24;     // Catch: NoSuchFieldError -> L57
        L113:
            r0[FeedFilterType.Collapsed.ordinal()] = 25;     // Catch: NoSuchFieldError -> L58
        L115:
            r0[FeedFilterType.AllMessage.ordinal()] = 26;     // Catch: NoSuchFieldError -> L59
        L65:
            r0[FeedFilterType.ExpiredFold.ordinal()] = 27;     // Catch: NoSuchFieldError -> L60
        L79:
            r0[FeedFilterType.MarkAsDeleted.ordinal()] = 28;     // Catch: NoSuchFieldError -> L61
        L91:
            r0[FeedFilterType.MessageWithoutDoubao.ordinal()] = 29;     // Catch: NoSuchFieldError -> L62
        L32:
            a = r0;
        }
    }

    @JvmStatic
    public static final FeedFilterType fromInt(int r1) {
        Companion.getClass();
        return a.a(r1);
    }

    public static EnumEntries<FeedFilterType> getEntries() {
        return b;
    }

    public static FeedFilterType valueOf(String r1) {
        return (FeedFilterType) r27.a.a(FeedFilterType.class, r1);
    }

    public static FeedFilterType[] values() {
        return (FeedFilterType[]) a.clone();
    }

    static {
        FeedFilterType r0 = new FeedFilterType(DSLType.Unknown, 0);
        Unknown = r0;
        FeedFilterType r1 = new FeedFilterType("Inbox", 1);
        Inbox = r1;
        FeedFilterType r3 = new FeedFilterType("AtMe", 2);
        AtMe = r3;
        FeedFilterType r5 = new FeedFilterType("Unread", 3);
        Unread = r5;
        FeedFilterType r7 = new FeedFilterType("Delayed", 4);
        Delayed = r7;
        FeedFilterType r9 = new FeedFilterType("Doc", 5);
        Doc = r9;
        FeedFilterType r11 = new FeedFilterType("P2pChat", 6);
        P2pChat = r11;
        FeedFilterType r13 = new FeedFilterType("GroupChat", 7);
        GroupChat = r13;
        FeedFilterType r15 = new FeedFilterType("Bot", 8);
        Bot = r15;
        FeedFilterType r14 = new FeedFilterType("HelpDesk", 9);
        HelpDesk = r14;
        FeedFilterType r12 = new FeedFilterType("TopicGroup", 10);
        TopicGroup = r12;
        FeedFilterType r10 = new FeedFilterType("Done", 11);
        Done = r10;
        FeedFilterType r8 = new FeedFilterType("CryptoChat", 12);
        CryptoChat = r8;
        FeedFilterType r6 = new FeedFilterType("Message", 13);
        Message = r6;
        FeedFilterType r4 = new FeedFilterType("Mute", 14);
        Mute = r4;
        FeedFilterType r2 = new FeedFilterType("Group", 15);
        Group = r2;
        FeedFilterType r16 = new FeedFilterType("Team", 16);
        Team = r16;
        FeedFilterType r17 = new FeedFilterType("DeprecatedAtMeOnly", 17);
        DeprecatedAtMeOnly = r17;
        FeedFilterType r18 = new FeedFilterType("Tag", 18);
        Tag = r18;
        FeedFilterType r19 = new FeedFilterType("Flag", 19);
        Flag = r19;
        FeedFilterType r20 = new FeedFilterType("Thread", 20);
        Thread = r20;
        FeedFilterType r21 = new FeedFilterType("UnreadOverDays", 21);
        UnreadOverDays = r21;
        FeedFilterType r22 = new FeedFilterType("CalendarGroup", 22);
        CalendarGroup = r22;
        FeedFilterType r23 = new FeedFilterType("InstantMeetingGroup", 23);
        InstantMeetingGroup = r23;
        FeedFilterType r24 = new FeedFilterType("Collapsed", 24);
        Collapsed = r24;
        FeedFilterType r25 = new FeedFilterType("AllMessage", 25);
        AllMessage = r25;
        FeedFilterType r26 = new FeedFilterType("ExpiredFold", 26);
        ExpiredFold = r26;
        FeedFilterType r27 = new FeedFilterType("MarkAsDeleted", 27);
        MarkAsDeleted = r27;
        FeedFilterType r28 = new FeedFilterType("MessageWithoutDoubao", 28);
        MessageWithoutDoubao = r28;
        FeedFilterType[] r29 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28};
        a = r29;
        b = EnumEntriesKt.enumEntries(r29);
        Companion = new a();
    }

    public final lark_biz_feed.proto.FeedFilterType into() {
        switch(b.a[ordinal()]) {
            case 1: goto L35;
            case 2: goto L63;
            case 3: goto L62;
            case 4: goto L61;
            case 5: goto L60;
            case 6: goto L59;
            case 7: goto L58;
            case 8: goto L57;
            case 9: goto L56;
            case 10: goto L55;
            case 11: goto L54;
            case 12: goto L53;
            case 13: goto L52;
            case 14: goto L51;
            case 15: goto L50;
            case 16: goto L49;
            case 17: goto L48;
            case 18: goto L47;
            case 19: goto L46;
            case 20: goto L45;
            case 21: goto L44;
            case 22: goto L43;
            case 23: goto L42;
            case 24: goto L41;
            case 25: goto L40;
            case 26: goto L39;
            case 27: goto L38;
            case 28: goto L37;
            case 29: goto L36;
            default: goto L5;
        };
    L5:
        throw new NoWhenBranchMatchedException();
    L36:
        return lark_biz_feed.proto.FeedFilterType.VAR_FEED_FILTER_TYPE_MESSAGE_WITHOUT_DOUBAO;
    L37:
        return lark_biz_feed.proto.FeedFilterType.VAR_FEED_FILTER_TYPE_MARK_AS_DELETED;
    L38:
        return lark_biz_feed.proto.FeedFilterType.VAR_FEED_FILTER_TYPE_EXPIRED_FOLD;
    L39:
        return lark_biz_feed.proto.FeedFilterType.VAR_FEED_FILTER_TYPE_ALL_MESSAGE;
    L40:
        return lark_biz_feed.proto.FeedFilterType.VAR_FEED_FILTER_TYPE_COLLAPSED;
    L41:
        return lark_biz_feed.proto.FeedFilterType.VAR_FEED_FILTER_TYPE_INSTANT_MEETING_GROUP;
    L42:
        return lark_biz_feed.proto.FeedFilterType.VAR_FEED_FILTER_TYPE_CALENDAR_GROUP;
    L43:
        return lark_biz_feed.proto.FeedFilterType.VAR_FEED_FILTER_TYPE_UNREAD_OVER_DAYS;
    L44:
        return lark_biz_feed.proto.FeedFilterType.VAR_FEED_FILTER_TYPE_THREAD;
    L45:
        return lark_biz_feed.proto.FeedFilterType.VAR_FEED_FILTER_TYPE_FLAG;
    L46:
        return lark_biz_feed.proto.FeedFilterType.VAR_FEED_FILTER_TYPE_TAG;
    L47:
        return lark_biz_feed.proto.FeedFilterType.VAR_FEED_FILTER_TYPE_DEPRECATED_AT_ME_ONLY;
    L48:
        return lark_biz_feed.proto.FeedFilterType.VAR_FEED_FILTER_TYPE_TEAM;
    L49:
        return lark_biz_feed.proto.FeedFilterType.VAR_FEED_FILTER_TYPE_GROUP;
    L50:
        return lark_biz_feed.proto.FeedFilterType.VAR_FEED_FILTER_TYPE_MUTE;
    L51:
        return lark_biz_feed.proto.FeedFilterType.VAR_FEED_FILTER_TYPE_MESSAGE;
    L52:
        return lark_biz_feed.proto.FeedFilterType.VAR_FEED_FILTER_TYPE_CRYPTO_CHAT;
    L53:
        return lark_biz_feed.proto.FeedFilterType.VAR_FEED_FILTER_TYPE_DONE;
    L54:
        return lark_biz_feed.proto.FeedFilterType.VAR_FEED_FILTER_TYPE_TOPIC_GROUP;
    L55:
        return lark_biz_feed.proto.FeedFilterType.VAR_FEED_FILTER_TYPE_HELP_DESK;
    L56:
        return lark_biz_feed.proto.FeedFilterType.VAR_FEED_FILTER_TYPE_BOT;
    L57:
        return lark_biz_feed.proto.FeedFilterType.VAR_FEED_FILTER_TYPE_GROUP_CHAT;
    L58:
        return lark_biz_feed.proto.FeedFilterType.VAR_FEED_FILTER_TYPE_P2P_CHAT;
    L59:
        return lark_biz_feed.proto.FeedFilterType.VAR_FEED_FILTER_TYPE_DOC;
    L60:
        return lark_biz_feed.proto.FeedFilterType.VAR_FEED_FILTER_TYPE_DELAYED;
    L61:
        return lark_biz_feed.proto.FeedFilterType.VAR_FEED_FILTER_TYPE_UNREAD;
    L62:
        return lark_biz_feed.proto.FeedFilterType.VAR_FEED_FILTER_TYPE_AT_ME;
    L63:
        return lark_biz_feed.proto.FeedFilterType.VAR_FEED_FILTER_TYPE_INBOX;
    L35:
        return lark_biz_feed.proto.FeedFilterType.VAR_FEED_FILTER_TYPE_UNKNOWN;
    }

    public final int intoInt() {
        switch(b.a[ordinal()]) {
            case 1: goto L34;
            case 2: goto L33;
            case 3: goto L32;
            case 4: goto L31;
            case 5: goto L30;
            case 6: goto L29;
            case 7: goto L28;
            case 8: goto L27;
            case 9: goto L26;
            case 10: goto L25;
            case 11: goto L24;
            case 12: goto L23;
            case 13: goto L22;
            case 14: goto L21;
            case 15: goto L20;
            case 16: goto L19;
            case 17: goto L18;
            case 18: goto L17;
            case 19: goto L16;
            case 20: goto L15;
            case 21: goto L14;
            case 22: goto L13;
            case 23: goto L12;
            case 24: goto L11;
            case 25: goto L10;
            case 26: goto L9;
            case 27: goto L8;
            case 28: goto L7;
            case 29: goto L6;
            default: goto L5;
        };
    L6:
        return 28;
    L7:
        return 27;
    L8:
        return 26;
    L9:
        return 25;
    L10:
        return 24;
    L11:
        return 23;
    L12:
        return 22;
    L13:
        return 21;
    L14:
        return 20;
    L15:
        return 19;
    L16:
        return 18;
    L17:
        return 17;
    L18:
        return 16;
    L19:
        return 15;
    L20:
        return 14;
    L21:
        return 13;
    L22:
        return 12;
    L23:
        return 11;
    L24:
        return 10;
    L25:
        return 9;
    L26:
        return 8;
    L27:
        return 7;
    L28:
        return 6;
    L29:
        return 5;
    L30:
        return 4;
    L31:
        return 3;
    L32:
        return 2;
    L33:
        return 1;
    L34:
        return 0;
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public FeedFilterType(String r1, int r2) {
        super(r1, r2);
    }
}
