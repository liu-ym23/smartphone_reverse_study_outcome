package com.bytedance.badger.data;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/badger/data/EventReportEnum;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "START", "PHONE_INPUT", "PHONE_INPUT_START", "PHONE_INPUT_END", "AGREEMENT_BUTTON", "VERIFY_AND_LOGIN_BUTTON", "VERIFY_CODE_INPUT", "VERIFY_CODE_INPUT_START", "VERIFY_CODE_INPUT_END", "LOGIN_BUTTON", "TOUCH", "badger-api_release"}, k = 1, mv = {1, 4, 0})
public final enum EventReportEnum extends Enum<EventReportEnum> {
    public static final EventReportEnum AGREEMENT_BUTTON = null;
    public static final EventReportEnum LOGIN_BUTTON = null;
    public static final EventReportEnum PHONE_INPUT = null;
    public static final EventReportEnum PHONE_INPUT_END = null;
    public static final EventReportEnum PHONE_INPUT_START = null;
    public static final EventReportEnum START = null;
    public static final EventReportEnum TOUCH = null;
    public static final EventReportEnum VERIFY_AND_LOGIN_BUTTON = null;
    public static final EventReportEnum VERIFY_CODE_INPUT = null;
    public static final EventReportEnum VERIFY_CODE_INPUT_END = null;
    public static final EventReportEnum VERIFY_CODE_INPUT_START = null;
    public static final /* synthetic */ EventReportEnum[] a = null;
    private final String value;

    public static EventReportEnum valueOf(String r1) {
        return (EventReportEnum) a.a(EventReportEnum.class, r1);
    }

    public static EventReportEnum[] values() {
        return (EventReportEnum[]) a.clone();
    }

    static {
        EventReportEnum r1 = new EventReportEnum("START", 0, "start");
        START = r1;
        EventReportEnum r2 = new EventReportEnum("PHONE_INPUT", 1, "phone_input");
        PHONE_INPUT = r2;
        EventReportEnum r3 = new EventReportEnum("PHONE_INPUT_START", 2, "phone_input_start");
        PHONE_INPUT_START = r3;
        EventReportEnum r4 = new EventReportEnum("PHONE_INPUT_END", 3, "phone_input_end");
        PHONE_INPUT_END = r4;
        EventReportEnum r5 = new EventReportEnum("AGREEMENT_BUTTON", 4, "agreement_button");
        AGREEMENT_BUTTON = r5;
        EventReportEnum r6 = new EventReportEnum("VERIFY_AND_LOGIN_BUTTON", 5, "verify_and_login_button");
        VERIFY_AND_LOGIN_BUTTON = r6;
        EventReportEnum r7 = new EventReportEnum("VERIFY_CODE_INPUT", 6, "verify_code_input");
        VERIFY_CODE_INPUT = r7;
        EventReportEnum r8 = new EventReportEnum("VERIFY_CODE_INPUT_START", 7, "verify_code_input_start");
        VERIFY_CODE_INPUT_START = r8;
        EventReportEnum r9 = new EventReportEnum("VERIFY_CODE_INPUT_END", 8, "verify_code_input_end");
        VERIFY_CODE_INPUT_END = r9;
        EventReportEnum r10 = new EventReportEnum("LOGIN_BUTTON", 9, "login_button");
        LOGIN_BUTTON = r10;
        EventReportEnum r12 = new EventReportEnum("TOUCH", 10, "touch");
        TOUCH = r12;
        a = new EventReportEnum[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12};
    }

    public final String getValue() {
        return this.value;
    }

    public EventReportEnum(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
