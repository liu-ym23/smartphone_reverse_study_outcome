package com.bytedance.crash.service;

/* JADX INFO: loaded from: classes2.dex */
public interface INetworkCallback {
    public static final String TYPE_TTNET = "ttnet";
    public static final String TYPE_URL_CONNECTION = "urlconnection";

    void onCallback(String r1);
}
