package com.larus.chat.job.impl.page.edit;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/chat/job/impl/page/edit/ChatJobEditOptionKey;", "", "<init>", "(Ljava/lang/String;I)V", "REPEAT", "FREQUENCY", "HOURLY_MINUTE", "DATE", "TIME", "RUN_TIME", "MODEL", "ENVIRONMENT", "PROJECT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatJobEditOptionKey extends Enum<ChatJobEditOptionKey> {
    public static final ChatJobEditOptionKey DATE = null;
    public static final ChatJobEditOptionKey ENVIRONMENT = null;
    public static final ChatJobEditOptionKey FREQUENCY = null;
    public static final ChatJobEditOptionKey HOURLY_MINUTE = null;
    public static final ChatJobEditOptionKey MODEL = null;
    public static final ChatJobEditOptionKey PROJECT = null;
    public static final ChatJobEditOptionKey REPEAT = null;
    public static final ChatJobEditOptionKey RUN_TIME = null;
    public static final ChatJobEditOptionKey TIME = null;
    public static final /* synthetic */ ChatJobEditOptionKey[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ChatJobEditOptionKey> getEntries() {
        return b;
    }

    static {
        ChatJobEditOptionKey r0 = new ChatJobEditOptionKey("REPEAT", 0);
        REPEAT = r0;
        ChatJobEditOptionKey r1 = new ChatJobEditOptionKey("FREQUENCY", 1);
        FREQUENCY = r1;
        ChatJobEditOptionKey r3 = new ChatJobEditOptionKey("HOURLY_MINUTE", 2);
        HOURLY_MINUTE = r3;
        ChatJobEditOptionKey r5 = new ChatJobEditOptionKey("DATE", 3);
        DATE = r5;
        ChatJobEditOptionKey r7 = new ChatJobEditOptionKey("TIME", 4);
        TIME = r7;
        ChatJobEditOptionKey r9 = new ChatJobEditOptionKey("RUN_TIME", 5);
        RUN_TIME = r9;
        ChatJobEditOptionKey r11 = new ChatJobEditOptionKey("MODEL", 6);
        MODEL = r11;
        ChatJobEditOptionKey r13 = new ChatJobEditOptionKey("ENVIRONMENT", 7);
        ENVIRONMENT = r13;
        ChatJobEditOptionKey r15 = new ChatJobEditOptionKey("PROJECT", 8);
        PROJECT = r15;
        ChatJobEditOptionKey[] r14 = {r0, r1, r3, r5, r7, r9, r11, r13, r15};
        a = r14;
        b = EnumEntriesKt.enumEntries(r14);
    }

    public static ChatJobEditOptionKey[] values() {
        return (ChatJobEditOptionKey[]) a.clone();
    }

    public static ChatJobEditOptionKey valueOf(String r1) {
        return (ChatJobEditOptionKey) r27.a.a(ChatJobEditOptionKey.class, r1);
    }

    public ChatJobEditOptionKey(String r1, int r2) {
        super(r1, r2);
    }
}
