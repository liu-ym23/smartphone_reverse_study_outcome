package com.ss.android.lark.preload.v2.condition.clean;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/preload/v2/condition/clean/MemoryLow$MemoryState;", "", "<init>", "(Ljava/lang/String;I)V", "CRITICAL", "MODERATE", "LOW", "UNKNOWN", "preload-manager_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MemoryLow$MemoryState extends Enum<MemoryLow$MemoryState> {
    public static final MemoryLow$MemoryState CRITICAL = null;
    public static final MemoryLow$MemoryState LOW = null;
    public static final MemoryLow$MemoryState MODERATE = null;
    public static final MemoryLow$MemoryState UNKNOWN = null;
    public static final /* synthetic */ MemoryLow$MemoryState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MemoryLow$MemoryState> getEntries() {
        return b;
    }

    static {
        MemoryLow$MemoryState r0 = new MemoryLow$MemoryState("CRITICAL", 0);
        CRITICAL = r0;
        MemoryLow$MemoryState r1 = new MemoryLow$MemoryState("MODERATE", 1);
        MODERATE = r1;
        MemoryLow$MemoryState r3 = new MemoryLow$MemoryState("LOW", 2);
        LOW = r3;
        MemoryLow$MemoryState r5 = new MemoryLow$MemoryState("UNKNOWN", 3);
        UNKNOWN = r5;
        MemoryLow$MemoryState[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static MemoryLow$MemoryState[] values() {
        return (MemoryLow$MemoryState[]) a.clone();
    }

    public static MemoryLow$MemoryState valueOf(String r1) {
        return (MemoryLow$MemoryState) a.a(MemoryLow$MemoryState.class, r1);
    }

    public MemoryLow$MemoryState(String r1, int r2) {
        super(r1, r2);
    }
}
