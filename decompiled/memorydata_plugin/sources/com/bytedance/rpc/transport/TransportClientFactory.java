package com.bytedance.rpc.transport;

import com.bytedance.rpc.RpcContext;

/* JADX INFO: loaded from: classes2.dex */
public interface TransportClientFactory {
    TransportClient create(RpcContext r1, boolean r2);
}
