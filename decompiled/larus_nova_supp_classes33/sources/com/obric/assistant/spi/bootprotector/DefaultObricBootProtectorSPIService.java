package com.obric.assistant.spi.bootprotector;

import com.larus.bootprotector.activity.BootProtectorLandingActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/spi/bootprotector/DefaultObricBootProtectorSPIService;", "Lcom/obric/assistant/spi/bootprotector/IObricBootProtectorSPIService;", "<init>", "()V", "isObricHandler", "", "prefetchLatestAppApkUrl", "", "tryStartDownloadLatestApk", "context", "Landroid/content/Context;", "downloadButtonText", "", "dialogMessage", "startNetworkRetry", "stopNetworkRetry", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultObricBootProtectorSPIService implements IObricBootProtectorSPIService {
    public DefaultObricBootProtectorSPIService() {
    }

    @Override // com.obric.assistant.spi.bootprotector.IObricBootProtectorSPIService
    public final void a() {
    }

    @Override // com.obric.assistant.spi.bootprotector.IObricBootProtectorSPIService
    public final boolean b() {
        return false;
    }

    @Override // com.obric.assistant.spi.bootprotector.IObricBootProtectorSPIService
    public final void c() {
    }

    @Override // com.obric.assistant.spi.bootprotector.IObricBootProtectorSPIService
    public final String d() {
        return null;
    }

    @Override // com.obric.assistant.spi.bootprotector.IObricBootProtectorSPIService
    public final String e() {
        return null;
    }

    @Override // com.obric.assistant.spi.bootprotector.IObricBootProtectorSPIService
    public final boolean f(BootProtectorLandingActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return false;
    }

    @Override // com.obric.assistant.spi.bootprotector.IObricBootProtectorSPIService
    public final void g() {
    }
}
