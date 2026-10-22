package com.ttnet.org.chromium.net.urlconnection;

import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class TTRequestCanceledException extends IOException {
    public int getCronetInternalErrorCode() {
        return -999;
    }

    public TTRequestCanceledException(String r1) {
        super(r1);
    }
}
