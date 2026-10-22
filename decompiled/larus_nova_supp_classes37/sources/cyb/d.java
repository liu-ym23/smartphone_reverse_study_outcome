package cyb;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.opmonitor.service.OPMonitor;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\u0015R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001e\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR \u0010 \u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001f¨\u0006("}, d2 = {"Lcom/ss/android/lark/opmonitor/config/TraceConfig;", "Lcom/ss/android/lark/opmonitor/config/IMonitorFilter;", "<init>", "()V", "logEnabled", "", "getLogEnabled", "()Z", "setLogEnabled", "(Z)V", "reportEnabled", "getReportEnabled", "setReportEnabled", "batchBlackListEnabled", "getBatchBlackListEnabled", "setBatchBlackListEnabled", "batchWhiteListEnabled", "getBatchWhiteListEnabled", "setBatchWhiteListEnabled", "bizBlackList", "", "", "getBizBlackList", "()Ljava/util/List;", "setBizBlackList", "(Ljava/util/List;)V", "blackFilter", "Lcom/ss/android/lark/opmonitor/config/TraceFilter;", "getBlackFilter", "()Lcom/ss/android/lark/opmonitor/config/TraceFilter;", "setBlackFilter", "(Lcom/ss/android/lark/opmonitor/config/TraceFilter;)V", "whiteFilter", "getWhiteFilter", "setWhiteFilter", "filter", "monitor", "Lcom/ss/android/lark/opmonitor/service/OPMonitor;", "isInBizBlackList", "bizName", "opmonitor_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class d {

    @SerializedName("batchBlackListEnabled")
    @Expose
    private boolean batchBlackListEnabled;

    @SerializedName("batchWhiteListEnabled")
    @Expose
    private boolean batchWhiteListEnabled;

    @SerializedName("bizBlackList")
    @Expose
    private List<String> bizBlackList;

    @SerializedName("batchBlackList")
    @Expose
    private e blackFilter;

    @SerializedName("logEnabled")
    @Expose
    private boolean logEnabled;

    @SerializedName("reportEnabled")
    @Expose
    private boolean reportEnabled;

    @SerializedName("batchWhiteList")
    @Expose
    private e whiteFilter;

    public d() {
        this.bizBlackList = new ArrayList();
    }

    public final boolean b() {
        return this.logEnabled;
    }

    public final boolean c() {
        return this.reportEnabled;
    }

    public final boolean a(OPMonitor r5) {
        Intrinsics.checkNotNullParameter(r5, "monitor");
        if (this.reportEnabled == true) goto L5;
        return false;
    L5:
        boolean r0 = this.batchBlackListEnabled;
        if (r0 == false) goto L8;
    L10:
        if (r0 == false) goto L18;
        e r1 = this.blackFilter;
        if (r1 == null) goto L14;
        boolean r2 = r1.a(r5);
    L15:
        if (r2 == false) goto L18;
        return false;
    L14:
        r2 = false;
    L18:
        if (this.batchWhiteListEnabled == false) goto L23;
        e r3 = this.whiteFilter;
        if (r3 != null) goto L22;
        return false;
    L22:
        return r3.a(r5);
    L23:
        return true;
    L8:
        if (this.batchWhiteListEnabled == true) goto L10;
        return true;
    }

    public final boolean d(String r2) {
        if (r2 != null) goto L6;
        return true;
    L6:
        return this.bizBlackList.contains(r2);
    }
}
