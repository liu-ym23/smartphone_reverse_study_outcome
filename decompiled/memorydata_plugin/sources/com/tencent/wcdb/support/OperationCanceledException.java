package com.tencent.wcdb.support;

/* JADX INFO: loaded from: classes6.dex */
public class OperationCanceledException extends RuntimeException {
    public OperationCanceledException() {
        this(null);
    }

    public OperationCanceledException(String r1) {
        if (r1 != null) goto L5;
        r1 = "The operation has been canceled.";
    L5:
        super(r1);
    }
}
