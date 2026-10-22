package com.obric.memorydata.memory.auditory;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/memory/auditory/AuditoryPlatformSupport;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "SUPPORTED", "UNSUPPORTED", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum AuditoryPlatformSupport extends Enum<AuditoryPlatformSupport> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AuditoryPlatformSupport[] $VALUES = null;
    public static final AuditoryPlatformSupport SUPPORTED = null;
    public static final AuditoryPlatformSupport UNKNOWN = null;
    public static final AuditoryPlatformSupport UNSUPPORTED = null;

    private static final /* synthetic */ AuditoryPlatformSupport[] $values() {
        return new AuditoryPlatformSupport[]{UNKNOWN, SUPPORTED, UNSUPPORTED};
    }

    static {
        UNKNOWN = new AuditoryPlatformSupport("UNKNOWN", 0);
        SUPPORTED = new AuditoryPlatformSupport("SUPPORTED", 1);
        UNSUPPORTED = new AuditoryPlatformSupport("UNSUPPORTED", 2);
        AuditoryPlatformSupport[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private AuditoryPlatformSupport(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<AuditoryPlatformSupport> getEntries() {
        return $ENTRIES;
    }

    public static AuditoryPlatformSupport valueOf(String r2) {
        return (AuditoryPlatformSupport) ZeusTransformUtils.preCheckCast(Enum.valueOf(AuditoryPlatformSupport.class, r2), AuditoryPlatformSupport.class, "com.obric.memorydata.plugin");
    }

    public static AuditoryPlatformSupport[] values() {
        return (AuditoryPlatformSupport[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AuditoryPlatformSupport[].class, "com.obric.memorydata.plugin");
    }
}
