package com.ss.ugc.live.gift.resource.exception;

import com.ss.ugc.live.gift.resource.download.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class NetworkException extends BaseGetResourceException {
    private a mDownloadRequest;
    private int mErrorCode;

    @Override // com.ss.ugc.live.gift.resource.exception.BaseGetResourceException, java.lang.Throwable
    public String getMessage() {
        throw null;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public NetworkException(qlc.a r1, int r2, a r3) {
        super(r1);
        this.mErrorCode = r2;
    }

    public NetworkException(String r1, qlc.a r2, int r3, a r4) {
        super(r1, r2);
        this.mErrorCode = r3;
    }

    public NetworkException(String r1, Throwable r2, qlc.a r3, int r4, a r5) {
        super(r1, r2, r3);
        this.mErrorCode = r4;
    }
}
