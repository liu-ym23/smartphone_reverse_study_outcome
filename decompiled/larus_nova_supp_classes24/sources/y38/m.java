package y38;

import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class m implements x38.g<Unit> {
    public final /* synthetic */ CompletionBlock<l.b> a;

    public m(CompletionBlock<l.b> r1) {
        this.a = r1;
    }

    @Override // x38.g
    public final void a(x38.a r6) {
        Intrinsics.checkNotNullParameter(r6, "error");
        CompletionBlock<l.b> r0 = this.a;
        String r1 = r6.b;
        if (r1 != null) goto L5;
        r1 = "Network Error";
    L5:
        l.b r2 = ne7.e.b(l.b.class);
        l.b r3 = r2;
        r3.setXErrorCode(Integer.valueOf(r6.a));
        r3.setXErrorMessage(r6.b);
        Unit r7 = Unit.INSTANCE;
        r0.onFailure(0, r1, r2);
    }

    @Override // x38.g
    public final void onSuccess(Unit r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        CompletionBlock.DefaultImpls.onSuccess$default(this.a, ne7.e.b(l.b.class), null, 2, null);
    }
}
