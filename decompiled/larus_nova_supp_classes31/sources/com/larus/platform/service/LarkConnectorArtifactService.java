package com.larus.platform.service;

import android.content.Context;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.ArtifactBlock;
import com.larus.platform.api.ILarkConnectorArtifactService;
import com.tencent.open.log.TraceLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\"\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J$\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/larus/platform/service/LarkConnectorArtifactService;", "Lcom/larus/platform/api/ILarkConnectorArtifactService;", "<init>", "()V", "service", "getService", "()Lcom/larus/platform/api/ILarkConnectorArtifactService;", "service$delegate", "Lkotlin/Lazy;", "isLarkConnectorArtifact", "", "message", "Lcom/larus/im/bean/message/Message;", "tryOpenUrl", "context", "Landroid/content/Context;", "url", "", "tryOpen", "artifactBlock", "Lcom/larus/im/bean/message/block/ArtifactBlock;", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class LarkConnectorArtifactService implements ILarkConnectorArtifactService {
    public static final LarkConnectorArtifactService a = null;
    public static final Lazy b = null;

    private LarkConnectorArtifactService() {
    }

    static {
        a = new LarkConnectorArtifactService();
        b = LazyKt.lazy(new f1());
    }

    @Override // com.larus.platform.api.ILarkConnectorArtifactService
    public final boolean c(Message r2) {
        ILarkConnectorArtifactService r0 = (ILarkConnectorArtifactService) b.getValue();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.c(r2) != true) goto L7;
        return true;
    }

    @Override // com.larus.platform.api.ILarkConnectorArtifactService
    public final boolean a(Context r2, Message r3, ArtifactBlock r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        ILarkConnectorArtifactService r0 = (ILarkConnectorArtifactService) b.getValue();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.a(r2, r3, r4) != true) goto L7;
        return true;
    }

    @Override // com.larus.platform.api.ILarkConnectorArtifactService
    public final boolean b(Context r2, Message r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "url");
        ILarkConnectorArtifactService r0 = (ILarkConnectorArtifactService) b.getValue();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.b(r2, r3, r4) != true) goto L7;
        return true;
    }
}
