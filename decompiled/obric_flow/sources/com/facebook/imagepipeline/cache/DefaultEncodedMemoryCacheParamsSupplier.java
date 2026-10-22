package com.facebook.imagepipeline.cache;

import com.facebook.common.internal.Supplier;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultEncodedMemoryCacheParamsSupplier implements Supplier<MemoryCacheParams> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f8032a = 0;

    static {
        f8032a = TimeUnit.MINUTES.toMillis(5);
    }

    public DefaultEncodedMemoryCacheParamsSupplier() {
    }

    @Override // com.facebook.common.internal.Supplier
    public final Object get() {
        int r10 = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (r10 >= 16777216) goto L7;
        int r11 = 1048576;
    L5:
        int r5 = r11;
        return new MemoryCacheParams(r5, Integer.MAX_VALUE, r5, r5 / 8, f8032a);
    L7:
        if (r10 >= 33554432) goto L9;
        r11 = 2097152;
        goto L5
    L9:
        r11 = 4194304;
        goto L5
    }
}
