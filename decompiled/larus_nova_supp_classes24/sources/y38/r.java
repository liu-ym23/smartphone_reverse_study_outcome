package y38;

import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeResultModelArguments;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class r implements x38.g<Unit> {
    public final /* synthetic */ CompletionBlock<rc7.b.b> a;

    public r(CompletionBlock<rc7.b.b> r1) {
        this.a = r1;
    }

    @Override // x38.g
    public final void a(x38.a r8) {
        Intrinsics.checkNotNullParameter(r8, "error");
        CompletionBlock<rc7.b.b> r1 = this.a;
        String r9 = r8.b;
        if (r9 != null) goto L5;
        r9 = "";
    L5:
        CompletionBlock.DefaultImpls.onFailure$default(r1, 0, r9, null, 4, null);
    }

    @Override // x38.g
    public final void onSuccess(Unit r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        CompletionBlock.DefaultImpls.onSuccess$default(this.a, XBridgeResultModelArguments.INSTANCE.createModel(rc7.b.b.class), null, 2, null);
    }
}
