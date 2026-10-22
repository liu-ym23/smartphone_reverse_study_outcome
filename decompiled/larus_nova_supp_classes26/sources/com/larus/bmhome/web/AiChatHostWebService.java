package com.larus.bmhome.web;

import android.os.Bundle;
import com.larus.platform.model.webview.AbsWebFragment;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zt8.a;
import zt8.b;
import zt8.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\nJ\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/larus/bmhome/web/AiChatHostWebService;", "Lcom/larus/bmhome/web/IAiChatHostWebService;", "<init>", "()V", "service", "getService", "()Lcom/larus/bmhome/web/IAiChatHostWebService;", "service$delegate", "Lkotlin/Lazy;", "isSupported", "", "getWebFragment", "Lcom/larus/platform/model/webview/AbsWebFragment;", "webViewScrollCallback", "Lcom/larus/bmhome/web/IWebViewProxyCallback;", "getWebFragmentArguments", "Landroid/os/Bundle;", "config", "Lcom/larus/bmhome/web/HostWebFragmentConfig;", "getUrlForCodePreview", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AiChatHostWebService implements IAiChatHostWebService {
    public static final AiChatHostWebService a = null;
    public static final Lazy b = null;

    private AiChatHostWebService() {
    }

    static {
        a = new AiChatHostWebService();
        b = LazyKt.lazy(new a());
    }

    @Override // com.larus.bmhome.web.IAiChatHostWebService
    public final String b() {
        IAiChatHostWebService r0 = (IAiChatHostWebService) b.getValue();
        if (r0 == null) goto L6;
        String r1 = r0.b();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // com.larus.bmhome.web.IAiChatHostWebService
    public final AbsWebFragment a(c r2) {
        IAiChatHostWebService r0 = (IAiChatHostWebService) b.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a(r2);
    }

    @Override // com.larus.bmhome.web.IAiChatHostWebService
    public final Bundle c(b r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        IAiChatHostWebService r0 = (IAiChatHostWebService) b.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c(r2);
    }
}
