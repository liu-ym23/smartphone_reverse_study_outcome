package yu0;

import com.bytedance.live.datacontext.m;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public static final void a(com.bytedance.android.live.revenue.common.reactive.c r1, m r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$forwardTo");
        Intrinsics.checkNotNullParameter(r2, "target");
        Disposable r3 = r1.a(new d(r2));
        r2.a().doOnComplete(new c(r3));
    }
}
