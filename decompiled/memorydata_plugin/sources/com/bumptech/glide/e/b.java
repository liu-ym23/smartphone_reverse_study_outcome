package com.bumptech.glide.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ConcurrentMap<String, com.bumptech.glide.load.c> f550a = null;

    static {
        f550a = new ConcurrentHashMap();
    }

    public static com.bumptech.glide.load.c a(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        String r0 = r6.getPackageName();
        ConcurrentMap<String, com.bumptech.glide.load.c> r2 = f550a;
        com.bumptech.glide.load.c r3 = (com.bumptech.glide.load.c) ZeusTransformUtils.preCheckCast(r2.get(r0), com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L9;
        com.bumptech.glide.load.c r4 = b(r6);
        com.bumptech.glide.load.c r7 = (com.bumptech.glide.load.c) ZeusTransformUtils.preCheckCast(r2.putIfAbsent(r0, r4), com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L8;
        return r4;
    L8:
        return r7;
    L9:
        return r3;
    }

    private static String a(PackageInfo r0) {
        if (r0 == null) goto L5;
        return String.valueOf(r0.versionCode);
    L5:
        return UUID.randomUUID().toString();
    }

    private static com.bumptech.glide.load.c b(Context r2) {
        return new d(a(c((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"))));
    }

    private static PackageInfo c(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        return r4.getPackageManager().getPackageInfo(r4.getPackageName(), 0);
    L5:
        e = move-exception;
        Log.e("AppVersionSignature", "Cannot resolve info for" + r4.getPackageName(), e);
        return null;
    }
}
