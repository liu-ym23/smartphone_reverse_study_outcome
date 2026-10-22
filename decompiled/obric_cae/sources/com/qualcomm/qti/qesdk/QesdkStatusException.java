package com.qualcomm.qti.qesdk;

/* JADX INFO: loaded from: classes2.dex */
public class QesdkStatusException extends Exception {
    private static final String DEFAULT_MESSAGE = "Api call failed with status: ";

    public QesdkStatusException(int r8) {
        super(defpackage.a.d(DEFAULT_MESSAGE, r8));
    }

    public QesdkStatusException(String r8, int r10) {
        super(r8 + r10);
    }
}
