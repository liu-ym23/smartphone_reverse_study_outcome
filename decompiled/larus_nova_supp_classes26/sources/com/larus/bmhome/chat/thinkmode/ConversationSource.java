package com.larus.bmhome.chat.thinkmode;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/chat/thinkmode/ConversationSource;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "MAIN_CONVERSATION", "NEW_CONVERSATION", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ConversationSource extends Enum<ConversationSource> {
    public static final a Companion = null;
    public static final ConversationSource MAIN_CONVERSATION = null;
    public static final ConversationSource NEW_CONVERSATION = null;
    public static final ConversationSource UNKNOWN = null;
    public static final /* synthetic */ ConversationSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<ConversationSource> getEntries() {
        return b;
    }

    static {
        ConversationSource r0 = new ConversationSource("UNKNOWN", 0, 0);
        UNKNOWN = r0;
        ConversationSource r1 = new ConversationSource("MAIN_CONVERSATION", 1, 1);
        MAIN_CONVERSATION = r1;
        ConversationSource r3 = new ConversationSource("NEW_CONVERSATION", 2, 2);
        NEW_CONVERSATION = r3;
        ConversationSource[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
        Companion = new a();
    }

    public static ConversationSource[] values() {
        return (ConversationSource[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ConversationSource valueOf(String r1) {
        return (ConversationSource) r27.a.a(ConversationSource.class, r1);
    }

    public ConversationSource(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
