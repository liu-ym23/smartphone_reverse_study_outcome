package org.bouncycastle.jcajce.provider.drbg;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.net.URL;
import java.security.AccessController;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.SecureRandomSpi;
import java.security.Security;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.prng.EntropySource;
import org.bouncycastle.crypto.prng.EntropySourceProvider;
import org.bouncycastle.crypto.prng.SP800SecureRandom;
import org.bouncycastle.crypto.prng.SP800SecureRandomBuilder;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;
import org.bouncycastle.util.Properties;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public class DRBG {
    private static final String PREFIX = "org.bouncycastle.jcajce.provider.drbg.DRBG";
    private static EntropyDaemon entropyDaemon;
    private static Thread entropyThread;
    private static final String[][] initialEntropySourceNames = null;

    private static class CoreSecureRandom extends SecureRandom {
        CoreSecureRandom(Object[] r4) {
            super((SecureRandomSpi) ZeusTransformUtils.preCheckCast(r4[1], SecureRandomSpi.class, "com.obric.memorydata.plugin"), (Provider) ZeusTransformUtils.preCheckCast(r4[0], Provider.class, "com.obric.memorydata.plugin"));
        }
    }

    public static class Default extends SecureRandomSpi {
        private static final SecureRandom random = null;

        static {
            random = DRBG.access$200(true);
        }

        public Default() {
        }

        @Override // java.security.SecureRandomSpi
        public byte[] engineGenerateSeed(int r1) {
            return random.generateSeed(r1);
        }

        @Override // java.security.SecureRandomSpi
        public void engineNextBytes(byte[] r1) {
            random.nextBytes(r1);
        }

        @Override // java.security.SecureRandomSpi
        public void engineSetSeed(byte[] r1) {
            random.setSeed(r1);
        }
    }

    private static class EntropyDaemon implements Runnable {
        private final ConcurrentLinkedDeque<Runnable> tasks;

        private EntropyDaemon() {
            this.tasks = new ConcurrentLinkedDeque();
        }

        /* synthetic */ EntropyDaemon(AnonymousClass1 r1) {
            this();
        }

        void addTask(Runnable r3) {
            Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
            this.tasks.add(r4);
        }

        @Override // java.lang.Runnable
        public void run() {
        L2:
            Runnable r0 = (Runnable) ZeusTransformUtils.preCheckCast(this.tasks.pollFirst(), Runnable.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L13;
            r0.run();     // Catch: Throwable -> L10
            goto L2
        L13:
            Thread.sleep(5000);     // Catch: InterruptedException -> L9
        L9:
            Thread.currentThread().interrupt();
            goto L2
        }
    }

    private static class HybridEntropySource implements EntropySource {
        private final byte[] additionalInput;
        private final int bytesRequired;
        private final SP800SecureRandom drbg;
        private final SignallingEntropySource entropySource;
        private final AtomicInteger samples;
        private final AtomicBoolean seedAvailable;

        private class SignallingEntropySource implements IncrementalEntropySource {
            private final int byteLength;
            private final AtomicReference entropy;
            private final EntropyDaemon entropyDaemon;
            private final IncrementalEntropySource entropySource;
            private final long pause;
            private final AtomicBoolean scheduled;
            private final AtomicBoolean seedAvailable;
            final /* synthetic */ HybridEntropySource this$0;

            private class EntropyGatherer implements Runnable {
                private final IncrementalEntropySource baseRandom;
                final /* synthetic */ SignallingEntropySource this$1;

                EntropyGatherer(SignallingEntropySource r3, IncrementalEntropySource r4) {
                    IncrementalEntropySource r5 = (IncrementalEntropySource) ZeusTransformUtils.wrapperContextForParams(r4, IncrementalEntropySource.class, "com.obric.memorydata.plugin");
                    this.this$1 = r3;
                    this.baseRandom = r5;
                }

                @Override // java.lang.Runnable
                public void run() {
                    SignallingEntropySource.access$1200(this.this$1).set(this.baseRandom.getEntropy(SignallingEntropySource.access$1100(this.this$1)));
                    SignallingEntropySource.access$1300(this.this$1).set(true);
                }
            }

            SignallingEntropySource(HybridEntropySource r3, EntropyDaemon r4, AtomicBoolean r5, EntropySourceProvider r6, int r7) {
                EntropySourceProvider r8 = (EntropySourceProvider) ZeusTransformUtils.wrapperContextForParams(r6, EntropySourceProvider.class, "com.obric.memorydata.plugin");
                this.this$0 = r3;
                this.entropy = new AtomicReference();
                this.scheduled = new AtomicBoolean(false);
                this.entropyDaemon = r4;
                this.seedAvailable = r5;
                this.entropySource = (IncrementalEntropySource) ZeusTransformUtils.preCheckCast(r8.get(r7), IncrementalEntropySource.class, "com.obric.memorydata.plugin");
                this.byteLength = (r7 + 7) / 8;
                this.pause = DRBG.access$1000();
            }

            static /* synthetic */ long access$1100(SignallingEntropySource r2) {
                return r2.pause;
            }

            static /* synthetic */ AtomicReference access$1200(SignallingEntropySource r0) {
                return r0.entropy;
            }

            static /* synthetic */ AtomicBoolean access$1300(SignallingEntropySource r0) {
                return r0.seedAvailable;
            }

            @Override // org.bouncycastle.crypto.prng.EntropySource
            public int entropySize() {
                return this.byteLength * 8;
            }

            @Override // org.bouncycastle.crypto.prng.EntropySource
            public byte[] getEntropy() {
                return getEntropy(0);
            }

            @Override // org.bouncycastle.jcajce.provider.drbg.DRBG.IncrementalEntropySource
            public byte[] getEntropy(long r4) {
                byte[] r0 = (byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(this.entropy.getAndSet(null), byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin");
                if (r0 != null) goto L5;
            L8:
                r0 = this.entropySource.getEntropy(r4);
            L9:
                schedule();
                return r0;
            L5:
                if (r0.length != this.byteLength) goto L8;
                this.scheduled.set(false);
                goto L9
            }

            void schedule() {
                if (this.scheduled.getAndSet(true) == true) goto L6;
                this.entropyDaemon.addTask(new EntropyGatherer(this, this.entropySource));
                return;
            }
        }

        HybridEntropySource(EntropyDaemon r8, int r9) {
            AtomicBoolean r3 = new AtomicBoolean(false);
            this.seedAvailable = r3;
            this.samples = new AtomicInteger(0);
            this.additionalInput = Pack.longToBigEndian(System.currentTimeMillis());
            EntropySourceProvider r4 = DRBG.access$800();
            this.bytesRequired = (r9 + 7) / 8;
            SignallingEntropySource r10 = new SignallingEntropySource(this, r8, r3, r4, 256);
            this.entropySource = r10;
            this.drbg = new SP800SecureRandomBuilder(new AnonymousClass1(this)).setPersonalizationString(Strings.toByteArray("Bouncy Castle Hybrid Entropy Source")).buildHMAC(new HMac(new SHA512Digest()), r10.getEntropy(), false);
        }

        static /* synthetic */ SignallingEntropySource access$900(HybridEntropySource r0) {
            return r0.entropySource;
        }

        @Override // org.bouncycastle.crypto.prng.EntropySource
        public int entropySize() {
            return this.bytesRequired * 8;
        }

        @Override // org.bouncycastle.crypto.prng.EntropySource
        public byte[] getEntropy() {
            byte[] r0 = new byte[this.bytesRequired];
            if (this.samples.getAndIncrement() > 20) goto L5;
        L8:
            this.drbg.nextBytes(r0);
            return r0;
        L5:
            if (this.seedAvailable.getAndSet(false) == false) goto L7;
            this.samples.set(0);
            this.drbg.reseed(this.additionalInput);
            goto L8
        L7:
            this.entropySource.schedule();
            goto L8
        }
    }

    private interface IncrementalEntropySource extends EntropySource {
        byte[] getEntropy(long r1);
    }

    private static class IncrementalEntropySourceProvider implements EntropySourceProvider {
        private final boolean predictionResistant;
        private final SecureRandom random;

        public IncrementalEntropySourceProvider(SecureRandom r1, boolean r2) {
            this.random = r1;
            this.predictionResistant = r2;
        }

        static /* synthetic */ SecureRandom access$1500(IncrementalEntropySourceProvider r0) {
            return r0.random;
        }

        @Override // org.bouncycastle.crypto.prng.EntropySourceProvider
        public EntropySource get(final int r2) {
            return new AnonymousClass1(this, r2);
        }
    }

    public static class NonceAndIV extends SecureRandomSpi {
        private static final SecureRandom random = null;

        static {
            random = DRBG.access$200(false);
        }

        public NonceAndIV() {
        }

        @Override // java.security.SecureRandomSpi
        public byte[] engineGenerateSeed(int r1) {
            return random.generateSeed(r1);
        }

        @Override // java.security.SecureRandomSpi
        public void engineNextBytes(byte[] r1) {
            random.nextBytes(r1);
        }

        @Override // java.security.SecureRandomSpi
        public void engineSetSeed(byte[] r1) {
            random.setSeed(r1);
        }
    }

    private static class URLSeededEntropySourceProvider implements EntropySourceProvider {
        private final InputStream seedStream;

        URLSeededEntropySourceProvider(final URL r3) {
            this.seedStream = (InputStream) ZeusTransformUtils.preCheckCast(AccessController.doPrivileged(new AnonymousClass1(this, r3)), InputStream.class, "com.obric.memorydata.plugin");
        }

        static /* synthetic */ InputStream access$500(URLSeededEntropySourceProvider r0) {
            return r0.seedStream;
        }

        static /* synthetic */ int access$600(URLSeededEntropySourceProvider r0, byte[] r1, int r2, int r3) {
            return r0.privilegedRead(r1, r2, r3);
        }

        private int privilegedRead(final byte[] r2, final int r3, final int r4) {
            return ((Integer) ZeusTransformUtils.preCheckCast(AccessController.doPrivileged(new AnonymousClass2(this, r2, r3, r4)), Integer.class, "com.obric.memorydata.plugin")).intValue();
        }

        @Override // org.bouncycastle.crypto.prng.EntropySourceProvider
        public EntropySource get(final int r2) {
            return new AnonymousClass3(this, r2);
        }
    }

    static {
        initialEntropySourceNames = new String[][]{new String[]{"sun.security.provider.Sun", "sun.security.provider.SecureRandom"}, new String[]{"org.apache.harmony.security.provider.crypto.CryptoProvider", "org.apache.harmony.security.provider.crypto.SHA1PRNG_SecureRandomImpl"}, new String[]{"com.android.org.conscrypt.OpenSSLProvider", "com.android.org.conscrypt.OpenSSLRandom"}, new String[]{"org.conscrypt.OpenSSLProvider", "org.conscrypt.OpenSSLRandom"}};
        entropyDaemon = null;
        entropyThread = null;
        entropyDaemon = new EntropyDaemon(null);
        Thread r0 = new Thread(entropyDaemon, "BC Entropy Daemon");
        entropyThread = r0;
        r0.setDaemon(true);
        entropyThread.start();
    }

    public DRBG() {
    }

    static /* synthetic */ long access$1000() {
        return getPause();
    }

    static /* synthetic */ SecureRandom access$200(boolean r0) {
        return createBaseRandom(r0);
    }

    static /* synthetic */ EntropyDaemon access$300() {
        return entropyDaemon;
    }

    static /* synthetic */ Object[] access$400() {
        return findSource();
    }

    static /* synthetic */ void access$700(long r0) {
        sleep(r0);
    }

    static /* synthetic */ EntropySourceProvider access$800() {
        return createCoreEntropySourceProvider();
    }

    private static SecureRandom createBaseRandom(boolean r4) {
        if (Properties.getPropertyValue("org.bouncycastle.drbg.entropysource") == null) goto L10;
        EntropySourceProvider r0 = createEntropySource();
        EntropySource r1 = r0.get(128);
        byte[] r2 = r1.getEntropy();
        if (r4 == false) goto L7;
        byte[] r3 = generateDefaultPersonalizationString(r2);
    L9:
        return new SP800SecureRandomBuilder(r0).setPersonalizationString(r3).buildHash(new SHA512Digest(), r1.getEntropy(), r4);
    L7:
        r3 = generateNonceIVPersonalizationString(r2);
        goto L9
    L10:
        HybridEntropySource r5 = new HybridEntropySource(entropyDaemon, 256);
        byte[] r6 = r5.getEntropy();
        if (r4 == false) goto L13;
        byte[] r7 = generateDefaultPersonalizationString(r6);
    L15:
        return new SP800SecureRandomBuilder(new AnonymousClass1()).setPersonalizationString(r7).buildHash(new SHA512Digest(), r5.getEntropy(), r4);
    L13:
        r7 = generateNonceIVPersonalizationString(r6);
        goto L15
    }

    private static EntropySourceProvider createCoreEntropySourceProvider() {
        if (Security.getProperty("securerandom.source") == null) goto L5;
        return new URLSeededEntropySourceProvider(new URL(Security.getProperty("securerandom.source")));
    L9:
        return createInitialEntropySource();
    L5:
        return createInitialEntropySource();
    }

    private static EntropySourceProvider createEntropySource() {
        final String r0 = Properties.getPropertyValue("org.bouncycastle.drbg.entropysource");
        return (EntropySourceProvider) ZeusTransformUtils.preCheckCast(AccessController.doPrivileged(new AnonymousClass4(r0)), EntropySourceProvider.class, "com.obric.memorydata.plugin");
    }

    private static EntropySourceProvider createInitialEntropySource() {
        if (((Boolean) ZeusTransformUtils.preCheckCast(AccessController.doPrivileged(new AnonymousClass2()), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L7;
        return new IncrementalEntropySourceProvider((SecureRandom) ZeusTransformUtils.preCheckCast(AccessController.doPrivileged(new AnonymousClass3()), SecureRandom.class, "com.obric.memorydata.plugin"), true);
    L7:
        return new IncrementalEntropySourceProvider(new CoreSecureRandom(findSource()), true);
    }

    private static final Object[] findSource() {
        int r2 = 0;
    L3:
        String[][] r3 = initialEntropySourceNames;
        if (r2 >= r3.length) goto L9;
        String[] r4 = r3[r2];
        return new Object[]{ZeusTransformUtils.forName(r4[0], "com.obric.memorydata.plugin").newInstance(), ZeusTransformUtils.forName(r4[1], "com.obric.memorydata.plugin").newInstance()};
    L8:
        r2 = r2 + 1;
        goto L3
    L9:
        return null;
    }

    private static byte[] generateDefaultPersonalizationString(byte[] r4) {
        return Arrays.concatenate(Strings.toByteArray("Default"), r4, Pack.longToBigEndian(Thread.currentThread().getId()), Pack.longToBigEndian(System.currentTimeMillis()));
    }

    private static byte[] generateNonceIVPersonalizationString(byte[] r4) {
        return Arrays.concatenate(Strings.toByteArray("Nonce"), r4, Pack.longToLittleEndian(Thread.currentThread().getId()), Pack.longToLittleEndian(System.currentTimeMillis()));
    }

    private static long getPause() {
        String r0 = Properties.getPropertyValue("org.bouncycastle.drbg.gather_pause_secs");
        if (r0 != null) goto L9;
    L7:
        return 5000;
    L9:
        return Long.parseLong(r0) * 1000;
    }

    private static void sleep(long r0) {
        Thread.sleep(r0);     // Catch: InterruptedException -> L4
        return;
    L4:
        Thread.currentThread().interrupt();
    }
}
