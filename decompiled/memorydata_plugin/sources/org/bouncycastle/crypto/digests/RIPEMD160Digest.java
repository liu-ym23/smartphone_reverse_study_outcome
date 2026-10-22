package org.bouncycastle.crypto.digests;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.crypto.CryptoServiceProperties;
import org.bouncycastle.crypto.CryptoServicePurpose;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes7.dex */
public class RIPEMD160Digest extends GeneralDigest {
    private int H0;
    private int H1;
    private int H2;
    private int H3;
    private int H4;
    private int[] X;
    private int xOff;

    public RIPEMD160Digest() {
        this(CryptoServicePurpose.ANY);
    }

    public RIPEMD160Digest(CryptoServicePurpose r1) {
        super(r1);
        this.X = new int[16];
        CryptoServicesRegistrar.checkConstraints(cryptoServiceProperties());
        reset();
    }

    public RIPEMD160Digest(RIPEMD160Digest r2) {
        super(r2);
        this.X = new int[16];
        CryptoServicesRegistrar.checkConstraints(cryptoServiceProperties());
        copyIn(r2);
    }

    private int RL(int r1, int r2) {
        return (r1 << r2) | (r1 >>> (32 - r2));
    }

    private void copyIn(RIPEMD160Digest r5) {
        super.copyIn(r5);
        this.H0 = r5.H0;
        this.H1 = r5.H1;
        this.H2 = r5.H2;
        this.H3 = r5.H3;
        this.H4 = r5.H4;
        int[] r0 = r5.X;
        System.arraycopy(r0, 0, this.X, 0, r0.length);
        this.xOff = r5.xOff;
    }

    private int f1(int r1, int r2, int r3) {
        return (r1 ^ r2) ^ r3;
    }

    private int f2(int r1, int r2, int r3) {
        return (r1 & r2) | ((~r1) & r3);
    }

    private int f3(int r1, int r2, int r3) {
        return ((~r2) | r1) ^ r3;
    }

    private int f4(int r1, int r2, int r3) {
        return (r1 & r3) | ((~r3) & r2);
    }

    private int f5(int r1, int r2, int r3) {
        return ((~r3) | r2) ^ r1;
    }

    @Override // org.bouncycastle.util.Memoable
    public Memoable copy() {
        return new RIPEMD160Digest(this);
    }

    public CryptoServiceProperties cryptoServiceProperties() {
        return Utils.getDefaultProperties(this, 128, this.purpose);
    }

