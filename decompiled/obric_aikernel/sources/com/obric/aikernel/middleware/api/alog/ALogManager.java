package com.obric.aikernel.middleware.api.alog;

import com.bytedance.news.common.service.manager.IService;
import d4.a;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes2.dex */
public final class ALogManager implements IALogManager {
    public static final ALogManager INSTANCE = null;
    private final /* synthetic */ IALogManager $$delegate_0;

    static {
        INSTANCE = new ALogManager();
    }

    private ALogManager() {
        IService r10 = a.a(Reflection.getOrCreateKotlinClass(IALogManager.class));
        Intrinsics.checkNotNull(r10);
        this.$$delegate_0 = (IALogManager) r10;
    }

    @Override // com.obric.aikernel.middleware.api.alog.IALogManager
    public List<String> getALogFiles(long r10, long r11) {
        return this.$$delegate_0.getALogFiles(r10, r11);
    }

    @Override // com.obric.aikernel.middleware.api.alog.IALogManager
    public List<String> getLogFiles() {
        return this.$$delegate_0.getLogFiles();
    }

    @Override // com.obric.aikernel.middleware.api.alog.IALogManager
    public void init() {
        this.$$delegate_0.init();
    }

    @Override // com.obric.aikernel.middleware.api.alog.IALogManager
    public void setAlogConsumer() {
        this.$$delegate_0.setAlogConsumer();
    }
}
