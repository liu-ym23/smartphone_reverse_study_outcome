package com.larksuite.component.universe_design.checkbox.compose;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larksuite/component/universe_design/checkbox/compose/UDCheckBoxSize;", "", "<init>", "(Ljava/lang/String;I)V", "Normal", "Small", "universe-ui-checkbox_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum UDCheckBoxSize extends Enum<UDCheckBoxSize> {
    public static final UDCheckBoxSize Normal = null;
    public static final UDCheckBoxSize Small = null;
    public static final /* synthetic */ UDCheckBoxSize[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<UDCheckBoxSize> getEntries() {
        return b;
    }

    static {
        UDCheckBoxSize r0 = new UDCheckBoxSize("Normal", 0);
        Normal = r0;
        UDCheckBoxSize r1 = new UDCheckBoxSize("Small", 1);
        Small = r1;
        UDCheckBoxSize[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static UDCheckBoxSize[] values() {
        return (UDCheckBoxSize[]) a.clone();
    }

    public static UDCheckBoxSize valueOf(String r1) {
        return (UDCheckBoxSize) r27.a.a(UDCheckBoxSize.class, r1);
    }

    public UDCheckBoxSize(String r1, int r2) {
        super(r1, r2);
    }
}
