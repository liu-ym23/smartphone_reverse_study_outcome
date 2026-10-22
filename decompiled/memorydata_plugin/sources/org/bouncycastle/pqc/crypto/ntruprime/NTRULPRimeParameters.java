package org.bouncycastle.pqc.crypto.ntruprime;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.ss.bduploader.BDVideoUploaderBase;
import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes7.dex */
public class NTRULPRimeParameters implements CipherParameters {
    public static final NTRULPRimeParameters ntrulpr1013 = null;
    public static final NTRULPRimeParameters ntrulpr1277 = null;
    public static final NTRULPRimeParameters ntrulpr653 = null;
    public static final NTRULPRimeParameters ntrulpr761 = null;
    public static final NTRULPRimeParameters ntrulpr857 = null;
    public static final NTRULPRimeParameters ntrulpr953 = null;
    private final int delta;
    private final String name;
    private final int p;
    private final int privateKeyBytes;
    private final int publicKeyBytes;
    private final int q;
    private final int roundedPolynomialBytes;
    private final int sharedKeyBytes;
    private final int tau0;
    private final int tau1;
    private final int tau2;
    private final int tau3;
    private final int w;

    static {
        ntrulpr653 = new NTRULPRimeParameters("ntrulpr653", 653, 4621, 252, 289, 2175, 113, 2031, 290, 865, 897, 1125, 16);
        ntrulpr761 = new NTRULPRimeParameters("ntrulpr761", 761, 4591, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 292, 2156, 114, 2007, 287, 1007, 1039, 1294, 16);
        ntrulpr857 = new NTRULPRimeParameters("ntrulpr857", 857, 5167, 281, 329, 2433, 101, 2265, 324, 1152, 1184, 1463, 16);
        ntrulpr953 = new NTRULPRimeParameters("ntrulpr953", 953, 6343, 345, 404, 2997, 82, 2798, 400, 1317, 1349, 1652, 24);
        ntrulpr1013 = new NTRULPRimeParameters("ntrulpr1013", 1013, 7177, 392, BDVideoUploaderBase.KeyIsDynamicSliceHighSize, 3367, 73, 3143, BDVideoUploaderBase.KeyIsDynamicSliceNormalSize, 1423, 1455, 1773, 24);
        ntrulpr1277 = new NTRULPRimeParameters("ntrulpr1277", 1277, 7879, 429, 502, 3724, 66, 3469, 496, 1815, 1847, 2231, 32);
    }

    private NTRULPRimeParameters(String r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9, int r10, int r11, int r12, int r13) {
        this.name = r1;
        this.p = r2;
        this.q = r3;
        this.w = r4;
        this.delta = r5;
        this.tau0 = r6;
        this.tau1 = r7;
        this.tau2 = r8;
        this.tau3 = r9;
        this.roundedPolynomialBytes = r10;
        this.publicKeyBytes = r11;
        this.privateKeyBytes = r12;
        this.sharedKeyBytes = r13;
    }

    public String getName() {
        return this.name;
    }

    public int getPrivateKeyBytes() {
        return this.privateKeyBytes;
    }

    public int getPublicKeyBytes() {
        return this.publicKeyBytes;
    }
}
