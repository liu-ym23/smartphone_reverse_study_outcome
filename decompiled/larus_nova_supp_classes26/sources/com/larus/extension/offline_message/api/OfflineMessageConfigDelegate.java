package com.larus.extension.offline_message.api;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\t\u0010\b\u001a\u00020\tH\u0096\u0001J\t\u0010\n\u001a\u00020\tH\u0096\u0001¨\u0006\u000b"}, d2 = {"Lcom/larus/extension/offline_message/api/OfflineMessageConfigDelegate;", "Lcom/larus/extension/offline_message/api/IOfflineMessageConfig;", "<init>", "()V", "bizCode", "", "enabled", "", "getLatestMessageTimeout", "", "saveLocalMessageTimeout", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfflineMessageConfigDelegate implements IOfflineMessageConfig {
    public static final OfflineMessageConfigDelegate b = null;
    public final /* synthetic */ IOfflineMessageConfig a;

    static {
        b = new OfflineMessageConfigDelegate();
    }

    @Override // com.larus.extension.offline_message.api.IOfflineMessageConfig
    public final boolean enabled() {
        return this.a.enabled();
    }

    private OfflineMessageConfigDelegate() {
        IOfflineMessageConfig r0 = (IOfflineMessageConfig) ServiceManager.get().getService(IOfflineMessageConfig.class);
        if (r0 != null) goto L5;
        r0 = new OfflineMessageConfigNoop();
    L5:
        this.a = r0;
    }
}
