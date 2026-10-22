package com.obric.aiagent.product;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.aiagent.product.platform.api.IPlatformService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u0005J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u000f"}, d2 = {"Lcom/obric/aiagent/product/ObricProductSdk;", "", "<init>", "()V", CommonConsts.APM_INNER_EVENT_COST_INIT, "", WsConstants.KEY_PLATFORM, "Lcom/obric/aiagent/platform/IAIAgentPlatform;", "isInited", "", "destroy", "platformService", "Lcom/obric/aiagent/product/platform/api/IPlatformService;", "featureService", "Lcom/obric/aiagent/product/feature/api/IFeatureService;", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f5974a = null;

    static {
        f5974a = new b();
    }

    private b() {
    }

    public final IPlatformService a() {
        return a.f5962a.a().platformService();
    }

    public final void a(com.obric.aiagent.platform.b r2) {
        com.obric.aiagent.platform.b r1 = (com.obric.aiagent.platform.b) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.aiagent.platform.b.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L5;
        com.obric.aiagent.platform.a.f5946a.a(r1);
    L5:
        a.f5962a.a().init();
    }

    public final com.obric.aiagent.product.feature.a.a b() {
        return a.f5962a.a().featureService();
    }
}
