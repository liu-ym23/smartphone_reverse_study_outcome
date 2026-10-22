package com.obric.assistant.spi.share;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0007\u001a\u00020\bH\u0096\u0001¨\u0006\t"}, d2 = {"Lcom/obric/assistant/spi/share/ShareKeyConfigDelegate;", "Lcom/obric/assistant/spi/share/IShareKeyConfigService;", "<init>", "()V", "getKey", "", "channel", "isAvailable", "", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareKeyConfigDelegate implements IShareKeyConfigService {
    public static final ShareKeyConfigDelegate b = null;
    public final /* synthetic */ IShareKeyConfigService a;

    static {
        b = new ShareKeyConfigDelegate();
    }

    @Override // com.obric.assistant.spi.share.IShareKeyConfigService
    public final String a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "channel");
        return this.a.a(r2);
    }

    private ShareKeyConfigDelegate() {
        IShareKeyConfigService r0 = (IShareKeyConfigService) ServiceManager.get().getService(IShareKeyConfigService.class);
        if (r0 != null) goto L5;
        r0 = new DefaultShareKeyConfigService();
    L5:
        this.a = r0;
    }
}
