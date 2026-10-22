package com.bytedance.retrofit2.client;

/* JADX INFO: loaded from: classes2.dex */
public interface Client {

    public interface Provider {
        Client get();
    }

    SsCall newSsCall(Request r1);
}
