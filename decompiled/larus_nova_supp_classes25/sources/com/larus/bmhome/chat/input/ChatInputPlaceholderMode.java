package com.larus.bmhome.chat.input;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/input/ChatInputPlaceholderMode;", "", "<init>", "(Ljava/lang/String;I)V", "KEYBOARD", "VOICE", "api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum ChatInputPlaceholderMode extends Enum<ChatInputPlaceholderMode> {
    public static final ChatInputPlaceholderMode KEYBOARD = null;
    public static final ChatInputPlaceholderMode VOICE = null;
    public static final /* synthetic */ ChatInputPlaceholderMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ChatInputPlaceholderMode> getEntries() {
        return b;
    }

    static {
        ChatInputPlaceholderMode r0 = new ChatInputPlaceholderMode("KEYBOARD", 0);
        KEYBOARD = r0;
        ChatInputPlaceholderMode r1 = new ChatInputPlaceholderMode("VOICE", 1);
        VOICE = r1;
        ChatInputPlaceholderMode[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ChatInputPlaceholderMode[] values() {
        return (ChatInputPlaceholderMode[]) a.clone();
    }

    public static ChatInputPlaceholderMode valueOf(String r1) {
        return (ChatInputPlaceholderMode) a.a(ChatInputPlaceholderMode.class, r1);
    }

    public ChatInputPlaceholderMode(String r1, int r2) {
        super(r1, r2);
    }
}
