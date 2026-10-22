package com.larus.chat;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/chat/ChatTitleBarIcon;", "", "<init>", "(Ljava/lang/String;I)V", "BACK", "COLLAPSE", "SIDE_NAV", "PAGE_SIZE", "SEARCH", "NEW_CONVERSATION", "TTS", "MORE", "ADD_BOT", "REAL_TIME_CALL", "HISTORY", "MULTITASK_MANAGEMENT", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatTitleBarIcon extends Enum<ChatTitleBarIcon> {
    public static final ChatTitleBarIcon ADD_BOT = null;
    public static final ChatTitleBarIcon BACK = null;
    public static final ChatTitleBarIcon COLLAPSE = null;
    public static final ChatTitleBarIcon HISTORY = null;
    public static final ChatTitleBarIcon MORE = null;
    public static final ChatTitleBarIcon MULTITASK_MANAGEMENT = null;
    public static final ChatTitleBarIcon NEW_CONVERSATION = null;
    public static final ChatTitleBarIcon PAGE_SIZE = null;
    public static final ChatTitleBarIcon REAL_TIME_CALL = null;
    public static final ChatTitleBarIcon SEARCH = null;
    public static final ChatTitleBarIcon SIDE_NAV = null;
    public static final ChatTitleBarIcon TTS = null;
    public static final /* synthetic */ ChatTitleBarIcon[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ChatTitleBarIcon> getEntries() {
        return b;
    }

    static {
        ChatTitleBarIcon r0 = new ChatTitleBarIcon("BACK", 0);
        BACK = r0;
        ChatTitleBarIcon r1 = new ChatTitleBarIcon("COLLAPSE", 1);
        COLLAPSE = r1;
        ChatTitleBarIcon r3 = new ChatTitleBarIcon("SIDE_NAV", 2);
        SIDE_NAV = r3;
        ChatTitleBarIcon r5 = new ChatTitleBarIcon("PAGE_SIZE", 3);
        PAGE_SIZE = r5;
        ChatTitleBarIcon r7 = new ChatTitleBarIcon("SEARCH", 4);
        SEARCH = r7;
        ChatTitleBarIcon r9 = new ChatTitleBarIcon("NEW_CONVERSATION", 5);
        NEW_CONVERSATION = r9;
        ChatTitleBarIcon r11 = new ChatTitleBarIcon("TTS", 6);
        TTS = r11;
        ChatTitleBarIcon r13 = new ChatTitleBarIcon("MORE", 7);
        MORE = r13;
        ChatTitleBarIcon r15 = new ChatTitleBarIcon("ADD_BOT", 8);
        ADD_BOT = r15;
        ChatTitleBarIcon r14 = new ChatTitleBarIcon("REAL_TIME_CALL", 9);
        REAL_TIME_CALL = r14;
        ChatTitleBarIcon r12 = new ChatTitleBarIcon("HISTORY", 10);
        HISTORY = r12;
        ChatTitleBarIcon r10 = new ChatTitleBarIcon("MULTITASK_MANAGEMENT", 11);
        MULTITASK_MANAGEMENT = r10;
        ChatTitleBarIcon[] r8 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10};
        a = r8;
        b = EnumEntriesKt.enumEntries(r8);
    }

    public static ChatTitleBarIcon[] values() {
        return (ChatTitleBarIcon[]) a.clone();
    }

    public static ChatTitleBarIcon valueOf(String r1) {
        return (ChatTitleBarIcon) a.a(ChatTitleBarIcon.class, r1);
    }

    public ChatTitleBarIcon(String r1, int r2) {
        super(r1, r2);
    }
}
