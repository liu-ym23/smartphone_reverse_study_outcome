package com.larksuite.component.universe_design.dialog.compose;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larksuite/component/universe_design/dialog/compose/UDDialogActionRole;", "", "<init>", "(Ljava/lang/String;I)V", "Primary", "Secondary", "Danger", "universe-ui-dialog_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum UDDialogActionRole extends Enum<UDDialogActionRole> {
    public static final UDDialogActionRole Danger = null;
    public static final UDDialogActionRole Primary = null;
    public static final UDDialogActionRole Secondary = null;
    public static final /* synthetic */ UDDialogActionRole[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<UDDialogActionRole> getEntries() {
        return b;
    }

    static {
        UDDialogActionRole r0 = new UDDialogActionRole("Primary", 0);
        Primary = r0;
        UDDialogActionRole r1 = new UDDialogActionRole("Secondary", 1);
        Secondary = r1;
        UDDialogActionRole r3 = new UDDialogActionRole("Danger", 2);
        Danger = r3;
        UDDialogActionRole[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static UDDialogActionRole[] values() {
        return (UDDialogActionRole[]) a.clone();
    }

    public static UDDialogActionRole valueOf(String r1) {
        return (UDDialogActionRole) r27.a.a(UDDialogActionRole.class, r1);
    }

    public UDDialogActionRole(String r1, int r2) {
        super(r1, r2);
    }
}
