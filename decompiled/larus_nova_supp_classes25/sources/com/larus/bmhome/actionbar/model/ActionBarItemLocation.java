package com.larus.bmhome.actionbar.model;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/actionbar/model/ActionBarItemLocation;", "", "<init>", "(Ljava/lang/String;I)V", "PRIMARY_BAR", "DETAIL_PANEL", "instruction_core_api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum ActionBarItemLocation extends Enum<ActionBarItemLocation> {
    public static final ActionBarItemLocation DETAIL_PANEL = null;
    public static final ActionBarItemLocation PRIMARY_BAR = null;
    public static final /* synthetic */ ActionBarItemLocation[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ActionBarItemLocation> getEntries() {
        return b;
    }

    static {
        ActionBarItemLocation r0 = new ActionBarItemLocation("PRIMARY_BAR", 0);
        PRIMARY_BAR = r0;
        ActionBarItemLocation r1 = new ActionBarItemLocation("DETAIL_PANEL", 1);
        DETAIL_PANEL = r1;
        ActionBarItemLocation[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ActionBarItemLocation[] values() {
        return (ActionBarItemLocation[]) a.clone();
    }

    public static ActionBarItemLocation valueOf(String r1) {
        return (ActionBarItemLocation) r27.a.a(ActionBarItemLocation.class, r1);
    }

    public ActionBarItemLocation(String r1, int r2) {
        super(r1, r2);
    }
}
