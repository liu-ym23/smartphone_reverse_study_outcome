package org.bouncycastle.pqc.crypto.frodo;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.jvm.internal.ShortCompanionObject;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Xof;
import org.bouncycastle.crypto.digests.SHAKEDigest;

/* JADX INFO: loaded from: classes7.dex */
public class FrodoParameters implements CipherParameters {
    private static final short[] cdf_table1344 = null;
    private static final short[] cdf_table640 = null;
    private static final short[] cdf_table976 = null;
    public static final FrodoParameters frodokem1344aes = null;
    public static final FrodoParameters frodokem1344shake = null;
    public static final FrodoParameters frodokem640aes = null;
    public static final FrodoParameters frodokem640shake = null;
    public static final FrodoParameters frodokem976aes = null;
    public static final FrodoParameters frodokem976shake = null;
    private final int B;
    private final int D;
    private final int defaultKeySize;
    private final FrodoEngine engine;
    private final int n;
    private final String name;

    static {
        short[] r0 = {4643, 13363, 20579, 25843, 29227, 31145, 32103, 32525, 32689, 32745, 32762, 32766, ShortCompanionObject.MAX_VALUE};
        cdf_table640 = r0;
        short[] r10 = {5638, 15915, 23689, 28571, 31116, 32217, 32613, 32731, 32760, 32766, ShortCompanionObject.MAX_VALUE};
        cdf_table976 = r10;
        short[] r11 = {9142, 23462, 30338, 32361, 32725, 32765, ShortCompanionObject.MAX_VALUE};
        cdf_table1344 = r11;
        frodokem640aes = new FrodoParameters("frodokem640aes", 640, 15, 2, r0, new SHAKEDigest(128), new FrodoMatrixGenerator.Aes128MatrixGenerator(640, 32768));
        frodokem640shake = new FrodoParameters("frodokem640shake", 640, 15, 2, r0, new SHAKEDigest(128), new FrodoMatrixGenerator.Shake128MatrixGenerator(640, 32768));
        frodokem976aes = new FrodoParameters("frodokem976aes", 976, 16, 3, r10, new SHAKEDigest(256), new FrodoMatrixGenerator.Aes128MatrixGenerator(976, 65536));
        frodokem976shake = new FrodoParameters("frodokem976shake", 976, 16, 3, r10, new SHAKEDigest(256), new FrodoMatrixGenerator.Shake128MatrixGenerator(976, 65536));
        frodokem1344aes = new FrodoParameters("frodokem1344aes", 1344, 16, 4, r11, new SHAKEDigest(256), new FrodoMatrixGenerator.Aes128MatrixGenerator(1344, 65536));
        frodokem1344shake = new FrodoParameters("frodokem1344shake", 1344, 16, 4, r11, new SHAKEDigest(256), new FrodoMatrixGenerator.Shake128MatrixGenerator(1344, 65536));
    }

    private FrodoParameters(String r8, int r9, int r10, int r11, short[] r12, Xof r13, FrodoMatrixGenerator r14) {
        Xof r5 = (Xof) ZeusTransformUtils.wrapperContextForParams(r13, Xof.class, "com.obric.memorydata.plugin");
        this.name = r8;
        this.n = r9;
        this.D = r10;
        this.B = r11;
        this.defaultKeySize = (r11 * 8) * 8;
        this.engine = new FrodoEngine(r9, r10, r11, r12, r5, r14);
    }

    public String getName() {
        return this.name;
    }
}
