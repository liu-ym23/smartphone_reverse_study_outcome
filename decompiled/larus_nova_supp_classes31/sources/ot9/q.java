package ot9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u00120\b\u0002\u0010\b\u001a*\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\tj\u0014\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u0001`\f\u0012 \b\u0002\u0010\r\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u000ej\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u0001`\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J1\u0010 \u001a*\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\tj\u0014\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u0001`\fHÆ\u0003J!\u0010!\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u000ej\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u0001`\u000fHÆ\u0003J\u0085\u0001\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u000620\b\u0002\u0010\b\u001a*\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\tj\u0014\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u0001`\f2 \b\u0002\u0010\r\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u000ej\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u0001`\u000fHÆ\u0001J\u0013\u0010#\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\nHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R>\u0010\b\u001a*\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\tj\u0014\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u0001`\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R.\u0010\r\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u000ej\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u0001`\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006("}, d2 = {"Lcom/larus/settings/opt/PageMonitorConfig;", "", "enable", "", "enablePageLoadMonitor", "scanPageTimeout", "", "scanPageInterval", "pageMonitorConfig", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "ignoreViewList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "<init>", "(ZZJJLjava/util/HashMap;Ljava/util/ArrayList;)V", "getEnable", "()Z", "getEnablePageLoadMonitor", "getScanPageTimeout", "()J", "getScanPageInterval", "getPageMonitorConfig", "()Ljava/util/HashMap;", "getIgnoreViewList", "()Ljava/util/ArrayList;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class q {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("enable_page_load_monitor")
    private final boolean enablePageLoadMonitor;

    @SerializedName("ignore_view")
    private final ArrayList<String> ignoreViewList;

    @SerializedName("network_path_config")
    private final HashMap<String, Double> pageMonitorConfig;

    @SerializedName("scan_page_interval")
    private final long scanPageInterval;

    @SerializedName("scan_page_timeout")
    private final long scanPageTimeout;

    public q() {
        this(null);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof q) == true) goto L8;
        return false;
    L8:
        q r9 = (q) r8;
        if (this.enable == r9.enable) goto L12;
        return false;
    L12:
        if (this.enablePageLoadMonitor == r9.enablePageLoadMonitor) goto L15;
        return false;
    L15:
        if (this.scanPageTimeout == r9.scanPageTimeout) goto L18;
        return false;
    L18:
        if (this.scanPageInterval == r9.scanPageInterval) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.pageMonitorConfig, r9.pageMonitorConfig) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.ignoreViewList, r9.ignoreViewList) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.enable == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.enablePageLoadMonitor == true) goto L10;
        r1 = 1237;
    L10:
        int r3 = (r2 + r1) * 31;
        long r4 = this.scanPageTimeout;
        int r5 = (r3 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        long r6 = this.scanPageInterval;
        int r7 = (r5 + ((int) (r6 ^ (r6 >>> 32)))) * 31;
        HashMap<String, Double> r8 = this.pageMonitorConfig;
        int r9 = 0;
        if (r8 != null) goto L13;
        int r10 = 0;
    L14:
        int r11 = (r7 + r10) * 31;
        ArrayList<String> r12 = this.ignoreViewList;
        if (r12 == null) goto L19;
        r9 = r12.hashCode();
    L19:
        return r11 + r9;
    L13:
        r10 = r8.hashCode();
        goto L14
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "PageMonitorConfig(enable=" + this.enable + ", enablePageLoadMonitor=" + this.enablePageLoadMonitor + ", scanPageTimeout=" + this.scanPageTimeout + ", scanPageInterval=" + this.scanPageInterval + ", pageMonitorConfig=" + this.pageMonitorConfig + ", ignoreViewList=" + this.ignoreViewList + ')';
    }

    public q(Object r4) {
        HashMap<String, Double> r5 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("com.larus.bmhome.chat.ChatActivity", Double.valueOf(0.17d))});
        ArrayList<String> r0 = new ArrayList();
        this.enable = false;
        this.enablePageLoadMonitor = false;
        this.scanPageTimeout = 10000;
        this.scanPageInterval = 100;
        this.pageMonitorConfig = r5;
        this.ignoreViewList = r0;
    }
}
