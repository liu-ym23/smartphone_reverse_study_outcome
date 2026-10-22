package com.larus.calendar;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/calendar/ErrorCode;", "", "<init>", "(Ljava/lang/String;I)V", "ArgumentError", "NoPermission", "AlreadyExists", "NoAccount", "Unknown", "Success", "NotFound", "NotGetId", "calendar_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ErrorCode extends Enum<ErrorCode> {
    public static final ErrorCode AlreadyExists = null;
    public static final ErrorCode ArgumentError = null;
    public static final ErrorCode NoAccount = null;
    public static final ErrorCode NoPermission = null;
    public static final ErrorCode NotFound = null;
    public static final ErrorCode NotGetId = null;
    public static final ErrorCode Success = null;
    public static final ErrorCode Unknown = null;
    public static final /* synthetic */ ErrorCode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ErrorCode> getEntries() {
        return b;
    }

    static {
        ErrorCode r0 = new ErrorCode("ArgumentError", 0);
        ArgumentError = r0;
        ErrorCode r1 = new ErrorCode("NoPermission", 1);
        NoPermission = r1;
        ErrorCode r3 = new ErrorCode("AlreadyExists", 2);
        AlreadyExists = r3;
        ErrorCode r5 = new ErrorCode("NoAccount", 3);
        NoAccount = r5;
        ErrorCode r7 = new ErrorCode("Unknown", 4);
        Unknown = r7;
        ErrorCode r9 = new ErrorCode("Success", 5);
        Success = r9;
        ErrorCode r11 = new ErrorCode("NotFound", 6);
        NotFound = r11;
        ErrorCode r13 = new ErrorCode("NotGetId", 7);
        NotGetId = r13;
        ErrorCode[] r15 = {r0, r1, r3, r5, r7, r9, r11, r13};
        a = r15;
        b = EnumEntriesKt.enumEntries(r15);
    }

    public static ErrorCode[] values() {
        return (ErrorCode[]) a.clone();
    }

    public static ErrorCode valueOf(String r1) {
        return (ErrorCode) r27.a.a(ErrorCode.class, r1);
    }

    public ErrorCode(String r1, int r2) {
        super(r1, r2);
    }
}
