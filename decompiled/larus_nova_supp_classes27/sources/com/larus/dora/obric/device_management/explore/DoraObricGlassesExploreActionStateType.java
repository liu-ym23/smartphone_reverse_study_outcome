package com.larus.dora.obric.device_management.explore;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesExploreActionStateType;", "", "<init>", "(Ljava/lang/String;I)V", "NATURAL_WAKE", "DIARY", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraObricGlassesExploreActionStateType extends Enum<DoraObricGlassesExploreActionStateType> {
    public static final DoraObricGlassesExploreActionStateType DIARY = null;
    public static final DoraObricGlassesExploreActionStateType NATURAL_WAKE = null;
    public static final /* synthetic */ DoraObricGlassesExploreActionStateType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DoraObricGlassesExploreActionStateType> getEntries() {
        return b;
    }

    static {
        DoraObricGlassesExploreActionStateType r0 = new DoraObricGlassesExploreActionStateType("NATURAL_WAKE", 0);
        NATURAL_WAKE = r0;
        DoraObricGlassesExploreActionStateType r1 = new DoraObricGlassesExploreActionStateType("DIARY", 1);
        DIARY = r1;
        DoraObricGlassesExploreActionStateType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static DoraObricGlassesExploreActionStateType[] values() {
        return (DoraObricGlassesExploreActionStateType[]) a.clone();
    }

    public static DoraObricGlassesExploreActionStateType valueOf(String r1) {
        return (DoraObricGlassesExploreActionStateType) r27.a.a(DoraObricGlassesExploreActionStateType.class, r1);
    }

    public DoraObricGlassesExploreActionStateType(String r1, int r2) {
        super(r1, r2);
    }
}
