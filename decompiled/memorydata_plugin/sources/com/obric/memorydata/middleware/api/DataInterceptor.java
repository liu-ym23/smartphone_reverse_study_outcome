package com.obric.memorydata.middleware.api;

import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0001¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/middleware/api/DataInterceptor;", "Lcom/obric/memorydata/middleware/api/IDataInterceptor;", "<init>", "()V", "interceptLog", "", LocationMonitorConst.TAG, "", "level", "", NotificationCompat.CATEGORY_MESSAGE, "interceptTracker", "eventName", "jsonObject", "Lorg/json/JSONObject;", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DataInterceptor implements IDataInterceptor {
    public static final DataInterceptor INSTANCE = null;
    private final /* synthetic */ IDataInterceptor $$delegate_0;

    static {
        INSTANCE = new DataInterceptor();
    }

    private DataInterceptor() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IDataInterceptor.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (IDataInterceptor) ZeusTransformUtils.preCheckCast(r0, IDataInterceptor.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.IDataInterceptor
    public boolean interceptLog(String r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r4, NotificationCompat.CATEGORY_MESSAGE);
        return this.$$delegate_0.interceptLog(r2, r3, r4);
    }

    @Override // com.obric.memorydata.middleware.api.IDataInterceptor
    public boolean interceptTracker(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "jsonObject");
        return this.$$delegate_0.interceptTracker(r2, r3);
    }
}
