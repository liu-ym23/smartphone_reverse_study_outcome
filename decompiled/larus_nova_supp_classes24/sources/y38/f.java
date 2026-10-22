package y38;

import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeResultModelArguments;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f implements x38.g<Map<String, ? extends Object>> {
    public final /* synthetic */ CompletionBlock<rc7.a.b> a;

    public f(CompletionBlock<rc7.a.b> r1) {
        this.a = r1;
    }

    @Override // x38.g
    public final void a(x38.a r8) {
        Intrinsics.checkNotNullParameter(r8, "error");
        CompletionBlock<rc7.a.b> r1 = this.a;
        String r9 = r8.b;
        if (r9 != null) goto L5;
        r9 = "";
    L5:
        CompletionBlock.DefaultImpls.onFailure$default(r1, 0, r9, null, 4, null);
    }

    @Override // x38.g
    public final void onSuccess(Map<String, ? extends Object> r4) {
        Map<String, ? extends Object> r5 = r4;
        Intrinsics.checkNotNullParameter(r5, "data");
        rc7.a.b r0 = XBridgeResultModelArguments.INSTANCE.createModel(rc7.a.b.class);
        r0.setVerifyDecision(r5);
        CompletionBlock.DefaultImpls.onSuccess$default(this.a, r0, null, 2, null);
    }
}
