package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import android.os.Build;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class CronetLoggerFactory {
    private static final String CRONET_LOGGER_IMPL_CLASS = "com.google.net.cronet.telemetry.CronetLoggerImpl";
    private static final int SAMPLE_RATE_PER_SECOND = 1;
    private static final CronetLogger sDefaultLogger = null;
    private static CronetLogger sTestingLogger;

    public static class SwapLoggerForTesting implements AutoCloseable {
        public SwapLoggerForTesting(CronetLogger r10) {
            CronetLoggerFactory.access$000(r10);
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            CronetLoggerFactory.access$000(null);
        }
    }

    static {
        sDefaultLogger = new NoOpLogger();
    }

    private CronetLoggerFactory() {
    }

    static /* synthetic */ void access$000(CronetLogger r10) {
        setLoggerForTesting(r10);
    }

    public static CronetLogger createLogger(Context r10, CronetLogger.CronetSource r11) {
        CronetLogger r12 = sTestingLogger;
        if (r12 == null) goto L6;
        return r12;
    L6:
        if (CronetManifest.isAppOptedInForTelemetry(r10, r11) == false) goto L20;
        if (Build.VERSION.SDK_INT < 30) goto L20;
        Class<? extends CronetLogger> r13 = fetchLoggerImplClass();
        if (r13 != null) goto L21;
        return sDefaultLogger;
    L21:
        return r13.getConstructor(new Class[]{Integer.TYPE}).newInstance(new Object[]{1});
    L18:
        return sDefaultLogger;
    L20:
        return sDefaultLogger;
    }

    public static CronetLogger createNoOpLogger() {
        return sDefaultLogger;
    }

    private static Class<? extends CronetLogger> fetchLoggerImplClass() {
        return CronetLoggerFactory.class.getClassLoader().loadClass(CRONET_LOGGER_IMPL_CLASS).asSubclass(CronetLogger.class);
    L5:
        return null;
    }

    private static void setLoggerForTesting(@Nullable CronetLogger r10) {
        sTestingLogger = r10;
    }
}
