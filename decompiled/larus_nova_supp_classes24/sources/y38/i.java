package y38;

import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class i implements x38.g<Unit> {
    public final /* synthetic */ CompletionBlock<h.b> a;

    public i(CompletionBlock<h.b> r1) {
        this.a = r1;
    }

    @Override // x38.g
    public final void a(x38.a r8) {
        Intrinsics.checkNotNullParameter(r8, "error");
        CompletionBlock<h.b> r1 = this.a;
        String r9 = r8.b;
        if (r9 != null) goto L5;
        r9 = "";
    L5:
        CompletionBlock.DefaultImpls.onFailure$default(r1, 0, r9, null, 4, null);
    }

    @Override // x38.g
    public final void onSuccess(Unit r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        CompletionBlock.DefaultImpls.onSuccess$default(this.a, ne7.e.b(h.b.class), null, 2, null);
    }
}
