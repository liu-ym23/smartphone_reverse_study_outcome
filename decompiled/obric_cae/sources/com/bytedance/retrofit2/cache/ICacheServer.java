package com.bytedance.retrofit2.cache;

import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;

/* JADX INFO: loaded from: classes.dex */
public interface ICacheServer {
    Response getCacheResponse(Request r8);

    Response putCacheResponse(Request r8, Response r10);
}
