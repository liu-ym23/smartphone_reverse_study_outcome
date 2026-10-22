package org.bouncycastle.pqc.crypto.xmss;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.Objects;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Encodable;

/* JADX INFO: loaded from: classes7.dex */
public final class XMSSMTPrivateKeyParameters extends XMSSMTKeyParameters implements Encodable {
    private volatile BDSStateMap bdsState;
    private volatile long index;
    private final XMSSMTParameters params;
    private final byte[] publicSeed;
    private final byte[] root;
    private final byte[] secretKeyPRF;
    private final byte[] secretKeySeed;
    private volatile boolean used;

    /* JADX INFO: renamed from: org.bouncycastle.pqc.crypto.xmss.XMSSMTPrivateKeyParameters$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private BDSStateMap bdsState;
        private long index;
        private long maxIndex;
        private final XMSSMTParameters params;
        private byte[] privateKey;
        private byte[] publicSeed;
        private byte[] root;
        private byte[] secretKeyPRF;
        private byte[] secretKeySeed;
        private XMSSParameters xmss;

        public Builder(XMSSMTParameters r3) {
            this.index = 0;
            this.maxIndex = -1;
            this.secretKeySeed = null;
            this.secretKeyPRF = null;
            this.publicSeed = null;
            this.root = null;
            this.bdsState = null;
            this.privateKey = null;
            this.xmss = null;
            this.params = r3;
        }

        static /* synthetic */ XMSSMTParameters access$000(Builder r0) {
            return r0.params;
        }

        static /* synthetic */ byte[] access$100(Builder r0) {
            return r0.privateKey;
        }

        static /* synthetic */ XMSSParameters access$200(Builder r0) {
            return r0.xmss;
        }

        static /* synthetic */ long access$300(Builder r2) {
            return r2.index;
        }

        static /* synthetic */ byte[] access$400(Builder r0) {
            return r0.secretKeySeed;
        }

        static /* synthetic */ byte[] access$500(Builder r0) {
            return r0.secretKeyPRF;
        }

        static /* synthetic */ byte[] access$600(Builder r0) {
            return r0.publicSeed;
        }

        static /* synthetic */ byte[] access$700(Builder r0) {
            return r0.root;
        }

        static /* synthetic */ BDSStateMap access$800(Builder r0) {
            return r0.bdsState;
        }

        static /* synthetic */ long access$900(Builder r2) {
            return r2.maxIndex;
        }

        public XMSSMTPrivateKeyParameters build() {
            return new XMSSMTPrivateKeyParameters(this, null);
        }

        public Builder withBDSState(BDSStateMap r7) {
            if (r7.getMaxIndex() != 0) goto L5;
            this.bdsState = new BDSStateMap(r7, (1 << this.params.getHeight()) - 1);
        L6:
            return this;
        L5:
            this.bdsState = r7;
            goto L6
        }

        public Builder withIndex(long r1) {
            this.index = r1;
            return this;
        }

