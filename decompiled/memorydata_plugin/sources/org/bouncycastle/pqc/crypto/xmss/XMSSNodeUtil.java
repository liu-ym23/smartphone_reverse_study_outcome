package org.bouncycastle.pqc.crypto.xmss;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
class XMSSNodeUtil {
    static XMSSNode lTree(WOTSPlus r9, WOTSPlusPublicKeyParameters r10, LTreeAddress r11) {
        Objects.requireNonNull(r10, "publicKey == null");
        Objects.requireNonNull(r11, "address == null");
        int r0 = r9.getParams().getLen();
        byte[][] r12 = r10.toByteArray();
        XMSSNode[] r1 = new XMSSNode[r12.length];
        int r3 = 0;
    L4:
        if (r3 >= r12.length) goto L6;
        r1[r3] = new XMSSNode(0, r12[r3]);
        r3 = r3 + 1;
        goto L4
    L6:
        LTreeAddress.Builder r13 = ((LTreeAddress.Builder) ZeusTransformUtils.preCheckCast(((LTreeAddress.Builder) ZeusTransformUtils.preCheckCast(new LTreeAddress.Builder().withLayerAddress(r11.getLayerAddress()), LTreeAddress.Builder.class, "com.obric.memorydata.plugin")).withTreeAddress(r11.getTreeAddress()), LTreeAddress.Builder.class, "com.obric.memorydata.plugin")).withLTreeAddress(r11.getLTreeAddress()).withTreeHeight(0).withTreeIndex(r11.getTreeIndex()).withKeyAndMask(r11.getKeyAndMask());
    L7:
        LTreeAddress r14 = (LTreeAddress) ZeusTransformUtils.preCheckCast(((LTreeAddress.Builder) ZeusTransformUtils.preCheckCast(r13, LTreeAddress.Builder.class, "com.obric.memorydata.plugin")).build(), LTreeAddress.class, "com.obric.memorydata.plugin");
        if (r0 <= 1) goto L18;
        int r4 = 0;
    L10:
        double r5 = r0 / 2;
        if (r4 >= ((int) Math.floor(r5))) goto L14;
        r14 = (LTreeAddress) ZeusTransformUtils.preCheckCast(((LTreeAddress.Builder) ZeusTransformUtils.preCheckCast(((LTreeAddress.Builder) ZeusTransformUtils.preCheckCast(((LTreeAddress.Builder) ZeusTransformUtils.preCheckCast(new LTreeAddress.Builder().withLayerAddress(r14.getLayerAddress()), LTreeAddress.Builder.class, "com.obric.memorydata.plugin")).withTreeAddress(r14.getTreeAddress()), LTreeAddress.Builder.class, "com.obric.memorydata.plugin")).withLTreeAddress(r14.getLTreeAddress()).withTreeHeight(r14.getTreeHeight()).withTreeIndex(r4).withKeyAndMask(r14.getKeyAndMask()), LTreeAddress.Builder.class, "com.obric.memorydata.plugin")).build(), LTreeAddress.class, "com.obric.memorydata.plugin");
        int r6 = r4 * 2;
        r1[r4] = randomizeHash(r9, r1[r6], r1[r6 + 1], r14);
        r4 = r4 + 1;
        goto L10
    L14:
        if ((r0 % 2) != 1) goto L16;
        r1[(int) Math.floor(r5)] = r1[r0 - 1];
    L16:
        r0 = (int) Math.ceil(((double) r0) / 2.0d);
        r13 = ((LTreeAddress.Builder) ZeusTransformUtils.preCheckCast(((LTreeAddress.Builder) ZeusTransformUtils.preCheckCast(new LTreeAddress.Builder().withLayerAddress(r14.getLayerAddress()), LTreeAddress.Builder.class, "com.obric.memorydata.plugin")).withTreeAddress(r14.getTreeAddress()), LTreeAddress.Builder.class, "com.obric.memorydata.plugin")).withLTreeAddress(r14.getLTreeAddress()).withTreeHeight(r14.getTreeHeight() + 1).withTreeIndex(r14.getTreeIndex()).withKeyAndMask(r14.getKeyAndMask());
        goto L7
    L18:
        return r1[0];
    }

