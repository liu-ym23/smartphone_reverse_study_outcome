package org.bouncycastle.pqc.crypto.xmss;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Objects;
import java.util.Stack;

/* JADX INFO: loaded from: classes7.dex */
class BDSTreeHash implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    private boolean finished;
    private int height;
    private final int initialHeight;
    private boolean initialized;
    private int nextIndex;
    private XMSSNode tailNode;

    BDSTreeHash(int r1) {
        this.initialHeight = r1;
        this.initialized = false;
        this.finished = false;
    }

    public /* bridge */ /* synthetic */ Object clone() {
        return m3191clone();
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public BDSTreeHash m3191clone() {
        BDSTreeHash r0 = new BDSTreeHash(this.initialHeight);
        r0.tailNode = this.tailNode;
        r0.height = this.height;
        r0.nextIndex = this.nextIndex;
        r0.initialized = this.initialized;
        r0.finished = this.finished;
        return r0;
    }

    int getHeight() {
        if (this.initialized == true) goto L5;
        return Integer.MAX_VALUE;
    L5:
        if (this.finished == false) goto L8;
        return Integer.MAX_VALUE;
    L8:
        return this.height;
    }

    int getIndexLeaf() {
        return this.nextIndex;
    }

    public XMSSNode getTailNode() {
        return this.tailNode;
    }

    void initialize(int r2) {
        this.tailNode = null;
        this.height = this.initialHeight;
        this.nextIndex = r2;
        this.initialized = true;
        this.finished = false;
    }

    boolean isFinished() {
        return this.finished;
    }

    boolean isInitialized() {
        return this.initialized;
    }

    void setNode(XMSSNode r2) {
        this.tailNode = r2;
        int r3 = r2.getHeight();
        this.height = r3;
        if (r3 != this.initialHeight) goto L6;
        this.finished = true;
        return;
    }

    void update(Stack<XMSSNode> r6, WOTSPlus r7, byte[] r8, byte[] r9, OTSHashAddress r10) {
        Objects.requireNonNull(r10, "otsHashAddress == null");
        if (this.finished == true) goto L27;
        if (this.initialized == false) goto L27;
        OTSHashAddress r11 = (OTSHashAddress) ZeusTransformUtils.preCheckCast(((OTSHashAddress.Builder) ZeusTransformUtils.preCheckCast(((OTSHashAddress.Builder) ZeusTransformUtils.preCheckCast(((OTSHashAddress.Builder) ZeusTransformUtils.preCheckCast(new OTSHashAddress.Builder().withLayerAddress(r10.getLayerAddress()), OTSHashAddress.Builder.class, "com.obric.memorydata.plugin")).withTreeAddress(r10.getTreeAddress()), OTSHashAddress.Builder.class, "com.obric.memorydata.plugin")).withOTSAddress(this.nextIndex).withChainAddress(r10.getChainAddress()).withHashAddress(r10.getHashAddress()).withKeyAndMask(r10.getKeyAndMask()), OTSHashAddress.Builder.class, "com.obric.memorydata.plugin")).build(), OTSHashAddress.class, "com.obric.memorydata.plugin");
        LTreeAddress r0 = (LTreeAddress) ZeusTransformUtils.preCheckCast(((LTreeAddress.Builder) ZeusTransformUtils.preCheckCast(((LTreeAddress.Builder) ZeusTransformUtils.preCheckCast(new LTreeAddress.Builder().withLayerAddress(r11.getLayerAddress()), LTreeAddress.Builder.class, "com.obric.memorydata.plugin")).withTreeAddress(r11.getTreeAddress()), LTreeAddress.Builder.class, "com.obric.memorydata.plugin")).withLTreeAddress(this.nextIndex).build(), LTreeAddress.class, "com.obric.memorydata.plugin");
        HashTreeAddress r1 = (HashTreeAddress) ZeusTransformUtils.preCheckCast(((HashTreeAddress.Builder) ZeusTransformUtils.preCheckCast(((HashTreeAddress.Builder) ZeusTransformUtils.preCheckCast(new HashTreeAddress.Builder().withLayerAddress(r11.getLayerAddress()), HashTreeAddress.Builder.class, "com.obric.memorydata.plugin")).withTreeAddress(r11.getTreeAddress()), HashTreeAddress.Builder.class, "com.obric.memorydata.plugin")).withTreeIndex(this.nextIndex).build(), HashTreeAddress.class, "com.obric.memorydata.plugin");
        r7.importKeys(r7.getWOTSPlusSecretKey(r9, r11), r8);
        XMSSNode r12 = XMSSNodeUtil.lTree(r7, r7.getPublicKey(r11), r0);
    L8:
        if (r6.isEmpty() == true) goto L14;
        if (((XMSSNode) ZeusTransformUtils.preCheckCast(r6.peek(), XMSSNode.class, "com.obric.memorydata.plugin")).getHeight() != r12.getHeight()) goto L14;
        if (((XMSSNode) ZeusTransformUtils.preCheckCast(r6.peek(), XMSSNode.class, "com.obric.memorydata.plugin")).getHeight() == this.initialHeight) goto L14;
        HashTreeAddress r13 = (HashTreeAddress) ZeusTransformUtils.preCheckCast(((HashTreeAddress.Builder) ZeusTransformUtils.preCheckCast(((HashTreeAddress.Builder) ZeusTransformUtils.preCheckCast(((HashTreeAddress.Builder) ZeusTransformUtils.preCheckCast(new HashTreeAddress.Builder().withLayerAddress(r1.getLayerAddress()), HashTreeAddress.Builder.class, "com.obric.memorydata.plugin")).withTreeAddress(r1.getTreeAddress()), HashTreeAddress.Builder.class, "com.obric.memorydata.plugin")).withTreeHeight(r1.getTreeHeight()).withTreeIndex((r1.getTreeIndex() - 1) / 2).withKeyAndMask(r1.getKeyAndMask()), HashTreeAddress.Builder.class, "com.obric.memorydata.plugin")).build(), HashTreeAddress.class, "com.obric.memorydata.plugin");
        XMSSNode r14 = XMSSNodeUtil.randomizeHash(r7, (XMSSNode) ZeusTransformUtils.preCheckCast(r6.pop(), XMSSNode.class, "com.obric.memorydata.plugin"), r12, r13);
        XMSSNode r2 = new XMSSNode(r14.getHeight() + 1, r14.getValue());
        r1 = (HashTreeAddress) ZeusTransformUtils.preCheckCast(((HashTreeAddress.Builder) ZeusTransformUtils.preCheckCast(((HashTreeAddress.Builder) ZeusTransformUtils.preCheckCast(((HashTreeAddress.Builder) ZeusTransformUtils.preCheckCast(new HashTreeAddress.Builder().withLayerAddress(r13.getLayerAddress()), HashTreeAddress.Builder.class, "com.obric.memorydata.plugin")).withTreeAddress(r13.getTreeAddress()), HashTreeAddress.Builder.class, "com.obric.memorydata.plugin")).withTreeHeight(r13.getTreeHeight() + 1).withTreeIndex(r13.getTreeIndex()).withKeyAndMask(r13.getKeyAndMask()), HashTreeAddress.Builder.class, "com.obric.memorydata.plugin")).build(), HashTreeAddress.class, "com.obric.memorydata.plugin");
        r12 = r2;
    L14:
        XMSSNode r15 = this.tailNode;
        if (r15 != null) goto L18;
        this.tailNode = r12;
    L22:
        if (this.tailNode.getHeight() != this.initialHeight) goto L24;
        this.finished = true;
        return;
    L24:
        this.height = r12.getHeight();
        this.nextIndex++;
        return;
    L18:
        if (r15.getHeight() != r12.getHeight()) goto L20;
        HashTreeAddress r16 = (HashTreeAddress) ZeusTransformUtils.preCheckCast(((HashTreeAddress.Builder) ZeusTransformUtils.preCheckCast(((HashTreeAddress.Builder) ZeusTransformUtils.preCheckCast(((HashTreeAddress.Builder) ZeusTransformUtils.preCheckCast(new HashTreeAddress.Builder().withLayerAddress(r1.getLayerAddress()), HashTreeAddress.Builder.class, "com.obric.memorydata.plugin")).withTreeAddress(r1.getTreeAddress()), HashTreeAddress.Builder.class, "com.obric.memorydata.plugin")).withTreeHeight(r1.getTreeHeight()).withTreeIndex((r1.getTreeIndex() - 1) / 2).withKeyAndMask(r1.getKeyAndMask()), HashTreeAddress.Builder.class, "com.obric.memorydata.plugin")).build(), HashTreeAddress.class, "com.obric.memorydata.plugin");
        r12 = new XMSSNode(this.tailNode.getHeight() + 1, XMSSNodeUtil.randomizeHash(r7, this.tailNode, r12, r16).getValue());
        this.tailNode = r12;
        HashTreeAddress r17 = (HashTreeAddress) ZeusTransformUtils.preCheckCast(((HashTreeAddress.Builder) ZeusTransformUtils.preCheckCast(((HashTreeAddress.Builder) ZeusTransformUtils.preCheckCast(((HashTreeAddress.Builder) ZeusTransformUtils.preCheckCast(new HashTreeAddress.Builder().withLayerAddress(r16.getLayerAddress()), HashTreeAddress.Builder.class, "com.obric.memorydata.plugin")).withTreeAddress(r16.getTreeAddress()), HashTreeAddress.Builder.class, "com.obric.memorydata.plugin")).withTreeHeight(r16.getTreeHeight() + 1).withTreeIndex(r16.getTreeIndex()).withKeyAndMask(r16.getKeyAndMask()), HashTreeAddress.Builder.class, "com.obric.memorydata.plugin")).build(), HashTreeAddress.class, "com.obric.memorydata.plugin");
        goto L22
    L20:
        r6.push(r12);
    L27:
        throw new IllegalStateException("finished or not initialized");
    }
}
