package com.ss.android.lark.preload.v2.condition.trigger.device;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/preload/v2/condition/trigger/device/CPUState$CPULevel;", "", "<init>", "(Ljava/lang/String;I)V", "BUSY", "IDLE", "NORMAL", "preload-manager_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum CPUState$CPULevel extends Enum<CPUState$CPULevel> {
    public static final CPUState$CPULevel BUSY = null;
    public static final CPUState$CPULevel IDLE = null;
    public static final CPUState$CPULevel NORMAL = null;
    public static final /* synthetic */ CPUState$CPULevel[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CPUState$CPULevel> getEntries() {
        return b;
    }

    static {
        CPUState$CPULevel r0 = new CPUState$CPULevel("BUSY", 0);
        BUSY = r0;
        CPUState$CPULevel r1 = new CPUState$CPULevel("IDLE", 1);
        IDLE = r1;
        CPUState$CPULevel r3 = new CPUState$CPULevel("NORMAL", 2);
        NORMAL = r3;
        CPUState$CPULevel[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static CPUState$CPULevel[] values() {
        return (CPUState$CPULevel[]) a.clone();
    }

    public static CPUState$CPULevel valueOf(String r1) {
        return (CPUState$CPULevel) a.a(CPUState$CPULevel.class, r1);
    }

    public CPUState$CPULevel(String r1, int r2) {
        super(r1, r2);
    }
}
