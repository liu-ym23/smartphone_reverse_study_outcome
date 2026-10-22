package com.larus.receive.api;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096\u0001J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096\u0001J\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\rH\u0096\u0001¨\u0006\u0011"}, d2 = {"Lcom/larus/receive/api/ReceiveIntentServiceDelegate;", "Lcom/larus/receive/api/IReceiveIntentService;", "<init>", "()V", "handle", "", "context", "Landroid/content/Context;", "currentPage", "", "isReceive", "", "intent", "Landroid/content/Intent;", "parseUris", "", "Landroid/net/Uri;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ReceiveIntentServiceDelegate implements IReceiveIntentService {
    public static final ReceiveIntentServiceDelegate b = null;
    public final /* synthetic */ IReceiveIntentService a;

    static {
        b = new ReceiveIntentServiceDelegate();
    }

    @Override // com.larus.receive.api.IReceiveIntentService
    public final void a(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter("landing", "currentPage");
        this.a.a(r3);
    }

    @Override // com.larus.receive.api.IReceiveIntentService
    public final boolean b(Intent r2) {
        Intrinsics.checkNotNullParameter(r2, "intent");
        return this.a.b(r2);
    }

    @Override // com.larus.receive.api.IReceiveIntentService
    public final List<Uri> c(Intent r2) {
        Intrinsics.checkNotNullParameter(r2, "intent");
        return this.a.c(r2);
    }

    private ReceiveIntentServiceDelegate() {
        Object r0 = ServiceManager.get().getService(IReceiveIntentService.class);
        Intrinsics.checkNotNull(r0);
        this.a = (IReceiveIntentService) r0;
    }
}
