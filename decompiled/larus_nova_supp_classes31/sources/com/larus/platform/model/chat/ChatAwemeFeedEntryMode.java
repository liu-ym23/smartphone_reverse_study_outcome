package com.larus.platform.model.chat;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/platform/model/chat/ChatAwemeFeedEntryMode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NONE", "DIRECT_SLIDE", "VIEW_MORE", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum ChatAwemeFeedEntryMode extends Enum<ChatAwemeFeedEntryMode> {
    public static final ChatAwemeFeedEntryMode DIRECT_SLIDE = null;
    public static final ChatAwemeFeedEntryMode NONE = null;
    public static final ChatAwemeFeedEntryMode VIEW_MORE = null;
    public static final /* synthetic */ ChatAwemeFeedEntryMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<ChatAwemeFeedEntryMode> getEntries() {
        return b;
    }

    static {
        ChatAwemeFeedEntryMode r0 = new ChatAwemeFeedEntryMode("NONE", 0, 0);
        NONE = r0;
        ChatAwemeFeedEntryMode r1 = new ChatAwemeFeedEntryMode("DIRECT_SLIDE", 1, 1);
        DIRECT_SLIDE = r1;
        ChatAwemeFeedEntryMode r3 = new ChatAwemeFeedEntryMode("VIEW_MORE", 2, 2);
        VIEW_MORE = r3;
        ChatAwemeFeedEntryMode[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static ChatAwemeFeedEntryMode[] values() {
        return (ChatAwemeFeedEntryMode[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ChatAwemeFeedEntryMode valueOf(String r1) {
        return (ChatAwemeFeedEntryMode) a.a(ChatAwemeFeedEntryMode.class, r1);
    }

    public ChatAwemeFeedEntryMode(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
