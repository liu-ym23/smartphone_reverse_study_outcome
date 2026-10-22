package com.obric.aikernel.middleware.api.service;

import com.bytedance.news.common.service.manager.IService;
import d4.a;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes2.dex */
public final class AIInferRuntime implements IAIInferRuntime {
    public static final AIInferRuntime INSTANCE = null;
    private final /* synthetic */ IAIInferRuntime $$delegate_0;

    static {
        INSTANCE = new AIInferRuntime();
    }

    private AIInferRuntime() {
        IService r10 = a.a(Reflection.getOrCreateKotlinClass(IAIInferRuntime.class));
        Intrinsics.checkNotNull(r10);
        this.$$delegate_0 = (IAIInferRuntime) r10;
    }

    @Override // com.obric.aikernel.middleware.api.service.IAIInferRuntime
    public void init() {
        this.$$delegate_0.init();
    }
}
