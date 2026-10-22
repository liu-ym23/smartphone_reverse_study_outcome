package org.bouncycastle.pqc.crypto.lms;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.io.Streams;

/* JADX INFO: loaded from: classes7.dex */
public class HSSPrivateKeyParameters extends LMSKeyParameters {
    private long index;
    private final long indexLimit;
    private final boolean isShard;
    private List<LMSPrivateKeyParameters> keys;
    private final int l;
    private HSSPublicKeyParameters publicKey;
    private List<LMSSignature> sig;

    private HSSPrivateKeyParameters(int r3, List<LMSPrivateKeyParameters> r4, List<LMSSignature> r5, long r6, long r8, boolean r10) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        super(true);
        this.index = 0;
        this.l = r3;
        this.keys = Collections.unmodifiableList(r7);
        this.sig = Collections.unmodifiableList(r9);
        this.index = r6;
        this.indexLimit = r8;
        this.isShard = r10;
    }

    public static HSSPrivateKeyParameters getInstance(Object r13) {
        if (ZeusTransformUtils.instanceOf(r13, HSSPrivateKeyParameters.class) == false) goto L7;
        return (HSSPrivateKeyParameters) ZeusTransformUtils.preCheckCast(r13, HSSPrivateKeyParameters.class, "com.obric.memorydata.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r13, DataInputStream.class) == false) goto L21;
        if (((DataInputStream) ZeusTransformUtils.preCheckCast(r13, DataInputStream.class, "com.obric.memorydata.plugin")).readInt() != 0) goto L19;
        int r5 = ((DataInputStream) ZeusTransformUtils.preCheckCast(r13, DataInputStream.class, "com.obric.memorydata.plugin")).readInt();
        long r8 = ((DataInputStream) ZeusTransformUtils.preCheckCast(r13, DataInputStream.class, "com.obric.memorydata.plugin")).readLong();
        long r10 = ((DataInputStream) ZeusTransformUtils.preCheckCast(r13, DataInputStream.class, "com.obric.memorydata.plugin")).readLong();
        boolean r12 = ((DataInputStream) ZeusTransformUtils.preCheckCast(r13, DataInputStream.class, "com.obric.memorydata.plugin")).readBoolean();
        ArrayList r6 = new ArrayList();
        ArrayList r7 = new ArrayList();
        int r0 = 0;
        int r1 = 0;
    L11:
        if (r1 >= r5) goto L14;
        r6.add(LMSPrivateKeyParameters.getInstance(r13));
        r1 = r1 + 1;
    L14:
        if (r0 >= (r5 - 1)) goto L17;
        r7.add(LMSSignature.getInstance(r13));
        r0 = r0 + 1;
        goto L14
    L17:
        return new HSSPrivateKeyParameters(r5, r6, r7, r8, r10, r12);
    L19:
        throw new IllegalStateException("unknown version for hss private key");
    L21:
        if ((r13 instanceof byte[]) == false) goto L34;
        DataInputStream r2 = null;
        DataInputStream r3 = new DataInputStream(new ByteArrayInputStream((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r13, byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L29
        HSSPrivateKeyParameters r14 = getInstance(r3);     // Catch: Throwable -> L27
        r3.close();
        return r14;
    L27:
        th = th;
        r2 = r3;
    L30:
        if (r2 == null) goto L32;
        r2.close();
    L32:
        throw th;
    L29:
        th = th;
        goto L30
    L34:
        if (ZeusTransformUtils.instanceOf(r13, InputStream.class) == false) goto L38;
        return getInstance(Streams.readAll((InputStream) ZeusTransformUtils.preCheckCast(r13, InputStream.class, "com.obric.memorydata.plugin")));
    L38:
        throw new IllegalArgumentException("cannot parse " + r13);
    }

    public static HSSPrivateKeyParameters getInstance(byte[] r0, byte[] r1) {
        HSSPrivateKeyParameters r2 = getInstance(r0);
        r2.publicKey = HSSPublicKeyParameters.getInstance(r1);
        return r2;
    }

    private static HSSPrivateKeyParameters makeCopy(HSSPrivateKeyParameters r2) {
        return getInstance(r2.getEncoded());
    L4:
        e = move-exception;
        throw new RuntimeException(e.getMessage(), e);
    }

    public Object clone() {
        return makeCopy(this);
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L6;
        return true;
    L6:
        if (r6 != null) goto L8;
    L27:
        return false;
    L8:
        if (getClass() != r6.getClass()) goto L27;
        HSSPrivateKeyParameters r7 = (HSSPrivateKeyParameters) ZeusTransformUtils.preCheckCast(r6, HSSPrivateKeyParameters.class, "com.obric.memorydata.plugin");
        if (this.l == r7.l) goto L14;
        return false;
    L14:
        if (this.isShard == r7.isShard) goto L17;
        return false;
    L17:
        if (this.indexLimit == r7.indexLimit) goto L20;
        return false;
    L20:
        if (this.index == r7.index) goto L23;
        return false;
    L23:
        if (this.keys.equals(r7.keys) == true) goto L26;
        return false;
    L26:
        return this.sig.equals(r7.sig);
    }

    public HSSPrivateKeyParameters extractKeyShard(int r14) {
        monitor-enter(this);
        long r2 = r14;
        if (getUsagesRemaining() < r2) goto L9;
        long r8 = this.index;     // Catch: Throwable -> L10
        this.index = r2 + r8;     // Catch: Throwable -> L10
        ArrayList r6 = new ArrayList(getKeys());     // Catch: Throwable -> L10
        ArrayList r7 = new ArrayList(getSig());     // Catch: Throwable -> L10
        HSSPrivateKeyParameters r15 = makeCopy(new HSSPrivateKeyParameters(this.l, r6, r7, r8, r8 + r2, true));     // Catch: Throwable -> L10
        resetKeyToIndex();     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return r15;
    L9:
        throw new IllegalArgumentException("usageCount exceeds usages remaining in current leaf");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    @Override // org.bouncycastle.pqc.crypto.lms.LMSKeyParameters, org.bouncycastle.util.Encodable
    public synchronized byte[] getEncoded() {
        monitor-enter(this);
        Composer r0 = Composer.compose().u32str(0).u32str(this.l).u64str(this.index).u64str(this.indexLimit).bool(this.isShard);     // Catch: Throwable -> L14
        Iterator<LMSPrivateKeyParameters> r1 = this.keys.iterator();     // Catch: Throwable -> L14
    L5:
        if (r1.hasNext() == false) goto L7;
        r0.bytes((LMSPrivateKeyParameters) ZeusTransformUtils.preCheckCast(r1.next(), LMSPrivateKeyParameters.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L14
        goto L5
    L7:
        Iterator<LMSSignature> r2 = this.sig.iterator();     // Catch: Throwable -> L14
    L9:
        if (r2.hasNext() == false) goto L11;
        r0.bytes((LMSSignature) ZeusTransformUtils.preCheckCast(r2.next(), LMSSignature.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L14
        goto L9
    L11:
        byte[] r3 = r0.build();     // Catch: Throwable -> L14
        monitor-exit(this);
        return r3;
    L14:
        th = move-exception;
        throw th;
    }

    public synchronized long getIndex() {
        monitor-enter(this);
        long r0 = this.index;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized List<LMSPrivateKeyParameters> getKeys() {
        monitor-enter(this);
        List<LMSPrivateKeyParameters> r0 = this.keys;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public int getL() {
        return this.l;
    }

    public synchronized HSSPublicKeyParameters getPublicKey() {
        monitor-enter(this);
        HSSPublicKeyParameters r0 = new HSSPublicKeyParameters(this.l, getRootKey().getPublicKey());     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    LMSPrivateKeyParameters getRootKey() {
        return (LMSPrivateKeyParameters) ZeusTransformUtils.preCheckCast(this.keys.get(0), LMSPrivateKeyParameters.class, "com.obric.memorydata.plugin");
    }

    synchronized List<LMSSignature> getSig() {
        monitor-enter(this);
        List<LMSSignature> r0 = this.sig;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public long getUsagesRemaining() {
        return this.indexLimit - this.index;
    }

    public int hashCode() {
        int r0 = ((((((this.l * 31) + (this.isShard ? 1 : 0)) * 31) + this.keys.hashCode()) * 31) + this.sig.hashCode()) * 31;
        long r1 = this.indexLimit;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.index;
        return r2 + ((int) (r3 ^ (r3 >>> 32)));
    }

    void resetKeyToIndex() {
        List<LMSPrivateKeyParameters> r1 = getKeys();
        int r2 = r1.size();
        long[] r3 = new long[r2];
        long r4 = getIndex();
        int r6 = r1.size() - 1;
    L4:
        if (r6 < 0) goto L6;
        LMSigParameters r8 = ((LMSPrivateKeyParameters) ZeusTransformUtils.preCheckCast(r1.get(r6), LMSPrivateKeyParameters.class, "com.obric.memorydata.plugin")).getSigParameters();
        r3[r6] = ((long) ((1 << r8.getH()) - 1)) & r4;
        r4 = r4 >>> r8.getH();
        r6 = r6 - 1;
        goto L4
    L6:
        LMSPrivateKeyParameters[] r5 = (LMSPrivateKeyParameters[]) ZeusTransformUtils.preCheckCast(r1.toArray(new LMSPrivateKeyParameters[r1.size()]), LMSPrivateKeyParameters[].class, "com.obric.memorydata.plugin");
        List<LMSSignature> r7 = this.sig;
        LMSSignature[] r9 = (LMSSignature[]) ZeusTransformUtils.preCheckCast(r7.toArray(new LMSSignature[r7.size()]), LMSSignature[].class, "com.obric.memorydata.plugin");
        LMSPrivateKeyParameters r10 = getRootKey();
        if ((r5[0].getIndex() - 1) == r3[0]) goto L9;
        r5[0] = LMS.generateKeys(r10.getSigParameters(), r10.getOtsParameters(), (int) r3[0], r10.getI(), r10.getMasterSecret());
        boolean r11 = true;
    L10:
        int r12 = 1;
    L11:
        if (r12 >= r2) goto L35;
        int r13 = r12 - 1;
        LMSPrivateKeyParameters r14 = r5[r13];
        byte[] r15 = new byte[16];
        byte[] r16 = new byte[32];
        SeedDerive r17 = new SeedDerive(r14.getI(), r14.getMasterSecret(), DigestUtil.getDigest(r14.getOtsParameters().getDigestOID()));
        boolean r18 = r11;
        r17.setQ((int) r3[r13]);
        r17.setJ(-2);
        r17.deriveSeed(r16, true);
        byte[] r19 = new byte[32];
        r17.deriveSeed(r19, false);
        System.arraycopy(r19, 0, r15, 0, 16);
        if (r12 >= (r2 - 1)) goto L17;
        int r110 = r13;
        boolean r111 = r18;
        if (r3[r12] == (r5[r12].getIndex() - 1)) goto L19;
    L20:
        boolean r20 = false;
    L22:
        if (Arrays.areEqual(r15, r5[r12].getI()) == true) goto L24;
    L26:
        boolean r21 = false;
    L27:
        if (r21 == true) goto L30;
        r5[r12] = LMS.generateKeys(((LMSPrivateKeyParameters) ZeusTransformUtils.preCheckCast(r1.get(r12), LMSPrivateKeyParameters.class, "com.obric.memorydata.plugin")).getSigParameters(), ((LMSPrivateKeyParameters) ZeusTransformUtils.preCheckCast(r1.get(r12), LMSPrivateKeyParameters.class, "com.obric.memorydata.plugin")).getOtsParameters(), (int) r3[r12], r15, r16);
        r9[r110] = LMS.generateSign(r5[r110], r5[r12].getPublicKey().toByteArray());
    L29:
        r11 = true;
    L33:
        r12 = r12 + 1;
        goto L11
    L30:
        if (r20 == true) goto L32;
        r5[r12] = LMS.generateKeys(((LMSPrivateKeyParameters) ZeusTransformUtils.preCheckCast(r1.get(r12), LMSPrivateKeyParameters.class, "com.obric.memorydata.plugin")).getSigParameters(), ((LMSPrivateKeyParameters) ZeusTransformUtils.preCheckCast(r1.get(r12), LMSPrivateKeyParameters.class, "com.obric.memorydata.plugin")).getOtsParameters(), (int) r3[r12], r15, r16);
        goto L29
    L32:
        r11 = r111;
        goto L33
    L24:
        if (Arrays.areEqual(r16, r5[r12].getMasterSecret()) == false) goto L26;
        r21 = true;
    L19:
        r20 = true;
        goto L22
    L17:
        r110 = r13;
        r111 = r18;
        if (r3[r12] != r5[r12].getIndex()) goto L20;
    L35:
        if (r11 == false) goto L42;
        updateHierarchy(r5, r9);
        return;
    L42:
        return;
    L9:
        r11 = false;
        goto L10
    }

    public void updateHierarchy(LMSPrivateKeyParameters[] r1, LMSSignature[] r2) {
        monitor-enter(this);
        this.keys = Collections.unmodifiableList(java.util.Arrays.asList(r1));     // Catch: Throwable -> L6
        this.sig = Collections.unmodifiableList(java.util.Arrays.asList(r2));     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
