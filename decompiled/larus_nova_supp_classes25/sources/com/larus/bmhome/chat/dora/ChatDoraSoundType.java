package com.larus.bmhome.chat.dora;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/chat/dora/ChatDoraSoundType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "DORA_SOUND_TYPE_RECORDING_START", "DORA_SOUND_TYPE_RECORDING_COMPLETE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum ChatDoraSoundType extends Enum<ChatDoraSoundType> {
    public static final ChatDoraSoundType DORA_SOUND_TYPE_RECORDING_COMPLETE = null;
    public static final ChatDoraSoundType DORA_SOUND_TYPE_RECORDING_START = null;
    public static final /* synthetic */ ChatDoraSoundType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ChatDoraSoundType> getEntries() {
        return b;
    }

    static {
        ChatDoraSoundType r0 = new ChatDoraSoundType("DORA_SOUND_TYPE_RECORDING_START", 0);
        DORA_SOUND_TYPE_RECORDING_START = r0;
        ChatDoraSoundType r1 = new ChatDoraSoundType("DORA_SOUND_TYPE_RECORDING_COMPLETE", 1);
        DORA_SOUND_TYPE_RECORDING_COMPLETE = r1;
        ChatDoraSoundType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ChatDoraSoundType[] values() {
        return (ChatDoraSoundType[]) a.clone();
    }

    public static ChatDoraSoundType valueOf(String r1) {
        return (ChatDoraSoundType) a.a(ChatDoraSoundType.class, r1);
    }

    public ChatDoraSoundType(String r1, int r2) {
        super(r1, r2);
    }
}
