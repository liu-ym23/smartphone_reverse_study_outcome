package com.larus.uaigc.service;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/larus/uaigc/service/ICreationAiEditServiceNoop;", "Lcom/larus/uaigc/service/ICreationAiEditService;", "<init>", "()V", "getCreationAiEditParams", "Lcom/larus/uaigc/bean/chat/gallery/CreationAiEditParams;", "aiEditContext", "Lcom/larus/uaigc/bean/chat/gallery/AiEditFeatureContext;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ICreationAiEditServiceNoop implements ICreationAiEditService {
    public ICreationAiEditServiceNoop() {
    }

    @Override // com.larus.uaigc.service.ICreationAiEditService
    public final jy9.e a(jy9.a r9) {
        Intrinsics.checkNotNullParameter(r9, "aiEditContext");
        return new jy9.e(null, null, null, null, null, 63);
    }
}
