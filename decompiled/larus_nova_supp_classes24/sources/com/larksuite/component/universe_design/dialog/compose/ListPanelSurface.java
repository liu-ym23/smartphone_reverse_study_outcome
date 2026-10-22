package com.larksuite.component.universe_design.dialog.compose;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larksuite/component/universe_design/dialog/compose/ListPanelSurface;", "", "<init>", "(Ljava/lang/String;I)V", "ActionPanel", "ActionSheet", "universe-ui-dialog_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
final enum ListPanelSurface extends Enum<ListPanelSurface> {
    public static final ListPanelSurface ActionPanel = null;
    public static final ListPanelSurface ActionSheet = null;
    public static final /* synthetic */ ListPanelSurface[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ListPanelSurface> getEntries() {
        return b;
    }

    static {
        ListPanelSurface r0 = new ListPanelSurface("ActionPanel", 0);
        ActionPanel = r0;
        ListPanelSurface r1 = new ListPanelSurface("ActionSheet", 1);
        ActionSheet = r1;
        ListPanelSurface[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ListPanelSurface[] values() {
        return (ListPanelSurface[]) a.clone();
    }

    public static ListPanelSurface valueOf(String r1) {
        return (ListPanelSurface) r27.a.a(ListPanelSurface.class, r1);
    }

    public ListPanelSurface(String r1, int r2) {
        super(r1, r2);
    }
}
