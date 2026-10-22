package com.larus.dora.impl.device.ota;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/dora/impl/device/ota/EventTypeOTAStatus;", "", "code", "", "<init>", "(Ljava/lang/String;II)V", "getCode", "()I", "FAIL", "START_DOWNLOAD", "DOWNLOAD_COMPLETED", "VERIFIED", "ENVIRONMENT_READY", "START_INSTALL", "INSTALL_COMPLETED", "DELETE_PACKAGE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EventTypeOTAStatus extends Enum<EventTypeOTAStatus> {
    public static final EventTypeOTAStatus DELETE_PACKAGE = null;
    public static final EventTypeOTAStatus DOWNLOAD_COMPLETED = null;
    public static final EventTypeOTAStatus ENVIRONMENT_READY = null;
    public static final EventTypeOTAStatus FAIL = null;
    public static final EventTypeOTAStatus INSTALL_COMPLETED = null;
    public static final EventTypeOTAStatus START_DOWNLOAD = null;
    public static final EventTypeOTAStatus START_INSTALL = null;
    public static final EventTypeOTAStatus VERIFIED = null;
    public static final /* synthetic */ EventTypeOTAStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int code;

    public static EnumEntries<EventTypeOTAStatus> getEntries() {
        return b;
    }

    static {
        EventTypeOTAStatus r0 = new EventTypeOTAStatus("FAIL", 0, 0);
        FAIL = r0;
        EventTypeOTAStatus r1 = new EventTypeOTAStatus("START_DOWNLOAD", 1, 1);
        START_DOWNLOAD = r1;
        EventTypeOTAStatus r3 = new EventTypeOTAStatus("DOWNLOAD_COMPLETED", 2, 2);
        DOWNLOAD_COMPLETED = r3;
        EventTypeOTAStatus r5 = new EventTypeOTAStatus("VERIFIED", 3, 3);
        VERIFIED = r5;
        EventTypeOTAStatus r7 = new EventTypeOTAStatus("ENVIRONMENT_READY", 4, 4);
        ENVIRONMENT_READY = r7;
        EventTypeOTAStatus r9 = new EventTypeOTAStatus("START_INSTALL", 5, 5);
        START_INSTALL = r9;
        EventTypeOTAStatus r11 = new EventTypeOTAStatus("INSTALL_COMPLETED", 6, 6);
        INSTALL_COMPLETED = r11;
        EventTypeOTAStatus r13 = new EventTypeOTAStatus("DELETE_PACKAGE", 7, 7);
        DELETE_PACKAGE = r13;
        EventTypeOTAStatus[] r15 = {r0, r1, r3, r5, r7, r9, r11, r13};
        a = r15;
        b = EnumEntriesKt.enumEntries(r15);
    }

    public static EventTypeOTAStatus[] values() {
        return (EventTypeOTAStatus[]) a.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public static EventTypeOTAStatus valueOf(String r1) {
        return (EventTypeOTAStatus) r27.a.a(EventTypeOTAStatus.class, r1);
    }

    public EventTypeOTAStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.code = r3;
    }
}
