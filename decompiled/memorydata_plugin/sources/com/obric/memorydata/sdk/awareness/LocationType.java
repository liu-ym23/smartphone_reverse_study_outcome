package com.obric.memorydata.sdk.awareness;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/sdk/awareness/LocationType;", "", EventBody.KEY_VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "HOME", "COMPANY", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum LocationType extends Enum<LocationType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ LocationType[] $VALUES = null;
    public static final LocationType COMPANY = null;
    public static final LocationType HOME = null;
    private final String value;

    private static final /* synthetic */ LocationType[] $values() {
        return new LocationType[]{HOME, COMPANY};
    }

    static {
        HOME = new LocationType("HOME", 0, "location_home_gps");
        COMPANY = new LocationType("COMPANY", 1, "location_company_gps");
        LocationType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private LocationType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static EnumEntries<LocationType> getEntries() {
        return $ENTRIES;
    }

    public static LocationType valueOf(String r2) {
        return (LocationType) ZeusTransformUtils.preCheckCast(Enum.valueOf(LocationType.class, r2), LocationType.class, "com.obric.memorydata.plugin");
    }

    public static LocationType[] values() {
        return (LocationType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), LocationType[].class, "com.obric.memorydata.plugin");
    }

    public final String getValue() {
        return this.value;
    }
}
