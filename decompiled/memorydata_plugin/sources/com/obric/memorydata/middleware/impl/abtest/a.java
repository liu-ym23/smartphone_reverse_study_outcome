package com.obric.memorydata.middleware.impl.abtest;

import com.bytedance.applog.AppLog;
import com.bytedance.ies.abmock.g;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J&\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00072\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/middleware/impl/abtest/ABMockProviderAdapter;", "Lcom/bytedance/ies/abmock/ProviderAdapter;", "<init>", "()V", "exposeVids", "", "vidList", "", "getCurrentUid", "useLibraConfig", "", "onEvent", "eventName", "map", "", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a extends g {
    public a() {
    }

    @Override // com.bytedance.ies.abmock.g, com.bytedance.ies.abmock.datacenter.k
    public void a(String r2) {
        b.f11675a.a().update(AbVersionSource.ABMOCK, r2);
    }

    @Override // com.bytedance.ies.abmock.g, com.bytedance.ies.abmock.datacenter.k
    public void a(String r2, Map<String, String> r3) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "eventName");
        if (r1 != null) goto L5;
        r1 = MapsKt.emptyMap();
    L5:
        AppLog.onEventV3(r2, new JSONObject(r1));
    }

    @Override // com.bytedance.ies.abmock.g, com.bytedance.ies.abmock.datacenter.k
    public String c() {
        return UserSettings.INSTANCE.getUserId();
    }
}
