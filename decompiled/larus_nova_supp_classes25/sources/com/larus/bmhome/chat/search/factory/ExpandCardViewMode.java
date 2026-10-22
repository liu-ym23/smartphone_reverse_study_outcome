package com.larus.bmhome.chat.search.factory;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/chat/search/factory/ExpandCardViewMode;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "EXPAND", "NORMAL_SHARE", "EXPAND_SHARE", "NORMAL_PIC", "EXPAND_PIC", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum ExpandCardViewMode extends Enum<ExpandCardViewMode> {
    public static final ExpandCardViewMode EXPAND = null;
    public static final ExpandCardViewMode EXPAND_PIC = null;
    public static final ExpandCardViewMode EXPAND_SHARE = null;
    public static final ExpandCardViewMode NORMAL = null;
    public static final ExpandCardViewMode NORMAL_PIC = null;
    public static final ExpandCardViewMode NORMAL_SHARE = null;
    public static final /* synthetic */ ExpandCardViewMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ExpandCardViewMode> getEntries() {
        return b;
    }

    static {
        ExpandCardViewMode r0 = new ExpandCardViewMode("NORMAL", 0);
        NORMAL = r0;
        ExpandCardViewMode r1 = new ExpandCardViewMode("EXPAND", 1);
        EXPAND = r1;
        ExpandCardViewMode r3 = new ExpandCardViewMode("NORMAL_SHARE", 2);
        NORMAL_SHARE = r3;
        ExpandCardViewMode r5 = new ExpandCardViewMode("EXPAND_SHARE", 3);
        EXPAND_SHARE = r5;
        ExpandCardViewMode r7 = new ExpandCardViewMode("NORMAL_PIC", 4);
        NORMAL_PIC = r7;
        ExpandCardViewMode r9 = new ExpandCardViewMode("EXPAND_PIC", 5);
        EXPAND_PIC = r9;
        ExpandCardViewMode[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static ExpandCardViewMode[] values() {
        return (ExpandCardViewMode[]) a.clone();
    }

    public static ExpandCardViewMode valueOf(String r1) {
        return (ExpandCardViewMode) a.a(ExpandCardViewMode.class, r1);
    }

    public ExpandCardViewMode(String r1, int r2) {
        super(r1, r2);
    }
}
