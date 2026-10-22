package com.larus.receive.contract;

import android.content.Context;
import android.content.Intent;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0001¨\u0006\u000f"}, d2 = {"Lcom/larus/receive/contract/ReceiveCustomDiffContract;", "Lcom/larus/receive/contract/IReceiveCustomDiff;", "<init>", "()V", "getName", "", "handle", "", "context", "Landroid/content/Context;", "currentPage", "onIntercept", "", "intent", "Landroid/content/Intent;", "receive_contract_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ReceiveCustomDiffContract implements IReceiveCustomDiff {
    public static final ReceiveCustomDiffContract b = null;
    public final /* synthetic */ IReceiveCustomDiff a;

    static {
        b = new ReceiveCustomDiffContract();
    }

    @Override // com.larus.receive.contract.IReceiveCustomDiff
    public final void a(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter("landing", "currentPage");
        this.a.a(r3);
    }

    @Override // com.larus.receive.contract.IReceiveCustomDiff
    public final boolean b(Intent r2) {
        Intrinsics.checkNotNullParameter(r2, "intent");
        return this.a.b(r2);
    }

    @Override // com.larus.receive.contract.IReceiveCustomDiff
    public final String getName() {
        return this.a.getName();
    }

    private ReceiveCustomDiffContract() {
        IReceiveCustomDiff r0 = (IReceiveCustomDiff) ServiceManager.get().getService(IReceiveCustomDiff.class);
        if (r0 != null) goto L5;
        r0 = new DefaultReceiveCustomDiffImpl();
    L5:
        this.a = r0;
    }
}
