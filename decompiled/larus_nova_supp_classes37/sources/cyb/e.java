package cyb;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.opmonitor.model.OPMonitorCode;
import com.ss.android.lark.opmonitor.service.OPMonitor;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/opmonitor/config/TraceFilter;", "Lcom/ss/android/lark/opmonitor/config/IMonitorFilter;", "<init>", "()V", "monitorDomain", "", "", "monitorDomainPrefix", "monitorId", "eventName", "filter", "", "monitor", "Lcom/ss/android/lark/opmonitor/service/OPMonitor;", "opmonitor_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class e {

    @SerializedName("event_name")
    @Expose
    private final List<String> eventName;

    @SerializedName("monitor_domain")
    @Expose
    private final List<String> monitorDomain;

    @SerializedName("monitor_domain_prefix")
    @Expose
    private final List<String> monitorDomainPrefix;

    @SerializedName("monitor_id")
    @Expose
    private final List<String> monitorId;

    public e() {
        this.monitorDomain = CollectionsKt.emptyList();
        this.monitorDomainPrefix = CollectionsKt.emptyList();
        this.monitorId = CollectionsKt.emptyList();
        this.eventName = CollectionsKt.emptyList();
    }

    public final boolean a(OPMonitor r9) {
        Intrinsics.checkNotNullParameter(r9, "monitor");
        OPMonitorCode r0 = r9.getMonitorCode();
        if (r0 == null) goto L22;
        Iterator<T> r3 = this.monitorDomain.iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        String r4 = (String) r3.next();
        if (Intrinsics.areEqual(r0.domain, r4) == false) goto L6;
        return true;
    L10:
        Iterator<T> r5 = this.monitorDomainPrefix.iterator();
    L12:
        if (r5.hasNext() == false) goto L16;
        String r6 = (String) r5.next();
        if (StringsKt.startsWith$default(r0.domain, r6, false, 2, null) == false) goto L12;
        return true;
    L16:
        Iterator<T> r7 = this.monitorId.iterator();
    L18:
        if (r7.hasNext() == false) goto L22;
        String r8 = (String) r7.next();
        if (StringsKt.contains$default(r0.ID, r8, false, 2, null) == false) goto L18;
        return true;
    L22:
        String r10 = r9.getName();
        if (r10 == null) goto L30;
        Iterator<T> r1 = this.eventName.iterator();
    L26:
        if (r1.hasNext() == false) goto L30;
        if (Intrinsics.areEqual(r10, (String) r1.next()) == false) goto L26;
        return true;
    L30:
        return false;
    }
}
