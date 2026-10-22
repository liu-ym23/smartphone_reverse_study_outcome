package com.bytedance.bdinstall.util;

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
        return requestIdSingleTon.get(new Object[0]);
    }
}
