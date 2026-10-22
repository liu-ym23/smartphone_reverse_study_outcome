package com.ss.ugc.effectplatform.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class e<T> {
    public e() {
    }

    public abstract T getResponseData();

    public abstract String getResponseMessage();

    public abstract int getStatusCode();

    public boolean verifySign() {
        return true;
    }

    public final boolean checkStatusCode() {
        if (getStatusCode() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean checkValue() {
        if (getResponseData() == null) goto L5;
        return true;
    L5:
        return false;
    }
}
