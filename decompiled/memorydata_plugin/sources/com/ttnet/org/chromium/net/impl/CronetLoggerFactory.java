package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final class CronetLoggerFactory {
    private static final String CRONET_LOGGER_IMPL_CLASS = "com.google.net.cronet.telemetry.CronetLoggerImpl";
    private static final int SAMPLE_RATE_PER_SECOND = 1;
    private static final CronetLogger sDefaultLogger = null;
    private static CronetLogger sTestingLogger;

    public static class SwapLoggerForTesting implements AutoCloseable {
        public SwapLoggerForTesting(CronetLogger r1) {
            CronetLoggerFactory.access$000(r1);
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

    static /* synthetic */ void access$000(CronetLogger r0) {
        setLoggerForTesting(r0);
    }

    public static CronetLogger createLogger(Context r4, CronetLogger.CronetSource r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        CronetLogger r0 = sTestingLogger;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (CronetManifest.isAppOptedInForTelemetry(r6, r5) == false) goto L20;
        if (Build.VERSION.SDK_INT < 30) goto L20;
        Class<? extends CronetLogger> r7 = fetchLoggerImplClass();
        if (r7 != null) goto L21;
        return sDefaultLogger;
    L21:
        return (CronetLogger) ZeusTransformUtils.preCheckCast(r7.getConstructor(new Class[]{Integer.TYPE}).newInstance(new Object[]{1}), CronetLogger.class, "com.obric.memorydata.plugin");
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

    private static void setLoggerForTesting(CronetLogger r0) {
        sTestingLogger = r0;
    }
}
