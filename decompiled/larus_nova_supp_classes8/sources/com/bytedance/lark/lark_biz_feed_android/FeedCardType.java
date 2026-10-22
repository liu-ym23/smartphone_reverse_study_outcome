package com.bytedance.lark.lark_biz_feed_android;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0018"}, d2 = {"Lcom/bytedance/lark/lark_biz_feed_android/FeedCardType;", "", "(Ljava/lang/String;I)V", "into", "Llark_biz_feed/proto/FeedCardType;", "intoInt", "", "UnknownType", "Chat", "Mail", "Doc", "Thread", "Box", "Openapp", "Topic", "AppChat", "Deprecated9", "Subscription", "MsgThread", "MyAi", "AppFeed", "KnowledgeAi", "DoubaoCustom", "Companion", "lark_biz_feed_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum FeedCardType extends Enum<FeedCardType> {
    public static final FeedCardType AppChat = null;
    public static final FeedCardType AppFeed = null;
    public static final FeedCardType Box = null;
    public static final FeedCardType Chat = null;
    public static final a Companion = null;
    public static final FeedCardType Deprecated9 = null;
    public static final FeedCardType Doc = null;
    public static final FeedCardType DoubaoCustom = null;
    public static final FeedCardType KnowledgeAi = null;
    public static final FeedCardType Mail = null;
    public static final FeedCardType MsgThread = null;
    public static final FeedCardType MyAi = null;
    public static final FeedCardType Openapp = null;
    public static final FeedCardType Subscription = null;
    public static final FeedCardType Thread = null;
    public static final FeedCardType Topic = null;
    public static final FeedCardType UnknownType = null;
    public static final /* synthetic */ FeedCardType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static FeedCardType a(int r1) {
            switch(r1) {
                case 0: goto L21;
                case 1: goto L36;
                case 2: goto L35;
                case 3: goto L34;
                case 4: goto L33;
                case 5: goto L32;
                case 6: goto L31;
                case 7: goto L30;
                case 8: goto L29;
                case 9: goto L28;
                case 10: goto L27;
                case 11: goto L26;
                case 12: goto L25;
                case 13: goto L24;
                case 14: goto L23;
                case 15: goto L22;
                default: goto L4;
            };
        L4:
            throw new RuntimeException("Unmatched primitive enum value: FeedCardType with ");
        L22:
            return FeedCardType.DoubaoCustom;
        L23:
            return FeedCardType.KnowledgeAi;
        L24:
            return FeedCardType.AppFeed;
        L25:
            return FeedCardType.MyAi;
        L26:
            return FeedCardType.MsgThread;
        L27:
            return FeedCardType.Subscription;
        L28:
            return FeedCardType.Deprecated9;
        L29:
            return FeedCardType.AppChat;
        L30:
            return FeedCardType.Topic;
        L31:
            return FeedCardType.Openapp;
        L32:
            return FeedCardType.Box;
        L33:
            return FeedCardType.Thread;
        L34:
            return FeedCardType.Doc;
        L35:
            return FeedCardType.Mail;
        L36:
            return FeedCardType.Chat;
        L21:
            return FeedCardType.UnknownType;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[FeedCardType.values().length];
            r0[FeedCardType.UnknownType.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L55:
            r0[FeedCardType.Chat.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L67:
            r0[FeedCardType.Mail.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L41:
            r0[FeedCardType.Doc.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L43:
            r0[FeedCardType.Thread.ordinal()] = 5;     // Catch: NoSuchFieldError -> L25
        L51:
            r0[FeedCardType.Box.ordinal()] = 6;     // Catch: NoSuchFieldError -> L26
        L61:
            r0[FeedCardType.Openapp.ordinal()] = 7;     // Catch: NoSuchFieldError -> L27
        L47:
            r0[FeedCardType.Topic.ordinal()] = 8;     // Catch: NoSuchFieldError -> L28
        L57:
            r0[FeedCardType.AppChat.ordinal()] = 9;     // Catch: NoSuchFieldError -> L29
        L59:
            r0[FeedCardType.Deprecated9.ordinal()] = 10;     // Catch: NoSuchFieldError -> L30
        L39:
            r0[FeedCardType.Subscription.ordinal()] = 11;     // Catch: NoSuchFieldError -> L31
        L53:
            r0[FeedCardType.MsgThread.ordinal()] = 12;     // Catch: NoSuchFieldError -> L32
        L65:
            r0[FeedCardType.MyAi.ordinal()] = 13;     // Catch: NoSuchFieldError -> L33
        L37:
            r0[FeedCardType.AppFeed.ordinal()] = 14;     // Catch: NoSuchFieldError -> L34
        L45:
            r0[FeedCardType.KnowledgeAi.ordinal()] = 15;     // Catch: NoSuchFieldError -> L35
        L63:
            r0[FeedCardType.DoubaoCustom.ordinal()] = 16;     // Catch: NoSuchFieldError -> L36
        L19:
            a = r0;
        }
    }

    @JvmStatic
    public static final FeedCardType fromInt(int r1) {
        Companion.getClass();
        return a.a(r1);
    }

    public static EnumEntries<FeedCardType> getEntries() {
        return b;
    }

    public static FeedCardType valueOf(String r1) {
        return (FeedCardType) r27.a.a(FeedCardType.class, r1);
    }

    public static FeedCardType[] values() {
        return (FeedCardType[]) a.clone();
    }

    static {
        FeedCardType r0 = new FeedCardType("UnknownType", 0);
        UnknownType = r0;
        FeedCardType r1 = new FeedCardType("Chat", 1);
        Chat = r1;
        FeedCardType r3 = new FeedCardType("Mail", 2);
        Mail = r3;
        FeedCardType r5 = new FeedCardType("Doc", 3);
        Doc = r5;
        FeedCardType r7 = new FeedCardType("Thread", 4);
        Thread = r7;
        FeedCardType r9 = new FeedCardType("Box", 5);
        Box = r9;
        FeedCardType r11 = new FeedCardType("Openapp", 6);
        Openapp = r11;
        FeedCardType r13 = new FeedCardType("Topic", 7);
        Topic = r13;
        FeedCardType r15 = new FeedCardType("AppChat", 8);
        AppChat = r15;
        FeedCardType r14 = new FeedCardType("Deprecated9", 9);
        Deprecated9 = r14;
        FeedCardType r12 = new FeedCardType("Subscription", 10);
        Subscription = r12;
        FeedCardType r10 = new FeedCardType("MsgThread", 11);
        MsgThread = r10;
        FeedCardType r8 = new FeedCardType("MyAi", 12);
        MyAi = r8;
        FeedCardType r6 = new FeedCardType("AppFeed", 13);
        AppFeed = r6;
        FeedCardType r4 = new FeedCardType("KnowledgeAi", 14);
        KnowledgeAi = r4;
        FeedCardType r2 = new FeedCardType("DoubaoCustom", 15);
        DoubaoCustom = r2;
        FeedCardType[] r16 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2};
        a = r16;
        b = EnumEntriesKt.enumEntries(r16);
        Companion = new a();
    }

    public final lark_biz_feed.proto.FeedCardType into() {
        switch(b.a[ordinal()]) {
            case 1: goto L22;
            case 2: goto L37;
            case 3: goto L36;
            case 4: goto L35;
            case 5: goto L34;
            case 6: goto L33;
            case 7: goto L32;
            case 8: goto L31;
            case 9: goto L30;
            case 10: goto L29;
            case 11: goto L28;
            case 12: goto L27;
            case 13: goto L26;
            case 14: goto L25;
            case 15: goto L24;
            case 16: goto L23;
            default: goto L5;
        };
    L5:
        throw new NoWhenBranchMatchedException();
    L23:
        return lark_biz_feed.proto.FeedCardType.VAR_FEED_CARD_TYPE_DOUBAO_CUSTOM;
    L24:
        return lark_biz_feed.proto.FeedCardType.VAR_FEED_CARD_TYPE_KNOWLEDGE_AI;
    L25:
        return lark_biz_feed.proto.FeedCardType.VAR_FEED_CARD_TYPE_APP_FEED;
    L26:
        return lark_biz_feed.proto.FeedCardType.VAR_FEED_CARD_TYPE_MY_AI;
    L27:
        return lark_biz_feed.proto.FeedCardType.VAR_FEED_CARD_TYPE_MSG_THREAD;
    L28:
        return lark_biz_feed.proto.FeedCardType.VAR_FEED_CARD_TYPE_SUBSCRIPTION;
    L29:
        return lark_biz_feed.proto.FeedCardType.VAR_FEED_CARD_TYPE_DEPRECATED9;
    L30:
        return lark_biz_feed.proto.FeedCardType.VAR_FEED_CARD_TYPE_APP_CHAT;
    L31:
        return lark_biz_feed.proto.FeedCardType.VAR_FEED_CARD_TYPE_TOPIC;
    L32:
        return lark_biz_feed.proto.FeedCardType.VAR_FEED_CARD_TYPE_OPENAPP;
    L33:
        return lark_biz_feed.proto.FeedCardType.VAR_FEED_CARD_TYPE_BOX;
    L34:
        return lark_biz_feed.proto.FeedCardType.VAR_FEED_CARD_TYPE_THREAD;
    L35:
        return lark_biz_feed.proto.FeedCardType.VAR_FEED_CARD_TYPE_DOC;
    L36:
        return lark_biz_feed.proto.FeedCardType.VAR_FEED_CARD_TYPE_MAIL;
    L37:
        return lark_biz_feed.proto.FeedCardType.VAR_FEED_CARD_TYPE_CHAT;
    L22:
        return lark_biz_feed.proto.FeedCardType.VAR_FEED_CARD_TYPE_UNKNOWN_TYPE;
    }

    public final int intoInt() {
        switch(b.a[ordinal()]) {
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L16;
            case 7: goto L15;
            case 8: goto L14;
            case 9: goto L13;
            case 10: goto L12;
            case 11: goto L11;
            case 12: goto L10;
            case 13: goto L9;
            case 14: goto L8;
            case 15: goto L7;
            case 16: goto L6;
            default: goto L5;
        };
    L6:
        return 15;
    L7:
        return 14;
    L8:
        return 13;
    L9:
        return 12;
    L10:
        return 11;
    L11:
        return 10;
    L12:
        return 9;
    L13:
        return 8;
    L14:
        return 7;
    L15:
        return 6;
    L16:
        return 5;
    L17:
        return 4;
    L18:
        return 3;
    L19:
        return 2;
    L20:
        return 1;
    L21:
        return 0;
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public FeedCardType(String r1, int r2) {
        super(r1, r2);
    }
}
