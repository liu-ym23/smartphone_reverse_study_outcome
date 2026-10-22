package org.bouncycastle.pqc.crypto.sike;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.ss.bduploader.BDAbstractUpload;

/* JADX INFO: loaded from: classes7.dex */
public class SIKEParameters {
    public static final SIKEParameters sikep434 = null;
    public static final SIKEParameters sikep434_compressed = null;
    public static final SIKEParameters sikep503 = null;
    public static final SIKEParameters sikep503_compressed = null;
    public static final SIKEParameters sikep610 = null;
    public static final SIKEParameters sikep610_compressed = null;
    public static final SIKEParameters sikep751 = null;
    public static final SIKEParameters sikep751_compressed = null;
    private final SIKEEngine engine;
    private final String name;

    static {
        sikep434 = new SIKEParameters(BDAbstractUpload.KeyIsRetryStatesOption, false, "sikep434");
        sikep503 = new SIKEParameters(TypedValues.PositionType.TYPE_PERCENT_WIDTH, false, "sikep503");
        sikep610 = new SIKEParameters(TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, false, "sikep610");
        sikep751 = new SIKEParameters(751, false, "sikep751");
        sikep434_compressed = new SIKEParameters(BDAbstractUpload.KeyIsRetryStatesOption, true, "sikep434_compressed");
        sikep503_compressed = new SIKEParameters(TypedValues.PositionType.TYPE_PERCENT_WIDTH, true, "sikep503_compressed");
        sikep610_compressed = new SIKEParameters(TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, true, "sikep610_compressed");
        sikep751_compressed = new SIKEParameters(751, true, "sikep751_compressed");
    }

    private SIKEParameters(int r1, boolean r2, String r3) {
        this.name = r3;
        this.engine = new SIKEEngine(r1, r2);
    }

    public String getName() {
        return this.name;
    }
}
