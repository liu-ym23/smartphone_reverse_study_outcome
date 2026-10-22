package org.bouncycastle.pqc.crypto.lms;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.WeakHashMap;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.pqc.crypto.ExhaustedPrivateKeyException;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.io.Streams;

/* JADX INFO: loaded from: classes7.dex */
public class LMSPrivateKeyParameters extends LMSKeyParameters {
    private static CacheKey T1;
    private static CacheKey[] internedKeys;
    private final byte[] I;
    private final byte[] masterSecret;
    private final int maxCacheR;
    private final int maxQ;
    private final LMOtsParameters otsParameters;
    private final LMSigParameters parameters;
    private LMSPublicKeyParameters publicKey;
    private int q;
    private final Map<CacheKey, byte[]> tCache;
    private final Digest tDigest;

    private static class CacheKey {
        private final int index;

        CacheKey(int r1) {
            this.index = r1;
        }

        static /* synthetic */ int access$000(CacheKey r0) {
            return r0.index;
        }

        public boolean equals(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, CacheKey.class) == true) goto L5;
            return false;
        L5:
            if (((CacheKey) ZeusTransformUtils.preCheckCast(r4, CacheKey.class, "com.obric.memorydata.plugin")).index != this.index) goto L9;
            return true;
        L9:
            return false;
        }

        public int hashCode() {
            return this.index;
        }
    }

    static {
        CacheKey r0 = new CacheKey(1);
        T1 = r0;
        CacheKey[] r2 = new CacheKey[129];
        internedKeys = r2;
        r2[1] = r0;
        int r1 = 2;
    L3:
        CacheKey[] r3 = internedKeys;
        if (r1 >= r3.length) goto L6;
        r3[r1] = new CacheKey(r1);
        r1 = r1 + 1;
        goto L3
    }

    private LMSPrivateKeyParameters(LMSPrivateKeyParameters r4, int r5, int r6) {
        super(true);
        LMSigParameters r1 = r4.parameters;
        this.parameters = r1;
        this.otsParameters = r4.otsParameters;
        this.q = r5;
        this.I = r4.I;
        this.maxQ = r6;
        this.masterSecret = r4.masterSecret;
        this.maxCacheR = 1 << r1.getH();
        this.tCache = r4.tCache;
        this.tDigest = DigestUtil.getDigest(r1.getDigestOID());
        this.publicKey = r4.publicKey;
    }

    public LMSPrivateKeyParameters(LMSigParameters r2, LMOtsParameters r3, int r4, byte[] r5, int r6, byte[] r7) {
        super(true);
        this.parameters = r2;
        this.otsParameters = r3;
        this.q = r4;
        this.I = Arrays.clone(r5);
        this.maxQ = r6;
        this.masterSecret = Arrays.clone(r7);
        this.maxCacheR = 1 << (r2.getH() + 1);
        this.tCache = new WeakHashMap();
        this.tDigest = DigestUtil.getDigest(r2.getDigestOID());
    }

    private byte[] calcT(int r6) {
        int r0 = 1 << getSigParameters().getH();
        if (r6 < r0) goto L6;
        LmsUtils.byteArray(getI(), this.tDigest);
        LmsUtils.u32str(r6, this.tDigest);
        LmsUtils.u16str(-32126, this.tDigest);
        LmsUtils.byteArray(LM_OTS.lms_ots_generatePublicKey(getOtsParameters(), getI(), r6 - r0, getMasterSecret()), this.tDigest);
        byte[] r7 = new byte[this.tDigest.getDigestSize()];
        this.tDigest.doFinal(r7, 0);
        return r7;
    L6:
        int r1 = r6 * 2;
        byte[] r3 = findT(r1);
        byte[] r2 = findT(r1 + 1);
        LmsUtils.byteArray(getI(), this.tDigest);
        LmsUtils.u32str(r6, this.tDigest);
        LmsUtils.u16str(-31869, this.tDigest);
        LmsUtils.byteArray(r3, this.tDigest);
        LmsUtils.byteArray(r2, this.tDigest);
        byte[] r8 = new byte[this.tDigest.getDigestSize()];
        this.tDigest.doFinal(r8, 0);
        return r8;
    }

    private byte[] findT(CacheKey r5) {
        Map<CacheKey, byte[]> r0 = this.tCache;
        monitor-enter(r0);
        byte[] r1 = (byte[]) ZeusTransformUtils.preCheckCast(this.tCache.get(r5), byte[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r1 == null) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r1;
    L8:
        byte[] r2 = calcT(CacheKey.access$000(r5));     // Catch: Throwable -> L11
        this.tCache.put(r5, r2);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r2;
    L11:
        th = move-exception;
        throw th;
    }

    public static LMSPrivateKeyParameters getInstance(Object r8) {
        if (ZeusTransformUtils.instanceOf(r8, LMSPrivateKeyParameters.class) == false) goto L7;
        return (LMSPrivateKeyParameters) ZeusTransformUtils.preCheckCast(r8, LMSPrivateKeyParameters.class, "com.obric.memorydata.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r8, DataInputStream.class) == false) goto L23;
        DataInputStream r9 = (DataInputStream) ZeusTransformUtils.preCheckCast(r8, DataInputStream.class, "com.obric.memorydata.plugin");
        if (r9.readInt() != 0) goto L21;
        LMSigParameters r2 = LMSigParameters.getParametersForType(r9.readInt());
        LMOtsParameters r3 = LMOtsParameters.getParametersForType(r9.readInt());
        byte[] r5 = new byte[16];
        r9.readFully(r5);
        int r4 = r9.readInt();
        int r6 = r9.readInt();
        int r0 = r9.readInt();
        if (r0 < 0) goto L19;
        if (r0 > r9.available()) goto L17;
        byte[] r7 = new byte[r0];
        r9.readFully(r7);
        return new LMSPrivateKeyParameters(r2, r3, r4, r5, r6, r7);
    L17:
        throw new IOException("secret length exceeded " + r9.available());
    L19:
        throw new IllegalStateException("secret length less than zero");
    L21:
        throw new IllegalStateException("expected version 0 lms private key");
    L23:
        if ((r8 instanceof byte[]) == false) goto L36;
        DataInputStream r1 = null;
        DataInputStream r10 = new DataInputStream(new ByteArrayInputStream((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r8, byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L31
        LMSPrivateKeyParameters r11 = getInstance(r10);     // Catch: Throwable -> L29
        r10.close();
        return r11;
    L29:
        th = th;
        r1 = r10;
    L32:
        if (r1 == null) goto L34;
        r1.close();
    L34:
        throw th;
    L31:
        th = th;
        goto L32
    L36:
        if (ZeusTransformUtils.instanceOf(r8, InputStream.class) == false) goto L40;
        return getInstance(Streams.readAll((InputStream) ZeusTransformUtils.preCheckCast(r8, InputStream.class, "com.obric.memorydata.plugin")));
    L40:
        throw new IllegalArgumentException("cannot parse " + r8);
    }

    public static LMSPrivateKeyParameters getInstance(byte[] r0, byte[] r1) {
        LMSPrivateKeyParameters r2 = getInstance(r0);
        r2.publicKey = LMSPublicKeyParameters.getInstance(r1);
        return r2;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L45:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L45;
        LMSPrivateKeyParameters r6 = (LMSPrivateKeyParameters) ZeusTransformUtils.preCheckCast(r5, LMSPrivateKeyParameters.class, "com.obric.memorydata.plugin");
        if (this.q == r6.q) goto L14;
        return false;
    L14:
        if (this.maxQ == r6.maxQ) goto L17;
        return false;
    L17:
        if (Arrays.areEqual(this.I, r6.I) == true) goto L19;
        return false;
    L19:
        LMSigParameters r2 = this.parameters;
        if (r2 == null) goto L25;
        if (r2.equals(r6.parameters) == false) goto L26;
    L27:
        LMOtsParameters r3 = this.otsParameters;
        if (r3 == null) goto L33;
        if (r3.equals(r6.otsParameters) == true) goto L36;
    L34:
        return false;
    L36:
        if (Arrays.areEqual(this.masterSecret, r6.masterSecret) == true) goto L38;
        return false;
    L38:
        LMSPublicKeyParameters r4 = this.publicKey;
        if (r4 == null) goto L44;
        LMSPublicKeyParameters r7 = r6.publicKey;
        if (r7 == null) goto L44;
        return r4.equals(r7);
    L44:
        return true;
    L33:
        if (r6.otsParameters == null) goto L36;
    L26:
        return false;
    L25:
        if (r6.parameters == null) goto L27;
        goto L26
    }

    public LMSPrivateKeyParameters extractKeyShard(int r4) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if ((this.q + r4) >= this.maxQ) goto L9;
        int r1 = this.q;     // Catch: Throwable -> L10
        LMSPrivateKeyParameters r0 = new LMSPrivateKeyParameters(this, r1, r1 + r4);     // Catch: Throwable -> L10
        this.q += r4;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return r0;
    L9:
        throw new IllegalArgumentException("usageCount exceeds usages remaining");     // Catch: Throwable -> L10
    }

    byte[] findT(int r3) {
        if (r3 >= this.maxCacheR) goto L11;
        CacheKey[] r0 = internedKeys;
        if (r3 >= r0.length) goto L7;
        CacheKey r4 = r0[r3];
    L9:
        return findT(r4);
    L7:
        r4 = new CacheKey(r3);
        goto L9
    L11:
        return calcT(r3);
    }

    public LMSContext generateLMSContext() {
        int r0 = getSigParameters().getH();
        int r1 = getIndex();
        LMOtsPrivateKey r2 = getNextOtsPrivateKey();
        int r4 = (1 << r0) + r1;
        byte[][] r3 = new byte[r0][];
        int r5 = 0;
    L3:
        if (r5 >= r0) goto L6;
        r3[r5] = findT((r4 / (1 << r5)) ^ 1);
        r5 = r5 + 1;
        goto L3
    L6:
        return r2.getSignatureContext(getSigParameters(), r3);
    }

    @Override // org.bouncycastle.pqc.crypto.lms.LMSKeyParameters, org.bouncycastle.util.Encodable
    public byte[] getEncoded() {
        return Composer.compose().u32str(0).u32str(this.parameters.getType()).u32str(this.otsParameters.getType()).bytes(this.I).u32str(this.q).u32str(this.maxQ).u32str(this.masterSecret.length).bytes(this.masterSecret).build();
    }

    public byte[] getI() {
        return Arrays.clone(this.I);
    }

    public synchronized int getIndex() {
        monitor-enter(this);
        int r0 = this.q;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public byte[] getMasterSecret() {
        return Arrays.clone(this.masterSecret);
    }

    LMOtsPrivateKey getNextOtsPrivateKey() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.q >= this.maxQ) goto L9;
        LMOtsPrivateKey r0 = new LMOtsPrivateKey(this.otsParameters, this.I, this.q, this.masterSecret);     // Catch: Throwable -> L10
        incIndex();     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return r0;
    L9:
        throw new ExhaustedPrivateKeyException("ots private key exhausted");     // Catch: Throwable -> L10
    }

    public LMOtsParameters getOtsParameters() {
        return this.otsParameters;
    }

    public LMSPublicKeyParameters getPublicKey() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.publicKey != null) goto L6;
        this.publicKey = new LMSPublicKeyParameters(this.parameters, this.otsParameters, findT(T1), this.I);     // Catch: Throwable -> L9
    L6:
        LMSPublicKeyParameters r0 = this.publicKey;     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        return r0;
    }

    public LMSigParameters getSigParameters() {
        return this.parameters;
    }

    public long getUsagesRemaining() {
        return this.maxQ - this.q;
    }

    public int hashCode() {
        int r0 = ((this.q * 31) + Arrays.hashCode(this.I)) * 31;
        LMSigParameters r1 = this.parameters;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        LMOtsParameters r5 = this.otsParameters;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (((((r4 + r6) * 31) + this.maxQ) * 31) + Arrays.hashCode(this.masterSecret)) * 31;
        LMSPublicKeyParameters r8 = this.publicKey;
        if (r8 == null) goto L14;
        r2 = r8.hashCode();
    L14:
        return r7 + r2;
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    synchronized void incIndex() {
        monitor-enter(this);
        this.q++;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
