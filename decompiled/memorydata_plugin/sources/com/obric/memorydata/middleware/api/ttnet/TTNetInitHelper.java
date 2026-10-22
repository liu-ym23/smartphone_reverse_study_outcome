package com.obric.memorydata.middleware.api.ttnet;

import android.app.Application;
import android.content.Context;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096\u0001¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/middleware/api/ttnet/TTNetInitHelper;", "Lcom/obric/memorydata/middleware/api/ttnet/ITTNetInitHelper;", "<init>", "()V", "initTTNet", "", "context", "Landroid/content/Context;", "application", "Landroid/app/Application;", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TTNetInitHelper implements ITTNetInitHelper {
    private final /* synthetic */ ITTNetInitHelper $$delegate_0;

    public TTNetInitHelper() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(ITTNetInitHelper.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (ITTNetInitHelper) ZeusTransformUtils.preCheckCast(r0, ITTNetInitHelper.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.ttnet.ITTNetInitHelper
    public void initTTNet(Context r3, Application r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Application r6 = (Application) ZeusTransformUtils.wrapperContextForParams(r4, Application.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "application");
        this.$$delegate_0.initTTNet(r5, r6);
    }
}
