package com.obric.aikernel.middleware.api.qcom;

import com.bytedance.news.common.service.manager.IService;
import d4.a;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes2.dex */
public final class QcomManager implements IQcomManager {
    public static final QcomManager INSTANCE = null;
    private final /* synthetic */ IQcomManager $$delegate_0;

    static {
        INSTANCE = new QcomManager();
    }

    private QcomManager() {
        IService r10 = a.a(Reflection.getOrCreateKotlinClass(IQcomManager.class));
        Intrinsics.checkNotNull(r10);
        this.$$delegate_0 = (IQcomManager) r10;
    }

    @Override // com.obric.aikernel.middleware.api.qcom.IQcomManager
    public boolean isIniting() {
        return this.$$delegate_0.isIniting();
    }

    @Override // com.obric.aikernel.middleware.api.qcom.IQcomManager
    public Object waitInit(Continuation<? super Unit> r10) {
        return this.$$delegate_0.waitInit(r10);
    }
}
