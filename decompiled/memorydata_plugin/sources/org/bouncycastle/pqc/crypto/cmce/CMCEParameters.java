package org.bouncycastle.pqc.crypto.cmce;

import com.obric.aikernel.core.data.IdlErrors;
import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes7.dex */
public class CMCEParameters implements CipherParameters {
    public static final CMCEParameters mceliece348864fr3 = null;
    public static final CMCEParameters mceliece348864r3 = null;
    public static final CMCEParameters mceliece460896fr3 = null;
    public static final CMCEParameters mceliece460896r3 = null;
    public static final CMCEParameters mceliece6688128fr3 = null;
    public static final CMCEParameters mceliece6688128r3 = null;
    public static final CMCEParameters mceliece6960119fr3 = null;
    public static final CMCEParameters mceliece6960119r3 = null;
    public static final CMCEParameters mceliece8192128fr3 = null;
    public static final CMCEParameters mceliece8192128r3 = null;
    private static int[] poly3488;
    private static int[] poly4608;
    private static int[] poly6688;
    private static int[] poly6960;
    private static int[] poly8192;
    private final int defaultKeySize;
    private final CMCEEngine engine;
    private final int m;
    private final int n;
    private final String name;
    private final int t;
    private final boolean usePivots;

    static {
        poly3488 = new int[]{3, 1, 0};
        poly4608 = new int[]{10, 9, 6, 0};
        poly6688 = new int[]{7, 2, 1, 0};
        poly6960 = new int[]{8, 0};
        poly8192 = new int[]{7, 2, 1, 0};
        mceliece348864r3 = new CMCEParameters("mceliece348864", 12, 3488, 64, poly3488, false, 128);
        mceliece348864fr3 = new CMCEParameters("mceliece348864f", 12, 3488, 64, poly3488, true, 128);
        mceliece460896r3 = new CMCEParameters("mceliece460896", 13, 4608, 96, poly4608, false, 192);
        mceliece460896fr3 = new CMCEParameters("mceliece460896f", 13, 4608, 96, poly4608, true, 192);
        mceliece6688128r3 = new CMCEParameters("mceliece6688128", 13, 6688, 128, poly6688, false, 256);
        mceliece6688128fr3 = new CMCEParameters("mceliece6688128f", 13, 6688, 128, poly6688, true, 256);
        mceliece6960119r3 = new CMCEParameters("mceliece6960119", 13, 6960, IdlErrors.E_RejectInferDeviceOverheat, poly6960, false, 256);
        mceliece6960119fr3 = new CMCEParameters("mceliece6960119f", 13, 6960, IdlErrors.E_RejectInferDeviceOverheat, poly6960, true, 256);
        mceliece8192128r3 = new CMCEParameters("mceliece8192128", 13, 8192, 128, poly8192, false, 256);
        mceliece8192128fr3 = new CMCEParameters("mceliece8192128f", 13, 8192, 128, poly8192, true, 256);
    }

    private CMCEParameters(String r8, int r9, int r10, int r11, int[] r12, boolean r13, int r14) {
        this.name = r8;
        this.m = r9;
        this.n = r10;
        this.t = r11;
        this.usePivots = r13;
        this.defaultKeySize = r14;
        this.engine = new CMCEEngine(r9, r10, r11, r12, r13, r14);
    }

    CMCEEngine getEngine() {
        return this.engine;
    }

    public String getName() {
        return this.name;
    }

    public int getT() {
        return this.t;
    }
}
