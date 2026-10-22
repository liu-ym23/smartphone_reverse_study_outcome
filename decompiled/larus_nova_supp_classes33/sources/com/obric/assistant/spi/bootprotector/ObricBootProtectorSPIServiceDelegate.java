package com.obric.assistant.spi.bootprotector;

import com.larus.bootprotector.activity.BootProtectorLandingActivity;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J\t\u0010\u0007\u001a\u00020\bH\u0096\u0001J\t\u0010\t\u001a\u00020\nH\u0096\u0001J\t\u0010\u000b\u001a\u00020\nH\u0096\u0001J\t\u0010\f\u001a\u00020\nH\u0096\u0001J\u0011\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096\u0001¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/spi/bootprotector/ObricBootProtectorSPIServiceDelegate;", "Lcom/obric/assistant/spi/bootprotector/IObricBootProtectorSPIService;", "<init>", "()V", "dialogMessage", "", "downloadButtonText", "isObricHandler", "", "prefetchLatestAppApkUrl", "", "startNetworkRetry", "stopNetworkRetry", "tryStartDownloadLatestApk", "context", "Landroid/content/Context;", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricBootProtectorSPIServiceDelegate implements IObricBootProtectorSPIService {
    public static final ObricBootProtectorSPIServiceDelegate b = null;
    public final /* synthetic */ IObricBootProtectorSPIService a;

    static {
        b = new ObricBootProtectorSPIServiceDelegate();
    }

    @Override // com.obric.assistant.spi.bootprotector.IObricBootProtectorSPIService
    public final void a() {
        this.a.a();
    }

    @Override // com.obric.assistant.spi.bootprotector.IObricBootProtectorSPIService
    public final boolean b() {
        return this.a.b();
    }

    @Override // com.obric.assistant.spi.bootprotector.IObricBootProtectorSPIService
    public final void c() {
        this.a.c();
    }

    @Override // com.obric.assistant.spi.bootprotector.IObricBootProtectorSPIService
    public final String d() {
        return this.a.d();
    }

    @Override // com.obric.assistant.spi.bootprotector.IObricBootProtectorSPIService
    public final String e() {
        return this.a.e();
    }

    @Override // com.obric.assistant.spi.bootprotector.IObricBootProtectorSPIService
    public final boolean f(BootProtectorLandingActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return this.a.f(r2);
    }

    @Override // com.obric.assistant.spi.bootprotector.IObricBootProtectorSPIService
    public final void g() {
        this.a.g();
    }

    private ObricBootProtectorSPIServiceDelegate() {
        this.a = (IObricBootProtectorSPIService) ServiceManager.get().getService(IObricBootProtectorSPIService.class);
    }
}
