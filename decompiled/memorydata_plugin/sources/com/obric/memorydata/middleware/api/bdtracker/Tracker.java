package com.obric.memorydata.middleware.api.bdtracker;

import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0001J\u0019\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096\u0001J\u0019\u0010\u0010\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u000fH\u0096\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u000fH\u0096\u0001J%\u0010\u0014\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00160\u0015H\u0096\u0001J\t\u0010\u0017\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/middleware/api/bdtracker/Tracker;", "Lcom/obric/memorydata/middleware/api/bdtracker/ITracker;", "<init>", "()V", "registerDailyReportCallback", "", "callback", "Lcom/obric/memorydata/middleware/api/bdtracker/DailyReportCallback;", "registerReportEventRejectedHandler", "event", "", "handler", "Lcom/obric/memorydata/middleware/api/bdtracker/ReportEventRejectedHandler;", "reportDevEvent", "data", "Lorg/json/JSONObject;", "reportEvent", TrackerImpl.PARAMS, "reportEventAccepted", "", "reportWithSystemId", "", "", "startDailyReport", "unregisterDailyReportCallback", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Tracker implements ITracker {
    public static final Tracker INSTANCE = null;
    private final /* synthetic */ ITracker $$delegate_0;

    static {
        INSTANCE = new Tracker();
    }

    private Tracker() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(ITracker.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (ITracker) ZeusTransformUtils.preCheckCast(r0, ITracker.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.bdtracker.ITracker
    public void registerDailyReportCallback(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.$$delegate_0.registerDailyReportCallback(r4);
    }

    @Override // com.obric.memorydata.middleware.api.bdtracker.ITracker
    public void registerReportEventRejectedHandler(String r3, b r4) {
        b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r5, "handler");
        this.$$delegate_0.registerReportEventRejectedHandler(r3, r5);
    }

    @Override // com.obric.memorydata.middleware.api.bdtracker.ITracker
    public void reportDevEvent(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r3, "data");
        this.$$delegate_0.reportDevEvent(r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.bdtracker.ITracker
    public void reportEvent(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r3, TrackerImpl.PARAMS);
        this.$$delegate_0.reportEvent(r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.bdtracker.ITracker
    public boolean reportEventAccepted(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r3, TrackerImpl.PARAMS);
        return this.$$delegate_0.reportEventAccepted(r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.bdtracker.ITracker
    public void reportWithSystemId(String r3, Map<String, ? extends Object> r4) {
        Map<String, ? extends Object> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r5, "data");
        this.$$delegate_0.reportWithSystemId(r3, r5);
    }

    @Override // com.obric.memorydata.middleware.api.bdtracker.ITracker
    public void startDailyReport() {
        this.$$delegate_0.startDailyReport();
    }

    @Override // com.obric.memorydata.middleware.api.bdtracker.ITracker
    public void unregisterDailyReportCallback(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.$$delegate_0.unregisterDailyReportCallback(r4);
    }
}
