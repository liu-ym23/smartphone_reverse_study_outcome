package com.larus.avlink.simulInterpret.page.model;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/avlink/simulInterpret/page/model/SliderLevel;", "", "<init>", "(Ljava/lang/String;I)V", "BOTTOM", "MIDDLE", "TOP", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum SliderLevel extends Enum<SliderLevel> {
    public static final SliderLevel BOTTOM = null;
    public static final SliderLevel MIDDLE = null;
    public static final SliderLevel TOP = null;
    public static final /* synthetic */ SliderLevel[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<SliderLevel> getEntries() {
        return b;
    }

    static {
        SliderLevel r0 = new SliderLevel("BOTTOM", 0);
        BOTTOM = r0;
        SliderLevel r1 = new SliderLevel("MIDDLE", 1);
        MIDDLE = r1;
        SliderLevel r3 = new SliderLevel("TOP", 2);
        TOP = r3;
        SliderLevel[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static SliderLevel[] values() {
        return (SliderLevel[]) a.clone();
    }

    public static SliderLevel valueOf(String r1) {
        return (SliderLevel) r27.a.a(SliderLevel.class, r1);
    }

    public SliderLevel(String r1, int r2) {
        super(r1, r2);
    }
}
