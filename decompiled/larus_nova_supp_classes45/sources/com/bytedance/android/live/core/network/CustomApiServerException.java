package com.bytedance.android.live.core.network;

import android.text.TextUtils;
import com.bytedance.android.live.base.exception.ApiServerException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class CustomApiServerException extends ApiServerException {
    private String traceId;
    private String url;
    private String xTtLogId;

    @Override // com.bytedance.android.live.base.exception.ApiServerException, com.bytedance.android.live.base.exception.ApiException, java.lang.Throwable
    public String getMessage() {
        return " TYPE = CustomApiServerException, url = " + this.url + ", xTtLogId = " + this.xTtLogId + "  , traceId = " + this.traceId + "  " + super.getMessage();
    }

    public String getTraceId() {
        return this.traceId;
    }

    public String getUrl() {
        return this.url;
    }

    public String getXTtLogId() {
        return this.xTtLogId;
    }

    public CustomApiServerException(int r2, String r3, String r4, String r5) {
        super(r2);
        if (TextUtils.isEmpty(r3) == false) goto L5;
        this.url = "";
    L7:
        if (TextUtils.isEmpty(r4) == false) goto L9;
        this.xTtLogId = "";
    L11:
        if (TextUtils.isEmpty(r5) == false) goto L13;
        this.traceId = "";
        return;
    L13:
        this.traceId = r5;
        return;
    L9:
        this.xTtLogId = r4;
        goto L11
    L5:
        this.url = r3;
        goto L7
    }
}
