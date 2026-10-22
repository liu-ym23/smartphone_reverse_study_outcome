package com.obric.memorydata.datatransport.manager;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/datatransport/manager/ExportStatisticsSection;", "", "<init>", "(Ljava/lang/String;I)V", "DATA_TABLE", "ATTACHMENT", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ExportStatisticsSection extends Enum<ExportStatisticsSection> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ExportStatisticsSection[] $VALUES = null;
    public static final ExportStatisticsSection ATTACHMENT = null;
    public static final ExportStatisticsSection DATA_TABLE = null;

    private static final /* synthetic */ ExportStatisticsSection[] $values() {
        return new ExportStatisticsSection[]{DATA_TABLE, ATTACHMENT};
    }

    static {
        DATA_TABLE = new ExportStatisticsSection("DATA_TABLE", 0);
        ATTACHMENT = new ExportStatisticsSection("ATTACHMENT", 1);
        ExportStatisticsSection[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private ExportStatisticsSection(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<ExportStatisticsSection> getEntries() {
        return $ENTRIES;
    }

    public static ExportStatisticsSection valueOf(String r2) {
        return (ExportStatisticsSection) ZeusTransformUtils.preCheckCast(Enum.valueOf(ExportStatisticsSection.class, r2), ExportStatisticsSection.class, "com.obric.memorydata.plugin");
    }

    public static ExportStatisticsSection[] values() {
        return (ExportStatisticsSection[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ExportStatisticsSection[].class, "com.obric.memorydata.plugin");
    }
}
