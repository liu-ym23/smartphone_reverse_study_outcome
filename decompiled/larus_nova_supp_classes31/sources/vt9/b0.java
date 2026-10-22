package vt9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/larus/settings/provider/audio/LoudnessConfig;", "", "targetLufs", "", "doraLufs", "loudNormAlgoType", "", "<init>", "(FFI)V", "getTargetLufs", "()F", "getDoraLufs", "getLoudNormAlgoType", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class b0 {

    @SerializedName("dora_lufs")
    private final float doraLufs;

    @SerializedName("loud_norm_algo_type")
    private final int loudNormAlgoType;

    @SerializedName("target_lufs")
    private final float targetLufs;

    public b0() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b0) == true) goto L8;
        return false;
    L8:
        b0 r6 = (b0) r5;
        if (Float.compare(this.targetLufs, r6.targetLufs) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.doraLufs, r6.doraLufs) == 0) goto L15;
        return false;
    L15:
        if (this.loudNormAlgoType == r6.loudNormAlgoType) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((Float.floatToIntBits(this.targetLufs) * 31) + Float.floatToIntBits(this.doraLufs)) * 31) + this.loudNormAlgoType;
    }

    public final String toString() {
        return "LoudnessConfig(targetLufs=" + this.targetLufs + ", doraLufs=" + this.doraLufs + ", loudNormAlgoType=" + this.loudNormAlgoType + ')';
    }

    public final float a() {
        return this.doraLufs;
    }

    public final int b() {
        return this.loudNormAlgoType;
    }

    public final float c() {
        return this.targetLufs;
    }

    public b0(int r1) {
        this.targetLufs = -12.0f;
        this.doraLufs = -12.0f;
        this.loudNormAlgoType = 1;
    }
}