    @Override // org.bouncycastle.crypto.Digest
    public int doFinal(byte[] r3, int r4) {
        finish();
        Pack.intToLittleEndian(this.H0, r3, r4);
        Pack.intToLittleEndian(this.H1, r3, r4 + 4);
        Pack.intToLittleEndian(this.H2, r3, r4 + 8);
        Pack.intToLittleEndian(this.H3, r3, r4 + 12);
        Pack.intToLittleEndian(this.H4, r3, r4 + 16);
        reset();
        return 20;
    }

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "RIPEMD160";
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return 20;
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest
    public void processBlock() {
        int r1 = this.H0;
        int r2 = this.H1;
        int r3 = this.H2;
        int r4 = this.H3;
        int r5 = this.H4;
        int r6 = RL((f1(r2, r3, r4) + r1) + this.X[0], 11) + r5;
        int r10 = RL(r3, 10);
        int r11 = RL((f1(r6, r2, r10) + r5) + this.X[1], 14) + r4;
        int r14 = RL(r2, 10);
        int r15 = RL((f1(r11, r6, r14) + r4) + this.X[2], 15) + r10;
        int r7 = RL(r6, 10);
        int r12 = RL((r10 + f1(r15, r11, r7)) + this.X[3], 12) + r14;
        int r13 = RL(r11, 10);
        int r16 = RL((r14 + f1(r12, r15, r13)) + this.X[4], 5) + r7;
        int r17 = RL(r15, 10);
        int r8 = RL((r7 + f1(r16, r12, r17)) + this.X[5], 8) + r13;
        int r18 = RL(r12, 10);
        int r19 = RL((r13 + f1(r8, r16, r18)) + this.X[6], 7) + r17;
        int r110 = RL(r16, 10);
        int r111 = RL((r17 + f1(r19, r8, r110)) + this.X[7], 9) + r18;
        int r9 = RL(r8, 10);
        int r20 = RL((r18 + f1(r111, r19, r9)) + this.X[8], 11) + r110;
        int r112 = RL(r19, 10);
        int r113 = RL((r110 + f1(r20, r111, r112)) + this.X[9], 13) + r9;
        int r114 = RL(r111, 10);
        int r21 = RL((r9 + f1(r113, r20, r114)) + this.X[10], 14) + r112;
        int r22 = RL(r20, 10);
        int r115 = RL((r112 + f1(r21, r113, r22)) + this.X[11], 15) + r114;
        int r116 = RL(r113, 10);
        int r117 = RL((r114 + f1(r115, r21, r116)) + this.X[12], 6) + r22;
        int r23 = RL(r21, 10);
        int r24 = RL((r22 + f1(r117, r115, r23)) + this.X[13], 7) + r116;
        int r118 = RL(r115, 10);
        int r119 = RL((r116 + f1(r24, r117, r118)) + this.X[14], 9) + r23;
        int r120 = RL(r117, 10);
        int r25 = RL((r23 + f1(r119, r24, r120)) + this.X[15], 8) + r118;
        int r26 = RL(r24, 10);
        int r27 = RL(((r1 + f5(r2, r3, r4)) + this.X[5]) + 1352829926, 8) + r5;
        int r28 = RL(r3, 10);
        int r29 = RL(((r5 + f5(r27, r2, r28)) + this.X[14]) + 1352829926, 9) + r4;
        int r30 = RL(r2, 10);
        int r31 = RL(((r4 + f5(r29, r27, r30)) + this.X[7]) + 1352829926, 9) + r28;
        int r32 = RL(r27, 10);
        int r33 = RL(((r28 + f5(r31, r29, r32)) + this.X[0]) + 1352829926, 11) + r30;
        int r34 = RL(r29, 10);
        int r35 = RL(((r30 + f5(r33, r31, r34)) + this.X[9]) + 1352829926, 13) + r32;
        int r36 = RL(r31, 10);
        int r37 = RL(((r32 + f5(r35, r33, r36)) + this.X[2]) + 1352829926, 15) + r34;
        int r38 = RL(r33, 10);
        int r39 = RL(((r34 + f5(r37, r35, r38)) + this.X[11]) + 1352829926, 15) + r36;
        int r40 = RL(r35, 10);
        int r41 = RL(((r36 + f5(r39, r37, r40)) + this.X[4]) + 1352829926, 5) + r38;
        int r42 = RL(r37, 10);
        int r43 = RL(((r38 + f5(r41, r39, r42)) + this.X[13]) + 1352829926, 7) + r40;
        int r44 = RL(r39, 10);
        int r45 = RL(((r40 + f5(r43, r41, r44)) + this.X[6]) + 1352829926, 7) + r42;
        int r46 = RL(r41, 10);
        int r47 = RL(((r42 + f5(r45, r43, r46)) + this.X[15]) + 1352829926, 8) + r44;
        int r48 = RL(r43, 10);
        int r49 = RL(((r44 + f5(r47, r45, r48)) + this.X[8]) + 1352829926, 11) + r46;
        int r50 = RL(r45, 10);
        int r51 = RL(((r46 + f5(r49, r47, r50)) + this.X[1]) + 1352829926, 14) + r48;
        int r52 = RL(r47, 10);
        int r53 = RL(((r48 + f5(r51, r49, r52)) + this.X[10]) + 1352829926, 14) + r50;
        int r54 = RL(r49, 10);
        int r55 = RL(((r50 + f5(r53, r51, r54)) + this.X[3]) + 1352829926, 12) + r52;
        int r56 = RL(r51, 10);
        int r57 = RL(((r52 + f5(r55, r53, r56)) + this.X[12]) + 1352829926, 6) + r54;
        int r58 = RL(r53, 10);
        int r121 = RL(((r118 + f2(r25, r119, r26)) + this.X[7]) + 1518500249, 7) + r120;
        int r122 = RL(r119, 10);
        int r123 = RL(((r120 + f2(r121, r25, r122)) + this.X[4]) + 1518500249, 6) + r26;
        int r59 = RL(r25, 10);
        int r60 = RL(((r26 + f2(r123, r121, r59)) + this.X[13]) + 1518500249, 8) + r122;
        int r124 = RL(r121, 10);
        int r125 = RL(((r122 + f2(r60, r123, r124)) + this.X[1]) + 1518500249, 13) + r59;
        int r126 = RL(r123, 10);
        int r61 = RL(((r59 + f2(r125, r60, r126)) + this.X[10]) + 1518500249, 11) + r124;
        int r62 = RL(r60, 10);
        int r127 = RL(((r124 + f2(r61, r125, r62)) + this.X[6]) + 1518500249, 9) + r126;
        int r128 = RL(r125, 10);
        int r129 = RL(((r126 + f2(r127, r61, r128)) + this.X[15]) + 1518500249, 7) + r62;
        int r63 = RL(r61, 10);
        int r64 = RL(((r62 + f2(r129, r127, r63)) + this.X[3]) + 1518500249, 15) + r128;
        int r130 = RL(r127, 10);
        int r131 = RL(((r128 + f2(r64, r129, r130)) + this.X[12]) + 1518500249, 7) + r63;
        int r132 = RL(r129, 10);
        int r65 = RL(((r63 + f2(r131, r64, r132)) + this.X[0]) + 1518500249, 12) + r130;
        int r66 = RL(r64, 10);
        int r133 = RL(((r130 + f2(r65, r131, r66)) + this.X[9]) + 1518500249, 15) + r132;
        int r134 = RL(r131, 10);
        int r135 = RL(((r132 + f2(r133, r65, r134)) + this.X[5]) + 1518500249, 9) + r66;
        int r67 = RL(r65, 10);
        int r68 = RL(((r66 + f2(r135, r133, r67)) + this.X[2]) + 1518500249, 11) + r134;
        int r136 = RL(r133, 10);
        int r137 = RL(((r134 + f2(r68, r135, r136)) + this.X[14]) + 1518500249, 7) + r67;
        int r138 = RL(r135, 10);
        int r69 = RL(((r67 + f2(r137, r68, r138)) + this.X[11]) + 1518500249, 13) + r136;
        int r70 = RL(r68, 10);
        int r139 = RL(((r136 + f2(r69, r137, r70)) + this.X[8]) + 1518500249, 12) + r138;
        int r140 = RL(r137, 10);
        int r71 = RL(((r54 + f4(r57, r55, r58)) + this.X[6]) + 1548603684, 9) + r56;
        int r72 = RL(r55, 10);
        int r73 = RL(((r56 + f4(r71, r57, r72)) + this.X[11]) + 1548603684, 13) + r58;
        int r74 = RL(r57, 10);
        int r75 = RL(((r58 + f4(r73, r71, r74)) + this.X[3]) + 1548603684, 15) + r72;
        int r76 = RL(r71, 10);
        int r77 = RL(((r72 + f4(r75, r73, r76)) + this.X[7]) + 1548603684, 7) + r74;
        int r78 = RL(r73, 10);
        int r79 = RL(((r74 + f4(r77, r75, r78)) + this.X[0]) + 1548603684, 12) + r76;
        int r80 = RL(r75, 10);
        int r81 = RL(((r76 + f4(r79, r77, r80)) + this.X[13]) + 1548603684, 8) + r78;
        int r82 = RL(r77, 10);
        int r83 = RL(((r78 + f4(r81, r79, r82)) + this.X[5]) + 1548603684, 9) + r80;
        int r84 = RL(r79, 10);
        int r85 = RL(((r80 + f4(r83, r81, r84)) + this.X[10]) + 1548603684, 11) + r82;
        int r86 = RL(r81, 10);
        int r87 = RL(((r82 + f4(r85, r83, r86)) + this.X[14]) + 1548603684, 7) + r84;
        int r88 = RL(r83, 10);
        int r89 = RL(((r84 + f4(r87, r85, r88)) + this.X[15]) + 1548603684, 7) + r86;
        int r90 = RL(r85, 10);
        int r91 = RL(((r86 + f4(r89, r87, r90)) + this.X[8]) + 1548603684, 12) + r88;
        int r92 = RL(r87, 10);
        int r93 = RL(((r88 + f4(r91, r89, r92)) + this.X[12]) + 1548603684, 7) + r90;
        int r94 = RL(r89, 10);
        int r95 = RL(((r90 + f4(r93, r91, r94)) + this.X[4]) + 1548603684, 6) + r92;
        int r96 = RL(r91, 10);
        int r97 = RL(((r92 + f4(r95, r93, r96)) + this.X[9]) + 1548603684, 15) + r94;
        int r98 = RL(r93, 10);
        int r99 = RL(((r94 + f4(r97, r95, r98)) + this.X[1]) + 1548603684, 13) + r96;
        int r100 = RL(r95, 10);
        int r101 = RL(((r96 + f4(r99, r97, r100)) + this.X[2]) + 1548603684, 11) + r98;
        int r102 = RL(r97, 10);
        int r141 = RL(((r138 + f3(r139, r69, r140)) + this.X[3]) + 1859775393, 11) + r70;
        int r103 = RL(r69, 10);
        int r104 = RL(((r70 + f3(r141, r139, r103)) + this.X[10]) + 1859775393, 13) + r140;
        int r142 = RL(r139, 10);
        int r143 = RL(((r140 + f3(r104, r141, r142)) + this.X[14]) + 1859775393, 6) + r103;
        int r144 = RL(r141, 10);
        int r105 = RL(((r103 + f3(r143, r104, r144)) + this.X[4]) + 1859775393, 7) + r142;
        int r106 = RL(r104, 10);
        int r145 = RL(((r142 + f3(r105, r143, r106)) + this.X[9]) + 1859775393, 14) + r144;
        int r146 = RL(r143, 10);
        int r147 = RL(((r144 + f3(r145, r105, r146)) + this.X[15]) + 1859775393, 9) + r106;
        int r107 = RL(r105, 10);
        int r108 = RL(((r106 + f3(r147, r145, r107)) + this.X[8]) + 1859775393, 13) + r146;
        int r148 = RL(r145, 10);
        int r149 = RL(((r146 + f3(r108, r147, r148)) + this.X[1]) + 1859775393, 15) + r107;
        int r150 = RL(r147, 10);
        int r109 = RL(((r107 + f3(r149, r108, r150)) + this.X[2]) + 1859775393, 14) + r148;
        int r151 = RL(r108, 10);
        int r152 = RL(((r148 + f3(r109, r149, r151)) + this.X[7]) + 1859775393, 8) + r150;
        int r153 = RL(r149, 10);
        int r154 = RL(((r150 + f3(r152, r109, r153)) + this.X[0]) + 1859775393, 13) + r151;
        int r155 = RL(r109, 10);
        int r156 = RL(((r151 + f3(r154, r152, r155)) + this.X[6]) + 1859775393, 6) + r153;
        int r157 = RL(r152, 10);
        int r158 = RL(((r153 + f3(r156, r154, r157)) + this.X[13]) + 1859775393, 5) + r155;
        int r159 = RL(r154, 10);
        int r160 = RL(((r155 + f3(r158, r156, r159)) + this.X[11]) + 1859775393, 12) + r157;
        int r161 = RL(r156, 10);
        int r162 = RL(((r157 + f3(r160, r158, r161)) + this.X[5]) + 1859775393, 7) + r159;
        int r163 = RL(r158, 10);
        int r164 = RL(((r159 + f3(r162, r160, r163)) + this.X[12]) + 1859775393, 5) + r161;
        int r165 = RL(r160, 10);
        int r166 = RL(((r98 + f3(r101, r99, r102)) + this.X[15]) + 1836072691, 9) + r100;
        int r167 = RL(r99, 10);
        int r168 = RL(((r100 + f3(r166, r101, r167)) + this.X[5]) + 1836072691, 7) + r102;
        int r169 = RL(r101, 10);
        int r170 = RL(((r102 + f3(r168, r166, r169)) + this.X[1]) + 1836072691, 15) + r167;
        int r171 = RL(r166, 10);
        int r172 = RL(((r167 + f3(r170, r168, r171)) + this.X[3]) + 1836072691, 11) + r169;
        int r173 = RL(r168, 10);
        int r174 = RL(((r169 + f3(r172, r170, r173)) + this.X[7]) + 1836072691, 8) + r171;
        int r175 = RL(r170, 10);
        int r176 = RL(((r171 + f3(r174, r172, r175)) + this.X[14]) + 1836072691, 6) + r173;
        int r177 = RL(r172, 10);
        int r178 = RL(((r173 + f3(r176, r174, r177)) + this.X[6]) + 1836072691, 6) + r175;
        int r179 = RL(r174, 10);
        int r180 = RL(((r175 + f3(r178, r176, r179)) + this.X[9]) + 1836072691, 14) + r177;
        int r181 = RL(r176, 10);
        int r182 = RL(((r177 + f3(r180, r178, r181)) + this.X[11]) + 1836072691, 12) + r179;
        int r183 = RL(r178, 10);
        int r184 = RL(((r179 + f3(r182, r180, r183)) + this.X[8]) + 1836072691, 13) + r181;
        int r185 = RL(r180, 10);
        int r186 = RL(((r181 + f3(r184, r182, r185)) + this.X[12]) + 1836072691, 5) + r183;
        int r187 = RL(r182, 10);
        int r188 = RL(((r183 + f3(r186, r184, r187)) + this.X[2]) + 1836072691, 14) + r185;
        int r189 = RL(r184, 10);
        int r190 = RL(((r185 + f3(r188, r186, r189)) + this.X[10]) + 1836072691, 13) + r187;
        int r191 = RL(r186, 10);
        int r192 = RL(((r187 + f3(r190, r188, r191)) + this.X[0]) + 1836072691, 13) + r189;
        int r193 = RL(r188, 10);
        int r194 = RL(((r189 + f3(r192, r190, r193)) + this.X[4]) + 1836072691, 7) + r191;
        int r195 = RL(r190, 10);
        int r196 = RL(((r191 + f3(r194, r192, r195)) + this.X[13]) + 1836072691, 5) + r193;
        int r197 = RL(r192, 10);
        int r198 = RL(((r161 + f4(r164, r162, r165)) + this.X[1]) - 1894007588, 11) + r163;
        int r199 = RL(r162, 10);
        int r1100 = RL(((r163 + f4(r198, r164, r199)) + this.X[9]) - 1894007588, 12) + r165;
        int r1101 = RL(r164, 10);
        int r200 = RL(((r165 + f4(r1100, r198, r1101)) + this.X[11]) - 1894007588, 14) + r199;
        int r201 = RL(r198, 10);
        int r1102 = RL(((r199 + f4(r200, r1100, r201)) + this.X[10]) - 1894007588, 15) + r1101;
        int r1103 = RL(r1100, 10);
        int r1104 = RL(((r1101 + f4(r1102, r200, r1103)) + this.X[0]) - 1894007588, 14) + r201;
        int r202 = RL(r200, 10);
        int r203 = RL(((r201 + f4(r1104, r1102, r202)) + this.X[8]) - 1894007588, 15) + r1103;
        int r1105 = RL(r1102, 10);
        int r1106 = RL(((r1103 + f4(r203, r1104, r1105)) + this.X[12]) - 1894007588, 9) + r202;
        int r1107 = RL(r1104, 10);
        int r204 = RL(((r202 + f4(r1106, r203, r1107)) + this.X[4]) - 1894007588, 8) + r1105;
        int r205 = RL(r203, 10);
        int r1108 = RL(((r1105 + f4(r204, r1106, r205)) + this.X[13]) - 1894007588, 9) + r1107;
        int r1109 = RL(r1106, 10);
        int r1110 = RL(((r1107 + f4(r1108, r204, r1109)) + this.X[3]) - 1894007588, 14) + r205;
        int r206 = RL(r204, 10);
        int r207 = RL(((r205 + f4(r1110, r1108, r206)) + this.X[7]) - 1894007588, 5) + r1109;
        int r1111 = RL(r1108, 10);
        int r1112 = RL(((r1109 + f4(r207, r1110, r1111)) + this.X[15]) - 1894007588, 6) + r206;
        int r1113 = RL(r1110, 10);
        int r208 = RL(((r206 + f4(r1112, r207, r1113)) + this.X[14]) - 1894007588, 8) + r1111;
        int r209 = RL(r207, 10);
        int r1114 = RL(((r1111 + f4(r208, r1112, r209)) + this.X[5]) - 1894007588, 6) + r1113;
        int r1115 = RL(r1112, 10);
        int r1116 = RL(((r1113 + f4(r1114, r208, r1115)) + this.X[6]) - 1894007588, 5) + r209;
        int r210 = RL(r208, 10);
        int r211 = RL(((r209 + f4(r1116, r1114, r210)) + this.X[2]) - 1894007588, 12) + r1115;
        int r1117 = RL(r1114, 10);
        int r212 = RL(((r193 + f2(r196, r194, r197)) + this.X[8]) + 2053994217, 15) + r195;
        int r213 = RL(r194, 10);
        int r214 = RL(((r195 + f2(r212, r196, r213)) + this.X[6]) + 2053994217, 5) + r197;
        int r215 = RL(r196, 10);
        int r216 = RL(((r197 + f2(r214, r212, r215)) + this.X[4]) + 2053994217, 8) + r213;
        int r217 = RL(r212, 10);
        int r218 = RL(((r213 + f2(r216, r214, r217)) + this.X[1]) + 2053994217, 11) + r215;
        int r219 = RL(r214, 10);
        int r220 = RL(((r215 + f2(r218, r216, r219)) + this.X[3]) + 2053994217, 14) + r217;
        int r221 = RL(r216, 10);
        int r222 = RL(((r217 + f2(r220, r218, r221)) + this.X[11]) + 2053994217, 14) + r219;
        int r223 = RL(r218, 10);
        int r224 = RL(((r219 + f2(r222, r220, r223)) + this.X[15]) + 2053994217, 6) + r221;
        int r225 = RL(r220, 10);
        int r226 = RL(((r221 + f2(r224, r222, r225)) + this.X[0]) + 2053994217, 14) + r223;
        int r227 = RL(r222, 10);
        int r228 = RL(((r223 + f2(r226, r224, r227)) + this.X[5]) + 2053994217, 6) + r225;
        int r229 = RL(r224, 10);
        int r230 = RL(((r225 + f2(r228, r226, r229)) + this.X[12]) + 2053994217, 9) + r227;
        int r231 = RL(r226, 10);
        int r232 = RL(((r227 + f2(r230, r228, r231)) + this.X[2]) + 2053994217, 12) + r229;
        int r233 = RL(r228, 10);
        int r234 = RL(((r229 + f2(r232, r230, r233)) + this.X[13]) + 2053994217, 9) + r231;
        int r235 = RL(r230, 10);
        int r236 = RL(((r231 + f2(r234, r232, r235)) + this.X[9]) + 2053994217, 12) + r233;
        int r237 = RL(r232, 10);
        int r238 = RL(((r233 + f2(r236, r234, r237)) + this.X[7]) + 2053994217, 5) + r235;
        int r239 = RL(r234, 10);
        int r240 = RL(((r235 + f2(r238, r236, r239)) + this.X[10]) + 2053994217, 15) + r237;
        int r241 = RL(r236, 10);
        int r242 = RL(((r237 + f2(r240, r238, r241)) + this.X[14]) + 2053994217, 8) + r239;
        int r243 = RL(r238, 10);
        int r1118 = RL(((r1115 + f5(r211, r1116, r1117)) + this.X[4]) - 1454113458, 9) + r210;
        int r1119 = RL(r1116, 10);
        int r244 = RL(((r210 + f5(r1118, r211, r1119)) + this.X[0]) - 1454113458, 15) + r1117;
        int r245 = RL(r211, 10);
        int r1120 = RL(((r1117 + f5(r244, r1118, r245)) + this.X[5]) - 1454113458, 5) + r1119;
        int r1121 = RL(r1118, 10);
        int r1122 = RL(((r1119 + f5(r1120, r244, r1121)) + this.X[9]) - 1454113458, 11) + r245;
        int r246 = RL(r244, 10);
        int r247 = RL(((r245 + f5(r1122, r1120, r246)) + this.X[7]) - 1454113458, 6) + r1121;
        int r1123 = RL(r1120, 10);
        int r1124 = RL(((r1121 + f5(r247, r1122, r1123)) + this.X[12]) - 1454113458, 8) + r246;
        int r1125 = RL(r1122, 10);
        int r248 = RL(((r246 + f5(r1124, r247, r1125)) + this.X[2]) - 1454113458, 13) + r1123;
        int r249 = RL(r247, 10);
        int r1126 = RL(((r1123 + f5(r248, r1124, r249)) + this.X[10]) - 1454113458, 12) + r1125;
        int r1127 = RL(r1124, 10);
        int r1128 = RL(((r1125 + f5(r1126, r248, r1127)) + this.X[14]) - 1454113458, 5) + r249;
        int r250 = RL(r248, 10);
        int r251 = RL(((r249 + f5(r1128, r1126, r250)) + this.X[1]) - 1454113458, 12) + r1127;
        int r1129 = RL(r1126, 10);
        int r1130 = RL(((r1127 + f5(r251, r1128, r1129)) + this.X[3]) - 1454113458, 13) + r250;
        int r1131 = RL(r1128, 10);
        int r252 = RL(((r250 + f5(r1130, r251, r1131)) + this.X[8]) - 1454113458, 14) + r1129;
        int r253 = RL(r251, 10);
        int r1132 = RL(((r1129 + f5(r252, r1130, r253)) + this.X[11]) - 1454113458, 11) + r1131;
        int r1133 = RL(r1130, 10);
        int r1134 = RL(((r1131 + f5(r1132, r252, r1133)) + this.X[6]) - 1454113458, 8) + r253;
        int r254 = RL(r252, 10);
        int r255 = RL(((r253 + f5(r1134, r1132, r254)) + this.X[15]) - 1454113458, 5) + r1133;
        int r1135 = RL(r1132, 10);
        int r1136 = RL(((r1133 + f5(r255, r1134, r1135)) + this.X[13]) - 1454113458, 6) + r254;
        int r1137 = RL(r1134, 10);
        int r256 = RL((r239 + f1(r242, r240, r243)) + this.X[12], 8) + r241;
        int r257 = RL(r240, 10);
        int r258 = RL((r241 + f1(r256, r242, r257)) + this.X[15], 5) + r243;
        int r259 = RL(r242, 10);
        int r260 = RL((r243 + f1(r258, r256, r259)) + this.X[10], 12) + r257;
        int r261 = RL(r256, 10);
        int r262 = RL((r257 + f1(r260, r258, r261)) + this.X[4], 9) + r259;
        int r263 = RL(r258, 10);
        int r264 = RL((r259 + f1(r262, r260, r263)) + this.X[1], 12) + r261;
        int r265 = RL(r260, 10);
        int r266 = RL((r261 + f1(r264, r262, r265)) + this.X[5], 5) + r263;
        int r267 = RL(r262, 10);
        int r268 = RL((r263 + f1(r266, r264, r267)) + this.X[8], 14) + r265;
        int r269 = RL(r264, 10);
        int r270 = RL((r265 + f1(r268, r266, r269)) + this.X[7], 6) + r267;
        int r271 = RL(r266, 10);
        int r272 = RL((r267 + f1(r270, r268, r271)) + this.X[6], 8) + r269;
        int r273 = RL(r268, 10);
        int r274 = RL((r269 + f1(r272, r270, r273)) + this.X[2], 13) + r271;
        int r275 = RL(r270, 10);
        int r276 = RL((r271 + f1(r274, r272, r275)) + this.X[13], 6) + r273;
        int r277 = RL(r272, 10);
        int r278 = RL((r273 + f1(r276, r274, r277)) + this.X[14], 5) + r275;
        int r279 = RL(r274, 10);
        int r280 = RL((r275 + f1(r278, r276, r279)) + this.X[0], 15) + r277;
        int r281 = RL(r276, 10);
        int r282 = RL((r277 + f1(r280, r278, r281)) + this.X[3], 13) + r279;
        int r283 = RL(r278, 10);
        int r284 = RL((r279 + f1(r282, r280, r283)) + this.X[9], 11) + r281;
        int r285 = RL(r280, 10);
        int r286 = RL((r281 + f1(r284, r282, r285)) + this.X[11], 11) + r283;
        int r287 = RL(r282, 10) + (r255 + this.H1);
        this.H1 = (this.H2 + r1137) + r285;
        this.H2 = (this.H3 + r1135) + r283;
        this.H3 = (this.H4 + r254) + r286;
        this.H4 = (this.H0 + r1136) + r284;
        this.H0 = r287;
        this.xOff = 0;
        int r288 = 0;
    L3:
        int[] r289 = this.X;
        if (r288 == r289.length) goto L6;
        r289[r288] = 0;
        r288 = r288 + 1;
        goto L3
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest
    public void processLength(long r5) {
        if (this.xOff <= 14) goto L5;
        processBlock();
    L5:
        int[] r4 = this.X;
        r4[14] = (int) ((-1) & r5);
        r4[15] = (int) (r5 >>> 32);
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest
    public void processWord(byte[] r4, int r5) {
        int[] r0 = this.X;
        int r1 = this.xOff;
        this.xOff = r1 + 1;
        r0[r1] = Pack.littleEndianToInt(r4, r5);
        if (this.xOff != 16) goto L6;
        processBlock();
        return;
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest, org.bouncycastle.crypto.Digest
    public void reset() {
        super.reset();
        this.H0 = 1732584193;
        this.H1 = -271733879;
        this.H2 = -1732584194;
        this.H3 = 271733878;
        this.H4 = -1009589776;
        this.xOff = 0;
        int r1 = 0;
    L3:
        int[] r2 = this.X;
        if (r1 == r2.length) goto L6;
        r2[r1] = 0;
        r1 = r1 + 1;
        goto L3
    }

    @Override // org.bouncycastle.util.Memoable
    public void reset(Memoable r3) {
        copyIn((RIPEMD160Digest) ZeusTransformUtils.preCheckCast((Memoable) ZeusTransformUtils.wrapperContextForParams(r3, Memoable.class, "com.obric.memorydata.plugin"), RIPEMD160Digest.class, "com.obric.memorydata.plugin"));
    }
}
