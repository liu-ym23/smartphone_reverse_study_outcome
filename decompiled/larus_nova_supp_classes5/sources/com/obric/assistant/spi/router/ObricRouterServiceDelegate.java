package com.obric.assistant.spi.router;

import android.net.Uri;
import android.os.Bundle;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\u001b\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0001¨\u0006\r"}, d2 = {"Lcom/obric/assistant/spi/router/ObricRouterServiceDelegate;", "Lcom/obric/assistant/spi/router/IObricRouterService;", "<init>", "()V", "addAllRouterInterceptor", "", "deeplinkQueryDisabled", "putDeeplinkQueryParams", "", "bundle", "Landroid/os/Bundle;", "uri", "Landroid/net/Uri;", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricRouterServiceDelegate implements IObricRouterService {
    public static final ObricRouterServiceDelegate b = null;
    public final /* synthetic */ IObricRouterService a;

    static {
        b = new ObricRouterServiceDelegate();
    }

    public final boolean a() {
        return this.a.a();
    }

    public final void b(Bundle r2, Uri r3) {
        Intrinsics.checkNotNullParameter(r2, "bundle");
        this.a.b(r2, r3);
    }

    public final boolean c() {
        return this.a.c();
    }

    private ObricRouterServiceDelegate() {
        DefaultRouterServiceImpl r0 = (IObricRouterService) ServiceManager.get().getService(IObricRouterService.class);
        if (r0 != null) goto L5;
        r0 = new DefaultRouterServiceImpl();
    L5:
        this.a = r0;
    }
}
