package com.obric.memorydata.datatransport.manager;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0013\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/datatransport/manager/ExportFailureReason;", "", "labelRes", "", "<init>", "(Ljava/lang/String;II)V", "getLabelRes", "()I", "SOURCE_NOT_FOUND", "ACCESS_DENIED", "OPEN_FAILED", "READ_FAILED", "WRITE_FAILED", "QUERY_FAILED", "CONVERSION_FAILED", "UNKNOWN", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ExportFailureReason extends Enum<ExportFailureReason> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ExportFailureReason[] $VALUES = null;
    public static final ExportFailureReason ACCESS_DENIED = null;
    public static final ExportFailureReason CONVERSION_FAILED = null;
    public static final ExportFailureReason OPEN_FAILED = null;
    public static final ExportFailureReason QUERY_FAILED = null;
    public static final ExportFailureReason READ_FAILED = null;
    public static final ExportFailureReason SOURCE_NOT_FOUND = null;
    public static final ExportFailureReason UNKNOWN = null;
    public static final ExportFailureReason WRITE_FAILED = null;
    private final int labelRes;

    private static final /* synthetic */ ExportFailureReason[] $values() {
        return new ExportFailureReason[]{SOURCE_NOT_FOUND, ACCESS_DENIED, OPEN_FAILED, READ_FAILED, WRITE_FAILED, QUERY_FAILED, CONVERSION_FAILED, UNKNOWN};
    }

    static {
        SOURCE_NOT_FOUND = new ExportFailureReason("SOURCE_NOT_FOUND", 0, ZeusTransformUtils.mapRes(R.string.data_transport_export_failure_source_not_found, TypedValues.Custom.S_STRING, "data_transport_export_failure_source_not_found"));
        ACCESS_DENIED = new ExportFailureReason("ACCESS_DENIED", 1, ZeusTransformUtils.mapRes(R.string.data_transport_export_failure_access_denied, TypedValues.Custom.S_STRING, "data_transport_export_failure_access_denied"));
        OPEN_FAILED = new ExportFailureReason("OPEN_FAILED", 2, ZeusTransformUtils.mapRes(R.string.data_transport_export_failure_open_failed, TypedValues.Custom.S_STRING, "data_transport_export_failure_open_failed"));
        READ_FAILED = new ExportFailureReason("READ_FAILED", 3, ZeusTransformUtils.mapRes(R.string.data_transport_export_failure_read_failed, TypedValues.Custom.S_STRING, "data_transport_export_failure_read_failed"));
        WRITE_FAILED = new ExportFailureReason("WRITE_FAILED", 4, ZeusTransformUtils.mapRes(R.string.data_transport_export_failure_write_failed, TypedValues.Custom.S_STRING, "data_transport_export_failure_write_failed"));
        QUERY_FAILED = new ExportFailureReason("QUERY_FAILED", 5, ZeusTransformUtils.mapRes(R.string.data_transport_export_failure_query_failed, TypedValues.Custom.S_STRING, "data_transport_export_failure_query_failed"));
        CONVERSION_FAILED = new ExportFailureReason("CONVERSION_FAILED", 6, ZeusTransformUtils.mapRes(R.string.data_transport_export_failure_conversion_failed, TypedValues.Custom.S_STRING, "data_transport_export_failure_conversion_failed"));
        UNKNOWN = new ExportFailureReason("UNKNOWN", 7, ZeusTransformUtils.mapRes(R.string.data_transport_export_failure_unknown, TypedValues.Custom.S_STRING, "data_transport_export_failure_unknown"));
        ExportFailureReason[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private ExportFailureReason(String r1, int r2, int r3) {
        super(r1, r2);
        this.labelRes = r3;
    }

    public static EnumEntries<ExportFailureReason> getEntries() {
        return $ENTRIES;
    }

    public static ExportFailureReason valueOf(String r2) {
        return (ExportFailureReason) ZeusTransformUtils.preCheckCast(Enum.valueOf(ExportFailureReason.class, r2), ExportFailureReason.class, "com.obric.memorydata.plugin");
    }

    public static ExportFailureReason[] values() {
        return (ExportFailureReason[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ExportFailureReason[].class, "com.obric.memorydata.plugin");
    }

    public final int getLabelRes() {
        return this.labelRes;
    }
}
