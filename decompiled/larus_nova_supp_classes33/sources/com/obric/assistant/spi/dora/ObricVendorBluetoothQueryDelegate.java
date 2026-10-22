package com.obric.assistant.spi.dora;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import lga.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0096\u0001¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/spi/dora/ObricVendorBluetoothQueryDelegate;", "Lcom/obric/assistant/spi/dora/IObricVendorBluetoothQueryService;", "<init>", "()V", "queryVendorBluetoothSppStatus", "Lcom/obric/assistant/spi/dora/VendorBluetoothSppStatus;", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricVendorBluetoothQueryDelegate implements IObricVendorBluetoothQueryService {
    public static final ObricVendorBluetoothQueryDelegate b = null;
    public final /* synthetic */ IObricVendorBluetoothQueryService a;

    static {
        b = new ObricVendorBluetoothQueryDelegate();
    }

    @Override // com.obric.assistant.spi.dora.IObricVendorBluetoothQueryService
    public final a a() {
        return this.a.a();
    }

    private ObricVendorBluetoothQueryDelegate() {
        IObricVendorBluetoothQueryService r0 = (IObricVendorBluetoothQueryService) ServiceManager.get().getService(IObricVendorBluetoothQueryService.class);
        if (r0 != null) goto L5;
        r0 = new DefaultObricVendorBluetoothQueryServiceImpl();
    L5:
        this.a = r0;
    }
}
