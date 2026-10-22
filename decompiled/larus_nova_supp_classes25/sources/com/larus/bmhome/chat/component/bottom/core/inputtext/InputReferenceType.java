package com.larus.bmhome.chat.component.bottom.core.inputtext;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/core/inputtext/InputReferenceType;", "", "<init>", "(Ljava/lang/String;I)V", "CONTACT", "GROUP", "ATTACHMENT", "SKILL", "DRIVE", "CONVERSATION", "FILE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum InputReferenceType extends Enum<InputReferenceType> {
    public static final InputReferenceType ATTACHMENT = null;
    public static final InputReferenceType CONTACT = null;
    public static final InputReferenceType CONVERSATION = null;
    public static final InputReferenceType DRIVE = null;
    public static final InputReferenceType FILE = null;
    public static final InputReferenceType GROUP = null;
    public static final InputReferenceType SKILL = null;
    public static final /* synthetic */ InputReferenceType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<InputReferenceType> getEntries() {
        return b;
    }

    static {
        InputReferenceType r0 = new InputReferenceType("CONTACT", 0);
        CONTACT = r0;
        InputReferenceType r1 = new InputReferenceType("GROUP", 1);
        GROUP = r1;
        InputReferenceType r3 = new InputReferenceType("ATTACHMENT", 2);
        ATTACHMENT = r3;
        InputReferenceType r5 = new InputReferenceType("SKILL", 3);
        SKILL = r5;
        InputReferenceType r7 = new InputReferenceType("DRIVE", 4);
        DRIVE = r7;
        InputReferenceType r9 = new InputReferenceType("CONVERSATION", 5);
        CONVERSATION = r9;
        InputReferenceType r11 = new InputReferenceType("FILE", 6);
        FILE = r11;
        InputReferenceType[] r13 = {r0, r1, r3, r5, r7, r9, r11};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
    }

    public static InputReferenceType[] values() {
        return (InputReferenceType[]) a.clone();
    }

    public static InputReferenceType valueOf(String r1) {
        return (InputReferenceType) r27.a.a(InputReferenceType.class, r1);
    }

    public InputReferenceType(String r1, int r2) {
        super(r1, r2);
    }
}
