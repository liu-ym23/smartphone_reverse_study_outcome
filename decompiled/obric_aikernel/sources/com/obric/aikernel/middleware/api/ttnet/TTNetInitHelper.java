package com.obric.aikernel.middleware.api.ttnet;

import com.bytedance.news.common.service.manager.IService;
import d4.a;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes2.dex */
public final class TTNetInitHelper implements ITTNetInitHelper {
    private final /* synthetic */ ITTNetInitHelper $$delegate_0;

    public TTNetInitHelper() {
        IService r10 = a.a(Reflection.getOrCreateKotlinClass(ITTNetInitHelper.class));
        Intrinsics.checkNotNull(r10);
        this.$$delegate_0 = (ITTNetInitHelper) r10;
    }

    @Override // com.obric.aikernel.middleware.api.ttnet.ITTNetInitHelper
    public void initTTNet() {
        this.$$delegate_0.initTTNet();
    }
}
