package com.bytedance.bmmt.base;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
class JniHelper {
    public JniHelper() {
    }

    public static Object getStringClass() {
        return String.class;
    }

    public static Object getKey(Map.Entry r0) {
        return r0.getKey();
    }

    public static byte[] getStringBytes(String r1) {
        return r1.getBytes("utf-8");
    L5:
        throw new RuntimeException("utf-8 is unsupported");
    }

    public static Object getValue(Map.Entry r0) {
        return r0.getValue();
    }
}
