package com.larksuite.common_selection.selectionhandle;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larksuite/common_selection/selectionhandle/SelectionHandleType;", "", "<init>", "(Ljava/lang/String;I)V", "START", "END", "common-selection_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum SelectionHandleType extends Enum<SelectionHandleType> {
    public static final SelectionHandleType END = null;
    public static final SelectionHandleType START = null;
    public static final /* synthetic */ SelectionHandleType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<SelectionHandleType> getEntries() {
        return b;
    }

    static {
        SelectionHandleType r0 = new SelectionHandleType("START", 0);
        START = r0;
        SelectionHandleType r1 = new SelectionHandleType("END", 1);
        END = r1;
        SelectionHandleType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static SelectionHandleType[] values() {
        return (SelectionHandleType[]) a.clone();
    }

    public static SelectionHandleType valueOf(String r1) {
        return (SelectionHandleType) a.a(SelectionHandleType.class, r1);
    }

    public SelectionHandleType(String r1, int r2) {
        super(r1, r2);
    }
}
