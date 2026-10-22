package com.ss.android.lark.opmonitor.trace;

import android.os.Trace;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.opmonitor.model.OPMonitorCode;
import com.ss.android.lark.opmonitor.model.OPMonitorLevel;
import com.ss.android.lark.opmonitor.service.OPMonitor;
import com.ss.android.lark.optrace.api.ITracing;
import com.ss.android.lark.optrace.api.TracingCoreSpan;
import com.ss.android.lark.optrace.extension.TracingExtension;
import com.ss.android.lark.optrace.extension.TracingExtensionEnum;
import com.ss.android.lark.optrace.impl.TracingSpanImpl;
import com.ss.android.lark.picker.base.view.ItemViewType;
import fyb.e;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 G2\u00020\u00012\u00020\u0002:\u0001GB\t\b\u0016¢\u0006\u0004\b\u0003\u0010\u0004B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0003\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\tJ\u0006\u0010\u001a\u001a\u00020\u0006J\u0006\u0010\u001b\u001a\u00020\u0001J\b\u0010\u001c\u001a\u00020\u0006H\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u001c\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0012\u0010%\u001a\u00020 2\b\u0010&\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010'\u001a\u00020\u001e2\b\u0010(\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010)\u001a\u00020\u001e2\b\u0010(\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010*\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010+\u001a\u00020 2\b\u0010,\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010-\u001a\u00020 H\u0016J;\u0010.\u001a\u00020 \"\n\b\u0000\u0010/*\u0004\u0018\u0001002\b\u0010.\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u0002H/2\u000e\u00103\u001a\n\u0012\u0004\u0012\u0002H/\u0018\u000104H\u0016¢\u0006\u0002\u00105J)\u00106\u001a\u00020 2\u0006\u00107\u001a\u00020\u00062\u0012\u00108\u001a\n\u0012\u0006\b\u0001\u0012\u00020009\"\u000200H\u0016¢\u0006\u0002\u0010:J)\u0010;\u001a\u00020 2\u0006\u00107\u001a\u00020\u00062\u0012\u00108\u001a\n\u0012\u0006\b\u0001\u0012\u00020009\"\u000200H\u0016¢\u0006\u0002\u0010:J)\u0010<\u001a\u00020 2\u0006\u00107\u001a\u00020\u00062\u0012\u00108\u001a\n\u0012\u0006\b\u0001\u0012\u00020009\"\u000200H\u0016¢\u0006\u0002\u0010:J)\u0010=\u001a\u00020 2\u0006\u00107\u001a\u00020\u00062\u0012\u00108\u001a\n\u0012\u0006\b\u0001\u0012\u00020009\"\u000200H\u0016¢\u0006\u0002\u0010:J\b\u0010>\u001a\u00020\u0001H\u0017J\b\u0010?\u001a\u00020\u0000H\u0016J\u000e\u0010?\u001a\u00020\u00002\u0006\u0010@\u001a\u00020\u0006J\u0010\u0010A\u001a\u00020 2\u0006\u0010B\u001a\u00020CH\u0016J\u0010\u0010D\u001a\u00020 2\u0006\u0010B\u001a\u00020CH\u0016J\u0010\u0010E\u001a\u00020 2\b\u0010F\u001a\u0004\u0018\u00010CR\u0012\u0010\n\u001a\u00020\u00018\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016¨\u0006H"}, d2 = {"Lcom/ss/android/lark/opmonitor/trace/OPTrace;", "Lcom/ss/android/lark/optrace/api/TracingCoreSpan;", "Lcom/ss/android/lark/opmonitor/service/AbsMonitorService;", "<init>", "()V", "traceId", "", "(Ljava/lang/String;)V", "tracingCoreSpan", "(Lcom/ss/android/lark/optrace/api/TracingCoreSpan;)V", "mBase", "monitors", "", "getMonitors", "()Ljava/util/List;", "setMonitors", "(Ljava/util/List;)V", "finished", "", "getFinished", "()Z", "setFinished", "(Z)V", "batchEnabled", "getBatchEnabled", "setBatchEnabled", "serialize", "getTracingSpanImpl", "getTracingID", "createTime", "", "addExtension", "", "extensionEnum", "Lcom/ss/android/lark/optrace/extension/TracingExtensionEnum;", "extension", "Lcom/ss/android/lark/optrace/extension/TracingExtension;", "clientDurationTagStart", "tagKey", "clientDurationTagEnd", "startKey", "clientDuration", "getRequestId", "setRequestId", "requestid", "clientDurationEndAll", "linkTracing", "T", "", "Lcom/ss/android/lark/optrace/api/ITracing;", "context", "callback", "Lcom/ss/android/lark/optrace/api/ITracingLink$TracingLinkCallback;", "(Lcom/ss/android/lark/optrace/api/ITracing;Ljava/lang/Object;Lcom/ss/android/lark/optrace/api/ITracingLink$TracingLinkCallback;)V", "i", "tag", "msg", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "w", "e", "d", "generateSpan", "subTrace", "bizName", "flush", "monitor", "Lcom/ss/android/lark/opmonitor/service/OPMonitor;", "log", "finish", "reportMonitor", "Companion", "opmonitor_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class OPTrace extends fyb.a implements TracingCoreSpan {
    public static final int BATCH_CODE = 10000;
    public static final String BATCH_DATA_KEY = "batch";
    public static final String BATCH_DOMAIN = "monitor.base.batch";
    public static final String BATCH_EVENT_NAME = "monitor_batch_report";
    public static final int BATCH_MAX_NUM = 50;
    public static final String BATCH_MSG = "batch_monitor";
    public static final a Companion = null;
    public static final String TAG = "OPTrace";
    public static final OPMonitorCode a = null;

    @SerializedName("batchEnabled")
    @Expose
    private boolean batchEnabled;
    private boolean finished;

    @SerializedName("trace")
    @Expose
    private TracingCoreSpan mBase;

    @SerializedName("monitorCache")
    @Expose
    private List<String> monitors;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static boolean a(String r4) {
            if (r4 != null) goto L4;
        L20:
            boolean r5 = false;
        L22:
            return !r5;
        L4:
            if (cyb.b.b != null) goto L14;
            int r0 = iyb.a.a;
            Intrinsics.checkNotNullParameter("op_api_report_config", "configKey");
            Log.i("MinaConfig", "getBatchConfigList config: ");
            if (TextUtils.isEmpty("") == true) goto L12;
            cyb.b.b = (List) OPTraceGSONParser.a.fromJson("", new cyb.a().getType());     // Catch: Exception -> L9
        L9:
            e = move-exception;
            Log.e("MinaConfig", e);
        L12:
            if (cyb.b.b != null) goto L14;
            cyb.b.b = new ArrayList();
        L14:
            List<String> r1 = cyb.b.b;
            if (r1 == null) goto L17;
            Boolean r6 = Boolean.valueOf(r1.contains(r4));
        L18:
            if (r6 == null) goto L20;
            r5 = r6.booleanValue();
            goto L22
        L17:
            r6 = null;
            goto L18
        }
    }

    @JvmStatic
    public static final boolean checkApiReportEnabled(String r1) {
        Companion.getClass();
        return a.a(r1);
    }

    static {
        Companion = new a();
        a = new OPMonitorCode(BATCH_DOMAIN, BATCH_CODE, OPMonitorLevel.NORMAL, BATCH_MSG);
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, com.ss.android.lark.optrace.api.ITracing
    public void clientDurationEndAll() {
        this.mBase.clientDurationEndAll();
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, com.ss.android.lark.optrace.api.ITracing
    public long createTime() {
        return this.mBase.createTime();
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan
    @Deprecated(message = "use subTrace")
    public TracingCoreSpan generateSpan() {
        return new OPTrace(this.mBase.generateSpan());
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, com.ss.android.lark.optrace.api.ITracing
    public String getRequestId() {
        return this.mBase.getRequestId();
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, com.ss.android.lark.optrace.api.ITracing
    public String getTracingID() {
        return this.mBase.getTracingID();
    }

    public final String serialize() {
        Gson r0 = OPTraceGSONParser.a;
        return GsonProtectorUtils.toJson(OPTraceGSONParser.a, this);
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan
    public OPTrace subTrace() {
        OPTrace r0 = new OPTrace(this.mBase.subTrace());
        r0.batchEnabled = this.batchEnabled;
        return r0;
    }

    public OPTrace() {
        this.monitors = new ArrayList();
        this.mBase = new TracingSpanImpl(null);
    }

    public static final /* synthetic */ OPMonitorCode access$getBATCH_MONITOR_CODE$cp() {
        return a;
    }

    public final boolean getBatchEnabled() {
        return this.batchEnabled;
    }

    public final boolean getFinished() {
        return this.finished;
    }

    public final List<String> getMonitors() {
        return this.monitors;
    }

    public final TracingCoreSpan getTracingSpanImpl() {
        return this.mBase;
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan
    public /* bridge */ /* synthetic */ TracingCoreSpan subTrace() {
        return subTrace();
    }

    public OPTrace(String r2) {
        Intrinsics.checkNotNullParameter(r2, "traceId");
        this.monitors = new ArrayList();
        this.mBase = new TracingSpanImpl(r2);
    }

    @JvmStatic
    public static final boolean checkBizBatchEnabled(String r1) {
        Companion.getClass();
        return !cyb.b.a().d(r1);
    }

    @JvmStatic
    public static final OPTrace deserialize(String r2) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r2, "data");
        Type r0 = new com.ss.android.lark.opmonitor.trace.a().getType();
        return (OPTrace) GsonProtectorUtils.fromJson(OPTraceGSONParser.a, r2, r0);
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, com.ss.android.lark.optrace.api.ITracing
    public long clientDuration(String r3) {
        return this.mBase.clientDuration(r3);
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, com.ss.android.lark.optrace.api.ITracing
    public long clientDurationTagEnd(String r3) {
        return this.mBase.clientDurationTagEnd(r3);
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, com.ss.android.lark.optrace.api.ITracing
    public void clientDurationTagStart(String r2) {
        this.mBase.clientDurationTagStart(r2);
    }

    public final synchronized void finish(OPMonitor r4) {
        monitor-enter(this);
        Trace.beginSection("computeOPTraceFinish");     // Catch: Throwable -> L24
        if (cyb.b.a().c() == true) goto L10;
        Trace.endSection();     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L10:
        if (this.finished == false) goto L12;
    L21:
        Log.e(TAG, "is already finished or monitors is empty!,finished:" + this.finished + ",size:" + this.monitors.size());     // Catch: Throwable -> L24
        Trace.endSection();     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L12:
        if (this.monitors.isEmpty() == true) goto L21;
        Trace.beginSection("computeOPTraceFlush");     // Catch: Throwable -> L24
        if (r4 == null) goto L17;
        Gson r1 = OPTraceGSONParser.a;     // Catch: Throwable -> L24
        r4.addCategoryValue(BATCH_DATA_KEY, GsonProtectorUtils.toJson(OPTraceGSONParser.a, this.monitors)).tracing(getTracingID()).flush();     // Catch: Throwable -> L24
    L18:
        Trace.endSection();     // Catch: Throwable -> L24
        this.finished = true;     // Catch: Throwable -> L24
        this.monitors.clear();     // Catch: Throwable -> L24
        Trace.endSection();     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L17:
        OPMonitor r5 = new OPMonitor(BATCH_EVENT_NAME, a);     // Catch: Throwable -> L24
        Gson r2 = OPTraceGSONParser.a;     // Catch: Throwable -> L24
        r5.addCategoryValue(BATCH_DATA_KEY, GsonProtectorUtils.toJson(OPTraceGSONParser.a, this.monitors)).tracing(getTracingID()).flush();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    @Override // byb.e
    public synchronized void flush(OPMonitor r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "monitor");     // Catch: Throwable -> L14
        if (cyb.b.a().a(r5) == false) goto L12;
        Trace.beginSection("computeSerializeOPMonitor");     // Catch: Throwable -> L14
        if (this.monitors.size() <= 50) goto L11;
        Log.w(TAG, "batch monitor execeed max nums:" + getTracingID());     // Catch: Throwable -> L14
        this.monitors.clear();     // Catch: Throwable -> L14
        this.batchEnabled = false;     // Catch: Throwable -> L14
        Trace.endSection();     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L11:
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L14
        r0.put(AppbrandHostConstants.Schema_Meta.NAME, r5.getName());     // Catch: Throwable -> L14
        r0.put("metrics", new JSONObject(r5.getMetrics()));     // Catch: Throwable -> L14
        r0.put("categories", new JSONObject(r5.getCategories()));     // Catch: Throwable -> L14
        this.monitors.add(r0.toString());     // Catch: Throwable -> L14
        Trace.endSection();     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // byb.e
    public void log(OPMonitor r3) {
        Intrinsics.checkNotNullParameter(r3, "monitor");
        boolean r0 = cyb.b.a().c();
        if (cyb.b.a().b() == false) goto L9;
        if (r0 == true) goto L6;
    L7:
        log(r3, e.b.a);
        return;
    L6:
        if (cyb.b.a().a(r3) == false) goto L7;
        return;
    }

    public final void setBatchEnabled(boolean r1) {
        this.batchEnabled = r1;
    }

    public final void setFinished(boolean r1) {
        this.finished = r1;
    }

    public final void setMonitors(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.monitors = r2;
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, com.ss.android.lark.optrace.api.ITracing
    public void setRequestId(String r2) {
        this.mBase.setRequestId(r2);
    }

    public final OPTrace subTrace(String r4) {
        Intrinsics.checkNotNullParameter(r4, "bizName");
        OPTrace r0 = subTrace();
        Companion.getClass();
        boolean r1 = !cyb.b.a().d(r4);
        r0.batchEnabled = r1;
        if (r1 == false) goto L5;
        r0.batchEnabled = a.a(r4);
        Log.i(TAG, "batch monitor subTrace apiName: " + r4 + ", batchEnabled: " + r0.batchEnabled);
    L5:
        return r0;
    }

    public OPTrace(TracingCoreSpan r2) {
        Intrinsics.checkNotNullParameter(r2, "tracingCoreSpan");
        this.monitors = new ArrayList();
        this.mBase = r2;
    }

    @JvmStatic
    public static final OPTrace deserialize(String r2, String r3) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r2, "traceId");
        OPTrace r0 = new OPTrace(r2);
        r0.setBatchEnabled(!cyb.b.a().d(r3));
        if (r0.getBatchEnabled() == false) goto L5;
        r0.setBatchEnabled(a.a(r3));
        Log.i(TAG, "batch monitor deserialize apiName: " + r3 + ", batchEnabled: " + r0.getBatchEnabled());
    L5:
        return r0;
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, com.ss.android.lark.optrace.api.ITracing
    public void addExtension(TracingExtensionEnum r2, TracingExtension r3) {
        this.mBase.addExtension(r2, r3);
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, hyb.a
    public void d(String r3, Object... r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "msg");
        this.mBase.d(r3, Arrays.copyOf(r4, r4.length));
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, hyb.a
    public void e(String r3, Object... r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "msg");
        this.mBase.e(r3, Arrays.copyOf(r4, r4.length));
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, hyb.a
    public void i(String r3, Object... r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "msg");
        this.mBase.i(r3, Arrays.copyOf(r4, r4.length));
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan, hyb.a
    public void w(String r3, Object... r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "msg");
        this.mBase.w(r3, Arrays.copyOf(r4, r4.length));
    }

    @Override // com.ss.android.lark.optrace.api.TracingCoreSpan
    public <T> void linkTracing(ITracing r2, T r3, hyb.b<T> r4) {
        if ((r2 instanceof OPTrace) == false) goto L5;
        this.mBase.linkTracing(((OPTrace) r2).mBase, r3, r4);
        return;
    L5:
        this.mBase.linkTracing(r2, r3, r4);
    }
}
