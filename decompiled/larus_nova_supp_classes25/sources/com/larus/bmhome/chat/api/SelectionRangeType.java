package com.larus.bmhome.chat.api;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/bmhome/chat/api/SelectionRangeType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "WORD", "MARK_TEXT", "SENTENCE", "PARAGRAPH", "ENTIRE", "CUSTOM_RANGE", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum SelectionRangeType extends Enum<SelectionRangeType> {
    public static final SelectionRangeType CUSTOM_RANGE = null;
    public static final SelectionRangeType ENTIRE = null;
    public static final SelectionRangeType MARK_TEXT = null;
    public static final SelectionRangeType PARAGRAPH = null;
    public static final SelectionRangeType SENTENCE = null;
    public static final SelectionRangeType WORD = null;
    public static final /* synthetic */ SelectionRangeType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<SelectionRangeType> getEntries() {
        return b;
    }

    static {
        SelectionRangeType r0 = new SelectionRangeType("WORD", 0, "word");
        WORD = r0;
        SelectionRangeType r1 = new SelectionRangeType("MARK_TEXT", 1, "mark_text");
        MARK_TEXT = r1;
        SelectionRangeType r2 = new SelectionRangeType("SENTENCE", 2, "sentence");
        SENTENCE = r2;
        SelectionRangeType r4 = new SelectionRangeType("PARAGRAPH", 3, "paragraph");
        PARAGRAPH = r4;
        SelectionRangeType r6 = new SelectionRangeType("ENTIRE", 4, "entire");
        ENTIRE = r6;
        SelectionRangeType r8 = new SelectionRangeType("CUSTOM_RANGE", 5, "custom_range");
        CUSTOM_RANGE = r8;
        SelectionRangeType[] r10 = {r0, r1, r2, r4, r6, r8};
        a = r10;
        b = EnumEntriesKt.enumEntries(r10);
    }

    public static SelectionRangeType[] values() {
        return (SelectionRangeType[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static SelectionRangeType valueOf(String r1) {
        return (SelectionRangeType) a.a(SelectionRangeType.class, r1);
    }

    public SelectionRangeType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
