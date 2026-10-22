package hq9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/larus/platform/model/AudioStreamPlayerMechanismConfig;", "", "timeoutProtect", "", "timeoutSec", "timeoutSecPerChunk", "timeoutWrite", "<init>", "(JJJJ)V", "getTimeoutProtect", "()J", "getTimeoutSec", "getTimeoutSecPerChunk", "getTimeoutWrite", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class s {

    @SerializedName("timeout_protect")
    private final long timeoutProtect;

    @SerializedName("timeout_sec")
    private final long timeoutSec;

    @SerializedName("timeout_sec_per_chunk")
    private final long timeoutSecPerChunk;

    @SerializedName("timeout_write")
    private final long timeoutWrite;

    public s() {
        this(0);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof s) == true) goto L8;
        return false;
    L8:
        s r9 = (s) r8;
        if (this.timeoutProtect == r9.timeoutProtect) goto L12;
        return false;
    L12:
        if (this.timeoutSec == r9.timeoutSec) goto L15;
        return false;
    L15:
        if (this.timeoutSecPerChunk == r9.timeoutSecPerChunk) goto L18;
        return false;
    L18:
        if (this.timeoutWrite == r9.timeoutWrite) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        long r0 = this.timeoutProtect;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.timeoutSec;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r4 = this.timeoutSecPerChunk;
        int r5 = (r2 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        long r6 = this.timeoutWrite;
        return r5 + ((int) (r6 ^ (r6 >>> 32)));
    }

    public final String toString() {
        return "AudioStreamPlayerMechanismConfig(timeoutProtect=" + this.timeoutProtect + ", timeoutSec=" + this.timeoutSec + ", timeoutSecPerChunk=" + this.timeoutSecPerChunk + ", timeoutWrite=" + this.timeoutWrite + ')';
    }

    public final long a() {
        return this.timeoutProtect;
    }

    public final long b() {
        return this.timeoutSec;
    }

    public final long c() {
        return this.timeoutSecPerChunk;
    }

    public final long d() {
        return this.timeoutWrite;
    }

    public s(int r3) {
        this.timeoutProtect = 180;
        this.timeoutSec = 60;
        this.timeoutSecPerChunk = 60;
        this.timeoutWrite = 60;
    }
}
