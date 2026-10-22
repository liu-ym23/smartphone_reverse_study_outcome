package com.bytedance.bdinstall.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class RequestIdGenerator {
    private static Singleton<String> requestIdSingleTon;

    static {
        requestIdSingleTon = createReqIdSingleton();
    }

    public RequestIdGenerator() {
    }

    public static void clearReqId() {
        requestIdSingleTon = createReqIdSingleton();
    }

    private static Singleton<String> createReqIdSingleton() {
        return new AnonymousClass1();
    }

    public static String getRequestId() {
        return (String) ZeusTransformUtils.preCheckCast(requestIdSingleTon.get(new Object[0]), String.class, "com.obric.memorydata.plugin");
    }
}
