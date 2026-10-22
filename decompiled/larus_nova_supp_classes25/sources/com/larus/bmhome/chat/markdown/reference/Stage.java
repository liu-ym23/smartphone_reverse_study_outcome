package com.larus.bmhome.chat.markdown.reference;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/chat/markdown/reference/Stage;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Searching", "Searched", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum Stage extends Enum<Stage> {
    public static final Stage Searched = null;
    public static final Stage Searching = null;
    public static final /* synthetic */ Stage[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<Stage> getEntries() {
        return b;
    }

    static {
        Stage r0 = new Stage("Searching", 0, 1);
        Searching = r0;
        Stage r1 = new Stage("Searched", 1, 2);
        Searched = r1;
        Stage[] r4 = {r0, r1};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static Stage[] values() {
        return (Stage[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static Stage valueOf(String r1) {
        return (Stage) r27.a.a(Stage.class, r1);
    }

    public Stage(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
