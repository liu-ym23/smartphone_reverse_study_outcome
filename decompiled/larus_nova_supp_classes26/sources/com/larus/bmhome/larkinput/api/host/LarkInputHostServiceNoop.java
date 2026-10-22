package com.larus.bmhome.larkinput.api.host;

import com.bytedance.creativex.mediaimport.preview.internal.main.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oq8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/larus/bmhome/larkinput/api/host/LarkInputHostServiceNoop;", "Lcom/larus/bmhome/larkinput/api/host/ILarkInputHostService;", "<init>", "()V", "openPicker", "", "request", "Lcom/larus/bmhome/larkinput/api/model/InlineTokenRequest;", "callback", "Lcom/larus/bmhome/larkinput/api/host/ILarkInputTokenCallback;", "createSpans", "", "", "token", "Lcom/larus/bmhome/larkinput/api/model/InlineToken;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LarkInputHostServiceNoop implements ILarkInputHostService {
    public LarkInputHostServiceNoop() {
    }

    @Override // com.larus.bmhome.larkinput.api.host.ILarkInputHostService
    public final void a(a r2, g r3) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "callback");
    }
}
