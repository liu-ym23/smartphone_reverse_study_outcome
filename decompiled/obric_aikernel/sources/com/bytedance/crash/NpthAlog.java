package com.bytedance.crash;

/* JADX INFO: loaded from: classes.dex */
final class NpthAlog {
    NpthAlog() {
    }

    static void init() {
        NpthAlogApi.setAlogFlushImpl(new AnonymousClass1());
        NpthAlogApi.setAlogGetFilesImpl(new AnonymousClass2());
        NpthAlogApi.setAlogInitImpl(new AnonymousClass3());
    }
}
