package com.ss.ugc.effectplatform.bridge.network;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface b extends INetworkClient {
    NetResponse a(NetRequest r1, String r2, String r3, a r4);

    void cancel(String r1);

    void pause(String r1);
}
