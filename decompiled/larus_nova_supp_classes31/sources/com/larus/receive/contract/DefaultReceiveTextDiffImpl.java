package com.larus.receive.contract;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/larus/receive/contract/DefaultReceiveTextDiffImpl;", "Lcom/larus/receive/contract/IReceiveTextDiff;", "<init>", "()V", "resolveTextShare", "Lcom/larus/receive/contract/ReceiveTextDecision;", "request", "Lcom/larus/receive/contract/ReceiveTextRequest;", "receive_contract_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class DefaultReceiveTextDiffImpl implements IReceiveTextDiff {
    public DefaultReceiveTextDiffImpl() {
    }

    @Override // com.larus.receive.contract.IReceiveTextDiff
    public final a a(ps9.a r6) {
        Intrinsics.checkNotNullParameter(r6, "request");
        if (Intrinsics.areEqual(r6.a, "android.intent.action.SEND") == false) goto L16;
        String r0 = r6.b;
        boolean r1 = false;
        if (r0 != null) goto L7;
    L9:
        if (r1 == false) goto L16;
        if (r6.c == false) goto L16;
        return new a.C0019a(ReceiveTextDelivery.AUTO_SEND);
    L7:
        if (StringsKt.startsWith$default(r0, "text/", false, 2, null) != true) goto L9;
        r1 = true;
    L16:
        return a.b.a;
    }
}
