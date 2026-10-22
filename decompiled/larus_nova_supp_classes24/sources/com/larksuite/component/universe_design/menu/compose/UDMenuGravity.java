package com.larksuite.component.universe_design.menu.compose;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larksuite/component/universe_design/menu/compose/UDMenuGravity;", "", "<init>", "(Ljava/lang/String;I)V", "Top", "Bottom", "Start", "End", "universe-ui-menu_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum UDMenuGravity extends Enum<UDMenuGravity> {
    public static final UDMenuGravity Bottom = null;
    public static final UDMenuGravity End = null;
    public static final UDMenuGravity Start = null;
    public static final UDMenuGravity Top = null;
    public static final /* synthetic */ UDMenuGravity[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<UDMenuGravity> getEntries() {
        return b;
    }

    static {
        UDMenuGravity r0 = new UDMenuGravity("Top", 0);
        Top = r0;
        UDMenuGravity r1 = new UDMenuGravity("Bottom", 1);
        Bottom = r1;
        UDMenuGravity r3 = new UDMenuGravity("Start", 2);
        Start = r3;
        UDMenuGravity r5 = new UDMenuGravity("End", 3);
        End = r5;
        UDMenuGravity[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static UDMenuGravity[] values() {
        return (UDMenuGravity[]) a.clone();
    }

    public static UDMenuGravity valueOf(String r1) {
        return (UDMenuGravity) r27.a.a(UDMenuGravity.class, r1);
    }

    public UDMenuGravity(String r1, int r2) {
        super(r1, r2);
    }
}
