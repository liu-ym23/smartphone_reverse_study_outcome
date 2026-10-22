package com.larus.dora.obric.device_management.explore;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesImagePageType;", "", "<init>", "(Ljava/lang/String;I)V", "EXPLORE", "DETAIL", "BASIC_DETAIL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraObricGlassesImagePageType extends Enum<DoraObricGlassesImagePageType> {
    public static final DoraObricGlassesImagePageType BASIC_DETAIL = null;
    public static final DoraObricGlassesImagePageType DETAIL = null;
    public static final DoraObricGlassesImagePageType EXPLORE = null;
    public static final /* synthetic */ DoraObricGlassesImagePageType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DoraObricGlassesImagePageType> getEntries() {
        return b;
    }

    static {
        DoraObricGlassesImagePageType r0 = new DoraObricGlassesImagePageType("EXPLORE", 0);
        EXPLORE = r0;
        DoraObricGlassesImagePageType r1 = new DoraObricGlassesImagePageType("DETAIL", 1);
        DETAIL = r1;
        DoraObricGlassesImagePageType r3 = new DoraObricGlassesImagePageType("BASIC_DETAIL", 2);
        BASIC_DETAIL = r3;
        DoraObricGlassesImagePageType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static DoraObricGlassesImagePageType[] values() {
        return (DoraObricGlassesImagePageType[]) a.clone();
    }

    public static DoraObricGlassesImagePageType valueOf(String r1) {
        return (DoraObricGlassesImagePageType) r27.a.a(DoraObricGlassesImagePageType.class, r1);
    }

    public DoraObricGlassesImagePageType(String r1, int r2) {
        super(r1, r2);
    }
}
