package y38;

import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.larus.account.saas.jsb.core.FlowAccountCommonAlertCore;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b implements x38.g<FlowAccountCommonAlertCore.b> {
    public final /* synthetic */ CompletionBlock<a.b> a;

    public b(CompletionBlock<a.b> r1) {
        this.a = r1;
    }

    @Override // x38.g
    public final void a(x38.a r15) {
        Intrinsics.checkNotNullParameter(r15, "error");
        if (r15.a != FlowAccountCommonAlertCore.Error.CANCELLED.getCode()) goto L5;
        CompletionBlock.DefaultImpls.onFailure$default(this.a, -7, null, null, 6, null);
        return;
    L5:
        CompletionBlock<a.b> r8 = this.a;
        String r16 = r15.b;
        if (r16 != null) goto L8;
        r16 = "";
    L8:
        CompletionBlock.DefaultImpls.onFailure$default(r8, 0, r16, null, 4, null);
    }

    @Override // x38.g
    public final void onSuccess(FlowAccountCommonAlertCore.b r5) {
        FlowAccountCommonAlertCore.b r6 = r5;
        Intrinsics.checkNotNullParameter(r6, "data");
        CompletionBlock<a.b> r0 = this.a;
        a.b r1 = ne7.e.b(a.b.class);
        a.b r2 = r1;
        r2.setId(r6.a);
        r2.setTitle(r6.b);
        r2.setStyle(r6.c);
        CompletionBlock.DefaultImpls.onSuccess$default(r0, r1, null, 2, null);
    }
}
