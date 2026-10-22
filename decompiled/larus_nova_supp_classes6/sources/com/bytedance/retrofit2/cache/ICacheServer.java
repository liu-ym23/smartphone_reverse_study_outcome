package com.bytedance.retrofit2.cache;

import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface ICacheServer {
    Response getCacheResponse(Request r1);

    Response putCacheResponse(Request r1, Response r2);
}
