package org.bouncycastle.pqc.crypto.hqc;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.obric.aikernel.core.data.IdlErrors;
import com.obric.cae.userAware.WifiScanSceneType;
import com.obric.cae.userAware.datacollection.AwareStateListener;
import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes7.dex */
public class HQCParameters implements CipherParameters {
    public static final HQCParameters hqc128 = null;
    public static final HQCParameters hqc192 = null;
    public static final HQCParameters hqc256 = null;
    private int delta;
    private int fft;
    private int g;
    private int[] generatorPoly;
    private HQCEngine hqcEngine;
    private int k;
    private int n;
    private int n1;
    private int n2;
    private final String name;
    private int utilRejectionThreshold;
    private int w;
    private int we;
    private int wr;

    static {
        hqc128 = new HQCParameters("hqc-128", 17669, 46, 384, 16, 31, 15, 66, 75, 75, 16767881, 4, new int[]{89, 69, 153, 116, 176, 117, 111, 75, 73, 233, 242, 233, 65, 210, 21, 139, 103, 173, 67, 118, 105, 210, 174, 110, 74, 69, 228, 82, 255, 181, 1});
        hqc192 = new HQCParameters("hqc-192", 35851, 56, 640, 24, 33, 16, 100, 114, 114, 16742417, 5, new int[]{45, 216, 239, 24, 253, 104, 27, 40, 107, 50, 163, 210, 227, 134, 224, 158, IdlErrors.E_RejectInferDeviceOverheat, 13, 158, 1, 238, 164, 82, 43, 15, 232, 246, 142, 50, 189, 29, 232, 1});
        hqc256 = new HQCParameters("hqc-256", 57637, 90, 640, 32, 59, 29, 131, 149, 149, 16772367, 5, new int[]{49, 167, 49, 39, 200, 121, 124, 91, 240, 63, 148, 71, AwareStateListener.DEFAULT_POI_WALK_STEP_THRESHOLD, 123, 87, 101, 32, 215, 159, 71, 201, 115, 97, 210, 186, 183, 141, 217, 123, 12, 31, 243, SubsamplingScaleImageView.ORIENTATION_180, 219, 152, 239, 99, 141, 4, 246, 191, 144, 8, 232, 47, 27, 141, 178, 130, 64, 124, 47, 39, 188, 216, 48, WifiScanSceneType.HAR_END, 187, 1});
    }

    private HQCParameters(String r16, int r17, int r18, int r19, int r20, int r21, int r22, int r23, int r24, int r25, int r26, int r27, int[] r28) {
        this.name = r16;
        this.n = r17;
        this.n1 = r18;
        this.n2 = r19;
        this.k = r20;
        this.delta = r22;
        this.w = r23;
        this.wr = r24;
        this.we = r25;
        this.generatorPoly = r28;
        this.g = r21;
        this.utilRejectionThreshold = r26;
        this.fft = r27;
        this.hqcEngine = new HQCEngine(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28);
    }

    public String getName() {
        return this.name;
    }
}
