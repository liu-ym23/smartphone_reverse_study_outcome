package com.larus.bmhome.larkinput.api.service;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oq8.b;
import pq8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/larkinput/api/service/LarkInputService;", "Lcom/larus/bmhome/larkinput/api/service/ILarkInputService;", "<init>", "()V", "createController", "Lcom/larus/bmhome/larkinput/api/service/ILarkInputController;", "config", "Lcom/larus/bmhome/larkinput/api/model/InlineTriggerConfig;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LarkInputService implements ILarkInputService {
    public static final LarkInputService b = null;
    public final /* synthetic */ ILarkInputService a;

    static {
        b = new LarkInputService();
    }

    @Override // com.larus.bmhome.larkinput.api.service.ILarkInputService
    public final a a(b r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        return this.a.a(r2);
    }

    private LarkInputService() {
        ILarkInputService r0 = (ILarkInputService) ServiceManager.get().getService(ILarkInputService.class);
        if (r0 != null) goto L5;
        r0 = new LarkInputServiceNoop();
    L5:
        this.a = r0;
    }
}
