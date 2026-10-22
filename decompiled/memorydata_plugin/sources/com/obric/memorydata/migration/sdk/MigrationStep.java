package com.obric.memorydata.migration.sdk;

import com.obric.memorydata.database.entity.RawObservationEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/migration/sdk/MigrationStep;", "", "<init>", "(Ljava/lang/String;I)V", "CONNECTING", "BACKING_UP", "TRANSFERRING", "RESTORING", "SUCCESS", RawObservationEntity.STATE_FAILED, "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum MigrationStep extends Enum<MigrationStep> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ MigrationStep[] $VALUES = null;
    public static final MigrationStep BACKING_UP = null;
    public static final MigrationStep CONNECTING = null;
    public static final MigrationStep FAILED = null;
    public static final MigrationStep RESTORING = null;
    public static final MigrationStep SUCCESS = null;
    public static final MigrationStep TRANSFERRING = null;

    private static final /* synthetic */ MigrationStep[] $values() {
        return new MigrationStep[]{CONNECTING, BACKING_UP, TRANSFERRING, RESTORING, SUCCESS, FAILED};
    }

    static {
        CONNECTING = new MigrationStep("CONNECTING", 0);
        BACKING_UP = new MigrationStep("BACKING_UP", 1);
        TRANSFERRING = new MigrationStep("TRANSFERRING", 2);
        RESTORING = new MigrationStep("RESTORING", 3);
        SUCCESS = new MigrationStep("SUCCESS", 4);
        FAILED = new MigrationStep(RawObservationEntity.STATE_FAILED, 5);
        MigrationStep[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private MigrationStep(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<MigrationStep> getEntries() {
        return $ENTRIES;
    }

    public static MigrationStep valueOf(String r2) {
        return (MigrationStep) ZeusTransformUtils.preCheckCast(Enum.valueOf(MigrationStep.class, r2), MigrationStep.class, "com.obric.memorydata.plugin");
    }

    public static MigrationStep[] values() {
        return (MigrationStep[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MigrationStep[].class, "com.obric.memorydata.plugin");
    }
}
