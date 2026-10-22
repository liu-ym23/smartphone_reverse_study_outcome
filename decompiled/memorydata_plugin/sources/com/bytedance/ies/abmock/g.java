package com.bytedance.ies.abmock;

import androidx.core.app.NotificationCompat;
import com.bytedance.ies.abmock.datacenter.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J&\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00062\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\u001c\u0010\u0013\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ies/abmock/ProviderAdapter;", "Lcom/bytedance/ies/abmock/datacenter/Provider;", "()V", "exposeVids", "", "vidList", "", "forceEnglish", "", "getConfigMock", "Lcom/bytedance/ies/abmock/datacenter/mock/IConfigMock;", "getCurrentUid", "isErasePerformanceOptEnable", "isSupportMock", "onEvent", "eventName", "map", "", "restartApp", "traceGetValueByKey", "key", NotificationCompat.CATEGORY_MESSAGE, "useLibraConfig", "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class g implements k {
    public g() {
    }

    @Override // com.bytedance.ies.abmock.datacenter.k
    public void a(String r1) {
    }

    @Override // com.bytedance.ies.abmock.datacenter.k
    public void a(String r2, Map<String, String> r3) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "eventName");
    }

    @Override // com.bytedance.ies.abmock.datacenter.k
    public boolean a() {
        return false;
    }

    @Override // com.bytedance.ies.abmock.datacenter.k
    public com.bytedance.ies.abmock.datacenter.a.a b() {
        return null;
    }

    @Override // com.bytedance.ies.abmock.datacenter.k
    public String c() {
        return "";
    }

    @Override // com.bytedance.ies.abmock.datacenter.k
    public boolean d() {
        return false;
    }
}
