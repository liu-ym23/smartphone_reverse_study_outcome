package org.bouncycastle.pqc.crypto.xmss;

import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes7.dex */
public abstract class XMSSAddress {
    private final int keyAndMask;
    private final int layerAddress;
    private final long treeAddress;
    private final int type;

    protected static abstract class Builder<T extends Builder> {
        private int keyAndMask;
        private int layerAddress;
        private long treeAddress;
        private final int type;

        public Builder(int r4) {
            this.layerAddress = 0;
            this.treeAddress = 0;
            this.keyAndMask = 0;
            this.type = r4;
        }

        static /* synthetic */ int access$000(Builder r0) {
            return r0.layerAddress;
        }

        static /* synthetic */ long access$100(Builder r2) {
            return r2.treeAddress;
        }

        static /* synthetic */ int access$200(Builder r0) {
            return r0.type;
        }

        static /* synthetic */ int access$300(Builder r0) {
            return r0.keyAndMask;
        }

        public abstract T getThis();

        public T withKeyAndMask(int r1) {
            this.keyAndMask = r1;
            return (T) getThis();
        }

        public T withLayerAddress(int r1) {
            this.layerAddress = r1;
            return (T) getThis();
        }

        public T withTreeAddress(long r1) {
            this.treeAddress = r1;
            return (T) getThis();
        }
    }

    public XMSSAddress(Builder r3) {
        this.layerAddress = Builder.access$000(r3);
        this.treeAddress = Builder.access$100(r3);
        this.type = Builder.access$200(r3);
        this.keyAndMask = Builder.access$300(r3);
    }

    public final int getKeyAndMask() {
        return this.keyAndMask;
    }

    public final int getLayerAddress() {
        return this.layerAddress;
    }

    public final long getTreeAddress() {
        return this.treeAddress;
    }

    public final int getType() {
        return this.type;
    }

    public byte[] toByteArray() {
        byte[] r0 = new byte[32];
        Pack.intToBigEndian(this.layerAddress, r0, 0);
        Pack.longToBigEndian(this.treeAddress, r0, 4);
        Pack.intToBigEndian(this.type, r0, 12);
        Pack.intToBigEndian(this.keyAndMask, r0, 28);
        return r0;
    }
}
