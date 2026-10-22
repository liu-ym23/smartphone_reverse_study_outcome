package com.obric.assistant.spi.push;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096\u0001¨\u0006\b"}, d2 = {"Lcom/obric/assistant/spi/push/ObricPushConfigServiceDelegate;", "Lcom/obric/assistant/spi/push/IObricPushConfigService;", "<init>", "()V", "savePushToken", "", "token", "", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricPushConfigServiceDelegate implements IObricPushConfigService {
    public static final ObricPushConfigServiceDelegate b = null;
    public final /* synthetic */ IObricPushConfigService a;

    static {
        b = new ObricPushConfigServiceDelegate();
    }

    public final void a(String r2) {
        this.a.a(r2);
    }

    private ObricPushConfigServiceDelegate() {
        DefaultObricPushConfigServiceImpl r0 = (IObricPushConfigService) ServiceManager.get().getService(IObricPushConfigService.class);
        if (r0 != null) goto L5;
        r0 = new DefaultObricPushConfigServiceImpl();
    L5:
        this.a = r0;
    }
}
