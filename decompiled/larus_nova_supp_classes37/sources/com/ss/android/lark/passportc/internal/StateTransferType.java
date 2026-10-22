package com.ss.android.lark.passportc.internal;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/passportc/internal/StateTransferType;", "", "<init>", "(Ljava/lang/String;I)V", "Online", "Swap", "Offline", "Clean", "UpdateToDate", "Illegal", "passport-container-manager_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final enum StateTransferType extends Enum<StateTransferType> {
    public static final StateTransferType Clean = null;
    public static final StateTransferType Illegal = null;
    public static final StateTransferType Offline = null;
    public static final StateTransferType Online = null;
    public static final StateTransferType Swap = null;
    public static final StateTransferType UpdateToDate = null;
    public static final /* synthetic */ StateTransferType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<StateTransferType> getEntries() {
        return b;
    }

    static {
        StateTransferType r0 = new StateTransferType("Online", 0);
        Online = r0;
        StateTransferType r1 = new StateTransferType("Swap", 1);
        Swap = r1;
        StateTransferType r3 = new StateTransferType("Offline", 2);
        Offline = r3;
        StateTransferType r5 = new StateTransferType("Clean", 3);
        Clean = r5;
        StateTransferType r7 = new StateTransferType("UpdateToDate", 4);
        UpdateToDate = r7;
        StateTransferType r9 = new StateTransferType("Illegal", 5);
        Illegal = r9;
        StateTransferType[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static StateTransferType[] values() {
        return (StateTransferType[]) a.clone();
    }

    public static StateTransferType valueOf(String r1) {
        return (StateTransferType) r27.a.a(StateTransferType.class, r1);
    }

    public StateTransferType(String r1, int r2) {
        super(r1, r2);
    }
}
