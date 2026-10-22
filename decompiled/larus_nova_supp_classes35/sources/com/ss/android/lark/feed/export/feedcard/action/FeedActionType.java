package com.ss.android.lark.feed.export.feedcard.action;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0018\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/feed/export/feedcard/action/FeedActionType;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "TOPPING", "FLAG_MARK", "ADD_FEED_TAG", "NO_DISTURB", "MOVE_TO_NO_DISTURB", "DONE", "CLEAR_UNREAD", "MARK_UNREAD", "ADD_CHAT_BOX", "REMOVE_FROM_TAG", "DISMISS", "BOT_MUTE", "ATTACH_TEAM", "DELETE", "TOPPING_IN_LIST", "EDIT_NAME", "SHARE", "FLOW_DELETE", "FLOW_TOPPING", "FLOW_HIDE", "FLOW_PROJECT", "feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FeedActionType extends Enum<FeedActionType> {
    public static final FeedActionType ADD_CHAT_BOX = null;
    public static final FeedActionType ADD_FEED_TAG = null;
    public static final FeedActionType ATTACH_TEAM = null;
    public static final FeedActionType BOT_MUTE = null;
    public static final FeedActionType CLEAR_UNREAD = null;
    public static final FeedActionType DELETE = null;
    public static final FeedActionType DISMISS = null;
    public static final FeedActionType DONE = null;
    public static final FeedActionType EDIT_NAME = null;
    public static final FeedActionType FLAG_MARK = null;
    public static final FeedActionType FLOW_DELETE = null;
    public static final FeedActionType FLOW_HIDE = null;
    public static final FeedActionType FLOW_PROJECT = null;
    public static final FeedActionType FLOW_TOPPING = null;
    public static final FeedActionType MARK_UNREAD = null;
    public static final FeedActionType MOVE_TO_NO_DISTURB = null;
    public static final FeedActionType NO_DISTURB = null;
    public static final FeedActionType REMOVE_FROM_TAG = null;
    public static final FeedActionType SHARE = null;
    public static final FeedActionType TOPPING = null;
    public static final FeedActionType TOPPING_IN_LIST = null;
    public static final /* synthetic */ FeedActionType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<FeedActionType> getEntries() {
        return b;
    }

    static {
        FeedActionType r0 = new FeedActionType("TOPPING", 0);
        TOPPING = r0;
        FeedActionType r1 = new FeedActionType("FLAG_MARK", 1);
        FLAG_MARK = r1;
        FeedActionType r3 = new FeedActionType("ADD_FEED_TAG", 2);
        ADD_FEED_TAG = r3;
        FeedActionType r5 = new FeedActionType("NO_DISTURB", 3);
        NO_DISTURB = r5;
        FeedActionType r7 = new FeedActionType("MOVE_TO_NO_DISTURB", 4);
        MOVE_TO_NO_DISTURB = r7;
        FeedActionType r9 = new FeedActionType("DONE", 5);
        DONE = r9;
        FeedActionType r11 = new FeedActionType("CLEAR_UNREAD", 6);
        CLEAR_UNREAD = r11;
        FeedActionType r13 = new FeedActionType("MARK_UNREAD", 7);
        MARK_UNREAD = r13;
        FeedActionType r15 = new FeedActionType("ADD_CHAT_BOX", 8);
        ADD_CHAT_BOX = r15;
        FeedActionType r14 = new FeedActionType("REMOVE_FROM_TAG", 9);
        REMOVE_FROM_TAG = r14;
        FeedActionType r12 = new FeedActionType("DISMISS", 10);
        DISMISS = r12;
        FeedActionType r10 = new FeedActionType("BOT_MUTE", 11);
        BOT_MUTE = r10;
        FeedActionType r8 = new FeedActionType("ATTACH_TEAM", 12);
        ATTACH_TEAM = r8;
        FeedActionType r6 = new FeedActionType("DELETE", 13);
        DELETE = r6;
        FeedActionType r4 = new FeedActionType("TOPPING_IN_LIST", 14);
        TOPPING_IN_LIST = r4;
        FeedActionType r2 = new FeedActionType("EDIT_NAME", 15);
        EDIT_NAME = r2;
        FeedActionType r16 = new FeedActionType("SHARE", 16);
        SHARE = r16;
        FeedActionType r17 = new FeedActionType("FLOW_DELETE", 17);
        FLOW_DELETE = r17;
        FeedActionType r18 = new FeedActionType("FLOW_TOPPING", 18);
        FLOW_TOPPING = r18;
        FeedActionType r19 = new FeedActionType("FLOW_HIDE", 19);
        FLOW_HIDE = r19;
        FeedActionType r20 = new FeedActionType("FLOW_PROJECT", 20);
        FLOW_PROJECT = r20;
        FeedActionType[] r21 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19, r20};
        a = r21;
        b = EnumEntriesKt.enumEntries(r21);
    }

    public static FeedActionType[] values() {
        return (FeedActionType[]) a.clone();
    }

    public static FeedActionType valueOf(String r1) {
        return (FeedActionType) a.a(FeedActionType.class, r1);
    }

    public FeedActionType(String r1, int r2) {
        super(r1, r2);
    }
}
