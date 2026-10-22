package com.bytedance.pia.core.api.bridge;

/* JADX INFO: loaded from: classes2.dex */
public class PiaMethod$Error extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6951a;

    public PiaMethod$Error() {
        super("");
        this.f6951a = 0;
    }

    public PiaMethod$Error(int r5) {
        super("");
        this.f6951a = r5;
    }

    public PiaMethod$Error(int r5, String r10) {
        super(r10);
        this.f6951a = r5;
    }

    public PiaMethod$Error(String r5) {
        super(r5);
        this.f6951a = 0;
    }
}
