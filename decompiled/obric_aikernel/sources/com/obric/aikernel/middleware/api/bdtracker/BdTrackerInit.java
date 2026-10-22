package com.obric.aikernel.middleware.api.bdtracker;

import com.bytedance.news.common.service.manager.IService;
import d4.a;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes2.dex */
public final class BdTrackerInit implements IBdTrackerInit {
    private final /* synthetic */ IBdTrackerInit $$delegate_0;

    public BdTrackerInit() {
        IService r10 = a.a(Reflection.getOrCreateKotlinClass(IBdTrackerInit.class));
        Intrinsics.checkNotNull(r10);
        this.$$delegate_0 = (IBdTrackerInit) r10;
    }

    @Override // com.obric.aikernel.middleware.api.bdtracker.IBdTrackerInit
    public void init() {
        this.$$delegate_0.init();
    }
}
