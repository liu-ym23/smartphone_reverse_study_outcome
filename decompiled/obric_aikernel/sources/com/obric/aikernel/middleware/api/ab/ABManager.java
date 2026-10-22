package com.obric.aikernel.middleware.api.ab;

import com.bytedance.news.common.service.manager.IService;
import d4.a;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes2.dex */
public final class ABManager implements IABManager {
    public static final ABManager INSTANCE = null;
    private final /* synthetic */ IABManager $$delegate_0;

    static {
        INSTANCE = new ABManager();
    }

    private ABManager() {
        IService r10 = a.a(Reflection.getOrCreateKotlinClass(IABManager.class));
        Intrinsics.checkNotNull(r10);
        this.$$delegate_0 = (IABManager) r10;
    }

    @Override // com.obric.aikernel.middleware.api.ab.IABManager
    public void init() {
        this.$$delegate_0.init();
    }
}
