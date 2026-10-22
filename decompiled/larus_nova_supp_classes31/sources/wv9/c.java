package wv9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/larus/settings/provider/realtimecall/RealtimeCallForegroundServiceOptConfig;", "", "enablePlaybackForegroundService", "", "enableServiceTypeExpandAndroid11", "<init>", "(ZZ)V", "getEnablePlaybackForegroundService", "()Z", "getEnableServiceTypeExpandAndroid11", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class c {

    @SerializedName("enable_playback_foreground_service")
    private final boolean enablePlaybackForegroundService;

    @SerializedName("enable_service_type_expand_to_android_11")
    private final boolean enableServiceTypeExpandAndroid11;

    public c() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (this.enablePlaybackForegroundService == r6.enablePlaybackForegroundService) goto L12;
        return false;
    L12:
        if (this.enableServiceTypeExpandAndroid11 == r6.enableServiceTypeExpandAndroid11) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.enablePlaybackForegroundService == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.enableServiceTypeExpandAndroid11 == true) goto L11;
        r1 = 1237;
    L11:
        return r2 + r1;
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "RealtimeCallForegroundServiceOptConfig(enablePlaybackForegroundService=" + this.enablePlaybackForegroundService + ", enableServiceTypeExpandAndroid11=" + this.enableServiceTypeExpandAndroid11 + ')';
    }

    public final boolean a() {
        return this.enablePlaybackForegroundService;
    }

    public final boolean b() {
        return this.enableServiceTypeExpandAndroid11;
    }

    public c(int r1) {
        this.enablePlaybackForegroundService = true;
        this.enableServiceTypeExpandAndroid11 = true;
    }
}