        public Builder withMaxIndex(long r1) {
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

    private XMSSMTPrivateKeyParameters(Builder r9) {
        super(true, Builder.access$000(r9).getTreeDigest());
        XMSSMTParameters r3 = Builder.access$000(r9);
        this.params = r3;
        Objects.requireNonNull(r3, "params == null");
        int r0 = r3.getTreeDigestSize();
        byte[] r1 = Builder.access$100(r9);
        if (r1 == null) goto L17;
        Objects.requireNonNull(Builder.access$200(r9), "xmss == null");
        int r2 = r3.getHeight();
        int r4 = (r2 + 7) / 8;
        this.index = XMSSUtil.bytesToXBigEndian(r1, 0, r4);
        if (XMSSUtil.isIndexValid(r2, this.index) == false) goto L16;
        int r5 = r4 + 0;
        this.secretKeySeed = XMSSUtil.extractBytesAtOffset(r1, r5, r0);
        int r6 = r5 + r0;
        this.secretKeyPRF = XMSSUtil.extractBytesAtOffset(r1, r6, r0);
        int r7 = r6 + r0;
        this.publicSeed = XMSSUtil.extractBytesAtOffset(r1, r7, r0);
        int r8 = r7 + r0;
        this.root = XMSSUtil.extractBytesAtOffset(r1, r8, r0);
        int r10 = r8 + r0;
        this.bdsState = ((BDSStateMap) ZeusTransformUtils.preCheckCast(XMSSUtil.deserialize(XMSSUtil.extractBytesAtOffset(r1, r10, r1.length - r10), BDSStateMap.class), BDSStateMap.class, "com.obric.memorydata.plugin")).withWOTSDigest(Builder.access$200(r9).getTreeDigestOID());     // Catch: ClassNotFoundException -> L9 IOException -> L12
    L68:
        return;
    L12:
        e = move-exception;
        throw new IllegalArgumentException(e.getMessage(), e);
    L9:
        e = move-exception;
        throw new IllegalArgumentException(e.getMessage(), e);
    L16:
        throw new IllegalArgumentException("index out of bounds");
    L17:
        this.index = Builder.access$300(r9);
        byte[] r11 = Builder.access$400(r9);
        if (r11 != null) goto L20;
        this.secretKeySeed = new byte[r0];
    L25:
        byte[] r12 = Builder.access$500(r9);
        if (r12 != null) goto L28;
        this.secretKeyPRF = new byte[r0];
    L33:
        byte[] r13 = Builder.access$600(r9);
        if (r13 != null) goto L36;
        this.publicSeed = new byte[r0];
    L41:
        byte[] r14 = Builder.access$700(r9);
        if (r14 != null) goto L44;
        this.root = new byte[r0];
    L49:
        BDSStateMap r15 = Builder.access$800(r9);
        if (r15 == null) goto L52;
    L51:
        this.bdsState = r15;
        if (Builder.access$900(r9) >= 0) goto L61;
        return;
    L61:
        if (Builder.access$900(r9) != this.bdsState.getMaxIndex()) goto L64;
        return;
    L64:
        throw new IllegalArgumentException("maxIndex set but not reflected in state");
    L52:
        long r16 = Builder.access$300(r9);
        if (XMSSUtil.isIndexValid(r3.getHeight(), r16) == false) goto L57;
        if (r13 == null) goto L57;
        if (r11 == null) goto L57;
        r15 = new BDSStateMap(r3, Builder.access$300(r9), r13, r11);
    L57:
        r15 = new BDSStateMap(Builder.access$900(r9) + 1);
        goto L51
    L44:
        if (r14.length != r0) goto L47;
        this.root = r14;
        goto L49
    L47:
        throw new IllegalArgumentException("size of root needs to be equal size of digest");
    L36:
        if (r13.length != r0) goto L39;
        this.publicSeed = r13;
        goto L41
    L39:
        throw new IllegalArgumentException("size of publicSeed needs to be equal size of digest");
    L28:
        if (r12.length != r0) goto L31;
        this.secretKeyPRF = r12;
        goto L33
    L31:
        throw new IllegalArgumentException("size of secretKeyPRF needs to be equal size of digest");
    L20:
        if (r11.length != r0) goto L23;
        this.secretKeySeed = r11;
        goto L25
    L23:
        throw new IllegalArgumentException("size of secretKeySeed needs to be equal size of digest");
    }

    /* synthetic */ XMSSMTPrivateKeyParameters(Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    public XMSSMTPrivateKeyParameters extractKeyShard(int r8) {
        if (r8 < 1) goto L19;
        monitor-enter(this);
        long r0 = r8;
    L15:
        th = move-exception;
        throw th;
    L7:
        if (r0 > getUsagesRemaining()) goto L14;
        XMSSMTPrivateKeyParameters r1 = new Builder(this.params).withSecretKeySeed(this.secretKeySeed).withSecretKeyPRF(this.secretKeyPRF).withPublicSeed(this.publicSeed).withRoot(this.root).withIndex(getIndex()).withBDSState(new BDSStateMap(this.bdsState, (getIndex() + r0) - 1)).build();     // Catch: Throwable -> L15
        int r2 = 0;
    L9:
        if (r2 == r8) goto L11;
        rollKey();     // Catch: Throwable -> L15
        r2 = r2 + 1;     // Catch: Throwable -> L15
        goto L9
    L11:
        monitor-exit(this);     // Catch: Throwable -> L15
        return r1;
    L14:
        throw new IllegalArgumentException("usageCount exceeds usages remaining");     // Catch: Throwable -> L15
    L19:
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

    public long getIndex() {
        return this.index;
    }

    public XMSSMTParameters getParameters() {
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

    XMSSMTPrivateKeyParameters rollKey() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (getIndex() >= this.bdsState.getMaxIndex()) goto L7;
        this.bdsState.updateState(this.params, this.index, this.publicSeed, this.secretKeySeed);     // Catch: Throwable -> L10
        this.index++;     // Catch: Throwable -> L10
    L6:
        this.used = false;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return this;
    L7:
        this.index = this.bdsState.getMaxIndex() + 1;     // Catch: Throwable -> L10
        this.bdsState = new BDSStateMap(this.bdsState.getMaxIndex());     // Catch: Throwable -> L10
        goto L6
    }

    public byte[] toByteArray() {
        monitor-enter(this);
        int r0 = this.params.getTreeDigestSize();     // Catch: Throwable -> L10
        int r1 = (this.params.getHeight() + 7) / 8;     // Catch: Throwable -> L10
        byte[] r2 = new byte[(((r1 + r0) + r0) + r0) + r0];     // Catch: Throwable -> L10
        XMSSUtil.copyBytesAtOffset(r2, XMSSUtil.toBytesBigEndian(this.index, r1), 0);     // Catch: Throwable -> L10
        int r3 = r1 + 0;     // Catch: Throwable -> L10
        XMSSUtil.copyBytesAtOffset(r2, this.secretKeySeed, r3);     // Catch: Throwable -> L10
        int r4 = r3 + r0;     // Catch: Throwable -> L10
        XMSSUtil.copyBytesAtOffset(r2, this.secretKeyPRF, r4);     // Catch: Throwable -> L10
        int r5 = r4 + r0;     // Catch: Throwable -> L10
        XMSSUtil.copyBytesAtOffset(r2, this.publicSeed, r5);     // Catch: Throwable -> L10
        XMSSUtil.copyBytesAtOffset(r2, this.root, r5 + r0);     // Catch: Throwable -> L10
        byte[] r6 = Arrays.concatenate(r2, XMSSUtil.serialize(this.bdsState));     // Catch: IOException -> L7 Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return r6;
    L7:
        e = move-exception;
        throw new IllegalStateException("error serializing bds state: " + e.getMessage(), e);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }
}
