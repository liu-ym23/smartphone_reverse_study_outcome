package com.larus.avlink.e;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/avlink/e/DoraImageEvent;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "TAKE_PHOTO_CMD_SEND", "IMAGE_TAKE_START", "IMAGE_TRANS_START", "IMAGE_TRANS_FINISH", "IMAGE_UPLOAD_START", "IMAGE_UPLOAD_FINISH", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum DoraImageEvent extends Enum<DoraImageEvent> {
    public static final DoraImageEvent IMAGE_TAKE_START = null;
    public static final DoraImageEvent IMAGE_TRANS_FINISH = null;
    public static final DoraImageEvent IMAGE_TRANS_START = null;
    public static final DoraImageEvent IMAGE_UPLOAD_FINISH = null;
    public static final DoraImageEvent IMAGE_UPLOAD_START = null;
    public static final DoraImageEvent TAKE_PHOTO_CMD_SEND = null;
    public static final DoraImageEvent UNKNOWN = null;
    public static final /* synthetic */ DoraImageEvent[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DoraImageEvent> getEntries() {
        return b;
    }

    static {
        DoraImageEvent r0 = new DoraImageEvent("UNKNOWN", 0);
        UNKNOWN = r0;
        DoraImageEvent r1 = new DoraImageEvent("TAKE_PHOTO_CMD_SEND", 1);
        TAKE_PHOTO_CMD_SEND = r1;
        DoraImageEvent r3 = new DoraImageEvent("IMAGE_TAKE_START", 2);
        IMAGE_TAKE_START = r3;
        DoraImageEvent r5 = new DoraImageEvent("IMAGE_TRANS_START", 3);
        IMAGE_TRANS_START = r5;
        DoraImageEvent r7 = new DoraImageEvent("IMAGE_TRANS_FINISH", 4);
        IMAGE_TRANS_FINISH = r7;
        DoraImageEvent r9 = new DoraImageEvent("IMAGE_UPLOAD_START", 5);
        IMAGE_UPLOAD_START = r9;
        DoraImageEvent r11 = new DoraImageEvent("IMAGE_UPLOAD_FINISH", 6);
        IMAGE_UPLOAD_FINISH = r11;
        DoraImageEvent[] r13 = {r0, r1, r3, r5, r7, r9, r11};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
    }

    public static DoraImageEvent[] values() {
        return (DoraImageEvent[]) a.clone();
    }

    public static DoraImageEvent valueOf(String r1) {
        return (DoraImageEvent) r27.a.a(DoraImageEvent.class, r1);
    }

    public DoraImageEvent(String r1, int r2) {
        super(r1, r2);
    }
}
