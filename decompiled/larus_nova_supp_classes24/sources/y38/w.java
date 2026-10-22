package y38;

import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class w implements x38.g<Unit> {
    public final /* synthetic */ CompletionBlock<v.b> a;

    public w(CompletionBlock<v.b> r1) {
        this.a = r1;
    }

    @Override // x38.g
    public final void a(x38.a r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        CompletionBlock<v.b> r0 = this.a;
        String r5 = r4.b;
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        r0.onFailure(-3, r5, ne7.e.b(v.b.class));
    }

    @Override // x38.g
    public final void onSuccess(Unit r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        CompletionBlock.DefaultImpls.onSuccess$default(this.a, ne7.e.b(v.b.class), null, 2, null);
    }
}
