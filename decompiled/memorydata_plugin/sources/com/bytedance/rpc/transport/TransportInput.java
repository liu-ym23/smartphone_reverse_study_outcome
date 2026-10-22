package com.bytedance.rpc.transport;

import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public interface TransportInput {
    long contentLength();

    String contentType();

    InputStream in();
}
