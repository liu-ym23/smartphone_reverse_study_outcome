package com.larus.bmhome.chat.resp;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/bmhome/chat/resp/NoticeGroup;", "", "group", "", "<init>", "(Ljava/lang/String;II)V", "getGroup", "()I", "COMMON", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum NoticeGroup extends Enum<NoticeGroup> {
    public static final NoticeGroup COMMON = null;
    public static final /* synthetic */ NoticeGroup[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int group;

    public static EnumEntries<NoticeGroup> getEntries() {
        return b;
    }

    static {
        NoticeGroup r0 = new NoticeGroup();
        COMMON = r0;
        NoticeGroup[] r1 = {r0};
        a = r1;
        b = EnumEntriesKt.enumEntries(r1);
    }

    public NoticeGroup() {
        super("COMMON", 0);
        this.group = 1;
    }

    public static NoticeGroup[] values() {
        return (NoticeGroup[]) a.clone();
    }

    public final int getGroup() {
        return this.group;
    }

    public static NoticeGroup valueOf(String r1) {
        return (NoticeGroup) a.a(NoticeGroup.class, r1);
    }
}
