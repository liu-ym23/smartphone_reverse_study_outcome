package com.larus.platform.model;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/platform/model/CoordinateType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "GCJ_O2", "WGS_84", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum CoordinateType extends Enum<CoordinateType> {
    public static final CoordinateType GCJ_O2 = null;
    public static final CoordinateType WGS_84 = null;
    public static final /* synthetic */ CoordinateType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String type;

    public static EnumEntries<CoordinateType> getEntries() {
        return b;
    }

    static {
        CoordinateType r0 = new CoordinateType("GCJ_O2", 0, "gcj02");
        GCJ_O2 = r0;
        CoordinateType r1 = new CoordinateType("WGS_84", 1, "wgs84");
        WGS_84 = r1;
        CoordinateType[] r2 = {r0, r1};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
    }

    public static CoordinateType[] values() {
        return (CoordinateType[]) a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public static CoordinateType valueOf(String r1) {
        return (CoordinateType) a.a(CoordinateType.class, r1);
    }

    public CoordinateType(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}