    static XMSSNode randomizeHash(WOTSPlus r9, XMSSNode r10, XMSSNode r11, XMSSAddress r12) {
        Objects.requireNonNull(r10, "left == null");
        Objects.requireNonNull(r11, "right == null");
        if (r10.getHeight() != r11.getHeight()) goto L30;
        Objects.requireNonNull(r12, "address == null");
        byte[] r0 = r9.getPublicSeed();
        int r2 = 0;
        if (ZeusTransformUtils.instanceOf(r12, LTreeAddress.class) == false) goto L8;
        LTreeAddress r13 = (LTreeAddress) ZeusTransformUtils.preCheckCast(r12, LTreeAddress.class, "com.obric.memorydata.plugin");
        r12 = (LTreeAddress) ZeusTransformUtils.preCheckCast(((LTreeAddress.Builder) ZeusTransformUtils.preCheckCast(((LTreeAddress.Builder) ZeusTransformUtils.preCheckCast(((LTreeAddress.Builder) ZeusTransformUtils.preCheckCast(new LTreeAddress.Builder().withLayerAddress(r13.getLayerAddress()), LTreeAddress.Builder.class, "com.obric.memorydata.plugin")).withTreeAddress(r13.getTreeAddress()), LTreeAddress.Builder.class, "com.obric.memorydata.plugin")).withLTreeAddress(r13.getLTreeAddress()).withTreeHeight(r13.getTreeHeight()).withTreeIndex(r13.getTreeIndex()).withKeyAndMask(0), LTreeAddress.Builder.class, "com.obric.memorydata.plugin")).build(), LTreeAddress.class, "com.obric.memorydata.plugin");
    L10:
        byte[] r1 = r9.getKhf().PRF(r0, r12.toByteArray());
        if (ZeusTransformUtils.instanceOf(r12, LTreeAddress.class) == false) goto L14;
        LTreeAddress r14 = (LTreeAddress) ZeusTransformUtils.preCheckCast(r12, LTreeAddress.class, "com.obric.memorydata.plugin");
        r12 = (LTreeAddress) ZeusTransformUtils.preCheckCast(((LTreeAddress.Builder) ZeusTransformUtils.preCheckCast(((LTreeAddress.Builder) ZeusTransformUtils.preCheckCast(((LTreeAddress.Builder) ZeusTransformUtils.preCheckCast(new LTreeAddress.Builder().withLayerAddress(r14.getLayerAddress()), LTreeAddress.Builder.class, "com.obric.memorydata.plugin")).withTreeAddress(r14.getTreeAddress()), LTreeAddress.Builder.class, "com.obric.memorydata.plugin")).withLTreeAddress(r14.getLTreeAddress()).withTreeHeight(r14.getTreeHeight()).withTreeIndex(r14.getTreeIndex()).withKeyAndMask(1), LTreeAddress.Builder.class, "com.obric.memorydata.plugin")).build(), LTreeAddress.class, "com.obric.memorydata.plugin");
    L16:
        byte[] r4 = r9.getKhf().PRF(r0, r12.toByteArray());
        if (ZeusTransformUtils.instanceOf(r12, LTreeAddress.class) == false) goto L20;
        LTreeAddress r15 = (LTreeAddress) ZeusTransformUtils.preCheckCast(r12, LTreeAddress.class, "com.obric.memorydata.plugin");
        r12 = (LTreeAddress) ZeusTransformUtils.preCheckCast(((LTreeAddress.Builder) ZeusTransformUtils.preCheckCast(((LTreeAddress.Builder) ZeusTransformUtils.preCheckCast(((LTreeAddress.Builder) ZeusTransformUtils.preCheckCast(new LTreeAddress.Builder().withLayerAddress(r15.getLayerAddress()), LTreeAddress.Builder.class, "com.obric.memorydata.plugin")).withTreeAddress(r15.getTreeAddress()), LTreeAddress.Builder.class, "com.obric.memorydata.plugin")).withLTreeAddress(r15.getLTreeAddress()).withTreeHeight(r15.getTreeHeight()).withTreeIndex(r15.getTreeIndex()).withKeyAndMask(2), LTreeAddress.Builder.class, "com.obric.memorydata.plugin")).build(), LTreeAddress.class, "com.obric.memorydata.plugin");
    L22:
        byte[] r16 = r9.getKhf().PRF(r0, r12.toByteArray());
        int r3 = r9.getParams().getTreeDigestSize();
        byte[] r5 = new byte[r3 * 2];
        int r6 = 0;
    L23:
        if (r6 >= r3) goto L25;
        r5[r6] = (byte) (r10.getValue()[r6] ^ r4[r6]);
        r6 = r6 + 1;
    L25:
        if (r2 >= r3) goto L28;
        r5[r2 + r3] = (byte) (r11.getValue()[r2] ^ r16[r2]);
        r2 = r2 + 1;
        goto L25
    L28:
        return new XMSSNode(r10.getHeight(), r9.getKhf().H(r1, r5));
    L20:
        if (ZeusTransformUtils.instanceOf(r12, HashTreeAddress.class) == false) goto L22;
        HashTreeAddress r17 = (HashTreeAddress) ZeusTransformUtils.preCheckCast(r12, HashTreeAddress.class, "com.obric.memorydata.plugin");
        r12 = (HashTreeAddress) ZeusTransformUtils.preCheckCast(((HashTreeAddress.Builder) ZeusTransformUtils.preCheckCast(((HashTreeAddress.Builder) ZeusTransformUtils.preCheckCast(((HashTreeAddress.Builder) ZeusTransformUtils.preCheckCast(new HashTreeAddress.Builder().withLayerAddress(r17.getLayerAddress()), HashTreeAddress.Builder.class, "com.obric.memorydata.plugin")).withTreeAddress(r17.getTreeAddress()), HashTreeAddress.Builder.class, "com.obric.memorydata.plugin")).withTreeHeight(r17.getTreeHeight()).withTreeIndex(r17.getTreeIndex()).withKeyAndMask(2), HashTreeAddress.Builder.class, "com.obric.memorydata.plugin")).build(), HashTreeAddress.class, "com.obric.memorydata.plugin");
        goto L22
    L14:
        if (ZeusTransformUtils.instanceOf(r12, HashTreeAddress.class) == false) goto L16;
        HashTreeAddress r18 = (HashTreeAddress) ZeusTransformUtils.preCheckCast(r12, HashTreeAddress.class, "com.obric.memorydata.plugin");
        r12 = (HashTreeAddress) ZeusTransformUtils.preCheckCast(((HashTreeAddress.Builder) ZeusTransformUtils.preCheckCast(((HashTreeAddress.Builder) ZeusTransformUtils.preCheckCast(((HashTreeAddress.Builder) ZeusTransformUtils.preCheckCast(new HashTreeAddress.Builder().withLayerAddress(r18.getLayerAddress()), HashTreeAddress.Builder.class, "com.obric.memorydata.plugin")).withTreeAddress(r18.getTreeAddress()), HashTreeAddress.Builder.class, "com.obric.memorydata.plugin")).withTreeHeight(r18.getTreeHeight()).withTreeIndex(r18.getTreeIndex()).withKeyAndMask(1), HashTreeAddress.Builder.class, "com.obric.memorydata.plugin")).build(), HashTreeAddress.class, "com.obric.memorydata.plugin");
        goto L16
    L8:
        if (ZeusTransformUtils.instanceOf(r12, HashTreeAddress.class) == false) goto L10;
        HashTreeAddress r19 = (HashTreeAddress) ZeusTransformUtils.preCheckCast(r12, HashTreeAddress.class, "com.obric.memorydata.plugin");
        r12 = (HashTreeAddress) ZeusTransformUtils.preCheckCast(((HashTreeAddress.Builder) ZeusTransformUtils.preCheckCast(((HashTreeAddress.Builder) ZeusTransformUtils.preCheckCast(((HashTreeAddress.Builder) ZeusTransformUtils.preCheckCast(new HashTreeAddress.Builder().withLayerAddress(r19.getLayerAddress()), HashTreeAddress.Builder.class, "com.obric.memorydata.plugin")).withTreeAddress(r19.getTreeAddress()), HashTreeAddress.Builder.class, "com.obric.memorydata.plugin")).withTreeHeight(r19.getTreeHeight()).withTreeIndex(r19.getTreeIndex()).withKeyAndMask(0), HashTreeAddress.Builder.class, "com.obric.memorydata.plugin")).build(), HashTreeAddress.class, "com.obric.memorydata.plugin");
        goto L10
    L30:
        throw new IllegalStateException("height of both nodes must be equal");
    }
}
