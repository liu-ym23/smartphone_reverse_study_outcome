package com.optimize.statistics;

import com.bytedance.ttnet.http.HttpRequestInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface ImageTraceListener {
    void imageNetCallBack(long r1, long r3, String r5, HttpRequestInfo r6, Throwable r7, JSONObject r8);

    void onImageLoaded(boolean r1, String r2, JSONObject r3);
}
