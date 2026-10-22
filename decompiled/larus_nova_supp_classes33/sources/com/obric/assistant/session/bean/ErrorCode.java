package com.obric.assistant.session.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/assistant/session/bean/ErrorCode;", "", "<init>", "(Ljava/lang/String;I)V", "NA", "CONTINUE", "QUIT_SESSION", "LAUNCH_ASSISTANT_DIRECTLY", "END_ON_SHOW", "ONLY_END", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ErrorCode extends Enum<ErrorCode> {
    public static final ErrorCode CONTINUE = null;
    public static final ErrorCode END_ON_SHOW = null;
    public static final ErrorCode LAUNCH_ASSISTANT_DIRECTLY = null;
    public static final ErrorCode NA = null;
    public static final ErrorCode ONLY_END = null;
    public static final ErrorCode QUIT_SESSION = null;
    public static final /* synthetic */ ErrorCode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ErrorCode> getEntries() {
        return b;
    }

    static {
        ErrorCode r0 = new ErrorCode("NA", 0);
        NA = r0;
        ErrorCode r1 = new ErrorCode("CONTINUE", 1);
        CONTINUE = r1;
        ErrorCode r3 = new ErrorCode("QUIT_SESSION", 2);
        QUIT_SESSION = r3;
        ErrorCode r5 = new ErrorCode("LAUNCH_ASSISTANT_DIRECTLY", 3);
        LAUNCH_ASSISTANT_DIRECTLY = r5;
        ErrorCode r7 = new ErrorCode("END_ON_SHOW", 4);
        END_ON_SHOW = r7;
        ErrorCode r9 = new ErrorCode("ONLY_END", 5);
        ONLY_END = r9;
        ErrorCode[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static ErrorCode[] values() {
        return (ErrorCode[]) a.clone();
    }

    public static ErrorCode valueOf(String r1) {
        return (ErrorCode) a.a(ErrorCode.class, r1);
    }

    public ErrorCode(String r1, int r2) {
        super(r1, r2);
    }
}
