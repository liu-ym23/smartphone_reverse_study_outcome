package org.bouncycastle.pqc.crypto.xmss;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.util.Integers;

/* JADX INFO: loaded from: classes7.dex */
public class BDSStateMap implements Serializable {
    private static final long serialVersionUID = -3464451825208522308L;
    private final Map<Integer, BDS> bdsState;
    private transient long maxIndex;

    BDSStateMap(long r2) {
        this.bdsState = new TreeMap();
        this.maxIndex = r2;
    }

    BDSStateMap(BDSStateMap r8, long r9) {
        this.bdsState = new TreeMap();
        Iterator<Integer> r0 = r8.bdsState.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(r0.next(), Integer.class, "com.obric.memorydata.plugin");
        this.bdsState.put(r1, new BDS((BDS) ZeusTransformUtils.preCheckCast(r8.bdsState.get(r1), BDS.class, "com.obric.memorydata.plugin")));
        goto L4
    L6:
        this.maxIndex = r9;
    }

    BDSStateMap(XMSSMTParameters r12, long r13, byte[] r15, byte[] r16) {
        this.bdsState = new TreeMap();
        this.maxIndex = (1 << r12.getHeight()) - 1;
        long r9 = 0;
    L4:
        if (r9 >= r13) goto L6;
        updateState(r12, r9, r15, r16);
        r9 = r9 + 1;
        goto L4
    }

    private void readObject(ObjectInputStream r3) {
        r3.defaultReadObject();
        if (r3.available() == 0) goto L5;
        long r0 = r3.readLong();
    L6:
        this.maxIndex = r0;
        return;
    L5:
        r0 = 0;
        goto L6
    }

    private void writeObject(ObjectOutputStream r3) {
        r3.defaultWriteObject();
        r3.writeLong(this.maxIndex);
    }

    BDS get(int r2) {
        return (BDS) ZeusTransformUtils.preCheckCast(this.bdsState.get(Integers.valueOf(r2)), BDS.class, "com.obric.memorydata.plugin");
    }

    public long getMaxIndex() {
        return this.maxIndex;
    }

    public boolean isEmpty() {
        return this.bdsState.isEmpty();
    }

    void put(int r1, BDS r2) {
        this.bdsState.put(Integers.valueOf(r1), r2);
    }

    BDS update(int r4, byte[] r5, byte[] r6, OTSHashAddress r7) {
        return (BDS) ZeusTransformUtils.preCheckCast(this.bdsState.put(Integers.valueOf(r4), ((BDS) ZeusTransformUtils.preCheckCast(this.bdsState.get(Integers.valueOf(r4)), BDS.class, "com.obric.memorydata.plugin")).getNextState(r5, r6, r7)), BDS.class, "com.obric.memorydata.plugin");
    }

    void updateState(XMSSMTParameters r19, long r20, byte[] r22, byte[] r23) {
        XMSSParameters r5 = r19.getXMSSParameters();
        int r6 = r5.getHeight();
        long r7 = XMSSUtil.getTreeIndex(r20, r6);
        int r9 = XMSSUtil.getLeafIndex(r20, r6);
        OTSHashAddress r10 = (OTSHashAddress) ZeusTransformUtils.preCheckCast(((OTSHashAddress.Builder) ZeusTransformUtils.preCheckCast(new OTSHashAddress.Builder().withTreeAddress(r7), OTSHashAddress.Builder.class, "com.obric.memorydata.plugin")).withOTSAddress(r9).build(), OTSHashAddress.class, "com.obric.memorydata.plugin");
        int r11 = 1;
        int r13 = (1 << r6) - 1;
        if (r9 >= r13) goto L10;
        if (get(0) == null) goto L7;
        if (r9 == 0) goto L7;
    L8:
        update(0, r22, r23, r10);
    L7:
        put(0, new BDS(r5, r22, r23, r10));
    L10:
        if (r11 >= r19.getLayers()) goto L23;
        int r12 = XMSSUtil.getLeafIndex(r7, r6);
        long r8 = XMSSUtil.getTreeIndex(r7, r6);
        OTSHashAddress r14 = (OTSHashAddress) ZeusTransformUtils.preCheckCast(((OTSHashAddress.Builder) ZeusTransformUtils.preCheckCast(((OTSHashAddress.Builder) ZeusTransformUtils.preCheckCast(new OTSHashAddress.Builder().withLayerAddress(r11), OTSHashAddress.Builder.class, "com.obric.memorydata.plugin")).withTreeAddress(r8), OTSHashAddress.Builder.class, "com.obric.memorydata.plugin")).withOTSAddress(r12).build(), OTSHashAddress.class, "com.obric.memorydata.plugin");
        if (this.bdsState.get(Integer.valueOf(r11)) != null) goto L14;
    L17:
        this.bdsState.put(Integer.valueOf(r11), new BDS(r5, r22, r23, r14));
    L18:
        if (r12 >= r13) goto L22;
        if (XMSSUtil.isNewAuthenticationPathNeeded(r20, r6, r11) == false) goto L22;
        update(r11, r22, r23, r14);
    L22:
        r11 = r11 + 1;
        r7 = r8;
        goto L10
    L14:
        if (XMSSUtil.isNewBDSInitNeeded(r20, r6, r11) == false) goto L18;
    }

    public BDSStateMap withWOTSDigest(ASN1ObjectIdentifier r8) {
        BDSStateMap r0 = new BDSStateMap(this.maxIndex);
        Iterator<Integer> r1 = this.bdsState.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Integer r2 = (Integer) ZeusTransformUtils.preCheckCast(r1.next(), Integer.class, "com.obric.memorydata.plugin");
        r0.bdsState.put(r2, ((BDS) ZeusTransformUtils.preCheckCast(this.bdsState.get(r2), BDS.class, "com.obric.memorydata.plugin")).withWOTSDigest(r8));
        goto L4
    L6:
        return r0;
    }
}
