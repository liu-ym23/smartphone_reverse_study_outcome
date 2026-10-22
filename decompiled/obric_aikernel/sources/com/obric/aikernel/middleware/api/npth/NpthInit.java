package com.obric.aikernel.middleware.api.npth;

import com.bytedance.news.common.service.manager.IService;
import d4.a;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes2.dex */
public final class NpthInit implements INpthInit {
    public static final NpthInit INSTANCE = null;
    private final /* synthetic */ INpthInit $$delegate_0;

    static {
        INSTANCE = new NpthInit();
    }

    private NpthInit() {
        IService r10 = a.a(Reflection.getOrCreateKotlinClass(INpthInit.class));
        Intrinsics.checkNotNull(r10);
        this.$$delegate_0 = (INpthInit) r10;
    }

    @Override // com.obric.aikernel.middleware.api.npth.INpthInit
    public void init() {
        this.$$delegate_0.init();
    }
}
