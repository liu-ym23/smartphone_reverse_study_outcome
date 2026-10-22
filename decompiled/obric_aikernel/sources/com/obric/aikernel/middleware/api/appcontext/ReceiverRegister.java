package com.obric.aikernel.middleware.api.appcontext;

import com.bytedance.news.common.service.manager.IService;
import d4.a;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes2.dex */
public final class ReceiverRegister implements IReceiverRegister {
    public static final ReceiverRegister INSTANCE = null;
    private final /* synthetic */ IReceiverRegister $$delegate_0;

    static {
        INSTANCE = new ReceiverRegister();
    }

    private ReceiverRegister() {
        IService r10 = a.a(Reflection.getOrCreateKotlinClass(IReceiverRegister.class));
        Intrinsics.checkNotNull(r10);
        this.$$delegate_0 = (IReceiverRegister) r10;
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IReceiverRegister
    public void init() {
        this.$$delegate_0.init();
    }
}
