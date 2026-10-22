package com.larus.dora.impl.device.ota;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/larus/dora/impl/device/ota/EventTypeOTAErrorCode;", "", "code", "", "<init>", "(Ljava/lang/String;II)V", "getCode", "()I", "SUCCESS", "PARAMETERS", "VERSION_FORMAT", "VERSION_EXISTED", "STORAGE_FULL", "USER_CANCEL", "PACKAGE_URL", "DOWNLOAD_FAILED", "VERIFICATION_FAILED", "PACKAGE_CONTENT", "INSTALL_FAILED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EventTypeOTAErrorCode extends Enum<EventTypeOTAErrorCode> {
    public static final EventTypeOTAErrorCode DOWNLOAD_FAILED = null;
    public static final EventTypeOTAErrorCode INSTALL_FAILED = null;
    public static final EventTypeOTAErrorCode PACKAGE_CONTENT = null;
    public static final EventTypeOTAErrorCode PACKAGE_URL = null;
    public static final EventTypeOTAErrorCode PARAMETERS = null;
    public static final EventTypeOTAErrorCode STORAGE_FULL = null;
    public static final EventTypeOTAErrorCode SUCCESS = null;
    public static final EventTypeOTAErrorCode USER_CANCEL = null;
    public static final EventTypeOTAErrorCode VERIFICATION_FAILED = null;
    public static final EventTypeOTAErrorCode VERSION_EXISTED = null;
    public static final EventTypeOTAErrorCode VERSION_FORMAT = null;
    public static final /* synthetic */ EventTypeOTAErrorCode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int code;

    public static EnumEntries<EventTypeOTAErrorCode> getEntries() {
        return b;
    }

    static {
        EventTypeOTAErrorCode r0 = new EventTypeOTAErrorCode("SUCCESS", 0, 0);
        SUCCESS = r0;
        EventTypeOTAErrorCode r1 = new EventTypeOTAErrorCode("PARAMETERS", 1, 1);
        PARAMETERS = r1;
        EventTypeOTAErrorCode r3 = new EventTypeOTAErrorCode("VERSION_FORMAT", 2, 2);
        VERSION_FORMAT = r3;
        EventTypeOTAErrorCode r5 = new EventTypeOTAErrorCode("VERSION_EXISTED", 3, 3);
        VERSION_EXISTED = r5;
        EventTypeOTAErrorCode r7 = new EventTypeOTAErrorCode("STORAGE_FULL", 4, 4);
        STORAGE_FULL = r7;
        EventTypeOTAErrorCode r9 = new EventTypeOTAErrorCode("USER_CANCEL", 5, 5);
        USER_CANCEL = r9;
        EventTypeOTAErrorCode r11 = new EventTypeOTAErrorCode("PACKAGE_URL", 6, 6);
        PACKAGE_URL = r11;
        EventTypeOTAErrorCode r13 = new EventTypeOTAErrorCode("DOWNLOAD_FAILED", 7, 7);
        DOWNLOAD_FAILED = r13;
        EventTypeOTAErrorCode r15 = new EventTypeOTAErrorCode("VERIFICATION_FAILED", 8, 8);
        VERIFICATION_FAILED = r15;
        EventTypeOTAErrorCode r14 = new EventTypeOTAErrorCode("PACKAGE_CONTENT", 9, 9);
        PACKAGE_CONTENT = r14;
        EventTypeOTAErrorCode r12 = new EventTypeOTAErrorCode("INSTALL_FAILED", 10, 10);
        INSTALL_FAILED = r12;
        EventTypeOTAErrorCode[] r10 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12};
        a = r10;
        b = EnumEntriesKt.enumEntries(r10);
    }

    public static EventTypeOTAErrorCode[] values() {
        return (EventTypeOTAErrorCode[]) a.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public static EventTypeOTAErrorCode valueOf(String r1) {
        return (EventTypeOTAErrorCode) r27.a.a(EventTypeOTAErrorCode.class, r1);
    }

    public EventTypeOTAErrorCode(String r1, int r2, int r3) {
        super(r1, r2);
        this.code = r3;
    }
}
