package com.larus.receive.contract;

import android.content.Context;
import android.content.Intent;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016¨\u0006\u000f"}, d2 = {"Lcom/larus/receive/contract/DefaultReceiveCustomDiffImpl;", "Lcom/larus/receive/contract/IReceiveCustomDiff;", "<init>", "()V", "getName", "", "onIntercept", "", "intent", "Landroid/content/Intent;", "handle", "", "context", "Landroid/content/Context;", "currentPage", "receive_contract_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class DefaultReceiveCustomDiffImpl implements IReceiveCustomDiff {
    public DefaultReceiveCustomDiffImpl() {
    }

    @Override // com.larus.receive.contract.IReceiveCustomDiff
    public final void a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter("landing", "currentPage");
    }

    @Override // com.larus.receive.contract.IReceiveCustomDiff
    public final boolean b(Intent r2) {
        Intrinsics.checkNotNullParameter(r2, "intent");
        return false;
    }

    @Override // com.larus.receive.contract.IReceiveCustomDiff
    public final String getName() {
        return "";
    }
}
