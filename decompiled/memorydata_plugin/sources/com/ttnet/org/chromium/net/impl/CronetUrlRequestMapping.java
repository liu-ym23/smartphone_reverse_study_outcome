package com.ttnet.org.chromium.net.impl;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes6.dex */
public class CronetUrlRequestMapping {
    public static final String TAG = "CronetUrlRequestMapping";
    private static Map<String, CronetUrlRequest> sRequestMapping;

    static {
        sRequestMapping = new ConcurrentHashMap();
    }

    public CronetUrlRequestMapping() {
    }

    public static void AddRequest(String r1, CronetUrlRequest r2) {
        if (TextUtils.isEmpty(r1) == true) goto L7;
        if (r2 == null) goto L8;
        sRequestMapping.put(r1, r2);
        return;
    L8:
        return;
    }

    public static CronetUrlRequest GetRequest(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return null;
    L5:
        return (CronetUrlRequest) ZeusTransformUtils.preCheckCast(sRequestMapping.get(r2), CronetUrlRequest.class, "com.obric.memorydata.plugin");
    }

    public static void RemoveRequest(String r1) {
        if (TextUtils.isEmpty(r1) == true) goto L6;
        sRequestMapping.remove(r1);
        return;
    }
}
