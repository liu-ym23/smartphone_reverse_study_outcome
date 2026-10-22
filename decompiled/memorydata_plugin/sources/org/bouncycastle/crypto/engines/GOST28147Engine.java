package org.bouncycastle.crypto.engines;

import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Hashtable;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithSBox;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public class GOST28147Engine implements BlockCipher {
    private static byte[] DSbox_A;
    private static byte[] DSbox_Test;
    private static byte[] ESbox_A;
    private static byte[] ESbox_B;
    private static byte[] ESbox_C;
    private static byte[] ESbox_D;
    private static byte[] ESbox_Test;
    private static byte[] Param_Z;
    private static byte[] Sbox_Default;
    private static Hashtable sBoxes;
    private byte[] S;
    private boolean forEncryption;
    private int[] workingKey;

    static {
        Sbox_Default = new byte[]{4, 10, 9, 2, 13, 8, 0, 14, 6, 11, 1, 12, 7, 15, 5, 3, 14, 11, 4, 12, 6, 13, 15, 10, 2, 3, 8, 1, 0, 7, 5, 9, 5, 8, 1, 13, 10, 3, 4, 2, 14, 15, 12, 7, 6, 0, 9, 11, 7, 13, 10, 1, 0, 8, 9, 15, 14, 4, 6, 12, 11, 2, 5, 3, 6, 12, 7, 1, 5, 15, 13, 8, 4, 10, 9, 14, 0, 3, 11, 2, 4, 11, 10, 0, 7, 2, 1, 13, 3, 6, 8, 5, 9, 12, 15, 14, 13, 11, 4, 1, 3, 15, 5, 9, 0, 10, 14, 7, 6, 8, 2, 12, 1, 15, 13, 0, 5, 7, 10, 4, 9, 2, 3, 14, 6, 11, 8, 12};
        ESbox_Test = new byte[]{4, 2, 15, 5, 9, 1, 0, 8, 14, 3, 11, 12, 13, 7, 10, 6, 12, 9, 15, 14, 8, 1, 3, 10, 2, 7, 4, 13, 6, 0, 11, 5, 13, 8, 14, 12, 7, 3, 9, 10, 1, 5, 2, 4, 6, 15, 0, 11, 14, 9, 11, 2, 5, 15, 7, 1, 0, 13, 12, 6, 10, 4, 3, 8, 3, 14, 5, 9, 6, 8, 0, 13, 10, 11, 7, 12, 2, 1, 15, 4, 8, 15, 6, 11, 1, 9, 12, 5, 13, 3, 7, 10, 0, 14, 2, 4, 9, 11, 12, 0, 3, 6, 7, 5, 4, 8, 14, 15, 1, 10, 2, 13, 12, 6, 5, 2, 11, 0, 9, 13, 3, 14, 7, 10, 15, 4, 1, 8};
        ESbox_A = new byte[]{9, 6, 3, 2, 8, 11, 1, 7, 10, 4, 14, 15, 12, 0, 13, 5, 3, 7, 14, 9, 8, 10, 15, 0, 5, 2, 6, 12, 11, 4, 13, 1, 14, 4, 6, 2, 11, 3, 13, 8, 12, 15, 5, 10, 0, 7, 1, 9, 14, 7, 10, 12, 13, 1, 3, 9, 0, 2, 11, 4, 15, 8, 5, 6, 11, 5, 1, 9, 8, 13, 15, 0, 14, 4, 2, 3, 12, 7, 10, 6, 3, 10, 13, 12, 1, 2, 0, 11, 7, 5, 9, 4, 8, 15, 14, 6, 1, 13, 2, 9, 7, 10, 6, 0, 8, 12, 4, 5, 15, 3, 11, 14, 11, 10, 15, 5, 0, 12, 14, 8, 6, 2, 3, 9, 1, 7, 13, 4};
        ESbox_B = new byte[]{8, 4, 11, 1, 3, 5, 0, 9, 2, 14, 10, 12, 13, 6, 7, 15, 0, 1, 2, 10, 4, 13, 5, 12, 9, 7, 3, 15, 11, 8, 6, 14, 14, 12, 0, 10, 9, 2, 13, 11, 7, 5, 8, 15, 3, 6, 1, 4, 7, 5, 0, 13, 11, 6, 1, 2, 3, 10, 12, 15, 4, 14, 9, 8, 2, 7, 12, 15, 9, 5, 10, 11, 1, 4, 0, 13, 6, 8, 14, 3, 8, 3, 2, 6, 4, 13, 14, 11, 12, 1, 7, 15, 10, 0, 9, 5, 5, 2, 10, 11, 9, 1, 12, 3, 7, 4, 13, 0, 6, 15, 8, 14, 0, 4, 11, 14, 8, 3, 7, 1, 10, 2, 9, 6, 15, 13, 5, 12};
        ESbox_C = new byte[]{1, 11, 12, 2, 9, 13, 0, 15, 4, 5, 8, 14, 10, 7, 6, 3, 0, 1, 7, 13, 11, 4, 5, 2, 8, 14, 15, 12, 9, 10, 6, 3, 8, 2, 5, 0, 4, 9, 15, 10, 3, 7, 12, 13, 6, 14, 1, 11, 3, 6, 0, 1, 5, 13, 10, 8, 11, 2, 9, 7, 14, 15, 12, 4, 8, 13, 11, 0, 4, 5, 1, 2, 9, 3, 12, 14, 6, 15, 10, 7, 12, 9, 11, 1, 8, 14, 2, 4, 7, 3, 6, 5, 10, 0, 15, 13, 10, 9, 6, 8, 13, 14, 2, 0, 15, 3, 5, 11, 4, 1, 12, 7, 7, 4, 0, 5, 10, 2, 15, 14, 12, 6, 1, 11, 13, 9, 3, 8};
        ESbox_D = new byte[]{15, 12, 2, 10, 6, 4, 5, 0, 7, 9, 14, 13, 1, 11, 8, 3, 11, 6, 3, 4, 12, 15, 14, 2, 7, 13, 8, 0, 5, 10, 9, 1, 1, 12, 11, 0, 15, 14, 6, 5, 10, 13, 4, 8, 9, 3, 7, 2, 1, 5, 14, 12, 10, 7, 0, 13, 6, 2, 11, 4, 9, 3, 15, 8, 0, 12, 8, 9, 13, 2, 10, 11, 7, 3, 6, 5, 4, 14, 15, 1, 8, 0, 15, 3, 2, 5, 14, 11, 1, 10, 4, 7, 12, 9, 13, 6, 3, 0, 6, 15, 1, 14, 9, 2, 13, 8, 12, 4, 11, 10, 5, 7, 1, 10, 6, 8, 15, 11, 0, 4, 12, 3, 5, 9, 7, 13, 2, 14};
        Param_Z = new byte[]{12, 4, 6, 2, 10, 5, 11, 9, 14, 8, 13, 7, 0, 3, 15, 1, 6, 8, 2, 3, 9, 10, 5, 12, 1, 14, 4, 7, 11, 13, 0, 15, 11, 3, 5, 8, 2, 15, 10, 13, 14, 1, 7, 4, 12, 9, 6, 0, 12, 8, 2, 1, 13, 4, 15, 6, 7, 0, 10, 5, 3, 14, 9, 11, 7, 15, 5, 10, 8, 1, 6, 13, 0, 9, 3, 14, 11, 4, 2, 12, 5, 13, 15, 6, 9, 2, 12, 10, 11, 7, 8, 1, 4, 3, 14, 0, 8, 14, 2, 5, 6, 9, 1, 12, 15, 4, 11, 0, 13, 10, 3, 7, 1, 7, 14, 13, 0, 5, 8, 3, 4, 15, 10, 6, 9, 12, 11, 2};
        DSbox_Test = new byte[]{4, 10, 9, 2, 13, 8, 0, 14, 6, 11, 1, 12, 7, 15, 5, 3, 14, 11, 4, 12, 6, 13, 15, 10, 2, 3, 8, 1, 0, 7, 5, 9, 5, 8, 1, 13, 10, 3, 4, 2, 14, 15, 12, 7, 6, 0, 9, 11, 7, 13, 10, 1, 0, 8, 9, 15, 14, 4, 6, 12, 11, 2, 5, 3, 6, 12, 7, 1, 5, 15, 13, 8, 4, 10, 9, 14, 0, 3, 11, 2, 4, 11, 10, 0, 7, 2, 1, 13, 3, 6, 8, 5, 9, 12, 15, 14, 13, 11, 4, 1, 3, 15, 5, 9, 0, 10, 14, 7, 6, 8, 2, 12, 1, 15, 13, 0, 5, 7, 10, 4, 9, 2, 3, 14, 6, 11, 8, 12};
        DSbox_A = new byte[]{10, 4, 5, 6, 8, 1, 3, 7, 13, 12, 14, 0, 9, 2, 11, 15, 5, 15, 4, 0, 2, 13, 11, 9, 1, 7, 6, 3, 12, 14, 10, 8, 7, 15, 12, 14, 9, 4, 1, 0, 3, 11, 5, 2, 6, 10, 8, 13, 4, 10, 7, 12, 0, 15, 2, 8, 14, 1, 6, 5, 13, 11, 9, 3, 7, 6, 4, 11, 9, 12, 2, 10, 1, 8, 0, 14, 15, 13, 3, 5, 7, 6, 2, 4, 13, 9, 15, 0, 10, 1, 5, 11, 8, 14, 12, 3, 13, 14, 4, 1, 7, 0, 5, 10, 3, 12, 8, 15, 6, 2, 9, 11, 1, 3, 10, 9, 5, 11, 4, 15, 8, 6, 7, 14, 13, 0, 2, 12};
        sBoxes = new Hashtable();
        addSBox("Default", Sbox_Default);
        addSBox("E-TEST", ESbox_Test);
        addSBox("E-A", ESbox_A);
        addSBox("E-B", ESbox_B);
        addSBox("E-C", ESbox_C);
        addSBox("E-D", ESbox_D);
        addSBox("Param-Z", Param_Z);
        addSBox("D-TEST", DSbox_Test);
        addSBox("D-A", DSbox_A);
    }

    public GOST28147Engine() {
        this.workingKey = null;
        this.S = Sbox_Default;
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(getAlgorithmName(), 178));
    }

    private void GOST28147Func(int[] r9, byte[] r10, int r11, byte[] r12, int r13) {
        int r0 = bytesToint(r10, r11);
        int r14 = bytesToint(r10, r11 + 4);
        int r1 = 7;
        if (this.forEncryption == false) goto L13;
        int r15 = 0;
    L5:
        if (r15 >= 3) goto L10;
        int r5 = 0;
    L7:
        if (r5 >= 8) goto L9;
        int r16 = r14 ^ GOST28147_mainStep(r0, r9[r5]);
        r5 = r5 + 1;
        int r7 = r0;
        r0 = r16;
        r14 = r7;
        goto L7
    L9:
        r15 = r15 + 1;
        goto L5
    L10:
        int r17 = r14;
        int r18 = r0;
    L11:
        if (r1 <= 0) goto L26;
        int r19 = r17 ^ GOST28147_mainStep(r18, r9[r1]);
        r1 = r1 - 1;
        r17 = r18;
        r18 = r19;
    L26:
        int r20 = GOST28147_mainStep(r18, r9[0]) ^ r17;
        intTobytes(r18, r12, r13);
        intTobytes(r20, r12, r13 + 4);
        return;
    L13:
        int r110 = 0;
    L14:
        if (r110 >= 8) goto L16;
        int r111 = r14 ^ GOST28147_mainStep(r0, r9[r110]);
        r110 = r110 + 1;
        int r8 = r0;
        r0 = r111;
        r14 = r8;
        goto L14
    L16:
        r17 = r14;
        r18 = r0;
        int r2 = 0;
    L17:
        if (r2 >= 3) goto L26;
        int r3 = 7;
    L19:
        if (r3 < 0) goto L25;
        if (r2 != 2) goto L24;
        if (r3 == 0) goto L25;
    L24:
        int r112 = r17 ^ GOST28147_mainStep(r18, r9[r3]);
        r3 = r3 - 1;
        r17 = r18;
        r18 = r112;
    L25:
        r2 = r2 + 1;
        goto L17
    }

    private int GOST28147_mainStep(int r2, int r3) {
        int r4 = r3 + r2;
        byte[] r1 = this.S;
        int r5 = (((((((r1[((r4 >> 0) & 15) + 0] << 0) + (r1[((r4 >> 4) & 15) + 16] << 4)) + (r1[((r4 >> 8) & 15) + 32] << 8)) + (r1[((r4 >> 12) & 15) + 48] << 12)) + (r1[((r4 >> 16) & 15) + 64] << 16)) + (r1[((r4 >> 20) & 15) + 80] << 20)) + (r1[((r4 >> 24) & 15) + 96] << 24)) + (r1[((r4 >> 28) & 15) + 112] << 28);
        return (r5 << 11) | (r5 >>> 21);
    }

    private static void addSBox(String r1, byte[] r2) {
        sBoxes.put(Strings.toUpperCase(r1), r2);
    }

    private int bytesToint(byte[] r3, int r4) {
        return ((((r3[r4 + 3] << 24) & ViewCompat.MEASURED_STATE_MASK) + ((r3[r4 + 2] << 16) & 16711680)) + ((r3[r4 + 1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK)) + (r3[r4] & 255);
    }

    private int[] generateWorkingKey(boolean r4, byte[] r5) {
        this.forEncryption = r4;
        if (r5.length != 32) goto L9;
        int[] r0 = new int[8];
        int r1 = 0;
    L5:
        if (r1 == 8) goto L7;
        r0[r1] = bytesToint(r5, r1 * 4);
        r1 = r1 + 1;
        goto L5
    L7:
        return r0;
    L9:
        throw new IllegalArgumentException("Key length invalid. Key needs to be 32 byte - 256 bit!!!");
    }

    public static byte[] getSBox(String r2) {
        byte[] r3 = (byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(sBoxes.get(Strings.toUpperCase(r2)), byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L7;
        return Arrays.clone(r3);
    L7:
        throw new IllegalArgumentException("Unknown S-Box - possible types: \"Default\", \"E-Test\", \"E-A\", \"E-B\", \"E-C\", \"E-D\", \"Param-Z\", \"D-Test\", \"D-A\".");
    }

    private void intTobytes(int r2, byte[] r3, int r4) {
        r3[r4 + 3] = (byte) (r2 >>> 24);
        r3[r4 + 2] = (byte) (r2 >>> 16);
        r3[r4 + 1] = (byte) (r2 >>> 8);
        r3[r4] = (byte) r2;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "GOST28147";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 8;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean r6, CipherParameters r7) {
        CipherParameters r8 = (CipherParameters) ZeusTransformUtils.wrapperContextForParams(r7, CipherParameters.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, ParametersWithSBox.class) == false) goto L12;
        ParametersWithSBox r0 = (ParametersWithSBox) ZeusTransformUtils.preCheckCast(r8, ParametersWithSBox.class, "com.obric.memorydata.plugin");
        byte[] r2 = r0.getSBox();
        if (r2.length != Sbox_Default.length) goto L10;
        this.S = Arrays.clone(r2);
        if (r0.getParameters() == null) goto L15;
        this.workingKey = generateWorkingKey(r6, ((KeyParameter) ZeusTransformUtils.preCheckCast(r0.getParameters(), KeyParameter.class, "com.obric.memorydata.plugin")).getKey());
    L15:
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(getAlgorithmName(), 178, r8, Utils.getPurpose(r6)));
        return;
    L10:
        throw new IllegalArgumentException("invalid S-box passed to GOST28147 init");
    L12:
        if (ZeusTransformUtils.instanceOf(r8, KeyParameter.class) == false) goto L14;
        this.workingKey = generateWorkingKey(r6, ((KeyParameter) ZeusTransformUtils.preCheckCast(r8, KeyParameter.class, "com.obric.memorydata.plugin")).getKey());
        goto L15
    L14:
        if (r8 == null) goto L15;
        throw new IllegalArgumentException("invalid parameter passed to GOST28147 init - " + r8.getClass().getName());
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] r7, int r8, byte[] r9, int r10) {
        int[] r1 = this.workingKey;
        if (r1 == null) goto L15;
        if ((r8 + 8) > r7.length) goto L13;
        if ((r10 + 8) > r9.length) goto L11;
        GOST28147Func(r1, r7, r8, r9, r10);
        return 8;
    L11:
        throw new OutputLengthException("output buffer too short");
    L13:
        throw new DataLengthException("input buffer too short");
    L15:
        throw new IllegalStateException("GOST28147 engine not initialised");
    }
}
