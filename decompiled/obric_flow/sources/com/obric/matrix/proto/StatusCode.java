package com.obric.matrix.proto;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

/* JADX INFO: loaded from: classes3.dex */
public final enum StatusCode extends Enum<StatusCode> implements WireEnum {
    private static final /* synthetic */ StatusCode[] $VALUES = null;
    public static final ProtoAdapter<StatusCode> ADAPTER = null;
    public static final StatusCode API_NO_PERMISSION = null;
    public static final StatusCode CMD_NOT_SUPPORT = null;
    public static final StatusCode ERROR_UNKNOW = null;
    public static final StatusCode ILLEGAL_REQUEST_PARAM = null;
    public static final StatusCode INVALID_APPKEY = null;
    public static final StatusCode OK = null;
    public static final StatusCode REQUEST_BODY_IS_NULL = null;
    public static final StatusCode REQUEST_DATA_PARSE_ERROR = null;
    public static final StatusCode USER_NO_LOGIN = null;
    private final int value;

    static {
        StatusCode r5 = new StatusCode("OK", 0, 0);
        OK = r5;
        StatusCode r10 = new StatusCode("INVALID_APPKEY", 1, -100001);
        INVALID_APPKEY = r10;
        StatusCode r11 = new StatusCode("USER_NO_LOGIN", 2, -100002);
        USER_NO_LOGIN = r11;
        StatusCode r12 = new StatusCode("REQUEST_BODY_IS_NULL", 3, -100003);
        REQUEST_BODY_IS_NULL = r12;
        StatusCode r13 = new StatusCode("ERROR_UNKNOW", 4, -100004);
        ERROR_UNKNOW = r13;
        StatusCode r14 = new StatusCode("REQUEST_DATA_PARSE_ERROR", 5, -100005);
        REQUEST_DATA_PARSE_ERROR = r14;
        StatusCode r15 = new StatusCode("CMD_NOT_SUPPORT", 6, -100006);
        CMD_NOT_SUPPORT = r15;
        StatusCode r16 = new StatusCode("API_NO_PERMISSION", 7, -100007);
        API_NO_PERMISSION = r16;
        StatusCode r17 = new StatusCode("ILLEGAL_REQUEST_PARAM", 8, -100008);
        ILLEGAL_REQUEST_PARAM = r17;
        $VALUES = new StatusCode[]{r5, r10, r11, r12, r13, r14, r15, r16, r17};
        ADAPTER = new ProtoAdapter_StatusCode();
    }

    private StatusCode(String r5, int r10, int r11) {
        super(r5, r10);
        this.value = r11;
    }

    public static StatusCode fromValue(int r5) {
        if (r5 == 0) goto L23;
        switch(r5) {
            case -100008: goto L21;
            case -100007: goto L19;
            case -100006: goto L17;
            case -100005: goto L15;
            case -100004: goto L13;
            case -100003: goto L11;
            case -100002: goto L9;
            case -100001: goto L7;
            default: goto L4;
        };
    L4:
        return null;
    L7:
        return INVALID_APPKEY;
    L9:
        return USER_NO_LOGIN;
    L11:
        return REQUEST_BODY_IS_NULL;
    L13:
        return ERROR_UNKNOW;
    L15:
        return REQUEST_DATA_PARSE_ERROR;
    L17:
        return CMD_NOT_SUPPORT;
    L19:
        return API_NO_PERMISSION;
    L21:
        return ILLEGAL_REQUEST_PARAM;
    L23:
        return OK;
    }

    public static StatusCode valueOf(String r5) {
        return (StatusCode) Enum.valueOf(StatusCode.class, r5);
    }

    public static StatusCode[] values() {
        return (StatusCode[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
