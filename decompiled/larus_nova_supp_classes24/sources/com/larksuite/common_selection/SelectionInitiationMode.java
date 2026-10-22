package com.larksuite.common_selection;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larksuite/common_selection/SelectionInitiationMode;", "", "<init>", "(Ljava/lang/String;I)V", "SELECT_ON_CONTENT", "SELECT_ANYWHERE", "common-selection_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum SelectionInitiationMode extends Enum<SelectionInitiationMode> {
    public static final SelectionInitiationMode SELECT_ANYWHERE = null;
    public static final SelectionInitiationMode SELECT_ON_CONTENT = null;
    public static final /* synthetic */ SelectionInitiationMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<SelectionInitiationMode> getEntries() {
        return b;
    }

    static {
        SelectionInitiationMode r0 = new SelectionInitiationMode("SELECT_ON_CONTENT", 0);
        SELECT_ON_CONTENT = r0;
        SelectionInitiationMode r1 = new SelectionInitiationMode("SELECT_ANYWHERE", 1);
        SELECT_ANYWHERE = r1;
        SelectionInitiationMode[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static SelectionInitiationMode[] values() {
        return (SelectionInitiationMode[]) a.clone();
    }

    public static SelectionInitiationMode valueOf(String r1) {
        return (SelectionInitiationMode) r27.a.a(SelectionInitiationMode.class, r1);
    }

    public SelectionInitiationMode(String r1, int r2) {
        super(r1, r2);
    }
}
