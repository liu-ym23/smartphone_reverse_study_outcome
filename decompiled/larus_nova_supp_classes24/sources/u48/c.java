package u48;

import com.larus.share.impl.view.k0;
import com.larus.share.service.IShareDoubaoForwardService;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c implements mpc.b {
    public final /* synthetic */ IShareDoubaoForwardService.a a;
    public final /* synthetic */ List<kw9.a> b;

    public final void onSuccess() {
        this.a.a((kw9.a) CollectionsKt.singleOrNull(this.b));
    }

    public c(k0 r1, List r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onFailure(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "errorMessage");
        this.a.onFailure(Integer.valueOf(r2), r3);
    }
}
