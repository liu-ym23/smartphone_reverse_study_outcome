package com.obric.memorydata.migration.sdk;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/migration/sdk/DbRole;", "", "<init>", "(Ljava/lang/String;I)V", "GLOBAL", "USER", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum DbRole extends Enum<DbRole> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ DbRole[] $VALUES = null;
    public static final DbRole GLOBAL = null;
    public static final DbRole USER = null;

    private static final /* synthetic */ DbRole[] $values() {
        return new DbRole[]{GLOBAL, USER};
    }

    static {
        GLOBAL = new DbRole("GLOBAL", 0);
        USER = new DbRole("USER", 1);
        DbRole[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private DbRole(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<DbRole> getEntries() {
        return $ENTRIES;
    }

    public static DbRole valueOf(String r2) {
        return (DbRole) ZeusTransformUtils.preCheckCast(Enum.valueOf(DbRole.class, r2), DbRole.class, "com.obric.memorydata.plugin");
    }

    public static DbRole[] values() {
        return (DbRole[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DbRole[].class, "com.obric.memorydata.plugin");
    }
}
