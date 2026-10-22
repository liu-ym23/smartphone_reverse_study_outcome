package org.bouncycastle.pqc.crypto.xmss;

import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes7.dex */
final class OTSHashAddress extends XMSSAddress {
    private final int chainAddress;
    private final int hashAddress;
    private final int otsAddress;

    /* JADX INFO: renamed from: org.bouncycastle.pqc.crypto.xmss.OTSHashAddress$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    protected static class Builder extends XMSSAddress.Builder<Builder> {
        private int chainAddress;
        private int hashAddress;
        private int otsAddress;

        public Builder() {
            super(0);
            this.otsAddress = 0;
            this.chainAddress = 0;
            this.hashAddress = 0;
        }

        static /* synthetic */ int access$000(Builder r0) {
            return r0.otsAddress;
        }

        static /* synthetic */ int access$100(Builder r0) {
            return r0.chainAddress;
        }

        static /* synthetic */ int access$200(Builder r0) {
            return r0.hashAddress;
        }

        public XMSSAddress build() {
            return new OTSHashAddress(this, null);
        }

        @Override // org.bouncycastle.pqc.crypto.xmss.XMSSAddress.Builder
        public Builder getThis() {
            return this;
        }

        @Override // org.bouncycastle.pqc.crypto.xmss.XMSSAddress.Builder
        public /* bridge */ /* synthetic */ XMSSAddress.Builder getThis() {
            return getThis();
        }

        public Builder withChainAddress(int r1) {
            this.chainAddress = r1;
            return this;
        }

        public Builder withHashAddress(int r1) {
            this.hashAddress = r1;
            return this;
        }

        public Builder withOTSAddress(int r1) {
            this.otsAddress = r1;
            return this;
        }
    }

    private OTSHashAddress(Builder r2) {
        super(r2);
        this.otsAddress = Builder.access$000(r2);
        this.chainAddress = Builder.access$100(r2);
        this.hashAddress = Builder.access$200(r2);
    }

    /* synthetic */ OTSHashAddress(Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    public int getChainAddress() {
        return this.chainAddress;
    }

    public int getHashAddress() {
        return this.hashAddress;
    }

    public int getOTSAddress() {
        return this.otsAddress;
    }

    @Override // org.bouncycastle.pqc.crypto.xmss.XMSSAddress
    public byte[] toByteArray() {
        byte[] r0 = super.toByteArray();
        Pack.intToBigEndian(this.otsAddress, r0, 16);
        Pack.intToBigEndian(this.chainAddress, r0, 20);
        Pack.intToBigEndian(this.hashAddress, r0, 24);
        return r0;
    }
}
