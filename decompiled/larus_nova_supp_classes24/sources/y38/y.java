package y38;

import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.larus.account.saas.jsb.core.FlowAccountUnbindCore;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class y implements x38.g<FlowAccountUnbindCore.a> {
    public final /* synthetic */ CompletionBlock<x.b> a;

    public y(CompletionBlock<x.b> r1) {
        this.a = r1;
    }

    @Override // x38.g
    public final void a(x38.a r8) {
        Intrinsics.checkNotNullParameter(r8, "error");
        CompletionBlock<x.b> r1 = this.a;
        String r9 = r8.b;
        if (r9 != null) goto L5;
        r9 = "";
    L5:
        CompletionBlock.DefaultImpls.onFailure$default(r1, -3, r9, null, 4, null);
    }

    @Override // x38.g
    public final void onSuccess(FlowAccountUnbindCore.a r5) {
        FlowAccountUnbindCore.a r6 = r5;
        Intrinsics.checkNotNullParameter(r6, "data");
        CompletionBlock<x.b> r0 = this.a;
        x.b r1 = ne7.e.b(x.b.class);
        x.b r2 = r1;
        r2.setSuccess(r6.a);
        r2.setErrorCode(r6.b);
        r2.setErrorMessage(r6.c);
        CompletionBlock.DefaultImpls.onSuccess$default(r0, r1, null, 2, null);
    }
}
