package com.obric.assistant.spi.update;

import com.larus.home.impl.t;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vga.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J$\u0010\r\u001a\u00020\n2\u001a\u0010\u000e\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00100\u000fH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/obric/assistant/spi/update/ObricUpdateSPIServiceDelegate;", "Lcom/obric/assistant/spi/update/IObricUpdateSPIService;", "<init>", "()V", "delegate", "getDelegate", "()Lcom/obric/assistant/spi/update/IObricUpdateSPIService;", "delegate$delegate", "Lkotlin/Lazy;", "checkUpdate", "", "auto", "", "setRequestTagHeaderProvider", "provider", "Lkotlin/Function0;", "Landroid/util/Pair;", "", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricUpdateSPIServiceDelegate implements IObricUpdateSPIService {
    public static final ObricUpdateSPIServiceDelegate a = null;
    public static final Lazy b = null;

    private ObricUpdateSPIServiceDelegate() {
    }

    static {
        a = new ObricUpdateSPIServiceDelegate();
        b = LazyKt.lazy(new a());
    }

    @Override // com.obric.assistant.spi.update.IObricUpdateSPIService
    public final void a() {
        IObricUpdateSPIService r0 = (IObricUpdateSPIService) b.getValue();
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    @Override // com.obric.assistant.spi.update.IObricUpdateSPIService
    public final void b(t r2) {
        Intrinsics.checkNotNullParameter(r2, "provider");
        IObricUpdateSPIService r0 = (IObricUpdateSPIService) b.getValue();
        if (r0 == null) goto L6;
        r0.b(r2);
        return;
    }
}
