package com.larus.drive.sdk.api.file.select;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/drive/sdk/api/file/select/ChatRecentFileSource;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "LARK", "DOUBAO", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatRecentFileSource extends Enum<ChatRecentFileSource> {
    public static final ChatRecentFileSource DOUBAO = null;
    public static final ChatRecentFileSource LARK = null;
    public static final ChatRecentFileSource UNKNOWN = null;
    public static final /* synthetic */ ChatRecentFileSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ChatRecentFileSource> getEntries() {
        return b;
    }

    static {
        ChatRecentFileSource r0 = new ChatRecentFileSource("UNKNOWN", 0);
        UNKNOWN = r0;
        ChatRecentFileSource r1 = new ChatRecentFileSource("LARK", 1);
        LARK = r1;
        ChatRecentFileSource r3 = new ChatRecentFileSource("DOUBAO", 2);
        DOUBAO = r3;
        ChatRecentFileSource[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static ChatRecentFileSource[] values() {
        return (ChatRecentFileSource[]) a.clone();
    }

    public static ChatRecentFileSource valueOf(String r1) {
        return (ChatRecentFileSource) a.a(ChatRecentFileSource.class, r1);
    }

    public ChatRecentFileSource(String r1, int r2) {
        super(r1, r2);
    }
}
