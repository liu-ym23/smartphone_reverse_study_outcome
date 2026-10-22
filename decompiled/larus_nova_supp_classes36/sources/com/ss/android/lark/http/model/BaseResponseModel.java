package com.ss.android.lark.http.model;

import android.text.TextUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class BaseResponseModel implements Serializable {
    private int code;
    private String error;
    private String message;

    public String getErrorMessage() {
        if (TextUtils.isEmpty(this.message) == false) goto L6;
        return this.error;
    L6:
        return this.message;
    }

    public boolean isSuccess() {
        if (this.code != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public BaseResponseModel() {
        this.code = 0;
    }

    public int getErrorCode() {
        return this.code;
    }

    public void setCode(int r1) {
        this.code = r1;
    }

    public void setError(String r1) {
        this.error = r1;
    }

    public void setMessage(String r1) {
        this.message = r1;
    }
}
