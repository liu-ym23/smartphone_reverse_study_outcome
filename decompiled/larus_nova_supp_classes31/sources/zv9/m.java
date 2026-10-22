package zv9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\bHÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006#"}, d2 = {"Lcom/larus/settings/provider/security/OfflineDLPConfig;", "", "enable", "", "sampleRate", "", "usePPE", "ppeEnv", "", "<init>", "(ZJZLjava/lang/String;)V", "getEnable", "()Z", "setEnable", "(Z)V", "getSampleRate", "()J", "setSampleRate", "(J)V", "getUsePPE", "setUsePPE", "getPpeEnv", "()Ljava/lang/String;", "setPpeEnv", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class m {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("ppe_env")
    private String ppeEnv;

    @SerializedName("sample_rate")
    private long sampleRate;

    @SerializedName("use_ppe")
    private boolean usePPE;

    public m() {
        this(0);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof m) == true) goto L8;
        return false;
    L8:
        m r9 = (m) r8;
        if (this.enable == r9.enable) goto L12;
        return false;
    L12:
        if (this.sampleRate == r9.sampleRate) goto L15;
        return false;
    L15:
        if (this.usePPE == r9.usePPE) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.ppeEnv, r9.ppeEnv) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.enable == false) goto L5;
        int r0 = 1231;
    L6:
        long r3 = this.sampleRate;
        int r2 = ((r0 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        if (this.usePPE == true) goto L10;
        r1 = 1237;
    L10:
        int r4 = (r2 + r1) * 31;
        String r5 = this.ppeEnv;
        if (r5 != null) goto L13;
        int r6 = 0;
    L15:
        return r4 + r6;
    L13:
        r6 = r5.hashCode();
        goto L15
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "OfflineDLPConfig(enable=" + this.enable + ", sampleRate=" + this.sampleRate + ", usePPE=" + this.usePPE + ", ppeEnv=" + this.ppeEnv + ')';
    }

    public m(int r3) {
        this.enable = true;
        this.sampleRate = 2000;
        this.usePPE = false;
        this.ppeEnv = "ppe_dola_dlp";
    }
}
