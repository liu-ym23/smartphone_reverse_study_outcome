package com.larus.bmhome.ability;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/larus/bmhome/ability/ContainerExceptionType;", "", "value", "", "type", "Lcom/larus/bmhome/ability/MessageMonitorItemType;", "<init>", "(Ljava/lang/String;ILjava/lang/String;Lcom/larus/bmhome/ability/MessageMonitorItemType;)V", "getValue", "()Ljava/lang/String;", "getType", "()Lcom/larus/bmhome/ability/MessageMonitorItemType;", "FAILED_LYNX", "FAILED_IMAGE", "FAILED_VIDEO", "TIMEOUT_LYNX", "TIMEOUT_IMAGE", "TIMEOUT_VIDEO", "UNRECOGNIZED_LINK", "WRONG_LINK", "EXCEPTION_LINK", "FAILED_FORMULA", "UNRECOGNIZED_POTENTIAL_FORMULA", "UNRECOGNIZED_POTENTIAL_TABLE", "UNRECOGNIZED_POTENTIAL_BOLD", "api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum ContainerExceptionType extends Enum<ContainerExceptionType> {
    public static final ContainerExceptionType EXCEPTION_LINK = null;
    public static final ContainerExceptionType FAILED_FORMULA = null;
    public static final ContainerExceptionType FAILED_IMAGE = null;
    public static final ContainerExceptionType FAILED_LYNX = null;
    public static final ContainerExceptionType FAILED_VIDEO = null;
    public static final ContainerExceptionType TIMEOUT_IMAGE = null;
    public static final ContainerExceptionType TIMEOUT_LYNX = null;
    public static final ContainerExceptionType TIMEOUT_VIDEO = null;
    public static final ContainerExceptionType UNRECOGNIZED_LINK = null;
    public static final ContainerExceptionType UNRECOGNIZED_POTENTIAL_BOLD = null;
    public static final ContainerExceptionType UNRECOGNIZED_POTENTIAL_FORMULA = null;
    public static final ContainerExceptionType UNRECOGNIZED_POTENTIAL_TABLE = null;
    public static final ContainerExceptionType WRONG_LINK = null;
    public static final /* synthetic */ ContainerExceptionType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final MessageMonitorItemType type;
    private final String value;

    public static EnumEntries<ContainerExceptionType> getEntries() {
        return b;
    }

    static {
        MessageMonitorItemType r1 = MessageMonitorItemType.LYNX;
        ContainerExceptionType r0 = new ContainerExceptionType("FAILED_LYNX", 0, "failed_lynx", r1);
        FAILED_LYNX = r0;
        MessageMonitorItemType r4 = MessageMonitorItemType.IMAGE;
        ContainerExceptionType r2 = new ContainerExceptionType("FAILED_IMAGE", 1, "failed_image", r4);
        FAILED_IMAGE = r2;
        MessageMonitorItemType r7 = MessageMonitorItemType.VIDEO;
        ContainerExceptionType r5 = new ContainerExceptionType("FAILED_VIDEO", 2, "failed_video", r7);
        FAILED_VIDEO = r5;
        ContainerExceptionType r8 = new ContainerExceptionType("TIMEOUT_LYNX", 3, "timeout_lynx", r1);
        TIMEOUT_LYNX = r8;
        ContainerExceptionType r3 = new ContainerExceptionType("TIMEOUT_IMAGE", 4, "timeout_image", r4);
        TIMEOUT_IMAGE = r3;
        ContainerExceptionType r6 = new ContainerExceptionType("TIMEOUT_VIDEO", 5, "timeout_video", r7);
        TIMEOUT_VIDEO = r6;
        MessageMonitorItemType r10 = MessageMonitorItemType.LINK;
        ContainerExceptionType r9 = new ContainerExceptionType("UNRECOGNIZED_LINK", 6, "unrecognized_link", r10);
        UNRECOGNIZED_LINK = r9;
        ContainerExceptionType r11 = new ContainerExceptionType("WRONG_LINK", 7, "wrong_link", r10);
        WRONG_LINK = r11;
        ContainerExceptionType r14 = new ContainerExceptionType("EXCEPTION_LINK", 8, "exception_link", r10);
        EXCEPTION_LINK = r14;
        MessageMonitorItemType r13 = MessageMonitorItemType.POTENTIAL_FORMULA;
        ContainerExceptionType r12 = new ContainerExceptionType("FAILED_FORMULA", 9, "failed_formula", r13);
        FAILED_FORMULA = r12;
        ContainerExceptionType r15 = new ContainerExceptionType("UNRECOGNIZED_POTENTIAL_FORMULA", 10, "unrecognized_potential_formula", r13);
        UNRECOGNIZED_POTENTIAL_FORMULA = r15;
        ContainerExceptionType r16 = new ContainerExceptionType("UNRECOGNIZED_POTENTIAL_TABLE", 11, "unrecognized_potential_table", MessageMonitorItemType.POTENTIAL_TABLE);
        UNRECOGNIZED_POTENTIAL_TABLE = r16;
        ContainerExceptionType r17 = new ContainerExceptionType("UNRECOGNIZED_POTENTIAL_BOLD", 12, "unrecognized_potential_bold", MessageMonitorItemType.POTENTIAL_BOLD);
        UNRECOGNIZED_POTENTIAL_BOLD = r17;
        ContainerExceptionType[] r18 = {r0, r2, r5, r8, r3, r6, r9, r11, r14, r12, r15, r16, r17};
        a = r18;
        b = EnumEntriesKt.enumEntries(r18);
    }

    public static ContainerExceptionType[] values() {
        return (ContainerExceptionType[]) a.clone();
    }

    public final MessageMonitorItemType getType() {
        return this.type;
    }

    public final String getValue() {
        return this.value;
    }

    public static ContainerExceptionType valueOf(String r1) {
        return (ContainerExceptionType) a.a(ContainerExceptionType.class, r1);
    }

    public ContainerExceptionType(String r1, int r2, String r3, MessageMonitorItemType r4) {
        super(r1, r2);
        this.value = r3;
        this.type = r4;
    }
}
