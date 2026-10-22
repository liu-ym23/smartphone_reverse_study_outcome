package com.larksuite.component.universe_design.button.compose;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larksuite/component/universe_design/button/compose/UDButtonIconPlacement;", "", "<init>", "(Ljava/lang/String;I)V", "Start", "End", "Center", "universe-ui-button_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum UDButtonIconPlacement extends Enum<UDButtonIconPlacement> {
    public static final UDButtonIconPlacement Center = null;
    public static final UDButtonIconPlacement End = null;
    public static final UDButtonIconPlacement Start = null;
    public static final /* synthetic */ UDButtonIconPlacement[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<UDButtonIconPlacement> getEntries() {
        return b;
    }

    static {
        UDButtonIconPlacement r0 = new UDButtonIconPlacement("Start", 0);
        Start = r0;
        UDButtonIconPlacement r1 = new UDButtonIconPlacement("End", 1);
        End = r1;
        UDButtonIconPlacement r3 = new UDButtonIconPlacement("Center", 2);
        Center = r3;
        UDButtonIconPlacement[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static UDButtonIconPlacement[] values() {
        return (UDButtonIconPlacement[]) a.clone();
    }

    public static UDButtonIconPlacement valueOf(String r1) {
        return (UDButtonIconPlacement) r27.a.a(UDButtonIconPlacement.class, r1);
    }

    public UDButtonIconPlacement(String r1, int r2) {
        super(r1, r2);
    }
}
