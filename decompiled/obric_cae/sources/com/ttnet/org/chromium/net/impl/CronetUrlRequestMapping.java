package com.ttnet.org.chromium.net.impl;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class CronetUrlRequestMapping {
    public static final String TAG = "CronetUrlRequestMapping";
    private static Map<String, CronetUrlRequest> sRequestMapping;

    static {
        sRequestMapping = new ConcurrentHashMap();
    }

    public CronetUrlRequestMapping() {
    }

    public static void AddRequest(String r8, CronetUrlRequest r10) {
        if (TextUtils.isEmpty(r8) == true) goto L7;
        if (r10 == null) goto L8;
        sRequestMapping.put(r8, r10);
        return;
    L8:
        return;
    }

    public static CronetUrlRequest GetRequest(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return null;
    L5:
        return sRequestMapping.get(r8);
    }

    public static void RemoveRequest(String r8) {
        if (TextUtils.isEmpty(r8) == true) goto L6;
        sRequestMapping.remove(r8);
        return;
    }
}
