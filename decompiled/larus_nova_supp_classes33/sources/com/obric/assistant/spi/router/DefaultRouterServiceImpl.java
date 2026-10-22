package com.obric.assistant.spi.router;

import android.net.Uri;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\r"}, d2 = {"Lcom/obric/assistant/spi/router/DefaultRouterServiceImpl;", "Lcom/obric/assistant/spi/router/IObricRouterService;", "<init>", "()V", "addAllRouterInterceptor", "", "deeplinkQueryDisabled", "putDeeplinkQueryParams", "", "bundle", "Landroid/os/Bundle;", "uri", "Landroid/net/Uri;", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultRouterServiceImpl implements IObricRouterService {
    public DefaultRouterServiceImpl() {
    }

    public final boolean a() {
        return false;
    }

    public final void b(Bundle r1, Uri r2) {
        Intrinsics.checkNotNullParameter(r1, "bundle");
    }

    public final boolean c() {
        return false;
    }
}
