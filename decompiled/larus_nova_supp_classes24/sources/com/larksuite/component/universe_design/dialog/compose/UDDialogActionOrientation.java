package com.larksuite.component.universe_design.dialog.compose;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larksuite/component/universe_design/dialog/compose/UDDialogActionOrientation;", "", "<init>", "(Ljava/lang/String;I)V", "Auto", "Horizontal", "Vertical", "universe-ui-dialog_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum UDDialogActionOrientation extends Enum<UDDialogActionOrientation> {
    public static final UDDialogActionOrientation Auto = null;
    public static final UDDialogActionOrientation Horizontal = null;
    public static final UDDialogActionOrientation Vertical = null;
    public static final /* synthetic */ UDDialogActionOrientation[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<UDDialogActionOrientation> getEntries() {
        return b;
    }

    static {
        UDDialogActionOrientation r0 = new UDDialogActionOrientation("Auto", 0);
        Auto = r0;
        UDDialogActionOrientation r1 = new UDDialogActionOrientation("Horizontal", 1);
        Horizontal = r1;
        UDDialogActionOrientation r3 = new UDDialogActionOrientation("Vertical", 2);
        Vertical = r3;
        UDDialogActionOrientation[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static UDDialogActionOrientation[] values() {
        return (UDDialogActionOrientation[]) a.clone();
    }

    public static UDDialogActionOrientation valueOf(String r1) {
        return (UDDialogActionOrientation) r27.a.a(UDDialogActionOrientation.class, r1);
    }

    public UDDialogActionOrientation(String r1, int r2) {
        super(r1, r2);
    }
}
