package com.larus.bmhome.chat.component.bottom.reference.entity;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/reference/entity/RefEntranceType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Unknown", "ChooseTextAutoCite", "LongPressAnswerMore", "LongPressAndChooseText", "ClickMarkDownLink", "TaskCardQuestion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum RefEntranceType extends Enum<RefEntranceType> {
    public static final RefEntranceType ChooseTextAutoCite = null;
    public static final RefEntranceType ClickMarkDownLink = null;
    public static final RefEntranceType LongPressAndChooseText = null;
    public static final RefEntranceType LongPressAnswerMore = null;
    public static final RefEntranceType TaskCardQuestion = null;
    public static final RefEntranceType Unknown = null;
    public static final /* synthetic */ RefEntranceType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<RefEntranceType> getEntries() {
        return b;
    }

    static {
        RefEntranceType r0 = new RefEntranceType("Unknown", 0, 0);
        Unknown = r0;
        RefEntranceType r1 = new RefEntranceType("ChooseTextAutoCite", 1, 1);
        ChooseTextAutoCite = r1;
        RefEntranceType r3 = new RefEntranceType("LongPressAnswerMore", 2, 2);
        LongPressAnswerMore = r3;
        RefEntranceType r5 = new RefEntranceType("LongPressAndChooseText", 3, 3);
        LongPressAndChooseText = r5;
        RefEntranceType r7 = new RefEntranceType("ClickMarkDownLink", 4, 4);
        ClickMarkDownLink = r7;
        RefEntranceType r9 = new RefEntranceType("TaskCardQuestion", 5, 5);
        TaskCardQuestion = r9;
        RefEntranceType[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static RefEntranceType[] values() {
        return (RefEntranceType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static RefEntranceType valueOf(String r1) {
        return (RefEntranceType) a.a(RefEntranceType.class, r1);
    }

    public RefEntranceType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
