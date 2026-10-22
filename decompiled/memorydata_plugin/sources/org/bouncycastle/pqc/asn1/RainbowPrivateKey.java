package org.bouncycastle.pqc.asn1;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.pqc.legacy.crypto.rainbow.Layer;
import org.bouncycastle.pqc.legacy.crypto.rainbow.util.RainbowUtil;

/* JADX INFO: loaded from: classes7.dex */
public class RainbowPrivateKey extends ASN1Object {
    private byte[] b1;
    private byte[] b2;
    private byte[][] invA1;
    private byte[][] invA2;
    private Layer[] layers;
    private ASN1ObjectIdentifier oid;
    private ASN1Integer version;
    private byte[] vi;

    private RainbowPrivateKey(ASN1Sequence r19) {
        int r2 = 0;
        if (ZeusTransformUtils.instanceOf(r19.getObjectAt(0), ASN1Integer.class) == false) goto L5;
        this.version = ASN1Integer.getInstance(r19.getObjectAt(0));
    L6:
        int r3 = 1;
        ASN1Sequence r4 = (ASN1Sequence) ZeusTransformUtils.preCheckCast(r19.getObjectAt(1), ASN1Sequence.class, "com.obric.memorydata.plugin");
        this.invA1 = new byte[r4.size()][];
        int r5 = 0;
    L8:
        if (r5 >= r4.size()) goto L10;
        this.invA1[r5] = ((ASN1OctetString) ZeusTransformUtils.preCheckCast(r4.getObjectAt(r5), ASN1OctetString.class, "com.obric.memorydata.plugin")).getOctets();
        r5 = r5 + 1;
        goto L8
    L10:
        this.b1 = ((ASN1OctetString) ZeusTransformUtils.preCheckCast(((ASN1Sequence) ZeusTransformUtils.preCheckCast(r19.getObjectAt(2), ASN1Sequence.class, "com.obric.memorydata.plugin")).getObjectAt(0), ASN1OctetString.class, "com.obric.memorydata.plugin")).getOctets();
        ASN1Sequence r7 = (ASN1Sequence) ZeusTransformUtils.preCheckCast(r19.getObjectAt(3), ASN1Sequence.class, "com.obric.memorydata.plugin");
        this.invA2 = new byte[r7.size()][];
        int r8 = 0;
    L12:
        if (r8 >= r7.size()) goto L14;
        this.invA2[r8] = ((ASN1OctetString) ZeusTransformUtils.preCheckCast(r7.getObjectAt(r8), ASN1OctetString.class, "com.obric.memorydata.plugin")).getOctets();
        r8 = r8 + 1;
        goto L12
    L14:
        this.b2 = ((ASN1OctetString) ZeusTransformUtils.preCheckCast(((ASN1Sequence) ZeusTransformUtils.preCheckCast(r19.getObjectAt(4), ASN1Sequence.class, "com.obric.memorydata.plugin")).getObjectAt(0), ASN1OctetString.class, "com.obric.memorydata.plugin")).getOctets();
        this.vi = ((ASN1OctetString) ZeusTransformUtils.preCheckCast(((ASN1Sequence) ZeusTransformUtils.preCheckCast(r19.getObjectAt(5), ASN1Sequence.class, "com.obric.memorydata.plugin")).getObjectAt(0), ASN1OctetString.class, "com.obric.memorydata.plugin")).getOctets();
        ASN1Sequence r1 = (ASN1Sequence) ZeusTransformUtils.preCheckCast(r19.getObjectAt(6), ASN1Sequence.class, "com.obric.memorydata.plugin");
        byte[][][][] r9 = new byte[r1.size()][][][];
        byte[][][][] r10 = new byte[r1.size()][][][];
        byte[][][] r11 = new byte[r1.size()][][];
        byte[][] r12 = new byte[r1.size()][];
        int r13 = 0;
    L16:
        if (r13 >= r1.size()) goto L38;
        ASN1Sequence r14 = (ASN1Sequence) ZeusTransformUtils.preCheckCast(r1.getObjectAt(r13), ASN1Sequence.class, "com.obric.memorydata.plugin");
        ASN1Sequence r15 = (ASN1Sequence) ZeusTransformUtils.preCheckCast(r14.getObjectAt(r2), ASN1Sequence.class, "com.obric.memorydata.plugin");
        r9[r13] = new byte[r15.size()][][];
        int r16 = r2;
    L19:
        if (r16 >= r15.size()) goto L25;
        ASN1Sequence r6 = (ASN1Sequence) ZeusTransformUtils.preCheckCast(r15.getObjectAt(r16), ASN1Sequence.class, "com.obric.memorydata.plugin");
        r9[r13][r16] = new byte[r6.size()][];
        int r17 = 0;
    L22:
        if (r17 >= r6.size()) goto L24;
        r9[r13][r16][r17] = ((ASN1OctetString) ZeusTransformUtils.preCheckCast(r6.getObjectAt(r17), ASN1OctetString.class, "com.obric.memorydata.plugin")).getOctets();
        r17 = r17 + 1;
        goto L22
    L24:
        r16 = r16 + 1;
        r3 = 1;
        goto L19
    L25:
        ASN1Sequence r18 = (ASN1Sequence) ZeusTransformUtils.preCheckCast(r14.getObjectAt(r3), ASN1Sequence.class, "com.obric.memorydata.plugin");
        r10[r13] = new byte[r18.size()][][];
        int r20 = 0;
    L27:
        if (r20 >= r18.size()) goto L33;
        ASN1Sequence r21 = (ASN1Sequence) ZeusTransformUtils.preCheckCast(r18.getObjectAt(r20), ASN1Sequence.class, "com.obric.memorydata.plugin");
        r10[r13][r20] = new byte[r21.size()][];
        int r22 = 0;
    L30:
        if (r22 >= r21.size()) goto L32;
        r10[r13][r20][r22] = ((ASN1OctetString) ZeusTransformUtils.preCheckCast(r21.getObjectAt(r22), ASN1OctetString.class, "com.obric.memorydata.plugin")).getOctets();
        r22 = r22 + 1;
        goto L30
    L32:
        r20 = r20 + 1;
        goto L27
    L33:
        ASN1Sequence r23 = (ASN1Sequence) ZeusTransformUtils.preCheckCast(r14.getObjectAt(2), ASN1Sequence.class, "com.obric.memorydata.plugin");
        r11[r13] = new byte[r23.size()][];
        int r24 = 0;
    L35:
        if (r24 >= r23.size()) goto L37;
        r11[r13][r24] = ((ASN1OctetString) ZeusTransformUtils.preCheckCast(r23.getObjectAt(r24), ASN1OctetString.class, "com.obric.memorydata.plugin")).getOctets();
        r24 = r24 + 1;
        goto L35
    L37:
        r12[r13] = ((ASN1OctetString) ZeusTransformUtils.preCheckCast(r14.getObjectAt(3), ASN1OctetString.class, "com.obric.memorydata.plugin")).getOctets();
        r13 = r13 + 1;
        r2 = 0;
        r3 = 1;
        goto L16
    L38:
        int r25 = this.vi.length - 1;
        this.layers = new Layer[r25];
        int r26 = 0;
    L39:
        if (r26 >= r25) goto L41;
        byte[] r27 = this.vi;
        int r28 = r26 + 1;
        this.layers[r26] = new Layer(r27[r26], r27[r28], RainbowUtil.convertArray(r9[r26]), RainbowUtil.convertArray(r10[r26]), RainbowUtil.convertArray(r11[r26]), RainbowUtil.convertArray(r12[r26]));
        r26 = r28;
        goto L39
    L41:
        return;
    L5:
        this.oid = ASN1ObjectIdentifier.getInstance(r19.getObjectAt(0));
        goto L6
    }

