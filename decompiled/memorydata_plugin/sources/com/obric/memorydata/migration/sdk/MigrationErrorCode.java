package com.obric.memorydata.migration.sdk;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/migration/sdk/MigrationErrorCode;", "", "<init>", "(Ljava/lang/String;I)V", "UID_MISMATCH", "VERSION_TOO_LOW", "CONNECT_FAILED", "DISCONNECTED", "NO_SPACE_LEFT", "OTHER", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum MigrationErrorCode extends Enum<MigrationErrorCode> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ MigrationErrorCode[] $VALUES = null;
    public static final MigrationErrorCode CONNECT_FAILED = null;
    public static final MigrationErrorCode DISCONNECTED = null;
    public static final MigrationErrorCode NO_SPACE_LEFT = null;
    public static final MigrationErrorCode OTHER = null;
    public static final MigrationErrorCode UID_MISMATCH = null;
    public static final MigrationErrorCode VERSION_TOO_LOW = null;

    private static final /* synthetic */ MigrationErrorCode[] $values() {
        return new MigrationErrorCode[]{UID_MISMATCH, VERSION_TOO_LOW, CONNECT_FAILED, DISCONNECTED, NO_SPACE_LEFT, OTHER};
    }

    static {
        UID_MISMATCH = new MigrationErrorCode("UID_MISMATCH", 0);
        VERSION_TOO_LOW = new MigrationErrorCode("VERSION_TOO_LOW", 1);
        CONNECT_FAILED = new MigrationErrorCode("CONNECT_FAILED", 2);
        DISCONNECTED = new MigrationErrorCode("DISCONNECTED", 3);
        NO_SPACE_LEFT = new MigrationErrorCode("NO_SPACE_LEFT", 4);
        OTHER = new MigrationErrorCode("OTHER", 5);
        MigrationErrorCode[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private MigrationErrorCode(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<MigrationErrorCode> getEntries() {
        return $ENTRIES;
    }

    public static MigrationErrorCode valueOf(String r2) {
        return (MigrationErrorCode) ZeusTransformUtils.preCheckCast(Enum.valueOf(MigrationErrorCode.class, r2), MigrationErrorCode.class, "com.obric.memorydata.plugin");
    }

    public static MigrationErrorCode[] values() {
        return (MigrationErrorCode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MigrationErrorCode[].class, "com.obric.memorydata.plugin");
    }
}
