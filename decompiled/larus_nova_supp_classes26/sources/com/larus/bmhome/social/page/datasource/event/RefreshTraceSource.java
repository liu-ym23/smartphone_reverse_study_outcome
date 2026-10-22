package com.larus.bmhome.social.page.datasource.event;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lcom/larus/bmhome/social/page/datasource/event/RefreshTraceSource;", "", "tag", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getTag", "()Ljava/lang/String;", "PRELOAD", "LOCAL", "REMOTE", "SEND", "RECEIVE", "UPDATE", "REGEN", "REMOVE", "REFRESH_ALL", "LIST_INSERT", "LIST_UPDATE", "LIST_REPLACE", "STREAM_END", "CONVERSATION_CHANGE", "REPROCESS", "UNKNOWN", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RefreshTraceSource extends Enum<RefreshTraceSource> {
    public static final RefreshTraceSource CONVERSATION_CHANGE = null;
    public static final RefreshTraceSource LIST_INSERT = null;
    public static final RefreshTraceSource LIST_REPLACE = null;
    public static final RefreshTraceSource LIST_UPDATE = null;
    public static final RefreshTraceSource LOCAL = null;
    public static final RefreshTraceSource PRELOAD = null;
    public static final RefreshTraceSource RECEIVE = null;
    public static final RefreshTraceSource REFRESH_ALL = null;
    public static final RefreshTraceSource REGEN = null;
    public static final RefreshTraceSource REMOTE = null;
    public static final RefreshTraceSource REMOVE = null;
    public static final RefreshTraceSource REPROCESS = null;
    public static final RefreshTraceSource SEND = null;
    public static final RefreshTraceSource STREAM_END = null;
    public static final RefreshTraceSource UNKNOWN = null;
    public static final RefreshTraceSource UPDATE = null;
    public static final /* synthetic */ RefreshTraceSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String tag;

    public static EnumEntries<RefreshTraceSource> getEntries() {
        return b;
    }

    static {
        RefreshTraceSource r0 = new RefreshTraceSource("PRELOAD", 0, "preload");
        PRELOAD = r0;
        RefreshTraceSource r1 = new RefreshTraceSource("LOCAL", 1, "local");
        LOCAL = r1;
        RefreshTraceSource r2 = new RefreshTraceSource("REMOTE", 2, "remote");
        REMOTE = r2;
        RefreshTraceSource r4 = new RefreshTraceSource("SEND", 3, "onSendMessage");
        SEND = r4;
        RefreshTraceSource r6 = new RefreshTraceSource("RECEIVE", 4, "onReceiveMessage");
        RECEIVE = r6;
        RefreshTraceSource r8 = new RefreshTraceSource("UPDATE", 5, "onUpdateMessage");
        UPDATE = r8;
        RefreshTraceSource r10 = new RefreshTraceSource("REGEN", 6, "onRegenMessage");
        REGEN = r10;
        RefreshTraceSource r12 = new RefreshTraceSource("REMOVE", 7, "removeMessage");
        REMOVE = r12;
        RefreshTraceSource r14 = new RefreshTraceSource("REFRESH_ALL", 8, "refreshAllMessage");
        REFRESH_ALL = r14;
        RefreshTraceSource r13 = new RefreshTraceSource("LIST_INSERT", 9, "onMessageListInsert");
        LIST_INSERT = r13;
        RefreshTraceSource r11 = new RefreshTraceSource("LIST_UPDATE", 10, "onMessageListUpdate");
        LIST_UPDATE = r11;
        RefreshTraceSource r9 = new RefreshTraceSource("LIST_REPLACE", 11, "onMessageListReplaced");
        LIST_REPLACE = r9;
        RefreshTraceSource r7 = new RefreshTraceSource("STREAM_END", 12, "onStreamEnd");
        STREAM_END = r7;
        RefreshTraceSource r5 = new RefreshTraceSource("CONVERSATION_CHANGE", 13, "conversationChange");
        CONVERSATION_CHANGE = r5;
        RefreshTraceSource r3 = new RefreshTraceSource("REPROCESS", 14, "reprocess");
        REPROCESS = r3;
        RefreshTraceSource r15 = new RefreshTraceSource("UNKNOWN", 15, "unknown");
        UNKNOWN = r15;
        RefreshTraceSource[] r16 = {r0, r1, r2, r4, r6, r8, r10, r12, r14, r13, r11, r9, r7, r5, r3, r15};
        a = r16;
        b = EnumEntriesKt.enumEntries(r16);
    }

    public static RefreshTraceSource[] values() {
        return (RefreshTraceSource[]) a.clone();
    }

    public final String getTag() {
        return this.tag;
    }

    public static RefreshTraceSource valueOf(String r1) {
        return (RefreshTraceSource) r27.a.a(RefreshTraceSource.class, r1);
    }

    public RefreshTraceSource(String r1, int r2, String r3) {
        super(r1, r2);
        this.tag = r3;
    }
}
