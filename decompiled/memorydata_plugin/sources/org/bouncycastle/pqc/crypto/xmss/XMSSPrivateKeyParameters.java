package org.bouncycastle.pqc.crypto.xmss;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.Objects;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Encodable;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes7.dex */
public final class XMSSPrivateKeyParameters extends XMSSKeyParameters implements Encodable {
    private volatile BDS bdsState;
    private final XMSSParameters params;
    private final byte[] publicSeed;
    private final byte[] root;
    private final byte[] secretKeyPRF;
    private final byte[] secretKeySeed;

    /* JADX INFO: renamed from: org.bouncycastle.pqc.crypto.xmss.XMSSPrivateKeyParameters$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private BDS bdsState;
        private int index;
        private int maxIndex;
        private final XMSSParameters params;
        private byte[] privateKey;
        private byte[] publicSeed;
        private byte[] root;
        private byte[] secretKeyPRF;
        private byte[] secretKeySeed;

        public Builder(XMSSParameters r2) {
            this.index = 0;
            this.maxIndex = -1;
            this.secretKeySeed = null;
            this.secretKeyPRF = null;
            this.publicSeed = null;
            this.root = null;
            this.bdsState = null;
            this.privateKey = null;
            this.params = r2;
        }

        static /* synthetic */ XMSSParameters access$000(Builder r0) {
            return r0.params;
        }

        static /* synthetic */ byte[] access$100(Builder r0) {
            return r0.privateKey;
        }

        static /* synthetic */ byte[] access$200(Builder r0) {
            return r0.secretKeySeed;
        }

        static /* synthetic */ byte[] access$300(Builder r0) {
            return r0.secretKeyPRF;
        }

        static /* synthetic */ byte[] access$400(Builder r0) {
            return r0.publicSeed;
        }

        static /* synthetic */ byte[] access$500(Builder r0) {
            return r0.root;
        }

        static /* synthetic */ BDS access$600(Builder r0) {
            return r0.bdsState;
        }

        static /* synthetic */ int access$700(Builder r0) {
            return r0.index;
        }

        static /* synthetic */ int access$800(Builder r0) {
            return r0.maxIndex;
        }

        public XMSSPrivateKeyParameters build() {
            return new XMSSPrivateKeyParameters(this, null);
        }

        public Builder withBDSState(BDS r1) {
            this.bdsState = r1;
            return this;
        }

        public Builder withIndex(int r1) {
            this.index = r1;
            return this;
        }

        public Builder withMaxIndex(int r1) {
            this.maxIndex = r1;
            return this;
        }

        public Builder withPublicSeed(byte[] r1) {
            this.publicSeed = XMSSUtil.cloneArray(r1);
            return this;
        }

        public Builder withRoot(byte[] r1) {
            this.root = XMSSUtil.cloneArray(r1);
            return this;
        }

        public Builder withSecretKeyPRF(byte[] r1) {
            this.secretKeyPRF = XMSSUtil.cloneArray(r1);
            return this;
        }

