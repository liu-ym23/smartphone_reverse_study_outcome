package com.larus.bmhome.chat.model;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/model/ImportedImageRouteMode;", "", "<init>", "(Ljava/lang/String;I)V", "Attachment", "DirectSend", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum ImportedImageRouteMode extends Enum<ImportedImageRouteMode> {
    public static final ImportedImageRouteMode Attachment = null;
    public static final ImportedImageRouteMode DirectSend = null;
    public static final /* synthetic */ ImportedImageRouteMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ImportedImageRouteMode> getEntries() {
        return b;
    }

    static {
        ImportedImageRouteMode r0 = new ImportedImageRouteMode("Attachment", 0);
        Attachment = r0;
        ImportedImageRouteMode r1 = new ImportedImageRouteMode("DirectSend", 1);
        DirectSend = r1;
        ImportedImageRouteMode[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ImportedImageRouteMode[] values() {
        return (ImportedImageRouteMode[]) a.clone();
    }

    public static ImportedImageRouteMode valueOf(String r1) {
        return (ImportedImageRouteMode) r27.a.a(ImportedImageRouteMode.class, r1);
    }

    public ImportedImageRouteMode(String r1, int r2) {
        super(r1, r2);
    }
}
