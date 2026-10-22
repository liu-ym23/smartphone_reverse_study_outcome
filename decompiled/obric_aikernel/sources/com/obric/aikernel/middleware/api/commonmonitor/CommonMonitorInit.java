package com.obric.aikernel.middleware.api.commonmonitor;

import com.bytedance.news.common.service.manager.IService;
import d4.a;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes2.dex */
public final class CommonMonitorInit implements ICommonMonitorInit {
    private final /* synthetic */ ICommonMonitorInit $$delegate_0;

    public CommonMonitorInit() {
        IService r10 = a.a(Reflection.getOrCreateKotlinClass(ICommonMonitorInit.class));
        Intrinsics.checkNotNull(r10);
        this.$$delegate_0 = (ICommonMonitorInit) r10;
    }

    @Override // com.obric.aikernel.middleware.api.commonmonitor.ICommonMonitorInit
    public void initApm() {
        this.$$delegate_0.initApm();
    }
}
