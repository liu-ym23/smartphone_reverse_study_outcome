package com.bytedance.android.live.pushstream;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import io.reactivex.functions.Function;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o<T, R> implements Function {
    public static final o a = null;

    static {
        a = new o();
    }

    public o() {
    }

    public final Object apply(Object r6) {
        File r7 = (File) r6;
        Intrinsics.checkNotNullParameter(r7, "it");
        MessageDigest r0 = MessageDigest.getInstance("MD5");     // Catch: Throwable -> L17
        PolarisFileInputStreamWrapper r1 = new PolarisFileInputStreamWrapper(r7);
        byte[] r2 = new byte[8192];
    L28:
        int r3 = r1.read(r2);     // Catch: Throwable -> L10 IOException -> L12
        if (r3 <= 0) goto L8;
        r0.update(r2, 0, r3);     // Catch: Throwable -> L10 IOException -> L12
        goto L28
    L8:
        String r4 = String.format("%32s", new Object[]{new BigInteger(1, r0.digest()).toString(16)}).replace(' ', '0');     // Catch: Throwable -> L10 IOException -> L12
    L22:
        r1.close();     // Catch: IOException -> L20
    L18:
        ALogger.e("LiveStream", "name:" + r7.getName() + " md5:" + r4);
        JSONObject r5 = new JSONObject();
        BaseMonitor.add(r5, "so_name", r7.getName());
        BaseMonitor.add(r5, "so_md5", r4);
        return r5;
    L12:
        r4 = "";
    L10:
        th = move-exception;
        r1.close();     // Catch: IOException -> L21
    L16:
        throw th;
    L17:
        r4 = null;
        goto L18
    }
}
