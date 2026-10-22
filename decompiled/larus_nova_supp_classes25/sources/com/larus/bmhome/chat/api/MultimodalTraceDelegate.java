package com.larus.bmhome.chat.api;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J/\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J/\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0096\u0001¨\u0006\u0011"}, d2 = {"Lcom/larus/bmhome/chat/api/MultimodalTraceDelegate;", "Lcom/larus/bmhome/chat/api/IMultimodalTraceService;", "<init>", "()V", "onLoadVideoFail", "", "fileIdentifier", "", "msgID", "errorMsg", "videoParam", "enterMethod", "onLoadVideoSuccess", "onProcessStart", "localSendMsgId", "cvsId", "scene", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class MultimodalTraceDelegate implements IMultimodalTraceService {
    public static final MultimodalTraceDelegate b = null;
    public final /* synthetic */ IMultimodalTraceService a;

    static {
        b = new MultimodalTraceDelegate();
    }

    @Override // com.larus.bmhome.chat.api.IMultimodalTraceService
    public final void a(String r8, String r9, String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r8, "fileIdentifier");
        this.a.a(r8, r9, r10, r11, r12);
    }

    @Override // com.larus.bmhome.chat.api.IMultimodalTraceService
    public final void b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "fileIdentifier");
        this.a.b(r2, r3);
    }

    @Override // com.larus.bmhome.chat.api.IMultimodalTraceService
    public final void c(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "fileIdentifier");
        this.a.c(r2, r3, r4, r5);
    }

    private MultimodalTraceDelegate() {
        IMultimodalTraceService r0 = (IMultimodalTraceService) ServiceManager.get().getService(IMultimodalTraceService.class);
        if (r0 != null) goto L5;
        r0 = new MultimodalTraceServiceNoop();
    L5:
        this.a = r0;
    }
}
