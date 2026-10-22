package com.obric.aikernel.middleware.api.account;

import com.bytedance.news.common.service.manager.IService;
import d4.a;
import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes2.dex */
public final class OAccountInitManager implements IOAccountManager {
    public static final OAccountInitManager INSTANCE = null;
    private final /* synthetic */ IOAccountManager $$delegate_0;

    static {
        INSTANCE = new OAccountInitManager();
    }

    private OAccountInitManager() {
        IService r10 = a.a(Reflection.getOrCreateKotlinClass(IOAccountManager.class));
        Intrinsics.checkNotNull(r10);
        this.$$delegate_0 = (IOAccountManager) r10;
    }

    @Override // com.obric.aikernel.middleware.api.account.IOAccountManager
    public ArrayList<String> addTokenHost() {
        return this.$$delegate_0.addTokenHost();
    }

    @Override // com.obric.aikernel.middleware.api.account.IOAccountManager
    public void init() {
        this.$$delegate_0.init();
    }

    @Override // com.obric.aikernel.middleware.api.account.IOAccountManager
    public Map<String, String> xttTokenMap() {
        return this.$$delegate_0.xttTokenMap();
    }
}
