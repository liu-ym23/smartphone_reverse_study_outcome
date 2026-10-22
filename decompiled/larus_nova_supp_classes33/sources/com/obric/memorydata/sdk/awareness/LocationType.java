package com.obric.memorydata.sdk.awareness;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/sdk/awareness/LocationType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "HOME", "COMPANY", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum LocationType extends Enum<LocationType> {
    public static final LocationType COMPANY = null;
    public static final LocationType HOME = null;
    public static final /* synthetic */ LocationType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<LocationType> getEntries() {
        return b;
    }

    static {
        LocationType r0 = new LocationType("HOME", 0, "location_home_gps");
        HOME = r0;
        LocationType r1 = new LocationType("COMPANY", 1, "location_company_gps");
        COMPANY = r1;
        LocationType[] r2 = {r0, r1};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
    }

    public static LocationType[] values() {
        return (LocationType[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static LocationType valueOf(String r1) {
        return (LocationType) a.a(LocationType.class, r1);
    }

    public LocationType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
