package com.larksuite.component.universe_design.menu;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larksuite/component/universe_design/menu/PositionAlign;", "", "<init>", "(Ljava/lang/String;I)V", "START", "CENTER", "END", "universe-ui-menu_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum PositionAlign extends Enum<PositionAlign> {
    public static final PositionAlign CENTER = null;
    public static final PositionAlign END = null;
    public static final PositionAlign START = null;
    public static final /* synthetic */ PositionAlign[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<PositionAlign> getEntries() {
        return b;
    }

    static {
        PositionAlign r0 = new PositionAlign("START", 0);
        START = r0;
        PositionAlign r1 = new PositionAlign("CENTER", 1);
        CENTER = r1;
        PositionAlign r3 = new PositionAlign("END", 2);
        END = r3;
        PositionAlign[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static PositionAlign[] values() {
        return (PositionAlign[]) a.clone();
    }

    public static PositionAlign valueOf(String r1) {
        return (PositionAlign) r27.a.a(PositionAlign.class, r1);
    }

    public PositionAlign(String r1, int r2) {
        super(r1, r2);
    }
}
