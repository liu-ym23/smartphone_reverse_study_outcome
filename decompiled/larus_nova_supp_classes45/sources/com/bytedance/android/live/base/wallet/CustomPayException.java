package com.bytedance.android.live.base.wallet;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class CustomPayException extends Exception {
    public static final int PAY_WX_APP_ID_IS_NULL = 2;
    public static final int PAY_WX_APP_NOT_SUPPORT_PAY = 3;
    public static final int PAY_WX_APP_PARAM_ERROR = 4;
    public static final int PAY_WX_NOT_ISNTALLED = 1;
    private int code;
    private Map<String, String> extra;
    private String message;

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    public CustomPayException(String r1, int r2) {
        this.message = r1;
        this.code = r2;
    }
}
