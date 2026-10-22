package org.bouncycastle.pqc.crypto.xmss;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;
import java.util.TreeMap;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;

/* JADX INFO: loaded from: classes7.dex */
public final class BDS implements Serializable {
    private static final long serialVersionUID = 1;
    private List<XMSSNode> authenticationPath;
    private int index;
    private int k;
    private Map<Integer, XMSSNode> keep;
    private transient int maxIndex;
    private Map<Integer, LinkedList<XMSSNode>> retain;
    private XMSSNode root;
    private Stack<XMSSNode> stack;
    private final List<BDSTreeHash> treeHashInstances;
    private final int treeHeight;
    private boolean used;
    private transient WOTSPlus wotsPlus;

    BDS(BDS r7) {
        this.wotsPlus = new WOTSPlus(r7.wotsPlus.getParams());
        this.treeHeight = r7.treeHeight;
        this.k = r7.k;
        this.root = r7.root;
        ArrayList r0 = new ArrayList();
        this.authenticationPath = r0;
        r0.addAll(r7.authenticationPath);
        this.retain = new TreeMap();
        Iterator<Integer> r1 = r7.retain.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Integer r2 = (Integer) ZeusTransformUtils.preCheckCast(r1.next(), Integer.class, "com.obric.memorydata.plugin");
        this.retain.put(r2, (LinkedList) ZeusTransformUtils.preCheckCast(((LinkedList) ZeusTransformUtils.preCheckCast(r7.retain.get(r2), LinkedList.class, "com.obric.memorydata.plugin")).clone(), LinkedList.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        Stack<XMSSNode> r3 = new Stack();
        this.stack = r3;
        r3.addAll(r7.stack);
        this.treeHashInstances = new ArrayList();
        Iterator<BDSTreeHash> r4 = r7.treeHashInstances.iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        this.treeHashInstances.add(((BDSTreeHash) ZeusTransformUtils.preCheckCast(r4.next(), BDSTreeHash.class, "com.obric.memorydata.plugin")).m3191clone());
        goto L8
    L10:
        this.keep = new TreeMap(r7.keep);
        this.index = r7.index;
        this.maxIndex = r7.maxIndex;
        this.used = r7.used;
    }

    private BDS(BDS r6, int r7, ASN1ObjectIdentifier r8) {
        this.wotsPlus = new WOTSPlus(new WOTSPlusParameters(r8));
        this.treeHeight = r6.treeHeight;
        this.k = r6.k;
        this.root = r6.root;
        ArrayList r9 = new ArrayList();
        this.authenticationPath = r9;
        r9.addAll(r6.authenticationPath);
        this.retain = new TreeMap();
        Iterator<Integer> r10 = r6.retain.keySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        Integer r0 = (Integer) ZeusTransformUtils.preCheckCast(r10.next(), Integer.class, "com.obric.memorydata.plugin");
        this.retain.put(r0, (LinkedList) ZeusTransformUtils.preCheckCast(((LinkedList) ZeusTransformUtils.preCheckCast(r6.retain.get(r0), LinkedList.class, "com.obric.memorydata.plugin")).clone(), LinkedList.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        Stack<XMSSNode> r11 = new Stack();
        this.stack = r11;
        r11.addAll(r6.stack);
        this.treeHashInstances = new ArrayList();
        Iterator<BDSTreeHash> r12 = r6.treeHashInstances.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        this.treeHashInstances.add(((BDSTreeHash) ZeusTransformUtils.preCheckCast(r12.next(), BDSTreeHash.class, "com.obric.memorydata.plugin")).m3191clone());
        goto L8
    L10:
        this.keep = new TreeMap(r6.keep);
        this.index = r6.index;
        this.maxIndex = r7;
        this.used = r6.used;
        validate();
    }

    private BDS(BDS r6, ASN1ObjectIdentifier r7) {
        this.wotsPlus = new WOTSPlus(new WOTSPlusParameters(r7));
        this.treeHeight = r6.treeHeight;
        this.k = r6.k;
        this.root = r6.root;
        ArrayList r8 = new ArrayList();
        this.authenticationPath = r8;
        r8.addAll(r6.authenticationPath);
        this.retain = new TreeMap();
        Iterator<Integer> r9 = r6.retain.keySet().iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        Integer r0 = (Integer) ZeusTransformUtils.preCheckCast(r9.next(), Integer.class, "com.obric.memorydata.plugin");
        this.retain.put(r0, (LinkedList) ZeusTransformUtils.preCheckCast(((LinkedList) ZeusTransformUtils.preCheckCast(r6.retain.get(r0), LinkedList.class, "com.obric.memorydata.plugin")).clone(), LinkedList.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        Stack<XMSSNode> r10 = new Stack();
        this.stack = r10;
        r10.addAll(r6.stack);
        this.treeHashInstances = new ArrayList();
        Iterator<BDSTreeHash> r11 = r6.treeHashInstances.iterator();
    L8:
        if (r11.hasNext() == false) goto L10;
        this.treeHashInstances.add(((BDSTreeHash) ZeusTransformUtils.preCheckCast(r11.next(), BDSTreeHash.class, "com.obric.memorydata.plugin")).m3191clone());
        goto L8
    L10:
        this.keep = new TreeMap(r6.keep);
        this.index = r6.index;
        this.maxIndex = r6.maxIndex;
        this.used = r6.used;
        validate();
    }

    private BDS(BDS r7, byte[] r8, byte[] r9, OTSHashAddress r10) {
        this.wotsPlus = new WOTSPlus(r7.wotsPlus.getParams());
        this.treeHeight = r7.treeHeight;
        this.k = r7.k;
        this.root = r7.root;
        ArrayList r0 = new ArrayList();
        this.authenticationPath = r0;
        r0.addAll(r7.authenticationPath);
        this.retain = new TreeMap();
        Iterator<Integer> r1 = r7.retain.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Integer r2 = (Integer) ZeusTransformUtils.preCheckCast(r1.next(), Integer.class, "com.obric.memorydata.plugin");
        this.retain.put(r2, (LinkedList) ZeusTransformUtils.preCheckCast(((LinkedList) ZeusTransformUtils.preCheckCast(r7.retain.get(r2), LinkedList.class, "com.obric.memorydata.plugin")).clone(), LinkedList.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        Stack<XMSSNode> r3 = new Stack();
        this.stack = r3;
        r3.addAll(r7.stack);
        this.treeHashInstances = new ArrayList();
        Iterator<BDSTreeHash> r4 = r7.treeHashInstances.iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        this.treeHashInstances.add(((BDSTreeHash) ZeusTransformUtils.preCheckCast(r4.next(), BDSTreeHash.class, "com.obric.memorydata.plugin")).m3191clone());
        goto L8
    L10:
        this.keep = new TreeMap(r7.keep);
        this.index = r7.index;
        this.maxIndex = r7.maxIndex;
        this.used = false;
        nextAuthenticationPath(r8, r9, r10);
    }

    private BDS(WOTSPlus r2, int r3, int r4, int r5) {
        this.wotsPlus = r2;
        this.treeHeight = r3;
        this.maxIndex = r5;
        this.k = r4;
        if (r4 > r3) goto L14;
        if (r4 < 2) goto L14;
        int r6 = r3 - r4;
        if ((r6 % 2) != 0) goto L14;
        this.authenticationPath = new ArrayList();
        this.retain = new TreeMap();
        this.stack = new Stack();
        this.treeHashInstances = new ArrayList();
        int r7 = 0;
    L9:
        if (r7 >= r6) goto L11;
        this.treeHashInstances.add(new BDSTreeHash(r7));
        r7 = r7 + 1;
        goto L9
    L11:
        this.keep = new TreeMap();
        this.index = 0;
        this.used = false;
        return;
    L14:
        throw new IllegalArgumentException("illegal value for BDS parameter k");
    }

    BDS(XMSSParameters r3, int r4, int r5) {
        this(r3.getWOTSPlus(), r3.getHeight(), r3.getK(), r5);
        this.maxIndex = r4;
        this.index = r5;
        this.used = true;
    }

    BDS(XMSSParameters r5, byte[] r6, byte[] r7, OTSHashAddress r8) {
        this(r5.getWOTSPlus(), r5.getHeight(), r5.getK(), (1 << r5.getHeight()) - 1);
        initialize(r6, r7, r8);
    }

    BDS(XMSSParameters r5, byte[] r6, byte[] r7, OTSHashAddress r8, int r9) {
        this(r5.getWOTSPlus(), r5.getHeight(), r5.getK(), (1 << r5.getHeight()) - 1);
        initialize(r6, r7, r8);
    L4:
        if (this.index >= r9) goto L6;
        nextAuthenticationPath(r6, r7, r8);
        this.used = false;
        goto L4
    }

    private BDSTreeHash getBDSTreeHashInstanceForUpdate() {
        Iterator<BDSTreeHash> r4 = this.treeHashInstances.iterator();
        BDSTreeHash r0 = null;
    L4:
        if (r4.hasNext() == false) goto L20;
        BDSTreeHash r1 = (BDSTreeHash) ZeusTransformUtils.preCheckCast(r4.next(), BDSTreeHash.class, "com.obric.memorydata.plugin");
        if (r1.isFinished() == true) goto L4;
        if (r1.isInitialized() == false) goto L4;
        if (r0 == null) goto L14;
        if (r1.getHeight() < r0.getHeight()) goto L14;
        if (r1.getHeight() != r0.getHeight()) goto L4;
        if (r1.getIndexLeaf() >= r0.getIndexLeaf()) goto L4;
    L14:
        r0 = r1;
        goto L4
    L20:
        return r0;
    }

    private void initialize(byte[] r12, byte[] r13, OTSHashAddress r14) {
        Objects.requireNonNull(r14, "otsHashAddress == null");
        LTreeAddress r0 = (LTreeAddress) ZeusTransformUtils.preCheckCast(((LTreeAddress.Builder) ZeusTransformUtils.preCheckCast(((LTreeAddress.Builder) ZeusTransformUtils.preCheckCast(new LTreeAddress.Builder().withLayerAddress(r14.getLayerAddress()), LTreeAddress.Builder.class, "com.obric.memorydata.plugin")).withTreeAddress(r14.getTreeAddress()), LTreeAddress.Builder.class, "com.obric.memorydata.plugin")).build(), LTreeAddress.class, "com.obric.memorydata.plugin");
        HashTreeAddress r1 = (HashTreeAddress) ZeusTransformUtils.preCheckCast(((HashTreeAddress.Builder) ZeusTransformUtils.preCheckCast(((HashTreeAddress.Builder) ZeusTransformUtils.preCheckCast(new HashTreeAddress.Builder().withLayerAddress(r14.getLayerAddress()), HashTreeAddress.Builder.class, "com.obric.memorydata.plugin")).withTreeAddress(r14.getTreeAddress()), HashTreeAddress.Builder.class, "com.obric.memorydata.plugin")).build(), HashTreeAddress.class, "com.obric.memorydata.plugin");
        int r3 = 0;
    L4:
        if (r3 >= (1 << this.treeHeight)) goto L31;
        r14 = (OTSHashAddress) ZeusTransformUtils.preCheckCast(((OTSHashAddress.Builder) ZeusTransformUtils.preCheckCast(((OTSHashAddress.Builder) ZeusTransformUtils.preCheckCast(((OTSHashAddress.Builder) ZeusTransformUtils.preCheckCast(new OTSHashAddress.Builder().withLayerAddress(r14.getLayerAddress()), OTSHashAddress.Builder.class, "com.obric.memorydata.plugin")).withTreeAddress(r14.getTreeAddress()), OTSHashAddress.Builder.class, "com.obric.memorydata.plugin")).withOTSAddress(r3).withChainAddress(r14.getChainAddress()).withHashAddress(r14.getHashAddress()).withKeyAndMask(r14.getKeyAndMask()), OTSHashAddress.Builder.class, "com.obric.memorydata.plugin")).build(), OTSHashAddress.class, "com.obric.memorydata.plugin");
        WOTSPlus r4 = this.wotsPlus;
        r4.importKeys(r4.getWOTSPlusSecretKey(r13, r14), r12);
        WOTSPlusPublicKeyParameters r5 = this.wotsPlus.getPublicKey(r14);
        r0 = (LTreeAddress) ZeusTransformUtils.preCheckCast(((LTreeAddress.Builder) ZeusTransformUtils.preCheckCast(((LTreeAddress.Builder) ZeusTransformUtils.preCheckCast(((LTreeAddress.Builder) ZeusTransformUtils.preCheckCast(new LTreeAddress.Builder().withLayerAddress(r0.getLayerAddress()), LTreeAddress.Builder.class, "com.obric.memorydata.plugin")).withTreeAddress(r0.getTreeAddress()), LTreeAddress.Builder.class, "com.obric.memorydata.plugin")).withLTreeAddress(r3).withTreeHeight(r0.getTreeHeight()).withTreeIndex(r0.getTreeIndex()).withKeyAndMask(r0.getKeyAndMask()), LTreeAddress.Builder.class, "com.obric.memorydata.plugin")).build(), LTreeAddress.class, "com.obric.memorydata.plugin");
        XMSSNode r6 = XMSSNodeUtil.lTree(this.wotsPlus, r5, r0);
        r1 = (HashTreeAddress) ZeusTransformUtils.preCheckCast(((HashTreeAddress.Builder) ZeusTransformUtils.preCheckCast(((HashTreeAddress.Builder) ZeusTransformUtils.preCheckCast(((HashTreeAddress.Builder) ZeusTransformUtils.preCheckCast(new HashTreeAddress.Builder().withLayerAddress(r1.getLayerAddress()), HashTreeAddress.Builder.class, "com.obric.memorydata.plugin")).withTreeAddress(r1.getTreeAddress()), HashTreeAddress.Builder.class, "com.obric.memorydata.plugin")).withTreeIndex(r3).withKeyAndMask(r1.getKeyAndMask()), HashTreeAddress.Builder.class, "com.obric.memorydata.plugin")).build(), HashTreeAddress.class, "com.obric.memorydata.plugin");
    L7:
        if (this.stack.isEmpty() == true) goto L30;
        if (((XMSSNode) ZeusTransformUtils.preCheckCast(this.stack.peek(), XMSSNode.class, "com.obric.memorydata.plugin")).getHeight() != r6.getHeight()) goto L30;
        int r7 = r3 / (1 << r6.getHeight());
        if (r7 != 1) goto L14;
        this.authenticationPath.add(r6);
    L14:
        if (r7 == 3) goto L16;
    L18:
        if (r7 < 3) goto L29;
        if ((r7 & 1) != 1) goto L29;
        if (r6.getHeight() < (this.treeHeight - this.k)) goto L29;
        if (r6.getHeight() > (this.treeHeight - 2)) goto L29;
        if (this.retain.get(Integer.valueOf(r6.getHeight())) != null) goto L28;
        LinkedList<XMSSNode> r8 = new LinkedList();
        r8.add(r6);
        this.retain.put(Integer.valueOf(r6.getHeight()), r8);
        goto L29
    L28:
        ((LinkedList) ZeusTransformUtils.preCheckCast(this.retain.get(Integer.valueOf(r6.getHeight())), LinkedList.class, "com.obric.memorydata.plugin")).add(r6);
    L29:
        HashTreeAddress r2 = (HashTreeAddress) ZeusTransformUtils.preCheckCast(((HashTreeAddress.Builder) ZeusTransformUtils.preCheckCast(((HashTreeAddress.Builder) ZeusTransformUtils.preCheckCast(((HashTreeAddress.Builder) ZeusTransformUtils.preCheckCast(new HashTreeAddress.Builder().withLayerAddress(r1.getLayerAddress()), HashTreeAddress.Builder.class, "com.obric.memorydata.plugin")).withTreeAddress(r1.getTreeAddress()), HashTreeAddress.Builder.class, "com.obric.memorydata.plugin")).withTreeHeight(r1.getTreeHeight()).withTreeIndex((r1.getTreeIndex() - 1) / 2).withKeyAndMask(r1.getKeyAndMask()), HashTreeAddress.Builder.class, "com.obric.memorydata.plugin")).build(), HashTreeAddress.class, "com.obric.memorydata.plugin");
        XMSSNode r9 = XMSSNodeUtil.randomizeHash(this.wotsPlus, (XMSSNode) ZeusTransformUtils.preCheckCast(this.stack.pop(), XMSSNode.class, "com.obric.memorydata.plugin"), r6, r2);
        XMSSNode r10 = new XMSSNode(r9.getHeight() + 1, r9.getValue());
        r1 = (HashTreeAddress) ZeusTransformUtils.preCheckCast(((HashTreeAddress.Builder) ZeusTransformUtils.preCheckCast(((HashTreeAddress.Builder) ZeusTransformUtils.preCheckCast(((HashTreeAddress.Builder) ZeusTransformUtils.preCheckCast(new HashTreeAddress.Builder().withLayerAddress(r2.getLayerAddress()), HashTreeAddress.Builder.class, "com.obric.memorydata.plugin")).withTreeAddress(r2.getTreeAddress()), HashTreeAddress.Builder.class, "com.obric.memorydata.plugin")).withTreeHeight(r2.getTreeHeight() + 1).withTreeIndex(r2.getTreeIndex()).withKeyAndMask(r2.getKeyAndMask()), HashTreeAddress.Builder.class, "com.obric.memorydata.plugin")).build(), HashTreeAddress.class, "com.obric.memorydata.plugin");
        r6 = r10;
        goto L7
    L16:
        if (r6.getHeight() >= (this.treeHeight - this.k)) goto L18;
        ((BDSTreeHash) ZeusTransformUtils.preCheckCast(this.treeHashInstances.get(r6.getHeight()), BDSTreeHash.class, "com.obric.memorydata.plugin")).setNode(r6);
    L30:
        this.stack.push(r6);
        r3 = r3 + 1;
        goto L4
    L31:
        this.root = (XMSSNode) ZeusTransformUtils.preCheckCast(this.stack.pop(), XMSSNode.class, "com.obric.memorydata.plugin");
    }

    private void nextAuthenticationPath(byte[] r13, byte[] r14, OTSHashAddress r15) {
        Objects.requireNonNull(r15, "otsHashAddress == null");
        if (this.used == true) goto L38;
        int r0 = this.index;
        if (r0 > (this.maxIndex - 1)) goto L36;
        int r1 = XMSSUtil.calculateTau(r0, this.treeHeight);
        if (((this.index >> (r1 + 1)) & 1) == 0) goto L9;
    L11:
        LTreeAddress r2 = (LTreeAddress) ZeusTransformUtils.preCheckCast(((LTreeAddress.Builder) ZeusTransformUtils.preCheckCast(((LTreeAddress.Builder) ZeusTransformUtils.preCheckCast(new LTreeAddress.Builder().withLayerAddress(r15.getLayerAddress()), LTreeAddress.Builder.class, "com.obric.memorydata.plugin")).withTreeAddress(r15.getTreeAddress()), LTreeAddress.Builder.class, "com.obric.memorydata.plugin")).build(), LTreeAddress.class, "com.obric.memorydata.plugin");
        HashTreeAddress r3 = (HashTreeAddress) ZeusTransformUtils.preCheckCast(((HashTreeAddress.Builder) ZeusTransformUtils.preCheckCast(((HashTreeAddress.Builder) ZeusTransformUtils.preCheckCast(new HashTreeAddress.Builder().withLayerAddress(r15.getLayerAddress()), HashTreeAddress.Builder.class, "com.obric.memorydata.plugin")).withTreeAddress(r15.getTreeAddress()), HashTreeAddress.Builder.class, "com.obric.memorydata.plugin")).build(), HashTreeAddress.class, "com.obric.memorydata.plugin");
        int r5 = 0;
        if (r1 != 0) goto L14;
        r15 = (OTSHashAddress) ZeusTransformUtils.preCheckCast(((OTSHashAddress.Builder) ZeusTransformUtils.preCheckCast(((OTSHashAddress.Builder) ZeusTransformUtils.preCheckCast(((OTSHashAddress.Builder) ZeusTransformUtils.preCheckCast(new OTSHashAddress.Builder().withLayerAddress(r15.getLayerAddress()), OTSHashAddress.Builder.class, "com.obric.memorydata.plugin")).withTreeAddress(r15.getTreeAddress()), OTSHashAddress.Builder.class, "com.obric.memorydata.plugin")).withOTSAddress(this.index).withChainAddress(r15.getChainAddress()).withHashAddress(r15.getHashAddress()).withKeyAndMask(r15.getKeyAndMask()), OTSHashAddress.Builder.class, "com.obric.memorydata.plugin")).build(), OTSHashAddress.class, "com.obric.memorydata.plugin");
        WOTSPlus r4 = this.wotsPlus;
        r4.importKeys(r4.getWOTSPlusSecretKey(r14, r15), r13);
        this.authenticationPath.set(0, XMSSNodeUtil.lTree(this.wotsPlus, this.wotsPlus.getPublicKey(r15), (LTreeAddress) ZeusTransformUtils.preCheckCast(((LTreeAddress.Builder) ZeusTransformUtils.preCheckCast(((LTreeAddress.Builder) ZeusTransformUtils.preCheckCast(((LTreeAddress.Builder) ZeusTransformUtils.preCheckCast(new LTreeAddress.Builder().withLayerAddress(r2.getLayerAddress()), LTreeAddress.Builder.class, "com.obric.memorydata.plugin")).withTreeAddress(r2.getTreeAddress()), LTreeAddress.Builder.class, "com.obric.memorydata.plugin")).withLTreeAddress(this.index).withTreeHeight(r2.getTreeHeight()).withTreeIndex(r2.getTreeIndex()).withKeyAndMask(r2.getKeyAndMask()), LTreeAddress.Builder.class, "com.obric.memorydata.plugin")).build(), LTreeAddress.class, "com.obric.memorydata.plugin")));
    L28:
        if (r5 >= ((this.treeHeight - this.k) >> 1)) goto L33;
        BDSTreeHash r6 = getBDSTreeHashInstanceForUpdate();
        if (r6 == null) goto L32;
        r6.update(this.stack, this.wotsPlus, r13, r14, r15);
    L32:
        r5 = r5 + 1;
        goto L28
    L33:
        this.index++;
        return;
    L14:
        int r7 = r1 - 1;
        HashTreeAddress r8 = (HashTreeAddress) ZeusTransformUtils.preCheckCast(((HashTreeAddress.Builder) ZeusTransformUtils.preCheckCast(((HashTreeAddress.Builder) ZeusTransformUtils.preCheckCast(((HashTreeAddress.Builder) ZeusTransformUtils.preCheckCast(new HashTreeAddress.Builder().withLayerAddress(r3.getLayerAddress()), HashTreeAddress.Builder.class, "com.obric.memorydata.plugin")).withTreeAddress(r3.getTreeAddress()), HashTreeAddress.Builder.class, "com.obric.memorydata.plugin")).withTreeHeight(r7).withTreeIndex(this.index >> r1).withKeyAndMask(r3.getKeyAndMask()), HashTreeAddress.Builder.class, "com.obric.memorydata.plugin")).build(), HashTreeAddress.class, "com.obric.memorydata.plugin");
        WOTSPlus r9 = this.wotsPlus;
        r9.importKeys(r9.getWOTSPlusSecretKey(r14, r15), r13);
        XMSSNode r10 = XMSSNodeUtil.randomizeHash(this.wotsPlus, (XMSSNode) ZeusTransformUtils.preCheckCast(this.authenticationPath.get(r7), XMSSNode.class, "com.obric.memorydata.plugin"), (XMSSNode) ZeusTransformUtils.preCheckCast(this.keep.get(Integer.valueOf(r7)), XMSSNode.class, "com.obric.memorydata.plugin"), r8);
        this.authenticationPath.set(r1, new XMSSNode(r10.getHeight() + 1, r10.getValue()));
        this.keep.remove(Integer.valueOf(r7));
        int r11 = 0;
    L15:
        if (r11 >= r1) goto L21;
        if (r11 >= (this.treeHeight - this.k)) goto L19;
        List r12 = this.authenticationPath;
        Object r16 = ((BDSTreeHash) ZeusTransformUtils.preCheckCast(this.treeHashInstances.get(r11), BDSTreeHash.class, "com.obric.memorydata.plugin")).getTailNode();
    L20:
        r12.set(r11, r16);
        r11 = r11 + 1;
        goto L15
    L19:
        r12 = this.authenticationPath;
        r16 = ((LinkedList) ZeusTransformUtils.preCheckCast(this.retain.get(Integer.valueOf(r11)), LinkedList.class, "com.obric.memorydata.plugin")).removeFirst();
        goto L20
    L21:
        int r17 = Math.min(r1, this.treeHeight - this.k);
        int r18 = 0;
    L22:
        if (r18 >= r17) goto L28;
        int r19 = (this.index + 1) + ((1 << r18) * 3);
        if (r19 >= (1 << this.treeHeight)) goto L26;
        ((BDSTreeHash) ZeusTransformUtils.preCheckCast(this.treeHashInstances.get(r18), BDSTreeHash.class, "com.obric.memorydata.plugin")).initialize(r19);
    L26:
        r18 = r18 + 1;
        goto L22
    L9:
        if (r1 >= (this.treeHeight - 1)) goto L11;
        this.keep.put(Integer.valueOf(r1), this.authenticationPath.get(r1));
        goto L11
    L36:
        throw new IllegalStateException("index out of bounds");
    L38:
        throw new IllegalStateException("index already used");
    }

    private void readObject(ObjectInputStream r4) {
        r4.defaultReadObject();
        if (r4.available() == 0) goto L5;
        int r0 = r4.readInt();
    L6:
        this.maxIndex = r0;
        int r1 = this.maxIndex;
        if (r1 > ((1 << this.treeHeight) - 1)) goto L14;
        if (this.index > (r1 + 1)) goto L14;
        if (r4.available() != 0) goto L14;
        return;
    L14:
        throw new IOException("inconsistent BDS data detected");
    L5:
        r0 = (1 << this.treeHeight) - 1;
        goto L6
    }

    private void validate() {
        if (this.authenticationPath == null) goto L26;
        if (this.retain == null) goto L24;
        if (this.stack == null) goto L22;
        if (this.treeHashInstances == null) goto L20;
        if (this.keep == null) goto L18;
        if (XMSSUtil.isIndexValid(this.treeHeight, this.index) == false) goto L16;
        return;
    L16:
        throw new IllegalStateException("index in BDS state out of bounds");
    L18:
        throw new IllegalStateException("keep == null");
    L20:
        throw new IllegalStateException("treeHashInstances == null");
    L22:
        throw new IllegalStateException("stack == null");
    L24:
        throw new IllegalStateException("retain == null");
    L26:
        throw new IllegalStateException("authenticationPath == null");
    }

    private void writeObject(ObjectOutputStream r1) {
        r1.defaultWriteObject();
        r1.writeInt(this.maxIndex);
    }

    public List<XMSSNode> getAuthenticationPath() {
        ArrayList r0 = new ArrayList();
        Iterator<XMSSNode> r4 = this.authenticationPath.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r0.add((XMSSNode) ZeusTransformUtils.preCheckCast(r4.next(), XMSSNode.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        return r0;
    }

    public int getIndex() {
        return this.index;
    }

    public int getMaxIndex() {
        return this.maxIndex;
    }

    public BDS getNextState(byte[] r2, byte[] r3, OTSHashAddress r4) {
        return new BDS(this, r2, r3, r4);
    }

    public XMSSNode getRoot() {
        return this.root;
    }

    public int getTreeHeight() {
        return this.treeHeight;
    }

    boolean isUsed() {
        return this.used;
    }

    void markUsed() {
        this.used = true;
    }

    public BDS withMaxIndex(int r2, ASN1ObjectIdentifier r3) {
        return new BDS(this, r2, r3);
    }

    public BDS withWOTSDigest(ASN1ObjectIdentifier r2) {
        return new BDS(this, r2);
    }
}
