package com.obric.assistant.spi.dora;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0007H\u0096\u0001¨\u0006\b"}, d2 = {"Lcom/obric/assistant/spi/dora/VendorPrivateLinkDelegate;", "Lcom/obric/assistant/spi/dora/IObricVendorPrivateLinkService;", "<init>", "()V", "needActivePrivateLink", "", "refreshDeviceAsync", "", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VendorPrivateLinkDelegate implements IObricVendorPrivateLinkService {
    public static final VendorPrivateLinkDelegate b = null;
    public final /* synthetic */ IObricVendorPrivateLinkService a;

    static {
        b = new VendorPrivateLinkDelegate();
    }

    @Override // com.obric.assistant.spi.dora.IObricVendorPrivateLinkService
    public final boolean a() {
        return this.a.a();
    }

    @Override // com.obric.assistant.spi.dora.IObricVendorPrivateLinkService
    public final void b() {
        this.a.b();
    }

    private VendorPrivateLinkDelegate() {
        IObricVendorPrivateLinkService r0 = (IObricVendorPrivateLinkService) ServiceManager.get().getService(IObricVendorPrivateLinkService.class);
        if (r0 != null) goto L5;
        r0 = new DefaultVendorPrivateLinkServiceImpl();
    L5:
        this.a = r0;
    }
}
