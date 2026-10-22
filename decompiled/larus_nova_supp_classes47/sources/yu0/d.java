package yu0;

import com.bytedance.android.live.revenue.common.reactive.f;
import com.bytedance.live.datacontext.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d<T> implements f {
    public final /* synthetic */ m a;

    public d(m r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.revenue.common.reactive.f
    public final void a(T r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        this.a.setValue(r2);
    }
}
