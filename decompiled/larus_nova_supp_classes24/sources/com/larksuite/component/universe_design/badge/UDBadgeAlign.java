package com.larksuite.component.universe_design.badge;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larksuite/component/universe_design/badge/UDBadgeAlign;", "", "<init>", "(Ljava/lang/String;I)V", "LEFT", "LEFT_TOP", "LEFT_BOTTOM", "RIGHT", "RIGHT_TOP", "RIGHT_BOTTOM", "universe-ui-badge_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum UDBadgeAlign extends Enum<UDBadgeAlign> {
    public static final UDBadgeAlign LEFT = null;
    public static final UDBadgeAlign LEFT_BOTTOM = null;
    public static final UDBadgeAlign LEFT_TOP = null;
    public static final UDBadgeAlign RIGHT = null;
    public static final UDBadgeAlign RIGHT_BOTTOM = null;
    public static final UDBadgeAlign RIGHT_TOP = null;
    public static final /* synthetic */ UDBadgeAlign[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<UDBadgeAlign> getEntries() {
        return b;
    }

    static {
        UDBadgeAlign r0 = new UDBadgeAlign("LEFT", 0);
        LEFT = r0;
        UDBadgeAlign r1 = new UDBadgeAlign("LEFT_TOP", 1);
        LEFT_TOP = r1;
        UDBadgeAlign r3 = new UDBadgeAlign("LEFT_BOTTOM", 2);
        LEFT_BOTTOM = r3;
        UDBadgeAlign r5 = new UDBadgeAlign("RIGHT", 3);
        RIGHT = r5;
        UDBadgeAlign r7 = new UDBadgeAlign("RIGHT_TOP", 4);
        RIGHT_TOP = r7;
        UDBadgeAlign r9 = new UDBadgeAlign("RIGHT_BOTTOM", 5);
        RIGHT_BOTTOM = r9;
        UDBadgeAlign[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static UDBadgeAlign[] values() {
        return (UDBadgeAlign[]) a.clone();
    }

    public static UDBadgeAlign valueOf(String r1) {
        return (UDBadgeAlign) a.a(UDBadgeAlign.class, r1);
    }

    public UDBadgeAlign(String r1, int r2) {
        super(r1, r2);
    }
}
