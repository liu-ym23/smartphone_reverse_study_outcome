package com.google.crypto.tink.config.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class TinkFipsUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f4874a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f4875b = null;

    /* JADX INFO: renamed from: com.google.crypto.tink.config.internal.TinkFipsUtil$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static abstract enum AlgorithmFipsCompatibility extends Enum<AlgorithmFipsCompatibility> {
        private static final /* synthetic */ AlgorithmFipsCompatibility[] $VALUES = null;
        public static final AlgorithmFipsCompatibility ALGORITHM_NOT_FIPS = null;
        public static final AlgorithmFipsCompatibility ALGORITHM_REQUIRES_BORINGCRYPTO = null;

        static {
            final String r1 = "ALGORITHM_NOT_FIPS";
            final int r2 = 0;
            AlgorithmFipsCompatibility r0 = new AnonymousClass1(r1, r2);
            ALGORITHM_NOT_FIPS = r0;
            final String r3 = "ALGORITHM_REQUIRES_BORINGCRYPTO";
            final int r4 = 1;
            AlgorithmFipsCompatibility r5 = new AnonymousClass2(r3, r4);
            ALGORITHM_REQUIRES_BORINGCRYPTO = r5;
            $VALUES = new AlgorithmFipsCompatibility[]{r0, r5};
        }

        private AlgorithmFipsCompatibility(String r1, int r2) {
            super(r1, r2);
        }

        /* synthetic */ AlgorithmFipsCompatibility(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        public static AlgorithmFipsCompatibility valueOf(String r2) {
            return (AlgorithmFipsCompatibility) ZeusTransformUtils.preCheckCast(Enum.valueOf(AlgorithmFipsCompatibility.class, r2), AlgorithmFipsCompatibility.class, "com.obric.memorydata.plugin");
        }

        public static AlgorithmFipsCompatibility[] values() {
            return (AlgorithmFipsCompatibility[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AlgorithmFipsCompatibility[].class, "com.obric.memorydata.plugin");
        }

        public abstract boolean isCompatible();
    }

    static {
        f4874a = Logger.getLogger(TinkFipsUtil.class.getName());
        f4875b = new AtomicBoolean(false);
    }

    private TinkFipsUtil() {
    }

    public static boolean a() {
        if (a.a() == false) goto L5;
    L8:
        return true;
    L5:
        if (f4875b.get() == true) goto L8;
        return false;
    }

    public static boolean b() {
        return c().booleanValue();
    }

    static Boolean c() {
        return (Boolean) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName("org.conscrypt.Conscrypt", "com.obric.memorydata.plugin").getMethod("isBoringSslFIPSBuild", new Class[0]).invoke(null, new Object[0]), Boolean.class, "com.obric.memorydata.plugin");
    L5:
        f4874a.info("Conscrypt is not available or does not support checking for FIPS build.");
        return false;
    }
}
