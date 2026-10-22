package com.obric.aikernel.middleware.api.teaagent;

import com.bytedance.news.common.service.manager.IService;
import d4.a;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes2.dex */
public final class TeaAgentManager implements ITeaAgentManager {
    public static final TeaAgentManager INSTANCE = null;
    private final /* synthetic */ ITeaAgentManager $$delegate_0;

    static {
        INSTANCE = new TeaAgentManager();
    }

    private TeaAgentManager() {
        IService r10 = a.a(Reflection.getOrCreateKotlinClass(ITeaAgentManager.class));
        Intrinsics.checkNotNull(r10);
        this.$$delegate_0 = (ITeaAgentManager) r10;
    }

    @Override // com.obric.aikernel.middleware.api.teaagent.ITeaAgentManager
    public String getForegroundApp() {
        return this.$$delegate_0.getForegroundApp();
    }

    @Override // com.obric.aikernel.middleware.api.teaagent.ITeaAgentManager
    public void init() {
        this.$$delegate_0.init();
    }

    @Override // com.obric.aikernel.middleware.api.teaagent.ITeaAgentManager
    public boolean isForegroundApp(String r10) {
        Intrinsics.checkNotNullParameter(r10, "packageName");
        return this.$$delegate_0.isForegroundApp(r10);
    }
}
