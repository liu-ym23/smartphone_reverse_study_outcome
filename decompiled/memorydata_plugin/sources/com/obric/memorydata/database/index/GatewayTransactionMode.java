package com.obric.memorydata.database.index;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/database/index/GatewayTransactionMode;", "", "<init>", "(Ljava/lang/String;I)V", "OWNED", "OBSERVED_IN_CALLER_TRANSACTION", "PENDING_ONLY_IN_CALLER_TRANSACTION", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum GatewayTransactionMode extends Enum<GatewayTransactionMode> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ GatewayTransactionMode[] $VALUES = null;
    public static final GatewayTransactionMode OBSERVED_IN_CALLER_TRANSACTION = null;
    public static final GatewayTransactionMode OWNED = null;
    public static final GatewayTransactionMode PENDING_ONLY_IN_CALLER_TRANSACTION = null;

    private static final /* synthetic */ GatewayTransactionMode[] $values() {
        return new GatewayTransactionMode[]{OWNED, OBSERVED_IN_CALLER_TRANSACTION, PENDING_ONLY_IN_CALLER_TRANSACTION};
    }

    static {
        OWNED = new GatewayTransactionMode("OWNED", 0);
        OBSERVED_IN_CALLER_TRANSACTION = new GatewayTransactionMode("OBSERVED_IN_CALLER_TRANSACTION", 1);
        PENDING_ONLY_IN_CALLER_TRANSACTION = new GatewayTransactionMode("PENDING_ONLY_IN_CALLER_TRANSACTION", 2);
        GatewayTransactionMode[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private GatewayTransactionMode(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<GatewayTransactionMode> getEntries() {
        return $ENTRIES;
    }

    public static GatewayTransactionMode valueOf(String r2) {
        return (GatewayTransactionMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(GatewayTransactionMode.class, r2), GatewayTransactionMode.class, "com.obric.memorydata.plugin");
    }

    public static GatewayTransactionMode[] values() {
        return (GatewayTransactionMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), GatewayTransactionMode[].class, "com.obric.memorydata.plugin");
    }
}
