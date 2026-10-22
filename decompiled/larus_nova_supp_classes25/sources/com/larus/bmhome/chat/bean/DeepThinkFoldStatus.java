package com.larus.bmhome.chat.bean;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/bean/DeepThinkFoldStatus;", "", "<init>", "(Ljava/lang/String;I)V", "CompleteFold", "HalfFold", "CompleteExpand", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum DeepThinkFoldStatus extends Enum<DeepThinkFoldStatus> {
    public static final DeepThinkFoldStatus CompleteExpand = null;
    public static final DeepThinkFoldStatus CompleteFold = null;
    public static final DeepThinkFoldStatus HalfFold = null;
    public static final /* synthetic */ DeepThinkFoldStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DeepThinkFoldStatus> getEntries() {
        return b;
    }

    static {
        DeepThinkFoldStatus r0 = new DeepThinkFoldStatus("CompleteFold", 0);
        CompleteFold = r0;
        DeepThinkFoldStatus r1 = new DeepThinkFoldStatus("HalfFold", 1);
        HalfFold = r1;
        DeepThinkFoldStatus r3 = new DeepThinkFoldStatus("CompleteExpand", 2);
        CompleteExpand = r3;
        DeepThinkFoldStatus[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static DeepThinkFoldStatus[] values() {
        return (DeepThinkFoldStatus[]) a.clone();
    }

    public static DeepThinkFoldStatus valueOf(String r1) {
        return (DeepThinkFoldStatus) r27.a.a(DeepThinkFoldStatus.class, r1);
    }

    public DeepThinkFoldStatus(String r1, int r2) {
        super(r1, r2);
    }
}
