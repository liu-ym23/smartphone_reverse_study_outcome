package com.larksuite.component.universe_design.checkbox.compose;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larksuite/component/universe_design/checkbox/compose/UDCheckBoxType;", "", "<init>", "(Ljava/lang/String;I)V", "CheckBox", "Radio", "CheckMark", "universe-ui-checkbox_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum UDCheckBoxType extends Enum<UDCheckBoxType> {
    public static final UDCheckBoxType CheckBox = null;
    public static final UDCheckBoxType CheckMark = null;
    public static final UDCheckBoxType Radio = null;
    public static final /* synthetic */ UDCheckBoxType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<UDCheckBoxType> getEntries() {
        return b;
    }

    static {
        UDCheckBoxType r0 = new UDCheckBoxType("CheckBox", 0);
        CheckBox = r0;
        UDCheckBoxType r1 = new UDCheckBoxType("Radio", 1);
        Radio = r1;
        UDCheckBoxType r3 = new UDCheckBoxType("CheckMark", 2);
        CheckMark = r3;
        UDCheckBoxType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static UDCheckBoxType[] values() {
        return (UDCheckBoxType[]) a.clone();
    }

    public static UDCheckBoxType valueOf(String r1) {
        return (UDCheckBoxType) r27.a.a(UDCheckBoxType.class, r1);
    }

    public UDCheckBoxType(String r1, int r2) {
        super(r1, r2);
    }
}
