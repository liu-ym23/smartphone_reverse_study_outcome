package com.larus.dora.impl.log.engine;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/larus/dora/impl/log/engine/OTALogReason;", "", "message", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "NOT_SATISFY_TO_RESUME", "BUDS_NOT_READY", "LOW_BATTERY", "BUSY", "DOWNLOAD_OTA_FILE_FAILED", "OTA_OTHER", "EAR_BUDS_NOT_READY", "FILE_NOT_FOUND", "AUTOMATIC_SWITCH_CLOSE", "NO_REMAINING_TIMES", "RECEIVED_OTA_PACKAGE", "ERROR_MESSAGE_MSG", "BES_CONNECT_ERROR_OTA_STATUS", "TASK_CANCELED", "D_BUDS_PROTOCOL_DISCONNECT", "EVENT_BUDS_VUI_ERROR", "COPY_SN", "CLOUD_ORDER_LOG", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OTALogReason extends Enum<OTALogReason> {
    public static final OTALogReason AUTOMATIC_SWITCH_CLOSE = null;
    public static final OTALogReason BES_CONNECT_ERROR_OTA_STATUS = null;
    public static final OTALogReason BUDS_NOT_READY = null;
    public static final OTALogReason BUSY = null;
    public static final OTALogReason CLOUD_ORDER_LOG = null;
    public static final OTALogReason COPY_SN = null;
    public static final OTALogReason DOWNLOAD_OTA_FILE_FAILED = null;
    public static final OTALogReason D_BUDS_PROTOCOL_DISCONNECT = null;
    public static final OTALogReason EAR_BUDS_NOT_READY = null;
    public static final OTALogReason ERROR_MESSAGE_MSG = null;
    public static final OTALogReason EVENT_BUDS_VUI_ERROR = null;
    public static final OTALogReason FILE_NOT_FOUND = null;
    public static final OTALogReason LOW_BATTERY = null;
    public static final OTALogReason NOT_SATISFY_TO_RESUME = null;
    public static final OTALogReason NO_REMAINING_TIMES = null;
    public static final OTALogReason OTA_OTHER = null;
    public static final OTALogReason RECEIVED_OTA_PACKAGE = null;
    public static final OTALogReason TASK_CANCELED = null;
    public static final /* synthetic */ OTALogReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String message;

    public static EnumEntries<OTALogReason> getEntries() {
        return b;
    }

    static {
        OTALogReason r0 = new OTALogReason("NOT_SATISFY_TO_RESUME", 0, "not_satisfy_to_resume_data_transfer");
        NOT_SATISFY_TO_RESUME = r0;
        OTALogReason r1 = new OTALogReason("BUDS_NOT_READY", 1, "ota_buds_not_ready");
        BUDS_NOT_READY = r1;
        OTALogReason r2 = new OTALogReason("LOW_BATTERY", 2, "ota_low_battery");
        LOW_BATTERY = r2;
        OTALogReason r4 = new OTALogReason("BUSY", 3, "ota_busy");
        BUSY = r4;
        OTALogReason r6 = new OTALogReason("DOWNLOAD_OTA_FILE_FAILED", 4, "ota_download_package_failure");
        DOWNLOAD_OTA_FILE_FAILED = r6;
        OTALogReason r8 = new OTALogReason("OTA_OTHER", 5, "ota_other");
        OTA_OTHER = r8;
        OTALogReason r10 = new OTALogReason("EAR_BUDS_NOT_READY", 6, "ota_ear_buds_not_ready");
        EAR_BUDS_NOT_READY = r10;
        OTALogReason r12 = new OTALogReason("FILE_NOT_FOUND", 7, "ota_file_not_found");
        FILE_NOT_FOUND = r12;
        OTALogReason r14 = new OTALogReason("AUTOMATIC_SWITCH_CLOSE", 8, "ota_automatic_switch_close");
        AUTOMATIC_SWITCH_CLOSE = r14;
        OTALogReason r13 = new OTALogReason("NO_REMAINING_TIMES", 9, "ota_no_remaining_times");
        NO_REMAINING_TIMES = r13;
        OTALogReason r11 = new OTALogReason("RECEIVED_OTA_PACKAGE", 10, "ota_received_ota_package");
        RECEIVED_OTA_PACKAGE = r11;
        OTALogReason r9 = new OTALogReason("ERROR_MESSAGE_MSG", 11, "ota_bes_error_message_msg");
        ERROR_MESSAGE_MSG = r9;
        OTALogReason r7 = new OTALogReason("BES_CONNECT_ERROR_OTA_STATUS", 12, "ota_bes_connect_error");
        BES_CONNECT_ERROR_OTA_STATUS = r7;
        OTALogReason r5 = new OTALogReason("TASK_CANCELED", 13, "ota_status_cancel");
        TASK_CANCELED = r5;
        OTALogReason r3 = new OTALogReason("D_BUDS_PROTOCOL_DISCONNECT", 14, "event_buds_vui_error");
        D_BUDS_PROTOCOL_DISCONNECT = r3;
        OTALogReason r15 = new OTALogReason("EVENT_BUDS_VUI_ERROR", 15, "event_buds_vui_error");
        EVENT_BUDS_VUI_ERROR = r15;
        OTALogReason r16 = new OTALogReason("COPY_SN", 16, "copy_sn");
        COPY_SN = r16;
        OTALogReason r17 = new OTALogReason("CLOUD_ORDER_LOG", 17, "cloud_order_log");
        CLOUD_ORDER_LOG = r17;
        OTALogReason[] r18 = {r0, r1, r2, r4, r6, r8, r10, r12, r14, r13, r11, r9, r7, r5, r3, r15, r16, r17};
        a = r18;
        b = EnumEntriesKt.enumEntries(r18);
    }

    public static OTALogReason[] values() {
        return (OTALogReason[]) a.clone();
    }

    public final String getMessage() {
        return this.message;
    }

    public static OTALogReason valueOf(String r1) {
        return (OTALogReason) a.a(OTALogReason.class, r1);
    }

    public OTALogReason(String r1, int r2, String r3) {
        super(r1, r2);
        this.message = r3;
    }
}