        public Builder withSecretKeySeed(byte[] r1) {
            this.secretKeySeed = XMSSUtil.cloneArray(r1);
            return this;
        }
    }

    private XMSSPrivateKeyParameters(Builder r9) {
        super(true, Builder.access$000(r9).getTreeDigest());
        XMSSParameters r3 = Builder.access$000(r9);
        this.params = r3;
        Objects.requireNonNull(r3, "params == null");
        int r0 = r3.getTreeDigestSize();
        byte[] r2 = Builder.access$100(r9);
        if (r2 == null) goto L20;
        int r1 = r3.getHeight();
        int r4 = Pack.bigEndianToInt(r2, 0);
        if (XMSSUtil.isIndexValid(r1, r4) == false) goto L19;
        this.secretKeySeed = XMSSUtil.extractBytesAtOffset(r2, 4, r0);
        int r5 = 4 + r0;
        this.secretKeyPRF = XMSSUtil.extractBytesAtOffset(r2, r5, r0);
        int r6 = r5 + r0;
        this.publicSeed = XMSSUtil.extractBytesAtOffset(r2, r6, r0);
        int r7 = r6 + r0;
        this.root = XMSSUtil.extractBytesAtOffset(r2, r7, r0);
        int r8 = r7 + r0;
        BDS r10 = (BDS) ZeusTransformUtils.preCheckCast(XMSSUtil.deserialize(XMSSUtil.extractBytesAtOffset(r2, r8, r2.length - r8), BDS.class), BDS.class, "com.obric.memorydata.plugin");     // Catch: ClassNotFoundException -> L12 IOException -> L15
        if (r10.getIndex() != r4) goto L11;
        this.bdsState = r10.withWOTSDigest(Builder.access$000(r9).getTreeDigestOID());     // Catch: ClassNotFoundException -> L12 IOException -> L15
        return;
    L11:
        throw new IllegalStateException("serialized BDS has wrong index");     // Catch: ClassNotFoundException -> L12 IOException -> L15
    L15:
        e = move-exception;
        throw new IllegalArgumentException(e.getMessage(), e);
    L12:
        e = move-exception;
        throw new IllegalArgumentException(e.getMessage(), e);
    L19:
        throw new IllegalArgumentException("index out of bounds");
    L20:
        byte[] r11 = Builder.access$200(r9);
        if (r11 != null) goto L23;
        this.secretKeySeed = new byte[r0];
    L28:
        byte[] r12 = Builder.access$300(r9);
        if (r12 != null) goto L31;
        this.secretKeyPRF = new byte[r0];
    L36:
        byte[] r13 = Builder.access$400(r9);
        if (r13 != null) goto L39;
        this.publicSeed = new byte[r0];
    L44:
        byte[] r14 = Builder.access$500(r9);
        if (r14 != null) goto L47;
        this.root = new byte[r0];
    L52:
        BDS r15 = Builder.access$600(r9);
        if (r15 == null) goto L56;
    L54:
        this.bdsState = r15;
        if (Builder.access$800(r9) >= 0) goto L64;
        return;
    L64:
        if (Builder.access$800(r9) != this.bdsState.getMaxIndex()) goto L67;
        return;
    L67:
        throw new IllegalArgumentException("maxIndex set but not reflected in state");
    L56:
        if (Builder.access$700(r9) >= ((1 << r3.getHeight()) - 2)) goto L60;
        if (r13 == null) goto L60;
        if (r11 == null) goto L60;
        r15 = new BDS(r3, r13, r11, (OTSHashAddress) ZeusTransformUtils.preCheckCast(new OTSHashAddress.Builder().build(), OTSHashAddress.class, "com.obric.memorydata.plugin"), Builder.access$700(r9));
    L60:
        r15 = new BDS(r3, (1 << r3.getHeight()) - 1, Builder.access$700(r9));
        goto L54
    L47:
        if (r14.length != r0) goto L50;
        this.root = r14;
        goto L52
    L50:
        throw new IllegalArgumentException("size of root needs to be equal size of digest");
    L39:
        if (r13.length != r0) goto L42;
        this.publicSeed = r13;
        goto L44
    L42:
        throw new IllegalArgumentException("size of publicSeed needs to be equal size of digest");
    L31:
        if (r12.length != r0) goto L34;
        this.secretKeyPRF = r12;
        goto L36
    L34:
        throw new IllegalArgumentException("size of secretKeyPRF needs to be equal size of digest");
    L23:
        if (r11.length != r0) goto L26;
        this.secretKeySeed = r11;
        goto L28
    L26:
        throw new IllegalArgumentException("size of secretKeySeed needs to be equal size of digest");
    }

    /* synthetic */ XMSSPrivateKeyParameters(Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    public XMSSPrivateKeyParameters extractKeyShard(int r7) {
        if (r7 < 1) goto L22;
        monitor-enter(this);
        long r1 = r7;
    L18:
        th = move-exception;
        throw th;
    L7:
        if (r1 > getUsagesRemaining()) goto L17;
        XMSSPrivateKeyParameters r0 = new Builder(this.params).withSecretKeySeed(this.secretKeySeed).withSecretKeyPRF(this.secretKeyPRF).withPublicSeed(this.publicSeed).withRoot(this.root).withIndex(getIndex()).withBDSState(this.bdsState.withMaxIndex((this.bdsState.getIndex() + r7) - 1, this.params.getTreeDigestOID())).build();     // Catch: Throwable -> L18
        if (r1 != getUsagesRemaining()) goto L11;
        this.bdsState = new BDS(this.params, this.bdsState.getMaxIndex(), getIndex() + r7);     // Catch: Throwable -> L18
    L14:
        monitor-exit(this);     // Catch: Throwable -> L18
        return r0;
    L11:
        OTSHashAddress r2 = (OTSHashAddress) ZeusTransformUtils.preCheckCast(new OTSHashAddress.Builder().build(), OTSHashAddress.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        int r3 = 0;
    L12:
        if (r3 == r7) goto L14;
        this.bdsState = this.bdsState.getNextState(this.publicSeed, this.secretKeySeed, r2);     // Catch: Throwable -> L18
        r3 = r3 + 1;     // Catch: Throwable -> L18
        goto L12
    L17:
        throw new IllegalArgumentException("usageCount exceeds usages remaining");     // Catch: Throwable -> L18
    L22:
        throw new IllegalArgumentException("cannot ask for a shard with 0 keys");
    }

    @Override // org.bouncycastle.util.Encodable
    public byte[] getEncoded() {
        monitor-enter(this);
        byte[] r0 = toByteArray();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public int getIndex() {
        return this.bdsState.getIndex();
    }

    public XMSSParameters getParameters() {
        return this.params;
    }

    public long getUsagesRemaining() {
        monitor-enter(this);
        long r0 = (this.bdsState.getMaxIndex() - getIndex()) + 1;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public byte[] toByteArray() {
        monitor-enter(this);
        int r0 = this.params.getTreeDigestSize();     // Catch: Throwable -> L11
        byte[] r1 = new byte[(((r0 + 4) + r0) + r0) + r0];     // Catch: Throwable -> L11
        Pack.intToBigEndian(this.bdsState.getIndex(), r1, 0);     // Catch: Throwable -> L11
        XMSSUtil.copyBytesAtOffset(r1, this.secretKeySeed, 4);     // Catch: Throwable -> L11
        int r3 = 4 + r0;     // Catch: Throwable -> L11
        XMSSUtil.copyBytesAtOffset(r1, this.secretKeyPRF, r3);     // Catch: Throwable -> L11
        int r4 = r3 + r0;     // Catch: Throwable -> L11
        XMSSUtil.copyBytesAtOffset(r1, this.publicSeed, r4);     // Catch: Throwable -> L11
        XMSSUtil.copyBytesAtOffset(r1, this.root, r4 + r0);     // Catch: Throwable -> L11
        byte[] r2 = Arrays.concatenate(r1, XMSSUtil.serialize(this.bdsState));     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        return r2;
    L8:
        e = move-exception;
        throw new RuntimeException("error serializing bds state: " + e.getMessage());     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }
}
