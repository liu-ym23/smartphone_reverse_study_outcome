package com.ss.android.lark.preload.v2.condition.clean;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/preload/v2/condition/clean/SwitchAccount$MemoryState;", "", "<init>", "(Ljava/lang/String;I)V", "CRITICAL", "UNKNOWN", "preload-manager_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum SwitchAccount$MemoryState extends Enum<SwitchAccount$MemoryState> {
    public static final SwitchAccount$MemoryState CRITICAL = null;
    public static final SwitchAccount$MemoryState UNKNOWN = null;
    public static final /* synthetic */ SwitchAccount$MemoryState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<SwitchAccount$MemoryState> getEntries() {
        return b;
    }

    static {
        SwitchAccount$MemoryState r0 = new SwitchAccount$MemoryState("CRITICAL", 0);
        CRITICAL = r0;
        SwitchAccount$MemoryState r1 = new SwitchAccount$MemoryState("UNKNOWN", 1);
        UNKNOWN = r1;
        SwitchAccount$MemoryState[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static SwitchAccount$MemoryState[] values() {
        return (SwitchAccount$MemoryState[]) a.clone();
    }

    public static SwitchAccount$MemoryState valueOf(String r1) {
        return (SwitchAccount$MemoryState) a.a(SwitchAccount$MemoryState.class, r1);
    }

    public SwitchAccount$MemoryState(String r1, int r2) {
        super(r1, r2);
    }
}
