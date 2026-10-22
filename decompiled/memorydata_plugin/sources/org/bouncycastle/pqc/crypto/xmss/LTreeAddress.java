package org.bouncycastle.pqc.crypto.xmss;

import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes7.dex */
final class LTreeAddress extends XMSSAddress {
    private final int lTreeAddress;
    private final int treeHeight;
    private final int treeIndex;

    /* JADX INFO: renamed from: org.bouncycastle.pqc.crypto.xmss.LTreeAddress$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    protected static class Builder extends XMSSAddress.Builder<Builder> {
        private int lTreeAddress;
        private int treeHeight;
        private int treeIndex;

        public Builder() {
            super(1);
            this.lTreeAddress = 0;
            this.treeHeight = 0;
            this.treeIndex = 0;
        }

        static /* synthetic */ int access$000(Builder r0) {
            return r0.lTreeAddress;
        }

        static /* synthetic */ int access$100(Builder r0) {
            return r0.treeHeight;
        }

        static /* synthetic */ int access$200(Builder r0) {
            return r0.treeIndex;
        }

        public XMSSAddress build() {
            return new LTreeAddress(this, null);
        }

        @Override // org.bouncycastle.pqc.crypto.xmss.XMSSAddress.Builder
        public Builder getThis() {
            return this;
        }

        @Override // org.bouncycastle.pqc.crypto.xmss.XMSSAddress.Builder
        public /* bridge */ /* synthetic */ XMSSAddress.Builder getThis() {
            return getThis();
        }

        public Builder withLTreeAddress(int r1) {
            this.lTreeAddress = r1;
            return this;
        }

        public Builder withTreeHeight(int r1) {
            this.treeHeight = r1;
            return this;
        }

        public Builder withTreeIndex(int r1) {
            this.treeIndex = r1;
            return this;
        }
    }

    private LTreeAddress(Builder r2) {
        super(r2);
        this.lTreeAddress = Builder.access$000(r2);
        this.treeHeight = Builder.access$100(r2);
        this.treeIndex = Builder.access$200(r2);
    }

    /* synthetic */ LTreeAddress(Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    public int getLTreeAddress() {
        return this.lTreeAddress;
    }

    public int getTreeHeight() {
        return this.treeHeight;
    }

    public int getTreeIndex() {
        return this.treeIndex;
    }

    @Override // org.bouncycastle.pqc.crypto.xmss.XMSSAddress
    public byte[] toByteArray() {
        byte[] r0 = super.toByteArray();
        Pack.intToBigEndian(this.lTreeAddress, r0, 16);
        Pack.intToBigEndian(this.treeHeight, r0, 20);
        Pack.intToBigEndian(this.treeIndex, r0, 24);
        return r0;
    }
}
