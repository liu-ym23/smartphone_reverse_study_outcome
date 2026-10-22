package com.obric.memorydata.datastorage.dataaging.strategy.factory;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/datastorage/dataaging/strategy/factory/AgingDatabaseScope;", "", "<init>", "(Ljava/lang/String;I)V", "GLOBAL", "PERSONAL", "app_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum AgingDatabaseScope extends Enum<AgingDatabaseScope> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AgingDatabaseScope[] $VALUES = null;
    public static final AgingDatabaseScope GLOBAL = null;
    public static final AgingDatabaseScope PERSONAL = null;

    private static final /* synthetic */ AgingDatabaseScope[] $values() {
        return new AgingDatabaseScope[]{GLOBAL, PERSONAL};
    }

    static {
        GLOBAL = new AgingDatabaseScope("GLOBAL", 0);
        PERSONAL = new AgingDatabaseScope("PERSONAL", 1);
        AgingDatabaseScope[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private AgingDatabaseScope(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<AgingDatabaseScope> getEntries() {
        return $ENTRIES;
    }

    public static AgingDatabaseScope valueOf(String r2) {
        return (AgingDatabaseScope) ZeusTransformUtils.preCheckCast(Enum.valueOf(AgingDatabaseScope.class, r2), AgingDatabaseScope.class, "com.obric.memorydata.plugin");
    }

    public static AgingDatabaseScope[] values() {
        return (AgingDatabaseScope[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AgingDatabaseScope[].class, "com.obric.memorydata.plugin");
    }
}
