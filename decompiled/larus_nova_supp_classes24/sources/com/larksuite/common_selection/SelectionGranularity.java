package com.larksuite.common_selection;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larksuite/common_selection/SelectionGranularity;", "", "<init>", "(Ljava/lang/String;I)V", "CHARACTER", "WORD", "PARAGRAPH", "ALL_TEXT", "ALL", "common-selection_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum SelectionGranularity extends Enum<SelectionGranularity> {
    public static final SelectionGranularity ALL = null;
    public static final SelectionGranularity ALL_TEXT = null;
    public static final SelectionGranularity CHARACTER = null;
    public static final SelectionGranularity PARAGRAPH = null;
    public static final SelectionGranularity WORD = null;
    public static final /* synthetic */ SelectionGranularity[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<SelectionGranularity> getEntries() {
        return b;
    }

    static {
        SelectionGranularity r0 = new SelectionGranularity("CHARACTER", 0);
        CHARACTER = r0;
        SelectionGranularity r1 = new SelectionGranularity("WORD", 1);
        WORD = r1;
        SelectionGranularity r3 = new SelectionGranularity("PARAGRAPH", 2);
        PARAGRAPH = r3;
        SelectionGranularity r5 = new SelectionGranularity("ALL_TEXT", 3);
        ALL_TEXT = r5;
        SelectionGranularity r7 = new SelectionGranularity("ALL", 4);
        ALL = r7;
        SelectionGranularity[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static SelectionGranularity[] values() {
        return (SelectionGranularity[]) a.clone();
    }

    public static SelectionGranularity valueOf(String r1) {
        return (SelectionGranularity) r27.a.a(SelectionGranularity.class, r1);
    }

    public SelectionGranularity(String r1, int r2) {
        super(r1, r2);
    }
}
