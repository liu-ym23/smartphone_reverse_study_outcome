package org.bouncycastle.crypto;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public class BufferedBlockCipher {
    protected byte[] buf;
    protected int bufOff;
    protected BlockCipher cipher;
    protected MultiBlockCipher mbCipher;
    protected boolean partialBlockOkay;
    protected boolean pgpCFB;

    public BufferedBlockCipher() {
    }

    public BufferedBlockCipher(BlockCipher r6) {
        BlockCipher r7 = (BlockCipher) ZeusTransformUtils.wrapperContextForParams(r6, BlockCipher.class, "com.obric.memorydata.plugin");
        this.cipher = r7;
        if (ZeusTransformUtils.instanceOf(r7, MultiBlockCipher.class) == false) goto L5;
        MultiBlockCipher r0 = (MultiBlockCipher) ZeusTransformUtils.preCheckCast(r7, MultiBlockCipher.class, "com.obric.memorydata.plugin");
        this.mbCipher = r0;
        this.buf = new byte[r0.getMultiBlockSize()];
    L6:
        boolean r1 = false;
        this.bufOff = 0;
        String r2 = r7.getAlgorithmName();
        int r3 = r2.indexOf(47) + 1;
        if (r3 > 0) goto L9;
    L11:
        boolean r4 = false;
    L12:
        this.pgpCFB = r4;
        if (r4 == false) goto L15;
    L22:
        this.partialBlockOkay = true;
        return;
    L15:
        if (ZeusTransformUtils.instanceOf(r7, StreamCipher.class) == true) goto L22;
        if (r3 > 0) goto L19;
    L21:
        this.partialBlockOkay = r1;
        return;
    L19:
        if (r2.startsWith("OpenPGP", r3) == false) goto L21;
        r1 = true;
        goto L21
    L9:
        if (r2.startsWith("PGP", r3) == false) goto L11;
        r4 = true;
        goto L12
    L5:
        this.mbCipher = null;
        this.buf = new byte[r7.getBlockSize()];
        goto L6
    }
}
