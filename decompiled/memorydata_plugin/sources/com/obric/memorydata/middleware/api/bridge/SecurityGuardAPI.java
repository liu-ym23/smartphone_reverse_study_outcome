package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/middleware/api/bridge/SecurityGuardAPI;", "Lcom/obric/memorydata/middleware/api/bridge/ISecurityGuardAPI;", "<init>", "()V", "contentReviewByNLP", "", Params.CONTENT, "", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SecurityGuardAPI implements ISecurityGuardAPI {
    public static final SecurityGuardAPI INSTANCE = null;
    private final /* synthetic */ ISecurityGuardAPI $$delegate_0;

    static {
        INSTANCE = new SecurityGuardAPI();
    }

    private SecurityGuardAPI() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(ISecurityGuardAPI.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (ISecurityGuardAPI) ZeusTransformUtils.preCheckCast(r0, ISecurityGuardAPI.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ISecurityGuardAPI
    public boolean contentReviewByNLP(String r2) {
        Intrinsics.checkNotNullParameter(r2, Params.CONTENT);
        return this.$$delegate_0.contentReviewByNLP(r2);
    }
}
