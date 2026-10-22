package com.bytedance.map.api.exception;

/* JADX INFO: loaded from: classes2.dex */
public class BDMapException extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6899a;

    public BDMapException(String r5) {
        this.f6899a = r5;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return this.f6899a;
    }
}