    public RainbowPrivateKey(short[][] r4, short[] r5, short[][] r6, short[] r7, int[] r8, Layer[] r9) {
        this.version = new ASN1Integer(1);
        this.invA1 = RainbowUtil.convertArray(r4);
        this.b1 = RainbowUtil.convertArray(r5);
        this.invA2 = RainbowUtil.convertArray(r6);
        this.b2 = RainbowUtil.convertArray(r7);
        this.vi = RainbowUtil.convertIntArray(r8);
        this.layers = r9;
    }

    public static RainbowPrivateKey getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, RainbowPrivateKey.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new RainbowPrivateKey(ASN1Sequence.getInstance(r2));
    L5:
        return (RainbowPrivateKey) ZeusTransformUtils.preCheckCast(r2, RainbowPrivateKey.class, "com.obric.memorydata.plugin");
    }

    public short[] getB1() {
        return RainbowUtil.convertArray(this.b1);
    }

    public short[] getB2() {
        return RainbowUtil.convertArray(this.b2);
    }

    public short[][] getInvA1() {
        return RainbowUtil.convertArray(this.invA1);
    }

    public short[][] getInvA2() {
        return RainbowUtil.convertArray(this.invA2);
    }

    public Layer[] getLayers() {
        return this.layers;
    }

    public int[] getVi() {
        return RainbowUtil.convertArraytoInt(this.vi);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector();
        ASN1Encodable r1 = this.version;
        if (r1 != null) goto L6;
        r1 = this.oid;
    L6:
        r0.add(r1);
        ASN1EncodableVector r2 = new ASN1EncodableVector();
        int r3 = 0;
    L8:
        if (r3 >= this.invA1.length) goto L10;
        r2.add(new DEROctetString(this.invA1[r3]));
        r3 = r3 + 1;
        goto L8
    L10:
        r0.add(new DERSequence(r2));
        ASN1EncodableVector r4 = new ASN1EncodableVector();
        r4.add(new DEROctetString(this.b1));
        r0.add(new DERSequence(r4));
        ASN1EncodableVector r5 = new ASN1EncodableVector();
        int r6 = 0;
    L12:
        if (r6 >= this.invA2.length) goto L14;
        r5.add(new DEROctetString(this.invA2[r6]));
        r6 = r6 + 1;
        goto L12
    L14:
        r0.add(new DERSequence(r5));
        ASN1EncodableVector r7 = new ASN1EncodableVector();
        r7.add(new DEROctetString(this.b2));
        r0.add(new DERSequence(r7));
        ASN1EncodableVector r8 = new ASN1EncodableVector();
        r8.add(new DEROctetString(this.vi));
        r0.add(new DERSequence(r8));
        ASN1EncodableVector r9 = new ASN1EncodableVector();
        int r10 = 0;
    L16:
        if (r10 >= this.layers.length) goto L38;
        ASN1EncodableVector r11 = new ASN1EncodableVector();
        byte[][][] r12 = RainbowUtil.convertArray(this.layers[r10].getCoeffAlpha());
        ASN1EncodableVector r13 = new ASN1EncodableVector();
        int r14 = 0;
    L19:
        if (r14 >= r12.length) goto L25;
        ASN1EncodableVector r15 = new ASN1EncodableVector();
        int r16 = 0;
    L22:
        if (r16 >= r12[r14].length) goto L24;
        r15.add(new DEROctetString(r12[r14][r16]));
        r16 = r16 + 1;
        goto L22
    L24:
        r13.add(new DERSequence(r15));
        r14 = r14 + 1;
        goto L19
    L25:
        r11.add(new DERSequence(r13));
        byte[][][] r17 = RainbowUtil.convertArray(this.layers[r10].getCoeffBeta());
        ASN1EncodableVector r18 = new ASN1EncodableVector();
        int r19 = 0;
    L27:
        if (r19 >= r17.length) goto L33;
        ASN1EncodableVector r20 = new ASN1EncodableVector();
        int r21 = 0;
    L30:
        if (r21 >= r17[r19].length) goto L32;
        r20.add(new DEROctetString(r17[r19][r21]));
        r21 = r21 + 1;
        goto L30
    L32:
        r18.add(new DERSequence(r20));
        r19 = r19 + 1;
        goto L27
    L33:
        r11.add(new DERSequence(r18));
        byte[][] r22 = RainbowUtil.convertArray(this.layers[r10].getCoeffGamma());
        ASN1EncodableVector r23 = new ASN1EncodableVector();
        int r24 = 0;
    L35:
        if (r24 >= r22.length) goto L37;
        r23.add(new DEROctetString(r22[r24]));
        r24 = r24 + 1;
        goto L35
    L37:
        r11.add(new DERSequence(r23));
        r11.add(new DEROctetString(RainbowUtil.convertArray(this.layers[r10].getCoeffEta())));
        r9.add(new DERSequence(r11));
        r10 = r10 + 1;
        goto L16
    L38:
        r0.add(new DERSequence(r9));
        return new DERSequence(r0);
    }
}
