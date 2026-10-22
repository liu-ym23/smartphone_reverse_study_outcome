package com.larus.receive.contract;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001¨\u0006\b"}, d2 = {"Lcom/larus/receive/contract/ReceiveTextDiffContract;", "Lcom/larus/receive/contract/IReceiveTextDiff;", "<init>", "()V", "resolveTextShare", "Lcom/larus/receive/contract/ReceiveTextDecision;", "request", "Lcom/larus/receive/contract/ReceiveTextRequest;", "receive_contract_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ReceiveTextDiffContract implements IReceiveTextDiff {
    public static final ReceiveTextDiffContract b = null;
    public final /* synthetic */ IReceiveTextDiff a;

    static {
        b = new ReceiveTextDiffContract();
    }

    @Override // com.larus.receive.contract.IReceiveTextDiff
    public final a a(ps9.a r2) {
        Intrinsics.checkNotNullParameter(r2, "request");
        return this.a.a(r2);
    }

    private ReceiveTextDiffContract() {
        IReceiveTextDiff r0 = (IReceiveTextDiff) ServiceManager.get().getService(IReceiveTextDiff.class);
        if (r0 != null) goto L5;
        r0 = new DefaultReceiveTextDiffImpl();
    L5:
        this.a = r0;
    }
}
