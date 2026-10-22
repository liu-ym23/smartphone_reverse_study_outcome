package com.larus.bmhome.chat.input.swipe;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/input/swipe/InputContentMode;", "", "<init>", "(Ljava/lang/String;I)V", "TEXT", "SPEAK", "api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum InputContentMode extends Enum<InputContentMode> {
    public static final InputContentMode SPEAK = null;
    public static final InputContentMode TEXT = null;
    public static final /* synthetic */ InputContentMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<InputContentMode> getEntries() {
        return b;
    }

    static {
        InputContentMode r0 = new InputContentMode("TEXT", 0);
        TEXT = r0;
        InputContentMode r1 = new InputContentMode("SPEAK", 1);
        SPEAK = r1;
        InputContentMode[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static InputContentMode[] values() {
        return (InputContentMode[]) a.clone();
    }

    public static InputContentMode valueOf(String r1) {
        return (InputContentMode) a.a(InputContentMode.class, r1);
    }

    public InputContentMode(String r1, int r2) {
        super(r1, r2);
    }
}
