package com.bytedance.ai.debugscene;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.okhttp.GlobalNetworkGate;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class z0 {
    public static final ExecutorService a = null;

    static {
        a = PThreadExecutorsUtils.newCachedThreadPool(new x0());
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection a(URL r10) throws IOException {
        String r11 = r10.getHost();     // Catch: Throwable -> L8 IOException -> L12
        String r12 = r10.getPath();     // Catch: Throwable -> L8 IOException -> L12
        if (com.obric.assistant.network.okhttp.a.c(r11, r12) == false) goto L11;
        FLogger.a.i("UrlConnLancet", "openConnection drop host=" + r11 + " path=" + r12);     // Catch: Throwable -> L8 IOException -> L12
        com.obric.assistant.network.okhttp.a.b(GlobalNetworkGate.a(r11, r12), r11, r12);     // Catch: Throwable -> L8 IOException -> L12
        throw new IOException("[NetGuard] dropped " + r10);     // Catch: Throwable -> L8 IOException -> L12
    L11:
        return r10.openConnection();
    L12:
        e = move-exception;
        throw e;
    L8:
        th = move-exception;
        FLogger.a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
        goto L11
    }
}
