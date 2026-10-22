package org.bouncycastle.pqc.crypto.bike;

import com.obric.cae.userAware.WifiScanSceneType;
import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes7.dex */
public class BIKEParameters implements CipherParameters {
    public static final BIKEParameters bike128 = null;
    public static final BIKEParameters bike192 = null;
    public static final BIKEParameters bike256 = null;
    private BIKEEngine bikeEngine;
    private final int defaultKeySize;
    private int l;
    private String name;
    private int nbIter;
    private int r;
    private int t;
    private int tau;
    private int w;

    static {
        bike128 = new BIKEParameters("bike128", 12323, 142, 134, 256, 5, 3, 128);
        bike192 = new BIKEParameters("bike192", 24659, 206, WifiScanSceneType.HAR_END, 256, 5, 3, 192);
        bike256 = new BIKEParameters("bike256", 40973, 274, 264, 256, 5, 3, 256);
    }

    private BIKEParameters(String r8, int r9, int r10, int r11, int r12, int r13, int r14, int r15) {
        this.name = r8;
        this.r = r9;
        this.w = r10;
        this.t = r11;
        this.l = r12;
        this.nbIter = r13;
        this.tau = r14;
        this.defaultKeySize = r15;
        this.bikeEngine = new BIKEEngine(r9, r10, r11, r12, r13, r14);
    }

    public String getName() {
        return this.name;
    }

    public int getRByte() {
        return (this.r + 7) / 8;
    }
}
