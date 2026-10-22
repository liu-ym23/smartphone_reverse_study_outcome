package com.obric.assistant.upload.internal;

import androidx.collection.LruCache;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.platform.service.o;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class k {
    public static final LruCache<String, l> a = null;

    static {
        a = new LruCache(10);
    }

    public static void a(String r2, boolean r3, long r4, long r6, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r2, "identifier");
        long r0 = System.currentTimeMillis() - r4;
        long r5 = System.currentTimeMillis() - r6;
        l r7 = (l) a.get(r2);
        if (r7 != null) goto L5;
        r7 = new l(0);
    L5:
        r7.i(Boolean.valueOf(r3));
        if (r8 == null) goto L8;
        r7.g(r8);
    L8:
        if (r9 == null) goto L10;
        r7.h(r9);
    L10:
        r7.e(Long.valueOf(r0));
        r7.f(Long.valueOf(r5));
        JSONObject r10 = new JSONObject(GsonProtectorUtils.toJson(new Gson(), r7));
        o.a.reportEvent("o_resource_upload", r10);
    }
}
