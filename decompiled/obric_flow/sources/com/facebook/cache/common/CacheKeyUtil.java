package com.facebook.cache.common;

import com.facebook.common.util.SecureHashUtil;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CacheKeyUtil {
    public static ArrayList a(SimpleCacheKey r5) {
        ArrayList r10 = new ArrayList(1);     // Catch: UnsupportedEncodingException -> L5
        r10.add(SecureHashUtil.a(r5.f7579a.getBytes("UTF-8")));     // Catch: UnsupportedEncodingException -> L5
        return r10;
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static String a(CacheKey r5) {
    L7:
        e = move-exception;
        throw new RuntimeException(e);
    L4:
        if ((r5 instanceof MultiCacheKey) == false) goto L10;
        return SecureHashUtil.a(((CacheKey) ((MultiCacheKey) r5).f7576a.get(0)).a().getBytes("UTF-8"));
    L10:
        return SecureHashUtil.a(r5.a().getBytes("UTF-8"));
    }
}
