package com.obric.memorydata.database.util.file_utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/database/util/file_utils/PptxPreflightRejectReason;", "", "<init>", "(Ljava/lang/String;I)V", "EXPAT_NAME_REFERENCE_COUNT", "ZIP_RESOURCE_LIMIT", "XML_RESOURCE_LIMIT", "XML_STRUCTURE", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum PptxPreflightRejectReason extends Enum<PptxPreflightRejectReason> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ PptxPreflightRejectReason[] $VALUES = null;
    public static final PptxPreflightRejectReason EXPAT_NAME_REFERENCE_COUNT = null;
    public static final PptxPreflightRejectReason XML_RESOURCE_LIMIT = null;
    public static final PptxPreflightRejectReason XML_STRUCTURE = null;
    public static final PptxPreflightRejectReason ZIP_RESOURCE_LIMIT = null;

    private static final /* synthetic */ PptxPreflightRejectReason[] $values() {
        return new PptxPreflightRejectReason[]{EXPAT_NAME_REFERENCE_COUNT, ZIP_RESOURCE_LIMIT, XML_RESOURCE_LIMIT, XML_STRUCTURE};
    }

    static {
        EXPAT_NAME_REFERENCE_COUNT = new PptxPreflightRejectReason("EXPAT_NAME_REFERENCE_COUNT", 0);
        ZIP_RESOURCE_LIMIT = new PptxPreflightRejectReason("ZIP_RESOURCE_LIMIT", 1);
        XML_RESOURCE_LIMIT = new PptxPreflightRejectReason("XML_RESOURCE_LIMIT", 2);
        XML_STRUCTURE = new PptxPreflightRejectReason("XML_STRUCTURE", 3);
        PptxPreflightRejectReason[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private PptxPreflightRejectReason(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<PptxPreflightRejectReason> getEntries() {
        return $ENTRIES;
    }

    public static PptxPreflightRejectReason valueOf(String r2) {
        return (PptxPreflightRejectReason) ZeusTransformUtils.preCheckCast(Enum.valueOf(PptxPreflightRejectReason.class, r2), PptxPreflightRejectReason.class, "com.obric.memorydata.plugin");
    }

    public static PptxPreflightRejectReason[] values() {
        return (PptxPreflightRejectReason[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PptxPreflightRejectReason[].class, "com.obric.memorydata.plugin");
    }
}
