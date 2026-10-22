package org.bouncycastle.pqc.crypto.lms;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.crypto.Digest;

/* JADX INFO: loaded from: classes7.dex */
class SeedDerive {
    private final byte[] I;
    private final Digest digest;
    private int j;
    private final byte[] masterSeed;
    private int q;

    public SeedDerive(byte[] r3, byte[] r4, Digest r5) {
        Digest r6 = (Digest) ZeusTransformUtils.wrapperContextForParams(r5, Digest.class, "com.obric.memorydata.plugin");
        this.I = r3;
        this.masterSeed = r4;
        this.digest = r6;
    }

    public void deriveSeed(byte[] r2, boolean r3) {
        deriveSeed(r2, r3, 0);
    }

    public void deriveSeed(byte[] r1, boolean r2, int r3) {
        deriveSeed(r1, r3);
        if (r2 == false) goto L6;
        this.j++;
        return;
    }

    public byte[] deriveSeed(byte[] r5, int r6) {
        if (r5.length < this.digest.getDigestSize()) goto L7;
        Digest r0 = this.digest;
        byte[] r1 = this.I;
        r0.update(r1, 0, r1.length);
        this.digest.update((byte) (this.q >>> 24));
        this.digest.update((byte) (this.q >>> 16));
        this.digest.update((byte) (this.q >>> 8));
        this.digest.update((byte) this.q);
        this.digest.update((byte) (this.j >>> 8));
        this.digest.update((byte) this.j);
        this.digest.update((byte) -1);
        Digest r2 = this.digest;
        byte[] r3 = this.masterSeed;
        r2.update(r3, 0, r3.length);
        this.digest.doFinal(r5, r6);
        return r5;
    L7:
        throw new IllegalArgumentException("target length is less than digest size.");
    }

    public void setJ(int r1) {
        this.j = r1;
    }

    public void setQ(int r1) {
        this.q = r1;
    }
}
