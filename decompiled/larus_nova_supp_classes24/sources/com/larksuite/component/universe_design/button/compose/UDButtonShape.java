package com.larksuite.component.universe_design.button.compose;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larksuite/component/universe_design/button/compose/UDButtonShape;", "", "<init>", "(Ljava/lang/String;I)V", "Rounded", "Circle", "universe-ui-button_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum UDButtonShape extends Enum<UDButtonShape> {
    public static final UDButtonShape Circle = null;
    public static final UDButtonShape Rounded = null;
    public static final /* synthetic */ UDButtonShape[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<UDButtonShape> getEntries() {
        return b;
    }

    static {
        UDButtonShape r0 = new UDButtonShape("Rounded", 0);
        Rounded = r0;
        UDButtonShape r1 = new UDButtonShape("Circle", 1);
        Circle = r1;
        UDButtonShape[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static UDButtonShape[] values() {
        return (UDButtonShape[]) a.clone();
    }

    public static UDButtonShape valueOf(String r1) {
        return (UDButtonShape) r27.a.a(UDButtonShape.class, r1);
    }

    public UDButtonShape(String r1, int r2) {
        super(r1, r2);
    }
}
