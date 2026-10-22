package com.bytedance.android.livesdk.gift.platform.core.download;

import com.bytedance.android.livesdk.gift.platform.business.effect.assets.e;
import com.bytedance.kmp.livesdk.gift.platform.resourcemanager.exception.BaseGetResourceException;
import dd6.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class TTDownloadException extends BaseGetResourceException {
    private a mDownloadRequest;
    private int mErrorCode;

    public String getMessage() {
        return this.mDownloadRequest.toString() + "\n" + super.getMessage();
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public TTDownloadException(String r1, Throwable r2, e r3, int r4, a r5) {
        super(r1, r2, r3);
        this.mErrorCode = r4;
        this.mDownloadRequest = r5;
    }
}
