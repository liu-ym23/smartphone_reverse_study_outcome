package com.larus.avlink.plugins;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/avlink/plugins/DoraIntentType;", "", "type", "", "desc", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getType", "()I", "getDesc", "()Ljava/lang/String;", "UNKNOWN", "TAKE_PHOTO", "START_VIDEO_RECORDING", "END_SESSION", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum DoraIntentType extends Enum<DoraIntentType> {
    public static final DoraIntentType END_SESSION = null;
    public static final DoraIntentType START_VIDEO_RECORDING = null;
    public static final DoraIntentType TAKE_PHOTO = null;
    public static final DoraIntentType UNKNOWN = null;
    public static final /* synthetic */ DoraIntentType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String desc;
    private final int type;

    public static EnumEntries<DoraIntentType> getEntries() {
        return b;
    }

    static {
        DoraIntentType r0 = new DoraIntentType("UNKNOWN", 0, -1, "unknown");
        UNKNOWN = r0;
        DoraIntentType r1 = new DoraIntentType("TAKE_PHOTO", 1, 1, "take_photo");
        TAKE_PHOTO = r1;
        DoraIntentType r2 = new DoraIntentType("START_VIDEO_RECORDING", 2, 2, "start_video_recording");
        START_VIDEO_RECORDING = r2;
        DoraIntentType r3 = new DoraIntentType("END_SESSION", 3, 3, "end_session");
        END_SESSION = r3;
        DoraIntentType[] r6 = {r0, r1, r2, r3};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
    }

    public static DoraIntentType[] values() {
        return (DoraIntentType[]) a.clone();
    }

    public final String getDesc() {
        return this.desc;
    }

    public final int getType() {
        return this.type;
    }

    public static DoraIntentType valueOf(String r1) {
        return (DoraIntentType) r27.a.a(DoraIntentType.class, r1);
    }

    public DoraIntentType(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.type = r3;
        this.desc = r4;
    }
}
