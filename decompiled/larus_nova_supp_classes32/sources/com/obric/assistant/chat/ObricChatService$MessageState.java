package com.obric.assistant.chat;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/assistant/chat/ObricChatService$MessageState;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "NA", "SEND", "RECV", "END", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricChatService$MessageState extends Enum<ObricChatService$MessageState> {
    public static final ObricChatService$MessageState END = null;
    public static final ObricChatService$MessageState NA = null;
    public static final ObricChatService$MessageState RECV = null;
    public static final ObricChatService$MessageState SEND = null;
    public static final /* synthetic */ ObricChatService$MessageState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ObricChatService$MessageState> getEntries() {
        return b;
    }

    static {
        ObricChatService$MessageState r0 = new ObricChatService$MessageState("NA", 0);
        NA = r0;
        ObricChatService$MessageState r1 = new ObricChatService$MessageState("SEND", 1);
        SEND = r1;
        ObricChatService$MessageState r3 = new ObricChatService$MessageState("RECV", 2);
        RECV = r3;
        ObricChatService$MessageState r5 = new ObricChatService$MessageState("END", 3);
        END = r5;
        ObricChatService$MessageState[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static ObricChatService$MessageState[] values() {
        return (ObricChatService$MessageState[]) a.clone();
    }

    public static ObricChatService$MessageState valueOf(String r1) {
        return (ObricChatService$MessageState) a.a(ObricChatService$MessageState.class, r1);
    }

    public ObricChatService$MessageState(String r1, int r2) {
        super(r1, r2);
    }
}
