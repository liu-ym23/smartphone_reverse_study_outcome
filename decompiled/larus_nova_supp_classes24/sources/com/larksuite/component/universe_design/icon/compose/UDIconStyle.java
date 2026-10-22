package com.larksuite.component.universe_design.icon.compose;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larksuite/component/universe_design/icon/compose/UDIconStyle;", "", "<init>", "(Ljava/lang/String;I)V", "Outlined", "Filled", "Colorful", "Other", "universe-ui-icon_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum UDIconStyle extends Enum<UDIconStyle> {
    public static final UDIconStyle Colorful = null;
    public static final UDIconStyle Filled = null;
    public static final UDIconStyle Other = null;
    public static final UDIconStyle Outlined = null;
    public static final /* synthetic */ UDIconStyle[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<UDIconStyle> getEntries() {
        return b;
    }

    static {
        UDIconStyle r0 = new UDIconStyle("Outlined", 0);
        Outlined = r0;
        UDIconStyle r1 = new UDIconStyle("Filled", 1);
        Filled = r1;
        UDIconStyle r3 = new UDIconStyle("Colorful", 2);
        Colorful = r3;
        UDIconStyle r5 = new UDIconStyle("Other", 3);
        Other = r5;
        UDIconStyle[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static UDIconStyle[] values() {
        return (UDIconStyle[]) a.clone();
    }

    public static UDIconStyle valueOf(String r1) {
        return (UDIconStyle) r27.a.a(UDIconStyle.class, r1);
    }

    public UDIconStyle(String r1, int r2) {
        super(r1, r2);
    }
}
