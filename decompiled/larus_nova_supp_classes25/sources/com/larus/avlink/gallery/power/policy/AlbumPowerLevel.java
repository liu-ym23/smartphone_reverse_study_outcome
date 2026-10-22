package com.larus.avlink.gallery.power.policy;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/avlink/gallery/power/policy/AlbumPowerLevel;", "", "<init>", "(Ljava/lang/String;I)V", "CRITICAL", "HIGH", "MEDIUM", "LOW", "UNKNOWN", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum AlbumPowerLevel extends Enum<AlbumPowerLevel> {
    public static final AlbumPowerLevel CRITICAL = null;
    public static final AlbumPowerLevel HIGH = null;
    public static final AlbumPowerLevel LOW = null;
    public static final AlbumPowerLevel MEDIUM = null;
    public static final AlbumPowerLevel UNKNOWN = null;
    public static final /* synthetic */ AlbumPowerLevel[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<AlbumPowerLevel> getEntries() {
        return b;
    }

    static {
        AlbumPowerLevel r0 = new AlbumPowerLevel("CRITICAL", 0);
        CRITICAL = r0;
        AlbumPowerLevel r1 = new AlbumPowerLevel("HIGH", 1);
        HIGH = r1;
        AlbumPowerLevel r3 = new AlbumPowerLevel("MEDIUM", 2);
        MEDIUM = r3;
        AlbumPowerLevel r5 = new AlbumPowerLevel("LOW", 3);
        LOW = r5;
        AlbumPowerLevel r7 = new AlbumPowerLevel("UNKNOWN", 4);
        UNKNOWN = r7;
        AlbumPowerLevel[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static AlbumPowerLevel[] values() {
        return (AlbumPowerLevel[]) a.clone();
    }

    public static AlbumPowerLevel valueOf(String r1) {
        return (AlbumPowerLevel) a.a(AlbumPowerLevel.class, r1);
    }

    public AlbumPowerLevel(String r1, int r2) {
        super(r1, r2);
    }
}
