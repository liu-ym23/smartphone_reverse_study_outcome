package vt9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/larus/settings/provider/audio/RTCConnectionOpt;", "", "clickDebounce", "", "connectTimeout", "<init>", "(II)V", "getClickDebounce", "()I", "setClickDebounce", "(I)V", "getConnectTimeout", "setConnectTimeout", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class e0 {

    @SerializedName("realtime_call_start_debounce_interval")
    private int clickDebounce;

    @SerializedName("connect_timeout")
    private int connectTimeout;

    public e0() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e0) == true) goto L8;
        return false;
    L8:
        e0 r6 = (e0) r5;
        if (this.clickDebounce == r6.clickDebounce) goto L12;
        return false;
    L12:
        if (this.connectTimeout == r6.connectTimeout) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.clickDebounce * 31) + this.connectTimeout;
    }

    public final String toString() {
        return "RTCConnectionOpt(clickDebounce=" + this.clickDebounce + ", connectTimeout=" + this.connectTimeout + ')';
    }

    public final int a() {
        return this.clickDebounce;
    }

    public final int b() {
        return this.connectTimeout;
    }

    public e0(int r1) {
        this.clickDebounce = 500;
        this.connectTimeout = 5;
    }
}
