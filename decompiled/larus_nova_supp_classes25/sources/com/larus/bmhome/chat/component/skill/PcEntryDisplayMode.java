package com.larus.bmhome.chat.component.skill;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/chat/component/skill/PcEntryDisplayMode;", "", "<init>", "(Ljava/lang/String;I)V", "DEVICE_ONLY", "DEVICE_AND_FOLDER", "SUB_CONVERSATION", "MERGED", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum PcEntryDisplayMode extends Enum<PcEntryDisplayMode> {
    public static final PcEntryDisplayMode DEVICE_AND_FOLDER = null;
    public static final PcEntryDisplayMode DEVICE_ONLY = null;
    public static final PcEntryDisplayMode MERGED = null;
    public static final PcEntryDisplayMode SUB_CONVERSATION = null;
    public static final /* synthetic */ PcEntryDisplayMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<PcEntryDisplayMode> getEntries() {
        return b;
    }

    static {
        PcEntryDisplayMode r0 = new PcEntryDisplayMode("DEVICE_ONLY", 0);
        DEVICE_ONLY = r0;
        PcEntryDisplayMode r1 = new PcEntryDisplayMode("DEVICE_AND_FOLDER", 1);
        DEVICE_AND_FOLDER = r1;
        PcEntryDisplayMode r3 = new PcEntryDisplayMode("SUB_CONVERSATION", 2);
        SUB_CONVERSATION = r3;
        PcEntryDisplayMode r5 = new PcEntryDisplayMode("MERGED", 3);
        MERGED = r5;
        PcEntryDisplayMode[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static PcEntryDisplayMode[] values() {
        return (PcEntryDisplayMode[]) a.clone();
    }

    public static PcEntryDisplayMode valueOf(String r1) {
        return (PcEntryDisplayMode) a.a(PcEntryDisplayMode.class, r1);
    }

    public PcEntryDisplayMode(String r1, int r2) {
        super(r1, r2);
    }
}
