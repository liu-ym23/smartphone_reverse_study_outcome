package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.net.ExperimentalUrlRequest;
import com.ttnet.org.chromium.net.UploadDataProvider;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes6.dex */
public abstract class UrlRequestBase extends ExperimentalUrlRequest {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @Retention(RetentionPolicy.SOURCE)
    public @interface StatusValues {
    }

    static {
    }

    public UrlRequestBase() {
    }

    public static int convertLoadState(int r1) {
        switch(r1) {
            case 0: goto L33;
            case 1: goto L31;
            case 2: goto L29;
            case 3: goto L27;
            case 4: goto L25;
            case 5: goto L4;
            case 6: goto L23;
            case 7: goto L21;
            case 8: goto L19;
            case 9: goto L17;
            case 10: goto L15;
            case 11: goto L13;
            case 12: goto L11;
            case 13: goto L9;
            case 14: goto L7;
            case 15: goto L5;
            default: goto L4;
        };
    L5:
        return 14;
    L7:
        return 13;
    L9:
        return 12;
    L11:
        return 11;
    L13:
        return 10;
    L15:
        return 9;
    L17:
        return 8;
    L19:
        return 7;
    L21:
        return 6;
    L23:
        return 5;
    L25:
        return 4;
    L27:
        return 3;
    L29:
        return 2;
    L31:
        return 1;
    L33:
        return 0;
    L4:
        throw new IllegalArgumentException("No request status found.");
    }

    public abstract void addHeader(String r1, String r2);

    public abstract void setHttpMethod(String r1);

    public abstract void setRequestTimeout(int r1);

    public abstract void setSocketConnectTimeout(int r1);

    public abstract void setSocketReadTimeout(int r1);

    public abstract void setSocketWriteTimeout(int r1);

    public abstract void setUploadDataProvider(UploadDataProvider r1, Executor r2);
}
