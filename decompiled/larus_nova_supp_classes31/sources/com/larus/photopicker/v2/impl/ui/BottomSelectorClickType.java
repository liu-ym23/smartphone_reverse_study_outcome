package com.larus.photopicker.v2.impl.ui;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/photopicker/v2/impl/ui/BottomSelectorClickType;", "", "<init>", "(Ljava/lang/String;I)V", "CLICK_ITEM", "DEL_ITEM", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum BottomSelectorClickType extends Enum<BottomSelectorClickType> {
    public static final BottomSelectorClickType CLICK_ITEM = null;
    public static final BottomSelectorClickType DEL_ITEM = null;
    public static final /* synthetic */ BottomSelectorClickType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<BottomSelectorClickType> getEntries() {
        return b;
    }

    static {
        BottomSelectorClickType r0 = new BottomSelectorClickType("CLICK_ITEM", 0);
        CLICK_ITEM = r0;
        BottomSelectorClickType r1 = new BottomSelectorClickType("DEL_ITEM", 1);
        DEL_ITEM = r1;
        BottomSelectorClickType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static BottomSelectorClickType[] values() {
        return (BottomSelectorClickType[]) a.clone();
    }

    public static BottomSelectorClickType valueOf(String r1) {
        return (BottomSelectorClickType) a.a(BottomSelectorClickType.class, r1);
    }

    public BottomSelectorClickType(String r1, int r2) {
        super(r1, r2);
    }
}
