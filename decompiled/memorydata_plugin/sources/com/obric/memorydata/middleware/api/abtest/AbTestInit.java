package com.obric.memorydata.middleware.api.abtest;

import android.content.Context;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0096\u0001¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/middleware/api/abtest/AbTestInit;", "Lcom/obric/memorydata/middleware/api/abtest/IAbTestInit;", "<init>", "()V", "initialize", "", "registerPluginConfig", "pluginContext", "Landroid/content/Context;", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AbTestInit implements IAbTestInit {
    public static final AbTestInit INSTANCE = null;
    private final /* synthetic */ IAbTestInit $$delegate_0;

    static {
        INSTANCE = new AbTestInit();
    }

    private AbTestInit() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IAbTestInit.class));
        if (r0 == null) goto L7;
        this.$$delegate_0 = (IAbTestInit) ZeusTransformUtils.preCheckCast(r0, IAbTestInit.class, "com.obric.memorydata.plugin");
        return;
    L7:
        throw new IllegalStateException("Required value was null.".toString());
    }

    @Override // com.obric.memorydata.middleware.api.abtest.IAbTestInit
    public void initialize() {
        this.$$delegate_0.initialize();
    }

    @Override // com.obric.memorydata.middleware.api.abtest.IAbTestInit
    public void registerPluginConfig(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "pluginContext");
        this.$$delegate_0.registerPluginConfig(r4);
    }
}
