package com.larksuite.component.universe_design.button.compose;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larksuite/component/universe_design/button/compose/UDButtonSize;", "", "<init>", "(Ljava/lang/String;I)V", "Column", "Big", "Middle", "Small", "Custom", "universe-ui-button_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum UDButtonSize extends Enum<UDButtonSize> {
    public static final UDButtonSize Big = null;
    public static final UDButtonSize Column = null;
    public static final UDButtonSize Custom = null;
    public static final UDButtonSize Middle = null;
    public static final UDButtonSize Small = null;
    public static final /* synthetic */ UDButtonSize[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<UDButtonSize> getEntries() {
        return b;
    }

    static {
        UDButtonSize r0 = new UDButtonSize("Column", 0);
        Column = r0;
        UDButtonSize r1 = new UDButtonSize("Big", 1);
        Big = r1;
        UDButtonSize r3 = new UDButtonSize("Middle", 2);
        Middle = r3;
        UDButtonSize r5 = new UDButtonSize("Small", 3);
        Small = r5;
        UDButtonSize r7 = new UDButtonSize("Custom", 4);
        Custom = r7;
        UDButtonSize[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static UDButtonSize[] values() {
        return (UDButtonSize[]) a.clone();
    }

    public static UDButtonSize valueOf(String r1) {
        return (UDButtonSize) r27.a.a(UDButtonSize.class, r1);
    }

    public UDButtonSize(String r1, int r2) {
        super(r1, r2);
    }
}
