package com.obric.memorydata.memory.ui.feedback;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/ui/feedback/MemoryFeedbackOdpReportResult;", "", "<init>", "(Ljava/lang/String;I)V", "DISABLED", "MISSING_DATA", "SUCCESS", "FAILURE", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum MemoryFeedbackOdpReportResult extends Enum<MemoryFeedbackOdpReportResult> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ MemoryFeedbackOdpReportResult[] $VALUES = null;
    public static final MemoryFeedbackOdpReportResult DISABLED = null;
    public static final MemoryFeedbackOdpReportResult FAILURE = null;
    public static final MemoryFeedbackOdpReportResult MISSING_DATA = null;
    public static final MemoryFeedbackOdpReportResult SUCCESS = null;

    private static final /* synthetic */ MemoryFeedbackOdpReportResult[] $values() {
        return new MemoryFeedbackOdpReportResult[]{DISABLED, MISSING_DATA, SUCCESS, FAILURE};
    }

    static {
        DISABLED = new MemoryFeedbackOdpReportResult("DISABLED", 0);
        MISSING_DATA = new MemoryFeedbackOdpReportResult("MISSING_DATA", 1);
        SUCCESS = new MemoryFeedbackOdpReportResult("SUCCESS", 2);
        FAILURE = new MemoryFeedbackOdpReportResult("FAILURE", 3);
        MemoryFeedbackOdpReportResult[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private MemoryFeedbackOdpReportResult(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<MemoryFeedbackOdpReportResult> getEntries() {
        return $ENTRIES;
    }

    public static MemoryFeedbackOdpReportResult valueOf(String r2) {
        return (MemoryFeedbackOdpReportResult) ZeusTransformUtils.preCheckCast(Enum.valueOf(MemoryFeedbackOdpReportResult.class, r2), MemoryFeedbackOdpReportResult.class, "com.obric.memorydata.plugin");
    }

    public static MemoryFeedbackOdpReportResult[] values() {
        return (MemoryFeedbackOdpReportResult[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MemoryFeedbackOdpReportResult[].class, "com.obric.memorydata.plugin");
    }
}
