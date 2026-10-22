package org.bouncycastle.pqc.crypto.xmss;

import java.util.Objects;
import org.bouncycastle.util.Encodable;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes7.dex */
public final class XMSSMTPublicKeyParameters extends XMSSMTKeyParameters implements Encodable {
    private final int oid;
    private final XMSSMTParameters params;
    private final byte[] publicSeed;
    private final byte[] root;

    /* JADX INFO: renamed from: org.bouncycastle.pqc.crypto.xmss.XMSSMTPublicKeyParameters$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private final XMSSMTParameters params;
        private byte[] publicKey;
        private byte[] publicSeed;
        private byte[] root;

        public Builder(XMSSMTParameters r2) {
            this.root = null;
            this.publicSeed = null;
            this.publicKey = null;
            this.params = r2;
        }

        static /* synthetic */ XMSSMTParameters access$000(Builder r0) {
            return r0.params;
        }

        static /* synthetic */ byte[] access$100(Builder r0) {
            return r0.publicKey;
        }

        static /* synthetic */ byte[] access$200(Builder r0) {
            return r0.root;
        }

        static /* synthetic */ byte[] access$300(Builder r0) {
            return r0.publicSeed;
        }

        public XMSSMTPublicKeyParameters build() {
            return new XMSSMTPublicKeyParameters(this, null);
        }

        public Builder withPublicKey(byte[] r1) {
            this.publicKey = XMSSUtil.cloneArray(r1);
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
    }

    private XMSSMTPublicKeyParameters(Builder r5) {
        super(false, Builder.access$000(r5).getTreeDigest());
        XMSSMTParameters r0 = Builder.access$000(r5);
        this.params = r0;
        Objects.requireNonNull(r0, "params == null");
        int r2 = r0.getTreeDigestSize();
        byte[] r3 = Builder.access$100(r5);
        if (r3 == null) goto L13;
        if (r3.length != (r2 + r2)) goto L8;
        this.oid = 0;
        this.root = XMSSUtil.extractBytesAtOffset(r3, 0, r2);
        this.publicSeed = XMSSUtil.extractBytesAtOffset(r3, r2 + 0, r2);
        return;
    L8:
        if (r3.length != ((r2 + 4) + r2)) goto L11;
        this.oid = Pack.bigEndianToInt(r3, 0);
        this.root = XMSSUtil.extractBytesAtOffset(r3, 4, r2);
        this.publicSeed = XMSSUtil.extractBytesAtOffset(r3, 4 + r2, r2);
        return;
    L11:
        throw new IllegalArgumentException("public key has wrong size");
    L13:
        if (r0.getOid() == null) goto L15;
        this.oid = r0.getOid().getOid();
    L16:
        byte[] r1 = Builder.access$200(r5);
        if (r1 != null) goto L19;
        this.root = new byte[r2];
    L24:
        byte[] r6 = Builder.access$300(r5);
        if (r6 != null) goto L27;
        this.publicSeed = new byte[r2];
        return;
    L27:
        if (r6.length != r2) goto L30;
        this.publicSeed = r6;
        return;
    L30:
        throw new IllegalArgumentException("length of publicSeed must be equal to length of digest");
    L19:
        if (r1.length != r2) goto L22;
        this.root = r1;
        goto L24
    L22:
        throw new IllegalArgumentException("length of root must be equal to length of digest");
    L15:
        this.oid = 0;
        goto L16
    }

    /* synthetic */ XMSSMTPublicKeyParameters(Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    @Override // org.bouncycastle.util.Encodable
    public byte[] getEncoded() {
        return toByteArray();
    }

    public XMSSMTParameters getParameters() {
        return this.params;
    }

    public byte[] getPublicSeed() {
        return XMSSUtil.cloneArray(this.publicSeed);
    }

    public byte[] getRoot() {
        return XMSSUtil.cloneArray(this.root);
    }

    public byte[] toByteArray() {
        int r0 = this.params.getTreeDigestSize();
        int r1 = this.oid;
        int r2 = 0;
        if (r1 == 0) goto L5;
        byte[] r3 = new byte[(r0 + 4) + r0];
        Pack.intToBigEndian(r1, r3, 0);
        r2 = 4;
    L6:
        XMSSUtil.copyBytesAtOffset(r3, this.root, r2);
        byte[] r4 = this.publicSeed;
        XMSSUtil.copyBytesAtOffset(r3, r4, r2 + r0);
        return r3;
    L5:
        r3 = new byte[r0 + r0];
        goto L6
    }
}
