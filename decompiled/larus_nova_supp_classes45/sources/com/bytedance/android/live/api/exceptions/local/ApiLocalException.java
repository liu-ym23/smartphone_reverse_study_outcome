package com.bytedance.android.live.api.exceptions.local;

import com.bytedance.android.live.base.exception.ApiException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class ApiLocalException extends ApiException {
    @Override // com.bytedance.android.live.base.exception.ApiException, java.lang.Throwable
    public String getMessage() {
        return " TYPE = ApiLocalException " + super.getMessage();
    }

    public ApiLocalException(int r1) {
        super(r1);
    }

    public ApiLocalException(int r1, Throwable r2) {
        super(r1, r2);
    }
}
