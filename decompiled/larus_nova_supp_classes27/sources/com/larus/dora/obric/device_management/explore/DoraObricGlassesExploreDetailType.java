package com.larus.dora.obric.device_management.explore;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesExploreDetailType;", "", "<init>", "(Ljava/lang/String;I)V", "INTRODUCTION", "BASIC_LIST", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraObricGlassesExploreDetailType extends Enum<DoraObricGlassesExploreDetailType> {
    public static final DoraObricGlassesExploreDetailType BASIC_LIST = null;
    public static final DoraObricGlassesExploreDetailType INTRODUCTION = null;
    public static final /* synthetic */ DoraObricGlassesExploreDetailType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DoraObricGlassesExploreDetailType> getEntries() {
        return b;
    }

    static {
        DoraObricGlassesExploreDetailType r0 = new DoraObricGlassesExploreDetailType("INTRODUCTION", 0);
        INTRODUCTION = r0;
        DoraObricGlassesExploreDetailType r1 = new DoraObricGlassesExploreDetailType("BASIC_LIST", 1);
        BASIC_LIST = r1;
        DoraObricGlassesExploreDetailType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static DoraObricGlassesExploreDetailType[] values() {
        return (DoraObricGlassesExploreDetailType[]) a.clone();
    }

    public static DoraObricGlassesExploreDetailType valueOf(String r1) {
        return (DoraObricGlassesExploreDetailType) r27.a.a(DoraObricGlassesExploreDetailType.class, r1);
    }

    public DoraObricGlassesExploreDetailType(String r1, int r2) {
        super(r1, r2);
    }
}
