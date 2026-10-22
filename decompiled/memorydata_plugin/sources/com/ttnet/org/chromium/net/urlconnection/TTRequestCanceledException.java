package com.ttnet.org.chromium.net.urlconnection;

import com.bytedance.retrofit2.PriorityLevel;
import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public class TTRequestCanceledException extends IOException {
    public TTRequestCanceledException(String r1) {
        super(r1);
    }

    public int getCronetInternalErrorCode() {
        return PriorityLevel.INVALID;
    }
}
