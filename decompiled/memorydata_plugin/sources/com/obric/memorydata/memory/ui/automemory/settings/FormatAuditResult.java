package com.obric.memorydata.memory.ui.automemory.settings;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/settings/FormatAuditResult;", "", "<init>", "(Ljava/lang/String;I)V", "PASSED", "COMPLIANCE_FAILED", "RELEVANCE_FAILED", "SERVICE_FAILED", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum FormatAuditResult extends Enum<FormatAuditResult> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ FormatAuditResult[] $VALUES = null;
    public static final FormatAuditResult COMPLIANCE_FAILED = null;
    public static final FormatAuditResult PASSED = null;
    public static final FormatAuditResult RELEVANCE_FAILED = null;
    public static final FormatAuditResult SERVICE_FAILED = null;

    private static final /* synthetic */ FormatAuditResult[] $values() {
        return new FormatAuditResult[]{PASSED, COMPLIANCE_FAILED, RELEVANCE_FAILED, SERVICE_FAILED};
    }

    static {
        PASSED = new FormatAuditResult("PASSED", 0);
        COMPLIANCE_FAILED = new FormatAuditResult("COMPLIANCE_FAILED", 1);
        RELEVANCE_FAILED = new FormatAuditResult("RELEVANCE_FAILED", 2);
        SERVICE_FAILED = new FormatAuditResult("SERVICE_FAILED", 3);
        FormatAuditResult[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private FormatAuditResult(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<FormatAuditResult> getEntries() {
        return $ENTRIES;
    }

    public static FormatAuditResult valueOf(String r2) {
        return (FormatAuditResult) ZeusTransformUtils.preCheckCast(Enum.valueOf(FormatAuditResult.class, r2), FormatAuditResult.class, "com.obric.memorydata.plugin");
    }

    public static FormatAuditResult[] values() {
        return (FormatAuditResult[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FormatAuditResult[].class, "com.obric.memorydata.plugin");
    }
}
