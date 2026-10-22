package com.obric.aikernel.middleware.api.obric;

import android.content.Context;
import com.bytedance.news.common.service.manager.IService;
import d4.a;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes2.dex */
public final class ProcessService implements IProcessService {
    public static final ProcessService INSTANCE = null;
    private final /* synthetic */ IProcessService $$delegate_0;

    static {
        INSTANCE = new ProcessService();
    }

    private ProcessService() {
        IService r10 = a.a(Reflection.getOrCreateKotlinClass(IProcessService.class));
        Intrinsics.checkNotNull(r10);
        this.$$delegate_0 = (IProcessService) r10;
    }

    @Override // com.obric.aikernel.middleware.api.obric.IProcessService
    public void destroy() {
        this.$$delegate_0.destroy();
    }

    @Override // com.obric.aikernel.middleware.api.obric.IProcessService
    public void init(Context r10) {
        this.$$delegate_0.init(r10);
    }
}
