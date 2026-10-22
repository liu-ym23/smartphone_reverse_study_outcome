package com.ss.android.lark.officesdk.launcher;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/launcher/OfficeLaunchSchedulerType;", "", "<init>", "(Ljava/lang/String;I)V", "V1", "V2", "officesdk-assemble_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum OfficeLaunchSchedulerType extends Enum<OfficeLaunchSchedulerType> {
    public static final OfficeLaunchSchedulerType V1 = null;
    public static final OfficeLaunchSchedulerType V2 = null;
    public static final /* synthetic */ OfficeLaunchSchedulerType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<OfficeLaunchSchedulerType> getEntries() {
        return b;
    }

    static {
        OfficeLaunchSchedulerType r0 = new OfficeLaunchSchedulerType("V1", 0);
        V1 = r0;
        OfficeLaunchSchedulerType r1 = new OfficeLaunchSchedulerType("V2", 1);
        V2 = r1;
        OfficeLaunchSchedulerType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static OfficeLaunchSchedulerType[] values() {
        return (OfficeLaunchSchedulerType[]) a.clone();
    }

    public static OfficeLaunchSchedulerType valueOf(String r1) {
        return (OfficeLaunchSchedulerType) r27.a.a(OfficeLaunchSchedulerType.class, r1);
    }

    public OfficeLaunchSchedulerType(String r1, int r2) {
        super(r1, r2);
    }
}
