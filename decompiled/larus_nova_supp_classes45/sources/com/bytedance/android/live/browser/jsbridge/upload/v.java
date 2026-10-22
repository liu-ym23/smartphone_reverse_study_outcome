package com.bytedance.android.live.browser.jsbridge.upload;

import android.util.Base64;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.util.concurrent.Callable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class v<V> implements Callable {
    public final /* synthetic */ x a;
    public final /* synthetic */ String b;

    public v(x r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.util.concurrent.Callable
    public final String call() {
        x r0 = this.a;
        String r1 = this.b;
        r0.getClass();
        PolarisFileInputStreamWrapper r2 = new PolarisFileInputStreamWrapper(r1);
        byte[] r3 = new byte[r2.available()];     // Catch: Throwable -> L6
        r2.read(r3);     // Catch: Throwable -> L6
        String r4 = Base64.encodeToString(r3, 2);     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r2, null);
        return r4;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);
        throw th;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
