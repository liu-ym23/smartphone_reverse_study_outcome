package com.obric.assistant.dora;

import com.obric.assistant.spi.dora.IObricVendorPrivateLinkService;
import com.obric.assistant.wakeup.co_wakeup.dora.CoWakeupApi;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/dora/VendorPrivateLinkServiceImpl;", "Lcom/obric/assistant/spi/dora/IObricVendorPrivateLinkService;", "<init>", "()V", "TAG", "", "ioScope", "Lkotlinx/coroutines/CoroutineScope;", "isVendorDevice", "Ljava/util/concurrent/atomic/AtomicBoolean;", "refreshDeviceAsync", "", "needActivePrivateLink", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VendorPrivateLinkServiceImpl implements IObricVendorPrivateLinkService {
    public final String a;
    public final CoroutineScope b;
    public final AtomicBoolean c;

    @Override // com.obric.assistant.spi.dora.IObricVendorPrivateLinkService
    public final void b() {
        BuildersKt.launch$default(this.b, null, null, new VendorPrivateLinkServiceImpl$refreshDeviceAsync$1(this, null), 3, null);
    }

    public VendorPrivateLinkServiceImpl() {
        this.a = "VendorPrivateLinkService";
        this.b = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.c = new AtomicBoolean(false);
    }

    @Override // com.obric.assistant.spi.dora.IObricVendorPrivateLinkService
    public final boolean a() {
        CoWakeupApi r0 = uha.a.a();
        if (r0 == null) goto L7;
        boolean r2 = true;
        if (r0.b() != true) goto L7;
    L8:
        if (r2 == false) goto L11;
        return false;
    L11:
        return this.c.get();
    L7:
        r2 = false;
        goto L8
    }
}
