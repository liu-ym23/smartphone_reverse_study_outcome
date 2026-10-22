package com.larus.platform.api;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/platform/api/SdkCalendarErrorCode;", "", "<init>", "(Ljava/lang/String;I)V", "ArgumentError", "NoPermission", "AlreadyExists", "NoAccount", "Unknown", "Success", "NotFound", "NotGetId", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum SdkCalendarErrorCode extends Enum<SdkCalendarErrorCode> {
    public static final SdkCalendarErrorCode AlreadyExists = null;
    public static final SdkCalendarErrorCode ArgumentError = null;
    public static final SdkCalendarErrorCode NoAccount = null;
    public static final SdkCalendarErrorCode NoPermission = null;
    public static final SdkCalendarErrorCode NotFound = null;
    public static final SdkCalendarErrorCode NotGetId = null;
    public static final SdkCalendarErrorCode Success = null;
    public static final SdkCalendarErrorCode Unknown = null;
    public static final /* synthetic */ SdkCalendarErrorCode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<SdkCalendarErrorCode> getEntries() {
        return b;
    }

    static {
        SdkCalendarErrorCode r0 = new SdkCalendarErrorCode("ArgumentError", 0);
        ArgumentError = r0;
        SdkCalendarErrorCode r1 = new SdkCalendarErrorCode("NoPermission", 1);
        NoPermission = r1;
        SdkCalendarErrorCode r3 = new SdkCalendarErrorCode("AlreadyExists", 2);
        AlreadyExists = r3;
        SdkCalendarErrorCode r5 = new SdkCalendarErrorCode("NoAccount", 3);
        NoAccount = r5;
        SdkCalendarErrorCode r7 = new SdkCalendarErrorCode("Unknown", 4);
        Unknown = r7;
        SdkCalendarErrorCode r9 = new SdkCalendarErrorCode("Success", 5);
        Success = r9;
        SdkCalendarErrorCode r11 = new SdkCalendarErrorCode("NotFound", 6);
        NotFound = r11;
        SdkCalendarErrorCode r13 = new SdkCalendarErrorCode("NotGetId", 7);
        NotGetId = r13;
        SdkCalendarErrorCode[] r15 = {r0, r1, r3, r5, r7, r9, r11, r13};
        a = r15;
        b = EnumEntriesKt.enumEntries(r15);
    }

    public static SdkCalendarErrorCode[] values() {
        return (SdkCalendarErrorCode[]) a.clone();
    }

    public static SdkCalendarErrorCode valueOf(String r1) {
        return (SdkCalendarErrorCode) r27.a.a(SdkCalendarErrorCode.class, r1);
    }

    public SdkCalendarErrorCode(String r1, int r2) {
        super(r1, r2);
    }
}
