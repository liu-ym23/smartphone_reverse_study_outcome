package com.larus.bmhome.larkinput.api.host;

import com.bytedance.creativex.mediaimport.preview.internal.main.g;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oq8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0096\u0001J\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0001¨\u0006\u000f"}, d2 = {"Lcom/larus/bmhome/larkinput/api/host/LarkInputHostService;", "Lcom/larus/bmhome/larkinput/api/host/ILarkInputHostService;", "<init>", "()V", "createSpans", "", "", "token", "Lcom/larus/bmhome/larkinput/api/model/InlineToken;", "openPicker", "", "request", "Lcom/larus/bmhome/larkinput/api/model/InlineTokenRequest;", "callback", "Lcom/larus/bmhome/larkinput/api/host/ILarkInputTokenCallback;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LarkInputHostService implements ILarkInputHostService {
    public static final LarkInputHostService b = null;
    public final /* synthetic */ ILarkInputHostService a;

    static {
        b = new LarkInputHostService();
    }

    @Override // com.larus.bmhome.larkinput.api.host.ILarkInputHostService
    public final void a(a r2, g r3) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.a.a(r2, r3);
    }

    private LarkInputHostService() {
        ILarkInputHostService r0 = (ILarkInputHostService) ServiceManager.get().getService(ILarkInputHostService.class);
        if (r0 != null) goto L5;
        r0 = new LarkInputHostServiceNoop();
    L5:
        this.a = r0;
    }
}
