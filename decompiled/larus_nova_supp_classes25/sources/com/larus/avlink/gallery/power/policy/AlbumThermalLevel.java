package com.larus.avlink.gallery.power.policy;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/avlink/gallery/power/policy/AlbumThermalLevel;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "LIGHT", "MODERATE", "SEVERE", "CRITICAL", "EMERGENCY", "SHUTDOWN", "UNKNOWN", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum AlbumThermalLevel extends Enum<AlbumThermalLevel> {
    public static final AlbumThermalLevel CRITICAL = null;
    public static final AlbumThermalLevel EMERGENCY = null;
    public static final AlbumThermalLevel LIGHT = null;
    public static final AlbumThermalLevel MODERATE = null;
    public static final AlbumThermalLevel NONE = null;
    public static final AlbumThermalLevel SEVERE = null;
    public static final AlbumThermalLevel SHUTDOWN = null;
    public static final AlbumThermalLevel UNKNOWN = null;
    public static final /* synthetic */ AlbumThermalLevel[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<AlbumThermalLevel> getEntries() {
        return b;
    }

    static {
        AlbumThermalLevel r0 = new AlbumThermalLevel("NONE", 0);
        NONE = r0;
        AlbumThermalLevel r1 = new AlbumThermalLevel("LIGHT", 1);
        LIGHT = r1;
        AlbumThermalLevel r3 = new AlbumThermalLevel("MODERATE", 2);
        MODERATE = r3;
        AlbumThermalLevel r5 = new AlbumThermalLevel("SEVERE", 3);
        SEVERE = r5;
        AlbumThermalLevel r7 = new AlbumThermalLevel("CRITICAL", 4);
        CRITICAL = r7;
        AlbumThermalLevel r9 = new AlbumThermalLevel("EMERGENCY", 5);
        EMERGENCY = r9;
        AlbumThermalLevel r11 = new AlbumThermalLevel("SHUTDOWN", 6);
        SHUTDOWN = r11;
        AlbumThermalLevel r13 = new AlbumThermalLevel("UNKNOWN", 7);
        UNKNOWN = r13;
        AlbumThermalLevel[] r15 = {r0, r1, r3, r5, r7, r9, r11, r13};
        a = r15;
        b = EnumEntriesKt.enumEntries(r15);
    }

    public static AlbumThermalLevel[] values() {
        return (AlbumThermalLevel[]) a.clone();
    }

    public static AlbumThermalLevel valueOf(String r1) {
        return (AlbumThermalLevel) a.a(AlbumThermalLevel.class, r1);
    }

    public AlbumThermalLevel(String r1, int r2) {
        super(r1, r2);
    }
}
